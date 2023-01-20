#!/usr/bin/env bash

SERVER_LOG=mktemp
SERVER_WAIT_PATTERN="Started ServerApplication"
CLIENT_LOG=mktemp
CLIENT_WAIT_PATTERN="Started ClientApplication"
TIMEOUT=10

./gradlew clean server:bootRun > "$SERVER_LOG" &
./gradlew clean client:bootRun > "$CLIENT_LOG" &

if timeout "$TIMEOUT" tail -f "$SERVER_LOG" | grep -q "$SERVER_WAIT_PATTERN"; then
    echo "Server started"
else
    echo "Server failed to start"
    jobs -p | xargs kill
    exit 1
fi

if timeout "$TIMEOUT" tail -f "$CLIENT_LOG" | grep -q "$CLIENT_WAIT_PATTERN"; then
    echo "Client started"
else
    echo "Client failed to start"
    jobs -p | xargs kill
    exit 1
fi


jobs -p | xargs kill

# CEX: Protocol Buffers

## Prerequisites

* JDK 17 e.g. [Adoptium OpenJDK](https://adoptium.net/)

## Start

**Server**
    
```bash
./gradlew server:bootRun
```

**Client**
    
```bash
./gradlew client:bootRun
```

### Commands/Queries

**Protocol Buffers**

```bash
curl http://localhost:8081/protobuf/getOrders
curl -X POST http://localhost:8081/protobuf/createOrder
```

**JSON**

```bash
curl http://localhost:8081/json/getOrders
curl -X POST http://localhost:8081/json/createOrder
```

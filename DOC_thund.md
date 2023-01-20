# Add an optional field to the end

## Protocol Buffers

```protobuf
message OrderProtoDto {
  // [..]
  // ADDED
  string customer = 9;
}
```
Must be added to the static server order list to test the new field.

```java
var order = OrderProtoDto.newBuilder()
    // [..]
    .setCustomer("John Doe")
    .build();
```

- GetOrders works as before. unknown field is anonymously parsed 
- CreateOrder works

## JSON



# Remove an optional field from the end

## Protocol Buffers

## JSON

# Scalar to List of Scalars

## Protocol Buffers

## JSON

# Composite to list of composites

## Protocol Buffers

## JSON

# List of composite to composite

## Protocol Buffers

## JSON

# Add choice to existing union

## Protocol Buffers

## JSON

# Remove choice from existing union

## Protocol Buffers

## JSON

# Scalar to enumeration

## Protocol Buffers

## JSON

# Enumeration to scalar

## Protocol Buffers

## JSON

# Add enumeration constant

## Protocol Buffers

## JSON

# Remove enumeration constant

## Protocol Buffers

## JSON

# Increase integer width

## Protocol Buffers

## JSON

# Decrease integer width

## Protocol Buffers

## JSON

# Increase float precision

## Protocol Buffers

## JSON

# Decrease float precision

## Protocol Buffers

## JSON


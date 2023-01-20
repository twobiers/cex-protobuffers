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

## Schema Transformations

All schema transformations can be found in the [patches](./patches) directory. and applied
using `git apply`.

| Schema Transformation                 | Protobuf Patch                                                                                                                                                                             | JSON Patch                                                                                                                                                                              |
|---------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Structures**                        |                                                                                                                                                                                            |                                                                                                                                                                                         |
| Add an optional field to the end      | [1_proto_add_optional_field](./patches/1_proto_add_optional_field.patch<br/>)                                                                                                              | [1_json_add_optional_field](./patches/1_json_add_optional_field.patch)                                                                                                                  |
| Remove an optional field from the end | [2_proto_remove_optional_field](./patches/2_proto_remove_optional_field.patch)                                                                                                             | [2_json_remove_optional_field](./patches/2_json_remove_optional_field.patch)                                                                                                            |
| **Lists**                             |                                                                                                                                                                                            |                                                                                                                                                                                         |
| Scalar to List of Scalars             | [3_proto_scalar_to_list](./patches/3_proto_scalar_to_list.patch)                                                                                                                           | [3_json_scalar_to_list](./patches/3_json_scalar_to_list.patch)                                                                                                                          |
| Composite to list of composites       | [4_proto_composite_to_list](./patches/4_proto_composite_to_list.patch)                                                                                                                     | [4_json_composite_to_list](./patches/4_json_composite_to_list.patch)                                                                                                                    |
| List of composite to composite        | [5_proto_list_to_composite](./patches/5_proto_list_to_composite.patch)                                                                                                                     | [5_json_list_to_composite](./patches/5_json_list_to_composite.patch)                                                                                                                    |
| Add choice to existing union          | [6_proto_add_union](./patches/6_proto_add_union.patch)                                                                                                                                     | [6_json_add_union](./patches/6_json_add_union.patch)                                                                                                                                    |
| Remove choice from existing union     | [7_proto_remove_union](./patches/7_proto_remove_union.patch)                                                                                                                               | [7_json_remove_union](./patches/7_json_remove_union.patch)                                                                                                                              |
| **Enums**                             |                                                                                                                                                                                            |                                                                                                                                                                                         |
| Scalar to enumeration                 | [8_proto_scalar_to_enum](./patches/8_proto_scalar_to_enum.patch)                                                                                                                           | [8_json_scalar_to_enum](./patches/8_json_scalar_to_enum.patch)                                                                                                                          |
| Enumeration to scalar                 | [9_proto_enum_to_scalar](./patches/9_proto_enum_to_scalar.patch)                                                                                                                           | [9_json_enum_to_scalar](./patches/9_json_enum_to_scalar.patch)                                                                                                                          |
| Add enumeration constant              | [10_proto_add_enum_const](./patches/10_proto_add_enum_const.patch)                                                                                                                         | [10_json_add_enum_const](./patches/10_json_add_enum_const.patch)                                                                                                                        |
| Remove enumeration constant           | [11_proto_remve_enum_const](./patches/11_proto_remve_enum_const.patch)                                                                                                                     | [11_json_remve_enum_const](./patches/11_json_remve_enum_const.patch)                                                                                                                    |        
| **Type Conversion**                   |                                                                                                                                                                                            |                                                                                                                                                                                         |
| Increase integer width                | [12_proto_increase_integer_width](./patches/12_proto_increase_integer_width.patch)                                                                                                         | [12_json_increase_integer_width](./patches/12_json_increase_integer_width.patch)                                                                                                        |
| Decrease integer width                | [13_proto_decrease_integer_width](./patches/13_proto_decrease_integer_width.patch)                                                                                                         | [13_json_decrease_integer_width](./patches/13_json_decrease_integer_width.patch)                                                                                                        |
| Increase float precision              | [14_proto_increase_float_precision_1](./patches/14_proto_increase_float_precision_1.patch)<br/>[14_proto_increase_float_precision_2](./patches/14_proto_increase_float_precision_2.patch)  | [14_json_increase_float_precision_1](./patches/14_json_increase_float_precision_1.patch)  <br/>[14_json_increase_float_precision_2](./patches/14_json_increase_float_precision_2.patch) |
| Decrease float precision              | [15_proto_decrease_float_precision_1](./patches/15_proto_decrease_float_precision_1.patch)<br/> [15_proto_decrease_float_precision_2](./patches/15_proto_decrease_float_precision_2.patch) | [15_json_decrease_float_precision_1](./patches/15_json_decrease_float_precision_1.patch)<br/>[15_json_decrease_float_precision_2](./patches/15_json_decrease_float_precision_2.patch)   |

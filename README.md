### Hexlet tests and linter status:
[![Actions Status](https://github.com/Zenjo93/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Zenjo93/java-project-78/actions)
[![Java CI](https://github.com/Zenjo93/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Zenjo93/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/df17ecfe3ec1385a8f14/maintainability)](https://codeclimate.com/github/Zenjo93/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/df17ecfe3ec1385a8f14/test_coverage)](https://codeclimate.com/github/Zenjo93/java-project-78/test_coverage)


# Hexlet Project #3: "Data validator"
## Description
Data Validator is a library that allows you to check the correctness of any data. There are many similar libraries in every language, as almost all programs work with external data that needs to be checked for correctness. First of all, we are talking about data from forms filled out by users. The project is based on the yup library.

## Usage Example:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// strings
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with support for structure validation
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```

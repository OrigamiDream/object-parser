# object-parser
Simple java object(including primitive) parser set

# How to use
```java
T value = ReturnTypeParser.parseTo(T.class, /* object instance */);
```

For example,

```java
double d = ReturnTypeParser.parseTo(double.class, new BigDecimal("17.2735"));
```

You can see testcases at [here](https://github.com/OrigamiDream/object-parser/blob/master/src/test/java/avis/parser/test/ParsingTest.java)

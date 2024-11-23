Java8
    Lambda Expressions

    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    names.forEach(name -> System.out.println(name));

Stream API: Process collections declaratively

     List<String> filtered = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());

Default Methods: Allows interfaces to have default method implementations
    
    interface Vehicle {
        default void start() {
            System.out.println("Vehicle started");
            }
    }



Java 11: Continued innovation and modularization
new String Methods: Useful utility methods like isBlank, lines, strip
```
String str = "  hello  ";
System.out.println(str.strip()); // "hello"
System.out.println(str.isBlank()); // false

```

Local-Variable Syntax for Lambda Parameters:
```angular2html
var greet = (var name) -> "Hello, " + name;

```
HTTP Client (Standard): A modern API for HTTP requests
```angular2html
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://example.com"))
    .build();

```

Java 17: Stability and modernity
Sealed Classes: Restrict which classes can inherit from a parent class.
```angular2html
public sealed class Shape permits Circle, Square {}

```
Pattern Matching for Switch: Enhanced switch for pattern matching.
```angular2html
switch (obj) {
    case String s -> System.out.println("It's a string: " + s);
    case Integer i -> System.out.println("It's an integer: " + i);
    default -> System.out.println("Unknown type");
}

```
Text Blocks: Multi-line strings for better readability.
```angular2html
String json = """
    {
        "name": "Alice",
        "age": 30
    }
    """;

```
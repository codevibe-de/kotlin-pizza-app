# Pizza API in Kotlin

This project is a port of the Java Spring-Boot Pizza API project used in our Spring trainings.

The `main` branch is a **non-working set of basic classes** that need major work to become a well
working application.

## Tests

You can run the tests to get an idea of what is missing.

## Notes

- Since H2 is on the classpath Spring will start an internal in-memory database instance, for which
JPA will automatically create a schema
- Be aware of the SQL reserved word "order" when defining the `Order` JPA entity...

## Stuff to do

- make sure all required beans exist
- annotate JPA entities
- fill in business logic
- redesign the repository interfaces
- create REST endpoints
- complete given classes (e.g. `OrderRequest`), making sure you use Kotlin features 

## Links

- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.nullability.kotlin

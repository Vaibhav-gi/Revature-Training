**Java 17 \& Java 21 – Interview Questions WITH Answers**

**Sealed Classes (Java 17)**

Q1. What is a sealed class?

Answer:

A sealed class restricts which classes can extend it using the permits keyword. Only permitted subclasses are allowed.

Q2. Why were sealed classes introduced?

Answer:

To improve security, maintainability, and domain modeling by controlling class hierarchies.

Q3. What are sealed, final, and non-sealed?

Answer:

sealed → restricts subclasses

final → cannot be extended

non-sealed → allows unrestricted extension

Q4. Can interfaces be sealed?

Answer:

Yes, interfaces can also be sealed.

Q5. Give an example of a sealed class.

Answer:

sealed class Payment permits CardPayment, UpiPayment {}

final class CardPayment extends Payment {}

non-sealed class UpiPayment extends Payment {}

&nbsp;Pattern Matching (Java 17 / 21)

Q6. What is pattern matching?

Answer:

It simplifies type checks and casting using enhanced instanceof and switch.

Q7. How is pattern matching better than instanceof?

Answer:

It removes explicit casting and reduces boilerplate code.

Q8. Pattern matching instanceof example?

Answer:

if (obj instanceof String s) {

&nbsp; System.out.println(s.length());

}

Q9. What is pattern matching in switch?

Answer:

It allows matching types and values directly in switch expressions.

Q10. Is null supported in pattern matching switch?

Answer:

Yes, Java 21 supports explicit case null.

&nbsp;Text Blocks (Java 17)

Q11. What are text blocks?

Answer:

Multiline string literals using """ introduced to improve readability.

Q12. Where are text blocks commonly used?

Answer:

SQL queries, JSON, XML, HTML templates.

Q13. Text block example?

Answer:

String query = """

&nbsp; SELECT \* FROM employee

&nbsp; WHERE salary > ?

&nbsp; """;

&nbsp;Records (Java 17)

Q14. What is a record?

Answer:

A record is an immutable data carrier class that automatically generates boilerplate code.

Q15. Are records immutable?

Answer:

Yes, all fields are final.

Q16. Can records extend a class?

Answer:

No, records cannot extend classes but can implement interfaces.

Q17. Record example?

Answer:

public record Employee(int id, String name) {}

Q18. Difference between POJO and Record?

Answer:

Records auto-generate constructor, getters, equals, hashCode, and are immutable.

&nbsp;Virtual Threads (Java 21)

Q19. What are virtual threads?

Answer:

Lightweight threads managed by the JVM, not OS.

Q20. Difference between platform and virtual threads?

Answer:

Platform Thread Virtual Thread

OS managed JVM managed

Heavy Lightweight

Limited Millions supported

Q21. Best use case for virtual threads?

Answer:

I/O-bound tasks like JDBC, HTTP calls.

Q22. Can virtual threads replace ExecutorService?

Answer:

Yes, using Executors.newVirtualThreadPerTaskExecutor().

Q23. Virtual thread example?

Answer:

try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

&nbsp; executor.submit(() -> System.out.println("Hello"));

}

&nbsp;JDBC – Interview Questions WITH Answers

&nbsp;JDBC Architecture

Q24. What is JDBC?

Answer:

Java Database Connectivity is an API to connect Java applications with databases.

Q25. Explain JDBC architecture.

Answer:

Java App → JDBC API → DriverManager → JDBC Driver → Database

Q26. What is the role of DriverManager?

Answer:

It loads drivers and establishes database connections.

&nbsp;JDBC Interfaces

Q27. What is Connection?

Answer:

Represents an active database connection.

Q28. What is Statement?

Answer:

Used to execute static SQL queries.

Q29. What is PreparedStatement?

Answer:

Used to execute precompiled, parameterized SQL queries.

Q30. What is ResultSet?

Answer:

Stores the result returned from a SELECT query.

&nbsp;JDBC Driver Types

Q31. How many JDBC driver types exist?

Answer:

Four types.

Q32. Which driver is most commonly used?

Answer:

Type 4 (Thin Driver).

Q33. Why is Type 4 preferred?

Answer:

It is platform-independent, fast, and written entirely in Java.

&nbsp;Driver Registration

Q34. How is JDBC driver registered?

Answer:

Automatically using Service Provider mechanism or manually using Class.forName().

Q35. Is Class.forName() mandatory?

Answer:

No, since Java 6 it is optional.

&nbsp;JDBC Utility Class

Q36. Why use a JDBC utility class?

Answer:

To centralize connection logic and avoid code duplication.

Q37. Utility class example?

Answer:

public class DBUtil {

&nbsp; public static Connection getConnection() throws Exception {

&nbsp; return DriverManager.getConnection(

&nbsp; "jdbc:mysql://localhost:3306/test", "root", "root");

&nbsp; }

}

&nbsp;Statements vs PreparedStatement

Q38. Why is Statement not recommended?

Answer:

It is vulnerable to SQL Injection.

Q39. How does PreparedStatement prevent SQL Injection?

Answer:

By separating SQL logic from user input.

Q40. Simple Statement example?

Answer:

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("SELECT \* FROM employee");

Q41. PreparedStatement example?

Answer:

PreparedStatement ps =

&nbsp; con.prepareStatement("SELECT \* FROM employee WHERE id=?");

ps.setInt(1, 1);

ResultSet rs = ps.executeQuery();

&nbsp;Rapid Technical Round Questions

Q42. Are records thread-safe?

Answer:

Yes, because they are immutable.

Q43. Are virtual threads good for CPU-bound tasks?

Answer:

No, they are best for I/O-bound tasks.

Q44. Can sealed classes work with pattern matching?

Answer:

Yes, they work perfectly together.

Q45. Which Java version introduced records?

Answer:

Java 16 (standardized), widely used in Java 17.

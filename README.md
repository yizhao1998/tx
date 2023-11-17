# Test project for Spring Issue

Issue Link: https://github.com/spring-projects/spring-framework/issues/25977

Run this project: \
1. Create MySQL database, run sql in `tx/run.sql` to create test database and tables.
2. Open project with Intellij Idea, import the dependencies and launch application.
3. Execute `curl localhost:8080/testTx`
4. You will notice neither `print 1` or `print 2` is printed out, while at least one of them should be printed out follow logic in `com.spring.demo.tx.service.TxTestService.doSomeTx`.
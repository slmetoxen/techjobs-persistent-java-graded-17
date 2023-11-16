--Part 1
SQL TASK: At this point, you will have one table, job. In queries.sql under “Part 1”, list the columns and their data types in the table as a SQL comment.

CREATE TABLE job (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
name VARCHAR,
employer VARCHAR,
skills VARCHAR
);

--Part 2
SQL TASK: In queries.sql under “Part 2”, write a query to list the names of the employers in St. Louis City. Do NOT specify an ordering for the query results.
--Part 3

SQL TASK: In queries.sql under “Part 3”, write the SQL statement to remove the job table.
--Part 4

 SQL TASK: In queries.sql under “Part 4”, write a query to return the names of all skills that are attached to jobs in alphabetical order. If a skill does not have a job listed, it should not be included in the results of this query.
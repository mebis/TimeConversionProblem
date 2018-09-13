# TimeConversionProblem

Given a time in -hour AM/PM format, convert it to military (24-hour) time.

# Description

This project was written as a Spring Boot / Jersey Rest Application with Swagger documentation and built with Maven because it seemed fitting.

After you have started this application please use your browser and goto:

http://localhost:8001

There you will see the Swagger rest service front end with one GET call for the time conversion function.

# TESTS

Tests were written for cases provided in the problem description:

12:00:00AM becomes 00:00:00<br>
12:00:00PM becomes 12:00:00<br>
07:05:45PM becomes 19:05:45<br>

Error test cases were written also for bad hours, minutes, seconds and AM/PM.

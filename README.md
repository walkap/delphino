# Delphino java application

## Requirements
JVM, SDK 1.8
Postgres database
Postgres JDBC Driver

## Guide
1. First, you have to configure a file config.properties as you prefer and place it in the root's project.

2. Then you have to place a jdbc driver in a folder /lib under the root's project.

3. Now you are ready to go, with our application.

#### config.properties Example
  #Database configuration file
  
  USER = postgres
  
  PASSWORD = postgres
  
  DB_URL = jdbc:postgresql://localhost:5432/databasename
  
  DRIVER_CLASS_NAME = org.postgresql.Driver

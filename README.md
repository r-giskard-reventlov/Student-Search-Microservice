Student-Search-Microservice
===========================

A sample application to demonstrate the use of Dropwizard in the creation of a Microservice which allow a 
repository of students to be searched.

To build:
  mvn clean package

To run:
  From the top level directory:
    java -jar target/TemplateDropWizardProject-1.0-SNAPSHOT.jar server src/main/resources/org/rgiskardreventlov/sample-configuration.yaml

To test:
  Open a web browser:

    Search by surname:
      http://localhost:8080/student/name?surname=Smith

    Search by id:
      http://localhost:8080/student/id?id=1


  The following student's exist as test data:

   ---- ---------  --------
  | Id | Forename | Surname |
   ---- ---------- ---------
  | 1  | Justin   | Smith   |
  | 2  | Iain     | Smith   |
  | 3  | Hamish   | McDougal|
  | 4  | Tim      | Shanky  |
   ---- ---------- ---------
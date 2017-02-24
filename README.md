# ExamPrep-3_JPA1

##Q: Describe how you handled persistence in the last three semesters
First time I used any sort of persistence was to serialize objects, and save them into a file in the project folder. Later, we were introduced to mySQL and how to persist data onto a database. The data on our 2'nd semester was persisted with the JDBC-driver, and writing the mySQL statements through prepared statements, and then extracting the data from the received resultSet. One of the more recent thing that we have learned is the way that cookies work and how you can save data in them when using web projects.


##Q: Explain the Pros & Cons in using an ORM (Object Relational Mapping) framework
Pros:

      * ORM typically reduces the amount of code that needs to be written.
      * Avoids low level JDBC and SQL code.
      * Provides database and schema independence.
      * Allows to use the Object Oriented-paradigm.

Cons:

      * The high level of abstraction can obscure what is happening in the implementation code.
      * Heavy reliance on ORM software has been cited as a major factor in producing poorly designed databases.
      * Variety of difficulties that arise when considering how to match an object system to a relational database.
      * Annotations using JPA is hard to memorize.

##Q: Elaborate on some of the problems ORM tries to solve
Answered through the Pros and Cons above.

##Q: Explain the basic "components" involved when using Java JPA
Object data: Entity classes, POJO classes containing attributes and getter/setter methods etc. 

Mapping/Persistence: The persistence XML-file containing the persistence unit data which is used to make the connection to the database. This files has a list of the projects entity classes as well.

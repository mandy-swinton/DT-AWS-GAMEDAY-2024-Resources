Java 11
Angular 12

To run locally: `mvn clean spring-boot:run`
It will run on `localhost:8080`

To push to Azure:  `mvn clean package azure-webapp:deploy`



To recreate table:

CREATE TABLE car (
    id uuid PRIMARY KEY,
    make text,
    model text
); 

To deploy this on your own db, make sure to update the hardcoded urls in cars.service.ts to your website
Update the appplication.properties with your cosmos/cassandra connection strings
And update the POM plugin section with your connection properties 

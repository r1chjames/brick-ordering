# Ordering v1 Service

Ordering v1 service written in Java using the Dropwizard library along with JDBI3.

## Building
Run **gradlew clean build jarIt** to buld a standalone jar that contains all dependencies. Run it at the command line using this command: **java -jar brick-ordering-standalone.jar server <<path_to_config_yml>>**.

Run **gradlew cucumber** to run all Cucumber tests.

## Resources
The service provides three endpoints:
* **POST** /order/v1/orders - add a new order
* **GET** /order/v1/orders/{orderId} - retrieve an order by ID
* **GET** /order/v1/orders - retrieve all orders in the system

## Local Requirements

* PostgresSQL database
    * Port: 5432
    * User: postgres
    * Password: Pa55w0rd!
    * Database: ordering
    
 

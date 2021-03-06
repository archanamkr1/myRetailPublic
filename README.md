myRetail

This is an end-to-end Proof-of-Concept for a products API, a simple demonstration of RESTful webservices.
This will also consolidate data from other APIs , provides JSON response to the caller.

Author:

Archana Ambati.M

Technology Used:
Java, Spring boot ,maven, JUnit ( in-memory database)

Tools Used
Eclipse IDE, Postman

Published on : Feb 8th 2021

APIs:
GET/PUT -- http://localhost:8080/products/{id}
POST -- http://localhost:8080/products 
GET -- http://localhost:8080/productname/{id}
GET -- http://localhost:8080/productprice/{id}

JSON Results Format:
Working Example
All fields have data.

{
    "id": 464653,
    "name": "Blue_Ray",
    "current_price": {
        "value": 46.7,
        "currency_code": "USD"
    }
}

Links to Examples
Working Examples
http://localhost:8080/products/464653
http://localhost:8080/products/646676
http://localhost:8080/products/3554654

Can use any REST Clients like curl or postman to test the application
This application can be deployed on a container based solution ( like docker / k8s) to make it production compliant.

Other Artifacts

Screenshots_Postman_JUNIT.doc - Screenshots from Postman and JUNIT 
myRetail_ReadMe.doc -- Readme file for the application

Further enhancements in scope

1. Improved Error handling
2. Secured webservices with authentication / authorization
3. Improved JUnit for negative test cases.




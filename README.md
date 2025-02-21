# SEL-Architect-MicroServices

## Account API
account api is implemented layered architecture.

###### Functionalities:
 * List:
 ` all account information.
 `
 * Find by Id:
  ` get account information by id.
  `
 * Save:
   ` save account information on the data bases relational.  
   `
  * Delete:
    ` physical account information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base postgresql.
            `
######  Environment Variables:

 ``` 
java 11
postgresql-9.6.24-1-windows-x64
```

## Card API
card api is implemented with hexagonal architecture.

###### Functionalities:
 * List:
 ` all card information.
 `
 * Find by Id:
  ` get card information by id.
  `
 * Save:
   ` save card information on the data bases no relational.  
   `
  * Delete:
    ` physical card information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base mongoDB.
            `
######  Environment Variables:
 
 `application.home.config=\{localPath}\logback-spring.xml`


## Credit API
Credit api is implemented with layered architecture.

###### Functionalities:
 * List:
 ` all credit information.
 `
 * Find by Id:
  ` get credit information by id.
  `
 * Save:
   ` save credit information on the data bases relational.  
   `
  * Delete:
    ` physical credit information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base MySql.
            `
######  Environment Variables:

 ``` 
java 11
MySql 5.7
```

## Customer API
customer api is implemented hexagonal architecture.

###### Functionalities:
 * List:
 ` all customer information.
 `
 * Find by Id:
  ` get customer information by id.
  `
 * Save:
   ` save customer information on the data bases no relational.  
   `
  * Delete:
    ` physical customer information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base MongoDB.
            `
######  Environment Variables:

 ``` 
java 11
mongoDB 6.0
```

## Transaction API
Transaction api is implemented with hexagonal architecture.

###### Functionalities:
 * List:
 ` all transaction information.
 `
 * Find by Id:
  ` get transaction information by id.
  `
 * Save:
   ` save transaction information on the data bases no relational.  
   `
  * Delete:
    ` physical transaction information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base mongoDB.
            `
######  Environment Variables:
 
 `application.home.config=\{localPath}\logback-spring.xml`


## Wallet API
Wallet api is implemented with layered Architecture.

###### Functionalities:
 * List:
 ` all wallet information.
 `
 * Find by Id:
  ` get wallet information by id.
  `
 * Save:
   ` save wallet information on the data bases relational.  
   `
  * Delete:
    ` physical wallet information.
  
  ###### Integration:
   * Server configuration.
   * Server discovery.
   * Server gateway.
   * Data base mysql.
   * Cache redis.
            `
######  Environment Variables:

 ``` 
java 11
redis-2.4.5-win32-win64 
MySql 5.7
```

## Configuration server API

###### Functionalities:
 * port:
 ` 9080
 `
  ###### Integration:
   * github.
            `
######  Environment Variables:

 ``` 
java 11
```


## Eureka discovery API

###### Functionalities:
 * port:
 ` 9090
 `
  
######  Environment Variables:

 ``` 
java 11
```

## Gateway register API

###### Functionalities:
 * port:
 ` 9095
 `
  
######  Environment Variables:

 ``` 
java 11
```


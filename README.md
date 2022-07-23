# marketplace_api_intellistart_quiz

#### Ability to add new users to the system
<details>
  <summary>POST localhost:8080/users</summary>
  
-------------------------------------  
Request body:
  
``` json
{
    "firstName": "John",
    "lastName": "Snow",
    "amountOfMoney": 1000
}
```

Response body:  
````
You successfully added user
````
------------------------------------- 
</details>

#### Ability to add new products to the system
<details>
  <summary>POST localhost:8080/products</summary>
  
-------------------------------------  
Request body:
  
``` json

{
    "name":"apple",
    "price": 10.5
}  
```

Response body:  
````
You successfully added product
````
------------------------------------- 
</details>


#### Ability to delete users
<details>
  <summary>DELETE localhost:8080/users/{id}</summary>
  
-------------------------------------  

Response body:  
````
You successfully deleted user
````

-------------------------------------
</details>

#### Ability to delete products
<details>
  <summary>DELETE localhost:8080/products/{id}</summary>
  
-------------------------------------  

Response body:  
````
You successfully deleted product
````

-------------------------------------
</details>

#### Display list of all users
<details>
  <summary>GET localhost:8080/users</summary>
  
-------------------------------------  

Response body:  
````json
[
    {
        "id": 2,
        "firstName": "John",
        "lastName": "Snow",
        "amountOfMoney": 1000.0
    },
    {
        "id": 3,
        "firstName": "Daenerys",
        "lastName": "Targaryen",
        "amountOfMoney": 500.0
    }
]
````

-------------------------------------
</details>

#### Display list of all products
<details>
  <summary>GET localhost:8080/products</summary>
  
-------------------------------------  

Response body:  
````json
[
    {
        "id": 1,
        "name": "apple",
        "price": 10.5
    },
    {
        "id": 2,
        "name": "peach",
        "price": 15.5
    }
]
````

-------------------------------------
</details>

#### Ability to buy a products
<details>
  <summary>POST localhost:8080/purchases</summary>
  
-------------------------------------  
Request body:
````json
{
    "userId": 2,
    "productId": 1
}
````
Response body:  
````
You successfully bought product
````

-------------------------------------
</details>

#### List of purchases
<details>
  <summary>GET localhost:8080/purchases?userId={userId}</summary>
  
  - If you put in request parametrs only `userId` - you will get all products that were bought by user!
  - If you put in request parametrs only `productId` - you will get all users that have bought this product!
  - If you put in request parametrs `productId` and `userId`  - you will get information on whether certain product was bought by certain user!
  
-------------------------------------  

Response body:  
````json
[
    {
        "user": {
            "id": 3,
            "firstName": "Daenerys",
            "lastName": "Targaryen",
            "amountOfMoney": 453.0
        },
        "product": {
            "id": 1,
            "name": "apple",
            "price": 10.5
        }
    },
    {
        "user": {
            "id": 3,
            "firstName": "Daenerys",
            "lastName": "Targaryen",
            "amountOfMoney": 453.0
        },
        "product": {
            "id": 1,
            "name": "apple",
            "price": 10.5
        }
    },
    {
        "user": {
            "id": 3,
            "firstName": "Daenerys",
            "lastName": "Targaryen",
            "amountOfMoney": 453.0
        },
        "product": {
            "id": 2,
            "name": "peach",
            "price": 15.5
        }
    },
    {
        "user": {
            "id": 3,
            "firstName": "Daenerys",
            "lastName": "Targaryen",
            "amountOfMoney": 453.0
        },
        "product": {
            "id": 1,
            "name": "apple",
            "price": 10.5
        }
    }
]
````

-------------------------------------
</details>

# Book Store RESTful API

Develop a RESTful API for a bookstore that allows a user to login, perform user related tasks,
view a list of books and place book orders.

## API Documentation

http://localhost:8080/v2/api-docs

## Getting Started

1) Clone this repository to your machine 
2) Install all maven dependencies in pom.xml file via command

```
$ mvn clean install
```
- This step is a mandatory step since we use map struct plugin with this project. So, we need to 
generate the mapper class on complied time before start running the application.

3) Test API by endpoints below 

## API Endpoint

**[GET] /books**

- This API is for getting all available book lists.

Curl script

```
curl -X GET \
  http://localhost:8080/books \
  -H 'cache-control: no-cache' \
  -H 'postman-token: b8029911-5dfc-ffd4-6797-f4c275e508a3'
```


**[POST] /users**

Curl script

```
curl -X POST \
  http://localhost:8080/users \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 0edb2dd1-a3aa-4b16-c90c-f1b7ddbf627a' \
  -d '{
	"username": "nsupanuth",
	"password": "supanuth",
	"date_of_birth": "29/02/1996",
	"name": "Supanuth",
	"surname": "Ongsuk"
}'
```

**[GET] /users**

Curl script

```
curl -X GET \
  http://localhost:8080/users \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1e7c8f29-efb0-e563-ce48-ace4c500ed8c'
```

**[POST] /users/orders**

Curl script

```
curl -X POST \
  http://localhost:8080/users/orders \
  -H 'authorization: Basic bnN1cGFudXRoOnN1cGFudXRo' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 913768b3-4045-acd0-a9cd-2accab228507' \
  -d '{
	"orders": [1,2]
}'
```

**[DELETE] /users**

Curl script

```
curl -X DELETE \
  http://localhost:8080/users \
  -H 'authorization: Basic bnN1cGFudXRoOnN1cGFudXRo' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: a4d87d46-9e79-6a6e-d213-537295930087'
```


Note : Please follow the following API step by step since we need to create user first in order to authorize 
the some API.




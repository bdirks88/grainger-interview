# Grainger Interview

## Backend Setup

### Create and start a Postgres container
Assumes Docker version 28.1.1 is already installed.

If the container doesn't already exist, run the following:
```
docker run --name my-postgres \
-e POSTGRES_DB=mydb \
-e POSTGRES_USER=myuser \
-e POSTGRES_PASSWORD=mypassword \
-p 5432:5432 \
-d postgres
```
If the above command has been run before, just start the container:

```
docker start my-postgres
```

### Start the backend application
Assumes Java v17 is installed.

From inside the grainger-backend folder, run the following command:

``` 
./mvnw spring-boot:run
```

Application will be running on http://localhost:8080

## Frontend Setup
### Start the frontend application
Assumes Node.js v24.3.0 is already installed along with npm v11.4.2

If first time setting up the project, run the following command from the grainger-frontend folder:

```
npm install
```

To start the application, from inside the grainger-frontend folder, run the following:

```
npm run dev
```

Application will be running on http://localhost:5173

## Backend API Description
### Get All Products
```
GET http://localhost:8080/products
```
### Get Single Product
```
GET http://localhost:8080/products/{id}
```
### Create a product
```
POST http://localhost:8080/products

{
  "name": "myproduct"
}
```



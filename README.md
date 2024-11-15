# URL

BE
http://localhost:8080/

FE
http://localhost:3000/

Code for FE
https://github.com/daichitt/Restful-api-react

## API
| Method | Endpoint                     | Description                             | Request Body          | Response Type | Status Codes               |
|--------|------------------------------|-----------------------------------------|-----------------------|---------------|----------------------------|
| GET    | http://localhost:8080        | Retrieves all data from the server     | None                  | JSON/XML      | 200 OK, 404 Not Found      |
| GET    | http://localhost:8080/{id}   | Retrieves a specific item by ID        | None                  | JSON/XML      | 200 OK, 404 Not Found      |
| POST   | http://localhost:8080        | Adds a new item to the server          | JSON/XML (item data)  | JSON/XML      | 201 Created, 400 Bad Request |
| PUT    | http://localhost:8080/{id}   | Updates an existing item by ID         | JSON/XML (updated data)| JSON/XML      | 200 OK, 404 Not Found, 400 Bad Request |
| DELETE | http://localhost:8080/{id}   | Deletes a specific item by ID          | None                  | JSON/XML      | 204 No Content, 404 Not Found |

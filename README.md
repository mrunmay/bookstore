# Bookstore API [![Java CI with Maven](https://github.com/mrunmay/bookstore/actions/workflows/maven.yml/badge.svg)](https://github.com/mrunmay/bookstore/actions/workflows/maven.yml)

Welcome to the Bookstore API documentation. This document outlines the requirements, constraints, and details of the API.

## Requirements

### Application Description

This application exposes REST API for managing book orders. It allows users to place orders for books by providing the ISBN and quantity. Additionally, users can retrieve a list of book orders.

### Security

The API is secured using OAuth flow with GitHub as the authentication provider. Users must authenticate using their GitHub accounts to access the protected endpoints.

Reference Note: [https://docs.github.com](https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps)


### Response Format

The API supports both JSON and XML response formats. Clients can choose the format that best suits their needs.

## Endpoints

### Place an Order

Place an order for a book.

**Endpoint:**
```
POST /api/bookstore/order
```

**Request Body:**
```json
{
"isbn": "978-1234567890",
"quantity": 2
}
```

**Response:**
- Status: `201 Created`
- Body: "Book ordered with ID = {orderId}"

### Retrieve Book Orders

Retrieve a list of book orders.

**Endpoint:**
```
GET /api/bookstore/allorders
```

**Response:**
- Status: `200 OK`
- Body: List of book orders in the chosen response format
```json    
 [
  {
    "id": "78285bb7-736f-459a-8080-3eb047e3026a",
    "isbn": "Sample Book 1",
    "quantity": 10
  }
]
```

## Constraints

### Tech Stack

The application is built using the following technology stack:
- Spring Boot
- Java 1.8
- Database: H2, MySQL
- AWS free tier(EC2, RDS, S3)

### Deployment

The application is deployed using  AWS free tier services.
The deployment process is automated through a GitHub Actions workflow, which builds a runnable "Fat JAR" of the application.

### GitHub Repository

All infrastructure and application code are hosted in a public GitHub repository. You can access the code, configuration, and workflow details at [GitHub Repository Link](https://github.com/mrunmay/bookstore).

## Documentation and Testing

The API is publicly available for testing. You can access and test the API endpoints using your GitHub account credentials for authentication.

**Swagger URL:** `http://ec2-16-171-147-116.eu-north-1.compute.amazonaws.com:8080/swagger-ui.html`

**LIVE Demo:**

**POST**
```shell
curl --location 'http://ec2-16-171-147-116.eu-north-1.compute.amazonaws.com:8080/api/bookstore/order' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1BCBB05753290F06ABE6E3E7E4AF6A49' \
--data '{
"isbn": "Sample Book 1",
"quantity": 10
}'
```
**GET**
```shell
curl --location 'http://ec2-16-171-147-116.eu-north-1.compute.amazonaws.com:8080/api/bookstore/allorders' \
--header 'Cookie: JSESSIONID=1BCBB05753290F06ABE6E3E7E4AF6A49'
```

## Conclusion

The Bookstore API provides a simple and secure way to manage book orders. It leverages Spring Boot, Java, and AWS services to ensure a seamless and automated deployment process.

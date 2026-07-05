# URL Shortener

A RESTful URL Shortener API built with Spring Boot and Spring Data JPA. The application generates unique short URLs for long links, stores the mappings in a database, and redirects users to the original website when a short URL is accessed.

## Features

* Generate unique short URLs for long URLs.
* Prevent duplicate short code collisions.
* Return an existing short URL for previously shortened links.
* Redirect users to the original URL using HTTP 302 responses.
* Persist URL mappings using Spring Data JPA.
* RESTful API design with separate service, controller, and repository layers.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Maven
* PostgreeSQL
* REST APIs

## API Endpoints

### Create a Short URL

**POST** `/api/urlshortener/shorten`

**Request**

```json
{
  "originalUrl": "https://www.google.com"
}
```

### Redirect to the Original URL

**GET** `/{shortCode}`

Example:

```
GET /abc123
```

This endpoint redirects the client to the original URL associated with the given short code.

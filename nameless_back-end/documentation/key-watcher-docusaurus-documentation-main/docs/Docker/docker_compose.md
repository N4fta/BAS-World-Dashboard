---
sidebar_position: 7
sidebar_label: "Compose setup"
---

# Nameless Application Deployment

This guide provides step-by-step instructions to deploy the **Nameless** application using Docker Compose. The setup includes three services: a MongoDB database, a backend service, and a frontend service.

---

## Docker Compose Configuration

Below is the Docker Compose configuration for the `Nameless` application:

```yaml
services:
  nameless-mongodb:
    image: mongo
    environment:
      - MONGO_INITDB_ROOT_USERNAME=root
      - MONGO_INITDB_ROOT_PASSWORD=dhsrLpM8P3LqcuY
      - MONGO_INITDB_DATABASE=Nameless_DB
    volumes:
      - mongodb-data:/data/db
    container_name: mongo
    ports:
      - 27017:27017

  nameless-backend:
    image: n4fta/nameless:backend
    container_name: nameless-backend
    ports:
      - 8080:8080
    depends_on:
      - nameless-mongodb

  nameless-frontend:
    image: n4fta/nameless:frontend
    container_name: nameless-frontend
    environment:
      - VITE_API_BASE_URL=nameless-backend
      - NODE_ENV=production
    ports:
      - 3000:3000
    depends_on:
      - nameless-backend

volumes:
  mongodb-data:
```

---

## Services Overview

### 1. **MongoDB Service** (`nameless-mongodb`)

- **Image**: `mongo`
- **Environment Variables**:
  - `MONGO_INITDB_ROOT_USERNAME`: MongoDB root username (`root`).
  - `MONGO_INITDB_ROOT_PASSWORD`: MongoDB root password (`dhsrLpM8P3LqcuY`).
  - `MONGO_INITDB_DATABASE`: Default database name (`Nameless_DB`).
- **Volumes**: Stores MongoDB data in a persistent volume `mongodb-data`.
- **Ports**: Exposes the database on port `27017`.

### 2. **Backend Service** (`nameless-backend`)

- **Image**: `n4fta/nameless:backend`
- **Container Name**: `nameless-backend`
- **Ports**: Exposes the backend on port `8080`.
- **Dependencies**: Depends on the MongoDB service (`nameless-mongodb`).

### 3. **Frontend Service** (`nameless-frontend`)

- **Image**: `n4fta/nameless:frontend`
- **Container Name**: `nameless-frontend`
- **Environment Variables**:
  - `VITE_API_BASE_URL`: URL of the backend service (`nameless-backend`).
  - `NODE_ENV`: Specifies the production environment (`production`).
- **Ports**: Exposes the frontend on port `3000`.
- **Dependencies**: Depends on the backend service (`nameless-backend`).

---

## Deployment Instructions

1. **Clone the Repository**  
   Ensure the `docker-compose.yml` file is present in your working directory.

2. **Start the Services**  
   Run the following command to start all services:

   ```bash
   docker-compose up -d
   ```

3. **Verify the Services**  
   - MongoDB: Accessible on `localhost:27017`.
   - Backend: Accessible on `localhost:8080`.
   - Frontend: Accessible on `localhost:3000`.

4. **Stop the Services**  
   To stop and remove the services, run:

   ```bash
   docker-compose down
   ```

---

## Persistent Data Storage

The MongoDB service uses a Docker volume named `mongodb-data` to store database data persistently. This ensures that data is retained even if the container is removed.

---

## Troubleshooting

- **Service Not Starting**: Ensure Docker and Docker Compose are installed and running on your system.
- **Port Conflicts**: If the default ports (`27017`, `8080`, or `3000`) are in use, modify them in the `docker-compose.yml` file.
- **Connection Issues**: Verify that the services are running using the `docker ps` command.

---

## References

- [Docker Documentation](https://docs.docker.com/)
- [Docker Compose Documentation](https://docs.docker.com/compose/)


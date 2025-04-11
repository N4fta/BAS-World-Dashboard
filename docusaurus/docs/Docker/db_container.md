---
sidebar_position: 2
sidebar_label: Database Containerization
---

# Database contenerization

## Creating the Staging Database

### Part 1: Setting Up the Development Database

To initialize a Mongo database locally using Docker, follow these steps to create and run the container:

#### Step 1: Start Mongo in Docker

Execute the following command to launch a Mongo container locally on port 27017:

```bash
docker run --name nameless-db -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=<mongo_root_password> -d mongo
```


:::warning
Replace `<mongo_root_password>` with the desired mongo root password.
- `nameless-db` is a example name for the container

```bash, title="application.properties in the back-end container"
spring.data.mongodb.uri=mongodb://root:<mongo_root_password>@mongo:27017/Nameless_DB?authSource=admin
```
:::

After the container starts, it will have the Mongo database (`Nameless_DB`) created, accessible through any database management tool.
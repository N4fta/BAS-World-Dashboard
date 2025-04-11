---
sidebar_position: 3
sidebar_label: Create Back-end image and container
---

# Creating Docker Image of the Back-end

This document provides instructions on setting up a Docker container for the dashboard project. The Dockerfile is based on the `gradle:8.1.1-jdk17` image, and it uses the `namelessbackend.jar` file built with Gradle.

## Dockerfile Configuration

Below is the configuration for the Dockerfile with explanations added:

```dockerfile, title="Dockerfile"
FROM gradle:8.10.1-jdk17
WORKDIR /opt/app
COPY build/libs/nameless_backend-0.0.1-SNAPSHOT.jar namelessbackend.jar
COPY example-events/ example-events/

# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "namelessbackend.jar"]
```

## How to create the image

Once the Dockerfile is set up, you can build the Docker image for your application by running the following command in the root of your project (where the Dockerfile is located):

```bash
docker build -t <image_name> .
```

### Explanation
- **docker build**: The command used to create a Docker image from the Dockerfile.
- **-t image_name**: This option tags the image with the name `<image_name>`.
- **.**: The dot indicates the build context is the current directory, where Docker will look for the Dockerfile and other files.

## Verify the Image

After building the image, verify its existence by listing all Docker images or check in Docker Desktop:

```bash
docker images
```

You should see `<image_name>` in the output, indicating the image was successfully built.

## Creating and running the Docker Container

   - Run the container with the environment variables:
    ```bash
    docker run -d --name keywatcher_backend_container -p 8080:8080 <image_name>
    ```


You now have a container called `keywatcher_backend_container` running the image `<image_name>`.
    
The application will be accessible at `http://localhost:8080` by default.
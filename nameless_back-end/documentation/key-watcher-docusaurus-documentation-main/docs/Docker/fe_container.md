---
sidebar_position: 5
sidebar_label: Create Front-end Image and Container
---

# Creating Docker Image of the Front-end

This document provides instructions on setting up a Docker container for the dashboard project's front-end. The Dockerfile is based on the `node:18-alpine` image and uses a multi-stage build process to optimize the container size.

## Dockerfile Configuration

Below is the configuration for the Dockerfile, including comments explaining each step:

```dockerfile
FROM node:20-alpine

WORKDIR /app

COPY ./dist/ .

RUN npm i -g serve

EXPOSE 3000

CMD [ "serve", "-s", "." ]
```

## How to Create the Image

Once the Dockerfile is configured, build the Docker image for the application by running the following command in the root of the project:

```bash
docker build -t <image_name> .
```

### Explanation
- **docker build**: Creates a Docker image from the Dockerfile.
- **-t image_name*: Tags the image with a custom name.
- **.**: Indicates the current directory as the build context.

## Verify the Image

After building the image, verify its existence by listing Docker images or checking Docker Desktop:

```bash
docker images
```

You should see `<image_name>` listed in the output, confirming a successful build.

## Creating and Running the Docker Container

Run the container with the appropriate environment variables:

- Run the container with the environment variables:
   ```bash
   docker run -d --name raisehub_frontend_container -e VITE_API_BASE_URL=localhost:8080 -p 5173:5173 <image_name>
   ```


The application will be accessible at `http://localhost:5173` by default.
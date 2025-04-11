---
sidebar_position: 6
sidebar_label: DockerHub Repositories
---

# DockerHub Repositories

This guide provides the details for pulling the necessary Docker images from DockerHub to set up the KeyWatcher application.

---

## Frontend Image

To pull the frontend image, use the following command:

```bash
docker pull n4fta/nameless:frontend
```

Once you have pulled the image, follow this guide to set up the backend container:
 - [Frontend container setup](fe_container.md#creating-and-running-the-docker-container)

---

## Backend Image

To pull the backend image, run the following command:

```bash
docker pull n4fta/nameless:backend
```

Once you have pulled the image, follow this guide to set up the backend container:
 - [Backend container setup](be_container.md#creating-and-running-the-docker-container)

---

:::warning
Dont forget to [create a docker network](brigde_config.md) and then [connect the database and backend containers to the same network](connect_to_network.md).
:::
---

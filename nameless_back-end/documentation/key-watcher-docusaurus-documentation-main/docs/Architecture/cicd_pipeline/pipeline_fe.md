---
sidebar_position: 2
sidebar_label: "Front-end"
---

# Front-end Pipeline


The Front-end CI/CD pipeline automates the process of building and testing the front-end application. Below is an overview of the pipeline's workflow:

![Back-end Pipeline](img/fe_pipeline.png)

1. **Code Development**: Code is written on the developer's PC.
2. **Code Push**: Code is pushed to the GitLab server.
3. **Build**: The pipeline builds the React application using Vite.
4. **Test**: Automated tests are executed to ensure code quality.
5. **Build Docker Image**: A Docker image of the application is created.
6. **Verification**: The pipeline determines whether the build passes all checks (✅) or fails (❌).


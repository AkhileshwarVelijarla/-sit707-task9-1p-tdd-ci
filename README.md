# SIT707 Task 9.1P - Test Driven Development and Continuous Integration

## Project Function

This project implements a simplified OnTrack function called **Task Status Checker**.
The function checks a student's task submission details and returns the current status of the task.

Possible statuses:

- NOT_SUBMITTED
- SUBMITTED
- UNDER_REVIEW
- NEEDS_RESUBMISSION
- COMPLETED

## Requirement Story

As a student using OnTrack, I want to check the current status of my submitted task so that I can understand whether my task has not been submitted, submitted, under review, requires resubmission, or has been completed.

## Technologies Used

- Java 17
- Maven
- JUnit 5
- GitHub Actions

## How to Import in Eclipse

1. Open Eclipse.
2. Go to **File > Import**.
3. Select **Maven > Existing Maven Projects**.
4. Browse and select this project folder.
5. Click **Finish**.
6. Wait for Maven dependencies to download.

## How to Import in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click **Open**.
3. Select this project folder.
4. Choose **Open as Maven Project** if asked.
5. Wait for Maven indexing to finish.

## How to Run Tests Locally

Open terminal inside the project folder and run:

```bash
mvn clean test
```

## How to Build the Project

```bash
mvn package
```

## CI Setup

The GitHub Actions workflow is stored in:

```text
.github/workflows/ci.yml
```

Every push to the `main` branch automatically runs Maven tests and builds the project artifact.

## Screenshot Checklist for Submission

Take screenshots of:

1. Project folder structure
2. First failing test result for TDD red stage
3. Passing test result for TDD green stage
4. GitHub Actions failed build
5. Failed build email notification
6. GitHub Actions successful build
7. Successful build email notification
8. GitHub repository showing the pushed project folder

# Speaking Clock

## Project Overview
The Speaking Clock is a Java-based application that converts a 24-hour clock time into words. It provides an API to convert the current system time and user-input time into a spoken format. The application also handles special cases like "Midday" and "Midnight."

## Features
- Converts 24-hour time to words (e.g., "08:34" to "It's eight thirty-four").
- Handles special cases for "Midday" and "Midnight."
- REST API implementation with Swagger documentation.
- Exception handling and unit test cases included.

## Prerequisites
- **Java 17** 
- **Maven** (for building the project)
- **Spring Boot** (included via Maven dependencies)

## How to Build and Run the Project

### Building the Project
1. Clone the repository or download the project files.
    ```bash
    git clone <your-repo-url>
    cd speaking-clock
    ```
2. Use Maven to clean and build the project:
    ```bash
    mvn clean install
    ```

### Running the Application
1. After building, run the application:
    ```bash
    mvn spring-boot:run
    ```

### Accessing the API
- **Get Current Time in Words**:  
  - **Endpoint**: `/current-time`  
  - **Method**: GET  
  - **Response**: Converts the current system time to words.

- **Convert User-Input Time to Words**:  
  - **Endpoint**: `/convert-time`  
  - **Method**: GET  
  - **Params**: `time` (e.g., "11:25")  
  - **Response**: Converts the provided time to words.

### Example Requests
- **Current Time in Words**:  
  ```http
  GET http://localhost:8086/current-time
 
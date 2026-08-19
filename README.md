#  SmartResume-AI

SmartResume-AI is a Spring Boot based intelligent resume management and analysis platform designed to evaluate resumes, calculate ATS scores, manage job descriptions, and support future AI-powered resume-to-job matching.

##  Features

* Resume management
* Job management
* RESTful APIs
* Resume ATS score calculation
* Skill and profile information management
* MySQL database integration
* Spring Data JPA persistence
* Exception handling
* CORS support
* Modular layered architecture
* Future-ready AI resume analysis and job matching

##  Technology Stack

| Technology      | Purpose                 |
| --------------- | ----------------------- |
| Java 21         | Backend development     |
| Spring Boot     | Application framework   |
| Spring Web      | REST APIs               |
| Spring Data JPA | Database persistence    |
| Hibernate       | ORM                     |
| MySQL           | Relational database     |
| Maven           | Dependency management   |
| IntelliJ IDEA   | Development environment |
| Git & GitHub    | Version control         |

##  Project Structure

```text
smartresume-ai
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.smartresume.ai
│   │   │       ├── SmartResumeAiApplication.java
│   │   │       │
│   │   │       ├── controller
│   │   │       │   ├── ResumeController.java
│   │   │       │   └── JobController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   ├── ResumeService.java
│   │   │       │   └── JobService.java
│   │   │       │
│   │   │       ├── serviceimpl
│   │   │       │   ├── ResumeServiceImpl.java
│   │   │       │   └── JobServiceImpl.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │   ├── ResumeRepository.java
│   │   │       │   └── JobRepository.java
│   │   │       │
│   │   │       ├── entity
│   │   │       │   ├── Resume.java
│   │   │       │   └── Job.java
│   │   │       │
│   │   │       ├── dto
│   │   │       │   ├── ResumeRequest.java
│   │   │       │   └── JobRequest.java
│   │   │       │
│   │   │       ├── exception
│   │   │       │   └── ResumeNotFoundException.java
│   │   │       │
│   │   │       └── config
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
├── pom.xml
├── README.md
├── .gitignore
└── LICENSE
```

##  Architecture

```text
Client
   │
   ▼
REST Controller
   │
   ▼
Service Layer
   │
   ▼
Service Implementation
   │
   ▼
Repository Layer
   │
   ▼
Hibernate / JPA
   │
   ▼
MySQL Database
```

##  Current API Endpoints

### Resume APIs

| Method | Endpoint                      | Description         |
| ------ | ----------------------------- | ------------------- |
| POST   | `/api/resumes`                | Create resume       |
| GET    | `/api/resumes`                | Get all resumes     |
| GET    | `/api/resumes/{id}`           | Get resume by ID    |
| PUT    | `/api/resumes/{id}`           | Update resume       |
| DELETE | `/api/resumes/{id}`           | Delete resume       |
| GET    | `/api/resumes/{id}/ats-score` | Calculate ATS score |

### Job APIs

| Method | Endpoint         | Description   |
| ------ | ---------------- | ------------- |
| POST   | `/api/jobs`      | Create job    |
| GET    | `/api/jobs`      | Get all jobs  |
| GET    | `/api/jobs/{id}` | Get job by ID |
| PUT    | `/api/jobs/{id}` | Update job    |
| DELETE | `/api/jobs/{id}` | Delete job    |

##  ATS Scoring

The current ATS engine evaluates the presence of important resume sections:

* Name — 10 points
* Email — 10 points
* Phone — 10 points
* Skills — 20 points
* Education — 15 points
* Experience — 20 points
* Projects — 15 points

**Maximum Score: 100**

##  Future Enhancements

* Resume PDF upload
* Resume text extraction
* AI-based skill extraction
* Job-resume compatibility score
* NLP-based keyword matching
* Missing skill recommendations
* Resume improvement suggestions
* AI-generated career recommendations
* Authentication and authorization
* Swagger/OpenAPI documentation
* Frontend dashboard
* Resume analytics
* Docker deployment
* Cloud deployment

##  Configuration

Create a MySQL database named:

```sql
CREATE DATABASE smartresume_db;
```

Configure your local database credentials in `application.properties`.

Never commit real database passwords or API keys to GitHub.

## ▶️ Running the Project

Clone the repository and open it in IntelliJ IDEA.

Run:

```bash
mvn clean install
```

Then start:

```text
SmartResumeAiApplication
```

The application runs on:

```text
http://localhost:8080
```

##  Project Status

**Current Status:** Backend foundation completed

* Spring Boot setup 
* REST architecture 
* Resume CRUD 
* Job CRUD 
* JPA integration 
* MySQL configuration 
* Basic ATS scoring 
* AI matching engine 
* Resume parser 
* Frontend 

##  Author

**Shree Saravanan B**

B.Tech Artificial Intelligence and Data Science

## 📄 License

This project is licensed under the MIT License.

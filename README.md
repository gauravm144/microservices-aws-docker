# 🚀 AWS Microservices Architecture (Spring Boot + ECS Fargate)

## 📌 Overview
This project demonstrates a production-style microservices architecture deployed on AWS using containerized Spring Boot services.

It includes:
- Service-to-service communication using AWS Cloud Map (DNS-based discovery)
- Load balancing using Application Load Balancer (ALB)
- HTTPS-enabled custom domain integration
- Containerized deployment using Docker and ECS Fargate

---

## 🧠 Architecture

Client → ALB → ECS Fargate → Microservices → Cloud Map (Service Discovery)

- `/users/*` → user-service
- `/orders/*` → order-service
- order-service internally calls user-service via `user-service.local`

---

## ⚙️ Tech Stack

- Java, Spring Boot
- Docker
- AWS ECS (Fargate)
- AWS Application Load Balancer (ALB)
- AWS Cloud Map (Service Discovery)
- AWS ACM (SSL)
- GoDaddy (Domain DNS)

---

## 🔥 Features

- Microservices architecture with independent services
- Horizontal scaling (multiple instances per service)
- DNS-based service discovery (no hardcoded URLs)
- Path-based routing via ALB
- HTTPS enabled using AWS Certificate Manager
- High availability across multiple AZs

---

## 🧪 Endpoints


---

## 💡 Key Learnings

- How to deploy microservices on AWS ECS Fargate
- Implement service discovery using Cloud Map
- Configure ALB for routing and load balancing
- Enable HTTPS with custom domain and SSL
- Handle internal communication between services

                ┌──────────────────────────┐
                │        User (Client)     │
                └────────────┬─────────────┘
                             │
                   HTTPS (Domain + SSL)
                             │
                ┌────────────▼────────────┐
                │  Application Load       │
                │  Balancer (ALB)         │
                │  Path-based routing     │
                └───────┬─────────┬───────┘
                        │         │
             /users/*   │         │   /orders/*
                        │         │
        ┌───────────────▼───┐   ┌─▼────────────────┐
        │   user-service     │   │  order-service   │
        │   (Spring Boot)    │   │ (Spring Boot)    │
        │   ECS Fargate x2   │   │ ECS Fargate x2   │
        └───────────────┬───┘   └─────────┬────────┘
                        │                 │
                        │                 │ calls
                        │                 ▼
                        │      user-service.local
                        │   (AWS Cloud Map DNS)
                        │
        ┌───────────────▼──────────────┐
        │   AWS Cloud Map              │
        │   Service Discovery (DNS)    │
        └──────────────────────────────┘

## 🚀 Future Improvements

- Add database (AWS RDS)
- Implement circuit breaker (Resilience4j)
- Add CI/CD pipeline (GitHub Actions)
- Add caching layer (Redis)

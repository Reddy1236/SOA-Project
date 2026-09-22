# PS023 Architecture

## Service responsibilities

| Service | Responsibility | Port |
|---|---|---:|
| Eureka Server | Service discovery/registry | 8761 |
| API Gateway | Single entry point and JWT protection | 8080 |
| Auth Service | Login/register and JWT issuance | 8081 |
| Member Service | Member profile CRUD | 8082 |
| Subscription Service | Plans, subscriptions, renewals | 8083 |
| Attendance Service | Facility check-in and visit history | 8084 |

## Security

Auth issues a signed JWT. Gateway and every business service validate the JWT. Business endpoints therefore remain protected even if a service is reached directly during development.

## Load balancing

Subscription and Attendance use Spring Cloud LoadBalancer with Eureka service names (`MEMBER-SERVICE` and `SUBSCRIPTION-SERVICE`). Gateway routes use `lb://...`, so multiple registered instances can be used without hardcoding a single host.

## Data ownership

Each business service owns its own database/schema. No service directly queries another service's database.

## Main API

```text
POST /api/auth/login
POST /api/auth/register

GET    /api/members
GET    /api/members/{id}
POST   /api/members
PUT    /api/members/{id}
DELETE /api/members/{id}

GET  /api/subscriptions/plans
POST /api/subscriptions/plans
GET  /api/subscriptions/{id}
GET  /api/subscriptions/member/{memberId}
GET  /api/subscriptions/member/{memberId}/active
POST /api/subscriptions
POST /api/subscriptions/{id}/renew

POST /api/attendance/check-in
GET  /api/attendance
GET  /api/attendance/member/{memberId}
```

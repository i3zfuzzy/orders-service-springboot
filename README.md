# Orders Service (Spring Boot)

Pequeno serviço REST (Java 17 + Spring Boot 3) para cadastro de pedidos (in-memory).

## Endpoints
- `POST /api/orders` { customer, quantity, unitPrice }
- `GET /api/orders` lista
- `GET /api/orders/{id}` detalhe
- `DELETE /api/orders/{id}` remove

## Rodar
```bash
./mvnw spring-boot:run   # ou mvn spring-boot:run
```

## Docker
```bash
docker build -t com.dgs.backend/orders-service:0.1.0 .
docker run -p 8080:8080 com.dgs.backend/orders-service:0.1.0
```

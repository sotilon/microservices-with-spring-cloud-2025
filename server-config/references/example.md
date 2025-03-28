It looks like you're asking for help with configuring a Spring Cloud service (specifically `service-customer-dev.properties`) and testing it using `curl`. I can help with that! Let's break it down step by step.

---

### ✅ 1. **Spring Cloud Config Setup**

Assuming you're using **Spring Cloud Config Server**, your `service-customer-dev.properties` file would be stored in a Git repository or local file system that the Config Server reads from.

#### Example: `service-customer-dev.properties`
```properties
server.port=8081
spring.application.name=service-customer
customer.service.message=Hello from Customer Service (DEV)
```

This file should be placed in your config repository (e.g., Git) and named according to the pattern:
```
<application-name>-<profile>.properties
```
In this case:
- Application name: `service-customer`
- Profile: `dev`

---

### ✅ 2. **Spring Boot Application Configuration**

In your Spring Boot application (`service-customer`), make sure you have the following in `application.yml` or `application.properties`:

```yaml
spring:
  application:
    name: service-customer
  profiles:
    active: dev
  cloud:
    config:
      uri: http://localhost:8888  # URL of your Config Server
```

---

### ✅ 3. **Testing with `curl`**

Once your **Spring Cloud Config Server** is running on port `8888`, you can test it using `curl`.

#### 🔍 Example: Fetch config for `service-customer` with `dev` profile

```bash
curl http://localhost:8888/service-customer/dev
```

You should get a JSON response like:
```json
{
  "name": "service-customer",
  "profiles": ["dev"],
  "label": null,
  "version": "abc123",
  "propertySources": [
    {
      "name": "https://your-git-repo/service-customer-dev.properties",
      "source": {
        "server.port": "8081",
        "spring.application.name": "service-customer",
        "customer.service.message": "Hello from Customer Service (DEV)"
      }
    }
  ]
}
```

---

### ✅ 4. **Testing the Running Service with `curl`**

If your `service-customer` app is running and exposes an endpoint (e.g., `/message`), you can test it like this:

#### Example Controller:
```java
@RestController
public class CustomerController {

    @Value("${customer.service.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
```

#### Test with `curl`:
```bash
curl http://localhost:8081/message
```

Expected output:
```
Hello from Customer Service (DEV)
```

---

### ✅ 5. Optional: Refresh Configuration at Runtime

If you change the config in Git and want to refresh it without restarting the app, make sure you have `spring-boot-starter-actuator` and `spring-cloud-starter-bus-refresh` dependencies, and then:

```bash
curl -X POST http://localhost:8081/actuator/refresh
```

---

Would you like help creating a sample project structure or Docker setup for this?
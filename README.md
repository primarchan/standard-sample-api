# 표준 API 프로젝트
- 표준 API Response 스펙 적용
- 표준 예외 처리 로직 적용
- JPA 지원

## TECH_STACK
- Java 17
- Spring Boot 3.2.3
- Spring Web
- Spring Data JPA
- MySQL 8.0.3
- Lombok
- Gradle
- IntelliJ IDEA 2023.3.4 (Ultimate Edition)
- macOS Sonoma 14.4.1

## Swagger UI
- [Swagger UI 링크](http://localhost:8888/swagger-ui/index.html)

## API RESPONSE SPEC
```json
{
  "result" : {
    "result_code" : 200,
    "result_message" : "OK",
    "result_description" : "성공"
  },
  "body" : {

  }
}
```
package org.example.springbootjavajpastandardapi.config.objectmapper;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Jdk8Module 을 등록하여 Optional 과 같은 JDK 8의 새로운 타입들을 지원합니다.
        objectMapper.registerModule(new Jdk8Module());

        // JavaTimeModule 을 등록하여 Java 8 날짜/시간 타입을 지원합니다.
        objectMapper.registerModule(new JavaTimeModule());

        // 알 수 없는 JSON 속성이 객체에 매핑될 때 예외를 발생시키지 않도록 합니다.
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 빈 객체를 JSON 으로 직렬화할 때 예외를 발생시키지 않도록 합니다.
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 날짜와 시간 값을 타임스탬프가 아닌 ISO8601 형식의 문자열로 직렬화합니다.
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 속성 이름을 스네이크 케이스(예: some_property_name)로 직렬화하도록 명명 전략을 설정합니다.
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }

}

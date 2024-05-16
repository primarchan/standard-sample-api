package org.example.springbootjavajpastandardapi.domain.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.springbootjavajpastandardapi.common.jpa.BaseEntity;
import org.example.springbootjavajpastandardapi.domain.test.dto.request.TestRequest;

import java.time.LocalDateTime;

@Table(name = "test")
@Getter
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity extends BaseEntity {

    private String name;

    private String description;

    public static TestEntity of(TestRequest testRequest) {
        return TestEntity.builder()
                .name(testRequest.getName())
                .description(testRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

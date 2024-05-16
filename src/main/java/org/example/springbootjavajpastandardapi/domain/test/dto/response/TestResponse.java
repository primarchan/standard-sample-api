package org.example.springbootjavajpastandardapi.domain.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootjavajpastandardapi.domain.test.entity.TestEntity;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TestResponse of(TestEntity testEntity) {
        return TestResponse.builder()
                .id(testEntity.getId())
                .name(testEntity.getName())
                .description(testEntity.getDescription())
                .createdAt(testEntity.getCreatedAt())
                .build();
    }

}

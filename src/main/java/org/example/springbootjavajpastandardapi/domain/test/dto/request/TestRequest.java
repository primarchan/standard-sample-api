package org.example.springbootjavajpastandardapi.domain.test.dto.request;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class TestRequest {

    @Valid
    private String name;

    @Valid
    private String description;

}

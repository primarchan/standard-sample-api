package org.example.springbootjavajpastandardapi.domain.test.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootjavajpastandardapi.common.api.ApiResponse;
import org.example.springbootjavajpastandardapi.common.error.UserErrorCode;
import org.example.springbootjavajpastandardapi.domain.test.dto.request.TestRequest;
import org.example.springbootjavajpastandardapi.domain.test.dto.response.TestResponse;
import org.example.springbootjavajpastandardapi.domain.test.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public ApiResponse<TestResponse> saveTestData(@RequestBody TestRequest testRequest) {
        TestResponse response = testService.saveTestData(testRequest);

        return ApiResponse.OK(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<TestResponse> getTestData(@PathVariable final Long id) {
        TestResponse response = testService.findTestDataById(id);

        return ApiResponse.OK(response);
    }

    @GetMapping("/error")
    public ApiResponse<Object> errorTest() {
        return ApiResponse.ERROR(UserErrorCode.USER_NOT_FOUND, "사용자를 찾을 수 없음");
    }

}

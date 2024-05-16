package org.example.springbootjavajpastandardapi.domain.test.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootjavajpastandardapi.common.error.ErrorCode;
import org.example.springbootjavajpastandardapi.common.error.ErrorCodeIfs;
import org.example.springbootjavajpastandardapi.common.exception.ApiResponseException;
import org.example.springbootjavajpastandardapi.domain.test.dto.request.TestRequest;
import org.example.springbootjavajpastandardapi.domain.test.dto.response.TestResponse;
import org.example.springbootjavajpastandardapi.domain.test.entity.TestEntity;
import org.example.springbootjavajpastandardapi.domain.test.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public TestResponse findTestDataById(Long id) {
        TestEntity testEntity = testRepository.findById(id)
                .orElseThrow(() -> new ApiResponseException(ErrorCode.BAD_REQUEST, String.format("%s번 데이터는 존재하지 않습니다.", id)));

        return TestResponse.of(testEntity);
    }

    public TestResponse saveTestData(TestRequest testRequest) {
        TestEntity testEntity = TestEntity.of(testRequest);

        TestEntity savedTestEntity = testRepository.save(testEntity);

        return TestResponse.of(savedTestEntity);
    }

}

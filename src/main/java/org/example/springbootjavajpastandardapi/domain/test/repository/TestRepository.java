package org.example.springbootjavajpastandardapi.domain.test.repository;

import org.example.springbootjavajpastandardapi.domain.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}

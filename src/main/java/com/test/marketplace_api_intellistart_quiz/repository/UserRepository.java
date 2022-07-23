package com.test.marketplace_api_intellistart_quiz.repository;

import com.test.marketplace_api_intellistart_quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

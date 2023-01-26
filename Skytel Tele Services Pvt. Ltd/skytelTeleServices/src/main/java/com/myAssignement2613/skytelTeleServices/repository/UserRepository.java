package com.myAssignement2613.skytelTeleServices.repository;

import com.myAssignement2613.skytelTeleServices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByAgeGreaterThan(int age);
}

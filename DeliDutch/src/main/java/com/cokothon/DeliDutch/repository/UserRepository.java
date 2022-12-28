package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

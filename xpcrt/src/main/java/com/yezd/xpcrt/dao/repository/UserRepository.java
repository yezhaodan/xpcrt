package com.yezd.xpcrt.dao.repository;

import com.yezd.xpcrt.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByName(String name);
}

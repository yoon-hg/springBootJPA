package com.example.jpasetting.model;

import org.springframework.data.domain.Page;

public interface UserRepositoryCustom {

    Page<User> findByAll();
}

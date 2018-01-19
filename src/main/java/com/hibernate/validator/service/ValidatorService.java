package com.hibernate.validator.service;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ValidatorService.java
 * <p>
 * Created by 阳君 on 2017/10/16.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Validated
@Service
public class ValidatorService {

    public String checkUser(@NotEmpty(message = "{username.NotEmpty}")
                                    String username,
                            @NotEmpty(message = "{password.NotEmpty}")
                            @Size(min = 6, max = 9, message = "{password.Size}")
                                    String password) throws ConstraintViolationException {
        return "User [username=" + username + ", password=" + password + "]";
    }

}
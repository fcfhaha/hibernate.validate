package com.hibernate.validator.controller;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hibernate.validator.service.ValidatorService;
import com.hibernate.validator.vo.User;

/**
 * ValidatorController.java
 * <p>
 * Created by 阳君 on 2017/10/16.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @RequestMapping("")
    public String index() {
    	System.out.println(" test !!!!!!!!");
    	System.out.println(" dddd !!!!!!!!");
        return "validator/index";
    }
//hibernate-validate-i18n
    @RequestMapping("/login")
    public String login(Model model, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                FieldError fieldError = (FieldError) objectError;
                model.addAttribute(fieldError.getField() + "Valid", objectError.getDefaultMessage());
            }
            return "validator/index";
        }
        model.addAttribute("msg", user.toString());
        return "validator/success";
    }

    @RequestMapping("/login2")
    public String login2(Model model, User user) {
        try {
            model.addAttribute("msg", this.validatorService.checkUser(user.getUsername(), user.getPassword()));
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation constraintViolation : e.getConstraintViolations()) {
                String key = ((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().getName() + "Valid";
                model.addAttribute(key, constraintViolation.getMessage());
            }
            return "validator/index";
        }
        return "validator/success";
    }

}
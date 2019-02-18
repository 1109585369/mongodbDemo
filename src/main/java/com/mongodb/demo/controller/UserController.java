package com.mongodb.demo.controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.demo.dao.UserDao;
import com.mongodb.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yy
 * @ProjectName mongodbDemo
 * @Description: TODO
 * @date 2019/2/15 14:11
 */
@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/findByName/{name}")
    public String findByName(@PathVariable("name") String name){
        List<UserEntity> userEntities = userDao.findUserByName(name);
        return  userEntities.toString();
    }
}

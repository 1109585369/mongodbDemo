package com.mongodb.demo.dao.impl;

import com.mongodb.demo.dao.UserDao;
import com.mongodb.demo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(21);
        userEntity.setName("jack");
        userEntity.setPassword("qwerdf");
        userDao.saveUser(userEntity);
    }

    @Test
    public void findUserByName() {
        String name = "jack";
        userDao.findUserByName(name);
    }

    @Test
    public void updateUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(21);
        userEntity.setName("jack");
        userEntity.setPassword("qwert");

        userDao.updateUser(userEntity);
    }

    @Test
    public void deleteUserById() {

        userDao.deleteUserById((long) 21);
    }
}
package com.mongodb.demo.dao;

import com.mongodb.demo.entity.UserEntity;

import java.util.List;

/**
 * @author yy
 * @ProjectName mongodbDemo
 * @Description: TODO
 * @date 2019/2/1515:04
 */
public interface UserDao  {

    void saveUser(UserEntity user);

    List<UserEntity> findUserByName(String name);

    void updateUser(UserEntity user);

    void deleteUserById(Long id);
}

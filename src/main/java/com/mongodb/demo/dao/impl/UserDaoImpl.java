package com.mongodb.demo.dao.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.demo.dao.UserDao;
import com.mongodb.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yy
 * @ProjectName mongodbDemo
 * @Description: TODO
 * @date 2019/2/15 15:07
 */

@Service("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    @Cacheable(cacheNames = "userCache",key = "#name")
    public List<UserEntity> findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        System.out.println("查询数据库");
        List<UserEntity> users = mongoTemplate.find(query,UserEntity.class);
        return users;
    }

    @Override
    public void updateUser(UserEntity user) {
        Query query  = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name",user.getName()).set("password",user.getPassword());
        //更新查询返回结果集的第一条
        //mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
         UpdateResult result =  mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult result = mongoTemplate.remove(query,UserEntity.class);
    }
}

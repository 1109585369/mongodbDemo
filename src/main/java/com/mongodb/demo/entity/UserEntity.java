package com.mongodb.demo.entity;

import java.io.Serializable;

/**
 * @author yy
 * @ProjectName mongodbDemo
 * @Description: TODO
 * @date 2019/2/15 15:02
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5934994507788207789L;

    private Long id;

    private String name;

    private String password;


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

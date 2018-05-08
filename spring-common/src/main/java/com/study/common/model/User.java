package com.study.common.model;

import java.io.Serializable;

/**
 * Created by lf52 on 2018/5/5.
 */
public class User implements Serializable {

    private String name;
    private String city;
    private Integer age;

    public User() {

    }

    public User(String city, Integer age, String name) {
        this.city = city;
        this.age = age;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}

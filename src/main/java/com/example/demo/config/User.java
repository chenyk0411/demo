package com.example.demo.config;

public class User implements Comparable<User> {
    private String userName;
    private Integer age;
    public User(String userName,Integer age){
        this.userName = userName;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age > o.getAge()?-1:1;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

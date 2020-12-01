package com.gyc.springbootdata.pojo;

/**
 * Created by GYC
 * 2020/12/1 15:35
 */
public class Student {
    private int id;
    private String name;
    private boolean gender;
    private String major;
    private String phone;

    public Student() {
    }

    public Student(int id, String name, boolean gender, String major, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

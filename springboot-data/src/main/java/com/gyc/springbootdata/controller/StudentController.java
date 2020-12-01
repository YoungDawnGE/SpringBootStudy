package com.gyc.springbootdata.controller;

import com.gyc.springbootdata.mapper.StudentMapper;
import com.gyc.springbootdata.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GYC
 * 2020/12/1 18:08
 */
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        List<Student> students = studentMapper.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
        return students;
    }
}

package com.gyc.springbootdata.mapper;

import com.gyc.springbootdata.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GYC
 * 2020/12/1 15:39
 */
//@Mapper表示了这是一个MyBatis的Mapper类
//@Repository表示了这是Dao层

@Mapper
@Repository
public interface StudentMapper {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudentById(int id);
}

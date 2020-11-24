package com.gyc.springbootstudy;

import com.gyc.springbootstudy.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootstudyApplicationTests {
    /*@Autowired
    private Dog dog;

    @Value("Bob")
    private String name;
    @Value("2")
    private Integer age;*/

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}

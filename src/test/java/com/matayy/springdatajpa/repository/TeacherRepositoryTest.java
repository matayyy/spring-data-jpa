package com.matayy.springdatajpa.repository;

import com.matayy.springdatajpa.entity.Course;
import com.matayy.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course2 = new Course("course2",42);
        Course course3 = new Course("course123",43);
        Course course1 = new Course("course1",41);

//        Teacher teacher = new Teacher("TeacherName", "TeacherLastName", List.of(course1, course2, course3));
//        teacherRepository.save(teacher);
    }

}
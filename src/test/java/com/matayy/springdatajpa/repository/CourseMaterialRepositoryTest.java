package com.matayy.springdatajpa.repository;

import com.matayy.springdatajpa.entity.Course;
import com.matayy.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = new Course("Jpa Course", 12);
        CourseMaterial courseMaterial = new CourseMaterial("www.google.com", course);
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterials() {
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}
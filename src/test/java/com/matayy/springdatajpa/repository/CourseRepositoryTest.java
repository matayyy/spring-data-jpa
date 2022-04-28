package com.matayy.springdatajpa.repository;

import com.matayy.springdatajpa.entity.Course;
import com.matayy.springdatajpa.entity.Student;
import com.matayy.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = new Teacher("name", "lastname");
        Course course = new Course("courseTeacher", 12, teacher);

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllWitchSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2, Sort.by("credit").descending());

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = new Teacher("maciek", "zkalnu");
        Student student = new Student.Builder()
                .firstName("stu")
                .lastName("dent")
                .emailId("123@.com")
                .build();
        Course course = new Course("titleStuTeach", 12,teacher);

        course.addStudent(student);
        courseRepository.save(course);
    }

}
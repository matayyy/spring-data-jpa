package com.matayy.springdatajpa.repository;

import com.matayy.springdatajpa.entity.Guardian;
import com.matayy.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = new Student.Builder()
                .emailId("test@email.com")
                .firstName("User")
                .lastName("Test")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = new Guardian("Maciek", "maciek@email.pl", "20123123");
        Student student = new Student.Builder()
                .firstName("Salivan")
                .lastName("Gruby")
                .emailId("salivan@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students = studentRepository.findByFirstName("Salivan");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students = studentRepository.findByFirstNameContaining("ser");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikil");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("test@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentNameByEmailAddress() {
        String name = studentRepository.getStudentFirstNameByEmailAddress("test@email.com");
        System.out.println("name = " + name);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("test@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("test@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("UpdatedUser", "test@email.com");
    }
}
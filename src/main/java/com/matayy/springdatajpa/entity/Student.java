package com.matayy.springdatajpa.entity;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = {
                @UniqueConstraint(name = "emailid_unique", columnNames = "email_address")
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Embedded
    private Guardian guardian;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    protected Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.emailId = builder.emailId;
        this.guardian = builder.guardian;
    }

    public static class Builder {

        public Guardian guardian;
        private String firstName;
        private String lastName;
        private String emailId;

        public Builder() {
        }

        Builder(String firstName, String lastName, String emailId, Guardian guardian) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailId = emailId;
            this.guardian = guardian;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return Builder.this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return Builder.this;
        }

        public Builder emailId(String emailId){
            this.emailId = emailId;
            return Builder.this;
        }

        public Builder guardian(Guardian guardian) {
            this.guardian = guardian;
            return Builder.this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", guardian=" + guardian +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

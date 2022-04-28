package com.matayy.springdatajpa.entity;

import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;

@Entity
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    public CourseMaterial() {
    }

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
//                ", course=" + course +
                '}';
    }
}

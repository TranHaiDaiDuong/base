package com.gst.base.ejb.bean;

import com.gst.base.remote.entity.Student;
import com.gst.base.remote.service.StudentBeanRemote;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;


import static com.gst.base.remote.entity.Student.FIXED_TIME;


@Stateless
public class StudentBean implements StudentBeanRemote {
    @Override
    public List<Student> findBySex(String sex) {
        Student fixedStudent1 = Student.builder().id(1).sex("Nam").name("Dương")
                .dateOfBirth(FIXED_TIME.minusYears(7))
                .phoneNumber("0869023080").image("u01/base/1.jpg").build();
        Student fixedStudent2 = Student.builder().id(2).sex("Nam").name("CƯờng")
                .dateOfBirth(FIXED_TIME.minusYears(6))
                .phoneNumber("0869023080").image("u01/base/2.jpg").build();
        Student fixedStudent3 = Student.builder().id(3).sex("Nữ").name("Minh")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/3.jpg").build();
        Student fixedStudent4 = Student.builder().id(5).sex("Nam").name("Vinh")
                .dateOfBirth(FIXED_TIME.plusYears(4))
                .phoneNumber("0869023080").image("u01/base/4.jpg").build();
        Student fixedStudent5 = Student.builder().id(4).sex("Nữ").name("Trường")
                .dateOfBirth(FIXED_TIME.minusYears(3))
                .phoneNumber("0869023080").image("u01/base/5.jpg").build();
        Student fixedStudent6 = Student.builder().id(6).sex("Nữ").name("Nhung")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/6.jpg").build();
        Student fixedStudent7 = Student.builder().id(7).sex("Nam").name("Hoàng")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/7.jpg").build();

       List<Student> fixedMaleStudents = Arrays.asList(fixedStudent1, fixedStudent2, fixedStudent4, fixedStudent7);
       List<Student> fixedFEMaleStudents = Arrays.asList(fixedStudent3, fixedStudent5, fixedStudent6);

        if (sex.equals("Nam")) {
            return fixedMaleStudents;
        } else if (sex.equals("Nữ")){
            return fixedFEMaleStudents;
        } else {
            return null;
        }
    }

    @Override
    public Student findById(Integer id) {
        if (id == 1) {
            return Student.builder().id(1).sex("Nam").name("Dương")
                    .dateOfBirth(FIXED_TIME.minusYears(7))
                    .phoneNumber("0869023080").image("u01/base/1.jpg").build();
        } else if (id == 2) {
            return Student.builder().id(2).sex("Nam").name("Cường")
                    .dateOfBirth(FIXED_TIME.minusYears(6))
                    .phoneNumber("0869023080").image("u01/base/2.jpg").build();
        } else if (id == 3) {
            return Student.builder().id(3).sex("Nữ").name("Minh")
                    .dateOfBirth(FIXED_TIME.minusYears(2))
                    .phoneNumber("0869023080").image("u01/base/3.jpg").build();
        } else {
            return null;
        }
    }




    @Override
    public List<Student> findByAll() {
        Student fixedStudent1 = Student.builder().id(1).sex("Nam").name("Dương")
                .dateOfBirth(FIXED_TIME.minusYears(7))
                .phoneNumber("0869023080").image("u01/base/1.jpg").build();
        Student fixedStudent2 = Student.builder().id(2).sex("Nam").name("Cường")
                .dateOfBirth(FIXED_TIME.minusYears(6))
                .phoneNumber("0869023080").image("u01/base/2.jpg").build();
        Student fixedStudent3 = Student.builder().id(3).sex("Nữ").name("Hiền")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/3.jpg").build();
        Student fixedStudent4 = Student.builder().id(4).sex("Nam").name("Trường")
                .dateOfBirth(FIXED_TIME.plusYears(4))
                .phoneNumber("0869023080").image("u01/base/4.jpg").build();
        Student fixedStudent5 = Student.builder().id(5).sex("Nữ").name("Trang")
                .dateOfBirth(FIXED_TIME.minusYears(3))
                .phoneNumber("0869023080").image("u01/base/5.jpg").build();
        Student fixedStudent6 = Student.builder().id(6).sex("Nữ").name("Thảo")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/6.jpg").build();
        Student fixedStudent7 = Student.builder().id(7).sex("Nam").name("Hoàng")
                .dateOfBirth(FIXED_TIME.minusYears(2))
                .phoneNumber("0869023080").image("u01/base/7.jpg").build();
        List<Student> fixedAllStudents = Arrays.asList(fixedStudent1, fixedStudent2, fixedStudent3
                , fixedStudent4, fixedStudent5, fixedStudent6, fixedStudent7);
        if (fixedAllStudents.isEmpty()) {
            return null;
        } else {
            return fixedAllStudents;
        }

    }
}

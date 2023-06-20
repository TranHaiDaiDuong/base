package com.gst.base.remote.service;

import com.gst.base.remote.entity.Student;
import javassist.NotFoundException;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface StudentBeanRemote {
    List<Student> findBySex(String sex);

    Student findById(Integer id) throws NotFoundException;

    List<Student> findByAll();


}

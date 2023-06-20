package com.gst.base.remote.service;

import com.gst.base.remote.entity.Staff;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface StaffBeanRemote {

    Staff findByPhoneNumber(String phoneNumber);

    List<Staff> findAllStaff();

    List<Staff> findByStaffId(Integer staffId);
    List<Staff> findByTeamId(Integer teamId);

    List<Staff> findByTeamIdAge(Integer teamId);

    List<Staff> findByName(String name);
}

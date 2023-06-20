package com.gst.base.remote.util;

public interface BaseJndi {

    String BASE_BASIC_BEAN = "ejb:base-ear/base-ejb/"
            + "BaseBasicBean!com.gst.base.remote.service.BaseBasicBeanRemote";
    String DEMO_BEAN = "ejb:base-ear/base-ejb/"
            + "DemoBean!com.gst.base.remote.service.DemoBeanRemote";
    String STUDENT_BEAN = "ejb:base-ear/base-ejb/"
            + "StudentBean!com.gst.base.remote.service.StudentBeanRemote";
    String STAFF_BEAN = "ejb:base-ear/base-ejb/"
            + "StaffBean!com.gst.base.remote.service.StaffBeanRemote";
}

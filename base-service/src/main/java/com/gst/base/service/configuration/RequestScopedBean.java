package com.gst.base.service.configuration;

import com.gst.base.remote.service.BaseBasicBeanRemote;
import com.gst.base.remote.service.DemoBeanRemote;
import com.gst.base.remote.service.StaffBeanRemote;
import com.gst.base.remote.service.StudentBeanRemote;
import com.gst.base.remote.util.BaseBeanProvider;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@RequestScoped
public class RequestScopedBean implements Serializable {

    @Produces
    public BaseBasicBeanRemote getBaseBasicBeanRemote() {
        return BaseBeanProvider.getBaseBasicBeanRemote();
    }

    @Produces
    public DemoBeanRemote getDemoBeanRemote() {
        return BaseBeanProvider.getDemoBeanRemote();
    }

    //them
    @Produces
    public StudentBeanRemote getStudentBeanRemote() {
        return BaseBeanProvider.getStudentBeanRemote();
    }

    @Produces
    public StaffBeanRemote getStaffBeanRemote() {
        return BaseBeanProvider.getStaffBeanRemote();
    }

}

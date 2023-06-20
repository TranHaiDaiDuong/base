package com.gst.base.ejb.bean;

import com.gst.base.remote.entity.DemoEntity;
import com.gst.base.remote.service.DemoBeanRemote;

import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Stateless
public class DemoBean implements DemoBeanRemote {
    @PersistenceContext(unitName = "base-pu")
//    private EntityManager em;

    public static final int YEARS = 21;

    @Override
    public DemoEntity findByName(String name) {
        return DemoEntity.builder().id(1).fullName("Nguyen Van Nam" + name)
                .dateOfBirth(LocalDateTime.now().minusYears(YEARS)).imageLink("/u01/avatar.jpg").build();
    }



}

package com.gst.base.ejb.bean;

import com.gst.base.remote.entity.Staff;
import com.gst.base.remote.service.StaffBeanRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StaffBean implements StaffBeanRemote {
    // kết nối DB
    @PersistenceContext(unitName = "base-pu")
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }


    @Override
    public Staff findByPhoneNumber(String phoneNumber) {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findByPhoneNumber", Staff.class);
        query.setParameter("phoneNumber", phoneNumber);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public List<Staff> findAllStaff() {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findAllStaff", Staff.class);
        //query.setParameter("staff", );
        return query.getResultList();    }

    @Override
    public List<Staff> findByStaffId(Integer staffId) {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findByStaffId", Staff.class);
        query.setParameter("staff", staffId);
        return query.getResultList();
    }
    @Override
    public List<Staff> findByTeamId(Integer teamId) {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findByTeamId", Staff.class);
        query.setParameter("team", teamId);
        return query.getResultList();
    }

    @Override
    public List<Staff> findByTeamIdAge(Integer teamId) {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findByTeamIdAge", Staff.class);
        query.setParameter("teamId", teamId);
        return query.getResultList();
    }

    @Override
    public List<Staff> findByName(String name) {
        TypedQuery<Staff> query = getEntityManager().createNamedQuery("Staff.findByName", Staff.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}

package com.gst.base.ejb;

import com.gst.util.ejb.bean.session.BasicBeanImplement;
import com.gst.base.remote.service.BaseBasicBeanRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseBasicBean extends BasicBeanImplement implements BaseBasicBeanRemote {

    @PersistenceContext(unitName = "base-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

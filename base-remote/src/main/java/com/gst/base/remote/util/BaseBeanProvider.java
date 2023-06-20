package com.gst.base.remote.util;

import com.gst.base.remote.service.BaseBasicBeanRemote;
import com.gst.base.remote.service.DemoBeanRemote;

import com.gst.base.remote.service.StaffBeanRemote;
import com.gst.base.remote.service.StudentBeanRemote;
import com.gst.util.remote.provider.AbstractBeanProvider;

import javax.naming.Context;
import java.util.Properties;

public class BaseBeanProvider extends AbstractBeanProvider {

    public static BaseBeanProvider getInstance() {
        return BaseBeanProviderHolder.INSTANCE;
    }

    public static BaseBasicBeanRemote getBaseBasicBeanRemote() {
        return getInstance().getBean(BaseJndi.BASE_BASIC_BEAN);
    }

    public static DemoBeanRemote getDemoBeanRemote() {
        return getInstance().getBean(BaseJndi.DEMO_BEAN);
    }

    public static StudentBeanRemote getStudentBeanRemote() {
        return getInstance().getBean(BaseJndi.STUDENT_BEAN);
    }
    public static StaffBeanRemote getStaffBeanRemote() {
        return getInstance().getBean(BaseJndi.STAFF_BEAN);
    }

    @Override
    protected Properties getEnvironment() {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        return jndiProperties;
    }

    private static class BaseBeanProviderHolder {

        private static final BaseBeanProvider INSTANCE = new BaseBeanProvider();

        private BaseBeanProviderHolder() {
        }
    }
}

package com.gst.base.ejb.singleton;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Singleton
@Startup
public class EntityViewManagerProducer {

    // inject the configuration provided by the cdi integration
    @Inject
    private EntityViewConfiguration config;

    // inject the criteria builder factory which will be used along with the entity view manager
    @Inject
    private CriteriaBuilderFactory criteriaBuilderFactory;

    private EntityViewManager evm;

    @PostConstruct
    public void init() {
        // do some configuration
        BaseEntityViewConfiguration.addAllEntityView(config);
        evm = config.createEntityViewManager(criteriaBuilderFactory);
    }

    @Produces
    @ApplicationScoped
    public EntityViewManager createEntityViewManager() {
        return evm;
    }
}

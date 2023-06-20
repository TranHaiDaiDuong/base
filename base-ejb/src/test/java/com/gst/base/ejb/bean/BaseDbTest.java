package com.gst.base.ejb.bean;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViews;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.junit5.DBUnitExtension;
import com.github.database.rider.junit5.util.EntityManagerProvider;
import com.gst.base.ejb.singleton.BaseEntityViewConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.persistence.EntityManager;

@ExtendWith({DBUnitExtension.class})
public abstract class BaseDbTest {
    protected static final String PU_NAME = "base-pu";
    private ConnectionHolder connectionHolder = () ->
            EntityManagerProvider.instance(PU_NAME).clear().connection();

    private AutoCloseable mockitoInstance;
    @Spy
    protected EntityManager entityManager = EntityManagerProvider.em(PU_NAME);
    @Spy
    protected CriteriaBuilderFactory criteriaBuilderFactory;
    @Spy
    protected EntityViewManager evm;

    @BeforeEach
    public void openMocks() {
        mockitoInstance = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        mockitoInstance.close();
    }

    @BeforeEach
    public void setupBlazePersistence() {
        EntityViewConfiguration cfg = EntityViews.createDefaultConfiguration();
        BaseEntityViewConfiguration.addAllEntityView(cfg);
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        criteriaBuilderFactory = config.createCriteriaBuilderFactory(entityManager.getEntityManagerFactory());
        evm = cfg.createEntityViewManager(criteriaBuilderFactory);
    }
}

package com.gst.base.remote.util;

public class BasePropertiesProvider {

    public static final String TEST_BASE_DOMAIN = "http://test.gst/";

    private final String baseProperty;

    private BasePropertiesProvider() {
        String baseDomainProperties = System.getProperty("base-domain");
        baseProperty = baseDomainProperties == null ? TEST_BASE_DOMAIN : baseDomainProperties;
    }

    public BasePropertiesProvider(
            String baseProperty) {
        this.baseProperty = baseProperty;
    }

    public static BasePropertiesProvider getInstance() {
        return SystemPropertiesProviderHolder.INSTANCE;
    }

    public String getBaseProperty() {
        return baseProperty;
    }

    private static class SystemPropertiesProviderHolder {
        private static final BasePropertiesProvider INSTANCE = new BasePropertiesProvider();
    }
}

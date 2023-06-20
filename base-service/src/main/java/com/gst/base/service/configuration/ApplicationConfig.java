package com.gst.base.service.configuration;

import com.gst.base.service.DemoService;
import com.gst.base.service.StaffService;
import com.gst.base.service.StudentSevice;
import com.gst.util.api.ThrowableExceptionMapper;
import com.gst.util.api.config.JsonObjectMapper;
import com.gst.util.api.filter.AuthenticationFilter;
import com.gst.util.api.filter.RequiredParameterFilter;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api")
@OpenAPIDefinition(
        security = @SecurityRequirement(name = "Authorization"),
        servers = @Server(url = "http://188.166.213.153:8082/base-service/"),
        info = @Info(
                version = "1.0-SNAPSHOT",
                title = "Base app Api Documentation",
                description = "This is instructions for use when working with base web's api",
                contact = @Contact(email = "gst@gmail.com")
        )
)
@SecurityScheme(type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer",
        in = SecuritySchemeIn.HEADER, name = "Authorization")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(RequestScopedBean.class);
        resources.add(ThrowableExceptionMapper.class);
        resources.add(OpenApiResource.class);
        resources.add(JsonObjectMapper.class);
        resources.add(AuthenticationFilter.class);
        resources.add(RequiredParameterFilter.class);
        resources.add(DemoService.class);
        resources.add(StudentSevice.class);
        resources.add(StaffService.class);



    }

}

package com.gst.base.service;

import com.gst.base.remote.entity.DemoEntity;
import com.gst.base.remote.service.DemoBeanRemote;
import com.gst.base.service.viewable.mapper.DemoMapper;
import com.gst.base.service.viewable.mapper.DemoViewable;
import com.gst.util.api.util.Encoding;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("demo")
public class DemoService {
    @Inject
    private DemoBeanRemote demoBeanRemote;

    @Path("haha")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    public DemoViewable findByName(@QueryParam("name") String name) {
        DemoEntity demoEntity = demoBeanRemote.findByName(name);
        return DemoMapper.INSTANCE.demoToViewable(demoEntity);
    }


}

package com.gst.base.service.viewable.mapper;

import com.gst.base.remote.entity.DemoEntity;
import com.gst.util.api.mapper.BaseMapper;
import com.gst.util.api.mapper.MapperCentralConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperCentralConfig.class)
public abstract class DemoMapper implements BaseMapper<DemoEntity, DemoViewable> {
    public static final DemoMapper INSTANCE = Mappers.getMapper(DemoMapper.class);

    @Mapping(source = "imageLink", target = "avatarLink", qualifiedByName = "filePath2ImageLink")
    public abstract DemoViewable demoToViewable(DemoEntity demoEntity);
}

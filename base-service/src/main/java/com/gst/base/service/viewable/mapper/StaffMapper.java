package com.gst.base.service.viewable.mapper;

import com.gst.base.remote.entity.Staff;
import com.gst.util.api.mapper.BaseMapper;
import com.gst.util.api.mapper.MapperCentralConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperCentralConfig.class)
public abstract class StaffMapper implements BaseMapper<Staff,StaffViewable> {
    public static final StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    public abstract StaffViewable staffToViewable(Staff staff);
}

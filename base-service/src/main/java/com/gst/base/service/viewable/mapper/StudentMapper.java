package com.gst.base.service.viewable.mapper;

import com.gst.base.remote.entity.Student;
import com.gst.util.api.mapper.BaseMapper;
import com.gst.util.api.mapper.MapperCentralConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperCentralConfig.class)
public abstract class StudentMapper implements BaseMapper<Student,StudentViewable> {
    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "image", target = "imageL", qualifiedByName = "filePath2ImageLink")
    public abstract StudentViewable studentToViewable(Student student);
}

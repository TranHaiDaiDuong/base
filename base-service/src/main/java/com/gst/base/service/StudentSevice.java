package com.gst.base.service;

import com.gst.base.remote.entity.Student;
import com.gst.base.remote.service.StudentBeanRemote;
import com.gst.base.service.util.Encoding;
import com.gst.base.service.viewable.mapper.StudentMapper;
import com.gst.base.service.viewable.mapper.StudentViewable;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javassist.NotFoundException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("student")
public class StudentSevice {
    @Inject
    private StudentBeanRemote studentBeanRemote;
    @Path("info")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "KHONG DUOC NULL")))
    public List<StudentViewable> findBySex(@QueryParam("sex") String sex)  {
        List<Student> studentList = studentBeanRemote.findBySex(sex);
        if(studentList == null){
            throw new com.gst.exception.predefined.http.NotFoundException("KHONG DUOC NULL");
        }else {
            return StudentMapper.INSTANCE.convertListObject(studentList);
        }
    }

    @Path("/{id}/info")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "KHONG DUOC NULL")))
    public StudentViewable findById(@PathParam("id")Integer id) throws NotFoundException {
        Student student = studentBeanRemote.findById(id);
        if(student == null){
            throw new com.gst.exception.predefined.http.NotFoundException("KHONG DUOC NULL");
        } else {
            return StudentMapper.INSTANCE.studentToViewable(student);
        }
    }

    @Path("all-info")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Not existed team")))
    public List<StudentViewable> findByAll()  {
        List<Student> studentList = studentBeanRemote.findByAll();
        if(studentList == null){
            throw new com.gst.exception.predefined.http.NotFoundException("KHONG DUOC NULL");
        }else {
            return StudentMapper.INSTANCE.convertListObject(studentList);
        }
    }


}

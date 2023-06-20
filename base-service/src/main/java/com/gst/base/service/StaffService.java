package com.gst.base.service;

import com.gst.base.remote.entity.Staff;
import com.gst.base.remote.service.StaffBeanRemote;
import com.gst.base.service.util.Encoding;
import com.gst.base.service.viewable.mapper.StaffMapper;
import com.gst.base.service.viewable.mapper.StaffViewable;
import com.gst.exception.predefined.http.NotFoundException;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("staff")
public class StaffService {

    @Inject
    private StaffBeanRemote staffBeanRemote;


    @Path("info-phone")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Staff not exists")))
    public StaffViewable findByPhoneNumber(@QueryParam("phoneNumber") String phoneNumber) {
        Staff staff = staffBeanRemote.findByPhoneNumber(phoneNumber);
        if (staff == null) {
            throw new NotFoundException("Staff not exists");
        } else {
            return StaffMapper.INSTANCE.staffToViewable(staff);
        }
    }

    @Path("get-all")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Staff not exists")))
    public List<StaffViewable> findByAll() {
        List<Staff> staffList = staffBeanRemote.findAllStaff();
        if (staffList == null) {
            throw new com.gst.exception.predefined.http.NotFoundException("Staff not exists");
        } else {
            return StaffMapper.INSTANCE.convertListObject(staffList);
        }
    }

    @Path("/{id}/get-staff")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Staff not exists")))
    public List<StaffViewable> findByStaffId(@PathParam("id") Integer staffId) {
        List<Staff> listStaff = staffBeanRemote.findByStaffId(staffId);
        if (listStaff == null) {
            throw new NotFoundException("Staff not exists");
        } else {
            return StaffMapper.INSTANCE.convertListObject(listStaff);
        }
    }


    @Path("/{id}/get-team")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Not existed staff")))
    public List<StaffViewable> findByTeamId(@PathParam("id") Integer teamId) {
        List<Staff> listStaff = staffBeanRemote.findByTeamId(teamId);
        if (listStaff == null) {
            throw new NotFoundException("Not existed staff");
        } else {
            return StaffMapper.INSTANCE.convertListObject(listStaff);
        }
    }

    @Path("/{id}/get-team-age")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Not existed staff")))
    public List<StaffViewable> findByTeamIdAge(@PathParam("id") Integer teamId) {
        List<Staff> listStaff = staffBeanRemote.findByTeamIdAge(teamId);
        if (listStaff == null) {
            throw new NotFoundException("Not existed staff");
        } else {
            return StaffMapper.INSTANCE.convertListObject(listStaff);
        }
    }

    @Path("/get-name-staff")
    @GET
    @Produces(Encoding.CHARSET_UTF8)
    @ApiResponse(responseCode = "200",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StaffViewable.class))))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(example = "Not existed name")))
    public List<StaffViewable> findByName(@QueryParam("name") String name) {
        List<Staff> listStaff = staffBeanRemote.findByName(name);
        if (listStaff == null) {
            throw new NotFoundException("Not existed name");
        } else {
            return StaffMapper.INSTANCE.convertListObject(listStaff);
        }
    }}

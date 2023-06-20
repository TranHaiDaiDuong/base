package com.gst.base.ejb.data;

import com.github.database.rider.core.dataset.builder.ColumnBuilder;
import com.gst.base.remote.entity.Staff;
import com.gst.util.test.data.DataProvider;
import com.gst.util.test.data.DataUtil;
import com.gst.util.test.data.IdGenerator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gst.base.ejb.data.TeamDataProvider.TEAM_5;
import static com.gst.base.ejb.data.TeamDataProvider.TEAM_6;

public class StaffDataProvider extends DataProvider<Staff> {
    public static final StaffDataProvider DEFAULT_INSTANCE = new StaffDataProvider();
    public static final Staff STAFF_1 = Staff.builder().id(IdGenerator.getNextValueInt()).name("Duong")
            .birthDay(LocalDateTime.of(2001, 1, 1, 6, 7, 8))
            .phoneNumber("0869023080").email("d@gmail.com").team(TEAM_5).position(Staff.POSITION_LEADER)
            .imagePath("u01/base/buituan.jpg").build();

    public static final Staff STAFF_2 = Staff.builder().id(IdGenerator.getNextValueInt()).name("Cường")
            .birthDay(LocalDateTime.of(2001, 2, 2, 2, 03, 40))
            .phoneNumber("0869023080").email("c@gmail.com").team(TEAM_5).position(Staff.POSITION_STAFF)
            .imagePath("u02/base/c.jpg").build();

    public static final Staff STAFF_3 = Staff.builder().id(IdGenerator.getNextValueInt()).name("minh")
            .birthDay(LocalDateTime.of(2001, 3, 7, 6, 0, 0))
            .phoneNumber("0869023080").email("m@gmail.com").team(TEAM_6).position(Staff.POSITION_STAFF)
            .imagePath("u02/base/m.jpg").build();

    @Override
    protected Staff[] getData() {
        return new Staff[]{STAFF_1, STAFF_2, STAFF_3};
    }

    @Override
    protected String getTableName() {
        return "STAFF";
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"ID", "NAME", "BIRTH_DAY", "PHONE_NUMBER", "EMAIL", "IMAGE_PATH", "DATE_CREATED", "TEAM_ID"
                , "POSITION"};
    }

    @Override
    protected void addRow(ColumnBuilder columnBuilder, Staff staff) {
        columnBuilder.values(staff.getId(), staff.getName(), DataUtil.dateTime2String(staff.getBirthDay())
                , staff.getPhoneNumber(), staff.getEmail(), staff.getImagePath()
                , DataUtil.dateTime2String(staff.getDateCreated()), staff.getTeam().getId(), staff.getPosition());
    }

    @Override
    protected List<DataProvider> getDirectedDependencies() {
        return Arrays.asList(TeamDataProvider.DEFAULT_INSTANCE);
    }
}

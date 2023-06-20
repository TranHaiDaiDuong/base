package com.gst.base.ejb.bean;


import com.github.database.rider.core.api.dataset.DataSet;
import com.gst.base.ejb.data.BasicDataProvider;
import com.gst.base.remote.entity.Staff;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.gst.base.ejb.data.StaffDataProvider.STAFF_1;
import static com.gst.base.ejb.data.StaffDataProvider.STAFF_2;
import static com.gst.base.ejb.data.TeamDataProvider.TEAM_5;

@DataSet(provider = BasicDataProvider.class)

public class StaffBeanTest extends BaseDbTest {
    @Spy
    @InjectMocks
    private StaffBean staffBean;

    @Test
    void testFindByPhoneNumber_PhoneNumberValid_ShouldReturnStaff() {
        Staff actualResult = staffBean.findByPhoneNumber(STAFF_1.getPhoneNumber());

        Assertions.assertThat(actualResult).isEqualTo(STAFF_1);
    }
    @Test
    void testFindByPhoneNumber_InvalidPhoneNumber_ShouldReturnNull() {
        String invalidPhoneNumber = "2222";
        Staff actualResult = staffBean.findByPhoneNumber(invalidPhoneNumber);

        Assertions.assertThat(actualResult).isNull();
    }
    @Test
    void testFindByTeamId_TeamIdInValid_ShouldReturnListEmpty() {
        Integer inValidId = 2;
        List<Staff> actualResult = staffBean.findByTeamId(inValidId);

        Assertions.assertThat(actualResult).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindByTeamId_TeamIdValid_ShouldReturnListStaff() {
        List<Staff> actualResult = staffBean.findByTeamId(TEAM_5.getId());

        Assertions.assertThat(actualResult).isEqualTo(Arrays.asList(STAFF_1, STAFF_2));
    }

}

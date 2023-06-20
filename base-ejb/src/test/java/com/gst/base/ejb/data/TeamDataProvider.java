package com.gst.base.ejb.data;

import com.github.database.rider.core.dataset.builder.ColumnBuilder;
import com.gst.base.remote.entity.Team;
import com.gst.util.test.data.DataProvider;
import com.gst.util.test.data.DataUtil;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class TeamDataProvider extends DataProvider<Team> {
    public static final TeamDataProvider DEFAULT_INSTANCE = new TeamDataProvider();

    public static final Team TEAM_5 = Team.builder().id(1).name("Siêu Cấp").dateCreated(LocalDateTime.now()).build();

    public static final Team TEAM_6 = Team.builder().id(2).name("Siêu Cấp 2").dateCreated(LocalDateTime.now()).build();

    @Override
    protected Team[] getData() {
        return new Team[]{TEAM_5, TEAM_6};
    }

    @Override
    protected String getTableName() {
        return "TEAM";
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"ID", "NAME", "DATE_CREATED"};
    }

    @Override
    protected void addRow(ColumnBuilder columnBuilder, Team team) {
        columnBuilder.values(team.getId(), team.getName(), DataUtil.dateTime2String(team.getDateCreated()));
    }

    @Override
    protected List<DataProvider> getDirectedDependencies() {
        return Collections.emptyList();
    }
}

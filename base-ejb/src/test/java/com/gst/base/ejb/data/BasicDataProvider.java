package com.gst.base.ejb.data;

import com.github.database.rider.core.dataset.builder.ColumnBuilder;
import com.gst.util.test.data.DataProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicDataProvider extends DataProvider<Void> {

    @Override
    protected Void[] getData() {
        return new Void[0];
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected String[] getColumns() {
        return new String[0];
    }

    @Override
    protected void addRow(ColumnBuilder columnBuilder, Void unused) {

    }

    @Override
    protected List<DataProvider> getDirectedDependencies() {
        return Collections.emptyList();
    }
}

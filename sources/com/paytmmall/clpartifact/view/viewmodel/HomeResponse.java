package com.paytmmall.clpartifact.view.viewmodel;

import com.google.gson.a.c;
import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.utils.HomeUtils;

public final class HomeResponse extends CLPResponse {
    @c(a = "context")
    private UserContext context;
    private int dataSource = HomeUtils.INSTANCE.getDATA_SOURCE_UNKNOWN();

    public final UserContext getContext() {
        return this.context;
    }

    public final void setContext(UserContext userContext) {
        this.context = userContext;
    }

    public final int getDataSource() {
        return this.dataSource;
    }

    public final void setDataSource(int i2) {
        this.dataSource = i2;
    }
}

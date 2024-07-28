package com.business.merchant_payments.model.orderSummaryList;

import com.business.merchant_payments.model.primary.ResultInfo;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public final class DaywiseSummaryListModel {
    @c(a = "daywiseOrderList")
    @a
    public List<DaywiseOrderList> daywiseOrderList;
    @c(a = "hasMoreRecords")
    @a
    public Boolean hasMoreRecords = Boolean.FALSE;
    @c(a = "nextPageNumber")
    @a
    public Integer nextPageNumber;
    @c(a = "resultInfo")
    @a
    public ResultInfo resultInfo;

    public final Integer getNextPageNumber() {
        return this.nextPageNumber;
    }

    public final void setNextPageNumber(Integer num) {
        this.nextPageNumber = num;
    }

    public final Boolean getHasMoreRecords() {
        return this.hasMoreRecords;
    }

    public final void setHasMoreRecords(Boolean bool) {
        this.hasMoreRecords = bool;
    }

    public final List<DaywiseOrderList> getDaywiseOrderList() {
        return this.daywiseOrderList;
    }

    public final void setDaywiseOrderList(List<DaywiseOrderList> list) {
        this.daywiseOrderList = list;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }
}

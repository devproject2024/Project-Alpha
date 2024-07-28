package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRBusHolidayList extends IJRPaytmDataModel {
    @b(a = "body")
    private List<CJRBusHoliday> holidayList = null;
    @b(a = "status")
    private CJRPNRStatus mStatus;

    public CJRPNRStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(CJRPNRStatus cJRPNRStatus) {
        this.mStatus = cJRPNRStatus;
    }

    public ArrayList<CJRBusHoliday> getHolidayList() {
        return (ArrayList) this.holidayList;
    }

    public void setHolidayList(ArrayList<CJRBusHoliday> arrayList) {
        this.holidayList = arrayList;
    }
}

package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainHolidayList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private List<CJRTrainHoliday> holidayList = null;
    @b(a = "status")
    private CJRPNRStatus mStatus;

    public CJRPNRStatus getStatus() {
        return this.mStatus;
    }

    public ArrayList<CJRTrainHoliday> getHolidayList() {
        return (ArrayList) this.holidayList;
    }
}

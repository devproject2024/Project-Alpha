package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRBusInsurancePlans extends IJRPaytmDataModel {
    @b(a = "code")
    private int code;
    @b(a = "data")
    private List<CJRBusInsuranceItem> insuranceItems;
    @b(a = "status")
    private String status;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public List<CJRBusInsuranceItem> getInsuranceItems() {
        return this.insuranceItems;
    }

    public void setInsuranceItems(List<CJRBusInsuranceItem> list) {
        this.insuranceItems = list;
    }

    public int getPlansCount() {
        List<CJRBusInsuranceItem> list = this.insuranceItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public CJRBusInsuranceItem getInsuranceAtIndex(int i2) {
        if (i2 < getPlansCount()) {
            return this.insuranceItems.get(i2);
        }
        return null;
    }
}

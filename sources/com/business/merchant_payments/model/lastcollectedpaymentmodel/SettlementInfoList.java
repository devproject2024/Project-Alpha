package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import java.io.Serializable;
import java.util.ArrayList;

public class SettlementInfoList implements Serializable {
    public String settlementTime;
    public ArrayList<String> utrNoList;

    public String getSettlementTime() {
        return this.settlementTime;
    }

    public void setSettlementTime(String str) {
        this.settlementTime = str;
    }

    public ArrayList<String> getUtrNoList() {
        return this.utrNoList;
    }

    public void setUtrNoList(ArrayList<String> arrayList) {
        this.utrNoList = arrayList;
    }
}

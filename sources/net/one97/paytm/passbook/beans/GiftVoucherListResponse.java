package net.one97.paytm.passbook.beans;

import java.util.ArrayList;

public class GiftVoucherListResponse {
    private String status;
    private ArrayList<SubwalletStatusResponseList> subwalletStatusResponseList;

    public ArrayList<SubwalletStatusResponseList> getSubwalletStatusResponseList() {
        return this.subwalletStatusResponseList;
    }

    public void setSubwalletStatusResponseList(ArrayList<SubwalletStatusResponseList> arrayList) {
        this.subwalletStatusResponseList = arrayList;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "ClassPojo [subwalletStatusResponseList = " + this.subwalletStatusResponseList + ", status = " + this.status + "]";
    }
}

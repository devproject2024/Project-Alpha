package net.one97.paytm.passbook.spendanalytics.model;

import java.io.Serializable;

public final class a implements Serializable {
    public String cnt;
    public String payeeID;
    public String selectedMonth;
    public String storeLogo;
    public String storeName;
    public String sum;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cnt = str;
        this.payeeID = str2;
        this.storeLogo = str3;
        this.storeName = str4;
        this.sum = str5;
        this.selectedMonth = str6;
    }
}

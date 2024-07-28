package net.one97.paytm.nativesdk.instruments.upicollect.models;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class ExtendInfo implements BaseDataModel {
    private String comments;
    private String mercUnqRef;
    private String payerPSPApp;
    private String sdkType;
    private String udf1;
    private String udf2;
    private String udf3;

    public String getPayerPSPApp() {
        return this.payerPSPApp;
    }

    public void setPayerPSPApp(String str) {
        this.payerPSPApp = str;
    }

    public String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public String getUdf1() {
        return this.udf1;
    }

    public void setUdf1(String str) {
        this.udf1 = str;
    }

    public String getUdf2() {
        return this.udf2;
    }

    public void setUdf2(String str) {
        this.udf2 = str;
    }

    public String getUdf3() {
        return this.udf3;
    }

    public void setUdf3(String str) {
        this.udf3 = str;
    }

    public String getSdkType() {
        return this.sdkType;
    }

    public void setSdkType(String str) {
        this.sdkType = str;
    }
}

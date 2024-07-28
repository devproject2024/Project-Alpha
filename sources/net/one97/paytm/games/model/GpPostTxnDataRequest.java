package net.one97.paytm.games.model;

import com.google.gson.a.c;
import java.util.ArrayList;

public class GpPostTxnDataRequest {
    @c(a = "checksumhash")
    private String checksumhash;
    @c(a = "flag")
    private String flag;
    @c(a = "items")
    private ArrayList<GpTxnDatum> items;
    @c(a = "package_name")
    private String package_name;
    @c(a = "responseCode")
    private int responseCode;
    @c(a = "responseMessage")
    private String responseMessage;

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setPackageName(String str) {
        this.package_name = str;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public void setChecksumhash(String str) {
        this.checksumhash = str;
    }

    public void setItems(ArrayList<GpTxnDatum> arrayList) {
        this.items = arrayList;
    }
}

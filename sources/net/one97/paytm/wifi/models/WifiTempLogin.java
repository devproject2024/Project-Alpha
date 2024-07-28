package net.one97.paytm.wifi.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class WifiTempLogin extends IJRPaytmDataModel {
    @b(a = "ga_ap_mac")
    private String gaApMac;
    @b(a = "ga_cmac")
    private String gaCmac;
    @b(a = "ga_nas_id")
    private String gaNasId;
    @b(a = "ga_pass")
    private String gaPass;
    @b(a = "ga_Qv")
    private String gaQv;
    @b(a = "ga_srvr")
    private String gaSrvr;
    @b(a = "ga_user")
    private String gaUser;
    @b(a = "c_timeout")
    private String mCTimeout;
    @b(a = "ga_error_code")
    private String mGaErorCode;
    @b(a = "ga_orig_url")
    private String mGaOrigUrl;

    public final String getGaUser() {
        return this.gaUser;
    }

    public final void setGaUser(String str) {
        this.gaUser = str;
    }

    public final String getGaPass() {
        return this.gaPass;
    }

    public final void setGaPass(String str) {
        this.gaPass = str;
    }

    public final String getGaApMac() {
        return this.gaApMac;
    }

    public final String getGaNasId() {
        return this.gaNasId;
    }

    public final String getGaSrvr() {
        return this.gaSrvr;
    }

    public final String getGaCmac() {
        return this.gaCmac;
    }

    public final String getGaQv() {
        return this.gaQv;
    }

    public final void setmGaApMac(String str) {
        k.c(str, "gaApMac");
        this.gaApMac = str;
    }

    public final void setmGaNasId(String str) {
        k.c(str, "gaNasId");
        this.gaNasId = str;
    }

    public final void setmGaSrvr(String str) {
        k.c(str, "gaSrvr");
        this.gaSrvr = str;
    }

    public final void setmGaCmac(String str) {
        k.c(str, "gaCmac");
        this.gaCmac = str;
    }

    public final void setmGaOrigUrl(String str) {
        k.c(str, "gaOrigUrl");
        this.mGaOrigUrl = str;
    }

    public final void setmGaQv(String str) {
        k.c(str, "gaQv");
        this.gaQv = str;
    }

    public final void setmCTimeout(String str) {
        k.c(str, "cTimeout");
        this.mCTimeout = str;
    }

    public final void setmGaErorCode(String str) {
        k.c(str, "gaErorCode");
        this.mGaErorCode = str;
    }
}

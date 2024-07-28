package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class Body {
    @c(a = "resultInfo")
    @a
    private ResultInfo resultInfo;
    @c(a = "sarvatraUserProfile")
    @a
    private SarvatraUserProfile sarvatraUserProfile;
    @c(a = "sarvatraVpa")
    @a
    private List<String> sarvatraVpa = null;

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public List<String> getSarvatraVpa() {
        return this.sarvatraVpa;
    }

    public void setSarvatraVpa(List<String> list) {
        this.sarvatraVpa = list;
    }

    public SarvatraUserProfile getSarvatraUserProfile() {
        return this.sarvatraUserProfile;
    }

    public void setSarvatraUserProfile(SarvatraUserProfile sarvatraUserProfile2) {
        this.sarvatraUserProfile = sarvatraUserProfile2;
    }
}

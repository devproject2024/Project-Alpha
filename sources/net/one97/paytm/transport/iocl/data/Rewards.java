package net.one97.paytm.transport.iocl.data;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class Rewards implements IJRDataModel {
    private String otp;
    @b(a = "points")
    private Long points;
    @b(a = "updatedTime")
    private Long updatedTime;

    public Long getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Long l) {
        this.updatedTime = l;
    }

    public Long getPoints() {
        return this.points;
    }

    public void setPoints(Long l) {
        this.points = l;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String str) {
        this.otp = str;
    }
}

package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRDeviceBindingInfoV2 implements IJRDataModel {
    @b(a = "deviceBindingMethod")
    private String deviceBindingMethod;
    @b(a = "deviceBindingTime")
    private long deviceBindingTime;
    @b(a = "deviceId")
    private String deviceId;
    @b(a = "deviceModel")
    private String deviceModel;
    @b(a = "deviceOsVersion")
    private String deviceOsVersion;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    public String getDeviceBindingMethod() {
        return this.deviceBindingMethod;
    }

    public long getDeviceBindingTime() {
        return this.deviceBindingTime;
    }
}

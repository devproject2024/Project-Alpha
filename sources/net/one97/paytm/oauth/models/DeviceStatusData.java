package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DeviceStatusData extends IJRPaytmDataModel {
    @c(a = "deviceBindingStatus")
    private final String deviceBindingStatus;

    public final String getDeviceBindingStatus() {
        return this.deviceBindingStatus;
    }
}

package net.one97.paytm.common.entity.passcode;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class DeviceDetailPreference extends IJRPaytmDataModel implements IJRDataModel {
    private String DEVICE_PASSCODE_VERIFIED;
    private String language;
    private String networkOtp;

    public final String getNetworkOtp() {
        return this.networkOtp;
    }

    public final void setNetworkOtp(String str) {
        this.networkOtp = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getDEVICE_PASSCODE_VERIFIED() {
        return this.DEVICE_PASSCODE_VERIFIED;
    }

    public final void setDEVICE_PASSCODE_VERIFIED(String str) {
        this.DEVICE_PASSCODE_VERIFIED = str;
    }
}

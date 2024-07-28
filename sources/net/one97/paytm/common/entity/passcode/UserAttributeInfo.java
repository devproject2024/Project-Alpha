package net.one97.paytm.common.entity.passcode;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class UserAttributeInfo extends IJRPaytmDataModel implements IJRDataModel {
    private String DEVICE_PASSCODE_VERIFIED;

    public final String getDEVICE_PASSCODE_VERIFIED() {
        return this.DEVICE_PASSCODE_VERIFIED;
    }

    public final void setDEVICE_PASSCODE_VERIFIED(String str) {
        this.DEVICE_PASSCODE_VERIFIED = str;
    }
}

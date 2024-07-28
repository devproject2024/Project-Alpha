package net.one97.paytm.common.entity.passcode;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class DeviceAuthAttribute extends IJRPaytmDataModel implements IJRDataModel {
    private UserAttributeInfo userAttributeInfo;

    public final UserAttributeInfo getUserAttributeInfo() {
        return this.userAttributeInfo;
    }

    public final void setUserAttributeInfo(UserAttributeInfo userAttributeInfo2) {
        this.userAttributeInfo = userAttributeInfo2;
    }
}

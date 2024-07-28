package com.paytm.business.merchantprofile.model;

import com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork;
import net.one97.paytm.upi.util.UpiConstants;

public enum GSTINLeadStatus {
    AWAITING_CLOSE(ReactivationStatusNetwork.AWAITING_CLOSE),
    LEAD_NOT_PRESENT(ReactivationStatusNetwork.LEAD_NOT_PRESENT),
    LEAD_CLOSED(ReactivationStatusNetwork.LEAD_CLOSED),
    BLOCK(UpiConstants.BANK_HEALTH_STATUS_BLOCK);
    
    public final String value;

    /* access modifiers changed from: public */
    GSTINLeadStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

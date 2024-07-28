package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRError;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeConfigurationV2 implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private CJRError mError;
    @b(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }
}

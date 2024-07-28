package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventGetPolicyResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cp_enabled")
    private int cpEnable;
    @b(a = "details")
    private CJREventCancellationProtectDetail detail;

    public int getCpEnable() {
        return this.cpEnable;
    }

    public CJREventCancellationProtectDetail getDetail() {
        return this.detail;
    }
}

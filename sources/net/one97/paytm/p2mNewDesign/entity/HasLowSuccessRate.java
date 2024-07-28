package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class HasLowSuccessRate extends CJRWalletDataModel implements IJRDataModel {
    private String msg;
    private boolean status;

    public String getMsg() {
        return this.msg;
    }

    public boolean getStatus() {
        return this.status;
    }
}

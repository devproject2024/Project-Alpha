package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBBlockUnblockCardResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cardAlias")
    private String mCardAlias;
    @b(a = "errorMessage")
    private String mErrorMessage;
    @b(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public String getCardAlias() {
        return this.mCardAlias;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }
}

package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CJRStatus;

public class CJRFlightOffer extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String mError;
    @b(a = "body")
    private CJROffers mOffers;
    @b(a = "status")
    private CJRStatus mStatus;

    public String getmError() {
        return this.mError;
    }

    public void setmError(String str) {
        this.mError = str;
    }

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(CJRStatus cJRStatus) {
        this.mStatus = cJRStatus;
    }

    public CJROffers getmOffers() {
        return this.mOffers;
    }

    public void setmOffers(CJROffers cJROffers) {
        this.mOffers = cJROffers;
    }
}

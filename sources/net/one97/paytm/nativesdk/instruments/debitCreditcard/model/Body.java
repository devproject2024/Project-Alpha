package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.ResultInfo;

public class Body {
    @c(a = "emiDetail")
    @a
    private EmiDetail emiDetail;
    @c(a = "promoCodeDetail")
    @a
    private PromoCodeDetail promoCodeDetail;
    @c(a = "resultInfo")
    @a
    private ResultInfo resultInfo;

    public PromoCodeDetail getPromoCodeDetail() {
        return this.promoCodeDetail;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public EmiDetail getEmiDetail() {
        return this.emiDetail;
    }

    public void setEmiDetail(EmiDetail emiDetail2) {
        this.emiDetail = emiDetail2;
    }
}

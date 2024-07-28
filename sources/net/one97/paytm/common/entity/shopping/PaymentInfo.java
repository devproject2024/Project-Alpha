package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class PaymentInfo extends IJRPaytmDataModel {
    @b(a = "custId")
    private Integer custId;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "message")
    private String message;
    @b(a = "mid")
    private String mid;
    @b(a = "native_withdraw")
    private Integer nativeWithdraw;
    @b(a = "paytmSsoToken")
    private String paytmSsoToken;
    @b(a = "promoCode")
    private String promoCode;
    @b(a = "status")
    private String status;
    @b(a = "subwalletAmount")
    private String subwalletAmount;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getHitPG() {
        return this.hitPG;
    }

    public void setHitPG(String str) {
        this.hitPG = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public Integer getCustId() {
        return this.custId;
    }

    public void setCustId(Integer num) {
        this.custId = num;
    }

    public String getPaytmSsoToken() {
        return this.paytmSsoToken;
    }

    public void setPaytmSsoToken(String str) {
        this.paytmSsoToken = str;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public String getSubwalletAmount() {
        return this.subwalletAmount;
    }

    public void setSubwalletAmount(String str) {
        this.subwalletAmount = str;
    }

    public Integer getNativeWithdraw() {
        return this.nativeWithdraw;
    }

    public void setNativeWithdraw(Integer num) {
        this.nativeWithdraw = num;
    }
}

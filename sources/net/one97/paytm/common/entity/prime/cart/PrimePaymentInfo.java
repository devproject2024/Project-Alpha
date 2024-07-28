package net.one97.paytm.common.entity.prime.cart;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PrimePaymentInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "native")
    private Boolean _native;
    @b(a = "callbackUrl")
    private String callbackUrl;
    @b(a = "disablePaymentMode")
    private List<DisablePaymentMode> disablePaymentMode = null;
    @b(a = "enablePaymentMode")
    private List<Object> enablePaymentMode = null;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "message")
    private String message;
    @b(a = "mid")
    private String mid;
    @b(a = "native_withdraw")
    private String nativeWithdraw;
    @b(a = "payableAmount")
    private PayableAmount payableAmount;
    @b(a = "pgUrlToHit")
    private String pgUrlToHit;
    @b(a = "promoCode")
    private String promoCode;
    @b(a = "requestType")
    private String requestType;
    @b(a = "shippingInfo")
    private List<Object> shippingInfo = null;
    @b(a = "status")
    private String status;
    @b(a = "subwalletAmount")
    private String subwalletAmount;
    @b(a = "txnAmount")
    private TxnAmount txnAmount;
    @b(a = "websiteName")
    private String websiteName;

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

    public Boolean getNative() {
        return this._native;
    }

    public void setNative(Boolean bool) {
        this._native = bool;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public TxnAmount getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(TxnAmount txnAmount2) {
        this.txnAmount = txnAmount2;
    }

    public String getWebsiteName() {
        return this.websiteName;
    }

    public void setWebsiteName(String str) {
        this.websiteName = str;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public PayableAmount getPayableAmount() {
        return this.payableAmount;
    }

    public void setPayableAmount(PayableAmount payableAmount2) {
        this.payableAmount = payableAmount2;
    }

    public String getSubwalletAmount() {
        return this.subwalletAmount;
    }

    public void setSubwalletAmount(String str) {
        this.subwalletAmount = str;
    }

    public List<Object> getShippingInfo() {
        return this.shippingInfo;
    }

    public void setShippingInfo(List<Object> list) {
        this.shippingInfo = list;
    }

    public List<Object> getEnablePaymentMode() {
        return this.enablePaymentMode;
    }

    public void setEnablePaymentMode(List<Object> list) {
        this.enablePaymentMode = list;
    }

    public List<DisablePaymentMode> getDisablePaymentMode() {
        return this.disablePaymentMode;
    }

    public void setDisablePaymentMode(List<DisablePaymentMode> list) {
        this.disablePaymentMode = list;
    }

    public String getNativeWithdraw() {
        return this.nativeWithdraw;
    }

    public void setNativeWithdraw(String str) {
        this.nativeWithdraw = str;
    }

    public String getPgUrlToHit() {
        return this.pgUrlToHit;
    }

    public void setPgUrlToHit(String str) {
        this.pgUrlToHit = str;
    }

    public class PayableAmount {
        @b(a = "currency")
        private String currency;
        @b(a = "value")
        private Integer value;

        public PayableAmount() {
        }

        public Integer getValue() {
            return this.value;
        }

        public void setValue(Integer num) {
            this.value = num;
        }

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }
    }

    public class TxnAmount {
        @b(a = "currency")
        private String currency;
        @b(a = "value")
        private Integer value;

        public TxnAmount() {
        }

        public Integer getValue() {
            return this.value;
        }

        public void setValue(Integer num) {
            this.value = num;
        }

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }
    }

    public class Price {
        @b(a = "currency")
        private String currency;
        @b(a = "value")
        private Integer value;

        public Price() {
        }

        public Integer getValue() {
            return this.value;
        }

        public void setValue(Integer num) {
            this.value = num;
        }

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }
    }

    public class DisablePaymentMode {
        @b(a = "channels")
        private List<Object> channels = null;
        @b(a = "mode")
        private String mode;

        public DisablePaymentMode() {
        }

        public String getMode() {
            return this.mode;
        }

        public void setMode(String str) {
            this.mode = str;
        }

        public List<Object> getChannels() {
            return this.channels;
        }

        public void setChannels(List<Object> list) {
            this.channels = list;
        }
    }
}

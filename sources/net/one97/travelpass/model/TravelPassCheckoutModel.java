package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.g;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class TravelPassCheckoutModel extends IJRPaytmDataModel {
    @b(a = "body")
    private CartBody body;
    @b(a = "code")
    private int code;
    @b(a = "error")
    private String error;
    @b(a = "extra")
    private CartExtra extra;
    @b(a = "message")
    private String message;

    public static final class CartExtra extends IJRPaytmDataModel {
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final CartBody getBody() {
        return this.body;
    }

    public final void setBody(CartBody cartBody) {
        this.body = cartBody;
    }

    public final CartExtra getExtra() {
        return this.extra;
    }

    public final void setExtra(CartExtra cartExtra) {
        this.extra = cartExtra;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final CJRError getErrorMessage() {
        CartBody cartBody = this.body;
        String str = null;
        if (!p.a(cartBody != null ? cartBody.getStatus() : null, SDKConstants.GA_NATIVE_FAILED, true)) {
            return null;
        }
        CJRError cJRError = new CJRError();
        CartBody cartBody2 = this.body;
        if (cartBody2 != null) {
            str = cartBody2.getMessage();
        }
        cJRError.setMessage(str);
        return cJRError;
    }

    public final HashMap<String, String> getPGParams() {
        new HashMap();
        f a2 = new g().a();
        CartBody cartBody = this.body;
        String a3 = a2.a((Object) cartBody != null ? cartBody.getResp() : null);
        HashMap<String, String> hashMap = new HashMap<>();
        Object a4 = new f().a(a3, HashMap.class);
        if (!(a4 instanceof HashMap)) {
            a4 = null;
        }
        Map map = (HashMap) a4;
        if (!(map == null || map.isEmpty())) {
            for (Map.Entry entry : map.entrySet()) {
                hashMap.put((String) entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    public static final class CartBody extends IJRPaytmDataModel {
        @b(a = "Status")
        private String Status = "";
        @b(a = "error")
        private String error = "";
        @b(a = "message")
        private String message = "";
        @b(a = "resp")
        private CartResponse resp;

        public final String getStatus() {
            return this.Status;
        }

        public final void setStatus(String str) {
            this.Status = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final String getError() {
            return this.error;
        }

        public final void setError(String str) {
            this.error = str;
        }

        public final CartResponse getResp() {
            return this.resp;
        }

        public final void setResp(CartResponse cartResponse) {
            this.resp = cartResponse;
        }
    }

    public static final class CartResponse extends IJRPaytmDataModel {
        @b(a = "MID")
        private String MID;
        @b(a = "AUTH_MODE")
        private String authMode;
        @b(a = "BANK_CODE")
        private String bankCode;
        @b(a = "CARD_TYPE")
        private String cardType;
        @b(a = "message")
        private String cartMessage;
        @b(a = "ORDER_ID")
        private long cartOrderId = -1;
        @b(a = "status")
        private String cartStatus;
        @b(a = "THEME")
        private String cartTheme;
        @b(a = "CHANNEL_ID")
        private String channelId;
        @b(a = "CHECKSUMHASH")
        private String checksumhash;
        @b(a = "CUST_ID")
        private long custId = -1;
        @b(a = "DEVICE_ID")
        private String deviceId;
        @b(a = "EMI_OPTIONS")
        private String emiOptions;
        @b(a = "hitPG")
        private String hitPG;
        @b(a = "INDUSTRY_TYPE_ID")
        private String industryTypeId;
        @b(a = "native_withdraw")
        private String nativeWithdraw;
        @b(a = "native_withdraw_details")
        private CartNativeWithdrawDetails nativeWithdrawDetails;
        @b(a = "PAYMENT_MODE_DISABLE")
        private String paymentModeDisable;
        @b(a = "PAYMENT_TYPE_ID")
        private String paymentTypeId;
        @b(a = "PAYTM_TOKEN")
        private String paytmToken;
        @b(a = "pgUrlToHit")
        private String pgUrlToHit;
        @b(a = "PROMO_CAMP_ID")
        private String promoCampId;
        @b(a = "SSO_TOKEN")
        private String ssoToken;
        @b(a = "subwalletAmount")
        private String subwalletAmount;
        @b(a = "TOKEN_TYPE")
        private String tokenType;
        @b(a = "TXN_AMOUNT")
        private Double txnAmount = Double.valueOf(-1.0d);
        @b(a = "WEBSITE")
        private String website;

        public final String getNativeWithdraw() {
            return this.nativeWithdraw;
        }

        public final void setNativeWithdraw(String str) {
            this.nativeWithdraw = str;
        }

        public final CartNativeWithdrawDetails getNativeWithdrawDetails() {
            return this.nativeWithdrawDetails;
        }

        public final void setNativeWithdrawDetails(CartNativeWithdrawDetails cartNativeWithdrawDetails) {
            this.nativeWithdrawDetails = cartNativeWithdrawDetails;
        }

        public final long getCartOrderId() {
            return this.cartOrderId;
        }

        public final void setCartOrderId(long j) {
            this.cartOrderId = j;
        }

        public final String getMID() {
            return this.MID;
        }

        public final void setMID(String str) {
            this.MID = str;
        }

        public final Double getTxnAmount() {
            return this.txnAmount;
        }

        public final void setTxnAmount(Double d2) {
            this.txnAmount = d2;
        }

        public final String getTokenType() {
            return this.tokenType;
        }

        public final void setTokenType(String str) {
            this.tokenType = str;
        }

        public final String getCartTheme() {
            return this.cartTheme;
        }

        public final void setCartTheme(String str) {
            this.cartTheme = str;
        }

        public final String getCartStatus() {
            return this.cartStatus;
        }

        public final void setCartStatus(String str) {
            this.cartStatus = str;
        }

        public final String getCartMessage() {
            return this.cartMessage;
        }

        public final void setCartMessage(String str) {
            this.cartMessage = str;
        }

        public final String getHitPG() {
            return this.hitPG;
        }

        public final void setHitPG(String str) {
            this.hitPG = str;
        }

        public final long getCustId() {
            return this.custId;
        }

        public final void setCustId(long j) {
            this.custId = j;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final void setChannelId(String str) {
            this.channelId = str;
        }

        public final String getWebsite() {
            return this.website;
        }

        public final void setWebsite(String str) {
            this.website = str;
        }

        public final String getPaymentModeDisable() {
            return this.paymentModeDisable;
        }

        public final void setPaymentModeDisable(String str) {
            this.paymentModeDisable = str;
        }

        public final String getChecksumhash() {
            return this.checksumhash;
        }

        public final void setChecksumhash(String str) {
            this.checksumhash = str;
        }

        public final String getSsoToken() {
            return this.ssoToken;
        }

        public final void setSsoToken(String str) {
            this.ssoToken = str;
        }

        public final String getPaytmToken() {
            return this.paytmToken;
        }

        public final void setPaytmToken(String str) {
            this.paytmToken = str;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final void setDeviceId(String str) {
            this.deviceId = str;
        }

        public final String getSubwalletAmount() {
            return this.subwalletAmount;
        }

        public final void setSubwalletAmount(String str) {
            this.subwalletAmount = str;
        }

        public final String getIndustryTypeId() {
            return this.industryTypeId;
        }

        public final void setIndustryTypeId(String str) {
            this.industryTypeId = str;
        }

        public final String getAuthMode() {
            return this.authMode;
        }

        public final void setAuthMode(String str) {
            this.authMode = str;
        }

        public final String getPaymentTypeId() {
            return this.paymentTypeId;
        }

        public final void setPaymentTypeId(String str) {
            this.paymentTypeId = str;
        }

        public final String getBankCode() {
            return this.bankCode;
        }

        public final void setBankCode(String str) {
            this.bankCode = str;
        }

        public final String getCardType() {
            return this.cardType;
        }

        public final void setCardType(String str) {
            this.cardType = str;
        }

        public final String getPromoCampId() {
            return this.promoCampId;
        }

        public final void setPromoCampId(String str) {
            this.promoCampId = str;
        }

        public final String getEmiOptions() {
            return this.emiOptions;
        }

        public final void setEmiOptions(String str) {
            this.emiOptions = str;
        }

        public final String getPgUrlToHit() {
            return this.pgUrlToHit;
        }

        public final void setPgUrlToHit(String str) {
            this.pgUrlToHit = str;
        }
    }

    public static final class CartNativeWithdrawDetails extends IJRPaytmDataModel {
        @b(a = "authenticated")
        private Boolean authenticated = Boolean.FALSE;
        @b(a = "txnToken")
        private String txnToken;

        public final String getTxnToken() {
            return this.txnToken;
        }

        public final void setTxnToken(String str) {
            this.txnToken = str;
        }

        public final Boolean getAuthenticated() {
            return this.authenticated;
        }

        public final void setAuthenticated(Boolean bool) {
            this.authenticated = bool;
        }
    }
}

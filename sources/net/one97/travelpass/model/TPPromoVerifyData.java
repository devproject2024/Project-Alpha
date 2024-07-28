package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TPPromoVerifyData extends IJRPaytmDataModel {
    @b(a = "body")
    private PromoVerifyBody body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public PromoVerifyBody getBody() {
        return this.body;
    }

    public void setBody(PromoVerifyBody promoVerifyBody) {
        this.body = promoVerifyBody;
    }

    public class PromoVerifyBody extends IJRPaytmDataModel {
        @b(a = "promoCode")
        private String promoCode;
        @b(a = "promoFailureText")
        private String promoFailureText;
        @b(a = "promoStatus")
        private String promoStatus;
        @b(a = "promoStatusText")
        private String promoStatusText;

        public PromoVerifyBody() {
        }

        public String getPromoStatus() {
            return this.promoStatus;
        }

        public void setPromoStatus(String str) {
            this.promoStatus = str;
        }

        public String getPromoFailureText() {
            return this.promoFailureText;
        }

        public void setPromoFailureText(String str) {
            this.promoFailureText = str;
        }

        public String getPromoStatusText() {
            return this.promoStatusText;
        }

        public void setPromoStatusText(String str) {
            this.promoStatusText = str;
        }

        public String getPromoCode() {
            return this.promoCode;
        }

        public void setPromoCode(String str) {
            this.promoCode = str;
        }
    }
}

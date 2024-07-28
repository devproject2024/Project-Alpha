package net.one97.paytm.nativesdk.common.model;

import android.text.TextUtils;
import java.util.ArrayList;

public class ApplyPromoResponse implements BaseDataModel {
    private Body body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public static class Head implements BaseDataModel {
        private String requestId;
        private String responseTimestamp;
        private String version;

        public String getRequestId() {
            return this.requestId;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public String getResponseTimestamp() {
            return this.responseTimestamp;
        }

        public void setResponseTimestamp(String str) {
            this.responseTimestamp = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public static class Body implements BaseDataModel {
        private PaymentOffer paymentOffer;
        private ResultInfo resultInfo;

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public PaymentOffer getPaymentOffer() {
            return this.paymentOffer;
        }

        public void setPaymentOffer(PaymentOffer paymentOffer2) {
            this.paymentOffer = paymentOffer2;
        }
    }

    public static class PaymentOffer implements BaseDataModel {
        private ArrayList<OfferBreakup> offerBreakup;
        private String totalCashbackAmount;
        private String totalInstantDiscount;

        public String getTotalInstantDiscount() {
            return this.totalInstantDiscount;
        }

        public void setTotalInstantDiscount(String str) {
            this.totalInstantDiscount = str;
        }

        public String getTotalCashbackAmount() {
            return this.totalCashbackAmount;
        }

        public void setTotalCashbackAmount(String str) {
            this.totalCashbackAmount = str;
        }

        public ArrayList<OfferBreakup> getOfferBreakup() {
            return this.offerBreakup;
        }

        public void setOfferBreakup(ArrayList<OfferBreakup> arrayList) {
            this.offerBreakup = arrayList;
        }
    }

    public static class OfferBreakup implements BaseDataModel {
        private String cashbackAmount;
        private String instantDiscount;
        private String payMethod;
        private String promoVisibility;
        private String promocodeApplied;
        private String promotext;
        private String tncUrl;

        public String getPromocodeApplied() {
            return this.promocodeApplied;
        }

        public void setPromocodeApplied(String str) {
            this.promocodeApplied = str;
        }

        public String getPromotext() {
            return this.promotext;
        }

        public void setPromotext(String str) {
            this.promotext = str;
        }

        public String getInstantDiscount() {
            return this.instantDiscount;
        }

        public void setInstantDiscount(String str) {
            this.instantDiscount = str;
        }

        public String getCashbackAmount() {
            return this.cashbackAmount;
        }

        public void setCashbackAmount(String str) {
            this.cashbackAmount = str;
        }

        public String getPayMethod() {
            return this.payMethod;
        }

        public void setPayMethod(String str) {
            this.payMethod = str;
        }

        public void setPromoVisibility(String str) {
            this.promoVisibility = str;
        }

        public String getPromoVisibility() {
            return this.promoVisibility;
        }

        public boolean isPromoVisible() {
            return !TextUtils.isEmpty(this.promoVisibility) && "true".equalsIgnoreCase(this.promoVisibility.toLowerCase());
        }

        public String getTncUrl() {
            return this.tncUrl;
        }

        public void setTncUrl(String str) {
            this.tncUrl = str;
        }
    }
}

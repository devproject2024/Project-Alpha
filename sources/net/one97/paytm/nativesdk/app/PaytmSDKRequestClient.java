package net.one97.paytm.nativesdk.app;

import android.text.SpannableString;
import com.google.android.material.bottomsheet.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import org.json.JSONObject;

public interface PaytmSDKRequestClient {

    public interface ApplyAnotherOfferListener {
        void onError(ApiResponseError apiResponseError);

        void onSuccess();
    }

    public interface OnCheckoutResponse {
        void onCheckoutError(ApiResponseError apiResponseError);

        void onCheckoutSuccess(CheckoutResponseData checkoutResponseData);
    }

    public interface OnVerifyResponse {
        void onVerifyError(ApiResponseError apiResponseError);

        void onVerifySuccess(VerifyResponseData verifyResponseData);
    }

    public interface OtherPayOptionsListener {
        void onError(ApiResponseError apiResponseError);

        void setFetchPayOptionsResponse(CJPayMethodResponse cJPayMethodResponse, double d2);
    }

    public interface ShowOrderInfoFragment {
        void showFragment(b bVar);
    }

    void applyAnotherOffer(ApplyAnotherOfferListener applyAnotherOfferListener);

    void createOrderInfoFragment(ShowOrderInfoFragment showOrderInfoFragment, Object obj);

    void doCheckout(CallbackData callbackData, OnCheckoutResponse onCheckoutResponse);

    boolean isConvFeeEnabled();

    void onOtherPayModeSelected(boolean z, OtherPayOptionsListener otherPayOptionsListener);

    void verifyCart(CallbackData callbackData, OnVerifyResponse onVerifyResponse);

    public static class ApiResponseError implements BaseDataModel {
        private boolean closePgWithoutError;
        private String errorMsg;
        private String errorTitle;
        private boolean shouldClosePG;
        private int statusCode;

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public void setErrorMsg(String str) {
            this.errorMsg = str;
        }

        public String getErrorTitle() {
            return this.errorTitle;
        }

        public void setErrorTitle(String str) {
            this.errorTitle = str;
        }

        public boolean isShouldClosePG() {
            return this.shouldClosePG;
        }

        public void setShouldClosePG(boolean z) {
            this.shouldClosePG = z;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int i2) {
            this.statusCode = i2;
        }

        public boolean isClosePgWithoutError() {
            return this.closePgWithoutError;
        }

        public void setClosePgWithoutError(boolean z) {
            this.closePgWithoutError = z;
        }
    }

    public static class CheckoutResponseData {
        private CreateOrderResponse createOrderResponse;

        public CreateOrderResponse getCreateOrderResponse() {
            return this.createOrderResponse;
        }

        public void setCreateOrderResponse(CreateOrderResponse createOrderResponse2) {
            this.createOrderResponse = createOrderResponse2;
        }
    }

    public static class VerifyResponseData {
        private ConvFeeResponse convFeeResponse;
        private List<CJRPromoData> freebieItems;
        private Boolean is8DigitBin;
        private String mid;
        private String offerText;
        private double paytmCashBack;
        private double paytmDiscount;
        private String promoCode;
        private Object verifyModel;

        public ConvFeeResponse getConvFeeResponse() {
            return this.convFeeResponse;
        }

        public void setConvFeeResponse(ConvFeeResponse convFeeResponse2) {
            this.convFeeResponse = convFeeResponse2;
        }

        public List<CJRPromoData> getFreebieItems() {
            return this.freebieItems;
        }

        public void setFreebieItems(List<CJRPromoData> list) {
            this.freebieItems = list;
        }

        public String getPromoCode() {
            return this.promoCode;
        }

        public void setPromoCode(String str) {
            this.promoCode = str;
        }

        public Boolean getIs8DigitBin() {
            return this.is8DigitBin;
        }

        public void setIs8DigitBin(Boolean bool) {
            this.is8DigitBin = bool;
        }

        public String getMid() {
            return this.mid;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public double getPaytmCashBack() {
            return this.paytmCashBack;
        }

        public void setPaytmCashBack(double d2) {
            this.paytmCashBack = d2;
        }

        public double getPaytmDiscount() {
            return this.paytmDiscount;
        }

        public void setPaytmDiscount(double d2) {
            this.paytmDiscount = d2;
        }

        public String getOfferText() {
            return this.offerText;
        }

        public void setOfferText(String str) {
            this.offerText = str;
        }

        public Object getVerifyModel() {
            return this.verifyModel;
        }

        public void setVerifyModel(Object obj) {
            this.verifyModel = obj;
        }
    }

    public static class ConvFeeResponse implements BaseDataModel {
        private String aggregatePGConvFee;
        private String convFeeLabel;
        private String feePercent;
        private String offerMsg;
        private HashMap<String, String> paymentBreakupMap;
        private SpannableString spannableConvFeeText;
        private String totalAmtExConvFee;
        private String totalAmtIncConvFee;

        @Deprecated
        public void setConvFeeText(String str) {
        }

        public String getAggregatePGConvFee() {
            return this.aggregatePGConvFee;
        }

        public void setAggregatePGConvFee(String str) {
            this.aggregatePGConvFee = str;
        }

        public String getTotalAmtIncConvFee() {
            return this.totalAmtIncConvFee;
        }

        public void setTotalAmtIncConvFee(String str) {
            this.totalAmtIncConvFee = str;
        }

        public String getTotalAmtExConvFee() {
            return this.totalAmtExConvFee;
        }

        public void setTotalAmtExConvFee(String str) {
            this.totalAmtExConvFee = str;
        }

        public String getConvFeeLabel() {
            return this.convFeeLabel;
        }

        public void setConvFeeLabel(String str) {
            this.convFeeLabel = str;
        }

        public HashMap<String, String> getPaymentBreakupMap() {
            return this.paymentBreakupMap;
        }

        public void setPaymentBreakupMap(HashMap<String, String> hashMap) {
            this.paymentBreakupMap = hashMap;
        }

        public String getFeePercent() {
            return this.feePercent;
        }

        public void setFeePercent(String str) {
            this.feePercent = str;
        }

        public String getOfferMsg() {
            return this.offerMsg;
        }

        public void setOfferMsg(String str) {
            this.offerMsg = str;
        }

        public SpannableString getSpannableConvFeeText() {
            return this.spannableConvFeeText;
        }

        public void setSpannableConvFeeText(SpannableString spannableString) {
            this.spannableConvFeeText = spannableString;
        }
    }

    public static class CallbackData {
        private JSONObject emiOffers;
        private JSONObject offerBody;
        private ArrayList<PaymentIntent> paymentIntents;
        private double rcf;

        public JSONObject getOfferBody() {
            return this.offerBody;
        }

        public void setOfferBody(JSONObject jSONObject) {
            this.offerBody = jSONObject;
        }

        public double getRcf() {
            return this.rcf;
        }

        public void setRcf(double d2) {
            this.rcf = d2;
        }

        public ArrayList<PaymentIntent> getPaymentIntents() {
            return this.paymentIntents;
        }

        public void setPaymentIntents(ArrayList<PaymentIntent> arrayList) {
            this.paymentIntents = arrayList;
        }

        public JSONObject getEmiOffers() {
            return this.emiOffers;
        }

        public void setEmiOffers(JSONObject jSONObject) {
            this.emiOffers = jSONObject;
        }
    }
}

package net.one97.paytm.o2o.movies.moviepass;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.paytm.network.b.g;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentData;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPromoMetaData;
import org.json.JSONObject;

public final class d implements PaytmSDKRequestClient, VerifyPromoCallbackListener, OnPromoActivityDestroyListener {

    /* renamed from: b  reason: collision with root package name */
    private static d f75501b;

    /* renamed from: a  reason: collision with root package name */
    public a f75502a;

    /* renamed from: c  reason: collision with root package name */
    private VerifyPromoResultListener f75503c;

    /* renamed from: d  reason: collision with root package name */
    private PaytmSDKRequestClient.OnCheckoutResponse f75504d;

    public final void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
    }

    public final boolean isConvFeeEnabled() {
        return false;
    }

    public final void verifyCart(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
    }

    private d() {
    }

    public static d a() {
        if (f75501b == null) {
            f75501b = new d();
        }
        return f75501b;
    }

    public final void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        ArrayList<PaymentIntent> paymentIntents = callbackData.getPaymentIntents();
        String a2 = paymentIntents != null ? new f().a((Object) paymentIntents) : null;
        this.f75504d = onCheckoutResponse;
        this.f75502a.a(a2);
    }

    public final void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        this.f75502a.d();
        applyAnotherOfferListener.onSuccess();
    }

    public final void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        this.f75502a.a(otherPayOptionsListener);
    }

    public final void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        this.f75503c = verifyPromoResultListener;
        this.f75502a.a(str, i2, str2, false);
    }

    public final void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        this.f75503c = verifyPromoResultListener;
        this.f75502a.a(arrayList != null ? new f().a((Object) arrayList) : null, str2);
    }

    public final void clearPromoCode(String str, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        this.f75502a.d();
        applyAnotherOfferListener.onSuccess();
    }

    public final void onPromoSearchActivityDestroy(boolean z) {
        a aVar = this.f75502a;
        if (aVar != null) {
            aVar.a(z);
            this.f75503c = null;
        }
    }

    public final void a(Context context, double d2, Request request, a aVar) {
        this.f75502a = aVar;
        b.f75032a.f75033b.openPromoSearchActivityWithoutData("", context, d2, request, this, this);
    }

    public final void a(CJRMCart cJRMCart, boolean z) {
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        verifyResponseData.setOfferText(cJRMCart.getPromoText());
        try {
            verifyResponseData.setPaytmCashBack(Double.valueOf(cJRMCart.getPaytmCashBack()).doubleValue());
            verifyResponseData.setPaytmDiscount(Double.valueOf(cJRMCart.getPaytmDiscount()).doubleValue());
            verifyResponseData.setMid(cJRMCart.paymentInfo.mid);
            CJRPromoMetaData cJRPromoMetaData = cJRMCart.promoMetaData;
            if (!(cJRPromoMetaData == null || cJRPromoMetaData.paymentData == null)) {
                CJRPaymentData cJRPaymentData = cJRPromoMetaData.paymentData;
                if (cJRPaymentData.is8DigitBin != null) {
                    verifyResponseData.setIs8DigitBin(cJRPaymentData.is8DigitBin);
                }
            }
        } catch (Exception unused) {
        }
        VerifyPromoResultListener verifyPromoResultListener = this.f75503c;
        if (verifyPromoResultListener != null) {
            verifyPromoResultListener.onVerifyPromoSuccess(cJRMCart.getInstruments(), z, verifyResponseData);
        }
    }

    public final boolean a(String str) {
        VerifyPromoResultListener verifyPromoResultListener = this.f75503c;
        if (verifyPromoResultListener == null) {
            return false;
        }
        verifyPromoResultListener.onVerifyPromoError(str);
        return true;
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        String a2 = g.a(g.a(cJRRechargePayment.getNetworkResponse().data));
        PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
        checkoutResponseData.setCreateOrderResponse((CreateOrderResponse) new f().a(a2, CreateOrderResponse.class));
        this.f75504d.onCheckoutSuccess(checkoutResponseData);
    }

    public final boolean a(NetworkCustomError networkCustomError) {
        return a(b(networkCustomError));
    }

    public final boolean a(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        VerifyPromoResultListener verifyPromoResultListener = this.f75503c;
        if (verifyPromoResultListener == null) {
            return false;
        }
        verifyPromoResultListener.onVerifyPromoNetworkError(apiResponseError);
        return true;
    }

    public static PaytmSDKRequestClient.ApiResponseError b(NetworkCustomError networkCustomError) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        if (networkCustomError != null) {
            apiResponseError.setErrorMsg(networkCustomError.getAlertMessage());
            apiResponseError.setErrorTitle(networkCustomError.getAlertTitle());
            apiResponseError.setStatusCode(networkCustomError.getStatusCode());
        }
        apiResponseError.setShouldClosePG(false);
        return apiResponseError;
    }

    public final void b(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse = this.f75504d;
        if (onCheckoutResponse != null) {
            onCheckoutResponse.onCheckoutError(apiResponseError);
        }
    }

    public final void a(a aVar) {
        this.f75502a = aVar;
        PaytmSDK.setCheckoutCallbackListener(a());
    }

    public static void b() {
        f75501b = null;
    }

    public static Boolean b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is8DigitBin")) {
                return Boolean.valueOf(jSONObject.getBoolean("is8DigitBin"));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

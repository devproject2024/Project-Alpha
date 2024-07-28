package net.one97.paytm.travel;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.HashMap;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.paytm_finance.R;
import org.json.JSONObject;

public class AJRBusPaymentActivity extends AJRRechargePaymentActivity implements b, PaytmSDKRequestClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f65125a = "status";

    /* renamed from: b  reason: collision with root package name */
    private final String f65126b = "result";

    /* renamed from: c  reason: collision with root package name */
    private final String f65127c = "message";

    /* renamed from: d  reason: collision with root package name */
    private final String f65128d = "title";

    /* renamed from: e  reason: collision with root package name */
    private final String f65129e = "code";

    /* renamed from: f  reason: collision with root package name */
    private PaytmSDKRequestClient.OnCheckoutResponse f65130f;

    public void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
    }

    public void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
    }

    public boolean isConvFeeEnabled() {
        return false;
    }

    public void verifyCart(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
    }

    public final void a(boolean z, String str, PaytmSDKRequestClient paytmSDKRequestClient) {
        if (paytmSDKRequestClient == null) {
            super.a(z, str, (PaytmSDKRequestClient) this);
        } else {
            super.a(z, str, paytmSDKRequestClient);
        }
    }

    public void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        this.f65130f = onCheckoutResponse;
        String stringExtra = (getIntent() == null || getIntent().getExtras() == null) ? "" : getIntent().getStringExtra("bus_checkout_url");
        if (URLUtil.isValidUrl(stringExtra)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, a.q(this));
            String a2 = a(callbackData);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("native_withdraw", "1");
            boolean z = false;
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                z = getIntent().getBooleanExtra("is_reseller", false);
            }
            if (z) {
                hashMap2.put("is_reseller", "1");
            }
            if (a.m(getApplicationContext())) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = AJRBusPaymentActivity.class.getName();
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = stringExtra;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = hashMap2;
                bVar.f42884h = a2;
                bVar.f42885i = new CJRBusPayment();
                bVar.j = this;
                bVar.t = null;
                bVar.l().a();
                return;
            }
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        }
    }

    public void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        setResult(-1);
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setShouldClosePG(true);
        otherPayOptionsListener.onError(apiResponseError);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusPayment) {
            CJRRechargePayment paymentInfo = ((CJRBusPayment) iJRPaytmDataModel).getPaymentInfo();
            PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
            CreateOrderResponse createOrderResponse = new CreateOrderResponse();
            createOrderResponse.setMessage(paymentInfo.getMessage());
            createOrderResponse.setMID(paymentInfo.getMID());
            createOrderResponse.setNative_withdraw(paymentInfo.isNativeEnabled());
            createOrderResponse.setORDER_ID(paymentInfo.getOrderId());
            CreateOrderResponse.NativeWithdrawDetails nativeWithdrawDetails = new CreateOrderResponse.NativeWithdrawDetails();
            nativeWithdrawDetails.setTxnToken(paymentInfo.getmTxnToken());
            createOrderResponse.setNative_withdraw_details(nativeWithdrawDetails);
            createOrderResponse.setStatus(paymentInfo.getStatus());
            createOrderResponse.setTOKEN_TYPE(paymentInfo.getmTxnToken());
            createOrderResponse.setTXN_AMOUNT(paymentInfo.getTxnAmount());
            checkoutResponseData.setCreateOrderResponse(createOrderResponse);
            this.f65130f.onCheckoutSuccess(checkoutResponseData);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!((networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null) ? false : e(new String(networkCustomError.networkResponse.data)))) {
            a(networkCustomError.getStatusCode(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    private boolean e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("status");
            if (!jSONObject2.has("result") || !ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(jSONObject2.getString("result")) || !jSONObject2.has("message")) {
                return false;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("message");
            String str2 = "";
            String string = jSONObject3.has("title") ? jSONObject3.getString("title") : str2;
            if (jSONObject3.has("message")) {
                str2 = jSONObject3.getString("message");
            }
            int i2 = jSONObject.has("code") ? jSONObject.getInt("code") : 200;
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(str2)) {
                return false;
            }
            a(i2, string, str2);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void a(int i2, String str, String str2) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setStatusCode(i2);
        apiResponseError.setShouldClosePG(true);
        apiResponseError.setErrorTitle(str);
        apiResponseError.setErrorMsg(str2);
        this.f65130f.onCheckoutError(apiResponseError);
    }

    private String a(PaytmSDKRequestClient.CallbackData callbackData) {
        String str = "";
        try {
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                str = getIntent().getStringExtra("bus_checkout_params");
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("payment_offers_applied", callbackData.getOfferBody());
            jSONObject.put("paymentContext", jSONObject2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }
}

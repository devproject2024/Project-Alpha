package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import org.json.JSONObject;

public final class AppInvokeLifecycleListener implements p, PaytmSDKCallbackListener {
    private final InstrumentActivity activity;
    private PaytmSDKCallbackListener mSDKCallbackListener;

    public AppInvokeLifecycleListener(InstrumentActivity instrumentActivity) {
        k.c(instrumentActivity, "activity");
        this.activity = instrumentActivity;
        PaytmSDKCallbackListener callbackListener = PaytmSDK.getCallbackListener();
        k.a((Object) callbackListener, "PaytmSDK.getCallbackListener()");
        this.mSDKCallbackListener = callbackListener;
        PaytmSDK.setSDKCallbackListener(this);
    }

    public final InstrumentActivity getActivity() {
        return this.activity;
    }

    public final PaytmSDKCallbackListener getMSDKCallbackListener() {
        return this.mSDKCallbackListener;
    }

    public final void setMSDKCallbackListener(PaytmSDKCallbackListener paytmSDKCallbackListener) {
        k.c(paytmSDKCallbackListener, "<set-?>");
        this.mSDKCallbackListener = paytmSDKCallbackListener;
    }

    @aa(a = k.a.ON_DESTROY)
    public final void onDestroy() {
        PaytmSDK.setSDKCallbackListener(this.mSDKCallbackListener);
    }

    public final void onTransactionResponse(Bundle bundle) {
        String string;
        String str;
        String str2;
        String str3 = SDKConstants.UNKNOWN;
        if (bundle == null || (string = bundle.getString(SDKConstants.RESPONSE, (String) null)) == null) {
            this.mSDKCallbackListener.onTransactionResponse(bundle);
            return;
        }
        try {
            String string2 = new JSONObject(string).getString(SDKConstants.STATUS);
            if (string2 != null) {
                SDKUtility.sendGaTransactionEvent(SDKUtility.getAllInOneEventParams("transaction_status", string2));
                DirectPaymentBL instance = DirectPaymentBL.getInstance();
                kotlin.g.b.k.a((Object) instance, "DirectPaymentBL.getInstance()");
                if (!TextUtils.isEmpty(instance.getPromoCodeBankOfferAI())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string2);
                    sb.append("-");
                    DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
                    kotlin.g.b.k.a((Object) instance2, "DirectPaymentBL.getInstance()");
                    sb.append(instance2.getPromoCodeBankOfferAI());
                    str2 = sb.toString();
                } else {
                    str2 = string2;
                }
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_TRANSACTION_STATUS_HIT, str2));
                this.activity.showOrderInfoFragment(bundle, string2, false);
                PaytmSDK.setSDKCallbackListener(this.mSDKCallbackListener);
                return;
            }
            SDKUtility.sendGaTransactionEvent(SDKUtility.getAllInOneEventParams("transaction_status", str3));
            DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
            kotlin.g.b.k.a((Object) instance3, "DirectPaymentBL.getInstance()");
            if (!TextUtils.isEmpty(instance3.getPromoCodeBankOfferAI())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append("-");
                DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                kotlin.g.b.k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                sb2.append(instance4.getPromoCodeBankOfferAI());
                str = sb2.toString();
            } else {
                str = str3;
            }
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_TRANSACTION_STATUS_HIT, str));
            this.mSDKCallbackListener.onTransactionResponse(bundle);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            SDKUtility.sendGaTransactionEvent(SDKUtility.getAllInOneEventParams("transaction_status", str3));
            DirectPaymentBL instance5 = DirectPaymentBL.getInstance();
            kotlin.g.b.k.a((Object) instance5, "DirectPaymentBL.getInstance()");
            if (!TextUtils.isEmpty(instance5.getPromoCodeBankOfferAI())) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append("-");
                DirectPaymentBL instance6 = DirectPaymentBL.getInstance();
                kotlin.g.b.k.a((Object) instance6, "DirectPaymentBL.getInstance()");
                sb3.append(instance6.getPromoCodeBankOfferAI());
                str3 = sb3.toString();
            }
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_TRANSACTION_STATUS_HIT, str3));
            this.mSDKCallbackListener.onTransactionResponse(bundle);
        }
    }

    public final void networkError() {
        this.mSDKCallbackListener.networkError();
    }

    public final void logException(String str, String str2, Throwable th) {
        this.mSDKCallbackListener.logException(str, str2, th);
    }

    public final void onBackPressedCancelTransaction() {
        this.mSDKCallbackListener.onBackPressedCancelTransaction();
    }

    public final void onTransactionCancel(String str) {
        this.mSDKCallbackListener.onTransactionCancel(str);
    }

    public final void performGAOperation(Map<String, Object> map) {
        this.mSDKCallbackListener.performGAOperation(map);
    }

    public final void onSessionExpire(CustomVolleyError customVolleyError) {
        this.mSDKCallbackListener.onSessionExpire(customVolleyError);
    }

    public final void logCrashAnalytics(String str, String str2) {
        this.mSDKCallbackListener.logCrashAnalytics(str, str2);
    }
}

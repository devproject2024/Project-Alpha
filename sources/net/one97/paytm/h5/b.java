package net.one97.paytm.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.n;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f50536a = new b();

    private b() {
    }

    public static void a(Context context, String str, String str2) {
        k.c(context, "context");
        if (str != null && !TextUtils.isEmpty(str)) {
            CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
            cJRRechargePayment.parseJSONObject(str);
            if (a(cJRRechargePayment)) {
                k.c(context, "context");
                k.c(cJRRechargePayment, "rechargePayment");
                t.a(context, cJRRechargePayment, (FetchPayOptionsListener) new C0909b(context, cJRRechargePayment, str2));
                return;
            }
            b(context, cJRRechargePayment, str2);
        }
    }

    public static void a(Context context, Bundle bundle) {
        k.c(context, "context");
        k.c(bundle, "bundle");
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        if (bundle.containsKey("data")) {
            cJRRechargePayment.parseJSONObject(bundle.getString("data"));
        }
        for (String str : bundle.keySet()) {
            q.d("Bundle data - " + str + " = \"" + bundle.get(str) + "\"");
        }
        String string = bundle.getString("paymentType");
        q.d("paymentType = ".concat(String.valueOf(string)));
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        intent.putExtra("intent-type-is-buy-flow", true);
        if (!k.a((Object) string, (Object) "buy")) {
            if (k.a((Object) string, (Object) "sell")) {
                k.a((Object) intent.putExtra("intent-type-is-buy-flow", false), "intent.putExtra(CJRParam…_GOLD_IS_BUY_FLOW, false)");
            } else if (k.a((Object) string, (Object) "new_card")) {
                if (cJRRechargePayment.getPGParams() != null) {
                    HashMap<String, String> pGParams = cJRRechargePayment.getPGParams();
                    k.a((Object) pGParams, "payment.pgParams");
                    pGParams.put(CJRPGTransactionRequestUtils.THEME, "merchantLow|ccdc");
                }
            } else if (k.a((Object) string, (Object) "existing_card")) {
                c.a();
                String mid = cJRRechargePayment.getMID();
                String orderId = cJRRechargePayment.getOrderId();
                cJRRechargePayment.setmPGUrlToHit(c.a("processTxnAddMoneyURL", (String) null) + "?mid=" + mid + "&orderId=" + orderId);
            }
        }
        if (bundle.containsKey("nativeSdkEnabled")) {
            intent.putExtra("nativeSdkEnabled", bundle.getBoolean("nativeSdkEnabled"));
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("price", cJRRechargePayment.getTxnAmount());
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
        }
        intent.putExtra("key_is_intercept_summary_url", true);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra(UpiConstants.FROM, "gold");
        if (bundle.containsKey("Tab")) {
            intent.putExtra("Tab", bundle.getString("Tab"));
        }
        if (bundle.containsKey("vertical_id")) {
            intent.putExtra("vertical_id", bundle.getString("vertical_id"));
        }
        if (context != null) {
            ((Activity) context).startActivityForResult(intent, 1228);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    /* renamed from: net.one97.paytm.h5.b$b  reason: collision with other inner class name */
    public static final class C0909b implements FetchPayOptionsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f50540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRechargePayment f50541b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f50542c;

        public final void onPaymentOptionsError() {
        }

        public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        }

        public final void onRequestStart() {
        }

        public final void onVpaReceived(VpaFetch vpaFetch) {
        }

        C0909b(Context context, CJRRechargePayment cJRRechargePayment, String str) {
            this.f50540a = context;
            this.f50541b = cJRRechargePayment;
            this.f50542c = str;
        }

        public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
            PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
            b bVar = b.f50536a;
            b.b(this.f50540a, this.f50541b, this.f50542c);
        }
    }

    private static boolean a(CJRRechargePayment cJRRechargePayment) {
        return p.a("1", cJRRechargePayment.isNativeEnabled(), true);
    }

    /* access modifiers changed from: private */
    public static void b(Context context, CJRRechargePayment cJRRechargePayment, String str) {
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("nativeSdkEnabled", true);
            intent.putExtra("price", str);
        } else {
            intent.putExtra("nativeSdkEnabled", false);
        }
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("IS_FROM_EVENT", true);
        context.startActivity(intent);
    }

    public static void a(Activity activity) {
        k.c(activity, "activity");
        if (activity.findViewById(R.id.h5_rl_loading_view) == null) {
            View findViewById = activity.findViewById(16908290);
            if (findViewById != null) {
                View.inflate(activity, R.layout.h5_layout_loadingview, (FrameLayout) findViewById);
            } else {
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(R.id.h5_ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void b(Activity activity) {
        k.c(activity, "activity");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(R.id.h5_ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static final class a implements FetchPayOptionsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f50537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRechargePayment f50538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f50539c;

        public final void onPaymentOptionsError() {
        }

        public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        }

        public final void onRequestStart() {
        }

        public final void onVpaReceived(VpaFetch vpaFetch) {
        }

        a(Context context, CJRRechargePayment cJRRechargePayment, Bundle bundle) {
            this.f50537a = context;
            this.f50538b = cJRRechargePayment;
            this.f50539c = bundle;
        }

        public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
            PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
            b bVar = b.f50536a;
            b.b(this.f50537a, this.f50538b, this.f50539c);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, CJRRechargePayment cJRRechargePayment, Bundle bundle) {
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra(UpiConstants.FROM, bundle.getString(UpiConstants.FROM, "lending"));
        if (bundle.containsKey("Tab")) {
            intent.putExtra("Tab", bundle.getString("Tab"));
        }
        if (bundle.containsKey("vertical_id")) {
            intent.putExtra("vertical_id", bundle.getString("vertical_id"));
        }
        intent.putExtra(H5Event.TYPE_CALL_BACK, bundle.getBoolean(H5Event.TYPE_CALL_BACK, false));
        intent.putExtra("redirectTo", bundle.getString("redirectTo", ""));
        if (context != null) {
            ((Activity) context).startActivityForResult(intent, 1228);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    public static void b(Context context, Bundle bundle) {
        k.c(context, "context");
        k.c(bundle, "bundle");
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        if (bundle.containsKey("data")) {
            cJRRechargePayment.parseJSONObject(bundle.getString("data"));
        }
        if (a(cJRRechargePayment)) {
            k.c(context, "context");
            k.c(cJRRechargePayment, "rechargePayment");
            k.c(bundle, "bundle");
            t.a(context, cJRRechargePayment, (FetchPayOptionsListener) new a(context, cJRRechargePayment, bundle));
            return;
        }
        b(context, cJRRechargePayment, bundle);
    }

    public static String[] a(Context context) {
        int i2;
        k.c(context, "context");
        String a2 = n.a(context, n.a());
        k.a((Object) a2, "LocaleHelper.getLanguage(context)");
        if (!p.a(a2, "en", true)) {
            if (p.a(a2, "hi", true)) {
                i2 = 2;
            } else if (p.a(a2, "ta", true)) {
                i2 = 8;
            } else if (p.a(a2, "te", true)) {
                i2 = 9;
            } else if (p.a(a2, "kn", true)) {
                i2 = 7;
            } else if (p.a(a2, "pa", true)) {
                i2 = 11;
            } else if (p.a(a2, "mr", true)) {
                i2 = 5;
            } else if (p.a(a2, "gu", true)) {
                i2 = 10;
            } else if (p.a(a2, "bn", true)) {
                i2 = 3;
            } else if (p.a(a2, "ml", true)) {
                i2 = 6;
            } else if (p.a(a2, "or", true)) {
                i2 = 4;
            }
            return new String[]{a2, String.valueOf(i2)};
        }
        i2 = 1;
        return new String[]{a2, String.valueOf(i2)};
    }
}

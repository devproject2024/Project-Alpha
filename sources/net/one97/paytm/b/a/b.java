package net.one97.paytm.b.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.lifecycle.z;
import com.paytm.network.listener.b;
import com.paytm.utility.a;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f49478a;

    b(String str) {
        this.f49478a = str;
    }

    public static void a(Context context, String str, String str2, Map<String, String> map, com.paytm.network.listener.b bVar) {
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            String str5 = com.paytm.utility.b.v(context) + System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, a.q(context));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "APP");
            jSONObject3.put("qrCodeId", str2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject3.put("orderId", str);
            }
            jSONObject3.put("mlvSupported", true);
            jSONObject2.put("requestId", str5);
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        if (net.one97.paytm.wallet.utility.a.m(context)) {
            str3 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "fetchQRPaymentDetailsv2") + "?device-id=" + UpiUtils.getDeviceId(context);
        } else {
            str3 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "fetchQRPaymentDetails");
        }
        try {
            str4 = str3 + "&appVersion=" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + "&client=androidapp";
        } catch (PackageManager.NameNotFoundException unused2) {
            str4 = "appVersion=8.4.0&client=androidapp";
        }
        if (!TextUtils.isEmpty(str)) {
            str4 = str4 + "&orderId=" + str;
        }
        String str6 = str4;
        if (com.paytm.utility.b.c(context)) {
            net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(str6, new SingleAPIResponseV2(), (Map<String, String>) null, map, jSONObject.toString());
            bVar2.e();
            bVar2.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_instrument_api_timeout")));
            bVar2.c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    b.a(b.this, (f) obj);
                }
            });
            new StringBuilder("Single API Initiated ").append(System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(com.paytm.network.listener.b bVar, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            new StringBuilder("Single API Response Received ").append(System.currentTimeMillis());
            bVar.onApiSuccess(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            bVar.handleErrorCode(fVar.f55798c.f55799a, fVar.f55798c.f55800b, fVar.f55798c.f55801c);
        }
    }
}

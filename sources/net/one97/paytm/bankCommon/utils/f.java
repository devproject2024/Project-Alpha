package net.one97.paytm.bankCommon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[Catch:{ Exception -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[Catch:{ Exception -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[Catch:{ Exception -> 0x007b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[Catch:{ Exception -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r7, android.widget.TextView r8) {
        /*
            java.lang.String r0 = ""
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x007b }
            r2 = 0
            if (r1 == 0) goto L_0x0012
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x007b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = r2
            goto L_0x0019
        L_0x0012:
            java.lang.String r1 = "sans-serif-medium"
            r3 = 1
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x007b }
        L_0x0019:
            android.graphics.Typeface r3 = r8.getTypeface()     // Catch:{ Exception -> 0x007b }
            r4 = 0
            if (r3 == 0) goto L_0x0026
            android.graphics.Typeface r3 = r8.getTypeface()     // Catch:{ Exception -> 0x007b }
            if (r3 == 0) goto L_0x002c
        L_0x0026:
            java.lang.String r2 = "sans-serif-light"
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r4)     // Catch:{ Exception -> 0x007b }
        L_0x002c:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x007b }
            if (r3 == 0) goto L_0x0034
            java.lang.String r7 = "0.00"
        L_0x0034:
            java.lang.String r3 = "."
            boolean r3 = r7.contains(r3)     // Catch:{ Exception -> 0x007b }
            if (r3 != 0) goto L_0x004d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
            r3.<init>()     // Catch:{ Exception -> 0x007b }
            r3.append(r7)     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = ".00"
            r3.append(r7)     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x007b }
        L_0x004d:
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x007b }
            r3.<init>(r7)     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = "\\."
            java.lang.String[] r5 = r7.split(r5)     // Catch:{ Exception -> 0x007b }
            if (r5 != 0) goto L_0x005b
            return
        L_0x005b:
            r5 = r5[r4]     // Catch:{ Exception -> 0x007b }
            int r5 = r5.length()     // Catch:{ Exception -> 0x007b }
            int r7 = r7.length()     // Catch:{ Exception -> 0x007b }
            com.paytm.utility.CustomTypefaceSpan r6 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x007b }
            r6.<init>(r0, r1)     // Catch:{ Exception -> 0x007b }
            r1 = 34
            r3.setSpan(r6, r4, r5, r1)     // Catch:{ Exception -> 0x007b }
            com.paytm.utility.CustomTypefaceSpan r4 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x007b }
            r4.<init>(r0, r2)     // Catch:{ Exception -> 0x007b }
            r3.setSpan(r4, r5, r7, r1)     // Catch:{ Exception -> 0x007b }
            r8.setText(r3)     // Catch:{ Exception -> 0x007b }
            return
        L_0x007b:
            r7 = move-exception
            r7.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.utils.f.a(java.lang.String, android.widget.TextView):void");
    }

    public static void a(Activity activity, Exception exc, String str) {
        net.one97.paytm.bankOpen.f.a().handleError(activity, exc, str, (Bundle) null, false);
    }

    public static String a(boolean z, boolean z2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", UpiConstants.B2C_ANDROID);
            jSONObject.put("umrn", str);
            jSONObject.put("consentAction", z ? "AMEND" : "CREATE");
            jSONObject.put("consentTime", System.currentTimeMillis());
            if (!z2) {
                jSONObject.put("rejectCode", "M032");
                jSONObject.put("consentStatus", "REJECTED");
            } else {
                jSONObject.put("consentStatus", "ACCEPTED");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static int a(int i2) {
        try {
            return (int) (((float) i2) / Resources.getSystem().getDisplayMetrics().density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void a(Context context, NetworkCustomError networkCustomError, int i2) {
        net.one97.paytm.bankOpen.f.a().handleErrorV2(context, networkCustomError, i2);
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public static String a() {
        try {
            String b2 = b.b(net.one97.paytm.bankOpen.f.a().getApplicationContext());
            if (TextUtils.isEmpty(b2)) {
                return "ISA";
            }
            return b2;
        } catch (Exception unused) {
            return "ISA";
        }
    }
}

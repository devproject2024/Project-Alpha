package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.visascp.network.model.BaseModel;
import net.one97.paytm.payments.visascp.network.model.DeEnrollResponseModel;
import net.one97.paytm.payments.visascp.util.Utils;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class DeEnrollCard {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f580 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f581;

    public static void deEnrollCard(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, Response.Listener<BaseModel> listener, Response.ErrorListener errorListener) {
        String str8 = str;
        String str9 = str2;
        new HashMap().put(StringSet.token, str);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", "v1");
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.put("requestId", String.valueOf(System.currentTimeMillis()));
            jSONObject2.put(StringSet.token, str);
            jSONObject2.put("tokenType", str2);
            jSONObject.put("head", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appId", Utils.getMerchantAppId(context));
            String str10 = str5;
            jSONObject3.put("custId", str5);
            String str11 = str4;
            jSONObject3.put("cardAlias", str4);
            String str12 = str3;
            jSONObject3.put("bin", str3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(VisaSCPConstants.KEY_DENROLL_CONTENT, jSONObject3);
            jSONObject.put("body", jSONObject4);
            String str13 = str6;
            String str14 = str7;
            String deEnrollmentUrl = getDeEnrollmentUrl(str2, str6, str7);
            VolleyRequest volleyRequest = new VolleyRequest(1, deEnrollmentUrl, jSONObject.toString().replace("\\", ""), new DeEnrollResponseModel(), listener, errorListener);
            Context context2 = context;
            VolleyWrapper.newRequestQueue(context, deEnrollmentUrl).add(volleyRequest);
            int i2 = f580;
            int i3 = (i2 & 71) + (i2 | 71);
            f581 = i3 % 128;
            if (i3 % 2 != 0) {
            }
        } catch (JSONException unused) {
            String str15 = VisaSCPConstants.LOG_TAG;
            String str16 = VisaSCPConstants.EXCEPTION_MESSAGE;
            errorListener.onErrorResponse(new VolleyError());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if ((!net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release") ? '0' : '_') != '0') goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDeEnrollmentUrl(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = f581
            r1 = r0 & 39
            r0 = r0 | 39
            int r0 = -r0
            int r0 = -r0
            r2 = r1 | r0
            r3 = 1
            int r2 = r2 << r3
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f580 = r0
            int r2 = r2 % 2
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.DE_ENROLLMENT_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            if (r1 == 0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            r2 = 95
            if (r1 == 0) goto L_0x0024
            goto L_0x004b
        L_0x0024:
            int r1 = f580
            r4 = r1 ^ 107(0x6b, float:1.5E-43)
            r1 = r1 & 107(0x6b, float:1.5E-43)
            r1 = r1 | r4
            int r1 = r1 << r3
            int r4 = -r4
            r5 = r1 ^ r4
            r1 = r1 & r4
            int r1 = r1 << r3
            int r5 = r5 + r1
            int r1 = r5 % 128
            f581 = r1
            int r5 = r5 % 2
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            java.lang.String r4 = "release"
            boolean r1 = r1.equalsIgnoreCase(r4)
            r4 = 48
            if (r1 != 0) goto L_0x0047
            r1 = 48
            goto L_0x0049
        L_0x0047:
            r1 = 95
        L_0x0049:
            if (r1 == r4) goto L_0x005f
        L_0x004b:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.DE_ENROLLMENT_STAGING_URL
            int r1 = f581
            r4 = r1 & 57
            r1 = r1 ^ 57
            r1 = r1 | r4
            r5 = r4 | r1
            int r5 = r5 << r3
            r1 = r1 ^ r4
            int r5 = r5 - r1
            int r1 = r5 % 128
            f580 = r1
            int r5 = r5 % 2
        L_0x005f:
            java.lang.String r1 = "ACCESS"
            boolean r1 = r1.equalsIgnoreCase(r6)
            java.lang.String r4 = "?mid="
            if (r1 == 0) goto L_0x0092
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            r6.append(r7)
            java.lang.String r7 = "&referenceId="
            r6.append(r7)
            r6.append(r8)
            java.lang.String r0 = r6.toString()
            int r6 = f581
            r7 = r6 & 55
            r6 = r6 ^ 55
            r6 = r6 | r7
            int r7 = r7 + r6
            int r6 = r7 % 128
            f580 = r6
            int r7 = r7 % 2
            goto L_0x00bf
        L_0x0092:
            java.lang.String r8 = "CHECKSUM"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x00bf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            r6.append(r7)
            java.lang.String r0 = r6.toString()
            int r6 = f581
            int r6 = r6 + 7
            int r6 = r6 - r3
            int r6 = r6 - r3
            int r7 = r6 % 128
            f580 = r7
            int r6 = r6 % 2
            r7 = 90
            if (r6 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r2 = 90
        L_0x00bf:
            int r6 = f580
            r7 = r6 & 11
            int r8 = ~r7
            r6 = r6 | 11
            r6 = r6 & r8
            int r7 = r7 << r3
            int r7 = -r7
            int r7 = -r7
            r8 = r6 & r7
            r6 = r6 | r7
            int r8 = r8 + r6
            int r6 = r8 % 128
            f581 = r6
            int r8 = r8 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.DeEnrollCard.getDeEnrollmentUrl(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}

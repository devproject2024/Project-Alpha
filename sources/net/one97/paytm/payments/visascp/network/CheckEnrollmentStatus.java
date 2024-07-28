package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sendbird.android.constant.StringSet;
import java.util.Set;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.visascp.network.model.BaseModel;
import net.one97.paytm.payments.visascp.network.model.EnrollmentStatusModel;
import net.one97.paytm.payments.visascp.storage.SecureSharedPref;
import net.one97.paytm.payments.visascp.util.Utils;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckEnrollmentStatus {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f578 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f579;

    public static void checkAllEnrolledCards(Context context, String str, String str2, String str3, Set<String> set, String str4, String str5, Response.Listener<BaseModel> listener, Response.ErrorListener errorListener) {
        Context context2 = context;
        String str6 = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", "v1");
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.put("requestId", String.valueOf(System.currentTimeMillis()));
            String str7 = str;
            jSONObject2.put(StringSet.token, str);
            jSONObject2.put("tokenType", str2);
            jSONObject.put("head", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appId", Utils.getMerchantAppId(context));
            String str8 = str3;
            jSONObject3.put("custId", str3);
            JSONArray jSONArray = new JSONArray();
            SecureSharedPref instance = SecureSharedPref.getInstance(context);
            int i2 = f578;
            int i3 = (i2 | 33) << 1;
            int i4 = -(((~i2) & 33) | (i2 & -34));
            int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
            f579 = i5 % 128;
            int i6 = i5 % 2;
            for (String next : set) {
                JSONObject jSONObject4 = new JSONObject();
                StringBuilder sb = new StringBuilder();
                sb.append(next);
                sb.append(VisaSCPConstants.D_ID);
                String data = instance.getData(context, sb.toString());
                if ((TextUtils.isEmpty(data) ? '&' : 10) == 10) {
                    int i7 = f578;
                    int i8 = i7 & 9;
                    int i9 = i8 + ((i7 ^ 9) | i8);
                    f579 = i9 % 128;
                    int i10 = i9 % 2;
                    jSONObject4.put("deviceId", data);
                    int i11 = f579;
                    int i12 = (((i11 ^ 42) + ((i11 & 42) << 1)) + 0) - 1;
                    f578 = i12 % 128;
                    if (i12 % 2 != 0) {
                    }
                }
                jSONObject4.put("cardAlias", next);
                jSONArray.put(jSONObject4);
                int i13 = f579;
                int i14 = (i13 & 121) + (i13 | 121);
                f578 = i14 % 128;
                int i15 = i14 % 2;
            }
            jSONObject3.put("accountDataList", jSONArray);
            jSONObject.put("body", jSONObject3);
            String checkEnrollmentStatusUrl = getCheckEnrollmentStatusUrl(str2, str4, str5);
            VolleyWrapper.newRequestQueue(context, checkEnrollmentStatusUrl).add(new VolleyRequest(1, checkEnrollmentStatusUrl, jSONObject.toString().replace("\\", ""), new EnrollmentStatusModel(), listener, errorListener));
            int i16 = f578;
            int i17 = ((i16 | 17) << 1) - (i16 ^ 17);
            f579 = i17 % 128;
            if (i17 % 2 != 0) {
            }
        } catch (JSONException unused) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
            errorListener.onErrorResponse(new VolleyError());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if ((!net.one97.paytm.payments.visascp.VisaSDK.isStaging()) != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if ((net.one97.paytm.payments.visascp.VisaSDK.isStaging() ? 9 : 'C') != 'C') goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        if ((net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release")) != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.CHECK_ENROLLMENT_STATUS_STAGING_URL;
        r1 = f579;
        r5 = r1 & 65;
        r5 = (r5 - (~(-(-((r1 ^ 65) | r5))))) - 1;
        f578 = r5 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        if ((r5 % 2) == 0) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        if ("ACCESS".equalsIgnoreCase(r7) == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        r7 = new java.lang.StringBuilder();
        r7.append(r0);
        r7.append("?mid=");
        r7.append(r8);
        r7.append("&referenceId=");
        r7.append(r9);
        r0 = r7.toString();
        r7 = f579;
        r8 = (r7 ^ 7) + ((r7 & 7) << 1);
        f578 = r8 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        if ((r8 % 2) == 0) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
        if ("CHECKSUM".equalsIgnoreCase(r7) == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bf, code lost:
        r7 = new java.lang.StringBuilder();
        r7.append(r0);
        r7.append("?mid=");
        r7.append(r8);
        r0 = r7.toString();
        r7 = (f579 + 7) - 1;
        r8 = ((r7 | -1) << 1) - (~r7);
        f578 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e1, code lost:
        r7 = f578;
        r9 = r7 & 21;
        r8 = ((r7 ^ 21) | r9) << 1;
        r7 = -((r7 | 21) & (~r9));
        r9 = (r8 ^ r7) + ((r7 & r8) << 1);
        f579 = r9 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fb, code lost:
        if ((r9 % 2) != 0) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fd, code lost:
        r8 = 24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
        r8 = 28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0102, code lost:
        if (r8 == 28) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0104, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0105, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0109, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCheckEnrollmentStatusUrl(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = f578
            r1 = r0 & 73
            int r2 = ~r1
            r0 = r0 | 73
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f579 = r1
            int r0 = r0 % 2
            r1 = 8
            r3 = 65
            if (r0 != 0) goto L_0x001a
            r0 = 8
            goto L_0x001c
        L_0x001a:
            r0 = 65
        L_0x001c:
            r4 = 0
            if (r0 == r1) goto L_0x002d
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.CHECK_ENROLLMENT_STATUS_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            if (r1 == 0) goto L_0x0029
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0066
            goto L_0x003f
        L_0x002d:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.CHECK_ENROLLMENT_STATUS_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            r5 = 67
            if (r1 == 0) goto L_0x003a
            r1 = 9
            goto L_0x003c
        L_0x003a:
            r1 = 67
        L_0x003c:
            if (r1 == r5) goto L_0x003f
            goto L_0x0066
        L_0x003f:
            int r1 = f579
            r5 = r1 & -118(0xffffffffffffff8a, float:NaN)
            int r6 = ~r1
            r6 = r6 & 117(0x75, float:1.64E-43)
            r5 = r5 | r6
            r1 = r1 & 117(0x75, float:1.64E-43)
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r6 = r5 | r1
            int r6 = r6 << r2
            r1 = r1 ^ r5
            int r6 = r6 - r1
            int r1 = r6 % 128
            f578 = r1
            int r6 = r6 % 2
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            java.lang.String r5 = "release"
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x0063
            r1 = 0
            goto L_0x0064
        L_0x0063:
            r1 = 1
        L_0x0064:
            if (r1 == 0) goto L_0x007d
        L_0x0066:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.CHECK_ENROLLMENT_STATUS_STAGING_URL
            int r1 = f579
            r5 = r1 & 65
            r1 = r1 ^ r3
            r1 = r1 | r5
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r5 = r5 - r1
            int r5 = r5 - r2
            int r1 = r5 % 128
            f578 = r1
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r4 = 1
        L_0x007d:
            java.lang.String r1 = "ACCESS"
            boolean r1 = r1.equalsIgnoreCase(r7)
            java.lang.String r3 = "?mid="
            if (r1 == 0) goto L_0x00b7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = "&referenceId="
            r7.append(r8)
            r7.append(r9)
            java.lang.String r0 = r7.toString()
            int r7 = f579
            r8 = r7 ^ 7
            r7 = r7 & 7
            int r7 = r7 << r2
            int r8 = r8 + r7
            int r7 = r8 % 128
            f578 = r7
            int r8 = r8 % 2
            r7 = 6
            if (r8 == 0) goto L_0x00b4
            r8 = 6
            goto L_0x00e1
        L_0x00b4:
            r8 = 49
            goto L_0x00e1
        L_0x00b7:
            java.lang.String r9 = "CHECKSUM"
            boolean r7 = r9.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00e1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r3)
            r7.append(r8)
            java.lang.String r0 = r7.toString()
            int r7 = f579
            int r7 = r7 + 7
            int r7 = r7 - r2
            r8 = r7 | -1
            int r8 = r8 << r2
            int r7 = ~r7
            int r8 = r8 - r7
            int r7 = r8 % 128
            f578 = r7
            int r8 = r8 % 2
        L_0x00e1:
            int r7 = f578
            r8 = r7 ^ 21
            r9 = r7 & 21
            r8 = r8 | r9
            int r8 = r8 << r2
            int r9 = ~r9
            r7 = r7 | 21
            r7 = r7 & r9
            int r7 = -r7
            r9 = r8 ^ r7
            r7 = r7 & r8
            int r7 = r7 << r2
            int r9 = r9 + r7
            int r7 = r9 % 128
            f579 = r7
            int r9 = r9 % 2
            r7 = 28
            if (r9 != 0) goto L_0x0100
            r8 = 24
            goto L_0x0102
        L_0x0100:
            r8 = 28
        L_0x0102:
            if (r8 == r7) goto L_0x0105
            return r0
        L_0x0105:
            r7 = 0
            super.hashCode()     // Catch:{ all -> 0x010a }
            return r0
        L_0x010a:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}

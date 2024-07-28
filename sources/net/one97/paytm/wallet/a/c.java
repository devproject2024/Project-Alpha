package net.one97.paytm.wallet.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.brts.CJRBrtsUTS;
import net.one97.paytm.common.entity.transpost.CJRQRInfoBrtsResponse;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRExtendedInfoData;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.utils.aq;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.d.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.one97.paytm.base.BaseActivity r25, android.content.Context r26, java.lang.String r27, boolean r28, net.one97.paytm.wallet.newdesign.a.c r29, java.lang.String r30, boolean r31, java.lang.String r32, boolean r33, long r34, long r36, net.one97.paytm.wallet.a.f r38, java.lang.String r39) {
        /*
            r15 = r26
            r10 = r27
            r14 = r29
            r13 = r38
            r38.a()
            boolean r0 = net.one97.paytm.wallet.utility.a.x(r30)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x008e
            java.lang.String r0 = "ORDER_ID"
            if (r28 == 0) goto L_0x0048
            net.one97.paytm.wallet.d.j.a()
            net.one97.paytm.common.entity.IJRDataModel r4 = net.one97.paytm.wallet.d.j.a((android.content.Context) r26, (java.lang.String) r27)
            net.one97.paytm.common.entity.wallet.RecentScan r4 = (net.one97.paytm.common.entity.wallet.RecentScan) r4
            if (r4 == 0) goto L_0x0044
            java.lang.String r4 = r4.getScanResult()
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003e }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x003e }
            r5.remove(r0)     // Catch:{ JSONException -> 0x003e }
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r26)     // Catch:{ JSONException -> 0x003e }
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x003c }
            r13.a(r0, r3)     // Catch:{ JSONException -> 0x003c }
        L_0x003c:
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            r11 = r0
            r16 = r1
        L_0x0042:
            r0 = 1
            goto L_0x0092
        L_0x0044:
            r38.b()
            goto L_0x008e
        L_0x0048:
            net.one97.paytm.wallet.communicator.c r4 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r5 = "disableQRStoreDatabase"
            boolean r4 = r4.getBooleanFromGTM(r15, r5, r3)
            if (r4 != 0) goto L_0x008e
            net.one97.paytm.wallet.communicator.c r4 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r5 = "qrDatabaseDeleteOffset"
            long r4 = r4.getLongFromGTM(r15, r5)
            android.content.Context r6 = r26.getApplicationContext()
            r14.a((android.content.Context) r6, (long) r4)
            android.content.Context r4 = r26.getApplicationContext()
            java.lang.String r4 = r14.a((android.content.Context) r4, (java.lang.String) r10)
            if (r4 == 0) goto L_0x008b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0086 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0086 }
            r5.remove(r0)     // Catch:{ JSONException -> 0x0086 }
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r26)     // Catch:{ JSONException -> 0x0086 }
            if (r0 == 0) goto L_0x0086
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0084 }
            r13.a(r0, r3)     // Catch:{ JSONException -> 0x0084 }
        L_0x0084:
            r0 = 1
            goto L_0x0087
        L_0x0086:
            r0 = 0
        L_0x0087:
            r11 = r0
            r16 = r4
            goto L_0x0042
        L_0x008b:
            r16 = r4
            goto L_0x0090
        L_0x008e:
            r16 = r1
        L_0x0090:
            r0 = 0
            r11 = 0
        L_0x0092:
            boolean r4 = com.paytm.utility.b.r((android.content.Context) r26)
            if (r4 == 0) goto L_0x01e8
            net.one97.paytm.b.a.e.a()
            boolean r4 = net.one97.paytm.b.a.e.f()
            java.lang.String r5 = "ssotoken"
            java.lang.String r6 = "application/json"
            java.lang.String r7 = "Content-Type"
            if (r4 == 0) goto L_0x0112
            net.one97.paytm.utils.aq r12 = new net.one97.paytm.utils.aq
            r12.<init>()
            net.one97.paytm.wallet.a.c$1 r4 = new net.one97.paytm.wallet.a.c$1
            r4.<init>(r13)
            r12.a(r15, r4)
            r12.f69653b = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r4 = com.paytm.utility.a.q(r26)
            r1.put(r5, r4)
            r1.put(r7, r6)
            net.one97.paytm.b.a.e r4 = net.one97.paytm.b.a.e.a()
            r5 = r39
            r4.a(r15, r5, r10, r1)
            if (r11 == 0) goto L_0x00d3
            r38.b()
        L_0x00d3:
            boolean[] r9 = new boolean[r2]
            r9[r3] = r0
            net.one97.paytm.b.a.e.a()
            androidx.lifecycle.y r8 = net.one97.paytm.b.a.e.d()
            net.one97.paytm.wallet.a.c$2 r7 = new net.one97.paytm.wallet.a.c$2
            r0 = r7
            r1 = r16
            r2 = r38
            r3 = r26
            r4 = r32
            r5 = r33
            r6 = r27
            r10 = r7
            r7 = r30
            r15 = r8
            r8 = r31
            r16 = r15
            r15 = r10
            r10 = r11
            r11 = r29
            r14 = r13
            r13 = r28
            r14 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r13 = r25
            r0 = r16
            r0.observe(r13, r15)
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r26)
            if (r0 != 0) goto L_0x0111
            r38.b()
        L_0x0111:
            return
        L_0x0112:
            r13 = r25
            net.one97.paytm.utils.aq r1 = new net.one97.paytm.utils.aq
            r1.<init>()
            net.one97.paytm.wallet.a.c$3 r4 = new net.one97.paytm.wallet.a.c$3
            r8 = r38
            r4.<init>(r8)
            r9 = r26
            r1.a(r9, r4)
            net.one97.paytm.wallet.communicator.c r4 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r11 = "pgQRInfoURL"
            java.lang.String r4 = r4.getStringFromGTM(r9, r11)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.lang.String r12 = "FastScanFragment.QRNetworkCallHandler"
            java.lang.String r15 = "screen_name"
            r11.put(r15, r12)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r3.put(r7, r6)
            java.lang.String r6 = com.paytm.utility.a.q(r26)
            r3.put(r5, r6)
            java.lang.String r5 = a(r27)
            boolean[] r6 = new boolean[r2]
            r2 = 0
            r6[r2] = r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r26)
            if (r0 == 0) goto L_0x01b4
            r38.a()
            net.one97.paytm.network.b r0 = new net.one97.paytm.network.b
            net.one97.paytm.common.entity.wallet.CJRQRInfoResponse r19 = new net.one97.paytm.common.entity.wallet.CJRQRInfoResponse
            r19.<init>()
            r17 = r0
            r18 = r4
            r20 = r11
            r21 = r3
            r22 = r5
            r17.<init>(r18, r19, r20, r21, r22)
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r3 = "qrInfoNetworkTimeout"
            int r2 = r2.getIntegerFromGTM((android.content.Context) r9, (java.lang.String) r3)
            int r2 = net.one97.paytm.wallet.utility.a.a((int) r2)
            r0.a(r2)
            r0.e()
            androidx.lifecycle.y r15 = r0.c()
            net.one97.paytm.wallet.a.-$$Lambda$c$YeWrS4wS3XVvhtLrlmcE2pAV1S0 r12 = new net.one97.paytm.wallet.a.-$$Lambda$c$YeWrS4wS3XVvhtLrlmcE2pAV1S0
            r0 = r12
            r2 = r38
            r3 = r26
            r17 = r6
            r6 = r34
            r8 = r36
            r10 = r27
            r11 = r33
            r23 = r12
            r12 = r30
            r13 = r31
            r14 = r17
            r24 = r15
            r15 = r16
            r16 = r29
            r17 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r1 = r23
            r0 = r24
            r0.observeForever(r1)
            return
        L_0x01b4:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r0.put(r15, r12)
            java.lang.String r1 = "flowName"
            java.lang.String r2 = "Offline_Payments"
            r0.put(r1, r2)
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            r2 = -1
            r6 = 0
            com.paytm.network.a$b r3 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.a$c r8 = com.paytm.network.a.c.PAY
            java.lang.String r10 = "Sorry,no internet connectivity detected.Please reconnect and try again"
            r27 = r1
            r28 = r26
            r29 = r2
            r30 = r4
            r31 = r5
            r32 = r10
            r33 = r6
            r35 = r3
            r36 = r0
            r37 = r8
            r27.pushHawkeyeEvent(r28, r29, r30, r31, r32, r33, r35, r36, r37)
            return
        L_0x01e8:
            r8 = r13
            r38.c()
            r38.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.a.c.a(net.one97.paytm.base.BaseActivity, android.content.Context, java.lang.String, boolean, net.one97.paytm.wallet.newdesign.a.c, java.lang.String, boolean, java.lang.String, boolean, long, long, net.one97.paytm.wallet.a.f, java.lang.String):void");
    }

    private static void a(Context context, int i2, String str, f fVar, String str2, String str3, long j, long j2) {
        long j3;
        f fVar2 = fVar;
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", "FastScanFragment.QRNetworkCallHandler");
        hashMap.put("flowName", "Offline_Payments");
        if (!(fVar2 == null || fVar2.f55797b == null || !(fVar2.f55797b instanceof CJRQRInfoResponse) || ((CJRQRInfoResponse) fVar2.f55797b).getResponse() == null)) {
            hashMap.put("mid", ((CJRQRInfoResponse) fVar2.f55797b).getResponse().optString("MID"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j - j2);
        hashMap.put("scan_capture_time", sb.toString());
        net.one97.paytm.wallet.communicator.c a2 = b.a();
        if (fVar2.f55797b == null || fVar2.f55797b.getNetworkResponse() != null) {
            j3 = fVar2.f55797b.getNetworkResponse().networkTimeMs;
        } else {
            j3 = 0;
        }
        a2.pushHawkeyeEvent(context, i2, str, str3, str2, j3, a.b.USER_FACING, hashMap, a.c.PAY);
    }

    static void a(Context context, String str) {
        Intent intent = new Intent("com.android.wallet.TAGLINE_REFERER");
        intent.putExtra("merchant_tagline", str);
        context.sendBroadcast(intent);
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("qrCodeId", str);
            jSONObject.put("request", jSONObject2);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put("scanCompletedTime", sb.toString());
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "QR_CODE");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    static void a(Context context, JSONObject jSONObject, String str, String str2, boolean z) {
        if (!z || !b(str2)) {
            j.a().a(context, jSONObject.toString(), str, 1, 2);
        }
    }

    private static boolean b(String str) {
        Map linkedHashMap = new LinkedHashMap();
        try {
            linkedHashMap = net.one97.paytm.wallet.utility.a.j(str);
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(linkedHashMap.containsKey("am") ? (String) linkedHashMap.get("am") : null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(aq aqVar, f fVar, Context context, String str, String str2, long j, long j2, String str3, boolean z, String str4, boolean z2, boolean[] zArr, String str5, net.one97.paytm.wallet.newdesign.a.c cVar, FragmentActivity fragmentActivity, f fVar2) {
        String str6;
        aq aqVar2 = aqVar;
        f fVar3 = fVar;
        Context context2 = context;
        String str7 = str3;
        net.one97.paytm.wallet.newdesign.a.c cVar2 = cVar;
        f fVar4 = fVar2;
        if (fVar4.f55796a == h.SUCCESS) {
            aqVar2.f69653b = null;
            fVar.b();
            if (fVar4.f55797b instanceof CJRQRInfoResponse) {
                CJRQRInfoResponse cJRQRInfoResponse = (CJRQRInfoResponse) fVar4.f55797b;
                a(context, 200, str, fVar2, cJRQRInfoResponse.getStatusMessage(), str2, j, j2);
                if (cJRQRInfoResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                    JSONObject response = cJRQRInfoResponse.getResponse();
                    try {
                        response.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str7);
                    } catch (JSONException e2) {
                        q.d(String.valueOf(e2));
                    }
                    if (response == null) {
                        return;
                    }
                    if ("UTS".equals(response.optString("service"))) {
                        fVar3.a((IJRDataModel) (CJRBrtsUTS) new com.google.gsonhtcfix.f().a(response.optJSONObject("uts").toString(), new CJRBrtsUTS().getClass()));
                    } else if ("DEEPLINK".equals(response.optString("service"))) {
                        CJRExtendedInfoData cJRExtendedInfoData = (CJRExtendedInfoData) new com.google.gsonhtcfix.f().a(response.optJSONObject("extendedInfo").toString(), new CJRExtendedInfoData().getClass());
                        cJRExtendedInfoData.setQrCodeId(response.optString("qrCodeId"));
                        cJRExtendedInfoData.setmQRCodeRefrenceOrderID(response.optString("ORDER_ID"));
                        if (!TextUtils.isEmpty(cJRExtendedInfoData.getDeepLink())) {
                            a aVar = a.f69839a;
                            a.a("deeplink - " + cJRExtendedInfoData.getDeepLink(), z);
                            fVar3.a(cJRExtendedInfoData);
                            return;
                        }
                        fVar3.a(context2.getString(R.string.some_went_wrong));
                    } else {
                        boolean z3 = z;
                        a aVar2 = a.f69839a;
                        a.a(z);
                        a(context2, response, str7, str4, z2);
                        if (!zArr[0]) {
                            zArr[0] = false;
                            fVar3.a(response.toString(), true);
                        } else {
                            try {
                                a(context2, response.getString(CJRQRScanResultModel.KEY_TAG_LINE));
                            } catch (JSONException e3) {
                                q.d(String.valueOf(e3));
                            }
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(response.toString());
                            jSONObject.put("TXN_AMOUNT", "");
                            if (str5 == null) {
                                cVar2.a(context2, jSONObject.toString(), str7);
                            } else {
                                cVar2.b(context2, jSONObject.toString(), str7);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                } else {
                    fVar3.a(cJRQRInfoResponse.getStatusMessage());
                }
            } else {
                String str8 = "SUCCESS";
                if (fVar4.f55797b instanceof CJRQRInfoBrtsResponse) {
                    CJRQRInfoBrtsResponse cJRQRInfoBrtsResponse = (CJRQRInfoBrtsResponse) fVar4.f55797b;
                    a(context, 200, str, fVar2, cJRQRInfoBrtsResponse.getStatusMessage(), str2, j, j2);
                    if (cJRQRInfoBrtsResponse.getStatusCode().equalsIgnoreCase(str8)) {
                        fVar3.a((IJRDataModel) cJRQRInfoBrtsResponse);
                    } else {
                        fVar3.a(cJRQRInfoBrtsResponse.getStatusMessage());
                    }
                }
            }
        } else if (fVar4.f55796a == h.ERROR) {
            aqVar2.f69653b = null;
            fVar.b();
            int i2 = fVar4.f55798c.f55799a;
            if (fVar4.f55798c == null) {
                str6 = "NA";
            } else {
                str6 = fVar4.f55798c.f55801c.getAlertMessage();
            }
            a(context, i2, str, fVar2, str6, str2, j, j2);
            if (fVar4.f55798c == null || !(fVar4.f55798c.f55799a == 401 || fVar4.f55798c.f55799a == 410 || fVar4.f55798c.f55799a == 403)) {
                fVar3.a(context2.getString(R.string.wallet_error_qrinfo));
                return;
            }
            b.a().handleError(fragmentActivity, fVar4.f55798c.f55801c, "ScanNowFragmentGMS", (Bundle) null, false);
        }
    }
}

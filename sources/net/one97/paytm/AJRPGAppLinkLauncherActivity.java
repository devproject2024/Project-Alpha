package net.one97.paytm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.aa;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.utils.t;

public final class AJRPGAppLinkLauncherActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51627a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f51628b = "mWebAppInvokeOrderId";

    /* renamed from: c  reason: collision with root package name */
    private String f51629c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f51630d;

    static final class b extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Map $this_apply;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Map map) {
            super(1);
            this.$this_apply = map;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            k.c(str, "it");
            this.$this_apply.put("event_label", str);
        }
    }

    static final class c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Map $this_apply;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Map map) {
            super(1);
            this.$this_apply = map;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            k.c(str, "it");
            this.$this_apply.put("event_label3", str);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("applink_intent_data");
        k.a((Object) stringExtra, "intent.getStringExtra(\"applink_intent_data\")");
        this.f51629c = stringExtra;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("applink_uri_data");
        k.a((Object) parcelableExtra, "intent.getParcelableExtra(\"applink_uri_data\")");
        this.f51630d = (Uri) parcelableExtra;
        setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
        if (Build.VERSION.SDK_INT < 21) {
            String str = this.f51629c;
            if (str == null) {
                k.a("appLink");
            }
            Uri parse = Uri.parse(str);
            String queryParameter = parse != null ? parse.getQueryParameter(SDKConstants.orderId) : null;
            String string = SharedPreferenceUtil.getInstance().getString(this.f51628b, "");
            CharSequence charSequence = string;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = queryParameter;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    SharedPreferenceUtil.getInstance().setString(this.f51628b, queryParameter);
                }
            } else if (p.a(queryParameter, string, false)) {
                startActivity(new Intent(this, AJRMainActivity.class).setFlags(268435456));
                finish();
                return;
            } else {
                CharSequence charSequence3 = queryParameter;
                if (!(charSequence3 == null || charSequence3.length() == 0)) {
                    SharedPreferenceUtil.getInstance().setString(this.f51628b, queryParameter);
                }
            }
        }
        Context context = this;
        if (t.b(context) == null) {
            Intent intent = new Intent(context, AJRAuthActivity.class);
            intent.putExtra("launchSignUp", false);
            intent.putExtra("set_result_required", true);
            startActivityForResult(intent, 111);
            return;
        }
        a();
    }

    private final void a() {
        Uri uri = this.f51630d;
        if (uri == null) {
            k.a("applinkUri");
        }
        Uri uri2 = this.f51630d;
        if (uri2 == null) {
            k.a("applinkUri");
        }
        String path = uri2.getPath();
        if (path == null || !p.a((CharSequence) path, (CharSequence) "v1", true)) {
            Uri uri3 = this.f51630d;
            if (uri3 == null) {
                k.a("applinkUri");
            }
            String path2 = uri3.getPath();
            if (path2 != null && p.a((CharSequence) path2, (CharSequence) "v2", true)) {
                a(a("applink_type", uri.getQueryParameter("orderId"), "v2", uri.getQueryParameter("mid")));
            }
        } else {
            a(a("applink_type", uri.getQueryParameter("orderId"), "v1", uri.getQueryParameter("mid")));
        }
        aa aaVar = aa.f50292a;
        Context context = this;
        Uri uri4 = this.f51630d;
        if (uri4 == null) {
            k.a("applinkUri");
        }
        aa.a(context, uri4);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:62|63) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r0.setPackage((java.lang.String) null);
        startActivity(r0);
        r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams("callback_sent_error", r1);
        kotlin.g.b.k.a((java.lang.Object) r0, "SDKUtility.getAllInOneEv…llback_sent_error\",value)");
        a(r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0162 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            java.lang.String r0 = "SDKUtility.getAllInOneEv…US, SDKConstants.UNKNOWN)"
            java.lang.String r1 = "unknown"
            java.lang.String r2 = "amount"
            java.lang.String r3 = "mid"
            java.lang.String r4 = "orderId"
            java.lang.String r5 = "txnToken"
            java.lang.String r6 = "sourceUrl"
            java.lang.String r7 = "callback_sent_error"
            java.lang.String r8 = "transaction_status"
            super.onActivityResult(r12, r13, r14)
            r9 = 111(0x6f, float:1.56E-43)
            if (r12 != r9) goto L_0x0032
            r12 = r11
            android.content.Context r12 = (android.content.Context) r12
            boolean r12 = com.paytm.utility.a.p(r12)
            if (r12 == 0) goto L_0x002a
            r11.a()
            return
        L_0x002a:
            r12 = -1
            r11.setResult(r12, r14)
            r11.finish()
            return
        L_0x0032:
            r9 = 112(0x70, float:1.57E-43)
            if (r12 != r9) goto L_0x01bd
            r12 = 0
            android.net.Uri r9 = r11.f51630d     // Catch:{ Exception -> 0x0182 }
            if (r9 != 0) goto L_0x0040
            java.lang.String r10 = "applinkUri"
            kotlin.g.b.k.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0182 }
        L_0x0040:
            if (r9 == 0) goto L_0x0198
            java.lang.String r10 = r9.getQueryParameter(r6)     // Catch:{ Exception -> 0x0182 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0182 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0182 }
            if (r10 != 0) goto L_0x0198
            java.lang.String r6 = r9.getQueryParameter(r6)     // Catch:{ Exception -> 0x0182 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0182 }
            android.net.Uri$Builder r6 = r6.buildUpon()     // Catch:{ Exception -> 0x0182 }
            java.lang.String r10 = r9.getQueryParameter(r5)     // Catch:{ Exception -> 0x0182 }
            r6.appendQueryParameter(r5, r10)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r5 = r9.getQueryParameter(r4)     // Catch:{ Exception -> 0x0182 }
            r6.appendQueryParameter(r4, r5)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r4 = r9.getQueryParameter(r3)     // Catch:{ Exception -> 0x0182 }
            r6.appendQueryParameter(r3, r4)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r3 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x0182 }
            r6.appendQueryParameter(r2, r3)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r2 = "isAppInvoke"
            java.lang.String r3 = "true"
            r6.appendQueryParameter(r2, r3)     // Catch:{ Exception -> 0x0182 }
            r2 = 1
            if (r14 == 0) goto L_0x008f
            java.lang.String r3 = "isCancel"
            if (r13 != 0) goto L_0x0087
            r4 = 1
            goto L_0x0088
        L_0x0087:
            r4 = 0
        L_0x0088:
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0182 }
            r6.appendQueryParameter(r3, r4)     // Catch:{ Exception -> 0x0182 }
        L_0x008f:
            if (r14 == 0) goto L_0x00d0
            java.lang.String r3 = net.one97.paytm.nativesdk.Constants.SDKConstants.RESPONSE     // Catch:{ Exception -> 0x0182 }
            java.lang.String r3 = r14.getStringExtra(r3)     // Catch:{ Exception -> 0x0182 }
            if (r3 == 0) goto L_0x00d0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00be }
            java.lang.String r3 = "STATUS"
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x00be }
            if (r3 == 0) goto L_0x00b3
            java.util.Map r3 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r8, r3)     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = "SDKUtility.getAllInOneEv…I_TRANSACTION_STATUS, it)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00be }
            r11.a(r3)     // Catch:{ Exception -> 0x00be }
            goto L_0x00d0
        L_0x00b3:
            java.util.Map r3 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r8, r1)     // Catch:{ Exception -> 0x00be }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x00be }
            r11.a(r3)     // Catch:{ Exception -> 0x00be }
            goto L_0x00d0
        L_0x00be:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0182 }
            com.paytm.utility.q.d(r3)     // Catch:{ Exception -> 0x0182 }
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r8, r1)     // Catch:{ Exception -> 0x0182 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0182 }
            r11.a(r1)     // Catch:{ Exception -> 0x0182 }
        L_0x00d0:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0182 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0182 }
            android.net.Uri r1 = r6.build()     // Catch:{ Exception -> 0x0182 }
            r0.setData(r1)     // Catch:{ Exception -> 0x0182 }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r1 = "sourceName"
            java.lang.String r1 = r9.getQueryParameter(r1)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r3 = "googlechrome"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x00f8
            java.lang.String r2 = "com.android.chrome"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x00f8:
            java.lang.String r3 = "firefox"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x0106
            java.lang.String r2 = "org.mozilla.firefox"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x0106:
            java.lang.String r3 = "edge"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x0114
            java.lang.String r2 = "com.microsoft.emmx"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x0114:
            java.lang.String r3 = "opera"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x0122
            java.lang.String r2 = "com.opera.browser"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x0122:
            java.lang.String r3 = "uc"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x0131
            java.lang.String r2 = "com.UCMobile.intl"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x0131:
            java.lang.String r3 = "mi"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r3 == 0) goto L_0x013f
            java.lang.String r2 = "com.technicalnext.mibrowser"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x013f:
            java.lang.String r3 = "samsung"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            if (r2 == 0) goto L_0x014d
            java.lang.String r2 = "com.sec.android.app.sbrowser"
            r0.setPackage(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0150
        L_0x014d:
            r0.setPackage(r12)     // Catch:{ ActivityNotFoundException -> 0x0162 }
        L_0x0150:
            r11.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            java.lang.String r2 = "callback_sent"
            java.util.Map r2 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r2, r1)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            java.lang.String r3 = "SDKUtility.getAllInOneEv…ms(\"callback_sent\",value)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            r11.a(r2)     // Catch:{ ActivityNotFoundException -> 0x0162 }
            goto L_0x0174
        L_0x0162:
            r0.setPackage(r12)     // Catch:{ Exception -> 0x0182 }
            r11.startActivity(r0)     // Catch:{ Exception -> 0x0182 }
            java.util.Map r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r7, r1)     // Catch:{ Exception -> 0x0182 }
            java.lang.String r1 = "SDKUtility.getAllInOneEv…llback_sent_error\",value)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0182 }
            r11.a(r0)     // Catch:{ Exception -> 0x0182 }
        L_0x0174:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0182 }
            r1 = 21
            if (r0 < r1) goto L_0x017e
            r11.finishAndRemoveTask()     // Catch:{ Exception -> 0x0182 }
            return
        L_0x017e:
            r11.finish()     // Catch:{ Exception -> 0x0182 }
            return
        L_0x0182:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            java.lang.String r0 = "Redirection Failed"
            java.util.Map r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r7, r0)
            java.lang.String r1 = "SDKUtility.getAllInOneEv…or\",\"Redirection Failed\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r11.a(r0)
        L_0x0198:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = net.one97.paytm.nativesdk.Constants.SDKConstants.RESPONSE
            if (r14 == 0) goto L_0x01a8
            java.lang.String r2 = net.one97.paytm.nativesdk.Constants.SDKConstants.RESPONSE
            java.lang.String r2 = r14.getStringExtra(r2)
            goto L_0x01a9
        L_0x01a8:
            r2 = r12
        L_0x01a9:
            r0.putExtra(r1, r2)
            java.lang.String r1 = "nativeSdkForMerchantMessage"
            if (r14 == 0) goto L_0x01b4
            java.lang.String r12 = r14.getStringExtra(r1)
        L_0x01b4:
            r0.putExtra(r1, r12)
            r11.setResult(r13, r0)
            r11.finish()
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRPGAppLinkLauncherActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private void a(Map<String, Object> map) {
        k.c(map, "eventMap");
        try {
            map.put("user_id", com.paytm.utility.b.n(getApplicationContext()));
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, map, (Context) this);
        } catch (Exception unused) {
        }
    }

    private static Map<String, Object> a(String str, String str2, String str3, String str4) {
        Map<String, Object> allInOneEventParams = SDKUtility.getAllInOneEventParams(str, str3);
        ExtensionsKt.isNotNullNotBlank(str2, new b(allInOneEventParams));
        ExtensionsKt.isNotNullNotBlank(str4, new c(allInOneEventParams));
        k.a((Object) allInOneEventParams, "eventMap.apply {\n       …)\n            }\n        }");
        return allInOneEventParams;
    }
}

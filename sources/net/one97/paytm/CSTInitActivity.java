package net.one97.paytm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.utility.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.cst.a.a;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.h5.c;
import net.one97.paytm.upi.common.entity.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;

public class CSTInitActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    boolean f16174a;

    /* renamed from: b  reason: collision with root package name */
    private DeepLinkData f16175b;

    /* renamed from: c  reason: collision with root package name */
    private IJRDataModel f16176c;

    /* renamed from: d  reason: collision with root package name */
    private String f16177d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16178e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f16179f;

    /* renamed from: g  reason: collision with root package name */
    private final String f16180g = "cst";

    /* renamed from: h  reason: collision with root package name */
    private final String f16181h = "fd0f0ecc57a10b7ddd45e29d12415dd1b9e5147e";

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.f16179f = getIntent().getExtras();
        Bundle bundle2 = this.f16179f;
        if (bundle2 != null) {
            this.f16174a = bundle2.getBoolean("isH5", false);
            this.f16178e = this.f16179f.getBoolean("is_from_upi", false);
            this.f16176c = (IJRDataModel) this.f16179f.getSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM);
            this.f16177d = this.f16179f.getString("deeplink");
            if (!TextUtils.isEmpty(this.f16179f.getString("upiItem"))) {
                this.f16176c = (IJRDataModel) new f().a(this.f16179f.getString("upiItem"), UpiTransactionModelV2.class);
            }
        }
        if (getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.f16175b = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        }
        DeepLinkData deepLinkData = this.f16175b;
        if (!(deepLinkData == null || deepLinkData.f50289g == null)) {
            this.f16177d = this.f16175b.f50289g.toString();
        }
        a.a();
        if (!TextUtils.isEmpty(a.a("cstIssueListWebUrlV2", "https://webappsstatic.paytm.com/cst/v2/index.html"))) {
            StringBuilder sb = new StringBuilder();
            a.a();
            sb.append(a.a("cstIssueListWebUrlV2", "https://webappsstatic.paytm.com/cst/v2/index.html"));
            sb.append("?cst-home");
            str = sb.toString();
        } else {
            str = "";
        }
        u.a().a("cst", "fd0f0ecc57a10b7ddd45e29d12415dd1b9e5147e", str, a(), (String) null, (Context) this);
        c cVar = c.f50543a;
        c.a("cst", new c.b() {
            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                CSTInitActivity.this.a(str, cVar);
            }
        });
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1459599807:
                    if (str.equals("lastName")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -836030906:
                    if (str.equals("userId")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals(AppConstants.KEY_EMAIL)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 132835675:
                    if (str.equals("firstName")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 802258218:
                    if (str.equals("ssoToken")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                cVar.onResult(t.b((Context) this));
            } else if (c2 == 1) {
                cVar.onResult(b.h((Context) this));
            } else if (c2 == 2) {
                cVar.onResult(b.i((Context) this));
            } else if (c2 == 3) {
                cVar.onResult(com.paytm.utility.a.c((Context) this));
            } else if (c2 == 4) {
                cVar.onResult(com.paytm.utility.a.b((Context) this));
            } else if (c2 != 5) {
                cVar.onResult("");
            } else {
                cVar.onResult(com.paytm.utility.a.a((Context) this));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle a() {
        /*
            r9 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            net.one97.paytm.cst.model.WebViewInitialParams r1 = new net.one97.paytm.cst.model.WebViewInitialParams
            r1.<init>()
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            boolean r2 = r2.h((android.content.Context) r9)
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0041
            java.lang.String r2 = com.paytm.utility.b.ac(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x002a
            java.lang.String r2 = com.paytm.utility.b.ad(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0041
        L_0x002a:
            java.lang.String r2 = com.paytm.utility.b.ac(r9)
            if (r2 == 0) goto L_0x0035
            java.lang.String r2 = com.paytm.utility.b.ac(r9)
            goto L_0x0036
        L_0x0035:
            r2 = r3
        L_0x0036:
            java.lang.String r4 = com.paytm.utility.b.ad(r9)
            if (r4 == 0) goto L_0x0058
            java.lang.String r4 = com.paytm.utility.b.ad(r9)
            goto L_0x0059
        L_0x0041:
            java.lang.String r2 = com.paytm.utility.b.h((android.content.Context) r9)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = com.paytm.utility.b.h((android.content.Context) r9)
            goto L_0x004d
        L_0x004c:
            r2 = r3
        L_0x004d:
            java.lang.String r4 = com.paytm.utility.b.i((android.content.Context) r9)
            if (r4 == 0) goto L_0x0058
            java.lang.String r4 = com.paytm.utility.b.i((android.content.Context) r9)
            goto L_0x0059
        L_0x0058:
            r4 = r3
        L_0x0059:
            java.lang.String r5 = "24x7 Help"
            r1.setTitle(r5)
            java.lang.String r5 = "cstWidgetLanding"
            r1.setEntryPoint(r5)
            boolean r5 = com.paytm.utility.a.p(r9)
            if (r5 != 0) goto L_0x007a
            java.lang.String r5 = com.paytm.utility.a.d(r9)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x007a
            java.lang.String r5 = com.paytm.utility.a.d(r9)
            r1.setDeviceId(r5)
        L_0x007a:
            boolean r5 = r9.f16178e
            r6 = 1
            if (r5 == 0) goto L_0x0088
            r1.setFromBank(r6)
            java.lang.String r5 = "BANK"
            r1.setClient(r5)
            goto L_0x008d
        L_0x0088:
            java.lang.String r5 = "PAYTM"
            r1.setClient(r5)
        L_0x008d:
            java.lang.String r5 = r9.f16177d
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x009a
            java.lang.String r5 = r9.f16177d
            r1.setDeeplink(r5)
        L_0x009a:
            net.one97.paytm.deeplink.DeepLinkData r5 = r9.f16175b
            if (r5 == 0) goto L_0x00dd
            android.net.Uri r5 = r5.f50289g
            if (r5 == 0) goto L_0x00dd
            net.one97.paytm.deeplink.DeepLinkData r5 = r9.f16175b
            android.net.Uri r5 = r5.f50289g
            java.lang.String r7 = "issueListTab"
            java.lang.String r5 = r5.getQueryParameter(r7)
            if (r5 == 0) goto L_0x00dd
            net.one97.paytm.deeplink.DeepLinkData r5 = r9.f16175b
            android.net.Uri r5 = r5.f50289g
            java.lang.String r5 = r5.getQueryParameter(r7)
            java.lang.String r7 = "all"
            boolean r7 = r5.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00c3
            java.lang.String r7 = "0"
            r1.setSelectedIndex(r7)
        L_0x00c3:
            java.lang.String r7 = "open"
            boolean r7 = r5.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00d0
            java.lang.String r7 = "1"
            r1.setSelectedIndex(r7)
        L_0x00d0:
            java.lang.String r7 = "resolved"
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 == 0) goto L_0x00dd
            java.lang.String r5 = "2"
            r1.setSelectedIndex(r5)
        L_0x00dd:
            net.one97.paytm.common.entity.IJRDataModel r5 = r9.f16176c
            if (r5 == 0) goto L_0x00ef
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f
            r5.<init>()
            net.one97.paytm.common.entity.IJRDataModel r7 = r9.f16176c
            java.lang.String r5 = r5.a((java.lang.Object) r7)
            r1.setCstorderItem(r5)
        L_0x00ef:
            java.lang.String r5 = "Android"
            r1.setSource(r5)
            r1.setUser_first_name(r2)
            r1.setUser_last_name(r4)
            r2 = 0
            java.lang.String r4 = com.paytm.utility.c.a((android.content.Context) r9, (boolean) r2)
            r1.setRequestParameters(r4)
            r1.setH5_version(r6)
            java.lang.String r4 = com.paytm.utility.b.ab(r9)
            android.content.Context r5 = r9.getApplicationContext()
            com.paytm.b.a.a r5 = net.one97.paytm.utils.ag.a(r5)
            boolean r7 = com.paytm.utility.a.p(r9)
            if (r7 != 0) goto L_0x0127
            java.lang.String r7 = "oauth_cst_phone_number"
            java.lang.String r8 = r5.b((java.lang.String) r7, (java.lang.String) r3, (boolean) r6)
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0127
            java.lang.String r4 = r5.b((java.lang.String) r7, (java.lang.String) r3, (boolean) r6)
        L_0x0127:
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L_0x0130
            r1.setMobileNumber(r4)
        L_0x0130:
            android.os.Bundle r3 = r9.f16179f
            if (r3 == 0) goto L_0x01af
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            android.os.Bundle r4 = r9.f16179f
            java.util.Set r4 = r4.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0143:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01a8
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x019f }
            r7 = 19
            if (r6 < r7) goto L_0x0163
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ JSONException -> 0x019f }
            java.lang.Object r6 = org.json.JSONObject.wrap(r6)     // Catch:{ JSONException -> 0x019f }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x019f }
            goto L_0x0143
        L_0x0163:
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ JSONException -> 0x019f }
            boolean r6 = r6 instanceof java.lang.String     // Catch:{ JSONException -> 0x019f }
            if (r6 == 0) goto L_0x0177
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            java.lang.String r6 = r6.getString(r5)     // Catch:{ JSONException -> 0x019f }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x019f }
            goto L_0x0143
        L_0x0177:
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ JSONException -> 0x019f }
            boolean r6 = r6 instanceof java.lang.Boolean     // Catch:{ JSONException -> 0x019f }
            if (r6 == 0) goto L_0x018b
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            boolean r6 = r6.getBoolean(r5)     // Catch:{ JSONException -> 0x019f }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x019f }
            goto L_0x0143
        L_0x018b:
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ JSONException -> 0x019f }
            boolean r6 = r6 instanceof java.lang.Integer     // Catch:{ JSONException -> 0x019f }
            if (r6 == 0) goto L_0x0143
            android.os.Bundle r6 = r9.f16179f     // Catch:{ JSONException -> 0x019f }
            int r6 = r6.getInt(r5)     // Catch:{ JSONException -> 0x019f }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x019f }
            goto L_0x0143
        L_0x019f:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
            goto L_0x0143
        L_0x01a8:
            java.lang.String r3 = r3.toString()
            r1.setVerticalParams(r3)
        L_0x01af:
            com.google.gson.f r3 = new com.google.gson.f
            r3.<init>()
            java.lang.String r1 = r3.b(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "initParams"
            r0.putString(r3, r1)
            java.lang.String r1 = "showTitleBar"
            r0.putBoolean(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.CSTInitActivity.a():android.os.Bundle");
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}

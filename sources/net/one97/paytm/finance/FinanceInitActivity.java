package net.one97.paytm.finance;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamic.module.gold.GoldModuleHelper;
import net.one97.paytm.j.c;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class FinanceInitActivity extends AppCompatActivity {
    public static final String CIR_LAUNCH_URL_KEY = "fsCirLaunchUrl";
    private String CIR_PROD_LAUNCH_URL = "https://lms-static.paytm.com/cir/index.html";
    private final String DEFAULT_EMI_URL = "https://lms-static.paytm.com/lending-h5-emi/index.html";
    private final String DEFAULT_PERSONAL_LOAN_URL = "https://lms-static.paytm.com/h5-personal-loan/index.html";
    private final String DEFAULT_POSTPAID_LAUNCH_URL = "https://lending-h5-postpaid-frontend-prod.s3.ap-south-1.amazonaws.com/index.html";
    private String FINANCE_MODULE_NOT_ELIGIBLE_ACTIVITY = "com.finance.AJRPPNotEligible";
    private String PP_INTENT_EXTRA_REJECTION_REASON = "pp_intent_extra_rejection_reason";
    DeepLinkData deepLinkData;
    private boolean isGold = false;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        JarvisFinanceHelper.initFinanceApp((FinanceAccessProviderListener) null);
        this.isGold = false;
        if (getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA") != null) {
            this.deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            str = this.deepLinkData.f50283a;
            DeepLinkData deepLinkData2 = this.deepLinkData;
            if (!(deepLinkData2 == null || deepLinkData2.f50284b == null || !this.deepLinkData.f50284b.toLowerCase().contains("gold"))) {
                this.isGold = true;
            }
        } else if (getIntent().hasExtra("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            String deeplink = cJRHomePageItem.getDeeplink();
            if (!(cJRHomePageItem == null || cJRHomePageItem.getURLType() == null || !cJRHomePageItem.getURLType().toLowerCase().contains("gold"))) {
                this.isGold = true;
            }
            str = deeplink;
        } else {
            str = "";
        }
        DeepLinkData deepLinkData3 = this.deepLinkData;
        if (deepLinkData3 != null && deepLinkData3.f50289g != null && this.deepLinkData.f50289g.getQueryParameter("postpaidh5url") != null) {
            try {
                launchDev(URLDecoder.decode(this.deepLinkData.f50289g.getQueryParameter("postpaidh5url"), AppConstants.UTF_8));
            } catch (UnsupportedEncodingException e2) {
                q.b(e2.getMessage());
            }
        } else if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("paytm-postpaid")) {
            launchPostpaid();
        } else if (this.isGold) {
            handleThroughH5(getIntent(), this);
        }
        DeepLinkData deepLinkData4 = this.deepLinkData;
        if (!(deepLinkData4 == null || deepLinkData4.f50289g == null || !this.deepLinkData.f50284b.equalsIgnoreCase("fs-cir"))) {
            launchCIR();
        }
        DeepLinkData deepLinkData5 = this.deepLinkData;
        if (deepLinkData5 != null && deepLinkData5.f50289g != null && this.deepLinkData.f50289g.getQueryParameter("loanh5url") != null) {
            try {
                launchDev(URLDecoder.decode(this.deepLinkData.f50289g.getQueryParameter("loanh5url"), AppConstants.UTF_8));
            } catch (UnsupportedEncodingException e3) {
                q.b(e3.getMessage());
            }
        } else if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("personal-loan")) {
            launchPL();
        }
        DeepLinkData deepLinkData6 = this.deepLinkData;
        if (deepLinkData6 != null && deepLinkData6.f50289g != null && this.deepLinkData.f50289g.getQueryParameter("emih5url") != null) {
            try {
                launchDev(URLDecoder.decode(this.deepLinkData.f50289g.getQueryParameter("emih5url"), AppConstants.UTF_8));
            } catch (UnsupportedEncodingException e4) {
                q.b(e4.getMessage());
            }
        } else if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("paytm-emi")) {
            launchEMI();
        }
    }

    private void handleThroughH5(Intent intent, Context context) {
        CJRHomePageItem cJRHomePageItem;
        DeepLinkData deepLinkData2;
        if (intent.hasExtra("extra_home_data")) {
            cJRHomePageItem = (CJRHomePageItem) getIntent().getExtras().getSerializable("extra_home_data");
        } else {
            cJRHomePageItem = new CJRHomePageItem();
        }
        intent.putExtra("extra_is_default_param_reqd", true);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        this.deepLinkData = (DeepLinkData) intent.getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        if ((!intent.getBooleanExtra("isFromClick", false) || !intent.hasExtra("extra_home_data")) && (deepLinkData2 = this.deepLinkData) != null && !TextUtils.isEmpty(deepLinkData2.f50283a)) {
            Uri.parse(this.deepLinkData.f50283a).getQueryParameter(UpiConstants.FROM);
            String str = null;
            if (this.deepLinkData.f50283a.contains("paytmmp")) {
                String host = this.deepLinkData.f50289g.getHost();
                if (!TextUtils.isEmpty(host)) {
                    cJRHomePageItem.setUrlType(host);
                }
                cJRHomePageItem.setDeeplink(this.deepLinkData.f50283a);
                if (this.deepLinkData.f50283a.contains("recharge_number")) {
                    String queryParameter = this.deepLinkData.f50289g.getQueryParameter("recharge_number");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        intent.putExtra("mobile", queryParameter);
                    }
                }
                Uri build = Uri.parse(this.deepLinkData.f50283a).buildUpon().build();
                Set<String> queryParameterNames = build.getQueryParameterNames();
                Bundle bundle = new Bundle();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String next : queryParameterNames) {
                        bundle.putString(next, build.getQueryParameters(next).get(0));
                    }
                    List<String> queryParameters = build.getQueryParameters(UpiConstants.FROM);
                    if (queryParameters != null && queryParameters.contains("Order_history")) {
                        openGoldH5Page();
                        return;
                    }
                }
                String stringExtra = intent.getStringExtra(this.PP_INTENT_EXTRA_REJECTION_REASON);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase("notEligible")) {
                    str = this.FINANCE_MODULE_NOT_ELIGIBLE_ACTIVITY;
                }
                if (!TextUtils.isEmpty(str)) {
                    intent.setClassName(context, str);
                    intent.putExtra("extra_home_data", cJRHomePageItem);
                    context.startActivity(intent);
                    return;
                }
                openGoldH5Page();
                return;
            }
            return;
        }
        openGoldH5Page();
    }

    public void attachBaseContext(Context context) {
        try {
            Class.forName("net.one97.paytm.finance.FinanceDataProvider").getDeclaredMethod("initFianceApp", new Class[]{Context.class}).invoke((Object) null, new Object[]{CJRJarvisApplication.getAppContext()});
        } catch (Exception e2) {
            try {
                StringBuilder sb = new StringBuilder("Application oncreate : ");
                sb.append(e2.getLocalizedMessage());
                sb.append(StringUtility.NEW_LINE);
                sb.append(e2.getCause());
                q.b(e2.getMessage());
            } catch (Exception e3) {
                StringBuilder sb2 = new StringBuilder("Application oncreate : ");
                sb2.append(e3.getLocalizedMessage());
                sb2.append(StringUtility.NEW_LINE);
                sb2.append(e3.getCause());
                q.b(e3.getMessage());
            }
        }
        super.attachBaseContext(context);
        a.a((Context) this);
        a.b((Context) this);
    }

    private void openGoldH5Page() {
        GoldModuleHelper.INSTANCE.loadGoldControllerActivity(this, this.deepLinkData);
    }

    private void launchPostpaid() {
        c.a();
        String a2 = c.a("pph5onboarding", "");
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONObject jSONObject = new JSONObject(a2).getJSONObject("android");
                jSONObject.getString("render");
                jSONObject.getString("minVersion");
                openPPH5(jSONObject.getString("h5url"));
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else {
            openPPH5("https://lending-h5-postpaid-frontend-prod.s3.ap-south-1.amazonaws.com/index.html");
        }
    }

    private void openPPH5(String str) {
        String str2;
        DeepLinkData deepLinkData2 = this.deepLinkData;
        if (!(deepLinkData2 == null || deepLinkData2.f50289g == null)) {
            String[] split = this.deepLinkData.f50289g.toString().split("\\?");
            if (split.length >= 2) {
                str2 = AppConstants.AND_SIGN + split[1];
                Bundle bundle = new Bundle();
                bundle.putBoolean("canPullDown", false);
                bundle.putBoolean("pullRefresh", false);
                bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
                bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
                u.a().a("gold", "e9cb11f8ff1da1ee4eaa7b2d4c33f89a983175ca", str + "?os=android" + str2, bundle, "", (Context) this);
            }
        }
        str2 = "";
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("canPullDown", false);
        bundle2.putBoolean("pullRefresh", false);
        bundle2.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle2.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        u.a().a("gold", "e9cb11f8ff1da1ee4eaa7b2d4c33f89a983175ca", str + "?os=android" + str2, bundle2, "", (Context) this);
    }

    private void launchDev(String str) {
        String str2;
        DeepLinkData deepLinkData2 = this.deepLinkData;
        if (!(deepLinkData2 == null || deepLinkData2.f50289g == null)) {
            String[] split = this.deepLinkData.f50289g.toString().split("\\?");
            if (split.length == 2) {
                str2 = AppConstants.AND_SIGN + split[1];
                Bundle bundle = new Bundle();
                bundle.putBoolean("canPullDown", false);
                bundle.putBoolean("pullRefresh", false);
                bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
                bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
                u.a().a("gold", "e9cb11f8ff1da1ee4eaa7b2d4c33f89a983175ca", str + "?os=android" + str2, bundle, "", (Context) this);
            }
        }
        str2 = "";
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("canPullDown", false);
        bundle2.putBoolean("pullRefresh", false);
        bundle2.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle2.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        u.a().a("gold", "e9cb11f8ff1da1ee4eaa7b2d4c33f89a983175ca", str + "?os=android" + str2, bundle2, "", (Context) this);
    }

    private void launchCIR() {
        String str;
        c.a();
        String a2 = c.a(CIR_LAUNCH_URL_KEY, (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.CIR_PROD_LAUNCH_URL;
        }
        DeepLinkData deepLinkData2 = this.deepLinkData;
        String str2 = "";
        if (deepLinkData2 == null || deepLinkData2.f50289g == null) {
            str = str2;
        } else {
            str = !TextUtils.isEmpty(this.deepLinkData.f50289g.getPath()) ? this.deepLinkData.f50289g.getPath() : str2;
            if (!TextUtils.isEmpty(this.deepLinkData.f50289g.getQuery())) {
                str2 = AppConstants.AND_SIGN + this.deepLinkData.f50289g.getQuery();
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("canPullDown", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
        bundle.putString("paytmChangeBackButtonColor", "#000000");
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        u.a().a("gold", "32f73f046fa80272c55dfa4cadfec575ba0a716c", a2 + str + "?os=android" + str2, bundle, "", (Context) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchPL() {
        /*
            r10 = this;
            net.one97.paytm.j.c.a()
            java.lang.String r0 = ""
            java.lang.String r1 = "lendingplh5"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x002b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0023 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = "android"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "h5url"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x002d
        L_0x0023:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
        L_0x002b:
            java.lang.String r1 = "https://lms-static.paytm.com/h5-personal-loan/index.html"
        L_0x002d:
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            if (r2 == 0) goto L_0x0072
            android.net.Uri r2 = r2.f50289g
            if (r2 == 0) goto L_0x0072
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            android.net.Uri r2 = r2.f50289g
            java.lang.String r2 = r2.getPath()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x004c
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            android.net.Uri r2 = r2.f50289g
            java.lang.String r2 = r2.getPath()
            goto L_0x004d
        L_0x004c:
            r2 = r0
        L_0x004d:
            net.one97.paytm.deeplink.DeepLinkData r3 = r10.deepLinkData
            android.net.Uri r3 = r3.f50289g
            java.lang.String r3 = r3.getQuery()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0073
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "&"
            r0.<init>(r3)
            net.one97.paytm.deeplink.DeepLinkData r3 = r10.deepLinkData
            android.net.Uri r3 = r3.f50289g
            java.lang.String r3 = r3.getQuery()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            goto L_0x0073
        L_0x0072:
            r2 = r0
        L_0x0073:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r3 = 0
            java.lang.String r4 = "canPullDown"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "pullRefresh"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "showTitleBar"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "titleVerticalDivider"
            r7.putBoolean(r4, r3)
            java.lang.String r3 = "paytmChangeBackButtonColor"
            java.lang.String r4 = "#000000"
            r7.putString(r3, r4)
            java.lang.String r3 = "showProgress"
            java.lang.String r4 = "NO"
            r7.putString(r3, r4)
            net.one97.paytm.deeplink.u r3 = net.one97.paytm.deeplink.u.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = "?os=android"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r6 = r4.toString()
            java.lang.String r4 = "gold"
            java.lang.String r5 = "32f73f046fa80272c55dfa4cadfec575ba0a716c"
            java.lang.String r8 = ""
            r9 = r10
            r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (android.os.Bundle) r7, (java.lang.String) r8, (android.content.Context) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.finance.FinanceInitActivity.launchPL():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchEMI() {
        /*
            r10 = this;
            net.one97.paytm.j.c.a()
            java.lang.String r0 = ""
            java.lang.String r1 = "lendingemih5"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x002b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0023 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = "android"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "h5url"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x002d
        L_0x0023:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
        L_0x002b:
            java.lang.String r1 = "https://lms-static.paytm.com/lending-h5-emi/index.html"
        L_0x002d:
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            if (r2 == 0) goto L_0x0072
            android.net.Uri r2 = r2.f50289g
            if (r2 == 0) goto L_0x0072
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            android.net.Uri r2 = r2.f50289g
            java.lang.String r2 = r2.getPath()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x004c
            net.one97.paytm.deeplink.DeepLinkData r2 = r10.deepLinkData
            android.net.Uri r2 = r2.f50289g
            java.lang.String r2 = r2.getPath()
            goto L_0x004d
        L_0x004c:
            r2 = r0
        L_0x004d:
            net.one97.paytm.deeplink.DeepLinkData r3 = r10.deepLinkData
            android.net.Uri r3 = r3.f50289g
            java.lang.String r3 = r3.getQuery()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0073
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "&"
            r0.<init>(r3)
            net.one97.paytm.deeplink.DeepLinkData r3 = r10.deepLinkData
            android.net.Uri r3 = r3.f50289g
            java.lang.String r3 = r3.getQuery()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            goto L_0x0073
        L_0x0072:
            r2 = r0
        L_0x0073:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r3 = 0
            java.lang.String r4 = "canPullDown"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "pullRefresh"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "showTitleBar"
            r7.putBoolean(r4, r3)
            java.lang.String r4 = "titleVerticalDivider"
            r7.putBoolean(r4, r3)
            java.lang.String r3 = "paytmChangeBackButtonColor"
            java.lang.String r4 = "#000000"
            r7.putString(r3, r4)
            java.lang.String r3 = "showProgress"
            java.lang.String r4 = "NO"
            r7.putString(r3, r4)
            net.one97.paytm.deeplink.u r3 = net.one97.paytm.deeplink.u.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = "?os=android"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r6 = r4.toString()
            java.lang.String r4 = "gold"
            java.lang.String r5 = "32f73f046fa80272c55dfa4cadfec575ba0a716c"
            java.lang.String r8 = ""
            r9 = r10
            r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (android.os.Bundle) r7, (java.lang.String) r8, (android.content.Context) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.finance.FinanceInitActivity.launchEMI():void");
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}

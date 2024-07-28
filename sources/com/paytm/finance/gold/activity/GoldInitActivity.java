package com.paytm.finance.gold.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.finance.gold.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Set;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class GoldInitActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private DeepLinkData f13419a;

    /* renamed from: b  reason: collision with root package name */
    private String f13420b = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = a.f13415b;
        this.f13420b = a.a(getApplicationContext());
        if (getIntent().getExtras() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.f13419a = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        }
        String a2 = a();
        if (URLUtil.isValidUrl(a2)) {
            a aVar2 = a.f13415b;
            DeepLinkData deepLinkData = this.f13419a;
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("canPullDown", false);
            bundle2.putBoolean("pullRefresh", false);
            bundle2.putBoolean("paytmShowTitleBar", false);
            bundle2.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
            bundle2.putString("paytmChangeStatusBarColor", "#ffffff");
            bundle2.putString("paytmChangeBackButtonColor", "#000000");
            bundle2.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle2.putString("showLoading", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
            a.a(this, a2, deepLinkData, bundle2);
        } else {
            finish();
        }
        finish();
    }

    private String a() {
        String str = (TextUtils.isEmpty(this.f13420b) || !this.f13420b.equals(SDKConstants.KEY_STAGING_API)) ? "https://paytm.com/digitalgoldV2" : "https://staging.paytm.com/digitalgoldV2";
        DeepLinkData deepLinkData = this.f13419a;
        String str2 = "&ver=3";
        if (deepLinkData != null) {
            if (deepLinkData.f50289g != null) {
                String[] split = this.f13419a.f50289g.toString().split("\\?");
                if (split.length == 2) {
                    str2 = str2 + AppConstants.AND_SIGN + split[1];
                }
            }
            if (!TextUtils.isEmpty(this.f13419a.f50284b) && !this.f13419a.f50284b.equalsIgnoreCase("digital-gold") && !this.f13419a.f50284b.equalsIgnoreCase("gold")) {
                str2 = str2 + "&pageName=" + this.f13419a.f50284b;
            }
            try {
                Uri build = Uri.parse(this.f13419a.f50283a).buildUpon().build();
                Set<String> queryParameterNames = build.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    String str3 = build.getQueryParameters("order_id").get(0);
                    String str4 = build.getQueryParameters("order-summary-type").get(0);
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && str4.toLowerCase().equals("gold")) {
                        try {
                            str = str + "/orderConfirmation";
                        } catch (Exception unused) {
                        }
                        str2 = str2 + "&orderId=" + str3;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return str + "?os=android" + str2;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}

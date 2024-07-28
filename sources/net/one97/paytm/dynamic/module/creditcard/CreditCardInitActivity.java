package net.one97.paytm.dynamic.module.creditcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.g;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.j.c;
import net.one97.paytm.utils.ag;

public class CreditCardInitActivity extends AppCompatActivity {
    public static final String PROD_URL = "https://webappsstatic.paytm.com/firstcard/v1/index.html";
    private static final String STAGING_URL = "https://webappsstatic-stg.s3.ap-south-1.amazonaws.com/firstcard/v1/index.html";
    private String activityNameFlag;
    private DeepLinkData deepLinkData;
    private String productId;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CreditImplProvider.init(getApplicationContext());
        checkForDeepLinkIntent(getIntent(), this);
        finish();
    }

    private void checkForDeepLinkIntent(Intent intent, Context context) {
        if (getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            DeepLinkData deepLinkData2 = this.deepLinkData;
            if (!(deepLinkData2 == null || deepLinkData2.f50289g == null || this.deepLinkData.f50289g.getQueryParameter("productId") == null)) {
                this.productId = this.deepLinkData.f50289g.getQueryParameter("productId");
            }
        }
        CreditCardConstant.saveProductId(this, this.productId);
        this.activityNameFlag = intent.getStringExtra("EXTRA_ACTIVITY_FLAG");
        String str = this.activityNameFlag;
        if (str == null || !str.equalsIgnoreCase(g.a.CCPassbookAuthActivity.name())) {
            launchH5Page("");
        } else {
            launchH5Page("?login");
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    private void launchH5Page(String str) {
        c.a();
        String a2 = c.a("firstCardFormFlow", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = PROD_URL;
        }
        if (isUatFormType()) {
            c.a();
            a2 = c.a("firstCardUatFormFlow", (String) null);
        }
        String str2 = a2 + str;
        Bundle bundle = new Bundle();
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putString("entryPoint", "creditCardPage");
        if (isAuthUser()) {
            u.a().a(CreditCardConstant.CREDIT_CARD_VERTICAL_NAME, CreditCardConstant.H5_CreditCard_Id, str2, bundle, (String) null, (Context) this);
            return;
        }
        Intent intent = new Intent(this, AJRAuthActivity.class);
        intent.putExtra("resultant activity", "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("isFromPCC", true);
        if (isUatFormType()) {
            bundle2.putString("formType", getIntent().getExtras().getString("formType"));
        }
        intent.putExtra("resultant activity_bundle", bundle2);
        intent.putExtra("EXTRA_ACTIVITY_FLAG", this.activityNameFlag);
        startActivityForResult(intent, 4);
    }

    private boolean isAuthUser() {
        String b2 = ag.a(getApplicationContext()).b("sso_token=", "", true);
        if (b2 == "" || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    private boolean isUatFormType() {
        if (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("formType")) {
            return false;
        }
        String string = getIntent().getExtras().getString("formType");
        return !TextUtils.isEmpty(string) && "uat".equalsIgnoreCase(string);
    }
}

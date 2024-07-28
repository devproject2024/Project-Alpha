package net.one97.paytm.nearbuy_h5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class NearbuyInitActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    DeepLinkData f14207a;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        DeepLinkData deepLinkData;
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.f14207a = (DeepLinkData) getIntent().getExtras().getParcelable("EXTRA_DEEP_LINK_DATA");
            if (this.f14207a.f50284b.equalsIgnoreCase("nearbuy") && (deepLinkData = this.f14207a) != null && !TextUtils.isEmpty(deepLinkData.f50284b)) {
                String str = "https://h5.nearbuy.com/";
                if (deepLinkData.f50289g != null) {
                    if (deepLinkData.f50289g.getQueryParameter("h5_url") != null) {
                        str = deepLinkData.f50289g.getQueryParameter("h5_url");
                    } else {
                        a aVar = a.f55773a;
                        if (SDKConstants.KEY_STAGING_API.equalsIgnoreCase(a.a())) {
                            str = "https://www.nearbuystag.in";
                        }
                        if (!TextUtils.isEmpty(deepLinkData.f50289g.getQuery())) {
                            str = str + "?" + deepLinkData.f50289g.getQuery();
                        }
                    }
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("canPullDown", false);
                bundle2.putBoolean("pullRefresh", false);
                bundle2.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
                bundle2.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
                bundle2.putString("paytmChangeBackButtonColor", "#000000");
                bundle2.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
                u.a().a("nearbuy", "978832f7059a81e7c443187e5967fa4d9ac0b7fc", str, bundle2, "", (Context) this);
            }
        }
        finish();
    }
}

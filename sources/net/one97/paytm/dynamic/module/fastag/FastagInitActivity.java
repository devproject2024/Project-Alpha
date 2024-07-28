package net.one97.paytm.dynamic.module.fastag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.fastag.ui.activity.FasTagPostPaymentActivity;
import net.one97.paytm.upi.util.UpiConstants;

public class FastagInitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FastagImplProvider.init();
        checkForDeepLinkIntent(getIntent(), this);
        finish();
    }

    private void checkForDeepLinkIntent(Intent intent, Context context) {
        String str;
        String str2;
        if (intent.getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            DeepLinkData deepLinkData = (DeepLinkData) intent.getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            if (deepLinkData != null && "fastag_toll".equalsIgnoreCase(deepLinkData.f50284b)) {
                new CJRHomePageItem();
                Uri uri = deepLinkData.f50289g;
                if (deepLinkData.f50289g != null) {
                    str2 = uri.getQueryParameter("orderid");
                    str = uri.getQueryParameter("itemid");
                } else {
                    Bundle bundle = deepLinkData.f50290h;
                    String string = bundle.getString("orderid", "");
                    str = bundle.getString("itemid", "");
                    str2 = string;
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.setClass(context, FasTagPostPaymentActivity.class);
                    intent.putExtra("KEY_ORDER_ID_TO_TRACK", str2);
                    intent.putExtra("KEY_ITEM_ID_TO_TRACK", str);
                    h.a aVar = h.f50349a;
                    h.a.a(this, "paytmmall://itemdetails?url=https://cart.paytm.com/v2/myOrders/" + str2 + "/detail?actions=1&item_tracking=1&single_card=true", (Bundle) null);
                    return;
                }
                h.a aVar2 = h.f50349a;
                h.a.a(this, "paytmmp://homepage?url=https://storefront.paytm.com/v2/h/fastag-and-toll", (Bundle) null);
                return;
            }
            return;
        }
        h.a aVar3 = h.f50349a;
        h.a.a(this, "paytmmp://homepage?url=https://storefront.paytm.com/v2/h/fastag-and-toll", (Bundle) null);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void reInitialized() {
        FastagImplProvider.init();
    }
}

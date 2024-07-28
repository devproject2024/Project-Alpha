package com.paytmmall.clpartifact.utils;

import android.content.Context;
import com.paytm.ads.PaytmAdView;
import com.paytm.ads.b;
import com.paytm.utility.CJRSecureSharedPreferences;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;

public class AdSdkUtils {
    public static void adsdkSetAdsParams(PaytmAdView paytmAdView, CJRHomePageLayoutV2.Displaymetadata.Metadata metadata, String str) {
        if (metadata != null) {
            try {
                PaytmAdView a2 = paytmAdView.a(new b(metadata.getVendor_key(), metadata.getVerification_parameters(), metadata.getJavascript_resource_url()));
                a2.f40856e = str;
                a2.a(metadata.getImpression_pixel1()).a(metadata.getImpression_pixel2()).a(metadata.getImpression_pixel3());
            } catch (Exception unused) {
            }
        }
    }

    public static String getrequestid(Context context) {
        return CJRSecureSharedPreferences.getInstance(context.getApplicationContext()).getString(CLPConstants.ADSSDKREQUESTID, (String) null);
    }
}

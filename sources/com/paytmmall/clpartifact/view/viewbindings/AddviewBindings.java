package com.paytmmall.clpartifact.view.viewbindings;

import android.text.TextUtils;
import com.paytm.ads.PaytmAdView;
import com.paytm.ads.b;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public class AddviewBindings {
    public static void setAddView(PaytmAdView paytmAdView, Item item, String str) {
        if (item.getMdisplaymetadata() != null && item.getMdisplaymetadata().getMmetadata() != null) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                str = (CLPArtifact.getInstance() == null || CLPArtifact.getInstance().getCommunicationListener() == null) ? str2 : CLPArtifact.getInstance().getCommunicationListener().getClientRequestID();
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str + item.getId();
            }
            setParams(paytmAdView, str2, item.getMdisplaymetadata().getMmetadata());
        }
    }

    private static void setParams(PaytmAdView paytmAdView, String str, Item.Displaymetadata.Metadata metadata) {
        if (metadata != null) {
            try {
                PaytmAdView a2 = paytmAdView.a(new b(metadata.getVendor_key(), metadata.getVerification_parameters(), metadata.getJavascript_resource_url()));
                a2.f40856e = str;
                a2.a(metadata.getImpression_pixel1()).a(metadata.getImpression_pixel2()).a(metadata.getImpression_pixel3());
            } catch (Exception unused) {
            }
        }
    }
}

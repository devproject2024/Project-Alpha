package com.travel.sale.data;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.d;
import com.travel.sale.data.model.CampaignSubscriptionResponse;
import com.travel.travelPreferences.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class a {
    public static void a(Context context, b bVar, String str, boolean z) {
        k.c(context, "context");
        k.c(bVar, "paytmCommonApiListener");
        k.c(str, "campaignId");
        com.paytm.network.b a2 = a(context, str, bVar, z);
        if (a2 != null) {
            com.paytm.network.a l = a2.l();
            if (l != null) {
                l.b(true);
            }
            if (l != null) {
                l.a();
                return;
            }
            return;
        }
        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }

    private static com.paytm.network.b a(Context context, String str, b bVar, boolean z) {
        k.a((Object) d.a(), "TravelController.getInstance()");
        String str2 = d.b().a("subscribeTravelCampaign") + str + "/subscribe";
        if (TextUtils.isEmpty(str2) || context == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(a(context));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("isAddedToCalendar", String.valueOf(z));
        return new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_sales_campaign_details").a(a.C0715a.GET).a(Uri.parse(str2).buildUpon().build().toString()).a((Map<String, String>) hashMap).b((Map) hashMap2).a((IJRPaytmDataModel) new CampaignSubscriptionResponse()).a(bVar);
    }

    public static HashMap<String, String> a(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        String c2 = c.c(context);
        CharSequence charSequence = c2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            hashMap.put(AppConstants.SSO_TOKEN, c2);
        }
        return hashMap;
    }
}

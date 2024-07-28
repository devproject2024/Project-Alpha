package net.one97.paytm.dynamic.module.movie;

import android.content.Context;
import com.paytm.utility.q;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.amusementpark.a;

public class AmparkAnalyticsHandlerImpl implements a.C1469a {
    public void sendPaytmAssistGAEvents(String str, String str2, Context context) {
    }

    public void sendCustomEventWithMap(String str, Map<String, ?> map, Context context) {
        try {
            net.one97.paytm.j.a.b(str, (Map<String, Object>) map, context);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context) {
        net.one97.paytm.j.a.a(str, cJRHomePageItem, context);
    }

    public <T> void sendEventToPaytmAnalytics(T t, String str, boolean z) {
        net.one97.paytm.j.a.b(t, str);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        net.one97.paytm.j.a.e(cJRHomePageItem, context, i2, str2);
    }

    public void sendPromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str) {
        net.one97.paytm.j.a.a(cJRHomePageItem, context, i2, str);
    }
}

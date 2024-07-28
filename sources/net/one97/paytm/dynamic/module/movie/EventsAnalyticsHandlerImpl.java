package net.one97.paytm.dynamic.module.movie;

import android.content.Context;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.deeplink.k;
import net.one97.paytm.o2o.events.a;
import net.one97.paytm.y;

public class EventsAnalyticsHandlerImpl implements a.C1478a {
    public void sendGTMOrderSummaryTag(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, Boolean bool, String str2, String str3, Long l) {
    }

    public void sendCrashlyticsLogs(String str) {
        k.a(str);
    }

    public void sendCustomEventWithMap(String str, Map<String, ?> map, Context context) {
        net.one97.paytm.j.a.b(str, (Map<String, Object>) map, context);
    }

    public <T> void sendEventToPaytmAnalytics(T t, String str, Boolean bool) {
        bool.booleanValue();
        net.one97.paytm.j.a.b(t, str);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, Context context) {
        net.one97.paytm.j.a.a(cJROrderSummary, yVar, context);
    }

    public void sendPromotionClickforevents(CJRHomePageItem cJRHomePageItem, Context context, Integer num, String str) {
        net.one97.paytm.j.a.d(cJRHomePageItem, context, num.intValue(), str);
    }

    public void sendPromotionImpressionforevents(CJRHomePageItem cJRHomePageItem, Context context, Integer num, String str) {
        net.one97.paytm.j.a.c(cJRHomePageItem, context, num.intValue(), str);
    }
}

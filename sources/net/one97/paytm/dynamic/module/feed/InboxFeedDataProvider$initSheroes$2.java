package net.one97.paytm.dynamic.module.feed;

import android.content.Context;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import java.util.Map;
import net.one97.paytm.j.a;

final class InboxFeedDataProvider$initSheroes$2 implements SheroesSdk.AnalyticsCallback {
    final /* synthetic */ Context $context;

    InboxFeedDataProvider$initSheroes$2(Context context) {
        this.$context = context;
    }

    public final void onEventTriggered(Map<String, Object> map) {
        try {
            a.b(GAUtil.CUSTOM_EVENT, map, this.$context);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}

package net.one97.paytm.feed.ui.feed.l;

import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.bs;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class b extends net.one97.paytm.feed.ui.base.b<bs, FeedRecommendedApps, Object> {

    /* renamed from: b  reason: collision with root package name */
    private a f35093b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f35094c;

    /* renamed from: d  reason: collision with root package name */
    private int f35095d;

    public final void a(FeedRecommendedApps feedRecommendedApps) {
        k.c(feedRecommendedApps, "data");
        bs bsVar = (bs) this.f34872a;
        bsVar.setVariable(a.f33780g, feedRecommendedApps);
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(a.f33775b), new net.one97.paytm.feed.ui.feed.a())).entrySet()) {
            bsVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        TabLayout tabLayout = this.f35094c;
        if (tabLayout != null) {
            tabLayout.b();
            Iterator<RecommendedApps> it2 = feedRecommendedApps.getFeedRecommendedAppsData().getAppsList().iterator();
            while (it2.hasNext()) {
                it2.next();
                TabLayout.f a2 = tabLayout.a();
                int i2 = R.drawable.feed_recommended_tab_selector;
                if (a2.f36768h != null) {
                    tabLayout.a(a2.a(androidx.appcompat.a.a.a.b(a2.f36768h.getContext(), i2)));
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            TabLayout.f a3 = tabLayout.a(this.f35095d);
            if (a3 != null) {
                a3.d();
            }
        }
        a aVar = this.f35093b;
        if (aVar != null) {
            k.c(feedRecommendedApps, "data");
            aVar.f35092c.clear();
            aVar.f35092c.addAll(feedRecommendedApps.getFeedRecommendedAppsData().getAppsList());
            aVar.notifyDataSetChanged();
            aVar.f35090a = feedRecommendedApps.getFeedRecommendedAppsData().getTitle();
            aVar.f35091b = feedRecommendedApps.getFeedRecommendedAppsData().getViewAllUrl();
        }
    }
}

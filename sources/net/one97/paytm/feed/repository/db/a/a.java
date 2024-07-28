package net.one97.paytm.feed.repository.db.a;

import androidx.lifecycle.LiveData;
import java.util.List;
import net.one97.paytm.feed.repository.models.FeedData;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.repository.models.polls.PollsData;
import net.one97.paytm.feed.repository.models.promobanner.Banner;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.trending.Trending;

public interface a {
    long a(FeedData feedData);

    LiveData<List<FeedDataMinimal>> a();

    LiveData<List<FeedDataMinimal>> a(String str, String str2, String str3);

    void a(int i2, boolean z);

    void a(String str);

    void a(String str, boolean z);

    void a(FeedOfFeed feedOfFeed);

    void a(Channel channel);

    void a(Brand brand);

    void a(PollsData pollsData);

    void a(Banner banner);

    void a(RecommendedApps recommendedApps);

    void a(Stories stories);

    void a(Trending trending);

    void a(boolean z, String str);

    LiveData<List<FeedDataMinimal>> b();

    void b(int i2, boolean z);

    void b(String str);

    void b(String str, boolean z);

    LiveData<List<FeedDataMinimal>> c();

    void c(String str);

    void c(String str, boolean z);

    LiveData<List<FeedDataMinimal>> d();

    void d(String str);

    void d(String str, boolean z);

    LiveData<List<FeedDataMinimal>> e();

    void e(String str);

    void e(String str, boolean z);

    LiveData<List<FeedDataMinimal>> f();

    LiveData<FeedDataMinimal> f(String str);

    void f(String str, boolean z);

    LiveData<FeedDataMinimal> g(String str);

    void g();

    void h();

    void i();

    void j();

    void k();

    void l();

    void m();

    void n();

    void o();

    void p();
}

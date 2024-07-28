package net.one97.paytm.feed.ui.feed.m;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.events.a;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;
import net.one97.paytm.feed.ui.publisher.FeedProviderActivity;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.u;

public final class e {
    public static void a(Context context, FeedGeneric feedGeneric, FeedItem feedItem) {
        k.c(context, "context");
        k.c(feedGeneric, "data");
        FeedGenericData feedGenericData = feedGeneric.getFeedGenericData();
        j jVar = j.f35397a;
        if (j.e(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                String str = null;
                if (feedGenericData.getWebUrl() != null && p.a((CharSequence) feedGenericData.getWebUrl(), (CharSequence) "twitter", true)) {
                    FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                    CreatedBy createdBy = feedGenericData.getCreatedBy();
                    if (createdBy != null) {
                        str = createdBy.getName();
                    }
                    String str2 = str;
                    if (str2 == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context, str2, feedGenericData.getWebUrl(), "#1ea1f1", "#1ea1f1", feedItem);
                } else if (feedGenericData.getWebUrl() != null) {
                    FeedWebViewActivity.a aVar2 = FeedWebViewActivity.f34900a;
                    CreatedBy createdBy2 = feedGenericData.getCreatedBy();
                    if (createdBy2 != null) {
                        str = createdBy2.getName();
                    }
                    if (str == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context, str, feedGenericData.getWebUrl(), feedItem);
                } else if (feedGenericData.getStreamUrl() != null) {
                    FullVideoActivity.a aVar3 = FullVideoActivity.f35223a;
                    FullVideoActivity.a.a(context, feedGeneric, 0);
                } else if (feedGenericData.getDeeplink() != null) {
                    b bVar = b.f34268c;
                    String deeplink = feedGenericData.getDeeplink();
                    if (deeplink == null) {
                        k.a();
                    }
                    b.c(context, deeplink);
                }
                a aVar4 = a.f34284a;
                String post_clicked = FeedEventNames.INSTANCE.getPOST_CLICKED();
                if (feedItem == null) {
                    k.a();
                }
                a.a(post_clicked, feedItem, "", "");
            } else {
                return;
            }
        } else {
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
        FeedCommentActivity.a aVar5 = FeedCommentActivity.f34935e;
        if (FeedCommentActivity.q) {
            net.one97.paytm.feed.events.a.a aVar6 = net.one97.paytm.feed.events.a.a.f34296a;
            String id = feedGenericData.getId();
            net.one97.paytm.feed.events.a.b bVar2 = net.one97.paytm.feed.events.a.b.f34303a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_post_click", id, net.one97.paytm.feed.events.a.b.d(), "");
            return;
        }
        net.one97.paytm.feed.events.a.a aVar7 = net.one97.paytm.feed.events.a.a.f34296a;
        String id2 = feedGenericData.getId();
        net.one97.paytm.feed.events.a.b bVar3 = net.one97.paytm.feed.events.a.b.f34303a;
        net.one97.paytm.feed.events.a.a.a("v2_feed_post_click", id2, net.one97.paytm.feed.events.a.b.c(), "");
    }

    public static void a(View view, FeedItem feedItem) {
        CreatedBy createdBy;
        Integer id;
        k.c(view, "view");
        k.c(feedItem, "feedItem");
        FeedProviderActivity.a aVar = FeedProviderActivity.f35322f;
        if (!FeedProviderActivity.s) {
            j jVar = j.f35397a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (j.e(context)) {
                u uVar = u.f35438a;
                if (!u.a() && (createdBy = ((FeedGeneric) feedItem).getFeedGenericData().getCreatedBy()) != null && (id = createdBy.getId()) != null) {
                    int intValue = id.intValue();
                    FeedProviderActivity.a aVar2 = FeedProviderActivity.f35322f;
                    Context context2 = view.getContext();
                    k.a((Object) context2, "view.context");
                    FeedProviderActivity.a.a(context2, intValue);
                    return;
                }
                return;
            }
            Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
        }
    }
}

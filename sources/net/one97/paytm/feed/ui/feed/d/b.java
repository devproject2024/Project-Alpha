package net.one97.paytm.feed.ui.feed.d;

import android.content.Context;
import android.widget.Toast;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.events.a.a;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.u;

public final class b {
    public static void a(Context context, FeedGenericData feedGenericData) {
        k.c(context, "context");
        k.c(feedGenericData, "post");
        j jVar = j.f35397a;
        if (j.e(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                String webUrl = feedGenericData.getWebUrl();
                String str = null;
                Boolean valueOf = webUrl != null ? Boolean.valueOf(p.a((CharSequence) webUrl, (CharSequence) "twitter", true)) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                    CreatedBy createdBy = feedGenericData.getCreatedBy();
                    if (createdBy != null) {
                        str = createdBy.getName();
                    }
                    if (str == null) {
                        k.a();
                    }
                    String webUrl2 = feedGenericData.getWebUrl();
                    if (webUrl2 == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context, str, webUrl2, "#1ea1f1", "#1ea1f1");
                } else {
                    FeedWebViewActivity.a aVar2 = FeedWebViewActivity.f34900a;
                    CreatedBy createdBy2 = feedGenericData.getCreatedBy();
                    if (createdBy2 != null) {
                        str = createdBy2.getName();
                    }
                    if (str == null) {
                        k.a();
                    }
                    String webUrl3 = feedGenericData.getWebUrl();
                    if (webUrl3 == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context, str, webUrl3);
                }
            } else {
                return;
            }
        } else {
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
        FeedCommentActivity.a aVar3 = FeedCommentActivity.f34935e;
        if (FeedCommentActivity.q) {
            a aVar4 = a.f34296a;
            String id = feedGenericData.getId();
            net.one97.paytm.feed.events.a.b bVar = net.one97.paytm.feed.events.a.b.f34303a;
            a.a("v2_feed_post_click", id, net.one97.paytm.feed.events.a.b.d(), "");
            return;
        }
        a aVar5 = a.f34296a;
        String id2 = feedGenericData.getId();
        net.one97.paytm.feed.events.a.b bVar2 = net.one97.paytm.feed.events.a.b.f34303a;
        a.a("v2_feed_post_click", id2, net.one97.paytm.feed.events.a.b.c(), "");
    }
}

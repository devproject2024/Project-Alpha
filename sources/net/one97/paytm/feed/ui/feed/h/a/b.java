package net.one97.paytm.feed.ui.feed.h.a;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.t;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.events.a.a;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.utility.s;

public final class b implements t.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f35063a;

    /* renamed from: b  reason: collision with root package name */
    private FeedItem f35064b;

    public static void a(View view, FeedMerchant feedMerchant) {
        k.c(view, "view");
        k.c(feedMerchant, "merchant");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        net.one97.paytm.feed.e.b.a(context, feedMerchant.getFeedMerchantData().getDeepLinkUrl());
        FeedCommentActivity.a aVar = FeedCommentActivity.f34935e;
        if (FeedCommentActivity.q) {
            a aVar2 = a.f34296a;
            a.a("v2_feed_merchant_deal_click", "");
            return;
        }
        a aVar3 = a.f34296a;
        a.a("v2_feed_merchant_deal_click", "");
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.share;
        if (valueOf == null || valueOf.intValue() != i2) {
            return false;
        }
        try {
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            Context context = this.f35063a;
            if (context == null) {
                k.a();
            }
            FeedItem feedItem = this.f35064b;
            if (feedItem == null) {
                k.a();
            }
            net.one97.paytm.feed.repository.db.a.e(context, feedItem.getPid());
            s sVar = s.f35433a;
            FeedItem feedItem2 = this.f35064b;
            if (feedItem2 != null) {
                String shareUrl = ((FeedMerchant) feedItem2).getFeedMerchantData().getShareUrl();
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                s.a(shareUrl, net.one97.paytm.feed.e.b.x());
                return true;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant");
        } catch (Exception unused) {
            return true;
        }
    }
}

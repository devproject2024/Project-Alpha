package net.one97.paytm.feed.ui.feed.livetv.channel;

import android.content.Context;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;

public final class a {
    public static void a(View view, Channel channel) {
        k.c(view, "view");
        k.c(channel, "channel");
        FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        FeedWebViewActivity.a.a(context, channel.getChannelName(), channel.getProgramUrl(), (FeedItem) null);
        net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
        net.one97.paytm.feed.events.a.a.a("v2_feed_livetv_click", "");
    }
}

package net.one97.paytm.feed.ui.feed.livetv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.i;
import net.one97.paytm.feed.repository.models.livetv.Channel;

public final class c extends RecyclerView.a<net.one97.paytm.feed.ui.feed.livetv.channel.c<i, ? super Channel>> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Channel> f35110a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.feed.ui.feed.livetv.channel.c cVar = (net.one97.paytm.feed.ui.feed.livetv.channel.c) vVar;
        k.c(cVar, "holder");
        Channel channel = this.f35110a.get(i2);
        k.a((Object) channel, "result[position]");
        Channel channel2 = channel;
        k.c(channel2, "data");
        B b2 = cVar.f35137a;
        b2.setVariable(a.f33780g, channel2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        if (cVar.f35138b == null) {
            cVar.f35138b = new net.one97.paytm.feed.ui.feed.livetv.channel.a();
            b2.setVariable(a.f33775b, cVar.f35138b);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        cVar.f35137a.executePendingBindings();
        if ((cVar.f35137a instanceof i) && cVar.f35137a == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.databinding.FeedChannelItemBinding");
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_channel_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new net.one97.paytm.feed.ui.feed.livetv.channel.c(inflate);
    }

    public final int getItemCount() {
        return this.f35110a.size();
    }

    public final long getItemId(int i2) {
        return (long) this.f35110a.get(i2).getId().hashCode();
    }
}

package net.one97.paytm.feed.ui.feed.livetv.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ak;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategory;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ChannelCategory> f35115a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f35116b;

    public a(Context context) {
        k.c(context, "context");
        this.f35116b = context;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        ChannelCategory channelCategory = this.f35115a.get(i2);
        k.a((Object) channelCategory, "data[position]");
        ChannelCategory channelCategory2 = channelCategory;
        k.c(channelCategory2, "data");
        ak akVar = bVar.f35120b;
        akVar.setVariable(net.one97.paytm.feed.a.f33780g, channelCategory2);
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(net.one97.paytm.feed.a.f33775b), new net.one97.paytm.feed.ui.feed.livetv.a())).entrySet()) {
            akVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        bVar.f35120b.executePendingBindings();
        net.one97.paytm.feed.ui.feed.livetv.category.a.a aVar = bVar.f35119a;
        if (aVar != null) {
            List<Channel> channels = channelCategory2.getChannels();
            if (channels != null) {
                aVar.a((ArrayList) channels);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel> */");
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(this.f35116b);
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_live_tv_category, viewGroup, false);
        k.a((Object) inflate, "view");
        return new b(inflate);
    }

    public final int getItemCount() {
        return this.f35115a.size();
    }
}

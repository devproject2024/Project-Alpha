package net.one97.paytm.feed.ui.feed.livetv.category.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.am;
import net.one97.paytm.feed.repository.models.livetv.Channel;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Channel> f35117a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        Channel channel = this.f35117a.get(i2);
        k.a((Object) channel, "data[position]");
        Channel channel2 = channel;
        k.c(channel2, "data");
        am amVar = bVar.f35118a;
        amVar.setVariable(net.one97.paytm.feed.a.f33780g, channel2);
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(net.one97.paytm.feed.a.f33775b), new net.one97.paytm.feed.ui.feed.livetv.channel.a())).entrySet()) {
            amVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        bVar.f35118a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_live_tv_category_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new b(inflate);
    }

    public final int getItemCount() {
        return this.f35117a.size();
    }

    public final void a(ArrayList<Channel> arrayList) {
        k.c(arrayList, "data");
        this.f35117a.clear();
        this.f35117a.addAll(arrayList);
        notifyDataSetChanged();
    }
}

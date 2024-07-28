package net.one97.paytm.feed.ui.feed.g;

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
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.ai;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;

public final class b extends RecyclerView.a<d<ai, ? super FeedLanguageData>> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<FeedLanguageData> f35059a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        d dVar = (d) vVar;
        k.c(dVar, "holder");
        FeedLanguageData feedLanguageData = this.f35059a.get(i2);
        k.a((Object) feedLanguageData, "result[position]");
        FeedLanguageData feedLanguageData2 = feedLanguageData;
        k.c(feedLanguageData2, "data");
        B b2 = dVar.f35060a;
        b2.setVariable(a.f33780g, feedLanguageData2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(a.f33775b), new c())).entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        dVar.f35060a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_language_grid_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new d(inflate);
    }

    public final int getItemCount() {
        return this.f35059a.size();
    }
}

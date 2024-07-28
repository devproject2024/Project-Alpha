package net.one97.paytm.feed.ui.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.ui.a.g;

public final class a extends RecyclerView.a<g> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<FeedLanguageData> f34814a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private c f34815b;

    public a(c cVar) {
        this.f34815b = cVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        g gVar = (g) vVar;
        k.c(gVar, "holder");
        FeedLanguageData feedLanguageData = this.f34814a.get(i2);
        k.a((Object) feedLanguageData, "languages[position]");
        FeedLanguageData feedLanguageData2 = feedLanguageData;
        k.c(feedLanguageData2, "feedLanguageData");
        gVar.f34846b.setText(feedLanguageData2.getLang());
        gVar.f34845a.setText(feedLanguageData2.getLocaleName());
        gVar.f34847c.setChecked(feedLanguageData2.isSelected());
        gVar.f34848d.setOnClickListener(new g.a(gVar, feedLanguageData2));
        gVar.f34847c.setOnClickListener(new g.b(gVar, feedLanguageData2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_language_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new g(inflate, this.f34815b);
    }

    public final int getItemCount() {
        return this.f34814a.size();
    }

    public final void a(ArrayList<FeedLanguageData> arrayList) {
        k.c(arrayList, "lang");
        this.f34814a.addAll(arrayList);
        notifyItemRangeInserted(0, this.f34814a.size());
    }

    public final void a(c cVar) {
        if (this.f34815b == null || cVar == null) {
            this.f34815b = cVar;
        }
    }
}

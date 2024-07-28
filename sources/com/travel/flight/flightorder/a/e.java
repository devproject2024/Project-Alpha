package com.travel.flight.flightorder.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.by;
import com.travel.flight.pojo.Card;
import java.util.List;
import kotlin.g.b.k;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Card> f24337a;

    public e(List<Card> list) {
        k.c(list, "cards");
        this.f24337a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        aVar.f24338a.a(this.f24337a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        by a2 = by.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_refund_source, viewGroup, false));
        k.a((Object) a2, "ListItemRefundSourceBind…d_source, parent, false))");
        return new a(a2);
    }

    public final int getItemCount() {
        return this.f24337a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final by f24338a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(by byVar) {
            super(byVar.getRoot());
            k.c(byVar, "listItemRefundSourceBinding");
            this.f24338a = byVar;
        }
    }
}

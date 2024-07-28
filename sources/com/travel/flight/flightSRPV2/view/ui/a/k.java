package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.cc;
import com.travel.flight.pojo.Item;
import java.util.List;

public final class k extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final List<Item> f24204a;

    public k(List<Item> list) {
        kotlin.g.b.k.c(list, "items");
        this.f24204a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        kotlin.g.b.k.c(aVar, "holder");
        aVar.f24205a.a(aVar.f24206b.f24204a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        kotlin.g.b.k.c(viewGroup, "parent");
        cc a2 = cc.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_review_payment_item, viewGroup, false));
        kotlin.g.b.k.a((Object) a2, "ListItemReviewPaymentIte…ent_item, parent, false))");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f24204a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final cc f24205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f24206b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar, cc ccVar) {
            super(ccVar.getRoot());
            kotlin.g.b.k.c(ccVar, "listItemReviewPaymentDetailBinding");
            this.f24206b = kVar;
            this.f24205a = ccVar;
        }
    }
}

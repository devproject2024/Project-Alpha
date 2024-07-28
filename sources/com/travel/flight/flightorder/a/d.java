package com.travel.flight.flightorder.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.bw;
import com.travel.flight.pojo.Info;
import java.util.List;
import kotlin.g.b.k;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Info> f24335a;

    public d(List<Info> list) {
        k.c(list, "infos");
        this.f24335a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        aVar.f24336a.a(this.f24335a.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        bw a2 = bw.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_refund_info, viewGroup, false));
        k.a((Object) a2, "ListItemRefundInfoBindin…und_info, parent, false))");
        return new a(a2);
    }

    public final int getItemCount() {
        return this.f24335a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final bw f24336a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(bw bwVar) {
            super(bwVar.getRoot());
            k.c(bwVar, "listItemRefundInfoBinding");
            this.f24336a = bwVar;
        }
    }
}

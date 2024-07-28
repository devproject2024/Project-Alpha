package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.b.i;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.d.b;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class l extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f24207a;

    public l(List<d> list) {
        k.c(list, "airlineList");
        this.f24207a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        d dVar = this.f24207a.get(i2);
        k.c(dVar, "airlineInfo");
        aVar.f24208a.a(dVar);
        aVar.f24208a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        b bVar = b.f24177a;
        ViewDataBinding a2 = b.a(10, viewGroup);
        if (a2 != null) {
            return new a((i) a2);
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.databinding.FlightListItemAirlinePriceStripBinding");
    }

    public final int getItemCount() {
        return this.f24207a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final i f24208a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar) {
            super(iVar.getRoot());
            k.c(iVar, "dataBinding");
            this.f24208a = iVar;
        }
    }
}

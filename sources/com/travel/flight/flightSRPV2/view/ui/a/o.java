package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightSRPV2.d.a;
import com.travel.flight.flightSRPV2.d.b;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class o extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public SRPOneWayViewModel f24215a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends CJRFlightDetailsItem> f24216b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "onewayHolder");
        SRPOneWayViewModel sRPOneWayViewModel = this.f24215a;
        CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) this.f24216b.get(i2);
        k.c(cJRFlightDetailsItem, "flightInfo");
        aVar.f24176a.setVariable(com.travel.flight.a.p, sRPOneWayViewModel);
        aVar.f24176a.setVariable(com.travel.flight.a.x, cJRFlightDetailsItem);
        aVar.f24176a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        b bVar = b.f24177a;
        ViewDataBinding a2 = b.a(i2, viewGroup);
        if (a2 != null) {
            return new a(a2);
        }
        throw new u("null cannot be cast to non-null type androidx.databinding.ViewDataBinding");
    }

    public o(SRPOneWayViewModel sRPOneWayViewModel, List<? extends CJRFlightDetailsItem> list) {
        k.c(sRPOneWayViewModel, "oneWayViewModel");
        k.c(list, "flightList");
        this.f24215a = sRPOneWayViewModel;
        this.f24216b = list;
    }

    public final int getItemViewType(int i2) {
        return ((CJRFlightDetailsItem) this.f24216b.get(i2)).getViewType();
    }

    public final int getItemCount() {
        return this.f24216b.size();
    }
}

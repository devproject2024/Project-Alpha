package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.b.ce;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;
import java.util.List;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f24178a;

    /* renamed from: b  reason: collision with root package name */
    public FlightFilterViewModel f24179b;

    public a(List<d> list, FlightFilterViewModel flightFilterViewModel) {
        this.f24178a = list;
        this.f24179b = flightFilterViewModel;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        List<d> list = this.f24178a;
        if (list == null) {
            k.a();
        }
        d dVar = list.get(i2);
        FlightFilterViewModel flightFilterViewModel = this.f24179b;
        k.c(dVar, "airlineInfo");
        bVar.f24180a.setVariable(com.travel.flight.a.q, dVar);
        bVar.f24180a.setVariable(com.travel.flight.a.A, flightFilterViewModel);
        bVar.f24180a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ce a2 = ce.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PreFAirlineFilterItemBin….context), parent, false)");
        return new b(a2);
    }

    public final int getItemCount() {
        List<d> list = this.f24178a;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            k.a();
        }
        return list.size();
    }
}

package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.d.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import java.util.List;
import kotlin.g.b.k;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends CJRFlightDetailsItem> f24184a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24185b;

    /* renamed from: c  reason: collision with root package name */
    public DRTListViewModel f24186c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        DRTListViewModel dRTListViewModel = this.f24186c;
        CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) this.f24184a.get(i2);
        boolean z = this.f24185b;
        k.c(dRTListViewModel, "drtListViewModel");
        k.c(cJRFlightDetailsItem, "flightInfo");
        aVar.f24176a.setVariable(com.travel.flight.a.x, cJRFlightDetailsItem);
        aVar.f24176a.setVariable(com.travel.flight.a.f23485i, Boolean.valueOf(z));
        aVar.f24176a.setVariable(com.travel.flight.a.f23480d, Integer.valueOf(i2));
        aVar.f24176a.setVariable(com.travel.flight.a.f23479c, dRTListViewModel);
        aVar.f24176a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_drt_flight_list, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        return new a(a2);
    }

    public d(List<? extends CJRFlightDetailsItem> list, boolean z, DRTListViewModel dRTListViewModel) {
        k.c(list, "flightList");
        k.c(dRTListViewModel, "viewModel");
        this.f24184a = list;
        this.f24185b = z;
        this.f24186c = dRTListViewModel;
    }

    public final int getItemCount() {
        return this.f24184a.size();
    }

    public final int getItemViewType(int i2) {
        return R.layout.item_drt_flight_list;
    }
}

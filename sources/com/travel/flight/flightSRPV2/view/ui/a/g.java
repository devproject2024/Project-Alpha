package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.d.a;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import java.util.List;
import kotlin.g.b.k;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends CJRFlightDetailsItem> f24191a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24192b;

    /* renamed from: c  reason: collision with root package name */
    private final IRTSplitViewModel f24193c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        IRTSplitViewModel iRTSplitViewModel = this.f24193c;
        CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) this.f24191a.get(i2);
        boolean z = this.f24192b;
        k.c(cJRFlightDetailsItem, "flightItem");
        aVar.f24176a.setVariable(com.travel.flight.a.G, iRTSplitViewModel);
        aVar.f24176a.setVariable(com.travel.flight.a.U, cJRFlightDetailsItem);
        aVar.f24176a.setVariable(com.travel.flight.a.f23485i, Boolean.valueOf(z));
        aVar.f24176a.setVariable(com.travel.flight.a.f23480d, Integer.valueOf(i2));
        aVar.f24176a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_irt_flight_spit_view_list, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        return new a(a2);
    }

    public g(IRTSplitViewModel iRTSplitViewModel, List<? extends CJRFlightDetailsItem> list, boolean z) {
        k.c(iRTSplitViewModel, "irtSplitViewModel");
        k.c(list, "flightList");
        this.f24193c = iRTSplitViewModel;
        this.f24191a = list;
        this.f24192b = z;
    }

    public final int getItemCount() {
        return this.f24191a.size();
    }

    public final int getItemViewType(int i2) {
        return R.layout.item_irt_flight_spit_view_list;
    }
}

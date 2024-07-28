package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.d.a;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import java.util.List;
import kotlin.g.b.k;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends CJRIntlFlightList> f24189a;

    /* renamed from: b  reason: collision with root package name */
    private final IRTViewModel f24190b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (a(i2) != null) {
            IRTViewModel iRTViewModel = this.f24190b;
            CJRIntlFlightList a2 = a(i2);
            if (a2 == null) {
                k.a();
            }
            k.c(a2, "flightInfo");
            aVar.f24176a.setVariable(com.travel.flight.a.K, iRTViewModel);
            aVar.f24176a.setVariable(com.travel.flight.a.x, a2);
            aVar.f24176a.executePendingBindings();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_irt_flight_list, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        return new a(a2);
    }

    public f(IRTViewModel iRTViewModel, List<? extends CJRIntlFlightList> list) {
        k.c(iRTViewModel, "irtViewModel");
        k.c(list, "flightList");
        this.f24190b = iRTViewModel;
        this.f24189a = list;
    }

    public final int getItemCount() {
        return this.f24189a.size();
    }

    public final int getItemViewType(int i2) {
        return R.layout.item_irt_flight_list;
    }

    private final CJRIntlFlightList a(int i2) {
        return (CJRIntlFlightList) this.f24189a.get(i2);
    }
}

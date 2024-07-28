package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.b.ck;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.model.CalendarDatePriceInfo;
import java.util.List;
import kotlin.g.b.k;

public final class m extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<CalendarDatePriceInfo> f24209a;

    /* renamed from: b  reason: collision with root package name */
    public SRPSharedViewModel f24210b;

    public m(List<CalendarDatePriceInfo> list, SRPSharedViewModel sRPSharedViewModel) {
        k.c(list, "datePriceList");
        k.c(sRPSharedViewModel, "parentViewModel");
        this.f24209a = list;
        this.f24210b = sRPSharedViewModel;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CalendarDatePriceInfo calendarDatePriceInfo = this.f24209a.get(i2);
        SRPSharedViewModel sRPSharedViewModel = this.f24210b;
        k.c(calendarDatePriceInfo, "datePriceInfo");
        k.c(sRPSharedViewModel, "parentViewModel");
        aVar.f24211a.a(calendarDatePriceInfo);
        aVar.f24211a.a(sRPSharedViewModel);
        aVar.f24211a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ck a2 = ck.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PreFFlightDatePriceItemV….context), parent, false)");
        return new a(a2);
    }

    public final int getItemCount() {
        return this.f24209a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ck f24211a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ck ckVar) {
            super(ckVar.getRoot());
            k.c(ckVar, "dataBinding");
            this.f24211a = ckVar;
        }
    }
}

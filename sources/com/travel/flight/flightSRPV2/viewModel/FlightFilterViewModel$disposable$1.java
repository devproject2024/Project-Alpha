package com.travel.flight.flightSRPV2.viewModel;

import com.travel.flight.flightSRPV2.a.t;
import io.reactivex.rxjava3.d.g;
import java.util.List;
import kotlin.x;

final class FlightFilterViewModel$disposable$1<T> implements g<x> {
    final /* synthetic */ FlightFilterViewModel this$0;

    FlightFilterViewModel$disposable$1(FlightFilterViewModel flightFilterViewModel) {
        this.this$0 = flightFilterViewModel;
    }

    public final void accept(x xVar) {
        List<com.travel.flight.flightSRPV2.a.x> filters = this.this$0.getFilters();
        this.this$0.filterHomeViewModel.setOnFiltersChanged(this.this$0.isOnward(), (filters.isEmpty() && !this.this$0.arePreviousFiltersEmpty) || t.a((List<? extends com.travel.flight.flightSRPV2.a.x>) this.this$0.previouslySelectedFilters, (List<? extends com.travel.flight.flightSRPV2.a.x>) filters, false), filters);
    }
}

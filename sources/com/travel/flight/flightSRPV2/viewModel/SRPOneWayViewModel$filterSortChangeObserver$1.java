package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;

final class SRPOneWayViewModel$filterSortChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ SRPOneWayViewModel this$0;

    SRPOneWayViewModel$filterSortChangeObserver$1(SRPOneWayViewModel sRPOneWayViewModel) {
        this.this$0 = sRPOneWayViewModel;
    }

    public final void onChanged(Object obj) {
        this.this$0.updateFlightList();
    }
}

package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;

final class DRTListViewModel$returnSortChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ DRTListViewModel this$0;

    DRTListViewModel$returnSortChangeObserver$1(DRTListViewModel dRTListViewModel) {
        this.this$0 = dRTListViewModel;
    }

    public final void onChanged(Object obj) {
        if (this.this$0.getReturnFlightList().getValue() != null) {
            this.this$0.updateFlightSorting(false);
        }
    }
}

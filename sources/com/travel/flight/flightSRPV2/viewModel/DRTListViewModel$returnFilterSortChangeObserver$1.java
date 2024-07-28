package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;

final class DRTListViewModel$returnFilterSortChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ DRTListViewModel this$0;

    DRTListViewModel$returnFilterSortChangeObserver$1(DRTListViewModel dRTListViewModel) {
        this.this$0 = dRTListViewModel;
    }

    public final void onChanged(Object obj) {
        if (this.this$0.getParentViewModel().getSrpResult().getValue() != null) {
            this.this$0.updateFlightList(false);
            if (this.this$0.discountedStripClicked) {
                this.this$0.updateFlightList(true);
                this.this$0.discountedStripClicked = false;
            }
        }
    }
}

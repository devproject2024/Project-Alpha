package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;

final class DRTListViewModel$onwardFilterSortChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ DRTListViewModel this$0;

    DRTListViewModel$onwardFilterSortChangeObserver$1(DRTListViewModel dRTListViewModel) {
        this.this$0 = dRTListViewModel;
    }

    public final void onChanged(Object obj) {
        if (this.this$0.getParentViewModel().getSrpResult().getValue() != null) {
            this.this$0.updateFlightList(true);
            if (this.this$0.discountedStripClicked) {
                this.this$0.updateFlightList(false);
                this.this$0.discountedStripClicked = false;
            }
        }
    }
}

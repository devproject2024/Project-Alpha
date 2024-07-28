package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;

final class IRTViewModel$irtSortOptionChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ IRTViewModel this$0;

    IRTViewModel$irtSortOptionChangeObserver$1(IRTViewModel iRTViewModel) {
        this.this$0 = iRTViewModel;
    }

    public final void onChanged(Object obj) {
        if (this.this$0.getParentViewModel().getSrpResult().getValue() != null && this.this$0.getParentViewModel().getCopiedSrpResult().getValue() != null) {
            this.this$0.sortFlightList();
        }
    }
}

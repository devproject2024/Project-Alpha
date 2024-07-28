package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.z;
import com.travel.flight.flightSRPV2.a.x;
import java.util.List;
import kotlin.g.b.k;

final class IRTViewModel$onwardReturnFilterSortChangeObserver$1<T> implements z<Object> {
    final /* synthetic */ IRTViewModel this$0;

    IRTViewModel$onwardReturnFilterSortChangeObserver$1(IRTViewModel iRTViewModel) {
        this.this$0 = iRTViewModel;
    }

    public final void onChanged(Object obj) {
        if (this.this$0.getParentViewModel().getSrpResult().getValue() != null && this.this$0.getParentViewModel().getCopiedSrpResult().getValue() != null) {
            List<x> value = this.this$0.getParentViewModel().getOnwardFilterList().getValue();
            if (value == null) {
                k.a();
            }
            if (value.size() <= 0) {
                List<x> value2 = this.this$0.getParentViewModel().getReturnFilterList().getValue();
                if (value2 == null) {
                    k.a();
                }
                if (value2.size() <= 0) {
                    this.this$0.updateSRPCopy();
                    return;
                }
            }
            this.this$0.updateFlightList();
        }
    }
}

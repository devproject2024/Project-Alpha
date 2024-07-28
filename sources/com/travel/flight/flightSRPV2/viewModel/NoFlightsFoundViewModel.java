package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.c.b;
import java.util.Collection;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.x;

public final class NoFlightsFoundViewModel extends ai {
    private final y<Integer> actionText = new y<>();
    private final SRPSharedViewModel parentViewModel;
    private final b<x> popPageEvent = new b<>();
    private final y<Integer> subText = new y<>();

    public NoFlightsFoundViewModel(SRPSharedViewModel sRPSharedViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        List value = this.parentViewModel.getReturnFilterList().getValue();
        Collection value2 = this.parentViewModel.getOnwardFilterList().getValue();
        boolean z = false;
        if (value2 == null || value2.isEmpty()) {
            Collection collection = value;
            if ((collection == null || collection.isEmpty()) ? true : z) {
                this.subText.postValue(Integer.valueOf(R.string.msg_no_flying_flight_available));
                this.actionText.postValue(Integer.valueOf(R.string.change_date));
                this.parentViewModel.getToolTipMessagesEvent().postValue(w.INSTANCE);
            }
        }
        this.subText.postValue(Integer.valueOf(R.string.msg_no_flight_available));
        this.actionText.postValue(Integer.valueOf(R.string.remove_filters));
        this.parentViewModel.getToolTipMessagesEvent().postValue(w.INSTANCE);
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final y<Integer> getSubText() {
        return this.subText;
    }

    public final y<Integer> getActionText() {
        return this.actionText;
    }

    public final b<x> getPopPageEvent() {
        return this.popPageEvent;
    }

    public final void onActionPerform() {
        List value = this.parentViewModel.getReturnFilterList().getValue();
        Collection value2 = this.parentViewModel.getOnwardFilterList().getValue();
        boolean z = false;
        if (value2 == null || value2.isEmpty()) {
            Collection collection = value;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (z) {
                this.parentViewModel.onBackPressed();
                return;
            }
        }
        if (this.parentViewModel.getDefaultOnwardFilterInfo().getValue() == null && this.parentViewModel.getDefaultReturnFilterInfo().getValue() == null) {
            this.parentViewModel.onBackPressed();
            return;
        }
        this.popPageEvent.setValue(null);
        this.parentViewModel.applyFilters(w.INSTANCE, w.INSTANCE);
    }
}

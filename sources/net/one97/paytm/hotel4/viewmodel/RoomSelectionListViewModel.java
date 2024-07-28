package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class RoomSelectionListViewModel extends BaseViewModel {
    private y<Boolean> closeAmenities = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomSelectionListViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final y<Boolean> getCloseAmenities() {
        return this.closeAmenities;
    }

    public final void setCloseAmenities(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.closeAmenities = yVar;
    }

    public final void onAmenitiesViewAllPressed() {
        getParent().postScreenNavigationEvent("7", SDKConstants.UPI_DOWN_ERROR);
    }
}

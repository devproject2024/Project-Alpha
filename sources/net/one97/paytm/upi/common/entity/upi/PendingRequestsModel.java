package net.one97.paytm.upi.common.entity.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PendingRequestsModel implements IJRDataModel {
    @c(a = "details")
    private PendingRequests mDetails;

    public PendingRequests getDetails() {
        return this.mDetails;
    }

    public class PendingRequests implements IJRDataModel {
        @c(a = "pending")
        private ArrayList<UpiPendingRequestModel> mPendingRequests;

        public PendingRequests() {
        }

        public ArrayList<UpiPendingRequestModel> getPendingRequests() {
            return this.mPendingRequests;
        }
    }
}

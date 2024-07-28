package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class PendingRequestsModel implements UpiBaseDataModel {
    @c(a = "details")
    private PendingRequests mDetails;

    public PendingRequests getDetails() {
        return this.mDetails;
    }

    public class PendingRequests implements UpiBaseDataModel {
        @c(a = "pending")
        private ArrayList<UpiPendingRequestModel> mPendingRequests;

        public PendingRequests() {
        }

        public ArrayList<UpiPendingRequestModel> getPendingRequests() {
            return this.mPendingRequests;
        }
    }
}

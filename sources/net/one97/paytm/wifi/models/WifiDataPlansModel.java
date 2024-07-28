package net.one97.paytm.wifi.models;

import com.paytm.network.model.IJRPaytmDataModel;

public final class WifiDataPlansModel extends IJRPaytmDataModel {
    private String operator;
    private boolean planFetchSuccessful;
    private WifiUserPlanResponse userplansGwResponse;

    public final String getOperator() {
        return this.operator;
    }

    public final void setOperator(String str) {
        this.operator = str;
    }

    public final boolean getPlanFetchSuccessful() {
        return this.planFetchSuccessful;
    }

    public final void setPlanFetchSuccessful(boolean z) {
        this.planFetchSuccessful = z;
    }

    public final WifiUserPlanResponse getUserplansGwResponse() {
        return this.userplansGwResponse;
    }

    public final void setUserplansGwResponse(WifiUserPlanResponse wifiUserPlanResponse) {
        this.userplansGwResponse = wifiUserPlanResponse;
    }
}

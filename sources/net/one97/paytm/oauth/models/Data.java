package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class Data extends IJRPaytmDataModel {
    @c(a = "flow")
    private final String flow;
    @c(a = "iccidResponse")
    private final Iccid iccidResponse;
    @c(a = "selectedAppFlow")
    private final String selectedAppFlow;
    @c(a = "strategies")
    private final ArrayList<Strategy> strategies = new ArrayList<>();

    public final String getFlow() {
        return this.flow;
    }

    public final String getSelectedAppFlow() {
        return this.selectedAppFlow;
    }

    public final ArrayList<Strategy> getStrategies() {
        return this.strategies;
    }

    public final Iccid getIccidResponse() {
        return this.iccidResponse;
    }
}

package net.one97.paytm.wifi.models;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class WifiPlanArray extends IJRPaytmDataModel {
    private ArrayList<WifiPlan> Data;

    public final ArrayList<WifiPlan> getData() {
        return this.Data;
    }

    public final void setData(ArrayList<WifiPlan> arrayList) {
        this.Data = arrayList;
    }
}

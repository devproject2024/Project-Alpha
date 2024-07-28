package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRSellerCourierCard extends IJRPaytmDataModel {
    @b(a = "actions")
    private ArrayList<CJRAction> mActions = new ArrayList<>();
    @b(a = "status_flow")
    private ArrayList<CJRStatusFlow> mStatusFlow = new ArrayList<>();
    @b(a = "status_text")
    private String mStatusText;

    public ArrayList<CJRAction> getActions() {
        return this.mActions;
    }

    public ArrayList<CJRStatusFlow> getStatusFlow() {
        return this.mStatusFlow;
    }

    public String getStatusText() {
        return this.mStatusText;
    }
}

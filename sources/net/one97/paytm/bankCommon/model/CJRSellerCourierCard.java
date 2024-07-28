package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSellerCourierCard implements IJRDataModel {
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

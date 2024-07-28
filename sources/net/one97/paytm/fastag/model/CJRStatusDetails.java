package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRStatusDetails extends IJRPaytmDataModel {
    @b(a = "actions")
    private ArrayList<CJRAction> mActions = new ArrayList<>();
    @b(a = "status_text")
    private String mStatusText;

    public String getmStatusText() {
        return this.mStatusText;
    }

    public ArrayList<CJRAction> getmActions() {
        return this.mActions;
    }

    public void setmActions(ArrayList<CJRAction> arrayList) {
        this.mActions = arrayList;
    }

    public void setmStatusText(String str) {
        this.mStatusText = str;
    }
}

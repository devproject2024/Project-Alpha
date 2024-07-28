package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRGeneric extends IJRPaytmDataModel {
    @b(a = "actions")
    private ArrayList<CJRAction> actions;

    public CJRGeneric(ArrayList<CJRAction> arrayList) {
        this.actions = arrayList;
    }

    public List<CJRAction> getActions() {
        return this.actions;
    }
}

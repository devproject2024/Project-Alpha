package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGeneric implements IJRDataModel {
    @b(a = "actions")
    private ArrayList<CJRAction> actions;

    public CJRGeneric(ArrayList<CJRAction> arrayList) {
        this.actions = arrayList;
    }

    public List<CJRAction> getActions() {
        return this.actions;
    }
}

package net.one97.paytm.addmoney.common.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRAction;
import net.one97.paytm.common.entity.shopping.CJRStatusFlow;

public class CJRReturnCard implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "actions")
    ArrayList<CJRAction> mActions;
    @c(a = "status_flow")
    ArrayList<CJRStatusFlow> mStatusFlow;

    public CJRReturnCard(ArrayList<CJRAction> arrayList, ArrayList<CJRStatusFlow> arrayList2) {
        this.mStatusFlow = arrayList2;
        this.mActions = arrayList;
    }

    public ArrayList<CJRAction> getActions() {
        return this.mActions;
    }

    public ArrayList<CJRStatusFlow> getStatusFlow() {
        return this.mStatusFlow;
    }
}

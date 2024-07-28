package net.one97.paytm.marketplace.model;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReturnReplaceCancel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public ArrayList<CJRReturnCancelBase> returnCancelBase = new ArrayList<>();

    public ArrayList<CJRReturnCancelBase> getReturnCancelBase() {
        return this.returnCancelBase;
    }

    public void setReturnCancelBase(ArrayList<CJRReturnCancelBase> arrayList) {
        this.returnCancelBase = arrayList;
    }
}

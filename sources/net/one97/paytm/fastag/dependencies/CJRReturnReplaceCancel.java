package net.one97.paytm.fastag.dependencies;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRReturnReplaceCancel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    public ArrayList<CJRReturnCancelBase> returnCancelBase = new ArrayList<>();

    public ArrayList<CJRReturnCancelBase> getReturnCancelBase() {
        return this.returnCancelBase;
    }

    public void setReturnCancelBase(ArrayList<CJRReturnCancelBase> arrayList) {
        this.returnCancelBase = arrayList;
    }
}

package net.one97.paytm.common.entity.shopping;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryActionList implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJROrderSummaryAction> mActions;

    public ArrayList<CJROrderSummaryAction> getAction() {
        return this.mActions;
    }

    public void setAction(ArrayList<CJROrderSummaryAction> arrayList) {
        this.mActions = arrayList;
    }

    public void setAction(CJROrderSummaryAction cJROrderSummaryAction, int i2) {
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        this.mActions.add(i2, cJROrderSummaryAction);
    }
}

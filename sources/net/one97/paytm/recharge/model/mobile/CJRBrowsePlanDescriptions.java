package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlanDescriptions extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "grid_layout")
    private ArrayList<CJRBrowsePlanDescription> mDescription;
    @b(a = "has_more")
    private boolean mHasMore;

    public ArrayList<CJRBrowsePlanDescription> getDescription() {
        return this.mDescription;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public void setmDescription(ArrayList<CJRBrowsePlanDescription> arrayList) {
        this.mDescription = arrayList;
    }
}

package net.one97.paytm.p2p.theme;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;

public class DealsEntity extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<CJRGridProduct> grid_layout;
    private boolean mIsSelect;

    public boolean ismIsSelect() {
        return this.mIsSelect;
    }

    public void setmIsSelect(boolean z) {
        this.mIsSelect = z;
    }

    public ArrayList<CJRGridProduct> getGrid_layout() {
        return this.grid_layout;
    }

    public void setGrid_layout(ArrayList<CJRGridProduct> arrayList) {
        this.grid_layout = arrayList;
    }
}

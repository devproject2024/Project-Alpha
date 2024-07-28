package net.one97.paytm.common.entity.replacement;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerticalResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRReplacementReason> mReasonObjs;

    public ArrayList<CJRReplacementReason> getmReasonObjs() {
        return this.mReasonObjs;
    }

    public void setmReasonObjs(ArrayList<CJRReplacementReason> arrayList) {
        this.mReasonObjs = arrayList;
    }
}

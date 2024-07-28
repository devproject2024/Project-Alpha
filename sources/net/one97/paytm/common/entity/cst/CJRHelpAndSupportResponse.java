package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHelpAndSupportResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "reasonObjs")
    ArrayList<CJRHelpAndSupportItem> mReasonObjs;
    private final Long serialVersionUID = 1L;

    public ArrayList<CJRHelpAndSupportItem> getmReasonObjs() {
        return this.mReasonObjs;
    }

    public void setmReasonObjs(ArrayList<CJRHelpAndSupportItem> arrayList) {
        this.mReasonObjs = arrayList;
    }
}

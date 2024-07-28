package net.one97.paytm.common.entity.cst;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRCSTDissatisfaction extends IJRPaytmDataModel {
    @c(a = "reasons")
    @a
    private ArrayList<CJRCSTDissatisfactionReasons> reasons;

    public ArrayList<CJRCSTDissatisfactionReasons> getReasons() {
        return this.reasons;
    }

    public void setReasons(ArrayList<CJRCSTDissatisfactionReasons> arrayList) {
        this.reasons = arrayList;
    }
}

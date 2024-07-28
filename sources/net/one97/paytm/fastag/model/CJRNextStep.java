package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRNextStep extends IJRPaytmDataModel {
    @b(a = "ANDROID")
    private ArrayList<CJRNextStepDetail> nextStepDetails;

    public ArrayList<CJRNextStepDetail> getNextStepDetails() {
        return this.nextStepDetails;
    }
}

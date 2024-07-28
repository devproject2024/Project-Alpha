package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNextStep implements IJRDataModel {
    @b(a = "ANDROID")
    private ArrayList<CJRNextStepDetail> nextStepDetails;

    public ArrayList<CJRNextStepDetail> getNextStepDetails() {
        return this.nextStepDetails;
    }
}

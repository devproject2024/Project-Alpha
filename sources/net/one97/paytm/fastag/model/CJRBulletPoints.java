package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRBulletPoints extends IJRPaytmDataModel {
    @b(a = "salient_feature")
    private ArrayList<String> mSalientFeatures = new ArrayList<>();

    public ArrayList<String> getmSalientFeatures() {
        return this.mSalientFeatures;
    }

    public void setmSalientFeatures(ArrayList<String> arrayList) {
        this.mSalientFeatures = arrayList;
    }
}

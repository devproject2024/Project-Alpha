package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBulletPoints implements IJRDataModel {
    @b(a = "salient_feature")
    private ArrayList<String> mSalientFeatures = new ArrayList<>();

    public ArrayList<String> getmSalientFeatures() {
        return this.mSalientFeatures;
    }

    public void setmSalientFeatures(ArrayList<String> arrayList) {
        this.mSalientFeatures = arrayList;
    }
}

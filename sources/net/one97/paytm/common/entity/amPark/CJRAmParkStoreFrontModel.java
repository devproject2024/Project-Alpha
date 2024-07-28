package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkStoreFrontModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "homepage_layout")
    private ArrayList<CJRAmParkStoreFrontDetailModel> mStoreFrontItems = new ArrayList<>();

    public ArrayList<CJRAmParkStoreFrontDetailModel> getmStoreFrontItems() {
        return this.mStoreFrontItems;
    }

    public void setmStoreFrontItems(ArrayList<CJRAmParkStoreFrontDetailModel> arrayList) {
        this.mStoreFrontItems = arrayList;
    }
}

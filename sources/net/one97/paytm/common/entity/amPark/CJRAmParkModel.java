package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "activeCategory")
    private String mActiveCategory;
    @b(a = "categories")
    private List<String> mCategoryList = new ArrayList();
    @b(a = "ent_list")
    private ArrayList<CJRAmParkDetailModel> mParkDetailModelList = new ArrayList<>();

    public List<String> getmCategoryList() {
        return this.mCategoryList;
    }

    public void setmCategoryList(List<String> list) {
        this.mCategoryList = list;
    }

    public String getmActiveCategory() {
        return this.mActiveCategory;
    }

    public void setmActiveCategory(String str) {
        this.mActiveCategory = str;
    }

    public ArrayList<CJRAmParkDetailModel> getmParkDetailModelList() {
        return this.mParkDetailModelList;
    }

    public void setmParkDetailModelList(ArrayList<CJRAmParkDetailModel> arrayList) {
        this.mParkDetailModelList = arrayList;
    }
}

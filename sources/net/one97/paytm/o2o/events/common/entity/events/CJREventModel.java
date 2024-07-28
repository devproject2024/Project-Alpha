package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category_images")
    private ArrayList<CJRCategoryImages> categoryImages;
    @b(a = "activeCategory")
    private String mActiveCategory;
    @b(a = "allCategories")
    private List<String> mAllCategoryList;
    @b(a = "eventPark")
    private ArrayList<CJREventCategoryDetail> mCategoryDetail = new ArrayList<>();
    @b(a = "categories")
    private List<String> mCategoryList = new ArrayList();
    @b(a = "ent_list")
    private ArrayList<CJREventDetailModel> mEventList = new ArrayList<>();
    @b(a = "has_more")
    private boolean mHasMore;
    @b(a = "trending")
    private ArrayList<CJREventDetailModel> mTrendingEventList = new ArrayList<>();

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

    public ArrayList<CJREventDetailModel> getmEventList() {
        return this.mEventList;
    }

    public void setmEventList(ArrayList<CJREventDetailModel> arrayList) {
        this.mEventList = arrayList;
    }

    public ArrayList<CJREventDetailModel> getmTrendingEventList() {
        return this.mTrendingEventList;
    }

    public void setmTrendingEventList(ArrayList<CJREventDetailModel> arrayList) {
        this.mTrendingEventList = arrayList;
    }

    public ArrayList<CJREventCategoryDetail> getmCategoryDetail() {
        return this.mCategoryDetail;
    }

    public void setmCategoryDetail(ArrayList<CJREventCategoryDetail> arrayList) {
        this.mCategoryDetail = arrayList;
    }

    public boolean ismHasMore() {
        return this.mHasMore;
    }

    public List<String> getmAllCategoryList() {
        return this.mAllCategoryList;
    }

    public ArrayList<CJRCategoryImages> getCategoryImages() {
        return this.categoryImages;
    }
}

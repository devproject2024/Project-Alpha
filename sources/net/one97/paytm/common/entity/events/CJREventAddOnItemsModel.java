package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventAddOnItemsModel implements IJRDataModel {
    @b(a = "fb_product_id")
    private String fbProductId;
    @b(a = "info")
    private String info;
    @b(a = "F_B")
    ArrayList<CJREventFnBAddOnModel> mFnBAddOnList;
    @b(a = "merchandise")
    ArrayList<CJREventFnBAddOnModel> mMerchandiseAddOnList;
    @b(a = "merch_product_id")
    private String merchProductId;
    @b(a = "title")
    private String title;

    public ArrayList<CJREventFnBAddOnModel> getmFnBAddOnList() {
        return this.mFnBAddOnList;
    }

    public void setmFnBAddOnList(ArrayList<CJREventFnBAddOnModel> arrayList) {
        this.mFnBAddOnList = arrayList;
    }

    public ArrayList<CJREventFnBAddOnModel> getmMerchandiseAddOnList() {
        return this.mMerchandiseAddOnList;
    }

    public void setmMerchandiseAddOnList(ArrayList<CJREventFnBAddOnModel> arrayList) {
        this.mMerchandiseAddOnList = arrayList;
    }

    public String getFbProductId() {
        return this.fbProductId;
    }

    public void setFbProductId(String str) {
        this.fbProductId = str;
    }

    public String getMerchProductId() {
        return this.merchProductId;
    }

    public void setMerchProductId(String str) {
        this.merchProductId = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }
}

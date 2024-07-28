package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargeDetailProductList;

public class CJRVarients implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "course")
    private String mCourse;
    @b(a = "district")
    private String mDistrict;
    @b(a = "group1")
    private String mGroup1;
    @b(a = "group2")
    private String mGroup2;
    @b(a = "location")
    private String mLocation;
    @b(a = "products")
    private ArrayList<CJRRechargeDetailProductList> mRechargeDetailProductList;
    @b(a = "variants")
    private ArrayList<CJRVarients> mVarients;

    public String getGroup2() {
        return this.mGroup2;
    }

    public String getCourse() {
        return this.mCourse;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public ArrayList<CJRVarients> getmVarients() {
        if (this.mRechargeDetailProductList != null && this.mVarients == null) {
            ArrayList<CJRVarients> arrayList = new ArrayList<>();
            CJRVarients cJRVarients = new CJRVarients();
            cJRVarients.setCourse("NA");
            cJRVarients.setGroup2("NA");
            cJRVarients.setRechargeDetailProductList(this.mRechargeDetailProductList);
            arrayList.add(cJRVarients);
            this.mVarients = arrayList;
        }
        return this.mVarients;
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public String getGroup1() {
        return this.mGroup1;
    }

    public ArrayList<CJRRechargeDetailProductList> getVarients() {
        return this.mRechargeDetailProductList;
    }

    public void setGroup2(String str) {
        this.mGroup2 = str;
    }

    public void setCourse(String str) {
        this.mCourse = str;
    }

    public void setRechargeDetailProductList(ArrayList<CJRRechargeDetailProductList> arrayList) {
        this.mRechargeDetailProductList = arrayList;
    }
}

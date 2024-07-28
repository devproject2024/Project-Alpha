package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkStoreFrontDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRAmParkStoreFrontItemDetailModel> mBannertems;
    @b(a = "id")
    private int mId;
    @b(a = "layout")
    private String mLayout;
    @b(a = "name")
    private String mName;
    @b(a = "priority")
    private int mPriority;
    @b(a = "status")
    private int mStatus;

    public String getmLayout() {
        return this.mLayout;
    }

    public void setmLayout(String str) {
        this.mLayout = str;
    }

    public int getmId() {
        return this.mId;
    }

    public void setmId(int i2) {
        this.mId = i2;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public int getmPriority() {
        return this.mPriority;
    }

    public void setmPriority(int i2) {
        this.mPriority = i2;
    }

    public int getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(int i2) {
        this.mStatus = i2;
    }

    public ArrayList<CJRAmParkStoreFrontItemDetailModel> getmBannertems() {
        return this.mBannertems;
    }

    public void setmBannertems(ArrayList<CJRAmParkStoreFrontItemDetailModel> arrayList) {
        this.mBannertems = arrayList;
    }
}

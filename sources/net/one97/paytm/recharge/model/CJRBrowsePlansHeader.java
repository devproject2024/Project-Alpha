package net.one97.paytm.recharge.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlansHeader extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRBrowsePlanHeader> mBrowsePlans;
    private String mCircle;
    private String mOperator;
    private String mType;

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getOperator() {
        return this.mOperator;
    }

    public void setOperator(String str) {
        this.mOperator = str;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public void setCircle(String str) {
        this.mCircle = str;
    }

    public ArrayList<CJRBrowsePlanHeader> getBrowsePlans() {
        return this.mBrowsePlans;
    }

    public boolean checkBrowsePlanResponse(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mType) || !this.mType.equalsIgnoreCase(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(this.mOperator) || !this.mOperator.equalsIgnoreCase(str2)) {
            return false;
        }
        if (this.mType.equalsIgnoreCase("dth") || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(this.mCircle) && this.mCircle.equalsIgnoreCase(str3))) {
            return true;
        }
        return false;
    }

    public void setBrowsePlans(ArrayList<CJRBrowsePlanHeader> arrayList) {
        this.mBrowsePlans = arrayList;
    }

    public void removeBestOffersHeader() {
        Iterator<CJRBrowsePlanHeader> it2 = this.mBrowsePlans.iterator();
        while (it2.hasNext()) {
            CJRBrowsePlanHeader next = it2.next();
            if ("Best Offer".equalsIgnoreCase(next.getName())) {
                this.mBrowsePlans.remove(next);
                return;
            }
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBrowsePlansHeader cJRBrowsePlansHeader = (CJRBrowsePlansHeader) super.parseResponse(str, fVar);
        cJRBrowsePlansHeader.setType(getType());
        cJRBrowsePlansHeader.setOperator(getOperator());
        cJRBrowsePlansHeader.setCircle(getCircle());
        return cJRBrowsePlansHeader;
    }
}

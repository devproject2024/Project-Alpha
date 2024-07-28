package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInstantOperator extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "Circle")
    private String mCircle;
    @b(a = "Operator")
    private String mOperator;
    @b(a = "postpaid")
    private boolean mPostPaid;
    @b(a = "product_id")
    private String mProductId;
    @b(a = "status")
    private boolean mStatus;

    public String getOperator() {
        return this.mOperator;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public boolean getStatus() {
        return this.mStatus;
    }

    public boolean getPostPaid() {
        return this.mPostPaid;
    }

    public void setPostPaid(boolean z) {
        this.mPostPaid = z;
    }

    public void setmOperator(String str) {
        this.mOperator = str;
    }

    public void setmircle(String str) {
        this.mCircle = str;
    }

    public void setStatus(boolean z) {
        this.mStatus = z;
    }

    public String getmProductId() {
        return this.mProductId;
    }

    public void setmProductId(String str) {
        this.mProductId = str;
    }
}

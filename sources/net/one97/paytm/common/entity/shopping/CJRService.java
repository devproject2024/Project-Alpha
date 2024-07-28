package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.List;

public class CJRService extends CJRExpandableRecyclerManager implements Serializable {
    private int amount;
    @b(a = "connectiontype")
    private String connectiontype;
    private Integer mTotalCableAmount;
    @b(a = "planExpiryDetails")
    private List<CJRPlanExpiryDetails> planExpiryDetails;
    @b(a = "VC No")
    private String vCNo;

    public boolean isParentRow() {
        return true;
    }

    public Integer getmTotalCableAmount() {
        return this.mTotalCableAmount;
    }

    public void setmTotalCableAmount(Integer num) {
        this.mTotalCableAmount = num;
    }

    public String getVCNo() {
        return this.vCNo;
    }

    public void setVCNo(String str) {
        this.vCNo = str;
    }

    public String getConnectiontype() {
        return this.connectiontype;
    }

    public void setConnectiontype(String str) {
        this.connectiontype = str;
    }

    public List<CJRPlanExpiryDetails> getPlanExpiryDetails() {
        return this.planExpiryDetails;
    }

    public void setPlanExpiryDetails(List<CJRPlanExpiryDetails> list) {
        this.planExpiryDetails = list;
    }

    public int getAmount() {
        List<CJRPlanExpiryDetails> list;
        if (this.amount == 0 && (list = this.planExpiryDetails) != null) {
            for (CJRPlanExpiryDetails amount2 : list) {
                this.amount += Integer.parseInt(amount2.getAmount());
            }
        }
        return this.amount;
    }
}

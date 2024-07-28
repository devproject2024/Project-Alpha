package net.one97.paytm.common.entity.wallet;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class P2BCommissionMetaObject extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "commissionAmount")
    @a
    private Double commissionAmount;
    @c(a = "commissionMode")
    @a
    private String commissionMode;
    @c(a = "feeDetailsBreakupList")
    @a
    private List<FeeDetailsBreakupList> feeDetailsBreakupList = null;
    @c(a = "totalPayableAmount")
    @a
    private Double totalPayableAmount;

    public List<FeeDetailsBreakupList> getFeeDetailsBreakupList() {
        return this.feeDetailsBreakupList;
    }

    public void setFeeDetailsBreakupList(List<FeeDetailsBreakupList> list) {
        this.feeDetailsBreakupList = list;
    }

    public Double getCommissionAmount() {
        return this.commissionAmount;
    }

    public void setCommissionAmount(Double d2) {
        this.commissionAmount = d2;
    }

    public Double getTotalPayableAmount() {
        return this.totalPayableAmount;
    }

    public void setTotalPayableAmount(Double d2) {
        this.totalPayableAmount = d2;
    }

    public String getCommissionMode() {
        return this.commissionMode;
    }

    public void setCommissionMode(String str) {
        this.commissionMode = str;
    }
}

package net.one97.paytm.common.entity.wallet;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class FeeDetailsBreakupList extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "commissionMode")
    @a
    private String commissionMode;
    @c(a = "slabEndIndex")
    @a
    private Double slabEndIndex;
    @c(a = "slabFeeAmount")
    @a
    private Double slabFeeAmount;
    @c(a = "slabFeePercentage")
    @a
    private Double slabFeePercentage;
    @c(a = "slabPayableAmount")
    @a
    private Double slabPayableAmount;
    @c(a = "slabStartIndex")
    @a
    private Double slabStartIndex;
    @c(a = "slabTxnAmount")
    @a
    private Double slabTxnAmount;

    public Double getSlabStartIndex() {
        return this.slabStartIndex;
    }

    public void setSlabStartIndex(Double d2) {
        this.slabStartIndex = d2;
    }

    public Double getSlabEndIndex() {
        return this.slabEndIndex;
    }

    public void setSlabEndIndex(Double d2) {
        this.slabEndIndex = d2;
    }

    public Double getSlabFeePercentage() {
        return this.slabFeePercentage;
    }

    public void setSlabFeePercentage(Double d2) {
        this.slabFeePercentage = d2;
    }

    public Double getSlabFeeAmount() {
        return this.slabFeeAmount;
    }

    public void setSlabFeeAmount(Double d2) {
        this.slabFeeAmount = d2;
    }

    public Double getSlabTxnAmount() {
        return this.slabTxnAmount;
    }

    public void setSlabTxnAmount(Double d2) {
        this.slabTxnAmount = d2;
    }

    public Double getSlabPayableAmount() {
        return this.slabPayableAmount;
    }

    public void setSlabPayableAmount(Double d2) {
        this.slabPayableAmount = d2;
    }

    public String getCommissionMode() {
        return this.commissionMode;
    }

    public void setCommissionMode(String str) {
        this.commissionMode = str;
    }
}

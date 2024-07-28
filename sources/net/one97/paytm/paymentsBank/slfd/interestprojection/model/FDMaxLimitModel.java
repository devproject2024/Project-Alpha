package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class FDMaxLimitModel extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "availableAmount")
    private Double availableAmount;
    @a
    @b(a = "productType")
    private String productType;
    @a
    @b(a = "transferType")
    private String transferType;

    public Double getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(Double d2) {
        this.availableAmount = d2;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public String getTransferType() {
        return this.transferType;
    }

    public void setTransferType(String str) {
        this.transferType = str;
    }
}

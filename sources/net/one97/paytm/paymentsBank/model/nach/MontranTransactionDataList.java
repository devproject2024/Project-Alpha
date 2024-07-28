package net.one97.paytm.paymentsBank.model.nach;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class MontranTransactionDataList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private Integer amount;
    @b(a = "createdData")
    private String createdData;
    @b(a = "transactionStatus")
    private String transactionStatus;
    @b(a = "transferType")
    private String transferType;

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer num) {
        this.amount = num;
    }

    public String getCreatedData() {
        return this.createdData;
    }

    public void setCreatedData(String str) {
        this.createdData = str;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(String str) {
        this.transactionStatus = str;
    }

    public String getTransferType() {
        return this.transferType;
    }

    public void setTransferType(String str) {
        this.transferType = str;
    }
}

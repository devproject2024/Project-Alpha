package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDeleteCard extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "ErrorMsg")
    private String errorMessage;
    @b(a = "NUMBER_OF_RECORDS")
    private int numberOfRecords;
    @b(a = "STATUS")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public int getNumberOfRecords() {
        return this.numberOfRecords;
    }

    public void setNumberOfRecords(int i2) {
        this.numberOfRecords = i2;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}

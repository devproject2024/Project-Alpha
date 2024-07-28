package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import com.business.merchant_payments.model.BaseModel;
import java.util.ArrayList;

public class OrderDetailModel extends BaseModel {
    public ArrayList<OrderDetailItem> results;
    public String status;
    public String statusCode;
    public String statusMessage;

    public String getStatus() {
        return this.status;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public ArrayList<OrderDetailItem> getResults() {
        return this.results;
    }
}

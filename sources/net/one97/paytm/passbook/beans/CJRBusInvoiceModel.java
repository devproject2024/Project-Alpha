package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;

public class CJRBusInvoiceModel extends CJRDataModelItem {
    private static final long serialVersionUID = 2;
    @b(a = "response")
    private BusResponseModel busResponseModel;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestFGuid;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "status")
    private String status;

    public String getName() {
        return null;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getmStatusMessage() {
        return this.mStatusMessage;
    }

    public BusResponseModel getBusResponseModel() {
        return this.busResponseModel;
    }
}

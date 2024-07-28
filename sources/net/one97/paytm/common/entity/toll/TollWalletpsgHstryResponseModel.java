package net.one97.paytm.common.entity.toll;

import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class TollWalletpsgHstryResponseModel implements IJRDataModel {
    private String orderId;
    private String requestGuid;
    private List<TollWalletPsgHistoryModel> response;
    private String status;
    private String statusCode;
    private String statusMessage;

    public String getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public List<TollWalletPsgHistoryModel> getEntryModelList() {
        return this.response;
    }

    public void setEntryModelList(List<TollWalletPsgHistoryModel> list) {
        this.response = list;
    }
}

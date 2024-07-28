package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class KYCWaitTimeResponse extends IJRPaytmDataModel {
    @a
    @b(a = "displayMessage")
    private String displayMessage;
    @a
    @b(a = "isInternalRouting")
    private boolean isInternalRouting;
    @a
    @b(a = "refId")
    private String refId;
    @a
    @b(a = "routingSource")
    private String routingSource = "WORKAPPS";
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "statusCode")
    private Integer statusCode;
    @a
    @b(a = "waitTimeInSec")
    private Integer waitTimeInSec;

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String str) {
        this.refId = str;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getWaitTimeInSec() {
        return this.waitTimeInSec;
    }

    public void setWaitTimeInSec(Integer num) {
        this.waitTimeInSec = num;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public boolean isInternalRouting() {
        return this.isInternalRouting;
    }

    public void setInternalRouting(boolean z) {
        this.isInternalRouting = z;
    }

    public String getRoutingSource() {
        return this.routingSource;
    }

    public void setRoutingSource(String str) {
        this.routingSource = str;
    }
}

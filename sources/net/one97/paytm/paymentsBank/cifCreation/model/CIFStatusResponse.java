package net.one97.paytm.paymentsBank.cifCreation.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CIFStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cbsProductType")
    private String cbsProductType;
    @b(a = "iblCifId")
    private String iblCifId;
    @b(a = "identifier")
    private String identifier;
    @b(a = "processId")
    private String processId;
    @b(a = "productType")
    private String productType;
    @b(a = "requestDate")
    private long requestDate;
    @b(a = "slfdStatus")
    private String slfdStatus;
    @b(a = "status")
    private String status;

    public final String getIblCifId() {
        return this.iblCifId;
    }

    public final void setIblCifId(String str) {
        this.iblCifId = str;
    }

    public final String getSlfdStatus() {
        return this.slfdStatus;
    }

    public final void setSlfdStatus(String str) {
        this.slfdStatus = str;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        this.productType = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getProcessId() {
        return this.processId;
    }

    public final void setProcessId(String str) {
        this.processId = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final String getCbsProductType() {
        return this.cbsProductType;
    }

    public final void setCbsProductType(String str) {
        this.cbsProductType = str;
    }

    public final long getRequestDate() {
        return this.requestDate;
    }

    public final void setRequestDate(long j) {
        this.requestDate = j;
    }
}

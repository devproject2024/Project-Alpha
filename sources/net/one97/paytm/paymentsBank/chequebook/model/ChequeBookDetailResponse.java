package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class ChequeBookDetailResponse extends IJRPaytmDataModel {
    @a
    @b(a = "response")
    private List<b> cbList = new ArrayList();
    @a
    @b(a = "paging")
    private a cbListPaging;
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "responseCode")
    private String responseCode;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "success")
    private Boolean success;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public List<b> getCbList() {
        return this.cbList;
    }

    public void setCbList(List<b> list) {
        this.cbList = list;
    }

    public a getCbListPaging() {
        return this.cbListPaging;
    }

    public void setCbListPaging(a aVar) {
        this.cbListPaging = aVar;
    }
}

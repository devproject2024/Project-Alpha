package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;

public final class GetDocumentCreateResponse extends BaseCBModel {
    private boolean isDocumentGetApi;
    @c(a = "message")
    @a
    private String message;
    @c(a = "payload")
    @a
    private List<DocumentCreateResponse.Payload> payload;
    @c(a = "responseCode")
    @a
    private String responseCode;
    @c(a = "status")
    @a
    private String status;

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final List<DocumentCreateResponse.Payload> getPayload() {
        return this.payload;
    }

    public final void setPayload(List<DocumentCreateResponse.Payload> list) {
        this.payload = list;
    }

    public final boolean isDocumentGetApi() {
        return this.isDocumentGetApi;
    }

    public final void setDocumentGetApi(boolean z) {
        this.isDocumentGetApi = z;
    }
}

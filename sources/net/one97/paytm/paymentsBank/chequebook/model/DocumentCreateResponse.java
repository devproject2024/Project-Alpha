package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DocumentCreateResponse extends BaseCBModel {
    private boolean isAcknowledgeSig;
    private boolean isDocumentGetApi;
    private boolean isViewSignature;
    @c(a = "message")
    @a
    private String message;
    @c(a = "payload")
    @a
    private Payload payload;
    @c(a = "responseCode")
    @a
    private String responseCode;
    private String signatureType;
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

    public final Payload getPayload() {
        return this.payload;
    }

    public final void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public final boolean isDocumentGetApi() {
        return this.isDocumentGetApi;
    }

    public final void setDocumentGetApi(boolean z) {
        this.isDocumentGetApi = z;
    }

    public final boolean isViewSignature() {
        return this.isViewSignature;
    }

    public final void setViewSignature(boolean z) {
        this.isViewSignature = z;
    }

    public final boolean isAcknowledgeSig() {
        return this.isAcknowledgeSig;
    }

    public final void setAcknowledgeSig(boolean z) {
        this.isAcknowledgeSig = z;
    }

    public final String getSignatureType() {
        return this.signatureType;
    }

    public final void setSignatureType(String str) {
        this.signatureType = str;
    }

    public final class Payload extends IJRPaytmDataModel {
        @c(a = "active")
        @a
        private Boolean active;
        @c(a = "documentId")
        @a
        private String documentId;
        @c(a = "id")
        @a
        private Integer id;
        @c(a = "status")
        @a
        private String status;
        @c(a = "url")
        @a
        private Object url;

        public Payload() {
        }

        public final Integer getId() {
            return this.id;
        }

        public final void setId(Integer num) {
            this.id = num;
        }

        public final String getDocumentId() {
            return this.documentId;
        }

        public final void setDocumentId(String str) {
            this.documentId = str;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
        }

        public final Boolean getActive() {
            return this.active;
        }

        public final void setActive(Boolean bool) {
            this.active = bool;
        }

        public final Object getUrl() {
            return this.url;
        }

        public final void setUrl(Object obj) {
            this.url = obj;
        }
    }
}

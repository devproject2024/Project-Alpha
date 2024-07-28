package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;

public final class CBGetSignatureResponse extends BaseCBModel {
    @c(a = "message")
    @a
    private String message;
    @c(a = "payload")
    @a
    private List<Payload> payload;
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

    public final List<Payload> getPayload() {
        return this.payload;
    }

    public final void setPayload(List<Payload> list) {
        this.payload = list;
    }

    public final class Payload extends IJRPaytmDataModel {
        @c(a = "approvedAt")
        @a
        private Object approvedAt;
        @c(a = "approvedBy")
        @a
        private Object approvedBy;
        @c(a = "channel")
        @a
        private Object channel;
        @c(a = "documentTypeDescription")
        @a
        private String documentTypeDescription;
        @c(a = "documentTypeName")
        @a
        private Object documentTypeName;
        @c(a = "id")
        @a
        private Object id;
        @c(a = "imageId")
        @a
        private String imageId;
        @c(a = "rejectCode")
        @a
        private Object rejectCode;
        @c(a = "remarks")
        @a
        private Object remarks;
        @c(a = "status")
        @a
        private Object status;
        @c(a = "supportDocuments")
        @a
        private List<DocumentCreateResponse.Payload> supportDocuments;
        @c(a = "uploadedAt")
        @a
        private Object uploadedAt;
        @c(a = "url")
        @a
        private Object url;

        public Payload() {
        }

        public final Object getId() {
            return this.id;
        }

        public final void setId(Object obj) {
            this.id = obj;
        }

        public final String getImageId() {
            return this.imageId;
        }

        public final void setImageId(String str) {
            this.imageId = str;
        }

        public final Object getStatus() {
            return this.status;
        }

        public final void setStatus(Object obj) {
            this.status = obj;
        }

        public final Object getUploadedAt() {
            return this.uploadedAt;
        }

        public final void setUploadedAt(Object obj) {
            this.uploadedAt = obj;
        }

        public final Object getApprovedBy() {
            return this.approvedBy;
        }

        public final void setApprovedBy(Object obj) {
            this.approvedBy = obj;
        }

        public final Object getApprovedAt() {
            return this.approvedAt;
        }

        public final void setApprovedAt(Object obj) {
            this.approvedAt = obj;
        }

        public final Object getUrl() {
            return this.url;
        }

        public final void setUrl(Object obj) {
            this.url = obj;
        }

        public final Object getRemarks() {
            return this.remarks;
        }

        public final void setRemarks(Object obj) {
            this.remarks = obj;
        }

        public final Object getChannel() {
            return this.channel;
        }

        public final void setChannel(Object obj) {
            this.channel = obj;
        }

        public final Object getRejectCode() {
            return this.rejectCode;
        }

        public final void setRejectCode(Object obj) {
            this.rejectCode = obj;
        }

        public final Object getDocumentTypeName() {
            return this.documentTypeName;
        }

        public final void setDocumentTypeName(Object obj) {
            this.documentTypeName = obj;
        }

        public final String getDocumentTypeDescription() {
            return this.documentTypeDescription;
        }

        public final void setDocumentTypeDescription(String str) {
            this.documentTypeDescription = str;
        }

        public final List<DocumentCreateResponse.Payload> getSupportDocuments() {
            return this.supportDocuments;
        }

        public final void setSupportDocuments(List<DocumentCreateResponse.Payload> list) {
            this.supportDocuments = list;
        }
    }
}

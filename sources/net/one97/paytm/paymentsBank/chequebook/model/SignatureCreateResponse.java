package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class SignatureCreateResponse extends IJRPaytmDataModel {
    @c(a = "message")
    @a
    private String message;
    @c(a = "payload")
    @a
    private Payload payload;
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

    public final Payload getPayload() {
        return this.payload;
    }

    public final void setPayload(Payload payload2) {
        this.payload = payload2;
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
        private Object documentTypeDescription;
        @c(a = "documentTypeName")
        @a
        private Object documentTypeName;
        @c(a = "id")
        @a
        private Integer id;
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
        private String status;
        @c(a = "supportDocuments")
        @a
        private List<? extends Object> supportDocuments;
        @c(a = "uploadedAt")
        @a
        private Object uploadedAt;

        public Payload() {
        }

        public final Integer getId() {
            return this.id;
        }

        public final void setId(Integer num) {
            this.id = num;
        }

        public final String getImageId() {
            return this.imageId;
        }

        public final void setImageId(String str) {
            this.imageId = str;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
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

        public final Object getDocumentTypeDescription() {
            return this.documentTypeDescription;
        }

        public final void setDocumentTypeDescription(Object obj) {
            this.documentTypeDescription = obj;
        }

        public final List<Object> getSupportDocuments() {
            return this.supportDocuments;
        }

        public final void setSupportDocuments(List<? extends Object> list) {
            this.supportDocuments = list;
        }
    }
}

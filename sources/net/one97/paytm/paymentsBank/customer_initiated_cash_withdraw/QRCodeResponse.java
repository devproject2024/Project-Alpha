package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class QRCodeResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseCode")
    private int responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return Integer.valueOf(this.responseCode);
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num.intValue();
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public class MapResponse extends IJRPaytmDataModel {
        @b(a = "category")
        private Object category;
        @b(a = "displayName")
        private String displayName;
        @b(a = "isUpdated")
        private Boolean isUpdated;
        @b(a = "mappingId")
        private String mappingId;
        @b(a = "mappingType")
        private String mappingType;
        @b(a = "metadata")
        private String metadata;
        @b(a = "posId")
        private Object posId;
        @b(a = "secondaryPhoneNumber")
        private Object secondaryPhoneNumber;
        @b(a = "status")
        private String status;
        @b(a = "subCategory")
        private Object subCategory;
        @b(a = "tagLine")
        private Object tagLine;
        @b(a = "typeOfQrCode")
        private String typeOfQrCode;

        public MapResponse() {
        }

        public String getMappingId() {
            return this.mappingId;
        }

        public void setMappingId(String str) {
            this.mappingId = str;
        }

        public String getMappingType() {
            return this.mappingType;
        }

        public void setMappingType(String str) {
            this.mappingType = str;
        }

        public String getTypeOfQrCode() {
            return this.typeOfQrCode;
        }

        public void setTypeOfQrCode(String str) {
            this.typeOfQrCode = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public Object getCategory() {
            return this.category;
        }

        public void setCategory(Object obj) {
            this.category = obj;
        }

        public Object getSubCategory() {
            return this.subCategory;
        }

        public void setSubCategory(Object obj) {
            this.subCategory = obj;
        }

        public Object getTagLine() {
            return this.tagLine;
        }

        public void setTagLine(Object obj) {
            this.tagLine = obj;
        }

        public Object getSecondaryPhoneNumber() {
            return this.secondaryPhoneNumber;
        }

        public void setSecondaryPhoneNumber(Object obj) {
            this.secondaryPhoneNumber = obj;
        }

        public Object getPosId() {
            return this.posId;
        }

        public void setPosId(Object obj) {
            this.posId = obj;
        }

        public String getMetadata() {
            return this.metadata;
        }

        public void setMetadata(String str) {
            this.metadata = str;
        }

        public Boolean getIsUpdated() {
            return this.isUpdated;
        }

        public void setIsUpdated(Boolean bool) {
            this.isUpdated = bool;
        }
    }

    public class Payload extends IJRPaytmDataModel {
        @b(a = "mapResponse")
        private MapResponse mapResponse;
        @b(a = "qrCodeId")
        private String qrCodeId;
        @b(a = "stickerId")
        private String stickerId;

        public Payload() {
        }

        public String getStickerId() {
            return this.stickerId;
        }

        public void setStickerId(String str) {
            this.stickerId = str;
        }

        public String getQrCodeId() {
            return this.qrCodeId;
        }

        public void setQrCodeId(String str) {
            this.qrCodeId = str;
        }

        public MapResponse getMapResponse() {
            return this.mapResponse;
        }

        public void setMapResponse(MapResponse mapResponse2) {
            this.mapResponse = mapResponse2;
        }
    }
}

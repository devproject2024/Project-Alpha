package net.one97.paytm.paymentsBank.pdc.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCPriceResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private List<Payload> payload = null;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public List<Payload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<Payload> list) {
        this.payload = list;
    }

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "description")
        private String description;
        @b(a = "fulfilmentType")
        private String fulfilmentType;
        @b(a = "name")
        private String name;
        @b(a = "price")
        private String price;
        @b(a = "productId")
        private String productId;
        @b(a = "productInitiator")
        private String productInitiator;
        @b(a = "productType")
        private String productType;

        public String getProductId() {
            return this.productId;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPrice() {
            return this.price;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public String getProductType() {
            return this.productType;
        }

        public void setProductType(String str) {
            this.productType = str;
        }

        public String getFulfilmentType() {
            return this.fulfilmentType;
        }

        public void setFulfilmentType(String str) {
            this.fulfilmentType = str;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public String getProductInitiator() {
            return this.productInitiator;
        }

        public void setProductInitiator(String str) {
            this.productInitiator = str;
        }
    }
}

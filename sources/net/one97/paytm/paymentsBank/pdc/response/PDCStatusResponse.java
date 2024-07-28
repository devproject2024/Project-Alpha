package net.one97.paytm.paymentsBank.pdc.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private Payload payload;
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

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "address")
        private Address address;
        @b(a = "agentCaNumber")
        private Object agentCaNumber;
        @b(a = "agentCustId")
        private String agentCustId;
        @b(a = "amount")
        private double amount;
        @b(a = "beneficiaryName")
        private String beneficiaryName;
        @b(a = "benfAccountNumber")
        private String benfAccountNumber;
        @b(a = "benfCustId")
        private String benfCustId;
        @b(a = "cbsTransactionId")
        private Object cbsTransactionId;
        @b(a = "created")
        private long created;
        @b(a = "depositorName")
        private String depositorName;
        @b(a = "modeOfTransaction")
        private String modeOfTransaction;
        @b(a = "orderId")
        private String orderId;
        @b(a = "productId")
        private String productId;
        @b(a = "productName")
        private String productName;
        @b(a = "responseMessage")
        private Object responseMessage;
        @b(a = "state")
        private String state;
        @b(a = "status")
        private String status;
        @b(a = "transactionResponse")
        private Object transactionResponse;
        @b(a = "transactionState")
        private String transactionState;

        public Address getAddress() {
            return this.address;
        }

        public void setAddress(Address address2) {
            this.address = address2;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public String getProductName() {
            return this.productName;
        }

        public void setProductName(String str) {
            this.productName = str;
        }

        public String getProductId() {
            return this.productId;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public double getAmount() {
            return this.amount;
        }

        public void setAmount(double d2) {
            this.amount = d2;
        }

        public String getModeOfTransaction() {
            return this.modeOfTransaction;
        }

        public void setModeOfTransaction(String str) {
            this.modeOfTransaction = str;
        }

        public String getDepositorName() {
            return this.depositorName;
        }

        public void setDepositorName(String str) {
            this.depositorName = str;
        }

        public String getBeneficiaryName() {
            return this.beneficiaryName;
        }

        public void setBeneficiaryName(String str) {
            this.beneficiaryName = str;
        }

        public String getBenfAccountNumber() {
            return this.benfAccountNumber;
        }

        public void setBenfAccountNumber(String str) {
            this.benfAccountNumber = str;
        }

        public Object getCbsTransactionId() {
            return this.cbsTransactionId;
        }

        public void setCbsTransactionId(Object obj) {
            this.cbsTransactionId = obj;
        }

        public String getAgentCustId() {
            return this.agentCustId;
        }

        public void setAgentCustId(String str) {
            this.agentCustId = str;
        }

        public Object getAgentCaNumber() {
            return this.agentCaNumber;
        }

        public void setAgentCaNumber(Object obj) {
            this.agentCaNumber = obj;
        }

        public String getBenfCustId() {
            return this.benfCustId;
        }

        public void setBenfCustId(String str) {
            this.benfCustId = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String str) {
            this.state = str;
        }

        public String getTransactionState() {
            return this.transactionState;
        }

        public void setTransactionState(String str) {
            this.transactionState = str;
        }

        public Object getResponseMessage() {
            return this.responseMessage;
        }

        public void setResponseMessage(Object obj) {
            this.responseMessage = obj;
        }

        public long getCreated() {
            return this.created;
        }

        public void setCreated(long j) {
            this.created = j;
        }

        public Object getTransactionResponse() {
            return this.transactionResponse;
        }

        public void setTransactionResponse(Object obj) {
            this.transactionResponse = obj;
        }
    }

    public static class Address extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "address1")
        private String address1;
        @b(a = "address2")
        private String address2;
        @b(a = "city")
        private String city;
        @b(a = "country")
        private String country;
        @b(a = "countryCode")
        private String countryCode;
        @b(a = "mobile")
        private String mobile;
        @b(a = "name")
        private String name;
        @b(a = "pin")
        private String pin;
        @b(a = "priority")
        private String priority;
        @b(a = "state")
        private String state;
        @b(a = "title")
        private String title;
        @b(a = "type")
        private String type;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getAddress1() {
            return this.address1;
        }

        public void setAddress1(String str) {
            this.address1 = str;
        }

        public String getAddress2() {
            return this.address2;
        }

        public void setAddress2(String str) {
            this.address2 = str;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String str) {
            this.state = str;
        }

        public String getPin() {
            return this.pin;
        }

        public void setPin(String str) {
            this.pin = str;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public String getPriority() {
            return this.priority;
        }

        public void setPriority(String str) {
            this.priority = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }
    }
}

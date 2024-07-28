package net.one97.paytm.common.entity.wallet.universalp2p;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class WalletLimitsResDataModel extends CJRWalletDataModel implements IJRDataModel {
    @c(a = "metadata")
    @a
    private Object metadata;
    @c(a = "response")
    @a
    private Response objectResponse;
    @c(a = "orderId")
    @a
    private Object orderId;
    @c(a = "requestGuid")
    @a
    private Object requestGuid;
    @c(a = "response")
    @a
    private ArrayList<Response> response = new ArrayList<>();
    @c(a = "status")
    @a
    private Object status;
    @c(a = "statusCode")
    @a
    private String statusCode;
    @c(a = "statusMessage")
    @a
    private String statusMessage;
    @c(a = "type")
    @a
    private Object type;

    public Object getType() {
        return this.type;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public Object getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(Object obj) {
        this.requestGuid = obj;
    }

    public Object getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Object obj) {
        this.orderId = obj;
    }

    public Object getStatus() {
        return this.status;
    }

    public void setStatus(Object obj) {
        this.status = obj;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public ArrayList<Response> getResponse() {
        return this.response;
    }

    public Response getObjectResponse() {
        return this.objectResponse;
    }

    public void setObjectResponse(Response response2) {
        this.objectResponse = response2;
    }

    public void setResponse(ArrayList<Response> arrayList) {
        this.response = arrayList;
    }

    public Object getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Object obj) {
        this.metadata = obj;
    }

    public static class Response {
        @c(a = "addMoneyDestination")
        @a
        private String addMoneyDestination;
        @c(a = "allowedBalance")
        @a
        private Object allowedBalance;
        @c(a = "currentbalance")
        @a
        private String currentbalance;
        @c(a = "isLimitApplicable")
        @a
        private Boolean isLimitApplicable;
        @c(a = "limitMessage")
        @a
        private Object limitMessage;
        @c(a = "message")
        @a
        private String message;
        @c(a = "response")
        @a
        private Object response;
        @c(a = "trustFactor")
        @a
        private String trustFactor;
        @c(a = "walletOperationType")
        @a
        private String walletOperationType;
        @c(a = "walletRbiType")
        @a
        private String walletRbiType;

        public String getCurrentbalance() {
            return this.currentbalance;
        }

        public void setCurrentbalance(String str) {
            this.currentbalance = str;
        }

        public String getWalletRbiType() {
            return this.walletRbiType;
        }

        public void setWalletRbiType(String str) {
            this.walletRbiType = str;
        }

        public String getTrustFactor() {
            return this.trustFactor;
        }

        public void setTrustFactor(String str) {
            this.trustFactor = str;
        }

        public String getWalletOperationType() {
            return this.walletOperationType;
        }

        public void setWalletOperationType(String str) {
            this.walletOperationType = str;
        }

        public Boolean getIsLimitApplicable() {
            return this.isLimitApplicable;
        }

        public void setIsLimitApplicable(Boolean bool) {
            this.isLimitApplicable = bool;
        }

        public Object getLimitMessage() {
            return this.limitMessage;
        }

        public void setLimitMessage(Object obj) {
            this.limitMessage = obj;
        }

        public Object getAllowedBalance() {
            return this.allowedBalance;
        }

        public void setAllowedBalance(Object obj) {
            this.allowedBalance = obj;
        }

        public String getAddMoneyDestination() {
            return this.addMoneyDestination;
        }

        public void setAddMoneyDestination(String str) {
            this.addMoneyDestination = str;
        }

        public Object getResponse() {
            return this.response;
        }

        public void setResponse(Object obj) {
            this.response = obj;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }
}

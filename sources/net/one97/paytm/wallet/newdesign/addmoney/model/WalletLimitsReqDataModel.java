package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class WalletLimitsReqDataModel {
    @c(a = "operationType")
    @a
    private String operationType;
    @c(a = "ipAddress")
    @a
    private String platformName;
    @c(a = "request")
    @a
    private Request request;

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public void setPlatformName(String str) {
        this.platformName = str;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public static class Request {
        @c(a = "addMoneyDestination")
        @a
        private String addMoneyDestination;
        @c(a = "amount")
        @a
        private Double amount;
        @c(a = "mid")
        @a
        private Object mid;
        @c(a = "ssoId")
        @a
        private String ssoId;
        @c(a = "targetCustId")
        @a
        private Object targetCustId;
        @c(a = "targetPhoneNo")
        @a
        private String targetPhoneNo;
        @c(a = "walletOperationType")
        @a
        private String walletOperationType;
        private List<Double> walletOperationTypeBasedAmountList;
        private List<String> walletOperationTypeList;

        public List<Double> getWalletOperationTypeBasedAmountList() {
            return this.walletOperationTypeBasedAmountList;
        }

        public void setWalletOperationTypeBasedAmountList(List<Double> list) {
            this.walletOperationTypeBasedAmountList = list;
        }

        public List<String> getWalletOperationTypeList() {
            return this.walletOperationTypeList;
        }

        public void setWalletOperationTypeList(List<String> list) {
            this.walletOperationTypeList = list;
        }

        public String getAddMoneyDestination() {
            return this.addMoneyDestination;
        }

        public void setAddMoneyDestination(String str) {
            this.addMoneyDestination = str;
        }

        public String getSsoId() {
            return this.ssoId;
        }

        public void setSsoId(String str) {
            this.ssoId = str;
        }

        public String getTargetPhoneNo() {
            return this.targetPhoneNo;
        }

        public void setTargetPhoneNo(String str) {
            this.targetPhoneNo = str;
        }

        public Object getTargetCustId() {
            return this.targetCustId;
        }

        public void setTargetCustId(Object obj) {
            this.targetCustId = obj;
        }

        public Object getMid() {
            return this.mid;
        }

        public void setMid(Object obj) {
            this.mid = obj;
        }

        public String getWalletOperationType() {
            return this.walletOperationType;
        }

        public void setWalletOperationType(String str) {
            this.walletOperationType = str;
        }

        public Double getAmount() {
            return this.amount;
        }

        public void setAmount(Double d2) {
            this.amount = d2;
        }
    }
}

package net.one97.paytm.nativesdk.common.model;

import java.util.Map;

public class PcfDetailsResponse implements BaseDataModel {
    private PcfBody body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public PcfBody getBody() {
        return this.body;
    }

    public void setBody(PcfBody pcfBody) {
        this.body = pcfBody;
    }

    public static class ConsultDetail implements BaseDataModel {
        private AccountBalance baseTransactionAmount;
        private String displayText;
        private AccountBalance feeAmount;
        private String payMethod;
        private AccountBalance taxAmount;
        private String text;
        private AccountBalance totalConvenienceCharges;
        private AccountBalance totalTransactionAmount;

        public AccountBalance getTotalTransactionAmount() {
            return this.totalTransactionAmount;
        }

        public void setTotalTransactionAmount(AccountBalance accountBalance) {
            this.totalTransactionAmount = accountBalance;
        }

        public AccountBalance getTotalConvenienceCharges() {
            return this.totalConvenienceCharges;
        }

        public void setTotalConvenienceCharges(AccountBalance accountBalance) {
            this.totalConvenienceCharges = accountBalance;
        }

        public String getDisplayText() {
            return this.displayText;
        }

        public void setDisplayText(String str) {
            this.displayText = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public AccountBalance getBaseTransactionAmount() {
            return this.baseTransactionAmount;
        }

        public void setBaseTransactionAmount(AccountBalance accountBalance) {
            this.baseTransactionAmount = accountBalance;
        }

        public AccountBalance getTaxAmount() {
            return this.taxAmount;
        }

        public void setTaxAmount(AccountBalance accountBalance) {
            this.taxAmount = accountBalance;
        }
    }

    public static class PcfBody implements BaseDataModel {
        private Map<String, ConsultDetail> consultDetails;
        private ResultInfo resultInfo;

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public Map<String, ConsultDetail> getConsultDetails() {
            return this.consultDetails;
        }

        public void setConsultDetails(Map<String, ConsultDetail> map) {
            this.consultDetails = map;
        }
    }
}

package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiTransactionStatusModel implements UpiBaseDataModel {
    @c(a = "details")
    private TransactionStatus mDetails;

    public TransactionStatus getDetails() {
        return this.mDetails;
    }

    public void setmDetails(TransactionStatus transactionStatus) {
        this.mDetails = transactionStatus;
    }

    public static class TransactionStatus implements UpiBaseDataModel {
        @c(a = "importantNote")
        private String importantNote;
        @c(a = "amount")
        private double mAmount;
        @c(a = "message")
        private String mMessage;
        @c(a = "rc")
        private String mRc;
        @c(a = "rrn")
        private String mRrn;
        @c(a = "status")
        private String mStatus;
        @c(a = "payeeDetails")
        private PayeeDetails payeeDetails;
        @c(a = "payerDetails")
        private PayeeDetails payerDetails;
        @c(a = "timeline")
        private ArrayList<PassbookTimeline> timeline;
        private String txnId;
        @c(a = "cashback")
        private UpiGenerateCashbackDataModel upiGenerateCashbackDataModel;

        public String getRc() {
            return this.mRc;
        }

        public double getAmount() {
            return this.mAmount;
        }

        public String getImportantNote() {
            return this.importantNote;
        }

        public ArrayList<PassbookTimeline> getTimeline() {
            return this.timeline;
        }

        public UpiGenerateCashbackDataModel getUpiGenerateCashbackDataModel() {
            return this.upiGenerateCashbackDataModel;
        }

        public String getStatus() {
            return this.mStatus;
        }

        public String getRrn() {
            return this.mRrn;
        }

        public String getMessage() {
            return this.mMessage;
        }

        public String getTxnId() {
            return this.txnId;
        }

        public void setTxnId(String str) {
            this.txnId = str;
        }

        public void setmRc(String str) {
            this.mRc = str;
        }

        public void setmAmount(double d2) {
            this.mAmount = d2;
        }

        public void setmStatus(String str) {
            this.mStatus = str;
        }

        public void setmRrn(String str) {
            this.mRrn = str;
        }

        public void setmMessage(String str) {
            this.mMessage = str;
        }

        public PayeeDetails getPayeeDetails() {
            return this.payeeDetails;
        }

        public PayeeDetails getPayerDetails() {
            return this.payerDetails;
        }

        public class PayeeDetails implements UpiBaseDataModel {
            @c(a = "bankAccount")
            private String bankAccount;
            @c(a = "ifsc")
            private String ifsc;
            @c(a = "name")
            private String name;

            public PayeeDetails() {
            }

            public String getBankAccount() {
                return this.bankAccount;
            }

            public String getIfsc() {
                return this.ifsc;
            }

            public String getName() {
                return this.name;
            }
        }
    }
}

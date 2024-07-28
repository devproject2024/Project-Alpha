package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRPaytmPostPaidTransactionModel extends IJRDataModel {
    private List<CJRPaytmPostPaidTransaction> mPaytmPostPaidTransactionList;

    public List<CJRPaytmPostPaidTransaction> getmPaytmPostPaidTransactionList() {
        return this.mPaytmPostPaidTransactionList;
    }

    public void setmPaytmPostPaidTransactionList(List<CJRPaytmPostPaidTransaction> list) {
        this.mPaytmPostPaidTransactionList = list;
    }

    public static class CJRPaytmPostPaidTransaction extends IJRDataModel {
        @c(a = "entryTitle")
        private String mEntryTitle;
        @c(a = "transaction")
        private CJRPaytmPostPaidTransactionDesc transaction;

        public String getmEntryTitle() {
            return this.mEntryTitle;
        }

        public void setmEntryTitle(String str) {
            this.mEntryTitle = str;
        }

        public CJRPaytmPostPaidTransactionDesc getTransaction() {
            return this.transaction;
        }

        public void setTransaction(CJRPaytmPostPaidTransactionDesc cJRPaytmPostPaidTransactionDesc) {
            this.transaction = cJRPaytmPostPaidTransactionDesc;
        }
    }

    public static class CJRPaytmPostPaidTransactionDesc extends IJRDataModel {
        @c(a = "amount")
        private String amount;
        @c(a = "createdAt")
        private long createdAt;
        @c(a = "transactionId")
        private String transactionId;
        @c(a = "type")
        private String type;

        public long getCreatedAt() {
            return this.createdAt;
        }

        public void setCreatedAt(long j) {
            this.createdAt = j;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getAmount() {
            return this.amount;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public String getTransactionId() {
            return this.transactionId;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }
    }

    public static class TransactionHeader extends CJRPaytmPostPaidTransaction {
        public long createdAt;

        public TransactionHeader(long j) {
            this.createdAt = j;
        }
    }
}

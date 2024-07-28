package net.one97.paytm.paymentsBank.si.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class SITransactionListResponse extends IJRPaytmDataModel {
    @b(a = "currentPageSize")
    private Integer currentPageSize;
    @b(a = "isLastPage")
    private Boolean isLastPage;
    @b(a = "transactions")
    private ArrayList<Transaction> transactions = null;

    public Boolean getIsLastPage() {
        return this.isLastPage;
    }

    public void setIsLastPage(Boolean bool) {
        this.isLastPage = bool;
    }

    public Integer getCurrentPageSize() {
        return this.currentPageSize;
    }

    public void setCurrentPageSize(Integer num) {
        this.currentPageSize = num;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> arrayList) {
        this.transactions = arrayList;
    }

    public static class Transaction extends IJRPaytmDataModel {
        @b(a = "amount")
        private Double amount;
        @b(a = "date")
        private long date;
        @b(a = "middlewareId")
        private long middlewareId;
        @b(a = "siId")
        private String siId;
        @b(a = "status")
        private String status;
        @b(a = "transactionRequestId")
        private String transactionRequestId;

        public Double getAmount() {
            return this.amount;
        }

        public void setAmount(Double d2) {
            this.amount = d2;
        }

        public long getDate() {
            return this.date;
        }

        public void setDate(long j) {
            this.date = j;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getSiId() {
            return this.siId;
        }

        public void setSiId(String str) {
            this.siId = str;
        }

        public String getTransactionRequestId() {
            return this.transactionRequestId;
        }

        public void setTransactionRequestId(String str) {
            this.transactionRequestId = str;
        }

        public long getMiddlewareId() {
            return this.middlewareId;
        }

        public void setMiddlewareId(long j) {
            this.middlewareId = j;
        }
    }
}

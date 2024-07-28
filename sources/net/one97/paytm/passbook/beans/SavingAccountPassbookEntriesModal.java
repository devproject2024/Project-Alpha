package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class SavingAccountPassbookEntriesModal extends CJRDataModelItem {
    private String message;
    @b(a = "response")
    private Response response;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "status")
    private String status;

    public String getName() {
        return null;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public String toString() {
        return "SavingAccountPassbookEntriesModal{status='" + this.status + '\'' + ", responseCode=" + this.responseCode + ", response=" + this.response + '}';
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public class PaginationDetails {
        @b(a = "amountValue")
        private String amountValue;
        @b(a = "currencyCode")
        private String currencyCode;
        @b(a = "transactionDate")
        private String transactionDate;
        @b(a = "transactionId")
        private String transactionId;
        @b(a = "transactionPostDate")
        private String transactionPostDate;
        @b(a = "transactionSerialNumber")
        private String transactionSerialNumber;

        public PaginationDetails() {
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public String getAmountValue() {
            return this.amountValue;
        }

        public void setAmountValue(String str) {
            this.amountValue = str;
        }

        public String getTransactionPostDate() {
            return this.transactionPostDate;
        }

        public void setTransactionPostDate(String str) {
            this.transactionPostDate = str;
        }

        public String getTransactionDate() {
            return this.transactionDate;
        }

        public void setTransactionDate(String str) {
            this.transactionDate = str;
        }

        public String getTransactionId() {
            return this.transactionId;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }

        public String getTransactionSerialNumber() {
            return this.transactionSerialNumber;
        }

        public void setTransactionSerialNumber(String str) {
            this.transactionSerialNumber = str;
        }

        public String toString() {
            return new f().a((Object) this);
        }
    }

    public class Response {
        @b(a = "accountBalance")
        private String accountBalance;
        @b(a = "currencyCode")
        private String currencyCode;
        @b(a = "hasMoreData")
        private Boolean hasMoreData;
        @b(a = "paginationDetail")
        private PaginationDetails paginationDetails;
        @b(a = "transactionDetails")
        private ArrayList<TransactionDetail> transactionDetails = null;

        public Response() {
        }

        public Boolean getHasMoreData() {
            return this.hasMoreData;
        }

        public void setHasMoreData(Boolean bool) {
            this.hasMoreData = bool;
        }

        public String getAccountBalance() {
            return this.accountBalance;
        }

        public void setAccountBalance(String str) {
            this.accountBalance = str;
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public ArrayList<TransactionDetail> getTransactionDetails() {
            return this.transactionDetails;
        }

        public void setTransactionDetails(ArrayList<TransactionDetail> arrayList) {
            this.transactionDetails = arrayList;
        }

        public PaginationDetails getPaginationDetails() {
            return this.paginationDetails;
        }

        public void setPaginationDetails(PaginationDetails paginationDetails2) {
            this.paginationDetails = paginationDetails2;
        }

        public String toString() {
            return "Response{hasMoreData=" + this.hasMoreData + ", accountBalance='" + this.accountBalance + '\'' + ", currencyCode='" + this.currencyCode + '\'' + ", transactionDetails=" + this.transactionDetails + ", paginationDetails=" + this.paginationDetails + '}';
        }
    }

    public static class TransactionDetail extends IJRDataModel {
        private String accountId;
        @b(a = "amountValue")
        private String amountValue;
        @b(a = "currencyCode")
        private String currencyCode;
        private String formattedTxnTime;
        @b(a = "imageUrl")
        private String imageUrl;
        @b(a = "narration")
        private String narration;
        @b(a = "prtTxnId")
        private String prtTxnId;
        @b(a = "reportCode")
        private String reportCode;
        private String rrn;
        @b(a = "txnCategory")
        private String txnCategory;
        @b(a = "txnComment")
        private String txnComment;
        @b(a = "txnDate")
        private String txnDate;
        @b(a = "txnDesc")
        private String txnDesc;
        @b(a = "txnDesc1")
        private String txnDesc1;
        @b(a = "txnDesc2")
        private String txnDesc2;
        @b(a = "txnDesc3")
        private String txnDesc3;
        @b(a = "txnDesc4")
        private String txnDesc4;
        @b(a = "txnId")
        private String txnId;
        @b(a = "txnPostDate")
        private String txnPostDate;
        @b(a = "txnSerialNumber")
        private String txnSerialNumber;
        @b(a = "txnType")
        private String txnType;
        @b(a = "valueDate")
        private String valueDate;

        public String getRrn() {
            return this.rrn;
        }

        public void setRrn(String str) {
            this.rrn = str;
        }

        public String getValueDate() {
            return this.valueDate;
        }

        public void setValueDate(String str) {
            this.valueDate = str;
        }

        public String getTxnDate() {
            return this.txnDate;
        }

        public void setTxnDate(String str) {
            this.txnDate = str;
        }

        public String getTxnType() {
            return this.txnType;
        }

        public void setTxnType(String str) {
            this.txnType = str;
        }

        public String getTxnDesc() {
            return this.txnDesc;
        }

        public void setTxnDesc(String str) {
            this.txnDesc = str;
        }

        public String getAmountValue() {
            return this.amountValue;
        }

        public void setAmountValue(String str) {
            this.amountValue = str;
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public String getTxnPostDate() {
            return this.txnPostDate;
        }

        public void setTxnPostDate(String str) {
            this.txnPostDate = str;
        }

        public String getTxnCategory() {
            return this.txnCategory;
        }

        public void setTxnCategory(String str) {
            this.txnCategory = str;
        }

        public String getTxnId() {
            return this.txnId;
        }

        public void setTxnId(String str) {
            this.txnId = str;
        }

        public String getTxnSerialNumber() {
            return this.txnSerialNumber;
        }

        public void setTxnSerialNumber(String str) {
            this.txnSerialNumber = str;
        }

        public String getTxnDesc1() {
            return this.txnDesc1;
        }

        public void setTxnDesc1(String str) {
            this.txnDesc1 = str;
        }

        public String getTxnDesc2() {
            return this.txnDesc2;
        }

        public void setTxnDesc2(String str) {
            this.txnDesc2 = str;
        }

        public String getTxnDesc3() {
            return this.txnDesc3;
        }

        public void setTxnDesc3(String str) {
            this.txnDesc3 = str;
        }

        public String getTxnDesc4() {
            return this.txnDesc4;
        }

        public void setTxnDesc4(String str) {
            this.txnDesc4 = str;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public String getTxnComment() {
            return this.txnComment;
        }

        public void setTxnComment(String str) {
            this.txnComment = str;
        }

        public String getNarration() {
            return this.narration;
        }

        public void setNarration(String str) {
            this.narration = str;
        }

        public String getFormattedTxnTime() {
            return this.formattedTxnTime;
        }

        public void setFormattedTxnTime(String str) {
            this.formattedTxnTime = str;
        }

        public String getAccountId() {
            return this.accountId;
        }

        public void setAccountId(String str) {
            this.accountId = str;
        }

        public String toString() {
            return "TransactionDetail{valueDate='" + this.valueDate + '\'' + ", txnDate='" + this.txnDate + '\'' + ", txnType='" + this.txnType + '\'' + ", txnDesc='" + this.txnDesc + '\'' + ", amountValue='" + this.amountValue + '\'' + ", currencyCode='" + this.currencyCode + '\'' + ", txnPostDate='" + this.txnPostDate + '\'' + ", txnCategory='" + this.txnCategory + '\'' + ", txnId='" + this.txnId + '\'' + ", txnSerialNumber='" + this.txnSerialNumber + '\'' + ", txnDesc1='" + this.txnDesc1 + '\'' + ", txnDesc2='" + this.txnDesc2 + '\'' + ", txnDesc3='" + this.txnDesc3 + '\'' + ", txnDesc4='" + this.txnDesc4 + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", txnComment='" + this.txnComment + '\'' + ", narration='" + this.narration + '\'' + '}';
        }

        public String getPrtTxnId() {
            return this.prtTxnId;
        }

        public void setPrtTxnId(String str) {
            this.prtTxnId = str;
        }

        public String getReportCode() {
            return this.reportCode;
        }

        public void setReportCode(String str) {
            this.reportCode = str;
        }
    }

    public static class TransactionHeader extends TransactionDetail {
        public String txnDate;

        public TransactionHeader(String str) {
            this.txnDate = str;
        }
    }
}

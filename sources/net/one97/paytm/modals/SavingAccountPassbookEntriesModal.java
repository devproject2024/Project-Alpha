package net.one97.paytm.modals;

import com.google.gsonhtcfix.f;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;
import net.one97.paytm.common.entity.IJRDataModel;

public class SavingAccountPassbookEntriesModal extends CJRDataModelItem {
    private String message;
    @com.google.gsonhtcfix.a.b(a = "response")
    private b response;
    @com.google.gsonhtcfix.a.b(a = "responseCode")
    private Integer responseCode;
    @com.google.gsonhtcfix.a.b(a = "status")
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

    public b getResponse() {
        return this.response;
    }

    public void setResponse(b bVar) {
        this.response = bVar;
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

    public class a {
        public final String toString() {
            return new f().a((Object) this);
        }
    }

    public class b {
        @com.google.gsonhtcfix.a.b(a = "hasMoreData")

        /* renamed from: a  reason: collision with root package name */
        private Boolean f53509a;
        @com.google.gsonhtcfix.a.b(a = "accountBalance")

        /* renamed from: b  reason: collision with root package name */
        private String f53510b;
        @com.google.gsonhtcfix.a.b(a = "currencyCode")

        /* renamed from: c  reason: collision with root package name */
        private String f53511c;
        @com.google.gsonhtcfix.a.b(a = "transactionDetails")

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<TransactionDetail> f53512d;
        @com.google.gsonhtcfix.a.b(a = "paginationDetail")

        /* renamed from: e  reason: collision with root package name */
        private a f53513e;

        public final String toString() {
            return "Response{hasMoreData=" + this.f53509a + ", accountBalance='" + this.f53510b + '\'' + ", currencyCode='" + this.f53511c + '\'' + ", transactionDetails=" + this.f53512d + ", paginationDetails=" + this.f53513e + '}';
        }
    }

    public static class TransactionDetail implements IJRDataModel {
        private String accountId;
        @com.google.gsonhtcfix.a.b(a = "amountValue")
        private String amountValue;
        @com.google.gsonhtcfix.a.b(a = "currencyCode")
        private String currencyCode;
        @com.google.gsonhtcfix.a.b(a = "imageUrl")
        private String imageUrl;
        @com.google.gsonhtcfix.a.b(a = "narration")
        private String narration;
        @com.google.gsonhtcfix.a.b(a = "prtTxnId")
        private String prtTxnId;
        @com.google.gsonhtcfix.a.b(a = "reportCode")
        private String reportCode;
        private String rrn;
        @com.google.gsonhtcfix.a.b(a = "txnCategory")
        private String txnCategory;
        @com.google.gsonhtcfix.a.b(a = "txnComment")
        private String txnComment;
        @com.google.gsonhtcfix.a.b(a = "txnDate")
        private String txnDate;
        @com.google.gsonhtcfix.a.b(a = "txnDesc")
        private String txnDesc;
        @com.google.gsonhtcfix.a.b(a = "txnDesc1")
        private String txnDesc1;
        @com.google.gsonhtcfix.a.b(a = "txnDesc2")
        private String txnDesc2;
        @com.google.gsonhtcfix.a.b(a = "txnDesc3")
        private String txnDesc3;
        @com.google.gsonhtcfix.a.b(a = "txnDesc4")
        private String txnDesc4;
        @com.google.gsonhtcfix.a.b(a = "txnId")
        private String txnId;
        @com.google.gsonhtcfix.a.b(a = "txnPostDate")
        private String txnPostDate;
        @com.google.gsonhtcfix.a.b(a = "txnSerialNumber")
        private String txnSerialNumber;
        @com.google.gsonhtcfix.a.b(a = "txnType")
        private String txnType;
        @com.google.gsonhtcfix.a.b(a = "valueDate")
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

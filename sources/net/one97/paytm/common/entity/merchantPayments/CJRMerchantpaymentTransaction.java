package net.one97.paytm.common.entity.merchantPayments;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMerchantpaymentTransaction implements IJRDataModel {
    @c(a = "count")
    public int count;
    @c(a = "errorMessage")
    public String errorMessage;
    @c(a = "resultCode")
    public String resultCode;
    @c(a = "status")
    public String status;
    @c(a = "transactionInfo")
    public TransactionInfo transactionInfo;

    public static class PageInfo implements IJRDataModel {
        @c(a = "currentPage")
        public int currentPage;
        @c(a = "currentSize")
        public int currentSize;
        @c(a = "totalPage")
        public int totalPage;
        @c(a = "totalSize")
        public int totalSize;
    }

    public static class Transaction implements IJRDataModel {
        @c(a = "merchantDisplayName")
        public String merchantDisplayName;
        @c(a = "merchantLogo")
        public String merchantLogo;
        @c(a = "orderId")
        public String orderId;
        @c(a = "txnAmt")
        public String txnAmt;
        @c(a = "txnDate")
        public String txnDate;
        @c(a = "txnId")
        public String txnId;
        @c(a = "txnStatus")
        public String txnStatus;
        @c(a = "txnType")
        public String txnType;
    }

    public static class TransactionInfo implements IJRDataModel {
        @c(a = "pageInfo")
        public PageInfo pageInfo;
        @c(a = "transactions")
        public ArrayList<Transaction> transactions = new ArrayList<>();
    }

    public static class TransactionHeader extends Transaction {
        public String txnDate;

        public TransactionHeader(String str) {
            this.txnDate = str;
        }
    }
}

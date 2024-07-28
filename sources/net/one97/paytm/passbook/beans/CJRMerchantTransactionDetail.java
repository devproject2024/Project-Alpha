package net.one97.paytm.passbook.beans;

import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRMerchantTransactionDetail extends IJRDataModel {
    public int count;
    public Detail detail;
    public String errorMessage;
    public String resultCode;
    public String status;

    public static class Detail extends IJRDataModel {
        public String comments;
        public boolean hybrid;
        public String merchantDisplayName;
        public String merchantLogo;
        public String orderId;
        public ArrayList<Transactions> transactions = new ArrayList<>();
    }

    public static class Transactions extends IJRDataModel {
        public String authCode;
        public String bankAccountNo;
        public String bankTxnId;
        public String commission;
        public String date;
        public String extSerialNo;
        public String issuingBankName;
        public String maskedCardNo;
        public String payMethod;
        public String paymentUpdateTime;
        public String rrn;
        public String serviceTax;
        public String status;
        public String txnAmt;
        public String txnType;
    }
}

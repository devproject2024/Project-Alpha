package net.one97.paytm.passbook.beans.upi;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class UpiBankMetaData extends IJRDataModel {
    @c(a = "bankHealth")
    private BankHealth bankHealth;
    @c(a = "perTxnLimit")
    private String perTxnLimit;

    public String getPerTxnLimit() {
        return this.perTxnLimit;
    }

    public BankHealth getBankHealth() {
        return this.bankHealth;
    }

    class BankHealth implements UpiBaseDataModel {
        @c(a = "category")
        private String category;
        @c(a = "displayMsg")
        private String displayMsg;
        @c(a = "txnAction")
        private String txnAction;

        private BankHealth() {
        }

        public String getCategory() {
            return this.category;
        }

        public String getTxnAction() {
            return this.txnAction;
        }

        public String getDisplayMsg() {
            return this.displayMsg;
        }
    }
}

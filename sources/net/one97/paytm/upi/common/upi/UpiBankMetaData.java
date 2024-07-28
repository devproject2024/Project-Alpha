package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiBankMetaData implements UpiBaseDataModel {
    @c(a = "bankHealth")
    private a bankHealth;
    @c(a = "perTxnLimit")
    private String perTxnLimit;

    public String getPerTxnLimit() {
        return this.perTxnLimit;
    }

    public a getBankHealth() {
        return this.bankHealth;
    }

    class a implements UpiBaseDataModel {
        @c(a = "category")
        private String category;
        @c(a = "displayMsg")
        private String displayMsg;
        @c(a = "txnAction")
        private String txnAction;

        private a() {
        }

        public final String getCategory() {
            return this.category;
        }

        public final String getTxnAction() {
            return this.txnAction;
        }

        public final String getDisplayMsg() {
            return this.displayMsg;
        }
    }
}

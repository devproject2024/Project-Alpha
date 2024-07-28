package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class MerchantTransactions extends CashBackBaseModal {
    @b(a = "data")
    private Data data;

    public Data getData() {
        return this.data;
    }

    public class Data extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "is_next")
        private boolean isNext;
        @b(a = "oldest_txn_time")
        private String oldestTxnTime;
        @b(a = "transactions")
        private ArrayList<TransactionsItem> transactions;

        public Data() {
        }

        public boolean isNext() {
            return this.isNext;
        }

        public String getOldestTxnTime() {
            return this.oldestTxnTime;
        }

        public ArrayList<TransactionsItem> getTransactions() {
            return this.transactions;
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}

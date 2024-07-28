package net.one97.paytm.common.entity.gold.jeweller;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.gold.CJRGoldTransaction;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRGoldStatusModel extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "hasNext")
    private Boolean hasNext;
    @b(a = "last_id")
    private String lastId;
    @b(a = "last_txn_timestamp")
    private String lastTxnTimestamp;
    @b(a = "transactions")
    private List<CJRGoldTransaction> transactions = null;

    public Boolean getHasNext() {
        return this.hasNext;
    }

    public void setHasNext(Boolean bool) {
        this.hasNext = bool;
    }

    public String getLastId() {
        return this.lastId;
    }

    public void setLastId(String str) {
        this.lastId = str;
    }

    public String getLastTxnTimestamp() {
        return this.lastTxnTimestamp;
    }

    public void setLastTxnTimestamp(String str) {
        this.lastTxnTimestamp = str;
    }

    public List<CJRGoldTransaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<CJRGoldTransaction> list) {
        this.transactions = list;
    }
}

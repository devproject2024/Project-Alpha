package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRTransaction;

public class CJRCSTLedger extends CJRCSTDataModelItem {
    private static final long serialVersionUID = 1;
    private String ledgerTag = "";
    private long mLastUpdateTime;
    @b(a = "mMetadata")
    private String mMetadata;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestFGuid;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "response")
    public ArrayList<CJRTransaction> mTransactionList;

    public String getName() {
        return null;
    }

    public long getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public void setLastUpdateTime(long j) {
        this.mLastUpdateTime = j;
    }

    public String getLedgerTag() {
        return this.ledgerTag;
    }

    public void setLedgerTag(String str) {
        this.ledgerTag = str;
    }

    public String getRequestFGuid() {
        return this.mRequestFGuid;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public ArrayList<CJRTransaction> getTransactionList() {
        return this.mTransactionList;
    }

    public String getMetadata() {
        return this.mMetadata;
    }
}

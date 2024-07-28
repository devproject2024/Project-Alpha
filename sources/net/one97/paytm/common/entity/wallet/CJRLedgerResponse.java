package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRLedgerResponse extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "displayMessage")
    private String mDisplayMessage;
    @b(a = "txnGuid")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "txnMessage")
    private String mTxnMessage;
    @b(a = "txnStatus")
    private String mTxnStatus;

    public String getName() {
        return null;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public String getTxnStatus() {
        return this.mTxnStatus;
    }

    public String getTxnMessage() {
        return this.mTxnMessage;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getDisplayMessage() {
        return this.mDisplayMessage;
    }
}

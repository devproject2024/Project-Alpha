package net.one97.paytm.passbook.subWallet.model;

import net.one97.paytm.passbook.beans.CJRTransaction;

public class TransactionHeader extends CJRTransaction {
    public String txnDate;

    public TransactionHeader(String str) {
        this.txnDate = str;
    }
}

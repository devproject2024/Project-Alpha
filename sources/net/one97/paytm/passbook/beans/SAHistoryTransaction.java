package net.one97.paytm.passbook.beans;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SAHistoryTransaction extends IJRDataModel {
    private SAHistoryTransactionHeader txnHeader;
    private SAHistoryTransactionItems txnItem;

    public SAHistoryTransaction() {
        this((SAHistoryTransactionHeader) null, (SAHistoryTransactionItems) null, 3, (g) null);
    }

    public static /* synthetic */ SAHistoryTransaction copy$default(SAHistoryTransaction sAHistoryTransaction, SAHistoryTransactionHeader sAHistoryTransactionHeader, SAHistoryTransactionItems sAHistoryTransactionItems, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sAHistoryTransactionHeader = sAHistoryTransaction.txnHeader;
        }
        if ((i2 & 2) != 0) {
            sAHistoryTransactionItems = sAHistoryTransaction.txnItem;
        }
        return sAHistoryTransaction.copy(sAHistoryTransactionHeader, sAHistoryTransactionItems);
    }

    public final SAHistoryTransactionHeader component1() {
        return this.txnHeader;
    }

    public final SAHistoryTransactionItems component2() {
        return this.txnItem;
    }

    public final SAHistoryTransaction copy(SAHistoryTransactionHeader sAHistoryTransactionHeader, SAHistoryTransactionItems sAHistoryTransactionItems) {
        return new SAHistoryTransaction(sAHistoryTransactionHeader, sAHistoryTransactionItems);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAHistoryTransaction)) {
            return false;
        }
        SAHistoryTransaction sAHistoryTransaction = (SAHistoryTransaction) obj;
        return k.a((Object) this.txnHeader, (Object) sAHistoryTransaction.txnHeader) && k.a((Object) this.txnItem, (Object) sAHistoryTransaction.txnItem);
    }

    public final int hashCode() {
        SAHistoryTransactionHeader sAHistoryTransactionHeader = this.txnHeader;
        int i2 = 0;
        int hashCode = (sAHistoryTransactionHeader != null ? sAHistoryTransactionHeader.hashCode() : 0) * 31;
        SAHistoryTransactionItems sAHistoryTransactionItems = this.txnItem;
        if (sAHistoryTransactionItems != null) {
            i2 = sAHistoryTransactionItems.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SAHistoryTransaction(txnHeader=" + this.txnHeader + ", txnItem=" + this.txnItem + ")";
    }

    public final SAHistoryTransactionHeader getTxnHeader() {
        return this.txnHeader;
    }

    public final void setTxnHeader(SAHistoryTransactionHeader sAHistoryTransactionHeader) {
        this.txnHeader = sAHistoryTransactionHeader;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SAHistoryTransaction(SAHistoryTransactionHeader sAHistoryTransactionHeader, SAHistoryTransactionItems sAHistoryTransactionItems, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : sAHistoryTransactionHeader, (i2 & 2) != 0 ? null : sAHistoryTransactionItems);
    }

    public final SAHistoryTransactionItems getTxnItem() {
        return this.txnItem;
    }

    public final void setTxnItem(SAHistoryTransactionItems sAHistoryTransactionItems) {
        this.txnItem = sAHistoryTransactionItems;
    }

    public SAHistoryTransaction(SAHistoryTransactionHeader sAHistoryTransactionHeader, SAHistoryTransactionItems sAHistoryTransactionItems) {
        this.txnHeader = sAHistoryTransactionHeader;
        this.txnItem = sAHistoryTransactionItems;
    }
}

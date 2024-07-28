package net.one97.paytm.passbook.beans;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class PaymentHistoryTransaction extends IJRDataModel {
    private PaymentHistoryRootHeader headerLayout;
    private PaymentHistoryTransactionHeader txnHeader;
    private PaymentHistoryTransactionItems txnItem;

    public PaymentHistoryTransaction() {
        this((PaymentHistoryRootHeader) null, (PaymentHistoryTransactionHeader) null, (PaymentHistoryTransactionItems) null, 7, (g) null);
    }

    public static /* synthetic */ PaymentHistoryTransaction copy$default(PaymentHistoryTransaction paymentHistoryTransaction, PaymentHistoryRootHeader paymentHistoryRootHeader, PaymentHistoryTransactionHeader paymentHistoryTransactionHeader, PaymentHistoryTransactionItems paymentHistoryTransactionItems, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            paymentHistoryRootHeader = paymentHistoryTransaction.headerLayout;
        }
        if ((i2 & 2) != 0) {
            paymentHistoryTransactionHeader = paymentHistoryTransaction.txnHeader;
        }
        if ((i2 & 4) != 0) {
            paymentHistoryTransactionItems = paymentHistoryTransaction.txnItem;
        }
        return paymentHistoryTransaction.copy(paymentHistoryRootHeader, paymentHistoryTransactionHeader, paymentHistoryTransactionItems);
    }

    public final PaymentHistoryRootHeader component1() {
        return this.headerLayout;
    }

    public final PaymentHistoryTransactionHeader component2() {
        return this.txnHeader;
    }

    public final PaymentHistoryTransactionItems component3() {
        return this.txnItem;
    }

    public final PaymentHistoryTransaction copy(PaymentHistoryRootHeader paymentHistoryRootHeader, PaymentHistoryTransactionHeader paymentHistoryTransactionHeader, PaymentHistoryTransactionItems paymentHistoryTransactionItems) {
        return new PaymentHistoryTransaction(paymentHistoryRootHeader, paymentHistoryTransactionHeader, paymentHistoryTransactionItems);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentHistoryTransaction)) {
            return false;
        }
        PaymentHistoryTransaction paymentHistoryTransaction = (PaymentHistoryTransaction) obj;
        return k.a((Object) this.headerLayout, (Object) paymentHistoryTransaction.headerLayout) && k.a((Object) this.txnHeader, (Object) paymentHistoryTransaction.txnHeader) && k.a((Object) this.txnItem, (Object) paymentHistoryTransaction.txnItem);
    }

    public final int hashCode() {
        PaymentHistoryRootHeader paymentHistoryRootHeader = this.headerLayout;
        int i2 = 0;
        int hashCode = (paymentHistoryRootHeader != null ? paymentHistoryRootHeader.hashCode() : 0) * 31;
        PaymentHistoryTransactionHeader paymentHistoryTransactionHeader = this.txnHeader;
        int hashCode2 = (hashCode + (paymentHistoryTransactionHeader != null ? paymentHistoryTransactionHeader.hashCode() : 0)) * 31;
        PaymentHistoryTransactionItems paymentHistoryTransactionItems = this.txnItem;
        if (paymentHistoryTransactionItems != null) {
            i2 = paymentHistoryTransactionItems.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PaymentHistoryTransaction(headerLayout=" + this.headerLayout + ", txnHeader=" + this.txnHeader + ", txnItem=" + this.txnItem + ")";
    }

    public final PaymentHistoryRootHeader getHeaderLayout() {
        return this.headerLayout;
    }

    public final void setHeaderLayout(PaymentHistoryRootHeader paymentHistoryRootHeader) {
        this.headerLayout = paymentHistoryRootHeader;
    }

    public final PaymentHistoryTransactionHeader getTxnHeader() {
        return this.txnHeader;
    }

    public final void setTxnHeader(PaymentHistoryTransactionHeader paymentHistoryTransactionHeader) {
        this.txnHeader = paymentHistoryTransactionHeader;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentHistoryTransaction(PaymentHistoryRootHeader paymentHistoryRootHeader, PaymentHistoryTransactionHeader paymentHistoryTransactionHeader, PaymentHistoryTransactionItems paymentHistoryTransactionItems, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : paymentHistoryRootHeader, (i2 & 2) != 0 ? null : paymentHistoryTransactionHeader, (i2 & 4) != 0 ? null : paymentHistoryTransactionItems);
    }

    public final PaymentHistoryTransactionItems getTxnItem() {
        return this.txnItem;
    }

    public final void setTxnItem(PaymentHistoryTransactionItems paymentHistoryTransactionItems) {
        this.txnItem = paymentHistoryTransactionItems;
    }

    public PaymentHistoryTransaction(PaymentHistoryRootHeader paymentHistoryRootHeader, PaymentHistoryTransactionHeader paymentHistoryTransactionHeader, PaymentHistoryTransactionItems paymentHistoryTransactionItems) {
        this.headerLayout = paymentHistoryRootHeader;
        this.txnHeader = paymentHistoryTransactionHeader;
        this.txnItem = paymentHistoryTransactionItems;
    }
}

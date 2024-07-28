package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class TransactionListPGResponse extends IJRDataModel {
    @b(a = "accountTransactionInfos")
    private ArrayList<AccountTransactionInfo> accountTransactionInfos;
    @b(a = "paginator")
    private MGVPaginator paginator;

    public static /* synthetic */ TransactionListPGResponse copy$default(TransactionListPGResponse transactionListPGResponse, ArrayList<AccountTransactionInfo> arrayList, MGVPaginator mGVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = transactionListPGResponse.accountTransactionInfos;
        }
        if ((i2 & 2) != 0) {
            mGVPaginator = transactionListPGResponse.paginator;
        }
        return transactionListPGResponse.copy(arrayList, mGVPaginator);
    }

    public final ArrayList<AccountTransactionInfo> component1() {
        return this.accountTransactionInfos;
    }

    public final MGVPaginator component2() {
        return this.paginator;
    }

    public final TransactionListPGResponse copy(ArrayList<AccountTransactionInfo> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "accountTransactionInfos");
        k.c(mGVPaginator, "paginator");
        return new TransactionListPGResponse(arrayList, mGVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionListPGResponse)) {
            return false;
        }
        TransactionListPGResponse transactionListPGResponse = (TransactionListPGResponse) obj;
        return k.a((Object) this.accountTransactionInfos, (Object) transactionListPGResponse.accountTransactionInfos) && k.a((Object) this.paginator, (Object) transactionListPGResponse.paginator);
    }

    public final int hashCode() {
        ArrayList<AccountTransactionInfo> arrayList = this.accountTransactionInfos;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        MGVPaginator mGVPaginator = this.paginator;
        if (mGVPaginator != null) {
            i2 = mGVPaginator.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TransactionListPGResponse(accountTransactionInfos=" + this.accountTransactionInfos + ", paginator=" + this.paginator + ")";
    }

    public final ArrayList<AccountTransactionInfo> getAccountTransactionInfos() {
        return this.accountTransactionInfos;
    }

    public final void setAccountTransactionInfos(ArrayList<AccountTransactionInfo> arrayList) {
        k.c(arrayList, "<set-?>");
        this.accountTransactionInfos = arrayList;
    }

    public TransactionListPGResponse(ArrayList<AccountTransactionInfo> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "accountTransactionInfos");
        k.c(mGVPaginator, "paginator");
        this.accountTransactionInfos = arrayList;
        this.paginator = mGVPaginator;
    }

    public final MGVPaginator getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(MGVPaginator mGVPaginator) {
        k.c(mGVPaginator, "<set-?>");
        this.paginator = mGVPaginator;
    }
}

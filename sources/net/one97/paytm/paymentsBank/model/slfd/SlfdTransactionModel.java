package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdTransactionModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "is_last_page")
    private final boolean isLastPage;
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final String status;
    @b(a = "transactions")
    private final ArrayList<SlfdTransactionItem> transactionList;

    public SlfdTransactionModel() {
        this((String) null, (String) null, (ArrayList) null, false, 15, (g) null);
    }

    public static /* synthetic */ SlfdTransactionModel copy$default(SlfdTransactionModel slfdTransactionModel, String str, String str2, ArrayList<SlfdTransactionItem> arrayList, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = slfdTransactionModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = slfdTransactionModel.message;
        }
        if ((i2 & 4) != 0) {
            arrayList = slfdTransactionModel.transactionList;
        }
        if ((i2 & 8) != 0) {
            z = slfdTransactionModel.isLastPage;
        }
        return slfdTransactionModel.copy(str, str2, arrayList, z);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final ArrayList<SlfdTransactionItem> component3() {
        return this.transactionList;
    }

    public final boolean component4() {
        return this.isLastPage;
    }

    public final SlfdTransactionModel copy(String str, String str2, ArrayList<SlfdTransactionItem> arrayList, boolean z) {
        return new SlfdTransactionModel(str, str2, arrayList, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SlfdTransactionModel) {
                SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) obj;
                if (k.a((Object) this.status, (Object) slfdTransactionModel.status) && k.a((Object) this.message, (Object) slfdTransactionModel.message) && k.a((Object) this.transactionList, (Object) slfdTransactionModel.transactionList)) {
                    if (this.isLastPage == slfdTransactionModel.isLastPage) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<SlfdTransactionItem> arrayList = this.transactionList;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.isLastPage;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "SlfdTransactionModel(status=" + this.status + ", message=" + this.message + ", transactionList=" + this.transactionList + ", isLastPage=" + this.isLastPage + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<SlfdTransactionItem> getTransactionList() {
        return this.transactionList;
    }

    public SlfdTransactionModel(String str, String str2, ArrayList<SlfdTransactionItem> arrayList, boolean z) {
        this.status = str;
        this.message = str2;
        this.transactionList = arrayList;
        this.isLastPage = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlfdTransactionModel(String str, String str2, ArrayList arrayList, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : arrayList, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isLastPage() {
        return this.isLastPage;
    }
}

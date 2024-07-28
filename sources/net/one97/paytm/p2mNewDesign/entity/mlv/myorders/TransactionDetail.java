package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class TransactionDetail extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;
    @b(a = "value")
    private String value;

    public TransactionDetail() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ TransactionDetail copy$default(TransactionDetail transactionDetail, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = transactionDetail.title;
        }
        if ((i2 & 2) != 0) {
            str2 = transactionDetail.value;
        }
        if ((i2 & 4) != 0) {
            str3 = transactionDetail.type;
        }
        return transactionDetail.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.type;
    }

    public final TransactionDetail copy(String str, String str2, String str3) {
        return new TransactionDetail(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionDetail)) {
            return false;
        }
        TransactionDetail transactionDetail = (TransactionDetail) obj;
        return k.a((Object) this.title, (Object) transactionDetail.title) && k.a((Object) this.value, (Object) transactionDetail.value) && k.a((Object) this.type, (Object) transactionDetail.type);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "TransactionDetail(title=" + this.title + ", value=" + this.value + ", type=" + this.type + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public TransactionDetail(String str, String str2, String str3) {
        this.title = str;
        this.value = str2;
        this.type = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransactionDetail(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }
}

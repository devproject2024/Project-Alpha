package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class PaymentHistoryPagination extends IJRDataModel {
    @b(a = "pageNo")
    private Integer pageNo;
    @b(a = "paginationTxnId")
    private String pageTxnId;
    @b(a = "paginationStreamSource")
    private String paginationStreamSource;
    @b(a = "transactionDateEpoch")
    private String transactionDateEpoch;

    public PaymentHistoryPagination() {
        this((String) null, (String) null, (String) null, (Integer) null, 15, (g) null);
    }

    public static /* synthetic */ PaymentHistoryPagination copy$default(PaymentHistoryPagination paymentHistoryPagination, String str, String str2, String str3, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentHistoryPagination.transactionDateEpoch;
        }
        if ((i2 & 2) != 0) {
            str2 = paymentHistoryPagination.paginationStreamSource;
        }
        if ((i2 & 4) != 0) {
            str3 = paymentHistoryPagination.pageTxnId;
        }
        if ((i2 & 8) != 0) {
            num = paymentHistoryPagination.pageNo;
        }
        return paymentHistoryPagination.copy(str, str2, str3, num);
    }

    public final String component1() {
        return this.transactionDateEpoch;
    }

    public final String component2() {
        return this.paginationStreamSource;
    }

    public final String component3() {
        return this.pageTxnId;
    }

    public final Integer component4() {
        return this.pageNo;
    }

    public final PaymentHistoryPagination copy(String str, String str2, String str3, Integer num) {
        return new PaymentHistoryPagination(str, str2, str3, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentHistoryPagination)) {
            return false;
        }
        PaymentHistoryPagination paymentHistoryPagination = (PaymentHistoryPagination) obj;
        return k.a((Object) this.transactionDateEpoch, (Object) paymentHistoryPagination.transactionDateEpoch) && k.a((Object) this.paginationStreamSource, (Object) paymentHistoryPagination.paginationStreamSource) && k.a((Object) this.pageTxnId, (Object) paymentHistoryPagination.pageTxnId) && k.a((Object) this.pageNo, (Object) paymentHistoryPagination.pageNo);
    }

    public final int hashCode() {
        String str = this.transactionDateEpoch;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paginationStreamSource;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pageTxnId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.pageNo;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "PaymentHistoryPagination(transactionDateEpoch=" + this.transactionDateEpoch + ", paginationStreamSource=" + this.paginationStreamSource + ", pageTxnId=" + this.pageTxnId + ", pageNo=" + this.pageNo + ")";
    }

    public final String getTransactionDateEpoch() {
        return this.transactionDateEpoch;
    }

    public final void setTransactionDateEpoch(String str) {
        this.transactionDateEpoch = str;
    }

    public final String getPaginationStreamSource() {
        return this.paginationStreamSource;
    }

    public final void setPaginationStreamSource(String str) {
        this.paginationStreamSource = str;
    }

    public final String getPageTxnId() {
        return this.pageTxnId;
    }

    public final void setPageTxnId(String str) {
        this.pageTxnId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentHistoryPagination(String str, String str2, String str3, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : num);
    }

    public final Integer getPageNo() {
        return this.pageNo;
    }

    public final void setPageNo(Integer num) {
        this.pageNo = num;
    }

    public PaymentHistoryPagination(String str, String str2, String str3, Integer num) {
        this.transactionDateEpoch = str;
        this.paginationStreamSource = str2;
        this.pageTxnId = str3;
        this.pageNo = num;
    }
}

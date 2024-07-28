package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class FetchTransactionsResponse extends IJRDataModel {
    @b(a = "count")
    private Integer count;
    @b(a = "mgvTransactionListPGResponseVO")
    private TransactionListPGResponse data;
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "status")
    private String status;

    public FetchTransactionsResponse() {
        this((TransactionListPGResponse) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ FetchTransactionsResponse copy$default(FetchTransactionsResponse fetchTransactionsResponse, TransactionListPGResponse transactionListPGResponse, String str, Integer num, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            transactionListPGResponse = fetchTransactionsResponse.data;
        }
        if ((i2 & 2) != 0) {
            str = fetchTransactionsResponse.status;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            num = fetchTransactionsResponse.count;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str2 = fetchTransactionsResponse.resultCode;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = fetchTransactionsResponse.errorMessage;
        }
        return fetchTransactionsResponse.copy(transactionListPGResponse, str4, num2, str5, str3);
    }

    public final TransactionListPGResponse component1() {
        return this.data;
    }

    public final String component2() {
        return this.status;
    }

    public final Integer component3() {
        return this.count;
    }

    public final String component4() {
        return this.resultCode;
    }

    public final String component5() {
        return this.errorMessage;
    }

    public final FetchTransactionsResponse copy(TransactionListPGResponse transactionListPGResponse, String str, Integer num, String str2, String str3) {
        return new FetchTransactionsResponse(transactionListPGResponse, str, num, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchTransactionsResponse)) {
            return false;
        }
        FetchTransactionsResponse fetchTransactionsResponse = (FetchTransactionsResponse) obj;
        return k.a((Object) this.data, (Object) fetchTransactionsResponse.data) && k.a((Object) this.status, (Object) fetchTransactionsResponse.status) && k.a((Object) this.count, (Object) fetchTransactionsResponse.count) && k.a((Object) this.resultCode, (Object) fetchTransactionsResponse.resultCode) && k.a((Object) this.errorMessage, (Object) fetchTransactionsResponse.errorMessage);
    }

    public final int hashCode() {
        TransactionListPGResponse transactionListPGResponse = this.data;
        int i2 = 0;
        int hashCode = (transactionListPGResponse != null ? transactionListPGResponse.hashCode() : 0) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.count;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.resultCode;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.errorMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "FetchTransactionsResponse(data=" + this.data + ", status=" + this.status + ", count=" + this.count + ", resultCode=" + this.resultCode + ", errorMessage=" + this.errorMessage + ")";
    }

    public final TransactionListPGResponse getData() {
        return this.data;
    }

    public final void setData(TransactionListPGResponse transactionListPGResponse) {
        this.data = transactionListPGResponse;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public FetchTransactionsResponse(TransactionListPGResponse transactionListPGResponse, String str, Integer num, String str2, String str3) {
        this.data = transactionListPGResponse;
        this.status = str;
        this.count = num;
        this.resultCode = str2;
        this.errorMessage = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FetchTransactionsResponse(net.one97.paytm.passbook.beans.mgv.TransactionListPGResponse r5, java.lang.String r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.beans.mgv.FetchTransactionsResponse.<init>(net.one97.paytm.passbook.beans.mgv.TransactionListPGResponse, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}

package net.one97.paytm.common.entity.moneytransfer.requestmoney;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RequestMoneyActionModel implements IJRDataModel {
    private final String amount;
    private final String note;
    private final String payeeName;
    private final String payeeVa;
    private final String payerVA;
    private final String txnId;

    public static /* synthetic */ RequestMoneyActionModel copy$default(RequestMoneyActionModel requestMoneyActionModel, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = requestMoneyActionModel.payerVA;
        }
        if ((i2 & 2) != 0) {
            str2 = requestMoneyActionModel.amount;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = requestMoneyActionModel.payeeName;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = requestMoneyActionModel.payeeVa;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = requestMoneyActionModel.txnId;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = requestMoneyActionModel.note;
        }
        return requestMoneyActionModel.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.payerVA;
    }

    public final String component2() {
        return this.amount;
    }

    public final String component3() {
        return this.payeeName;
    }

    public final String component4() {
        return this.payeeVa;
    }

    public final String component5() {
        return this.txnId;
    }

    public final String component6() {
        return this.note;
    }

    public final RequestMoneyActionModel copy(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "payerVA");
        k.c(str2, "amount");
        k.c(str3, "payeeName");
        k.c(str4, "payeeVa");
        k.c(str5, "txnId");
        k.c(str6, "note");
        return new RequestMoneyActionModel(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestMoneyActionModel)) {
            return false;
        }
        RequestMoneyActionModel requestMoneyActionModel = (RequestMoneyActionModel) obj;
        return k.a((Object) this.payerVA, (Object) requestMoneyActionModel.payerVA) && k.a((Object) this.amount, (Object) requestMoneyActionModel.amount) && k.a((Object) this.payeeName, (Object) requestMoneyActionModel.payeeName) && k.a((Object) this.payeeVa, (Object) requestMoneyActionModel.payeeVa) && k.a((Object) this.txnId, (Object) requestMoneyActionModel.txnId) && k.a((Object) this.note, (Object) requestMoneyActionModel.note);
    }

    public final int hashCode() {
        String str = this.payerVA;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payeeName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payeeVa;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.txnId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.note;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "RequestMoneyActionModel(payerVA=" + this.payerVA + ", amount=" + this.amount + ", payeeName=" + this.payeeName + ", payeeVa=" + this.payeeVa + ", txnId=" + this.txnId + ", note=" + this.note + ")";
    }

    public RequestMoneyActionModel(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "payerVA");
        k.c(str2, "amount");
        k.c(str3, "payeeName");
        k.c(str4, "payeeVa");
        k.c(str5, "txnId");
        k.c(str6, "note");
        this.payerVA = str;
        this.amount = str2;
        this.payeeName = str3;
        this.payeeVa = str4;
        this.txnId = str5;
        this.note = str6;
    }

    public final String getPayerVA() {
        return this.payerVA;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPayeeName() {
        return this.payeeName;
    }

    public final String getPayeeVa() {
        return this.payeeVa;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getNote() {
        return this.note;
    }
}

package net.one97.paytm.common.entity.moneytransfer;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class UPISuggestedBankModel extends IJRPaytmDataModel {
    private String bankIfsc;
    private String bankName;
    private Integer serialNo;

    public static /* synthetic */ UPISuggestedBankModel copy$default(UPISuggestedBankModel uPISuggestedBankModel, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = uPISuggestedBankModel.serialNo;
        }
        if ((i2 & 2) != 0) {
            str = uPISuggestedBankModel.bankName;
        }
        if ((i2 & 4) != 0) {
            str2 = uPISuggestedBankModel.bankIfsc;
        }
        return uPISuggestedBankModel.copy(num, str, str2);
    }

    public final Integer component1() {
        return this.serialNo;
    }

    public final String component2() {
        return this.bankName;
    }

    public final String component3() {
        return this.bankIfsc;
    }

    public final UPISuggestedBankModel copy(Integer num, String str, String str2) {
        return new UPISuggestedBankModel(num, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UPISuggestedBankModel)) {
            return false;
        }
        UPISuggestedBankModel uPISuggestedBankModel = (UPISuggestedBankModel) obj;
        return k.a((Object) this.serialNo, (Object) uPISuggestedBankModel.serialNo) && k.a((Object) this.bankName, (Object) uPISuggestedBankModel.bankName) && k.a((Object) this.bankIfsc, (Object) uPISuggestedBankModel.bankIfsc);
    }

    public final int hashCode() {
        Integer num = this.serialNo;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.bankName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bankIfsc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UPISuggestedBankModel(serialNo=" + this.serialNo + ", bankName=" + this.bankName + ", bankIfsc=" + this.bankIfsc + ")";
    }

    public final Integer getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(Integer num) {
        this.serialNo = num;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public UPISuggestedBankModel(Integer num, String str, String str2) {
        this.serialNo = num;
        this.bankName = str;
        this.bankIfsc = str2;
    }

    public final String getBankIfsc() {
        return this.bankIfsc;
    }

    public final void setBankIfsc(String str) {
        this.bankIfsc = str;
    }
}

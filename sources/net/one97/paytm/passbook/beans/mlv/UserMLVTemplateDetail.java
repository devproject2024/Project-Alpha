package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UserMLVTemplateDetail extends IJRDataModel {
    @b(a = "cardTemplate")
    private MLVCardTemplate mlvCardTemplate;
    @b(a = "totalBalance")
    private MLVAmount totalBalance;

    public static /* synthetic */ UserMLVTemplateDetail copy$default(UserMLVTemplateDetail userMLVTemplateDetail, MLVCardTemplate mLVCardTemplate, MLVAmount mLVAmount, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mLVCardTemplate = userMLVTemplateDetail.mlvCardTemplate;
        }
        if ((i2 & 2) != 0) {
            mLVAmount = userMLVTemplateDetail.totalBalance;
        }
        return userMLVTemplateDetail.copy(mLVCardTemplate, mLVAmount);
    }

    public final MLVCardTemplate component1() {
        return this.mlvCardTemplate;
    }

    public final MLVAmount component2() {
        return this.totalBalance;
    }

    public final UserMLVTemplateDetail copy(MLVCardTemplate mLVCardTemplate, MLVAmount mLVAmount) {
        k.c(mLVCardTemplate, "mlvCardTemplate");
        k.c(mLVAmount, "totalBalance");
        return new UserMLVTemplateDetail(mLVCardTemplate, mLVAmount);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMLVTemplateDetail)) {
            return false;
        }
        UserMLVTemplateDetail userMLVTemplateDetail = (UserMLVTemplateDetail) obj;
        return k.a((Object) this.mlvCardTemplate, (Object) userMLVTemplateDetail.mlvCardTemplate) && k.a((Object) this.totalBalance, (Object) userMLVTemplateDetail.totalBalance);
    }

    public final int hashCode() {
        MLVCardTemplate mLVCardTemplate = this.mlvCardTemplate;
        int i2 = 0;
        int hashCode = (mLVCardTemplate != null ? mLVCardTemplate.hashCode() : 0) * 31;
        MLVAmount mLVAmount = this.totalBalance;
        if (mLVAmount != null) {
            i2 = mLVAmount.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UserMLVTemplateDetail(mlvCardTemplate=" + this.mlvCardTemplate + ", totalBalance=" + this.totalBalance + ")";
    }

    public final MLVCardTemplate getMlvCardTemplate() {
        return this.mlvCardTemplate;
    }

    public final void setMlvCardTemplate(MLVCardTemplate mLVCardTemplate) {
        k.c(mLVCardTemplate, "<set-?>");
        this.mlvCardTemplate = mLVCardTemplate;
    }

    public final MLVAmount getTotalBalance() {
        return this.totalBalance;
    }

    public final void setTotalBalance(MLVAmount mLVAmount) {
        k.c(mLVAmount, "<set-?>");
        this.totalBalance = mLVAmount;
    }

    public UserMLVTemplateDetail(MLVCardTemplate mLVCardTemplate, MLVAmount mLVAmount) {
        k.c(mLVCardTemplate, "mlvCardTemplate");
        k.c(mLVAmount, "totalBalance");
        this.mlvCardTemplate = mLVCardTemplate;
        this.totalBalance = mLVAmount;
    }
}

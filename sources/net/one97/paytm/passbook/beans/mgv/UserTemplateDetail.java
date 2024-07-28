package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UserTemplateDetail extends IJRDataModel {
    @b(a = "cardTemplate")
    private CardTemplate cardTemplate;
    @b(a = "totalBalance")
    private MGVAmount totalBalance;

    public static /* synthetic */ UserTemplateDetail copy$default(UserTemplateDetail userTemplateDetail, CardTemplate cardTemplate2, MGVAmount mGVAmount, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cardTemplate2 = userTemplateDetail.cardTemplate;
        }
        if ((i2 & 2) != 0) {
            mGVAmount = userTemplateDetail.totalBalance;
        }
        return userTemplateDetail.copy(cardTemplate2, mGVAmount);
    }

    public final CardTemplate component1() {
        return this.cardTemplate;
    }

    public final MGVAmount component2() {
        return this.totalBalance;
    }

    public final UserTemplateDetail copy(CardTemplate cardTemplate2, MGVAmount mGVAmount) {
        k.c(cardTemplate2, "cardTemplate");
        k.c(mGVAmount, "totalBalance");
        return new UserTemplateDetail(cardTemplate2, mGVAmount);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTemplateDetail)) {
            return false;
        }
        UserTemplateDetail userTemplateDetail = (UserTemplateDetail) obj;
        return k.a((Object) this.cardTemplate, (Object) userTemplateDetail.cardTemplate) && k.a((Object) this.totalBalance, (Object) userTemplateDetail.totalBalance);
    }

    public final int hashCode() {
        CardTemplate cardTemplate2 = this.cardTemplate;
        int i2 = 0;
        int hashCode = (cardTemplate2 != null ? cardTemplate2.hashCode() : 0) * 31;
        MGVAmount mGVAmount = this.totalBalance;
        if (mGVAmount != null) {
            i2 = mGVAmount.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UserTemplateDetail(cardTemplate=" + this.cardTemplate + ", totalBalance=" + this.totalBalance + ")";
    }

    public final CardTemplate getCardTemplate() {
        return this.cardTemplate;
    }

    public final void setCardTemplate(CardTemplate cardTemplate2) {
        k.c(cardTemplate2, "<set-?>");
        this.cardTemplate = cardTemplate2;
    }

    public UserTemplateDetail(CardTemplate cardTemplate2, MGVAmount mGVAmount) {
        k.c(cardTemplate2, "cardTemplate");
        k.c(mGVAmount, "totalBalance");
        this.cardTemplate = cardTemplate2;
        this.totalBalance = mGVAmount;
    }

    public final MGVAmount getTotalBalance() {
        return this.totalBalance;
    }

    public final void setTotalBalance(MGVAmount mGVAmount) {
        k.c(mGVAmount, "<set-?>");
        this.totalBalance = mGVAmount;
    }
}

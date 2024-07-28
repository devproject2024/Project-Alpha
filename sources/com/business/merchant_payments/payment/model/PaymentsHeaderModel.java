package com.business.merchant_payments.payment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class PaymentsHeaderModel {
    public String date;

    public PaymentsHeaderModel() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ PaymentsHeaderModel copy$default(PaymentsHeaderModel paymentsHeaderModel, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentsHeaderModel.date;
        }
        return paymentsHeaderModel.copy(str);
    }

    public final String component1() {
        return this.date;
    }

    public final PaymentsHeaderModel copy(String str) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        return new PaymentsHeaderModel(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PaymentsHeaderModel) && k.a((Object) this.date, (Object) ((PaymentsHeaderModel) obj).date);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.date;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PaymentsHeaderModel(date=" + this.date + ")";
    }

    public PaymentsHeaderModel(String str) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        this.date = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentsHeaderModel(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        k.d(str, "<set-?>");
        this.date = str;
    }
}

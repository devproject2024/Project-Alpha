package com.business.merchant_payments.payment.model;

import androidx.databinding.ObservableBoolean;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class PaymentsShowMoreModel {
    public String date;
    public ObservableBoolean showMoreButtonProgressState;
    public ObservableBoolean showMoreButtonState;

    public PaymentsShowMoreModel() {
        this((String) null, (ObservableBoolean) null, (ObservableBoolean) null, 7, (g) null);
    }

    public static /* synthetic */ PaymentsShowMoreModel copy$default(PaymentsShowMoreModel paymentsShowMoreModel, String str, ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentsShowMoreModel.date;
        }
        if ((i2 & 2) != 0) {
            observableBoolean = paymentsShowMoreModel.showMoreButtonState;
        }
        if ((i2 & 4) != 0) {
            observableBoolean2 = paymentsShowMoreModel.showMoreButtonProgressState;
        }
        return paymentsShowMoreModel.copy(str, observableBoolean, observableBoolean2);
    }

    public final String component1() {
        return this.date;
    }

    public final ObservableBoolean component2() {
        return this.showMoreButtonState;
    }

    public final ObservableBoolean component3() {
        return this.showMoreButtonProgressState;
    }

    public final PaymentsShowMoreModel copy(String str, ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        k.d(observableBoolean, "showMoreButtonState");
        k.d(observableBoolean2, "showMoreButtonProgressState");
        return new PaymentsShowMoreModel(str, observableBoolean, observableBoolean2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsShowMoreModel)) {
            return false;
        }
        PaymentsShowMoreModel paymentsShowMoreModel = (PaymentsShowMoreModel) obj;
        return k.a((Object) this.date, (Object) paymentsShowMoreModel.date) && k.a((Object) this.showMoreButtonState, (Object) paymentsShowMoreModel.showMoreButtonState) && k.a((Object) this.showMoreButtonProgressState, (Object) paymentsShowMoreModel.showMoreButtonProgressState);
    }

    public final int hashCode() {
        String str = this.date;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ObservableBoolean observableBoolean = this.showMoreButtonState;
        int hashCode2 = (hashCode + (observableBoolean != null ? observableBoolean.hashCode() : 0)) * 31;
        ObservableBoolean observableBoolean2 = this.showMoreButtonProgressState;
        if (observableBoolean2 != null) {
            i2 = observableBoolean2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PaymentsShowMoreModel(date=" + this.date + ", showMoreButtonState=" + this.showMoreButtonState + ", showMoreButtonProgressState=" + this.showMoreButtonProgressState + ")";
    }

    public PaymentsShowMoreModel(String str, ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        k.d(observableBoolean, "showMoreButtonState");
        k.d(observableBoolean2, "showMoreButtonProgressState");
        this.date = str;
        this.showMoreButtonState = observableBoolean;
        this.showMoreButtonProgressState = observableBoolean2;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        k.d(str, "<set-?>");
        this.date = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentsShowMoreModel(String str, ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new ObservableBoolean(true) : observableBoolean, (i2 & 4) != 0 ? new ObservableBoolean(false) : observableBoolean2);
    }

    public final ObservableBoolean getShowMoreButtonState() {
        return this.showMoreButtonState;
    }

    public final void setShowMoreButtonState(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.showMoreButtonState = observableBoolean;
    }

    public final ObservableBoolean getShowMoreButtonProgressState() {
        return this.showMoreButtonProgressState;
    }

    public final void setShowMoreButtonProgressState(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.showMoreButtonProgressState = observableBoolean;
    }

    public final int shouldShowMore(ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2) {
        k.d(observableBoolean, "showMoreButtonState");
        k.d(observableBoolean2, "showMoreButtonProgressState");
        return (observableBoolean2.get() || !observableBoolean.get()) ? 8 : 0;
    }

    public final int shouldShowLess(ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2) {
        k.d(observableBoolean, "showMoreButtonState");
        k.d(observableBoolean2, "showMoreButtonProgressState");
        return (observableBoolean2.get() || observableBoolean.get()) ? 8 : 0;
    }
}

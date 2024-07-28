package com.business.merchant_payments.payment.model;

import android.view.View;
import kotlin.g.b.k;

public final class GenericErrorModel {
    public View.OnClickListener onClick;

    public static /* synthetic */ GenericErrorModel copy$default(GenericErrorModel genericErrorModel, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onClickListener = genericErrorModel.onClick;
        }
        return genericErrorModel.copy(onClickListener);
    }

    public final View.OnClickListener component1() {
        return this.onClick;
    }

    public final GenericErrorModel copy(View.OnClickListener onClickListener) {
        k.d(onClickListener, "onClick");
        return new GenericErrorModel(onClickListener);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GenericErrorModel) && k.a((Object) this.onClick, (Object) ((GenericErrorModel) obj).onClick);
        }
        return true;
    }

    public final int hashCode() {
        View.OnClickListener onClickListener = this.onClick;
        if (onClickListener != null) {
            return onClickListener.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "GenericErrorModel(onClick=" + this.onClick + ")";
    }

    public GenericErrorModel(View.OnClickListener onClickListener) {
        k.d(onClickListener, "onClick");
        this.onClick = onClickListener;
    }

    public final View.OnClickListener getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(View.OnClickListener onClickListener) {
        k.d(onClickListener, "<set-?>");
        this.onClick = onClickListener;
    }
}

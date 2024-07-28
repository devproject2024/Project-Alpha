package com.business.merchant_payments;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.v {
    public abstract void bindData(Object obj, int i2);

    public void bindData(Object obj, int i2, int i3) {
    }

    public BaseViewHolder(View view) {
        super(view);
    }
}

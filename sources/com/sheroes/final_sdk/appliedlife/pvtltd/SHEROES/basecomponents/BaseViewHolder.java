package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.v implements View.OnClickListener {
    public abstract void bindData(T t, Context context, int i2);

    public abstract void viewRecycled();

    public BaseViewHolder(View view) {
        super(view);
    }
}

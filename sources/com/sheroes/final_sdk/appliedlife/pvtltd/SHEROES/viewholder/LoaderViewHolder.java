package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;

public class LoaderViewHolder extends RecyclerView.v {
    private final ProgressBar progress;

    public LoaderViewHolder(View view) {
        super(view);
        this.progress = (ProgressBar) view;
    }

    public void bindData(int i2, boolean z) {
        this.progress.setVisibility((i2 <= 0 || !z) ? 8 : 0);
    }
}

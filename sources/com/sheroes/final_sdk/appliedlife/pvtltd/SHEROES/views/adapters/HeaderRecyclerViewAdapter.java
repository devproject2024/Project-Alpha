package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public abstract class HeaderRecyclerViewAdapter extends RecyclerView.a<RecyclerView.v> {
    private static final int TYPE_HEADER = -100;
    public static final String header = "HEADER";
    private String headers = null;

    public abstract void bindHeaderViewHolder(HeaderViewHolder headerViewHolder);

    public abstract int customGetItemCount();

    public abstract int customGetItemViewType(int i2);

    public abstract void customOnBindViewHolder(RecyclerView.v vVar, int i2);

    public abstract RecyclerView.v customOnCreateViewHolder(ViewGroup viewGroup, int i2);

    public abstract HeaderViewHolder getHeaderViewHolder(ViewGroup viewGroup);

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != -100) {
            return customOnCreateViewHolder(viewGroup, i2);
        }
        return getHeaderViewHolder(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar.getItemViewType() == -100) {
            bindHeaderViewHolder((HeaderViewHolder) vVar);
        }
        customOnBindViewHolder(vVar, i2 - getHeaderSize());
    }

    public int getItemViewType(int i2) {
        if (getHeaderSize() == 0 || i2 != 0) {
            return customGetItemViewType(i2 - getHeaderSize());
        }
        return -100;
    }

    public int getItemCount() {
        return getHeaderSize() + customGetItemCount();
    }

    public void addHeader(String str) {
        if (this.headers == null) {
            this.headers = str;
            notifyItemInserted(0);
        }
    }

    public void removeHeader(String str) {
        String str2 = this.headers;
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            notifyItemRemoved(0);
            this.headers = null;
        }
    }

    public int getHeaderSize() {
        return this.headers != null ? 1 : 0;
    }

    public void customNotifyItemChanged(int i2) {
        notifyItemChanged(i2 + getHeaderSize());
    }

    public int getExactPosition(int i2) {
        return i2 - getHeaderSize();
    }

    public abstract class HeaderViewHolder extends RecyclerView.v {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }
}

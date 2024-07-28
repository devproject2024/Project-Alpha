package com.business.merchant_payments.common;

import androidx.recyclerview.widget.h;
import java.util.List;
import kotlin.g.b.k;

public class MPBaseAdapterDiffCallback extends h.a {
    public final List<Object> mNewList;
    public final List<Object> mOldList;

    public MPBaseAdapterDiffCallback(List<? extends Object> list, List<? extends Object> list2) {
        k.d(list, "mOldList");
        k.d(list2, "mNewList");
        this.mOldList = list;
        this.mNewList = list2;
    }

    public int getOldListSize() {
        return this.mOldList.size();
    }

    public int getNewListSize() {
        return this.mNewList.size();
    }

    public boolean areItemsTheSame(int i2, int i3) {
        return this.mOldList.get(i2) == this.mNewList.get(i3);
    }

    public boolean areContentsTheSame(int i2, int i3) {
        return k.a(this.mOldList.get(i2), this.mNewList.get(i3));
    }
}

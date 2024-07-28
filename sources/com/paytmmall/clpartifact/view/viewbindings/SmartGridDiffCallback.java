package com.paytmmall.clpartifact.view.viewbindings;

import androidx.recyclerview.widget.h;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.List;
import kotlin.g.b.k;

public final class SmartGridDiffCallback extends h.a {
    private final List<Item> newList;
    private final List<Item> oldList;

    public SmartGridDiffCallback(List<? extends Item> list, List<? extends Item> list2) {
        k.c(list, "oldList");
        k.c(list2, "newList");
        this.oldList = list;
        this.newList = list2;
    }

    public final int getOldListSize() {
        return this.oldList.size();
    }

    public final int getNewListSize() {
        return this.newList.size();
    }

    public final boolean areItemsTheSame(int i2, int i3) {
        return this.oldList.size() > i2 && this.newList.size() > i3 && this.oldList.get(i2).getId() == this.newList.get(i3).getId();
    }

    public final boolean areContentsTheSame(int i2, int i3) {
        return this.oldList.size() > i2 && this.newList.size() > i3 && this.oldList.get(i2).getName() == this.newList.get(i3).getName();
    }
}

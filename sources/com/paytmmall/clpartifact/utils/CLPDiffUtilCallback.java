package com.paytmmall.clpartifact.utils;

import androidx.recyclerview.widget.h;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import java.util.List;

public class CLPDiffUtilCallback extends h.a {
    private List<Page> mNewPageList;
    private List<Page> mOldPageList;

    public CLPDiffUtilCallback(List<Page> list, List<Page> list2) {
        this.mOldPageList = list;
        this.mNewPageList = list2;
    }

    public int getOldListSize() {
        return this.mOldPageList.size();
    }

    public int getNewListSize() {
        return this.mNewPageList.size();
    }

    public boolean areItemsTheSame(int i2, int i3) {
        return this.mOldPageList.get(i2).getId().equals(this.mNewPageList.get(i3).getId());
    }

    public boolean areContentsTheSame(int i2, int i3) {
        return this.mOldPageList.get(i2).equals(this.mNewPageList.get(i3));
    }
}

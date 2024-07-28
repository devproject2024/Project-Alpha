package com.paytmmall.clpartifact.view.fragment;

import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.adapter.IOnFilterClickListener;
import net.one97.paytm.i.h;

public abstract class FilterDetailFragment extends h {
    protected IOnFilterClickListener mOnFilterChildClickListener;

    public abstract void onClear(CJRFilterItem cJRFilterItem);

    public void setOnFilterChildClickListener(IOnFilterClickListener iOnFilterClickListener) {
        this.mOnFilterChildClickListener = iOnFilterClickListener;
    }
}

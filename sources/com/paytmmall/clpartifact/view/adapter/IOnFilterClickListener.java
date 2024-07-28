package com.paytmmall.clpartifact.view.adapter;

import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.fragment.FilterDetailFragment;

public interface IOnFilterClickListener {
    void onCategoryFilterClick(String str, boolean z, boolean z2, String str2);

    void onFilterItemClick(int i2, CJRFilterItem cJRFilterItem, FilterDetailFragment filterDetailFragment, boolean z);
}

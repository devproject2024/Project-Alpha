package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentFilterCategoryBinding;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CategoryParseHelper;
import com.paytmmall.clpartifact.view.adapter.CategoryFilterValuesAdapter;
import java.util.List;

public class FilterCategoryTreeFragment extends FilterDetailFragment {
    private CJRFrontEndFilter mFilterItem;
    private FragmentFilterCategoryBinding mFragmentBinding;
    private List<CJRFrontEndFilterItem> parsedFilterItem;

    public void onClear(CJRFilterItem cJRFilterItem) {
    }

    public static FilterCategoryTreeFragment getInstance(CJRFrontEndFilter cJRFrontEndFilter) {
        FilterCategoryTreeFragment filterCategoryTreeFragment = new FilterCategoryTreeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLPConstants.KEY_FRONTEND_FILTER_ITEM, cJRFrontEndFilter);
        filterCategoryTreeFragment.setArguments(bundle);
        return filterCategoryTreeFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mFragmentBinding = (FragmentFilterCategoryBinding) f.a(layoutInflater, R.layout.fragment_filter_category, viewGroup, false);
        this.mFilterItem = getFilterItem();
        setupRecyclerView();
        return this.mFragmentBinding.getRoot();
    }

    private void setupRecyclerView() {
        this.parsedFilterItem = CategoryParseHelper.getParsedFilterItem(this.mFilterItem);
        this.mFragmentBinding.rvFilterValues.setAdapter(new CategoryFilterValuesAdapter(this.parsedFilterItem, this.mOnFilterChildClickListener));
    }

    private CJRFrontEndFilter getFilterItem() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(CLPConstants.KEY_FRONTEND_FILTER_ITEM)) {
            return null;
        }
        return (CJRFrontEndFilter) arguments.get(CLPConstants.KEY_FRONTEND_FILTER_ITEM);
    }
}

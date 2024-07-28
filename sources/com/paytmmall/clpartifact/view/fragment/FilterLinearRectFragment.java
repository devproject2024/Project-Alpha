package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentFilterRectBinding;
import com.paytmmall.clpartifact.listeners.IFilterValueListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.view.adapter.FilterValuesAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FilterLinearRectFragment extends FilterDetailFragment implements Filterable, IFilterValueListener {
    /* access modifiers changed from: private */
    public FilterValuesAdapter adapter;
    private CJRFilterItem mFilterItem;
    /* access modifiers changed from: private */
    public List<CJRFilterValue> mFilterValues;
    private FragmentFilterRectBinding mFragmentBinding;
    private Set<String> mSelectedIDs;
    private SearchFilter searchFilter;

    public static FilterDetailFragment getInstance(CJRFilterItem cJRFilterItem) {
        FilterLinearRectFragment filterLinearRectFragment = new FilterLinearRectFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLPConstants.KEY_FILTER_ITEM, cJRFilterItem);
        filterLinearRectFragment.setArguments(bundle);
        return filterLinearRectFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mFragmentBinding = (FragmentFilterRectBinding) f.a(layoutInflater, R.layout.fragment_filter_rect, viewGroup, false);
        this.mFilterItem = getFilterItem();
        setupRecyclerView();
        return this.mFragmentBinding.getRoot();
    }

    private void setupRecyclerView() {
        this.mFragmentBinding.searchTxt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                FilterLinearRectFragment.this.getFilter().filter(charSequence);
            }
        });
        if (this.mFilterItem.getFilterValues().size() > 10) {
            this.mFragmentBinding.lytSearch.setVisibility(0);
            if (!TextUtils.isEmpty(this.mFilterItem.getTitle())) {
                this.mFragmentBinding.searchTxt.setHint(getActivity().getResources().getString(R.string.search_by_brand, new Object[]{this.mFilterItem.getTitle()}));
            } else {
                this.mFragmentBinding.searchTxt.setHint(getActivity().getResources().getString(R.string.search));
            }
        }
        updateDataVariables();
        CJRFilterItem cJRFilterItem = this.mFilterItem;
        this.adapter = new FilterValuesAdapter(cJRFilterItem, this.mSelectedIDs, cJRFilterItem.getFilterParam());
        this.mFragmentBinding.rvFilterValues.setAdapter(this.adapter);
    }

    private void updateDataVariables() {
        this.mFilterValues = modifySelectedValues(this.mFilterItem);
        this.mSelectedIDs = getSelectedIds();
    }

    private List<CJRFilterValue> modifySelectedValues(CJRFilterItem cJRFilterItem) {
        ArrayList<CJRFilterValue> filterValues = cJRFilterItem.getFilterValues();
        ArrayList<CJRFilterValue> filterApplied = cJRFilterItem.getFilterApplied();
        ArrayList arrayList = new ArrayList();
        Iterator<CJRFilterValue> it2 = filterValues.iterator();
        while (it2.hasNext()) {
            CJRFilterValue next = it2.next();
            if (checkIfFilterValueApplied(next, filterApplied)) {
                next.setChecked(true);
                arrayList.add(next);
                it2.remove();
            } else {
                next.setChecked(false);
            }
        }
        arrayList.addAll(filterValues);
        cJRFilterItem.setFilterValues(arrayList);
        return arrayList;
    }

    private boolean checkIfFilterValueApplied(CJRFilterValue cJRFilterValue, List<CJRFilterValue> list) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                CJRFilterValue cJRFilterValue2 = list.get(i2);
                if (cJRFilterValue2 != null && cJRFilterValue2.equals(cJRFilterValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<String> getSelectedIds() {
        HashSet hashSet = new HashSet();
        for (CJRFilterValue next : this.mFilterValues) {
            if (next.isChecked()) {
                hashSet.add(next.getID());
            }
        }
        return hashSet;
    }

    private CJRFilterItem getFilterItem() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(CLPConstants.KEY_FILTER_ITEM)) {
            return null;
        }
        return (CJRFilterItem) arguments.get(CLPConstants.KEY_FILTER_ITEM);
    }

    public Pair<String, String> getUpdatedFilterValues() {
        return new Pair<>(this.mFilterItem.getFilterParam(), Utils.getCSVValue(this.mSelectedIDs));
    }

    public Filter getFilter() {
        if (this.searchFilter == null) {
            this.searchFilter = new SearchFilter();
        }
        return this.searchFilter;
    }

    public void onClear(CJRFilterItem cJRFilterItem) {
        this.mFilterItem = cJRFilterItem;
        updateDataVariables();
        FilterValuesAdapter filterValuesAdapter = this.adapter;
        if (filterValuesAdapter != null) {
            filterValuesAdapter.updateData(this.mFilterItem);
        }
    }

    class SearchFilter extends Filter {
        private SearchFilter() {
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() <= 0) {
                filterResults.count = FilterLinearRectFragment.this.mFilterValues.size();
                filterResults.values = FilterLinearRectFragment.this.mFilterValues;
            } else {
                ArrayList arrayList = new ArrayList();
                for (CJRFilterValue cJRFilterValue : FilterLinearRectFragment.this.mFilterValues) {
                    if (cJRFilterValue.getName().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        arrayList.add(cJRFilterValue);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            FilterLinearRectFragment.this.adapter.updateFilterValueList((List) filterResults.values);
        }
    }
}

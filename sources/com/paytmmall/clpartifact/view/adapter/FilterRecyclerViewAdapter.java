package com.paytmmall.clpartifact.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.databinding.ItemFilterListBinding;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.utils.FilterWidgetUtils;
import com.paytmmall.clpartifact.view.fragment.FilterDetailFragment;
import java.util.List;

public class FilterRecyclerViewAdapter extends RecyclerView.a<FilterListViewHolder> {
    /* access modifiers changed from: private */
    public IOnFilterClickListener mFilterClickListener;
    private List<FilterDetailFragment> mFilterDetailFragment;
    /* access modifiers changed from: private */
    public List<CJRFilterItem> mFilterList;
    /* access modifiers changed from: private */
    public int mSelected;

    public FilterRecyclerViewAdapter(List<CJRFilterItem> list, List<FilterDetailFragment> list2, IOnFilterClickListener iOnFilterClickListener, int i2) {
        this.mFilterList = list;
        this.mFilterDetailFragment = list2;
        this.mFilterClickListener = iOnFilterClickListener;
        this.mSelected = i2;
    }

    public FilterListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FilterListViewHolder((ItemFilterListBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_filter_list));
    }

    public void onBindViewHolder(FilterListViewHolder filterListViewHolder, int i2) {
        filterListViewHolder.bind(i2, this.mFilterList.get(i2), this.mFilterDetailFragment.get(i2));
        filterListViewHolder.itemView.setSelected(true);
    }

    public int getItemCount() {
        List<CJRFilterItem> list = this.mFilterList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class FilterListViewHolder extends RecyclerView.v {
        private FilterDetailFragment mFragment;
        private ItemFilterListBinding mItemViewDataBinding;

        public FilterListViewHolder(ItemFilterListBinding itemFilterListBinding) {
            super(itemFilterListBinding.getRoot());
            this.mItemViewDataBinding = itemFilterListBinding;
        }

        public void bind(int i2, CJRFilterItem cJRFilterItem, FilterDetailFragment filterDetailFragment) {
            int i3;
            this.mFragment = filterDetailFragment;
            this.mItemViewDataBinding.setItem(cJRFilterItem);
            this.mItemViewDataBinding.setHandler(this);
            this.mItemViewDataBinding.setPosition(Integer.valueOf(i2));
            int i4 = -1;
            int i5 = 0;
            this.mItemViewDataBinding.imageSelectedFilter.setVisibility(!cJRFilterItem.getTitle().equals("Price") ? !(cJRFilterItem.getFilterApplied() == null || cJRFilterItem.getFilterApplied().isEmpty()) : !(cJRFilterItem.getFilterAppliedRange() == null || cJRFilterItem.getFilterAppliedRange().getAbsoluteMax() == -1) ? 0 : 4);
            LinearLayout linearLayout = this.mItemViewDataBinding.linearRectItem;
            if (!cJRFilterItem.isToggleChecked()) {
                i4 = this.mItemViewDataBinding.getRoot().getResources().getColor(R.color.filter_list_color);
            }
            linearLayout.setBackgroundColor(i4);
            View view = this.mItemViewDataBinding.selectedView;
            if (!cJRFilterItem.isToggleChecked()) {
                i5 = 8;
            }
            view.setVisibility(i5);
            CLPRobotoTextView cLPRobotoTextView = this.mItemViewDataBinding.filterTextView;
            if (cJRFilterItem.isToggleChecked()) {
                i3 = this.mItemViewDataBinding.getRoot().getContext().getResources().getColor(R.color.clp_color_2222222);
            } else {
                i3 = this.mItemViewDataBinding.getRoot().getContext().getResources().getColor(R.color.filter_text_color);
            }
            cLPRobotoTextView.setTextColor(i3);
            this.mItemViewDataBinding.filterTextView.setTypeface(this.mItemViewDataBinding.filterTextView.getTypeface(), 1);
        }

        public void onCLick(int i2) {
            if (!(i2 == FilterRecyclerViewAdapter.this.mSelected)) {
                int unused = FilterRecyclerViewAdapter.this.mSelected = i2;
                FilterWidgetUtils.filterToggle(i2, FilterRecyclerViewAdapter.this.mFilterList);
                FilterRecyclerViewAdapter filterRecyclerViewAdapter = FilterRecyclerViewAdapter.this;
                filterRecyclerViewAdapter.notifyItemRangeChanged(0, filterRecyclerViewAdapter.mFilterList.size());
                if (FilterRecyclerViewAdapter.this.mFilterClickListener != null) {
                    FilterRecyclerViewAdapter.this.mFilterClickListener.onFilterItemClick(i2, (CJRFilterItem) FilterRecyclerViewAdapter.this.mFilterList.get(i2), this.mFragment, false);
                }
            }
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        int i2;
        if (this.mSelected != -1 && this.mFilterList.size() > (i2 = this.mSelected)) {
            this.mFilterClickListener.onFilterItemClick(i2, this.mFilterList.get(i2), this.mFilterDetailFragment.get(this.mSelected), true);
        }
        super.onAttachedToRecyclerView(recyclerView);
    }

    public int getSelectedPosition() {
        return this.mSelected;
    }
}

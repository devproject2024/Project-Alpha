package com.paytmmall.clpartifact.view.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSortfilterDetailBinding;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.utils.GaHandler;

public class CLPSortBottomSheetVH extends RecyclerView.v {
    private IGridResponseUpdateListener mGridResponseUpdateListener;
    private ItemSortfilterDetailBinding mViewDataBinding;

    public CLPSortBottomSheetVH(IGridResponseUpdateListener iGridResponseUpdateListener, ItemSortfilterDetailBinding itemSortfilterDetailBinding) {
        super(itemSortfilterDetailBinding.getRoot());
        this.mGridResponseUpdateListener = iGridResponseUpdateListener;
        this.mViewDataBinding = itemSortfilterDetailBinding;
    }

    public void bind(CJRSortingKeys cJRSortingKeys) {
        if (cJRSortingKeys.isSelected()) {
            this.mViewDataBinding.sortFilterName.setTextColor(this.mViewDataBinding.getRoot().getResources().getColor(R.color.primaryBlue));
        }
        this.mViewDataBinding.setVariable(BR.item, cJRSortingKeys);
        this.mViewDataBinding.setVariable(BR.handler, this);
        this.mViewDataBinding.executePendingBindings();
    }

    public void handleSortItemClick(CJRSortingKeys cJRSortingKeys) {
        GaHandler.getInstance().fireSortFilterAppliedEvent(cJRSortingKeys.getName());
        this.mGridResponseUpdateListener.onSortingSelected(cJRSortingKeys);
    }
}

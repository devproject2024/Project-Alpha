package com.paytmmall.clpartifact.view.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.HsVariantBottomSheetListItemBinding;
import com.paytmmall.clpartifact.listeners.HSVariantBottomSheetRVAdapterListener;

public class HSVariantBottomSheetRVAdapterViewHolder extends RecyclerView.v {
    HsVariantBottomSheetListItemBinding mBinder;
    private HSVariantBottomSheetRVAdapterListener mListener;

    public HSVariantBottomSheetRVAdapterViewHolder(HsVariantBottomSheetListItemBinding hsVariantBottomSheetListItemBinding, HSVariantBottomSheetRVAdapterListener hSVariantBottomSheetRVAdapterListener) {
        super(hsVariantBottomSheetListItemBinding.getRoot());
        this.mBinder = hsVariantBottomSheetListItemBinding;
        this.mListener = hSVariantBottomSheetRVAdapterListener;
        this.mBinder.actualPrice.setPaintFlags(this.mBinder.actualPrice.getPaintFlags() | 16);
    }

    public void bind() {
        this.mBinder.setVariable(BR.item, this.mListener.getProducts().get(getAdapterPosition()));
        this.mBinder.setVariable(BR.holder, this);
        this.mBinder.executePendingBindings();
    }

    public void onProductClick() {
        this.mListener.onProductClick(getAdapterPosition());
    }

    public String getVariantLabel() {
        return this.mListener.getVariantLabel();
    }
}

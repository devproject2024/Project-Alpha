package com.paytmmall.clpartifact.view.viewHolder;

import com.paytmmall.clpartifact.databinding.ClpFreeDealsItemBinding;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class FreeDealsItemViewHolder extends CLPInfiniteGridHolder {
    private ClpFreeDealsItemBinding mBinder;

    public FreeDealsItemViewHolder(ClpFreeDealsItemBinding clpFreeDealsItemBinding, InfiniteGridRVAdapterListener infiniteGridRVAdapterListener, CustomAction customAction) {
        super(clpFreeDealsItemBinding, infiniteGridRVAdapterListener, customAction);
        this.mBinder = clpFreeDealsItemBinding;
    }

    public void bind(CJRGridProduct cJRGridProduct, int i2, boolean z) {
        cJRGridProduct.setGaData(getGAData());
        GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, i2);
        this.mBinder.setProduct(cJRGridProduct);
        this.mBinder.setHolder(this);
        this.mBinder.executePendingBindings();
    }
}

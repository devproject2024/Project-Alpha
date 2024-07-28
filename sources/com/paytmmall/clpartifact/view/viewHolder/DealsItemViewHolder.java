package com.paytmmall.clpartifact.view.viewHolder;

import com.paytmmall.clpartifact.databinding.DealsItemClpBinding;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class DealsItemViewHolder extends CLPInfiniteGridHolder {
    private DealsItemClpBinding mBinder;

    public DealsItemViewHolder(DealsItemClpBinding dealsItemClpBinding, InfiniteGridRVAdapterListener infiniteGridRVAdapterListener, CustomAction customAction) {
        super(dealsItemClpBinding, infiniteGridRVAdapterListener, customAction);
        this.mBinder = dealsItemClpBinding;
    }

    public void bind(CJRGridProduct cJRGridProduct, int i2, boolean z) {
        cJRGridProduct.setGaData(getGAData());
        GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, i2);
        this.mBinder.setProduct(cJRGridProduct);
        this.mBinder.setHolder(this);
        this.mBinder.executePendingBindings();
    }
}

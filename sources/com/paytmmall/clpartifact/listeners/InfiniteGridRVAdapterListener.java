package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;

public interface InfiniteGridRVAdapterListener {
    void fireGridProductImpression(CJRGridProduct cJRGridProduct, int i2);

    String getViewType();

    void onVariantClick(CJRGridProduct cJRGridProduct);

    boolean shouldShowProductPrice();

    boolean showAddToCart();
}

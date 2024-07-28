package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import java.util.ArrayList;

public interface HSVariantBottomSheetRVAdapterListener {
    ArrayList<CJRGridProduct> getProducts();

    String getVariantLabel();

    void onProductClick(int i2);
}

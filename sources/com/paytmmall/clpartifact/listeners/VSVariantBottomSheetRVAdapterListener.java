package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import java.util.ArrayList;

public interface VSVariantBottomSheetRVAdapterListener extends ICartClickListener {
    ArrayList<CJRGridProduct> getProducts();

    boolean isItemInStock();
}

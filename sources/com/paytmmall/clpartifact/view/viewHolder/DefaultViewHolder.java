package com.paytmmall.clpartifact.view.viewHolder;

import com.paytmmall.clpartifact.databinding.ItemDefaultBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class DefaultViewHolder extends CLPItemRVViewHolder {
    private ItemDefaultBinding mDefaultBinding;

    public DefaultViewHolder(ItemDefaultBinding itemDefaultBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemDefaultBinding, iGAHandlerListener, customAction);
        this.mDefaultBinding = itemDefaultBinding;
    }

    public void bindItem(Item item, int i2) {
        this.mDefaultBinding.setDefaultItemData(item);
        this.mDefaultBinding.executePendingBindings();
    }
}

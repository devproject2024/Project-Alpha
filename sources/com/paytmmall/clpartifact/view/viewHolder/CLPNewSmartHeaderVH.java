package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.library.baseAdapters.a;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemNewSmartHeaderDynBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import kotlin.g.b.k;

public final class CLPNewSmartHeaderVH extends ClickableRVChildViewHolder {
    private final CustomAction customAction;
    private ItemNewSmartHeaderDynBinding viewBinding;

    public CLPNewSmartHeaderVH(ItemNewSmartHeaderDynBinding itemNewSmartHeaderDynBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemNewSmartHeaderDynBinding, iGAHandlerListener, customAction2);
        this.viewBinding = itemNewSmartHeaderDynBinding;
        this.customAction = customAction2;
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public final ItemNewSmartHeaderDynBinding getViewBinding() {
        return this.viewBinding;
    }

    public final void setViewBinding(ItemNewSmartHeaderDynBinding itemNewSmartHeaderDynBinding) {
        this.viewBinding = itemNewSmartHeaderDynBinding;
    }

    public final void bindItem(Item item, View view) {
        k.c(item, "item");
        setGAData(view != null ? view.getGaData() : null);
        handleGAImpression(item, getAdapterPosition());
        enableItemClick();
        ItemNewSmartHeaderDynBinding itemNewSmartHeaderDynBinding = this.viewBinding;
        if (itemNewSmartHeaderDynBinding != null) {
            itemNewSmartHeaderDynBinding.setVariable(BR.item, item);
        }
        ItemNewSmartHeaderDynBinding itemNewSmartHeaderDynBinding2 = this.viewBinding;
        if (itemNewSmartHeaderDynBinding2 != null) {
            itemNewSmartHeaderDynBinding2.setVariable(a.f3275a, Integer.valueOf(getAdapterPosition()));
        }
        ItemNewSmartHeaderDynBinding itemNewSmartHeaderDynBinding3 = this.viewBinding;
        if (itemNewSmartHeaderDynBinding3 != null) {
            itemNewSmartHeaderDynBinding3.executePendingBindings();
        }
    }
}

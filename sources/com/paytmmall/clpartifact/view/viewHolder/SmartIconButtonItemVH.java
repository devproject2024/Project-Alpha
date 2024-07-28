package com.paytmmall.clpartifact.view.viewHolder;

import android.widget.TextView;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButtonBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import kotlin.g.b.k;

public final class SmartIconButtonItemVH extends CLPItemRVViewHolder {
    private final int MULTI_SPAN_MAX_WIDTH = 750;
    private final int SINGLE_SPAN_MAX_WIDTH = 250;
    private final ItemSmartIconButtonBinding viewBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartIconButtonItemVH(ItemSmartIconButtonBinding itemSmartIconButtonBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemSmartIconButtonBinding, iGAHandlerListener, customAction);
        k.c(itemSmartIconButtonBinding, "viewBinding");
        this.viewBinding = itemSmartIconButtonBinding;
    }

    public final ItemSmartIconButtonBinding getViewBinding() {
        return this.viewBinding;
    }

    public final int getSINGLE_SPAN_MAX_WIDTH() {
        return this.SINGLE_SPAN_MAX_WIDTH;
    }

    public final int getMULTI_SPAN_MAX_WIDTH() {
        return this.MULTI_SPAN_MAX_WIDTH;
    }

    public final void bindItem(Item item, int i2) {
        int i3;
        k.c(item, "data");
        if (item.getSpanCount() == 2) {
            String name = item.getName();
            if ((name != null ? name.length() : 0) > 20) {
                i3 = this.SINGLE_SPAN_MAX_WIDTH;
                TextView textView = this.viewBinding.buttonText;
                k.a((Object) textView, "viewBinding.buttonText");
                textView.setMaxWidth(i3);
                super.bindItem(item, i2);
            }
        }
        i3 = this.MULTI_SPAN_MAX_WIDTH;
        TextView textView2 = this.viewBinding.buttonText;
        k.a((Object) textView2, "viewBinding.buttonText");
        textView2.setMaxWidth(i3);
        super.bindItem(item, i2);
    }
}

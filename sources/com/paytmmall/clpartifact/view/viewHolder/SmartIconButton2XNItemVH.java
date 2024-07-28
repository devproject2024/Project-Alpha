package com.paytmmall.clpartifact.view.viewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import kotlin.g.b.k;

public final class SmartIconButton2XNItemVH extends CLPItemRVViewHolder {
    private final ConstraintLayout.LayoutParams MULTI_SPAN_MAX_WIDTH = new ConstraintLayout.LayoutParams(-1, -2);
    private final ConstraintLayout.LayoutParams SINGLE_SPAN_MAX_WIDTH = new ConstraintLayout.LayoutParams(-1, -2);
    private final ItemSmartIconButton2xnBinding viewBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartIconButton2XNItemVH(ItemSmartIconButton2xnBinding itemSmartIconButton2xnBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemSmartIconButton2xnBinding, iGAHandlerListener, customAction);
        k.c(itemSmartIconButton2xnBinding, "viewBinding");
        this.viewBinding = itemSmartIconButton2xnBinding;
    }

    public final ItemSmartIconButton2xnBinding getViewBinding() {
        return this.viewBinding;
    }

    public final void bindItem(Item item, int i2) {
        ConstraintLayout.LayoutParams layoutParams;
        k.c(item, "data");
        if (item.getSpanCount() == 2) {
            String name = item.getName();
            if ((name != null ? name.length() : 0) > 20) {
                layoutParams = this.SINGLE_SPAN_MAX_WIDTH;
                ConstraintLayout constraintLayout = this.viewBinding.cashbackView2XN;
                k.a((Object) constraintLayout, "viewBinding.cashbackView2XN");
                constraintLayout.setLayoutParams(layoutParams);
                super.bindItem(item, i2);
            }
        }
        layoutParams = this.MULTI_SPAN_MAX_WIDTH;
        ConstraintLayout constraintLayout2 = this.viewBinding.cashbackView2XN;
        k.a((Object) constraintLayout2, "viewBinding.cashbackView2XN");
        constraintLayout2.setLayoutParams(layoutParams);
        super.bindItem(item, i2);
    }
}

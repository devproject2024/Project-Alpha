package com.paytmmall.clpartifact.widgets.component.viewholder;

import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavSingleBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class FabSingleItemVH extends FabBaseVH {
    private ItemFloatingNavSingleBinding mViewDataBinding;

    public FabSingleItemVH(ItemFloatingNavSingleBinding itemFloatingNavSingleBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemFloatingNavSingleBinding, iGAHandlerListener, customAction);
        this.mViewDataBinding = itemFloatingNavSingleBinding;
    }

    public void bindItem(Item item, View view) {
        setGAData(view.getGaData());
        handleGAImpression(item, getAdapterPosition());
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.mViewDataBinding.executePendingBindings();
    }

    public android.view.View getAnimationView() {
        return this.mViewDataBinding.groupImageView;
    }
}

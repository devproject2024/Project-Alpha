package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPRecoItemVH extends ClickableRVChildViewHolder {
    private ViewDataBinding mViewDataBinding;

    public CLPRecoItemVH(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding, iGAHandlerListener, customAction);
        this.mViewDataBinding = viewDataBinding;
    }

    public void bindItem(Item item, View view) {
        setGAData(view.getGaData());
        if (!item.isGaAdded()) {
            handleGAImpression(item, getAdapterPosition());
        }
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.mViewDataBinding.executePendingBindings();
    }
}

package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class SealTrustViewHodler extends CLPItemVHWithoutRV {
    private ViewDataBinding viewDataBinding;

    public SealTrustViewHodler(ViewDataBinding viewDataBinding2, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding2, iGAHandlerListener, customAction);
        this.viewDataBinding = viewDataBinding2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        handleGAImpression(view.getItems().get(0), 0);
        this.viewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
    }
}

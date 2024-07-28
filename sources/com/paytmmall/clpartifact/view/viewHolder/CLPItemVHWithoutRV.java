package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class CLPItemVHWithoutRV extends ClickableRVChildViewHolder {
    private ViewDataBinding mViewDataBinding;

    public CLPItemVHWithoutRV(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding, iGAHandlerListener, customAction);
        this.mViewDataBinding = viewDataBinding;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        if (ValidateViewResponse.validateData(view, this.mViewDataBinding)) {
            enableItemClick();
            handleStaticViewGAImpression(view);
            this.mViewDataBinding.setVariable(BR.view, view);
            this.mViewDataBinding.executePendingBindings();
        }
    }

    private void handleStaticViewGAImpression(View view) {
        int size;
        List<Item> items = view.getItems();
        if (items != null && (size = items.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                handleGAImpression(items.get(i2), i2);
            }
        }
    }
}

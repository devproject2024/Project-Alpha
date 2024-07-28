package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPMerchantBannerVHWithoutRV extends CLPItemVHWithoutRV {
    private CustomAction customAction;
    private ViewDataBinding mViewDataBinding;

    public CLPMerchantBannerVHWithoutRV(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mViewDataBinding = viewDataBinding;
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        this.mViewDataBinding.setVariable(BR.view, view);
        this.mViewDataBinding.setVariable(BR.clickHandler, this);
        this.mViewDataBinding.executePendingBindings();
    }

    public void handleBackPress(android.view.View view) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).finish();
        }
    }

    public void onSearchClick(android.view.View view, String str) {
        CustomAction customAction2;
        FragmentActivity fragmentActivity = view.getContext() instanceof FragmentActivity ? (FragmentActivity) view.getContext() : null;
        if (fragmentActivity != null && (customAction2 = this.customAction) != null && customAction2.getMallSdkVHListener() != null) {
            this.customAction.getMallSdkVHListener().openSearch(fragmentActivity, str, 1);
        }
    }
}

package com.paytmmall.clpartifact.widgets.component.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavMultiBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class FabMultiItemVH extends FabBaseVH {
    private ItemFloatingNavMultiBinding mViewDataBinding;

    public FabMultiItemVH(ItemFloatingNavMultiBinding itemFloatingNavMultiBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemFloatingNavMultiBinding, iGAHandlerListener, customAction);
        this.mViewDataBinding = itemFloatingNavMultiBinding;
    }

    public void bindItem(Item item, View view) {
        setGAData(view.getGaData());
        handleGAImpression(item, getAdapterPosition());
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.mViewDataBinding.executePendingBindings();
        if (TextUtils.isEmpty(item.getTitle())) {
            this.mViewDataBinding.categoryTitle.setVisibility(4);
            this.mViewDataBinding.categoryTitle.setHeight(0);
            ViewGroup.LayoutParams layoutParams = this.mViewDataBinding.groupImageView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a.a(20);
            }
        }
    }

    public android.view.View getAnimationView() {
        return this.mViewDataBinding.groupImageView;
    }
}

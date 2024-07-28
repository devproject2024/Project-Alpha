package com.paytmmall.clpartifact.widgets.component.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavMultiBinding;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavSingleBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabMultiItemVH;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabSingleItemVH;
import java.util.List;

public class FloatingNavigationAdapter extends RecyclerView.a<FabBaseVH> {
    private int itemSize = this.items.size();
    private List<Item> items;
    private IGAHandlerListener listener;
    private View mView;

    public FloatingNavigationAdapter(View view, IGAHandlerListener iGAHandlerListener, List<Item> list) {
        this.mView = view;
        this.items = list;
        this.listener = iGAHandlerListener;
    }

    public FabBaseVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (getType() == FabBaseVH.ITEM_TYPE_MULTI) {
            return new FabMultiItemVH((ItemFloatingNavMultiBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_floating_nav_multi), this.listener, (CustomAction) null);
        }
        return new FabSingleItemVH((ItemFloatingNavSingleBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_floating_nav_single), this.listener, (CustomAction) null);
    }

    private int getType() {
        return this.itemSize <= 1 ? FabBaseVH.ITEM_TYPE_SINGLE : FabBaseVH.ITEM_TYPE_MULTI;
    }

    public void onBindViewHolder(FabBaseVH fabBaseVH, int i2) {
        fabBaseVH.bindItem(this.items.get(i2), this.mView);
    }

    public int getItemCount() {
        return Math.min(this.itemSize, 5);
    }
}

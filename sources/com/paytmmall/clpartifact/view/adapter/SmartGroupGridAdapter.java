package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSmartGrpGridBinding;
import com.paytmmall.clpartifact.listeners.IClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH;
import com.paytmmall.clpartifact.view.viewbindings.SmartGridDiffCallback;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class SmartGroupGridAdapter extends RecyclerView.a<SmartGroupItemVH> {
    private CustomAction customAction;
    private IGAHandlerListener gaHandler;
    private IClickListener iClickListener;
    private List<Item> items;
    private View mView;

    public SmartGroupGridAdapter(List<Item> list, View view, IGAHandlerListener iGAHandlerListener, IClickListener iClickListener2, CustomAction customAction2) {
        this.items = list;
        this.gaHandler = iGAHandlerListener;
        this.iClickListener = iClickListener2;
        this.mView = view;
        this.customAction = customAction2;
    }

    public SmartGroupItemVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new SmartGroupItemVH((ItemSmartGrpGridBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_smart_grp_grid), this.gaHandler, this.iClickListener, this.customAction);
    }

    public void onBindViewHolder(SmartGroupItemVH smartGroupItemVH, int i2) {
        if (!(this.items.size() <= 0 || this.items.get(i2) == null || this.mView.getGaData() == null)) {
            this.items.get(i2).setGaData(this.mView.getGaData());
        }
        smartGroupItemVH.bindItem(this.items.get(i2), this.mView);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void setItems(List<Item> list) {
        h.b a2 = h.a(new SmartGridDiffCallback(this.items, list));
        this.items.clear();
        this.items.addAll(list);
        a2.a((RecyclerView.a) this);
    }
}

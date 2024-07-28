package com.paytmmall.clpartifact.view.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemCarousel13Binding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem_1_3;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class HomeCarousel_1_3Adapter extends RecyclerView.a<CLPCarouselItem_1_3> {
    private CustomAction customAction;
    private IGAHandlerListener gaHandler;
    private List<Item> items;
    private View mView;

    public HomeCarousel_1_3Adapter(List<Item> list, View view, IGAHandlerListener iGAHandlerListener, Context context, CustomAction customAction2) {
        this.items = list;
        this.gaHandler = iGAHandlerListener;
        this.mView = view;
        this.customAction = customAction2;
    }

    public CLPCarouselItem_1_3 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPCarouselItem_1_3((ItemCarousel13Binding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_carousel_1_3), this.gaHandler, this.customAction);
    }

    public void onBindViewHolder(CLPCarouselItem_1_3 cLPCarouselItem_1_3, int i2) {
        setGaData(i2 % this.items.size());
        cLPCarouselItem_1_3.setMaxItemCount(getItemCount());
        List<Item> list = this.items;
        cLPCarouselItem_1_3.bindItem(list.get(i2 % list.size()), this.mView);
    }

    private void setGaData(int i2) {
        if (this.items.size() > 0 && this.items.get(i2) != null && this.mView.getGaData() != null) {
            this.items.get(i2).setGaData(this.mView.getGaData());
        }
    }

    public int getItemCount() {
        List<Item> list = this.items;
        return (list == null || list.isEmpty()) ? 0 : Integer.MAX_VALUE;
    }

    public void setItem(List<Item> list) {
        if (list.size() <= 0) {
            list = this.items;
        }
        this.items = list;
        notifyItemChanged(0, this.items);
    }
}

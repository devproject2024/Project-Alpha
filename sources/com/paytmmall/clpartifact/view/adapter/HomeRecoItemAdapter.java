package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class HomeRecoItemAdapter extends RecyclerView.a<CLPRecoItemVH> {
    private CustomAction customAction;
    private IGAHandlerListener gaHandler;
    private List<Item> items;
    private View mView;

    public HomeRecoItemAdapter(List<Item> list, View view, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        this.items = list;
        this.gaHandler = iGAHandlerListener;
        this.mView = view;
        this.customAction = customAction2;
    }

    public CLPRecoItemVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (isLargeReco()) {
            return new CLPRecoItemVH(DataBindingUtils.getViewBinding(viewGroup, R.layout.item_recommendation_banner_large_image), this.gaHandler, this.customAction);
        }
        return new CLPRecoItemVH(DataBindingUtils.getViewBinding(viewGroup, R.layout.item_recommendation_banner), this.gaHandler, this.customAction);
    }

    private boolean isLargeReco() {
        View view = this.mView;
        return view != null && ViewHolderFactory.CLASS_LARGE_ICON.equals(view.getClassName());
    }

    public void onBindViewHolder(CLPRecoItemVH cLPRecoItemVH, int i2) {
        setGaData(i2);
        cLPRecoItemVH.bindItem(this.items.get(i2), this.mView);
    }

    private void setGaData(int i2) {
        if (this.items.size() > 0 && this.items.get(i2) != null && this.mView.getGaData() != null) {
            this.items.get(i2).setGaData(this.mView.getGaData());
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void setItem(List<Item> list) {
        if (list.size() <= 0) {
            list = this.items;
        }
        this.items = list;
        notifyItemChanged(0, this.items);
    }
}

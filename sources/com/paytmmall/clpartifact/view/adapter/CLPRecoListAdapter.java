package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class CLPRecoListAdapter extends RecyclerView.a<CLPRecoItemVH> {
    private CustomAction customAction;
    private IGAHandlerListener gaHandler;
    private List<Item> items;
    private View mView;

    public CLPRecoListAdapter(List<Item> list, IGAHandlerListener iGAHandlerListener, View view, CustomAction customAction2) {
        this.items = list;
        this.gaHandler = iGAHandlerListener;
        this.mView = view;
        this.customAction = customAction2;
    }

    public CLPRecoItemVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPRecoItemVH(DataBindingUtils.getViewBinding(viewGroup, R.layout.item_reco_collapsed), this.gaHandler, this.customAction);
    }

    public void onBindViewHolder(CLPRecoItemVH cLPRecoItemVH, int i2) {
        if (!(this.items.size() <= 0 || this.items.get(i2) == null || this.mView.getGaData() == null)) {
            this.items.get(i2).setGaData(this.mView.getGaData());
        }
        cLPRecoItemVH.bindItem(this.items.get(i2), this.mView);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setItem(List<Item> list) {
        if (list.size() <= 0) {
            list = this.items;
        }
        this.items = list;
        notifyItemChanged(0, this.items);
    }
}

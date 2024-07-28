package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class CartItemRVAdapter extends CLPItemRVAdapter {
    private List<Item> mCartItemList;
    private String mType;

    public CartItemRVAdapter(View view, List<Item> list, IGAHandlerListener iGAHandlerListener, Long l, CustomAction customAction) {
        super(view, list, iGAHandlerListener, l, customAction);
        this.mCartItemList = list;
        this.mType = view.getType();
    }

    public CLPItemRVViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return super.onCreateViewHolder(viewGroup, ViewHolderFactory.parseViewType(this.mType));
    }

    public void onBindViewHolder(CLPItemRVViewHolder cLPItemRVViewHolder, int i2) {
        if (cLPItemRVViewHolder instanceof CLPBaseViewHolder) {
            cLPItemRVViewHolder.setGAData(this.mGAData);
        }
        cLPItemRVViewHolder.bindItem(this.mCartItemList.get(i2), i2);
    }

    public int getItemCount() {
        List<Item> list = this.mCartItemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

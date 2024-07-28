package com.paytmmall.clpartifact.view.adapter;

import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class BannerItemRVAdapter extends CLPItemRVAdapter {
    private int adapterPosition = -1;
    private final IGAHandlerListener listener;

    public BannerItemRVAdapter(View view, List<Item> list, IGAHandlerListener iGAHandlerListener, Long l, CustomAction customAction) {
        super(view, list, iGAHandlerListener, l, customAction);
        this.listener = iGAHandlerListener;
    }

    public int getItemCount() {
        if (CLPUtils.isHomeClient(this.listener)) {
            return Integer.MAX_VALUE;
        }
        return super.getItemCount();
    }

    public int getActualCount() {
        return super.getItemCount();
    }

    public void onBindViewHolder(CLPItemRVViewHolder cLPItemRVViewHolder, int i2) {
        super.onBindViewHolder(cLPItemRVViewHolder, i2 % getActualCount());
        this.adapterPosition = cLPItemRVViewHolder.getAdapterPosition();
        LogUtils.d("BannerRV", String.valueOf(this.adapterPosition));
    }

    public int getAdapterPosition() {
        LogUtils.d("BannerRV", "fetching adapter pos" + this.adapterPosition);
        return this.adapterPosition;
    }
}

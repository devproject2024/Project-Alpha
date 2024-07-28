package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemNewSmartHeaderDynBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.viewHolder.CLPNewSmartHeaderVH;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import kotlin.g.b.k;

public final class CLPNewSmartHeaderRVAdapter extends RecyclerView.a<CLPNewSmartHeaderVH> {
    private final CustomAction customAction;
    private IGAHandlerListener igaHandlerListener;
    private List<? extends Item> items;
    private View view;

    public CLPNewSmartHeaderRVAdapter(View view2, List<? extends Item> list, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        k.c(list, "items");
        k.c(iGAHandlerListener, "igaHandlerListener");
        this.view = view2;
        this.items = list;
        this.igaHandlerListener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public final IGAHandlerListener getIgaHandlerListener() {
        return this.igaHandlerListener;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final View getView() {
        return this.view;
    }

    public final void setIgaHandlerListener(IGAHandlerListener iGAHandlerListener) {
        k.c(iGAHandlerListener, "<set-?>");
        this.igaHandlerListener = iGAHandlerListener;
    }

    public final void setItems(List<? extends Item> list) {
        k.c(list, "<set-?>");
        this.items = list;
    }

    public final void setView(View view2) {
        this.view = view2;
    }

    public final CLPNewSmartHeaderVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new CLPNewSmartHeaderVH((ItemNewSmartHeaderDynBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_new_smart_header_dyn), this.igaHandlerListener, this.customAction);
    }

    public final int getItemCount() {
        return this.items.size();
    }

    public final void onBindViewHolder(CLPNewSmartHeaderVH cLPNewSmartHeaderVH, int i2) {
        k.c(cLPNewSmartHeaderVH, "holder");
        cLPNewSmartHeaderVH.bindItem((Item) this.items.get(i2), this.view);
    }
}

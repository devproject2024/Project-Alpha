package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.CLPHybridRVAdapter;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import kotlin.g.b.k;

public final class CLPCraousalBS1LowDimensionImageListViewHolder extends CLPItemVHWithRV {
    private final CustomAction customAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CLPCraousalBS1LowDimensionImageListViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        k.c(viewDataBinding, "thinBannerBinding");
        this.customAction = customAction2;
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    /* access modifiers changed from: protected */
    public final CLPItemRVAdapter getAdapter(View view) {
        k.c(view, "view");
        view.setGaData(getGAData());
        Long id = view.getId();
        k.a((Object) id, "view.id");
        return new CLPHybridRVAdapter(view, view.getItems(), getIgaHandlerListener(), new CLPCraousalBS1LowDimensionImageListViewHolder$getAdapter$1(), id.longValue(), this.customAction);
    }
}

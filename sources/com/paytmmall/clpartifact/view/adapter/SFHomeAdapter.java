package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SFHomeAdapter extends RecyclerView.a<CLPBaseViewHolder> {
    private CustomAction customAction;
    private IGAHandlerListener gaListener;
    private List<? extends View> list;

    public SFHomeAdapter() {
        this((IGAHandlerListener) null, (CustomAction) null, 3, (g) null);
    }

    public SFHomeAdapter(IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        this.gaListener = iGAHandlerListener;
        this.customAction = customAction2;
        this.list = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SFHomeAdapter(IGAHandlerListener iGAHandlerListener, CustomAction customAction2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : iGAHandlerListener, (i2 & 2) != 0 ? null : customAction2);
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public final IGAHandlerListener getGaListener() {
        return this.gaListener;
    }

    public final void setCustomAction(CustomAction customAction2) {
        this.customAction = customAction2;
    }

    public final void setGaListener(IGAHandlerListener iGAHandlerListener) {
        this.gaListener = iGAHandlerListener;
    }

    public final CLPBaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        HomeUtils.d$default("SFHomeAdapter onCreateViewHolder started", false, 2, (Object) null);
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.gaListener, this.customAction);
        HomeUtils.d$default("SFHomeAdapter onCreateViewHolder finished", false, 2, (Object) null);
        k.a((Object) viewHolder, "holder");
        return viewHolder;
    }

    public final int getItemCount() {
        return this.list.size();
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName((View) this.list.get(i2));
    }

    public final void onBindViewHolder(CLPBaseViewHolder cLPBaseViewHolder, int i2) {
        k.c(cLPBaseViewHolder, "holder");
        HomeUtils.d$default("SFHomeAdapter onBindViewHolder called for position ".concat(String.valueOf(i2)), false, 2, (Object) null);
        View view = (View) this.list.get(i2);
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
        view.setGaData(hashMap);
        cLPBaseViewHolder.bind(view, (CLPBaseViewHolder.IParentListProvider) null);
        HomeUtils.d$default("SFHomeAdapter onBindViewHolder finoshed for position ".concat(String.valueOf(i2)), false, 2, (Object) null);
    }

    public final void updateAdapter(List<? extends View> list2) {
        if (list2 == null) {
            list2 = this.list;
        }
        this.list = list2;
        notifyDataSetChanged();
    }

    public final void onViewAttachedToWindow(CLPBaseViewHolder cLPBaseViewHolder) {
        k.c(cLPBaseViewHolder, "holder");
        RecyclerView.v vVar = cLPBaseViewHolder;
        super.onViewAttachedToWindow(vVar);
        cLPBaseViewHolder.onViewAttachedToWindow(cLPBaseViewHolder, getView(vVar));
    }

    public final void onViewDetachedFromWindow(CLPBaseViewHolder cLPBaseViewHolder) {
        k.c(cLPBaseViewHolder, "holder");
        RecyclerView.v vVar = cLPBaseViewHolder;
        super.onViewDetachedFromWindow(vVar);
        cLPBaseViewHolder.onViewDetachedFromWindow(cLPBaseViewHolder, getView(vVar));
    }

    public final View getView(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        return (View) kotlin.a.k.a(this.list, vVar.getAdapterPosition());
    }
}

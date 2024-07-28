package com.paytmmall.clpartifact.view.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class SFCategoryItemAdapter extends RecyclerView.a<RecyclerView.v> {
    private Context context;
    private IGAHandlerListener gaListener;
    private ArrayList<View> itemList = new ArrayList<>();
    private RecyclerView parentRV;

    public SFCategoryItemAdapter(Context context2, IGAHandlerListener iGAHandlerListener) {
        k.c(context2, "context");
        this.context = context2;
        this.gaListener = iGAHandlerListener;
    }

    public final IGAHandlerListener getGaListener() {
        return this.gaListener;
    }

    public final void setGaListener(IGAHandlerListener iGAHandlerListener) {
        this.gaListener = iGAHandlerListener;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.gaListener);
        k.a((Object) viewHolder, "ViewHolderFactory.getVie…Type)), null, gaListener)");
        return viewHolder;
    }

    public final int getItemCount() {
        return this.itemList.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        ArrayList<View> arrayList = this.itemList;
        if (i2 < arrayList.size() && (vVar instanceof CLPBaseViewHolder)) {
            View view = arrayList.get(i2);
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
            view.setGaData(hashMap);
            ((CLPBaseViewHolder) vVar).bind(view, (CLPBaseViewHolder.IParentListProvider) null);
        }
    }

    public final int getItemViewType(int i2) {
        WidgetLayoutType.Companion companion = WidgetLayoutType.Companion;
        View view = this.itemList.get(i2);
        k.a((Object) view, "itemList[position]");
        return companion.getLayoutTypeIndexfromName(view);
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.parentRV = recyclerView;
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.parentRV = null;
    }

    public final void updateList(ArrayList<View> arrayList) {
        k.c(arrayList, "items");
        this.itemList.clear();
        this.itemList.addAll(arrayList);
        notifyDataSetChanged();
        RecyclerView recyclerView = this.parentRV;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    public static final class CategoryDiffCallback extends h.a {
        private final List<View> newList;
        private final List<View> oldList;

        public CategoryDiffCallback(List<? extends View> list, List<? extends View> list2) {
            k.c(list, "oldList");
            k.c(list2, "newList");
            this.oldList = list;
            this.newList = list2;
        }

        public final int getOldListSize() {
            return this.oldList.size();
        }

        public final int getNewListSize() {
            return this.newList.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            if (this.oldList.size() > i2 && this.newList.size() > i3) {
                Long id = this.oldList.get(i2).getId();
                if (id != null ? id.equals(this.newList.get(i3).getId()) : false) {
                    return true;
                }
            }
            return false;
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            if (this.oldList.size() > i2 && this.newList.size() > i3) {
                List<Item> list = this.oldList.get(i2).mItems;
                if (list != null ? list.equals(this.newList.get(i3).mItems) : false) {
                    return true;
                }
            }
            return false;
        }
    }
}

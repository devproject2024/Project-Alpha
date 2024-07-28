package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.LayoutCategoryListItemBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class SmartIconListAdapter extends RecyclerView.a<SmartIconViewHolder> {
    private final Context context;
    private final ArrayList<Item> itemList;
    /* access modifiers changed from: private */
    public final SmartIconListFragment.ItemListListner itemListListner;

    public SmartIconListAdapter(Context context2, ArrayList<Item> arrayList, SmartIconListFragment.ItemListListner itemListListner2) {
        this.context = context2;
        this.itemList = arrayList;
        this.itemListListner = itemListListner2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<Item> getItemList() {
        return this.itemList;
    }

    public final SmartIconViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutCategoryListItemBinding layoutCategoryListItemBinding = (LayoutCategoryListItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_category_list_item, viewGroup, false);
        Context context2 = viewGroup.getContext();
        k.a((Object) context2, "parent.context");
        k.a((Object) layoutCategoryListItemBinding, "dataBinding");
        View root = layoutCategoryListItemBinding.getRoot();
        k.a((Object) root, "dataBinding.root");
        root.setLayoutParams(new RecyclerView.LayoutParams(-1, (int) context2.getResources().getDimension(R.dimen.dimen_120dp)));
        return new SmartIconViewHolder(this, layoutCategoryListItemBinding);
    }

    public final int getItemCount() {
        ArrayList<Item> arrayList = this.itemList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void onBindViewHolder(SmartIconViewHolder smartIconViewHolder, int i2) {
        k.c(smartIconViewHolder, "holder");
        ArrayList<Item> arrayList = this.itemList;
        if (arrayList != null) {
            View view = smartIconViewHolder.itemView;
            Item item = arrayList.get(i2);
            k.a((Object) item, "get(position)");
            Item.LayoutData layout = item.getLayout();
            String str = layout != null ? layout.mLabel : null;
            Item item2 = arrayList.get(i2);
            k.a((Object) item2, "get(position)");
            String name = item2.getName();
            Item item3 = arrayList.get(i2);
            k.a((Object) item3, "get(position)");
            smartIconViewHolder.getDataBinding().setImageUrl(item3.getImageUrl());
            smartIconViewHolder.getDataBinding().setLabel(str);
            smartIconViewHolder.getDataBinding().setName(name);
            smartIconViewHolder.getDataBinding().executePendingBindings();
            view.setOnClickListener(new SmartIconListAdapter$onBindViewHolder$$inlined$apply$lambda$1(arrayList, this, smartIconViewHolder, i2));
        }
    }

    public final class SmartIconViewHolder extends RecyclerView.v {
        private LayoutCategoryListItemBinding dataBinding;
        final /* synthetic */ SmartIconListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SmartIconViewHolder(SmartIconListAdapter smartIconListAdapter, LayoutCategoryListItemBinding layoutCategoryListItemBinding) {
            super(layoutCategoryListItemBinding.getRoot());
            k.c(layoutCategoryListItemBinding, "dataBinding");
            this.this$0 = smartIconListAdapter;
            this.dataBinding = layoutCategoryListItemBinding;
        }

        public final LayoutCategoryListItemBinding getDataBinding() {
            return this.dataBinding;
        }

        public final void setDataBinding(LayoutCategoryListItemBinding layoutCategoryListItemBinding) {
            k.c(layoutCategoryListItemBinding, "<set-?>");
            this.dataBinding = layoutCategoryListItemBinding;
        }
    }
}

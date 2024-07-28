package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.view.View;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListAdapter;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment;
import java.util.ArrayList;
import kotlin.g.b.k;

final class SmartIconListAdapter$onBindViewHolder$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ SmartIconListAdapter.SmartIconViewHolder $holder$inlined;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ ArrayList $this_apply$inlined;
    final /* synthetic */ SmartIconListAdapter this$0;

    SmartIconListAdapter$onBindViewHolder$$inlined$apply$lambda$1(ArrayList arrayList, SmartIconListAdapter smartIconListAdapter, SmartIconListAdapter.SmartIconViewHolder smartIconViewHolder, int i2) {
        this.$this_apply$inlined = arrayList;
        this.this$0 = smartIconListAdapter;
        this.$holder$inlined = smartIconViewHolder;
        this.$position$inlined = i2;
    }

    public final void onClick(View view) {
        SmartIconListFragment.ItemListListner access$getItemListListner$p = this.this$0.itemListListner;
        if (access$getItemListListner$p != null) {
            int i2 = this.$position$inlined;
            Object obj = this.$this_apply$inlined.get(i2);
            k.a(obj, "get(position)");
            Item item = (Item) obj;
            ArrayList<Item> itemList = this.this$0.getItemList();
            access$getItemListListner$p.itemClick(i2, item, (itemList != null ? Integer.valueOf(itemList.size()) : null).intValue());
        }
    }
}

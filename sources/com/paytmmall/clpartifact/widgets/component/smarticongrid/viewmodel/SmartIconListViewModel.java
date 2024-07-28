package com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel;

import android.app.Application;
import androidx.lifecycle.a;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class SmartIconListViewModel extends a {
    private SmartIconListFragment.ItemListListner itemListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartIconListViewModel(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final SmartIconListFragment.ItemListListner getItemListener() {
        return this.itemListener;
    }

    public final void setItemListener(SmartIconListFragment.ItemListListner itemListListner) {
        this.itemListener = itemListListner;
    }

    public final ArrayList<Item> getItemList(int i2) {
        SmartIconListFragment.ItemListListner itemListListner = this.itemListener;
        if (itemListListner != null) {
            return itemListListner.getItemList(i2);
        }
        return null;
    }
}

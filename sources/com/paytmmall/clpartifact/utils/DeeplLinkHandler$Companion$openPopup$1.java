package com.paytmmall.clpartifact.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment;
import kotlin.g.b.k;

public final class DeeplLinkHandler$Companion$openPopup$1 implements SFSmartIconFragment.OnItemClickListner {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Item $item;

    public final void onTickerItemClick(int i2, Item item) {
        k.c(item, "item");
    }

    DeeplLinkHandler$Companion$openPopup$1(Item item, FragmentActivity fragmentActivity) {
        this.$item = item;
        this.$activity = fragmentActivity;
    }

    public final void onItemClick(int i2, Item item, int i3) {
        k.c(item, "childItem");
        item.setParentBindPosition(-1);
        item.setListType(this.$item.getParentType() + CLPConstants.DRAWER_POSTFIX);
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        CLPArtifact instance2 = CLPArtifact.getInstance();
        k.a((Object) instance2, "CLPArtifact.getInstance()");
        Context context = instance2.getContext();
        String str = "slot_" + (i2 + 1) + '_' + (item.getParentBindPosition() + 1) + '_' + i3 + ' ';
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        communicationListener.sendPromotionClickForSmartIconClick(context, item, "/", str, name, CLPConstants.SMART_ICON_GRID_4XN_DRAWER);
        CLPArtifact instance3 = CLPArtifact.getInstance();
        k.a((Object) instance3, "CLPArtifact.getInstance()");
        Item item2 = this.$item;
        instance3.getCommunicationListener().handleDeepLinkopenpop(this.$activity, item, item2, item2.getGaData());
        DeeplLinkHandler.Companion.addToRecents(this.$item);
    }
}

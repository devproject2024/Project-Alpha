package com.paytmmall.clpartifact.view.viewHolder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.RecoUtils;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.u;

public final class SmartIconHeaderV2RootVH$setRecoCollapseListener$1 extends BroadcastReceiver {
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    SmartIconHeaderV2RootVH$setRecoCollapseListener$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH) {
        this.this$0 = smartIconHeaderV2RootVH;
    }

    public final void onReceive(Context context, Intent intent) {
        View view = null;
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == 326224525 && action.equals(CLPConstants.RECO_LOCALBROADCAST)) {
            Serializable serializableExtra = intent.getSerializableExtra(CLPConstants.RECO_DATA);
            if (serializableExtra == null) {
                View access$getMView$p = this.this$0.mView;
                if (access$getMView$p != null) {
                    view = access$getMView$p.getmView();
                }
                serializableExtra = view;
            }
            View view2 = (View) serializableExtra;
            if (view2 != null) {
                this.this$0.recoView = view2;
                SmartIconHeaderV2RootVH smartIconHeaderV2RootVH = this.this$0;
                RecoUtils recoUtils = new RecoUtils();
                List<Item> list = view2.mItems;
                if (list != null) {
                    smartIconHeaderV2RootVH.filteredList = recoUtils.getFilteredItemList((ArrayList) list);
                    HomeReco4XAdapter access$getRecoRVAdapter$p = this.this$0.recoRVAdapter;
                    if (access$getRecoRVAdapter$p != null) {
                        access$getRecoRVAdapter$p.setItem(SmartIconHeaderV2RootVH.access$getFilteredList$p(this.this$0));
                    }
                    HomeReco4XAdapter access$getRecoRVAdapter$p2 = this.this$0.recoRVAdapter;
                    if (access$getRecoRVAdapter$p2 != null) {
                        access$getRecoRVAdapter$p2.notifyDataSetChanged();
                    }
                    this.this$0.closeCountText();
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> */");
            }
        }
    }
}

package com.paytmmall.clpartifact.view.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.ISnapPositionChangeListener;
import com.paytmmall.clpartifact.view.decoration.SnapToBlock;

public final class SmartIconHeaderV2RootVH$setSnapHelper$$inlined$let$lambda$1 implements ISnapPositionChangeListener {
    final /* synthetic */ RecyclerView $recyclerView$inlined;
    final /* synthetic */ SnapToBlock $snapToBlock$inlined;
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    SmartIconHeaderV2RootVH$setSnapHelper$$inlined$let$lambda$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH, SnapToBlock snapToBlock, RecyclerView recyclerView) {
        this.this$0 = smartIconHeaderV2RootVH;
        this.$snapToBlock$inlined = snapToBlock;
        this.$recyclerView$inlined = recyclerView;
    }

    public final void onSnapPositionChange(int i2) {
        SmartIconHeaderV2RootVH smartIconHeaderV2RootVH = this.this$0;
        smartIconHeaderV2RootVH.setGAImpression(smartIconHeaderV2RootVH.getItemForGa(i2), this.this$0.mView, i2, this.this$0.getGaListener());
    }
}

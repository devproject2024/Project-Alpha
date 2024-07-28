package com.paytmmall.clpartifact.view.viewHolder;

import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import kotlin.x;

public final class SmartIconHeaderV2RootVH$setGAImpression$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ IGAHandlerListener $gaListener$inlined;
    final /* synthetic */ Item $item$inlined;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    public SmartIconHeaderV2RootVH$setGAImpression$$inlined$Runnable$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH, View view, Item item, int i2, IGAHandlerListener iGAHandlerListener) {
        this.this$0 = smartIconHeaderV2RootVH;
        this.$view$inlined = view;
        this.$item$inlined = item;
        this.$position$inlined = i2;
        this.$gaListener$inlined = iGAHandlerListener;
    }

    public final void run() {
        synchronized (this.this$0) {
            this.this$0.handleGAImpression(this.$view$inlined, this.$item$inlined, this.$position$inlined, this.$gaListener$inlined);
            x xVar = x.f47997a;
        }
    }
}

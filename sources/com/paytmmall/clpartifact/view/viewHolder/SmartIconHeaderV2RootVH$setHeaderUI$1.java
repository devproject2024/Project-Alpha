package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import kotlin.g.b.k;

public final class SmartIconHeaderV2RootVH$setHeaderUI$1 extends LinearLayoutManager {
    final /* synthetic */ View $view;
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartIconHeaderV2RootVH$setHeaderUI$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH, View view, Context context, int i2, boolean z) {
        super(context, i2, z);
        this.this$0 = smartIconHeaderV2RootVH;
        this.$view = view;
    }

    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        k.c(layoutParams, "lp");
        layoutParams.width = getWidth() / (this.this$0.newItem(this.$view).size() > this.this$0.HEADER_ICON_MAX_SIZE ? this.this$0.HEADER_ICON_MAX_SIZE : this.this$0.newItem(this.$view).size());
        return true;
    }
}

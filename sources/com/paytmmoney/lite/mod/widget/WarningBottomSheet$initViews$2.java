package com.paytmmoney.lite.mod.widget;

import android.view.View;
import com.paytmmoney.lite.mod.widget.WarningBottomSheet;
import kotlin.g.b.k;

final class WarningBottomSheet$initViews$2 implements View.OnClickListener {
    final /* synthetic */ WarningBottomSheet this$0;

    WarningBottomSheet$initViews$2(WarningBottomSheet warningBottomSheet) {
        this.this$0 = warningBottomSheet;
    }

    public final void onClick(View view) {
        WarningBottomSheet.Listener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            k.a((Object) view, "it");
            access$getListener$p.okClick(Integer.valueOf(view.getId()));
        }
        this.this$0.dismiss();
    }
}

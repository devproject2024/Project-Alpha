package com.paytmmall.clpartifact.view.decoration;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import kotlin.g.b.k;
import kotlin.j.e;

public final class SnapToBlock$createScroller$1 extends p {
    final /* synthetic */ SnapToBlock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapToBlock$createScroller$1(SnapToBlock snapToBlock, Context context) {
        super(context);
        this.this$0 = snapToBlock;
    }

    public final void onTargetFound(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
        int[] iArr;
        k.c(view, "targetView");
        k.c(sVar, "state");
        k.c(aVar, "action");
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p == null) {
            k.a();
        }
        RecyclerView.LayoutManager layoutManager = access$getMRecyclerView$p.getLayoutManager();
        Integer num = null;
        if (layoutManager != null) {
            SnapToBlock snapToBlock = this.this$0;
            k.a((Object) layoutManager, "it1");
            iArr = snapToBlock.calculateDistanceToFinalSnap(layoutManager, view);
        } else {
            iArr = null;
        }
        Integer valueOf = iArr != null ? Integer.valueOf(iArr[0]) : null;
        Integer valueOf2 = iArr != null ? Integer.valueOf(iArr[1]) : null;
        if (valueOf != null) {
            Integer valueOf3 = valueOf2 != null ? Integer.valueOf(e.b(Integer.valueOf(Math.abs(valueOf.intValue())).intValue(), Math.abs(valueOf2.intValue()))) : null;
            if (valueOf3 != null) {
                num = Integer.valueOf(calculateTimeForDeceleration(valueOf3.intValue()));
            }
        }
        if (num != null && num.intValue() > 0 && valueOf2 != null) {
            aVar.a(valueOf.intValue(), valueOf2.intValue(), num.intValue(), SnapToBlock.sInterpolator);
        }
    }

    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        k.c(displayMetrics, "displayMetrics");
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}

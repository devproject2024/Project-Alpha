package com.paytmmall.clpartifact.view.fragment;

import android.view.ViewTreeObserver;
import kotlin.g.a.a;
import kotlin.g.b.l;

final class SFHomeFragment$scanButtonGlobalLayoutListener$2 extends l implements a<ViewTreeObserver.OnGlobalLayoutListener> {
    final /* synthetic */ SFHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFHomeFragment$scanButtonGlobalLayoutListener$2(SFHomeFragment sFHomeFragment) {
        super(0);
        this.this$0 = sFHomeFragment;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener invoke() {
        return new ViewTreeObserver.OnGlobalLayoutListener(this) {
            final /* synthetic */ SFHomeFragment$scanButtonGlobalLayoutListener$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onGlobalLayout() {
                this.this$0.this$0.setScanButtonGlobalLayoutListener();
            }
        };
    }
}

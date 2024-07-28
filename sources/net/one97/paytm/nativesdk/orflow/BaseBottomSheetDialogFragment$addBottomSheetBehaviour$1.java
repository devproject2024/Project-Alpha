package net.one97.paytm.nativesdk.orflow;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.g.b.k;

public final class BaseBottomSheetDialogFragment$addBottomSheetBehaviour$1 extends BottomSheetBehavior.a {
    final /* synthetic */ BaseBottomSheetDialogFragment this$0;

    public final void onSlide(View view, float f2) {
        k.c(view, "bottomSheet");
    }

    BaseBottomSheetDialogFragment$addBottomSheetBehaviour$1(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment) {
        this.this$0 = baseBottomSheetDialogFragment;
    }

    public final void onStateChanged(View view, int i2) {
        k.c(view, "bottomSheet");
        if (i2 == 5) {
            this.this$0.dismissAllowingStateLoss();
        }
    }
}

package net.one97.paytm.wallet.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;

/* renamed from: net.one97.paytm.wallet.c.-$$Lambda$d$aF0GeGxpU-_6DL4dBhtf2MdZ6eU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$d$aF0GeGxpU_6DL4dBhtf2MdZ6eU implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$d$aF0GeGxpU_6DL4dBhtf2MdZ6eU INSTANCE = new $$Lambda$d$aF0GeGxpU_6DL4dBhtf2MdZ6eU();

    private /* synthetic */ $$Lambda$d$aF0GeGxpU_6DL4dBhtf2MdZ6eU() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}

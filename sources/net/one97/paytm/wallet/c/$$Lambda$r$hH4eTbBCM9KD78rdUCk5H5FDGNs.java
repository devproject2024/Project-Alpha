package net.one97.paytm.wallet.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.wallet.R;

/* renamed from: net.one97.paytm.wallet.c.-$$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs INSTANCE = new $$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs();

    private /* synthetic */ $$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}

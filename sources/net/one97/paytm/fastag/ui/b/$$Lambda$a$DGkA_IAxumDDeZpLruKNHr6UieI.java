package net.one97.paytm.fastag.ui.b;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;

/* renamed from: net.one97.paytm.fastag.ui.b.-$$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI INSTANCE = new $$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI();

    private /* synthetic */ $$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}

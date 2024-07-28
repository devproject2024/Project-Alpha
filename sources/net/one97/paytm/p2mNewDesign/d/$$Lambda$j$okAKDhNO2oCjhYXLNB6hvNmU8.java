package net.one97.paytm.p2mNewDesign.d;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.wallet.R;

/* renamed from: net.one97.paytm.p2mNewDesign.d.-$$Lambda$j$o-kAKDhNO2oCj-hYXLNB6hvNmU8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$j$okAKDhNO2oCjhYXLNB6hvNmU8 implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$j$okAKDhNO2oCjhYXLNB6hvNmU8 INSTANCE = new $$Lambda$j$okAKDhNO2oCjhYXLNB6hvNmU8();

    private /* synthetic */ $$Lambda$j$okAKDhNO2oCjhYXLNB6hvNmU8() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}

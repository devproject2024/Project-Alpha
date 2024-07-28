package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import kotlin.g.b.k;
import kotlin.u;

final class AddMoneyFeeBottomSheet$onCreateDialog$1 implements DialogInterface.OnShowListener {
    public static final AddMoneyFeeBottomSheet$onCreateDialog$1 INSTANCE = new AddMoneyFeeBottomSheet$onCreateDialog$1();

    AddMoneyFeeBottomSheet$onCreateDialog$1() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
            if (frameLayout == null) {
                k.a();
            }
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
            from.setState(3);
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }
}

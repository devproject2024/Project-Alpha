package net.one97.paytm.wallet.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.wallet.R;

/* renamed from: net.one97.paytm.wallet.c.-$$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM INSTANCE = new $$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM();

    private /* synthetic */ $$Lambda$c$nLh58liPARyAPgZ9s3SOJczngxM() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}

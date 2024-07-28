package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class ActivateWalletCardView extends LinearLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivateWalletCardView(Context context) {
        super(context);
        k.c(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_activate_wallet_passbook_lyt, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        k.a((Object) inflate, "view");
        inflate.setLayoutParams(layoutParams);
        addView(inflate);
    }
}

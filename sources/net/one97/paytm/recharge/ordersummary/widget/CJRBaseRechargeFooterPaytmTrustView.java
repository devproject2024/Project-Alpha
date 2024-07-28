package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRBaseRechargeFooterPaytmTrustView extends ConstraintLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeFooterPaytmTrustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.content_base_recharge_footer_paytm_trust, this, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeFooterPaytmTrustView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }
}

package net.one97.paytm.recharge.dth.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;

public final class CJRDTHRechargeShimmerView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerFrameLayout f62755a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRDTHRechargeShimmerView(Context context) {
        super(context);
        k.c(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dth_recharge_shimmer_view, this, true);
        k.a((Object) inflate, "LayoutInflater.from(cont…shimmer_view, this, true)");
        this.f62755a = (ShimmerFrameLayout) inflate.findViewById(R.id.shimmer_lyt);
    }

    public final void a(boolean z) {
        if (z) {
            try {
                ShimmerFrameLayout shimmerFrameLayout = this.f62755a;
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.a();
                }
            } catch (Exception unused) {
            }
        } else {
            ShimmerFrameLayout shimmerFrameLayout2 = this.f62755a;
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.b();
            }
        }
    }
}

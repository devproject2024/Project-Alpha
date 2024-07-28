package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.ShimmerFrameLayout;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final View f53748a;

    /* renamed from: b  reason: collision with root package name */
    public final e f53749b;

    /* renamed from: c  reason: collision with root package name */
    public final e f53750c;

    /* renamed from: d  reason: collision with root package name */
    public final ShimmerFrameLayout f53751d;

    /* renamed from: e  reason: collision with root package name */
    private final ShimmerFrameLayout f53752e;

    private h(ShimmerFrameLayout shimmerFrameLayout, View view, e eVar, e eVar2, ShimmerFrameLayout shimmerFrameLayout2) {
        this.f53752e = shimmerFrameLayout;
        this.f53748a = view;
        this.f53749b = eVar;
        this.f53750c = eVar2;
        this.f53751d = shimmerFrameLayout2;
    }

    public final ShimmerFrameLayout a() {
        return this.f53752e;
    }

    public static h a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return a(layoutInflater.inflate(R.layout.dummy_self_accounts_view, viewGroup, false));
    }

    public static h a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.header_view);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.item_1);
            if (findViewById2 != null) {
                e a2 = e.a(findViewById2);
                View findViewById3 = view.findViewById(R.id.item_2);
                if (findViewById3 != null) {
                    e a3 = e.a(findViewById3);
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.self_shimmer_layout);
                    if (shimmerFrameLayout != null) {
                        return new h((ShimmerFrameLayout) view, findViewById, a2, a3, shimmerFrameLayout);
                    }
                    str = "selfShimmerLayout";
                } else {
                    str = "item2";
                }
            } else {
                str = "item1";
            }
        } else {
            str = "headerView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}

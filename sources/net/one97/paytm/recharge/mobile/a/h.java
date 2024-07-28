package net.one97.paytm.recharge.mobile.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;

public final class h extends j {
    /* access modifiers changed from: private */
    public static final String E;

    /* renamed from: f  reason: collision with root package name */
    public static final a f63650f = new a((byte) 0);
    private CharSequence D;
    private HashMap F;

    public final void a(int i2) {
    }

    public final View b(int i2) {
        if (this.F == null) {
            this.F = new HashMap();
        }
        View view = (View) this.F.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.F.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void u() {
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = h.class.getSimpleName();
        k.a((Object) simpleName, "FJREnterMobileRechargeAm…V8::class.java.simpleName");
        E = simpleName;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View findViewById;
        k.c(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(onCreateView == null || (findViewById = onCreateView.findViewById(R.id.lyt_scroll_view_enter_amount)) == null)) {
            findViewById.setVisibility(0);
        }
        return onCreateView;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.lyt_shimmer_enter_amount);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
        } catch (Exception unused) {
        }
        super.onViewCreated(view, bundle);
    }

    public final String a(CJRCategoryData cJRCategoryData) {
        this.D = super.a(cJRCategoryData);
        return "";
    }

    public final void D() {
        super.D();
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.lyt_scroll_view_enter_amount);
        k.a((Object) nestedScrollView, "lyt_scroll_view_enter_amount");
        nestedScrollView.setVisibility(8);
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.lyt_shimmer_enter_amount);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
        } catch (Exception unused) {
        }
    }

    public final void w() {
        super.w();
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.lyt_shimmer_enter_amount);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
        } catch (Exception unused) {
        }
    }

    public final void ay_() {
        N();
        super.ay_();
    }

    public final void H() {
        N();
    }

    private void N() {
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        k.a((Object) subtitleCollapsingToolbarLayout, "toolbar_layout");
        subtitleCollapsingToolbarLayout.setTitle(this.D);
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.lyt_scroll_view_enter_amount);
        k.a((Object) nestedScrollView, "lyt_scroll_view_enter_amount");
        nestedScrollView.setVisibility(8);
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.lyt_shimmer_enter_amount);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
        } catch (Exception unused) {
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.lyt_shimmer_enter_amount);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setAutoStart(false);
        }
        u();
    }
}

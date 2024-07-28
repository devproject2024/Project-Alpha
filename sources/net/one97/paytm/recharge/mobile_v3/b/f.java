package net.one97.paytm.recharge.mobile_v3.b;

import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;

public final class f extends h {
    /* access modifiers changed from: private */
    public static final String E;

    /* renamed from: f  reason: collision with root package name */
    public static final a f63845f = new a((byte) 0);
    private CharSequence D;
    private HashMap F;

    public final void aA_() {
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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
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
        String simpleName = f.class.getSimpleName();
        k.a((Object) simpleName, "FJRMobileAmountShimmerFr…V3::class.java.simpleName");
        E = simpleName;
    }

    public final void e(int i2) {
        super.e(R.id.lyt_content_shimmer_mobile_amount);
    }

    public final String a(CJRCategoryData cJRCategoryData) {
        this.D = super.a(cJRCategoryData);
        return "";
    }

    public final void D() {
        super.D();
        super.aA_();
    }

    public final void I() {
        N();
        super.I();
    }

    public final void J() {
        N();
    }

    private void N() {
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        if (subtitleCollapsingToolbarLayout != null) {
            subtitleCollapsingToolbarLayout.setTitle(this.D);
        }
        super.aA_();
    }
}

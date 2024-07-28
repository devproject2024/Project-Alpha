package net.one97.paytm.o2o.movies.widget.bottom_sheet_views;

import android.content.Context;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond;

public final class CPSlabAndTncBS extends BottomSheetBaseView {

    /* renamed from: d  reason: collision with root package name */
    private CJRCPTermsAndCond f76201d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f76202e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f76203f;

    public interface a {
        void onCancelClick();
    }

    /* access modifiers changed from: protected */
    public final float a() {
        return 85.0f;
    }

    public final View a(int i2) {
        if (this.f76203f == null) {
            this.f76203f = new HashMap();
        }
        View view = (View) this.f76203f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f76203f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPSlabAndTncBS(Context context, CJRCPTermsAndCond cJRCPTermsAndCond) {
        super(context);
        k.c(context, "context");
        k.c(cJRCPTermsAndCond, "termAndCond");
        this.f76201d = cJRCPTermsAndCond;
        d();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPSlabAndTncBS(Context context, CJRCPTermsAndCond cJRCPTermsAndCond, a aVar) {
        super(context);
        k.c(context, "context");
        k.c(cJRCPTermsAndCond, "termAndCond");
        k.c(aVar, "listener");
        this.f76201d = cJRCPTermsAndCond;
        this.f76202e = aVar;
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r4 = r4.getTerms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d() {
        /*
            r6 = this;
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r0 = r6.f76201d
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r0 = r0.getSlabs()
            if (r0 == 0) goto L_0x0010
            java.util.List r0 = r0.getSlabs_content()
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            kotlin.a.w r0 = kotlin.a.w.INSTANCE
            java.util.List r0 = (java.util.List) r0
        L_0x0014:
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r1 = r6.f76201d
            if (r1 == 0) goto L_0x0024
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r1 = r1.getTerms()
            if (r1 == 0) goto L_0x0024
            java.util.List r1 = r1.getTerms_content()
            if (r1 != 0) goto L_0x0028
        L_0x0024:
            kotlin.a.w r1 = kotlin.a.w.INSTANCE
            java.util.List r1 = (java.util.List) r1
        L_0x0028:
            int r2 = net.one97.paytm.o2o.movies.R.id.txt_slab_title
            android.view.View r2 = r6.a((int) r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            java.lang.String r3 = "txt_slab_title"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r3 = r6.f76201d
            if (r3 == 0) goto L_0x004d
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r3 = r3.getSlabs()
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = r3.getHeading()
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.a.d.b(r3)
            if (r3 == 0) goto L_0x004d
            goto L_0x0057
        L_0x004d:
            android.content.Context r3 = r6.getContext()
            int r4 = net.one97.paytm.o2o.movies.R.string.cancellation_protection
            java.lang.String r3 = r3.getString(r4)
        L_0x0057:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            java.lang.String r4 = "rv_slab"
            r5 = 0
            if (r2 == 0) goto L_0x0080
            int r2 = net.one97.paytm.o2o.movies.R.id.rv_slab
            android.view.View r2 = r6.a((int) r2)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.o2o.movies.adapter.ap r4 = new net.one97.paytm.o2o.movies.adapter.ap
            r4.<init>(r0)
            androidx.recyclerview.widget.RecyclerView$a r4 = (androidx.recyclerview.widget.RecyclerView.a) r4
            r2.setAdapter(r4)
            goto L_0x0090
        L_0x0080:
            int r0 = net.one97.paytm.o2o.movies.R.id.rv_slab
            android.view.View r0 = r6.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r5)
        L_0x0090:
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            java.lang.String r2 = "rv_tnc"
            java.lang.String r4 = "txt_tnc_title"
            if (r0 == 0) goto L_0x00d5
            int r0 = net.one97.paytm.o2o.movies.R.id.txt_tnc_title
            android.view.View r0 = r6.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r4 = r6.f76201d
            if (r4 == 0) goto L_0x00b9
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r4 = r4.getTerms()
            if (r4 == 0) goto L_0x00b9
            java.lang.String r4 = r4.getHeading()
            goto L_0x00ba
        L_0x00b9:
            r4 = 0
        L_0x00ba:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            int r0 = net.one97.paytm.o2o.movies.R.id.rv_tnc
            android.view.View r0 = r6.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.o2o.movies.adapter.aq r2 = new net.one97.paytm.o2o.movies.adapter.aq
            r2.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r0.setAdapter(r2)
            goto L_0x00f5
        L_0x00d5:
            int r0 = net.one97.paytm.o2o.movies.R.id.txt_tnc_title
            android.view.View r0 = r6.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r5)
            int r0 = net.one97.paytm.o2o.movies.R.id.rv_tnc
            android.view.View r0 = r6.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r5)
        L_0x00f5:
            int r0 = net.one97.paytm.o2o.movies.R.id.btn_cancel_tickets
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.card.MaterialCardView r0 = (com.google.android.material.card.MaterialCardView) r0
            java.lang.String r1 = "btn_cancel_tickets"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$a r1 = r6.f76202e
            if (r1 == 0) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = 0
        L_0x010a:
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r3)
            int r0 = net.one97.paytm.o2o.movies.R.id.btn_cancel_tickets
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.card.MaterialCardView r0 = (com.google.android.material.card.MaterialCardView) r0
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$b r1 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$b
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.o2o.movies.R.id.scrollView
            android.view.View r0 = r6.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$c r1 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$c
            r1.<init>(r6)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 100
            r0.postDelayed(r1, r2)
            int r0 = net.one97.paytm.o2o.movies.R.id.btn_close
            android.view.View r0 = r6.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$d r1 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS$d
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS.d():void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPSlabAndTncBS f76204a;

        b(CPSlabAndTncBS cPSlabAndTncBS) {
            this.f76204a = cPSlabAndTncBS;
        }

        public final void onClick(View view) {
            this.f76204a.f76195a.dismiss();
            a a2 = this.f76204a.f76202e;
            if (a2 != null) {
                a2.onCancelClick();
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPSlabAndTncBS f76205a;

        c(CPSlabAndTncBS cPSlabAndTncBS) {
            this.f76205a = cPSlabAndTncBS;
        }

        public final void run() {
            ((NestedScrollView) this.f76205a.a(R.id.scrollView)).scrollTo(0, 0);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPSlabAndTncBS f76206a;

        d(CPSlabAndTncBS cPSlabAndTncBS) {
            this.f76206a = cPSlabAndTncBS;
        }

        public final void onClick(View view) {
            this.f76206a.f76195a.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final int c() {
        return R.layout.view_cp_slab_and_tnc;
    }
}

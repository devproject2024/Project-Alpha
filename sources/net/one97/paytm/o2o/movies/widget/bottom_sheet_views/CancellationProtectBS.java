package net.one97.paytm.o2o.movies.widget.bottom_sheet_views;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.d.d;
import net.one97.paytm.o2o.movies.utils.n;

public final class CancellationProtectBS extends BottomSheetBaseView {

    /* renamed from: d  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f76207d = new c(this);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f76208e;

    public final View a(int i2) {
        if (this.f76208e == null) {
            this.f76208e = new HashMap();
        }
        View view = (View) this.f76208e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f76208e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0030, code lost:
        r4 = (r4 = r6.getSlabs()).getSlabs_content();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CancellationProtectBS(android.content.Context r4, net.one97.paytm.o2o.movies.entity.CJRCPUpgrade r5, net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r6, final net.one97.paytm.o2o.movies.d.d r7) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "listener"
            kotlin.g.b.k.c(r7, r0)
            r3.<init>(r4)
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$c r4 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$c
            r4.<init>(r3)
            android.view.ViewTreeObserver$OnGlobalLayoutListener r4 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r4
            r3.f76207d = r4
            int r4 = net.one97.paytm.o2o.movies.R.id.rv_cp_options
            android.view.View r4 = r3.a(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$b r0 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$b
            r0.<init>()
            androidx.recyclerview.widget.RecyclerView$h r0 = (androidx.recyclerview.widget.RecyclerView.h) r0
            r4.addItemDecoration(r0)
            if (r6 == 0) goto L_0x0036
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r4 = r6.getSlabs()
            if (r4 == 0) goto L_0x0036
            java.util.List r4 = r4.getSlabs_content()
            if (r4 != 0) goto L_0x003a
        L_0x0036:
            kotlin.a.w r4 = kotlin.a.w.INSTANCE
            java.util.List r4 = (java.util.List) r4
        L_0x003a:
            if (r6 == 0) goto L_0x0048
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r6 = r6.getTerms()
            if (r6 == 0) goto L_0x0048
            java.util.List r6 = r6.getTerms_content()
            if (r6 != 0) goto L_0x004c
        L_0x0048:
            kotlin.a.w r6 = kotlin.a.w.INSTANCE
            java.util.List r6 = (java.util.List) r6
        L_0x004c:
            if (r5 == 0) goto L_0x0089
            int r0 = net.one97.paytm.o2o.movies.R.id.rv_cp_options
            android.view.View r0 = r3.a(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r1 = "rv_cp_options"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.adapter.ao r2 = new net.one97.paytm.o2o.movies.adapter.ao
            r2.<init>(r5, r7)
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r0.setAdapter(r2)
            java.util.List r5 = r5.getOptions()
            if (r5 == 0) goto L_0x0089
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0089
            int r5 = net.one97.paytm.o2o.movies.R.id.rv_cp_options
            android.view.View r5 = r3.a(r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            android.view.ViewTreeObserver r5 = r5.getViewTreeObserver()
            android.view.ViewTreeObserver$OnGlobalLayoutListener r0 = r3.f76207d
            r5.addOnGlobalLayoutListener(r0)
        L_0x0089:
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ 1
            r5 = 0
            if (r4 != 0) goto L_0x00a6
            int r4 = net.one97.paytm.o2o.movies.R.id.rv_slab
            android.view.View r4 = r3.a(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r0 = "rv_slab"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.o2o.movies.common.a.e.a(r4, r5)
        L_0x00a6:
            r4 = r6
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x00ca
            int r4 = net.one97.paytm.o2o.movies.R.id.tnc_rv
            android.view.View r4 = r3.a(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r5 = "tnc_rv"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.o2o.movies.adapter.aq r5 = new net.one97.paytm.o2o.movies.adapter.aq
            r5.<init>(r6)
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r4.setAdapter(r5)
            goto L_0x00dc
        L_0x00ca:
            int r4 = net.one97.paytm.o2o.movies.R.id.rv_tnc
            android.view.View r4 = r3.a(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r6 = "rv_tnc"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.o2o.movies.common.a.e.a(r4, r5)
        L_0x00dc:
            int r4 = net.one97.paytm.o2o.movies.R.id.btn_close
            android.view.View r4 = r3.a(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$1 r5 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$1
            r5.<init>(r3, r7)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            int r4 = net.one97.paytm.o2o.movies.R.id.txt_tnc
            android.view.View r4 = r3.a(r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$2 r5 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$2
            r5.<init>(r3)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            android.view.ViewParent r4 = r3.getParent()
            boolean r5 = r4 instanceof android.view.View
            if (r5 != 0) goto L_0x0109
            r4 = 0
        L_0x0109:
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x011d
            com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r4)
            if (r4 == 0) goto L_0x011d
            net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$a r5 = new net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS$a
            r5.<init>(r4, r3, r7)
            com.google.android.material.bottomsheet.BottomSheetBehavior$a r5 = (com.google.android.material.bottomsheet.BottomSheetBehavior.a) r5
            r4.setBottomSheetCallback(r5)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS.<init>(android.content.Context, net.one97.paytm.o2o.movies.entity.CJRCPUpgrade, net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond, net.one97.paytm.o2o.movies.d.d):void");
    }

    /* access modifiers changed from: protected */
    public final int c() {
        return R.layout.view_cancellation_protect_bs;
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellationProtectBS f76215a;

        c(CancellationProtectBS cancellationProtectBS) {
            this.f76215a = cancellationProtectBS;
        }

        public final void onGlobalLayout() {
            RecyclerView recyclerView = (RecyclerView) this.f76215a.a(R.id.rv_cp_options);
            k.a((Object) recyclerView, "rv_cp_options");
            this.f76215a.setPeekHeight(recyclerView.getHeight() + n.b(110));
            RecyclerView recyclerView2 = (RecyclerView) this.f76215a.a(R.id.rv_cp_options);
            k.a((Object) recyclerView2, "rv_cp_options");
            recyclerView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static final class a extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f76212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CancellationProtectBS f76213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f76214c;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        a(BottomSheetBehavior bottomSheetBehavior, CancellationProtectBS cancellationProtectBS, d dVar) {
            this.f76212a = bottomSheetBehavior;
            this.f76213b = cancellationProtectBS;
            this.f76214c = dVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (!this.f76213b.f76196b && i2 == 1) {
                BottomSheetBehavior bottomSheetBehavior = this.f76212a;
                k.a((Object) bottomSheetBehavior, "behavior");
                bottomSheetBehavior.setState(4);
                this.f76213b.setExpanded(false);
                this.f76214c.a();
            } else if (i2 == 5) {
                this.f76213b.f76195a.dismiss();
                this.f76214c.b();
                this.f76213b.setExpanded(false);
            } else if (i2 == 3) {
                this.f76213b.setExpanded(true);
                ((RoboTextView) this.f76213b.a(R.id.txt_tnc)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tnc_arrow_up, 0);
                this.f76214c.a();
            } else {
                ((RoboTextView) this.f76213b.a(R.id.txt_tnc)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tnc_arrow_down, 0);
            }
        }
    }

    public static final class b extends RecyclerView.h {
        b() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
                layoutParams = null;
            }
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int adapterPosition = layoutParams2 != null ? layoutParams2.f4054c.getAdapterPosition() : -1;
            if (recyclerView.getAdapter() != null && adapterPosition > 0) {
                rect.top = n.b(23);
            }
        }
    }
}

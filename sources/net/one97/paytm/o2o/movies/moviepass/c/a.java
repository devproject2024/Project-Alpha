package net.one97.paytm.o2o.movies.moviepass.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.o2o.movies.moviepass.b.a;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f75480a;

    /* renamed from: b  reason: collision with root package name */
    private String f75481b;

    /* renamed from: c  reason: collision with root package name */
    private String f75482c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f75483d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a.C1491a f75484e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f75485f;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        try {
            if (!(context instanceof a.C1491a)) {
                context = null;
            }
            this.f75484e = (a.C1491a) context;
        } catch (Exception unused) {
        }
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f75487a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                ViewParent parent = frameLayout.getParent();
                if (parent != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setPeekHeight(frameLayout.getHeight());
                    ((CoordinatorLayout) parent).getParent().requestLayout();
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(b.f75487a);
        }
        return getLayoutInflater().inflate(net.one97.paytm.o2o.movies.R.layout.activity_movie_pass_review, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r9v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r8, r0)
            super.onViewCreated(r8, r9)
            android.os.Bundle r9 = r7.getArguments()
            r0 = 0
            if (r9 == 0) goto L_0x0019
            java.lang.String r1 = "mp_card_heading"
            java.lang.String r2 = "Movie Pass"
            java.lang.String r9 = r9.getString(r1, r2)
            goto L_0x001a
        L_0x0019:
            r9 = r0
        L_0x001a:
            r7.f75480a = r9
            android.os.Bundle r9 = r7.getArguments()
            if (r9 == 0) goto L_0x0029
            java.lang.String r1 = "mp_current_date"
            java.lang.String r9 = r9.getString(r1)
            goto L_0x002a
        L_0x0029:
            r9 = r0
        L_0x002a:
            r7.f75481b = r9
            android.os.Bundle r9 = r7.getArguments()
            if (r9 == 0) goto L_0x0039
            java.lang.String r1 = "mp_total_price"
            java.lang.String r9 = r9.getString(r1)
            goto L_0x003a
        L_0x0039:
            r9 = r0
        L_0x003a:
            r7.f75482c = r9
            if (r8 == 0) goto L_0x0047
            int r9 = net.one97.paytm.o2o.movies.R.id.mp_bottom_sheet_title
            android.view.View r9 = r8.findViewById(r9)
            r0 = r9
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0047:
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.TextView"
            if (r0 == 0) goto L_0x013d
            int r1 = net.one97.paytm.o2o.movies.R.id.mp_bottom_sheet_date
            android.view.View r1 = r8.findViewById(r1)
            if (r1 == 0) goto L_0x0137
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.o2o.movies.R.id.close
            android.view.View r2 = r8.findViewById(r2)
            if (r2 == 0) goto L_0x012f
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            int r3 = net.one97.paytm.o2o.movies.R.id.mp_bottom_sheet_total_price
            android.view.View r3 = r8.findViewById(r3)
            if (r3 == 0) goto L_0x0129
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.o2o.movies.R.id.mp_bottom_sheet_proceed_to_pay
            android.view.View r8 = r8.findViewById(r4)
            if (r8 == 0) goto L_0x0123
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.f75483d = r8
            java.lang.String r8 = r7.f75480a
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x0084
            java.lang.String r8 = r7.f75480a
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
        L_0x0084:
            java.lang.String r8 = r7.f75481b
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            r9 = 1
            if (r8 != 0) goto L_0x00cc
            java.lang.String r8 = r7.f75481b     // Catch:{ Exception -> 0x00c5 }
            java.util.Date r8 = net.one97.paytm.o2o.movies.common.d.c((java.lang.String) r8)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r0 = "date"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)     // Catch:{ Exception -> 0x00c5 }
            int r0 = r8.getYear()     // Catch:{ Exception -> 0x00c5 }
            int r0 = r0 + 1900
            int r4 = r8.getMonth()     // Catch:{ Exception -> 0x00c5 }
            int r8 = r8.getDate()     // Catch:{ Exception -> 0x00c5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = "Start Date : "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00c5 }
            androidx.fragment.app.FragmentActivity r6 = r7.getActivity()     // Catch:{ Exception -> 0x00c5 }
            android.content.Context r6 = (android.content.Context) r6     // Catch:{ Exception -> 0x00c5 }
            int r4 = r4 + r9
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.d.a((android.content.Context) r6, (int) r0, (int) r4, (int) r8)     // Catch:{ Exception -> 0x00c5 }
            r5.append(r8)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x00c5 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00c5 }
            r1.setText(r8)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00cc
        L_0x00c5:
            java.lang.String r8 = r7.f75481b
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x00cc:
            java.lang.String r8 = r7.f75482c
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x0115
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r0 = net.one97.paytm.o2o.movies.R.string.rupee_symbol
            java.lang.String r0 = r7.getString(r0)
            r8.append(r0)
            java.lang.String r0 = r7.f75482c
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.setText(r8)
            android.widget.TextView r8 = r7.f75483d
            if (r8 != 0) goto L_0x00f7
            kotlin.g.b.k.a()
        L_0x00f7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Proceed to Pay "
            r0.<init>(r1)
            int r1 = net.one97.paytm.o2o.movies.R.string.rupee_symbol
            java.lang.String r1 = r7.getString(r1)
            r0.append(r1)
            java.lang.String r1 = r7.f75482c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x0115:
            net.one97.paytm.o2o.movies.moviepass.c.a$a r8 = new net.one97.paytm.o2o.movies.moviepass.c.a$a
            r8.<init>(r7)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r2.setOnClickListener(r8)
            r7.a((boolean) r9)
            return
        L_0x0123:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r9)
            throw r8
        L_0x0129:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r9)
            throw r8
        L_0x012f:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView"
            r8.<init>(r9)
            throw r8
        L_0x0137:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r9)
            throw r8
        L_0x013d:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.c.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* renamed from: net.one97.paytm.o2o.movies.moviepass.c.a$a  reason: collision with other inner class name */
    static final class C1492a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f75486a;

        C1492a(a aVar) {
            this.f75486a = aVar;
        }

        public final void onClick(View view) {
            this.f75486a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f75488a;

        c(a aVar) {
            this.f75488a = aVar;
        }

        public final void onClick(View view) {
            a.C1491a a2 = this.f75488a.f75484e;
            if (a2 != null) {
                a2.b();
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            TextView textView = this.f75483d;
            if (textView == null) {
                k.a();
            }
            textView.setOnClickListener(new c(this));
            return;
        }
        TextView textView2 = this.f75483d;
        if (textView2 == null) {
            k.a();
        }
        textView2.setOnClickListener((View.OnClickListener) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75485f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

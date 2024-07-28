package net.one97.paytm.feed.ui.feed.actions;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.i.f;

public abstract class a<B extends ViewDataBinding, VM extends ai> extends f {

    /* renamed from: a  reason: collision with root package name */
    protected B f34929a;

    /* renamed from: b  reason: collision with root package name */
    protected VM f34930b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f34931c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f34932d;

    public abstract int b();

    public abstract HashMap<Integer, Object> c();

    public abstract void d();

    public boolean e() {
        return false;
    }

    public void f() {
        HashMap hashMap = this.f34932d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    /* access modifiers changed from: protected */
    public final B a() {
        B b2 = this.f34929a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        return b2;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        this.f34931c = context;
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a(this.f34931c);
        com.google.android.play.core.splitcompat.a.b(this.f34931c);
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        this.f34930b = net.one97.paytm.feed.c.a.a((Fragment) this);
        B a2 = androidx.databinding.f.a(layoutInflater, b(), viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…utId(), container, false)");
        this.f34929a = a2;
        B b2 = this.f34929a;
        if (b2 == null) {
            k.a("dataBinding");
        }
        int i2 = net.one97.paytm.feed.a.q;
        VM vm = this.f34930b;
        if (vm == null) {
            k.a("viewModel");
        }
        b2.setVariable(i2, vm);
        for (Map.Entry entry : c().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        B b3 = this.f34929a;
        if (b3 == null) {
            k.a("dataBinding");
        }
        return b3.getRoot();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new C0569a(this, onCreateDialog));
        return onCreateDialog;
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.actions.a$a  reason: collision with other inner class name */
    static final class C0569a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f34933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Dialog f34934b;

        C0569a(a aVar, Dialog dialog) {
            this.f34933a = aVar;
            this.f34934b = dialog;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
            r3 = r3.findViewById(com.google.android.material.R.id.design_bottom_sheet);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onShow(android.content.DialogInterface r3) {
            /*
                r2 = this;
                android.app.Dialog r3 = r2.f34934b
                android.view.Window r3 = r3.getWindow()
                r0 = 0
                if (r3 == 0) goto L_0x0014
                int r1 = com.google.android.material.R.id.touch_outside
                android.view.View r3 = r3.findViewById(r1)
                if (r3 == 0) goto L_0x0014
                r3.setOnClickListener(r0)
            L_0x0014:
                net.one97.paytm.feed.ui.feed.actions.a r3 = r2.f34933a
                boolean r3 = r3.e()
                if (r3 == 0) goto L_0x0040
                android.app.Dialog r3 = r2.f34934b
                int r0 = com.google.android.material.R.id.design_bottom_sheet
                android.view.View r3 = r3.findViewById(r0)
                if (r3 == 0) goto L_0x0038
                android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
                android.view.View r3 = (android.view.View) r3
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r3)
                java.lang.String r0 = "BottomSheetBehavior.from(bottomSheet)"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                r0 = 3
                r3.setState(r0)
                return
            L_0x0038:
                kotlin.u r3 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.FrameLayout"
                r3.<init>(r0)
                throw r3
            L_0x0040:
                android.app.Dialog r3 = r2.f34934b
                android.view.Window r3 = r3.getWindow()
                if (r3 == 0) goto L_0x0055
                int r1 = com.google.android.material.R.id.design_bottom_sheet
                android.view.View r3 = r3.findViewById(r1)
                if (r3 == 0) goto L_0x0055
                android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
                goto L_0x0056
            L_0x0055:
                r3 = r0
            L_0x0056:
                if (r3 == 0) goto L_0x005e
                androidx.coordinatorlayout.widget.CoordinatorLayout$d r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r3
                r3.a((androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior) r0)
                return
            L_0x005e:
                kotlin.u r3 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.actions.a.C0569a.onShow(android.content.DialogInterface):void");
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        d();
    }
}

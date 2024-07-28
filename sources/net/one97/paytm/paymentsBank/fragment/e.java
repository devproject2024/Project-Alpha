package net.one97.paytm.paymentsBank.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;

public final class e extends p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18497a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f18498b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f18499c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f18500d;

    public interface b {
        void e();

        void f();

        void g();
    }

    private View a(int i2) {
        if (this.f18500d == null) {
            this.f18500d = new HashMap();
        }
        View view = (View) this.f18500d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18500d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f18498b = (b) context;
            return;
        }
        throw new IllegalAccessException(context + " must implement DomantAccountActivationFragment.OnFragmentInteractionListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dormant_account, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r6, r0)
            super.onViewCreated(r6, r7)
            android.os.Bundle r6 = r5.getArguments()
            if (r6 == 0) goto L_0x00cc
            r7 = 0
            java.lang.String r0 = "acc_activated"
            boolean r0 = r6.getBoolean(r0, r7)
            java.lang.String r1 = "acc"
            boolean r2 = r6.containsKey(r1)
            r3 = 1
            if (r2 == 0) goto L_0x0034
            java.lang.String r6 = r6.getString(r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x002f
            int r6 = r6.length()
            if (r6 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r6 = 0
            goto L_0x0030
        L_0x002f:
            r6 = 1
        L_0x0030:
            if (r6 != 0) goto L_0x0034
            r6 = 1
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            if (r6 == 0) goto L_0x00cc
            int r6 = net.one97.paytm.paymentsBank.R.id.tv_tittle
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r2 = "tv_tittle"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            int r2 = net.one97.paytm.paymentsBank.R.string.activate_acc
            java.lang.String r2 = r5.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.paymentsBank.R.string.pb_dormant_not_active_msg
            java.lang.Object[] r2 = new java.lang.Object[r3]
            android.os.Bundle r4 = r5.getArguments()
            if (r4 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            java.lang.String r4 = r4.getString(r1)
            r2[r7] = r4
            java.lang.String r6 = r5.getString(r6, r2)
            java.lang.String r2 = "getString(\n             …EY_ACC)\n                )"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            java.lang.String r2 = "proceed"
            if (r0 == 0) goto L_0x00a4
            int r6 = net.one97.paytm.paymentsBank.R.string.pb_dormant_already_activate
            java.lang.Object[] r0 = new java.lang.Object[r3]
            android.os.Bundle r4 = r5.getArguments()
            if (r4 != 0) goto L_0x007c
            kotlin.g.b.k.a()
        L_0x007c:
            java.lang.String r1 = r4.getString(r1)
            r0[r7] = r1
            java.lang.String r6 = r5.getString(r6, r0)
            java.lang.String r7 = "getString(\n             …CC)\n                    )"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            int r7 = net.one97.paytm.paymentsBank.R.id.proceed
            android.view.View r7 = r5.a((int) r7)
            android.widget.Button r7 = (android.widget.Button) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            int r0 = net.one97.paytm.paymentsBank.R.string.go_home
            java.lang.String r0 = r5.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
            r5.f18499c = r3
            goto L_0x00ba
        L_0x00a4:
            int r7 = net.one97.paytm.paymentsBank.R.id.proceed
            android.view.View r7 = r5.a((int) r7)
            android.widget.Button r7 = (android.widget.Button) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_activate_my_acc
            java.lang.String r0 = r5.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
        L_0x00ba:
            int r7 = net.one97.paytm.paymentsBank.R.id.tv_desc
            android.view.View r7 = r5.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r0 = "tv_desc"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
        L_0x00cc:
            int r6 = net.one97.paytm.paymentsBank.R.id.proceed
            android.view.View r6 = r5.a((int) r6)
            android.widget.Button r6 = (android.widget.Button) r6
            net.one97.paytm.paymentsBank.fragment.e$c r7 = new net.one97.paytm.paymentsBank.fragment.e$c
            r7.<init>(r5)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            int r6 = net.one97.paytm.paymentsBank.R.id.iv_back
            android.view.View r6 = r5.a((int) r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            net.one97.paytm.paymentsBank.fragment.e$d r7 = new net.one97.paytm.paymentsBank.fragment.e$d
            r7.<init>(r5)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.fragment.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18501a;

        c(e eVar) {
            this.f18501a = eVar;
        }

        public final void onClick(View view) {
            if (this.f18501a.f18499c) {
                b b2 = this.f18501a.f18498b;
                if (b2 == null) {
                    k.a();
                }
                b2.g();
                return;
            }
            b b3 = this.f18501a.f18498b;
            if (b3 == null) {
                k.a();
            }
            b3.e();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18502a;

        d(e eVar) {
            this.f18502a = eVar;
        }

        public final void onClick(View view) {
            b b2 = this.f18502a.f18498b;
            if (b2 == null) {
                k.a();
            }
            b2.f();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(String str, boolean z) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString("acc", str);
            bundle.putBoolean("acc_activated", z);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18500d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

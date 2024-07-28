package net.one97.paytm.newaddmoney.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.i;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.newaddmoney.utils.e;

public final class f extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.newaddmoney.c.a f55945a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f55946b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f55947c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f55948d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f55949e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f55950f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f55951g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f55952h;

    /* renamed from: i  reason: collision with root package name */
    private String f55953i;
    private HashMap j;

    public static final /* synthetic */ net.one97.paytm.newaddmoney.c.a c(f fVar) {
        net.one97.paytm.newaddmoney.c.a aVar = fVar.f55945a;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    /* JADX WARNING: type inference failed for: r7v21, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r6, android.view.ViewGroup r7, android.os.Bundle r8) {
        /*
            r5 = this;
            java.lang.String r7 = "inflater"
            kotlin.g.b.k.c(r6, r7)
            int r7 = net.one97.paytm.addmoney.R.layout.layout_new_add_money_gv_bottom_sheet
            r8 = 0
            android.view.View r6 = r6.inflate(r7, r8)
            androidx.fragment.app.FragmentActivity r7 = r5.getActivity()
            if (r7 == 0) goto L_0x003c
            net.one97.paytm.newaddmoney.c.b$a r0 = net.one97.paytm.newaddmoney.c.b.f55842a
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 == 0) goto L_0x001f
            android.app.Application r0 = r0.getApplication()
            goto L_0x0020
        L_0x001f:
            r0 = r8
        L_0x0020:
            r1 = r5
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            net.one97.paytm.newaddmoney.c.b r0 = net.one97.paytm.newaddmoney.c.b.a.a(r0, r1)
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.newaddmoney.c.a> r0 = net.one97.paytm.newaddmoney.c.a.class
            androidx.lifecycle.ai r7 = r7.a(r0)
            java.lang.String r0 = "ViewModelProviders.of(it…neyViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            net.one97.paytm.newaddmoney.c.a r7 = (net.one97.paytm.newaddmoney.c.a) r7
            r5.f55945a = r7
        L_0x003c:
            android.os.Bundle r7 = r5.getArguments()
            if (r7 == 0) goto L_0x0049
            java.lang.String r0 = "amount"
            java.lang.String r7 = r7.getString(r0)
            goto L_0x004a
        L_0x0049:
            r7 = r8
        L_0x004a:
            r5.f55953i = r7
            if (r6 == 0) goto L_0x0057
            int r7 = net.one97.paytm.addmoney.R.id.tv_readmore
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x0058
        L_0x0057:
            r7 = r8
        L_0x0058:
            r5.f55946b = r7
            if (r6 == 0) goto L_0x0065
            int r7 = net.one97.paytm.addmoney.R.id.tv_gv_text1
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x0066
        L_0x0065:
            r7 = r8
        L_0x0066:
            r5.f55948d = r7
            if (r6 == 0) goto L_0x0073
            int r7 = net.one97.paytm.addmoney.R.id.tv_or
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x0074
        L_0x0073:
            r7 = r8
        L_0x0074:
            r5.f55951g = r7
            if (r6 == 0) goto L_0x0081
            int r7 = net.one97.paytm.addmoney.R.id.tv_gv_text2
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x0082
        L_0x0081:
            r7 = r8
        L_0x0082:
            r5.f55949e = r7
            if (r6 == 0) goto L_0x008f
            int r7 = net.one97.paytm.addmoney.R.id.tv_desc
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x0090
        L_0x008f:
            r7 = r8
        L_0x0090:
            r5.f55950f = r7
            if (r6 == 0) goto L_0x009d
            int r7 = net.one97.paytm.addmoney.R.id.tv_proceed
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x009e
        L_0x009d:
            r7 = r8
        L_0x009e:
            r5.f55947c = r7
            if (r6 == 0) goto L_0x00ab
            int r7 = net.one97.paytm.addmoney.R.id.tv_try_with_lower_amount
            android.view.View r7 = r6.findViewById(r7)
            r8 = r7
            android.widget.TextView r8 = (android.widget.TextView) r8
        L_0x00ab:
            r5.f55952h = r8
            android.widget.TextView r7 = r5.f55952h
            if (r7 == 0) goto L_0x00bb
            net.one97.paytm.newaddmoney.view.f$a r8 = new net.one97.paytm.newaddmoney.view.f$a
            r8.<init>(r5)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
        L_0x00bb:
            android.widget.TextView r7 = r5.f55947c
            if (r7 == 0) goto L_0x00c9
            net.one97.paytm.newaddmoney.view.f$b r8 = new net.one97.paytm.newaddmoney.view.f$b
            r8.<init>(r5)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
        L_0x00c9:
            r5.a()
            boolean r7 = r5.b()
            if (r7 != 0) goto L_0x00f1
            android.widget.TextView r7 = r5.f55950f
            if (r7 == 0) goto L_0x00e1
            int r8 = net.one97.paytm.addmoney.R.string.gv_recommend_rbi_descr2
            java.lang.String r8 = r5.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x00e1:
            android.widget.TextView r7 = r5.f55952h
            if (r7 == 0) goto L_0x012f
            int r8 = net.one97.paytm.addmoney.R.string.now_acivate_wallet_2
            java.lang.String r8 = r5.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            goto L_0x012f
        L_0x00f1:
            android.widget.TextView r7 = r5.f55952h
            r8 = 0
            r0 = 1
            if (r7 == 0) goto L_0x011a
            int r1 = net.one97.paytm.addmoney.R.string.try_less_amount
            java.lang.Object[] r2 = new java.lang.Object[r0]
            net.one97.paytm.newaddmoney.c.a r3 = r5.f55945a
            if (r3 != 0) goto L_0x0105
            java.lang.String r4 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0105:
            double r3 = r3.A
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = com.paytm.utility.b.S((java.lang.String) r3)
            r2[r8] = r3
            java.lang.String r1 = r5.getString(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
        L_0x011a:
            android.widget.TextView r7 = r5.f55950f
            if (r7 == 0) goto L_0x012f
            int r1 = net.one97.paytm.addmoney.R.string.gv_recommend_title_descr
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "10000"
            r0[r8] = r2
            java.lang.String r8 = r5.getString(r1, r0)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x012f:
            android.widget.TextView r7 = r5.f55946b
            if (r7 == 0) goto L_0x013d
            net.one97.paytm.newaddmoney.view.f$c r8 = new net.one97.paytm.newaddmoney.view.f$c
            r8.<init>(r5)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
        L_0x013d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.f.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55954a;

        a(f fVar) {
            this.f55954a = fVar;
        }

        public final void onClick(View view) {
            Double d2;
            y<net.one97.paytm.newaddmoney.utils.b> yVar;
            if (!this.f55954a.b()) {
                f.b(this.f55954a);
                return;
            }
            if (this.f55954a.getParentFragment() instanceof c) {
                Fragment parentFragment = this.f55954a.getParentFragment();
                if (parentFragment != null) {
                    c cVar = (c) parentFragment;
                    net.one97.paytm.newaddmoney.c.a aVar = cVar.f55893c;
                    if (!(aVar == null || (yVar = aVar.o) == null)) {
                        yVar.setValue(net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
                    }
                    net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
                    if (kVar == null) {
                        k.a("binder");
                    }
                    CustomAmountTextInputEditText customAmountTextInputEditText = kVar.f48064c;
                    StringBuilder sb = new StringBuilder();
                    net.one97.paytm.newaddmoney.c.a aVar2 = cVar.f55893c;
                    if (aVar2 != null) {
                        d2 = Double.valueOf(aVar2.A);
                    } else {
                        d2 = null;
                    }
                    sb.append(d2);
                    customAmountTextInputEditText.setText(AddMoneyUtils.d(sb.toString()));
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
                }
            }
            this.f55954a.dismiss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55955a;

        b(f fVar) {
            this.f55955a = fVar;
        }

        public final void onClick(View view) {
            f.c(this.f55955a).f55839i.postValue(x.f47997a);
            this.f55955a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55956a;

        c(f fVar) {
            this.f55956a = fVar;
        }

        public final void onClick(View view) {
            TextView d2 = this.f55956a.f55948d;
            if (d2 == null || d2.getVisibility() != 0) {
                f.f(this.f55956a);
            } else {
                this.f55956a.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        TextView textView;
        TextView textView2 = this.f55950f;
        if (textView2 != null) {
            textView2.setText(getString(R.string.gv_recommend_title_descr, "10000"));
        }
        TextView textView3 = this.f55946b;
        if (textView3 != null) {
            textView3.setText(getString(R.string.read_more));
        }
        TextView textView4 = this.f55948d;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = this.f55949e;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        Context context = getContext();
        if (context != null && (textView = this.f55946b) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, R.drawable.down_arrow), (Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean b() {
        return !e.a() && !j.d(getActivity()).equals("Non Wallet Account");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        if (!(getParentFragment() instanceof c) || getParentFragment() != null) {
            super.onDismiss(dialogInterface);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
    }

    public static final /* synthetic */ void b(f fVar) {
        String str;
        i<String> iVar;
        String d2 = j.d(fVar.getActivity());
        boolean a2 = e.a();
        if (!a2 && !d2.equals("Non Wallet Account")) {
            return;
        }
        if (a2) {
            Context context = fVar.getContext();
            if (context != null) {
                Context context2 = fVar.getContext();
                String[] strArr = new String[4];
                strArr[0] = e.a(fVar.getActivity());
                strArr[1] = "";
                strArr[2] = "";
                net.one97.paytm.newaddmoney.c.a aVar = fVar.f55945a;
                if (aVar == null) {
                    k.a("viewModel");
                }
                if (aVar == null || (iVar = aVar.k) == null) {
                    str = null;
                } else {
                    str = iVar.get();
                }
                strArr[3] = str;
                d.a(context2, "add_money", "add_money_wallet_activate", "/home-screen/add-money/", (ArrayList<String>) kotlin.a.k.d(strArr), "");
                net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
                k.a((Object) context, "it");
                a3.a(context, "paytmmp://min_kyc?featuretype=popup");
                return;
            }
            return;
        }
        new net.one97.paytm.addmoney.landing.view.d().show(fVar.getChildFragmentManager(), net.one97.paytm.addmoney.landing.view.d.class.getName());
    }

    public static final /* synthetic */ void f(f fVar) {
        TextView textView;
        TextView textView2 = fVar.f55946b;
        if (textView2 != null) {
            textView2.setText(fVar.getString(R.string.read_less));
        }
        TextView textView3 = fVar.f55948d;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = fVar.f55949e;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        Context context = fVar.getContext();
        if (context != null && (textView = fVar.f55946b) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, R.drawable.arrow_up), (Drawable) null);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

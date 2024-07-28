package net.one97.paytm.newaddmoney.view;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.m;
import net.one97.paytm.newaddmoney.c.b;
import net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers;

public final class a extends net.one97.paytm.i.f implements net.one97.paytm.wallet.f.e, net.one97.paytm.wallet.f.f, net.one97.paytm.wallet.newdesign.addmoney.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1046a f55873a = new C1046a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f55874b = "EXTRA_SELECTED_COUPON";

    /* renamed from: c  reason: collision with root package name */
    private Context f55875c;

    /* renamed from: d  reason: collision with root package name */
    private String f55876d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<AddMoneyOffers.AddMoneyCodeOffers> f55877e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.addmoney.a.a f55878f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.wallet.d.c f55879g;

    /* renamed from: h  reason: collision with root package name */
    private String f55880h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public m f55881i;
    private net.one97.paytm.newaddmoney.c.a j;
    /* access modifiers changed from: private */
    public boolean k = true;
    private final View.OnFocusChangeListener l = new g(this);
    private HashMap m;

    public final void onAddMoneyInvalidAmountEntered(String str) {
    }

    public final void onAddMoneyRequestComplete() {
    }

    public final void onAddMoneyRequestStart() {
    }

    public final void onAddMoneyVerifyResponse(String str) {
    }

    public static final /* synthetic */ net.one97.paytm.newaddmoney.c.a c(a aVar) {
        net.one97.paytm.newaddmoney.c.a aVar2 = aVar.j;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        return aVar2;
    }

    public final void a() {
        net.one97.paytm.newaddmoney.c.a aVar = this.j;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: net.one97.paytm.newaddmoney.view.a$a  reason: collision with other inner class name */
    public static final class C1046a {
        private C1046a() {
        }

        public /* synthetic */ C1046a(byte b2) {
            this();
        }
    }

    public final void a(String str) {
        if (this.f55879g != null) {
            b();
            net.one97.paytm.wallet.d.c cVar = this.f55879g;
            if (cVar != null) {
                cVar.b(false);
            }
            net.one97.paytm.wallet.d.c cVar2 = this.f55879g;
            if (cVar2 != null) {
                cVar2.a(this.f55876d, str);
            }
        }
    }

    public final void a(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                str2 = "";
            }
            a(true, str, str2);
        }
    }

    public final void b(String str, String str2) {
        a(false, str, str2);
    }

    public final void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        setStyle(0, R.style.p2bAppBottomSheetDialogTheme);
        this.f55875c = getContext();
        Bundle arguments = getArguments();
        Boolean bool = null;
        this.f55876d = arguments != null ? arguments.getString("amount") : null;
        Bundle arguments2 = getArguments();
        this.f55880h = arguments2 != null ? arguments2.getString(this.f55874b) : null;
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (serializable = arguments3.getSerializable("add_money_offers")) == null)) {
            ArrayList<AddMoneyOffers.AddMoneyCodeOffers> arrayList = this.f55877e;
            if (arrayList != null) {
                if (serializable != null) {
                    bool = Boolean.valueOf(arrayList.addAll((ArrayList) serializable));
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers.AddMoneyCodeOffers>");
                }
            }
            bool.booleanValue();
        }
        this.f55879g = new net.one97.paytm.wallet.d.c(true);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        b.a aVar = net.one97.paytm.newaddmoney.c.b.f55842a;
        FragmentActivity activity2 = getActivity();
        ai a2 = am.a(activity, (al.b) b.a.a(activity2 != null ? activity2.getApplication() : null, this)).a(net.one97.paytm.newaddmoney.c.a.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…neyViewModel::class.java)");
        this.j = (net.one97.paytm.newaddmoney.c.a) a2;
        ViewDataBinding a3 = androidx.databinding.f.a(layoutInflater, R.layout.layout_coupon_bottomsheet, viewGroup, false);
        if (a3 != null) {
            this.f55881i = (m) a3;
            m mVar = this.f55881i;
            if (mVar != null) {
                return mVar.getRoot();
            }
            return null;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.databinding.LayoutCouponBottomsheetBinding");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bb, code lost:
        r2 = r2.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onActivityCreated(r9)
            net.one97.paytm.wallet.d.c r9 = r8.f55879g
            if (r9 == 0) goto L_0x0022
            if (r9 == 0) goto L_0x0018
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = r8
            net.one97.paytm.wallet.f.f r1 = (net.one97.paytm.wallet.f.f) r1
            r2 = r8
            net.one97.paytm.wallet.newdesign.addmoney.b.a r2 = (net.one97.paytm.wallet.newdesign.addmoney.b.a) r2
            r9.a((android.app.Activity) r0, (net.one97.paytm.wallet.f.f) r1, (net.one97.paytm.wallet.newdesign.addmoney.b.a) r2)
        L_0x0018:
            net.one97.paytm.wallet.d.c r9 = r8.f55879g
            if (r9 == 0) goto L_0x0022
            r0 = r8
            net.one97.paytm.wallet.f.e r0 = (net.one97.paytm.wallet.f.e) r0
            r9.a((net.one97.paytm.wallet.f.e) r0)
        L_0x0022:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x002f
            android.widget.EditText r9 = r9.f48074c
            if (r9 == 0) goto L_0x002f
            android.view.View$OnFocusChangeListener r0 = r8.l
            r9.setOnFocusChangeListener(r0)
        L_0x002f:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0041
            android.widget.TextView r9 = r9.n
            if (r9 == 0) goto L_0x0041
            net.one97.paytm.newaddmoney.view.a$b r0 = new net.one97.paytm.newaddmoney.view.a$b
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x0041:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0053
            android.widget.ImageView r9 = r9.f48073b
            if (r9 == 0) goto L_0x0053
            net.one97.paytm.newaddmoney.view.a$c r0 = new net.one97.paytm.newaddmoney.view.a$c
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x0053:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0065
            android.widget.RelativeLayout r9 = r9.f48076e
            if (r9 == 0) goto L_0x0065
            net.one97.paytm.newaddmoney.view.a$d r0 = new net.one97.paytm.newaddmoney.view.a$d
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x0065:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0077
            android.widget.EditText r9 = r9.f48074c
            if (r9 == 0) goto L_0x0077
            net.one97.paytm.newaddmoney.view.a$e r0 = new net.one97.paytm.newaddmoney.view.a$e
            r0.<init>(r8)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r9.addTextChangedListener(r0)
        L_0x0077:
            java.util.ArrayList<net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers> r9 = r8.f55877e
            int r9 = r9.size()
            r0 = 0
            if (r9 <= 0) goto L_0x00f1
            java.lang.String r9 = r8.f55880h
            r1 = 1
            if (r9 == 0) goto L_0x009f
            java.util.ArrayList<net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers> r2 = r8.f55877e
            net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers r3 = new net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers
            r3.<init>(r9)
            int r9 = r2.indexOf(r3)
            if (r9 < 0) goto L_0x009f
            java.util.ArrayList<net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers> r2 = r8.f55877e
            java.lang.Object r9 = r2.get(r9)
            net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers r9 = (net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers.AddMoneyCodeOffers) r9
            if (r9 == 0) goto L_0x009f
            r9.setIsOfferApplied(r1)
        L_0x009f:
            net.one97.paytm.wallet.newdesign.addmoney.a.a r9 = r8.f55878f
            if (r9 != 0) goto L_0x00cf
            net.one97.paytm.wallet.newdesign.addmoney.a.a r9 = new net.one97.paytm.wallet.newdesign.addmoney.a.a
            android.content.Context r3 = r8.f55875c
            java.util.ArrayList<net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers$AddMoneyCodeOffers> r2 = r8.f55877e
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            r5 = r8
            net.one97.paytm.wallet.newdesign.addmoney.b.a r5 = (net.one97.paytm.wallet.newdesign.addmoney.b.a) r5
            net.one97.paytm.newaddmoney.c.a r2 = r8.j
            if (r2 != 0) goto L_0x00b9
            java.lang.String r6 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00b9:
            if (r2 == 0) goto L_0x00c6
            androidx.databinding.i<java.lang.String> r2 = r2.k
            if (r2 == 0) goto L_0x00c6
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00c7
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            r7 = r2
            r2 = r9
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r8.f55878f = r9
        L_0x00cf:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x00f0
            androidx.recyclerview.widget.RecyclerView r9 = r9.f48078g
            if (r9 == 0) goto L_0x00f0
            r9.setVisibility(r0)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r8.f55875c
            r0.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r9.setLayoutManager(r0)
            r9.setHasFixedSize(r1)
            net.one97.paytm.wallet.newdesign.addmoney.a.a r0 = r8.f55878f
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r9.setAdapter(r0)
        L_0x00f0:
            return
        L_0x00f1:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            r1 = 8
            if (r9 == 0) goto L_0x00fe
            androidx.recyclerview.widget.RecyclerView r9 = r9.f48078g
            if (r9 == 0) goto L_0x00fe
            r9.setVisibility(r1)
        L_0x00fe:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0109
            android.widget.TextView r9 = r9.j
            if (r9 == 0) goto L_0x0109
            r9.setVisibility(r1)
        L_0x0109:
            net.one97.paytm.addmoney.a.m r9 = r8.f55881i
            if (r9 == 0) goto L_0x0114
            android.widget.LinearLayout r9 = r9.f48075d
            if (r9 == 0) goto L_0x0114
            r9.setVisibility(r0)
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.a.onActivityCreated(android.os.Bundle):void");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new f(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class f implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55886a;

        f(a aVar) {
            this.f55886a = aVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        from.setState(3);
                        from.setPeekHeight(500);
                        from.setHideable(true);
                        from.setSkipCollapsed(true);
                        from.addBottomSheetCallback(new BottomSheetBehavior.a(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ f f55887a;

                            public final void onSlide(View view, float f2) {
                                k.c(view, "bottomSheet");
                            }

                            {
                                this.f55887a = r1;
                            }

                            public final void onStateChanged(View view, int i2) {
                                k.c(view, "bottomSheet");
                                if (i2 == 5) {
                                    this.f55887a.f55886a.c();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    private final void a(boolean z, String str, String str2) {
        if (z) {
            if (getParentFragment() instanceof c) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
                } else if (((c) parentFragment).isAdded()) {
                    Fragment parentFragment2 = getParentFragment();
                    if (parentFragment2 != null) {
                        ((c) parentFragment2).a(str, str2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
                    }
                }
            }
            c();
            return;
        }
        net.one97.paytm.wallet.d.c cVar = this.f55879g;
        if (!(cVar == null || cVar == null)) {
            cVar.d();
        }
        b(str2);
    }

    private final void b(String str) {
        TextView textView;
        RelativeLayout relativeLayout;
        TextView textView2;
        View view;
        TextView textView3;
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            m mVar = this.f55881i;
            if (!(mVar == null || (textView3 = mVar.k) == null)) {
                textView3.setVisibility(0);
            }
            m mVar2 = this.f55881i;
            if (!(mVar2 == null || (view = mVar2.o) == null)) {
                view.setBackgroundResource(R.color.error_separator_view_color);
            }
            m mVar3 = this.f55881i;
            if (!(mVar3 == null || (textView2 = mVar3.k) == null)) {
                textView2.setText(charSequence);
            }
            m mVar4 = this.f55881i;
            if (!(mVar4 == null || (relativeLayout = mVar4.f48076e) == null)) {
                relativeLayout.setVisibility(8);
            }
            m mVar5 = this.f55881i;
            if (mVar5 != null && (textView = mVar5.n) != null) {
                textView.setVisibility(8);
            }
        }
    }

    private void b() {
        EditText editText;
        try {
            Context context = getContext();
            IBinder iBinder = null;
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                m mVar = this.f55881i;
                if (!(mVar == null || (editText = mVar.f48074c) == null)) {
                    iBinder = editText.getWindowToken();
                }
                inputMethodManager.hideSoftInputFromWindow(iBinder, 2);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55882a;

        b(a aVar) {
            this.f55882a = aVar;
        }

        public final void onClick(View view) {
            ClipData.Item itemAt;
            m b2;
            EditText editText;
            Context context = this.f55882a.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (systemService != null) {
                ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
                if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null && (b2 = this.f55882a.f55881i) != null && (editText = b2.f48074c) != null) {
                    editText.setText(itemAt.getText());
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.content.ClipboardManager");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55883a;

        c(a aVar) {
            this.f55883a = aVar;
        }

        public final void onClick(View view) {
            this.f55883a.c();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55884a;

        d(a aVar) {
            this.f55884a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r9 = r9.f48074c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                net.one97.paytm.newaddmoney.view.a r9 = r8.f55884a
                net.one97.paytm.addmoney.a.m r9 = r9.f55881i
                r0 = 0
                if (r9 == 0) goto L_0x0012
                android.widget.EditText r9 = r9.f48074c
                if (r9 == 0) goto L_0x0012
                android.text.Editable r9 = r9.getText()
                goto L_0x0013
            L_0x0012:
                r9 = r0
            L_0x0013:
                java.lang.String r9 = java.lang.String.valueOf(r9)
                r1 = r9
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0066
                net.one97.paytm.newaddmoney.view.a r1 = r8.f55884a
                android.content.Context r2 = r1.getContext()
                r1 = 4
                java.lang.String[] r1 = new java.lang.String[r1]
                r3 = 0
                net.one97.paytm.newaddmoney.view.a r4 = r8.f55884a
                android.content.Context r4 = r4.getContext()
                java.lang.String r4 = net.one97.paytm.newaddmoney.utils.e.a(r4)
                r1[r3] = r4
                r3 = 1
                r1[r3] = r9
                r3 = 2
                java.lang.String r4 = ""
                r1[r3] = r4
                r3 = 3
                net.one97.paytm.newaddmoney.view.a r4 = r8.f55884a
                net.one97.paytm.newaddmoney.c.a r4 = net.one97.paytm.newaddmoney.view.a.c(r4)
                if (r4 == 0) goto L_0x0051
                androidx.databinding.i<java.lang.String> r4 = r4.k
                if (r4 == 0) goto L_0x0051
                java.lang.Object r0 = r4.get()
                java.lang.String r0 = (java.lang.String) r0
            L_0x0051:
                r1[r3] = r0
                java.util.ArrayList r6 = kotlin.a.k.d(r1)
                r7 = 0
                java.lang.String r3 = "add_money"
                java.lang.String r4 = "add_money_enter_amount_have_promo_enter_code_apply"
                java.lang.String r5 = "/home-screen/add-money/"
                net.one97.paytm.addmoney.utils.d.a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.ArrayList<java.lang.String>) r6, (java.lang.String) r7)
                net.one97.paytm.newaddmoney.view.a r0 = r8.f55884a
                r0.a((java.lang.String) r9)
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.a.d.onClick(android.view.View):void");
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55885a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        e(a aVar) {
            this.f55885a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            i<String> iVar;
            if (editable == null || editable.length() <= 0) {
                a.a(this.f55885a, false);
                return;
            }
            a.d(this.f55885a);
            a.a(this.f55885a, true);
            Context context = this.f55885a.getContext();
            String[] strArr = new String[4];
            strArr[0] = net.one97.paytm.newaddmoney.utils.e.a(this.f55885a.getContext());
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a c2 = a.c(this.f55885a);
            if (c2 == null || (iVar = c2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(context, "add_money", "add_money_tap_enter_promo", "/home-screen/add-money/", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
        }
    }

    static final class g implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55888a;

        g(a aVar) {
            this.f55888a = aVar;
        }

        public final void onFocusChange(View view, boolean z) {
            m b2;
            View view2;
            TextView textView;
            m b3;
            View view3;
            TextView textView2;
            if (z) {
                m b4 = this.f55888a.f55881i;
                if (!((b4 != null && (textView2 = b4.k) != null && textView2.getVisibility() == 0) || (b3 = this.f55888a.f55881i) == null || (view3 = b3.o) == null)) {
                    view3.setBackgroundResource(R.color.color_blue_ifsc);
                }
                if (this.f55888a.k && (this.f55888a.getParentFragment() instanceof c)) {
                    this.f55888a.k = false;
                    Fragment parentFragment = this.f55888a.getParentFragment();
                    if (parentFragment != null) {
                        c cVar = (c) parentFragment;
                        net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
                        if (kVar == null) {
                            k.a("binder");
                        }
                        NestedScrollView nestedScrollView = kVar.F;
                        k.a((Object) nestedScrollView, "binder.scrollView");
                        nestedScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(cVar.f55894d);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
                }
                return;
            }
            m b5 = this.f55888a.f55881i;
            if ((b5 == null || (textView = b5.k) == null || textView.getVisibility() != 0) && (b2 = this.f55888a.f55881i) != null && (view2 = b2.o) != null) {
                view2.setBackgroundResource(R.color.separator_view_color);
            }
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        String str;
        i<String> iVar;
        k.c(dialogInterface, "dialog");
        b();
        Context context = getContext();
        String[] strArr = new String[4];
        strArr[0] = net.one97.paytm.newaddmoney.utils.e.a(getContext());
        strArr[1] = "";
        strArr[2] = "";
        net.one97.paytm.newaddmoney.c.a aVar = this.j;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar == null || (iVar = aVar.k) == null) {
            str = null;
        } else {
            str = iVar.get();
        }
        strArr[3] = str;
        net.one97.paytm.addmoney.utils.d.a(context, "add_money", "add_money_enter_amount_have_promo_closed", "/home-screen/add-money/", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
        if ((getParentFragment() instanceof c) && !this.k) {
            this.k = true;
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                ((c) parentFragment).a();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.newaddmoney.view.AddMoneyWalletNewFragment");
            }
        }
        super.onDismiss(dialogInterface);
    }

    /* access modifiers changed from: private */
    public final void c() {
        b();
        dismiss();
    }

    public static final /* synthetic */ void d(a aVar) {
        View view;
        TextView textView;
        m mVar = aVar.f55881i;
        if (!(mVar == null || (textView = mVar.k) == null)) {
            textView.setVisibility(8);
        }
        m mVar2 = aVar.f55881i;
        if (mVar2 != null && (view = mVar2.o) != null) {
            view.setBackgroundResource(R.color.color_blue_ifsc);
        }
    }

    public static final /* synthetic */ void a(a aVar, boolean z) {
        TextView textView;
        RelativeLayout relativeLayout;
        TextView textView2;
        RelativeLayout relativeLayout2;
        if (z) {
            m mVar = aVar.f55881i;
            if (!(mVar == null || (relativeLayout2 = mVar.f48076e) == null)) {
                relativeLayout2.setVisibility(0);
            }
            m mVar2 = aVar.f55881i;
            if (mVar2 != null && (textView2 = mVar2.n) != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        m mVar3 = aVar.f55881i;
        if (!(mVar3 == null || (relativeLayout = mVar3.f48076e) == null)) {
            relativeLayout.setVisibility(8);
        }
        m mVar4 = aVar.f55881i;
        if (mVar4 != null && (textView = mVar4.n) != null) {
            textView.setVisibility(8);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

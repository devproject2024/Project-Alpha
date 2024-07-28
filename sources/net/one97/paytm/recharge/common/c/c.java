package net.one97.paytm.recharge.common.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.e.s;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRPromosViewV8;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class c extends net.one97.paytm.i.f implements TextWatcher, View.OnClickListener, l.b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f60959c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f60960d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public boolean f60961a;

    /* renamed from: b  reason: collision with root package name */
    LiveData<CJROffers> f60962b;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJROffers f60963e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRPromosViewV8 f60964f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public s f60965g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f60966h;

    /* renamed from: i  reason: collision with root package name */
    private String f60967i;
    private net.one97.paytm.recharge.ordersummary.h.d j;
    private final String k;
    private d l;
    /* access modifiers changed from: private */
    public CJRPromosViewV8.b m;
    private boolean n;
    private HashMap o;

    public interface b {
        void a(String str);

        void b(String str);

        void d();
    }

    /* renamed from: net.one97.paytm.recharge.common.c.c$c  reason: collision with other inner class name */
    public interface C1181c {
        y<CJRRechargeCart> a(CJROfferCode cJROfferCode, Object obj);
    }

    public final boolean a() {
        return false;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final View b(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<CJROffers> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60974a;

        e(c cVar) {
            this.f60974a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0056, code lost:
            r8 = r8.getValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r8) {
            /*
                r7 = this;
                net.one97.paytm.common.entity.shopping.CJROffers r8 = (net.one97.paytm.common.entity.shopping.CJROffers) r8
                net.one97.paytm.recharge.common.c.c r0 = r7.f60974a
                r0.f60963e = r8
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r0 = new net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b
                r0.<init>()
                net.one97.paytm.recharge.common.c.c r1 = r7.f60974a
                int r2 = net.one97.paytm.recharge.R.string.exclusive_cashback_title
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "getString(R.string.exclusive_cashback_title)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r0 = r0.a((java.lang.String) r1)
                net.one97.paytm.recharge.common.c.c r1 = r7.f60974a
                int r2 = net.one97.paytm.recharge.R.string.terms_and_conditions_title
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "getString(R.string.terms_and_conditions_title)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.String r2 = "popUpTitle"
                kotlin.g.b.k.c(r1, r2)
                r0.f61918h = r1
                net.one97.paytm.recharge.common.c.c r1 = r7.f60974a
                int r2 = net.one97.paytm.recharge.R.string.promo_action_apply
                java.lang.String r1 = r1.getString(r2)
                r0.f61914d = r1
                r1 = 0
                java.lang.String r2 = ""
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r0 = r0.a(r1, r2)
                net.one97.paytm.recharge.common.c.c r2 = r7.f60974a
                net.one97.paytm.recharge.common.a.l$b r2 = (net.one97.paytm.recharge.common.a.l.b) r2
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r0 = r0.a((net.one97.paytm.recharge.common.a.l.b) r2)
                r8.m = r0
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                androidx.lifecycle.LiveData<net.one97.paytm.common.entity.shopping.CJROffers> r8 = r8.f60962b
                r0 = 0
                if (r8 == 0) goto L_0x0063
                java.lang.Object r8 = r8.getValue()
                net.one97.paytm.common.entity.shopping.CJROffers r8 = (net.one97.paytm.common.entity.shopping.CJROffers) r8
                if (r8 == 0) goto L_0x0063
                java.util.ArrayList r8 = r8.getOfferCodes()
                goto L_0x0064
            L_0x0063:
                r8 = r0
            L_0x0064:
                java.util.Collection r8 = (java.util.Collection) r8
                if (r8 == 0) goto L_0x007f
                boolean r2 = r8.isEmpty()
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x007f
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                net.one97.paytm.recharge.common.c.c r2 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r2 = r2.m
                if (r2 == 0) goto L_0x007f
                java.util.List r8 = (java.util.List) r8
                r2.a((java.util.List<net.one97.paytm.common.entity.shopping.CJROfferCode>) r8)
            L_0x007f:
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r8 = r8.m
                if (r8 == 0) goto L_0x00ad
                net.one97.paytm.recharge.common.c.c r2 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r3 = new net.one97.paytm.recharge.common.widget.CJRPromosViewV8
                android.content.Context r4 = r2.getContext()
                net.one97.paytm.recharge.common.c.c r5 = r7.f60974a
                androidx.fragment.app.j r5 = r5.getChildFragmentManager()
                java.lang.String r6 = "childFragmentManager"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                net.one97.paytm.recharge.common.c.c r6 = r7.f60974a
                net.one97.paytm.recharge.common.e.s r6 = r6.f60965g
                if (r6 != 0) goto L_0x00a5
                kotlin.g.b.k.a()
            L_0x00a5:
                net.one97.paytm.recharge.common.e.t r6 = (net.one97.paytm.recharge.common.e.t) r6
                r3.<init>(r4, r5, r8, r6)
                r2.f60964f = r3
            L_0x00ad:
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                int r2 = net.one97.paytm.recharge.R.id.promo_code_container
                android.view.View r8 = r8.b((int) r2)
                android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
                r8.removeAllViews()
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r8 = r8.f60964f
                if (r8 == 0) goto L_0x00c5
                r8.e()
            L_0x00c5:
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                int r2 = net.one97.paytm.recharge.R.id.promo_code_container
                android.view.View r8 = r8.b((int) r2)
                android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
                net.one97.paytm.recharge.common.c.c r2 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.f60964f
                android.view.View r2 = (android.view.View) r2
                r8.addView(r2)
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r8 = r8.f60964f
                if (r8 == 0) goto L_0x00e6
                android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            L_0x00e6:
                if (r0 == 0) goto L_0x0101
                android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
                r8 = 30
                int r8 = com.paytm.utility.b.c((int) r8)
                r0.setMargins(r1, r1, r1, r8)
                net.one97.paytm.recharge.common.c.c r8 = r7.f60974a
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r8 = r8.f60964f
                if (r8 == 0) goto L_0x0100
                android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
                r8.setLayoutParams(r0)
            L_0x0100:
                return
            L_0x0101:
                kotlin.u r8 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.c.c.e.onChanged(java.lang.Object):void");
        }
    }

    static final class f<T> implements z<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60975a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROfferCode f60976b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRRechargeErrorModel f60977c;

        f(c cVar, CJROfferCode cJROfferCode, CJRRechargeErrorModel cJRRechargeErrorModel) {
            this.f60975a = cVar;
            this.f60976b = cJROfferCode;
            this.f60977c = cJRRechargeErrorModel;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c.a(this.f60975a, (CJRRechargeCart) obj, this.f60976b, this.f60977c);
        }
    }

    static final class g<T> implements z<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60978a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROfferCode f60979b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRRechargeErrorModel f60980c;

        g(c cVar, CJROfferCode cJROfferCode, CJRRechargeErrorModel cJRRechargeErrorModel) {
            this.f60978a = cVar;
            this.f60979b = cJROfferCode;
            this.f60980c = cJRRechargeErrorModel;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c.a(this.f60978a, (CJRRechargeCart) obj, this.f60979b, this.f60980c);
        }
    }

    public c() {
        this.k = "credit_card";
    }

    public final void a(String str) {
        k.c(str, CLPConstants.ARGUMENT_KEY_POSITION);
        this.f60966h = true;
        ProgressBar progressBar = (ProgressBar) b(R.id.apply_progress_bar);
        k.a((Object) progressBar, "apply_progress_bar");
        progressBar.setVisibility(8);
        TextView textView = (TextView) b(R.id.paste_promo_error);
        k.a((Object) textView, "paste_promo_error");
        textView.setVisibility(8);
        ba.a(getContext(), (View) (TextView) b(R.id.apply_text));
    }

    public c(d dVar) {
        this();
        this.l = dVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = c.class.getSimpleName();
        k.a((Object) simpleName, "CJRPromoSelectionBottomS…V8::class.java.simpleName");
        f60959c = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.anim.slide_up;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("operator_name")) {
            Bundle arguments2 = getArguments();
            this.f60967i = arguments2 != null ? arguments2.getString("operator_name") : null;
        }
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.j = new net.one97.paytm.recharge.ordersummary.h.d(context);
        }
        return layoutInflater.inflate(R.layout.content_bottom_sheet_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        LiveData<CJROffers> liveData;
        s sVar;
        LiveData<CJROffers> liveData2;
        k.c(view, "view");
        TextView textView = (TextView) b(R.id.title);
        k.a((Object) textView, "title");
        d dVar = this.l;
        if (dVar == null || (str = dVar.f60968a) == null) {
            str = "";
        }
        textView.setText(str);
        View b2 = b(R.id.fullScreen);
        k.a((Object) b2, "fullScreen");
        b2.setVisibility(0);
        ((EditText) b(R.id.search_edit_text)).addTextChangedListener(this);
        View.OnClickListener onClickListener = this;
        ((ImageView) b(R.id.close_button)).setOnClickListener(onClickListener);
        ((TextView) b(R.id.apply_text)).setOnClickListener(onClickListener);
        ((EditText) b(R.id.search_edit_text)).setOnClickListener(onClickListener);
        if (getActivity() instanceof s) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f60962b = ((s) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    this.f60965g = (s) activity2;
                    ProgressBar progressBar = (ProgressBar) b(R.id.dialog_progress_bar);
                    k.a((Object) progressBar, "dialog_progress_bar");
                    progressBar.setVisibility(8);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRProductPromoCodesLifeCycleOwner");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRProductPromoCodesLifeCycleOwner");
            }
        } else {
            d dVar2 = this.l;
            s sVar2 = null;
            if (dVar2 != null) {
                liveData = dVar2.f60970c;
            } else {
                liveData = null;
            }
            if (liveData != null) {
                d dVar3 = this.l;
                if (dVar3 != null) {
                    liveData2 = dVar3.f60970c;
                } else {
                    liveData2 = null;
                }
                this.f60962b = liveData2;
            }
            d dVar4 = this.l;
            if (dVar4 != null) {
                sVar = dVar4.f60971d;
            } else {
                sVar = null;
            }
            if (sVar != null) {
                d dVar5 = this.l;
                if (dVar5 != null) {
                    sVar2 = dVar5.f60971d;
                }
                this.f60965g = sVar2;
            }
        }
        LiveData<CJROffers> liveData3 = this.f60962b;
        if (liveData3 != null) {
            liveData3.observe(this, new e(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = 0
            if (r26 == 0) goto L_0x000e
            int r2 = r26.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x000f
        L_0x000e:
            r2 = r1
        L_0x000f:
            int r3 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r3 = r0.b((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            java.lang.String r4 = "close_button"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r3 = r3.getId()
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0025
            goto L_0x0055
        L_0x0025:
            int r5 = r2.intValue()
            if (r5 != r3) goto L_0x0055
            java.lang.String r1 = r0.f60967i
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = r0.f60967i
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            java.lang.String r2 = "coupon_skip_clicked"
            r0.a(r1, r2, r4)
        L_0x0041:
            android.content.Context r1 = r25.getContext()
            if (r1 == 0) goto L_0x0051
            net.one97.paytm.recharge.common.f.d r2 = new net.one97.paytm.recharge.common.f.d
            r2.<init>()
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.f61539a
            net.one97.paytm.recharge.common.f.d.a(r1, r2)
        L_0x0051:
            r25.dismiss()
            return
        L_0x0055:
            int r3 = net.one97.paytm.recharge.R.id.apply_text
            android.view.View r3 = r0.b((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r5 = "apply_text"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r3 = r3.getId()
            r6 = 1
            if (r2 != 0) goto L_0x006b
            goto L_0x031c
        L_0x006b:
            int r7 = r2.intValue()
            if (r7 != r3) goto L_0x031c
            r2 = 0
            r0.f60966h = r2
            java.lang.String r3 = r0.f60967i
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00aa
            java.lang.String r3 = r0.f60967i
            if (r3 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            int r7 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r7 = r0.b((int) r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x0094
            android.text.Editable r7 = r7.getText()
            goto L_0x0095
        L_0x0094:
            r7 = r1
        L_0x0095:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "promocode_entered"
            r0.a(r3, r8, r7)
            java.lang.String r3 = r0.f60967i
            if (r3 != 0) goto L_0x00a5
            kotlin.g.b.k.a()
        L_0x00a5:
            java.lang.String r7 = "promocode_apply_clicked"
            r0.a(r3, r7, r4)
        L_0x00aa:
            net.one97.paytm.recharge.common.c.c$d r3 = r0.l
            if (r3 == 0) goto L_0x0106
            boolean r3 = r3.f60973f
            if (r3 != r6) goto L_0x0106
            net.one97.paytm.recharge.ordersummary.h.d r7 = r0.j
            if (r7 == 0) goto L_0x00d9
            java.lang.String r8 = r0.k
            int r3 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r3 = r0.b((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x00c7
            android.text.Editable r3 = r3.getText()
            goto L_0x00c8
        L_0x00c7:
            r3 = r1
        L_0x00c8:
            java.lang.String r11 = java.lang.String.valueOf(r3)
            r13 = 0
            r14 = 0
            r15 = 96
            java.lang.String r9 = "promocode_entered"
            java.lang.String r10 = ""
            java.lang.String r12 = "recharges_utilities"
            net.one97.paytm.recharge.ordersummary.h.d.a(r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00d9:
            net.one97.paytm.recharge.ordersummary.h.d r3 = r0.j
            if (r3 == 0) goto L_0x0106
            java.lang.String r7 = r0.k
            int r8 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r8 = r0.b((int) r8)
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x00ee
            android.text.Editable r8 = r8.getText()
            goto L_0x00ef
        L_0x00ee:
            r8 = r1
        L_0x00ef:
            java.lang.String r20 = java.lang.String.valueOf(r8)
            r22 = 0
            r23 = 0
            r24 = 96
            java.lang.String r18 = "promocode_apply_clicked"
            java.lang.String r19 = ""
            java.lang.String r21 = "recharges_utilities"
            r16 = r3
            r17 = r7
            net.one97.paytm.recharge.ordersummary.h.d.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
        L_0x0106:
            int r3 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r3 = r0.b((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r7 = "search_edit_text"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r7 = r3.length()
            int r7 = r7 - r6
            r8 = r7
            r7 = 0
            r9 = 0
        L_0x0125:
            r10 = 32
            if (r7 > r8) goto L_0x0145
            if (r9 != 0) goto L_0x012d
            r11 = r7
            goto L_0x012e
        L_0x012d:
            r11 = r8
        L_0x012e:
            char r11 = r3.charAt(r11)
            if (r11 > r10) goto L_0x0136
            r11 = 1
            goto L_0x0137
        L_0x0136:
            r11 = 0
        L_0x0137:
            if (r9 != 0) goto L_0x0140
            if (r11 != 0) goto L_0x013d
            r9 = 1
            goto L_0x0125
        L_0x013d:
            int r7 = r7 + 1
            goto L_0x0125
        L_0x0140:
            if (r11 == 0) goto L_0x0145
            int r8 = r8 + -1
            goto L_0x0125
        L_0x0145:
            int r8 = r8 + r6
            java.lang.CharSequence r3 = r3.subSequence(r7, r8)
            java.lang.String r3 = r3.toString()
            java.lang.String r7 = " "
            java.lang.String r3 = kotlin.m.p.a(r3, r7, r4, r2)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x02f1
            android.content.Context r7 = r25.getContext()
            boolean r7 = com.paytm.utility.b.c((android.content.Context) r7)
            if (r7 == 0) goto L_0x029e
            int r7 = r4.length()
            int r7 = r7 - r6
            r8 = r7
            r7 = 0
            r9 = 0
        L_0x016f:
            if (r7 > r8) goto L_0x018d
            if (r9 != 0) goto L_0x0175
            r11 = r7
            goto L_0x0176
        L_0x0175:
            r11 = r8
        L_0x0176:
            char r11 = r4.charAt(r11)
            if (r11 > r10) goto L_0x017e
            r11 = 1
            goto L_0x017f
        L_0x017e:
            r11 = 0
        L_0x017f:
            if (r9 != 0) goto L_0x0188
            if (r11 != 0) goto L_0x0185
            r9 = 1
            goto L_0x016f
        L_0x0185:
            int r7 = r7 + 1
            goto L_0x016f
        L_0x0188:
            if (r11 == 0) goto L_0x018d
            int r8 = r8 + -1
            goto L_0x016f
        L_0x018d:
            int r8 = r8 + r6
            java.lang.CharSequence r4 = r4.subSequence(r7, r8)
            java.lang.String r4 = r4.toString()
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x028d
            net.one97.paytm.common.entity.shopping.CJROffers r4 = r0.f60963e
            if (r4 == 0) goto L_0x01d7
            java.util.ArrayList r4 = r4.getOfferCodes()
            if (r4 == 0) goto L_0x01d7
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x01b3:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x01d3
            java.lang.Object r8 = r4.next()
            r9 = r8
            net.one97.paytm.common.entity.shopping.CJROfferCode r9 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r9
            java.lang.String r10 = "it"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.lang.String r9 = r9.getCode()
            boolean r9 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r9, (boolean) r6)
            if (r9 == 0) goto L_0x01b3
            r7.add(r8)
            goto L_0x01b3
        L_0x01d3:
            r4 = r7
            java.util.List r4 = (java.util.List) r4
            goto L_0x01d8
        L_0x01d7:
            r4 = r1
        L_0x01d8:
            if (r4 == 0) goto L_0x01eb
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r6
            if (r7 == 0) goto L_0x01eb
            java.lang.Object r4 = r4.get(r2)
            net.one97.paytm.common.entity.shopping.CJROfferCode r4 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r4
            goto L_0x01f3
        L_0x01eb:
            net.one97.paytm.common.entity.shopping.CJROfferCode r4 = new net.one97.paytm.common.entity.shopping.CJROfferCode
            r4.<init>()
            r4.setCode(r3)
        L_0x01f3:
            r0.n = r6
            r0.f60961a = r6
            if (r4 != 0) goto L_0x01fc
            kotlin.g.b.k.a()
        L_0x01fc:
            java.lang.String r6 = "promoCode"
            kotlin.g.b.k.c(r4, r6)
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            androidx.fragment.app.FragmentActivity r7 = r25.getActivity()
            boolean r7 = r7 instanceof net.one97.paytm.recharge.common.e.s
            if (r7 == 0) goto L_0x024b
            int r7 = net.one97.paytm.recharge.R.id.dummy_container
            android.view.View r7 = r0.b((int) r7)
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x021e
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.recharge.common.utils.ai.a(r7)
        L_0x021e:
            net.one97.paytm.recharge.common.utils.ay r7 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r8 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROMO_VERIFY
            net.one97.paytm.recharge.common.utils.ay.a(r7, r8, r6)
            androidx.fragment.app.FragmentActivity r7 = r25.getActivity()
            if (r7 == 0) goto L_0x0243
            net.one97.paytm.recharge.common.e.s r7 = (net.one97.paytm.recharge.common.e.s) r7
            androidx.lifecycle.y r7 = r7.b(r4, r6)
            if (r7 == 0) goto L_0x026f
            r8 = r0
            androidx.lifecycle.q r8 = (androidx.lifecycle.q) r8
            net.one97.paytm.recharge.common.c.c$f r9 = new net.one97.paytm.recharge.common.c.c$f
            r9.<init>(r0, r4, r6)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r7.observe(r8, r9)
            goto L_0x026f
        L_0x0243:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRProductPromoCodesLifeCycleOwner"
            r1.<init>(r2)
            throw r1
        L_0x024b:
            net.one97.paytm.recharge.common.utils.ay r7 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r8 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.MANUAL_PROMO
            net.one97.paytm.recharge.common.utils.ay.a(r7, r8, r6)
            net.one97.paytm.recharge.common.c.c$d r7 = r0.l
            if (r7 == 0) goto L_0x026f
            net.one97.paytm.recharge.common.c.c$c r7 = r7.f60972e
            if (r7 == 0) goto L_0x026f
            androidx.lifecycle.y r7 = r7.a(r4, r6)
            if (r7 == 0) goto L_0x026f
            r8 = r0
            androidx.lifecycle.q r8 = (androidx.lifecycle.q) r8
            net.one97.paytm.recharge.common.c.c$g r9 = new net.one97.paytm.recharge.common.c.c$g
            r9.<init>(r0, r4, r6)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r7.observe(r8, r9)
        L_0x026f:
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r4 = r0.f60964f
            if (r4 == 0) goto L_0x028d
            androidx.lifecycle.LiveData<net.one97.paytm.common.entity.shopping.CJROffers> r6 = r0.f60962b
            if (r6 == 0) goto L_0x0283
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.common.entity.shopping.CJROffers r6 = (net.one97.paytm.common.entity.shopping.CJROffers) r6
            if (r6 == 0) goto L_0x0283
            java.util.ArrayList r1 = r6.getOfferCodes()
        L_0x0283:
            if (r1 != 0) goto L_0x0288
            kotlin.g.b.k.a()
        L_0x0288:
            java.util.List r1 = (java.util.List) r1
            r4.a((java.util.List<? extends net.one97.paytm.common.entity.shopping.CJROfferCode>) r1)
        L_0x028d:
            int r1 = net.one97.paytm.recharge.R.id.apply_progress_bar
            android.view.View r1 = r0.b((int) r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r4 = "apply_progress_bar"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r2)
            goto L_0x02f1
        L_0x029e:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r2 = r25.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROMO_VERIFY
            android.content.Context r7 = r25.getContext()
            if (r7 == 0) goto L_0x02bb
            android.content.res.Resources r7 = r7.getResources()
            if (r7 == 0) goto L_0x02bb
            int r8 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r7 = r7.getString(r8)
            goto L_0x02bc
        L_0x02bb:
            r7 = r1
        L_0x02bc:
            android.content.Context r8 = r25.getContext()
            if (r8 == 0) goto L_0x02cf
            android.content.res.Resources r8 = r8.getResources()
            if (r8 == 0) goto L_0x02cf
            int r9 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r8 = r8.getString(r9)
            goto L_0x02d0
        L_0x02cf:
            r8 = r1
        L_0x02d0:
            net.one97.paytm.recharge.common.utils.az.a(r2, r4, r6, r7, r8)
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r0.f60964f
            if (r2 == 0) goto L_0x02f1
            androidx.lifecycle.LiveData<net.one97.paytm.common.entity.shopping.CJROffers> r4 = r0.f60962b
            if (r4 == 0) goto L_0x02e7
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.common.entity.shopping.CJROffers r4 = (net.one97.paytm.common.entity.shopping.CJROffers) r4
            if (r4 == 0) goto L_0x02e7
            java.util.ArrayList r1 = r4.getOfferCodes()
        L_0x02e7:
            if (r1 != 0) goto L_0x02ec
            kotlin.g.b.k.a()
        L_0x02ec:
            java.util.List r1 = (java.util.List) r1
            r2.a((java.util.List<? extends net.one97.paytm.common.entity.shopping.CJROfferCode>) r1)
        L_0x02f1:
            net.one97.paytm.recharge.common.c.c$d r1 = r0.l
            if (r1 == 0) goto L_0x02fc
            net.one97.paytm.recharge.common.c.c$b r1 = r1.f60969b
            if (r1 == 0) goto L_0x02fc
            r1.a(r3)
        L_0x02fc:
            int r1 = net.one97.paytm.recharge.R.id.apply_text
            android.view.View r1 = r0.b((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r2 = 8
            r1.setVisibility(r2)
            android.content.Context r1 = r25.getContext()
            int r2 = net.one97.paytm.recharge.R.id.apply_text
            android.view.View r2 = r0.b((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r1, (android.view.View) r2)
            return
        L_0x031c:
            int r3 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r3 = r0.b((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x032e
            int r1 = r3.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x032e:
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0357
            java.lang.String r1 = r0.f60967i
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x034a
            java.lang.String r1 = r0.f60967i
            if (r1 != 0) goto L_0x0345
            kotlin.g.b.k.a()
        L_0x0345:
            java.lang.String r2 = "promocode_field_clicked"
            r0.a(r1, r2, r4)
        L_0x034a:
            int r1 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r1 = r0.b((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0357
            r1.setCursorVisible(r6)
        L_0x0357:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.c.c.onClick(android.view.View):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x003b: MOVE  (r6v7 java.util.Collection) = 
          (r6v6 java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROfferCode>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void onDismiss(android.content.DialogInterface r6) {
        /*
            r5 = this;
            java.lang.String r0 = "dialog"
            kotlin.g.b.k.c(r6, r0)
            int r0 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r0 = r5.b((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0018
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0018
            r0.clear()
        L_0x0018:
            int r0 = net.one97.paytm.recharge.R.id.search_edit_text
            android.view.View r0 = r5.b((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r1 = 0
            if (r0 == 0) goto L_0x0026
            r0.setCursorVisible(r1)
        L_0x0026:
            super.onDismiss(r6)
            androidx.lifecycle.LiveData<net.one97.paytm.common.entity.shopping.CJROffers> r6 = r5.f60962b
            if (r6 == 0) goto L_0x006d
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.common.entity.shopping.CJROffers r6 = (net.one97.paytm.common.entity.shopping.CJROffers) r6
            if (r6 == 0) goto L_0x006d
            java.util.ArrayList r6 = r6.getOfferCodes()
            if (r6 == 0) goto L_0x006d
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x006d
            boolean r0 = r6.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x006d
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r0 = r6.size()
            r2 = 0
        L_0x004e:
            if (r2 >= r0) goto L_0x006d
            java.lang.Object r3 = r6.get(r2)
            java.lang.String r4 = "offerCodes[i]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROfferCode r3 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r3
            r3.setExpanded(r1)
            java.lang.Object r3 = r6.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROfferCode r3 = (net.one97.paytm.common.entity.shopping.CJROfferCode) r3
            r3.setIsOfferApplied(r1)
            int r2 = r2 + 1
            goto L_0x004e
        L_0x006d:
            net.one97.paytm.recharge.common.c.c$d r6 = r5.l
            if (r6 == 0) goto L_0x0078
            net.one97.paytm.recharge.common.c.c$b r6 = r6.f60969b
            if (r6 == 0) goto L_0x0078
            r6.d()
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.c.c.onDismiss(android.content.DialogInterface):void");
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.apply_container);
        k.a((Object) relativeLayout, "apply_container");
        relativeLayout.setVisibility(8);
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        CJRPromosViewV8 cJRPromosViewV8;
        if (charSequence == null || p.a(charSequence)) {
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.apply_container);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            CJRPromosViewV8.b bVar = this.m;
            if (bVar != null) {
                CJROffers cJROffers = this.f60963e;
                if (cJROffers == null) {
                    k.a();
                }
                ArrayList<CJROfferCode> offerCodes = cJROffers.getOfferCodes();
                k.a((Object) offerCodes, "dealsPromoList!!.offerCodes");
                bVar.a((List<CJROfferCode>) offerCodes);
            }
            CJRPromosViewV8.b bVar2 = this.m;
            if (!(bVar2 == null || (cJRPromosViewV8 = this.f60964f) == null)) {
                k.c(bVar2, "option");
                List<CJROfferCode> list = bVar2.f61917g;
                if (list != null) {
                    l lVar = cJRPromosViewV8.f61908e;
                    if (lVar == null) {
                        k.a("adapter");
                    }
                    lVar.a((List<? extends CJROfferCode>) list);
                }
            }
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) b(R.id.apply_container);
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            TextView textView = (TextView) b(R.id.apply_text);
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        ProgressBar progressBar = (ProgressBar) b(R.id.apply_progress_bar);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        TextView textView2 = (TextView) b(R.id.paste_promo_error);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) b(R.id.paste_promo_error);
        if (textView3 != null) {
            textView3.setText("");
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        String f60968a = "";

        /* renamed from: b  reason: collision with root package name */
        public b f60969b;

        /* renamed from: c  reason: collision with root package name */
        public LiveData<CJROffers> f60970c;

        /* renamed from: d  reason: collision with root package name */
        public s f60971d;

        /* renamed from: e  reason: collision with root package name */
        public C1181c f60972e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60973f;

        public final d a(String str) {
            k.c(str, "title");
            this.f60968a = str;
            return this;
        }

        public final d a(b bVar) {
            k.c(bVar, "listener");
            this.f60969b = bVar;
            return this;
        }
    }

    public final void b() {
        ProgressBar progressBar = (ProgressBar) b(R.id.apply_progress_bar);
        if (progressBar != null) {
            ai.b(progressBar);
        }
        TextView textView = (TextView) b(R.id.apply_text);
        if (textView != null) {
            ai.a(textView);
        }
        this.f60961a = false;
    }

    public final void a(int i2) {
        FrameLayout frameLayout = (FrameLayout) b(R.id.dummy_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(i2);
        }
    }

    private void a(String str, String str2, String str3) {
        k.c(str, "event_category");
        k.c(str2, "action");
        k.c(str3, "event_label");
        try {
            HashMap hashMap = new HashMap();
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            hashMap.put("event_category", c.a.i(str));
            hashMap.put("event_action", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/metro/coupon");
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("event_label", str3);
            }
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public final void onDestroy() {
        if (((EditText) b(R.id.search_edit_text)) != null) {
            ((EditText) b(R.id.search_edit_text)).removeTextChangedListener(this);
        }
        super.onDestroy();
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a().a((Fragment) this);
            if (a2 != null) {
                a2.b();
            }
            super.show(jVar, str);
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void a(c cVar, CJRRechargeCart cJRRechargeCart, CJROfferCode cJROfferCode, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        CJRCart cart;
        b bVar;
        c cVar2 = cVar;
        CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        Object obj2 = obj;
        String str = null;
        if ((cJRRechargeCart2 != null ? cJRRechargeCart.getCart() : null) != null) {
            cVar2.f60961a = false;
            az azVar = az.f61525a;
            Bundle a2 = az.a(cVar.getContext(), cJRRechargeCart2, false, false);
            if (a2.getBoolean("extra.has.error")) {
                ProgressBar progressBar = (ProgressBar) cVar2.b(R.id.apply_progress_bar);
                k.a((Object) progressBar, "apply_progress_bar");
                progressBar.setVisibility(8);
                TextView textView = (TextView) cVar2.b(R.id.apply_text);
                k.a((Object) textView, "apply_text");
                textView.setVisibility(0);
                if (cVar.getContext() instanceof Activity) {
                    Context context = cVar.getContext();
                    if (context == null) {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    } else if (!((Activity) context).isFinishing() && !cVar.isDetached() && cVar.isAdded()) {
                        String string = a2.getString("extra.error.title");
                        String string2 = a2.getString("extra.error.msg");
                        if (obj2 instanceof CJRRechargeErrorModel) {
                            CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                            ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                            CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                            if (flowName != null) {
                                str = flowName.getActionType();
                            }
                            cJRRechargeErrorModel = cJRRechargeErrorModel2;
                            action_type = companion.getActionType(str, ACTION_TYPE.PROMO_VERIFY);
                        } else {
                            action_type = null;
                            cJRRechargeErrorModel = null;
                        }
                        az azVar2 = az.f61525a;
                        az.a(cVar.getContext(), ERROR_TYPE.UNDEFINED, action_type, string, string2, false, cJRRechargeErrorModel, false, 1504);
                    }
                }
            } else if (cVar2.n) {
                cVar2.n = false;
                CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                if (cartStatus != null) {
                    str = cartStatus.getResult();
                }
                if (!(!p.a(str, "SUCCESS", true) || (cart = cJRRechargeCart.getCart()) == null || cJROfferCode == null || cVar2.f60966h || cart.getPromoFailureText() == null)) {
                    d dVar = cVar2.l;
                    if (!(dVar == null || (bVar = dVar.f60969b) == null)) {
                        String promoFailureText = cart.getPromoFailureText();
                        k.a((Object) promoFailureText, "cart.promoFailureText");
                        bVar.b(promoFailureText);
                    }
                    d dVar2 = cVar2.l;
                    if (dVar2 != null && dVar2.f60973f) {
                        try {
                            net.one97.paytm.recharge.ordersummary.h.d dVar3 = cVar2.j;
                            if (dVar3 != null) {
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar3, cVar2.k, "apply_promocode_failed", "", cJROfferCode.getCode() + "/" + cart.getPromoFailureText(), (Object) null, (Object) null, (Object) null, 112);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    TextView textView2 = (TextView) cVar2.b(R.id.paste_promo_error);
                    k.a((Object) textView2, "paste_promo_error");
                    textView2.setVisibility(0);
                    TextView textView3 = (TextView) cVar2.b(R.id.paste_promo_error);
                    k.a((Object) textView3, "paste_promo_error");
                    textView3.setText(cart.getPromoFailureText());
                    ProgressBar progressBar2 = (ProgressBar) cVar2.b(R.id.apply_progress_bar);
                    k.a((Object) progressBar2, "apply_progress_bar");
                    progressBar2.setVisibility(8);
                    if (obj2 instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel3 = (CJRRechargeErrorModel) obj2;
                        cJRRechargeErrorModel3.setErrorMsg(cart.getPromoFailureText());
                        az azVar3 = az.f61525a;
                        az.a(cJRRechargeErrorModel3);
                    }
                }
            }
            FrameLayout frameLayout = (FrameLayout) cVar2.b(R.id.dummy_container);
            if (frameLayout != null) {
                ai.b(frameLayout);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

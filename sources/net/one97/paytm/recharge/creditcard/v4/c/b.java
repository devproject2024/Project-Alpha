package net.one97.paytm.recharge.creditcard.v4.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.y;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.a;
import net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class b extends Fragment implements View.OnClickListener, ai, net.one97.paytm.recharge.creditcard.v4.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f62581b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String w;

    /* renamed from: a  reason: collision with root package name */
    String f62582a = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f62583c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f62584d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f62585e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRCreditCardModelV8 f62586f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRAggsItem f62587g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public List<CJRProductsItem> f62588h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f62589i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    private boolean n;
    private net.one97.paytm.recharge.creditcard.c.a o;
    /* access modifiers changed from: private */
    public String p = "";
    /* access modifiers changed from: private */
    public int q = 19;
    /* access modifiers changed from: private */
    public String r = "";
    private t s;
    private boolean t;
    private final View.OnClickListener u = new f(this);
    private final C1210b v = new C1210b(this);
    private HashMap x;

    public final View a(int i2) {
        if (this.x == null) {
            this.x = new HashMap();
        }
        View view = (View) this.x.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.x.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        c(b bVar) {
            super(3, bVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((b) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        d(b bVar) {
            super(1, bVar);
        }

        public final String getName() {
            return "performInstuction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "performInstuction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            b.a((b) this.receiver, cJRInstruct);
        }
    }

    static final /* synthetic */ class e extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        e(b bVar) {
            super(3, bVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((b) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class g extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        g(b bVar) {
            super(3, bVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((b) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class h extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        h(b bVar) {
            super(1, bVar);
        }

        public final String getName() {
            return "performInstuction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "performInstuction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            b.a((b) this.receiver, cJRInstruct);
        }
    }

    static final /* synthetic */ class i extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        i(b bVar) {
            super(3, bVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((b) this.receiver).a(str, networkCustomError, obj);
        }
    }

    public static final /* synthetic */ t a(b bVar) {
        t tVar = bVar.s;
        if (tVar == null) {
            kotlin.g.b.k.a("mKeyboardUtil");
        }
        return tVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String name = b.class.getName();
        kotlin.g.b.k.a((Object) name, "FJRNewCreditCardFragmentV4::class.java.name");
        w = name;
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            kotlin.g.b.k.a((Object) activity, "this");
            this.s = new t(activity);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.t = arguments.getBoolean("IS_IN_TABS", false);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Locale locale = Locale.getDefault();
            kotlin.g.b.k.a((Object) locale, "Locale.getDefault()");
            String lowerCase = "/onus_credit_card/enter_cc_number".toLowerCase(locale);
            kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), lowerCase);
        } catch (Throwable unused) {
        }
        return layoutInflater.inflate(R.layout.v4_fragment_new_credit_card_layout, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        net.one97.paytm.recharge.creditcard.c.a aVar;
        super.onActivityCreated(bundle);
        ActionBar actionBar = null;
        if (getActivity() instanceof AJRNewCardActivityV4) {
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            if (net.one97.paytm.recharge.common.utils.y.k() == null) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                net.one97.paytm.recharge.common.utils.y yVar2 = net.one97.paytm.recharge.common.utils.y.f61814b;
                this.o = net.one97.paytm.recharge.common.utils.y.k();
                net.one97.paytm.recharge.creditcard.c.a aVar2 = this.o;
                if (aVar2 != null) {
                    b bVar = this;
                    aVar2.a((kotlin.k.e<x>) new c(bVar));
                    net.one97.paytm.recharge.common.utils.ai.a(this, aVar2.f61408a, new d(bVar));
                    w wVar = aVar2.t;
                    if (wVar != null) {
                        wVar.f61788h = new e(bVar);
                    }
                }
            }
        } else {
            try {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    this.o = (net.one97.paytm.recharge.creditcard.c.a) new al(activity2).a(net.one97.paytm.recharge.creditcard.c.a.class);
                }
            } catch (Exception unused) {
                if (getParentFragment() instanceof c) {
                    Fragment parentFragment = getParentFragment();
                    if (parentFragment != null) {
                        c cVar = (c) parentFragment;
                        if (cVar.getParentFragment() instanceof net.one97.paytm.recharge.creditcard.b.a) {
                            Fragment parentFragment2 = cVar.getParentFragment();
                            if (parentFragment2 != null) {
                                aVar = ((net.one97.paytm.recharge.creditcard.b.a) parentFragment2).f62401a;
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
                            }
                        } else {
                            aVar = null;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.v4.fragment.FJRSavedCardsFragmentV4");
                    }
                } else {
                    Fragment parentFragment3 = getParentFragment();
                    if (parentFragment3 != null) {
                        aVar = ((net.one97.paytm.recharge.creditcard.b.a) parentFragment3).f62401a;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
                    }
                }
                this.o = aVar;
            }
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setOnClickListener(this);
        }
        if (!this.t) {
            if (getActivity() instanceof net.one97.paytm.recharge.common.e.y) {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity3).i();
                    FragmentActivity activity4 = getActivity();
                    if (activity4 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity4).e();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
            if (getActivity() instanceof AppCompatActivity) {
                FragmentActivity activity5 = getActivity();
                if (!(activity5 instanceof AppCompatActivity)) {
                    activity5 = null;
                }
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity5;
                if (appCompatActivity != null) {
                    appCompatActivity.setSupportActionBar((Toolbar) a(R.id.toolbar));
                }
                FragmentActivity activity6 = getActivity();
                if (!(activity6 instanceof AppCompatActivity)) {
                    activity6 = null;
                }
                AppCompatActivity appCompatActivity2 = (AppCompatActivity) activity6;
                if (appCompatActivity2 != null) {
                    actionBar = appCompatActivity2.getSupportActionBar();
                }
                if (actionBar != null) {
                    actionBar.b(true);
                    actionBar.a((CharSequence) "");
                }
            }
            AppBarLayout appBarLayout = (AppBarLayout) a(R.id.app_bar_layout);
            if (appBarLayout != null) {
                appBarLayout.setVisibility(0);
            }
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) a(R.id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                collapsingToolbarLayout.setTitle(getString(R.string.v4_cc_enter_card_title));
            }
        } else {
            AppBarLayout appBarLayout2 = (AppBarLayout) a(R.id.app_bar_layout);
            if (appBarLayout2 != null) {
                appBarLayout2.setVisibility(4);
            }
            if (getActivity() instanceof net.one97.paytm.recharge.common.e.y) {
                FragmentActivity activity7 = getActivity();
                if (activity7 != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity7).b(getString(R.string.enter_card_number));
                    FragmentActivity activity8 = getActivity();
                    if (activity8 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity8).az_();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
        }
        EditText editText = (EditText) a(R.id.bottmFocusEt);
        if (editText != null) {
            editText.setInputType(8194);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        EditText editText = (EditText) a(R.id.etCreditCard);
        if (editText != null) {
            editText.requestFocus();
        }
        EditText editText2 = (EditText) a(R.id.etCreditCard);
        if (editText2 != null) {
            editText2.setInputType(2);
        }
        EditText editText3 = (EditText) a(R.id.etCreditCard);
        if (editText3 != null) {
            editText3.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        }
        Context activity = getActivity();
        EditText editText4 = (EditText) a(R.id.etCreditCard);
        if (editText4 != null) {
            ba.b(activity, (View) editText4);
            EditText editText5 = (EditText) a(R.id.etCreditCard);
            if (editText5 != null) {
                editText5.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.q)});
            }
            TextView textView = (TextView) a(R.id.etCreditCardHint);
            if (textView != null) {
                textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.q)});
            }
            ((EditText) a(R.id.etCreditCard)).addTextChangedListener(this.v);
            ((EditText) a(R.id.etCreditCard)).setOnClickListener(this.u);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final void onDestroyView() {
        CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: onDestroyView");
        super.onDestroyView();
        HashMap hashMap = this.x;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1517120432) {
                if (hashCode != 262142210 || !str.equals("get_pf_credit_card_verify")) {
                    return;
                }
            } else if (!str.equals("get_pf_credit_card_token")) {
                return;
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel.setExtraObj((Object) null);
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    flowName.setTag(str);
                }
            }
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62598a;

        f(b bVar) {
            this.f62598a = bVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "view");
            view.setFocusableInTouchMode(true);
            view.setFocusable(true);
            if (this.f62598a.getActivity() != null) {
                Context activity = this.f62598a.getActivity();
                EditText editText = (EditText) this.f62598a.a(R.id.etCreditCard);
                if (editText != null) {
                    ba.b(activity, (View) editText);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            }
        }
    }

    /* access modifiers changed from: private */
    public final SpannableString a(String str, String str2, boolean z) {
        if (str == null || str2 == null || getContext() == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(!z ? str : this.r);
        if (str2.length() <= spannableString.length()) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, !z ? R.color.white : R.color.transparent)), 0, str2.length(), 18);
        }
        if (str2.length() < spannableString.length() && str.length() <= spannableString.length()) {
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context2, !z ? R.color.transparent : R.color.color_DDE5ED)), str2.length(), str.length(), 18);
        }
        return spannableString;
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.c.b$b  reason: collision with other inner class name */
    public static final class C1210b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62590a;

        /* renamed from: b  reason: collision with root package name */
        private int f62591b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62592c;

        /* renamed from: d  reason: collision with root package name */
        private String f62593d = "";

        /* renamed from: e  reason: collision with root package name */
        private int f62594e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f62595f;

        /* renamed from: g  reason: collision with root package name */
        private int f62596g;

        C1210b(b bVar) {
            this.f62590a = bVar;
        }

        /* JADX WARNING: type inference failed for: r8v4, types: [android.text.Editable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                java.lang.String r2 = "etCreditCard"
                java.lang.String r3 = "s"
                kotlin.g.b.k.c(r1, r3)
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r4 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r3 = r3.a((int) r4)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3
                r4 = 1
                if (r3 == 0) goto L_0x0040
                boolean r3 = r3.isEnabled()
                if (r3 != 0) goto L_0x0040
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r3 = r3.a((int) r5)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3
                java.lang.String r5 = "btn_proceed"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                r3.setEnabled(r4)
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r6 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r3 = r3.a((int) r6)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                r3.setClickable(r4)
            L_0x0040:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r5)
                android.widget.EditText r3 = (android.widget.EditText) r3
                if (r3 == 0) goto L_0x0052
                r5 = r0
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r3.removeTextChangedListener(r5)
            L_0x0052:
                r3 = r1
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                kotlin.m.l r5 = new kotlin.m.l
                java.lang.String r6 = "^\\s+"
                r5.<init>((java.lang.String) r6)
                java.lang.String r6 = ""
                java.lang.String r3 = r5.replace((java.lang.CharSequence) r3, (java.lang.String) r6)
                r18.clear()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.append(r3)
                if (r1 == 0) goto L_0x0072
                java.lang.String r3 = r18.toString()
                if (r3 != 0) goto L_0x0073
            L_0x0072:
                r3 = r6
            L_0x0073:
                int r3 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r3)
                r0.f62594e = r3
                boolean r3 = r0.f62592c
                r5 = 5
                r7 = 4
                r8 = 0
                if (r3 != 0) goto L_0x00c5
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r9 = r0.f62594e
                if (r9 == r7) goto L_0x00b0
                if (r9 == r5) goto L_0x009d
                android.content.Context r9 = r3.getContext()
                if (r9 == 0) goto L_0x009b
                android.content.res.Resources r9 = r9.getResources()
                if (r9 == 0) goto L_0x009b
                int r10 = net.one97.paytm.recharge.R.string.default_placeholder
                java.lang.String r9 = r9.getString(r10)
                goto L_0x00c2
            L_0x009b:
                r9 = r8
                goto L_0x00c2
            L_0x009d:
                android.content.Context r9 = r3.getContext()
                if (r9 == 0) goto L_0x009b
                android.content.res.Resources r9 = r9.getResources()
                if (r9 == 0) goto L_0x009b
                int r10 = net.one97.paytm.recharge.R.string.diners
                java.lang.String r9 = r9.getString(r10)
                goto L_0x00c2
            L_0x00b0:
                android.content.Context r9 = r3.getContext()
                if (r9 == 0) goto L_0x009b
                android.content.res.Resources r9 = r9.getResources()
                if (r9 == 0) goto L_0x009b
                int r10 = net.one97.paytm.recharge.R.string.amex
                java.lang.String r9 = r9.getString(r10)
            L_0x00c2:
                r3.f62583c = r9
            L_0x00c5:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r3 = r3.f62583c
                if (r3 == 0) goto L_0x00d2
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                r9.r = r3
            L_0x00d2:
                int r3 = r0.f62594e
                r9 = 16
                java.lang.String r10 = "RechargeUtils.formatText…Card(editable.toString())"
                r11 = 2
                r12 = 19
                if (r3 == r4) goto L_0x0132
                if (r3 == r11) goto L_0x0132
                r13 = 3
                if (r3 == r13) goto L_0x0132
                java.lang.String r13 = "RechargeUtils.formatTextAmEx(editable.toString())"
                if (r3 == r7) goto L_0x0118
                if (r3 == r5) goto L_0x0100
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.q = r12
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r5 = java.lang.String.valueOf(r18)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.CharSequence) r5)
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
                r3.a((java.lang.String) r5)
                goto L_0x0149
            L_0x0100:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.q = r9
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r5 = java.lang.String.valueOf(r18)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.CharSequence) r5)
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
                r3.a((java.lang.String) r5)
                goto L_0x0149
            L_0x0118:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r5 = 17
                r3.q = r5
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r5 = java.lang.String.valueOf(r18)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.CharSequence) r5)
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
                r3.a((java.lang.String) r5)
                goto L_0x0149
            L_0x0132:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.q = r12
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r5 = java.lang.String.valueOf(r18)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.CharSequence) r5)
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
                r3.a((java.lang.String) r5)
            L_0x0149:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r5 = r3.f62582a
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a
                java.lang.String r10 = r10.f62583c
                java.lang.String r13 = "null cannot be cast to non-null type java.lang.String"
                if (r10 == 0) goto L_0x0169
                if (r10 == 0) goto L_0x0163
                char[] r10 = r10.toCharArray()
                java.lang.String r14 = "(this as java.lang.String).toCharArray()"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r14)
                goto L_0x016a
            L_0x0163:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r13)
                throw r1
            L_0x0169:
                r10 = r8
            L_0x016a:
                net.one97.paytm.recharge.creditcard.v4.c.b r14 = r0.f62590a
                java.lang.String r14 = r14.f62583c
                r15 = 0
                if (r14 == 0) goto L_0x0178
                int r14 = r14.length()
                goto L_0x0179
            L_0x0178:
                r14 = 0
            L_0x0179:
                int r9 = r5.length()
                if (r14 <= r9) goto L_0x0184
                int r9 = r5.length()
                goto L_0x0193
            L_0x0184:
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                java.lang.String r9 = r9.f62583c
                if (r9 == 0) goto L_0x0191
                int r9 = r9.length()
                goto L_0x0193
            L_0x0191:
                r9 = 16
            L_0x0193:
                if (r10 == 0) goto L_0x01ab
                r14 = 0
            L_0x0196:
                if (r14 >= r9) goto L_0x01a1
                char r16 = r5.charAt(r14)
                r10[r14] = r16
                int r14 = r14 + 1
                goto L_0x0196
            L_0x01a1:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r9 = new java.lang.String
                r9.<init>(r10)
                r5.f62583c = r9
            L_0x01ab:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                r3.f62583c = r5
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r3 = r3.f62583c
                if (r3 == 0) goto L_0x0203
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x01e4
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                java.lang.String r9 = r9.f62582a
                android.text.SpannableString r5 = r0.a(r5, r9, r15)
                if (r5 == 0) goto L_0x01d9
                goto L_0x01df
            L_0x01d9:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
            L_0x01df:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x01e4:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.overlayHintTextTV
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0203
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                java.lang.String r9 = r9.f62582a
                android.text.SpannableString r5 = r0.a(r5, r9, r4)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x0203:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r5)
                android.widget.EditText r3 = (android.widget.EditText) r3
                if (r3 == 0) goto L_0x0223
                android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r9 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a
                int r10 = r10.q
                r9.<init>(r10)
                android.text.InputFilter r9 = (android.text.InputFilter) r9
                r5[r15] = r9
                r3.setFilters(r5)
            L_0x0223:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0243
                android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r9 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a
                int r10 = r10.q
                r9.<init>(r10)
                android.text.InputFilter r9 = (android.text.InputFilter) r9
                r5[r15] = r9
                r3.setFilters(r5)
            L_0x0243:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r3 = r3.f62582a
                int r3 = r3.length()
                if (r3 >= r11) goto L_0x02d9
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.q = r12
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r5)
                android.widget.EditText r3 = (android.widget.EditText) r3
                if (r3 == 0) goto L_0x0272
                android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r9 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a
                int r10 = r10.q
                r9.<init>(r10)
                android.text.InputFilter r9 = (android.text.InputFilter) r9
                r5[r15] = r9
                r3.setFilters(r5)
            L_0x0272:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0292
                android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r9 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a
                int r10 = r10.q
                r9.<init>(r10)
                android.text.InputFilter r9 = (android.text.InputFilter) r9
                r5[r15] = r9
                r3.setFilters(r5)
            L_0x0292:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x02ba
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                java.lang.String r9 = r9.f62582a
                android.text.SpannableString r5 = r0.a(r5, r9, r15)
                if (r5 == 0) goto L_0x02af
                goto L_0x02b5
            L_0x02af:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
            L_0x02b5:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x02ba:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.overlayHintTextTV
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x02d9
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                java.lang.String r9 = r9.f62582a
                android.text.SpannableString r5 = r0.a(r5, r9, r4)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x02d9:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r3 = r3.f62582a
                r18.clear()
                r5 = r3
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.append(r5)
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                int r10 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r9 = r9.a((int) r10)
                android.widget.EditText r9 = (android.widget.EditText) r9
                if (r9 == 0) goto L_0x02fc
                net.one97.paytm.recharge.creditcard.v4.c.b$b$a r10 = new net.one97.paytm.recharge.creditcard.v4.c.b$b$a
                r10.<init>(r0)
                android.view.View$OnKeyListener r10 = (android.view.View.OnKeyListener) r10
                r9.setOnKeyListener(r10)
            L_0x02fc:
                java.lang.String r9 = r0.f62593d
                int r10 = r0.f62596g
                int r11 = r9.length()
                if (r9 == 0) goto L_0x0675
                java.lang.String r9 = r9.substring(r10, r11)
                java.lang.String r10 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
                int r9 = a(r9)
                int r9 = r0.a((int) r9, (java.lang.String) r3)
                net.one97.paytm.recharge.creditcard.v4.c.b r10 = r0.f62590a     // Catch:{ Exception -> 0x0327 }
                int r11 = net.one97.paytm.recharge.R.id.etCreditCard     // Catch:{ Exception -> 0x0327 }
                android.view.View r10 = r10.a((int) r11)     // Catch:{ Exception -> 0x0327 }
                android.widget.EditText r10 = (android.widget.EditText) r10     // Catch:{ Exception -> 0x0327 }
                if (r10 == 0) goto L_0x036d
                r10.setSelection(r9)     // Catch:{ Exception -> 0x0327 }
                goto L_0x036d
            L_0x0327:
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r0.f62590a
                int r10 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r9 = r9.a((int) r10)
                android.widget.EditText r9 = (android.widget.EditText) r9
                if (r9 == 0) goto L_0x0337
                r9.setText(r5)
            L_0x0337:
                int r5 = r3.length()
                if (r5 < 0) goto L_0x0342
                int r3 = r3.length()
                goto L_0x0343
            L_0x0342:
                r3 = 0
            L_0x0343:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                int r9 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r5 = r5.a((int) r9)
                android.widget.EditText r5 = (android.widget.EditText) r5
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
                android.text.Editable r5 = r5.getText()
                java.lang.String r5 = r5.toString()
                int r5 = r5.length()
                if (r3 >= r5) goto L_0x036d
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                int r9 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r5 = r5.a((int) r9)
                android.widget.EditText r5 = (android.widget.EditText) r5
                if (r5 == 0) goto L_0x036d
                r5.setSelection(r3)
            L_0x036d:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r5)
                android.widget.EditText r3 = (android.widget.EditText) r3
                if (r3 == 0) goto L_0x037f
                r5 = r0
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r3.addTextChangedListener(r5)
            L_0x037f:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r5)
                android.widget.EditText r3 = (android.widget.EditText) r3
                r5 = 7
                if (r3 == 0) goto L_0x043d
                android.text.Editable r3 = r3.getText()
                if (r3 == 0) goto L_0x043d
                int r3 = r3.length()
                if (r3 != r5) goto L_0x043d
                int r2 = r18.length()
                int r3 = r0.f62591b
                if (r2 >= r3) goto L_0x03a1
                return
            L_0x03a1:
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                boolean r2 = r2.k
                if (r2 == 0) goto L_0x03b2
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                boolean r2 = r2.j
                if (r2 == 0) goto L_0x03b2
                return
            L_0x03b2:
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                android.content.Context r2 = r2.getContext()
                boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
                if (r2 == 0) goto L_0x040a
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                r2.j = r4
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                r2.l = r4
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                java.lang.String r3 = r18.toString()
                r2.p = r3
                net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                r2.setErrorType(r3)
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
                if (r3 == 0) goto L_0x03eb
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                java.lang.String r4 = r4.name()
                r3.setErrorType(r4)
            L_0x03eb:
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
                if (r3 == 0) goto L_0x03fa
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                java.lang.String r4 = r4.name()
                r3.setActionType(r4)
            L_0x03fa:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.lang.String r1 = r18.toString()
                java.lang.String r4 = " "
                java.lang.String r1 = kotlin.m.p.a(r1, r4, r6, r15)
                net.one97.paytm.recharge.creditcard.v4.c.b.a((net.one97.paytm.recharge.creditcard.v4.c.b) r3, (java.lang.String) r1, (java.lang.Object) r2)
                return
            L_0x040a:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                r1.f62589i = r4
                net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                android.content.Context r1 = r1.getContext()
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r0.f62590a
                android.content.Context r4 = r4.getContext()
                if (r4 == 0) goto L_0x042a
                int r5 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r4 = r4.getString(r5)
                goto L_0x042b
            L_0x042a:
                r4 = r8
            L_0x042b:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                android.content.Context r5 = r5.getContext()
                if (r5 == 0) goto L_0x0439
                int r6 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r8 = r5.getString(r6)
            L_0x0439:
                net.one97.paytm.recharge.common.utils.az.a(r1, r2, r3, r4, r8)
                return
            L_0x043d:
                int r3 = r18.length()
                if (r3 >= r5) goto L_0x0577
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.k = r15
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.l = r15
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.f62587g = null
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                r3.f62586f = null
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                java.util.List r3 = r3.f62588h
                if (r3 == 0) goto L_0x0462
                r3.clear()
            L_0x0462:
                net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.cardBgIV
                android.view.View r3 = r3.a((int) r5)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                java.lang.String r5 = "cardBgIV"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                net.one97.paytm.recharge.common.utils.az.a((android.widget.ImageView) r3, (java.lang.String) r8)
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.img_bank
                android.view.View r3 = r3.a((int) r5)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                if (r3 == 0) goto L_0x0485
                r3.setVisibility(r7)
            L_0x0485:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.cardtypeView
                android.view.View r3 = r3.a((int) r5)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                if (r3 == 0) goto L_0x0494
                r3.setVisibility(r7)
            L_0x0494:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.bankImagePlaceHolderView
                android.view.View r3 = r3.a((int) r5)
                if (r3 == 0) goto L_0x04a1
                r3.setVisibility(r15)
            L_0x04a1:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.fallbackBankNameTV
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x04b2
                android.view.View r3 = (android.view.View) r3
                net.one97.paytm.recharge.common.utils.ai.b(r3)
            L_0x04b2:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.cardTypePlaceHolderView
                android.view.View r3 = r3.a((int) r5)
                if (r3 == 0) goto L_0x04bf
                r3.setVisibility(r15)
            L_0x04bf:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x04e7
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                java.lang.String r6 = r18.toString()
                android.text.SpannableString r5 = r0.a(r5, r6, r15)
                if (r5 == 0) goto L_0x04dc
                goto L_0x04e2
            L_0x04dc:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
            L_0x04e2:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r3.setText(r5)
            L_0x04e7:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r5 = net.one97.paytm.recharge.R.id.overlayHintTextTV
                android.view.View r3 = r3.a((int) r5)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0506
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                java.lang.String r5 = r5.f62583c
                java.lang.String r1 = r18.toString()
                android.text.SpannableString r1 = r0.a(r5, r1, r4)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r3.setText(r1)
            L_0x0506:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r3 = net.one97.paytm.recharge.R.id.chipPlaceHolderIV
                android.view.View r1 = r1.a((int) r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                if (r1 == 0) goto L_0x0515
                r1.setVisibility(r15)
            L_0x0515:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r3 = net.one97.paytm.recharge.R.id.chipIV
                android.view.View r1 = r1.a((int) r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                if (r1 == 0) goto L_0x0524
                r1.setVisibility(r7)
            L_0x0524:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r3 = net.one97.paytm.recharge.R.id.message_input_field
                android.view.View r1 = r1.a((int) r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0543
                int r1 = r1.getVisibility()
                if (r1 != 0) goto L_0x0543
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r3 = net.one97.paytm.recharge.R.id.message_input_field
                android.view.View r3 = r1.a((int) r3)
                android.widget.TextView r3 = (android.widget.TextView) r3
                r1.a((android.widget.TextView) r3, (java.lang.String) null)
            L_0x0543:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0576
                net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r3 = r3.a((int) r4)
                android.widget.EditText r3 = (android.widget.EditText) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
                int r2 = net.one97.paytm.recharge.R.color.color_00b9f5_re
                int r2 = androidx.core.content.b.c(r1, r2)
                net.one97.paytm.recharge.common.utils.az.a((android.widget.EditText) r3, (int) r2)
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                int r3 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r2.a((int) r3)
                android.widget.EditText r2 = (android.widget.EditText) r2
                int r3 = net.one97.paytm.recharge.R.color.color_1d2f54
                int r1 = androidx.core.content.b.c(r1, r3)
                r2.setTextColor(r1)
            L_0x0576:
                return
            L_0x0577:
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                boolean r2 = r2.k
                if (r2 != 0) goto L_0x0595
                int r2 = r18.length()
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                int r3 = r3.q
                if (r2 < r3) goto L_0x0595
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                java.lang.String r1 = r18.toString()
                r2.b((java.lang.String) r1)
                return
            L_0x0595:
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                boolean r2 = r2.j
                if (r2 != 0) goto L_0x0674
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                android.content.Context r2 = r2.getContext()
                boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
                if (r2 == 0) goto L_0x063a
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                boolean r2 = r2.l
                if (r2 != 0) goto L_0x0600
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                r2.j = r4
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                java.lang.String r3 = r18.toString()
                r2.p = r3
                net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                r2.setErrorType(r3)
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
                if (r3 == 0) goto L_0x05d9
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                java.lang.String r4 = r4.name()
                r3.setErrorType(r4)
            L_0x05d9:
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
                if (r3 == 0) goto L_0x05e8
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                java.lang.String r4 = r4.name()
                r3.setActionType(r4)
            L_0x05e8:
                net.one97.paytm.recharge.creditcard.v4.c.b r3 = r0.f62590a
                android.content.Context r4 = r3.getContext()
                if (r4 != 0) goto L_0x05f3
                kotlin.g.b.k.a()
            L_0x05f3:
                java.lang.String r5 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                java.lang.String r1 = r18.toString()
                net.one97.paytm.recharge.creditcard.v4.c.b.a((net.one97.paytm.recharge.creditcard.v4.c.b) r3, (android.content.Context) r4, (java.lang.String) r1, (java.lang.Object) r2)
                return
            L_0x0600:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r2 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r1 = r1.a((int) r2)
                android.widget.EditText r1 = (android.widget.EditText) r1
                if (r1 == 0) goto L_0x0611
                android.text.Editable r1 = r1.getText()
                goto L_0x0612
            L_0x0611:
                r1 = r8
            L_0x0612:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                int r1 = r1.length()
                net.one97.paytm.recharge.creditcard.v4.c.b r2 = r0.f62590a
                int r2 = r2.q
                if (r1 != r2) goto L_0x0639
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                int r2 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r1.a((int) r2)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x0632
                android.text.Editable r8 = r2.getText()
            L_0x0632:
                java.lang.String r2 = java.lang.String.valueOf(r8)
                r1.b((java.lang.String) r2)
            L_0x0639:
                return
            L_0x063a:
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                boolean r1 = r1.f62589i
                if (r1 != 0) goto L_0x0674
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                r1.f62589i = r4
                net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.v4.c.b r1 = r0.f62590a
                android.content.Context r1 = r1.getContext()
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r0.f62590a
                android.content.Context r4 = r4.getContext()
                if (r4 == 0) goto L_0x0662
                int r5 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r4 = r4.getString(r5)
                goto L_0x0663
            L_0x0662:
                r4 = r8
            L_0x0663:
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r0.f62590a
                android.content.Context r5 = r5.getContext()
                if (r5 == 0) goto L_0x0671
                int r6 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r8 = r5.getString(r6)
            L_0x0671:
                net.one97.paytm.recharge.common.utils.az.a(r1, r2, r3, r4, r8)
            L_0x0674:
                return
            L_0x0675:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r13)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.C1210b.afterTextChanged(android.text.Editable):void");
        }

        /* renamed from: net.one97.paytm.recharge.creditcard.v4.c.b$b$a */
        static final class a implements View.OnKeyListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1210b f62597a;

            a(C1210b bVar) {
                this.f62597a = bVar;
            }

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                this.f62597a.f62595f = i2 == 67 ? 1 : 0;
                return false;
            }
        }

        private SpannableString a(String str, String str2, boolean z) {
            if (str == null || str2 == null || this.f62590a.getContext() == null) {
                return null;
            }
            if (this.f62590a.f62587g != null) {
                return this.f62590a.a(str, str2, z);
            }
            SpannableString spannableString = new SpannableString(!z ? str : this.f62590a.r);
            if (str2.length() <= spannableString.length()) {
                Context context = this.f62590a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, !z ? R.color.color_1D2F54 : R.color.transparent)), 0, str2.length(), 18);
            }
            if (str2.length() < spannableString.length() && str.length() <= spannableString.length()) {
                Context context2 = this.f62590a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context2, !z ? R.color.transparent : R.color.color_DDE5ED)), str2.length(), str.length(), 18);
            }
            return spannableString;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
            if (r0 == 15) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
            if (r0 == 14) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008d, code lost:
            if (r0 == 12) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0096, code lost:
            if (r0 == 11) goto L_0x0098;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int a(int r9, java.lang.String r10) {
            /*
                r8 = this;
                if (r10 == 0) goto L_0x00b5
                r0 = r10
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.m.p.h((java.lang.CharSequence) r0)
                java.lang.String r0 = r0.toString()
                int r1 = r0.length()
                r2 = 0
                r4 = r9
                r3 = 0
                r5 = 0
            L_0x0015:
                if (r3 >= r1) goto L_0x002e
                char r6 = r0.charAt(r3)
                if (r4 == 0) goto L_0x002e
                boolean r7 = java.lang.Character.isDigit(r6)
                if (r7 != 0) goto L_0x0027
                r7 = 32
                if (r6 != r7) goto L_0x0029
            L_0x0027:
                int r4 = r4 + -1
            L_0x0029:
                int r5 = r5 + 1
                int r3 = r3 + 1
                goto L_0x0015
            L_0x002e:
                int r0 = r10.length()
                int r0 = r0 - r5
                if (r9 == 0) goto L_0x00a3
                java.lang.String r9 = r8.f62593d
                int r9 = b(r9)
                int r10 = b(r10)
                int r9 = r9 - r10
                int r0 = r0 + r9
                int r10 = r8.f62594e
                r1 = 4
                r3 = 5
                r4 = 1
                if (r10 == r1) goto L_0x0076
                if (r10 != r3) goto L_0x004b
                goto L_0x0076
            L_0x004b:
                int r10 = r8.f62595f
                r5 = 15
                r6 = 10
                if (r10 != r4) goto L_0x005c
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 == r6) goto L_0x0082
                if (r0 != r5) goto L_0x005c
                goto L_0x0082
            L_0x005c:
                int r10 = r8.f62595f
                if (r10 != 0) goto L_0x0069
                if (r0 == 0) goto L_0x0098
                if (r0 == r3) goto L_0x0098
                if (r0 == r6) goto L_0x0098
                if (r0 != r5) goto L_0x0069
                goto L_0x0098
            L_0x0069:
                if (r0 == 0) goto L_0x0098
                if (r0 == r1) goto L_0x0098
                r10 = 9
                if (r0 == r10) goto L_0x0098
                r10 = 14
                if (r0 != r10) goto L_0x009a
                goto L_0x0098
            L_0x0076:
                int r10 = r8.f62595f
                r5 = 12
                if (r10 != r4) goto L_0x0085
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 != r5) goto L_0x0085
            L_0x0082:
                int r0 = r0 + -1
                goto L_0x009a
            L_0x0085:
                int r10 = r8.f62595f
                if (r10 != 0) goto L_0x0090
                if (r0 == 0) goto L_0x0098
                if (r0 == r3) goto L_0x0098
                if (r0 != r5) goto L_0x0090
                goto L_0x0098
            L_0x0090:
                if (r0 == 0) goto L_0x0098
                if (r0 == r1) goto L_0x0098
                r10 = 11
                if (r0 != r10) goto L_0x009a
            L_0x0098:
                int r0 = r0 + 1
            L_0x009a:
                if (r9 <= 0) goto L_0x00a3
                if (r0 != r4) goto L_0x00a3
                int r9 = r8.f62596g
                if (r9 != r4) goto L_0x00a3
                r0 = 0
            L_0x00a3:
                if (r0 >= 0) goto L_0x00a6
                r0 = 0
            L_0x00a6:
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r8.f62590a
                int r9 = r9.q
                if (r0 <= r9) goto L_0x00b4
                net.one97.paytm.recharge.creditcard.v4.c.b r9 = r8.f62590a
                int r0 = r9.q
            L_0x00b4:
                return r0
            L_0x00b5:
                kotlin.u r9 = new kotlin.u
                java.lang.String r10 = "null cannot be cast to non-null type kotlin.CharSequence"
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.C1210b.a(int, java.lang.String):int");
        }

        private static int a(String str) {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (Character.isDigit(charAt) || charAt == ' ') {
                    i2++;
                }
            }
            return i2;
        }

        private static int b(String str) {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (str.charAt(i3) == ' ') {
                    i2++;
                }
            }
            return i2;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            CharSequence charSequence2 = null;
            if (i4 >= 2) {
                this.f62590a.f62584d = charSequence != null ? charSequence.toString() : null;
            }
            if (charSequence != null) {
                charSequence2 = charSequence.subSequence(i2, i3 + i2);
            }
            this.f62592c = kotlin.g.b.k.a((Object) " ", (Object) String.valueOf(charSequence2));
            this.f62593d = String.valueOf(charSequence);
            this.f62591b = charSequence != null ? charSequence.length() : 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            r4 = kotlin.m.p.a((r4 = r4.toString()), " ", "", false);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
            /*
                r3 = this;
                int r5 = r5 + r6
                r3.f62596g = r5
                r5 = 2
                if (r7 < r5) goto L_0x00b3
                java.lang.String r6 = ""
                if (r4 == 0) goto L_0x0017
                kotlin.m.l r7 = new kotlin.m.l
                java.lang.String r0 = "^\\s+"
                r7.<init>((java.lang.String) r0)
                java.lang.String r7 = r7.replace((java.lang.CharSequence) r4, (java.lang.String) r6)
                if (r7 != 0) goto L_0x0018
            L_0x0017:
                r7 = r6
            L_0x0018:
                int r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7)
                r3.f62594e = r7
                r7 = 0
                if (r4 == 0) goto L_0x0034
                java.lang.String r4 = r4.toString()
                if (r4 == 0) goto L_0x0034
                java.lang.String r0 = " "
                java.lang.String r4 = kotlin.m.p.a(r4, r0, r6, r7)
                if (r4 == 0) goto L_0x0034
                int r4 = r4.length()
                goto L_0x0035
            L_0x0034:
                r4 = 0
            L_0x0035:
                net.one97.paytm.recharge.creditcard.v4.c.b r0 = r3.f62590a
                int r0 = r0.q
                int r1 = r3.f62594e
                r2 = 4
                if (r1 == r2) goto L_0x0045
                r2 = 5
                if (r1 != r2) goto L_0x0044
                goto L_0x0045
            L_0x0044:
                r5 = 3
            L_0x0045:
                int r0 = r0 - r5
                if (r4 <= r0) goto L_0x00a3
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x005a
                r5 = r3
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r4.removeTextChangedListener(r5)
            L_0x005a:
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x006b
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r4.setText(r6)
            L_0x006b:
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                java.lang.String r4 = r4.f62584d
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x0090
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x0090
                net.one97.paytm.recharge.creditcard.v4.c.b r5 = r3.f62590a
                java.lang.String r5 = r5.f62584d
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r4.append(r5)
            L_0x0090:
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x00a2
                r5 = r3
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r4.addTextChangedListener(r5)
            L_0x00a2:
                return
            L_0x00a3:
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                r4.f62589i = r7
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                r4.j = r7
                net.one97.paytm.recharge.creditcard.v4.c.b r4 = r3.f62590a
                r5 = 1
                r4.k = r5
            L_0x00b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.C1210b.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "<set-?>");
        this.f62582a = str;
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62601a;

        k(b bVar) {
            this.f62601a = bVar;
        }

        public final void run() {
            EditText editText = (EditText) this.f62601a.a(R.id.bottmFocusEt);
            if (editText != null) {
                editText.requestFocus();
            }
            NestedScrollView nestedScrollView = (NestedScrollView) this.f62601a.a(R.id.scroll_view);
            if (nestedScrollView != null) {
                nestedScrollView.a(130);
            }
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62602a;

        l(b bVar) {
            this.f62602a = bVar;
        }

        public final void run() {
            EditText editText = (EditText) this.f62602a.a(R.id.etCreditCard);
            if (editText != null) {
                editText.requestFocus();
            }
            EditText editText2 = (EditText) this.f62602a.a(R.id.etCreditCard);
            if (editText2 != null) {
                EditText editText3 = (EditText) this.f62602a.a(R.id.etCreditCard);
                kotlin.g.b.k.a((Object) editText3, "etCreditCard");
                editText2.setSelection(editText3.getText().toString().length());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(TextView textView, String str) {
        CardView cardView = (CardView) a(R.id.cc_card_view);
        if (cardView != null) {
            cardView.clearAnimation();
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            if (textView != null) {
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                textView.setTextColor(androidx.core.content.b.c(context, R.color.v4_cc_error_color));
            }
            if (textView != null) {
                textView.setText(charSequence);
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.recharge_shake);
            kotlin.g.b.k.a((Object) loadAnimation, "AnimationUtils.loadAnima…t, R.anim.recharge_shake)");
            CardView cardView2 = (CardView) a(R.id.cc_card_view);
            if (cardView2 != null) {
                cardView2.startAnimation(loadAnimation);
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.INLINE_ERROR);
            a2.setErrorMsg(str);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.INLINE_ERROR.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.CC_BIN.name());
            }
            az azVar = az.f61525a;
            az.a(a2);
            new Handler().postDelayed(new k(this), 100);
            new Handler().postDelayed(new l(this), 500);
            return;
        }
        if (textView != null) {
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(context2, R.color.gray));
        }
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            r9.k = r0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r9.f62587g
            r2 = 0
            if (r1 == 0) goto L_0x00ad
            int r1 = r10.length()
            int r3 = r9.q
            if (r1 != r3) goto L_0x00ad
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.m.l r3 = new kotlin.m.l
            java.lang.String r4 = " "
            r3.<init>((java.lang.String) r4)
            java.lang.String r5 = ""
            java.lang.String r1 = r3.replace((java.lang.CharSequence) r1, (java.lang.String) r5)
            boolean r1 = com.paytm.utility.b.J((java.lang.String) r1)
            if (r1 == 0) goto L_0x00ad
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62586f
            if (r1 == 0) goto L_0x00f7
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r9.f62588h
            if (r1 == 0) goto L_0x0046
            if (r1 == 0) goto L_0x0033
            r1.clear()
        L_0x0033:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r9.f62587g
            if (r1 == 0) goto L_0x0046
            java.util.List r1 = r1.getProductList()
            if (r1 == 0) goto L_0x0046
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r9.f62588h
            if (r3 == 0) goto L_0x0046
            java.util.Collection r1 = (java.util.Collection) r1
            r3.addAll(r1)
        L_0x0046:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62586f
            if (r1 == 0) goto L_0x004d
            r1.setCardNumber(r10)
        L_0x004d:
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r9.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r9.a((android.widget.TextView) r1, (java.lang.String) r2)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62586f
            if (r1 == 0) goto L_0x006b
            java.lang.String r10 = kotlin.m.p.a(r10, r4, r5, r0)
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.m
            int r2 = net.one97.paytm.recharge.common.utils.ba.n
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r10, (java.lang.String) r0, (int) r2)
            r1.setDisplayCardNumber(r10)
        L_0x006b:
            int r10 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r10 = r9.a((int) r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            if (r10 == 0) goto L_0x0078
            r10.clearFocus()
        L_0x0078:
            int r10 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r10 = r9.a((int) r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            if (r10 == 0) goto L_0x0085
            r10.requestFocus()
        L_0x0085:
            net.one97.paytm.recharge.common.utils.t r10 = r9.s
            java.lang.String r0 = "mKeyboardUtil"
            if (r10 != 0) goto L_0x008e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x008e:
            int r10 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r10 = r9.a((int) r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            java.lang.String r1 = "etCreditCard"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
            android.view.View r10 = (android.view.View) r10
            net.one97.paytm.recharge.common.utils.t.a(r10)
            net.one97.paytm.recharge.common.utils.t r10 = r9.s
            if (r10 != 0) goto L_0x00a7
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00a7:
            r10.a()
            java.lang.String r10 = "correct"
            goto L_0x00f9
        L_0x00ad:
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)
            if (r10 == 0) goto L_0x00ea
            net.one97.paytm.recharge.model.v4.CJRAggsItem r10 = r9.f62587g
            if (r10 == 0) goto L_0x00f7
            int r10 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00cf
            java.lang.CharSequence r10 = r10.getText()
            if (r10 == 0) goto L_0x00cf
            java.lang.String r2 = r10.toString()
        L_0x00cf:
            r10 = r2
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x00de
            int r10 = net.one97.paytm.recharge.R.string.enter_valid_cc_number
            java.lang.String r2 = r9.getString(r10)
        L_0x00de:
            int r10 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.a((android.widget.TextView) r10, (java.lang.String) r2)
            goto L_0x00f7
        L_0x00ea:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x00f7
            r10.setVisibility(r0)
        L_0x00f7:
            java.lang.String r10 = "incorrect"
        L_0x00f9:
            r4 = r10
            net.one97.paytm.recharge.creditcard.c.a r10 = r9.o
            if (r10 == 0) goto L_0x0110
            net.one97.paytm.recharge.ordersummary.h.d r0 = r10.v
            if (r0 == 0) goto L_0x0110
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 112(0x70, float:1.57E-43)
            java.lang.String r1 = "onus_credit_card"
            java.lang.String r2 = "card_number_entered"
            java.lang.String r3 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.b(java.lang.String):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        if (isAdded() && !isRemoving() && getActivity() != null && getContext() != null && str.hashCode() == 63250152 && str.equals("fetchbin_api")) {
            this.l = false;
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            az azVar = az.f61525a;
            ImageView imageView = (ImageView) a(R.id.cardBgIV);
            kotlin.g.b.k.a((Object) imageView, "cardBgIV");
            az.a(imageView, "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x010b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r11, com.paytm.network.model.IJRPaytmDataModel r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r13 = "tag"
            kotlin.g.b.k.c(r11, r13)
            boolean r11 = r10.isAdded()
            if (r11 == 0) goto L_0x028e
            boolean r11 = r10.isVisible()
            if (r11 == 0) goto L_0x028e
            boolean r11 = r10.isRemoving()
            if (r11 != 0) goto L_0x028e
            boolean r11 = r12 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel
            if (r11 == 0) goto L_0x028e
            int r11 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r11 = r10.a((int) r11)
            android.widget.EditText r11 = (android.widget.EditText) r11
            java.lang.String r13 = "etCreditCard"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)
            android.text.Editable r11 = r11.getText()
            int r11 = r11.length()
            r13 = 7
            if (r11 >= r13) goto L_0x0034
            return
        L_0x0034:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel r12 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel) r12
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            r13 = 0
            r0 = 1
            if (r11 == 0) goto L_0x0075
            java.lang.String r1 = r11.getResponseCode()
            java.lang.String r2 = "405"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0075
            net.one97.paytm.recharge.di.helper.b r12 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x005b }
            android.content.Context r12 = r10.getContext()     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "credit_card_number_entered"
            java.lang.String r2 = "incorrect"
            java.lang.String r11 = r11.getResponseMessage()     // Catch:{ all -> 0x005b }
            net.one97.paytm.recharge.di.helper.b.b((android.content.Context) r12, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r11)     // Catch:{ all -> 0x005b }
        L_0x005b:
            r10.m = r0
            r10.l = r13
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r3 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            r4 = r11
            android.app.Activity r4 = (android.app.Activity) r4
            r5 = 0
            r6 = 0
            com.paytm.network.model.NetworkCustomError r7 = new com.paytm.network.model.NetworkCustomError
            r7.<init>()
            r8 = 0
            r9 = 1
            r3.showSessionTimeoutAlert(r4, r5, r6, r7, r8, r9)
            return
        L_0x0075:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            if (r11 == 0) goto L_0x009f
            java.lang.String r11 = r11.getCardType()
            if (r11 == 0) goto L_0x009f
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel$Companion r1 = net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel.Companion
            java.lang.String r1 = r1.getDEBIT_CARD_TYPE()
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r0)
            if (r11 == 0) goto L_0x009f
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.debit_card_not_supported_error
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x009f:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            if (r11 == 0) goto L_0x00c5
            java.lang.String r11 = r11.isIndian()
            if (r11 == 0) goto L_0x00c5
            java.lang.String r1 = "false"
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r0)
            if (r11 == 0) goto L_0x00c5
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.international_card_not_supported_error
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x00c5:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            r1 = 0
            if (r11 == 0) goto L_0x00d1
            java.lang.String r11 = r11.getCardScheme()
            goto L_0x00d2
        L_0x00d1:
            r11 = r1
        L_0x00d2:
            r10.f62585e = r11
            java.lang.String r11 = r10.f62585e
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x027d
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.o
            if (r11 == 0) goto L_0x00e5
            net.one97.paytm.recharge.model.v4.CJRCategoryData r11 = r11.R
            goto L_0x00e6
        L_0x00e5:
            r11 = r1
        L_0x00e6:
            if (r11 == 0) goto L_0x027d
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.o
            if (r11 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryData r11 = r11.R
            if (r11 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRGroupings r11 = r11.getGroupings()
            if (r11 == 0) goto L_0x00fb
            java.util.List r11 = r11.getAggs()
            goto L_0x00fc
        L_0x00fb:
            r11 = r1
        L_0x00fc:
            if (r11 == 0) goto L_0x013f
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r11.iterator()
        L_0x010b:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x013b
            java.lang.Object r3 = r11.next()
            r4 = r3
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r4
            java.lang.String r4 = r4.getBankCode()
            if (r4 == 0) goto L_0x0134
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r5 = r12.getBody()
            if (r5 == 0) goto L_0x012a
            java.lang.String r5 = r5.getIssuingBank()
            if (r5 != 0) goto L_0x012c
        L_0x012a:
            java.lang.String r5 = ""
        L_0x012c:
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r0)
            if (r4 != r0) goto L_0x0134
            r4 = 1
            goto L_0x0135
        L_0x0134:
            r4 = 0
        L_0x0135:
            if (r4 == 0) goto L_0x010b
            r2.add(r3)
            goto L_0x010b
        L_0x013b:
            r11 = r2
            java.util.List r11 = (java.util.List) r11
            goto L_0x0140
        L_0x013f:
            r11 = r1
        L_0x0140:
            if (r11 == 0) goto L_0x026b
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x026b
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r11.iterator()
        L_0x0159:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0181
            java.lang.Object r4 = r3.next()
            r5 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r5
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r6 = r12.getBody()
            if (r6 == 0) goto L_0x017a
            boolean r6 = r6.isPaytmFirstCard()
            if (r6 != r0) goto L_0x017a
            boolean r5 = r5.isPaytmFirst()
            if (r5 == 0) goto L_0x017a
            r5 = 1
            goto L_0x017b
        L_0x017a:
            r5 = 0
        L_0x017b:
            if (r5 == 0) goto L_0x0159
            r2.add(r4)
            goto L_0x0159
        L_0x0181:
            java.util.List r2 = (java.util.List) r2
            r12 = r2
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x0196
            java.lang.Object r11 = r2.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            r10.f62587g = r11
            goto L_0x01cd
        L_0x0196:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x01a1:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x01b9
            java.lang.Object r2 = r11.next()
            r3 = r2
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            boolean r3 = r3.isPaytmFirst()
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x01a1
            r12.add(r2)
            goto L_0x01a1
        L_0x01b9:
            java.util.List r12 = (java.util.List) r12
            r11 = r12
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r0
            if (r11 == 0) goto L_0x01cd
            java.lang.Object r11 = r12.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            r10.f62587g = r11
        L_0x01cd:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 != 0) goto L_0x01f7
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = new net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8
            r11.<init>()
            r10.f62586f = r11
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 != 0) goto L_0x01df
            kotlin.g.b.k.a()
        L_0x01df:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r12 = r10.f62586f
            if (r12 != 0) goto L_0x01e6
            kotlin.g.b.k.a()
        L_0x01e6:
            int r12 = r12.getIntermediateId()
            r11.setCardTypeId(r12)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 != 0) goto L_0x01f4
            kotlin.g.b.k.a()
        L_0x01f4:
            r11.setEditable(r0)
        L_0x01f7:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 == 0) goto L_0x0224
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r10.f62587g
            if (r12 == 0) goto L_0x0220
            java.util.List r12 = r12.getAggs()
            if (r12 == 0) goto L_0x0220
            java.lang.Object r12 = r12.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r12
            if (r12 == 0) goto L_0x0220
            java.util.List r12 = r12.getProductList()
            if (r12 == 0) goto L_0x0220
            java.lang.Object r12 = r12.get(r13)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r12
            if (r12 == 0) goto L_0x0220
            java.lang.String r12 = r12.getOperatorDisplayLabel()
            goto L_0x0221
        L_0x0220:
            r12 = r1
        L_0x0221:
            r11.setOperaterName(r12)
        L_0x0224:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 == 0) goto L_0x022d
            java.lang.String r12 = r10.f62585e
            r11.setCardType(r12)
        L_0x022d:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 == 0) goto L_0x0258
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r10.f62587g
            if (r12 == 0) goto L_0x0255
            java.util.List r12 = r12.getAggs()
            if (r12 == 0) goto L_0x0255
            java.lang.Object r12 = r12.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r12
            if (r12 == 0) goto L_0x0255
            java.util.List r12 = r12.getProductList()
            if (r12 == 0) goto L_0x0255
            java.lang.Object r12 = r12.get(r13)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r12 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r12
            if (r12 == 0) goto L_0x0255
            java.lang.String r1 = r12.getOperatorDisplayLabel()
        L_0x0255:
            r11.setBankName(r1)
        L_0x0258:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62586f
            if (r11 == 0) goto L_0x0267
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r10.f62587g
            if (r12 == 0) goto L_0x0264
            boolean r13 = r12.isPaytmFirst()
        L_0x0264:
            r11.setPaytmFirstCreditCard(r13)
        L_0x0267:
            r10.c()
            return
        L_0x026b:
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x027d:
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
        L_0x028e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final Context d() {
        return getContext();
    }

    public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8) {
        String str;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        StringBuilder sb = new StringBuilder("PFCC : Validation Failed ");
        if (cJRCreditCardModelV8 == null || (str = cJRCreditCardModelV8.getDisplayCardNumber()) == null) {
            str = "";
        }
        sb.append(str);
        net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: net.one97.paytm.recharge.model.v4.CJRCategoryData} */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        r2 = r2.R;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2, boolean r3, java.util.Map<java.lang.String, ? extends android.view.View> r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            java.lang.String r6 = "cardModel"
            kotlin.g.b.k.c(r2, r6)
            net.one97.paytm.recharge.widgets.c.e r6 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            net.one97.paytm.recharge.widgets.c.e r0 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            int r0 = r0.getDELAY_1000_MILLI()
            boolean r6 = r6.validateIsAlreadyClicked(r2, r0)
            if (r6 == 0) goto L_0x0016
            if (r5 != 0) goto L_0x0016
            return
        L_0x0016:
            boolean r6 = r2.isPaytmFirstCreditCard()
            if (r6 == 0) goto L_0x0030
            if (r5 == 0) goto L_0x001f
            goto L_0x0030
        L_0x001f:
            net.one97.paytm.recharge.creditcard.c.a r5 = r1.o
            if (r5 == 0) goto L_0x0028
            r6 = r1
            net.one97.paytm.recharge.creditcard.v4.a r6 = (net.one97.paytm.recharge.creditcard.v4.a) r6
            r5.W = r6
        L_0x0028:
            net.one97.paytm.recharge.creditcard.c.a r5 = r1.o
            if (r5 == 0) goto L_0x002f
            r5.a((net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r2, (boolean) r3, (java.util.Map<java.lang.String, ? extends android.view.View>) r4)
        L_0x002f:
            return
        L_0x0030:
            boolean r3 = r1.isDetached()
            if (r3 != 0) goto L_0x0167
            int r3 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r3 = r1.a((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x0043
            r3.clearFocus()
        L_0x0043:
            int r3 = net.one97.paytm.recharge.R.id.emptyFocusET
            android.view.View r3 = r1.a((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x0050
            r3.requestFocus()
        L_0x0050:
            net.one97.paytm.recharge.common.utils.t r3 = r1.s
            java.lang.String r5 = "mKeyboardUtil"
            if (r3 != 0) goto L_0x0059
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0059:
            int r3 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r3 = r1.a((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r6 = "etCreditCard"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.t.a(r3)
            net.one97.paytm.recharge.common.utils.t r3 = r1.s
            if (r3 != 0) goto L_0x0072
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0072:
            r3.a()
            android.content.Intent r3 = new android.content.Intent
            android.content.Context r5 = r1.getContext()
            java.lang.Class<net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4> r6 = net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4.class
            r3.<init>(r5, r6)
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r5)
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r5 = "selected_item"
            r3.putExtra(r5, r2)
            net.one97.paytm.recharge.creditcard.c.a r2 = r1.o
            r5 = 0
            if (r2 == 0) goto L_0x009a
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.R
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = r2.getCategoryHeader()
            goto L_0x009b
        L_0x009a:
            r2 = r5
        L_0x009b:
            java.lang.String r6 = "title"
            r3.putExtra(r6, r2)
            net.one97.paytm.recharge.creditcard.c.a r2 = r1.o
            if (r2 == 0) goto L_0x00ad
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.R
            if (r2 == 0) goto L_0x00ad
            java.lang.String r2 = r2.getDisclaimer()
            goto L_0x00ae
        L_0x00ad:
            r2 = r5
        L_0x00ae:
            java.lang.String r6 = "Recharge browse plan disclaimer"
            r3.putExtra(r6, r2)
            java.lang.String r2 = "From"
            java.lang.String r6 = ""
            r3.putExtra(r2, r6)
            net.one97.paytm.recharge.creditcard.c.a r2 = r1.o
            if (r2 == 0) goto L_0x00c1
            net.one97.paytm.common.entity.CJRItem r2 = r2.r
            goto L_0x00c2
        L_0x00c1:
            r2 = r5
        L_0x00c2:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r6 = "recharge_item"
            r3.putExtra(r6, r2)
            net.one97.paytm.recharge.creditcard.c.a r2 = r1.o
            if (r2 == 0) goto L_0x00e0
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData>> r2 = r2.x
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.recharge.model.v4.Data r2 = (net.one97.paytm.recharge.model.v4.Data) r2
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r2.getData()
            r5 = r2
            net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r5
        L_0x00e0:
            java.io.Serializable r5 = (java.io.Serializable) r5
            java.lang.String r2 = "intent_extra_cst_order_item"
            r3.putExtra(r2, r5)
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r2 < r5) goto L_0x015e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r4 == 0) goto L_0x0124
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00fc:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0124
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            if (r6 == 0) goto L_0x00fc
            android.util.Pair r6 = new android.util.Pair
            java.lang.Object r0 = r5.getValue()
            if (r0 != 0) goto L_0x0119
            kotlin.g.b.k.a()
        L_0x0119:
            java.lang.Object r5 = r5.getKey()
            r6.<init>(r0, r5)
            r2.add(r6)
            goto L_0x00fc
        L_0x0124:
            androidx.fragment.app.FragmentActivity r4 = r1.getActivity()
            android.app.Activity r4 = (android.app.Activity) r4
            java.util.Collection r2 = (java.util.Collection) r2
            r5 = 0
            android.util.Pair[] r5 = new android.util.Pair[r5]
            java.lang.Object[] r2 = r2.toArray(r5)
            if (r2 == 0) goto L_0x0156
            android.util.Pair[] r2 = (android.util.Pair[]) r2
            int r5 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r5)
            android.util.Pair[] r2 = (android.util.Pair[]) r2
            android.app.ActivityOptions r2 = android.app.ActivityOptions.makeSceneTransitionAnimation(r4, r2)
            androidx.fragment.app.FragmentActivity r4 = r1.getActivity()
            if (r4 == 0) goto L_0x0155
            net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$b r5 = net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.f62377b
            int r5 = net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.P
            android.os.Bundle r2 = r2.toBundle()
            r4.startActivityForResult(r3, r5, r2)
        L_0x0155:
            return
        L_0x0156:
            kotlin.u r2 = new kotlin.u
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T>"
            r2.<init>(r3)
            throw r2
        L_0x015e:
            net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$b r2 = net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.f62377b
            int r2 = net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.P
            r1.startActivityForResult(r3, r2)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.a(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8, boolean, java.util.Map, boolean, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r9 = this;
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62587g
            java.lang.String r1 = ""
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0036
            java.util.List r0 = r0.getAggs()
            if (r0 == 0) goto L_0x0036
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r0.next()
            r5 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r5
            java.lang.String r5 = r5.getValue()
            java.lang.String r6 = r9.f62585e
            if (r6 != 0) goto L_0x002a
            r6 = r1
        L_0x002a:
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r2)
            if (r5 == 0) goto L_0x0014
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            r0 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r0
            goto L_0x0037
        L_0x0036:
            r0 = r3
        L_0x0037:
            r9.f62587g = r0
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r9.f62588h
            if (r0 == 0) goto L_0x0042
            r0.clear()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0042:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62587g
            if (r0 == 0) goto L_0x0059
            java.util.List r0 = r0.getProductList()
            if (r0 == 0) goto L_0x0059
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r9.f62588h
            if (r4 == 0) goto L_0x0059
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r4.addAll(r0)
            java.lang.Boolean.valueOf(r0)
        L_0x0059:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62587g
            if (r0 == 0) goto L_0x0062
            java.util.List r0 = r0.getProductList()
            goto L_0x0063
        L_0x0062:
            r0 = r3
        L_0x0063:
            r4 = 0
            if (r0 == 0) goto L_0x0096
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62587g
            if (r0 == 0) goto L_0x006f
            java.util.List r0 = r0.getProductList()
            goto L_0x0070
        L_0x006f:
            r0 = r3
        L_0x0070:
            if (r0 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x007c
            goto L_0x0096
        L_0x007c:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62587g
            if (r0 == 0) goto L_0x0085
            java.util.List r0 = r0.getProductList()
            goto L_0x0086
        L_0x0085:
            r0 = r3
        L_0x0086:
            if (r0 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            boolean r0 = r0.isBillPaymentEnabled()
            goto L_0x0097
        L_0x0096:
            r0 = 0
        L_0x0097:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x0395
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x00a4
            java.util.List r5 = r5.getProductList()
            goto L_0x00a5
        L_0x00a4:
            r5 = r3
        L_0x00a5:
            if (r5 == 0) goto L_0x00d7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x00b0
            java.util.List r5 = r5.getProductList()
            goto L_0x00b1
        L_0x00b0:
            r5 = r3
        L_0x00b1:
            if (r5 != 0) goto L_0x00b6
            kotlin.g.b.k.a()
        L_0x00b6:
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00bd
            goto L_0x00d7
        L_0x00bd:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x00c6
            java.util.List r5 = r5.getProductList()
            goto L_0x00c7
        L_0x00c6:
            r5 = r3
        L_0x00c7:
            if (r5 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            java.lang.String r5 = r5.getCreditCardLength()
            goto L_0x00d8
        L_0x00d7:
            r5 = r3
        L_0x00d8:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0110
            if (r5 != 0) goto L_0x00e6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0110 }
        L_0x00e6:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0110 }
            r7 = 16
            if (r6 != r7) goto L_0x00f7
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0110 }
            int r5 = r5 + 3
            r9.q = r5     // Catch:{ Exception -> 0x0110 }
            goto L_0x0114
        L_0x00f7:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0110 }
            r7 = 14
            if (r6 == r7) goto L_0x0107
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0110 }
            r7 = 15
            if (r6 != r7) goto L_0x0114
        L_0x0107:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0110 }
            int r5 = r5 + 2
            r9.q = r5     // Catch:{ Exception -> 0x0110 }
            goto L_0x0114
        L_0x0110:
            r5 = 19
            r9.q = r5
        L_0x0114:
            int r5 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r5 = r9.a((int) r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x012e
            android.text.InputFilter[] r6 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r7 = new android.text.InputFilter$LengthFilter
            int r8 = r9.q
            r7.<init>(r8)
            android.text.InputFilter r7 = (android.text.InputFilter) r7
            r6[r4] = r7
            r5.setFilters(r6)
        L_0x012e:
            int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
            android.view.View r5 = r9.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0148
            android.text.InputFilter[] r6 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r7 = new android.text.InputFilter$LengthFilter
            int r8 = r9.q
            r7.<init>(r8)
            android.text.InputFilter r7 = (android.text.InputFilter) r7
            r6[r4] = r7
            r5.setFilters(r6)
        L_0x0148:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x0159
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62587g
            if (r6 == 0) goto L_0x0155
            java.lang.String r6 = r6.getImageUrl()
            goto L_0x0156
        L_0x0155:
            r6 = r3
        L_0x0156:
            r5.setOperaterImage(r6)
        L_0x0159:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x0162
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62587g
            r5.setSelectedDCVariant(r6)
        L_0x0162:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x016b
            java.util.List r5 = r5.getProductList()
            goto L_0x016c
        L_0x016b:
            r5 = r3
        L_0x016c:
            if (r5 == 0) goto L_0x01a6
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x0177
            java.util.List r5 = r5.getProductList()
            goto L_0x0178
        L_0x0177:
            r5 = r3
        L_0x0178:
            if (r5 != 0) goto L_0x017d
            kotlin.g.b.k.a()
        L_0x017d:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x01a6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x01a6
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62587g
            if (r6 == 0) goto L_0x0193
            java.util.List r6 = r6.getProductList()
            goto L_0x0194
        L_0x0193:
            r6 = r3
        L_0x0194:
            if (r6 != 0) goto L_0x0199
            kotlin.g.b.k.a()
        L_0x0199:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getImage()
            r5.setOperaterCardTypeImage(r6)
        L_0x01a6:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x01b5
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x01b5
            java.util.List r5 = r5.getProductList()
            goto L_0x01b6
        L_0x01b5:
            r5 = r3
        L_0x01b6:
            if (r5 == 0) goto L_0x021e
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x01c7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x01c7
            java.util.List r5 = r5.getProductList()
            goto L_0x01c8
        L_0x01c7:
            r5 = r3
        L_0x01c8:
            if (r5 != 0) goto L_0x01cd
            kotlin.g.b.k.a()
        L_0x01cd:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x021e
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x01fa
            if (r5 == 0) goto L_0x01e7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r5.getSelectedDCVariant()
            if (r6 == 0) goto L_0x01e7
            java.util.List r6 = r6.getProductList()
            goto L_0x01e8
        L_0x01e7:
            r6 = r3
        L_0x01e8:
            if (r6 != 0) goto L_0x01ed
            kotlin.g.b.k.a()
        L_0x01ed:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getDisclaimer()
            r5.setDisclaimer(r6)
        L_0x01fa:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x021e
            if (r5 == 0) goto L_0x020b
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r5.getSelectedDCVariant()
            if (r6 == 0) goto L_0x020b
            java.util.List r6 = r6.getProductList()
            goto L_0x020c
        L_0x020b:
            r6 = r3
        L_0x020c:
            if (r6 != 0) goto L_0x0211
            kotlin.g.b.k.a()
        L_0x0211:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getCreditCardLength()
            r5.setCreditCardLength(r6)
        L_0x021e:
            int r5 = net.one97.paytm.recharge.R.id.bankImagePlaceHolderView
            android.view.View r5 = r9.a((int) r5)
            r6 = 8
            if (r5 == 0) goto L_0x022b
            r5.setVisibility(r6)
        L_0x022b:
            int r5 = net.one97.paytm.recharge.R.id.cardTypePlaceHolderView
            android.view.View r5 = r9.a((int) r5)
            if (r5 == 0) goto L_0x0236
            r5.setVisibility(r6)
        L_0x0236:
            int r5 = net.one97.paytm.recharge.R.id.chipPlaceHolderIV
            android.view.View r5 = r9.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0243
            r5.setVisibility(r6)
        L_0x0243:
            int r5 = net.one97.paytm.recharge.R.id.chipIV
            android.view.View r5 = r9.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0250
            r5.setVisibility(r4)
        L_0x0250:
            int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
            android.view.View r5 = r9.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0267
            java.lang.String r6 = r9.f62583c
            java.lang.String r7 = r9.f62582a
            android.text.SpannableString r6 = r9.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r4)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x0267:
            int r5 = net.one97.paytm.recharge.R.id.overlayHintTextTV
            android.view.View r5 = r9.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x027e
            java.lang.String r6 = r9.f62583c
            java.lang.String r7 = r9.f62582a
            android.text.SpannableString r6 = r9.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r2)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x027e:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            java.lang.String r6 = "cardBgIV"
            if (r5 == 0) goto L_0x0334
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x0334
            java.util.List r5 = r5.getProductList()
            if (r5 == 0) goto L_0x0334
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r2
            if (r5 != r2) goto L_0x0334
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62586f
            if (r5 == 0) goto L_0x02a8
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x02a8
            java.util.List r5 = r5.getProductList()
            goto L_0x02a9
        L_0x02a8:
            r5 = r3
        L_0x02a9:
            if (r5 != 0) goto L_0x02ae
            kotlin.g.b.k.a()
        L_0x02ae:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            net.one97.paytm.recharge.common.utils.az r7 = net.one97.paytm.recharge.common.utils.az.f61525a
            int r7 = net.one97.paytm.recharge.R.id.cardBgIV
            android.view.View r7 = r9.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            java.lang.String r6 = r5.getCardBgV4()
            if (r6 != 0) goto L_0x02c8
            r6 = r1
        L_0x02c8:
            net.one97.paytm.recharge.common.utils.az.a((android.widget.ImageView) r7, (java.lang.String) r6)
            android.content.Context r6 = r9.getContext()
            java.lang.String r7 = r5.getBankNameLogoV4()
            int r8 = net.one97.paytm.recharge.R.id.img_bank
            android.view.View r8 = r9.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r6, (java.lang.String) r7, (android.widget.ImageView) r8, (boolean) r4)
            java.lang.String r6 = r5.getBankNameLogoV4()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x02ef
            boolean r6 = kotlin.m.p.a(r6)
            if (r6 == 0) goto L_0x02ed
            goto L_0x02ef
        L_0x02ed:
            r6 = 0
            goto L_0x02f0
        L_0x02ef:
            r6 = 1
        L_0x02f0:
            if (r6 == 0) goto L_0x0320
            java.lang.String r6 = r5.getOperatorDisplayLabel()
            boolean r6 = net.one97.paytm.recharge.common.utils.g.c(r6)
            if (r6 == 0) goto L_0x0320
            int r6 = net.one97.paytm.recharge.R.id.fallbackBankNameTV
            android.view.View r6 = r9.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x030d
            android.view.View r6 = (android.view.View) r6
            net.one97.paytm.recharge.common.utils.ai.a(r6)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x030d:
            int r6 = net.one97.paytm.recharge.R.id.fallbackBankNameTV
            android.view.View r6 = r9.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0320
            java.lang.String r7 = r5.getOperatorDisplayLabel()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
        L_0x0320:
            android.content.Context r6 = r9.getContext()
            java.lang.String r5 = r5.getCardTypeLogo()
            int r7 = net.one97.paytm.recharge.R.id.cardtypeView
            android.view.View r7 = r9.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r6, (java.lang.String) r5, (android.widget.ImageView) r7, (boolean) r4)
            goto L_0x0362
        L_0x0334:
            net.one97.paytm.recharge.common.utils.az r5 = net.one97.paytm.recharge.common.utils.az.f61525a
            int r5 = net.one97.paytm.recharge.R.id.cardBgIV
            android.view.View r5 = r9.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.recharge.common.utils.az.a((android.widget.ImageView) r5, (java.lang.String) r1)
            android.content.Context r5 = r9.getContext()
            int r6 = net.one97.paytm.recharge.R.id.img_bank
            android.view.View r6 = r9.a((int) r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r5, (java.lang.String) r1, (android.widget.ImageView) r6, (boolean) r4)
            android.content.Context r5 = r9.getContext()
            int r6 = net.one97.paytm.recharge.R.id.cardtypeView
            android.view.View r6 = r9.a((int) r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r5, (java.lang.String) r1, (android.widget.ImageView) r6, (boolean) r4)
        L_0x0362:
            android.content.Context r5 = r9.getContext()
            if (r5 == 0) goto L_0x0395
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            int r6 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r6 = r9.a((int) r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.String r7 = "etCreditCard"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            int r7 = net.one97.paytm.recharge.R.color.color_ffffff
            int r7 = androidx.core.content.b.c(r5, r7)
            net.one97.paytm.recharge.common.utils.az.a((android.widget.EditText) r6, (int) r7)
            int r6 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r6 = r9.a((int) r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x0395
            int r7 = net.one97.paytm.recharge.R.color.color_ffffff
            int r5 = androidx.core.content.b.c(r5, r7)
            r6.setTextColor(r5)
            kotlin.x r5 = kotlin.x.f47997a
        L_0x0395:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x039e
            java.util.List r5 = r5.getProductList()
            goto L_0x039f
        L_0x039e:
            r5 = r3
        L_0x039f:
            if (r5 == 0) goto L_0x03df
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x03aa
            java.util.List r5 = r5.getProductList()
            goto L_0x03ab
        L_0x03aa:
            r5 = r3
        L_0x03ab:
            if (r5 != 0) goto L_0x03b0
            kotlin.g.b.k.a()
        L_0x03b0:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x03df
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.b()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62587g
            if (r5 == 0) goto L_0x03c8
            java.util.List r5 = r5.getProductList()
            goto L_0x03c9
        L_0x03c8:
            r5 = r3
        L_0x03c9:
            if (r5 != 0) goto L_0x03ce
            kotlin.g.b.k.a()
        L_0x03ce:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            java.lang.Long r5 = r5.getProductId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.setProductId(r5)
        L_0x03df:
            if (r0 != 0) goto L_0x03fa
            int r0 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r1 = "getString(R.string.payme…_currently_not_supported)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r9.f62587g = r3
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r9.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r9.a((android.widget.TextView) r1, (java.lang.String) r0)
            return
        L_0x03fa:
            int r0 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r0 = r9.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.a((android.widget.TextView) r0, (java.lang.String) r3)
            boolean r0 = r9.k
            if (r0 == 0) goto L_0x0449
            boolean r0 = r9.j
            if (r0 == 0) goto L_0x0449
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r9.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0446
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0446
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x0446
            int r0 = r0.length()
            int r2 = r9.q
            if (r0 != r2) goto L_0x0446
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r9.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0441
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0441
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0442
        L_0x0441:
            r0 = r1
        L_0x0442:
            r9.b((java.lang.String) r0)
            return
        L_0x0446:
            r9.k = r4
            return
        L_0x0449:
            boolean r0 = r9.n
            if (r0 == 0) goto L_0x0450
            r9.e()
        L_0x0450:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.c():void");
    }

    private final void c(String str) {
        String str2;
        String str3;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        CharSequence text;
        Editable text2;
        String creditCardLength;
        List<CJRProductsItem> list;
        if (str != null) {
            if (str.length() >= this.q) {
                if (this.f62587g != null) {
                    if (com.paytm.utility.b.J(new kotlin.m.l(" ").replace((CharSequence) str, ""))) {
                        if (this.f62586f != null) {
                            List<CJRProductsItem> list2 = this.f62588h;
                            if (list2 != null) {
                                if (list2 != null) {
                                    list2.clear();
                                }
                                CJRAggsItem cJRAggsItem = this.f62587g;
                                if (cJRAggsItem == null) {
                                    kotlin.g.b.k.a();
                                }
                                List<CJRProductsItem> productList = cJRAggsItem.getProductList();
                                if (!(productList == null || (list = this.f62588h) == null)) {
                                    list.addAll(productList);
                                }
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62586f;
                            if (cJRCreditCardModelV8 != null) {
                                cJRCreditCardModelV8.setCardNumber(str.toString());
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62586f;
                            boolean z = false;
                            if (cJRCreditCardModelV82 != null) {
                                cJRCreditCardModelV82.setDisplayCardNumber(ba.a(p.a(str.toString(), " ", "", false), ba.m, ba.n));
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62586f;
                            if (cJRCreditCardModelV83 == null) {
                                kotlin.g.b.k.a();
                            }
                            this.f62586f = cJRCreditCardModelV83;
                            CJRCreditCardModelV8 cJRCreditCardModelV84 = this.f62586f;
                            if (cJRCreditCardModelV84 == null || (creditCardLength = cJRCreditCardModelV84.getCreditCardLength()) == null) {
                                this.q = 19;
                            } else {
                                if (creditCardLength.length() > 0) {
                                    z = true;
                                }
                                if (z) {
                                    try {
                                        if (Integer.parseInt(creditCardLength) == 16) {
                                            this.q = Integer.parseInt(creditCardLength) + 3;
                                        } else if (Integer.parseInt(creditCardLength) == 14 || Integer.parseInt(creditCardLength) == 15) {
                                            this.q = Integer.parseInt(creditCardLength) + 2;
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                this.q = 19;
                            }
                            EditText editText = (EditText) a(R.id.etCreditCard);
                            if (editText == null || (text2 = editText.getText()) == null || (str2 = text2.toString()) == null) {
                                str2 = "";
                            }
                            cJRCreditCardModelV83.setDisplayCardNumber(str2);
                            TextView textView = (TextView) a(R.id.etCreditCardHint);
                            if (textView == null || (text = textView.getText()) == null || (str3 = text.toString()) == null) {
                                str3 = "";
                            }
                            cJRCreditCardModelV83.setDisplayCardNumberHint(str3);
                            if (!isAdded() || !isVisible() || isRemoving()) {
                                CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: addCardView : NOT started amount screen");
                            } else {
                                CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: addCardView : Start amount screen");
                                net.one97.paytm.recharge.creditcard.c.a aVar = this.o;
                                if (!(aVar == null || (dVar2 = aVar.v) == null)) {
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, "onus_credit_card", "proceed_on_new_card_clicked", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
                                }
                                if (getParentFragment() instanceof net.one97.paytm.recharge.creditcard.b.a) {
                                    Fragment parentFragment = getParentFragment();
                                    if (parentFragment != null) {
                                        ((net.one97.paytm.recharge.creditcard.b.a) parentFragment).a(cJRCreditCardModelV83, false, (Map<String, ? extends View>) null, false);
                                    } else {
                                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
                                    }
                                } else if (getActivity() instanceof AJRNewCardActivityV4) {
                                    a.C1204a.a(this, cJRCreditCardModelV83, true, (Map) null, false, false, 24);
                                }
                            }
                            net.one97.paytm.recharge.creditcard.c.a aVar2 = this.o;
                            if (aVar2 != null && (dVar = aVar2.v) != null) {
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "proceed_on_new_card_clicked", "", (Object) null, (Object) null, (Object) null, (Object) null, 120);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                a((TextView) a(R.id.message_input_field), getString(R.string.enter_valid_cc_number));
                return;
            }
            a((TextView) a(R.id.message_input_field), getString(R.string.enter_valid_cc_number));
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.creditcard.c.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0) {
            ay ayVar = ay.f61523a;
            ay.a(i2);
        } else if (getActivity() != null && !TextUtils.isEmpty(this.p) && this.p.length() >= 7 && com.paytm.utility.b.c((Context) getActivity())) {
            String a2 = p.a(this.p, " ", "", false);
            if (a2 != null) {
                String substring = a2.substring(0, 6);
                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring.length() == 6) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a3.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName = a3.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    CRUFlowModel flowName2 = a3.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.CC_BIN.name());
                    }
                    a();
                    a(this, substring, (Object) a3);
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        AJRCreditCardEnterAmountActivity.b bVar = AJRCreditCardEnterAmountActivity.f62377b;
        if (i2 == AJRCreditCardEnterAmountActivity.P && az.d(getActivity()) && (aVar = this.o) != null) {
            b bVar2 = this;
            aVar.a((kotlin.k.e<x>) new g(bVar2));
            net.one97.paytm.recharge.common.utils.ai.a(this, aVar.f61408a, new h(bVar2));
            w wVar = aVar.t;
            if (wVar != null) {
                wVar.f61788h = new i(bVar2);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_proceed;
        if (valueOf != null && valueOf.intValue() == i2) {
            e();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e() {
        /*
            r6 = this;
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r0 = r6.f62586f
            r1 = 0
            if (r0 != 0) goto L_0x0136
            int r0 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r0 = r6.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x001a
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.toString()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x002a
            int r0 = net.one97.paytm.recharge.R.string.enter_valid_cc_number
            java.lang.String r0 = r6.getString(r0)
        L_0x002a:
            int r2 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r2 = r6.a((int) r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            if (r2 == 0) goto L_0x0039
            android.text.Editable r2 = r2.getText()
            goto L_0x003a
        L_0x0039:
            r2 = r1
        L_0x003a:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0058
            int r0 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r0 = r6.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.recharge.R.string.enter_cc_number
            java.lang.String r1 = r6.getString(r1)
            r6.a((android.widget.TextView) r0, (java.lang.String) r1)
            return
        L_0x0058:
            int r2 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r2 = r6.a((int) r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            if (r2 == 0) goto L_0x0067
            android.text.Editable r2 = r2.getText()
            goto L_0x0068
        L_0x0067:
            r2 = r1
        L_0x0068:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r2 = r2.length()
            r3 = 7
            if (r2 >= r3) goto L_0x0085
            int r0 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r0 = r6.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.recharge.R.string.enter_valid_cc_number
            java.lang.String r1 = r6.getString(r1)
            r6.a((android.widget.TextView) r0, (java.lang.String) r1)
            return
        L_0x0085:
            boolean r2 = r6.l
            if (r2 == 0) goto L_0x0095
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r6.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.a((android.widget.TextView) r1, (java.lang.String) r0)
            return
        L_0x0095:
            android.content.Context r0 = r6.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x010e
            r0 = 1
            r6.n = r0
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r6.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x00b7
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r0.toString()
            goto L_0x00b8
        L_0x00b7:
            r0 = r1
        L_0x00b8:
            if (r0 != 0) goto L_0x00bd
            kotlin.g.b.k.a()
        L_0x00bd:
            r6.p = r0
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r0.setErrorType(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x00d9
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x00d9:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x00e8
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x00e8:
            android.content.Context r2 = r6.getContext()
            if (r2 != 0) goto L_0x00f1
            kotlin.g.b.k.a()
        L_0x00f1:
            java.lang.String r3 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r3 = r6.a((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x010a
            android.text.Editable r3 = r3.getText()
            if (r3 == 0) goto L_0x010a
            java.lang.String r1 = r3.toString()
        L_0x010a:
            a((net.one97.paytm.recharge.creditcard.v4.c.b) r6, (android.content.Context) r2, (java.lang.String) r1, (java.lang.Object) r0)
            return
        L_0x010e:
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
            android.content.Context r4 = r6.getContext()
            if (r4 == 0) goto L_0x0125
            int r5 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0126
        L_0x0125:
            r4 = r1
        L_0x0126:
            android.content.Context r5 = r6.getContext()
            if (r5 == 0) goto L_0x0132
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r5.getString(r1)
        L_0x0132:
            net.one97.paytm.recharge.common.utils.az.a(r0, r2, r3, r4, r1)
            return
        L_0x0136:
            if (r0 == 0) goto L_0x0141
            boolean r0 = r0.isEditable()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0142
        L_0x0141:
            r0 = r1
        L_0x0142:
            if (r0 != 0) goto L_0x0147
            kotlin.g.b.k.a()
        L_0x0147:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0164
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r6.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0161
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0161
            java.lang.String r1 = r0.toString()
        L_0x0161:
            r6.c((java.lang.String) r1)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.b.e():void");
    }

    public final void a() {
        EditText editText = (EditText) a(R.id.etCreditCard);
        if (editText != null) {
            new Handler().postDelayed(new j(editText, this), 200);
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f62599a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f62600b;

        j(EditText editText, b bVar) {
            this.f62599a = editText;
            this.f62600b = bVar;
        }

        public final void run() {
            b.a(this.f62600b);
            t.b(this.f62599a);
        }
    }

    static /* synthetic */ void a(b bVar, String str, Object obj) {
        net.one97.paytm.recharge.creditcard.c.a aVar = bVar.o;
        if (aVar != null) {
            Context context = bVar.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            aVar.a("fetchbin_api", context, str, (ai) bVar, obj);
        }
    }

    static /* synthetic */ void a(b bVar, Context context, String str, Object obj) {
        if ((str != null ? str.length() : 0) >= 7) {
            String obj2 = p.a(String.valueOf(str), " ", "", false).subSequence(0, 6).toString();
            bVar.l = true;
            net.one97.paytm.recharge.creditcard.c.a aVar = bVar.o;
            if (aVar != null) {
                aVar.a("fetchbin_api", context, obj2, (ai) bVar, obj);
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, CJRInstruct cJRInstruct) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        if (cJRInstruct instanceof CJRInstruct.showAlertDialog) {
            CJRInstruct.showAlertDialog showalertdialog = (CJRInstruct.showAlertDialog) cJRInstruct;
            String str = null;
            if (showalertdialog.getHawkEyeEvent() instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) showalertdialog.getHawkEyeEvent();
                ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                if (flowName != null) {
                    str = flowName.getActionType();
                }
                cJRRechargeErrorModel = cJRRechargeErrorModel2;
                action_type = companion.getActionType(str, ACTION_TYPE.CLP_PROCEED);
            } else {
                action_type = null;
                cJRRechargeErrorModel = null;
            }
            az azVar = az.f61525a;
            Context context = bVar.getContext();
            if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                error_type = ERROR_TYPE.UNDEFINED;
            }
            az.a(context, error_type, action_type, showalertdialog.getTitle(), showalertdialog.getMessage(), false, cJRRechargeErrorModel, false, 1504);
        }
    }
}

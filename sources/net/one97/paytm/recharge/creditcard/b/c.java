package net.one97.paytm.recharge.creditcard.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.upi.util.Events;

public final class c extends Fragment implements View.OnClickListener, ai {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62423a = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String u;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f62424b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f62425c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f62426d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRCreditCardModelV8 f62427e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRAggsItem f62428f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public List<CJRProductsItem> f62429g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f62430h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f62431i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private boolean l;
    private boolean m;
    private net.one97.paytm.recharge.creditcard.c.a n;
    /* access modifiers changed from: private */
    public String o = "";
    /* access modifiers changed from: private */
    public int p = 19;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.ordersummary.h.d q;
    /* access modifiers changed from: private */
    public final String r = "credit_card";
    private final View.OnClickListener s = new d(this);
    private final C1201c t = new C1201c(this);
    private HashMap v;

    public final View a(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String name = c.class.getName();
        k.a((Object) name, "FJRNewCreditCardFragment::class.java.name");
        u = name;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.q = new net.one97.paytm.recharge.ordersummary.h.d(context);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Locale locale = Locale.getDefault();
            k.a((Object) locale, "Locale.getDefault()");
            String lowerCase = "/credit_card".toLowerCase(locale);
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), lowerCase);
        } catch (Throwable unused) {
        }
        return layoutInflater.inflate(R.layout.fragment_new_credit_card_layout, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        CJRCategoryData cJRCategoryData;
        net.one97.paytm.recharge.creditcard.c.a aVar;
        super.onActivityCreated(bundle);
        String str = null;
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.n = (net.one97.paytm.recharge.creditcard.c.a) am.a(activity).a(net.one97.paytm.recharge.creditcard.c.a.class);
            }
        } catch (Exception unused) {
            if (getParentFragment() instanceof d) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    d dVar = (d) parentFragment;
                    if (dVar.getParentFragment() instanceof a) {
                        Fragment parentFragment2 = dVar.getParentFragment();
                        if (parentFragment2 != null) {
                            aVar = ((a) parentFragment2).f62401a;
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
                        }
                    } else {
                        aVar = null;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRSavedCardsFragmentV3");
                }
            } else {
                Fragment parentFragment3 = getParentFragment();
                if (parentFragment3 != null) {
                    aVar = ((a) parentFragment3).f62401a;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
                }
            }
            this.n = aVar;
        }
        TextView textView = (TextView) a(R.id.view_disclaimer);
        if (textView != null) {
            net.one97.paytm.recharge.creditcard.c.a aVar2 = this.n;
            if (!(aVar2 == null || (cJRCategoryData = aVar2.R) == null)) {
                str = cJRCategoryData.getDisclaimer();
            }
            textView.setText(str);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setOnClickListener(this);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        EditText editText = (EditText) a(R.id.etCreditCard);
        if (editText != null) {
            editText.requestFocus();
        }
        EditText editText2 = (EditText) a(R.id.etCreditCard);
        if (editText2 != null) {
            editText2.setTypeface(Typeface.MONOSPACE);
        }
        EditText editText3 = (EditText) a(R.id.etCreditCardHint);
        if (editText3 != null) {
            editText3.setTypeface(Typeface.MONOSPACE);
        }
        EditText editText4 = (EditText) a(R.id.etCreditCard);
        if (editText4 != null) {
            editText4.setInputType(2);
        }
        EditText editText5 = (EditText) a(R.id.etCreditCard);
        if (editText5 != null) {
            editText5.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        }
        Context activity = getActivity();
        EditText editText6 = (EditText) a(R.id.etCreditCard);
        if (editText6 != null) {
            ba.b(activity, (View) editText6);
            EditText editText7 = (EditText) a(R.id.etCreditCard);
            if (editText7 != null) {
                editText7.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.p)});
            }
            EditText editText8 = (EditText) a(R.id.etCreditCardHint);
            if (editText8 != null) {
                editText8.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.p)});
            }
            ((EditText) a(R.id.etCreditCard)).addTextChangedListener(this.t);
            ((EditText) a(R.id.etCreditCard)).setOnClickListener(this.s);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final void onDestroyView() {
        CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: onDestroyView");
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62441a;

        d(c cVar) {
            this.f62441a = cVar;
        }

        public final void onClick(View view) {
            k.a((Object) view, "view");
            view.setFocusableInTouchMode(true);
            view.setFocusable(true);
            if (this.f62441a.getActivity() != null) {
                Context activity = this.f62441a.getActivity();
                EditText editText = (EditText) this.f62441a.a(R.id.etCreditCard);
                if (editText != null) {
                    ba.b(activity, (View) editText);
                } else {
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
            }
            net.one97.paytm.recharge.ordersummary.h.d b2 = this.f62441a.q;
            if (b2 != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(b2, this.f62441a.r, "credit_card_number_field_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.b.c$c  reason: collision with other inner class name */
    public static final class C1201c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62433a;

        /* renamed from: b  reason: collision with root package name */
        private int f62434b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62435c;

        /* renamed from: d  reason: collision with root package name */
        private String f62436d = "";

        /* renamed from: e  reason: collision with root package name */
        private int f62437e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f62438f;

        /* renamed from: g  reason: collision with root package name */
        private int f62439g;

        C1201c(c cVar) {
            this.f62433a = cVar;
        }

        /* JADX WARNING: type inference failed for: r5v4, types: [android.text.Editable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r14) {
            /*
                r13 = this;
                java.lang.String r0 = "s"
                kotlin.g.b.k.c(r14, r0)
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r1 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r0 = r0.a((int) r1)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
                r1 = 1
                if (r0 == 0) goto L_0x003a
                boolean r0 = r0.isEnabled()
                if (r0 != 0) goto L_0x003a
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r2 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r0 = r0.a((int) r2)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
                java.lang.String r2 = "btn_proceed"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r0.setEnabled(r1)
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r3 = net.one97.paytm.recharge.R.id.btn_proceed
                android.view.View r0 = r0.a((int) r3)
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r0.setClickable(r1)
            L_0x003a:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r2 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r0 = r0.a((int) r2)
                android.widget.EditText r0 = (android.widget.EditText) r0
                if (r0 == 0) goto L_0x004c
                r2 = r13
                android.text.TextWatcher r2 = (android.text.TextWatcher) r2
                r0.removeTextChangedListener(r2)
            L_0x004c:
                r0 = r14
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                kotlin.m.l r2 = new kotlin.m.l
                java.lang.String r3 = "^\\s+"
                r2.<init>((java.lang.String) r3)
                java.lang.String r3 = ""
                java.lang.String r0 = r2.replace((java.lang.CharSequence) r0, (java.lang.String) r3)
                r14.clear()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r14.append(r0)
                if (r14 == 0) goto L_0x006c
                java.lang.String r0 = r14.toString()
                if (r0 != 0) goto L_0x006d
            L_0x006c:
                r0 = r3
            L_0x006d:
                int r0 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r0)
                r13.f62437e = r0
                boolean r0 = r13.f62435c
                r2 = 5
                r4 = 4
                r5 = 0
                if (r0 != 0) goto L_0x00bf
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r6 = r13.f62437e
                if (r6 == r4) goto L_0x00aa
                if (r6 == r2) goto L_0x0097
                android.content.Context r6 = r0.getContext()
                if (r6 == 0) goto L_0x0095
                android.content.res.Resources r6 = r6.getResources()
                if (r6 == 0) goto L_0x0095
                int r7 = net.one97.paytm.recharge.R.string.default_placeholder
                java.lang.String r6 = r6.getString(r7)
                goto L_0x00bc
            L_0x0095:
                r6 = r5
                goto L_0x00bc
            L_0x0097:
                android.content.Context r6 = r0.getContext()
                if (r6 == 0) goto L_0x0095
                android.content.res.Resources r6 = r6.getResources()
                if (r6 == 0) goto L_0x0095
                int r7 = net.one97.paytm.recharge.R.string.diners
                java.lang.String r6 = r6.getString(r7)
                goto L_0x00bc
            L_0x00aa:
                android.content.Context r6 = r0.getContext()
                if (r6 == 0) goto L_0x0095
                android.content.res.Resources r6 = r6.getResources()
                if (r6 == 0) goto L_0x0095
                int r7 = net.one97.paytm.recharge.R.string.amex
                java.lang.String r6 = r6.getString(r7)
            L_0x00bc:
                r0.f62424b = r6
            L_0x00bf:
                int r0 = r13.f62437e
                r6 = 16
                java.lang.String r7 = "RechargeUtils.formatText…Card(editable.toString())"
                r8 = 2
                r9 = 19
                if (r0 == r1) goto L_0x0110
                if (r0 == r8) goto L_0x0110
                r10 = 3
                if (r0 == r10) goto L_0x0110
                java.lang.String r10 = "RechargeUtils.formatTextAmEx(editable.toString())"
                if (r0 == r4) goto L_0x00fb
                if (r0 == r2) goto L_0x00e8
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.p = r9
                java.lang.String r0 = java.lang.String.valueOf(r14)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.CharSequence) r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
                goto L_0x0122
            L_0x00e8:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.p = r6
                java.lang.String r0 = java.lang.String.valueOf(r14)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.CharSequence) r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
                goto L_0x0122
            L_0x00fb:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r2 = 17
                r0.p = r2
                java.lang.String r0 = java.lang.String.valueOf(r14)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.CharSequence) r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
                goto L_0x0122
            L_0x0110:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.p = r9
                java.lang.String r0 = java.lang.String.valueOf(r14)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.CharSequence) r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            L_0x0122:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                java.lang.String r4 = r2.f62424b
                java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
                if (r4 == 0) goto L_0x013e
                if (r4 == 0) goto L_0x0138
                char[] r4 = r4.toCharArray()
                java.lang.String r10 = "(this as java.lang.String).toCharArray()"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
                goto L_0x013f
            L_0x0138:
                kotlin.u r14 = new kotlin.u
                r14.<init>(r7)
                throw r14
            L_0x013e:
                r4 = r5
            L_0x013f:
                net.one97.paytm.recharge.creditcard.b.c r10 = r13.f62433a
                java.lang.String r10 = r10.f62424b
                r11 = 0
                if (r10 == 0) goto L_0x014d
                int r10 = r10.length()
                goto L_0x014e
            L_0x014d:
                r10 = 0
            L_0x014e:
                int r12 = r0.length()
                if (r10 <= r12) goto L_0x0159
                int r6 = r0.length()
                goto L_0x0165
            L_0x0159:
                net.one97.paytm.recharge.creditcard.b.c r10 = r13.f62433a
                java.lang.String r10 = r10.f62424b
                if (r10 == 0) goto L_0x0165
                int r6 = r10.length()
            L_0x0165:
                if (r4 == 0) goto L_0x017d
                r10 = 0
            L_0x0168:
                if (r10 >= r6) goto L_0x0173
                char r12 = r0.charAt(r10)
                r4[r10] = r12
                int r10 = r10 + 1
                goto L_0x0168
            L_0x0173:
                net.one97.paytm.recharge.creditcard.b.c r6 = r13.f62433a
                java.lang.String r10 = new java.lang.String
                r10.<init>(r4)
                r6.f62424b = r10
            L_0x017d:
                net.one97.paytm.recharge.creditcard.b.c r4 = r13.f62433a
                java.lang.String r4 = r4.f62424b
                r2.f62424b = r4
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                java.lang.String r2 = r2.f62424b
                if (r2 == 0) goto L_0x01a5
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x01a5
                net.one97.paytm.recharge.creditcard.b.c r4 = r13.f62433a
                java.lang.String r4 = r4.f62424b
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r2.setHint(r4)
            L_0x01a5:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x01c5
                android.text.InputFilter[] r4 = new android.text.InputFilter[r1]
                android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.b.c r10 = r13.f62433a
                int r10 = r10.p
                r6.<init>(r10)
                android.text.InputFilter r6 = (android.text.InputFilter) r6
                r4[r11] = r6
                r2.setFilters(r4)
            L_0x01c5:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x01e5
                android.text.InputFilter[] r4 = new android.text.InputFilter[r1]
                android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.b.c r10 = r13.f62433a
                int r10 = r10.p
                r6.<init>(r10)
                android.text.InputFilter r6 = (android.text.InputFilter) r6
                r4[r11] = r6
                r2.setFilters(r4)
            L_0x01e5:
                int r2 = r0.length()
                if (r2 >= r8) goto L_0x0247
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                r2.p = r9
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x0210
                android.text.InputFilter[] r4 = new android.text.InputFilter[r1]
                android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.b.c r8 = r13.f62433a
                int r8 = r8.p
                r6.<init>(r8)
                android.text.InputFilter r6 = (android.text.InputFilter) r6
                r4[r11] = r6
                r2.setFilters(r4)
            L_0x0210:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x0230
                android.text.InputFilter[] r4 = new android.text.InputFilter[r1]
                android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.creditcard.b.c r8 = r13.f62433a
                int r8 = r8.p
                r6.<init>(r8)
                android.text.InputFilter r6 = (android.text.InputFilter) r6
                r4[r11] = r6
                r2.setFilters(r4)
            L_0x0230:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCardHint
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x0247
                net.one97.paytm.recharge.creditcard.b.c r4 = r13.f62433a
                java.lang.String r4 = r4.f62424b
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r2.setHint(r4)
            L_0x0247:
                r14.clear()
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r14.append(r2)
                net.one97.paytm.recharge.creditcard.b.c r4 = r13.f62433a
                int r6 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r6)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x0266
                net.one97.paytm.recharge.creditcard.b.c$c$a r6 = new net.one97.paytm.recharge.creditcard.b.c$c$a
                r6.<init>(r13)
                android.view.View$OnKeyListener r6 = (android.view.View.OnKeyListener) r6
                r4.setOnKeyListener(r6)
            L_0x0266:
                java.lang.String r4 = r13.f62436d
                int r6 = r13.f62439g
                int r8 = r4.length()
                if (r4 == 0) goto L_0x0523
                java.lang.String r4 = r4.substring(r6, r8)
                java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
                int r4 = a(r4)
                int r4 = r13.a((int) r4, (java.lang.String) r0)
                net.one97.paytm.recharge.creditcard.b.c r6 = r13.f62433a     // Catch:{ Exception -> 0x0291 }
                int r7 = net.one97.paytm.recharge.R.id.etCreditCard     // Catch:{ Exception -> 0x0291 }
                android.view.View r6 = r6.a((int) r7)     // Catch:{ Exception -> 0x0291 }
                android.widget.EditText r6 = (android.widget.EditText) r6     // Catch:{ Exception -> 0x0291 }
                if (r6 == 0) goto L_0x02d9
                r6.setSelection(r4)     // Catch:{ Exception -> 0x0291 }
                goto L_0x02d9
            L_0x0291:
                net.one97.paytm.recharge.creditcard.b.c r4 = r13.f62433a
                int r6 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r6)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x02a1
                r4.setText(r2)
            L_0x02a1:
                int r2 = r0.length()
                if (r2 < 0) goto L_0x02ac
                int r0 = r0.length()
                goto L_0x02ad
            L_0x02ac:
                r0 = 0
            L_0x02ad:
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                java.lang.String r4 = "etCreditCard"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                int r2 = r2.length()
                if (r0 >= r2) goto L_0x02d9
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r4 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r2 = r2.a((int) r4)
                android.widget.EditText r2 = (android.widget.EditText) r2
                if (r2 == 0) goto L_0x02d9
                r2.setSelection(r0)
            L_0x02d9:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r2 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r0 = r0.a((int) r2)
                android.widget.EditText r0 = (android.widget.EditText) r0
                if (r0 == 0) goto L_0x02eb
                r2 = r13
                android.text.TextWatcher r2 = (android.text.TextWatcher) r2
                r0.addTextChangedListener(r2)
            L_0x02eb:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r2 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r0 = r0.a((int) r2)
                android.widget.EditText r0 = (android.widget.EditText) r0
                r2 = 7
                if (r0 == 0) goto L_0x03b1
                android.text.Editable r0 = r0.getText()
                if (r0 == 0) goto L_0x03b1
                int r0 = r0.length()
                if (r0 != r2) goto L_0x03b1
                int r0 = r14.length()
                int r2 = r13.f62434b
                if (r0 >= r2) goto L_0x030d
                return
            L_0x030d:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                boolean r0 = r0.j
                if (r0 == 0) goto L_0x031e
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                boolean r0 = r0.f62431i
                if (r0 == 0) goto L_0x031e
                return
            L_0x031e:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                android.content.Context r0 = r0.getContext()
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 == 0) goto L_0x037e
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.f62431i = r1
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.k = r1
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                java.lang.String r1 = r14.toString()
                java.lang.String r2 = " "
                java.lang.String r1 = kotlin.m.p.a(r1, r2, r3, r11)
                r0.o = r1
                net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r5, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r5)
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                r0.setErrorType(r1)
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x035d
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                java.lang.String r2 = r2.name()
                r1.setErrorType(r2)
            L_0x035d:
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x036c
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                java.lang.String r2 = r2.name()
                r1.setActionType(r2)
            L_0x036c:
                net.one97.paytm.recharge.creditcard.b.c r1 = r13.f62433a
                java.lang.String r14 = r14.toString()
                java.lang.String r2 = " "
                java.lang.String r14 = kotlin.m.p.a(r14, r2, r3, r11)
                java.lang.String r2 = "fetchbin_api"
                r1.a(r2, r14, r0)
                return
            L_0x037e:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.f62430h = r1
                net.one97.paytm.recharge.common.utils.az r14 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                android.content.Context r14 = r14.getContext()
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                android.content.Context r2 = r2.getContext()
                if (r2 == 0) goto L_0x039e
                int r3 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r2 = r2.getString(r3)
                goto L_0x039f
            L_0x039e:
                r2 = r5
            L_0x039f:
                net.one97.paytm.recharge.creditcard.b.c r3 = r13.f62433a
                android.content.Context r3 = r3.getContext()
                if (r3 == 0) goto L_0x03ad
                int r4 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r5 = r3.getString(r4)
            L_0x03ad:
                net.one97.paytm.recharge.common.utils.az.a(r14, r0, r1, r2, r5)
                return
            L_0x03b1:
                int r0 = r14.length()
                if (r0 >= r2) goto L_0x0423
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.j = r11
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.k = r11
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.f62428f = null
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.f62427e = null
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                java.util.List r14 = r14.f62429g
                if (r14 == 0) goto L_0x03d6
                r14.clear()
            L_0x03d6:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.lyt_outer_container
                android.view.View r14 = r14.a((int) r0)
                android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
                net.one97.paytm.recharge.common.utils.ba.a((android.view.View) r14, (java.lang.String) r5)
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.img_bank
                android.view.View r14 = r14.a((int) r0)
                android.widget.ImageView r14 = (android.widget.ImageView) r14
                r0 = 8
                if (r14 == 0) goto L_0x03f4
                r14.setVisibility(r0)
            L_0x03f4:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r1 = net.one97.paytm.recharge.R.id.cardtypeView
                android.view.View r14 = r14.a((int) r1)
                android.widget.ImageView r14 = (android.widget.ImageView) r14
                if (r14 == 0) goto L_0x0403
                r14.setVisibility(r0)
            L_0x0403:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.message_input_field
                android.view.View r14 = r14.a((int) r0)
                android.widget.TextView r14 = (android.widget.TextView) r14
                if (r14 == 0) goto L_0x0422
                int r14 = r14.getVisibility()
                if (r14 != 0) goto L_0x0522
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.message_input_field
                android.view.View r0 = r14.a((int) r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r14.a((android.widget.TextView) r0, (java.lang.String) null)
            L_0x0422:
                return
            L_0x0423:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                boolean r0 = r0.j
                if (r0 != 0) goto L_0x0441
                int r0 = r14.length()
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                int r2 = r2.p
                if (r0 < r2) goto L_0x0441
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                java.lang.String r14 = r14.toString()
                r0.a((java.lang.String) r14)
                return
            L_0x0441:
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                boolean r0 = r0.f62431i
                if (r0 != 0) goto L_0x0522
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                android.content.Context r0 = r0.getContext()
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 == 0) goto L_0x04e8
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                boolean r0 = r0.k
                if (r0 != 0) goto L_0x04ae
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                r0.f62431i = r1
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                java.lang.String r1 = r14.toString()
                r0.o = r1
                net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r5, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r5)
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                r0.setErrorType(r1)
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x0485
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                java.lang.String r2 = r2.name()
                r1.setErrorType(r2)
            L_0x0485:
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x0494
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                java.lang.String r2 = r2.name()
                r1.setActionType(r2)
            L_0x0494:
                net.one97.paytm.recharge.creditcard.b.c r1 = r13.f62433a
                android.content.Context r2 = r1.getContext()
                if (r2 != 0) goto L_0x049f
                kotlin.g.b.k.a()
            L_0x049f:
                java.lang.String r3 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r14 = r14.toString()
                java.lang.String r3 = "fetchbin_api"
                r1.a((java.lang.String) r3, (android.content.Context) r2, (java.lang.String) r14, (java.lang.Object) r0)
                return
            L_0x04ae:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r14 = r14.a((int) r0)
                android.widget.EditText r14 = (android.widget.EditText) r14
                if (r14 == 0) goto L_0x04bf
                android.text.Editable r14 = r14.getText()
                goto L_0x04c0
            L_0x04bf:
                r14 = r5
            L_0x04c0:
                java.lang.String r14 = java.lang.String.valueOf(r14)
                int r14 = r14.length()
                net.one97.paytm.recharge.creditcard.b.c r0 = r13.f62433a
                int r0 = r0.p
                if (r14 != r0) goto L_0x04e7
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                int r0 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r0 = r14.a((int) r0)
                android.widget.EditText r0 = (android.widget.EditText) r0
                if (r0 == 0) goto L_0x04e0
                android.text.Editable r5 = r0.getText()
            L_0x04e0:
                java.lang.String r0 = java.lang.String.valueOf(r5)
                r14.a((java.lang.String) r0)
            L_0x04e7:
                return
            L_0x04e8:
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                boolean r14 = r14.f62430h
                if (r14 != 0) goto L_0x0522
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                r14.f62430h = r1
                net.one97.paytm.recharge.common.utils.az r14 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.creditcard.b.c r14 = r13.f62433a
                android.content.Context r14 = r14.getContext()
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
                net.one97.paytm.recharge.creditcard.b.c r2 = r13.f62433a
                android.content.Context r2 = r2.getContext()
                if (r2 == 0) goto L_0x0510
                int r3 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r2 = r2.getString(r3)
                goto L_0x0511
            L_0x0510:
                r2 = r5
            L_0x0511:
                net.one97.paytm.recharge.creditcard.b.c r3 = r13.f62433a
                android.content.Context r3 = r3.getContext()
                if (r3 == 0) goto L_0x051f
                int r4 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r5 = r3.getString(r4)
            L_0x051f:
                net.one97.paytm.recharge.common.utils.az.a(r14, r0, r1, r2, r5)
            L_0x0522:
                return
            L_0x0523:
                kotlin.u r14 = new kotlin.u
                r14.<init>(r7)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.C1201c.afterTextChanged(android.text.Editable):void");
        }

        /* renamed from: net.one97.paytm.recharge.creditcard.b.c$c$a */
        static final class a implements View.OnKeyListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1201c f62440a;

            a(C1201c cVar) {
                this.f62440a = cVar;
            }

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                this.f62440a.f62438f = i2 == 67 ? 1 : 0;
                return false;
            }
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
                java.lang.String r9 = r8.f62436d
                int r9 = b(r9)
                int r10 = b(r10)
                int r9 = r9 - r10
                int r0 = r0 + r9
                int r10 = r8.f62437e
                r1 = 4
                r3 = 5
                r4 = 1
                if (r10 == r1) goto L_0x0076
                if (r10 != r3) goto L_0x004b
                goto L_0x0076
            L_0x004b:
                int r10 = r8.f62438f
                r5 = 15
                r6 = 10
                if (r10 != r4) goto L_0x005c
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 == r6) goto L_0x0082
                if (r0 != r5) goto L_0x005c
                goto L_0x0082
            L_0x005c:
                int r10 = r8.f62438f
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
                int r10 = r8.f62438f
                r5 = 12
                if (r10 != r4) goto L_0x0085
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 != r5) goto L_0x0085
            L_0x0082:
                int r0 = r0 + -1
                goto L_0x009a
            L_0x0085:
                int r10 = r8.f62438f
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
                int r9 = r8.f62439g
                if (r9 != r4) goto L_0x00a3
                r0 = 0
            L_0x00a3:
                if (r0 >= 0) goto L_0x00a6
                r0 = 0
            L_0x00a6:
                net.one97.paytm.recharge.creditcard.b.c r9 = r8.f62433a
                int r9 = r9.p
                if (r0 <= r9) goto L_0x00b4
                net.one97.paytm.recharge.creditcard.b.c r9 = r8.f62433a
                int r0 = r9.p
            L_0x00b4:
                return r0
            L_0x00b5:
                kotlin.u r9 = new kotlin.u
                java.lang.String r10 = "null cannot be cast to non-null type kotlin.CharSequence"
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.C1201c.a(int, java.lang.String):int");
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
                this.f62433a.f62425c = charSequence != null ? charSequence.toString() : null;
            }
            if (charSequence != null) {
                charSequence2 = charSequence.subSequence(i2, i3 + i2);
            }
            this.f62435c = k.a((Object) " ", (Object) String.valueOf(charSequence2));
            this.f62436d = String.valueOf(charSequence);
            this.f62434b = charSequence != null ? charSequence.length() : 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r4 = kotlin.m.p.a((r4 = r4.toString()), " ", "", false);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
            /*
                r3 = this;
                int r5 = r5 + r6
                r3.f62439g = r5
                r5 = 2
                if (r7 < r5) goto L_0x00b9
                java.lang.String r6 = ""
                if (r4 == 0) goto L_0x001d
                kotlin.m.l r7 = new kotlin.m.l
                java.lang.String r0 = "^\\s+"
                r7.<init>((java.lang.String) r0)
                java.lang.String r7 = r7.replace((java.lang.CharSequence) r4, (java.lang.String) r6)
                if (r7 == 0) goto L_0x001d
                java.lang.String r7 = r7.toString()
                if (r7 != 0) goto L_0x001e
            L_0x001d:
                r7 = r6
            L_0x001e:
                int r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7)
                r3.f62437e = r7
                r7 = 0
                if (r4 == 0) goto L_0x003a
                java.lang.String r4 = r4.toString()
                if (r4 == 0) goto L_0x003a
                java.lang.String r0 = " "
                java.lang.String r4 = kotlin.m.p.a(r4, r0, r6, r7)
                if (r4 == 0) goto L_0x003a
                int r4 = r4.length()
                goto L_0x003b
            L_0x003a:
                r4 = 0
            L_0x003b:
                net.one97.paytm.recharge.creditcard.b.c r0 = r3.f62433a
                int r0 = r0.p
                int r1 = r3.f62437e
                r2 = 4
                if (r1 == r2) goto L_0x004b
                r2 = 5
                if (r1 != r2) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r5 = 3
            L_0x004b:
                int r0 = r0 - r5
                if (r4 <= r0) goto L_0x00a9
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x0060
                r5 = r3
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r4.removeTextChangedListener(r5)
            L_0x0060:
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x0071
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r4.setText(r6)
            L_0x0071:
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                java.lang.String r4 = r4.f62425c
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x0096
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x0096
                net.one97.paytm.recharge.creditcard.b.c r5 = r3.f62433a
                java.lang.String r5 = r5.f62425c
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r4.append(r5)
            L_0x0096:
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                int r5 = net.one97.paytm.recharge.R.id.etCreditCard
                android.view.View r4 = r4.a((int) r5)
                android.widget.EditText r4 = (android.widget.EditText) r4
                if (r4 == 0) goto L_0x00a8
                r5 = r3
                android.text.TextWatcher r5 = (android.text.TextWatcher) r5
                r4.addTextChangedListener(r5)
            L_0x00a8:
                return
            L_0x00a9:
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                r4.f62430h = r7
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                r4.f62431i = r7
                net.one97.paytm.recharge.creditcard.b.c r4 = r3.f62433a
                r5 = 1
                r4.j = r5
            L_0x00b9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.C1201c.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62432a;

        b(c cVar) {
            this.f62432a = cVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f62432a.k = false;
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this.f62432a.getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f62432a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, Object obj) {
        net.one97.paytm.recharge.creditcard.c.a aVar = this.n;
        if (aVar != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            aVar.a(str, context, str2, (ai) new b(this), obj);
        }
    }

    /* access modifiers changed from: private */
    public final void a(TextView textView, String str) {
        FrameLayout frameLayout = (FrameLayout) a(R.id.creditCardlayout);
        if (frameLayout != null) {
            frameLayout.clearAnimation();
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            if (textView != null) {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                textView.setTextColor(androidx.core.content.b.c(context, R.color.error_color));
            }
            if (textView != null) {
                textView.setText(charSequence);
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.recharge_shake);
            k.a((Object) loadAnimation, "AnimationUtils.loadAnima…t, R.anim.recharge_shake)");
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.creditCardlayout);
            if (frameLayout2 != null) {
                frameLayout2.startAnimation(loadAnimation);
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
            return;
        }
        if (textView != null) {
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(context2, R.color.gray));
        }
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            r9.j = r0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r9.f62428f
            r2 = 0
            if (r1 == 0) goto L_0x0078
            int r1 = r10.length()
            int r3 = r9.p
            if (r1 != r3) goto L_0x0078
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.m.l r3 = new kotlin.m.l
            java.lang.String r4 = " "
            r3.<init>((java.lang.String) r4)
            java.lang.String r5 = ""
            java.lang.String r1 = r3.replace((java.lang.CharSequence) r1, (java.lang.String) r5)
            boolean r1 = com.paytm.utility.b.J((java.lang.String) r1)
            if (r1 == 0) goto L_0x0078
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62427e
            if (r1 == 0) goto L_0x00be
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r9.f62429g
            if (r1 == 0) goto L_0x0046
            if (r1 == 0) goto L_0x0033
            r1.clear()
        L_0x0033:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r9.f62428f
            if (r1 == 0) goto L_0x0046
            java.util.List r1 = r1.getProductList()
            if (r1 == 0) goto L_0x0046
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r9.f62429g
            if (r3 == 0) goto L_0x0046
            java.util.Collection r1 = (java.util.Collection) r1
            r3.addAll(r1)
        L_0x0046:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62427e
            if (r1 == 0) goto L_0x004d
            r1.setCardNumber(r10)
        L_0x004d:
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r9.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r9.a((android.widget.TextView) r1, (java.lang.String) r2)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r9.f62427e
            if (r1 == 0) goto L_0x006b
            java.lang.String r10 = kotlin.m.p.a(r10, r4, r5, r0)
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.m
            int r2 = net.one97.paytm.recharge.common.utils.ba.n
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r10, (java.lang.String) r0, (int) r2)
            r1.setDisplayCardNumber(r10)
        L_0x006b:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r10 = r9.f62427e
            if (r10 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            r9.a((net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r10)
            java.lang.String r10 = "correct"
            goto L_0x00c0
        L_0x0078:
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.paytm.utility.b.c((android.content.Context) r10)
            if (r10 == 0) goto L_0x00b1
            int r10 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0096
            java.lang.CharSequence r10 = r10.getText()
            if (r10 == 0) goto L_0x0096
            java.lang.String r2 = r10.toString()
        L_0x0096:
            r10 = r2
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x00a5
            int r10 = net.one97.paytm.recharge.R.string.enter_valid_cc_number
            java.lang.String r2 = r9.getString(r10)
        L_0x00a5:
            int r10 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r10 = r9.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.a((android.widget.TextView) r10, (java.lang.String) r2)
            goto L_0x00be
        L_0x00b1:
            int r10 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r10 = r9.a((int) r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            if (r10 == 0) goto L_0x00be
            r10.setVisibility(r0)
        L_0x00be:
            java.lang.String r10 = "incorrect"
        L_0x00c0:
            r4 = r10
            net.one97.paytm.recharge.ordersummary.h.d r0 = r9.q
            if (r0 == 0) goto L_0x00d3
            java.lang.String r1 = r9.r
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 112(0x70, float:1.57E-43)
            java.lang.String r2 = "credit_card_number_entered"
            java.lang.String r3 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void a(String str, Context context, String str2, Object obj) {
        if ((str2 != null ? str2.length() : 0) >= 7) {
            String obj2 = p.a(String.valueOf(str2), " ", "", false).subSequence(0, 6).toString();
            this.k = true;
            net.one97.paytm.recharge.creditcard.c.a aVar = this.n;
            if (aVar != null) {
                aVar.a(str, context, obj2, (ai) new e(this), obj);
            }
        }
    }

    public static final class e implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62442a;

        e(c cVar) {
            this.f62442a = cVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f62442a.k = false;
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this.f62442a.getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f62442a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x010c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r11, com.paytm.network.model.IJRPaytmDataModel r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r13 = "tag"
            kotlin.g.b.k.c(r11, r13)
            boolean r11 = r10.isAdded()
            if (r11 == 0) goto L_0x025e
            boolean r11 = r10.isVisible()
            if (r11 == 0) goto L_0x025e
            boolean r11 = r10.isRemoving()
            if (r11 != 0) goto L_0x025e
            boolean r11 = r12 instanceof net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel
            if (r11 == 0) goto L_0x025e
            int r11 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r11 = r10.a((int) r11)
            android.widget.EditText r11 = (android.widget.EditText) r11
            java.lang.String r13 = "etCreditCard"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)
            android.text.Editable r11 = r11.getText()
            int r11 = r11.length()
            r13 = 7
            if (r11 >= r13) goto L_0x0035
            return
        L_0x0035:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel r12 = (net.one97.paytm.recharge.model.creditcard.CJRCreditCardBinModel) r12
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            r13 = 0
            r0 = 1
            if (r11 == 0) goto L_0x0076
            java.lang.String r1 = r11.getResponseCode()
            java.lang.String r2 = "405"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0076
            net.one97.paytm.recharge.di.helper.b r12 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x005c }
            android.content.Context r12 = r10.getContext()     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "credit_card_number_entered"
            java.lang.String r2 = "incorrect"
            java.lang.String r11 = r11.getResponseMessage()     // Catch:{ all -> 0x005c }
            net.one97.paytm.recharge.di.helper.b.b((android.content.Context) r12, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r11)     // Catch:{ all -> 0x005c }
        L_0x005c:
            r10.l = r0
            r10.k = r13
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
        L_0x0076:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            if (r11 == 0) goto L_0x00a0
            java.lang.String r11 = r11.getCardType()
            if (r11 == 0) goto L_0x00a0
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel$Companion r1 = net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel.Companion
            java.lang.String r1 = r1.getDEBIT_CARD_TYPE()
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r0)
            if (r11 == 0) goto L_0x00a0
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.debit_card_not_supported_error
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x00a0:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            if (r11 == 0) goto L_0x00c6
            java.lang.String r11 = r11.isIndian()
            if (r11 == 0) goto L_0x00c6
            java.lang.String r1 = "false"
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r0)
            if (r11 == 0) goto L_0x00c6
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.international_card_not_supported_error
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x00c6:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r12.getBody()
            r1 = 0
            if (r11 == 0) goto L_0x00d2
            java.lang.String r11 = r11.getCardScheme()
            goto L_0x00d3
        L_0x00d2:
            r11 = r1
        L_0x00d3:
            r10.f62426d = r11
            java.lang.String r11 = r10.f62426d
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x024d
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.n
            if (r11 == 0) goto L_0x00e6
            net.one97.paytm.recharge.model.v4.CJRCategoryData r11 = r11.R
            goto L_0x00e7
        L_0x00e6:
            r11 = r1
        L_0x00e7:
            if (r11 == 0) goto L_0x024d
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.n
            if (r11 == 0) goto L_0x00fc
            net.one97.paytm.recharge.model.v4.CJRCategoryData r11 = r11.R
            if (r11 == 0) goto L_0x00fc
            net.one97.paytm.recharge.model.v4.CJRGroupings r11 = r11.getGroupings()
            if (r11 == 0) goto L_0x00fc
            java.util.List r11 = r11.getAggs()
            goto L_0x00fd
        L_0x00fc:
            r11 = r1
        L_0x00fd:
            if (r11 == 0) goto L_0x0140
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r11.iterator()
        L_0x010c:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x013c
            java.lang.Object r3 = r11.next()
            r4 = r3
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r4
            java.lang.String r4 = r4.getBankCode()
            if (r4 == 0) goto L_0x0135
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r5 = r12.getBody()
            if (r5 == 0) goto L_0x012b
            java.lang.String r5 = r5.getIssuingBank()
            if (r5 != 0) goto L_0x012d
        L_0x012b:
            java.lang.String r5 = ""
        L_0x012d:
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r0)
            if (r4 != r0) goto L_0x0135
            r4 = 1
            goto L_0x0136
        L_0x0135:
            r4 = 0
        L_0x0136:
            if (r4 == 0) goto L_0x010c
            r2.add(r3)
            goto L_0x010c
        L_0x013c:
            r11 = r2
            java.util.List r11 = (java.util.List) r11
            goto L_0x0141
        L_0x0140:
            r11 = r1
        L_0x0141:
            if (r11 == 0) goto L_0x023b
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x023b
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r11.iterator()
        L_0x015a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0182
            java.lang.Object r4 = r3.next()
            r5 = r4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r5
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r6 = r12.getBody()
            if (r6 == 0) goto L_0x017b
            boolean r6 = r6.isPaytmFirstCard()
            if (r6 != r0) goto L_0x017b
            boolean r5 = r5.isPaytmFirst()
            if (r5 == 0) goto L_0x017b
            r5 = 1
            goto L_0x017c
        L_0x017b:
            r5 = 0
        L_0x017c:
            if (r5 == 0) goto L_0x015a
            r2.add(r4)
            goto L_0x015a
        L_0x0182:
            java.util.List r2 = (java.util.List) r2
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0197
            java.lang.Object r11 = r2.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            r10.f62428f = r11
            goto L_0x01ce
        L_0x0197:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r11.iterator()
        L_0x01a2:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x01ba
            java.lang.Object r3 = r11.next()
            r4 = r3
            net.one97.paytm.recharge.model.v4.CJRAggsItem r4 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r4
            boolean r4 = r4.isPaytmFirst()
            r4 = r4 ^ r0
            if (r4 == 0) goto L_0x01a2
            r2.add(r3)
            goto L_0x01a2
        L_0x01ba:
            java.util.List r2 = (java.util.List) r2
            r11 = r2
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r0
            if (r11 == 0) goto L_0x01ce
            java.lang.Object r11 = r2.get(r13)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            r10.f62428f = r11
        L_0x01ce:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 != 0) goto L_0x01f8
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = new net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8
            r11.<init>()
            r10.f62427e = r11
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 != 0) goto L_0x01e0
            kotlin.g.b.k.a()
        L_0x01e0:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r13 = r10.f62427e
            if (r13 != 0) goto L_0x01e7
            kotlin.g.b.k.a()
        L_0x01e7:
            int r13 = r13.getIntermediateId()
            r11.setCardTypeId(r13)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 != 0) goto L_0x01f5
            kotlin.g.b.k.a()
        L_0x01f5:
            r11.setEditable(r0)
        L_0x01f8:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 == 0) goto L_0x020b
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r12 = r12.getBody()
            if (r12 == 0) goto L_0x0207
            java.lang.String r12 = r12.getIssuingBank()
            goto L_0x0208
        L_0x0207:
            r12 = r1
        L_0x0208:
            r11.setOperaterName(r12)
        L_0x020b:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 == 0) goto L_0x0214
            java.lang.String r12 = r10.f62426d
            r11.setCardType(r12)
        L_0x0214:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62427e
            if (r11 == 0) goto L_0x0225
            net.one97.paytm.recharge.model.v4.CJRAggsItem r12 = r10.f62428f
            if (r12 == 0) goto L_0x0221
            java.lang.String r12 = r12.getDisplayValue()
            goto L_0x0222
        L_0x0221:
            r12 = r1
        L_0x0222:
            r11.setBankName(r12)
        L_0x0225:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = r10.f62428f
            if (r11 != 0) goto L_0x022c
            kotlin.g.b.k.a()
        L_0x022c:
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.n
            if (r11 == 0) goto L_0x0232
            net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r11.R
        L_0x0232:
            if (r1 != 0) goto L_0x0237
            kotlin.g.b.k.a()
        L_0x0237:
            r10.b()
            return
        L_0x023b:
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
            return
        L_0x024d:
            int r11 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r11 = r10.a((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r12 = r10.getString(r12)
            r10.a((android.widget.TextView) r11, (java.lang.String) r12)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    private final void a(CJRCreditCardModelV8 cJRCreditCardModelV8) {
        String str;
        String str2;
        String str3;
        String operaterName;
        String str4;
        String str5;
        CharSequence hint;
        Editable text;
        String creditCardLength;
        this.f62427e = cJRCreditCardModelV8;
        CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62427e;
        if (cJRCreditCardModelV82 == null || (creditCardLength = cJRCreditCardModelV82.getCreditCardLength()) == null) {
            this.p = 19;
        } else {
            if (creditCardLength.length() > 0) {
                try {
                    if (Integer.parseInt(creditCardLength) == 16) {
                        this.p = Integer.parseInt(creditCardLength) + 3;
                    } else if (Integer.parseInt(creditCardLength) == 14 || Integer.parseInt(creditCardLength) == 15) {
                        this.p = Integer.parseInt(creditCardLength) + 2;
                    }
                } catch (Exception unused) {
                }
            }
            this.p = 19;
        }
        if (getParentFragment() instanceof a) {
            EditText editText = (EditText) a(R.id.etCreditCard);
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            cJRCreditCardModelV8.setDisplayCardNumber(str);
            EditText editText2 = (EditText) a(R.id.etCreditCardHint);
            if (editText2 == null || (hint = editText2.getHint()) == null || (str2 = hint.toString()) == null) {
                str2 = "";
            }
            cJRCreditCardModelV8.setDisplayCardNumberHint(str2);
            HashMap hashMap = null;
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap = new HashMap();
                CardView cardView = (CardView) a(R.id.cc_card_view);
                if (cardView == null || (str4 = cardView.getTransitionName()) == null) {
                    str4 = String.valueOf(R.id.cc_card_view);
                }
                hashMap.put(str4, (CardView) a(R.id.cc_card_view));
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_proceed);
                if (cJRProceedWidgetV8 == null || (str5 = cJRProceedWidgetV8.getTransitionName()) == null) {
                    str5 = String.valueOf(R.id.btn_proceed);
                }
                hashMap.put(str5, (CJRProceedWidgetV8) a(R.id.btn_proceed));
            }
            if (!isAdded() || !isVisible() || isRemoving()) {
                CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: addCardView : NOT started amount screen");
                return;
            }
            CJRRechargeUtilities.INSTANCE.debugLog("CCEnterNumber Screen: addCardView : Start amount screen");
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.q;
            if (dVar != null) {
                String str6 = this.r;
                CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62427e;
                if (cJRCreditCardModelV83 == null || (operaterName = cJRCreditCardModelV83.getOperaterName()) == null) {
                    str3 = "";
                } else {
                    str3 = operaterName;
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str6, Events.Action.PROCEED_CLICKED, "", str3, (Object) null, (Object) null, (Object) null, 112);
            }
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                ((a) parentFragment).a(cJRCreditCardModelV8, false, hashMap, false);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r9 = this;
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
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
            java.lang.String r6 = r9.f62426d
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
            r9.f62428f = r0
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r9.f62429g
            if (r0 == 0) goto L_0x0040
            r0.clear()
        L_0x0040:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x0053
            java.util.List r0 = r0.getProductList()
            if (r0 == 0) goto L_0x0053
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r9.f62429g
            if (r4 == 0) goto L_0x0053
            java.util.Collection r0 = (java.util.Collection) r0
            r4.addAll(r0)
        L_0x0053:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x005c
            java.util.List r0 = r0.getProductList()
            goto L_0x005d
        L_0x005c:
            r0 = r3
        L_0x005d:
            r4 = 0
            if (r0 == 0) goto L_0x0090
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x0069
            java.util.List r0 = r0.getProductList()
            goto L_0x006a
        L_0x0069:
            r0 = r3
        L_0x006a:
            if (r0 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0076
            goto L_0x0090
        L_0x0076:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x007f
            java.util.List r0 = r0.getProductList()
            goto L_0x0080
        L_0x007f:
            r0 = r3
        L_0x0080:
            if (r0 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            boolean r0 = r0.isBillPaymentEnabled()
            goto L_0x0091
        L_0x0090:
            r0 = 0
        L_0x0091:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x025f
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x009e
            java.util.List r5 = r5.getProductList()
            goto L_0x009f
        L_0x009e:
            r5 = r3
        L_0x009f:
            if (r5 == 0) goto L_0x00d1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x00aa
            java.util.List r5 = r5.getProductList()
            goto L_0x00ab
        L_0x00aa:
            r5 = r3
        L_0x00ab:
            if (r5 != 0) goto L_0x00b0
            kotlin.g.b.k.a()
        L_0x00b0:
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00b7
            goto L_0x00d1
        L_0x00b7:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x00c0
            java.util.List r5 = r5.getProductList()
            goto L_0x00c1
        L_0x00c0:
            r5 = r3
        L_0x00c1:
            if (r5 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            java.lang.String r5 = r5.getCreditCardLength()
            goto L_0x00d2
        L_0x00d1:
            r5 = r3
        L_0x00d2:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x010a
            if (r5 != 0) goto L_0x00e0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x010a }
        L_0x00e0:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x010a }
            r7 = 16
            if (r6 != r7) goto L_0x00f1
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x010a }
            int r5 = r5 + 3
            r9.p = r5     // Catch:{ Exception -> 0x010a }
            goto L_0x010e
        L_0x00f1:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x010a }
            r7 = 14
            if (r6 == r7) goto L_0x0101
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x010a }
            r7 = 15
            if (r6 != r7) goto L_0x010e
        L_0x0101:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x010a }
            int r5 = r5 + 2
            r9.p = r5     // Catch:{ Exception -> 0x010a }
            goto L_0x010e
        L_0x010a:
            r5 = 19
            r9.p = r5
        L_0x010e:
            int r5 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r5 = r9.a((int) r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x0128
            android.text.InputFilter[] r6 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r7 = new android.text.InputFilter$LengthFilter
            int r8 = r9.p
            r7.<init>(r8)
            android.text.InputFilter r7 = (android.text.InputFilter) r7
            r6[r4] = r7
            r5.setFilters(r6)
        L_0x0128:
            int r5 = net.one97.paytm.recharge.R.id.etCreditCardHint
            android.view.View r5 = r9.a((int) r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x0142
            android.text.InputFilter[] r6 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r7 = new android.text.InputFilter$LengthFilter
            int r8 = r9.p
            r7.<init>(r8)
            android.text.InputFilter r7 = (android.text.InputFilter) r7
            r6[r4] = r7
            r5.setFilters(r6)
        L_0x0142:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x0153
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62428f
            if (r6 == 0) goto L_0x014f
            java.lang.String r6 = r6.getImageUrl()
            goto L_0x0150
        L_0x014f:
            r6 = r3
        L_0x0150:
            r5.setOperaterImage(r6)
        L_0x0153:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x015c
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62428f
            r5.setSelectedDCVariant(r6)
        L_0x015c:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x0165
            java.util.List r5 = r5.getProductList()
            goto L_0x0166
        L_0x0165:
            r5 = r3
        L_0x0166:
            if (r5 == 0) goto L_0x01a0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x0171
            java.util.List r5 = r5.getProductList()
            goto L_0x0172
        L_0x0171:
            r5 = r3
        L_0x0172:
            if (r5 != 0) goto L_0x0177
            kotlin.g.b.k.a()
        L_0x0177:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x01a0
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x01a0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r9.f62428f
            if (r6 == 0) goto L_0x018d
            java.util.List r6 = r6.getProductList()
            goto L_0x018e
        L_0x018d:
            r6 = r3
        L_0x018e:
            if (r6 != 0) goto L_0x0193
            kotlin.g.b.k.a()
        L_0x0193:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getImage()
            r5.setOperaterCardTypeImage(r6)
        L_0x01a0:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x01af
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x01af
            java.util.List r5 = r5.getProductList()
            goto L_0x01b0
        L_0x01af:
            r5 = r3
        L_0x01b0:
            if (r5 == 0) goto L_0x0218
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x01c1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r5.getSelectedDCVariant()
            if (r5 == 0) goto L_0x01c1
            java.util.List r5 = r5.getProductList()
            goto L_0x01c2
        L_0x01c1:
            r5 = r3
        L_0x01c2:
            if (r5 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0218
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x01f4
            if (r5 == 0) goto L_0x01e1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r5.getSelectedDCVariant()
            if (r6 == 0) goto L_0x01e1
            java.util.List r6 = r6.getProductList()
            goto L_0x01e2
        L_0x01e1:
            r6 = r3
        L_0x01e2:
            if (r6 != 0) goto L_0x01e7
            kotlin.g.b.k.a()
        L_0x01e7:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getDisclaimer()
            r5.setDisclaimer(r6)
        L_0x01f4:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r5 = r9.f62427e
            if (r5 == 0) goto L_0x0218
            if (r5 == 0) goto L_0x0205
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = r5.getSelectedDCVariant()
            if (r6 == 0) goto L_0x0205
            java.util.List r6 = r6.getProductList()
            goto L_0x0206
        L_0x0205:
            r6 = r3
        L_0x0206:
            if (r6 != 0) goto L_0x020b
            kotlin.g.b.k.a()
        L_0x020b:
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r6 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r6
            java.lang.String r6 = r6.getCreditCardLength()
            r5.setCreditCardLength(r6)
        L_0x0218:
            int r5 = net.one97.paytm.recharge.R.id.lyt_outer_container
            android.view.View r5 = r9.a((int) r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r9.f62427e
            if (r6 == 0) goto L_0x0229
            java.lang.String r6 = r6.getCardType()
            goto L_0x022a
        L_0x0229:
            r6 = r3
        L_0x022a:
            net.one97.paytm.recharge.common.utils.ba.a((android.view.View) r5, (java.lang.String) r6)
            android.content.Context r5 = r9.getContext()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r9.f62427e
            if (r6 == 0) goto L_0x023a
            java.lang.String r6 = r6.getOperaterImage()
            goto L_0x023b
        L_0x023a:
            r6 = r3
        L_0x023b:
            int r7 = net.one97.paytm.recharge.R.id.img_bank
            android.view.View r7 = r9.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r5, (java.lang.String) r6, (android.widget.ImageView) r7, (boolean) r2)
            android.content.Context r5 = r9.getContext()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r6 = r9.f62427e
            if (r6 == 0) goto L_0x0253
            java.lang.String r6 = r6.getOperaterCardTypeImage()
            goto L_0x0254
        L_0x0253:
            r6 = r3
        L_0x0254:
            int r7 = net.one97.paytm.recharge.R.id.cardtypeView
            android.view.View r7 = r9.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r5, (java.lang.String) r6, (android.widget.ImageView) r7, (boolean) r2)
        L_0x025f:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x0268
            java.util.List r5 = r5.getProductList()
            goto L_0x0269
        L_0x0268:
            r5 = r3
        L_0x0269:
            if (r5 == 0) goto L_0x02a9
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x0274
            java.util.List r5 = r5.getProductList()
            goto L_0x0275
        L_0x0274:
            r5 = r3
        L_0x0275:
            if (r5 != 0) goto L_0x027a
            kotlin.g.b.k.a()
        L_0x027a:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x02a9
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.b()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r9.f62428f
            if (r5 == 0) goto L_0x0292
            java.util.List r5 = r5.getProductList()
            goto L_0x0293
        L_0x0292:
            r5 = r3
        L_0x0293:
            if (r5 != 0) goto L_0x0298
            kotlin.g.b.k.a()
        L_0x0298:
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            java.lang.Long r5 = r5.getProductId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.setProductId(r5)
        L_0x02a9:
            if (r0 != 0) goto L_0x02fa
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x02b5
            java.lang.String r0 = r0.getDisplayValue()
            if (r0 != 0) goto L_0x02b6
        L_0x02b5:
            r0 = r1
        L_0x02b6:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02da
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r9.f62428f
            if (r2 == 0) goto L_0x02cd
            java.lang.String r2 = r2.getDisplayValue()
            goto L_0x02ce
        L_0x02cd:
            r2 = r3
        L_0x02ce:
            r1.append(r2)
            java.lang.String r2 = " "
            r1.append(r2)
            r1.append(r0)
            goto L_0x02e1
        L_0x02da:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r9.f62428f
            if (r0 == 0) goto L_0x02e1
            r0.getDisplayValue()
        L_0x02e1:
            int r0 = net.one97.paytm.recharge.R.string.payment_of_this_credit_card_is_currently_not_supported
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r1 = "getString(R.string.payme…_currently_not_supported)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r9.f62428f = r3
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r9.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r9.a((android.widget.TextView) r1, (java.lang.String) r0)
            return
        L_0x02fa:
            int r0 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r0 = r9.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.a((android.widget.TextView) r0, (java.lang.String) r3)
            boolean r0 = r9.j
            if (r0 == 0) goto L_0x0349
            boolean r0 = r9.f62431i
            if (r0 == 0) goto L_0x0349
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r9.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0346
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0346
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x0346
            int r0 = r0.length()
            int r2 = r9.p
            if (r0 != r2) goto L_0x0346
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r9.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0341
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0341
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0342
        L_0x0341:
            r0 = r1
        L_0x0342:
            r9.a((java.lang.String) r0)
            return
        L_0x0346:
            r9.j = r4
            return
        L_0x0349:
            boolean r0 = r9.m
            if (r0 == 0) goto L_0x0350
            r9.c()
        L_0x0350:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.b():void");
    }

    private final void b(String str) {
        String str2;
        String operaterName;
        List<CJRProductsItem> list;
        if (str != null) {
            if (str.length() >= this.p) {
                if (this.f62428f != null) {
                    if (com.paytm.utility.b.J(new l(" ").replace((CharSequence) str, ""))) {
                        if (this.f62427e != null) {
                            List<CJRProductsItem> list2 = this.f62429g;
                            if (list2 != null) {
                                if (list2 != null) {
                                    list2.clear();
                                }
                                CJRAggsItem cJRAggsItem = this.f62428f;
                                if (cJRAggsItem == null) {
                                    k.a();
                                }
                                List<CJRProductsItem> productList = cJRAggsItem.getProductList();
                                if (!(productList == null || (list = this.f62429g) == null)) {
                                    list.addAll(productList);
                                }
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62427e;
                            if (cJRCreditCardModelV8 != null) {
                                cJRCreditCardModelV8.setCardNumber(str.toString());
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62427e;
                            if (cJRCreditCardModelV82 != null) {
                                cJRCreditCardModelV82.setDisplayCardNumber(ba.a(p.a(str.toString(), " ", "", false), ba.m, ba.n));
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62427e;
                            if (cJRCreditCardModelV83 == null) {
                                k.a();
                            }
                            a(cJRCreditCardModelV83);
                            net.one97.paytm.recharge.ordersummary.h.d dVar = this.q;
                            if (dVar != null) {
                                String str3 = this.r;
                                CJRCreditCardModelV8 cJRCreditCardModelV84 = this.f62427e;
                                if (cJRCreditCardModelV84 == null || (operaterName = cJRCreditCardModelV84.getOperaterName()) == null) {
                                    str2 = "";
                                } else {
                                    str2 = operaterName;
                                }
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str3, Events.Action.PROCEED_CLICKED, "", str2, (Object) null, (Object) null, (Object) null, 112);
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
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0) {
            ay ayVar = ay.f61523a;
            ay.a(i2);
        } else if (getActivity() != null && !TextUtils.isEmpty(this.o) && this.o.length() >= 7 && com.paytm.utility.b.c((Context) getActivity())) {
            String a2 = p.a(this.o, " ", "", false);
            if (a2 != null) {
                String substring = a2.substring(0, 6);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
                    a("fetchbin_api", substring, a3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_proceed;
        if (valueOf != null && valueOf.intValue() == i2) {
            c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r6 = this;
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r0 = r6.f62427e
            r1 = 0
            if (r0 != 0) goto L_0x0138
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
            boolean r2 = r6.k
            if (r2 == 0) goto L_0x0095
            int r1 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r1 = r6.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.a((android.widget.TextView) r1, (java.lang.String) r0)
            return
        L_0x0095:
            android.content.Context r0 = r6.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0110
            r0 = 1
            r6.m = r0
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
            r6.o = r0
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
            java.lang.String r3 = "fetchbin_api"
            r6.a((java.lang.String) r3, (android.content.Context) r2, (java.lang.String) r1, (java.lang.Object) r0)
            return
        L_0x0110:
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CC_BIN
            android.content.Context r4 = r6.getContext()
            if (r4 == 0) goto L_0x0127
            int r5 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0128
        L_0x0127:
            r4 = r1
        L_0x0128:
            android.content.Context r5 = r6.getContext()
            if (r5 == 0) goto L_0x0134
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r5.getString(r1)
        L_0x0134:
            net.one97.paytm.recharge.common.utils.az.a(r0, r2, r3, r4, r1)
            return
        L_0x0138:
            if (r0 == 0) goto L_0x0143
            boolean r0 = r0.isEditable()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0144
        L_0x0143:
            r0 = r1
        L_0x0144:
            if (r0 != 0) goto L_0x0149
            kotlin.g.b.k.a()
        L_0x0149:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0166
            int r0 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r0 = r6.a((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0163
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0163
            java.lang.String r1 = r0.toString()
        L_0x0163:
            r6.b((java.lang.String) r1)
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.c.c():void");
    }
}

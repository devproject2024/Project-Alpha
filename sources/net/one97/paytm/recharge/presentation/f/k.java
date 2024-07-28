package net.one97.paytm.recharge.presentation.f;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.g;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.domain.entities.CJRBankToken;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.widgets.c.g;
import net.one97.paytm.recharge.widgets.c.h;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import org.json.JSONObject;

public final class k extends f implements View.OnClickListener, TextView.OnEditorActionListener, g<CJRTaggedObservable<?>>, g.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final TextView f64894a = ((TextView) this.o.findViewById(R.id.txt_bank_name));
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f64895b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f64896c;

    /* renamed from: d  reason: collision with root package name */
    private final View f64897d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final CJRProceedWidgetV8 f64898e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final TextView f64899f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final RadioButton f64900g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final View f64901h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f64902i;
    private final net.one97.paytm.recharge.widgets.c.g j;
    private boolean k;
    private Object l;
    private final String m;
    private int n;
    /* access modifiers changed from: private */
    public final View o;
    private String p;
    private String q;
    private String r;
    private String s;
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.presentation.d.d t;
    private final String u;
    private final String v;
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.presentation.d.c w;

    public final void a(View view, CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(View view, String str, String str2, String str3, String str4, net.one97.paytm.recharge.presentation.d.d dVar, String str5, String str6, net.one97.paytm.recharge.presentation.d.c cVar) {
        super(view);
        kotlin.g.b.k.c(view, "mItemView");
        this.o = view;
        this.p = str;
        this.q = str2;
        this.r = str3;
        this.s = str4;
        this.t = dVar;
        this.u = str5;
        this.v = str6;
        this.w = cVar;
        View findViewById = this.itemView.findViewById(R.id.txt_masked_card_number);
        kotlin.g.b.k.a((Object) findViewById, "itemView.findViewById(R.id.txt_masked_card_number)");
        this.f64895b = findViewById;
        this.f64896c = (EditText) this.o.findViewById(R.id.edtxt_cvv);
        this.f64897d = this.o.findViewById(R.id.ic_card);
        this.f64898e = (CJRProceedWidgetV8) this.o.findViewById(R.id.btn_set_up_automatic);
        this.f64899f = (TextView) this.o.findViewById(R.id.txt_input_error);
        this.f64900g = (RadioButton) this.o.findViewById(R.id.radio_btn);
        this.f64901h = this.o.findViewById(R.id.lyt_enter_cvv);
        this.f64902i = (TextView) this.o.findViewById(R.id.txt_tnc);
        this.j = new net.one97.paytm.recharge.widgets.c.g(this.f64896c, this);
        this.m = "AMEX";
        this.n = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0168, code lost:
        if (kotlin.m.p.a(r1, r7, true) == true) goto L_0x016a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void a(T r13) {
        /*
            r12 = this;
            r12.l = r13
            r0 = 0
            r12.k = r0
            android.widget.RadioButton r1 = r12.f64900g
            java.lang.String r2 = "radioBtn"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r3 = 1
            r1.setEnabled(r3)
            android.widget.RadioButton r1 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.setChecked(r0)
            android.widget.TextView r1 = r12.f64894a
            java.lang.String r4 = "tvBankName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setEnabled(r3)
            android.view.View r1 = r12.f64895b
            r1.setEnabled(r3)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = r12.f64898e
            java.lang.String r5 = "proceedBtn"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setEnabled(r3)
            android.widget.TextView r1 = r12.f64899f
            java.lang.String r6 = "tvInputError"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r6 = 8
            r1.setVisibility(r6)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = r12.f64898e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = r12.f64898e
            r1.b()
            android.view.View r1 = r12.f64895b
            r7 = 0
            r1.setOnClickListener(r7)
            android.view.View r1 = r12.o
            r1.requestFocus()
            android.widget.EditText r1 = r12.f64896c
            net.one97.paytm.recharge.widgets.c.g r8 = r12.j
            android.text.TextWatcher r8 = (android.text.TextWatcher) r8
            r1.removeTextChangedListener(r8)
            android.widget.EditText r1 = r12.f64896c
            if (r1 == 0) goto L_0x0069
            java.lang.String r8 = ""
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x0069:
            android.widget.EditText r1 = r12.f64896c
            if (r1 == 0) goto L_0x0073
            r8 = r12
            android.widget.TextView$OnEditorActionListener r8 = (android.widget.TextView.OnEditorActionListener) r8
            r1.setOnEditorActionListener(r8)
        L_0x0073:
            android.widget.RadioButton r1 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.setClickable(r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = r12.f64898e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setEnabled(r0)
            boolean r1 = r13 instanceof net.one97.paytm.recharge.domain.entities.CJRSavedInstrument
            if (r1 == 0) goto L_0x009a
            java.lang.String r8 = r12.m
            r9 = r13
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r9 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r9
            java.lang.String r9 = r9.getChannelCode()
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r3)
            if (r8 != 0) goto L_0x009a
            r8 = 3
            r12.n = r8
            goto L_0x009d
        L_0x009a:
            r8 = 4
            r12.n = r8
        L_0x009d:
            android.widget.EditText r8 = r12.f64896c
            if (r8 == 0) goto L_0x00b1
            android.text.InputFilter[] r9 = new android.text.InputFilter[r3]
            android.text.InputFilter$LengthFilter r10 = new android.text.InputFilter$LengthFilter
            int r11 = r12.n
            r10.<init>(r11)
            android.text.InputFilter r10 = (android.text.InputFilter) r10
            r9[r0] = r10
            r8.setFilters(r9)
        L_0x00b1:
            android.widget.EditText r8 = r12.f64896c
            net.one97.paytm.recharge.widgets.c.g r9 = r12.j
            android.text.TextWatcher r9 = (android.text.TextWatcher) r9
            r8.addTextChangedListener(r9)
            java.lang.String r8 = "null cannot be cast to non-null type android.widget.TextView"
            java.lang.String r9 = "icCard"
            java.lang.String r10 = "etCVV"
            if (r1 == 0) goto L_0x01b4
            android.widget.TextView r1 = r12.f64894a
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r4 = r13
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r4 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r4
            java.lang.String r5 = r4.getDisplayName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.EditText r1 = r12.f64896c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r10)
            android.view.View r5 = r12.o
            android.content.res.Resources r5 = r5.getResources()
            int r10 = net.one97.paytm.recharge.automatic.R.string.enter_cvv
            java.lang.String r5 = r5.getString(r10)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setHint(r5)
            android.view.View r1 = r12.f64897d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            r1.setVisibility(r0)
            android.view.View r1 = r12.f64895b
            if (r1 == 0) goto L_0x01ae
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r5 = r4.getMaskCardNumber()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r5 = r4.getIconUrl()
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r5)
            android.view.View r5 = r12.o
            int r8 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r5 = r5.findViewById(r8)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r1.a((android.widget.ImageView) r5)
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r1 = r4.getCardDetails()
            if (r1 == 0) goto L_0x0124
            java.lang.String r1 = r1.getCardId()
            goto L_0x0125
        L_0x0124:
            r1 = r7
        L_0x0125:
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0140
            java.lang.String r5 = r12.p
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0140
            java.lang.String r5 = r12.p
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r0)
            if (r1 != 0) goto L_0x016a
        L_0x0140:
            java.lang.String r1 = r12.q
            if (r1 == 0) goto L_0x016c
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r5 = r4.getCardDetails()
            if (r5 == 0) goto L_0x014f
            java.lang.String r5 = r5.getFirstFourDigits()
            goto L_0x0150
        L_0x014f:
            r5 = r7
        L_0x0150:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r3)
            if (r1 != r3) goto L_0x016c
            java.lang.String r1 = r12.r
            if (r1 == 0) goto L_0x016c
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r5 = r4.getCardDetails()
            if (r5 == 0) goto L_0x0164
            java.lang.String r7 = r5.getLastFourDigit()
        L_0x0164:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r3)
            if (r1 != r3) goto L_0x016c
        L_0x016a:
            r1 = 1
            goto L_0x016d
        L_0x016c:
            r1 = 0
        L_0x016d:
            if (r1 == 0) goto L_0x017b
            r12.a((int) r6)
            android.widget.RadioButton r0 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setChecked(r3)
            goto L_0x0198
        L_0x017b:
            boolean r1 = r4.isSelected()
            if (r1 == 0) goto L_0x018d
            android.widget.RadioButton r1 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.setChecked(r3)
            r12.a((int) r0)
            goto L_0x0198
        L_0x018d:
            r12.a((int) r6)
            android.widget.RadioButton r1 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r1.setChecked(r0)
        L_0x0198:
            android.view.View r0 = r12.o
            net.one97.paytm.recharge.presentation.f.k$a r1 = new net.one97.paytm.recharge.presentation.f.k$a
            r1.<init>(r12, r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r13 = r12.f64898e
            r0 = r12
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
            goto L_0x02d2
        L_0x01ae:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r8)
            throw r13
        L_0x01b4:
            boolean r1 = r13 instanceof net.one97.paytm.recharge.domain.entities.CJRPaymentModes
            if (r1 == 0) goto L_0x02d2
            r12.k = r3
            android.widget.TextView r1 = r12.f64894a
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.view.View r4 = r12.o
            if (r4 == 0) goto L_0x01d0
            android.content.Context r4 = r4.getContext()
            if (r4 == 0) goto L_0x01d0
            int r11 = net.one97.paytm.recharge.automatic.R.string.paytm_payment_bank
            java.lang.String r4 = r4.getString(r11)
            goto L_0x01d1
        L_0x01d0:
            r4 = r7
        L_0x01d1:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.view.View r1 = r12.f64895b
            if (r1 == 0) goto L_0x02cc
            android.widget.TextView r1 = (android.widget.TextView) r1
            r4 = r13
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r4 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r4
            boolean r8 = r4.isInsufficientBalance()
            if (r8 != 0) goto L_0x02c8
            android.widget.EditText r8 = r12.f64896c
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            android.view.View r10 = r12.o
            android.content.res.Resources r10 = r10.getResources()
            int r11 = net.one97.paytm.recharge.automatic.R.string.pa_hint_ppbl_passcode
            java.lang.String r10 = r10.getString(r11)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8.setHint(r10)
            android.view.View r8 = r12.f64897d
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r8.setVisibility(r6)
            net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse r8 = r4.getAvailableBalance()
            if (r8 != 0) goto L_0x0241
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            android.view.View r9 = r12.o
            android.content.res.Resources r9 = r9.getResources()
            int r10 = net.one97.paytm.recharge.automatic.R.string.pa_check_balance
            java.lang.String r9 = r9.getString(r10)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.<init>(r9)
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            android.view.View r10 = r12.o
            android.content.Context r10 = r10.getContext()
            int r11 = net.one97.paytm.recharge.automatic.R.color.color_00b9f5
            int r10 = androidx.core.content.b.c(r10, r11)
            r9.<init>(r10)
            int r10 = r8.length()
            r11 = 33
            r8.setSpan(r9, r0, r10, r11)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
            r8 = r12
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r1.setOnClickListener(r8)
        L_0x0241:
            java.lang.String r8 = r4.getPaymentMode()
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0262
            java.lang.String r9 = r12.s
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0262
            java.lang.String r9 = r12.s
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r0)
            if (r8 == 0) goto L_0x0262
            r8 = 1
            goto L_0x0263
        L_0x0262:
            r8 = 0
        L_0x0263:
            android.view.View r9 = r12.o
            int r10 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r9 = r9.findViewById(r10)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x027e
            android.view.View r10 = r12.o
            android.content.Context r10 = r10.getContext()
            int r11 = net.one97.paytm.recharge.automatic.R.drawable.ic_recharge_paytm_logo
            android.graphics.drawable.Drawable r10 = androidx.core.content.b.a((android.content.Context) r10, (int) r11)
            r9.setImageDrawable(r10)
        L_0x027e:
            if (r8 == 0) goto L_0x028c
            r12.a((int) r6)
            android.widget.RadioButton r4 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            r4.setChecked(r3)
            goto L_0x02ab
        L_0x028c:
            boolean r4 = r4.isSelected()
            if (r4 == 0) goto L_0x02a0
            r12.s = r7
            r12.a((int) r0)
            android.widget.RadioButton r4 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            r4.setChecked(r3)
            goto L_0x02ab
        L_0x02a0:
            r12.a((int) r6)
            android.widget.RadioButton r3 = r12.f64900g
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            r3.setChecked(r0)
        L_0x02ab:
            android.view.View r2 = r12.o
            net.one97.paytm.recharge.presentation.f.k$b r3 = new net.one97.paytm.recharge.presentation.f.k$b
            r3.<init>(r12, r13, r1)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r13 = r12.f64898e
            r1 = r12
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r13.setOnClickListener(r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r13 = r12.f64898e
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r5)
            r13.setVisibility(r0)
            goto L_0x02d2
        L_0x02c8:
            r12.b()
            goto L_0x02d2
        L_0x02cc:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r8)
            throw r13
        L_0x02d2:
            r12.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.f.k.a(java.lang.Object):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f64903a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64904b;

        a(k kVar, Object obj) {
            this.f64903a = kVar;
            this.f64904b = obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
            r3 = r3.getCardType();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                net.one97.paytm.recharge.presentation.f.k r3 = r2.f64903a
                android.view.View r3 = r3.f64901h
                java.lang.String r0 = "cvvLayout"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                int r3 = r3.getVisibility()
                if (r3 != 0) goto L_0x0012
                return
            L_0x0012:
                java.lang.Object r3 = r2.f64904b
                net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r3 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r3
                r0 = 1
                r3.setSelected(r0)
                net.one97.paytm.recharge.presentation.f.k r3 = r2.f64903a
                r1 = 0
                r3.a((int) r1)
                net.one97.paytm.recharge.presentation.f.k r3 = r2.f64903a
                android.widget.RadioButton r3 = r3.f64900g
                java.lang.String r1 = "radioBtn"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
                r3.setChecked(r0)
                java.lang.Object r3 = r2.f64904b
                net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r3 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r3
                net.one97.paytm.recharge.domain.entities.CJRCardDetails r3 = r3.getCardDetails()
                if (r3 == 0) goto L_0x0049
                java.lang.String r3 = r3.getCardType()
                if (r3 == 0) goto L_0x0049
                java.lang.String r1 = "CREDIT_CARD"
                boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r0)
                if (r3 != r0) goto L_0x0049
                java.lang.String r3 = "credit card"
                goto L_0x004b
            L_0x0049:
                java.lang.String r3 = "debit card"
            L_0x004b:
                net.one97.paytm.recharge.presentation.f.k r0 = r2.f64903a
                net.one97.paytm.recharge.presentation.f.k.a((net.one97.paytm.recharge.presentation.f.k) r0, (java.lang.String) r3)
                net.one97.paytm.recharge.presentation.f.k r3 = r2.f64903a
                net.one97.paytm.recharge.presentation.d.d r3 = r3.t
                if (r3 == 0) goto L_0x0062
                net.one97.paytm.recharge.presentation.f.k r0 = r2.f64903a
                int r0 = r0.getAdapterPosition()
                r1 = 2
                r3.a(r0, r1)
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.f.k.a.onClick(android.view.View):void");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f64905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64906b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f64907c;

        b(k kVar, Object obj, TextView textView) {
            this.f64905a = kVar;
            this.f64906b = obj;
            this.f64907c = textView;
        }

        public final void onClick(View view) {
            Object obj = this.f64906b;
            if (obj == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPaymentModes");
            } else if (!((CJRPaymentModes) obj).isInsufficientBalance()) {
                this.f64907c.performClick();
                View a2 = this.f64905a.f64901h;
                kotlin.g.b.k.a((Object) a2, "cvvLayout");
                if (a2.getVisibility() != 0) {
                    ((CJRPaymentModes) this.f64906b).setSelected(true);
                    this.f64905a.a(0);
                    RadioButton b2 = this.f64905a.f64900g;
                    kotlin.g.b.k.a((Object) b2, "radioBtn");
                    b2.setChecked(true);
                    k.a(this.f64905a, BaseViewModel.PaymentType.PPB);
                    net.one97.paytm.recharge.presentation.d.d c2 = this.f64905a.t;
                    if (c2 != null) {
                        c2.a(this.f64905a.getAdapterPosition(), 3);
                    }
                }
            }
        }
    }

    private final void a() {
        String string = this.o.getContext().getString(R.string.tnc_automatic_select_card);
        kotlin.g.b.k.a((Object) string, "mItemView.context.getStr…nc_automatic_select_card)");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        c cVar = new c(this);
        String string2 = this.o.getContext().getString(R.string.index_term);
        kotlin.g.b.k.a((Object) string2, "mItemView.context.getString(R.string.index_term)");
        int a2 = p.a(charSequence, string2, 0, false, 6);
        if (a2 >= 0) {
            spannableString.setSpan(cVar, a2, string.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.o.getContext(), R.color.color_00b9f5)), a2, string.length(), 33);
            TextView textView = this.f64902i;
            if (textView != null) {
                textView.setText(spannableString);
            }
            TextView textView2 = this.f64902i;
            kotlin.g.b.k.a((Object) textView2, "tnCTextView");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f64908a;

        c(k kVar) {
            this.f64908a = kVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            if (!com.paytm.utility.b.c(this.f64908a.o.getContext())) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this.f64908a.o.getContext();
                if (context != null) {
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, (NetworkCustomError) new h(), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
            net.one97.paytm.recharge.presentation.d.c e2 = this.f64908a.w;
            if (e2 != null) {
                e2.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        View findViewById = this.o.findViewById(R.id.lyt_term_condition);
        kotlin.g.b.k.a((Object) findViewById, "mItemView.findViewById<V…(R.id.lyt_term_condition)");
        findViewById.setVisibility(i2);
        View view = this.f64901h;
        kotlin.g.b.k.a((Object) view, "cvvLayout");
        view.setVisibility(i2);
        View findViewById2 = this.o.findViewById(R.id.empty_view);
        kotlin.g.b.k.a((Object) findViewById2, "mItemView.findViewById<View>(R.id.empty_view)");
        findViewById2.setVisibility(i2);
    }

    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (6 != i2) {
            return false;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f64898e;
        kotlin.g.b.k.a((Object) cJRProceedWidgetV8, "proceedBtn");
        if (!cJRProceedWidgetV8.isEnabled()) {
            return true;
        }
        onClick(this.f64898e);
        return true;
    }

    public final void a(View view, Editable editable) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        EditText editText = this.f64896c;
        kotlin.g.b.k.a((Object) editText, "etCVV");
        int id = editText.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : afterTextChanged : Payment Option [" + getAdapterPosition() + "] : CVV");
            if (String.valueOf(editable).length() == this.n) {
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f64898e;
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.setEnabled(true);
                }
                h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                EditText editText2 = this.f64896c;
                kotlin.g.b.k.a((Object) editText2, "etCVV");
                Context context = editText2.getContext();
                kotlin.g.b.k.a((Object) context, "etCVV.context");
                EditText editText3 = this.f64896c;
                kotlin.g.b.k.a((Object) editText3, "etCVV");
                h.a.a(context, (View) editText3);
            } else if (String.valueOf(editable).length() < this.n) {
                TextView textView = this.f64899f;
                kotlin.g.b.k.a((Object) textView, "tvInputError");
                if (textView.getVisibility() == 0) {
                    TextView textView2 = this.f64899f;
                    kotlin.g.b.k.a((Object) textView2, "tvInputError");
                    textView2.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r2 = r2.getCardType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0026
            int r0 = r9.getId()
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_masked_card_number
            if (r0 != r1) goto L_0x0026
            boolean r0 = r8.k
            if (r0 == 0) goto L_0x0026
            net.one97.paytm.recharge.automatic.b.a.h$a r9 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r9 = "PaymentOptionViewHolder : onClick() : Check-Balance"
            net.one97.paytm.recharge.automatic.b.a.h.a.e(r9)
            net.one97.paytm.recharge.presentation.d.c r9 = r8.w
            if (r9 == 0) goto L_0x0025
            io.reactivex.rxjava3.j.c r9 = r9.b()
            if (r9 == 0) goto L_0x0025
            r0 = r8
            io.reactivex.rxjava3.d.g r0 = (io.reactivex.rxjava3.d.g) r0
            r9.subscribe(r0)
        L_0x0025:
            return
        L_0x0026:
            if (r9 == 0) goto L_0x0182
            int r0 = r9.getId()
            int r1 = net.one97.paytm.recharge.automatic.R.id.btn_set_up_automatic
            if (r0 != r1) goto L_0x0182
            boolean r0 = r9 instanceof net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8
            if (r0 == 0) goto L_0x0182
            android.view.View r0 = r8.o
            android.content.Context r0 = r0.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 != 0) goto L_0x0060
            net.one97.paytm.recharge.automatic.c.a.a r9 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            android.view.View r9 = r8.o
            android.content.Context r9 = r9.getContext()
            if (r9 == 0) goto L_0x0058
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.recharge.widgets.c.h r0 = new net.one97.paytm.recharge.widgets.c.h
            r0.<init>()
            com.paytm.network.model.NetworkCustomError r0 = (com.paytm.network.model.NetworkCustomError) r0
            net.one97.paytm.recharge.automatic.c.a.a.a((android.app.Activity) r9, (com.paytm.network.model.NetworkCustomError) r0, (int) r1)
            return
        L_0x0058:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
            r9.<init>(r0)
            throw r9
        L_0x0060:
            android.widget.TextView r0 = r8.f64899f
            java.lang.String r2 = "tvInputError"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r3 = 8
            r0.setVisibility(r3)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r9
            r9.setEnabled(r1)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.Object r3 = r8.l
            boolean r4 = r3 instanceof net.one97.paytm.recharge.domain.entities.CJRSavedInstrument
            java.lang.String r5 = "card_cvv"
            java.lang.String r6 = "mItemView.findViewById<EditText>(R.id.edtxt_cvv)"
            r7 = 1
            if (r4 == 0) goto L_0x00ff
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRSavedInstrument"
            if (r3 == 0) goto L_0x00f9
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r3 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r3
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r2 = r3.getCardDetails()
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = r2.getCardType()
            if (r2 == 0) goto L_0x009e
            java.lang.String r3 = "CREDIT_CARD"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r7)
            if (r2 != r7) goto L_0x009e
            java.lang.String r2 = "credit card"
            goto L_0x00a0
        L_0x009e:
            java.lang.String r2 = "debit card"
        L_0x00a0:
            r8.a((java.lang.String) r2)
            android.view.View r2 = r8.o
            int r3 = net.one97.paytm.recharge.automatic.R.id.edtxt_cvv
            android.view.View r2 = r2.findViewById(r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            android.widget.EditText r2 = (android.widget.EditText) r2
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r0.putString(r5, r2)
            java.lang.Object r2 = r8.l
            if (r2 == 0) goto L_0x00f3
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r2 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r2
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r2 = r2.getCardDetails()
            if (r2 == 0) goto L_0x00cc
            java.lang.String r2 = r2.getCardId()
            goto L_0x00cd
        L_0x00cc:
            r2 = 0
        L_0x00cd:
            java.lang.String r3 = "card_id"
            r0.putString(r3, r2)
            java.lang.Object r2 = r8.l
            if (r2 == 0) goto L_0x00ed
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r2 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r2
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r1 = r2.getCardDetails()
            if (r1 == 0) goto L_0x00e4
            java.lang.String r1 = r1.getCardType()
            if (r1 != 0) goto L_0x00e6
        L_0x00e4:
            java.lang.String r1 = ""
        L_0x00e6:
            java.lang.String r2 = "card_type"
            r0.putString(r2, r1)
            goto L_0x0174
        L_0x00ed:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r1)
            throw r9
        L_0x00f3:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r1)
            throw r9
        L_0x00f9:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r1)
            throw r9
        L_0x00ff:
            boolean r3 = r3 instanceof net.one97.paytm.recharge.domain.entities.CJRPaymentModes
            if (r3 == 0) goto L_0x0174
            java.lang.String r3 = "ppb"
            r8.a((java.lang.String) r3)
            android.view.View r3 = r8.o
            int r4 = net.one97.paytm.recharge.automatic.R.id.edtxt_cvv
            android.view.View r3 = r3.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            android.widget.EditText r3 = (android.widget.EditText) r3
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0152
            int r4 = r3.length()
            r6 = 4
            if (r4 < r6) goto L_0x0152
            r0.putString(r5, r3)
            android.view.View r1 = r8.o
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = "mItemView.context"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.recharge.presentation.f.k$e r2 = new net.one97.paytm.recharge.presentation.f.k$e
            r2.<init>(r8, r1, r3)
            io.reactivex.rxjava3.a.ab r2 = (io.reactivex.rxjava3.a.ab) r2
            io.reactivex.rxjava3.a.y r1 = io.reactivex.rxjava3.a.y.a(r2)
            io.reactivex.rxjava3.a.x r2 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.y r1 = r1.b((io.reactivex.rxjava3.a.x) r2)
            r1.d()
            goto L_0x0174
        L_0x0152:
            android.widget.TextView r0 = r8.f64899f
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r3 = r8.o
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.recharge.automatic.R.string.pa_error_enter_passcode
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.widget.TextView r0 = r8.f64899f
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r1)
            r9.setEnabled(r7)
            return
        L_0x0174:
            r9.a()
            net.one97.paytm.recharge.presentation.d.c r9 = r8.w
            if (r9 == 0) goto L_0x0182
            int r1 = r8.getAdapterPosition()
            r9.a(r1, r0)
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.f.k.onClick(android.view.View):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r1 = (r1 = r1.getBody()).getBalanceInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.l
            if (r0 == 0) goto L_0x0071
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r0 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r0
            net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse r1 = r0.getAvailableBalance()
            r2 = 0
            if (r1 == 0) goto L_0x001e
            net.one97.paytm.nativesdk.paymethods.model.fetchBalance.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x001e
            net.one97.paytm.nativesdk.paymethods.model.fetchBalance.BalanceInfo r1 = r1.getBalanceInfo()
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.getValue()
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            net.one97.paytm.recharge.automatic.b.a.h$a r3 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "PaymentOptionViewHolder : updatePPBLViewOnAvailableBalance() : "
            r3.<init>(r4)
            if (r1 != 0) goto L_0x002d
            java.lang.String r4 = ""
            goto L_0x002e
        L_0x002d:
            r4 = r1
        L_0x002e:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            net.one97.paytm.recharge.automatic.b.a.h.a.e(r3)
            net.one97.paytm.recharge.presentation.d.c r3 = r5.w
            if (r3 == 0) goto L_0x0040
            java.lang.String r2 = r3.c()
        L_0x0040:
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0070
            android.view.View r3 = r5.o
            android.content.Context r3 = r3.getContext()
            boolean r3 = r3 instanceof android.app.Activity
            if (r3 == 0) goto L_0x0070
            android.view.View r3 = r5.o
            android.content.Context r3 = r3.getContext()
            if (r3 == 0) goto L_0x0068
            android.app.Activity r3 = (android.app.Activity) r3
            net.one97.paytm.recharge.presentation.f.k$d r4 = new net.one97.paytm.recharge.presentation.f.k$d
            r4.<init>(r5, r1, r2, r0)
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.runOnUiThread(r4)
            goto L_0x0070
        L_0x0068:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            throw r0
        L_0x0070:
            return
        L_0x0071:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPaymentModes"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.f.k.b():void");
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f64909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f64910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f64911c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRPaymentModes f64912d;

        d(k kVar, String str, String str2, CJRPaymentModes cJRPaymentModes) {
            this.f64909a = kVar;
            this.f64910b = str;
            this.f64911c = str2;
            this.f64912d = cJRPaymentModes;
        }

        public final void run() {
            View f2 = this.f64909a.f64895b;
            if (f2 != null) {
                ((TextView) f2).setText(this.f64909a.o.getResources().getString(R.string.pa_available_balance, new Object[]{this.f64910b}));
                if (!TextUtils.isEmpty(this.f64911c)) {
                    try {
                        if (this.f64910b != null) {
                            if (this.f64911c != null && new BigDecimal(this.f64910b).doubleValue() < new BigDecimal(this.f64911c).doubleValue()) {
                                this.f64912d.setInsufficientBalance(true);
                                TextView g2 = this.f64909a.f64899f;
                                kotlin.g.b.k.a((Object) g2, "tvInputError");
                                g2.setText(this.f64909a.o.getResources().getString(R.string.pa_error_insufficient_balance));
                                TextView g3 = this.f64909a.f64899f;
                                kotlin.g.b.k.a((Object) g3, "tvInputError");
                                g3.setVisibility(0);
                                View a2 = this.f64909a.f64901h;
                                kotlin.g.b.k.a((Object) a2, "cvvLayout");
                                a2.setVisibility(8);
                                CJRProceedWidgetV8 h2 = this.f64909a.f64898e;
                                kotlin.g.b.k.a((Object) h2, "proceedBtn");
                                h2.setVisibility(8);
                                this.f64909a.a(8);
                                TextView i2 = this.f64909a.f64894a;
                                kotlin.g.b.k.a((Object) i2, "tvBankName");
                                i2.setEnabled(false);
                                ((TextView) this.f64909a.f64895b).setEnabled(false);
                                RadioButton b2 = this.f64909a.f64900g;
                                kotlin.g.b.k.a((Object) b2, "radioBtn");
                                b2.setEnabled(false);
                                RadioButton b3 = this.f64909a.f64900g;
                                kotlin.g.b.k.a((Object) b3, "radioBtn");
                                b3.setChecked(false);
                                return;
                            }
                        }
                        CJRProceedWidgetV8 h3 = this.f64909a.f64898e;
                        kotlin.g.b.k.a((Object) h3, "proceedBtn");
                        h3.setVisibility(0);
                    } catch (Exception unused) {
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        }
    }

    /* renamed from: a */
    public final void accept(CJRTaggedObservable<?> cJRTaggedObservable) {
        String str = null;
        if (this.k) {
            if (kotlin.g.b.k.a((Object) "tag.get.ppbl.balance", (Object) cJRTaggedObservable != null ? cJRTaggedObservable.getTag() : null)) {
                Object obj = this.l;
                if (obj != null) {
                    CJRPaymentModes cJRPaymentModes = (CJRPaymentModes) obj;
                    Object data = cJRTaggedObservable.getData();
                    if (!(data instanceof CJRFetchBalanceResponse)) {
                        data = null;
                    }
                    cJRPaymentModes.setAvailableBalance((CJRFetchBalanceResponse) data);
                    b();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPaymentModes");
            }
        }
        if (this.k) {
            if (cJRTaggedObservable != null) {
                str = cJRTaggedObservable.getTag();
            }
            if (kotlin.g.b.k.a((Object) "tag.get.ppbl.access.token", (Object) str)) {
                this.f64898e.b();
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f64898e;
                kotlin.g.b.k.a((Object) cJRProceedWidgetV8, "proceedBtn");
                cJRProceedWidgetV8.setEnabled(true);
                if (cJRTaggedObservable.getData() instanceof NetworkCustomError) {
                    TextView textView = this.f64899f;
                    kotlin.g.b.k.a((Object) textView, "tvInputError");
                    textView.setText(this.o.getResources().getString(R.string.pa_error_invalid_credentials));
                    TextView textView2 = this.f64899f;
                    kotlin.g.b.k.a((Object) textView2, "tvInputError");
                    textView2.setVisibility(0);
                } else if (cJRTaggedObservable.getData() instanceof CJRBankToken) {
                    Object data2 = cJRTaggedObservable.getData();
                    if (data2 != null) {
                        CJRBankToken cJRBankToken = (CJRBankToken) data2;
                        if (TextUtils.isEmpty(cJRBankToken.getAccessToken())) {
                            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            net.one97.paytm.recharge.widgets.c.d.a(cJRBankToken.getMessage() + " : " + cJRBankToken.getResponseCode());
                            TextView textView3 = this.f64899f;
                            kotlin.g.b.k.a((Object) textView3, "tvInputError");
                            textView3.setText(this.o.getResources().getString(R.string.pa_error_invalid_credentials));
                            TextView textView4 = this.f64899f;
                            kotlin.g.b.k.a((Object) textView4, "tvInputError");
                            textView4.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRBankToken");
                }
            }
        }
    }

    public final void a(boolean z) {
        RadioButton radioButton = this.f64900g;
        if (radioButton != null) {
            radioButton.setChecked(z);
        }
    }

    static final class e<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f64913a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f64914b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f64915c;

        e(k kVar, Context context, String str) {
            this.f64913a = kVar;
            this.f64914b = context;
            this.f64915c = str;
        }

        public final void subscribe(z<CJRBankToken> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed() && !zVar.isDisposed()) {
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(this.f64914b);
                kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                hashMap.put("Authorization", a2);
                hashMap.put("client", "ANDROID");
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(com.paytm.utility.c.b(this.f64914b, false));
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                jSONObject.put("login_secret", com.paytm.e.a.b.a(net.one97.paytm.recharge.automatic.c.a.a.a(), this.f64915c));
                jSONObject.put("login_secret_type", "passcode");
                jSONObject.put("scope", BuildConfig.BANK_TXN_SCOPE);
                jSONObject.put("device_info", jSONObject2);
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v1/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/token", new a(this), new CJRBankToken(), hashMap, jSONObject.toString());
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f64916a;

            a(e eVar) {
                this.f64916a = eVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                CJRTaggedObservable cJRTaggedObservable = new CJRTaggedObservable("tag.get.ppbl.access.token", iJRPaytmDataModel);
                this.f64916a.f64913a.accept((CJRTaggedObservable<?>) cJRTaggedObservable);
                net.one97.paytm.recharge.presentation.d.c e2 = this.f64916a.f64913a.w;
                if (e2 != null) {
                    e2.a((CJRTaggedObservable<?>) cJRTaggedObservable);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                CJRTaggedObservable cJRTaggedObservable = new CJRTaggedObservable("tag.get.ppbl.access.token", networkCustomError);
                this.f64916a.f64913a.accept((CJRTaggedObservable<?>) cJRTaggedObservable);
                net.one97.paytm.recharge.presentation.d.c e2 = this.f64916a.f64913a.w;
                if (e2 != null) {
                    e2.a((CJRTaggedObservable<?>) cJRTaggedObservable);
                }
            }
        }
    }

    private final void a(String str) {
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            View view = this.itemView;
            kotlin.g.b.k.a((Object) view, "itemView");
            Context context = view.getContext();
            kotlin.g.b.k.a((Object) context, "itemView.context");
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String n2 = net.one97.paytm.recharge.automatic.b.a.a.q;
            String str2 = this.v;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, n2, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, str);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void a(k kVar, String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(kVar.u) || !p.a(kVar.u, "manage_screen", true)) {
                a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                str2 = net.one97.paytm.recharge.automatic.b.a.a.p;
            } else {
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                str2 = net.one97.paytm.recharge.automatic.b.a.a.B;
            }
            String str3 = str2;
            net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            View view = kVar.itemView;
            kotlin.g.b.k.a((Object) view, "itemView");
            Context context = view.getContext();
            kotlin.g.b.k.a((Object) context, "itemView.context");
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            String str4 = kVar.v;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = str4;
            a.C1160a aVar5 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, str3, "", str5, net.one97.paytm.recharge.automatic.b.a.a.P, str);
        } catch (Throwable unused) {
        }
    }
}

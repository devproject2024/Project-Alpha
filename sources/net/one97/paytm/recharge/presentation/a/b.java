package net.one97.paytm.recharge.presentation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.j;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.domain.entities.CJRCreditCardBinModel;
import net.one97.paytm.recharge.domain.entities.CJRCreditCardBodyModel;
import net.one97.paytm.recharge.domain.entities.CJRCreditCardHeadModel;
import net.one97.paytm.recharge.widgets.c.g;
import net.one97.paytm.recharge.widgets.c.h;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class b extends net.one97.paytm.recharge.presentation.f.f implements View.OnClickListener, g.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64566a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final EditText f64567b = ((EditText) this.v.findViewById(R.id.edt_mm_yy));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final EditText f64568c = ((EditText) this.v.findViewById(R.id.edt_cvv));
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final EditText f64569d = ((EditText) this.v.findViewById(R.id.edt_card_number));
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final RadioButton f64570e = ((RadioButton) this.v.findViewById(R.id.radio_btn));
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final CJRProceedWidgetV8 f64571f = ((CJRProceedWidgetV8) this.v.findViewById(R.id.btn_set_up_automatic));
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextView f64572g = ((TextView) this.v.findViewById(R.id.error_card_number));

    /* renamed from: h  reason: collision with root package name */
    private final TextView f64573h = ((TextView) this.v.findViewById(R.id.invalid_expiry));

    /* renamed from: i  reason: collision with root package name */
    private final TextView f64574i = ((TextView) this.v.findViewById(R.id.txt_tnc));
    private final View j = this.v.findViewById(R.id.label_help);
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.widgets.c.g k;
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.widgets.c.g l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    private int r;
    /* access modifiers changed from: private */
    public String s;
    /* access modifiers changed from: private */
    public String t;
    private final f u;
    /* access modifiers changed from: private */
    public final View v;
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.presentation.d.d w;
    private final String x;
    private final String y;
    /* access modifiers changed from: private */
    public final net.one97.paytm.recharge.presentation.d.c z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, net.one97.paytm.recharge.presentation.d.d dVar, String str, String str2, net.one97.paytm.recharge.presentation.d.c cVar) {
        super(view);
        k.c(view, "mItemView");
        this.v = view;
        this.w = dVar;
        this.x = str;
        this.y = str2;
        this.z = cVar;
        g.a aVar = this;
        this.k = new net.one97.paytm.recharge.widgets.c.g(this.f64568c, aVar);
        this.l = new net.one97.paytm.recharge.widgets.c.g(this.f64567b, aVar);
        this.o = 19;
        this.p = "";
        this.q = "";
        this.r = 3;
        this.t = "";
        this.u = new f(this);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final <T> void a(T t2) {
        this.v.requestFocus();
        this.f64568c.removeTextChangedListener(this.k);
        this.f64567b.removeTextChangedListener(this.l);
        this.f64569d.removeTextChangedListener(this.u);
        View findViewById = this.v.findViewById(R.id.group_add_new_card);
        k.a((Object) findViewById, "mItemView.findViewById<G…(R.id.group_add_new_card)");
        ((Group) findViewById).setVisibility(8);
        EditText editText = this.f64569d;
        if (editText != null) {
            editText.setText("");
        }
        this.f64567b.setText("");
        this.f64568c.setText("");
        RadioButton radioButton = this.f64570e;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        RadioButton radioButton2 = this.f64570e;
        if (radioButton2 != null) {
            radioButton2.setClickable(false);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f64571f;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setEnabled(false);
        }
        this.q = "";
        ((ViewGroup) this.v.findViewById(R.id.lyt_parent)).setOnClickListener(new C1274b(this));
        ((CJRProceedWidgetV8) this.v.findViewById(R.id.btn_set_up_automatic)).setOnClickListener(new c(this));
        this.f64568c.addTextChangedListener(this.k);
        this.f64567b.addTextChangedListener(this.l);
        this.f64569d.addTextChangedListener(this.u);
        this.j.setOnClickListener(this);
        String string = this.v.getContext().getString(R.string.tnc_automatic_select_card);
        k.a((Object) string, "mItemView.context.getStr…nc_automatic_select_card)");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        g gVar = new g(this);
        String string2 = this.v.getContext().getString(R.string.index_term);
        k.a((Object) string2, "mItemView.context.getString(R.string.index_term)");
        int a2 = p.a(charSequence, string2, 0, false, 6);
        if (a2 >= 0) {
            spannableString.setSpan(gVar, a2, string.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.v.getContext(), R.color.color_00b9f5)), a2, string.length(), 33);
            TextView textView = this.f64574i;
            if (textView != null) {
                textView.setText(spannableString);
            }
            TextView textView2 = this.f64574i;
            k.a((Object) textView2, "tnCTextView");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* renamed from: net.one97.paytm.recharge.presentation.a.b$b  reason: collision with other inner class name */
    static final class C1274b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64575a;

        C1274b(b bVar) {
            this.f64575a = bVar;
        }

        public final void onClick(View view) {
            View findViewById = this.f64575a.v.findViewById(R.id.group_add_new_card);
            k.a((Object) findViewById, "mItemView.findViewById<G…(R.id.group_add_new_card)");
            if (((Group) findViewById).getVisibility() != 0) {
                View findViewById2 = this.f64575a.v.findViewById(R.id.group_add_new_card);
                k.a((Object) findViewById2, "mItemView.findViewById<G…(R.id.group_add_new_card)");
                if (((Group) findViewById2).getVisibility() == 8) {
                    View findViewById3 = this.f64575a.v.findViewById(R.id.group_add_new_card);
                    k.a((Object) findViewById3, "mItemView.findViewById<G…(R.id.group_add_new_card)");
                    ((Group) findViewById3).setVisibility(0);
                    RadioButton b2 = this.f64575a.f64570e;
                    k.a((Object) b2, "radioBtn");
                    b2.setChecked(true);
                    b.a(this.f64575a, "add new");
                }
                net.one97.paytm.recharge.presentation.d.d c2 = this.f64575a.w;
                if (c2 != null) {
                    c2.a(-5, 1);
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64576a;

        c(b bVar) {
            this.f64576a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.presentation.d.c f2;
            b.d(this.f64576a);
            if (!com.paytm.utility.b.c(this.f64576a.v.getContext())) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this.f64576a.v.getContext();
                if (context != null) {
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, (NetworkCustomError) new h(), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
            Bundle bundle = new Bundle();
            if (b.a(this.f64576a, bundle)) {
                if (!TextUtils.isEmpty(this.f64576a.q) && (f2 = this.f64576a.z) != null) {
                    String e2 = this.f64576a.q;
                    if (e2 == null) {
                        k.a();
                    }
                    f2.a(e2);
                }
                net.one97.paytm.recharge.presentation.d.c f3 = this.f64576a.z;
                if (f3 != null) {
                    f3.a(-5, bundle);
                    return;
                }
                return;
            }
            CJRProceedWidgetV8 g2 = this.f64576a.f64571f;
            k.a((Object) g2, "proceedBtn");
            g2.setEnabled(false);
        }
    }

    public final void a(View view, Editable editable) {
        EditText editText;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        EditText editText2 = this.f64568c;
        k.a((Object) editText2, "mEdtTxtCVV");
        int id = editText2.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : afterTextChanged : Add New Card : CVV");
            if (String.valueOf(editable).length() == this.r) {
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f64571f;
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.setEnabled(b());
                }
                h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                EditText editText3 = this.f64568c;
                k.a((Object) editText3, "mEdtTxtCVV");
                Context context = editText3.getContext();
                k.a((Object) context, "mEdtTxtCVV.context");
                EditText editText4 = this.f64568c;
                k.a((Object) editText4, "mEdtTxtCVV");
                h.a.a(context, (View) editText4);
                return;
            }
            return;
        }
        EditText editText5 = this.f64567b;
        k.a((Object) editText5, "mEdtMMYYTxt");
        int id2 = editText5.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : afterTextChanged : Add New Card : Expiry Date");
            if (editable != null && p.a((CharSequence) editable, (CharSequence) "/", false)) {
                List<String> a2 = p.a((CharSequence) editable.toString(), new String[]{"/"});
                if (a2 != null && (!a2.isEmpty())) {
                    num = p.c(a2.get(0));
                }
                if (num != null) {
                    int intValue = num.intValue();
                    if (1 > intValue || 12 < intValue) {
                        TextView textView = this.f64573h;
                        k.a((Object) textView, "mInvalidExpiryView");
                        textView.setVisibility(0);
                    } else if (editable.toString().length() == 5) {
                        CJRProceedWidgetV8 cJRProceedWidgetV82 = this.f64571f;
                        k.a((Object) cJRProceedWidgetV82, "proceedBtn");
                        cJRProceedWidgetV82.setEnabled(b());
                        EditText editText6 = this.f64568c;
                        k.a((Object) editText6, "mEdtTxtCVV");
                        if (TextUtils.isEmpty(editText6.getText()) && (editText = this.f64568c) != null) {
                            editText.requestFocus();
                        }
                    }
                }
            }
            if (editable != null && editable.length() < 2) {
                TextView textView2 = this.f64573h;
                k.a((Object) textView2, "mInvalidExpiryView");
                textView2.setVisibility(8);
            }
            if (editable != null && editable.length() < 5) {
                CJRProceedWidgetV8 cJRProceedWidgetV83 = this.f64571f;
                k.a((Object) cJRProceedWidgetV83, "proceedBtn");
                cJRProceedWidgetV83.setEnabled(b());
            }
        }
    }

    public final void a(View view, CharSequence charSequence, int i2, int i3, int i4) {
        String str;
        EditText editText;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        EditText editText2 = this.f64567b;
        k.a((Object) editText2, "mEdtMMYYTxt");
        int id = editText2.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : onTextChanged : Add New Card : Expiry Date");
            this.f64567b.removeTextChangedListener(this.l);
            if (i2 == 1 && i2 + i4 == 2 && charSequence != null && !p.a(charSequence, '/', false)) {
                editText = this.f64567b;
                str = this.v.getContext().getString(R.string.append_slash_after_digits, new Object[]{charSequence.toString()});
            } else if (i2 == 3 && i2 - i3 == 2 && charSequence != null && p.a(charSequence, '/', false)) {
                editText = (EditText) this.v.findViewById(R.id.edt_mm_yy);
                str = p.a(charSequence.toString(), "/", "", false);
            } else {
                if (i2 == 2 && i2 + i4 == 3 && charSequence != null && !p.a(charSequence, '/', false)) {
                    editText = (EditText) this.v.findViewById(R.id.edt_mm_yy);
                    str = charSequence.toString();
                    k.c(str, "input");
                    if (str.length() > 2) {
                        Context context = this.v.getContext();
                        int i5 = R.string.append_slash_between_credit_card_digits;
                        String substring = str.substring(0, 2);
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String substring2 = str.substring(2, str.length());
                        k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        str = context.getString(i5, new Object[]{substring, substring2});
                        k.a((Object) str, "mItemView.context.getStr…bstring(2, input.length))");
                    }
                }
                this.f64567b.addTextChangedListener(this.l);
            }
            editText.setText(str);
            EditText editText3 = this.f64567b;
            k.a((Object) editText3, "mEdtMMYYTxt");
            editText3.setSelection(editText3.getText().toString().length());
            this.f64567b.addTextChangedListener(this.l);
        }
    }

    public final void onClick(View view) {
        j jVar = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.label_help;
        if (valueOf != null && valueOf.intValue() == i2) {
            net.one97.paytm.recharge.presentation.d.c cVar = this.z;
            if (cVar != null) {
                jVar = cVar.d();
            }
            if (jVar != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this.s, this.z.d());
            }
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64581a;

        /* renamed from: b  reason: collision with root package name */
        private int f64582b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f64583c;

        /* renamed from: d  reason: collision with root package name */
        private String f64584d = "";

        /* renamed from: e  reason: collision with root package name */
        private int f64585e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f64586f;

        /* renamed from: g  reason: collision with root package name */
        private int f64587g;

        f(b bVar) {
            this.f64581a = bVar;
        }

        /* JADX WARNING: type inference failed for: r3v10, types: [android.text.Editable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r11) {
            /*
                r10 = this;
                java.lang.String r0 = "s"
                kotlin.g.b.k.c(r11, r0)
                net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
                java.lang.String r0 = "Automatic: TextWatcher : afterTextChanged : Add New Card : CardNumber"
                net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r0)
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                android.widget.EditText r0 = r0.f64569d
                if (r0 == 0) goto L_0x001a
                r1 = r10
                android.text.TextWatcher r1 = (android.text.TextWatcher) r1
                r0.removeTextChangedListener(r1)
            L_0x001a:
                net.one97.paytm.recharge.automatic.b.a.h$a r0 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
                java.lang.String r0 = ""
                if (r11 == 0) goto L_0x0026
                java.lang.String r1 = r11.toString()
                if (r1 != 0) goto L_0x0027
            L_0x0026:
                r1 = r0
            L_0x0027:
                int r1 = net.one97.paytm.recharge.automatic.b.a.h.a.f(r1)
                r10.f64585e = r1
                int r1 = r10.f64585e
                r2 = 2
                r3 = 19
                r4 = 1
                if (r1 == r4) goto L_0x007a
                if (r1 == r2) goto L_0x007a
                r5 = 3
                if (r1 == r5) goto L_0x007a
                r5 = 4
                if (r1 == r5) goto L_0x0066
                r5 = 5
                if (r1 == r5) goto L_0x0052
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                r1.o = r3
                net.one97.paytm.recharge.automatic.b.a.h$a r1 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
                java.lang.String r1 = java.lang.String.valueOf(r11)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.h.a.a((java.lang.CharSequence) r1)
                goto L_0x008b
            L_0x0052:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                r5 = 16
                r1.o = r5
                net.one97.paytm.recharge.automatic.b.a.h$a r1 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
                java.lang.String r1 = java.lang.String.valueOf(r11)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.h.a.b((java.lang.CharSequence) r1)
                goto L_0x008b
            L_0x0066:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                r5 = 17
                r1.o = r5
                net.one97.paytm.recharge.automatic.b.a.h$a r1 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
                java.lang.String r1 = java.lang.String.valueOf(r11)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.h.a.b((java.lang.CharSequence) r1)
                goto L_0x008b
            L_0x007a:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                r1.o = r3
                net.one97.paytm.recharge.automatic.b.a.h$a r1 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
                java.lang.String r1 = java.lang.String.valueOf(r11)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.h.a.a((java.lang.CharSequence) r1)
            L_0x008b:
                net.one97.paytm.recharge.presentation.a.b r5 = r10.f64581a
                android.widget.EditText r5 = r5.f64569d
                r6 = 0
                if (r5 == 0) goto L_0x00a8
                android.text.InputFilter[] r7 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r8 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.presentation.a.b r9 = r10.f64581a
                int r9 = r9.o
                r8.<init>(r9)
                android.text.InputFilter r8 = (android.text.InputFilter) r8
                r7[r6] = r8
                r5.setFilters(r7)
            L_0x00a8:
                int r5 = r1.length()
                if (r5 >= r2) goto L_0x00cf
                net.one97.paytm.recharge.presentation.a.b r2 = r10.f64581a
                r2.o = r3
                net.one97.paytm.recharge.presentation.a.b r2 = r10.f64581a
                android.widget.EditText r2 = r2.f64569d
                if (r2 == 0) goto L_0x00cf
                android.text.InputFilter[] r3 = new android.text.InputFilter[r4]
                android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
                net.one97.paytm.recharge.presentation.a.b r7 = r10.f64581a
                int r7 = r7.o
                r5.<init>(r7)
                android.text.InputFilter r5 = (android.text.InputFilter) r5
                r3[r6] = r5
                r2.setFilters(r3)
            L_0x00cf:
                r11.clear()
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r11.append(r2)
                net.one97.paytm.recharge.presentation.a.b r3 = r10.f64581a
                android.widget.EditText r3 = r3.f64569d
                if (r3 == 0) goto L_0x00ea
                net.one97.paytm.recharge.presentation.a.b$f$a r5 = new net.one97.paytm.recharge.presentation.a.b$f$a
                r5.<init>(r10)
                android.view.View$OnKeyListener r5 = (android.view.View.OnKeyListener) r5
                r3.setOnKeyListener(r5)
            L_0x00ea:
                java.lang.String r3 = r10.f64584d
                int r5 = r10.f64587g
                int r7 = r3.length()
                if (r3 == 0) goto L_0x0314
                java.lang.String r3 = r3.substring(r5, r7)
                java.lang.String r5 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                int r3 = a(r3)
                int r1 = r10.a((int) r3, (java.lang.String) r1)
                net.one97.paytm.recharge.presentation.a.b r3 = r10.f64581a     // Catch:{ Exception -> 0x0111 }
                android.widget.EditText r3 = r3.f64569d     // Catch:{ Exception -> 0x0111 }
                if (r3 == 0) goto L_0x0128
                r3.setSelection(r1)     // Catch:{ Exception -> 0x0111 }
                goto L_0x0128
            L_0x0111:
                net.one97.paytm.recharge.presentation.a.b r3 = r10.f64581a
                android.widget.EditText r3 = r3.f64569d
                if (r3 == 0) goto L_0x011d
                r3.setText(r2)
            L_0x011d:
                net.one97.paytm.recharge.presentation.a.b r2 = r10.f64581a
                android.widget.EditText r2 = r2.f64569d
                if (r2 == 0) goto L_0x0128
                r2.setSelection(r1)
            L_0x0128:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.widget.EditText r1 = r1.f64569d
                if (r1 == 0) goto L_0x0136
                r2 = r10
                android.text.TextWatcher r2 = (android.text.TextWatcher) r2
                r1.addTextChangedListener(r2)
            L_0x0136:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.widget.EditText r1 = r1.f64569d
                r2 = 7
                r3 = 0
                if (r1 == 0) goto L_0x01cc
                android.text.Editable r1 = r1.getText()
                if (r1 == 0) goto L_0x01cc
                int r1 = r1.length()
                if (r1 != r2) goto L_0x01cc
                int r1 = r11.length()
                int r2 = r10.f64582b
                if (r1 >= r2) goto L_0x0155
                return
            L_0x0155:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.widget.EditText r1 = r1.f64569d
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0193
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.widget.EditText r1 = r1.f64569d
                android.content.Context r1 = r1.getContext()
                boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
                if (r1 == 0) goto L_0x0193
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                r1.n = r4
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                java.lang.String r2 = r11.toString()
                java.lang.String r3 = " "
                java.lang.String r2 = kotlin.m.p.a(r2, r3, r0, r6)
                r1.t = r2
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                java.lang.String r11 = r11.toString()
                java.lang.String r11 = kotlin.m.p.a(r11, r3, r0, r6)
                r1.a((java.lang.String) r11)
                return
            L_0x0193:
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                r11.m = true
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64569d
                android.content.Context r11 = r11.getContext()
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                android.widget.EditText r0 = r0.f64569d
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto L_0x01b5
                int r1 = net.one97.paytm.recharge.automatic.R.string.no_connection
                java.lang.String r0 = r0.getString(r1)
                goto L_0x01b6
            L_0x01b5:
                r0 = r3
            L_0x01b6:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.widget.EditText r1 = r1.f64569d
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x01c8
                int r2 = net.one97.paytm.recharge.automatic.R.string.no_internet
                java.lang.String r3 = r1.getString(r2)
            L_0x01c8:
                com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r0, (java.lang.String) r3)
                return
            L_0x01cc:
                int r1 = r11.length()
                if (r1 >= r2) goto L_0x025b
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                r11.n = r6
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64568c
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                net.one97.paytm.recharge.widgets.c.g r1 = r1.k
                android.text.TextWatcher r1 = (android.text.TextWatcher) r1
                r11.removeTextChangedListener(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64568c
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r11.setText(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64568c
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                net.one97.paytm.recharge.widgets.c.g r1 = r1.k
                android.text.TextWatcher r1 = (android.text.TextWatcher) r1
                r11.addTextChangedListener(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64567b
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                net.one97.paytm.recharge.widgets.c.g r1 = r1.l
                android.text.TextWatcher r1 = (android.text.TextWatcher) r1
                r11.removeTextChangedListener(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64567b
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r11.setText(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64567b
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                net.one97.paytm.recharge.widgets.c.g r1 = r1.l
                android.text.TextWatcher r1 = (android.text.TextWatcher) r1
                r11.addTextChangedListener(r1)
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                r11.s = r3
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r11 = r11.f64571f
                if (r11 == 0) goto L_0x0243
                r11.setEnabled(r6)
            L_0x0243:
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.TextView r11 = r11.f64572g
                if (r11 == 0) goto L_0x025a
                int r11 = r11.getVisibility()
                if (r11 != 0) goto L_0x0313
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.TextView r11 = r11.f64572g
                net.one97.paytm.recharge.presentation.a.b.a(r11, r0, r6)
            L_0x025a:
                return
            L_0x025b:
                int r0 = r11.length()
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                int r1 = r1.o
                if (r0 < r1) goto L_0x0271
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                java.lang.String r11 = r11.toString()
                net.one97.paytm.recharge.presentation.a.b.f(r0, r11)
                return
            L_0x0271:
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                android.widget.EditText r0 = r0.f64569d
                java.lang.String r1 = "mCardNumberEdtTxt"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.content.Context r0 = r0.getContext()
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 == 0) goto L_0x02d3
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                boolean r0 = r0.n
                if (r0 != 0) goto L_0x02a1
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                java.lang.String r1 = r11.toString()
                r0.t = r1
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                java.lang.String r11 = r11.toString()
                net.one97.paytm.recharge.presentation.a.b.g(r0, r11)
                return
            L_0x02a1:
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r11 = r11.f64569d
                if (r11 == 0) goto L_0x02ae
                android.text.Editable r11 = r11.getText()
                goto L_0x02af
            L_0x02ae:
                r11 = r3
            L_0x02af:
                java.lang.String r11 = java.lang.String.valueOf(r11)
                int r11 = r11.length()
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                int r0 = r0.o
                if (r11 != r0) goto L_0x02d2
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.widget.EditText r0 = r11.f64569d
                if (r0 == 0) goto L_0x02cb
                android.text.Editable r3 = r0.getText()
            L_0x02cb:
                java.lang.String r0 = java.lang.String.valueOf(r3)
                net.one97.paytm.recharge.presentation.a.b.f(r11, r0)
            L_0x02d2:
                return
            L_0x02d3:
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                boolean r11 = r11.m
                if (r11 != 0) goto L_0x0313
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                r11.m = true
                net.one97.paytm.recharge.presentation.a.b r11 = r10.f64581a
                android.view.View r11 = r11.v
                android.content.Context r11 = r11.getContext()
                net.one97.paytm.recharge.presentation.a.b r0 = r10.f64581a
                android.view.View r0 = r0.v
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto L_0x02fd
                int r1 = net.one97.paytm.recharge.automatic.R.string.no_connection
                java.lang.String r0 = r0.getString(r1)
                goto L_0x02fe
            L_0x02fd:
                r0 = r3
            L_0x02fe:
                net.one97.paytm.recharge.presentation.a.b r1 = r10.f64581a
                android.view.View r1 = r1.v
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0310
                int r2 = net.one97.paytm.recharge.automatic.R.string.no_internet
                java.lang.String r3 = r1.getString(r2)
            L_0x0310:
                com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r0, (java.lang.String) r3)
            L_0x0313:
                return
            L_0x0314:
                kotlin.u r11 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r11.<init>(r0)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.a.b.f.afterTextChanged(android.text.Editable):void");
        }

        static final class a implements View.OnKeyListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f64588a;

            a(f fVar) {
                this.f64588a = fVar;
            }

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                this.f64588a.f64586f = i2 == 67 ? 1 : 0;
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
                java.lang.String r9 = r8.f64584d
                int r9 = b(r9)
                int r10 = b(r10)
                int r9 = r9 - r10
                int r0 = r0 + r9
                int r10 = r8.f64585e
                r1 = 4
                r3 = 5
                r4 = 1
                if (r10 == r1) goto L_0x0076
                if (r10 != r3) goto L_0x004b
                goto L_0x0076
            L_0x004b:
                int r10 = r8.f64586f
                r5 = 15
                r6 = 10
                if (r10 != r4) goto L_0x005c
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 == r6) goto L_0x0082
                if (r0 != r5) goto L_0x005c
                goto L_0x0082
            L_0x005c:
                int r10 = r8.f64586f
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
                int r10 = r8.f64586f
                r5 = 12
                if (r10 != r4) goto L_0x0085
                if (r0 == 0) goto L_0x0082
                if (r0 == r3) goto L_0x0082
                if (r0 != r5) goto L_0x0085
            L_0x0082:
                int r0 = r0 + -1
                goto L_0x009a
            L_0x0085:
                int r10 = r8.f64586f
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
                int r9 = r8.f64587g
                if (r9 != r4) goto L_0x00a3
                r0 = 0
            L_0x00a3:
                if (r0 >= 0) goto L_0x00a6
                r0 = 0
            L_0x00a6:
                net.one97.paytm.recharge.presentation.a.b r9 = r8.f64581a
                int r9 = r9.o
                if (r0 <= r9) goto L_0x00b4
                net.one97.paytm.recharge.presentation.a.b r9 = r8.f64581a
                int r0 = r9.o
            L_0x00b4:
                return r0
            L_0x00b5:
                kotlin.u r9 = new kotlin.u
                java.lang.String r10 = "null cannot be cast to non-null type kotlin.CharSequence"
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.a.b.f.a(int, java.lang.String):int");
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
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : beforeTextChanged : Add New Card : CardNumber");
            CharSequence charSequence2 = null;
            if (i4 >= 2) {
                this.f64581a.p = charSequence != null ? charSequence.toString() : null;
            }
            if (charSequence != null) {
                charSequence2 = charSequence.subSequence(i2, i3 + i2);
            }
            this.f64583c = k.a((Object) " ", (Object) String.valueOf(charSequence2));
            this.f64584d = String.valueOf(charSequence);
            this.f64582b = charSequence != null ? charSequence.length() : 0;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("Automatic: TextWatcher : onTextChanged : Add New Card : CardNumber");
            this.f64587g = i2 + i3;
        }
    }

    public static void a(TextView textView, String str, boolean z2) {
        k.c(textView, "view");
        k.c(str, "message");
        textView.setText(str);
        textView.setVisibility(z2 ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        y.a(new d(this, str)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new e(this));
    }

    static final class d<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f64578b;

        d(b bVar, String str) {
            this.f64577a = bVar;
            this.f64578b = str;
        }

        public final void subscribe(z<CJRCreditCardBinModel> zVar) {
            k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed() && !zVar.isDisposed()) {
                CJRCreditCardBinModel cJRCreditCardBinModel = new CJRCreditCardBinModel(new CJRCreditCardHeadModel(), new CJRCreditCardBodyModel());
                CJRCreditCardHeadModel head = cJRCreditCardBinModel.getHead();
                if (head != null) {
                    head.setClientId("IN");
                }
                CJRCreditCardHeadModel head2 = cJRCreditCardBinModel.getHead();
                if (head2 != null) {
                    head2.setVersion("v1");
                }
                CJRCreditCardHeadModel head3 = cJRCreditCardBinModel.getHead();
                if (head3 != null) {
                    head3.setRequestTimeStamp(String.valueOf(System.currentTimeMillis()));
                }
                CJRCreditCardHeadModel head4 = cJRCreditCardBinModel.getHead();
                if (head4 != null) {
                    head4.setChannelId("APP");
                }
                CJRCreditCardHeadModel head5 = cJRCreditCardBinModel.getHead();
                if (head5 != null) {
                    head5.setSignature("");
                }
                CJRCreditCardBodyModel body = cJRCreditCardBinModel.getBody();
                if (body != null) {
                    body.setBinNumber(this.f64578b);
                }
                CJRCreditCardBodyModel body2 = cJRCreditCardBinModel.getBody();
                if (body2 != null) {
                    body2.setSsoToken(com.paytm.utility.d.a(this.f64577a.v.getContext()));
                }
                String a2 = new com.google.gsonhtcfix.f().a((Object) cJRCreditCardBinModel);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(net.one97.paytm.recharge.automatic.c.a.b.j(), new a(zVar), new CJRCreditCardBinModel(), hashMap, a2);
                this.f64577a.v.getContext();
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f64579a;

            a(z zVar) {
                this.f64579a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f64579a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRCreditCardBinModel) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRCreditCardBinModel");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f64579a.tryOnError(networkCustomError);
                }
            }
        }
    }

    public static final class e implements aa<CJRCreditCardBinModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64580a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        e(b bVar) {
            this.f64580a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String isIndian;
            String cardType;
            CJRCreditCardBinModel cJRCreditCardBinModel = (CJRCreditCardBinModel) obj;
            k.c(cJRCreditCardBinModel, "t");
            EditText h2 = this.f64580a.f64569d;
            k.a((Object) h2, "mCardNumberEdtTxt");
            if (h2.getText().length() >= 7) {
                CJRCreditCardBodyModel body = cJRCreditCardBinModel.getBody();
                if (body == null || !k.a((Object) "405", (Object) body.getResponseCode())) {
                    b bVar = this.f64580a;
                    CJRCreditCardBodyModel body2 = cJRCreditCardBinModel.getBody();
                    String str = null;
                    bVar.s = body2 != null ? body2.getCardScheme() : null;
                    CJRCreditCardBodyModel body3 = cJRCreditCardBinModel.getBody();
                    if (!(body3 == null || (cardType = body3.getCardType()) == null || !p.a(cardType, CJRCreditCardBodyModel.Companion.getDEBIT_CARD_TYPE(), true))) {
                        net.one97.paytm.recharge.automatic.c.a.b bVar2 = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                        if (!net.one97.paytm.recharge.automatic.c.a.b.h()) {
                            this.f64580a.q = cardType;
                            TextView k = this.f64580a.f64572g;
                            k.a((Object) k, "mCardErrorView");
                            String string = this.f64580a.v.getContext().getString(R.string.debit_card_not_supported_error);
                            k.a((Object) string, "mItemView.context.getStr…card_not_supported_error)");
                            b.a(k, string, true);
                            return;
                        }
                    }
                    if (!this.f64580a.a()) {
                        b bVar3 = this.f64580a;
                        CJRCreditCardBodyModel body4 = cJRCreditCardBinModel.getBody();
                        if (body4 != null) {
                            str = body4.getCardType();
                        }
                        bVar3.q = str;
                        TextView k2 = this.f64580a.f64572g;
                        k.a((Object) k2, "mCardErrorView");
                        String string2 = this.f64580a.v.getContext().getString(R.string.card_not_supported_error);
                        k.a((Object) string2, "mItemView.context.getStr…card_not_supported_error)");
                        b.a(k2, string2, true);
                        return;
                    }
                    net.one97.paytm.recharge.automatic.c.a.b bVar4 = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                    ArrayList<String> m = net.one97.paytm.recharge.automatic.c.a.b.m();
                    if (TextUtils.isEmpty(this.f64580a.s) || m == null || !(!m.isEmpty()) || !kotlin.a.k.a(m, this.f64580a.s)) {
                        CJRCreditCardBodyModel body5 = cJRCreditCardBinModel.getBody();
                        if (body5 == null || (isIndian = body5.isIndian()) == null || !p.a(isIndian, "false", true)) {
                            b bVar5 = this.f64580a;
                            CJRCreditCardBodyModel body6 = cJRCreditCardBinModel.getBody();
                            if (body6 != null) {
                                str = body6.getCardType();
                            }
                            bVar5.q = str;
                            return;
                        }
                        TextView k3 = this.f64580a.f64572g;
                        k.a((Object) k3, "mCardErrorView");
                        String string3 = this.f64580a.v.getContext().getString(R.string.international_card_not_supported_error);
                        k.a((Object) string3, "mItemView.context.getStr…card_not_supported_error)");
                        b.a(k3, string3, true);
                        return;
                    }
                    TextView k4 = this.f64580a.f64572g;
                    k.a((Object) k4, "mCardErrorView");
                    String string4 = this.f64580a.v.getContext().getString(R.string.card_not_supported_error);
                    k.a((Object) string4, "mItemView.context.getStr…card_not_supported_error)");
                    b.a(k4, string4, true);
                    return;
                }
                this.f64580a.n = false;
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this.f64580a.v.getContext();
                if (context != null) {
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, 1014);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public final void onError(Throwable th) {
            k.c(th, "e");
            this.f64580a.n = false;
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = this.f64580a.v.getContext();
            if (context != null) {
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, (NetworkCustomError) th, 1014);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public final boolean a() {
        net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
        ArrayList<String> m2 = net.one97.paytm.recharge.automatic.c.a.b.m();
        return TextUtils.isEmpty(this.s) || m2 == null || !(m2.isEmpty() ^ true) || !kotlin.a.k.a(m2, this.s);
    }

    private final boolean b() {
        TextView textView = this.f64572g;
        k.a((Object) textView, "mCardErrorView");
        if (textView.getVisibility() == 8) {
            TextView textView2 = this.f64573h;
            k.a((Object) textView2, "mInvalidExpiryView");
            if (textView2.getVisibility() == 8) {
                EditText editText = this.f64568c;
                k.a((Object) editText, "mEdtTxtCVV");
                if (editText.getText().length() == this.r) {
                    EditText editText2 = this.f64567b;
                    k.a((Object) editText2, "mEdtMMYYTxt");
                    if (editText2.getText().length() == 5 && !TextUtils.isEmpty(this.q) && a()) {
                        if (CJRCreditCardBodyModel.Companion.getDEBIT_CARD_TYPE().equals(this.q)) {
                            net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                            if (!net.one97.paytm.recharge.automatic.c.a.b.h()) {
                                TextView textView3 = this.f64572g;
                                k.a((Object) textView3, "mCardErrorView");
                                String string = this.v.getContext().getString(R.string.debit_card_not_supported_error);
                                k.a((Object) string, "mItemView.context.getStr…card_not_supported_error)");
                                a(textView3, string, true);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final class g extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64589a;

        g(b bVar) {
            this.f64589a = bVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            if (!com.paytm.utility.b.c(this.f64589a.v.getContext())) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this.f64589a.v.getContext();
                if (context != null) {
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, (NetworkCustomError) new net.one97.paytm.recharge.widgets.c.h(), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
            net.one97.paytm.recharge.presentation.d.c f2 = this.f64589a.z;
            if (f2 != null) {
                f2.a();
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(bVar.x) || !p.a(bVar.x, "manage_screen", true)) {
                a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                str2 = net.one97.paytm.recharge.automatic.b.a.a.p;
            } else {
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                str2 = net.one97.paytm.recharge.automatic.b.a.a.B;
            }
            String str3 = str2;
            net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            View view = bVar.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            String str4 = bVar.y;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = str4;
            a.C1160a aVar5 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, str3, "", str5, net.one97.paytm.recharge.automatic.b.a.a.P, str);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        try {
            String str = (TextUtils.isEmpty(bVar.q) || !p.a(SDKConstants.DEBIT, bVar.q, true)) ? "credit card" : "debit card";
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            View view = bVar.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String n2 = net.one97.paytm.recharge.automatic.b.a.a.q;
            String str2 = bVar.y;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, n2, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, str);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ boolean a(b bVar, Bundle bundle) {
        TextView textView;
        View findViewById = bVar.v.findViewById(R.id.edt_card_number);
        k.a((Object) findViewById, "mItemView.findViewById<E…xt>(R.id.edt_card_number)");
        boolean z2 = false;
        String a2 = p.a(((EditText) findViewById).getText().toString(), " ", "", false);
        View findViewById2 = bVar.v.findViewById(R.id.edt_mm_yy);
        k.a((Object) findViewById2, "mItemView.findViewById<EditText>(R.id.edt_mm_yy)");
        String obj = ((EditText) findViewById2).getText().toString();
        View findViewById3 = bVar.v.findViewById(R.id.edt_cvv);
        k.a((Object) findViewById3, "mItemView.findViewById<EditText>(R.id.edt_cvv)");
        String obj2 = ((EditText) findViewById3).getText().toString();
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(obj) && obj.length() >= 5 && !TextUtils.isEmpty(obj2) && obj2.length() >= 3 && com.paytm.utility.b.J(a2) && (((textView = bVar.f64573h) == null || textView.getVisibility() != 0) && bVar.a())) {
            z2 = true;
        }
        bundle.putString(SDKConstants.AI_KEY_CARD_NUMBER, a2);
        bundle.putString(SDKConstants.AI_KEY_EXPIRY, obj);
        bundle.putString(SDKConstants.AI_KEY_CVV, obj2);
        CJRProceedWidgetV8 cJRProceedWidgetV8 = bVar.f64571f;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setEnabled(true);
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (net.one97.paytm.recharge.automatic.c.a.b.h() != false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void f(net.one97.paytm.recharge.presentation.a.b r7, java.lang.String r8) {
        /*
            int r0 = r8.length()
            int r1 = r7.o
            java.lang.String r2 = "mCardErrorView"
            r3 = 1
            if (r0 != r1) goto L_0x00ad
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            kotlin.m.l r0 = new kotlin.m.l
            java.lang.String r1 = " "
            r0.<init>((java.lang.String) r1)
            java.lang.String r1 = ""
            java.lang.String r8 = r0.replace((java.lang.CharSequence) r8, (java.lang.String) r1)
            boolean r8 = com.paytm.utility.b.J((java.lang.String) r8)
            if (r8 == 0) goto L_0x00ad
            net.one97.paytm.recharge.automatic.b.a.h$a r8 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            android.widget.EditText r8 = r7.f64569d
            java.lang.String r0 = "mCardNumberEdtTxt"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.text.Editable r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            int r8 = net.one97.paytm.recharge.automatic.b.a.h.a.f(r8)
            r0 = 4
            if (r8 == r0) goto L_0x0039
            r0 = 3
        L_0x0039:
            r7.r = r0
            android.widget.EditText r8 = r7.f64568c
            r4 = 0
            if (r8 == 0) goto L_0x004e
            android.text.InputFilter[] r5 = new android.text.InputFilter[r3]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r0)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r5[r4] = r6
            r8.setFilters(r5)
        L_0x004e:
            java.lang.String r8 = r7.q
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x006e
            net.one97.paytm.recharge.domain.entities.CJRCreditCardBodyModel$Companion r8 = net.one97.paytm.recharge.domain.entities.CJRCreditCardBodyModel.Companion
            java.lang.String r8 = r8.getDEBIT_CARD_TYPE()
            java.lang.String r0 = r7.q
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 == 0) goto L_0x006e
            net.one97.paytm.recharge.automatic.c.a.b r8 = net.one97.paytm.recharge.automatic.c.a.b.f60258a
            boolean r8 = net.one97.paytm.recharge.automatic.c.a.b.h()
            if (r8 == 0) goto L_0x0074
        L_0x006e:
            boolean r8 = r7.a()
            if (r8 != 0) goto L_0x00a4
        L_0x0074:
            boolean r8 = r7.a()
            java.lang.String r0 = "mItemView.context.getStr…card_not_supported_error)"
            if (r8 != 0) goto L_0x008c
            android.view.View r8 = r7.v
            android.content.Context r8 = r8.getContext()
            int r1 = net.one97.paytm.recharge.automatic.R.string.card_not_supported_error
            java.lang.String r8 = r8.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            goto L_0x009b
        L_0x008c:
            android.view.View r8 = r7.v
            android.content.Context r8 = r8.getContext()
            int r1 = net.one97.paytm.recharge.automatic.R.string.debit_card_not_supported_error
            java.lang.String r8 = r8.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
        L_0x009b:
            android.widget.TextView r0 = r7.f64572g
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            a(r0, r8, r3)
            goto L_0x00d0
        L_0x00a4:
            android.widget.TextView r8 = r7.f64572g
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            a(r8, r1, r4)
            goto L_0x00d0
        L_0x00ad:
            java.lang.String r8 = r7.q
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x00d0
            android.widget.TextView r8 = r7.f64572g
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            android.view.View r0 = r7.v
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.recharge.automatic.R.string.invalid_card_number
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "mItemView.context.getStr…ring.invalid_card_number)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            a(r8, r0, r3)
        L_0x00d0:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r8 = r7.f64571f
            java.lang.String r0 = "proceedBtn"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            boolean r7 = r7.b()
            r8.setEnabled(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.a.b.f(net.one97.paytm.recharge.presentation.a.b, java.lang.String):void");
    }

    public static final /* synthetic */ void g(b bVar, String str) {
        if ((str != null ? str.length() : 0) >= 7) {
            String obj = p.a(String.valueOf(str), " ", "", false).subSequence(0, 6).toString();
            bVar.n = true;
            bVar.a(obj);
        }
    }
}

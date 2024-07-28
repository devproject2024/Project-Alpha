package net.one97.paytm.recharge.common.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.TypefaceSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.a;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ab;

public final class b extends a implements View.OnClickListener {
    private String A;
    private final int B = 1;
    private final int C = 2;
    private final int D = 3;
    private LottieAnimationView E;
    private StringBuffer F;
    private View.OnKeyListener G = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67) {
                return false;
            }
            if (view.getId() == b.this.f62138g.getId()) {
                return b.a(b.this.f62138g, (CJRPasscodeEditText) null);
            }
            if (view.getId() == b.this.f62139h.getId()) {
                return b.a(b.this.f62139h, b.this.f62138g);
            }
            if (view.getId() == b.this.f62140i.getId()) {
                return b.a(b.this.f62140i, b.this.f62139h);
            }
            if (view.getId() == b.this.j.getId()) {
                return b.a(b.this.j, b.this.f62140i);
            }
            if (view.getId() == b.this.k.getId()) {
                return b.a(b.this.k, b.this.j);
            }
            if (view.getId() == b.this.l.getId()) {
                return b.a(b.this.l, b.this.k);
            }
            return true;
        }
    };
    private TextWatcher H = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (b.this.f62138g.getText().toString().equals("")) {
                b.this.f62138g.requestFocus();
            } else if (b.this.f62139h.getText().toString().equals("")) {
                b.this.f62139h.requestFocus();
                b.this.f62138g.setEnabled(false);
            } else if (b.this.f62140i.getText().toString().equals("")) {
                b.this.f62140i.requestFocus();
                b.this.f62139h.setEnabled(false);
            } else if (b.this.j.getText().toString().equals("")) {
                b.this.j.requestFocus();
                b.this.f62140i.setEnabled(false);
            } else if (b.this.k.getText().toString().equals("")) {
                b.this.k.requestFocus();
                b.this.j.setEnabled(false);
            } else if (b.this.l.getText().toString().equals("")) {
                b.this.l.requestFocus();
                b.this.k.setEnabled(false);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public CJRPasscodeEditText f62138g;

    /* renamed from: h  reason: collision with root package name */
    public CJRPasscodeEditText f62139h;

    /* renamed from: i  reason: collision with root package name */
    public CJRPasscodeEditText f62140i;
    public CJRPasscodeEditText j;
    public CJRPasscodeEditText k;
    public CJRPasscodeEditText l;
    public TextView m;
    public String n;
    private ab o;
    private RelativeLayout p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private String x;
    private Activity y;
    private String z;

    public b(Activity activity, String str, String str2, String str3, ab abVar) {
        super(activity);
        this.y = activity;
        this.x = null;
        this.n = str;
        this.o = abVar;
        this.z = str2;
        this.A = str3;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lyt_recharge_otp_dialog);
        this.t = (TextView) findViewById(R.id.txt_title);
        this.s = (TextView) findViewById(R.id.txt_msg);
        this.E = (LottieAnimationView) findViewById(R.id.loading_threedots_lav);
        this.q = (LinearLayout) findViewById(R.id.otpEnterLayout);
        this.f62138g = (CJRPasscodeEditText) findViewById(R.id.otp_digit_1);
        this.f62139h = (CJRPasscodeEditText) findViewById(R.id.otp_digit_2);
        this.f62140i = (CJRPasscodeEditText) findViewById(R.id.otp_digit_3);
        this.j = (CJRPasscodeEditText) findViewById(R.id.otp_digit_4);
        this.k = (CJRPasscodeEditText) findViewById(R.id.otp_digit_5);
        this.l = (CJRPasscodeEditText) findViewById(R.id.otp_digit_6);
        this.v = (TextView) findViewById(R.id.tv_otp_error);
        this.w = (ImageView) findViewById(R.id.close_action_button);
        this.f62138g.addTextChangedListener(this.H);
        this.f62139h.addTextChangedListener(this.H);
        this.f62140i.addTextChangedListener(this.H);
        this.j.addTextChangedListener(this.H);
        this.k.addTextChangedListener(this.H);
        this.l.addTextChangedListener(this.H);
        this.f62138g.setOnKeyListener(this.G);
        this.f62139h.setOnKeyListener(this.G);
        this.f62140i.setOnKeyListener(this.G);
        this.j.setOnKeyListener(this.G);
        this.k.setOnKeyListener(this.G);
        this.l.setOnKeyListener(this.G);
        this.f62138g.requestFocus();
        this.r = (TextView) findViewById(R.id.txt_resend_otp);
        this.r.setOnClickListener(this);
        this.m = (TextView) findViewById(R.id.txt_call_me_count_down_timer);
        this.w.setOnClickListener(this);
        this.p = (RelativeLayout) findViewById(R.id.btn_verify);
        this.u = (TextView) findViewById(R.id.btn_txt);
        this.p.setOnClickListener(this);
        if (com.paytm.utility.b.b(this.z)) {
            a(1, (String) null, (String) null, false);
        } else {
            a(3, "431", AppConstants.TRANSACTION_STATUS_ERROR, true);
        }
    }

    public final void a(int i2, String str, String str2, boolean z2) {
        if (i2 == 1) {
            this.u.setText(getContext().getResources().getString(R.string.send_otp_btn));
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.m.setVisibility(8);
            a(getContext().getResources().getString(R.string.recharge_verify_mobile_number, new Object[]{e()}));
            a(getContext().getResources().getString(R.string.verify_mobile_number_reg, new Object[]{e()}), true);
        } else if (i2 == 2) {
            this.u.setText(getContext().getResources().getString(R.string.confirm_re));
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            this.m.setVisibility(0);
            a(getContext().getResources().getString(R.string.enter_one_time_pwd));
            a(getContext().getResources().getString(R.string.enter_otp_msg, new Object[]{e()}), true);
            if (z2 && !TextUtils.isEmpty(str2) && !str2.trim().equalsIgnoreCase("SUCCESS")) {
                a(i2, str, str2);
            }
        } else if (i2 == 3) {
            this.u.setText(getContext().getResources().getString(R.string.button_ok));
            b(true);
            c(false);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.m.setVisibility(8);
            if (z2 && !TextUtils.isEmpty(str2) && !str2.trim().equalsIgnoreCase("SUCCESS")) {
                a(i2, str, str2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            r5.c((boolean) r0)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 2
            r3 = 1
            if (r1 != 0) goto L_0x0111
            r1 = -1
            int r4 = r7.hashCode()
            switch(r4) {
                case 51511: goto L_0x0066;
                case 51602: goto L_0x005c;
                case 51604: goto L_0x0052;
                case 51605: goto L_0x0047;
                case 52503: goto L_0x003d;
                case 52563: goto L_0x0033;
                case 54399: goto L_0x0029;
                case 55421: goto L_0x001f;
                case 1508391: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0070
        L_0x0015:
            java.lang.String r4 = "1107"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 3
            goto L_0x0071
        L_0x001f:
            java.lang.String r4 = "827"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 0
            goto L_0x0071
        L_0x0029:
            java.lang.String r4 = "708"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 6
            goto L_0x0071
        L_0x0033:
            java.lang.String r4 = "531"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 5
            goto L_0x0071
        L_0x003d:
            java.lang.String r4 = "513"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 7
            goto L_0x0071
        L_0x0047:
            java.lang.String r4 = "434"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 8
            goto L_0x0071
        L_0x0052:
            java.lang.String r4 = "433"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r4 = "431"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 1
            goto L_0x0071
        L_0x0066:
            java.lang.String r4 = "403"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0070
            r7 = 4
            goto L_0x0071
        L_0x0070:
            r7 = -1
        L_0x0071:
            switch(r7) {
                case 0: goto L_0x00ee;
                case 1: goto L_0x00bf;
                case 2: goto L_0x00af;
                case 3: goto L_0x00a1;
                case 4: goto L_0x00a1;
                case 5: goto L_0x0090;
                case 6: goto L_0x0090;
                default: goto L_0x0074;
            }
        L_0x0074:
            if (r6 != r2) goto L_0x00f2
            r5.a((boolean) r3)
            android.widget.TextView r6 = r5.v
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.v
            android.app.Activity r7 = r5.y
            android.content.res.Resources r7 = r7.getResources()
            int r8 = net.one97.paytm.recharge.R.string.text_someting_went_wrong
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
            return
        L_0x0090:
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.otp_limit_reached
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6)
            goto L_0x0123
        L_0x00a1:
            r5.a((boolean) r3)
            android.widget.TextView r6 = r5.v
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.v
            r6.setText(r8)
            return
        L_0x00af:
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.account_blocked
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6)
            goto L_0x0123
        L_0x00bf:
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.invalid_mobile_p2p_number
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6)
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r6 = net.one97.paytm.recharge.di.helper.c.aM()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x00de
            r5.a((java.lang.String) r6, (boolean) r0)
            return
        L_0x00de:
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.mobile_invalid_msg
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6, (boolean) r0)
            return
        L_0x00ee:
            r5.b()
            return
        L_0x00f2:
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.title_400
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6)
            android.app.Activity r6 = r5.y
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.recharge.R.string.text_someting_went_wrong
            java.lang.String r6 = r6.getString(r7)
            r5.a((java.lang.String) r6, (boolean) r0)
            return
        L_0x0111:
            if (r6 != r2) goto L_0x0123
            if (r8 == 0) goto L_0x0123
            r5.a((boolean) r3)
            android.widget.TextView r6 = r5.v
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.v
            r6.setText(r8)
            return
        L_0x0123:
            r5.a((java.lang.String) r8, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.b.a(int, java.lang.String, java.lang.String):void");
    }

    private void b() {
        c();
        if (this.o != null) {
            c(true);
            b(false);
            this.o.a(this.z);
        }
    }

    public final void a(boolean z2) {
        TextView textView = this.r;
        if (textView == null) {
            return;
        }
        if (z2) {
            textView.setEnabled(true);
            this.r.setClickable(true);
            this.m.setVisibility(8);
            return;
        }
        textView.setEnabled(false);
        this.r.setClickable(false);
    }

    public final void b(boolean z2) {
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z2);
        }
    }

    private void a(String str, boolean z2) {
        if (this.s != null && !TextUtils.isEmpty(str)) {
            this.s.setText(str);
            if (z2) {
                a(this.s, str, e());
            }
        }
    }

    private void a(String str) {
        if (this.t != null && !TextUtils.isEmpty(str)) {
            this.t.setText(str);
        }
    }

    private void c() {
        this.v.setVisibility(8);
    }

    public final void c(boolean z2) {
        if (z2) {
            this.E.setVisibility(0);
            this.E.setAnimation("Payments-Loader.json");
            this.E.loop(true);
            this.E.playAnimation();
            this.u.setVisibility(4);
            return;
        }
        this.E.cancelAnimation();
        this.E.setVisibility(8);
        this.u.setVisibility(0);
    }

    private void d() {
        this.f62138g.setText("");
        this.f62138g.setEnabled(true);
        this.f62139h.setText("");
        this.f62139h.setEnabled(true);
        this.f62140i.setText("");
        this.f62140i.setEnabled(true);
        this.j.setText("");
        this.j.setEnabled(true);
        this.k.setText("");
        this.k.setEnabled(true);
        this.l.setText("");
        this.l.setEnabled(true);
        this.f62138g.requestFocus();
        ((InputMethodManager) this.y.getSystemService("input_method")).showSoftInput(this.f62138g, 1);
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_resend_otp) {
            b();
        } else if (id == R.id.close_action_button) {
            dismiss();
            d();
            ab abVar = this.o;
            if (abVar != null) {
                abVar.a(false);
            }
        } else if (id != R.id.btn_verify) {
        } else {
            if (this.u.getText().toString().equalsIgnoreCase(this.y.getResources().getString(R.string.send_otp_btn))) {
                b();
            } else if (this.u.getText().toString().equalsIgnoreCase(this.y.getResources().getString(R.string.button_ok))) {
                ab abVar2 = this.o;
                if (abVar2 != null) {
                    abVar2.a(false);
                    d();
                }
            } else {
                this.F = new StringBuffer();
                this.F.append(this.f62138g.getText().toString());
                this.F.append(this.f62139h.getText().toString());
                this.F.append(this.f62140i.getText().toString());
                this.F.append(this.j.getText().toString());
                this.F.append(this.k.getText().toString());
                this.F.append(this.l.getText().toString());
                String stringBuffer = this.F.toString();
                if (TextUtils.isEmpty(stringBuffer) || stringBuffer.trim().length() != 6) {
                    a(2, (String) null, getContext().getResources().getString(R.string.enter_valid_otp), true);
                    return;
                }
                b(false);
                c();
                try {
                    View currentFocus = getCurrentFocus();
                    if (currentFocus != null) {
                        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    }
                } catch (Exception unused) {
                }
                c(true);
                ab abVar3 = this.o;
                if (abVar3 != null) {
                    abVar3.a(stringBuffer, this.n);
                }
            }
        }
    }

    private static void a(TextView textView, String str, String str2) {
        try {
            textView.setText(str, TextView.BufferType.SPANNABLE);
            Spannable spannable = (Spannable) textView.getText();
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                spannable.setSpan(new TypefaceSpan("sans-serif-medium"), indexOf, str2.length() + indexOf, 33);
            }
        } catch (Exception unused) {
        }
    }

    private String e() {
        String str = this.z;
        if (str == null || str.length() < 10) {
            return "";
        }
        StringBuilder sb = new StringBuilder("******");
        String str2 = this.z;
        sb.append(str2.substring(str2.length() - 4));
        return sb.toString();
    }

    static /* synthetic */ boolean a(CJRPasscodeEditText cJRPasscodeEditText, CJRPasscodeEditText cJRPasscodeEditText2) {
        if (!cJRPasscodeEditText.getText().toString().equals("")) {
            if (cJRPasscodeEditText.getSelectionStart() != 0 || cJRPasscodeEditText.getSelectionEnd() != 0) {
                return false;
            }
            cJRPasscodeEditText.setText("");
        } else if (cJRPasscodeEditText2 != null) {
            cJRPasscodeEditText2.setText("");
            cJRPasscodeEditText2.setEnabled(true);
            cJRPasscodeEditText2.requestFocus();
        }
        return true;
    }
}

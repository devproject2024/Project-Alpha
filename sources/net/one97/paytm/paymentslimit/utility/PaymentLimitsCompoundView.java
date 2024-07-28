package net.one97.paytm.paymentslimit.utility;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.wallet.R;

public class PaymentLimitsCompoundView extends LinearLayout implements View.OnClickListener {
    public Context A;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f59330a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintLayout f59331b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f59332c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59333d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59334e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59335f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59336g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59337h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59338i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public Button r;
    public EditText s;
    public EditText t;
    public EditText u;
    public EditText v;
    public ProgressBar w;
    public ProgressBar x;
    public ProgressBar y;
    public ProgressBar z;

    public PaymentLimitsCompoundView(Context context) {
        this(context, (AttributeSet) null);
        this.A = context;
    }

    public PaymentLimitsCompoundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.A = context;
    }

    public PaymentLimitsCompoundView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = context;
        a();
    }

    public PaymentLimitsCompoundView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.A = context;
        a();
    }

    private void a() {
        inflate(getContext(), R.layout.payment_limits_compound_view, this);
        d();
        c();
        this.f59333d.setOnClickListener(this);
        this.f59334e.setOnClickListener(this);
        b();
    }

    private void b() {
        this.s.addTextChangedListener(new a(this, (byte) 0));
        this.t.addTextChangedListener(new a(this, (byte) 0));
        this.u.addTextChangedListener(new a(this, (byte) 0));
        this.v.addTextChangedListener(new a(this, (byte) 0));
    }

    class a implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private a() {
        }

        /* synthetic */ a(PaymentLimitsCompoundView paymentLimitsCompoundView, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            if (PaymentLimitsCompoundView.this.s.getVisibility() == 0 && PaymentLimitsCompoundView.this.s.getText().toString().equals("") && PaymentLimitsCompoundView.this.t.getText().toString().equals("") && PaymentLimitsCompoundView.this.u.getText().toString().equals("") && PaymentLimitsCompoundView.this.v.getText().toString().equals("")) {
                PaymentLimitsCompoundView.this.f59334e.setVisibility(4);
            } else {
                PaymentLimitsCompoundView.this.f59334e.setVisibility(0);
            }
        }
    }

    private void c() {
        this.f59330a.setVisibility(0);
        this.f59331b.setVisibility(8);
        this.f59332c.setVisibility(8);
    }

    private void d() {
        this.f59330a = (RelativeLayout) findViewById(R.id.rl_default);
        this.f59331b = (ConstraintLayout) findViewById(R.id.cl_layout2);
        this.f59332c = (ConstraintLayout) findViewById(R.id.cl_layout_3);
        this.f59333d = (TextView) findViewById(R.id.tv_add_limits);
        this.f59334e = (TextView) findViewById(R.id.tv_remove);
        this.f59335f = (TextView) findViewById(R.id.tv_edit_layout_3);
        this.f59336g = (TextView) findViewById(R.id.tv_layout_top);
        this.f59337h = (TextView) findViewById(R.id.tv_layout_remove_edit);
        this.f59338i = (TextView) findViewById(R.id.tv_layout3_header);
        this.j = (TextView) findViewById(R.id.tv_daily_limit_payment_complete);
        this.k = (TextView) findViewById(R.id.tv_daily_limit_remaining);
        this.l = (TextView) findViewById(R.id.tv_daily_limit_spent);
        this.m = (TextView) findViewById(R.id.tv_daily_limit_available);
        this.n = (TextView) findViewById(R.id.tv_monthly_limit_payment_complete);
        this.o = (TextView) findViewById(R.id.tv_monthly_limit_remaining);
        this.p = (TextView) findViewById(R.id.tv_monthly_limit_spent);
        this.q = (TextView) findViewById(R.id.tv_monthly_limit_available);
        this.r = (Button) findViewById(R.id.btn_save);
        this.s = (EditText) findViewById(R.id.et_daily_limit_number_of_payments);
        this.t = (EditText) findViewById(R.id.et_daily_limit_amount_to_be_spent);
        this.u = (EditText) findViewById(R.id.et_monthly_limit_number_of_payments);
        this.v = (EditText) findViewById(R.id.et_monthly_limit_amount_to_be_spent);
        this.w = (ProgressBar) findViewById(R.id.pb_daily_limit_payment_complete);
        this.x = (ProgressBar) findViewById(R.id.pb_daily_limit_spent);
        this.y = (ProgressBar) findViewById(R.id.pb_monthly_limit_payment_complete);
        this.z = (ProgressBar) findViewById(R.id.pb_monthly_limit_spent);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_add_limits) {
            this.f59330a.setVisibility(8);
            this.f59331b.setVisibility(0);
        } else if (view.getId() == R.id.tv_remove) {
            this.s.setText("");
            this.t.setText("");
            this.u.setText("");
            this.v.setText("");
        }
    }

    public Map<String, EditText> getData() {
        HashMap hashMap = new HashMap();
        hashMap.put("etDailyLimitAmountToBeSpent", this.t);
        hashMap.put("etDailyLimitNumberOfPayments", this.s);
        hashMap.put("etMonthlyLimitAmountToBeSpent", this.v);
        hashMap.put("etMonthlyLimitNumberOfPayments", this.u);
        return hashMap;
    }
}

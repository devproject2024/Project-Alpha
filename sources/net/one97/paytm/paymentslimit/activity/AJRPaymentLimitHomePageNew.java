package net.one97.paytm.paymentslimit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentslimit.c.a;
import net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView;
import net.one97.paytm.wallet.R;

public class AJRPaymentLimitHomePageNew extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public PaymentLimitsCompoundView f59275a;

    /* renamed from: b  reason: collision with root package name */
    public PaymentLimitsCompoundView f59276b;

    /* renamed from: c  reason: collision with root package name */
    public PaymentLimitsCompoundView f59277c;

    /* renamed from: d  reason: collision with root package name */
    boolean f59278d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f59279e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f59280f = false;

    /* renamed from: g  reason: collision with root package name */
    private a f59281g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f59282h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_payment_limit_home_new);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.f59275a = (PaymentLimitsCompoundView) findViewById(R.id.compound_view_merchants);
        this.f59276b = (PaymentLimitsCompoundView) findViewById(R.id.compound_view_paytm_users);
        this.f59277c = (PaymentLimitsCompoundView) findViewById(R.id.compound_view_send_money_to_bank);
        this.f59282h = (ImageView) findViewById(R.id.iv_back_arrow);
        this.f59275a.f59336g.setText("Merchants");
        this.f59276b.f59336g.setText("Paytm Users");
        this.f59277c.f59336g.setText("Send Money to Bank");
        this.f59275a.f59337h.setText("Merchants");
        this.f59276b.f59337h.setText("Paytm Users");
        this.f59277c.f59337h.setText("Send Money to Bank");
        this.f59275a.f59338i.setText("Merchants");
        this.f59276b.f59338i.setText("Paytm Users");
        this.f59277c.f59338i.setText("Send Money to Bank");
        this.f59281g = new a(this, this);
        this.f59281g.a();
        this.f59275a.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.c(view);
            }
        });
        this.f59276b.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.b(view);
            }
        });
        this.f59277c.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.a(view);
            }
        });
        this.f59275a.f59335f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.f(view);
            }
        });
        this.f59276b.f59335f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.e(view);
            }
        });
        this.f59277c.f59335f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.d(view);
            }
        });
        this.f59282h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitHomePageNew.this.g(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.f59275a.f59332c.setVisibility(8);
        this.f59275a.f59331b.setVisibility(0);
        this.f59281g.a(this.f59275a, "Merchants");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.f59276b.f59332c.setVisibility(8);
        this.f59276b.f59331b.setVisibility(0);
        this.f59281g.a(this.f59276b, "Paytm Users");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.f59277c.f59332c.setVisibility(8);
        this.f59277c.f59331b.setVisibility(0);
        this.f59281g.a(this.f59277c, "Send Money to Bank");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f59278d = true;
        this.f59279e = false;
        this.f59280f = false;
        this.f59281g.a(this.f59275a.getData(), "Merchants");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f59278d = false;
        this.f59279e = true;
        this.f59280f = false;
        this.f59281g.a(this.f59276b.getData(), "Paytm Users");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f59278d = false;
        this.f59279e = false;
        this.f59280f = true;
        this.f59281g.a(this.f59277c.getData(), "Send Money to Bank");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f59281g.a();
        if (i3 != -1) {
            return;
        }
        if (this.f59278d) {
            this.f59275a.f59331b.setVisibility(8);
            this.f59275a.f59332c.setVisibility(0);
        } else if (this.f59279e) {
            this.f59276b.f59331b.setVisibility(8);
            this.f59276b.f59332c.setVisibility(0);
        } else if (this.f59280f) {
            this.f59277c.f59331b.setVisibility(8);
            this.f59277c.f59332c.setVisibility(0);
        }
    }
}

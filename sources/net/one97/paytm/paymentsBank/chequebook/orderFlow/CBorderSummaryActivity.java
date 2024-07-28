package net.one97.paytm.paymentsBank.chequebook.orderFlow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.view.CBTLandingView;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.pdc.response.PDCStatusResponse;
import net.one97.paytm.paymentsBank.utils.o;

public class CBorderSummaryActivity extends PaytmActivity implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f17663a = (!CBorderSummaryActivity.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private TextView f17664b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17665c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17666d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17667e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f17668f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f17669g;

    /* renamed from: h  reason: collision with root package name */
    private int f17670h = 0;

    /* renamed from: i  reason: collision with root package name */
    private ConstraintLayout f17671i;
    private LottieAnimationView j;
    private TextView k;
    private ShimmerFrameLayout l;
    private ShimmerFrameLayout m;
    private View n;
    private String o = "";
    private TextView p;
    private View q;
    private View r;
    private View s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cb_order_summary_activity);
        String stringExtra = getIntent().getStringExtra("responseMsg");
        if (getIntent() != null) {
            this.f17669g = getIntent().getStringExtra("order_id");
        }
        if (getIntent() != null && getIntent().hasExtra("cheque_book_amount")) {
            this.o = getIntent().getStringExtra("cheque_book_amount");
        }
        if (TextUtils.isEmpty(this.f17669g)) {
            com.paytm.utility.b.b((Context) this, "Error!", stringExtra);
            return;
        }
        this.s = findViewById(R.id.sep_view);
        this.r = findViewById(R.id.pay_status_lyt);
        this.q = findViewById(R.id.need_help_view);
        this.k = (TextView) findViewById(R.id.pdc_success_amount_success);
        this.f17671i = (ConstraintLayout) findViewById(R.id.ll_paymnet_summary_parent);
        this.f17668f = findViewById(R.id.pb_pending);
        this.j = (LottieAnimationView) findViewById(R.id.pdc_success_failure_img);
        this.f17664b = (TextView) findViewById(R.id.tv_cb_order_status);
        this.f17665c = (TextView) findViewById(R.id.tv_cb_money_deducted);
        this.f17666d = (TextView) findViewById(R.id.tv_cb_order_number);
        this.f17667e = (TextView) findViewById(R.id.tv_cb_order_date);
        ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(this);
        this.l = (ShimmerFrameLayout) findViewById(R.id.shimmer_lyt_top);
        this.m = (ShimmerFrameLayout) findViewById(R.id.shimmer_lyt_bottom);
        this.n = findViewById(R.id.shimmer_view_id);
        this.p = (TextView) findViewById(R.id.tv_status_header);
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CBorderSummaryActivity.this.a(view);
            }
        });
        if (!TextUtils.isEmpty(this.o)) {
            this.p.setText(getString(R.string.pb_cb_order_processing_text, new Object[]{this.o}));
        } else {
            this.p.setText(getString(R.string.pb_cb_order_processing_text_default));
        }
        this.j.setVisibility(0);
        this.j.setImageResource(R.drawable.pdc_pending_svg);
        this.f17664b.setText(getString(R.string.pb_cb_payment_pending));
        c();
    }

    private void a() {
        ShimmerFrameLayout shimmerFrameLayout = this.m;
        if (shimmerFrameLayout != null && !shimmerFrameLayout.f49623a) {
            this.n.setVisibility(0);
            this.l.a();
            this.m.a();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.l.b();
        this.m.b();
        this.n.setVisibility(8);
    }

    private void c() {
        int i2 = this.f17670h;
        if (i2 > 4) {
            b();
            this.f17668f.setVisibility(8);
        } else if (i2 == 0) {
            a();
            f();
        } else {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    CBorderSummaryActivity.this.f();
                }
            }, 4000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void f() {
        this.f17670h++;
        g a2 = g.a((Context) this);
        if (a2 != null) {
            a b2 = a2.b(getApplicationContext(), this.f17669g, this, getClass().getSimpleName());
            if (!com.paytm.utility.b.c((Context) this)) {
                e();
                com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.network_error_message));
            } else if (f17663a || b2 != null) {
                b2.a();
            } else {
                throw new AssertionError();
            }
        }
    }

    private void e() {
        this.r.setVisibility(8);
        this.f17665c.setVisibility(8);
        this.f17666d.setVisibility(8);
        this.f17667e.setVisibility(8);
        this.s.setVisibility(8);
        b();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_cb_money_deducted) {
            onBackPressed();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        this.f17668f.setVisibility(8);
        if (iJRPaytmDataModel == null) {
            c();
        } else if (iJRPaytmDataModel instanceof PDCStatusResponse) {
            PDCStatusResponse pDCStatusResponse = (PDCStatusResponse) iJRPaytmDataModel;
            if (pDCStatusResponse.getResponseCode().intValue() == 200) {
                this.f17671i.setVisibility(0);
                if (pDCStatusResponse.getPayload() == null || pDCStatusResponse.getPayload().getStatus() == null) {
                    b(pDCStatusResponse);
                    a(pDCStatusResponse);
                    c();
                    return;
                }
                if (!TextUtils.isEmpty(pDCStatusResponse.getPayload().getState()) && pDCStatusResponse.getPayload().getState().equalsIgnoreCase("TRANSACTION_SUCCESS")) {
                    this.j.setVisibility(0);
                    this.j.setImageResource(R.drawable.cb_os_success);
                    this.f17664b.setText(getString(R.string.pb_cb_os_payment_success_txn));
                    this.f17665c.setVisibility(4);
                    if (pDCStatusResponse == null || pDCStatusResponse.getPayload() == null || pDCStatusResponse.getPayload().getAmount() < 0.0d) {
                        str2 = this.o;
                    } else {
                        str2 = Double.toString(pDCStatusResponse.getPayload().getAmount());
                    }
                    this.k.setText(getString(R.string.pb_pdc_order_rupee, new Object[]{str2}));
                    g a2 = g.a((Context) this);
                    if (a2 != null) {
                        a b2 = a2.b(this, new b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                CBorderSummaryActivity.this.f17668f.setVisibility(8);
                                if (iJRPaytmDataModel instanceof ChequeBookFinResponse) {
                                    ChequeBookFinResponse chequeBookFinResponse = (ChequeBookFinResponse) iJRPaytmDataModel;
                                    h.a((Context) CBorderSummaryActivity.this);
                                    h.a("CB_KEY_FIN_RESPONSE", new f().a((Object) chequeBookFinResponse), CBorderSummaryActivity.this);
                                    if (chequeBookFinResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                                        ChequeBookResponse response = chequeBookFinResponse.getResponse();
                                        if (response != null) {
                                            ChequeBookSignature signature = response.getSignature();
                                            if (signature != null) {
                                                String status = signature.getStatus();
                                                Intent intent = new Intent(CBorderSummaryActivity.this, CBTLandingView.class);
                                                if ("ACCEPTED".equalsIgnoreCase(status)) {
                                                    intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", false);
                                                    intent.putExtra("order_id_extra", CBorderSummaryActivity.this.f17669g);
                                                } else {
                                                    intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", true);
                                                    intent.putExtra("order_id_extra", CBorderSummaryActivity.this.f17669g);
                                                }
                                                CBorderSummaryActivity.this.startActivity(intent);
                                                CBorderSummaryActivity.this.finish();
                                                return;
                                            }
                                            CBorderSummaryActivity.this.b();
                                            return;
                                        }
                                        CBorderSummaryActivity.this.b();
                                        return;
                                    }
                                    CBorderSummaryActivity.this.b();
                                }
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                CBorderSummaryActivity.this.b();
                                net.one97.paytm.bankCommon.utils.f.a((Activity) CBorderSummaryActivity.this, (Exception) networkCustomError, (String) null);
                            }
                        }, getClass().getSimpleName());
                        if (!com.paytm.utility.b.c((Context) this)) {
                            b();
                            com.paytm.utility.b.b((Context) this, getString(R.string.pb_title_connection_problem), getString(R.string.pb_msg_connection_problem));
                        } else if (b2 != null) {
                            this.f17668f.setVisibility(0);
                            b2.a();
                        } else {
                            b();
                            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
                        }
                    }
                } else if (TextUtils.isEmpty(pDCStatusResponse.getPayload().getState()) || !pDCStatusResponse.getPayload().getState().equalsIgnoreCase("TRANSACTION_FAILURE")) {
                    b(pDCStatusResponse);
                    c();
                } else {
                    this.j.setVisibility(0);
                    this.j.setImageResource(R.drawable.pdc_failure_svg);
                    this.f17665c.setVisibility(0);
                    this.f17665c.setText(getString(R.string.pb_cb_failure_os_sub_text));
                    this.f17664b.setText(getString(R.string.pb_cb_payment_failed));
                    if (pDCStatusResponse == null || pDCStatusResponse.getPayload() == null || pDCStatusResponse.getPayload().getAmount() < 0.0d) {
                        str = this.o;
                    } else {
                        str = Double.toString(pDCStatusResponse.getPayload().getAmount());
                    }
                    this.k.setText(getString(R.string.pb_pdc_order_rupee, new Object[]{str}));
                    b();
                }
                a(pDCStatusResponse);
            }
        }
    }

    private void a(PDCStatusResponse pDCStatusResponse) {
        try {
            this.f17666d.setText(String.format(getResources().getString(R.string.pdc_order_no), new Object[]{this.f17669g}));
            this.f17667e.setText(com.paytm.utility.b.a(Long.valueOf(pDCStatusResponse.getPayload().getCreated()), "hh:mm , dd MMM yyyy"));
        } catch (Exception unused) {
        }
    }

    private void b(PDCStatusResponse pDCStatusResponse) {
        String str;
        this.j.setVisibility(0);
        this.j.setImageResource(R.drawable.pdc_pending_svg);
        this.f17664b.setText(getString(R.string.pb_cb_payment_pending));
        this.f17665c.setVisibility(0);
        this.f17665c.setText(getString(R.string.cb_notify_payment));
        if (pDCStatusResponse == null || pDCStatusResponse.getPayload() == null || pDCStatusResponse.getPayload().getAmount() < 0.0d) {
            str = this.o;
        } else {
            str = Double.toString(pDCStatusResponse.getPayload().getAmount());
        }
        this.k.setText(getString(R.string.pb_pdc_order_rupee, new Object[]{str}));
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        o.a().checkDeepLinking(this, "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=4&templateId=6");
    }
}

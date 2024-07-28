package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.QRCodeResponse;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.CashWithdrawPostTransactionRedemptionStatus;
import net.one97.paytm.paymentsBank.fragment.h;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.utils.o;

public class QRCodeActivity extends PaytmActivity implements View.OnClickListener {
    private static long x;

    /* renamed from: a  reason: collision with root package name */
    int f18280a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f18281b = 1;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f18282c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f18283d;

    /* renamed from: e  reason: collision with root package name */
    boolean f18284e;

    /* renamed from: f  reason: collision with root package name */
    String f18285f;

    /* renamed from: g  reason: collision with root package name */
    boolean f18286g;

    /* renamed from: h  reason: collision with root package name */
    double f18287h;

    /* renamed from: i  reason: collision with root package name */
    String f18288i = "abc";
    private RelativeLayout j;
    private String k;
    private h l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public CountDownTimer o;
    private String p;
    private View q;
    private View r;
    private View s;
    private View t;
    private String u = "5";
    private String v = "00";
    private Handler w = new Handler();

    public void onClick(View view) {
    }

    public void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_qr_code_withdraw);
        this.j = (RelativeLayout) findViewById(R.id.rl_loader_wrapper);
        this.j.setVisibility(0);
        this.k = getIntent().getStringExtra("amount");
        this.l = new h(this);
        this.l.f18513a = getString(R.string.please_wait_progress_msg);
        ((TextView) findViewById(R.id.tv_amnt)).setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(this.k)}));
        this.f18283d = (LinearLayout) findViewById(R.id.ll_qr_expired);
        this.f18282c = (LinearLayout) findViewById(R.id.ll_qr_expire_timer);
        this.q = findViewById(R.id.regenerate_qr_tv);
        this.r = findViewById(R.id.tv_to_avoid);
        this.s = findViewById(R.id.tv_clear_qr);
        this.t = findViewById(R.id.iv_qr_fade_view);
        this.f18287h = getIntent().getDoubleExtra("effectivebalance", 0.0d);
        findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRCodeActivity.this.c(view);
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRCodeActivity.this.b(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRCodeActivity.this.a(view);
            }
        });
        this.m = (TextView) findViewById(R.id.tv_min);
        this.n = (TextView) findViewById(R.id.tv_sec);
        this.o = new CountDownTimer((long) (Integer.valueOf(this.u).intValue() * 60000)) {
            public final void onTick(long j) {
                if (QRCodeActivity.this.f18281b == 0 && QRCodeActivity.this.f18280a == 0) {
                    QRCodeActivity.this.o.cancel();
                    QRCodeActivity.this.a();
                    return;
                }
                if (QRCodeActivity.this.f18280a == 0) {
                    QRCodeActivity qRCodeActivity = QRCodeActivity.this;
                    qRCodeActivity.f18281b--;
                    QRCodeActivity.this.f18280a = 59;
                } else {
                    QRCodeActivity qRCodeActivity2 = QRCodeActivity.this;
                    qRCodeActivity2.f18280a--;
                }
                QRCodeActivity.this.n.setText(String.valueOf(QRCodeActivity.this.f18280a));
                QRCodeActivity.this.m.setText(String.valueOf(QRCodeActivity.this.f18281b));
            }

            public final void onFinish() {
                QRCodeActivity.this.a();
            }
        };
        if (getIntent().hasExtra("qrcodeId")) {
            String stringExtra = getIntent().getStringExtra("qrcodeId");
            this.j.setVisibility(8);
            o.a().getQRCodeBitmap((ImageView) findViewById(R.id.iv_qr), stringExtra, this);
            this.f18285f = stringExtra;
            if (bundle != null) {
                x = bundle.getLong("timer");
                long currentTimeMillis = System.currentTimeMillis();
                long intValue = x + ((long) (Integer.valueOf(this.u).intValue() * 60000));
                if (intValue < currentTimeMillis) {
                    a();
                    return;
                }
                long j2 = intValue - currentTimeMillis;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(j2);
                a(String.valueOf(minutes), String.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2 - TimeUnit.MINUTES.toMillis(minutes))));
                b();
                return;
            }
            x = System.currentTimeMillis();
            a(this.u, this.v);
            b();
            return;
        }
        this.l.a();
        if (getIntent().hasExtra(StringSet.token)) {
            this.p = getIntent().getStringExtra(StringSet.token);
        }
        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.a.f18227a.a(this, this.p, this.k, new g.b() {
            public final void onResponse(Object obj) {
                QRCodeActivity.this.c((IJRPaytmDataModel) obj);
            }
        }, new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                QRCodeActivity.this.c(i2, iJRPaytmDataModel, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
        String string = getString(R.string.CASH_WIDRAWL_TITLE);
        BankPasscodeActivity.a.a((Activity) this, string, getString(R.string.pb_cw_passcode_title) + " " + getString(R.string.pb_pdc_order_rupee, new Object[]{this.k}), getString(R.string.pb_enter_passcode_hint));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.o.cancel();
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f18282c.setVisibility(4);
        this.f18283d.setVisibility(0);
        this.q.setVisibility(0);
        this.t.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
    }

    private void a(String str, String str2) {
        this.o.cancel();
        this.f18280a = Integer.valueOf(str2).intValue();
        this.f18281b = Integer.valueOf(str).intValue();
        this.m.setText(str);
        this.n.setText(str2);
        this.f18282c.setVisibility(0);
        this.f18283d.setVisibility(8);
        this.q.setVisibility(8);
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.o.start();
    }

    public void onPause() {
        System.currentTimeMillis();
        super.onPause();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(IJRPaytmDataModel iJRPaytmDataModel) {
        this.l.b();
        this.j.setVisibility(8);
        QRCodeResponse qRCodeResponse = (QRCodeResponse) iJRPaytmDataModel;
        if ("success".equalsIgnoreCase(qRCodeResponse.getResponseMessage())) {
            o.a().getQRCodeBitmap((ImageView) findViewById(R.id.iv_qr), qRCodeResponse.getPayload().getQrCodeId(), this);
            this.f18285f = qRCodeResponse.getPayload().getQrCodeId();
            x = System.currentTimeMillis();
            a(this.u, this.v);
            b();
            return;
        }
        b.b((Context) this, getString(R.string.error), qRCodeResponse.getResponseMessage());
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.j.setVisibility(8);
        this.l.b();
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f18284e = false;
        this.l.b();
        this.j.setVisibility(8);
        QRCodeResponse qRCodeResponse = (QRCodeResponse) iJRPaytmDataModel;
        if (qRCodeResponse.getResponseMessage().equalsIgnoreCase("success")) {
            o.a().getQRCodeBitmap((ImageView) findViewById(R.id.iv_qr), qRCodeResponse.getPayload().getQrCodeId(), this);
            this.f18285f = qRCodeResponse.getPayload().getQrCodeId();
            x = System.currentTimeMillis();
            a(this.u, this.v);
            b();
            return;
        }
        b.b((Context) this, getString(R.string.error), qRCodeResponse.getResponseMessage());
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f18284e = false;
        this.j.setVisibility(8);
        this.l.b();
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f18286g = false;
        if (iJRPaytmDataModel instanceof CashWithdrawPostTransactionRedemptionStatus) {
            CashWithdrawPostTransactionRedemptionStatus cashWithdrawPostTransactionRedemptionStatus = (CashWithdrawPostTransactionRedemptionStatus) iJRPaytmDataModel;
            Intent intent = new Intent(this, CashWithdrawPostRedemptionSuccess.class);
            intent.putExtra("effectivebalance", this.f18287h);
            intent.putExtra("name", getIntent().getStringExtra("name"));
            intent.putExtra("isbankbranch", getIntent().getBooleanExtra("isbankbranch", false));
            intent.putExtra("amount", this.k);
            if ("SUCCESS".equalsIgnoreCase(cashWithdrawPostTransactionRedemptionStatus.getPayload().getStatus())) {
                this.f18288i = "success";
                intent.putExtra("status", this.f18288i);
                intent.putExtra("orderId", cashWithdrawPostTransactionRedemptionStatus.getPayload().getOrderId());
                intent.putExtra("orderDate", cashWithdrawPostTransactionRedemptionStatus.getPayload().getOrderDate());
                startActivity(intent);
                finish();
            } else if ("FAILURE".equalsIgnoreCase(cashWithdrawPostTransactionRedemptionStatus.getPayload().getStatus())) {
                this.f18288i = ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE;
                intent.putExtra("status", this.f18288i);
                intent.putExtra("orderId", cashWithdrawPostTransactionRedemptionStatus.getPayload().getOrderId());
                intent.putExtra("orderDate", cashWithdrawPostTransactionRedemptionStatus.getPayload().getOrderDate());
                startActivity(intent);
                finish();
            } else {
                this.f18288i = SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING;
                b();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f18286g = false;
        b();
    }

    private void b() {
        String str = this.f18288i;
        if ((str == null || !str.equalsIgnoreCase("success")) && !this.f18288i.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
            this.w.postDelayed(new Runnable() {
                public final void run() {
                    QRCodeActivity.this.c();
                }
            }, 10000);
        }
    }

    public void onDestroy() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            try {
                if (!TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                    this.p = intent.getStringExtra("passcode");
                    if (!this.f18284e) {
                        this.f18284e = true;
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("screen_name", getClass().getSimpleName());
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("ssotoken", this.p);
                        d.b();
                        String a2 = d.a("generate_qrcode_withdraw_cash");
                        StringBuilder sb = new StringBuilder();
                        if (TextUtils.isEmpty(a2)) {
                            sb.append("https://bankfulfillment-ite.paytmbank.com/qrcode/ext/v1/generate");
                        } else {
                            sb.append(a2);
                        }
                        sb.append("?amount=");
                        sb.append(this.k);
                        net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(sb.toString(), new g.b() {
                            public final void onResponse(Object obj) {
                                QRCodeActivity.this.b((IJRPaytmDataModel) obj);
                            }
                        }, new g.a() {
                            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                QRCodeActivity.this.b(i2, iJRPaytmDataModel, networkCustomError);
                            }
                        }, new QRCodeResponse(), hashMap, (String) null, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
                        getApplicationContext();
                        new c();
                        c.a(bVar);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putLong("timer", x);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (!this.f18286g && !TextUtils.isEmpty(this.f18285f)) {
            this.f18286g = true;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("userToken", com.paytm.utility.a.q(this));
            d.b();
            String a2 = d.a("gettxnstatus_withdraw_cash");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(a2)) {
                sb.append("https://bankfulfillment-ite.paytmbank.com/qr/ext/v1/qr/txn/status");
            } else {
                sb.append(a2);
            }
            sb.append("?qrCodeId=");
            sb.append(this.f18285f);
            net.one97.paytm.bankCommon.g.a aVar = new net.one97.paytm.bankCommon.g.a(sb.toString(), (g.b) new g.b() {
                public final void onResponse(Object obj) {
                    QRCodeActivity.this.a((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    QRCodeActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, (IJRPaytmDataModel) new CashWithdrawPostTransactionRedemptionStatus(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            getApplicationContext();
            new c();
            c.a(aVar);
        }
    }
}

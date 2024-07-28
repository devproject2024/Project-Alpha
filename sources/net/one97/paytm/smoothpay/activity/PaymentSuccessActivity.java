package net.one97.paytm.smoothpay.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.j.a;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2mNewDesign.f.k;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.b.b;
import net.one97.paytm.wallet.c.g;
import net.one97.paytm.wallet.d.h;

public class PaymentSuccessActivity extends AppCompatLockActivity implements k {

    /* renamed from: e  reason: collision with root package name */
    private boolean f65036e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f65037f;

    /* renamed from: g  reason: collision with root package name */
    private String f65038g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f65039h = false;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f65040i;
    private MediaPlayer j;
    private boolean k;
    private String l;
    private String m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private boolean s;
    private boolean t;
    private double u;
    private boolean v = false;
    private String w;
    private String x;

    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_payment_success_latest);
        if (bundle2 != null && bundle2.containsKey("shouldPlaySound")) {
            this.f65036e = bundle2.getBoolean("shouldPlaySound");
        }
        try {
            a.b("/wallet/pay-send/success", "Wallet", (Context) this);
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "success");
            a.b("wallet_send_money_method_selected", (Map<String, Object>) hashMap, getApplicationContext());
        } catch (Exception unused) {
        }
        getSupportActionBar().f();
        IJRDataModel iJRDataModel = (IJRDataModel) getIntent().getSerializableExtra("bundle");
        this.f65037f = getIntent().getStringExtra("amount");
        getIntent().getStringExtra("tran_time");
        String stringExtra = getIntent().getStringExtra("key_via");
        String stringExtra2 = getIntent().getStringExtra("phone_no");
        String stringExtra3 = getIntent().getStringExtra("amount");
        String stringExtra4 = getIntent().getStringExtra("name");
        this.f65038g = getIntent().getStringExtra("pay_response");
        this.f65039h = getIntent().getBooleanExtra("is_from_mobile_number", false);
        this.f65040i = getIntent().getExtras();
        this.t = getIntent().getBooleanExtra("is_pcf", false);
        this.u = getIntent().getDoubleExtra("pcf_amount", 0.0d);
        this.k = getIntent().getBooleanExtra("is_emi", false);
        this.l = getIntent().getStringExtra("emi_message");
        this.f65039h = getIntent().getBooleanExtra("is_from_mobile_number", false);
        this.f65040i = getIntent().getExtras();
        this.n = getIntent().getBooleanExtra("is_from_recent", false);
        this.o = getIntent().getBooleanExtra("isSingleAPI", false);
        this.s = getIntent().getBooleanExtra("is_amt_already_present", false);
        if (getIntent().hasExtra("qrScanTime")) {
            this.m = getIntent().getStringExtra("qrScanTime");
        }
        if (getIntent().hasExtra("suggestedInstrument")) {
            this.p = getIntent().getStringExtra("suggestedInstrument");
        }
        String str = "is_emi";
        if (getIntent().hasExtra("pay_mode_type")) {
            this.q = getIntent().getStringExtra("pay_mode_type");
        }
        if (getIntent().hasExtra("pay_mode_load_time")) {
            this.r = getIntent().getStringExtra("pay_mode_load_time");
        }
        this.v = getIntent().getBooleanExtra("is_static_qr_code", false);
        this.w = getIntent().getStringExtra("pay_mode");
        this.x = getIntent().getStringExtra("unique_identifier");
        String stringExtra5 = getIntent().getStringExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL);
        boolean booleanExtra = getIntent().getBooleanExtra("isP2B", false);
        String str2 = str;
        boolean booleanExtra2 = getIntent().getBooleanExtra("is_upi", false);
        String stringExtra6 = getIntent().getStringExtra(PayUtility.ACCOUNT_NUMBER);
        String str3 = str2;
        String stringExtra7 = getIntent().getStringExtra("paymentMode");
        String str4 = "pcf_amount";
        String str5 = "qrScanTime";
        String stringExtra8 = getIntent().getStringExtra("paymentType");
        String str6 = "is_pcf";
        String stringExtra9 = getIntent().getStringExtra("tagline");
        String str7 = str6;
        String stringExtra10 = getIntent().getStringExtra(PayUtility.BANK_NAME);
        boolean booleanExtra3 = getIntent().getBooleanExtra("is_from_deeplink", false);
        String stringExtra11 = getIntent().getStringExtra("ref_id");
        String str8 = stringExtra2;
        double doubleExtra = getIntent().getDoubleExtra("txn_fee", 0.0d);
        String str9 = "suggestedInstrument";
        String str10 = "pay_response";
        String str11 = "is_from_mobile_number";
        String str12 = str4;
        String str13 = "emi_message";
        String str14 = str6;
        String stringExtra12 = getIntent().getStringExtra("p2b_success_message");
        String stringExtra13 = getIntent().getStringExtra("p2b_pending_message");
        String str15 = "tran_time";
        Fragment a2 = g.a(iJRDataModel, stringExtra4, stringExtra3, stringExtra5, booleanExtra, stringExtra6, stringExtra7, stringExtra8, stringExtra9, doubleExtra, stringExtra, str8, stringExtra10, booleanExtra2, booleanExtra3, stringExtra11);
        a2.getArguments().putBoolean("is_offline_pg", getIntent().getBooleanExtra("is_offline_pg", false));
        a2.getArguments().putBoolean("is_wallet_transection", getIntent().getBooleanExtra("is_wallet_transection", false));
        a2.getArguments().putBoolean("backpress_offline_pg", getIntent().getBooleanExtra("backpress_offline_pg", false));
        a2.getArguments().putBoolean("is_postpaid", getIntent().getBooleanExtra("is_postpaid", false));
        String str16 = "is_upi";
        a2.getArguments().putBoolean(str16, getIntent().getBooleanExtra(str16, false));
        a2.getArguments().putBoolean("isFromPassbook", getIntent().getBooleanExtra("isFromPassbook", false));
        a2.getArguments().putBoolean("is_ppb_transaction", getIntent().getBooleanExtra("is_ppb_transaction", false));
        a2.getArguments().putBoolean("is_card_transaction", getIntent().getBooleanExtra("is_card_transaction", false));
        a2.getArguments().putBoolean("is_net_banking_transaction", getIntent().getBooleanExtra("is_net_banking_transaction", false));
        a2.getArguments().putString("merchant_logo", getIntent().getStringExtra("merchant_logo"));
        a2.getArguments().putString(str15, getIntent().getStringExtra(str15));
        String str17 = str3;
        a2.getArguments().putBoolean(str17, getIntent().getBooleanExtra(str17, false));
        a2.getArguments().putString(str13, getIntent().getStringExtra(str13));
        a2.getArguments().putBoolean(str14, this.t);
        a2.getArguments().putDouble(str12, this.u);
        if (!TextUtils.isEmpty(stringExtra12)) {
            a2.getArguments().putString("p2b_success_message", stringExtra12);
        }
        if (!TextUtils.isEmpty(stringExtra13)) {
            a2.getArguments().putString("p2b_pending_message", stringExtra13);
        }
        a2.getArguments().putBoolean(str11, this.f65039h);
        a2.getArguments().putBundle("sbBundle", this.f65040i);
        a2.getArguments().putBoolean("is_static_qr_code", this.v);
        a2.getArguments().putString("pay_mode", this.w);
        a2.getArguments().putString("unique_identifier", this.x);
        a2.getArguments().putString("scan_result", getIntent().getStringExtra("scan_result"));
        a2.getArguments().putBoolean("is_link_based_payment", getIntent().getBooleanExtra("is_link_based_payment", false));
        if (this.f65038g != null) {
            a2.getArguments().putString(str10, this.f65038g);
        }
        a2.getArguments().putBoolean(str17, this.k);
        if (this.k) {
            a2.getArguments().putString(str13, this.l);
        }
        a2.getArguments().putBoolean("is_from_recent", this.n);
        a2.getArguments().putBoolean("isSingleAPI", this.o);
        a2.getArguments().putBoolean("is_amt_already_present", this.s);
        if (!TextUtils.isEmpty(this.m)) {
            a2.getArguments().putString(str5, this.m);
        }
        if (!TextUtils.isEmpty(this.p)) {
            a2.getArguments().putString(str9, this.p);
        }
        if (!TextUtils.isEmpty(this.r)) {
            a2.getArguments().putString("page_load_time", this.r);
        }
        if (!TextUtils.isEmpty(this.q)) {
            a2.getArguments().putString("page_load_type", this.q);
        }
        if (getIntent().getBooleanExtra("backpress_offline_pg", false)) {
            a2.getArguments().putString("order_id", getIntent().getStringExtra("order_id"));
            a2.getArguments().putString("mid", getIntent().getStringExtra("mid"));
        }
        getSupportFragmentManager().a((String) null);
        getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, a2, "tag_donate_noble").b();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("bill")) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    PaymentSuccessActivity paymentSuccessActivity = PaymentSuccessActivity.this;
                    if (paymentSuccessActivity != null && !paymentSuccessActivity.isFinishing()) {
                        PaymentSuccessActivity.this.setResult(-1);
                        PaymentSuccessActivity.this.finish();
                    }
                }
            }, 2000);
        }
    }

    public final void a() {
        this.f51786a = 102;
    }

    public void setTitle(CharSequence charSequence) {
        ((TextView) findViewById(R.id.title)).setText(charSequence);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 104 && i3 == -1) {
            Fragment c2 = getSupportFragmentManager().c("tag_donate_noble");
            if (c2 instanceof g) {
                g gVar = (g) c2;
                gVar.m.setEnabled(true);
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                    if (gVar.f70019e == null) {
                        gVar.f70019e = new h();
                    }
                    if (!booleanExtra) {
                        gVar.f70019e.b(stringExtra);
                        return;
                    }
                    gVar.o = 0;
                    gVar.n = false;
                    b<Integer> bVar = gVar.j;
                    if (bVar.f69970c != null) {
                        bVar.f69970c.setSelected(false);
                    }
                    bVar.f69970c = null;
                    bVar.f69971d = -1;
                    bVar.notifyDataSetChanged();
                    if (gVar.l.intValue() != 0 && gVar.k.getVisibility() == 8) {
                        gVar.k.setVisibility(0);
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.f65036e) {
            this.j = MediaPlayer.create(this, R.raw.payment_success);
            this.f65036e = false;
            if (!this.j.isPlaying()) {
                this.j.start();
            }
            this.j.setOnCompletionListener($$Lambda$E7FaxYylohOwFmBzAjza06XyF8.INSTANCE);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shouldPlaySound", false);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}

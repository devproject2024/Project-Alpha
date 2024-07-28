package net.one97.paytm.p2mNewDesign.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2mNewDesign.d.d;
import net.one97.paytm.p2mNewDesign.f.k;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.h;

public class P2MPaymentSuccessActivity extends AppCompatLockActivity implements k {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private boolean F = false;
    private String G;
    private String H;
    private int I;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13205e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f13206f;

    /* renamed from: g  reason: collision with root package name */
    private String f13207g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13208h = false;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f13209i;
    private MediaPlayer j;
    private boolean k;
    private String l;
    private String m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private boolean u;
    private double v;
    private boolean w = false;
    private String x;
    private String y;
    private boolean z = false;

    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        super.onCreate(bundle);
        q.b("Inside Post payment");
        setContentView(R.layout.activity_payment_success_latest);
        if (bundle2 != null && bundle2.containsKey("shouldPlaySound")) {
            this.f13205e = bundle2.getBoolean("shouldPlaySound");
        }
        try {
            new HashMap().put("wallet_send_money_method_name", "success");
        } catch (Exception unused) {
        }
        getSupportActionBar().f();
        IJRDataModel iJRDataModel = (IJRDataModel) getIntent().getSerializableExtra("bundle");
        this.f13206f = getIntent().getStringExtra("amount");
        getIntent().getStringExtra("tran_time");
        String stringExtra = getIntent().getStringExtra("key_via");
        String stringExtra2 = getIntent().getStringExtra("phone_no");
        String stringExtra3 = getIntent().getStringExtra("amount");
        String stringExtra4 = getIntent().getStringExtra("name");
        this.f13207g = getIntent().getStringExtra("pay_response");
        this.f13208h = getIntent().getBooleanExtra("is_from_mobile_number", false);
        this.f13209i = getIntent().getExtras();
        this.u = getIntent().getBooleanExtra("is_pcf", false);
        this.v = getIntent().getDoubleExtra("pcf_amount", 0.0d);
        this.k = getIntent().getBooleanExtra("is_emi", false);
        this.l = getIntent().getStringExtra("emi_message");
        this.f13208h = getIntent().getBooleanExtra("is_from_mobile_number", false);
        this.f13209i = getIntent().getExtras();
        this.n = getIntent().getBooleanExtra("is_from_recent", false);
        this.o = getIntent().getBooleanExtra("isAutoFlashTxn", false);
        this.p = getIntent().getBooleanExtra("isSingleAPI", false);
        this.t = getIntent().getBooleanExtra("is_amt_already_present", false);
        this.I = getIntent().getIntExtra("launchFrom", e.C0905e.PAY.getType());
        if (getIntent().hasExtra("qrScanTime")) {
            this.m = getIntent().getStringExtra("qrScanTime");
        }
        if (getIntent().hasExtra("suggestedInstrument")) {
            this.q = getIntent().getStringExtra("suggestedInstrument");
        }
        if (getIntent().hasExtra("pay_mode_type")) {
            this.r = getIntent().getStringExtra("pay_mode_type");
        }
        if (getIntent().hasExtra("pay_mode_load_time")) {
            this.s = getIntent().getStringExtra("pay_mode_load_time");
        }
        if (getIntent().hasExtra("payee_vpa")) {
            this.G = getIntent().getStringExtra("payee_vpa");
        }
        if (getIntent().hasExtra(UpiConstants.EXTRA_PAYER_VPA)) {
            this.H = getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        }
        if (getIntent().hasExtra("isMLVEnabledPayment")) {
            this.z = getIntent().getBooleanExtra("isMLVEnabledPayment", false);
        }
        if (getIntent().hasExtra("mlvOrderId")) {
            this.B = getIntent().getStringExtra("mlvOrderId");
        }
        if (getIntent().hasExtra("provider")) {
            this.E = getIntent().getStringExtra("provider");
        }
        if (getIntent().hasExtra("mlvAmount")) {
            this.D = getIntent().getStringExtra("mlvAmount");
        }
        if (getIntent().hasExtra("mlvMerchantName")) {
            this.C = getIntent().getStringExtra("mlvMerchantName");
        }
        if (getIntent().hasExtra("mlvMyOrdersAPIUrl")) {
            this.A = getIntent().getStringExtra("mlvMyOrdersAPIUrl");
        }
        this.w = getIntent().getBooleanExtra("is_static_qr_code", false);
        this.x = getIntent().getStringExtra("pay_mode");
        this.y = getIntent().getStringExtra("unique_identifier");
        String stringExtra5 = getIntent().getStringExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL);
        boolean booleanExtra = getIntent().getBooleanExtra("isP2B", false);
        String str = "tran_time";
        boolean booleanExtra2 = getIntent().getBooleanExtra("is_upi", false);
        String stringExtra6 = getIntent().getStringExtra(PayUtility.ACCOUNT_NUMBER);
        String str2 = "suggestedInstrument";
        String stringExtra7 = getIntent().getStringExtra("paymentMode");
        String stringExtra8 = getIntent().getStringExtra("paymentType");
        String stringExtra9 = getIntent().getStringExtra("tagline");
        String stringExtra10 = getIntent().getStringExtra(PayUtility.BANK_NAME);
        String str3 = "qrScanTime";
        boolean booleanExtra3 = getIntent().getBooleanExtra("is_from_deeplink", false);
        String stringExtra11 = getIntent().getStringExtra("ref_id");
        String str4 = "emi_message";
        double doubleExtra = getIntent().getDoubleExtra("txn_fee", 0.0d);
        String stringExtra12 = getIntent().getStringExtra("p2b_success_message");
        String stringExtra13 = getIntent().getStringExtra("p2b_pending_message");
        this.F = getIntent().getBooleanExtra("is_from_app_evoke", false);
        boolean z2 = this.z;
        if (z2) {
            Fragment a2 = d.a(z2, this.B, this.A, this.C, this.E, stringExtra2, stringExtra4, this.u, this.v, this.k, this.l, stringExtra5, this.x, this.y, this.D, this.H, this.G, this.I);
            getSupportFragmentManager().a((String) null);
            getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, a2, "mlv_enabled_payment").c();
            return;
        }
        String str5 = this.H;
        String str6 = this.G;
        String str7 = stringExtra4;
        String str8 = str2;
        String str9 = stringExtra5;
        String str10 = str3;
        String str11 = stringExtra13;
        boolean z3 = booleanExtra;
        String str12 = stringExtra12;
        String str13 = str4;
        String str14 = "is_from_mobile_number";
        String str15 = "is_emi";
        String str16 = "pay_response";
        Fragment a3 = d.a(iJRDataModel, str7, stringExtra3, str9, z3, stringExtra6, stringExtra7, stringExtra8, stringExtra9, doubleExtra, stringExtra, stringExtra2, stringExtra10, booleanExtra2, booleanExtra3, stringExtra11, str5, str6);
        a3.getArguments().putBoolean("is_offline_pg", getIntent().getBooleanExtra("is_offline_pg", false));
        a3.getArguments().putBoolean("is_wallet_transection", getIntent().getBooleanExtra("is_wallet_transection", false));
        a3.getArguments().putBoolean("backpress_offline_pg", getIntent().getBooleanExtra("backpress_offline_pg", false));
        a3.getArguments().putBoolean("is_postpaid", getIntent().getBooleanExtra("is_postpaid", false));
        String str17 = "is_upi";
        a3.getArguments().putBoolean(str17, getIntent().getBooleanExtra(str17, false));
        a3.getArguments().putBoolean("isFromPassbook", getIntent().getBooleanExtra("isFromPassbook", false));
        a3.getArguments().putBoolean("is_ppb_transaction", getIntent().getBooleanExtra("is_ppb_transaction", false));
        a3.getArguments().putBoolean("is_card_transaction", getIntent().getBooleanExtra("is_card_transaction", false));
        a3.getArguments().putBoolean("is_net_banking_transaction", getIntent().getBooleanExtra("is_net_banking_transaction", false));
        a3.getArguments().putString("merchant_logo", getIntent().getStringExtra("merchant_logo"));
        String str18 = str;
        a3.getArguments().putString(str18, getIntent().getStringExtra(str18));
        a3.getArguments().putBoolean(str15, getIntent().getBooleanExtra(str15, false));
        String str19 = str4;
        a3.getArguments().putString(str19, getIntent().getStringExtra(str19));
        String str20 = str15;
        a3.getArguments().putBoolean("is_pcf", this.u);
        a3.getArguments().putDouble("pcf_amount", this.v);
        if (!TextUtils.isEmpty(str12)) {
            a3.getArguments().putString("p2b_success_message", str12);
        }
        if (!TextUtils.isEmpty(str11)) {
            a3.getArguments().putString("p2b_pending_message", str11);
        }
        a3.getArguments().putBoolean(str14, this.f13208h);
        a3.getArguments().putBundle("sbBundle", this.f13209i);
        a3.getArguments().putBoolean("is_static_qr_code", this.w);
        a3.getArguments().putString("pay_mode", this.x);
        a3.getArguments().putString("unique_identifier", this.y);
        a3.getArguments().putString("scan_result", getIntent().getStringExtra("scan_result"));
        a3.getArguments().putBoolean("is_link_based_payment", getIntent().getBooleanExtra("is_link_based_payment", false));
        a3.getArguments().putBoolean("isFromAppEvoke", this.F);
        a3.getArguments().putInt("launchFrom", this.I);
        if (this.f13207g != null) {
            a3.getArguments().putString(str16, this.f13207g);
        }
        a3.getArguments().putBoolean(str20, this.k);
        if (this.k) {
            a3.getArguments().putString(str19, this.l);
        }
        a3.getArguments().putBoolean("is_from_recent", this.n);
        a3.getArguments().putBoolean("isAutoFlashTxn", this.o);
        a3.getArguments().putBoolean("isSingleAPI", this.p);
        a3.getArguments().putBoolean("is_amt_already_present", this.t);
        if (!TextUtils.isEmpty(this.m)) {
            a3.getArguments().putString(str10, this.m);
        }
        if (!TextUtils.isEmpty(this.q)) {
            a3.getArguments().putString(str8, this.q);
        }
        if (!TextUtils.isEmpty(this.s)) {
            a3.getArguments().putString("page_load_time", this.s);
        }
        if (!TextUtils.isEmpty(this.r)) {
            a3.getArguments().putString("page_load_type", this.r);
        }
        if (getIntent().getBooleanExtra("backpress_offline_pg", false)) {
            a3.getArguments().putString("order_id", getIntent().getStringExtra("order_id"));
            a3.getArguments().putString("mid", getIntent().getStringExtra("mid"));
        }
        getSupportFragmentManager().a((String) null);
        getSupportFragmentManager().a().a(0, 0).b(R.id.qr_fragment_container, a3, "tag_donate_noble").b();
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
            if (c2 instanceof d) {
                d dVar = (d) c2;
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                    if (dVar.f51075b == null) {
                        dVar.f51075b = new h();
                    }
                    if (!booleanExtra) {
                        dVar.f51075b.b(stringExtra);
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.f13205e) {
            this.j = MediaPlayer.create(this, R.raw.payment_success);
            this.f13205e = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                if (!mediaPlayer.isPlaying()) {
                    this.j.start();
                }
                this.j.setOnCompletionListener($$Lambda$E7FaxYylohOwFmBzAjza06XyF8.INSTANCE);
            }
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

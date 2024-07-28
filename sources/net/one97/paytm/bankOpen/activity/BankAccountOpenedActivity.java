package net.one97.paytm.bankOpen.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.CJRCashWallet;
import net.one97.paytm.bankCommon.model.CJRP2BStatus;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.a.a;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class BankAccountOpenedActivity extends PBBaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TextView f16340b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16341c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f16342d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f16343e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f16344f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f16345g;

    /* renamed from: h  reason: collision with root package name */
    private CJRP2BStatus f16346h;

    /* renamed from: i  reason: collision with root package name */
    private CustProductList f16347i;
    private int j = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bank_account_opened);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.bank_account_opened_tv_full_saviings_access);
        this.f16341c = (TextView) findViewById(R.id.transfer_wallet_title);
        this.f16340b = (TextView) findViewById(R.id.available_bal_tv);
        View findViewById = findViewById(R.id.transfer_money_to_bank_btn);
        View findViewById2 = findViewById(R.id.skip_btn);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        this.f16342d = (ViewGroup) findViewById(R.id.normalLayout);
        this.f16343e = (ViewGroup) findViewById(R.id.p2bLayout);
        this.f16344f = (ViewGroup) findViewById(R.id.progressLayout);
        this.f16345g = (LottieAnimationView) findViewById(R.id.wallet_loader);
        if (getIntent().hasExtra("bottom_text")) {
            roboTextView.setVisibility(0);
            roboTextView.setText(getIntent().getStringExtra("bottom_text"));
        } else {
            findViewById(R.id.bank_account_opened_lyt_bottom_bar).setVisibility(8);
            findViewById(R.id.divider).setVisibility(8);
        }
        f.b().getNameFromKyc(this, new d() {
            public final void onFragmentAction(int i2, Object obj) {
                BankAccountOpenedActivity.this.a(i2, obj);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", b.n((Context) this));
        c.a("bank_savings_account_kyc_success_screen_load", (Map<String, Object>) hashMap, (Context) this);
        c.a("/bank/saving-account/kyc-success", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) this);
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountOpenedActivity.this.b(view);
            }
        });
        findViewById(R.id.bank_account_opened_btn_done).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountOpenedActivity.this.a(view);
            }
        });
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        ((TextView) findViewById(R.id.bank_account_opened_tv_name)).setText((String) obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c.a("bank_saving_account_done_clicked", (Map<String, Object>) new HashMap(), (Context) this);
        f.a().openLandingActivity(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void g() {
        if (b.c((Context) this)) {
            this.f16344f.setVisibility(0);
            a(this.f16345g);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f b2 = a.b(this, this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
            getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(b2);
            return;
        }
        f();
        b.b((Context) this, getString(R.string.error), getString(R.string.pb_check_your_network));
    }

    private void f() {
        this.f16344f.setVisibility(8);
        b(this.f16345g);
        this.f16342d.setVisibility(0);
        this.f16343e.setVisibility(8);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.f16347i = (CustProductList) iJRPaytmDataModel;
            CustProductList custProductList = this.f16347i;
            if (custProductList == null || TextUtils.isEmpty(custProductList.getIsaStatus())) {
                f();
            } else if (this.f16347i.getIsaStatus().equals("ISSUED")) {
                try {
                    getApplicationContext();
                    g.a();
                    String a2 = net.one97.paytm.bankCommon.utils.d.a("checkBalance");
                    if (a2 == null) {
                        return;
                    }
                    if (URLUtil.isValidUrl(a2)) {
                        String e2 = b.e((Context) this, a2);
                        HashMap hashMap = new HashMap();
                        hashMap.put("ssotoken", com.paytm.utility.a.q(this));
                        hashMap.put("Accept-Encoding", "gzip");
                        new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this));
                        b.j();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("screen_name", getClass().getSimpleName());
                        if (b.c((Context) this)) {
                            getApplicationContext();
                            new net.one97.paytm.bankCommon.g.c();
                            net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(e2, this, this, new CJRCashWallet(), hashMap, (String) null, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2));
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else {
                int i2 = this.j;
                if (i2 == 0) {
                    this.j = i2 + 1;
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            BankAccountOpenedActivity.this.g();
                        }
                    }, 2000);
                    return;
                }
                f();
            }
        } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet.getResponse() != null) {
                double amount = cJRCashWallet.getResponse().getAmount();
                String c2 = net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(amount));
                e.a(this, amount);
                net.one97.paytm.bankCommon.utils.f.a(String.format(getString(R.string.pb_wallet_rs), new Object[]{c2}), this.f16340b);
                net.one97.paytm.bankCommon.utils.d.b();
                int l = net.one97.paytm.bankCommon.utils.d.l();
                if (l <= 0 || amount < ((double) l)) {
                    f();
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankOpen.a.a.a((Activity) this, this.f16347i.getIsaAccNum(), this.f16347i.getIsaIfsc(), net.one97.paytm.bankCommon.h.b.C(this), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap3);
                return;
            }
            f();
        } else if (iJRPaytmDataModel instanceof CJRP2BStatus) {
            this.f16346h = (CJRP2BStatus) iJRPaytmDataModel;
            CJRP2BStatus cJRP2BStatus = this.f16346h;
            if (cJRP2BStatus == null || cJRP2BStatus.getResponse() == null || !this.f16346h.getResponse().isValidForTxn()) {
                f();
                return;
            }
            Double valueOf = Double.valueOf(0.0d);
            String floatCommission = this.f16346h.getResponse().getStatusTxnWiseResponse().getFloatCommission();
            if (!TextUtils.isEmpty(floatCommission) && !"0.0".equals(floatCommission)) {
                valueOf = Double.valueOf(Double.parseDouble(floatCommission));
            }
            if (valueOf.doubleValue() == 0.0d) {
                String string = getString(R.string.pb_transfer_ur_wallet_balance, new Object[]{"0"});
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(new StyleSpan(1), string.indexOf("0") - 1, string.length() - 1, 18);
                this.f16341c.setText(spannableStringBuilder);
                this.f16342d.setVisibility(8);
                b(this.f16345g);
                this.f16344f.setVisibility(8);
                this.f16343e.setVisibility(0);
                return;
            }
            f();
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        f();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.transfer_money_to_bank_btn) {
            c.a(this, "bank_saving_account", "transfer_to_bank_clicked", "", "", "/bank/savings-account/congratulation", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            Intent intent = new Intent(this, f.a().getTransferToBankActivityClass());
            intent.putExtra(net.one97.paytm.bankCommon.mapping.b.aP, this.f16346h);
            intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
            intent.putExtra("isFrom", 1);
            startActivity(intent);
            finish();
        } else if (id == R.id.skip_btn) {
            Intent intent2 = new Intent(this, f.a().getMainActivityClass());
            intent2.setFlags(67108864);
            intent2.putExtra("open_bank_tab", true);
            startActivity(intent2);
            finish();
        }
    }
}

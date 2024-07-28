package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.QRCodeResponse;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.slfd.redeemFd.RedeemFdActivity;

public class CashWithdrawnActivity extends RedeemFdActivity implements d {

    /* renamed from: b  reason: collision with root package name */
    double f18279b = -1.0d;
    private TextView l;
    private boolean m;
    private boolean n;
    private CustProductList o;
    private a p;

    enum a {
        NOT_FETCHING,
        FETCHED,
        FETCHING
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 1) {
            e((String) obj);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
        if (!e(net.one97.paytm.bankCommon.mapping.a.ab(g().getText().toString()))) {
            return;
        }
        if (b.c((Context) this)) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            String string = getString(R.string.CASH_WIDRAWL_TITLE);
            BankPasscodeActivity.a.a((Activity) this, string, getString(R.string.pb_cw_passcode_title) + " " + g().getText().toString(), getString(R.string.pb_enter_passcode_hint));
            return;
        }
        b.b((Context) this, getString(R.string.error), getString(R.string.network_error_message));
    }

    private void d(String str) {
        if (b.c((Context) this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f c2 = net.one97.paytm.paymentsBank.b.a.c((Context) this, str, (g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    CashWithdrawnActivity.this.c((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    CashWithdrawnActivity.this.c(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new c();
            c.a(c2);
            return;
        }
        this.p = a.NOT_FETCHING;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(IJRPaytmDataModel iJRPaytmDataModel) {
        try {
            PBCJRAccountSummary pBCJRAccountSummary = (PBCJRAccountSummary) iJRPaytmDataModel;
            this.l.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(pBCJRAccountSummary.getAccounts().get(0).getEffectiveBalance()))}));
            this.f18279b = pBCJRAccountSummary.getAccounts().get(0).getEffectiveBalance();
            this.f19283h = pBCJRAccountSummary.getAccounts().get(0).getEffectiveBalance();
            this.p = a.FETCHED;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.p = a.NOT_FETCHING;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(IJRPaytmDataModel iJRPaytmDataModel) {
        try {
            this.o = (CustProductList) iJRPaytmDataModel;
            d(this.o.getIsaAccNum());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.p = a.NOT_FETCHING;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        QRCodeResponse qRCodeResponse = (QRCodeResponse) iJRPaytmDataModel;
        if ("success".equalsIgnoreCase(qRCodeResponse.getResponseMessage())) {
            Intent intent = new Intent(getApplicationContext(), QRCodeActivity.class);
            intent.putExtra("qrcodeId", qRCodeResponse.getPayload().getQrCodeId());
            intent.putExtra("effectivebalance", this.f18279b);
            intent.putExtra("amount", str);
            intent.putExtra("name", getIntent().getStringExtra("name"));
            intent.putExtra("isbankbranch", this.m);
            startActivity(intent);
            setResult(-1);
            g().setText("");
            this.n = true;
            return;
        }
        b.b((Context) this, getString(R.string.error), qRCodeResponse.getResponseMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            try {
                String ab = net.one97.paytm.bankCommon.mapping.a.ab(g().getText().toString());
                if (!TextUtils.isEmpty(ab)) {
                    String stringExtra = intent.getStringExtra("passcode");
                    a(this, getString(R.string.please_wait));
                    net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.a.f18227a.a(this, stringExtra, ab, new g.b(ab) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onResponse(Object obj) {
                            CashWithdrawnActivity.this.a(this.f$1, (IJRPaytmDataModel) obj);
                        }
                    }, new g.a() {
                        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            CashWithdrawnActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            k().setError(getString(R.string.fd_empty_amount));
            return false;
        } else if (str.equals("0")) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            k().setError(getString(R.string.fd_zero_amount));
            return false;
        } else if (Double.valueOf(str).doubleValue() < 10.0d) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            k().setError(getString(R.string.pb_cw_amt_less_thn_ten));
            return false;
        } else if (this.f18279b >= 0.0d && Double.valueOf(str).doubleValue() > this.f18279b) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            TextInputLayout k = k();
            k.setError(getString(R.string.pb_cw_amt_cant_exc_bal) + " " + b.b(Double.valueOf(this.f18279b)));
            return false;
        } else if (Double.valueOf(str).doubleValue() > 10000.0d && !this.m) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            TextInputLayout k2 = k();
            k2.setError(getString(R.string.pb_cw_amt_cant_exc_bal) + " " + b.b(Double.valueOf(10000.0d)));
            return false;
        } else if (Double.valueOf(str).doubleValue() > 100000.0d && this.m) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            TextInputLayout k3 = k();
            k3.setError(getString(R.string.pb_cw_amt_cant_exc_bal) + " " + b.b(Double.valueOf(100000.0d)));
            return false;
        } else if (this.f18279b != -1.0d) {
            return true;
        } else {
            a((View) j(), getString(R.string.pb_cw_fetching_bal));
            return false;
        }
    }

    private static void a(View view, String str) {
        Snackbar.a(view, (CharSequence) str, -1).c();
    }

    public void onResume() {
        CustProductList custProductList;
        super.onResume();
        if (this.n && (custProductList = this.o) != null) {
            this.n = false;
            d(custProductList.getIsaAccNum());
        }
    }

    public void onCreate(Bundle bundle) {
        this.f19280e = true;
        super.onCreate(bundle);
        ((TextView) findViewById(R.id.tv_bank_hint)).setVisibility(8);
        ((Button) findViewById(R.id.btn_proceed)).setText(getString(R.string.pb_cw_generate_qr_code));
        TextView textView = (TextView) findViewById(R.id.tv_at_merchant);
        ((TextView) findViewById(R.id.tv_redeem_fd_title)).setText(getString(R.string.pb_cw_enter_amt_to_withdraw));
        View findViewById = findViewById(R.id.subtitle_amt_lyt);
        ((TextView) findViewById(R.id.tv_invested_amount)).setText(getString(R.string.pb_cw_your_sa_bal));
        findViewById.setBackgroundColor(androidx.core.content.b.c(this, R.color.color_f5f8fa));
        ((AppCompatImageView) findViewById(R.id.subtitle_icon)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_important_heading)).setText(getString(R.string.pb_cw_note));
        if (getIntent().hasExtra("name")) {
            textView.setVisibility(0);
            textView.setText("at " + getIntent().getStringExtra("name"));
        }
        this.m = getIntent().getBooleanExtra("isbankbranch", false);
        this.l = (TextView) findViewById(R.id.tv_invested_amount_value);
        this.l.setVisibility(0);
        g().setHint(R.string.pb_cw_amount);
        if (b.c((Context) this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            this.p = a.FETCHING;
            f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    CashWithdrawnActivity.this.b((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    CashWithdrawnActivity.this.b(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new c();
            c.a(a2);
        }
        h().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CashWithdrawnActivity.this.a(view);
            }
        });
        k.c(this, "listener");
        this.k = this;
    }
}

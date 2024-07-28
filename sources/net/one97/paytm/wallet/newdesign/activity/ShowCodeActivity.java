package net.one97.paytm.wallet.newdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.TextView;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.AJRLockActivity;
import net.one97.paytm.common.CJRPPUserProfileKycTnc;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.receiver.SilentPushReceiver;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.b.e;

public class ShowCodeActivity extends AJRLockActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f70566a = P2PActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private TextView f70567b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70568c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f70569e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70570f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f70571g;

    /* renamed from: h  reason: collision with root package name */
    private SilentPushReceiver f70572h;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    private void b(boolean z) {
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (z) {
                attributes.screenBrightness = 1.0f;
            } else {
                attributes.screenBrightness = -1.0f;
            }
            getWindow().setAttributes(attributes);
            getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            getWindow().addFlags(128);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        b(true);
        getSupportActionBar().f();
        try {
            b.a().sendGTMOpenScreenWithDeviceInfo(this, "/wallet/pay-send/show-code", "Wallet");
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "barcode");
            b.a().sendCustomGTMEvent(this, "wallet_send_money_method_selected", hashMap);
        } catch (Exception unused) {
        }
        setContentView(R.layout.w_activity_show_code);
        if (getIntent() != null) {
            this.f70571g = getIntent().getBooleanExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
        }
        this.f70572h = new SilentPushReceiver();
        this.f70570f = (TextView) findViewById(R.id.tv_postpaid);
        this.f70567b = (TextView) findViewById(R.id.activity_show_code_heading2);
        this.f70568c = (TextView) findViewById(R.id.tv_add_money);
        this.f70568c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShowCodeActivity showCodeActivity = ShowCodeActivity.this;
                showCodeActivity.sendGATags("offline_payments", "showcode_addmoney_clicked", showCodeActivity.f70571g ? "flow_through_scan_icon" : "flow_through_pay_icon", "", ShowCodeActivity.this, "home/pay-send/show-code/add-money");
                ShowCodeActivity.b(ShowCodeActivity.this);
            }
        });
        if (b.a().isMall() && (textView = this.f70568c) != null) {
            textView.setVisibility(8);
        }
        this.f70567b.setText(String.format(getString(R.string.p2b_wallet_rs), new Object[]{"--.-"}));
        if (com.paytm.utility.b.r((Context) this)) {
            a();
            if (b.a().getBooleanFromGTM(this, "isPostpaidEnabled", true)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u()) {
                    a((Double) null);
                    String stringFromGTM = b.a().getStringFromGTM(this, "pp_accounts_v3_url");
                    if (URLUtil.isValidUrl(stringFromGTM)) {
                        String uri = Uri.parse(stringFromGTM).buildUpon().appendQueryParameter("fetch_type", "ACCOUNTS").appendQueryParameter("channel", StringSet.Android).appendQueryParameter("version", "2").appendQueryParameter(AppConstants.TAG_SITE_ID, "1").appendQueryParameter(AppConstants.TAG_CHILD_SITE_ID, "1").build().toString();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("Content-Type", "application/json");
                        hashMap2.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a.q(this));
                        new HashMap().put("", "");
                        if (com.paytm.utility.b.c((Context) this)) {
                            new net.one97.paytm.network.a(uri, new CJRPPUserProfileKycTnc(), (Map<String, String>) null, hashMap2).c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    ShowCodeActivity.this.b((f) obj);
                                }
                            });
                        }
                    }
                }
            }
        } else {
            Intent intent = new Intent(this, b.a().getAuthActivityClass());
            intent.putExtra("launchSignUp", false);
            intent.putExtra("set_result_required", true);
            intent.putExtra("VERTICAL_NAME", "Wallet");
            startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        }
        findViewById(R.id.activity_show_code_btn_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShowCodeActivity.this.onBackPressed();
            }
        });
        e eVar = new e();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(UpiConstants.KEY_IS_SCAN_ONLY, this.f70571g);
        eVar.setArguments(bundle2);
        getSupportFragmentManager().a().a(R.id.rly_selectbank_container, eVar, "show_code").b();
    }

    private void a(Double d2) {
        String str;
        this.f70570f.setVisibility(0);
        if (d2 != null) {
            str = "(₹" + d2 + ")";
        } else {
            str = "";
        }
        TextView textView = this.f70570f;
        textView.setText(Html.fromHtml(("<font color='#ffa400'>" + getString(R.string.insuff_show_code) + "</font>") + (" " + getString(R.string.postpaid_message_on_show_code, new Object[]{str}))));
    }

    public void onResume() {
        super.onResume();
        registerReceiver(this.f70572h, new IntentFilter("com.android.wallet.SILENT_PUSH_TOTP"));
        if (this.f70569e) {
            a();
            this.f70569e = false;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void a() {
        try {
            String stringFromGTM = b.a().getStringFromGTM(this, "checkBalance");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = com.paytm.utility.b.e((Context) this, stringFromGTM);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", a.q(this));
                hashMap.put("Accept-Encoding", "gzip");
                if (com.paytm.utility.b.c((Context) this)) {
                    net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, (String) null);
                    bVar.e();
                    bVar.a(FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT);
                    bVar.c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            ShowCodeActivity.this.a((f) obj);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    private void b() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "show code");
            hashMap.put("event_category", d.bE);
            hashMap.put("event_action", "show_code_screen_loaded");
            hashMap.put(d.cw, "");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap.put(d.cv, "offline_payments");
            b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onDestroy() {
        b(false);
        super.onDestroy();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 301 && com.paytm.utility.b.r((Context) this)) {
            a();
        }
    }

    public void onPause() {
        unregisterReceiver(this.f70572h);
        super.onPause();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                b();
                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                if (cJRCashWallet.getResponse() != null) {
                    double amount = cJRCashWallet.getResponse().getAmount();
                    String b2 = com.paytm.utility.b.b(Double.valueOf(amount));
                    net.one97.paytm.wallet.utility.a.a((Context) this, amount);
                    this.f70567b.setText(String.format(getString(R.string.p2b_wallet_rs), new Object[]{b2}));
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            NetworkCustomError networkCustomError = fVar.f55798c.f55801c;
            b();
            if (networkCustomError == null) {
                return;
            }
            if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                b.a().handleError(this, networkCustomError, ShowCodeActivity.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        boolean z;
        CJRPPAccount cJRPPAccount;
        f fVar2 = fVar;
        if (fVar2.f55796a == h.SUCCESS) {
            CJRPPUserProfileKycTnc cJRPPUserProfileKycTnc = (CJRPPUserProfileKycTnc) fVar2.f55797b;
            if (cJRPPUserProfileKycTnc.getAccounts() != null) {
                if (cJRPPUserProfileKycTnc.getAccounts().length > 1) {
                    double d2 = 0.0d;
                    z = false;
                    CJRPPAccount cJRPPAccount2 = null;
                    for (CJRPPAccount cJRPPAccount3 : cJRPPUserProfileKycTnc.getAccounts()) {
                        int i2 = 0;
                        for (CJRPPAccount isUserEligible : cJRPPUserProfileKycTnc.getAccounts()) {
                            if (isUserEligible.isUserEligible()) {
                                i2++;
                            }
                        }
                        if (i2 > 1) {
                            if (cJRPPAccount3.isUserEligible() && cJRPPAccount3.getApplicationStatus() != null) {
                                b.a().isAppRejected(cJRPPAccount3);
                                if (b.a().isAppConfirmed(cJRPPAccount3) || b.a().isAppAccepted(cJRPPAccount3)) {
                                    if (cJRPPAccount3.getEligibleCreditLimit() != null) {
                                        d2 = cJRPPAccount3.getEligibleCreditLimit().doubleValue();
                                    }
                                } else if (b.a().isAppRejected(cJRPPAccount3)) {
                                    if (cJRPPAccount3.getEligibleCreditLimit() != null) {
                                        d2 = cJRPPAccount3.getEligibleCreditLimit().doubleValue();
                                    }
                                } else if (cJRPPAccount3.getEligibleCreditLimit() != null && cJRPPAccount3.getEligibleCreditLimit().doubleValue() > d2) {
                                    d2 = cJRPPAccount3.getEligibleCreditLimit().doubleValue();
                                }
                            }
                            cJRPPUserProfileKycTnc.getAccounts();
                        } else if (!cJRPPAccount3.isUserEligible()) {
                            cJRPPUserProfileKycTnc.getAccounts();
                        } else if (cJRPPAccount3.getApplicationStatus() != null) {
                            b.a().isAppRejected(cJRPPAccount3);
                        }
                        cJRPPAccount2 = cJRPPAccount3;
                        z = true;
                        cJRPPUserProfileKycTnc.getAccounts();
                    }
                    cJRPPAccount = cJRPPAccount2;
                } else {
                    if (cJRPPUserProfileKycTnc.getAccounts().length > 0) {
                        cJRPPAccount = cJRPPUserProfileKycTnc.getAccounts()[0];
                        if (cJRPPAccount.isUserEligible()) {
                            if (cJRPPAccount.getApplicationStatus() != null) {
                                b.a().isAppRejected(cJRPPAccount);
                            }
                            z = true;
                        }
                    }
                    cJRPPAccount = null;
                    z = false;
                }
                if (z && cJRPPAccount != null) {
                    a(cJRPPAccount.getAvailableCreditLimit());
                    return;
                }
            }
            return;
        }
        h hVar = h.ERROR;
    }

    static /* synthetic */ void b(ShowCodeActivity showCodeActivity) {
        showCodeActivity.f70569e = true;
        b.a().openAddMoneyScreen(showCodeActivity);
    }
}

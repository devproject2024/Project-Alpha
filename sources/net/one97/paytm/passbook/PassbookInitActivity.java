package net.one97.paytm.passbook;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.j.c;
import net.one97.paytm.n.e;
import net.one97.paytm.passbook.PassbookInitActivity;
import net.one97.paytm.passbook.c.a;
import net.one97.paytm.passbook.c.b;
import net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity;
import net.one97.paytm.passbook.giftVoucher.GiftVoucherRedeemActivity;
import net.one97.paytm.passbook.landing.activity.PassbookLandingActivity;
import net.one97.paytm.passbook.main.PassbookInfoActivity;
import net.one97.paytm.passbook.mgv.activity.MGVMainActivity;
import net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivity;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivityForPPB;
import net.one97.paytm.passbook.subWallet.PassbookDetailInfoActivity;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.transactionHistory.activity.SATransactionDetailsActivity;
import net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.utils.CustomWalletLoaderDialog;

public class PassbookInitActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f57064a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f57065b;

    /* renamed from: c  reason: collision with root package name */
    private DeepLinkData f57066c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57067d = false;

    /* renamed from: e  reason: collision with root package name */
    private a f57068e = new a() {
        public final void a(boolean z) {
            if (z) {
                CustomWalletLoaderDialog.getInstance(PassbookInitActivity.this).showLoader();
            } else {
                CustomWalletLoaderDialog.getInstance(PassbookInitActivity.this).dismissLoader();
            }
        }

        public final void a() {
            PassbookInitActivity.this.d();
        }

        public final void b() {
            if (!PassbookInitActivity.this.isFinishing()) {
                PassbookInitActivity passbookInitActivity = PassbookInitActivity.this;
                net.one97.paytm.passbook.mapping.a.a(passbookInitActivity, passbookInitActivity.getString(R.string.pass_alert), PassbookInitActivity.this.getString(R.string.no_internet), PassbookInitActivity.this.getString(R.string.pass_network_retry_yes), PassbookInitActivity.this.getString(R.string.cancel), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PassbookInitActivity.AnonymousClass1.this.b(dialogInterface, i2);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PassbookInitActivity.AnonymousClass1.this.a(dialogInterface, i2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
            PassbookInitActivity.this.f57065b.a("passLandingPasscodeEnabled");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
            PassbookInitActivity.this.finish();
        }

        public final void c() {
            PassbookInitActivity.this.d();
        }
    };

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        e.a();
        DeepLinkData deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        String uri = deepLinkData.f50289g.toString();
        if ((!b("passLandingPasscodeEnabled").booleanValue() || (!uri.equalsIgnoreCase("paytmmp://cash_wallet?featuretype=cash_ledger") && !uri.equalsIgnoreCase("paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet"))) && (!b("passL2PasscodeEnabled").booleanValue() || !uri.equalsIgnoreCase("paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet"))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.f57066c = deepLinkData;
            this.f57064a = true;
            if (b("passLandingPasscodeEnabled").booleanValue()) {
                a("passLandingPasscodeEnabled");
            } else if (b("passL2PasscodeEnabled").booleanValue()) {
                a("passL2PasscodeEnabled");
            }
        } else {
            a(this, deepLinkData);
        }
        if (!this.f57064a) {
            finish();
        }
    }

    private void a() {
        this.f57064a = true;
        Intent intent = new Intent();
        intent.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
        d.b().a((Activity) this, intent);
        startActivityForResult(intent, 1025);
    }

    private static void a(Intent intent) {
        intent.setFlags(335544320);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1025) {
            if (i3 == -1) {
                this.f57064a = false;
                b();
            }
            finish();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void b() {
        Intent intent = new Intent(this, PassbookL2Activity.class);
        intent.putExtra("passbook_type", n.SAVINGS_ACCOUNT.getValue());
        startActivity(intent);
    }

    private static boolean c() {
        e eVar = e.f55762a;
        if (!e.f()) {
            return false;
        }
        if (!b("passLandingPasscodeEnabled").booleanValue() && !b("passL2PasscodeEnabled").booleanValue()) {
            return false;
        }
        e eVar2 = e.f55762a;
        return !e.d();
    }

    private void a(String str) {
        if (this.f57065b == null) {
            this.f57065b = new b(this, this.f57068e);
            this.f57067d = true;
            this.f57064a = true;
        }
        this.f57065b.a(str);
    }

    private static Boolean b(String str) {
        c.a();
        return Boolean.valueOf(c.a(str, true));
    }

    public void onResume() {
        super.onResume();
        if (this.f57066c != null && !this.f57067d) {
            d();
        }
    }

    public void onPause() {
        super.onPause();
        this.f57067d = false;
    }

    /* access modifiers changed from: private */
    public void d() {
        if (!isFinishing()) {
            if (e()) {
                a(this, this.f57066c);
            }
            finish();
        }
    }

    private static boolean e() {
        return !c();
    }

    private void a(Context context, DeepLinkData deepLinkData) {
        String str = deepLinkData.f50288f;
        String str2 = deepLinkData.f50284b;
        if ("redeem_gv".equalsIgnoreCase(str2)) {
            Intent intent = new Intent(context, GiftVoucherRedeemActivity.class);
            a(intent);
            startActivity(intent);
        } else if ("transaction_detail".equalsIgnoreCase(str2)) {
            String queryParameter = deepLinkData.f50289g.getQueryParameter("id");
            if ("wallet".equalsIgnoreCase(deepLinkData.f50289g.getQueryParameter("system"))) {
                Intent intent2 = new Intent(context, PassbookDetailInfoActivity.class);
                intent2.putExtra("id", queryParameter);
                a(intent2);
                context.startActivity(intent2);
            }
        } else if ("passbook".equalsIgnoreCase(str2)) {
            if (!"statement".equalsIgnoreCase(deepLinkData.f50288f) || deepLinkData.f50289g == null) {
                if ("spend_analytics".equalsIgnoreCase(deepLinkData.f50288f)) {
                    Intent intent3 = new Intent(this, SpendAnalyticsMainActivity.class);
                    a(intent3);
                    startActivity(intent3);
                }
            } else if ("ppbl".equalsIgnoreCase(deepLinkData.f50289g.getQueryParameter("type"))) {
                Intent intent4 = new Intent(this, StatementDownloadActivityForPPB.class);
                a(intent4);
                startActivity(intent4);
            } else if ("ppblICA".equalsIgnoreCase(deepLinkData.f50289g.getQueryParameter("type"))) {
                Intent intent5 = new Intent(this, StatementDownloadActivityForPPB.class);
                intent5.putExtra("accountType", "ICA");
                a(intent5);
                startActivity(intent5);
            } else if ("fastag".equalsIgnoreCase(deepLinkData.f50289g.getQueryParameter("type"))) {
                Intent intent6 = new Intent(this, StatementDownloadActivity.class);
                intent6.putExtra("CallingFragment", "TransactionTollPassageHistoryFragment");
                a(intent6);
                startActivity(intent6);
            }
        } else if (!UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(str2)) {
        } else {
            if ("wallet_to_ppb".equalsIgnoreCase(str) || "send_money_bank".equalsIgnoreCase(str)) {
                Intent intent7 = new Intent(context, PassbookSubwalletActivity.class);
                intent7.putExtra("display_name", "Prepaid Wallet");
                intent7.putExtra("display_amount", "");
                intent7.putExtra("sub_wallet_type", n.PAYTM_WALLET.getValue());
                intent7.putExtra("extra_send_to_bank", true);
                a(intent7);
                context.startActivity(intent7);
            } else if ("cash_ledger".equalsIgnoreCase(str)) {
                String queryParameter2 = deepLinkData.f50289g.getQueryParameter("tab");
                if ("savings".equalsIgnoreCase(queryParameter2)) {
                    String queryParameter3 = deepLinkData.f50289g.getQueryParameter(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                    String queryParameter4 = deepLinkData.f50289g.getQueryParameter("totalBalance");
                    if (!TextUtils.isEmpty(queryParameter3) || !TextUtils.isEmpty(queryParameter4)) {
                        b();
                    } else {
                        a();
                    }
                } else if ("ica".equalsIgnoreCase(queryParameter2)) {
                    Intent intent8 = new Intent(context, PassbookL2Activity.class);
                    intent8.putExtra("passbook_type", n.ICA_CURRENT_ACCOUNT.getValue());
                    context.startActivity(intent8);
                } else if ("prepaid_wallet".equalsIgnoreCase(queryParameter2)) {
                    Intent intent9 = new Intent(this, PassbookL2Activity.class);
                    intent9.putExtra("passbook_type", n.PAYTM_WALLET.getValue());
                    a(intent9);
                    startActivity(intent9);
                } else if ("Paytmfirstgames".equalsIgnoreCase(queryParameter2)) {
                    Intent intent10 = new Intent(this, PassbookL2Activity.class);
                    intent10.putExtra("passbook_type", n.LOYALTY_WALLET_TYPE_7.getValue());
                    intent10.putExtra("passbookTypeFirstGames", n.PAYTM_FIRST_GAMES_WALLET);
                    a(intent10);
                    startActivity(intent10);
                } else if ("gift_voucher".equalsIgnoreCase(queryParameter2)) {
                    Intent intent11 = new Intent(this, PassbookSubwalletActivity.class);
                    intent11.putExtra("sub_wallet_type", n.GIFT_VOUCHER.getValue());
                    intent11.putExtra("display_name", getString(R.string.uam_gv_gift_vouchere));
                    a(intent11);
                    startActivity(intent11);
                } else if ("fastag".equalsIgnoreCase(queryParameter2)) {
                    Intent intent12 = new Intent(this, PassbookSubwalletActivity.class);
                    intent12.putExtra("sub_wallet_type", n.TOLL.getValue());
                    intent12.putExtra("display_name", getString(R.string.fastag));
                    a(intent12);
                    startActivity(intent12);
                } else if ("manage_fastag".equalsIgnoreCase(queryParameter2)) {
                    String a2 = d.b().a("passManageFastagDeeplink");
                    if (!TextUtils.isEmpty(a2)) {
                        d.b().a(a2, (Activity) context);
                    }
                } else if ("mgv".equalsIgnoreCase(queryParameter2)) {
                    String queryParameter5 = deepLinkData.f50289g.getQueryParameter("id");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        Intent intent13 = new Intent(this, MGVMainActivity.class);
                        intent13.putExtra("id", queryParameter5);
                        a(intent13);
                        startActivity(intent13);
                    }
                } else if ("payment_history".equalsIgnoreCase(queryParameter2)) {
                    String queryParameter6 = deepLinkData.f50289g.getQueryParameter("type");
                    String queryParameter7 = deepLinkData.f50289g.getQueryParameter("id");
                    String queryParameter8 = deepLinkData.f50289g.getQueryParameter("accNum");
                    String queryParameter9 = deepLinkData.f50289g.getQueryParameter("streamSource");
                    String queryParameter10 = deepLinkData.f50289g.getQueryParameter("tranDateEpoch");
                    String queryParameter11 = deepLinkData.f50289g.getQueryParameter("dateTimeEpoch");
                    Intent intent14 = new Intent();
                    if (TextUtils.isEmpty(queryParameter6) || !queryParameter6.equalsIgnoreCase("ppbl")) {
                        if (!TextUtils.isEmpty(queryParameter7) && !TextUtils.isEmpty(queryParameter9)) {
                            intent14.setClass(this, TransactionHistoryActivity.class);
                            intent14.putExtra("txnId", queryParameter7);
                            intent14.putExtra("stream_source", queryParameter9);
                            a(intent14);
                            startActivity(intent14);
                        }
                    } else if (!TextUtils.isEmpty(queryParameter7) && !TextUtils.isEmpty(queryParameter8) && !TextUtils.isEmpty(queryParameter10) && !TextUtils.isEmpty(queryParameter11)) {
                        intent14.setClass(this, SATransactionDetailsActivity.class);
                        intent14.putExtra("ACCOUNT_NUMBER", queryParameter8);
                        intent14.putExtra("txnId", queryParameter7);
                        intent14.putExtra("tranDateEpochMilli", queryParameter10);
                        intent14.putExtra("dateTimeEpochMilli", queryParameter11);
                        a(intent14);
                        startActivity(intent14);
                    }
                } else if (CJRPGTransactionRequestUtils.PAYER_BANK_NAME.equalsIgnoreCase(deepLinkData.f50289g.getQueryParameter("open_source"))) {
                    Intent intent15 = new Intent(context, PassbookLandingActivity.class);
                    intent15.putExtra("extra_module_open_source", 1);
                    a(intent15);
                    startActivity(intent15);
                } else {
                    Intent intent16 = new Intent(context, PassbookInfoActivity.class);
                    a(intent16);
                    startActivity(intent16);
                }
            } else if ("myorder".equalsIgnoreCase(str)) {
                q.a(context, "passbook", "passbook_ticker_clicked", (ArrayList<String>) null, "/passbook");
                d.b().a((ContextThemeWrapper) this);
            }
        }
    }
}

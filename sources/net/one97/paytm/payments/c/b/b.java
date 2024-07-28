package net.one97.paytm.payments.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.gsonhtcfix.f;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.payments.activity.AJRChangePasscode;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.paymentsBank.activity.AJRNomineeDetails;
import net.one97.paytm.paymentsBank.activity.PBH5LoginActivity;
import net.one97.paytm.paymentsBank.biometricAuthWall.BiometricSettingsActivity;
import net.one97.paytm.paymentsBank.customView.a;
import net.one97.paytm.paymentsBank.customView.c;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.nach.landing.PBNachRequestListActivity;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.si.activity.RecurringPaymentAddActivity;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {
    public static final b INSTANCE = new b();

    private b() {
    }

    public final boolean isHandledByBank(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        Activity activity2 = activity;
        String str2 = str;
        Bundle bundle2 = bundle;
        k.c(activity, "activity");
        k.c(str, "target");
        k.c(bundle, "bundle");
        boolean z3 = false;
        switch (str.hashCode()) {
            case -1632856956:
                if (str.equals("bankChangeLanguage")) {
                    o.a().openLanguageChangeActivity(activity);
                    return true;
                }
                break;
            case -1093384004:
                if (str.equals("bankOpenHomeNeedHelp")) {
                    o.a().openHelpAndSupport(activity2, true);
                    return true;
                }
                break;
            case -942465232:
                if (str.equals("bankOpenDbt")) {
                    String string = bundle.getString("deeplink", (String) null);
                    k.a((Object) string, "deeplink");
                    if (p.a(string)) {
                        string = null;
                    }
                    o.a().openDbt(activity2, string);
                    return true;
                }
                break;
            case -942456618:
                if (str.equals("bankOpenMap")) {
                    try {
                        Uri parse = Uri.parse("google.navigation:q=" + bundle.getDouble("lat") + ',' + bundle.getDouble("long"));
                        k.a((Object) parse, "Uri.parse(\"google.naviga…:q=$latitude,$longitude\")");
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.setPackage("com.google.android.apps.maps");
                        activity.startActivity(intent);
                    } catch (Exception unused) {
                    }
                    return true;
                }
                break;
            case -870387830:
                if (str.equals("bankPassbookNavigation")) {
                    o.a().openSavingPassbookWithBalance(activity2, bundle.getString("passbookAccBalance"), bundle.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER));
                    return true;
                }
                break;
            case -810554972:
                if (str.equals("bankCashWithdrawal")) {
                    activity.startActivity(new Intent(activity2, CashFromNearestPaytmActivity.class));
                    return true;
                }
                break;
            case -790109979:
                if (str.equals("bankOpenDownloads")) {
                    boolean z4 = bundle.getBoolean("isPanReceived");
                    Intent intent2 = new Intent(activity2, DownloadActivity.class);
                    if (z4) {
                        intent2.putExtra("SHOW_TDS", true);
                    }
                    activity.startActivity(intent2);
                    return true;
                }
                break;
            case -771167780:
                if (str.equals("bankBiometric")) {
                    activity.startActivityForResult(new Intent(activity2, BiometricSettingsActivity.class), 1205);
                    return true;
                }
                break;
            case -500580802:
                if (str.equals("bankOpenDebitCst")) {
                    o.a().openCstWithBundle(activity2, bundle);
                    return true;
                }
                break;
            case -408430676:
                if (str.equals("bankOpenDeeplink")) {
                    o.a().checkDeepLink(activity2, bundle.getString("deeplink", (String) null));
                    return true;
                }
                break;
            case -117151002:
                if (str.equals("bankLogout")) {
                    a.a(c.MASKED_CARD);
                    a.c();
                    androidx.localbroadcastmanager.a.a.a((Context) activity2).a(new Intent("templogout"));
                    return true;
                }
                break;
            case -65170392:
                if (str.equals("bankDormantAccount")) {
                    Intent intent3 = new Intent(activity2, ForgotPasscodeChallengesActivity.class);
                    intent3.putExtra("activity_flow", "ACTIVATE_ACCOUNT");
                    activity.startActivity(intent3);
                    return true;
                }
                break;
            case -31257609:
                if (str.equals("bankOpenSavingsTxnDetailpage")) {
                    String string2 = bundle.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                    long j = bundle.getLong("txnDateEpoch");
                    long j2 = bundle.getLong("dateTimeEpoch");
                    o.a().checkDeepLink(activity2, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=payment_history&type=ppbl&id=" + bundle.getString("txnId") + "&accNum=" + string2 + "&tranDateEpoch=" + j + "&dateTimeEpoch=" + j2);
                    return true;
                }
                break;
            case 8207393:
                if (str.equals("bankOpenAutomaticPayment")) {
                    String string3 = bundle.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                    Intent intent4 = new Intent(activity2, RecurringPaymentAddActivity.class);
                    intent4.putExtra("acc_no", string3);
                    activity.startActivity(intent4);
                    return true;
                }
                break;
            case 161209543:
                if (str.equals("bankChangeAtmPin")) {
                    Intent intent5 = new Intent(activity2, PDCPasscodePinActivity.class);
                    intent5.putExtra("cardNumberAlias", bundle.getString("cardNumberAlias"));
                    intent5.putExtra("ENTER_HEADER", "atmPinReset");
                    intent5.putExtra("isFromH5", true);
                    activity.startActivityForResult(intent5, 6131);
                    return true;
                }
                break;
            case 178725444:
                if (str.equals("bankOpenPasscode")) {
                    String string4 = bundle.getString("title", "");
                    String string5 = bundle.getString("subTitle", "");
                    String string6 = bundle.getString("source", "");
                    boolean z5 = bundle.getBoolean("bankscopetoken", false);
                    BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
                    k.a((Object) string4, "title");
                    k.a((Object) string5, "subTitle");
                    k.a((Object) string6, "source");
                    k.c(activity, "ctx");
                    k.c(string4, "title");
                    k.c(string5, "subTitle");
                    k.c("flow_h5", "flow");
                    k.c(string6, "source");
                    Intent intent6 = new Intent(activity2, BankPasscodeActivity.class);
                    intent6.putExtra("l_code", BankPasscodeActivity.A);
                    intent6.putExtra("title", string4);
                    intent6.putExtra(BankPasscodeActivity.w, string5);
                    intent6.putExtra("flow", "flow_h5");
                    intent6.putExtra("src", string6);
                    intent6.putExtra("bank_scope", z5);
                    intent6.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
                    activity.startActivityForResult(intent6, 6130);
                    return true;
                }
                break;
            case 339280720:
                if (str.equals("bankManageNominee")) {
                    String string7 = bundle.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                    String string8 = bundle.getString("nomineeModel");
                    Intent intent7 = new Intent(activity2, AJRNomineeDetails.class);
                    intent7.putExtra("NOMINEE_ITEM", (NomineeModel) new f().a(string8, NomineeModel.class));
                    intent7.putExtra("extra_account_number", string7);
                    intent7.putExtra("isEditable", true);
                    activity.startActivityForResult(intent7, 110);
                    return true;
                }
                break;
            case 665863434:
                if (str.equals("bankOpenNachMandate")) {
                    activity.startActivity(new Intent(activity2, PBNachRequestListActivity.class));
                    return true;
                }
                break;
            case 813737967:
                if (str.equals("bankMoneyTransfer")) {
                    net.one97.paytm.paymentsBank.h.a a2 = o.a();
                    k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                    Intent intent8 = new Intent(activity2, a2.getMoneyTransferActivityV3Class());
                    intent8.putExtra(UpiConstants.FROM, 100);
                    activity.startActivity(intent8);
                    return true;
                }
                break;
            case 1035387258:
                if (str.equals("bankOpenSetPasscode")) {
                    Intent intent9 = new Intent(activity2, AJRForgotPasscode.class);
                    intent9.putExtra("forgot_passcode_access", bundle.getString(StringSet.token));
                    activity.startActivityForResult(intent9, 9856);
                    break;
                }
                break;
            case 1197122218:
                if (str.equals("bankChangePasscode")) {
                    activity.startActivity(new Intent(activity2, AJRChangePasscode.class));
                    return true;
                }
                break;
            case 1430377138:
                if (str.equals("bankOpenSavingsHome")) {
                    o.a().openInnerSavingAccPasscodeActivity(activity2, bundle.getString("balance"), bundle.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER), bundle.getString("totalBalance"), bundle.getString("accType"));
                    return true;
                }
                break;
            case 1559541855:
                if (str.equals("bankOpenBeneficiary")) {
                    o.a().openManageBeneficiary(activity);
                    return true;
                }
                break;
            case 1601064281:
                if (str.equals("bankLoginScreen")) {
                    Intent intent10 = new Intent(activity2, PBH5LoginActivity.class);
                    intent10.putExtra("isFromH5", true);
                    activity.startActivityForResult(intent10, 6132);
                    return true;
                }
                break;
            case 1715235080:
                if (str.equals("bankOpenAddMoneyWithoutCallback")) {
                    String string9 = bundle.getString("slfdIblCifStatus");
                    String string10 = bundle.getString("slfdBalance");
                    net.one97.paytm.paymentsBank.h.a a3 = o.a();
                    k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
                    Intent intent11 = new Intent(activity2, a3.getAddMoneyToPPBActivityClass());
                    intent11.putExtra("add_money_source", "PPB");
                    CharSequence charSequence = string10;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        intent11.putExtra("slfdBalance", string10);
                    }
                    CharSequence charSequence2 = string9;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z3 = true;
                    }
                    if (!z3) {
                        intent11.putExtra("slfdIblCifStatus", string9);
                    }
                    activity.startActivity(intent11);
                    return true;
                }
                break;
        }
        return false;
    }
}

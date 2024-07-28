package net.one97.paytm.bankOpen.d;

import android.app.Activity;
import android.content.Intent;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.utils.a;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.activity.BankAccountOpenReqSubmittedActivity;
import net.one97.paytm.bankOpen.activity.BankAccountOpenedActivity;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.bankOpen.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {
    public static void a(Activity activity, e eVar) {
        if (activity != null) {
            boolean isPasscodeSet = f.a().isPasscodeSet(activity);
            boolean showPasscodeScreen = f.a().showPasscodeScreen(activity);
            String m = net.one97.paytm.bankCommon.h.b.m(activity);
            String c2 = net.one97.paytm.bankCommon.h.b.c(activity);
            net.one97.paytm.bankCommon.h.b.n(activity);
            String o = net.one97.paytm.bankCommon.h.b.o(activity);
            String q = net.one97.paytm.bankCommon.h.b.q(activity);
            if (!isPasscodeSet && showPasscodeScreen) {
                c(activity, eVar);
            } else if (m.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                b(activity, eVar);
            } else if (c2.equalsIgnoreCase("Y")) {
                if (o.equalsIgnoreCase("Y")) {
                    if (f.a().canHandlePostAccOpenCall()) {
                        f.a().onAccountCreated(activity, (Object) null);
                    } else {
                        activity.startActivity(new Intent(activity, BankAccountOpenedActivity.class));
                    }
                    if (eVar != null) {
                        activity.finish();
                    }
                } else if (o.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                    Intent intent = new Intent(activity, BankAccountOpenReqSubmittedActivity.class);
                    intent.putExtra("middle_text", activity.getString(R.string.bank_acc_open_after_verified));
                    activity.startActivity(intent);
                    if (eVar != null) {
                        activity.finish();
                    }
                } else if (!o.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                } else {
                    if (q.equalsIgnoreCase("Y")) {
                        if (f.a().canHandlePostAccOpenCall()) {
                            f.a().onAccountCreated(activity, (Object) null);
                        } else {
                            activity.startActivity(new Intent(activity, BankAccountOpenedActivity.class));
                        }
                        if (eVar != null) {
                            activity.finish();
                            return;
                        }
                        return;
                    }
                    try {
                        d b2 = f.b();
                        b2.checkDeepLinking(activity, a.a(a.a() + "payment_bank?open_screen=bank_acc_open_req_status", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, false));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (c2.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                try {
                    d b3 = f.b();
                    b3.checkDeepLinking(activity, a.a(a.a() + "payment_bank?open_screen=bank_kyc_status_screen", CJRPGTransactionRequestUtils.PAYER_BANK_NAME));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
                if (eVar != null) {
                    activity.finish();
                }
            } else if (c2.equalsIgnoreCase(AppConstants.USER_SUB_TYPE)) {
                activity.startActivity(new Intent(activity, BankAccountOpenReqSubmittedActivity.class));
                if (eVar != null) {
                    activity.finish();
                }
            }
        }
    }

    private static void b(Activity activity, e eVar) {
        if (eVar != null) {
            eVar.a(1);
            return;
        }
        Intent intent = new Intent(activity, PaymentsBankBaseActivity.class);
        intent.putExtra("extraDefaultFrame", 1);
        activity.startActivity(intent);
    }

    private static void c(Activity activity, e eVar) {
        if (eVar != null) {
            eVar.a(0);
            return;
        }
        Intent intent = new Intent(activity, PaymentsBankBaseActivity.class);
        intent.putExtra("extraDefaultFrame", 0);
        activity.startActivity(intent);
    }
}

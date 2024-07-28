package net.one97.paytm.paymentsBank.slfd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b.a;
import net.one97.paytm.paymentsBank.slfd.b.b;
import net.one97.paytm.paymentsBank.slfd.createfd.view.SlfdLandingPageActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FixedDepositHistoryPassbookActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FixedDepositOfferingActivity;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f19120a;

    public static void a(Activity activity, double d2, String str, double d3) {
        if (Double.compare(d2, 0.0d) == 0) {
            a(activity);
        } else {
            a(activity, str, d3, d2, (Bundle) null);
        }
    }

    public static void a(Activity activity, double d2, String str, double d3, Bundle bundle) {
        if (bundle == null) {
            f19120a = "";
        } else if (bundle.containsKey("deeplink")) {
            f19120a = bundle.getString("deeplink");
        }
        if (Double.compare(d2, 0.0d) == 0) {
            a(activity);
        } else {
            a(activity, str, d3, d2, bundle);
        }
    }

    public static void a(Activity activity, String str, double d2, double d3, Bundle bundle) {
        if (bundle == null) {
            f19120a = "";
        } else if (bundle.containsKey("deeplink")) {
            f19120a = bundle.getString("deeplink");
        }
        Intent intent = new Intent(activity, SlfdLandingPageActivity.class);
        net.one97.paytm.bankCommon.utils.d.b();
        intent.putExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
        intent.putExtra("account_num", str);
        intent.putExtra("sa_balance", d2);
        intent.putExtra("fd_balance", d3);
        if (!v.a(f19120a)) {
            intent.putExtra(b.f18956a, f19120a);
            f19120a = "";
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str, double d2, double d3, String str2, Bundle bundle) {
        if (bundle == null) {
            f19120a = "";
        } else if (bundle.containsKey("deeplink")) {
            f19120a = bundle.getString("deeplink");
        }
        Intent intent = new Intent(activity, SlfdLandingPageActivity.class);
        net.one97.paytm.bankCommon.utils.d.b();
        intent.putExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
        intent.putExtra("account_num", str);
        intent.putExtra("sa_balance", d2);
        intent.putExtra("fd_balance", d3);
        intent.putExtra("user_type", str2);
        if (!v.a(f19120a)) {
            intent.putExtra(b.f18956a, f19120a);
            f19120a = "";
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    private static void a(Activity activity) {
        if (com.paytm.utility.b.c((Context) activity)) {
            com.paytm.utility.b.k(activity, activity.getString(R.string.pb_please_wait));
            new a(activity).a((g.b<IJRPaytmDataModel>) new g.b(activity) {
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onResponse(Object obj) {
                    d.a(this.f$0, (IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a(activity) {
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    d.a(this.f$0, i2, iJRPaytmDataModel, networkCustomError);
                }
            }, "A", "");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, IJRPaytmDataModel iJRPaytmDataModel) {
        com.paytm.utility.b.p();
        if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
            SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
            if (slfdTransactionModel != null && ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(slfdTransactionModel.getStatus())) {
                com.paytm.utility.b.b((Context) activity, activity.getString(R.string.error), slfdTransactionModel.getMessage());
            } else if (slfdTransactionModel == null || slfdTransactionModel.getTransactionList() == null || slfdTransactionModel.getTransactionList().size() <= 0) {
                Intent intent = new Intent(activity, FixedDepositOfferingActivity.class);
                if (!v.a(f19120a)) {
                    intent.putExtra(b.f18956a, f19120a);
                    f19120a = "";
                }
                activity.startActivity(intent);
            } else {
                Intent intent2 = new Intent(activity, FixedDepositHistoryPassbookActivity.class);
                intent2.putExtra("extra_slfd_transaction_model", slfdTransactionModel);
                if (!v.a(f19120a)) {
                    intent2.putExtra(b.f18956a, f19120a);
                    f19120a = "";
                }
                activity.startActivity(intent2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.p();
        f.a(activity, (Exception) networkCustomError, (String) null);
    }
}

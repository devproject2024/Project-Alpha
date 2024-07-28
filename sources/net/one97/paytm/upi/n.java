package net.one97.paytm.upi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferLinkAccountActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.awareness.view.UpiAwarenessActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.mandate.view.MandateListActivity;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.passbook.view.UpiPassbookTransactionDetailActivity;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.referral.UpiReferralActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.t;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f67609a = new n();

    private n() {
    }

    private static void b(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        boolean z = false;
        if (!TextUtils.isEmpty(t.b(context))) {
            ag.a aVar = ag.f69605a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = ag.a.a(applicationContext);
            if (a2.b("is_upi_user", false, true)) {
                Intent intent = new Intent(context, MoneyTransferLinkAccountActivity.class);
                intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData.f50283a);
                intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } else if (a2.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
                context.startActivity(UpiUtils.getUpiLandingPageActivityIntent(context));
            } else {
                context.startActivity(new Intent(context, UpiSelectBankActivity.class));
            }
        } else {
            Intent intent2 = new Intent(context, AJRAuthActivity.class);
            Bundle bundle = deepLinkData.f50290h;
            if (bundle != null) {
                z = bundle.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
            }
            intent2.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z);
            intent2.putExtra("resultant activity", MoneyTransferLinkAccountActivity.class.getName());
            context.startActivity(intent2);
        }
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f67610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f67611b;

        a(Context context, ProgressDialog progressDialog) {
            this.f67610a = context;
            this.f67611b = progressDialog;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (this.f67610a instanceof Activity) {
                ProgressDialog progressDialog = this.f67611b;
                if (progressDialog != null && progressDialog.isShowing() && !((Activity) this.f67610a).isFinishing()) {
                    this.f67611b.dismiss();
                }
            } else {
                try {
                    if (this.f67611b != null && this.f67611b.isShowing()) {
                        this.f67611b.dismiss();
                    }
                } catch (IllegalStateException e2) {
                    q.b(e2.getMessage());
                }
            }
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (p.a("success", upiProfileModel.getStatus(), true)) {
                    if (upiProfileModel.getResponse() != null) {
                        UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                        k.a((Object) response, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                        k.a((Object) profileDetail, "response.response.profileDetail");
                        if (profileDetail.getProfileVpaList() != null) {
                            UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                            k.a((Object) response2, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                            k.a((Object) profileDetail2, "response.response.profileDetail");
                            for (UpiProfileDefaultBank next : profileDetail2.getProfileVpaList()) {
                                k.a((Object) next, "vpaProfile");
                                if (next.isPrimary()) {
                                    String virtualAddress = next.getVirtualAddress();
                                    UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                                    Context context = this.f67610a;
                                    k.a((Object) virtualAddress, "vpa");
                                    UpiAddBankHelperActivity.a.a(context, virtualAddress);
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    Toast.makeText(this.f67610a, R.string.some_went_wrong, 1).show();
                    return;
                }
                Toast.makeText(this.f67610a, R.string.some_went_wrong, 1).show();
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            if (this.f67610a instanceof Activity) {
                ProgressDialog progressDialog = this.f67611b;
                if (progressDialog != null && progressDialog.isShowing() && !((Activity) this.f67610a).isFinishing()) {
                    this.f67611b.dismiss();
                }
            } else {
                try {
                    if (this.f67611b != null && this.f67611b.isShowing()) {
                        this.f67611b.dismiss();
                    }
                } catch (IllegalStateException e2) {
                    q.b(e2.getMessage());
                }
            }
            Toast.makeText(this.f67610a, R.string.some_went_wrong, 1).show();
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (!p.a(deepLinkData.f50284b, "upi_passbook", false) && !p.a(deepLinkData.f50284b, "upi", false) && !p.a(deepLinkData.f50284b, "upi_landing", false) && !p.a(deepLinkData.f50284b, "upi_referral", false) && !p.a(deepLinkData.f50284b, "upi_awareness", false) && !p.a(deepLinkData.f50284b, "pay", false) && !p.a(deepLinkData.f50284b, "upi_mandate_landing", false) && !p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_QR_LANDING, false)) {
            return false;
        }
        return true;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        String str;
        boolean z;
        Intent intent;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        boolean z2 = false;
        if (p.a(deepLinkData.f50284b, "upi_passbook", false) && p.a(deepLinkData.f50288f, UpiConstants.FEATURE_TYPE_TRANSACTION_DETAIL, true)) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            Intent intent2 = new Intent(context, UpiPassbookTransactionDetailActivity.class);
            intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData.f50283a);
            intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent2.setFlags(536870912);
            context.startActivity(intent2);
        } else if (p.a(deepLinkData.f50284b, "upi_passbook", true)) {
            if (!TextUtils.isEmpty(com.paytm.utility.a.q(context))) {
                intent = new Intent(context, UpiPassbookActivity.class);
                intent.putExtra("url", deepLinkData.f50284b);
                intent.setFlags(268435456);
                intent.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, deepLinkData.f50288f);
            } else {
                intent = new Intent(context, AJRAuthActivity.class);
                Bundle bundle = deepLinkData.f50290h;
                if (bundle != null) {
                    z2 = bundle.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
                }
                intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z2);
                intent.putExtra("resultant activity", UpiPassbookActivity.class.getName());
                intent.putExtra("url", deepLinkData.f50284b);
                intent.setFlags(268435456);
                intent.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, deepLinkData.f50288f);
            }
            context.startActivity(intent);
        } else if (p.a(deepLinkData.f50284b, "upi_referral", false)) {
            if (!TextUtils.isEmpty(t.b(context))) {
                Intent intent3 = new Intent(context, UpiReferralActivity.class);
                intent3.setFlags(268435456);
                context.startActivity(intent3);
                return;
            }
            Intent intent4 = new Intent(context, AJRAuthActivity.class);
            Bundle bundle2 = deepLinkData.f50290h;
            if (bundle2 != null) {
                z2 = bundle2.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
            }
            intent4.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z2);
            intent4.putExtra("resultant activity", UpiReferralActivity.class.getName());
            context.startActivity(intent4);
        } else if (p.a(deepLinkData.f50284b, "upi_awareness", false)) {
            if (!TextUtils.isEmpty(t.b(context))) {
                context.startActivity(new Intent(context, UpiAwarenessActivity.class));
                return;
            }
            Intent intent5 = new Intent(context, AJRAuthActivity.class);
            Bundle bundle3 = deepLinkData.f50290h;
            if (bundle3 != null) {
                z2 = bundle3.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
            }
            intent5.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z2);
            intent5.putExtra("resultant activity", UpiAwarenessActivity.class.getName());
            context.startActivity(intent5);
        } else if (p.a(deepLinkData.f50284b, "upi_landing", false)) {
            if (!TextUtils.isEmpty(t.b(context))) {
                ag.a aVar = ag.f69605a;
                Context applicationContext = context.getApplicationContext();
                k.a((Object) applicationContext, "context.applicationContext");
                com.paytm.b.a.a a2 = ag.a.a(applicationContext);
                if (a2.b("is_upi_user", false, true)) {
                    if (!a2.b(UpiConstants.PREF_KEY_IS_BANK_ACCOUNT_ADDED, false, true)) {
                        ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.setMessage(context.getString(R.string.please_wait));
                        progressDialog.setIndeterminate(true);
                        progressDialog.show();
                        g.a().a((a.C1382a) new a(context, progressDialog), "", "");
                        return;
                    }
                    Intent intent6 = new Intent(context, UPISettingsActivity.class);
                    intent6.setFlags(268435456);
                    context.startActivity(intent6);
                } else if (a2.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
                    Intent upiLandingPageActivityIntent = UpiUtils.getUpiLandingPageActivityIntent(context);
                    upiLandingPageActivityIntent.setFlags(268435456);
                    context.startActivity(upiLandingPageActivityIntent);
                } else {
                    Intent intent7 = new Intent(context, UpiSelectBankActivity.class);
                    intent7.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData.f50283a);
                    intent7.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
                    intent7.setFlags(268435456);
                    context.startActivity(intent7);
                }
            } else {
                ag.a aVar2 = ag.f69605a;
                Context applicationContext2 = context.getApplicationContext();
                k.a((Object) applicationContext2, "context.applicationContext");
                com.paytm.b.a.a a3 = ag.a.a(applicationContext2);
                boolean b2 = a3.b("is_upi_user", false, true);
                Intent intent8 = new Intent(context, AJRAuthActivity.class);
                Bundle bundle4 = deepLinkData.f50290h;
                if (bundle4 != null) {
                    z = bundle4.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
                } else {
                    z = false;
                }
                intent8.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z);
                intent8.putExtra("deeplink", deepLinkData.f50283a);
                intent8.setFlags(268435456);
                if (b2) {
                    intent8.putExtra("resultant activity", UPISettingsActivity.class.getName());
                } else if (a3.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
                    intent8.putExtra("resultant activity", UPISettingsActivity.class.getName());
                } else {
                    intent8.putExtra("resultant activity", UpiSelectBankActivity.class.getName());
                }
                context.startActivity(intent8);
            }
        } else if (p.a(deepLinkData.f50284b, "upi", false)) {
            if (deepLinkData.f50288f != null && (str = deepLinkData.f50288f) != null) {
                int hashCode = str.hashCode();
                if (hashCode != -801908935) {
                    if (hashCode != 1095692943) {
                        if (hashCode == 1193647446 && str.equals(UpiConstants.FEATURE_TYPE_LINK_BANK_LIST)) {
                            b(context, deepLinkData);
                        }
                    } else if (str.equals("request")) {
                        k.c(context, "context");
                        k.c(deepLinkData, "deepLinkData");
                        if (!TextUtils.isEmpty(t.b(context))) {
                            ag.a aVar3 = ag.f69605a;
                            Context applicationContext3 = context.getApplicationContext();
                            k.a((Object) applicationContext3, "context.applicationContext");
                            com.paytm.b.a.a a4 = ag.a.a(applicationContext3);
                            if (a4.b("is_upi_user", false, true)) {
                                context.startActivity(new Intent(context, RequestMoneyV2Activity.class));
                            } else if (a4.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
                                context.startActivity(UpiUtils.getUpiLandingPageActivityIntent(context));
                            } else {
                                context.startActivity(new Intent(context, UpiSelectBankActivity.class));
                            }
                        } else {
                            Intent intent9 = new Intent(context, AJRAuthActivity.class);
                            Bundle bundle5 = deepLinkData.f50290h;
                            if (bundle5 != null) {
                                z2 = bundle5.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
                            }
                            intent9.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z2);
                            intent9.putExtra("resultant activity", RequestMoneyV2Activity.class.getName());
                            context.startActivity(intent9);
                        }
                    }
                } else if (str.equals(UpiConstants.FEATURE_TYPE_VIEW_LINKED_BANK_ACCOUNTS)) {
                    b(context, deepLinkData);
                }
            }
        } else if (p.a(deepLinkData.f50284b, "pay", false)) {
            String str2 = deepLinkData.f50283a;
            Intent intent10 = new Intent(context, MoneyTransferV3Activity.class);
            intent10.setData(Uri.parse(str2));
            intent10.addFlags(67108864);
            intent10.setFlags(536870912);
            context.startActivity(intent10);
        } else if (p.a(deepLinkData.f50284b, "upi_mandate_landing", false)) {
            Intent intent11 = new Intent(context, MandateListActivity.class);
            intent11.setFlags(268435456);
            context.startActivity(intent11);
        } else if (!p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_QR_LANDING, false)) {
        } else {
            if (!TextUtils.isEmpty(t.b(context))) {
                q.a aVar4 = q.f68356a;
                k.c(context, "context");
                net.one97.paytm.upi.profile.a cVar = new q.a.c(context);
                k.c(context, "context");
                k.c(cVar, H5Event.TYPE_CALL_BACK);
                q.a.a(context, new q.a.b(cVar));
                return;
            }
            Intent intent12 = new Intent(context, AJRAuthActivity.class);
            Bundle bundle6 = deepLinkData.f50290h;
            if (bundle6 != null) {
                z2 = bundle6.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
            }
            intent12.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z2);
            intent12.putExtra("resultant activity", MoneyTransferLinkAccountActivity.class.getName());
            context.startActivity(intent12);
        }
    }
}

package net.one97.paytm.upi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.lifecycle.k;
import com.appsflyer.internal.referrer.Payload;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;

public final class UpiOnboardingHelperActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66484a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f66485b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f66485b = getIntent().getBooleanExtra("self_destroy", false);
        a();
    }

    private final void a() {
        if (!b()) {
            AccountProviderActivity.a((Activity) this, 101);
        } else {
            c();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 101:
                if (i3 != -1) {
                    finish();
                    return;
                } else if (intent != null) {
                    Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                    if (!(serializableExtra instanceof AccountProviderBody.AccountProvider)) {
                        serializableExtra = null;
                    }
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                    if (accountProvider != null) {
                        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
                        k.a((Object) a2, "Injection.provideUpiRegi…NpciServices(this, null))");
                        if (a2.e()) {
                            Context context = this;
                            k.c(context, "context");
                            k.c(accountProvider, UpiContract.UPI_ACCOUNT_PROVIDER.ACCOUNT_PROVIDER);
                            ProgressDialog progressDialog = new ProgressDialog(context);
                            progressDialog.setMessage(context.getString(R.string.please_wait));
                            progressDialog.setIndeterminate(true);
                            progressDialog.show();
                            q.a aVar = q.f68356a;
                            q.a.a(context, new b(this, progressDialog, accountProvider, context));
                            return;
                        } else if (this.f66485b) {
                            UpiRegistrationActivity.b(this, accountProvider, UpiConstants.UPI_ONBOARDING_SELF_DESTROY, UpiConstants.SourceOfOnBoarding.UPI_ONBOARDING.getVal());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        finish();
                        return;
                    }
                } else {
                    finish();
                    return;
                }
            case 102:
                if (i3 == -1) {
                    if (this.f66485b) {
                        setResult(-1);
                    } else {
                        UPISettingsActivity.a aVar2 = UPISettingsActivity.f68712d;
                        UPISettingsActivity.a.a(this);
                    }
                }
                finish();
                return;
            case 103:
                if (i3 == -1) {
                    if (this.f66485b) {
                        setResult(-1);
                    } else {
                        UpiLandingPageActivity.a((Context) this);
                    }
                }
                finish();
                return;
            case 104:
                if (i3 == -1) {
                    a();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }

    private static boolean b() {
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
        k.a((Object) a2, "Injection.provideUpiRegi…NpciServices(this, null))");
        return a2.f();
    }

    public static final class b implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiOnboardingHelperActivity f66486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f66487b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AccountProviderBody.AccountProvider f66488c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f66489d;

        b(UpiOnboardingHelperActivity upiOnboardingHelperActivity, ProgressDialog progressDialog, AccountProviderBody.AccountProvider accountProvider, Context context) {
            this.f66486a = upiOnboardingHelperActivity;
            this.f66487b = progressDialog;
            this.f66488c = accountProvider;
            this.f66489d = context;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            ProgressDialog progressDialog = this.f66487b;
            if (progressDialog != null && progressDialog.isShowing()) {
                androidx.lifecycle.k lifecycle = this.f66486a.getLifecycle();
                k.a((Object) lifecycle, "lifecycle");
                if (lifecycle.a().isAtLeast(k.b.RESUMED) && !this.f66486a.isDestroyed()) {
                    this.f66487b.dismiss();
                }
            }
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (p.a("success", upiProfileModel.getStatus(), true)) {
                    if (upiProfileModel.getResponse() != null) {
                        UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                        kotlin.g.b.k.a((Object) response, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                        kotlin.g.b.k.a((Object) profileDetail, "response.response.profileDetail");
                        if (profileDetail.getProfileVpaList() != null) {
                            UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                            kotlin.g.b.k.a((Object) response2, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                            kotlin.g.b.k.a((Object) profileDetail2, "response.response.profileDetail");
                            for (UpiProfileDefaultBank next : profileDetail2.getProfileVpaList()) {
                                kotlin.g.b.k.a((Object) next, "vpaProfile");
                                if (next.isPrimary()) {
                                    BankVpaCreationActivity.a((Activity) this.f66486a, this.f66488c, next.getVirtualAddress(), 103);
                                    return;
                                }
                                this.f66486a.finish();
                            }
                            return;
                        }
                    }
                    Toast.makeText(this.f66489d, R.string.some_went_wrong, 1).show();
                    this.f66486a.finish();
                    return;
                }
                Toast.makeText(this.f66489d, R.string.some_went_wrong, 1).show();
                this.f66486a.finish();
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            ProgressDialog progressDialog = this.f66487b;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f66487b.dismiss();
            }
            Toast.makeText(this.f66489d, R.string.some_went_wrong, 1).show();
            this.f66486a.finish();
        }
    }

    private final void c() {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, 104);
    }
}

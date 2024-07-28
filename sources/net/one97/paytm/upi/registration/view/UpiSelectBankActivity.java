package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.b;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.i;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b.a;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiSelectBankActivity extends PaytmActivity implements i {

    /* renamed from: a  reason: collision with root package name */
    private BottomSheetBehavior f68779a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f68780b;

    /* renamed from: c  reason: collision with root package name */
    private k f68781c;

    /* renamed from: d  reason: collision with root package name */
    private String f68782d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f68783e;

    /* renamed from: f  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68784f;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public void attachBaseContext(Context context) {
        if (net.one97.paytm.upi.i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = net.one97.paytm.upi.i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_select_bank);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        this.f68780b = (RelativeLayout) findViewById(R.id.rv_bottom_sheet);
        this.f68779a = BottomSheetBehavior.from(this.f68780b);
        this.f68779a.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 3) {
                    return;
                }
                if (i2 == 4) {
                    UpiSelectBankActivity.this.setResult(0);
                } else if (i2 == 5) {
                    UpiSelectBankActivity.this.setResult(0);
                    UpiSelectBankActivity.this.finish();
                }
            }
        });
        this.f68779a.setState(3);
        this.f68782d = getIntent().getStringExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL);
        this.f68783e = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FROM_SCHEDULER, false);
        this.f68781c = (k) getSupportFragmentManager().c(k.class.getSimpleName());
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, false)) {
            AccountProviderActivity.a((Activity) this, 1);
        } else if (this.f68781c == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(UpiConstants.EXTRA_IS_FROM_SCHEDULER, this.f68783e);
            this.f68781c = k.c();
            this.f68781c.setArguments(bundle2);
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), this.f68781c, R.id.fl_container);
        }
        String b2 = PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.EXTRA_UPI_REFER_DEEPLINK, "", true);
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            String queryParameter = Uri.parse(getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA")).getQueryParameter("referralCode");
            if (!TextUtils.isEmpty(queryParameter)) {
                a.a(getApplicationContext()).d((a.C1389a) null, "", queryParameter);
            }
        } else if (!TextUtils.isEmpty(b2)) {
            String queryParameter2 = Uri.parse(b2).getQueryParameter("referralCode");
            if (!TextUtils.isEmpty(queryParameter2)) {
                net.one97.paytm.upi.registration.b.a.b.a.a(getApplicationContext()).d(new a.C1389a() {
                    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    }

                    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                        UpiUtils.clearReferralCode(UpiSelectBankActivity.this.getApplicationContext());
                    }
                }, "", queryParameter2);
            }
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        UpiRegistrationActivity.a((Activity) this, accountProvider, this.f68782d, getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0));
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            k kVar = this.f68781c;
            if (kVar != null && kVar.isAdded()) {
                this.f68781c.onActivityResult(i2, i3, intent);
            } else if (intent != null) {
                this.f68784f = (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                AccountProviderBody.AccountProvider accountProvider = this.f68784f;
                if (accountProvider != null) {
                    b(accountProvider);
                }
            } else {
                finish();
            }
        } else if (i2 == 16) {
            b(this.f68784f);
        }
    }

    private void b(AccountProviderBody.AccountProvider accountProvider) {
        this.f68784f = accountProvider;
        if (Build.VERSION.SDK_INT >= 23) {
            int a2 = b.a((Context) this, "android.permission.READ_PHONE_STATE");
            int a3 = b.a((Context) this, "android.permission.READ_SMS");
            if (!(a2 == 0 && a3 == 0)) {
                requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_SMS"}, 16);
                return;
            }
        }
        a();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 16) {
            if (PermissionUtil.areAllPermissionsGranted(iArr)) {
                a();
            } else if (PermissionUtil.hasSelectedNeverShowThisAgain(this, "android.permission.READ_PHONE_STATE") || PermissionUtil.hasSelectedNeverShowThisAgain(this, "android.permission.READ_SMS")) {
                UpiUtils.showTakeToSettingsPermissionDialog(this, Boolean.FALSE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        UpiSelectBankActivity.this.c();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        UpiSelectBankActivity.this.finish();
                    }
                });
            } else {
                UpiUtils.showReadPhoneStatePermissionDialog(this, Boolean.FALSE, $$Lambda$UpiSelectBankActivity$pPcinnbVP7Ydk7yXKykOS5Nnzs.INSTANCE, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        UpiSelectBankActivity.this.finish();
                    }
                });
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        PermissionUtil.openAppSettingPage((Activity) this, 16);
    }

    private void a() {
        a(this.f68784f);
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }
}

package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.a.h;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiRegistrationActivity extends PaytmActivity implements h.b {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f68769a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f68770b;

    /* renamed from: c  reason: collision with root package name */
    int f68771c;

    /* renamed from: d  reason: collision with root package name */
    public String f68772d;

    /* renamed from: e  reason: collision with root package name */
    boolean f68773e;

    /* renamed from: f  reason: collision with root package name */
    boolean f68774f;

    /* renamed from: g  reason: collision with root package name */
    private Context f68775g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f68776h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public h.a f68777i;
    private AccountProviderBody.AccountProvider j;
    private int k = 0;
    private Random l;
    private k m;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68777i = (h.a) obj;
    }

    public static void a(Activity activity, AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        Intent intent = new Intent(activity, UpiRegistrationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, str);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, i2);
        intent.addFlags(33554432);
        activity.startActivity(intent);
    }

    public static void a(Fragment fragment, AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        Intent intent = new Intent(fragment.getContext(), UpiRegistrationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, str);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, i2);
        fragment.startActivityForResult(intent, 352);
    }

    public static void b(Activity activity, AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        Intent intent = new Intent(activity, UpiRegistrationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, str);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, i2);
        activity.startActivityForResult(intent, 102);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_registration);
        UpiUtils.setStatusBarColor(getResources().getColor(R.color.white), this);
        this.f68775g = this;
        this.f68773e = false;
        this.f68770b = (RelativeLayout) findViewById(R.id.i_bottom_strip);
        this.f68769a = (LinearLayout) findViewById(R.id.ll_upi_toolbar);
        this.f68776h = (ImageView) findViewById(R.id.iv_back);
        this.f68776h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRegistrationActivity.this.f68777i.a();
            }
        });
        this.f68771c = getIntent().getIntExtra("redirect", -1);
        this.f68772d = getIntent().getStringExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL);
        this.f68774f = getIntent().getBooleanExtra(UpiConstants.EXTRA_REGISTRATION_DO_CREATE_PROFILE, false);
        if (getIntent().hasExtra(UpiConstants.EXTRA_SELECTED_BANK)) {
            this.j = (AccountProviderBody.AccountProvider) getIntent().getSerializableExtra(UpiConstants.EXTRA_SELECTED_BANK);
        }
        this.f68777i = new net.one97.paytm.upi.registration.presenter.h(this);
        if (this.f68771c == -1) {
            c();
        }
        if (!g.a(a.a(g.d(), (a.C1347a) null)).g() || !UpiUtils.isSimAvailable(this)) {
            e();
        } else {
            b(this.j, -1);
        }
    }

    public void onResume() {
        super.onResume();
        this.f68777i.e();
    }

    public final int b() {
        return getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (Build.VERSION.SDK_INT >= 23) {
            int a2 = b.a((Context) this, "android.permission.READ_PHONE_STATE");
            int a3 = b.a((Context) this, "android.permission.READ_SMS");
            if (!(a2 == 0 && a3 == 0)) {
                requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_SMS"}, 16);
                return;
            }
        }
        if (this.f68771c == 288) {
            b(this.j, getIntent().getIntExtra(UpiConstants.EXTRA_SUBSCRIPTION_ID, -1));
        } else {
            f();
        }
    }

    private void f() {
        if (!UpiUtils.isSimAvailable(this.f68775g)) {
            a(this.j, -1, UpiConstants.RegistrationErrorOrigin.NO_SIM_INSTALLED.ordinal(), "");
        } else if (UpiUtils.isMultiSimDevice(this.f68775g)) {
            a(this.j, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal());
        } else {
            AccountProviderBody.AccountProvider accountProvider = this.j;
            if (accountProvider == null) {
                a(accountProvider, -1, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal(), "");
            } else {
                b(accountProvider, -1);
            }
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str) {
        c();
        this.f68770b.setVisibility(UpiUtils.isPaytmFirstApp() ? 8 : 0);
        i iVar = (i) getSupportFragmentManager().c(i.class.getSimpleName());
        if (iVar == null) {
            iVar = i.b(accountProvider, i2, i3, str);
        }
        UpiUtils.replaceFragmentToActivity(getSupportFragmentManager(), iVar, R.id.fl_container);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2) {
        c();
        this.f68770b.setVisibility(UpiUtils.isPaytmFirstApp() ? 8 : 0);
        g gVar = (g) getSupportFragmentManager().c(g.class.getSimpleName());
        if (gVar == null) {
            gVar = g.a(accountProvider, i2);
        }
        UpiUtils.replaceFragmentToActivity(getSupportFragmentManager(), gVar, R.id.fl_container);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        c();
        this.f68770b.setVisibility(UpiUtils.isPaytmFirstApp() ? 8 : 0);
        net.one97.paytm.upi.profile.view.b bVar = (net.one97.paytm.upi.profile.view.b) getSupportFragmentManager().c(net.one97.paytm.upi.profile.view.b.class.getSimpleName());
        if (bVar == null) {
            bVar = net.one97.paytm.upi.profile.view.b.a(accountProvider, str, UpiConstants.PROFILE_STATE.ADD_BANK);
        }
        UpiUtils.replaceFragmentToActivity(getSupportFragmentManager(), bVar, R.id.fl_container);
    }

    public final void a() {
        if (b() == UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
            Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
            intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
        } else if (b() == UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "sending_sms_back_arrow", "", "", "", "", "wallet");
        }
        finish();
    }

    public void onBackPressed() {
        if (!this.f68773e) {
            a();
        }
    }

    public final void b(AccountProviderBody.AccountProvider accountProvider, int i2) {
        c();
        this.f68770b.setVisibility(UpiUtils.isPaytmFirstApp() ? 8 : 0);
        j jVar = (j) getSupportFragmentManager().c(j.class.getSimpleName());
        if (jVar == null) {
            jVar = j.a(accountProvider, i2, this.f68771c);
        }
        UpiUtils.replaceFragmentToActivity(getSupportFragmentManager(), jVar, R.id.fl_container);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            k kVar = this.m;
            if (kVar != null && kVar.isAdded()) {
                this.m.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 2) {
            if (intent != null) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                net.one97.paytm.upi.profile.view.b bVar = (net.one97.paytm.upi.profile.view.b) getSupportFragmentManager().c(net.one97.paytm.upi.profile.view.b.class.getSimpleName());
                if (bVar != null) {
                    bVar.a(accountProvider);
                }
            }
        } else if (i2 == 3) {
            try {
                List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
                if (d2 != null) {
                    if (d2.size() > 0) {
                        for (Fragment a2 : d2) {
                            getSupportFragmentManager().a().a(a2).c();
                            getSupportFragmentManager().a((String) null, 0);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            f();
        } else if (i2 == 16) {
            e();
        }
    }

    public final void c() {
        this.f68769a.setBackgroundColor(b.c(this.f68775g, R.color.white));
        this.f68770b.setVisibility(8);
    }

    private ArrayList<String> a(ArrayList<String> arrayList) {
        if (this.l == null) {
            this.l = new Random();
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i2 = 0;
        while (i2 < 2) {
            try {
                int nextInt = this.l.nextInt(arrayList.size());
                arrayList2.add(arrayList.get(nextInt));
                arrayList.remove(nextInt);
                i2++;
            } catch (Exception unused) {
            }
        }
        return arrayList2;
    }

    public final ArrayList<String> d() {
        ArrayList<String> arrayList = new ArrayList<>();
        String randomTelcoNumberList = UpiGTMLoader.getInstance().getRandomTelcoNumberList();
        try {
            if (!TextUtils.isEmpty(randomTelcoNumberList)) {
                arrayList.addAll(Arrays.asList(randomTelcoNumberList.split("##")));
                if (arrayList.size() > 2) {
                    ArrayList<String> a2 = a(arrayList);
                    arrayList.clear();
                    arrayList.addAll(a2);
                }
            }
        } catch (Exception unused) {
        }
        if (arrayList.size() == 0) {
            arrayList.add(UpiGTMLoader.getInstance().getUpiTelcoNumber());
        }
        return arrayList;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 16) {
            if (PermissionUtil.areAllPermissionsGranted(iArr)) {
                e();
            } else if (PermissionUtil.hasSelectedNeverShowThisAgain(this, "android.permission.READ_PHONE_STATE") || PermissionUtil.hasSelectedNeverShowThisAgain(this, "android.permission.READ_SMS")) {
                UpiUtils.showTakeToSettingsPermissionDialog(this, Boolean.FALSE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        UpiRegistrationActivity.this.g();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        UpiRegistrationActivity.this.finish();
                    }
                });
            } else {
                UpiUtils.showReadPhoneStatePermissionDialog(this, Boolean.FALSE, new CustomDialog.OkClickListener() {
                    public final void onOkClick() {
                        UpiRegistrationActivity.this.e();
                    }
                }, new CustomDialog.OnDialogDismissListener() {
                    public final void onDialogDismissed() {
                        UpiRegistrationActivity.this.finish();
                    }
                });
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        PermissionUtil.openAppSettingPage((Activity) this, 16);
    }
}

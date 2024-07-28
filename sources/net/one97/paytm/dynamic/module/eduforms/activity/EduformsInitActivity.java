package net.one97.paytm.dynamic.module.eduforms.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.play.core.splitcompat.a;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.h5.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiContract;
import net.one97.paytm.utils.t;

public class EduformsInitActivity extends AppCompatActivity {
    private final String INSTALLER_PACKAGE_NAME = "com.android.vending";
    DeepLinkData deepLinkData;
    private String eduFormH5URL = "";

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    private void initEduformsLib() {
        c cVar = c.f50543a;
        c.a("education", new c.b() {
            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                EduformsInitActivity.this.lambda$initEduformsLib$0$EduformsInitActivity(str, cVar);
            }
        });
    }

    public /* synthetic */ void lambda$initEduformsLib$0$EduformsInitActivity(String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1940613496:
                    if (str.equals("networkType")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1459599807:
                    if (str.equals("lastName")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1133543344:
                    if (str.equals("deviceLocale")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -836030906:
                    if (str.equals("userId")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -662089212:
                    if (str.equals("appVersionCode")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -661774686:
                    if (str.equals("appVersionName")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals(AppConstants.KEY_EMAIL)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 132835675:
                    if (str.equals("firstName")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 780851262:
                    if (str.equals("deviceImei")) {
                        c2 = 12;
                        break;
                    }
                    break;
                case 780988929:
                    if (str.equals("deviceName")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 802258218:
                    if (str.equals("ssoToken")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1109191185:
                    if (str.equals("deviceId")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 1170165752:
                    if (str.equals("isPlaystoreInstall")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1812004436:
                    if (str.equals("osVersion")) {
                        c2 = 13;
                        break;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 1998308679:
                    if (str.equals("deviceManufacturer")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    cVar.onResult(t.b((Context) this));
                    return;
                case 1:
                    cVar.onResult(b.h((Context) this));
                    return;
                case 2:
                    cVar.onResult(b.i((Context) this));
                    return;
                case 3:
                    cVar.onResult(com.paytm.utility.a.c((Context) this));
                    return;
                case 4:
                    cVar.onResult(com.paytm.utility.a.b((Context) this));
                    return;
                case 5:
                    cVar.onResult(com.paytm.utility.a.a((Context) this));
                    return;
                case 6:
                    cVar.onResult(720656);
                    return;
                case 7:
                    cVar.onResult(b.Q((Context) this));
                    return;
                case 8:
                    cVar.onResult(Build.MANUFACTURER);
                    return;
                case 9:
                    cVar.onResult(Build.MODEL);
                    return;
                case 10:
                    cVar.onResult(b.g());
                    return;
                case 11:
                    cVar.onResult(com.paytm.utility.a.l(this));
                    return;
                case 12:
                    cVar.onResult(getImei());
                    return;
                case 13:
                    cVar.onResult(Integer.valueOf(b.d()));
                    return;
                case 14:
                    cVar.onResult(Boolean.valueOf(isPlayStoreInstall()));
                    return;
                case 15:
                    cVar.onResult(Settings.Secure.getString(getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
                    return;
                case 16:
                    cVar.onResult(StringSet.Android);
                    return;
                default:
                    cVar.onResult("");
                    return;
            }
        }
    }

    private String getImei() {
        try {
            getSystemService(ContactColumn.PHONE_NUMBER);
            return com.paytm.utility.a.f(this);
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean isPlayStoreInstall() {
        try {
            PackageManager packageManager = getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return "com.android.vending".equalsIgnoreCase(installerPackageName);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initEduformsLib();
        getSupportActionBar().f();
        if (!com.paytm.utility.a.m(this)) {
            g.f43805b = new g.a() {
                public void onOkClick() {
                    EduformsInitActivity.this.finish();
                }
            };
            g.b(this, getString(R.string.no_network_title), getString(R.string.network_error_message));
        } else if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.deepLinkData = (DeepLinkData) getIntent().getExtras().getParcelable("EXTRA_DEEP_LINK_DATA");
            if (this.deepLinkData.f50284b.equalsIgnoreCase("edu-open-h5")) {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setGravity(17);
                setContentView((View) linearLayout);
                LottieAnimationView lottieAnimationView = new LottieAnimationView(this);
                linearLayout.addView(lottieAnimationView);
                lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(com.paytm.utility.a.a(120), com.paytm.utility.a.a(60)));
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
                getSupportActionBar().f();
                net.one97.paytm.j.c.a();
                String a2 = net.one97.paytm.j.c.a("edu_fee_h5_min_supported_app_version", "8.7.0");
                net.one97.paytm.j.c.a();
                int a3 = net.one97.paytm.j.c.a("edu_fee_h5_min_supported_os_version", 23);
                net.one97.paytm.j.c.a();
                launchFeeConfigCheck(net.one97.paytm.j.c.a("edu_fee_h5_launch_url", "https://www.paytm.com/edu-fee-h5/"), a3, a2);
            }
        } else if (getIntent() != null) {
            if (getIntent().hasExtra("H5_URL")) {
                openH5Page(getIntent().getStringExtra("H5_URL"));
            } else {
                launchUsingIntent(getIntent());
            }
            finish();
        }
    }

    private void launchFeeConfigCheck(String str, int i2, String str2) {
        if (TextUtils.isEmpty(str) || i2 > Build.VERSION.SDK_INT || !checkAppVersion(str2)) {
            h.a aVar = h.f50349a;
            h.a.a(this, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/46007?group=brand", (Bundle) null);
            return;
        }
        this.eduFormH5URL = str;
        openEduH5PageDev();
    }

    private boolean checkAppVersion(String str) {
        String str2;
        String[] split = str.split("\\.");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        try {
            str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split2 = str2.split("\\.");
        int parseInt4 = Integer.parseInt(split2[0]);
        int parseInt5 = Integer.parseInt(split2[1]);
        int parseInt6 = Integer.parseInt(split2[2]);
        if (parseInt > parseInt4) {
            return false;
        }
        if (parseInt == parseInt4) {
            if (parseInt2 > parseInt5) {
                return false;
            }
            if (parseInt2 != parseInt5 || parseInt3 <= parseInt6) {
                return true;
            }
            return false;
        }
        return true;
    }

    private void openH5Page(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(t.b((Context) this))) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("canPullDown", false);
            bundle.putBoolean("pullRefresh", false);
            bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
            bundle.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
            bundle.putString("paytmChangeBackButtonColor", "#000000");
            bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            u.a().a("education", "bbd2fe663bab76d2e140a4706b50fd80e2cf01ea", str, bundle, "", (Context) this);
        }
    }

    private void openEduH5PageDev() {
        DeepLinkData deepLinkData2 = this.deepLinkData;
        String str = "";
        if (deepLinkData2 != null && !TextUtils.isEmpty(deepLinkData2.f50283a) && this.deepLinkData.f50283a.contains("paytmmp://edu-open-h5?qrCodeParams")) {
            str = this.deepLinkData.f50283a.replace("paytmmp://edu-open-h5", str);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("canPullDown", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
        bundle.putString("paytmChangeBackButtonColor", "#000000");
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        Uri parse = Uri.parse(this.eduFormH5URL);
        u a2 = u.a();
        a2.a("education", "bbd2fe663bab76d2e140a4706b50fd80e2cf01ea", parse.toString() + str, bundle, "", (Context) this);
    }

    private void launchUsingIntent(Intent intent) {
        if (intent.hasExtra("RESULTANT_ACTIVITY_NAME")) {
            intent.setClassName(this, intent.getStringExtra("RESULTANT_ACTIVITY_NAME"));
            startActivity(intent);
        }
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}

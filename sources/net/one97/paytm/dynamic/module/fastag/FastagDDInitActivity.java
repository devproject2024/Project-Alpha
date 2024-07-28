package net.one97.paytm.dynamic.module.fastag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.HashMap;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.h5.c;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public class FastagDDInitActivity extends AppCompatActivity {
    private DeepLinkData deepLinkData;
    private String url;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        c cVar = c.f50543a;
        c.a("FasTag", new c.b() {
            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                FastagDDInitActivity.this.lambda$onCreate$0$FastagDDInitActivity(str, cVar);
            }
        });
        if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.deepLinkData = (DeepLinkData) getIntent().getExtras().getParcelable("EXTRA_DEEP_LINK_DATA");
            if (this.deepLinkData.f50289g.getQueryParameter("url") != null) {
                this.url = this.deepLinkData.f50289g.getQueryParameter("url");
                try {
                    this.url = URLDecoder.decode(this.url, AppConstants.UTF_8);
                } catch (UnsupportedEncodingException e2) {
                    q.b(e2.getMessage());
                }
            } else {
                DeepLinkData deepLinkData2 = this.deepLinkData;
                String str2 = "";
                if (deepLinkData2 == null || deepLinkData2.f50289g == null) {
                    str = str2;
                } else {
                    str = !TextUtils.isEmpty(this.deepLinkData.f50289g.getPath()) ? this.deepLinkData.f50289g.getPath() : str2;
                    if (!TextUtils.isEmpty(this.deepLinkData.f50289g.getQuery())) {
                        str2 = "?" + this.deepLinkData.f50289g.getQuery();
                    }
                }
                net.one97.paytm.j.c.a();
                this.url = net.one97.paytm.j.c.a("fastagLaunchUrl", "https://paytm.com/manage-fastag/");
                this.url += str + str2;
            }
        }
        openH5Page();
        finish();
    }

    public /* synthetic */ void lambda$onCreate$0$FastagDDInitActivity(String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 97513095:
                    if (str.equals("flags")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1468308994:
                    if (str.equals("USER_SESSION")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(com.business.merchant_payments.common.utility.AppConstants.TAG_CHILD_SITE_ID, "1");
                hashMap.put(com.business.merchant_payments.common.utility.AppConstants.TAG_SITE_ID, "1");
                String g2 = t.g(getApplicationContext());
                if (g2 != null) {
                    hashMap.put("cart_id", g2);
                }
                if (com.paytm.utility.a.a((Context) this) != null) {
                    hashMap.put("user_id", com.paytm.utility.a.a((Context) this));
                }
                DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
                hashMap.put(StringSet.width, Integer.valueOf(displayMetrics.widthPixels));
                hashMap.put(StringSet.height, Integer.valueOf(displayMetrics.heightPixels));
                hashMap.putAll(com.paytm.utility.c.b((Context) this, true));
                hashMap.put("jsonContext", r.a((Context) this, (String) null, (String) null));
                hashMap.put("addressApiHeader", t.e(this));
                hashMap.put(com.business.merchant_payments.common.utility.AppConstants.TAG_DEVICE, "android");
                cVar.onResult(hashMap);
            } else if (c2 == 1) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("payment_info_version", 2);
                cVar.onResult(hashMap2);
            } else if (c2 == 2) {
                cVar.onResult(b.m((Context) this));
            } else if (c2 == 3) {
                cVar.onResult(b.l((Context) this));
            }
        }
    }

    private void openH5Page() {
        if (!TextUtils.isEmpty(this.url)) {
            u.a().a("FasTag", "dcdb8651f559d43d96061bd7b6d0a940fe456b49", appendDefaultParams(this.url), getH5Bundle(), "", (Context) this);
        }
    }

    private String appendDefaultParams(String str) {
        float f2;
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("notchHeight", "0");
            buildUpon.appendQueryParameter("framework", "h5App");
            buildUpon.appendQueryParameter("isH5InitialPage", "1");
            int i2 = getNavigationBarSize(this).y;
            if (i2 == 0) {
                f2 = 0.0f;
            } else {
                f2 = ((float) i2) / Resources.getSystem().getDisplayMetrics().density;
            }
            buildUpon.appendQueryParameter("navBarHeight", String.valueOf(f2));
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private Bundle getH5Bundle() {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("deviceName", com.paytm.utility.a.e());
            bundle.putString("osVersion", String.valueOf(b.d()));
            bundle.putString("applicationName", "Paytm");
            bundle.putString("applicationId", "net.one97.paytm");
            bundle.putBoolean("paytmShowTitleBar", false);
            bundle.putString(H5Param.LONG_BACK_BEHAVIOR, H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
            bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return bundle;
    }

    public Point getNavigationBarSize(Context context) {
        Point appUsableScreenSize = getAppUsableScreenSize(context);
        Point realScreenSize = getRealScreenSize(context);
        if (ViewConfiguration.get(context).hasPermanentMenuKey() || appUsableScreenSize.y != realScreenSize.y) {
            return new Point();
        }
        return new Point(appUsableScreenSize.x, getNavigationBatHeight(context));
    }

    public Point getAppUsableScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public Point getRealScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return point;
    }

    public int getNavigationBatHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}

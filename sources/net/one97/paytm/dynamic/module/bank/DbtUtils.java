package net.one97.paytm.dynamic.module.bank;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.a;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.j.c;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.l;
import org.json.JSONArray;

public final class DbtUtils {
    public static final DbtUtils INSTANCE = new DbtUtils();

    private DbtUtils() {
    }

    public final void openDbt(Context context, String str) {
        String str2;
        k.c(context, "context");
        c.a();
        String a2 = c.a("dbt_index", "https://dbt.paytmbank.com");
        String str3 = "";
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (!TextUtils.isEmpty(str)) {
                k.a((Object) parse, "uri");
                str2 = parse.getPath();
                if (str2 == null) {
                    k.a();
                }
            } else {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(parse.getQuery())) {
                str3 = "?" + parse.getQuery();
            }
        } else {
            str2 = str3;
        }
        initDbt(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("canPullDown", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
        bundle.putString("paytmChangeBackButtonColor", "#000000");
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        u.a().a(DbtUtilsKt.DBT_VERTICAL_NAME, DbtUtilsKt.DBT_VERTICAL_UNIQUE_ID, a2 + str2 + str3, bundle, "", context);
    }

    public final void initDbt(Context context) {
        k.c(context, "context");
        net.one97.paytm.h5.c cVar = net.one97.paytm.h5.c.f50543a;
        net.one97.paytm.h5.c.a(DbtUtilsKt.DBT_VERTICAL_NAME, new DbtUtils$initDbt$1(context));
    }

    /* access modifiers changed from: private */
    public final String getImei(Context context) {
        try {
            if (context.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                String f2 = a.f(context);
                k.a((Object) f2, "ApplaunchUtility.getUniq…text, inTelephonyManager)");
                return f2;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final boolean isPlayStoreInstall(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return p.a("com.android.vending", installerPackageName, true);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final boolean hasCC(Context context) {
        if (context == null) {
            return false;
        }
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return ag.a.a(applicationContext).b("isCreditCard", false, true);
    }

    /* access modifiers changed from: private */
    public final JSONArray getAllEmails(Context context) {
        JSONArray jSONArray = new JSONArray();
        Iterator<DeviceAccount> it2 = l.d(context).iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().getValue());
        }
        return jSONArray;
    }
}

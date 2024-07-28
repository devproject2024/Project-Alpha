package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.Iterator;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.c.i;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import org.json.JSONObject;

public final class j extends ad {
    public j() {
        super("paytmDeviceManufacturer", "paytmDeviceName", "paytmDeviceLocale", "paytmNetworkType", "paytmDeviceImei", "paytmOsVersion", "paytmIsPlaystoreInstall", "paytmAppVersion", "paytmH5Version", "paytmGetAppInfo");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        String str;
        Configuration configuration;
        Locale locale;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        super.handleEvent(h5Event, h5BridgeContext);
        if (a(h5Event)) {
            if (h5Event == null) {
                k.a();
            }
            String action = h5Event.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -1659987207:
                        if (action.equals("paytmIsPlaystoreInstall")) {
                            Activity activity5 = h5Event.getActivity();
                            k.a((Object) activity5, "event.activity");
                            a((Object) Boolean.valueOf(b(activity5)));
                            break;
                        }
                        break;
                    case -947307865:
                        if (action.equals("paytmNetworkType") && (activity = h5Event.getActivity()) != null) {
                            Context context = activity;
                            if (b.a(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                                a(H5Event.Error.UNKNOWN_ERROR, "Permission denied");
                                break;
                            } else {
                                a((Object) a(context));
                                break;
                            }
                        }
                    case -831844280:
                        if (action.equals("paytmDeviceManufacturer")) {
                            a((Object) Build.MANUFACTURER);
                            break;
                        }
                        break;
                    case -405839855:
                        if (action.equals("paytmDeviceLocale")) {
                            Resources system = Resources.getSystem();
                            if (system == null || (configuration = system.getConfiguration()) == null || (locale = configuration.locale) == null || (str = locale.getLanguage()) == null) {
                                str = "";
                            }
                            a((Object) str);
                            break;
                        }
                        break;
                    case -74041558:
                        if (action.equals("paytmH5Version")) {
                            a((Object) "2.1.40-MB-07");
                            break;
                        }
                        break;
                    case 136081978:
                        if (action.equals("paytmGetAppInfo") && (activity2 = h5Event.getActivity()) != null) {
                            if (activity2 instanceof PaytmH5Activity) {
                                H5ProviderManager providerManager = Nebula.getProviderManager();
                                i iVar = (i) (providerManager != null ? providerManager.getProvider(i.class.getName()) : null);
                                if (iVar != null) {
                                    Activity activity6 = h5Event.getActivity();
                                    k.a((Object) activity6, "event.activity");
                                    Context applicationContext = activity6.getApplicationContext();
                                    k.a((Object) applicationContext, "event.activity.applicationContext");
                                    String b2 = iVar.b(applicationContext);
                                    Activity activity7 = h5Event.getActivity();
                                    k.a((Object) activity7, "event.activity");
                                    Context applicationContext2 = activity7.getApplicationContext();
                                    k.a((Object) applicationContext2, "event.activity.applicationContext");
                                    int a2 = iVar.a(applicationContext2);
                                    Activity activity8 = h5Event.getActivity();
                                    k.a((Object) activity8, "event.activity");
                                    Context applicationContext3 = activity8.getApplicationContext();
                                    k.a((Object) applicationContext3, "event.activity.applicationContext");
                                    JSONObject c2 = iVar.c(applicationContext3);
                                    e eVar = new e();
                                    Iterator<String> keys = c2.keys();
                                    k.a((Object) keys, "defaultParamsJson.keys()");
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        eVar.put(next, c2.get(next));
                                    }
                                    a("app_info_pt", (Object) eVar);
                                    a("appVersionCode", (Object) Integer.valueOf(a2));
                                    a("appVersionName", (Object) b2);
                                    a("h5Version", (Object) "2.1.40-MB-07");
                                    a((Object) null);
                                    break;
                                }
                            }
                            a(H5Event.Error.UNKNOWN_ERROR, "Unable to fetch app info");
                            break;
                        }
                    case 674346047:
                        if (action.equals("paytmDeviceImei") && (activity3 = h5Event.getActivity()) != null) {
                            if (b.a((Context) activity3, "android.permission.READ_PHONE_STATE") != 0) {
                                a(H5Event.Error.UNKNOWN_ERROR, "Permission denied");
                                break;
                            } else {
                                Object systemService = activity3.getSystemService(ContactColumn.PHONE_NUMBER);
                                if (systemService != null) {
                                    a((Object) ((TelephonyManager) systemService).getDeviceId());
                                    break;
                                } else {
                                    throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
                                }
                            }
                        }
                    case 674483714:
                        if (action.equals("paytmDeviceName")) {
                            a((Object) Build.MODEL);
                            break;
                        }
                        break;
                    case 838737459:
                        if (action.equals("paytmOsVersion")) {
                            a((Object) Build.VERSION.RELEASE);
                            break;
                        }
                        break;
                    case 1377607544:
                        if (action.equals("paytmAppVersion") && (activity4 = h5Event.getActivity()) != null) {
                            PackageManager packageManager = activity4.getPackageManager();
                            Context applicationContext4 = activity4.getApplicationContext();
                            k.a((Object) applicationContext4, "it.applicationContext");
                            PackageInfo packageInfo = packageManager.getPackageInfo(applicationContext4.getPackageName(), 1);
                            a(AppConstants.VERSION_CODE, (Object) Integer.valueOf(packageInfo.versionCode));
                            String str2 = packageInfo.versionName;
                            k.a((Object) str2, "info.versionName");
                            a(AppConstants.VERSION_NAME, (Object) str2);
                            a((Object) null);
                            break;
                        }
                }
            }
        }
        return true;
    }

    private static String a(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return H5Utils.NETWORK_TYPE_WIFI;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return H5Utils.NETWORK_TYPE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return H5Utils.NETWORK_TYPE_3G;
                            case 13:
                                return H5Utils.NETWORK_TYPE_4G;
                        }
                    }
                }
                return "Unknown";
            }
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    private static boolean b(Context context) {
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
}

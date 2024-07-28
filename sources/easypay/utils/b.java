package easypay.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.entity.NewConfigResponse;
import easypay.entity.PreferenceList;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.utils.a;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.upi.util.UpiContract;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f46102a = {64, 64, 64, 64, 38, 38, 38, 38, 35, 35, 35, 35, 36, 36, 36, 36};

    public static void a(Context context, String str) {
        PreferenceList preferenceList;
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
                String string = sharedPreferences.getString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, "");
                f fVar = new f();
                if (!TextUtils.isEmpty(str)) {
                    NewConfigResponse newConfigResponse = (NewConfigResponse) fVar.a(str, NewConfigResponse.class);
                    if (newConfigResponse != null && newConfigResponse.getResponseCode() != null && !TextUtils.isEmpty(newConfigResponse.getResponseMessage()) && newConfigResponse.getResponseCode().intValue() != 403 && !newConfigResponse.getResponseMessage().contains("Bank name is not supported")) {
                        if (TextUtils.isEmpty(string)) {
                            preferenceList = new PreferenceList();
                            preferenceList.getPrefList().add(newConfigResponse.getAssistBaseSRO());
                        } else {
                            preferenceList = (PreferenceList) fVar.a(string, PreferenceList.class);
                            if (preferenceList != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= preferenceList.getPrefList().size()) {
                                        i2 = -1;
                                        break;
                                    }
                                    if (newConfigResponse.getAssistBaseSRO().equals(preferenceList.getPrefList().get(i2))) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (i2 != -1) {
                                    preferenceList.getPrefList().set(i2, newConfigResponse.getAssistBaseSRO());
                                } else if (preferenceList.getPrefList().size() < 5) {
                                    preferenceList.getPrefList().add(newConfigResponse.getAssistBaseSRO());
                                } else {
                                    preferenceList.getPrefList().remove(preferenceList.getPrefList().size() - 1);
                                    preferenceList.getPrefList().add(0, newConfigResponse.getAssistBaseSRO());
                                }
                            }
                        }
                        AssistMerchantDetails.getInstance().setAssistFeatureEvents(newConfigResponse.getAssistFeatureEvents());
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, new f().b(preferenceList));
                        edit.putString(Constants.EASY_PAY_CONFIG_PREF_KEY, new f().b(newConfigResponse.getAssistBaseSRO()));
                        edit.apply();
                    }
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        } else {
            AssistLogs.printLog("Null context passed", "EasyPayUtils");
        }
    }

    public static String a() {
        return Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.DEVICE + "|" + Build.BRAND + "|" + f();
    }

    public static String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
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
                        default:
                            return "Unknown";
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            return null;
        }
    }

    private static String f() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString((statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / 1048576);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Activity activity) {
        try {
            androidx.core.app.a.a(activity, new String[]{"android.permission.READ_SMS"}, 111);
        } catch (ActivityNotFoundException e2) {
            AssistLogs.printLog(e2.getMessage(), e2);
        }
    }

    public static DisplayMetrics b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static boolean b() {
        return androidx.core.app.a.a(AssistMerchantDetails.getInstance().getContext(), "android.permission.RECEIVE_SMS") == 0;
    }

    public static boolean c(Context context) {
        return androidx.core.content.b.a(context, "android.permission.READ_SMS") == 0;
    }

    public static String a(String str, String str2) {
        String str3;
        String str4 = str + AppConstants.COLON + str2 + AppConstants.COLON + String.valueOf(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis()) + AppConstants.COLON + Settings.Secure.getString(AssistMerchantDetails.getInstance().getContext().getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(1, new SecretKeySpec("D!i+)(qCgsq&E+K)".getBytes(), "AES"), new IvParameterSpec(f46102a));
            str3 = new String(Base64.encode(instance.doFinal(str4.getBytes()), 2));
            try {
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                instance2.init(2, new SecretKeySpec("D!i+)(qCgsq&E+K)".getBytes(), "AES"), new IvParameterSpec(f46102a));
                String[] split = new String(instance2.doFinal(Base64.decode(str3, 2))).split(AppConstants.COLON);
                int i2 = 0;
                while (i2 < split.length) {
                    StringBuilder sb = new StringBuilder("Decrypt checksum: Entry (");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append("):");
                    sb.append(split[i2]);
                    AssistLogs.printLog(sb.toString(), b.class);
                    i2 = i3;
                }
            } catch (Exception e2) {
                e = e2;
                AssistLogs.printLog("EXCEPTION", e);
                return str3;
            }
        } catch (Exception e3) {
            e = e3;
            str3 = str4;
            AssistLogs.printLog("EXCEPTION", e);
            return str3;
        }
        return str3;
    }

    public static int a(Context context, String str, String str2) {
        ArrayList arrayList;
        try {
            AssistLogs.printLog("Delete ID called", context);
            a aVar = new a(context, "PaytmAsist");
            a.C0775a a2 = aVar.edit();
            HashMap hashMap = (HashMap) new f().a(aVar.getString(Constants.USER_ID_NET_BANK_KEY, ""), new a().getType());
            new f().b(hashMap);
            if (hashMap == null || (arrayList = (ArrayList) hashMap.get(str)) == null || !arrayList.contains(str2)) {
                return 1;
            }
            if (arrayList.size() == 1) {
                hashMap.remove(str);
            } else {
                arrayList.remove(str2);
                hashMap.put(str, arrayList);
            }
            a2.putString(Constants.USER_ID_NET_BANK_KEY, new f().b(hashMap));
            a2.apply();
            return 0;
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            return 1;
        }
    }

    static class a extends com.google.gson.b.a<HashMap<String, ArrayList<String>>> {
        a() {
        }
    }

    public static Map<String, ArrayList<String>> d(Context context) {
        AssistLogs.printLog("inside fetch USerID before run", context);
        String string = new a(context, "PaytmAsist").getString(Constants.USER_ID_NET_BANK_KEY, "");
        AssistLogs.printLog("inside fetch USerID".concat(String.valueOf(string)), context);
        try {
            return (HashMap) new f().a(string, new C0776b().getType());
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            return null;
        }
    }

    /* renamed from: easypay.utils.b$b  reason: collision with other inner class name */
    static class C0776b extends com.google.gson.b.a<HashMap<String, ArrayList<String>>> {
        C0776b() {
        }
    }

    public static int b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        AssistLogs.printLog("Saved ID called", context);
        new Thread(new c(context, str2, str)).start();
        return 0;
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f46103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f46104b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46105c;

        c(Context context, String str, String str2) {
            this.f46103a = context;
            this.f46104b = str;
            this.f46105c = str2;
        }

        public final void run() {
            String str;
            try {
                a aVar = new a(this.f46103a, "PaytmAsist");
                a.C0775a a2 = aVar.edit();
                String string = aVar.getString(Constants.USER_ID_NET_BANK_KEY, "");
                Type type = new a().getType();
                f fVar = new f();
                HashMap hashMap = (HashMap) fVar.a(string, type);
                if (hashMap != null) {
                    ArrayList arrayList = (ArrayList) hashMap.get(this.f46104b);
                    if (arrayList != null) {
                        if (arrayList.contains(this.f46105c)) {
                            arrayList.remove(this.f46105c);
                        } else if (arrayList.size() == 3) {
                            arrayList.remove(0);
                        }
                        arrayList.add(this.f46105c);
                        hashMap.put(this.f46104b, arrayList);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(this.f46105c);
                        hashMap.put(this.f46104b, arrayList2);
                    }
                    str = fVar.b(hashMap);
                } else {
                    HashMap hashMap2 = new HashMap();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(this.f46105c);
                    hashMap2.put(this.f46104b, arrayList3);
                    str = fVar.b(hashMap2);
                }
                a2.putString(Constants.USER_ID_NET_BANK_KEY, str);
                a2.apply();
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }

        class a extends com.google.gson.b.a<HashMap<String, ArrayList<String>>> {
            a() {
            }
        }
    }

    public static String c() {
        return new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ssZ", Locale.getDefault()).format(Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault()).getTime());
    }

    public static String d() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String e() {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it2 = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                return hostAddress;
                            }
                            int indexOf = hostAddress.indexOf(37);
                            return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}

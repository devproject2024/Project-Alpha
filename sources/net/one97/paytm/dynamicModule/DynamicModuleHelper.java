package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.k;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicModuleHelper {
    public static String downloadSourceActivity = "Activity";
    public static String downloadSourceBottomSheet = "BottomSheet";
    public static String downloadSourceFragment = "Fragment";
    private static Handler mHandler;

    public static void startInitialBackgroundInstall(Activity activity) {
    }

    public static ArrayList<String> getAllDynamicModulesList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ddbase");
        arrayList.add("passbook");
        arrayList.add("ddbase");
        arrayList.add("paytm_finance");
        arrayList.add("flight_dynamic");
        arrayList.add("paytm_finance");
        arrayList.add("paytm_finance");
        arrayList.add("movie");
        arrayList.add("ddbase");
        arrayList.add("ddbase");
        arrayList.add("feed");
        arrayList.add("ddbase");
        arrayList.add("ddbase");
        arrayList.add("paytm_finance");
        arrayList.add("paytm_finance");
        arrayList.add("flight_dynamic");
        return arrayList;
    }

    public static void startInitialDeferredInstall() {
        if (DynamicModuleUtils.getAvailableInternalMemorySizeInMB() >= 200) {
            c.a();
            if (c.a("isInitialDeferredInstallEnabled", true)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("ddbase");
                arrayList.add("ddbase");
                arrayList.add("passbook");
                arrayList.add("paytm_finance");
                arrayList.add("flight_dynamic");
                arrayList.add("paytm_finance");
                arrayList.add("paytm_finance");
                arrayList.add("movie");
                arrayList.add("ddbase");
                arrayList.add("feed");
                arrayList.add("chat");
                arrayList.add("paytm_finance");
                arrayList.add("flight_dynamic");
                DynamicModuleManager.getInstance().deferredInstall((ArrayList<String>) arrayList);
            }
        }
    }

    public static void loadAndLaunchModule(AppCompatActivity appCompatActivity, String str, String str2) {
        if (DynamicModuleManager.getInstance().isInstalled(str)) {
            Intent intent = new Intent();
            intent.setClassName(appCompatActivity, str2);
            appCompatActivity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(appCompatActivity, CommonDynamicLoaderActivity.class);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, str2);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, str);
        appCompatActivity.startActivity(intent2);
    }

    public static void loadModuleWithBottomSheet(AppCompatActivity appCompatActivity, String str, DynamicModuleLoaderListener dynamicModuleLoaderListener) {
        DynamicModuleLoaderBottomSheet newInstance = DynamicModuleLoaderBottomSheet.newInstance(str);
        newInstance.setListener(dynamicModuleLoaderListener);
        if (appCompatActivity != null && appCompatActivity.getLifecycle().a().isAtLeast(k.b.RESUMED)) {
            newInstance.show(appCompatActivity.getSupportFragmentManager(), "DynamicModuleLoaderBottomSheet");
        }
    }

    public static void loadModuleWithBottomSheet(AppCompatActivity appCompatActivity, String str, String str2) {
        DynamicModuleLoaderBottomSheet newInstance = DynamicModuleLoaderBottomSheet.newInstance(str, str2);
        if (appCompatActivity != null && appCompatActivity.getLifecycle().a().isAtLeast(k.b.RESUMED)) {
            newInstance.show(appCompatActivity.getSupportFragmentManager(), "DynamicModuleLoaderBottomSheet");
        }
    }

    public static void loadPlayCoreErrorBottomSheet(j jVar, String str, String str2, int i2, String str3) {
        try {
            DynamicModuleErrorBottomSheet newInstance = DynamicModuleErrorBottomSheet.newInstance(str, str2, i2, str3);
            if (jVar != null) {
                newInstance.show(jVar, "DynamicModuleErrorBottomSheet");
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> getPreRequisiteModuleDependencyList(java.lang.String r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r6.hashCode()
            r2 = -1336683695(0xffffffffb053d351, float:-7.706165E-10)
            r3 = 2
            r4 = 1
            java.lang.String r5 = "ddbase"
            if (r1 == r2) goto L_0x0031
            r2 = -807830852(0xffffffffcfd97abc, float:-7.2973988E9)
            if (r1 == r2) goto L_0x0027
            r2 = 104087344(0x6343f30, float:3.390066E-35)
            if (r1 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            java.lang.String r1 = "movie"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0039
            r6 = 1
            goto L_0x003a
        L_0x0027:
            java.lang.String r1 = "paytm_finance"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0039
            r6 = 2
            goto L_0x003a
        L_0x0031:
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x0039
            r6 = 0
            goto L_0x003a
        L_0x0039:
            r6 = -1
        L_0x003a:
            if (r6 == 0) goto L_0x004e
            if (r6 == r4) goto L_0x004a
            if (r6 == r3) goto L_0x0041
            goto L_0x0051
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r5)
            goto L_0x0051
        L_0x004a:
            r0.add(r5)
            goto L_0x0051
        L_0x004e:
            r0.add(r5)
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.DynamicModuleHelper.getPreRequisiteModuleDependencyList(java.lang.String):java.util.ArrayList");
    }

    public static String getModuleIconUrl(String str) {
        try {
            return new JSONObject(DynamicModuleUtils.loadJSONFromAsset(CJRJarvisApplication.getAppContext(), "dfm_icon_urls.json")).getString(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getModuleTitle(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1336683695: goto L_0x0044;
                case -807830852: goto L_0x003a;
                case 3052376: goto L_0x0030;
                case 3138974: goto L_0x0026;
                case 104087344: goto L_0x001c;
                case 630397808: goto L_0x0012;
                case 1216360058: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "passbook"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "flight_dynamic"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 4
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "movie"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "feed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 5
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "chat"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "paytm_finance"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "ddbase"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            switch(r1) {
                case 0: goto L_0x006e;
                case 1: goto L_0x006a;
                case 2: goto L_0x0066;
                case 3: goto L_0x0062;
                case 4: goto L_0x005e;
                case 5: goto L_0x005a;
                case 6: goto L_0x0056;
                default: goto L_0x0052;
            }
        L_0x0052:
            r1 = 2131960893(0x7f13243d, float:1.9558468E38)
            goto L_0x0071
        L_0x0056:
            r1 = 2131963877(0x7f132fe5, float:1.956452E38)
            goto L_0x0071
        L_0x005a:
            r1 = 2131963886(0x7f132fee, float:1.9564538E38)
            goto L_0x0071
        L_0x005e:
            r1 = 2131963883(0x7f132feb, float:1.9564532E38)
            goto L_0x0071
        L_0x0062:
            r1 = 2131963907(0x7f133003, float:1.956458E38)
            goto L_0x0071
        L_0x0066:
            r1 = 2131963909(0x7f133005, float:1.9564585E38)
            goto L_0x0071
        L_0x006a:
            r1 = 2131963900(0x7f132ffc, float:1.9564566E38)
            goto L_0x0071
        L_0x006e:
            r1 = 2131963903(0x7f132fff, float:1.9564573E38)
        L_0x0071:
            android.content.Context r0 = net.one97.paytm.app.CJRJarvisApplication.getAppContext()
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r1 = r0.getString(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.DynamicModuleHelper.getModuleTitle(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getModuleIcon(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1336683695: goto L_0x0044;
                case -807830852: goto L_0x003a;
                case 3052376: goto L_0x0030;
                case 3138974: goto L_0x0026;
                case 104087344: goto L_0x001c;
                case 630397808: goto L_0x0012;
                case 1216360058: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "passbook"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "flight_dynamic"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 4
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "movie"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "feed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 5
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "chat"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "paytm_finance"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "ddbase"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            switch(r1) {
                case 0: goto L_0x006e;
                case 1: goto L_0x006a;
                case 2: goto L_0x0066;
                case 3: goto L_0x0062;
                case 4: goto L_0x005e;
                case 5: goto L_0x005a;
                case 6: goto L_0x0056;
                default: goto L_0x0052;
            }
        L_0x0052:
            r1 = 2131232535(0x7f080717, float:1.8081182E38)
            goto L_0x0071
        L_0x0056:
            r1 = 2131232156(0x7f08059c, float:1.8080413E38)
            goto L_0x0071
        L_0x005a:
            r1 = 2131232231(0x7f0805e7, float:1.8080565E38)
            goto L_0x0071
        L_0x005e:
            r1 = 2131232234(0x7f0805ea, float:1.8080571E38)
            goto L_0x0071
        L_0x0062:
            r1 = 2131232230(0x7f0805e6, float:1.8080563E38)
            goto L_0x0071
        L_0x0066:
            r1 = 2131232232(0x7f0805e8, float:1.8080567E38)
            goto L_0x0071
        L_0x006a:
            r1 = 2131232513(0x7f080701, float:1.8081137E38)
            goto L_0x0071
        L_0x006e:
            r1 = 2131232225(0x7f0805e1, float:1.8080553E38)
        L_0x0071:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.DynamicModuleHelper.getModuleIcon(java.lang.String):int");
    }

    static void sendEvents(Context context, DynamicModuleLoaderItem dynamicModuleLoaderItem, boolean z) {
        au.e eVar = new au.e();
        au.a aVar = new au.a();
        aVar.f69670a = dynamicModuleLoaderItem.getName();
        aVar.f69676g = l.b();
        if (dynamicModuleLoaderItem.getSize() != -5000) {
            aVar.f69671b = String.valueOf(dynamicModuleLoaderItem.getSize());
        }
        if (dynamicModuleLoaderItem.getStatusCode() != -5000) {
            aVar.f69672c = String.valueOf(dynamicModuleLoaderItem.getStatusCode());
        }
        if (dynamicModuleLoaderItem.getErrorCode() != -5000 || z) {
            aVar.f69673d = String.valueOf(dynamicModuleLoaderItem.getErrorCode());
        }
        if (dynamicModuleLoaderItem.getDownloadTime() != -5000) {
            aVar.f69674e = String.valueOf(dynamicModuleLoaderItem.getDownloadTime());
        }
        if (dynamicModuleLoaderItem.getFailureDump() != null) {
            aVar.f69675f = dynamicModuleLoaderItem.getFailureDump();
        }
        eVar.x = aVar;
        au.a(eVar, au.c.DFMLog.stringValue, context);
    }

    static void sendEvents(Context context, String str, int i2, int i3, String str2) {
        au.e eVar = new au.e();
        au.a aVar = new au.a();
        aVar.f69670a = str;
        aVar.f69676g = l.b();
        if (i2 != -5000) {
            aVar.f69672c = String.valueOf(i2);
        }
        if (i3 != -5000) {
            aVar.f69673d = String.valueOf(i3);
        }
        if (str2 != null) {
            aVar.f69675f = str2;
        }
        eVar.x = aVar;
        au.a(eVar, au.c.DFMLog.stringValue, context);
    }
}

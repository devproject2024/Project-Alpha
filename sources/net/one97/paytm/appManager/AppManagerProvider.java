package net.one97.paytm.appManager;

import com.paytm.utility.q;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.appManager.d.a;
import net.one97.paytm.appManager.d.b;
import net.one97.paytm.utils.au;

public class AppManagerProvider implements b {
    private static AppManagerProvider mInstance;

    public String getAuthValue() {
        return "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=";
    }

    public String getFetchDataURL() {
        return "https://appmanager.paytm.com/paytm/v1/getkeys?";
    }

    public String getLocalRawFileName() {
        return "release/rawData";
    }

    public static void init() {
        if (mInstance == null) {
            mInstance = new AppManagerProvider();
        }
        a.a(mInstance);
    }

    public void logHawkeyeEvent(String str) {
        try {
            au.e eVar = new au.e();
            au.b bVar = new au.b();
            bVar.f69678b = str;
            eVar.y = bVar;
            eVar.f69690e = au.c.DeepLinkLog.stringValue;
            au.a(eVar, au.c.DeepLinkLog.stringValue, CJRJarvisApplication.getAppContext());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}

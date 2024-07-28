package net.one97.paytm.q;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.utils.au;

public final class b {
    public static void a(au.e eVar, au.c cVar) {
        try {
            eVar.f69687b = "9.1.3";
            eVar.f69688c = "720656";
            eVar.f69690e = cVar.toString();
            eVar.k = com.paytm.erroranalytics.b.b.c(CJRJarvisApplication.getAppContext());
            eVar.j = com.paytm.erroranalytics.b.b.a();
            eVar.f69693h = com.paytm.erroranalytics.b.b.b(CJRJarvisApplication.getAppContext());
            eVar.f69689d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
            eVar.f69693h = com.paytm.erroranalytics.b.b.b(CJRJarvisApplication.getAppContext());
            eVar.l = "androidapp";
        } catch (Exception unused) {
        }
        au.a(eVar, cVar.stringValue, CJRJarvisApplication.getAppContext());
    }
}

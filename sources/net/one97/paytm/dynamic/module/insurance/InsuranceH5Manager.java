package net.one97.paytm.dynamic.module.insurance;

import android.app.Application;
import net.one97.paytm.h5.c;
import net.one97.paytm.insurance.H5.a;

public class InsuranceH5Manager {
    private String MODULE_NAME = "Insurance";
    private boolean isAlreadyInit = false;

    /* access modifiers changed from: package-private */
    public void init(Application application) {
        if (!this.isAlreadyInit) {
            c cVar = c.f50543a;
            c.a("insurance", new c.b(application) {
                private final /* synthetic */ Application f$0;

                {
                    this.f$0 = r1;
                }

                public final void provideValuesForKeys(String str, c.C0910c cVar) {
                    InsuranceH5Manager.lambda$init$0(this.f$0, str, cVar);
                }
            });
            this.isAlreadyInit = true;
        }
    }

    static /* synthetic */ void lambda$init$0(Application application, String str, c.C0910c cVar) {
        String[] split;
        if (str != null) {
            if ((str.contains("gtm") || str.contains("GTM")) && (split = str.split("\\.")) != null && split.length > 1) {
                cVar.onResult(net.one97.paytm.insurance.b.c.a().getStringFromGTM(split[1]));
            }
            if (str.equalsIgnoreCase("authData")) {
                a aVar = a.f13985a;
                cVar.onResult(a.a(application.getApplicationContext()));
            }
            if (str.equalsIgnoreCase("appData")) {
                a aVar2 = a.f13985a;
                cVar.onResult(a.a(application.getApplicationContext()));
            }
            cVar.onResult("");
        }
        cVar.onResult((Object) null);
    }
}

package net.one97.paytm.dynamic.module.movie;

import android.app.Application;
import android.content.Context;
import com.paytm.utility.a;
import com.paytm.utility.b;
import kotlin.g.b.k;
import net.one97.paytm.h5.c;

public final class EventsModuleManager$init$1 implements c.b {
    final /* synthetic */ Application $application;
    final /* synthetic */ EventsModuleManager this$0;

    EventsModuleManager$init$1(EventsModuleManager eventsModuleManager, Application application) {
        this.this$0 = eventsModuleManager;
        this.$application = application;
    }

    public final void provideValuesForKeys(String str, c.C0910c cVar) {
        k.c(str, "key");
        switch (str.hashCode()) {
            case -2035625137:
                if (str.equals("jsVersion")) {
                    if (cVar != null) {
                        cVar.onResult(EventUtility.getJsVersion());
                        return;
                    }
                    return;
                }
                break;
            case -1638015529:
                if (str.equals("emailId")) {
                    if (cVar != null) {
                        cVar.onResult(a.c((Context) this.$application));
                        return;
                    }
                    return;
                }
                break;
            case -1581184615:
                if (str.equals("customerId")) {
                    if (cVar != null) {
                        cVar.onResult(a.a((Context) this.$application));
                        return;
                    }
                    return;
                }
                break;
            case -1459599807:
                if (str.equals("lastName")) {
                    if (cVar != null) {
                        cVar.onResult(b.i((Context) this.$application));
                        return;
                    }
                    return;
                }
                break;
            case -1400970552:
                if (str.equals("buildType")) {
                    if (cVar != null) {
                        cVar.onResult(net.one97.paytm.deeplink.k.c());
                        return;
                    }
                    return;
                }
                break;
            case -1192969641:
                if (str.equals("phoneNumber")) {
                    if (cVar != null) {
                        cVar.onResult(a.b((Context) this.$application));
                        return;
                    }
                    return;
                }
                break;
            case 132835675:
                if (str.equals("firstName")) {
                    if (cVar != null) {
                        cVar.onResult(b.h((Context) this.$application));
                        return;
                    }
                    return;
                }
                break;
            case 620238606:
                if (str.equals("encryptedSsoToken")) {
                    this.this$0.getEncryptedSsoTokeFromApi(this.$application, cVar);
                    return;
                }
                break;
            case 1326405379:
                if (str.equals("fixVersion")) {
                    if (cVar != null) {
                        cVar.onResult(EventUtility.getFixVersion());
                        return;
                    }
                    return;
                }
                break;
        }
        if (cVar != null) {
            cVar.onResult("");
        }
    }
}

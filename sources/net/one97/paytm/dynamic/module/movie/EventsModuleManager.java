package net.one97.paytm.dynamic.module.movie;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.g;
import net.one97.paytm.deeplink.k;
import net.one97.paytm.h5.c;
import net.one97.paytm.utils.t;

public final class EventsModuleManager implements k.a {
    public static final Companion Companion = new Companion((g) null);
    public static final String MODULE_NAME = "events";
    public static final String TAG = "EventsModuleManager";
    private boolean isAlreadyInit;

    public final void launchBookingEventDetail(Context context, String str, String str2) {
    }

    public final void launchFullGalleryView(Context context, String str, boolean z) {
    }

    public final void launchFullMapActivity(Context context, String str) {
    }

    public final void launchGalleryView(Context context, String[] strArr, int i2) {
    }

    public final void launchVideo(Context context, String str) {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        k.a((k.a) new EventsModuleManager());
    }

    public final boolean isAlreadyInit() {
        return this.isAlreadyInit;
    }

    public final void setAlreadyInit(boolean z) {
        this.isAlreadyInit = z;
    }

    public final void init(Application application) {
        kotlin.g.b.k.c(application, "application");
        if (!this.isAlreadyInit) {
            c cVar = c.f50543a;
            c.a(MODULE_NAME, new EventsModuleManager$init$1(this, application));
            this.isAlreadyInit = true;
        }
    }

    /* access modifiers changed from: private */
    public final void getEncryptedSsoTokeFromApi(Application application, c.C0910c cVar) {
        Context context = application;
        if (TextUtils.isEmpty(t.a(context))) {
            net.one97.paytm.j.c.a();
            new b().a(context).a(a.c.EVENT).a(a.C0715a.GET).a(net.one97.paytm.j.c.a("encryptedTokenUrl")).a((Map<String, String>) com.paytm.utility.b.ah(context)).a((IJRPaytmDataModel) new EncryptedSSOToken()).a((com.paytm.network.listener.b) new EventsModuleManager$getEncryptedSsoTokeFromApi$tokenNetworkRequest$1(cVar)).a(a.b.SILENT).c(TAG).l().a();
        } else if (cVar != null) {
            cVar.onResult(t.a(context));
        }
    }
}

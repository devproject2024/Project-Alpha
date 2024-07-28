package net.one97.paytm.phoenix.manager;

import android.app.Activity;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.c;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.api.e;

public final class SessionPluginManager implements p, e {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f59595a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Activity f59596b;

    public final void a(c cVar) {
        k.c(cVar, "eventFilter");
    }

    public SessionPluginManager(Activity activity) {
        this.f59596b = activity;
    }

    public final boolean a(d dVar) {
        k.c(dVar, "plugin");
        c cVar = new c();
        dVar.a(cVar);
        Iterator<String> a2 = cVar.a();
        while (a2.hasNext()) {
            this.f59595a.put(a2.next(), dVar);
        }
        return true;
    }

    public final boolean b(d dVar) {
        k.c(dVar, "plugin");
        c cVar = new c();
        dVar.a(cVar);
        Iterator<String> a2 = cVar.a();
        while (a2.hasNext()) {
            this.f59595a.remove(a2.next());
        }
        return true;
    }

    public final boolean a(Activity activity, String str) {
        k.c(activity, "activity");
        k.c(str, "actionName");
        return this.f59595a.get(str) != null;
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        d dVar = (d) this.f59595a.get(h5Event.getBridgeName());
        return dVar != null && dVar.a(h5Event, bVar);
    }

    @aa(a = k.a.ON_DESTROY)
    public final void clearSession() {
        this.f59595a.clear();
        this.f59596b = null;
    }
}

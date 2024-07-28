package net.one97.paytm.h5.a;

import android.app.Activity;
import com.alibaba.a.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.j.c;

public final class f extends ad {

    /* renamed from: a  reason: collision with root package name */
    private H5BridgeContext f16845a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f() {
        super(e.p);
        e.a aVar = e.f16836a;
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        Object obj;
        super.handleEvent(h5Event, h5BridgeContext);
        if (a(h5Event)) {
            this.f16845a = h5BridgeContext;
            if (!(h5Event == null || h5Event == null || (activity = h5Event.getActivity()) == null)) {
                String action = h5Event.getAction();
                e.a aVar = e.f16836a;
                if (k.a((Object) action, (Object) e.p)) {
                    b bVar = null;
                    com.alibaba.a.e param = h5Event.getParam();
                    if (!(param == null || (obj = param.get("keys")) == null || !(obj instanceof b))) {
                        bVar = (b) obj;
                    }
                    e.a aVar2 = e.f16836a;
                    if (!e.a.a(this.f16845a, activity, "whitelisted_aids_configkeys", 8)) {
                        Collection collection = bVar;
                        boolean z = collection == null || collection.isEmpty();
                        if (bVar != null) {
                            Iterator<Object> it2 = bVar.iterator();
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                if (next instanceof String) {
                                    if (!(((CharSequence) next).length() == 0)) {
                                    }
                                }
                                z = true;
                            }
                        }
                        if (z) {
                            e.a aVar3 = e.f16836a;
                            e.a.a(Integer.valueOf(H5Event.Error.NOT_FOUND.ordinal()), "Key not found", this.f16845a);
                        }
                        if (!z) {
                            if (bVar == null) {
                                k.a();
                            }
                            com.alibaba.a.e eVar = new com.alibaba.a.e();
                            Iterator<Object> it3 = bVar.iterator();
                            while (it3.hasNext()) {
                                String str = (String) it3.next();
                                c.a();
                                eVar.put(str, (Object) c.a(str));
                            }
                            a((Object) eVar);
                        }
                    }
                }
            }
        }
        return true;
    }
}

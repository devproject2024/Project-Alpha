package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.smssdk.b.b;

public final class q extends ad {

    /* renamed from: a  reason: collision with root package name */
    private H5BridgeContext f16916a;

    /* renamed from: d  reason: collision with root package name */
    private final b f16917d = new a(this);

    public q() {
        super("paytmGetConsent", "paytmUpdateConsent");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        String action;
        boolean z;
        super.handleEvent(h5Event, h5BridgeContext);
        if (a(h5Event)) {
            this.f16916a = h5BridgeContext;
            if (!(h5Event == null || (activity = h5Event.getActivity()) == null || (action = h5Event.getAction()) == null)) {
                int hashCode = action.hashCode();
                Object obj = null;
                if (hashCode != 539521904) {
                    if (hashCode == 1881855973 && action.equals("paytmGetConsent")) {
                        e param = h5Event.getParam();
                        if (param != null) {
                            obj = param.get("consent_keys");
                        }
                        if (obj == null) {
                            if (h5BridgeContext != null) {
                                h5BridgeContext.sendError(3, "Unable to process your request,Param Missing");
                            }
                            return false;
                        }
                        Context context = activity;
                        com.alibaba.a.b bVar = (com.alibaba.a.b) obj;
                        k.c(context, "context");
                        k.c(bVar, "consentKeys");
                        ArrayList arrayList = new ArrayList();
                        Iterator<Object> it2 = bVar.iterator();
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            if (next != null) {
                                arrayList.add((String) next);
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        net.one97.paytm.smssdk.b bVar2 = net.one97.paytm.smssdk.b.f65064b;
                        net.one97.paytm.smssdk.b.a(context, arrayList, this.f16917d);
                    }
                } else if (action.equals("paytmUpdateConsent")) {
                    e param2 = h5Event.getParam();
                    if (param2 != null) {
                        obj = param2.get("consent_keys");
                    }
                    if (obj == null) {
                        if (h5BridgeContext != null) {
                            h5BridgeContext.sendError(3, "Unable to process your request,Param Missing");
                        }
                        return false;
                    }
                    com.alibaba.a.b bVar3 = (com.alibaba.a.b) obj;
                    if (bVar3.size() > 1) {
                        Context context2 = activity;
                        k.c(context2, "context");
                        k.c(bVar3, "consentKeys");
                        if (bVar3.get(1) instanceof Boolean) {
                            Object obj2 = bVar3.get(1);
                            if (obj2 != null) {
                                z = ((Boolean) obj2).booleanValue();
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        } else {
                            z = false;
                        }
                        net.one97.paytm.smssdk.b bVar4 = net.one97.paytm.smssdk.b.f65064b;
                        Object obj3 = bVar3.get(0);
                        if (obj3 != null) {
                            net.one97.paytm.smssdk.b.a(context2, (String) obj3, z, this.f16917d);
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        if (h5BridgeContext != null) {
                            h5BridgeContext.sendError(3, "Unable to process your request,Two Param required as String and Boolean");
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f16918a;

        a(q qVar) {
            this.f16918a = qVar;
        }

        public final void a(boolean z, int i2, String str) {
            if (z) {
                q.a(this.f16918a, new e());
            } else {
                q.a(this.f16918a, i2, str);
            }
        }

        public final void a(Map<String, Boolean> map, int i2, String str) {
            if (map == null || map.isEmpty()) {
                if (str == null) {
                    str = "Unable to process your request";
                }
                q.a(this.f16918a, i2, str);
                return;
            }
            q.a(this.f16918a, new e((Map<String, Object>) map));
        }
    }

    public static final /* synthetic */ void a(q qVar, e eVar) {
        e eVar2 = new e();
        eVar2.put("success", (Object) Boolean.TRUE);
        eVar2.put("data", (Object) eVar);
        H5BridgeContext h5BridgeContext = qVar.f16916a;
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult(eVar2);
        }
    }

    public static final /* synthetic */ void a(q qVar, int i2, String str) {
        e eVar = new e();
        eVar.put("message", (Object) str);
        eVar.put("error", (Object) Integer.valueOf(i2));
        eVar.put("success", (Object) Boolean.FALSE);
        H5BridgeContext h5BridgeContext = qVar.f16916a;
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }
}

package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import com.alibaba.a.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import net.one97.paytm.utils.l;

public final class g extends ad {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public H5BridgeContext f16846a;

    /* renamed from: d  reason: collision with root package name */
    private String f16847d = "accounts";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g() {
        super(e.r);
        e.a aVar = e.f16836a;
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        this.f16846a = h5BridgeContext;
        if (h5Event == null || (activity = h5Event.getActivity()) == null) {
            return true;
        }
        String action = h5Event.getAction();
        e.a aVar = e.f16836a;
        if (!k.a((Object) action, (Object) e.r)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CONTACTS");
        e.a aVar2 = e.f16836a;
        if (e.a.a((ArrayList<String>) arrayList, activity)) {
            a(activity);
            return true;
        } else if (activity != null) {
            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                paytmH5Activity.f17103a.addObserver(new a(this, paytmH5Activity));
                paytmH5Activity.a((String[]) array);
                return true;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
        }
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity) {
        e.a aVar = e.f16836a;
        if (!e.a.a(this.f16846a, activity, "whitelisted_aids_deviceAccount", true)) {
            b(activity);
        }
    }

    private final void b(Activity activity) {
        com.alibaba.a.e eVar = new com.alibaba.a.e();
        eVar.put("success", (Object) Boolean.TRUE);
        eVar.put(this.f16847d, (Object) activity != null ? a((Context) activity) : null);
        a((Object) eVar);
    }

    private static b a(Context context) {
        b bVar = new b();
        ArrayList<DeviceAccount> d2 = l.d(context);
        k.a((Object) d2, "CJRAppUtility.getDeviceAccounts(context)");
        Iterator<DeviceAccount> it2 = d2.iterator();
        while (it2.hasNext()) {
            bVar.add(it2.next().getValue());
        }
        return bVar;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16848a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f16849b;

        a(g gVar, PaytmH5Activity paytmH5Activity) {
            this.f16848a = gVar;
            this.f16849b = paytmH5Activity;
        }

        public final void update(Observable observable, Object obj) {
            g gVar = this.f16848a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    Object[] objArr = (Object[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        int length = objArr.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = i3 + 1;
                            if (iArr[i3] == 0) {
                                gVar.a((Activity) this.f16849b);
                            } else {
                                e.a aVar = e.f16836a;
                                e.a.a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", gVar.f16846a);
                            }
                            i2++;
                            i3 = i4;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                e.a aVar2 = e.f16836a;
                e.a.a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", gVar.f16846a);
            }
            this.f16849b.f17103a.deleteObservers();
        }
    }
}

package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.d;
import net.one97.paytm.utils.l;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    b f19807a;

    /* renamed from: b  reason: collision with root package name */
    H5Event f19808b;

    /* renamed from: c  reason: collision with root package name */
    private String f19809c = "accounts";

    public j() {
        super("paytmFetchDeviceAccounts");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f19807a = bVar;
        this.f19808b = h5Event;
        Activity activity = h5Event.getActivity();
        if (activity == null || (bridgeName = h5Event.getBridgeName()) == null || bridgeName.hashCode() != -1917246763 || !bridgeName.equals("paytmFetchDeviceAccounts")) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CONTACTS");
        d.a aVar = d.f19890a;
        if (d.a.a(arrayList, activity)) {
            a(activity);
            return true;
        } else if (activity != null) {
            PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                phoenixActivity.g().addObserver(new a(this, phoenixActivity));
                phoenixActivity.a((String[]) array);
                return true;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Activity activity) {
        d.a aVar = d.f19890a;
        if (!d.a.a(this.f19808b, this.f19807a, activity, "whitelisted_aids_deviceAccount", true)) {
            b(activity);
        }
    }

    private final void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", true);
        jSONObject.put(this.f19809c, activity != null ? a((Context) activity) : null);
        H5Event h5Event = this.f19808b;
        if (h5Event != null) {
            net.one97.paytm.phoenix.core.a.a(this, h5Event, jSONObject, false, 4);
        }
    }

    private static JSONArray a(Context context) {
        JSONArray jSONArray = new JSONArray();
        ArrayList<DeviceAccount> d2 = l.d(context);
        k.a((Object) d2, "CJRAppUtility.getDeviceAccounts(context)");
        Iterator<DeviceAccount> it2 = d2.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().getValue());
        }
        return jSONArray;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f19810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19811b;

        a(j jVar, PhoenixActivity phoenixActivity) {
            this.f19810a = jVar;
            this.f19811b = phoenixActivity;
        }

        public final void update(Observable observable, Object obj) {
            j jVar = this.f19810a;
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
                                jVar.a((Activity) this.f19811b);
                            } else {
                                d.a aVar = d.f19890a;
                                d.a.a(jVar.f19808b, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", jVar.f19807a);
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
                d.a aVar2 = d.f19890a;
                d.a.a(jVar.f19808b, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", jVar.f19807a);
            }
            this.f19811b.g().deleteObservers();
        }
    }
}

package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.util.d;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    b f19834a;

    /* renamed from: b  reason: collision with root package name */
    H5Event f19835b;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.smssdk.b.b f19836c = new a(this);

    public n() {
        super("paytmGetConsent", "paytmUpdateConsent");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        boolean z;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f19834a = bVar;
        this.f19835b = h5Event;
        Activity activity = h5Event.getActivity();
        if (!(activity == null || (bridgeName = h5Event.getBridgeName()) == null)) {
            int hashCode = bridgeName.hashCode();
            Object obj = null;
            int i2 = 0;
            if (hashCode != 539521904) {
                if (hashCode == 1881855973 && bridgeName.equals("paytmGetConsent")) {
                    JSONObject params = h5Event.getParams();
                    if (params != null) {
                        obj = params.get("consent_keys");
                    }
                    if (obj == null) {
                        bVar.a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal(), "Unable to process your request,Param Missing");
                        return false;
                    }
                    Context context = activity;
                    JSONArray jSONArray = (JSONArray) obj;
                    k.c(context, "context");
                    k.c(jSONArray, "consentKeys");
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length() - 1;
                    if (length >= 0) {
                        while (true) {
                            arrayList.add(jSONArray.getString(i2));
                            if (i2 == length) {
                                break;
                            }
                            i2++;
                        }
                    }
                    net.one97.paytm.smssdk.b bVar2 = net.one97.paytm.smssdk.b.f65064b;
                    net.one97.paytm.smssdk.b.a(context, arrayList, this.f19836c);
                }
            } else if (bridgeName.equals("paytmUpdateConsent")) {
                JSONObject params2 = h5Event.getParams();
                if (params2 != null) {
                    obj = params2.get("consent_keys");
                }
                if (obj == null) {
                    bVar.a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal(), "Unable to process your request,Param Missing");
                    return false;
                }
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() > 1) {
                    Context context2 = activity;
                    k.c(context2, "context");
                    k.c(jSONArray2, "consentKeys");
                    if (jSONArray2.get(1) instanceof Boolean) {
                        Object obj2 = jSONArray2.get(1);
                        if (obj2 != null) {
                            z = ((Boolean) obj2).booleanValue();
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.Boolean");
                        }
                    } else {
                        z = false;
                    }
                    net.one97.paytm.smssdk.b bVar3 = net.one97.paytm.smssdk.b.f65064b;
                    Object obj3 = jSONArray2.get(0);
                    if (obj3 != null) {
                        net.one97.paytm.smssdk.b.a(context2, (String) obj3, z, this.f19836c);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    bVar.a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal(), "Unable to process your request,Two Param required as String and Boolean");
                    return false;
                }
            }
        }
        return true;
    }

    public static final class a implements net.one97.paytm.smssdk.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f19837a;

        a(n nVar) {
            this.f19837a = nVar;
        }

        public final void a(boolean z, int i2, String str) {
            if (z) {
                H5Event h5Event = this.f19837a.f19835b;
                if (h5Event != null) {
                    d.a aVar = d.f19890a;
                    d.a.a(h5Event, new JSONObject(), this.f19837a.f19834a);
                    return;
                }
                return;
            }
            d.a aVar2 = d.f19890a;
            H5Event h5Event2 = this.f19837a.f19835b;
            Integer valueOf = Integer.valueOf(i2);
            if (str == null) {
                str = "";
            }
            d.a.a(h5Event2, valueOf, str, this.f19837a.f19834a);
        }

        public final void a(Map<String, Boolean> map, int i2, String str) {
            if (map == null || map.isEmpty()) {
                if (str == null) {
                    str = "Unable to process your request";
                }
                d.a aVar = d.f19890a;
                H5Event h5Event = this.f19837a.f19835b;
                Integer valueOf = Integer.valueOf(i2);
                if (str == null) {
                    str = "";
                }
                d.a.a(h5Event, valueOf, str, this.f19837a.f19834a);
                return;
            }
            H5Event h5Event2 = this.f19837a.f19835b;
            if (h5Event2 != null) {
                d.a aVar2 = d.f19890a;
                d.a.a(h5Event2, new JSONObject(map), this.f19837a.f19834a);
            }
        }
    }
}

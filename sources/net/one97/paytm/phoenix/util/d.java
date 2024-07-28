package net.one97.paytm.phoenix.util;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.provider.PhoenixWhiteListAppDataProviderImpl;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19890a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(H5Event h5Event, JSONObject jSONObject, b bVar) {
            k.c(jSONObject, "dataJson");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", true);
            jSONObject2.put("data", jSONObject);
            if (h5Event != null && bVar != null) {
                bVar.a(h5Event, jSONObject2);
            }
        }

        public static void a(H5Event h5Event, Object obj, String str, b bVar) {
            k.c(obj, "error");
            k.c(str, "errorMsg");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", obj);
            jSONObject.put("message", str);
            jSONObject.put("success", false);
            if (h5Event != null && bVar != null) {
                bVar.a(h5Event, jSONObject);
            }
        }

        public static boolean a(ArrayList<String> arrayList, Activity activity) {
            k.c(arrayList, "permissionsToCheck");
            k.c(activity, "activity");
            for (String a2 : arrayList) {
                if (androidx.core.content.b.a((Context) activity, a2) == 0) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ boolean a(H5Event h5Event, b bVar, Activity activity, String str, int i2) {
            if ((i2 & 8) != 0) {
                str = null;
            }
            return a(h5Event, bVar, activity, str, false);
        }

        public static boolean a(H5Event h5Event, b bVar, Activity activity, String str, boolean z) {
            k.c(activity, "activity");
            if (str == null || new PhoenixWhiteListAppDataProviderImpl().isAppWhitelisted(((PhoenixActivity) activity).f(), str)) {
                if (!z) {
                    CharSequence q = com.paytm.utility.a.q(activity);
                    if (q == null || q.length() == 0) {
                        a(h5Event, 10, "user not logged in", bVar);
                        return true;
                    }
                }
                if (z || com.paytm.utility.b.c((Context) activity)) {
                    return false;
                }
                a(h5Event, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", bVar);
                return true;
            }
            a(h5Event, Integer.valueOf(net.one97.paytm.phoenix.api.a.FORBIDDEN.ordinal()), "Not authorized", bVar);
            return true;
        }
    }
}

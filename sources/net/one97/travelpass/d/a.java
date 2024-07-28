package net.one97.travelpass.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.travelpass.model.MyPassesResponse;
import net.one97.travelpass.model.TPAboutResponse;
import net.one97.travelpass.model.TravelPass;
import org.json.JSONObject;

public final class a {
    public static HashMap<String, String> a(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AppConstants.SSO_TOKEN, d.a(context));
        return hashMap;
    }

    public static void a(Context context, b bVar) {
        com.paytm.network.b bVar2;
        k.c(context, "context");
        k.c(bVar, "paytmCommonApiListener");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        String a2 = net.one97.travelpass.d.b().a("tpassFetchCards");
        if (TextUtils.isEmpty(a2) || context == null) {
            bVar2 = null;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.putAll(a(context));
            bVar2 = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_home").a(a.C0715a.GET).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new TravelPass()).a(bVar);
        }
        if (bVar2 != null) {
            com.paytm.network.a l = bVar2.l();
            if (l != null) {
                l.b(true);
            }
            if (l != null) {
                l.a();
                return;
            }
            return;
        }
        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }

    public static void b(Context context, b bVar) {
        com.paytm.network.b bVar2;
        k.c(context, "context");
        k.c(bVar, "paytmCommonApiListener");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        String a2 = net.one97.travelpass.d.b().a("tpassMyPass");
        HashMap hashMap = new HashMap();
        hashMap.putAll(a(context));
        if (TextUtils.isEmpty(a2) || context == null) {
            bVar2 = null;
        } else {
            new JSONObject();
            bVar2 = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_my_passes").a(a.C0715a.GET).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new MyPassesResponse()).a(bVar);
        }
        if (bVar2 != null) {
            com.paytm.network.a l = bVar2.l();
            if (l != null) {
                l.b(true);
            }
            if (l != null) {
                l.a();
                return;
            }
            return;
        }
        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }

    public static void c(Context context, b bVar) {
        com.paytm.network.b bVar2;
        k.c(context, "context");
        k.c(bVar, "paytmCommonApiListener");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        String a2 = net.one97.travelpass.d.b().a("tpassAboutInfo");
        if (TextUtils.isEmpty(a2) || context == null) {
            bVar2 = null;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.putAll(a(context));
            bVar2 = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_home").a(a.C0715a.GET).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new TPAboutResponse()).a(bVar);
        }
        if (bVar2 != null) {
            com.paytm.network.a l = bVar2.l();
            if (l != null) {
                l.b(true);
            }
            if (l != null) {
                l.a();
                return;
            }
            return;
        }
        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }
}

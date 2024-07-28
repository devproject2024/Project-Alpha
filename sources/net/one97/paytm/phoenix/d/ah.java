package net.one97.paytm.phoenix.d;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProvider;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProviderCallback;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ah extends net.one97.paytm.phoenix.core.a {
    public ah() {
        super("paytmFetchValuesForKeys");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        if (a(h5Event)) {
            x.e eVar = new x.e();
            f b2 = c.f59399a.b();
            String name = FetchValuesForKeysProvider.class.getName();
            k.a((Object) name, "FetchValuesForKeysProvider::class.java.name");
            eVar.element = (FetchValuesForKeysProvider) b2.a(name);
            if (((FetchValuesForKeysProvider) eVar.element) == null) {
                eVar.element = PhoenixManager.INSTANCE.getTempFetchValueForProvider(h5Event.getActivity());
                if (((FetchValuesForKeysProvider) eVar.element) == null) {
                    j jVar = j.f59646a;
                    j.b("PhoenixFetchValuesForKeysPlugin", "dataProvider:" + ((FetchValuesForKeysProvider) eVar.element));
                    a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'FetchValuesForKeysProvider'");
                    return false;
                }
            }
            j jVar2 = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "dataProvider:" + ((FetchValuesForKeysProvider) eVar.element));
            JSONObject params = h5Event.getParams();
            j jVar3 = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "params:" + String.valueOf(params));
            JSONArray optJSONArray = params != null ? params.optJSONArray("keys") : null;
            j jVar4 = j.f59646a;
            StringBuilder sb = new StringBuilder("keysArray Size:");
            sb.append(optJSONArray != null ? Integer.valueOf(optJSONArray.length()) : null);
            j.b("PhoenixFetchValuesForKeysPlugin", sb.toString());
            if (optJSONArray != null && optJSONArray.length() == 1) {
                Object obj = optJSONArray.get(0);
                if (obj instanceof String) {
                    ((FetchValuesForKeysProvider) eVar.element).provideValuesForKeys((String) obj, new b(this, obj, h5Event));
                }
            } else if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Object opt = optJSONArray.opt(i2);
                    if (opt instanceof String) {
                        j jVar5 = j.f59646a;
                        j.b("PhoenixFetchValuesForKeysPlugin", "key is String".concat(String.valueOf(opt)));
                        ((FetchValuesForKeysProvider) eVar.element).provideValuesForKeys((String) opt, new a(opt, this, eVar, h5Event));
                    }
                }
                j jVar6 = j.f59646a;
                j.b("PhoenixFetchValuesForKeysPlugin", "sendSuccessResult");
                net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, false, 6);
            }
        }
        return true;
    }

    public static final class b implements FetchValuesForKeysProviderCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ah f59494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f59495b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f59496c;

        b(ah ahVar, Object obj, H5Event h5Event) {
            this.f59494a = ahVar;
            this.f59495b = obj;
            this.f59496c = h5Event;
        }

        public final void onResult(Object obj) {
            Object a2 = ah.a(obj, (String) this.f59495b);
            ah ahVar = this.f59494a;
            String str = (String) this.f59495b;
            if (a2 == null) {
                a2 = "";
            }
            ahVar.a(str, a2);
            net.one97.paytm.phoenix.core.a.a(this.f59494a, this.f59496c, (Object) null, false, 6);
        }
    }

    public static final class a implements FetchValuesForKeysProviderCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f59490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ah f59491b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f59492c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59493d;

        a(Object obj, ah ahVar, x.e eVar, H5Event h5Event) {
            this.f59490a = obj;
            this.f59491b = ahVar;
            this.f59492c = eVar;
            this.f59493d = h5Event;
        }

        public final void onResult(Object obj) {
            Object a2 = ah.a(obj, (String) this.f59490a);
            ah ahVar = this.f59491b;
            String str = (String) this.f59490a;
            k.c(str, "key");
            k.c(str, "key");
            j jVar = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "getDataInResult key:".concat(String.valueOf(str)));
            Object opt = ahVar.j.opt(str);
            j jVar2 = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "addValueInResult key:".concat(String.valueOf(str)));
            j jVar3 = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "addValueInResult value:".concat(String.valueOf(opt)));
            j jVar4 = j.f59646a;
            j.b("PhoenixFetchValuesForKeysPlugin", "addValueInResult valueToInsert:".concat(String.valueOf(a2)));
            if (opt == null || k.a((Object) "", opt)) {
                if (a2 == null) {
                    a2 = "";
                }
                ahVar.a(str, a2);
            }
        }
    }

    public static final /* synthetic */ Object a(Object obj, String str) {
        if ((obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof String) || (obj instanceof Double) || (obj instanceof Byte) || (obj instanceof Short) || obj == null || (obj instanceof Character)) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(new com.google.gson.f().b(obj));
        j jVar = j.f59646a;
        j.b("PhoenixFetchValuesForKeysPlugin", "onResult key:".concat(String.valueOf(str)));
        j jVar2 = j.f59646a;
        j.b("PhoenixFetchValuesForKeysPlugin", "onResult value:Object-".concat(String.valueOf(jSONObject)));
        return jSONObject;
    }
}

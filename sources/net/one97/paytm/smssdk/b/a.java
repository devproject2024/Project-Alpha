package net.one97.paytm.smssdk.b;

import android.content.Context;
import com.google.gson.g;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.smssdk.a.c;
import net.one97.paytm.smssdk.model.ConsentRequestBody;
import net.one97.paytm.smssdk.model.ConsentStatus;
import net.one97.paytm.smssdk.model.ConsentStatusPreference;
import net.one97.paytm.smssdk.model.ConsentStatusResponse;
import net.one97.paytm.smssdk.model.ConsentUpdatePreference;
import net.one97.paytm.smssdk.model.ConsentUpdateResponse;
import net.one97.paytm.smssdk.model.Preference;
import net.one97.paytm.smssdk.model.Request;
import net.one97.paytm.smssdk.model.Response;
import net.one97.paytm.smssdk.model.StatusInfo;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65066a = new a();

    private a() {
    }

    /* renamed from: net.one97.paytm.smssdk.b.a$a  reason: collision with other inner class name */
    public static final class C1286a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65067a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f65068b;

        public C1286a(b bVar, Context context) {
            this.f65067a = bVar;
            this.f65068b = context;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f65067a.a((Map<String, Boolean>) null, i2, (String) null);
            q.d("get consent failed  status code =  ".concat(String.valueOf(i2)));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof ConsentStatus) {
                ConsentStatus consentStatus = (ConsentStatus) iJRPaytmDataModel;
                if (consentStatus.getNetworkResponse().statusCode == 200) {
                    HashMap hashMap = new HashMap();
                    ConsentStatusResponse response = consentStatus.getResponse();
                    String str = null;
                    List<ConsentStatusPreference> preferences = response != null ? response.getPreferences() : null;
                    if (preferences != null) {
                        for (ConsentStatusPreference consentStatusPreference : preferences) {
                            c.a aVar = c.f65060a;
                            c.a.a(this.f65068b).a(consentStatusPreference.getKey(), consentStatusPreference.getValue(), false);
                            a aVar2 = a.f65066a;
                            a.a(this.f65068b, consentStatusPreference.getKey());
                            hashMap.put(consentStatusPreference.getKey(), Boolean.valueOf(consentStatusPreference.getValue()));
                        }
                    }
                    b bVar = this.f65067a;
                    Map map = hashMap;
                    int i2 = consentStatus.getNetworkResponse().statusCode;
                    StatusInfo statusInfo = consentStatus.getStatusInfo();
                    if (statusInfo != null) {
                        statusInfo.getStatus();
                    }
                    StatusInfo statusInfo2 = consentStatus.getStatusInfo();
                    if (statusInfo2 != null) {
                        statusInfo2.getStatusCode();
                    }
                    StatusInfo statusInfo3 = consentStatus.getStatusInfo();
                    if (statusInfo3 != null) {
                        str = statusInfo3.getStatusMessage();
                    }
                    bVar.a((Map<String, Boolean>) map, i2, str);
                    StringBuilder sb = new StringBuilder("consent fetch id successfully  response = ");
                    byte[] bArr = consentStatus.getNetworkResponse().data;
                    k.a((Object) bArr, "response.networkResponse.data");
                    Charset forName = Charset.forName(AppConstants.UTF_8);
                    k.a((Object) forName, "Charset.forName(\"UTF-8\")");
                    sb.append(new String(bArr, forName));
                    q.d(sb.toString());
                }
            }
        }
    }

    public static void a(Context context, String str, boolean z, b bVar) {
        k.c(context, "context");
        k.c(str, "consentKey");
        k.c(bVar, "listener");
        q.d("updateConsent  consent key : ".concat(String.valueOf(str)));
        String uuid = UUID.randomUUID().toString();
        k.a((Object) uuid, "UUID.randomUUID().toString()");
        String b2 = new g().a().b(new ConsentRequestBody(new Request(str, z), uuid));
        net.one97.paytm.smssdk.a aVar = net.one97.paytm.smssdk.a.f65042a;
        com.paytm.network.listener.b bVar2 = new b(bVar, context, str, z);
        k.a((Object) b2, "jsonbody");
        k.c(context, "context");
        k.c(bVar2, "responseHandler");
        k.c(b2, "body");
        k.c(uuid, "requestId");
        net.one97.paytm.smssdk.b bVar3 = net.one97.paytm.smssdk.b.f65064b;
        String str2 = net.one97.paytm.smssdk.b.a().f65046c;
        if (str2 == null) {
            k.a();
        }
        HashMap hashMap = new HashMap();
        net.one97.paytm.smssdk.a.a(hashMap);
        Map map = hashMap;
        String Q = com.paytm.utility.b.Q(context);
        k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
        map.put("appVersion", Q);
        String A = com.paytm.utility.b.A(context);
        k.a((Object) A, "CJRAppCommonUtility.getDeviceID(context)");
        map.put("deviceId", A);
        map.put("requestId", uuid);
        map.put("Content-Type", "application/json");
        com.paytm.network.b a2 = net.one97.paytm.smssdk.a.a(context, str2, bVar2, new ConsentUpdateResponse((String) null, (Response) null, (StatusInfo) null, 7, (kotlin.g.b.g) null), map);
        a2.a(a.C0715a.PUT);
        a2.b((Map) new HashMap());
        a2.b(b2);
        a2.a(false);
        com.paytm.network.a l = a2.l();
        if (l != null) {
            l.a();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65069a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f65070b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f65071c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f65072d;

        b(b bVar, Context context, String str, boolean z) {
            this.f65069a = bVar;
            this.f65070b = context;
            this.f65071c = str;
            this.f65072d = z;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f65069a.a(false, i2, (String) null);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            ConsentUpdatePreference preference;
            if (iJRPaytmDataModel instanceof ConsentUpdateResponse) {
                ConsentUpdateResponse consentUpdateResponse = (ConsentUpdateResponse) iJRPaytmDataModel;
                if (consentUpdateResponse.getNetworkResponse().statusCode == 200) {
                    b bVar = this.f65069a;
                    int i2 = consentUpdateResponse.getNetworkResponse().statusCode;
                    StatusInfo statusInfo = consentUpdateResponse.getStatusInfo();
                    if (statusInfo != null) {
                        statusInfo.getStatus();
                    }
                    StatusInfo statusInfo2 = consentUpdateResponse.getStatusInfo();
                    if (statusInfo2 != null) {
                        statusInfo2.getStatusCode();
                    }
                    StatusInfo statusInfo3 = consentUpdateResponse.getStatusInfo();
                    String str = null;
                    bVar.a(true, i2, statusInfo3 != null ? statusInfo3.getStatusMessage() : null);
                    c.a aVar = c.f65060a;
                    c.a.a(this.f65070b).a(this.f65071c, this.f65072d, false);
                    a aVar2 = a.f65066a;
                    a.a(this.f65070b, this.f65071c);
                    StringBuilder sb = new StringBuilder("consent updated successfully ");
                    Response response = consentUpdateResponse.getResponse();
                    if (!(response == null || (preference = response.getPreference()) == null)) {
                        str = preference.getKey();
                    }
                    sb.append(str);
                    sb.append(" response = ");
                    byte[] bArr = consentUpdateResponse.getNetworkResponse().data;
                    k.a((Object) bArr, "response.networkResponse.data");
                    Charset forName = Charset.forName(AppConstants.UTF_8);
                    k.a((Object) forName, "Charset.forName(\"UTF-8\")");
                    sb.append(new String(bArr, forName));
                }
            }
        }
    }

    public static Map<String, Boolean> a(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            c.a aVar = c.f65060a;
            if (!c.a.a(context).b(str, false)) {
                return null;
            }
            c.a aVar2 = c.f65060a;
            hashMap.put(str, Boolean.valueOf(c.a.a(context).b(str, false, false)));
        }
        return hashMap;
    }

    public static void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "consentKey");
        c.a aVar = c.f65060a;
        Set<String> b2 = c.a.a(context).b("sms_consent_set", (Set<String>) new HashSet(), false);
        if (b2 != null) {
            HashSet hashSet = (HashSet) b2;
            if ((hashSet == null || !hashSet.contains(str)) && hashSet != null) {
                hashSet.add(str);
                c.a aVar2 = c.f65060a;
                c.a.a(context).a("sms_consent_set", (Set<String>) hashSet, false);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
    }

    public static List<Preference> a(Context context) {
        k.c(context, "context");
        ArrayList arrayList = new ArrayList();
        c.a aVar = c.f65060a;
        if (c.a.a(context).b("sms_consent_set", false)) {
            c.a aVar2 = c.f65060a;
            Set<String> b2 = c.a.a(context).b("sms_consent_set", (Set<String>) new HashSet(), false);
            if (b2 != null) {
                HashSet hashSet = (HashSet) b2;
                Iterator it2 = hashSet != null ? hashSet.iterator() : null;
                k.a((Object) it2, "consentSet?.iterator()");
                while (true) {
                    Boolean valueOf = it2 != null ? Boolean.valueOf(it2.hasNext()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (!valueOf.booleanValue()) {
                        break;
                    }
                    Object next = it2.next();
                    k.a(next, "iter.next()");
                    String str = (String) next;
                    if (!p.a(ContactsConstant.CONTACTS_CONSENT_KEY, str, true)) {
                        arrayList.add(new Preference("permission", str, "sms consent"));
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
            }
        }
        return arrayList;
    }

    public static boolean b(Context context) {
        k.c(context, "context");
        c.a aVar = c.f65060a;
        if (c.a.a(context).b("sms_consent_set", false)) {
            c.a aVar2 = c.f65060a;
            Set<String> b2 = c.a.a(context).b("sms_consent_set", (Set<String>) new HashSet(), false);
            if (b2 != null) {
                HashSet hashSet = (HashSet) b2;
                Iterator it2 = hashSet != null ? hashSet.iterator() : null;
                k.a((Object) it2, "consentSet?.iterator()");
                while (true) {
                    Boolean valueOf = it2 != null ? Boolean.valueOf(it2.hasNext()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (!valueOf.booleanValue()) {
                        break;
                    }
                    Object next = it2.next();
                    k.a(next, "iter.next()");
                    String str = (String) next;
                    if (!p.a(ContactsConstant.CONTACTS_CONSENT_KEY, str, true)) {
                        c.a aVar3 = c.f65060a;
                        if (c.a.a(context).b(str, false, false)) {
                            return true;
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
            }
        }
        return false;
    }
}

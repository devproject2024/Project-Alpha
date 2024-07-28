package com.paytm.contactsSdk.network;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.gson.f;
import com.google.gson.g;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.constant.NetworkConstant;
import com.paytm.contactsSdk.models.ContactPhone;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.paytm.contactsSdk.models.network.DeleteContactRequest;
import com.paytm.contactsSdk.models.network.DeleteContactResponse;
import com.paytm.contactsSdk.models.network.DeleteStatusInfo;
import com.paytm.contactsSdk.models.requests.ContactDetail;
import com.paytm.contactsSdk.models.requests.ContactInfo;
import com.paytm.contactsSdk.models.requests.HealthRequest;
import com.paytm.contactsSdk.models.requests.Phones;
import com.paytm.contactsSdk.models.requests.PostContactRequest;
import com.paytm.contactsSdk.models.requests.SearchContactRequest;
import com.paytm.contactsSdk.models.responses.ContactNetworkResponse;
import com.paytm.contactsSdk.models.responses.HealthResponse;
import com.paytm.contactsSdk.models.responses.Response;
import com.paytm.contactsSdk.models.responses.Search.EnrichmentContactResponse;
import com.paytm.contactsSdk.models.responses.Search.SearchContactResponse;
import com.paytm.contactsSdk.models.responses.Search.SearchStatusInfo;
import com.paytm.contactsSdk.models.responses.StatusInfo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.k;

public final class NetworkRequestHelper {
    public static final NetworkRequestHelper INSTANCE = new NetworkRequestHelper();
    private static final f gson = new g().a();

    private NetworkRequestHelper() {
    }

    public final a addContactsNetworkCall(Context context, PostContactRequest postContactRequest, b bVar) {
        k.c(context, "context");
        k.c(postContactRequest, "postContactRequest");
        k.c(bVar, "responseHandler");
        Map<String, String> defaultHeader = getDefaultHeader(context);
        NetworkRequestHelper networkRequestHelper = INSTANCE;
        com.paytm.network.b networkCallBuilder = networkRequestHelper.getNetworkCallBuilder(context, ContactsSdk.INSTANCE.getBaseURL$contacts_sdk_release() + NetworkConstant.URL_ADD_CONTACTS, bVar, new ContactNetworkResponse((String) null, (StatusInfo) null, 3, (kotlin.g.b.g) null), defaultHeader);
        networkCallBuilder.f42879c = a.C0715a.POST;
        networkCallBuilder.f42883g = new HashMap();
        networkCallBuilder.f42884h = new g().a().b(postContactRequest);
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        return networkCallBuilder.l();
    }

    public final void deleteContactsNetworkCall(Context context, DeleteContactRequest deleteContactRequest, b bVar) {
        k.c(context, "context");
        k.c(deleteContactRequest, "deleteContactRequest");
        k.c(bVar, "responseHandler");
        Context context2 = context;
        com.paytm.network.b networkCallBuilder = INSTANCE.getNetworkCallBuilder(context2, ContactsSdk.INSTANCE.getBaseURL$contacts_sdk_release() + NetworkConstant.URL_DELETE_CONTACTS, bVar, new DeleteContactResponse((DeleteStatusInfo) null, (String) null, 3, (kotlin.g.b.g) null), getDefaultHeader(context));
        networkCallBuilder.f42879c = a.C0715a.POST;
        networkCallBuilder.f42883g = new HashMap();
        networkCallBuilder.f42884h = gson.b(deleteContactRequest);
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        networkCallBuilder.l().a();
    }

    public final a searchContactNetworkCall(Context context, SearchContactRequest searchContactRequest, b bVar) {
        SearchContactRequest searchContactRequest2 = searchContactRequest;
        k.c(context, "context");
        k.c(searchContactRequest2, "searchContactRequest");
        b bVar2 = bVar;
        k.c(bVar2, "responseHandler");
        Map<String, String> defaultHeader = getDefaultHeader(context);
        NetworkRequestHelper networkRequestHelper = INSTANCE;
        com.paytm.network.b networkCallBuilder = networkRequestHelper.getNetworkCallBuilder(context, ContactsSdk.INSTANCE.getBaseURL$contacts_sdk_release() + NetworkConstant.URL_SEARCH_CONTACT, bVar2, new SearchContactResponse((SearchStatusInfo) null, (EnrichmentContactResponse) null, (String) null, 7, (kotlin.g.b.g) null), defaultHeader);
        networkCallBuilder.f42879c = a.C0715a.POST;
        networkCallBuilder.f42883g = new HashMap();
        networkCallBuilder.f42884h = new g().a().b(searchContactRequest2);
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        return networkCallBuilder.l();
    }

    public final a healthAPINetworkCall(Context context, HealthRequest healthRequest, b bVar) {
        k.c(context, "context");
        k.c(healthRequest, "healthRequest");
        k.c(bVar, "responseHandler");
        Map<String, String> defaultHeader = getDefaultHeader(context);
        NetworkRequestHelper networkRequestHelper = INSTANCE;
        com.paytm.network.b networkCallBuilder = networkRequestHelper.getNetworkCallBuilder(context, ContactsSdk.INSTANCE.getBaseURL$contacts_sdk_release() + NetworkConstant.URL_HEALTH, bVar, new HealthResponse((StatusInfo) null, (Response) null, 3, (kotlin.g.b.g) null), defaultHeader);
        networkCallBuilder.f42879c = a.C0715a.POST;
        networkCallBuilder.f42883g = new HashMap();
        networkCallBuilder.f42884h = new g().a().b(healthRequest);
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        return networkCallBuilder.l();
    }

    private final com.paytm.network.b getNetworkCallBuilder(Context context, String str, b bVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42880d = str;
        bVar2.f42882f = map;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.n = a.b.USER_FACING;
        bVar2.j = bVar;
        bVar2.o = "UpsSdk";
        bVar2.x = 0;
        bVar2.f42878b = a.c.COMS;
        k.a((Object) bVar2, "setVerticalId(CJRCommonN…workCall.VerticalId.COMS)");
        k.a((Object) bVar2, "with(CJRCommonNetworkCal…erticalId.COMS)\n        }");
        return bVar2;
    }

    private final Map<String, String> getDefaultHeader(Context context) {
        HashMap hashMap = new HashMap();
        String uuid = UUID.randomUUID().toString();
        k.a((Object) uuid, "UUID.randomUUID().toString()");
        Map<String, String> map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("sso-token", ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getSSOToken());
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("requestId", uuid);
        map.put("appVersion", ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getAppVersion());
        map.put(ContactsConstant.LOCALE, ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getLocale());
        map.put(ContactsConstant.NETWORK, ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getNetworkType());
        map.put(ContactsConstant.IP, ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getIp());
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        k.a((Object) defaultUserAgent, "WebSettings.getDefaultUserAgent(context)");
        map.put(ContactsConstant.USER_AGENT, defaultUserAgent);
        map.put(ContactsConstant.LAT_LONG, ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getLanLng());
        map.put("OS", "android");
        q.d(uuid);
        return map;
    }

    public final PostContactRequest getaddContactAPIRequest(Context context, List<ContactWithPhones> list) {
        k.c(context, "context");
        k.c(list, "contactWithPhones");
        ArrayList arrayList = new ArrayList();
        for (ContactWithPhones next : list) {
            ArrayList arrayList2 = new ArrayList();
            String str = null;
            for (ContactPhone next2 : next.getPhones()) {
                if (next2.getPhone().length() > 0) {
                    if (!next2.isPrimary()) {
                        arrayList2.add(ContactUtil.INSTANCE.getNormalizedPhoneNumber$contacts_sdk_release(next2.getPhone()));
                    } else {
                        str = ContactUtil.INSTANCE.getNormalizedPhoneNumber$contacts_sdk_release(next2.getPhone());
                    }
                }
            }
            arrayList.add(new ContactDetail(String.valueOf(next.getContact().getId()), next.getContact().getName(), next.getContact().getName(), new ContactInfo(new Phones(str, arrayList2), new ArrayList())));
        }
        String A = com.paytm.utility.b.A(context);
        k.a((Object) A, "CJRAppCommonUtility.getDeviceID(context)");
        return new PostContactRequest(A, ContactsConstant.CONTACT_TYPE_VALUE, arrayList);
    }
}

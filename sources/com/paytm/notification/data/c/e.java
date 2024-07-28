package com.paytm.notification.data.c;

import com.paytm.notification.data.b.c;
import com.paytm.notification.models.FlashFetchResponse;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.pai.network.model.EventResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43064a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final com.paytm.notification.data.datasource.dao.a f43065b;

    /* renamed from: c  reason: collision with root package name */
    private final c f43066c;

    public e(com.paytm.notification.data.datasource.dao.a aVar, c cVar) {
        k.c(aVar, "flashDao");
        k.c(cVar, "flashApi");
        this.f43065b = aVar;
        this.f43066c = cVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(com.paytm.notification.data.datasource.dao.c cVar) throws Exception {
        k.c(cVar, "flashData");
        this.f43065b.a(cVar);
    }

    public final List<com.paytm.notification.data.datasource.dao.c> a() {
        String customerId$paytmnotification_paytmRelease = com.paytm.notification.data.datasource.a.f43088i.b().getCustomerId$paytmnotification_paytmRelease();
        if (customerId$paytmnotification_paytmRelease != null) {
            List<com.paytm.notification.data.datasource.dao.c> a2 = this.f43065b.a(customerId$paytmnotification_paytmRelease, new Date().getTime());
            if (a2.isEmpty()) {
                com.paytm.notification.b.e.f43014a.b("Flash message not found", new Object[0]);
                return null;
            }
            com.paytm.notification.b.e.f43014a.b("Flash message found", new Object[0]);
            return a2;
        }
        com.paytm.notification.b.e.f43014a.b("Flash message not found", new Object[0]);
        return null;
    }

    public final com.paytm.notification.data.datasource.dao.c b(String str) {
        k.c(str, "id");
        try {
            String customerId$paytmnotification_paytmRelease = com.paytm.notification.data.datasource.a.f43088i.b().getCustomerId$paytmnotification_paytmRelease();
            if (customerId$paytmnotification_paytmRelease != null) {
                return this.f43065b.a(customerId$paytmnotification_paytmRelease, new Date().getTime(), str);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "customerId");
        k.c(str2, "pushId");
        this.f43065b.a(str, str2);
    }

    public final void b(String str, String str2) {
        k.c(str, "customerId");
        k.c(str2, "pushId");
        this.f43065b.a(str, str2);
    }

    public final List<String> a(String str) {
        k.c(str, "customerId");
        return this.f43065b.b(str, new Date().getTime());
    }

    public final EventResponse<ArrayList<FlashFetchResponse>> a(String str, String str2, String str3, String str4, FetchInboxRequest fetchInboxRequest) {
        k.c(str, "endpoints");
        k.c(str2, "customerId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        k.c(fetchInboxRequest, "request");
        return this.f43066c.a(str, str2, str3, str4, fetchInboxRequest);
    }

    public final EventResponse<Boolean> a(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4) {
        k.c(fetchInboxRequest, "pushIds");
        k.c(str, "endpoints");
        k.c(str2, "customerId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        return this.f43066c.a(fetchInboxRequest, str, str2, str3, str4);
    }

    public final ArrayList<String> b() {
        return (ArrayList) this.f43065b.b();
    }

    public final void a(List<String> list, String str) {
        k.c(list, "pushId");
        k.c(str, "customerId");
        this.f43065b.a(list, str);
    }

    public final List<com.paytm.notification.data.datasource.dao.c> b(List<com.paytm.notification.data.datasource.dao.c> list, String str) {
        boolean z;
        boolean z2;
        k.c(list, "flashData");
        k.c(str, "customerId");
        List<com.paytm.notification.data.datasource.dao.c> a2 = this.f43065b.a(str, new Date().getTime());
        if (!a2.isEmpty()) {
            for (com.paytm.notification.data.datasource.dao.c cVar : a2) {
                Iterator<com.paytm.notification.data.datasource.dao.c> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (k.a((Object) cVar.f43116f, (Object) it2.next().f43116f)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    this.f43065b.a(str, cVar.f43116f);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        List<com.paytm.notification.data.datasource.dao.c> a3 = this.f43065b.a();
        for (com.paytm.notification.data.datasource.dao.c cVar2 : list) {
            Iterator<com.paytm.notification.data.datasource.dao.c> it3 = a3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z = false;
                    break;
                }
                com.paytm.notification.data.datasource.dao.c next = it3.next();
                if (k.a((Object) cVar2.f43116f, (Object) next.f43116f)) {
                    if (next.f43113c != 2) {
                        arrayList.add(cVar2);
                    }
                    z = true;
                }
            }
            if (!z) {
                this.f43065b.a(cVar2);
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    public final void c() {
        this.f43065b.a(new Date().getTime());
    }

    public final List<com.paytm.notification.data.datasource.dao.c> d() {
        return this.f43065b.b(new Date().getTime());
    }
}

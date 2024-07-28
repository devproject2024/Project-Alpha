package com.paytm.notification.schedulers.b;

import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.d;
import com.paytm.notification.data.c.h;
import com.paytm.notification.data.datasource.dao.c;
import com.paytm.notification.i;
import com.paytm.notification.j;
import com.paytm.notification.models.FlashFetchResponse;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final d f43253a;

    /* renamed from: b  reason: collision with root package name */
    final com.paytm.notification.data.c.b f43254b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationUserConfig f43255c;

    public b(NotificationUserConfig notificationUserConfig, d dVar, com.paytm.notification.data.c.b bVar) {
        k.c(notificationUserConfig, "notificationUserConfig");
        k.c(dVar, "flashRepo");
        k.c(bVar, "analyticsRepo");
        this.f43255c = notificationUserConfig;
        this.f43253a = dVar;
        this.f43254b = bVar;
    }

    public final boolean a() throws com.paytm.notification.schedulers.a.a {
        String str;
        try {
            h c2 = j.f43241a.c();
            String inboxEndPoints$paytmnotification_paytmRelease = this.f43255c.getInboxEndPoints$paytmnotification_paytmRelease();
            String j = c2.j();
            String clientName$paytmnotification_paytmRelease = c2.a().getClientName$paytmnotification_paytmRelease();
            String customerId$paytmnotification_paytmRelease = c2.a().getCustomerId$paytmnotification_paytmRelease();
            if (j == null || customerId$paytmnotification_paytmRelease == null || inboxEndPoints$paytmnotification_paytmRelease == null) {
                throw new com.paytm.notification.schedulers.a.a("App secret/customer/endPoints id not found");
            }
            d dVar = this.f43253a;
            if (clientName$paytmnotification_paytmRelease == null) {
                k.a();
            }
            String f2 = c2.f();
            if (f2 == null) {
                k.a();
            }
            EventResponse<ArrayList<FlashFetchResponse>> a2 = a(inboxEndPoints$paytmnotification_paytmRelease, customerId$paytmnotification_paytmRelease, dVar, j, clientName$paytmnotification_paytmRelease, f2);
            if (a2 != null) {
                if (!k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE) || !k.a((Object) a2.isDoNotRetry(), (Object) Boolean.TRUE)) {
                    if (k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE)) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList<FlashFetchResponse> response = a2.getResponse();
                    if (response != null) {
                        for (FlashFetchResponse flashFetchResponse : response) {
                            c a3 = com.paytm.notification.c.c.a(flashFetchResponse);
                            if (a3 != null) {
                                a3.c(customerId$paytmnotification_paytmRelease);
                            }
                            if (a3 != null) {
                                com.paytm.notification.c.a aVar = com.paytm.notification.c.a.f43021a;
                                a3.l = Long.valueOf(com.paytm.notification.c.a.a(flashFetchResponse.getReceivedDate()));
                            }
                            if (a3 != null) {
                                arrayList.add(a3);
                            }
                        }
                    }
                    x.e eVar = new x.e();
                    eVar.element = null;
                    if (!arrayList.isEmpty()) {
                        eVar.element = this.f43253a.b((List<c>) arrayList, customerId$paytmnotification_paytmRelease);
                        if (!((List) eVar.element).isEmpty()) {
                            i.a aVar2 = i.f43209d;
                            i d2 = i.f43210i;
                            if (d2 != null) {
                                d2.a();
                            }
                        }
                    }
                    new Thread(new a(this, eVar)).start();
                    this.f43253a.c();
                    return true;
                }
            }
            if (a2 != null) {
                str = a2.getErrorMessage();
                if (a2.getResponse() != null) {
                    str = str + ": " + new f().b(a2.getResponse());
                }
            } else {
                str = "response is null";
            }
            throw new com.paytm.notification.schedulers.a.a(str);
        } catch (com.paytm.notification.schedulers.a.a e2) {
            e2.printStackTrace();
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (Exception e3) {
            e.f43014a.b(e3);
            return false;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f43256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f43257b;

        a(b bVar, x.e eVar) {
            this.f43256a = bVar;
            this.f43257b = eVar;
        }

        public final void run() {
            List<c> list = (List) this.f43257b.element;
            if (list != null) {
                for (c cVar : list) {
                    com.paytm.notification.data.c.b bVar = this.f43256a.f43254b;
                    String str = cVar.f43116f;
                    String str2 = cVar.f43115e;
                    if (str2 == null) {
                        str2 = "";
                    }
                    bVar.b(str, str2);
                }
            }
            for (c cVar2 : this.f43256a.f43253a.d()) {
                com.paytm.notification.data.c.b bVar2 = this.f43256a.f43254b;
                String str3 = cVar2.f43116f;
                String str4 = cVar2.f43115e;
                if (str4 == null) {
                    str4 = "";
                }
                bVar2.g(str3, str4);
            }
            this.f43256a.f43254b.a();
        }
    }

    private static EventResponse<ArrayList<FlashFetchResponse>> a(String str, String str2, d dVar, String str3, String str4, String str5) throws com.paytm.notification.schedulers.a.a {
        try {
            com.paytm.notification.c.f fVar = com.paytm.notification.c.f.f43030a;
            return dVar.a(str, str2, str3, str4, com.paytm.notification.c.f.a(str5, (ArrayList<String>) null));
        } catch (MalformedURLException e2) {
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new com.paytm.notification.schedulers.a.a(e3.getMessage());
        }
    }
}

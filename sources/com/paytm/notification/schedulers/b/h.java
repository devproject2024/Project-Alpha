package com.paytm.notification.schedulers.b;

import com.paytm.notification.c.f;
import com.paytm.notification.data.c.d;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.notification.schedulers.a.a;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final NotificationUserConfig f43285a;

    /* renamed from: b  reason: collision with root package name */
    private final com.paytm.notification.data.c.h f43286b;

    /* renamed from: c  reason: collision with root package name */
    private final d f43287c;

    public h(NotificationUserConfig notificationUserConfig, com.paytm.notification.data.c.h hVar, d dVar) {
        k.c(notificationUserConfig, "notificationUserConfig");
        k.c(hVar, "pushConfigRepo");
        k.c(dVar, "flashRepo");
        this.f43285a = notificationUserConfig;
        this.f43286b = hVar;
        this.f43287c = dVar;
    }

    public final boolean a() throws a {
        try {
            for (String str : this.f43287c.b()) {
                List<String> a2 = this.f43287c.a(str);
                if (a2 != null) {
                    ArrayList arrayList = (ArrayList) a2;
                    if (true ^ arrayList.isEmpty()) {
                        String f2 = this.f43286b.f();
                        if (f2 == null) {
                            k.a();
                        }
                        a(arrayList, str, f2);
                    }
                    this.f43287c.a((List<String>) arrayList, str);
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
                }
            }
            return true;
        } catch (MalformedURLException e2) {
            throw new a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new a(e3.getMessage());
        }
    }

    private final boolean a(ArrayList<String> arrayList, String str, String str2) throws a {
        String str3;
        try {
            if (arrayList.isEmpty()) {
                return true;
            }
            f fVar = f.f43030a;
            FetchInboxRequest a2 = f.a(str2, arrayList);
            d dVar = this.f43287c;
            String inboxEndPoints$paytmnotification_paytmRelease = this.f43285a.getInboxEndPoints$paytmnotification_paytmRelease();
            if (inboxEndPoints$paytmnotification_paytmRelease == null) {
                k.a();
            }
            String j = this.f43286b.j();
            if (j == null) {
                k.a();
            }
            String clientName$paytmnotification_paytmRelease = this.f43286b.a().getClientName$paytmnotification_paytmRelease();
            if (clientName$paytmnotification_paytmRelease == null) {
                k.a();
            }
            EventResponse<Boolean> a3 = dVar.a(a2, inboxEndPoints$paytmnotification_paytmRelease, str, j, clientName$paytmnotification_paytmRelease);
            if (a3 != null) {
                if (!k.a((Object) a3.isSuccess(), (Object) Boolean.FALSE) || !k.a((Object) a3.isDoNotRetry(), (Object) Boolean.TRUE)) {
                    if (k.a((Object) a3.isSuccess(), (Object) Boolean.FALSE)) {
                        return false;
                    }
                    return true;
                }
            }
            if (a3 != null) {
                str3 = a3.getErrorMessage();
                if (a3.getResponse() != null) {
                    str3 = str3 + ": " + new com.google.gson.f().b(a3.getResponse());
                }
            } else {
                str3 = "response is null";
            }
            throw new a(str3);
        } catch (MalformedURLException e2) {
            throw new a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new a(e3.getMessage());
        }
    }
}

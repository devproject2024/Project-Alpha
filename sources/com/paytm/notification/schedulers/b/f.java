package com.paytm.notification.schedulers.b;

import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.notification.schedulers.a.a;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final NotificationUserConfig f43277a;

    /* renamed from: b  reason: collision with root package name */
    private final h f43278b;

    /* renamed from: c  reason: collision with root package name */
    private final com.paytm.notification.data.c.f f43279c;

    public f(NotificationUserConfig notificationUserConfig, h hVar, com.paytm.notification.data.c.f fVar) {
        k.c(notificationUserConfig, "notificationUserConfig");
        k.c(hVar, "pushConfigRepo");
        k.c(fVar, "inboxRepo");
        this.f43277a = notificationUserConfig;
        this.f43278b = hVar;
        this.f43279c = fVar;
    }

    public final boolean a() throws a {
        try {
            String f2 = this.f43278b.f();
            if (f2 == null) {
                k.a();
            }
            for (String str : this.f43279c.b()) {
                ArrayList<com.paytm.notification.data.datasource.dao.f> a2 = this.f43279c.a(str);
                if (a2 != null && (!a2.isEmpty())) {
                    a(a2, str, f2);
                }
                ArrayList<com.paytm.notification.data.datasource.dao.f> b2 = this.f43279c.b(str);
                if (true ^ b2.isEmpty()) {
                    b(b2, str, f2);
                }
                this.f43279c.c(str);
            }
            return true;
        } catch (MalformedURLException e2) {
            throw new a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new a(e3.getMessage());
        }
    }

    private final boolean a(ArrayList<com.paytm.notification.data.datasource.dao.f> arrayList, String str, String str2) throws a {
        String str3;
        try {
            ArrayList<String> a2 = a(arrayList);
            if (a2.isEmpty()) {
                return true;
            }
            com.paytm.notification.c.f fVar = com.paytm.notification.c.f.f43030a;
            FetchInboxRequest a3 = com.paytm.notification.c.f.a(str2, a2);
            com.paytm.notification.data.c.f fVar2 = this.f43279c;
            String inboxEndPoints$paytmnotification_paytmRelease = this.f43277a.getInboxEndPoints$paytmnotification_paytmRelease();
            if (inboxEndPoints$paytmnotification_paytmRelease == null) {
                k.a();
            }
            String j = this.f43278b.j();
            if (j == null) {
                k.a();
            }
            String clientName$paytmnotification_paytmRelease = this.f43278b.a().getClientName$paytmnotification_paytmRelease();
            if (clientName$paytmnotification_paytmRelease == null) {
                k.a();
            }
            EventResponse<Boolean> b2 = fVar2.b(a3, inboxEndPoints$paytmnotification_paytmRelease, str, j, clientName$paytmnotification_paytmRelease);
            if (b2 != null) {
                if (!k.a((Object) b2.isSuccess(), (Object) Boolean.FALSE) || !k.a((Object) b2.isDoNotRetry(), (Object) Boolean.TRUE)) {
                    if (k.a((Object) b2.isSuccess(), (Object) Boolean.FALSE)) {
                        return false;
                    }
                    this.f43279c.b(a2, str);
                    return true;
                }
            }
            if (b2 != null) {
                str3 = b2.getErrorMessage();
                if (b2.getResponse() != null) {
                    str3 = str3 + ": " + new com.google.gson.f().b(b2.getResponse());
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

    private final boolean b(ArrayList<com.paytm.notification.data.datasource.dao.f> arrayList, String str, String str2) throws a {
        try {
            ArrayList<String> a2 = a(arrayList);
            if (a2.isEmpty()) {
                return true;
            }
            com.paytm.notification.c.f fVar = com.paytm.notification.c.f.f43030a;
            FetchInboxRequest a3 = com.paytm.notification.c.f.a(str2, a2);
            com.paytm.notification.data.c.f fVar2 = this.f43279c;
            String inboxEndPoints$paytmnotification_paytmRelease = this.f43277a.getInboxEndPoints$paytmnotification_paytmRelease();
            if (inboxEndPoints$paytmnotification_paytmRelease == null) {
                k.a();
            }
            String j = this.f43278b.j();
            if (j == null) {
                k.a();
            }
            String clientName$paytmnotification_paytmRelease = this.f43278b.a().getClientName$paytmnotification_paytmRelease();
            if (clientName$paytmnotification_paytmRelease == null) {
                k.a();
            }
            EventResponse<Boolean> a4 = fVar2.a(a3, inboxEndPoints$paytmnotification_paytmRelease, str, j, clientName$paytmnotification_paytmRelease);
            if (k.a((Object) a4.isSuccess(), (Object) Boolean.FALSE)) {
                if (k.a((Object) a4.isDoNotRetry(), (Object) Boolean.TRUE)) {
                    throw new a();
                }
            }
            if (k.a((Object) a4.isSuccess(), (Object) Boolean.FALSE)) {
                return false;
            }
            this.f43279c.b(a2, str);
            return true;
        } catch (MalformedURLException e2) {
            e.f43014a.b("Job sync event status unsuccessful", new Object[0]);
            throw new a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            e.f43014a.b("Job sync event status unsuccessful", new Object[0]);
            throw new a(e3.getMessage());
        }
    }

    private static ArrayList<String> a(ArrayList<com.paytm.notification.data.datasource.dao.f> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (com.paytm.notification.data.datasource.dao.f fVar : arrayList) {
            arrayList2.add(fVar.f43137e);
        }
        return arrayList2;
    }
}

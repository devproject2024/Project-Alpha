package com.paytm.notification.schedulers.b;

import com.paytm.notification.b.e;
import com.paytm.notification.c.c;
import com.paytm.notification.data.c.b;
import com.paytm.notification.data.c.f;
import com.paytm.notification.data.c.h;
import com.paytm.notification.j;
import com.paytm.notification.models.InboxMessageResponse;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final f f43261a;

    /* renamed from: b  reason: collision with root package name */
    final b f43262b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationUserConfig f43263c;

    public d(NotificationUserConfig notificationUserConfig, f fVar, b bVar) {
        k.c(notificationUserConfig, "notificationUserConfig");
        k.c(fVar, "inboxRepo");
        k.c(bVar, "analyticsRepo");
        this.f43263c = notificationUserConfig;
        this.f43261a = fVar;
        this.f43262b = bVar;
    }

    public final boolean a() throws com.paytm.notification.schedulers.a.a {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            h c2 = j.f43241a.c();
            String inboxEndPoints$paytmnotification_paytmRelease = this.f43263c.getInboxEndPoints$paytmnotification_paytmRelease();
            String j = c2.j();
            String clientName$paytmnotification_paytmRelease = c2.a().getClientName$paytmnotification_paytmRelease();
            String customerId$paytmnotification_paytmRelease = c2.a().getCustomerId$paytmnotification_paytmRelease();
            if (j == null || customerId$paytmnotification_paytmRelease == null) {
                throw new com.paytm.notification.schedulers.a.a("App secret or customer id not found");
            }
            if (inboxEndPoints$paytmnotification_paytmRelease == null) {
                k.a();
            }
            if (clientName$paytmnotification_paytmRelease == null) {
                k.a();
            }
            String f2 = c2.f();
            if (f2 == null) {
                k.a();
            }
            EventResponse<ArrayList<InboxMessageResponse>> a2 = a(inboxEndPoints$paytmnotification_paytmRelease, customerId$paytmnotification_paytmRelease, j, clientName$paytmnotification_paytmRelease, f2);
            if (a2 != null) {
                if (!k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE) || !k.a((Object) a2.isDoNotRetry(), (Object) Boolean.TRUE)) {
                    if (k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE)) {
                        return false;
                    }
                    ArrayList<InboxMessageResponse> response = a2.getResponse();
                    if (response == null) {
                        k.a();
                    }
                    Object clone = response.clone();
                    if (clone != null) {
                        for (InboxMessageResponse inboxMessageResponse : (ArrayList) clone) {
                            com.paytm.notification.data.datasource.dao.f a3 = c.a(inboxMessageResponse, customerId$paytmnotification_paytmRelease);
                            inboxMessageResponse.setCampaignId(a3.p);
                            arrayList.add(a3);
                        }
                        new Thread(new a(this, a2, customerId$paytmnotification_paytmRelease)).start();
                        return true;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytm.notification.models.InboxMessageResponse> /* = java.util.ArrayList<com.paytm.notification.models.InboxMessageResponse> */");
                }
            }
            if (a2 != null) {
                str = a2.getErrorMessage();
                if (a2.getResponse() != null) {
                    str = str + ": " + new com.google.gson.f().b(a2.getResponse());
                }
            } else {
                str = "response is null";
            }
            throw new com.paytm.notification.schedulers.a.a(str);
        } catch (com.paytm.notification.schedulers.a.a unused) {
            throw new com.paytm.notification.schedulers.a.a();
        } catch (Exception e2) {
            e.f43014a.b(e2);
            return false;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43264a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EventResponse f43265b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43266c;

        a(d dVar, EventResponse eventResponse, String str) {
            this.f43264a = dVar;
            this.f43265b = eventResponse;
            this.f43266c = str;
        }

        public final void run() {
            for (InboxMessageResponse inboxMessageResponse : this.f43264a.f43261a.a((ArrayList<InboxMessageResponse>) (ArrayList) this.f43265b.getResponse(), this.f43266c)) {
                b bVar = this.f43264a.f43262b;
                String pushId = inboxMessageResponse.getPushId();
                String str = "";
                if (pushId == null) {
                    pushId = str;
                }
                String campaignId = inboxMessageResponse.getCampaignId();
                if (campaignId != null) {
                    str = campaignId;
                }
                bVar.a(pushId, str);
                e.b bVar2 = e.f43014a;
                bVar2.b("inboxPulled:" + inboxMessageResponse.getPushId(), new Object[0]);
            }
            this.f43264a.f43262b.a();
        }
    }

    private final EventResponse<ArrayList<InboxMessageResponse>> a(String str, String str2, String str3, String str4, String str5) throws com.paytm.notification.schedulers.a.a {
        try {
            com.paytm.notification.c.f fVar = com.paytm.notification.c.f.f43030a;
            return this.f43261a.a(str, str2, str3, str4, com.paytm.notification.c.f.a(str5, (ArrayList<String>) null));
        } catch (MalformedURLException e2) {
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new com.paytm.notification.schedulers.a.a(e3.getMessage());
        }
    }
}

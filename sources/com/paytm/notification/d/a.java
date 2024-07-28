package com.paytm.notification.d;

import android.content.Context;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.b;
import com.paytm.notification.models.PushMessage;
import com.paytm.notification.schedulers.c;
import kotlin.g.b.k;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f43039a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f43040b;

    /* renamed from: c  reason: collision with root package name */
    private final b f43041c;

    /* renamed from: d  reason: collision with root package name */
    private final PushMessage f43042d;

    /* renamed from: e  reason: collision with root package name */
    private final c f43043e;

    public a(Context context, Runnable runnable, b bVar, PushMessage pushMessage, c cVar) {
        k.c(context, "context");
        k.c(runnable, "finish");
        k.c(bVar, "analyticsRepo");
        k.c(pushMessage, "pushMessage");
        k.c(cVar, "jobScheduler");
        this.f43039a = context;
        this.f43040b = runnable;
        this.f43041c = bVar;
        this.f43042d = pushMessage;
        this.f43043e = cVar;
    }

    public final void run() {
        e.f43014a.b("Running push runnable", new Object[0]);
        try {
            com.paytm.notification.ui.a aVar = com.paytm.notification.ui.a.f43334a;
            Context context = this.f43039a;
            PushMessage pushMessage = this.f43042d;
            Integer notificationId = this.f43042d.getNotificationId();
            int i2 = -1;
            com.paytm.notification.ui.b a2 = aVar.a(context, pushMessage, notificationId != null ? notificationId.intValue() : -1);
            if (a2.f43339d) {
                e.f43014a.a("Notification disabled on the channel. Discarding notification ...", new Object[0]);
                b bVar = this.f43041c;
                Integer notificationId2 = this.f43042d.getNotificationId();
                if (notificationId2 != null) {
                    i2 = notificationId2.intValue();
                }
                bVar.a(i2, 5);
                b bVar2 = this.f43041c;
                PushMessage pushMessage2 = this.f43042d;
                String str = a2.f43342g;
                if (str == null) {
                    k.a();
                }
                bVar2.c(pushMessage2, str);
            } else {
                if (a2.f43340e) {
                    this.f43041c.a(this.f43042d, a2.f43341f);
                }
                if (a2.f43337b && !a2.f43338c) {
                    this.f43041c.d(this.f43042d);
                }
                b bVar3 = this.f43041c;
                Integer notificationId3 = this.f43042d.getNotificationId();
                if (notificationId3 != null) {
                    i2 = notificationId3.intValue();
                }
                bVar3.a(i2, 2);
                this.f43041c.c(this.f43042d);
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
            b bVar4 = this.f43041c;
            PushMessage pushMessage3 = this.f43042d;
            String localizedMessage = e2.getLocalizedMessage();
            k.a((Object) localizedMessage, "e.localizedMessage");
            bVar4.a(pushMessage3, localizedMessage);
        } catch (Throwable th) {
            this.f43041c.a();
            this.f43040b.run();
            throw th;
        }
        this.f43041c.a();
        this.f43040b.run();
    }
}

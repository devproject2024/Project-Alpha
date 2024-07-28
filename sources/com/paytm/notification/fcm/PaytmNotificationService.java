package com.paytm.notification.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.h;
import com.paytm.notification.j;
import com.paytm.notification.models.callback.PushManagerReadyCallback;
import com.sendbird.android.constant.StringSet;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;

public class PaytmNotificationService extends FirebaseMessagingService {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f43186a = Executors.newCachedThreadPool();

    public void onNewToken(String str) {
        k.c(str, StringSet.token);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        k.c(remoteMessage, "remoteMessage");
        synchronized (g.class) {
            try {
                e.b bVar = e.f43014a;
                bVar.a("From: " + remoteMessage.a(), new Object[0]);
                e.b bVar2 = e.f43014a;
                bVar2.a("Message id : " + remoteMessage.c(), new Object[0]);
                Map<String, String> b2 = remoteMessage.b();
                k.a((Object) b2, "remoteMessage.data");
                if (!b2.isEmpty()) {
                    e.b bVar3 = e.f43014a;
                    bVar3.a("Message data payload: " + remoteMessage.b(), new Object[0]);
                    remoteMessage.b().put("receiveTIme", String.valueOf(new Date().getTime()));
                    if (p.a(remoteMessage.b().get("provider"), "paytm", true)) {
                        g.c cVar = g.f43191a;
                        g.c.a((PushManagerReadyCallback) new a(this, remoteMessage));
                    } else {
                        k.c(remoteMessage, "remoteMessage");
                    }
                } else {
                    this.f43186a.execute(new b(this, remoteMessage));
                }
            } catch (com.paytm.notification.a.a.a unused) {
                e.f43014a.b("Paytm notification is disable.... Please initialize", new Object[0]);
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
            x xVar = x.f47997a;
        }
    }

    public static final class a implements PushManagerReadyCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmNotificationService f43187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RemoteMessage f43188b;

        a(PaytmNotificationService paytmNotificationService, RemoteMessage remoteMessage) {
            this.f43187a = paytmNotificationService;
            this.f43188b = remoteMessage;
        }

        public final void onCallbackReady(h hVar) {
            k.c(hVar, "pushHandler");
            hVar.a(this.f43188b);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmNotificationService f43189a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RemoteMessage f43190b;

        b(PaytmNotificationService paytmNotificationService, RemoteMessage remoteMessage) {
            this.f43189a = paytmNotificationService;
            this.f43190b = remoteMessage;
        }

        public final void run() {
            com.paytm.notification.c.e eVar = com.paytm.notification.c.e.f43026a;
            Map<String, String> b2 = this.f43190b.b();
            k.a((Object) b2, "remoteMessage.data");
            j.f43241a.a().b(com.paytm.notification.c.e.a(b2), "remoteMessage.data is empty");
        }
    }
}

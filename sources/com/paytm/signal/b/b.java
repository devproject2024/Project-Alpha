package com.paytm.signal.b;

import android.content.res.Resources;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.signal.models.Config;
import com.paytm.signal.models.SignalEvent;
import com.paytm.signal.schedulers.a;
import com.paytm.signal.schedulers.c;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f43606a;

    /* renamed from: b  reason: collision with root package name */
    public final a f43607b;

    /* renamed from: c  reason: collision with root package name */
    private final f f43608c = new f();

    /* renamed from: d  reason: collision with root package name */
    private final com.paytm.signal.data.a f43609d;

    public b(a aVar, a aVar2, com.paytm.signal.data.a aVar3) {
        k.c(aVar, "configProvider");
        k.c(aVar2, "jobScheduler");
        k.c(aVar3, "analyticsEventRepository");
        this.f43606a = aVar;
        this.f43607b = aVar2;
        this.f43609d = aVar3;
    }

    public final void a() {
        boolean z = true;
        try {
            e.f43014a.a("uploadPriorityEvents(): send signal events", new Object[0]);
            com.paytm.signal.schedulers.b bVar = com.paytm.signal.schedulers.b.f43659a;
            z = com.paytm.signal.schedulers.b.a(this.f43606a.f43603a, this.f43609d, this.f43607b, true);
        } catch (com.paytm.notification.schedulers.a.a unused) {
        }
        if (!z) {
            this.f43607b.a(30000);
        }
    }

    public final boolean a(SignalEvent signalEvent) {
        if (signalEvent.getPayload() == null) {
            e.f43014a.a("SignalSDKLog - Event discarded at paytm analytics , null event found", new Object[0]);
            return false;
        }
        if (this.f43606a.f43603a.getCustomDimension() != null && (signalEvent.getPayload() instanceof Map)) {
            com.paytm.signal.a.b bVar = com.paytm.signal.a.b.f43593a;
            Object payload = signalEvent.getPayload();
            if (payload != null) {
                Map map = (Map) payload;
                Map<String, String> customDimension = this.f43606a.f43603a.getCustomDimension();
                if (customDimension == null) {
                    k.a();
                }
                signalEvent.setPayload(bVar.a((Map<String, ? extends Object>) map, customDimension));
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            }
        }
        a(signalEvent, this.f43606a.f43603a);
        this.f43609d.a(signalEvent);
        e.b bVar2 = e.f43014a;
        bVar2.a("SignalSDKLog - New event  received by paytm analytics " + signalEvent.getEventType(), new Object[0]);
        e.b bVar3 = e.f43014a;
        bVar3.a("SignalSDKLog - PaytmAnalytics Event added to local db " + signalEvent.getPayload() + " type:" + signalEvent.getEventType(), new Object[0]);
        return true;
    }

    private final void a(SignalEvent signalEvent, Config config) {
        signalEvent.setPayload(a(signalEvent.getPayload()));
        signalEvent.setDeviceId$paytmnotification_paytmRelease(config.getDeviceId());
        signalEvent.setCustomerId$paytmnotification_paytmRelease(config.getUserId$paytmnotification_paytmRelease());
        Integer messageVersion = config.getMessageVersion();
        signalEvent.setMessageVersion$paytmnotification_paytmRelease(Integer.valueOf(messageVersion != null ? messageVersion.intValue() : 0));
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = c.f43662a;
        signalEvent.setDeviceDateTime$paytmnotification_paytmRelease(Long.valueOf(currentTimeMillis + c.a()));
        signalEvent.setClientId$paytmnotification_paytmRelease(config.getClientName());
        signalEvent.setAppVersion$paytmnotification_paytmRelease(config.getAppVersion());
        signalEvent.setAppLanguage$paytmnotification_paytmRelease(config.getAppLanguage());
        signalEvent.setLastAppOpenDate$paytmnotification_paytmRelease(config.getLastAppOpenDate$paytmnotification_paytmRelease());
        signalEvent.setOsType$paytmnotification_paytmRelease(config.getOsType());
        signalEvent.setOsVersion$paytmnotification_paytmRelease(config.getOsVersion$paytmnotification_paytmRelease());
        signalEvent.setModel$paytmnotification_paytmRelease(config.getModel$paytmnotification_paytmRelease());
        signalEvent.setBrand$paytmnotification_paytmRelease(config.getBrand$paytmnotification_paytmRelease());
        signalEvent.setAdvertisementId$paytmnotification_paytmRelease(config.getAdvertisementId$paytmnotification_paytmRelease());
        signalEvent.setIp$paytmnotification_paytmRelease(config.getIp$paytmnotification_paytmRelease());
        signalEvent.setCarrier$paytmnotification_paytmRelease(config.getCarrier$paytmnotification_paytmRelease());
        signalEvent.setConnectionType$paytmnotification_paytmRelease(config.getConnectionType$paytmnotification_paytmRelease());
    }

    public static Locale b() {
        try {
            Resources system = Resources.getSystem();
            k.a((Object) system, "Resources.getSystem()");
            return androidx.core.d.c.a(system.getConfiguration()).a(0);
        } catch (Exception e2) {
            e.f43014a.b(e2);
            return null;
        }
    }

    private final String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.f43608c.b(obj);
    }
}

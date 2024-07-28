package com.paytm.analytics.b;

import android.content.res.Resources;
import com.google.gson.f;
import com.paytm.a.a.b;
import com.paytm.analytics.models.Config;
import com.paytm.analytics.models.PaytmLocation;
import com.paytm.analytics.models.SignalEvent;
import com.paytm.analytics.schedulers.a;
import com.paytm.analytics.schedulers.c;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final f f40923a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final a f40924b;

    /* renamed from: c  reason: collision with root package name */
    private final a f40925c;

    /* renamed from: d  reason: collision with root package name */
    private final com.paytm.analytics.data.a f40926d;

    public b(a aVar, a aVar2, com.paytm.analytics.data.a aVar3) {
        k.c(aVar, "configProvider");
        k.c(aVar2, "jobScheduler");
        k.c(aVar3, "analyticsEventRepository");
        this.f40924b = aVar;
        this.f40925c = aVar2;
        this.f40926d = aVar3;
    }

    public final void a(SignalEvent signalEvent, PaytmLocation paytmLocation) {
        k.c(signalEvent, "signalEvent");
        try {
            if (b(signalEvent, paytmLocation)) {
                Integer priority = signalEvent.getPriority();
                if (priority != null) {
                    if (priority.intValue() == 100) {
                        b();
                        return;
                    }
                }
                c();
            }
        } catch (com.paytm.a.a e2) {
            b.C0678b bVar = com.paytm.a.a.b.f40832a;
            bVar.a("DoNotRetryException " + e2.getLocalizedMessage(), new Object[0]);
        } catch (Exception e3) {
            e3.printStackTrace();
            com.paytm.a.a.b.f40832a.b(e3);
        }
    }

    private void b() {
        boolean z = true;
        try {
            com.paytm.a.a.b.f40832a.a("uploadPriorityEvents(): send signal events", new Object[0]);
            com.paytm.analytics.schedulers.b bVar = com.paytm.analytics.schedulers.b.f40976a;
            z = com.paytm.analytics.schedulers.b.a(this.f40924b.f40920a, this.f40926d, this.f40925c, true);
        } catch (com.paytm.a.a unused) {
        }
        if (!z) {
            this.f40925c.a(30000);
        }
    }

    private final boolean b(SignalEvent signalEvent, PaytmLocation paytmLocation) {
        if (signalEvent.getPayload() == null) {
            com.paytm.a.a.b.f40832a.a("SignalSDKLog - Event discarded at paytm analytics , null event found", new Object[0]);
            return false;
        }
        if (this.f40924b.f40920a.getCustomDimension() != null && (signalEvent.getPayload() instanceof Map)) {
            com.paytm.analytics.a.b bVar = com.paytm.analytics.a.b.f40910a;
            Object payload = signalEvent.getPayload();
            if (payload != null) {
                Map map = (Map) payload;
                Map<String, String> customDimension = this.f40924b.f40920a.getCustomDimension();
                if (customDimension == null) {
                    k.a();
                }
                signalEvent.setPayload(bVar.a((Map<String, ? extends Object>) map, customDimension));
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            }
        }
        a(signalEvent, this.f40924b.f40920a, paytmLocation);
        this.f40926d.a(signalEvent);
        b.C0678b bVar2 = com.paytm.a.a.b.f40832a;
        bVar2.a("SignalSDKLog - New event  received by paytm analytics " + signalEvent.getEventType(), new Object[0]);
        b.C0678b bVar3 = com.paytm.a.a.b.f40832a;
        bVar3.a("SignalSDKLog - PaytmAnalytics Event added to local db " + signalEvent.getPayload() + " type:" + signalEvent.getEventType(), new Object[0]);
        return true;
    }

    private final void a(SignalEvent signalEvent, Config config, PaytmLocation paytmLocation) {
        signalEvent.setPayload(a(signalEvent.getPayload()));
        signalEvent.setDeviceId$paytmanalytics_release(config.getDeviceId());
        signalEvent.setCustomerId$paytmanalytics_release(config.getUserId$paytmanalytics_release());
        Integer messageVersion = config.getMessageVersion();
        signalEvent.setMessageVersion$paytmanalytics_release(Integer.valueOf(messageVersion != null ? messageVersion.intValue() : 0));
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = c.f40979a;
        signalEvent.setDeviceDateTime$paytmanalytics_release(Long.valueOf(currentTimeMillis + c.a()));
        signalEvent.setClientId$paytmanalytics_release(config.getClientName());
        signalEvent.setAppVersion$paytmanalytics_release(config.getAppVersion());
        signalEvent.setAppLanguage$paytmanalytics_release(config.getAppLanguage());
        signalEvent.setLastAppOpenDate$paytmanalytics_release(config.getLastAppOpenDate$paytmanalytics_release());
        signalEvent.setOsType$paytmanalytics_release(config.getOsType());
        signalEvent.setOsVersion$paytmanalytics_release(config.getOsVersion$paytmanalytics_release());
        signalEvent.setModel$paytmanalytics_release(config.getModel$paytmanalytics_release());
        signalEvent.setBrand$paytmanalytics_release(config.getBrand$paytmanalytics_release());
        if (paytmLocation != null) {
            signalEvent.setLatitude$paytmanalytics_release(String.valueOf(paytmLocation.getLatitude()));
            signalEvent.setLongitude$paytmanalytics_release(String.valueOf(paytmLocation.getLongitude()));
        }
        signalEvent.setAdvertisementId$paytmanalytics_release(config.getAdvertisementId$paytmanalytics_release());
        signalEvent.setIp$paytmanalytics_release(config.getIp$paytmanalytics_release());
        signalEvent.setCarrier$paytmanalytics_release(config.getCarrier$paytmanalytics_release());
        signalEvent.setConnectionType$paytmanalytics_release(config.getConnectionType$paytmanalytics_release());
    }

    public static Locale a() {
        try {
            Resources system = Resources.getSystem();
            k.a((Object) system, "Resources.getSystem()");
            return androidx.core.d.c.a(system.getConfiguration()).a(0);
        } catch (Exception e2) {
            com.paytm.a.a.b.f40832a.b(e2);
            return null;
        }
    }

    private final String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.f40923a.b(obj);
    }

    private final void c() {
        long j;
        Integer uploadFrequency = this.f40924b.f40920a.getUploadFrequency();
        if ((uploadFrequency != null ? uploadFrequency.intValue() : 0) <= 0) {
            j = 10000;
        } else {
            Integer uploadFrequency2 = this.f40924b.f40920a.getUploadFrequency();
            if (uploadFrequency2 == null) {
                k.a();
            }
            j = ((long) uploadFrequency2.intValue()) * 1000;
        }
        this.f40925c.a(j);
    }
}

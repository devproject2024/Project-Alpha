package com.paytm.analytics.data;

import android.content.SharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.analytics.models.SignalEvent;
import com.paytm.analytics.models.SignalEventDb;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f40955a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final f f40956b = new f();

    /* renamed from: c  reason: collision with root package name */
    private long f40957c;

    /* renamed from: d  reason: collision with root package name */
    private final d f40958d;

    /* renamed from: e  reason: collision with root package name */
    private final c f40959e;

    public b(d dVar, c cVar) {
        k.c(dVar, "eventDao");
        k.c(cVar, "configPreferenceStore");
        this.f40958d = dVar;
        this.f40959e = cVar;
    }

    public final synchronized List<SignalEvent> a() {
        return b(this.f40958d.a());
    }

    public final synchronized List<SignalEvent> b() {
        return b(this.f40958d.b());
    }

    public final synchronized void a(List<Long> list) {
        this.f40958d.a(list);
    }

    private final List<SignalEvent> b(List<SignalEventDb> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                SignalEvent signalEvent = (SignalEvent) this.f40956b.a(list.get(i2).getSignalEvent(), SignalEvent.class);
                signalEvent.setId$paytmanalytics_release(Long.valueOf(list.get(i2).getId()));
                arrayList.add(signalEvent);
            } catch (Exception e2) {
                com.paytm.a.a.b.f40832a.b(e2);
            }
        }
        return arrayList;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final synchronized void a(SignalEvent signalEvent) {
        k.c(signalEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        SignalEventDb signalEventDb = new SignalEventDb(0, (Integer) null, (Long) null, (String) null, 15, (g) null);
        signalEventDb.setSignalEvent(this.f40956b.b(signalEvent));
        signalEventDb.setPriority(signalEvent.getPriority());
        signalEventDb.setDeviceDateTime(signalEvent.getDeviceDateTime$paytmanalytics_release());
        this.f40958d.a(signalEventDb);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f40957c == 0) {
                this.f40957c = this.f40959e.a().getLong("db_check_time", 0);
            }
            if (currentTimeMillis - this.f40957c > 480000) {
                this.f40957c = currentTimeMillis;
                SharedPreferences.Editor edit = this.f40959e.a().edit();
                edit.putLong("db_check_time", currentTimeMillis);
                edit.apply();
                try {
                    int c2 = this.f40958d.c();
                    int i2 = c2 - 1200;
                    if (i2 >= 0) {
                        if (i2 <= 100) {
                            i2 = 100;
                        }
                        this.f40958d.a(this.f40958d.a(i2));
                        com.paytm.a.a.b.f40832a.d("(Not an error) DB reached 1200 max. Total db count: " + c2 + ", Deleting " + i2 + " items.", new Object[0]);
                        return;
                    }
                } catch (Exception e2) {
                    com.paytm.a.a.b.f40832a.b(e2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return;
        return;
    }
}

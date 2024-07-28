package com.paytm.signal.data;

import android.content.SharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.signal.models.SignalEvent;
import com.paytm.signal.models.SignalEventDb;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43638a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final f f43639b = new f();

    /* renamed from: c  reason: collision with root package name */
    private long f43640c;

    /* renamed from: d  reason: collision with root package name */
    private final d f43641d;

    /* renamed from: e  reason: collision with root package name */
    private final c f43642e;

    public b(d dVar, c cVar) {
        k.c(dVar, "eventDao");
        k.c(cVar, "configPreferenceStore");
        this.f43641d = dVar;
        this.f43642e = cVar;
    }

    public final synchronized List<SignalEvent> a() {
        return b(this.f43641d.a());
    }

    public final synchronized List<SignalEvent> b() {
        return b(this.f43641d.b());
    }

    public final synchronized void a(List<Long> list) {
        this.f43641d.a(list);
    }

    private final List<SignalEvent> b(List<SignalEventDb> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                SignalEvent signalEvent = (SignalEvent) this.f43639b.a(list.get(i2).getSignalEvent(), SignalEvent.class);
                signalEvent.setId$paytmnotification_paytmRelease(Long.valueOf(list.get(i2).getId()));
                arrayList.add(signalEvent);
            } catch (Exception e2) {
                e.f43014a.b(e2);
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
        signalEventDb.setSignalEvent(this.f43639b.b(signalEvent));
        signalEventDb.setPriority(signalEvent.getPriority());
        signalEventDb.setDeviceDateTime(signalEvent.getDeviceDateTime$paytmnotification_paytmRelease());
        this.f43641d.a(signalEventDb);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f43640c == 0) {
                this.f43640c = this.f43642e.a().getLong("db_check_time", 0);
            }
            if (currentTimeMillis - this.f43640c > 480000) {
                this.f43640c = currentTimeMillis;
                SharedPreferences.Editor edit = this.f43642e.a().edit();
                edit.putLong("db_check_time", currentTimeMillis);
                edit.apply();
                try {
                    int c2 = this.f43641d.c();
                    int i2 = c2 - 1200;
                    if (i2 >= 0) {
                        if (i2 <= 100) {
                            i2 = 100;
                        }
                        this.f43641d.a(this.f43641d.a(i2));
                        e.f43014a.d("(Not an error) DB reached 1200 max. Total db count: " + c2 + ", Deleting " + i2 + " items.", new Object[0]);
                        return;
                    }
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return;
        return;
    }
}

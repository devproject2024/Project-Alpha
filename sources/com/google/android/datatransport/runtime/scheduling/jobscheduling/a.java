package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.c;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7896a;

    /* renamed from: b  reason: collision with root package name */
    private final c f7897b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f7898c;

    /* renamed from: d  reason: collision with root package name */
    private final g f7899d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.a f7900e;

    public a(Context context, c cVar, com.google.android.datatransport.runtime.d.a aVar, g gVar) {
        this(context, cVar, (AlarmManager) context.getSystemService("alarm"), aVar, gVar);
    }

    private a(Context context, c cVar, AlarmManager alarmManager, com.google.android.datatransport.runtime.d.a aVar, g gVar) {
        this.f7896a = context;
        this.f7897b = cVar;
        this.f7898c = alarmManager;
        this.f7900e = aVar;
        this.f7899d = gVar;
    }

    public final void a(l lVar, int i2) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", lVar.a());
        builder.appendQueryParameter("priority", String.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c())));
        if (lVar.b() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(lVar.b(), 0));
        }
        Intent intent = new Intent(this.f7896a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        if (PendingIntent.getBroadcast(this.f7896a, 0, intent, 536870912) != null) {
            com.google.android.datatransport.runtime.a.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", (Object) lVar);
            return;
        }
        long a2 = this.f7897b.a(lVar);
        long a3 = this.f7899d.a(lVar.c(), a2, i2);
        com.google.android.datatransport.runtime.a.a.a("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", lVar, Long.valueOf(a3), Long.valueOf(a2), Integer.valueOf(i2));
        this.f7898c.set(3, this.f7900e.a() + a3, PendingIntent.getBroadcast(this.f7896a, 0, intent, 0));
    }
}

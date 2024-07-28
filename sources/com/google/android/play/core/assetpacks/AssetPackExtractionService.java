package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.play.core.b.b;

public class AssetPackExtractionService extends Service {

    /* renamed from: a  reason: collision with root package name */
    Context f36937a;

    /* renamed from: b  reason: collision with root package name */
    cw f36938b;

    /* renamed from: c  reason: collision with root package name */
    ad f36939c;

    /* renamed from: d  reason: collision with root package name */
    private final b f36940d = new b("AssetPackExtractionService");

    /* renamed from: e  reason: collision with root package name */
    private aa f36941e;

    /* renamed from: f  reason: collision with root package name */
    private NotificationManager f36942f;

    private final synchronized void b(Bundle bundle) {
        String string = bundle.getString("notification_title");
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f36937a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.f36937a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f36940d.d("Starting foreground service.", new Object[0]);
        this.f36938b.a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f36942f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    public final synchronized Bundle a(Bundle bundle) {
        int i2 = bundle.getInt("action_type");
        b bVar = this.f36940d;
        Integer valueOf = Integer.valueOf(i2);
        bVar.a("updateServiceState: %d", valueOf);
        if (i2 == 1) {
            b(bundle);
        } else if (i2 != 2) {
            this.f36940d.b("Unknown action type received: %d", valueOf);
        } else {
            a();
        }
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        this.f36940d.d("Stopping service.", new Object[0]);
        this.f36938b.a(false);
        stopForeground(true);
        stopSelf();
    }

    public final IBinder onBind(Intent intent) {
        return this.f36941e;
    }

    public final void onCreate() {
        super.onCreate();
        this.f36940d.a("onCreate", new Object[0]);
        by.a(getApplicationContext()).a(this);
        this.f36941e = new aa(this.f36937a, this, this.f36939c);
        this.f36942f = (NotificationManager) this.f36937a.getSystemService("notification");
    }
}

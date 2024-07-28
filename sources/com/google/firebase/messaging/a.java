package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.h;
import androidx.core.content.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f38995a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: com.google.firebase.messaging.a$a  reason: collision with other inner class name */
    public static class C0651a {

        /* renamed from: a  reason: collision with root package name */
        public final h.e f38996a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38997b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38998c = 0;

        C0651a(h.e eVar, String str) {
            this.f38996a = eVar;
            this.f38997b = str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.messaging.a.C0651a a(android.content.Context r9, com.google.firebase.messaging.n r10) {
        /*
            android.content.pm.PackageManager r0 = r9.getPackageManager()
            java.lang.String r1 = r9.getPackageName()
            android.os.Bundle r0 = a((android.content.pm.PackageManager) r0, (java.lang.String) r1)
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "gcm.n.android_channel_id"
            java.lang.String r2 = r10.a((java.lang.String) r2)
            java.lang.String r2 = b(r9, r2, r0)
            android.content.res.Resources r3 = r9.getResources()
            android.content.pm.PackageManager r4 = r9.getPackageManager()
            androidx.core.app.h$e r5 = new androidx.core.app.h$e
            r5.<init>(r9, r2)
            java.lang.String r2 = "gcm.n.title"
            java.lang.String r2 = r10.a(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0036
            r5.a((java.lang.CharSequence) r2)
        L_0x0036:
            java.lang.String r2 = "gcm.n.body"
            java.lang.String r2 = r10.a(r3, r1, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0051
            r5.b((java.lang.CharSequence) r2)
            androidx.core.app.h$c r6 = new androidx.core.app.h$c
            r6.<init>()
            androidx.core.app.h$c r2 = r6.a((java.lang.CharSequence) r2)
            r5.a((androidx.core.app.h.C0039h) r2)
        L_0x0051:
            java.lang.String r2 = "gcm.n.icon"
            java.lang.String r2 = r10.a((java.lang.String) r2)
            int r2 = a(r4, r3, r1, r2, r0)
            r5.a((int) r2)
            java.lang.String r2 = "gcm.n.sound2"
            java.lang.String r2 = r10.a((java.lang.String) r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L_0x0070
            java.lang.String r2 = "gcm.n.sound"
            java.lang.String r2 = r10.a((java.lang.String) r2)
        L_0x0070:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 2
            r8 = 0
            if (r6 == 0) goto L_0x007a
            r2 = r8
            goto L_0x00bf
        L_0x007a:
            java.lang.String r6 = "default"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x00bb
            java.lang.String r6 = "raw"
            int r3 = r3.getIdentifier(r2, r6, r1)
            if (r3 == 0) goto L_0x00bb
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r3 = r3 + 24
            java.lang.String r6 = java.lang.String.valueOf(r2)
            int r6 = r6.length()
            int r3 = r3 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            java.lang.String r3 = "android.resource://"
            r6.append(r3)
            r6.append(r1)
            java.lang.String r3 = "/raw/"
            r6.append(r3)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            goto L_0x00bf
        L_0x00bb:
            android.net.Uri r2 = android.media.RingtoneManager.getDefaultUri(r7)
        L_0x00bf:
            if (r2 == 0) goto L_0x00c4
            r5.a((android.net.Uri) r2)
        L_0x00c4:
            java.lang.String r2 = "gcm.n.click_action"
            java.lang.String r2 = r10.a((java.lang.String) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00de
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r2)
            r3.setPackage(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r3.setFlags(r1)
            goto L_0x0110
        L_0x00de:
            java.lang.String r2 = "gcm.n.link_android"
            java.lang.String r2 = r10.a((java.lang.String) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x00f0
            java.lang.String r2 = "gcm.n.link"
            java.lang.String r2 = r10.a((java.lang.String) r2)
        L_0x00f0:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00fb
            android.net.Uri r2 = android.net.Uri.parse(r2)
            goto L_0x00fc
        L_0x00fb:
            r2 = r8
        L_0x00fc:
            if (r2 == 0) goto L_0x010c
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            r3.setPackage(r1)
            r3.setData(r2)
            goto L_0x0110
        L_0x010c:
            android.content.Intent r3 = r4.getLaunchIntentForPackage(r1)
        L_0x0110:
            java.lang.String r1 = "google.c.a.e"
            if (r3 != 0) goto L_0x0116
            r2 = r8
            goto L_0x014d
        L_0x0116:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r2)
            android.os.Bundle r2 = r10.c()
            r3.putExtras(r2)
            java.util.concurrent.atomic.AtomicInteger r2 = f38995a
            int r2 = r2.incrementAndGet()
            r4 = 1073741824(0x40000000, float:2.0)
            android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r9, r2, r3, r4)
            boolean r3 = r10.b(r1)
            if (r3 == 0) goto L_0x014d
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "com.google.firebase.messaging.NOTIFICATION_OPEN"
            r3.<init>(r4)
            android.os.Bundle r4 = r10.d()
            android.content.Intent r3 = r3.putExtras(r4)
            java.lang.String r4 = "pending_intent"
            android.content.Intent r2 = r3.putExtra(r4, r2)
            android.app.PendingIntent r2 = a((android.content.Context) r9, (android.content.Intent) r2)
        L_0x014d:
            r5.f2723f = r2
            boolean r1 = r10.b(r1)
            if (r1 != 0) goto L_0x0157
            r1 = r8
            goto L_0x016a
        L_0x0157:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r1.<init>(r2)
            android.os.Bundle r2 = r10.d()
            android.content.Intent r1 = r1.putExtras(r2)
            android.app.PendingIntent r1 = a((android.content.Context) r9, (android.content.Intent) r1)
        L_0x016a:
            if (r1 == 0) goto L_0x0170
            android.app.Notification r2 = r5.P
            r2.deleteIntent = r1
        L_0x0170:
            java.lang.String r1 = "gcm.n.color"
            java.lang.String r1 = r10.a((java.lang.String) r1)
            java.lang.Integer r9 = a(r9, r1, r0)
            if (r9 == 0) goto L_0x0182
            int r9 = r9.intValue()
            r5.C = r9
        L_0x0182:
            java.lang.String r9 = "gcm.n.sticky"
            boolean r9 = r10.b(r9)
            r0 = 1
            r9 = r9 ^ r0
            r5.a((boolean) r9)
            java.lang.String r9 = "gcm.n.local_only"
            boolean r9 = r10.b(r9)
            r5.x = r9
            java.lang.String r9 = "gcm.n.ticker"
            java.lang.String r9 = r10.a((java.lang.String) r9)
            if (r9 == 0) goto L_0x01a0
            r5.d(r9)
        L_0x01a0:
            java.lang.String r9 = "gcm.n.notification_priority"
            java.lang.Integer r9 = r10.c(r9)
            r1 = -2
            if (r9 != 0) goto L_0x01ab
        L_0x01a9:
            r9 = r8
            goto L_0x01d8
        L_0x01ab:
            int r2 = r9.intValue()
            if (r2 < r1) goto L_0x01b7
            int r2 = r9.intValue()
            if (r2 <= r7) goto L_0x01d8
        L_0x01b7:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 72
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "notificationPriority is invalid "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting notificationPriority."
            r3.append(r9)
            goto L_0x01a9
        L_0x01d8:
            if (r9 == 0) goto L_0x01e0
            int r9 = r9.intValue()
            r5.l = r9
        L_0x01e0:
            java.lang.String r9 = "gcm.n.visibility"
            java.lang.Integer r9 = r10.c(r9)
            if (r9 != 0) goto L_0x01ea
        L_0x01e8:
            r9 = r8
            goto L_0x0219
        L_0x01ea:
            int r2 = r9.intValue()
            r3 = -1
            if (r2 < r3) goto L_0x01f7
            int r2 = r9.intValue()
            if (r2 <= r0) goto L_0x0219
        L_0x01f7:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "visibility is invalid: "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting visibility."
            r3.append(r9)
            goto L_0x01e8
        L_0x0219:
            if (r9 == 0) goto L_0x0221
            int r9 = r9.intValue()
            r5.D = r9
        L_0x0221:
            java.lang.String r9 = "gcm.n.notification_count"
            java.lang.Integer r9 = r10.c(r9)
            if (r9 != 0) goto L_0x022a
            goto L_0x0252
        L_0x022a:
            int r2 = r9.intValue()
            if (r2 >= 0) goto L_0x0251
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            int r2 = r2.length()
            int r2 = r2 + 67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "notificationCount is invalid: "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = ". Skipping setting notificationCount."
            r3.append(r9)
            goto L_0x0252
        L_0x0251:
            r8 = r9
        L_0x0252:
            if (r8 == 0) goto L_0x025a
            int r9 = r8.intValue()
            r5.k = r9
        L_0x025a:
            java.lang.String r9 = "gcm.n.event_time"
            java.lang.Long r9 = r10.d(r9)
            if (r9 == 0) goto L_0x026b
            r5.m = r0
            long r2 = r9.longValue()
            r5.a((long) r2)
        L_0x026b:
            long[] r9 = r10.a()
            if (r9 == 0) goto L_0x0275
            android.app.Notification r2 = r5.P
            r2.vibrate = r9
        L_0x0275:
            int[] r9 = r10.b()
            if (r9 == 0) goto L_0x02a6
            r2 = 0
            r3 = r9[r2]
            r4 = r9[r0]
            r9 = r9[r7]
            android.app.Notification r6 = r5.P
            r6.ledARGB = r3
            android.app.Notification r3 = r5.P
            r3.ledOnMS = r4
            android.app.Notification r3 = r5.P
            r3.ledOffMS = r9
            android.app.Notification r9 = r5.P
            int r9 = r9.ledOnMS
            if (r9 == 0) goto L_0x029b
            android.app.Notification r9 = r5.P
            int r9 = r9.ledOffMS
            if (r9 == 0) goto L_0x029b
            goto L_0x029c
        L_0x029b:
            r0 = 0
        L_0x029c:
            android.app.Notification r9 = r5.P
            android.app.Notification r2 = r5.P
            int r2 = r2.flags
            r1 = r1 & r2
            r0 = r0 | r1
            r9.flags = r0
        L_0x02a6:
            java.lang.String r9 = "gcm.n.default_sound"
            boolean r9 = r10.b(r9)
            java.lang.String r0 = "gcm.n.default_vibrate_timings"
            boolean r0 = r10.b(r0)
            if (r0 == 0) goto L_0x02b6
            r9 = r9 | 2
        L_0x02b6:
            java.lang.String r0 = "gcm.n.default_light_settings"
            boolean r0 = r10.b(r0)
            if (r0 == 0) goto L_0x02c0
            r9 = r9 | 4
        L_0x02c0:
            r5.b((int) r9)
            com.google.firebase.messaging.a$a r9 = new com.google.firebase.messaging.a$a
            java.lang.String r0 = "gcm.n.tag"
            java.lang.String r10 = r10.a((java.lang.String) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x02d2
            goto L_0x02e9
        L_0x02d2:
            long r0 = android.os.SystemClock.uptimeMillis()
            r10 = 37
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            java.lang.String r10 = "FCM-Notification:"
            r2.append(r10)
            r2.append(r0)
            java.lang.String r10 = r2.toString()
        L_0x02e9:
            r9.<init>(r5, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.a.a(android.content.Context, com.google.firebase.messaging.n):com.google.firebase.messaging.a$a");
    }

    private static boolean a(Resources resources, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i2, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i2);
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i2);
            sb2.append(", treating it as an invalid icon");
            return false;
        }
    }

    private static int a(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && a(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && a(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
        }
        int i2 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i2 == 0 || !a(resources, i2)) {
            try {
                i2 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
            }
        }
        if (i2 == 0 || !a(resources, i2)) {
            return 17301651;
        }
        return i2;
    }

    private static Integer a(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
            }
        }
        int i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i2 != 0) {
            try {
                return Integer.valueOf(b.c(context, i2));
            } catch (Resources.NotFoundException unused2) {
            }
        }
        return null;
    }

    private static Bundle a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                return applicationInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
        }
        return Bundle.EMPTY;
    }

    private static String b(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(string) && notificationManager.getNotificationChannel(string) != null) {
                return string;
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, f38995a.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }
}

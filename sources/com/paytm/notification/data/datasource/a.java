package com.paytm.notification.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.NotificationUserConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.x;

public final class a {
    private static String A = null;
    private static final String B = B;
    private static final String C = C;
    private static final String D = D;
    private static final String E = E;
    private static final String F = F;
    private static SharedPreferences G = null;
    private static final f H = new f();
    private static final ExecutorService I = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public static final String f43080a = f43080a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43081b = f43081b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f43082c = f43082c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f43083d = f43083d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f43084e = f43084e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f43085f = f43085f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f43086g = f43086g;

    /* renamed from: h  reason: collision with root package name */
    public static NotificationUserConfig f43087h = null;

    /* renamed from: i  reason: collision with root package name */
    public static final a f43088i = new a();
    private static final String j = j;
    private static final String k = "device_id";
    private static final String l = l;
    private static final String m = m;
    private static final String n = n;
    private static final String o = o;
    private static final String p = p;
    private static final String q = q;
    private static final String r = r;
    private static final String s = s;
    private static final String t = t;
    private static final String u = u;
    private static final String v = v;
    private static final String w = w;
    private static final String x = x;
    private static final String y = y;
    private static final String z = "staging";

    private a() {
    }

    public final SharedPreferences a() {
        if (G == null) {
            synchronized (this) {
                if (G == null) {
                    g.c cVar = g.f43191a;
                    if (g.f43192h == null) {
                        e.f43014a.d("PaytmNotifications.appContext == null", new Object[0]);
                    }
                    g.c cVar2 = g.f43191a;
                    Context d2 = g.f43192h;
                    G = d2 != null ? d2.getSharedPreferences(j, 0) : null;
                }
                x xVar = x.f47997a;
            }
        }
        SharedPreferences sharedPreferences = G;
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences;
    }

    public final synchronized void a(NotificationUserConfig notificationUserConfig) {
        k.c(notificationUserConfig, "notificationUserConfig");
        SharedPreferences.Editor edit = a().edit();
        if (notificationUserConfig.getAppVersion$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig2 = f43087h;
            if (notificationUserConfig2 != null) {
                notificationUserConfig2.setAppVersion$paytmnotification_paytmRelease(notificationUserConfig.getAppVersion$paytmnotification_paytmRelease());
            }
            edit.putString(q, notificationUserConfig.getAppVersion$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getClientName$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig3 = f43087h;
            if (notificationUserConfig3 != null) {
                notificationUserConfig3.setClientName$paytmnotification_paytmRelease(notificationUserConfig.getClientName$paytmnotification_paytmRelease());
            }
            edit.putString(s, notificationUserConfig.getClientName$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getSecret$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig4 = f43087h;
            if (notificationUserConfig4 != null) {
                notificationUserConfig4.setSecret$paytmnotification_paytmRelease(notificationUserConfig.getSecret$paytmnotification_paytmRelease());
            }
            A = notificationUserConfig.getSecret$paytmnotification_paytmRelease();
        }
        if (notificationUserConfig.getMsgIcon$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig5 = f43087h;
            if (notificationUserConfig5 != null) {
                notificationUserConfig5.setMsgIcon$paytmnotification_paytmRelease(notificationUserConfig.getMsgIcon$paytmnotification_paytmRelease());
            }
            String str = y;
            Integer msgIcon$paytmnotification_paytmRelease = notificationUserConfig.getMsgIcon$paytmnotification_paytmRelease();
            if (msgIcon$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putInt(str, msgIcon$paytmnotification_paytmRelease.intValue());
        }
        if (notificationUserConfig.getLoginState$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig6 = f43087h;
            if (notificationUserConfig6 != null) {
                notificationUserConfig6.setLoginState$paytmnotification_paytmRelease(notificationUserConfig.getLoginState$paytmnotification_paytmRelease());
            }
            edit.putString(B, notificationUserConfig.getLoginState$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getConfigEndPoints$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig7 = f43087h;
            if (notificationUserConfig7 != null) {
                notificationUserConfig7.setConfigEndPoints$paytmnotification_paytmRelease(notificationUserConfig.getConfigEndPoints$paytmnotification_paytmRelease());
            }
            edit.putString(C, notificationUserConfig.getConfigEndPoints$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getCustomerId$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig8 = f43087h;
            if (notificationUserConfig8 != null) {
                notificationUserConfig8.setCustomerId$paytmnotification_paytmRelease(notificationUserConfig.getCustomerId$paytmnotification_paytmRelease());
            }
            edit.putString(f43080a, notificationUserConfig.getCustomerId$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getServerEndPoints$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig9 = f43087h;
            if (notificationUserConfig9 != null) {
                notificationUserConfig9.setServerEndPoints$paytmnotification_paytmRelease(notificationUserConfig.getServerEndPoints$paytmnotification_paytmRelease());
            }
            edit.putString(l, notificationUserConfig.getServerEndPoints$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getInboxEndPoints$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig10 = f43087h;
            if (notificationUserConfig10 != null) {
                notificationUserConfig10.setInboxEndPoints$paytmnotification_paytmRelease(notificationUserConfig.getInboxEndPoints$paytmnotification_paytmRelease());
            }
            edit.putString(m, notificationUserConfig.getInboxEndPoints$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getFlashEndPoint$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig11 = f43087h;
            if (notificationUserConfig11 != null) {
                notificationUserConfig11.setFlashEndPoint$paytmnotification_paytmRelease(notificationUserConfig.getFlashEndPoint$paytmnotification_paytmRelease());
            }
            edit.putString(n, notificationUserConfig.getFlashEndPoint$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getEventBatchEndPoint$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig12 = f43087h;
            if (notificationUserConfig12 != null) {
                notificationUserConfig12.setEventBatchEndPoint$paytmnotification_paytmRelease(notificationUserConfig.getEventBatchEndPoint$paytmnotification_paytmRelease());
            }
            edit.putString(o, notificationUserConfig.getEventBatchEndPoint$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getEventBatchFrequency$paytmnotification_paytmRelease() != null) {
            Integer eventBatchFrequency$paytmnotification_paytmRelease = notificationUserConfig.getEventBatchFrequency$paytmnotification_paytmRelease();
            if ((eventBatchFrequency$paytmnotification_paytmRelease != null ? eventBatchFrequency$paytmnotification_paytmRelease.intValue() : 0) > 0) {
                NotificationUserConfig notificationUserConfig13 = f43087h;
                if (notificationUserConfig13 != null) {
                    notificationUserConfig13.setEventBatchFrequency$paytmnotification_paytmRelease(notificationUserConfig.getEventBatchFrequency$paytmnotification_paytmRelease());
                }
                String str2 = w;
                Integer eventBatchFrequency$paytmnotification_paytmRelease2 = notificationUserConfig.getEventBatchFrequency$paytmnotification_paytmRelease();
                edit.putInt(str2, eventBatchFrequency$paytmnotification_paytmRelease2 != null ? eventBatchFrequency$paytmnotification_paytmRelease2.intValue() : 0);
            }
        }
        if (notificationUserConfig.getEventBatchSize$paytmnotification_paytmRelease() != null) {
            Integer eventBatchSize$paytmnotification_paytmRelease = notificationUserConfig.getEventBatchSize$paytmnotification_paytmRelease();
            if ((eventBatchSize$paytmnotification_paytmRelease != null ? eventBatchSize$paytmnotification_paytmRelease.intValue() : 0) > 0) {
                NotificationUserConfig notificationUserConfig14 = f43087h;
                if (notificationUserConfig14 != null) {
                    notificationUserConfig14.setEventBatchSize$paytmnotification_paytmRelease(notificationUserConfig.getEventBatchSize$paytmnotification_paytmRelease());
                }
                String str3 = x;
                Integer eventBatchSize$paytmnotification_paytmRelease2 = notificationUserConfig.getEventBatchSize$paytmnotification_paytmRelease();
                edit.putInt(str3, eventBatchSize$paytmnotification_paytmRelease2 != null ? eventBatchSize$paytmnotification_paytmRelease2.intValue() : 0);
            }
        }
        if (notificationUserConfig.isInboxEnabled$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig15 = f43087h;
            if (notificationUserConfig15 != null) {
                notificationUserConfig15.setInboxEnabled$paytmnotification_paytmRelease(notificationUserConfig.isInboxEnabled$paytmnotification_paytmRelease());
            }
            String str4 = t;
            Boolean isInboxEnabled$paytmnotification_paytmRelease = notificationUserConfig.isInboxEnabled$paytmnotification_paytmRelease();
            if (isInboxEnabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putBoolean(str4, isInboxEnabled$paytmnotification_paytmRelease.booleanValue());
        }
        if (notificationUserConfig.isFlashEnabled$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig16 = f43087h;
            if (notificationUserConfig16 != null) {
                notificationUserConfig16.setFlashEnabled$paytmnotification_paytmRelease(notificationUserConfig.isFlashEnabled$paytmnotification_paytmRelease());
            }
            String str5 = u;
            Boolean isFlashEnabled$paytmnotification_paytmRelease = notificationUserConfig.isFlashEnabled$paytmnotification_paytmRelease();
            if (isFlashEnabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putBoolean(str5, isFlashEnabled$paytmnotification_paytmRelease.booleanValue());
        }
        if (notificationUserConfig.isPushEnabled$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig17 = f43087h;
            if (notificationUserConfig17 != null) {
                notificationUserConfig17.setPushEnabled$paytmnotification_paytmRelease(notificationUserConfig.isPushEnabled$paytmnotification_paytmRelease());
            }
            String str6 = v;
            Boolean isPushEnabled$paytmnotification_paytmRelease = notificationUserConfig.isPushEnabled$paytmnotification_paytmRelease();
            if (isPushEnabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putBoolean(str6, isPushEnabled$paytmnotification_paytmRelease.booleanValue());
        }
        if (notificationUserConfig.getDeviceId$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig18 = f43087h;
            if (notificationUserConfig18 != null) {
                notificationUserConfig18.setDeviceId$paytmnotification_paytmRelease(notificationUserConfig.getDeviceId$paytmnotification_paytmRelease());
            }
            edit.putString(k, notificationUserConfig.getDeviceId$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getAppLanguage$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig19 = f43087h;
            if (notificationUserConfig19 != null) {
                notificationUserConfig19.setAppLanguage$paytmnotification_paytmRelease(notificationUserConfig.getAppLanguage$paytmnotification_paytmRelease());
            }
            edit.putString(p, notificationUserConfig.getAppLanguage$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getBuildFlavour$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig20 = f43087h;
            if (notificationUserConfig20 != null) {
                notificationUserConfig20.setBuildFlavour$paytmnotification_paytmRelease(notificationUserConfig.getBuildFlavour$paytmnotification_paytmRelease());
            }
            edit.putString(r, notificationUserConfig.getBuildFlavour$paytmnotification_paytmRelease());
        }
        if (notificationUserConfig.getShowDebugLogs$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig21 = f43087h;
            if (notificationUserConfig21 != null) {
                notificationUserConfig21.setShowDebugLogs$paytmnotification_paytmRelease(notificationUserConfig.getShowDebugLogs$paytmnotification_paytmRelease());
            }
            String str7 = D;
            Boolean showDebugLogs$paytmnotification_paytmRelease = notificationUserConfig.getShowDebugLogs$paytmnotification_paytmRelease();
            if (showDebugLogs$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putBoolean(str7, showDebugLogs$paytmnotification_paytmRelease.booleanValue());
        }
        if (notificationUserConfig.getEnableInboxCountSchedule$paytmnotification_paytmRelease() != null) {
            NotificationUserConfig notificationUserConfig22 = f43087h;
            if (notificationUserConfig22 != null) {
                notificationUserConfig22.setEnableInboxCountSchedule$paytmnotification_paytmRelease(notificationUserConfig.getEnableInboxCountSchedule$paytmnotification_paytmRelease());
            }
            String str8 = E;
            Boolean enableInboxCountSchedule$paytmnotification_paytmRelease = notificationUserConfig.getEnableInboxCountSchedule$paytmnotification_paytmRelease();
            if (enableInboxCountSchedule$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putBoolean(str8, enableInboxCountSchedule$paytmnotification_paytmRelease.booleanValue());
        }
        if (notificationUserConfig.getInboxCountScheduleInterval$paytmnotification_paytmRelease() != null) {
            String str9 = F;
            Long inboxCountScheduleInterval$paytmnotification_paytmRelease = notificationUserConfig.getInboxCountScheduleInterval$paytmnotification_paytmRelease();
            if (inboxCountScheduleInterval$paytmnotification_paytmRelease == null) {
                k.a();
            }
            edit.putLong(str9, inboxCountScheduleInterval$paytmnotification_paytmRelease.longValue());
        }
        edit.apply();
        e.f43014a.a("User saved to prefernces", new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0119, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.paytm.notification.models.NotificationUserConfig b() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.paytm.notification.models.NotificationUserConfig r0 = f43087h     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x000e
            com.paytm.notification.models.NotificationUserConfig r0 = f43087h     // Catch:{ all -> 0x011a }
            if (r0 != 0) goto L_0x000c
            kotlin.g.b.k.a()     // Catch:{ all -> 0x011a }
        L_0x000c:
            monitor-exit(r6)
            return r0
        L_0x000e:
            android.content.SharedPreferences r0 = r6.a()     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = new com.paytm.notification.models.NotificationUserConfig$Builder     // Catch:{ all -> 0x011a }
            r1.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r2 = f43080a     // Catch:{ all -> 0x011a }
            r3 = 0
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setCustomerId(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = k     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setDeviceId(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = l     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setServerEndPoints(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = p     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setAppLanguage(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = q     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setAppVersion(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setBuildFlavour(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = s     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setClientName(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = m     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setInboxEndPoints(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = t     // Catch:{ all -> 0x011a }
            r4 = 1
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setInboxEnabled(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = u     // Catch:{ all -> 0x011a }
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setFlashEnabled(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = v     // Catch:{ all -> 0x011a }
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setPushEnabled(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = o     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setEventBatchEndPoints(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = n     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setFlashEndPoints(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = w     // Catch:{ all -> 0x011a }
            r4 = 0
            int r2 = r0.getInt(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setEventBatchFrequency(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = x     // Catch:{ all -> 0x011a }
            int r2 = r0.getInt(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setEventBatchSize(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = A     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setSecret(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = y     // Catch:{ all -> 0x011a }
            r5 = -1
            int r2 = r0.getInt(r2, r5)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setMsgIcon(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = z     // Catch:{ all -> 0x011a }
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setStaging(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = B     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setLoginState(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = C     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setConfigEndPoints(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = D     // Catch:{ all -> 0x011a }
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setShowDebugLogs(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = E     // Catch:{ all -> 0x011a }
            boolean r2 = r0.getBoolean(r2, r4)     // Catch:{ all -> 0x011a }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r1 = r1.setEnableInboxCountSchedule(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = F     // Catch:{ all -> 0x011a }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ all -> 0x011a }
            r4 = 2
            long r3 = r3.toMillis(r4)     // Catch:{ all -> 0x011a }
            long r2 = r0.getLong(r2, r3)     // Catch:{ all -> 0x011a }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig$Builder r0 = r1.setInboxCountScheduleInterval(r0)     // Catch:{ all -> 0x011a }
            com.paytm.notification.models.NotificationUserConfig r0 = r0.build()     // Catch:{ all -> 0x011a }
            f43087h = r0     // Catch:{ all -> 0x011a }
            if (r0 != 0) goto L_0x0118
            kotlin.g.b.k.a()     // Catch:{ all -> 0x011a }
        L_0x0118:
            monitor-exit(r6)
            return r0
        L_0x011a:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.datasource.a.b():com.paytm.notification.models.NotificationUserConfig");
    }

    public static String c() {
        return A;
    }

    public final synchronized void a(String str) {
        A = str;
    }
}

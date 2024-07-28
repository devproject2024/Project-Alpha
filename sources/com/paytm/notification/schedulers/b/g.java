package com.paytm.notification.schedulers.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.paytm.notification.b.e;
import com.paytm.notification.c.b;
import com.paytm.notification.c.f;
import com.paytm.notification.data.c.h;
import com.paytm.notification.g;
import com.paytm.notification.j;
import com.paytm.notification.models.JOB_RESULT;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.callback.ChannelReadyCallback;
import com.paytm.notification.models.callback.ConfigChannelReadyCallback;
import com.paytm.notification.models.callback.ConfigReadyCallback;
import com.paytm.notification.models.request.DeviceDetails;
import com.paytm.notification.schedulers.b;
import com.paytm.notification.schedulers.c;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.Map;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f43280a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f43281b;

    private g() {
    }

    public final JOB_RESULT a(Context context) {
        k.c(context, "context");
        h c2 = j.f43241a.c();
        String b2 = c2.b();
        boolean d2 = c2.d();
        if (b2 == null) {
            e.f43014a.c("syncLogout failed: fcmToken is null. Device might be offline.", new Object[0]);
            return JOB_RESULT.RETRY;
        } else if (!d2) {
            return a(context, b2, c2);
        } else {
            e.f43014a.a("syncLogout already synced. Cancelling the work", new Object[0]);
            return JOB_RESULT.SUCCESS;
        }
    }

    public final JOB_RESULT b(Context context) {
        k.c(context, "context");
        h c2 = j.f43241a.c();
        String b2 = c2.b();
        if (b2 == null) {
            e.f43014a.c("syncLogin failed: fcmToken is null. Device might be offline.", new Object[0]);
            return JOB_RESULT.RETRY;
        } else if (!c2.e()) {
            return a(context, b2, c2);
        } else {
            e.f43014a.a("syncLogin already synced. Cancelling the work", new Object[0]);
            return JOB_RESULT.SUCCESS;
        }
    }

    public final JOB_RESULT a(Context context, String str, h hVar) {
        String str2;
        ConfigChannelReadyCallback k;
        k.c(context, "context");
        k.c(str, "updateToken");
        k.c(hVar, "pushConfigRepo");
        try {
            NotificationUserConfig a2 = hVar.a();
            boolean z = hVar.f() == null;
            if (a2.getServerEndPoints$paytmnotification_paytmRelease() == null) {
                g.c cVar = com.paytm.notification.g.f43191a;
                ConfigReadyCallback aVar = new a(context, str, hVar);
                k.c(aVar, "configReadyCallback");
                com.paytm.notification.g.m = aVar;
                return JOB_RESULT.DO_NOT_RETRY;
            }
            try {
                b bVar = b.f43023b;
                k.c(context, "context");
                DeviceDetails deviceDetails = new DeviceDetails();
                b.f43022a = deviceDetails;
                deviceDetails.setImei(b.a(context));
                DeviceDetails deviceDetails2 = b.f43022a;
                if (deviceDetails2 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails2.setName(Build.MODEL);
                DeviceDetails deviceDetails3 = b.f43022a;
                if (deviceDetails3 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails3.setModel(Build.MODEL);
                DeviceDetails deviceDetails4 = b.f43022a;
                if (deviceDetails4 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails4.setOsVersion(Build.VERSION.RELEASE);
                DeviceDetails deviceDetails5 = b.f43022a;
                if (deviceDetails5 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails5.setManufacturer(Build.MANUFACTURER);
                DeviceDetails deviceDetails6 = b.f43022a;
                if (deviceDetails6 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails6.setCategory(b.b(context));
                DeviceDetails deviceDetails7 = b.f43022a;
                if (deviceDetails7 == null) {
                    k.a("deviceDetails");
                }
                DisplayMetrics c2 = b.c(context);
                if (c2 != null) {
                    int i2 = c2.widthPixels;
                    str2 = String.valueOf(i2) + "x" + c2.heightPixels;
                } else {
                    str2 = null;
                }
                deviceDetails7.setScreenResolution(str2);
                DeviceDetails deviceDetails8 = b.f43022a;
                if (deviceDetails8 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails8.setClient("androidapp");
                DeviceDetails deviceDetails9 = b.f43022a;
                if (deviceDetails9 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails9.setPlatform("android");
                DeviceDetails deviceDetails10 = b.f43022a;
                if (deviceDetails10 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails10.setBrand(Build.BRAND);
                DeviceDetails deviceDetails11 = b.f43022a;
                if (deviceDetails11 == null) {
                    k.a("deviceDetails");
                }
                deviceDetails11.setIdentifier(b.d(context));
                DeviceDetails deviceDetails12 = b.f43022a;
                if (deviceDetails12 == null) {
                    k.a("deviceDetails");
                }
                boolean a3 = a(str, a2, deviceDetails12, a2.handleLogin());
                if (a3) {
                    if (a2.getCustomerId$paytmnotification_paytmRelease() != null) {
                        hVar.a(true);
                    } else {
                        hVar.a(false);
                    }
                    if (z && hVar.f() != null) {
                        g.c cVar2 = com.paytm.notification.g.f43191a;
                        String f2 = hVar.f();
                        if (f2 == null) {
                            k.a();
                        }
                        g.c.b(f2);
                    }
                    g.c cVar3 = com.paytm.notification.g.f43191a;
                    com.paytm.notification.g.t.lock();
                    com.paytm.notification.g.q = Boolean.valueOf(a3);
                    ChannelReadyCallback l = com.paytm.notification.g.n;
                    if (l != null) {
                        l.onChannelReady(a3);
                    }
                    if (k.a((Object) com.paytm.notification.g.p, (Object) Boolean.TRUE) && k.a((Object) com.paytm.notification.g.q, (Object) Boolean.TRUE) && (k = com.paytm.notification.g.o) != null) {
                        k.onConfigChannelReady(true);
                    }
                    com.paytm.notification.g.t.unlock();
                    return JOB_RESULT.SUCCESS;
                }
                return JOB_RESULT.RETRY;
            } catch (com.paytm.notification.schedulers.a.a e2) {
                e.f43014a.a("[DoNotRetry] SyncFCMToken error: " + e2.getMessage(), new Object[0]);
                return JOB_RESULT.DO_NOT_RETRY;
            }
        } catch (com.paytm.notification.a.a.a e3) {
            e.f43014a.b(e3);
        } catch (Exception e4) {
            e.f43014a.b(e4);
        } catch (Throwable th) {
            com.paytm.notification.g.t.unlock();
            throw th;
        }
    }

    public static final class a implements ConfigReadyCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f43282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f43283b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f43284c;

        a(Context context, String str, h hVar) {
            this.f43282a = context;
            this.f43283b = str;
            this.f43284c = hVar;
        }

        public final void onConfigReady(boolean z) {
            if (!z) {
                b.a aVar = com.paytm.notification.schedulers.b.f43250b;
                c a2 = b.a.a();
                if (a2 != null) {
                    a2.l();
                }
            } else if (g.f43280a.a(this.f43282a, this.f43283b, this.f43284c) == JOB_RESULT.RETRY) {
                b.a aVar2 = com.paytm.notification.schedulers.b.f43250b;
                c a3 = b.a.a();
                if (a3 != null) {
                    a3.l();
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:63|(2:65|66)|67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0198, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0181 */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x0181=Splitter:B:67:0x0181, B:32:0x009f=Splitter:B:32:0x009f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean a(java.lang.String r14, com.paytm.notification.models.NotificationUserConfig r15, com.paytm.notification.models.request.DeviceDetails r16, boolean r17) throws com.paytm.notification.schedulers.a.a {
        /*
            r13 = this;
            r0 = r16
            monitor-enter(r13)
            com.paytm.notification.j r1 = com.paytm.notification.j.f43241a     // Catch:{ all -> 0x01ab }
            com.paytm.notification.data.c.h r9 = r1.c()     // Catch:{ all -> 0x01ab }
            java.lang.String r2 = r15.getServerEndPoints$paytmnotification_paytmRelease()     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = r9.j()     // Catch:{ all -> 0x01ab }
            com.paytm.notification.models.NotificationUserConfig r1 = r9.a()     // Catch:{ all -> 0x01ab }
            java.lang.String r6 = r1.getClientName$paytmnotification_paytmRelease()     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x01a1
            java.lang.String r10 = r9.f()     // Catch:{ all -> 0x01ab }
            r11 = 1
            r12 = 0
            if (r10 != 0) goto L_0x0145
            boolean r1 = f43281b     // Catch:{ all -> 0x01ab }
            if (r1 == 0) goto L_0x0048
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x01ab }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = "Trying to register another token even though it was already registered. customerId: "
            r3.<init>(r4)     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = r15.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ all -> 0x01ab }
            r3.append(r4)     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = " DeviceDetails: "
            r3.append(r4)     // Catch:{ all -> 0x01ab }
            r3.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01ab }
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ all -> 0x01ab }
            r1.d(r3, r4)     // Catch:{ all -> 0x01ab }
        L_0x0048:
            if (r2 != 0) goto L_0x004d
            kotlin.g.b.k.a()     // Catch:{ all -> 0x01ab }
        L_0x004d:
            if (r6 != 0) goto L_0x0052
            kotlin.g.b.k.a()     // Catch:{ all -> 0x01ab }
        L_0x0052:
            r1 = r2
            r2 = r9
            r3 = r5
            r4 = r6
            r5 = r17
            r6 = r14
            r7 = r15
            r8 = r16
            com.paytm.pai.network.model.EventResponse r1 = a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01ab }
            if (r1 == 0) goto L_0x010d
            java.lang.Boolean r2 = r1.isSuccess()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01ab }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x007c
            java.lang.Boolean r2 = r1.isDoNotRetry()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x01ab }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x007c
            goto L_0x010d
        L_0x007c:
            java.lang.Boolean r2 = r1.isSuccess()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01ab }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x008a
            monitor-exit(r13)
            return r12
        L_0x008a:
            java.lang.Object r2 = r1.getResponse()     // Catch:{ Exception -> 0x009e }
            if (r2 != 0) goto L_0x0093
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x009e }
        L_0x0093:
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x009e }
            java.lang.String r3 = "devicePushIdentifier"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x009e }
            goto L_0x009f
        L_0x009e:
            r2 = r10
        L_0x009f:
            com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = "DevicePushIdentifier: "
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x01ab }
            java.lang.Object[] r5 = new java.lang.Object[r12]     // Catch:{ all -> 0x01ab }
            r3.a(r4, r5)     // Catch:{ all -> 0x01ab }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x01ab }
            if (r3 == 0) goto L_0x00be
            int r3 = r3.length()     // Catch:{ all -> 0x01ab }
            if (r3 != 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r3 = 0
            goto L_0x00bf
        L_0x00be:
            r3 = 1
        L_0x00bf:
            if (r3 == 0) goto L_0x00fc
            com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x01ab }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "Even though response was successful channelId was not returned from the server. customerId: "
            r4.<init>(r5)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = r15.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ all -> 0x01ab }
            r4.append(r5)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "  DeviceDetails: "
            r4.append(r5)     // Catch:{ all -> 0x01ab }
            r4.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = " responseCode: "
            r4.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.Integer r0 = r1.getResponseCode()     // Catch:{ all -> 0x01ab }
            r4.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = " response: "
            r4.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.Object r0 = r1.getResponse()     // Catch:{ all -> 0x01ab }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x01ab }
            r4.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x01ab }
            java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ all -> 0x01ab }
            r3.d(r0, r1)     // Catch:{ all -> 0x01ab }
        L_0x00fc:
            f43281b = r11     // Catch:{ all -> 0x01ab }
            if (r2 != 0) goto L_0x0103
            kotlin.g.b.k.a()     // Catch:{ all -> 0x01ab }
        L_0x0103:
            r9.a((java.lang.String) r2)     // Catch:{ all -> 0x01ab }
            com.paytm.notification.b.a r0 = com.paytm.notification.b.a.f42999a     // Catch:{ all -> 0x01ab }
            com.paytm.notification.b.a.a((java.lang.String) r2)     // Catch:{ all -> 0x01ab }
            goto L_0x0197
        L_0x010d:
            if (r1 == 0) goto L_0x013b
            java.lang.String r0 = r1.getErrorMessage()     // Catch:{ all -> 0x01ab }
            java.lang.Object r2 = r1.getResponse()     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x013d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ab }
            r2.<init>()     // Catch:{ all -> 0x01ab }
            r2.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = ": "
            r2.append(r0)     // Catch:{ all -> 0x01ab }
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ all -> 0x01ab }
            r0.<init>()     // Catch:{ all -> 0x01ab }
            java.lang.Object r1 = r1.getResponse()     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = r0.b(r1)     // Catch:{ all -> 0x01ab }
            r2.append(r0)     // Catch:{ all -> 0x01ab }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01ab }
            goto L_0x013d
        L_0x013b:
            java.lang.String r0 = "response is null"
        L_0x013d:
            com.paytm.notification.schedulers.a.a r1 = new com.paytm.notification.schedulers.a.a     // Catch:{ all -> 0x01ab }
            r1.<init>(r0)     // Catch:{ all -> 0x01ab }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x01ab }
            throw r1     // Catch:{ all -> 0x01ab }
        L_0x0145:
            if (r2 != 0) goto L_0x014a
            kotlin.g.b.k.a()     // Catch:{ all -> 0x01ab }
        L_0x014a:
            if (r6 != 0) goto L_0x014f
            kotlin.g.b.k.a()     // Catch:{ all -> 0x01ab }
        L_0x014f:
            r3 = r10
            r4 = r9
            r7 = r14
            r8 = r15
            com.paytm.pai.network.model.EventResponse r0 = a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01ab }
            if (r0 == 0) goto L_0x0199
            java.lang.Boolean r1 = r0.isSuccess()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01ab }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x01ab }
            if (r1 == 0) goto L_0x0189
            java.lang.Boolean r1 = r0.isDoNotRetry()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x01ab }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x01ab }
            if (r1 == 0) goto L_0x0189
            java.lang.String r1 = ""
            java.lang.Object r2 = r0.getResponse()     // Catch:{ all -> 0x01ab }
            if (r2 == 0) goto L_0x0181
            java.lang.Object r0 = r0.getResponse()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0181 }
        L_0x0181:
            com.paytm.notification.schedulers.a.a r0 = new com.paytm.notification.schedulers.a.a     // Catch:{ all -> 0x01ab }
            r0.<init>(r1)     // Catch:{ all -> 0x01ab }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x01ab }
            throw r0     // Catch:{ all -> 0x01ab }
        L_0x0189:
            java.lang.Boolean r0 = r0.isSuccess()     // Catch:{ all -> 0x01ab }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01ab }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x01ab }
            if (r0 == 0) goto L_0x0197
            monitor-exit(r13)
            return r12
        L_0x0197:
            monitor-exit(r13)
            return r11
        L_0x0199:
            com.paytm.notification.schedulers.a.a r0 = new com.paytm.notification.schedulers.a.a     // Catch:{ all -> 0x01ab }
            r0.<init>()     // Catch:{ all -> 0x01ab }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x01ab }
            throw r0     // Catch:{ all -> 0x01ab }
        L_0x01a1:
            com.paytm.notification.schedulers.a.a r0 = new com.paytm.notification.schedulers.a.a     // Catch:{ all -> 0x01ab }
            java.lang.String r1 = "App secret not found"
            r0.<init>(r1)     // Catch:{ all -> 0x01ab }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x01ab }
            throw r0     // Catch:{ all -> 0x01ab }
        L_0x01ab:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.b.g.a(java.lang.String, com.paytm.notification.models.NotificationUserConfig, com.paytm.notification.models.request.DeviceDetails, boolean):boolean");
    }

    private static EventResponse<Map<String, String>> a(String str, h hVar, String str2, String str3, boolean z, String str4, NotificationUserConfig notificationUserConfig, DeviceDetails deviceDetails) throws com.paytm.notification.schedulers.a.a {
        try {
            f fVar = f.f43030a;
            return hVar.a(f.a(str4, notificationUserConfig, deviceDetails, z), str, str2, str3);
        } catch (MalformedURLException e2) {
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new com.paytm.notification.schedulers.a.a(e3.getMessage());
        }
    }

    private static EventResponse<?> a(String str, String str2, h hVar, String str3, String str4, String str5, NotificationUserConfig notificationUserConfig) throws com.paytm.notification.schedulers.a.a {
        try {
            f fVar = f.f43030a;
            return hVar.a(f.a(str5, notificationUserConfig), str, str2, str3, str4);
        } catch (MalformedURLException e2) {
            e.f43014a.b("Job sync event status unsuccessful", new Object[0]);
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            e.f43014a.b("Job sync event status unsuccessful", new Object[0]);
            throw new com.paytm.notification.schedulers.a.a(e3.getMessage());
        }
    }
}

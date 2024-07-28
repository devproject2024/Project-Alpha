package com.sendbird.android;

import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.sendbird.android.Command;
import com.sendbird.android.SendBird;
import com.sendbird.android.TimeoutScheduler;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.log.Tag;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.okhttp3.WebSocket;
import com.sendbird.android.shadow.okhttp3.WebSocketListener;
import com.sendbird.android.utils.TimeoutLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class Connection extends WebSocketListener {

    /* renamed from: i  reason: collision with root package name */
    private static AppInfo f44219i;
    private static n j = new n();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public WebSocket f44220a;

    /* renamed from: b  reason: collision with root package name */
    private SendBirdException f44221b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicReference<SendBird.ConnectionState> f44222c = new AtomicReference<>(SendBird.ConnectionState.CLOSED);

    /* renamed from: d  reason: collision with root package name */
    private TimeoutLock f44223d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WSClientHandler f44224e;

    /* renamed from: f  reason: collision with root package name */
    private final String f44225f;

    /* renamed from: g  reason: collision with root package name */
    private final String f44226g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final StringBuffer f44227h;
    /* access modifiers changed from: private */
    public final AtomicBoolean k = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final a l;

    public interface WSClientHandler {
        void onError(boolean z, SendBirdException sendBirdException);

        void onMessage(Command command);
    }

    Connection(String str, String str2, WSClientHandler wSClientHandler) {
        a(SendBird.ConnectionState.CLOSED);
        this.f44227h = new StringBuffer();
        this.f44225f = str;
        this.f44226g = str2;
        this.f44224e = wSClientHandler;
        this.l = new a(this, (byte) 0);
    }

    static n a() {
        return j;
    }

    static AppInfo b() {
        return f44219i;
    }

    private void a(SendBird.ConnectionState connectionState) {
        AtomicReference<SendBird.ConnectionState> atomicReference = this.f44222c;
        atomicReference.compareAndSet(atomicReference.get(), connectionState);
    }

    private boolean h() {
        return this.f44222c.get() == SendBird.ConnectionState.CONNECTING;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.f44222c.get() == SendBird.ConnectionState.CLOSED;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.f44225f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x013a A[Catch:{ SendBirdException | TimeoutException | InterruptedException -> 0x0208, all -> 0x0206 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c5 A[Catch:{ SendBirdException | TimeoutException | InterruptedException -> 0x0208, all -> 0x0206 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01f0 A[Catch:{ SendBirdException | TimeoutException | InterruptedException -> 0x0208, all -> 0x0206 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d() throws com.sendbird.android.SendBirdException {
        /*
            r8 = this;
            monitor-enter(r8)
            com.sendbird.android.log.Tag r0 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ all -> 0x025f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x025f }
            java.lang.String r2 = ">> Connection::connect user id : "
            r1.<init>(r2)     // Catch:{ all -> 0x025f }
            java.lang.String r2 = r8.f44225f     // Catch:{ all -> 0x025f }
            r1.append(r2)     // Catch:{ all -> 0x025f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x025f }
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r0, (java.lang.String) r1)     // Catch:{ all -> 0x025f }
            r0 = 0
            com.sendbird.android.log.Tag r1 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = "connect await start"
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r1, (java.lang.String) r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.SendBird$ConnectionState r1 = com.sendbird.android.SendBird.ConnectionState.CONNECTING     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r8.a((com.sendbird.android.SendBird.ConnectionState) r1)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.utils.TimeoutLock r1 = new com.sendbird.android.utils.TimeoutLock     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r2 = com.sendbird.android.SendBird.Options.connectionTimeout     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r3 = com.sendbird.android.SendBird.Options.wsResponseTimeoutSec     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r2 = r2 + r3
            long r2 = (long) r2     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.<init>(r2, r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r8.f44223d = r1     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.log.Tag r1 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = ">> Connection::connect connectInternal()"
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r1, (java.lang.String) r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.OkHttpClient$Builder r1 = new com.sendbird.android.shadow.okhttp3.OkHttpClient$Builder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.<init>()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r2 = com.sendbird.android.SendBird.Options.connectionTimeout     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            long r2 = (long) r2     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.OkHttpClient$Builder r1 = r1.connectTimeout(r2, r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r2 = 0
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.OkHttpClient$Builder r1 = r1.readTimeout(r2, r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.OkHttpClient r1 = r1.build()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = r8.f44225f     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r3 = r8.f44226g     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.getApplicationId()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x01fb
            java.lang.String r4 = com.sendbird.android.SendBird.getApplicationId()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r4 = r4.length()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x01fb
            java.lang.String r4 = com.sendbird.android.u.f45285b     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = com.sendbird.android.u.f45285b     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            goto L_0x0081
        L_0x006e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = "https://api-"
            r4.<init>(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = com.sendbird.android.SendBird.getApplicationId()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r4.append(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = ".sendbird.com"
            r4.append(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x0081:
            java.lang.String r4 = com.sendbird.android.u.f45284a     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x0088
            java.lang.String r4 = com.sendbird.android.u.f45284a     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            goto L_0x00a0
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = "wss://ws-"
            r4.<init>(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = com.sendbird.android.SendBird.getApplicationId()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r4.append(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r5 = ".sendbird.com"
            r4.append(r5)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = r4.toString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x00a0:
            com.sendbird.android.log.Tag r5 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r6 = "++ wsHost : "
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r5, (java.lang.String) r6)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.<init>(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "/?p=Android&pv="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.getOSVersion()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "&sv="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.getSDKVersion()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "&ai="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.getApplicationId()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "&SB-User-Agent="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.makeExUserAgentString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.b.urlEncodeUTF8((java.lang.String) r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "&include_extra_data="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.SendBird.getAdditionalData()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = com.sendbird.android.b.urlEncodeUTF8((java.lang.String) r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.User r4 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x011e
            com.sendbird.android.APIClient r4 = com.sendbird.android.APIClient.a()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = r4.h()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r4 == 0) goto L_0x010d
            goto L_0x011e
        L_0x010d:
            java.lang.String r2 = "&key="
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.APIClient r2 = com.sendbird.android.APIClient.a()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = r2.h()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            goto L_0x0134
        L_0x011e:
            java.lang.String r4 = "&user_id="
            r5.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = com.sendbird.android.b.urlEncodeUTF8((java.lang.String) r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r3 == 0) goto L_0x0134
            java.lang.String r2 = "&access_token="
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x0134:
            com.sendbird.android.SendBird r2 = com.sendbird.android.SendBird.getInstance()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r2 == 0) goto L_0x014a
            java.lang.String r2 = "&active="
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.SendBird r2 = com.sendbird.android.SendBird.getInstance()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r2 = r2.isActive()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r5.append(r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x014a:
            com.sendbird.android.log.Tag r2 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = "WS request: "
            r3.<init>(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = r5.toString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r3.append(r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r3 = r3.toString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r2, (java.lang.String) r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.APIClient r2 = com.sendbird.android.APIClient.a()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.APIClient$2 r3 = new com.sendbird.android.APIClient$2     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r3.<init>()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.d.a(r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Request$Builder r2 = new com.sendbird.android.shadow.okhttp3.Request$Builder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r2.<init>()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r3 = "User-Agent"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r6 = "Jand/"
            r4.<init>(r6)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r6 = com.sendbird.android.SendBird.getSDKVersion()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r4.append(r6)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = r4.toString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Request$Builder r2 = r2.header(r3, r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r3 = "Request-Sent-Timestamp"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Request$Builder r2 = r2.header(r3, r4)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r3 = r5.toString()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Request$Builder r2 = r2.url((java.lang.String) r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Request r2 = r2.build()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.Connection$1 r3 = new com.sendbird.android.Connection$1     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r3.<init>()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.WebSocket r2 = r1.newWebSocket(r2, r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r8.f44220a = r2     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.shadow.okhttp3.Dispatcher r1 = r1.dispatcher()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.util.concurrent.ExecutorService r1 = r1.executorService()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.shutdown()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.utils.TimeoutLock r1 = r8.f44223d     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.await()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            boolean r1 = r8.c()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r1 != 0) goto L_0x01f0
            com.sendbird.android.SendBirdException r1 = r8.f44221b     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            if (r1 != 0) goto L_0x01de
            com.sendbird.android.log.Tag r1 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = "connect await end success"
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r1, (java.lang.String) r2)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.SendBird$ConnectionState r1 = com.sendbird.android.SendBird.ConnectionState.OPEN     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r8.a((com.sendbird.android.SendBird.ConnectionState) r1)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.Connection$a r1 = r8.l     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.a()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r8.f44221b = r0     // Catch:{ all -> 0x025f }
            monitor-exit(r8)
            return
        L_0x01de:
            com.sendbird.android.SendBirdException r1 = new com.sendbird.android.SendBirdException     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.SendBirdException r2 = r8.f44221b     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            com.sendbird.android.SendBirdException r3 = r8.f44221b     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            int r3 = r3.getCode()     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            r1.<init>(r2, r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            throw r1     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x01f0:
            com.sendbird.android.SendBirdException r1 = new com.sendbird.android.SendBirdException     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = "Connection has not made."
            r3 = 800200(0xc35c8, float:1.121319E-39)
            r1.<init>(r2, r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            throw r1     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x01fb:
            com.sendbird.android.SendBirdException r1 = new com.sendbird.android.SendBirdException     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            java.lang.String r2 = "Application ID is not set. Initialize SendBird class."
            r3 = 800100(0xc3564, float:1.121179E-39)
            r1.<init>(r2, r3)     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
            throw r1     // Catch:{ TimeoutException -> 0x020c, InterruptedException -> 0x020a, SendBirdException -> 0x0208 }
        L_0x0206:
            r1 = move-exception
            goto L_0x025c
        L_0x0208:
            r1 = move-exception
            goto L_0x020d
        L_0x020a:
            r1 = move-exception
            goto L_0x020d
        L_0x020c:
            r1 = move-exception
        L_0x020d:
            com.sendbird.android.log.Tag r2 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "connect await end exception : "
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0206 }
            com.sendbird.android.log.Logger.it((com.sendbird.android.log.Tag) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0206 }
            r8.e()     // Catch:{ all -> 0x0206 }
            boolean r2 = r1 instanceof com.sendbird.android.utils.TimeoutLock.TimeoutException     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x0251
            boolean r2 = r1 instanceof java.lang.InterruptedException     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x0241
            com.sendbird.android.log.Tag r1 = com.sendbird.android.log.Tag.CONNECTION     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "-- interrupted instance : "
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0206 }
            com.sendbird.android.log.Logger.dt((com.sendbird.android.log.Tag) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0206 }
            com.sendbird.android.SendBirdException r1 = new com.sendbird.android.SendBirdException     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "Connection has been canceled."
            r3 = 800102(0xc3566, float:1.121182E-39)
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0206 }
            throw r1     // Catch:{ all -> 0x0206 }
        L_0x0241:
            com.sendbird.android.SendBirdException r2 = new com.sendbird.android.SendBirdException     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0206 }
            com.sendbird.android.SendBirdException r1 = (com.sendbird.android.SendBirdException) r1     // Catch:{ all -> 0x0206 }
            int r1 = r1.getCode()     // Catch:{ all -> 0x0206 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0206 }
            throw r2     // Catch:{ all -> 0x0206 }
        L_0x0251:
            com.sendbird.android.SendBirdException r1 = new com.sendbird.android.SendBirdException     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "WebSocket Connection failure [TIMEOUT]"
            r3 = 800190(0xc35be, float:1.121305E-39)
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0206 }
            throw r1     // Catch:{ all -> 0x0206 }
        L_0x025c:
            r8.f44221b = r0     // Catch:{ all -> 0x025f }
            throw r1     // Catch:{ all -> 0x025f }
        L_0x025f:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.Connection.d():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        Tag tag = Tag.CONNECTION;
        Logger.it(tag, "__ actural disconnect isConnecting :" + h());
        TimeoutLock timeoutLock = this.f44223d;
        if (timeoutLock != null) {
            timeoutLock.release();
        }
        this.k.set(true);
        if (c()) {
            Logger.dt(Tag.CONNECTION, "++ socket is already disconnected()");
            return false;
        }
        i();
        return true;
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.f44220a != null) {
            Logger.it(Tag.CONNECTION, ">> Connection::quit()");
            this.l.b();
            WebSocket webSocket = this.f44220a;
            if (webSocket != null) {
                webSocket.cancel();
            }
            try {
                if (this.f44220a != null) {
                    this.f44220a.close(1000, "");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f44220a = null;
            a(SendBird.ConnectionState.CLOSED);
        }
    }

    /* access modifiers changed from: package-private */
    public final SendBird.ConnectionState f() {
        return this.f44222c.get();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        a aVar = this.l;
        if (aVar != null) {
            aVar.a();
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        TimeoutScheduler f44229a;

        /* renamed from: b  reason: collision with root package name */
        long f44230b;

        /* renamed from: c  reason: collision with root package name */
        TimeoutLock f44231c;

        /* renamed from: d  reason: collision with root package name */
        AtomicBoolean f44232d;

        private a() {
            this.f44232d = new AtomicBoolean(true);
        }

        /* synthetic */ a(Connection connection, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a() {
            Logger.dt(Tag.PINGER, "[Pinger] start()");
            this.f44232d.set(true);
            if (this.f44229a != null) {
                this.f44229a.a();
                c();
                return;
            }
            this.f44229a = new TimeoutScheduler(0, (long) Connection.a().f44842e, true, new TimeoutScheduler.TimeoutEventhandler() {
                public final void onTimeout(Object obj) {
                    Logger.dt(Tag.PINGER, ">> Pinger::onTimeout(timer : %s)", a.this.f44229a);
                    a aVar = a.this;
                    boolean andSet = aVar.f44232d.getAndSet(false);
                    int i2 = Connection.a().f44842e;
                    long currentTimeMillis = (System.currentTimeMillis() - aVar.f44230b) + 500;
                    if (andSet || currentTimeMillis >= ((long) i2)) {
                        Tag tag = Tag.PINGER;
                        Logger.dt(tag, "[Pinger] sendPing(forcedPing: " + andSet + ")");
                        try {
                            Command d2 = Command.d();
                            if (d2 != null) {
                                u.a().a(d2, false, (Command.SendCommandHandler) new Command.SendCommandHandler(andSet) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ boolean f44235a;

                                    {
                                        this.f44235a = r2;
                                    }

                                    public final void onResult(Command command, SendBirdException sendBirdException) {
                                        Tag tag = Tag.PINGER;
                                        StringBuilder sb = new StringBuilder("[Pinger] sendPing(forcedPing: ");
                                        sb.append(this.f44235a);
                                        sb.append(") => ");
                                        sb.append(sendBirdException != null ? sendBirdException.getMessage() : Payload.RESPONSE_OK);
                                        Logger.dt(tag, sb.toString());
                                    }
                                });
                                n a2 = Connection.a();
                                Tag tag2 = Tag.PINGER;
                                Logger.dt(tag2, "++ pong time out : " + a2.f44843f);
                                aVar.f44231c = new TimeoutLock((long) a2.f44843f, TimeUnit.MILLISECONDS);
                                Logger.dt(Tag.PINGER, "-- ping await start (%s)", aVar.f44231c);
                                aVar.f44231c.await();
                                aVar.f44230b = System.currentTimeMillis();
                            }
                        } catch (TimeoutLock.TimeoutException e2) {
                            if (Connection.this.f44224e != null) {
                                Logger.dt(Tag.PINGER, "[Pinger] sendPing timeout error=%s, lock=%s", e2, aVar.f44231c);
                                Connection.this.f44224e.onError(Connection.this.k.get(), new SendBirdException("Server is unreachable.", SendBirdError.ERR_NETWORK));
                            }
                        } catch (Exception e3) {
                            Logger.dt(Tag.PINGER, "[Pinger] sendPing error", e3.getMessage());
                        } finally {
                            Logger.dt(Tag.PINGER, "-- ping end");
                            aVar.c();
                        }
                    } else {
                        Logger.dt(Tag.PINGER, "-- skip sendPing interval=%s, diff=%s", Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                    }
                }
            }, (Object) null);
            this.f44229a.c();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void b() {
            Logger.dt(Tag.PINGER, "[Pinger] stop()");
            Tag tag = Tag.PINGER;
            Object[] objArr = new Object[1];
            objArr[0] = this.f44229a != null ? Boolean.valueOf(this.f44229a.f44672a.get()) : "timer is null";
            Logger.et(tag, "Pinger stop %s", objArr);
            if (this.f44229a != null) {
                Tag tag2 = Tag.PINGER;
                Logger.dt(tag2, ">> Pinger::stop() isRunning : " + this.f44229a.f44672a.get());
                this.f44229a.a(false);
            }
            c();
            Logger.dt(Tag.PINGER, "[Pinger] stop end()");
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            Tag tag = Tag.PINGER;
            Logger.dt(tag, "++ Pinger::done() lock : " + this.f44231c);
            TimeoutLock timeoutLock = this.f44231c;
            if (timeoutLock != null) {
                timeoutLock.release();
                this.f44231c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Command command) {
        int i2 = 0;
        if (command.f44215a != m.LOGI) {
            return false;
        }
        Logger.dt(Tag.CONNECTION, "LOGI RECEIVED: ");
        this.f44221b = null;
        JsonObject asJsonObject = command.c().getAsJsonObject();
        if (!asJsonObject.getAsJsonObject().has("error") || !asJsonObject.getAsJsonObject().get("error").isJsonPrimitive() || !asJsonObject.getAsJsonObject().get("error").getAsBoolean()) {
            if (asJsonObject.has("user_id")) {
                Tag tag = Tag.CONNECTION;
                Logger.dt(tag, "++ LOGI user id : " + asJsonObject.get("user_id").getAsString());
                SendBird.setCurrentUser(new User(command.c()));
                Tag tag2 = Tag.CONNECTION;
                Logger.dt(tag2, "++ after LOGI user id : " + SendBird.getCurrentUser().getUserId());
            }
            if (asJsonObject.has("key")) {
                APIClient.a().b(asJsonObject.get("key").getAsString());
            }
            if (asJsonObject.has(StringSet.ekey)) {
                SendBird.setEkey(asJsonObject.get(StringSet.ekey).getAsString());
            }
            j = new n(asJsonObject);
            f44219i = new AppInfo(asJsonObject);
            return true;
        }
        String asString = (!asJsonObject.getAsJsonObject().has("message") || !asJsonObject.getAsJsonObject().get("message").isJsonPrimitive()) ? "" : asJsonObject.getAsJsonObject().get("message").getAsString();
        if (asJsonObject.getAsJsonObject().has("code") && asJsonObject.getAsJsonObject().get("code").isJsonPrimitive()) {
            i2 = asJsonObject.getAsJsonObject().get("code").getAsInt();
        }
        this.f44221b = new SendBirdException(asString, i2);
        return true;
    }

    static /* synthetic */ void d(Connection connection) {
        Logger.dt(Tag.CONNECTION, "-- done connectLock released ");
        connection.f44223d.release();
    }
}

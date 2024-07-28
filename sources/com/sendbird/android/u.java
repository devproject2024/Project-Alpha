package com.sendbird.android;

import android.text.TextUtils;
import com.sendbird.android.Command;
import com.sendbird.android.Connection;
import com.sendbird.android.ConnectionManager;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.k;
import com.sendbird.android.log.Logger;
import com.sendbird.android.log.Tag;
import com.sendbird.android.o;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.utils.CancelableThreadHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class u implements Connection.WSClientHandler {

    /* renamed from: a  reason: collision with root package name */
    static String f45284a;

    /* renamed from: b  reason: collision with root package name */
    static String f45285b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f45286c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f45287d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentHashMap<String, SendBird.ConnectionHandler> f45288e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final ConcurrentHashMap<String, ConnectionManager.NetworkHandler> f45289f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Connection f45290g;

    /* renamed from: h  reason: collision with root package name */
    private CancelableThreadHolder f45291h;

    /* renamed from: i  reason: collision with root package name */
    private v f45292i;
    /* access modifiers changed from: private */
    public final Object j;
    /* access modifiers changed from: private */
    public final AtomicBoolean k;
    private final AtomicInteger l;
    private final v m;
    private final v n;
    private final CopyOnWriteArraySet<SendBird.ConnectHandler> o;
    private final CopyOnWriteArraySet<CountDownLatch> p;
    private final CopyOnWriteArraySet<TimeoutScheduler> q;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, f> r;

    enum a {
        START,
        SUCCESS,
        FAIL
    }

    static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final u f45329a = new u((byte) 0);
    }

    /* synthetic */ u(byte b2) {
        this();
    }

    private u() {
        this.f45292i = new v(CancelableExecutorService.newSingleThreadExecutor());
        this.j = new Object();
        this.f45286c = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.f45287d = new AtomicBoolean(false);
        this.l = new AtomicInteger(1);
        this.m = new v(CancelableExecutorService.newSingleThreadExecutor());
        this.n = new v(CancelableExecutorService.newSingleThreadExecutor());
        this.o = new CopyOnWriteArraySet<>();
        this.f45288e = new ConcurrentHashMap<>();
        this.f45289f = new ConcurrentHashMap<>();
        this.p = new CopyOnWriteArraySet<>();
        this.q = new CopyOnWriteArraySet<>();
        this.r = new ConcurrentHashMap<>();
    }

    public static u a() {
        return b.f45329a;
    }

    static SendBirdException b() {
        return new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED);
    }

    /* access modifiers changed from: private */
    public void a(User user, SendBirdException sendBirdException) {
        HashSet<SendBird.ConnectHandler> hashSet;
        Logger.d(">> connectionComplete() e : ".concat(String.valueOf(sendBirdException)));
        if (sendBirdException == null) {
            k.a.f44826a.a();
            SendBirdPushHelper.retryPendingAction();
        }
        synchronized (this.o) {
            hashSet = new HashSet<>(this.o);
            this.o.clear();
        }
        for (SendBird.ConnectHandler onConnected : hashSet) {
            onConnected.onConnected(user, sendBirdException);
        }
        j();
    }

    /* access modifiers changed from: package-private */
    public final SendBird.ConnectionState c() {
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.k.get());
        objArr[1] = Boolean.valueOf(this.f45286c.get());
        Connection connection = this.f45290g;
        objArr[2] = connection;
        objArr[3] = connection != null ? connection.f() : "connection is null";
        Logger.i("__  connecting=%s, reconnecting=%s, connection=%s, getCurrentState=%s", objArr);
        if (this.k.get()) {
            return SendBird.ConnectionState.CONNECTING;
        }
        Connection connection2 = this.f45290g;
        if (connection2 == null) {
            return SendBird.ConnectionState.CLOSED;
        }
        return connection2.f();
    }

    private boolean h() {
        return c() == SendBird.ConnectionState.CONNECTING;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return c() == SendBird.ConnectionState.OPEN;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return c() == SendBird.ConnectionState.CLOSED;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.sendbird.android.ConnectionManager.AuthInfoRequestHandler r5, final com.sendbird.android.ConnectionManager.AuthenticateHandler r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = ">> SocketManager::connectFromAuthenticate() "
            com.sendbird.android.log.Logger.d((java.lang.String) r0)     // Catch:{ all -> 0x0048 }
            com.sendbird.android.User r0 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0016
            com.sendbird.android.u$1 r5 = new com.sendbird.android.u$1     // Catch:{ all -> 0x0048 }
            r5.<init>(r6)     // Catch:{ all -> 0x0048 }
            com.sendbird.android.SendBird.runOnUIThread(r5)     // Catch:{ all -> 0x0048 }
            monitor-exit(r4)
            return
        L_0x0016:
            int r0 = com.sendbird.android.SendBird.Options.authenticationTimeout     // Catch:{ all -> 0x0048 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "++ connectFromAuthenticate timeout : "
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0048 }
            com.sendbird.android.log.Logger.d((java.lang.String) r2)     // Catch:{ all -> 0x0048 }
            com.sendbird.android.TimeoutScheduler r2 = new com.sendbird.android.TimeoutScheduler     // Catch:{ all -> 0x0048 }
            r2.<init>((long) r0)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.CopyOnWriteArraySet<com.sendbird.android.TimeoutScheduler> r0 = r4.q     // Catch:{ all -> 0x0048 }
            r0.add(r2)     // Catch:{ all -> 0x0048 }
            com.sendbird.android.u$7 r0 = new com.sendbird.android.u$7     // Catch:{ all -> 0x0048 }
            r0.<init>(r2, r6)     // Catch:{ all -> 0x0048 }
            r2.f44674c = r0     // Catch:{ all -> 0x0048 }
            r2.b()     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x0046
            com.sendbird.android.u$8 r0 = new com.sendbird.android.u$8     // Catch:{ all -> 0x0048 }
            r0.<init>(r6, r2)     // Catch:{ all -> 0x0048 }
            r5.onAuthInfoRequest(r0)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r4)
            return
        L_0x0048:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.u.a(com.sendbird.android.ConnectionManager$AuthInfoRequestHandler, com.sendbird.android.ConnectionManager$AuthenticateHandler):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized Future<User> a(String str, String str2, String str3, String str4, final SendBird.ConnectHandler connectHandler) {
        Logger.d("-- connect start()");
        Logger.d("-- connect userId=%s", str);
        f45285b = str3;
        f45284a = str4;
        if (TextUtils.isEmpty(str)) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    SendBird.ConnectHandler connectHandler = connectHandler;
                    if (connectHandler != null) {
                        connectHandler.onConnected((User) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                }
            });
            return null;
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException unused) {
        }
        Logger.d("-- connection=%s", this.f45290g);
        boolean z = this.f45290g != null && this.f45290g.a(str);
        Logger.d("-- isSameRequest : ".concat(String.valueOf(z)));
        Logger.d("++ connect status : %s, connecting=%s", c(), Boolean.valueOf(this.k.get()));
        if (!z || !d()) {
            synchronized (this.o) {
                if (connectHandler != null) {
                    Logger.d("CONNECT", "++ addHandeler");
                    this.o.add(connectHandler);
                }
            }
            if (!h() || this.f45286c.get()) {
                if (this.f45286c.get()) {
                    Logger.d("++ isReconnecting()");
                    a(false, (SendBird.DisconnectHandler) null);
                }
                if (!z && !e()) {
                    Logger.d("++ !isSameRequest && !isDisconnected()");
                    a(true, (SendBird.DisconnectHandler) null);
                }
                APIClient.a().c();
                this.k.set(true);
                return a(str, str2, false);
            }
            Logger.d("-- return (already connecting)");
            return a(SendBird.getCurrentUser());
        }
        Logger.d("++ isSameRequest && isConnected()");
        SendBird.runOnUIThread(new Runnable() {
            public final void run() {
                connectHandler.onConnected(SendBird.getCurrentUser(), (SendBirdException) null);
            }
        });
        return a(SendBird.getCurrentUser());
    }

    private Future<User> a(final String str, final String str2, final boolean z) {
        Logger.d(">> connectInternal(fromReconnect: %s)", Boolean.valueOf(z));
        return this.m.a(new q<User>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                User user = (User) obj;
                if (!z) {
                    u.this.a(user, sendBirdException);
                }
                Logger.d("-- connect end(), e = %s, fromReconnect = %s", sendBirdException, Boolean.valueOf(z));
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public User call() throws Exception {
                Logger.d("++ connectInternal request connect() state : " + u.this.c());
                try {
                    boolean z = u.this.f45290g != null && u.this.f45290g.a(str);
                    if (!z || !u.this.d()) {
                        if (u.this.f45290g != null && u.this.d()) {
                            u.this.a(!z, (SendBird.DisconnectHandler) null);
                        }
                        synchronized (u.this.j) {
                            Connection unused = u.this.f45290g = new Connection(str, str2, u.this);
                            Logger.i("++ new Connection is made %s", u.this.f45290g);
                            u.this.f45290g.d();
                        }
                        u.this.k.set(false);
                        return SendBird.getCurrentUser();
                    }
                    Logger.d("-- return (connection is already connected)");
                    User currentUser = SendBird.getCurrentUser();
                    u.this.k.set(false);
                    return currentUser;
                } catch (Throwable th) {
                    u.this.k.set(false);
                    throw th;
                }
            }
        });
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    final synchronized void a(boolean r9, final com.sendbird.android.SendBird.DisconnectHandler r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "++ disconnect start (logout : %s, state : %s, isReconnecting : %s)"
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x012a }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x012a }
            r3 = 0
            r1[r3] = r2     // Catch:{ all -> 0x012a }
            com.sendbird.android.SendBird$ConnectionState r2 = r8.c()     // Catch:{ all -> 0x012a }
            r4 = 1
            r1[r4] = r2     // Catch:{ all -> 0x012a }
            r2 = 2
            java.util.concurrent.atomic.AtomicBoolean r5 = r8.f45286c     // Catch:{ all -> 0x012a }
            boolean r5 = r5.get()     // Catch:{ all -> 0x012a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x012a }
            r1[r2] = r5     // Catch:{ all -> 0x012a }
            com.sendbird.android.log.Logger.d((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x012a }
            r0 = 30
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0029 }
        L_0x0029:
            com.sendbird.android.v r0 = r8.m     // Catch:{ all -> 0x012a }
            r0.a()     // Catch:{ all -> 0x012a }
            com.sendbird.android.v r0 = r8.n     // Catch:{ all -> 0x012a }
            r0.a()     // Catch:{ all -> 0x012a }
            com.sendbird.android.v r0 = r8.f45292i     // Catch:{ all -> 0x012a }
            r0.a()     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            java.lang.String r1 = "++ ackSessionMap : "
            r0.<init>(r1)     // Catch:{ all -> 0x012a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.sendbird.android.f> r1 = r8.r     // Catch:{ all -> 0x012a }
            r0.append(r1)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012a }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x012a }
            com.sendbird.android.log.Logger.i((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x012a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.sendbird.android.f> r0 = r8.r     // Catch:{ all -> 0x012a }
            monitor-enter(r0)     // Catch:{ all -> 0x012a }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0127 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.sendbird.android.f> r2 = r8.r     // Catch:{ all -> 0x0127 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0127 }
            r1.<init>(r2)     // Catch:{ all -> 0x0127 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.sendbird.android.f> r2 = r8.r     // Catch:{ all -> 0x0127 }
            r2.clear()     // Catch:{ all -> 0x0127 }
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x012a }
        L_0x0065:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x012a }
            r2 = 0
            if (r1 == 0) goto L_0x008e
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x012a }
            com.sendbird.android.f r1 = (com.sendbird.android.f) r1     // Catch:{ all -> 0x012a }
            if (r1 == 0) goto L_0x0065
            java.lang.String r5 = "-- session canceled()"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x012a }
            com.sendbird.android.log.Logger.i((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x012a }
            com.sendbird.android.TimeoutScheduler r5 = r1.f44705a     // Catch:{ all -> 0x012a }
            r5.a((boolean) r4)     // Catch:{ all -> 0x012a }
            com.sendbird.android.SendBirdException r5 = new com.sendbird.android.SendBirdException     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "Request was interrupted before receiving ack from the server. Maybe the connection was closed."
            r7 = 800180(0xc35b4, float:1.121291E-39)
            r5.<init>(r6, r7)     // Catch:{ all -> 0x012a }
            r1.a(r2, r5)     // Catch:{ all -> 0x012a }
            goto L_0x0065
        L_0x008e:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.k     // Catch:{ all -> 0x012a }
            r0.set(r3)     // Catch:{ all -> 0x012a }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f45286c     // Catch:{ all -> 0x012a }
            r0.set(r3)     // Catch:{ all -> 0x012a }
            com.sendbird.android.k unused = com.sendbird.android.k.a.f44826a     // Catch:{ all -> 0x012a }
            com.sendbird.android.k.b()     // Catch:{ all -> 0x012a }
            java.lang.Object r0 = r8.j     // Catch:{ all -> 0x012a }
            monitor-enter(r0)     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0124 }
            java.lang.String r3 = "-- connection : "
            r1.<init>(r3)     // Catch:{ all -> 0x0124 }
            com.sendbird.android.Connection r3 = r8.f45290g     // Catch:{ all -> 0x0124 }
            r1.append(r3)     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0124 }
            com.sendbird.android.log.Logger.d((java.lang.String) r1)     // Catch:{ all -> 0x0124 }
            com.sendbird.android.Connection r1 = r8.f45290g     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x00bf
            com.sendbird.android.Connection r1 = r8.f45290g     // Catch:{ all -> 0x0124 }
            r1.e()     // Catch:{ all -> 0x0124 }
            r8.f45290g = r2     // Catch:{ all -> 0x0124 }
        L_0x00bf:
            monitor-exit(r0)     // Catch:{ all -> 0x0124 }
            if (r9 == 0) goto L_0x00ee
            java.lang.String r9 = "Clear local data."
            com.sendbird.android.log.Logger.d((java.lang.String) r9)     // Catch:{ all -> 0x012a }
            com.sendbird.android.APIClient r9 = com.sendbird.android.APIClient.a()     // Catch:{ all -> 0x012a }
            r9.d()     // Catch:{ all -> 0x012a }
            com.sendbird.android.APIClient.a()     // Catch:{ all -> 0x012a }
            com.sendbird.android.APIClient.b()     // Catch:{ all -> 0x012a }
            java.lang.String r9 = ""
            com.sendbird.android.SendBird.setEkey(r9)     // Catch:{ all -> 0x012a }
            com.sendbird.android.k r9 = com.sendbird.android.k.a.f44826a     // Catch:{ all -> 0x012a }
            com.sendbird.android.w r9 = r9.f44725b     // Catch:{ all -> 0x012a }
            r9.a()     // Catch:{ all -> 0x012a }
            com.sendbird.android.SendBird.setCurrentUser(r2)     // Catch:{ all -> 0x012a }
            com.sendbird.android.OpenChannel.clearEnteredChannels()     // Catch:{ all -> 0x012a }
            com.sendbird.android.OpenChannel.clearCache()     // Catch:{ all -> 0x012a }
            com.sendbird.android.GroupChannel.clearCache()     // Catch:{ all -> 0x012a }
        L_0x00ee:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            java.lang.String r0 = "++ isReconnecting : "
            r9.<init>(r0)     // Catch:{ all -> 0x012a }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f45286c     // Catch:{ all -> 0x012a }
            boolean r0 = r0.get()     // Catch:{ all -> 0x012a }
            r9.append(r0)     // Catch:{ all -> 0x012a }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x012a }
            com.sendbird.android.log.Logger.d((java.lang.String) r9)     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            java.lang.String r0 = "++ request disconnect finished state : "
            r9.<init>(r0)     // Catch:{ all -> 0x012a }
            com.sendbird.android.SendBird$ConnectionState r0 = r8.c()     // Catch:{ all -> 0x012a }
            r9.append(r0)     // Catch:{ all -> 0x012a }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x012a }
            com.sendbird.android.log.Logger.d((java.lang.String) r9)     // Catch:{ all -> 0x012a }
            com.sendbird.android.u$13 r9 = new com.sendbird.android.u$13     // Catch:{ all -> 0x012a }
            r9.<init>(r10)     // Catch:{ all -> 0x012a }
            com.sendbird.android.SendBird.runOnUIThread(r9)     // Catch:{ all -> 0x012a }
            monitor-exit(r8)
            return
        L_0x0124:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0124 }
            throw r9     // Catch:{ all -> 0x012a }
        L_0x0127:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            throw r9     // Catch:{ all -> 0x012a }
        L_0x012a:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.u.a(boolean, com.sendbird.android.SendBird$DisconnectHandler):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(final boolean z) {
        Logger.d(">> reconnect() from error : %s, reconnecting : %s", Boolean.valueOf(z), Boolean.valueOf(this.f45286c.get()));
        User currentUser = SendBird.getCurrentUser();
        if (currentUser != null && !TextUtils.isEmpty(currentUser.getUserId())) {
            if (!TextUtils.isEmpty(APIClient.a().h())) {
                this.f45287d.set(z);
                if (this.f45286c.get()) {
                    if (this.f45291h != null) {
                        this.f45291h.awake();
                    }
                    this.l.set(0);
                    Logger.d("-- return reconnecting =%s, retryCount =%s", Boolean.valueOf(this.f45286c.get()), Integer.valueOf(this.l.get()));
                    return false;
                }
                a(false, (SendBird.DisconnectHandler) null);
                APIClient.a().c();
                a(a.START);
                final String userId = SendBird.getCurrentUser().getUserId();
                Logger.d("++ reconnect user id : ".concat(String.valueOf(userId)));
                this.n.a(new q<Boolean>() {
                    public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                        Boolean bool = (Boolean) obj;
                        Logger.i("++ reconnect isComplete : %s, e : %s", bool, sendBirdException);
                        if (bool != null && bool.booleanValue()) {
                            if (sendBirdException == null && u.this.d()) {
                                u.this.b(z);
                            } else if (u.this.e()) {
                                u.this.a((User) null, u.b());
                            } else {
                                Logger.i("The connection is in the middle of connecting..", new Object[0]);
                            }
                        }
                    }

                    /* access modifiers changed from: private */
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        try {
                            u.this.f45286c.set(true);
                            boolean unused = u.this.a(userId);
                            u.this.f45286c.set(false);
                            k.c();
                            Boolean bool = Boolean.TRUE;
                            u.this.f45286c.set(false);
                            u.this.f45287d.compareAndSet(true, false);
                            return bool;
                        } catch (Exception e2) {
                            if (!(e2 instanceof InterruptedException)) {
                                u.this.a(false, (SendBird.DisconnectHandler) null);
                            }
                            throw e2;
                        } catch (Throwable th) {
                            u.this.f45286c.set(false);
                            u.this.f45287d.compareAndSet(true, false);
                            throw th;
                        }
                    }
                });
                return true;
            }
        }
        Logger.d("-- return currentUser =%s, sessionKey =%s", SendBird.getCurrentUser(), APIClient.a().h());
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(String str) throws InterruptedException {
        StringBuilder sb;
        Logger.d(">> reconnectInternal()");
        this.l.set(0);
        n a2 = Connection.a();
        int i2 = a2.f44841d;
        Logger.d("++ maxRetryCount : ".concat(String.valueOf(i2)));
        while (true) {
            if (i2 < 0 || this.l.get() < i2) {
                try {
                    this.f45291h = new CancelableThreadHolder();
                    int andIncrement = this.l.getAndIncrement();
                    float min = Math.min(andIncrement == 0 ? 0.0f : a2.f44839b, a2.f44838a + ((float) (andIncrement * a2.f44840c))) * 1000.0f;
                    Logger.d("++ reconnect delay : ".concat(String.valueOf(min)));
                    if (min > 0.0f) {
                        this.f45291h.sleep((long) min);
                        Logger.d("++ reconnect sleep released");
                    }
                    Logger.d("++ reconnect connect state : %s, user id : %s", c(), str);
                    if (e()) {
                        a(str, (String) null, true).get();
                    }
                    if (!d()) {
                        sb = new StringBuilder("++ reconnect retrycount : ");
                        sb.append(this.l.get());
                        Logger.d(sb.toString());
                        this.f45291h = null;
                    } else {
                        a(a.SUCCESS);
                        Logger.d("++ reconnect retrycount : " + this.l.get());
                        this.f45291h = null;
                        return true;
                    }
                } catch (InterruptedException e2) {
                    Logger.e("-- reconnect interrupted retry count = " + this.l.get());
                    throw e2;
                } catch (Exception e3) {
                    Logger.e("-- reconnect fail retry count = " + this.l.get() + " message : " + e3.getMessage());
                    sb = new StringBuilder("++ reconnect retrycount : ");
                } catch (Throwable th) {
                    Logger.d("++ reconnect retrycount : " + this.l.get());
                    this.f45291h = null;
                    throw th;
                }
            } else {
                a(a.FAIL);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        Logger.d("[SendBird] reconnected()");
        a(SendBird.getCurrentUser(), (SendBirdException) null);
        if (z) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final a aVar) {
        Logger.d(">> ConnectManager::notifyReconnectState() state : " + aVar.name());
        if (!SendBird.isAppBackground() && !this.f45288e.isEmpty()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ConnectionHandler connectionHandler : u.this.f45288e.values()) {
                        int i2 = AnonymousClass6.f45319a[aVar.ordinal()];
                        if (i2 == 1) {
                            connectionHandler.onReconnectStarted();
                        } else if (i2 != 2) {
                            connectionHandler.onReconnectFailed();
                        } else {
                            connectionHandler.onReconnectSucceeded();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.sendbird.android.u$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45319a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.sendbird.android.u$a[] r0 = com.sendbird.android.u.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45319a = r0
                int[] r0 = f45319a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.u$a r1 = com.sendbird.android.u.a.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f45319a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.u$a r1 = com.sendbird.android.u.a.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.u.AnonymousClass6.<clinit>():void");
        }
    }

    private void i() {
        Logger.d("[SendBird] reconnectSucceededFromOnErrorForNetworkHandler()");
        if (!SendBird.isAppBackground() && !this.f45289f.isEmpty()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (ConnectionManager.NetworkHandler networkHandler : u.this.f45289f.values()) {
                        if (networkHandler != null) {
                            networkHandler.onReconnected();
                        }
                    }
                }
            });
        }
    }

    private void j() {
        synchronized (this.p) {
            Iterator<CountDownLatch> it2 = this.p.iterator();
            while (it2.hasNext()) {
                it2.next().countDown();
            }
            this.p.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() throws SendBirdException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.p) {
            this.p.add(countDownLatch);
        }
        try {
            countDownLatch.await((long) (SendBird.Options.connectionTimeout + SendBird.Options.wsResponseTimeoutSec), TimeUnit.SECONDS);
            if (!d()) {
                throw b();
            }
        } catch (Exception unused) {
            throw b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        Connection connection;
        if (d() && (connection = this.f45290g) != null) {
            connection.g();
        }
    }

    public final void onError(boolean z, SendBirdException sendBirdException) {
        Logger.w(">> onError : " + sendBirdException.getMessage() + ", reconnecting : " + this.f45286c.get() + ", explicitDisconnect : " + z);
        if (!z && !this.f45286c.get()) {
            k unused = k.a.f44826a;
            k.b();
            APIClient.a().d();
            APIClient.a().c();
            a(true);
        }
    }

    private static <T> Future<T> a(final T t) {
        return new Future<T>() {
            public final boolean cancel(boolean z) {
                return false;
            }

            public final boolean isCancelled() {
                return false;
            }

            public final boolean isDone() {
                return true;
            }

            public final T get() {
                return t;
            }

            public final T get(long j, TimeUnit timeUnit) {
                return t;
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean a(TimeoutScheduler timeoutScheduler) {
        boolean z;
        if (timeoutScheduler != null) {
            timeoutScheduler.a(false);
            z = this.q.remove(timeoutScheduler);
        } else {
            z = false;
        }
        if (this.k.get() && this.o.isEmpty() && this.q.isEmpty()) {
            this.k.set(false);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final Future<Boolean> a(final Command command, final boolean z, final Command.SendCommandHandler sendCommandHandler) {
        Logger.d("__ request sendCommand[%s] Start", command.f44215a);
        if (!e()) {
            return this.f45292i.a(new s<Boolean>() {
                /* access modifiers changed from: private */
                /* renamed from: a */
                public Boolean call() {
                    try {
                        Logger.d("++ request sendCommand[%s] connected : %s, isReconnectFromError : %s", command.f44215a, Boolean.valueOf(u.this.d()), Boolean.valueOf(u.this.f45287d.get()));
                        if ((!u.this.d() && !z) || u.this.f45287d.get()) {
                            throw new SendBirdException("WS connection closed.", SendBirdError.ERR_WEBSOCKET_CONNECTION_CLOSED);
                        } else if (!command.f44215a.isAckRequired() || !command.f()) {
                            u.a(u.this, command, z);
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    if (sendCommandHandler != null) {
                                        sendCommandHandler.onResult(command, (SendBirdException) null);
                                    }
                                }
                            });
                            return Boolean.TRUE;
                        } else {
                            f fVar = new f((long) (SendBird.Options.wsResponseTimeoutSec * 1000), sendCommandHandler);
                            synchronized (u.this.r) {
                                u.this.r.putIfAbsent(command.f44217c, fVar);
                                u.a(u.this, command, z);
                                Logger.d(">> AckSession::start()");
                                fVar.f44705a.c();
                            }
                            return Boolean.TRUE;
                        }
                    } catch (Exception e2) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                if (sendCommandHandler != null) {
                                    Command.SendCommandHandler sendCommandHandler = sendCommandHandler;
                                    Command command = command;
                                    Exception exc = e2;
                                    sendCommandHandler.onResult(command, exc instanceof SendBirdException ? (SendBirdException) exc : new SendBirdException(exc.getMessage(), SendBirdError.ERR_REQUEST_FAILED));
                                }
                            }
                        });
                    }
                }
            });
        }
        if (sendCommandHandler != null) {
            sendCommandHandler.onResult((Command) null, new SendBirdException("Connection closed.", SendBirdError.ERR_WEBSOCKET_CONNECTION_CLOSED));
        }
        return a(Boolean.FALSE);
    }

    public final void onMessage(Command command) {
        SendBirdException sendBirdException;
        f remove;
        int i2;
        k a2 = k.a.f44826a;
        JsonObject asJsonObject = command.c().getAsJsonObject();
        int i3 = 0;
        if (asJsonObject != null && asJsonObject.has(StringSet.unread_cnt)) {
            w wVar = a2.f44725b;
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(StringSet.unread_cnt);
            if (asJsonObject2 != null) {
                long asLong = asJsonObject2.has(StringSet.ts) ? asJsonObject2.get(StringSet.ts).getAsLong() : 0;
                if (asLong > wVar.f45336c) {
                    wVar.f45336c = asLong;
                    int asInt = asJsonObject2.has(StringSet.all) ? asJsonObject2.get(StringSet.all).getAsInt() : wVar.f45334a;
                    if (asInt != wVar.f45334a) {
                        wVar.f45334a = asInt;
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (asJsonObject2.has(StringSet.custom_types)) {
                        for (Map.Entry next : asJsonObject2.getAsJsonObject(StringSet.custom_types).entrySet()) {
                            if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                                String str = (String) next.getKey();
                                int asInt2 = ((JsonElement) next.getValue()).getAsInt();
                                if (!wVar.f45337d.containsKey(str) || wVar.f45337d.get(str).intValue() != asInt2) {
                                    wVar.f45337d.put(str, Integer.valueOf(asInt2));
                                    i2 = 1;
                                }
                            }
                        }
                        for (Integer next2 : wVar.f45337d.values()) {
                            if (next2 != null) {
                                i3 += next2.intValue();
                            }
                        }
                        if (i3 != wVar.f45335b) {
                            wVar.f45335b = i3;
                            i3 = 1;
                        }
                    }
                    i3 = i2;
                }
            }
        }
        if (i3 != 0) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run(
/*
Method generation error in method: com.sendbird.android.k.25.run():void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.sendbird.android.k.25.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
        if (command.f44215a == m.EROR) {
            JsonObject asJsonObject3 = command.c().getAsJsonObject();
            sendBirdException = new SendBirdException(asJsonObject3.get("message").getAsString(), asJsonObject3.get("code").getAsInt());
        } else {
            o.a.f44853a.a(command);
            sendBirdException = null;
        }
        if (sendBirdException != null || (command.f44215a.isAckRequired() && command.f())) {
            synchronized (this.r) {
                remove = this.r.remove(command.f44217c);
            }
            if (remove != null) {
                Logger.d(">> AckSession::ackReceived()");
                remove.f44705a.a(true);
                remove.a(command, sendBirdException);
            }
        }
    }

    static /* synthetic */ void a(u uVar, String str, String str2, String str3, String str4, final ConnectionManager.AuthenticateHandler authenticateHandler, TimeoutScheduler timeoutScheduler) {
        if (uVar.a(timeoutScheduler)) {
            Logger.d("[SocketManager] localAuthenticate()");
            uVar.a(str, str2, str3, str4, new SendBird.ConnectHandler() {
                public final void onConnected(User user, SendBirdException sendBirdException) {
                    String str;
                    StringBuilder sb = new StringBuilder("[SocketManager] onAuthenticated()");
                    if (sendBirdException != null) {
                        str = " => " + sendBirdException.getMessage();
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    Logger.d(sb.toString());
                    ConnectionManager.AuthenticateHandler authenticateHandler = authenticateHandler;
                    if (authenticateHandler != null) {
                        authenticateHandler.onAuthenticated(user, sendBirdException);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(u uVar, Command command, boolean z) throws SendBirdException {
        Logger.d("_____ [%s][lazy : %s] SEND START, reconnectingFromError : %s, isConnecting : %s", command.f44215a, Boolean.valueOf(z), Boolean.valueOf(uVar.f45287d.get()), Boolean.valueOf(uVar.h()));
        if (z) {
            try {
                if (!uVar.d()) {
                    if (uVar.e() || uVar.f45287d.get()) {
                        throw b();
                    } else if (uVar.h()) {
                        uVar.f();
                    }
                }
            } catch (Exception e2) {
                throw new SendBirdException(e2.getMessage(), SendBirdError.ERR_WEBSOCKET_CONNECTION_FAILED);
            } catch (Throwable th) {
                Logger.d("_____ [%s] SEND END", command.f44215a);
                throw th;
            }
        }
        Connection connection = uVar.f45290g;
        Tag tag = Tag.CONNECTION;
        Logger.dt(tag, "++ Send: " + command.b());
        if (connection.f44220a != null) {
            connection.f44220a.send(command.b());
            Logger.d("_____ [%s] SEND END", command.f44215a);
            return;
        }
        throw new SendBirdException("Connection closed.", SendBirdError.ERR_WEBSOCKET_CONNECTION_CLOSED);
    }
}

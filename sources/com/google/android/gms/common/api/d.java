package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.aa;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.bh;
import com.google.android.gms.common.api.internal.bm;
import com.google.android.gms.common.api.internal.bs;
import com.google.android.gms.common.api.internal.ce;
import com.google.android.gms.common.api.internal.cg;
import com.google.android.gms.common.api.internal.ci;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;

public class d<O extends a.d> implements f<O> {
    private final a<O> mApi;
    private final Context mContext;
    private final int mId;
    private final O zabj;
    private final b<O> zabk;
    private final Looper zabl;
    private final e zabm;
    private final r zabn;
    protected final f zabo;

    protected d(Context context, a<O> aVar, Looper looper) {
        s.a(context, (Object) "Null context is not permitted.");
        s.a(aVar, (Object) "Api must not be null.");
        s.a(looper, (Object) "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.mApi = aVar;
        this.zabj = null;
        this.zabl = looper;
        this.zabk = new b<>(aVar);
        this.zabm = new bh(this);
        this.zabo = f.a(this.mContext);
        this.mId = this.zabo.f8587c.getAndIncrement();
        this.zabn = new com.google.android.gms.common.api.internal.a();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8368a = new C0128a().a();

        /* renamed from: b  reason: collision with root package name */
        public final r f8369b;

        /* renamed from: c  reason: collision with root package name */
        public final Looper f8370c;

        /* renamed from: com.google.android.gms.common.api.d$a$a  reason: collision with other inner class name */
        public static class C0128a {

            /* renamed from: a  reason: collision with root package name */
            private r f8371a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f8372b;

            public final C0128a a(r rVar) {
                s.a(rVar, (Object) "StatusExceptionMapper must not be null.");
                this.f8371a = rVar;
                return this;
            }

            public final C0128a a(Looper looper) {
                s.a(looper, (Object) "Looper must not be null.");
                this.f8372b = looper;
                return this;
            }

            public final a a() {
                if (this.f8371a == null) {
                    this.f8371a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f8372b == null) {
                    this.f8372b = Looper.getMainLooper();
                }
                return new a(this.f8371a, this.f8372b, (byte) 0);
            }
        }

        private a(r rVar, Looper looper) {
            this.f8369b = rVar;
            this.f8370c = looper;
        }

        /* synthetic */ a(r rVar, Looper looper, byte b2) {
            this(rVar, looper);
        }
    }

    @Deprecated
    public d(Context context, a<O> aVar, O o, Looper looper, r rVar) {
        this(context, aVar, o, new a.C0128a().a(looper).a(rVar).a());
    }

    public d(Activity activity, a<O> aVar, O o, a aVar2) {
        s.a(activity, (Object) "Null activity is not permitted.");
        s.a(aVar, (Object) "Api must not be null.");
        s.a(aVar2, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.mApi = aVar;
        this.zabj = o;
        this.zabl = aVar2.f8370c;
        this.zabk = b.a(this.mApi, this.zabj);
        this.zabm = new bh(this);
        this.zabo = f.a(this.mContext);
        this.mId = this.zabo.f8587c.getAndIncrement();
        this.zabn = aVar2.f8369b;
        if (!(activity instanceof GoogleApiActivity)) {
            z.a(activity, this.zabo, this.zabk);
        }
        this.zabo.a((d<?>) this);
    }

    public d(Context context, a<O> aVar, O o, a aVar2) {
        s.a(context, (Object) "Null context is not permitted.");
        s.a(aVar, (Object) "Api must not be null.");
        s.a(aVar2, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.mApi = aVar;
        this.zabj = o;
        this.zabl = aVar2.f8370c;
        this.zabk = b.a(this.mApi, this.zabj);
        this.zabm = new bh(this);
        this.zabo = f.a(this.mContext);
        this.mId = this.zabo.f8587c.getAndIncrement();
        this.zabn = aVar2.f8369b;
        this.zabo.a((d<?>) this);
    }

    @Deprecated
    public d(Activity activity, a<O> aVar, O o, r rVar) {
        this(activity, aVar, o, new a.C0128a().a(rVar).a(activity.getMainLooper()).a());
    }

    @Deprecated
    public d(Context context, a<O> aVar, O o, r rVar) {
        this(context, aVar, o, new a.C0128a().a(rVar).a());
    }

    private final <A extends a.b, T extends d.a<? extends l, A>> T zaa(int i2, T t) {
        t.e();
        f fVar = this.zabo;
        fVar.f8591g.sendMessage(fVar.f8591g.obtainMessage(4, new bm(new ce(i2, t), fVar.f8588d.get(), this)));
        return t;
    }

    private final <TResult, A extends a.b> Task<TResult> zaa(int i2, t<A, TResult> tVar) {
        com.google.android.gms.tasks.f fVar = new com.google.android.gms.tasks.f();
        f fVar2 = this.zabo;
        fVar2.f8591g.sendMessage(fVar2.f8591g.obtainMessage(4, new bm(new cg(i2, tVar, fVar, this.zabn), fVar2.f8588d.get(), this)));
        return fVar.f12478a;
    }

    public <A extends a.b, T extends d.a<? extends l, A>> T doRead(T t) {
        return zaa(0, t);
    }

    public <TResult, A extends a.b> Task<TResult> doRead(t<A, TResult> tVar) {
        return zaa(0, tVar);
    }

    public <A extends a.b, T extends d.a<? extends l, A>> T doWrite(T t) {
        return zaa(1, t);
    }

    public <TResult, A extends a.b> Task<TResult> doWrite(t<A, TResult> tVar) {
        return zaa(1, tVar);
    }

    public <A extends a.b, T extends d.a<? extends l, A>> T doBestEffortWrite(T t) {
        return zaa(2, t);
    }

    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(t<A, TResult> tVar) {
        return zaa(2, tVar);
    }

    @Deprecated
    public <A extends a.b, T extends n<A, ?>, U extends v<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        s.a(t);
        s.a(u);
        s.a(t.f8624a.f8618b, (Object) "Listener has already been released.");
        s.a(u.f8632a, (Object) "Listener has already been released.");
        s.b(t.f8624a.f8618b.equals(u.f8632a), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zabo.a(this, t, u);
    }

    public <A extends a.b> Task<Void> doRegisterEventListener(o<A, ?> oVar) {
        s.a(oVar);
        s.a(oVar.f8627a.f8624a.f8618b, (Object) "Listener has already been released.");
        s.a(oVar.f8628b.f8632a, (Object) "Listener has already been released.");
        return this.zabo.a(this, oVar.f8627a, oVar.f8628b);
    }

    public Task<Boolean> doUnregisterEventListener(k.a<?> aVar) {
        s.a(aVar, (Object) "Listener key cannot be null.");
        f fVar = this.zabo;
        com.google.android.gms.tasks.f fVar2 = new com.google.android.gms.tasks.f();
        fVar.f8591g.sendMessage(fVar.f8591g.obtainMessage(13, new bm(new ci(aVar, fVar2), fVar.f8588d.get(), this)));
        return fVar2.f12478a;
    }

    public <L> k<L> registerListener(L l, String str) {
        return l.a(l, this.zabl, str);
    }

    /* access modifiers changed from: protected */
    public Task<Boolean> disconnectService() {
        f fVar = this.zabo;
        aa aaVar = new aa(getApiKey());
        fVar.f8591g.sendMessage(fVar.f8591g.obtainMessage(14, aaVar));
        return aaVar.f8396b.f12478a;
    }

    public a.f zaa(Looper looper, f.a<O> aVar) {
        return this.mApi.a().buildClient(this.mContext, looper, createClientSettingsBuilder().a(), this.zabj, (e.b) aVar, (e.c) aVar);
    }

    public final a<O> getApi() {
        return this.mApi;
    }

    public O getApiOptions() {
        return this.zabj;
    }

    public b<O> getApiKey() {
        return this.zabk;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public e asGoogleApiClient() {
        return this.zabm;
    }

    public Looper getLooper() {
        return this.zabl;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.internal.d.a createClientSettingsBuilder() {
        /*
            r4 = this;
            com.google.android.gms.common.internal.d$a r0 = new com.google.android.gms.common.internal.d$a
            r0.<init>()
            O r1 = r4.zabj
            boolean r2 = r1 instanceof com.google.android.gms.common.api.a.d.b
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.common.api.a$d$b r1 = (com.google.android.gms.common.api.a.d.b) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.a()
            if (r1 == 0) goto L_0x0021
            java.lang.String r2 = r1.f8203a
            if (r2 == 0) goto L_0x002e
            android.accounts.Account r2 = new android.accounts.Account
            java.lang.String r1 = r1.f8203a
            java.lang.String r3 = "com.google"
            r2.<init>(r1, r3)
            goto L_0x002f
        L_0x0021:
            O r1 = r4.zabj
            boolean r2 = r1 instanceof com.google.android.gms.common.api.a.d.C0126a
            if (r2 == 0) goto L_0x002e
            com.google.android.gms.common.api.a$d$a r1 = (com.google.android.gms.common.api.a.d.C0126a) r1
            android.accounts.Account r2 = r1.a()
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r0.f8825a = r2
            O r1 = r4.zabj
            boolean r2 = r1 instanceof com.google.android.gms.common.api.a.d.b
            if (r2 == 0) goto L_0x0044
            com.google.android.gms.common.api.a$d$b r1 = (com.google.android.gms.common.api.a.d.b) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.a()
            if (r1 == 0) goto L_0x0044
            java.util.Set r1 = r1.a()
            goto L_0x0048
        L_0x0044:
            java.util.Set r1 = java.util.Collections.emptySet()
        L_0x0048:
            androidx.a.b<com.google.android.gms.common.api.Scope> r2 = r0.f8826b
            if (r2 != 0) goto L_0x0053
            androidx.a.b r2 = new androidx.a.b
            r2.<init>()
            r0.f8826b = r2
        L_0x0053:
            androidx.a.b<com.google.android.gms.common.api.Scope> r2 = r0.f8826b
            r2.addAll(r1)
            android.content.Context r1 = r4.mContext
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.f8828d = r1
            android.content.Context r1 = r4.mContext
            java.lang.String r1 = r1.getPackageName()
            r0.f8827c = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.d.createClientSettingsBuilder():com.google.android.gms.common.internal.d$a");
    }

    public bs zaa(Context context, Handler handler) {
        return new bs(context, handler, createClientSettingsBuilder().a());
    }
}

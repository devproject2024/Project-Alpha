package com.google.zxing.client.android.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

final class a implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40109a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Collection<String> f40110b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40111c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40112d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40113e;

    /* renamed from: f  reason: collision with root package name */
    private final Camera f40114f;

    /* renamed from: g  reason: collision with root package name */
    private AsyncTask<?, ?, ?> f40115g;

    static {
        ArrayList arrayList = new ArrayList(2);
        f40110b = arrayList;
        arrayList.add("auto");
        f40110b.add("macro");
    }

    a(Context context, Camera camera) {
        this.f40114f = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = true;
        this.f40113e = (!defaultSharedPreferences.getBoolean("preferences_auto_focus", true) || !f40110b.contains(focusMode)) ? false : z;
        StringBuilder sb = new StringBuilder("Current focus mode '");
        sb.append(focusMode);
        sb.append("'; use auto focus? ");
        sb.append(this.f40113e);
        a();
    }

    public final synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f40112d = false;
        c();
    }

    private synchronized void c() {
        if (!this.f40111c && this.f40115g == null) {
            C0673a aVar = new C0673a(this, (byte) 0);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f40115g = aVar;
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f40113e     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001d
            r0 = 0
            r1.f40115g = r0     // Catch:{ all -> 0x001f }
            boolean r0 = r1.f40111c     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x001d
            boolean r0 = r1.f40112d     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x001d
            android.hardware.Camera r0 = r1.f40114f     // Catch:{ RuntimeException -> 0x001a }
            r0.autoFocus(r1)     // Catch:{ RuntimeException -> 0x001a }
            r0 = 1
            r1.f40112d = r0     // Catch:{ RuntimeException -> 0x001a }
            monitor-exit(r1)
            return
        L_0x001a:
            r1.c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.a.a.a():void");
    }

    private synchronized void d() {
        if (this.f40115g != null) {
            if (this.f40115g.getStatus() != AsyncTask.Status.FINISHED) {
                this.f40115g.cancel(true);
            }
            this.f40115g = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b() {
        this.f40111c = true;
        if (this.f40113e) {
            d();
            try {
                this.f40114f.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }

    /* renamed from: com.google.zxing.client.android.a.a$a  reason: collision with other inner class name */
    final class C0673a extends AsyncTask<Object, Object, Object> {
        private C0673a() {
        }

        /* synthetic */ C0673a(a aVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException unused) {
            }
            a.this.a();
            return null;
        }
    }
}

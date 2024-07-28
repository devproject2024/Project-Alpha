package com.business.common_module.zxingutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.business.common_module.utilities.LogUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

final class b implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7397a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Collection<String> f7398b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7399c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7400d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7401e;

    /* renamed from: f  reason: collision with root package name */
    private final Camera f7402f;

    /* renamed from: g  reason: collision with root package name */
    private AsyncTask<?, ?, ?> f7403g;

    static {
        ArrayList arrayList = new ArrayList(2);
        f7398b = arrayList;
        arrayList.add("auto");
        f7398b.add("macro");
    }

    b(Context context, Camera camera) {
        this.f7402f = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = true;
        this.f7401e = (!defaultSharedPreferences.getBoolean("preferences_auto_focus", true) || !f7398b.contains(focusMode)) ? false : z;
        String str = f7397a;
        LogUtility.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f7401e);
        a();
    }

    public final synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f7400d = false;
        c();
    }

    private synchronized void c() {
        if (!this.f7399c && this.f7403g == null) {
            a aVar = new a(this, (byte) 0);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f7403g = aVar;
            } catch (RejectedExecutionException e2) {
                LogUtility.d(f7397a, "Could not request auto focus".concat(String.valueOf(e2)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (this.f7401e) {
            this.f7403g = null;
            if (!this.f7399c && !this.f7400d) {
                try {
                    this.f7402f.autoFocus(this);
                    this.f7400d = true;
                } catch (RuntimeException e2) {
                    LogUtility.d(f7397a, "Unexpected exception while focusing".concat(String.valueOf(e2)));
                    c();
                }
            }
        }
    }

    private synchronized void d() {
        if (this.f7403g != null) {
            if (this.f7403g.getStatus() != AsyncTask.Status.FINISHED) {
                this.f7403g.cancel(true);
            }
            this.f7403g = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b() {
        this.f7399c = true;
        if (this.f7401e) {
            d();
            try {
                this.f7402f.cancelAutoFocus();
            } catch (RuntimeException e2) {
                LogUtility.d(f7397a, "Unexpected exception while cancelling focusing".concat(String.valueOf(e2)));
            }
        }
    }

    final class a extends AsyncTask<Object, Object, Object> {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException unused) {
            }
            b.this.a();
            return null;
        }
    }
}

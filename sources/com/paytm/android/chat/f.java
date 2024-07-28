package com.paytm.android.chat;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import kotlin.g.b.k;
import kotlin.m.p;

public final class f {
    public static final void a(View view, boolean z) {
        k.c(view, "$this$isVisible");
        view.setVisibility(z ? 0 : 8);
    }

    public static final String a(String str) {
        if (str == null || p.b(str).toString().length() == 0) {
            return null;
        }
        return str;
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f42026a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f42027b;

        b(z zVar, Object obj) {
            this.f42026a = zVar;
            this.f42027b = obj;
        }

        public final void run() {
            if (!this.f42026a.isDisposed()) {
                this.f42026a.onSuccess(this.f42027b);
            }
        }
    }

    public static final <T> void a(z<T> zVar, T t) {
        k.c(zVar, "$this$onSuccessMainThread");
        io.reactivex.rxjava3.android.b.a.a().a((Runnable) new b(zVar, t));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f42021a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f42022b;

        a(z zVar, Throwable th) {
            this.f42021a = zVar;
            this.f42022b = th;
        }

        public final void run() {
            if (!this.f42021a.isDisposed()) {
                this.f42021a.onError(this.f42022b);
            }
        }
    }

    public static final <T> void a(z<T> zVar, Throwable th) {
        k.c(zVar, "$this$onErrorMainThread");
        k.c(th, "value");
        io.reactivex.rxjava3.android.b.a.a().a((Runnable) new a(zVar, th));
    }

    static final class c<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Task f42031a;

        c(Task task) {
            this.f42031a = task;
        }

        public final void subscribe(final z<Result> zVar) {
            this.f42031a.a(new OnSuccessListener<Result>() {
                public final void onSuccess(Result result) {
                    if (result != null) {
                        z zVar = zVar;
                        k.a((Object) zVar, "source");
                        if (!zVar.isDisposed()) {
                            zVar.onSuccess(result);
                            return;
                        }
                        return;
                    }
                    z zVar2 = zVar;
                    k.a((Object) zVar2, "source");
                    if (!zVar2.isDisposed()) {
                        zVar.onError(new NullPointerException("Result was null"));
                    }
                }
            }).a((OnFailureListener) new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    k.c(exc, "error");
                    z zVar = zVar;
                    k.a((Object) zVar, "source");
                    if (!zVar.isDisposed()) {
                        zVar.onError(exc);
                    }
                }
            });
        }
    }

    public static final <Result> y<Result> a(Task<Result> task) {
        k.c(task, "$this$toSingle");
        y<Result> a2 = y.a(new c(task));
        k.a((Object) a2, "Single.create<Result> { …        }\n        }\n    }");
        return a2;
    }

    public static final boolean a(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }
}

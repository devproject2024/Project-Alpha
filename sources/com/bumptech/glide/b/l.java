package com.bumptech.glide.b;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.bumptech.glide.b;
import com.bumptech.glide.g.k;
import com.bumptech.glide.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class l implements Handler.Callback {

    /* renamed from: i  reason: collision with root package name */
    private static final a f6448i = new a() {
        public final i a(b bVar, h hVar, m mVar, Context context) {
            return new i(bVar, hVar, mVar, context);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, k> f6449a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<j, o> f6450b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final androidx.a.a<View, Fragment> f6451c = new androidx.a.a<>();

    /* renamed from: d  reason: collision with root package name */
    public final androidx.a.a<View, android.app.Fragment> f6452d = new androidx.a.a<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile i f6453e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f6454f;

    /* renamed from: g  reason: collision with root package name */
    private final a f6455g;

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f6456h = new Bundle();

    public interface a {
        i a(b bVar, h hVar, m mVar, Context context);
    }

    public l(a aVar) {
        this.f6455g = aVar == null ? f6448i : aVar;
        this.f6454f = new Handler(Looper.getMainLooper(), this);
    }

    private i c(Context context) {
        if (this.f6453e == null) {
            synchronized (this) {
                if (this.f6453e == null) {
                    this.f6453e = this.f6455g.a(b.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f6453e;
    }

    public final i a(Context context) {
        while (context != null) {
            if (k.c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        context = contextWrapper.getBaseContext();
                    }
                }
            }
            return c(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final i a(FragmentActivity fragmentActivity) {
        if (k.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        return a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    public final i a(Activity activity) {
        if (k.d()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    a((Collection<Fragment>) next.getChildFragmentManager().f3424a.d(), map);
                }
            }
        }
    }

    @Deprecated
    public final void a(FragmentManager fragmentManager, androidx.a.a<View, android.app.Fragment> aVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    aVar.put(next.getView(), next);
                    a(next.getChildFragmentManager(), aVar);
                }
            }
            return;
        }
        b(fragmentManager, aVar);
    }

    @Deprecated
    private void b(FragmentManager fragmentManager, androidx.a.a<View, android.app.Fragment> aVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f6456h.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f6456h, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    aVar.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), aVar);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public static Activity b(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final k b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    private k a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f6449a.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.a(fragment);
            if (z) {
                kVar.f6441a.a();
            }
            this.f6449a.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f6454f.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    @Deprecated
    public final i a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        k a2 = a(fragmentManager, fragment, z);
        i iVar = a2.f6443c;
        if (iVar != null) {
            return iVar;
        }
        i a3 = this.f6455g.a(b.a(context), a2.f6441a, a2.f6442b, context);
        a2.f6443c = a3;
        return a3;
    }

    /* access modifiers changed from: package-private */
    public final o a(Context context, j jVar) {
        return a(jVar, (Fragment) null, d(context));
    }

    private static boolean d(Context context) {
        Activity b2 = b(context);
        return b2 == null || !b2.isFinishing();
    }

    private o a(j jVar, Fragment fragment, boolean z) {
        o oVar = (o) jVar.c("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f6450b.get(jVar)) == null) {
            oVar = new o();
            oVar.a(fragment);
            if (z) {
                oVar.f6460a.a();
            }
            this.f6450b.put(jVar, oVar);
            jVar.a().a((Fragment) oVar, "com.bumptech.glide.manager").c();
            this.f6454f.obtainMessage(2, jVar).sendToTarget();
        }
        return oVar;
    }

    public final i a(Context context, j jVar, Fragment fragment, boolean z) {
        o a2 = a(jVar, fragment, z);
        i iVar = a2.f6462c;
        if (iVar != null) {
            return iVar;
        }
        i a3 = this.f6455g.a(b.a(context), a2.f6460a, a2.f6461b, context);
        a2.f6462c = a3;
        return a3;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        int i2 = message.what;
        Object obj2 = null;
        boolean z = true;
        if (i2 == 1) {
            obj2 = (FragmentManager) message.obj;
            obj = this.f6449a.remove(obj2);
        } else if (i2 != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (j) message.obj;
            obj = this.f6450b.remove(obj2);
        }
        if (z && obj == null && Log.isLoggable("RMRetriever", 5)) {
            new StringBuilder("Failed to remove expected request manager fragment, manager: ").append(obj2);
        }
        return z;
    }
}

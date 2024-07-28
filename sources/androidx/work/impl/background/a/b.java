package androidx.work.impl.background.a;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.p;
import androidx.work.impl.e;
import androidx.work.impl.j;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import androidx.work.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b implements c, androidx.work.impl.b, e {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5231b = l.a("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    Boolean f5232a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5233c;

    /* renamed from: d  reason: collision with root package name */
    private final j f5234d;

    /* renamed from: e  reason: collision with root package name */
    private final d f5235e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<p> f5236f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private a f5237g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5238h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f5239i;

    public final boolean a() {
        return false;
    }

    public b(Context context, androidx.work.b bVar, a aVar, j jVar) {
        this.f5233c = context;
        this.f5234d = jVar;
        this.f5235e = new d(context, aVar, this);
        this.f5237g = new a(this, bVar.f5058e);
        this.f5239i = new Object();
    }

    public final void a(p... pVarArr) {
        if (this.f5232a == null) {
            this.f5232a = Boolean.valueOf(TextUtils.equals(this.f5233c.getPackageName(), c()));
        }
        if (!this.f5232a.booleanValue()) {
            l.a();
            return;
        }
        b();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long c2 = pVar.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f5181b == u.a.ENQUEUED) {
                if (currentTimeMillis < c2) {
                    a aVar = this.f5237g;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (!pVar.d()) {
                    l.a();
                    String.format("Starting work for %s", new Object[]{pVar.f5180a});
                    this.f5234d.a(pVar.f5180a, (WorkerParameters.a) null);
                } else if (Build.VERSION.SDK_INT >= 23 && pVar.j.f5075d) {
                    l.a();
                    String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{pVar});
                } else if (Build.VERSION.SDK_INT < 24 || !pVar.j.a()) {
                    hashSet.add(pVar);
                    hashSet2.add(pVar.f5180a);
                } else {
                    l.a();
                    String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{pVar});
                }
            }
        }
        synchronized (this.f5239i) {
            if (!hashSet.isEmpty()) {
                l.a();
                String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(AppConstants.COMMA, hashSet2)});
                this.f5236f.addAll(hashSet);
                this.f5235e.a((Iterable<p>) this.f5236f);
            }
        }
    }

    public final void a(String str) {
        Runnable remove;
        if (this.f5232a == null) {
            this.f5232a = Boolean.valueOf(TextUtils.equals(this.f5233c.getPackageName(), c()));
        }
        if (!this.f5232a.booleanValue()) {
            l.a();
            return;
        }
        b();
        l.a();
        String.format("Cancelling work ID %s", new Object[]{str});
        a aVar = this.f5237g;
        if (!(aVar == null || (remove = aVar.f5228d.remove(str)) == null)) {
            aVar.f5227c.a(remove);
        }
        this.f5234d.d(str);
    }

    public final void a(List<String> list) {
        for (String next : list) {
            l.a();
            String.format("Constraints met: Scheduling work ID %s", new Object[]{next});
            this.f5234d.a(next, (WorkerParameters.a) null);
        }
    }

    public final void b(List<String> list) {
        for (String next : list) {
            l.a();
            String.format("Constraints not met: Cancelling work ID %s", new Object[]{next});
            this.f5234d.d(next);
        }
    }

    private void b() {
        if (!this.f5238h) {
            this.f5234d.f5364f.a((androidx.work.impl.b) this);
            this.f5238h = true;
        }
    }

    private String c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread", false, b.class.getClassLoader());
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = cls.getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke((Object) null, new Object[0]);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("getProcessName", new Class[0]);
                declaredMethod3.setAccessible(true);
                obj = declaredMethod3.invoke(declaredMethod2.invoke((Object) null, new Object[0]), new Object[0]);
            }
            if (obj instanceof String) {
                return (String) obj;
            }
        } catch (Throwable th) {
            l.a();
            new Throwable[1][0] = th;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.f5233c.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public final void a(String str, boolean z) {
        synchronized (this.f5239i) {
            Iterator<p> it2 = this.f5236f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                p next = it2.next();
                if (next.f5180a.equals(str)) {
                    l.a();
                    String.format("Stopping tracking for %s", new Object[]{str});
                    this.f5236f.remove(next);
                    this.f5235e.a((Iterable<p>) this.f5236f);
                    break;
                }
            }
        }
    }
}

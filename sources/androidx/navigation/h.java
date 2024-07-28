package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.p;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3898a;

    /* renamed from: b  reason: collision with root package name */
    m f3899b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f3900c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f3901d;

    /* renamed from: e  reason: collision with root package name */
    public Parcelable[] f3902e;

    /* renamed from: f  reason: collision with root package name */
    public final Deque<g> f3903f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final t f3904g = new t() {
        public final s<? extends k> a(String str, s<? extends k> sVar) {
            s<? extends k> a2 = super.a(str, sVar);
            if (a2 != sVar) {
                if (a2 != null) {
                    a2.b(h.this.f3905h);
                }
                sVar.a(h.this.f3905h);
            }
            return a2;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    final s.c f3905h = new s.c() {
        public final void a(s sVar) {
            k kVar;
            Iterator<g> descendingIterator = h.this.f3903f.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = descendingIterator.next().f3896a;
                if (h.this.f3904g.a(kVar.f3919c) == sVar) {
                    break;
                }
            }
            if (kVar != null) {
                h.this.a(kVar.f3921e, false);
                if (!h.this.f3903f.isEmpty()) {
                    h.this.f3903f.removeLast();
                }
                h.this.c();
                return;
            }
            throw new IllegalArgumentException("Navigator " + sVar + " reported pop but did not have any destinations on the NavController back stack");
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private Activity f3906i;
    private o j;
    private final CopyOnWriteArrayList<Object> k = new CopyOnWriteArrayList<>();

    public h(Context context) {
        this.f3898a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f3906i = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        t tVar = this.f3904g;
        tVar.a((s<? extends k>) new n(tVar));
        this.f3904g.a((s<? extends k>) new a(this.f3898a));
    }

    public final boolean a() {
        if (this.f3903f.isEmpty()) {
            return false;
        }
        return b(e().f3921e, true);
    }

    private boolean b(int i2, boolean z) {
        return a(i2, z) && c();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.f3903f.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<g> descendingIterator = this.f3903f.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            k kVar = descendingIterator.next().f3896a;
            s a2 = this.f3904g.a(kVar.f3919c);
            if (z || kVar.f3921e != i2) {
                arrayList.add(a2);
            }
            if (kVar.f3921e == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            String a3 = k.a(this.f3898a, i2);
            StringBuilder sb = new StringBuilder("Ignoring popBackStack to destination ");
            sb.append(a3);
            sb.append(" as it was not found on the current back stack");
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext() && ((s) it2.next()).a()) {
            this.f3903f.removeLast();
            z3 = true;
        }
        return z3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x0027, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r3 = this;
        L_0x0000:
            java.util.Deque<androidx.navigation.g> r0 = r3.f3903f
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != 0) goto L_0x0029
            java.util.Deque<androidx.navigation.g> r0 = r3.f3903f
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.g r0 = (androidx.navigation.g) r0
            androidx.navigation.k r0 = r0.f3896a
            boolean r0 = r0 instanceof androidx.navigation.m
            if (r0 == 0) goto L_0x0029
            java.util.Deque<androidx.navigation.g> r0 = r3.f3903f
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.g r0 = (androidx.navigation.g) r0
            androidx.navigation.k r0 = r0.f3896a
            int r0 = r0.f3921e
            boolean r0 = r3.a((int) r0, (boolean) r1)
            if (r0 != 0) goto L_0x0000
        L_0x0029:
            java.util.Deque<androidx.navigation.g> r0 = r3.f3903f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0047
            java.util.Deque<androidx.navigation.g> r0 = r3.f3903f
            r0.peekLast()
            java.util.concurrent.CopyOnWriteArrayList<java.lang.Object> r0 = r3.k
            java.util.Iterator r0 = r0.iterator()
        L_0x003c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0046
            r0.next()
            goto L_0x003c
        L_0x0046:
            return r1
        L_0x0047:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.h.c():boolean");
    }

    public final o d() {
        if (this.j == null) {
            this.j = new o(this.f3898a, this.f3904g);
        }
        return this.j;
    }

    public final void a(int i2, Bundle bundle) {
        a(d().a(i2), bundle);
    }

    public final void a(m mVar, Bundle bundle) {
        m mVar2 = this.f3899b;
        if (mVar2 != null) {
            a(mVar2.f3921e, true);
        }
        this.f3899b = mVar;
        a(bundle);
    }

    private void a(Bundle bundle) {
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f3900c;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                s a2 = this.f3904g.a(next);
                Bundle bundle3 = this.f3900c.getBundle(next);
                if (bundle3 != null) {
                    a2.a(bundle3);
                }
            }
        }
        boolean z = false;
        if (this.f3901d != null) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f3901d;
                if (i2 >= iArr.length) {
                    this.f3901d = null;
                    this.f3902e = null;
                    break;
                }
                int i3 = iArr[i2];
                Bundle bundle4 = (Bundle) this.f3902e[i2];
                k a3 = a(i3);
                if (a3 != null) {
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.f3898a.getClassLoader());
                    }
                    this.f3903f.add(new g(a3, bundle4));
                    i2++;
                } else {
                    throw new IllegalStateException("unknown destination during restore: " + this.f3898a.getResources().getResourceName(i3));
                }
            }
        }
        if (this.f3899b != null && this.f3903f.isEmpty()) {
            Activity activity = this.f3906i;
            if (activity != null && a(activity.getIntent())) {
                z = true;
            }
            if (!z) {
                a(this.f3899b, bundle, (p) null);
            }
        }
    }

    private boolean a(Intent intent) {
        k kVar;
        m mVar;
        k.a a2;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        Bundle bundle = null;
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle2 = new Bundle();
        if (extras != null) {
            bundle = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (!((intArray != null && intArray.length != 0) || intent.getData() == null || (a2 = this.f3899b.a(intent.getData())) == null)) {
            intArray = a2.f3926a.d();
            bundle2.putAll(a2.f3927b);
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String a3 = a(intArray);
        if (a3 != null) {
            StringBuilder sb = new StringBuilder("Could not find destination ");
            sb.append(a3);
            sb.append(" in the navigation graph, ignoring the deep link from ");
            sb.append(intent);
            return false;
        }
        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i2 = 268435456 & flags;
        if (i2 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            p.a(this.f3898a).b(intent).a();
            Activity activity = this.f3906i;
            if (activity != null) {
                activity.finish();
            }
            return true;
        } else if (i2 != 0) {
            if (!this.f3903f.isEmpty()) {
                a(this.f3899b.f3921e, true);
            }
            int i3 = 0;
            while (i3 < intArray.length) {
                int i4 = i3 + 1;
                int i5 = intArray[i3];
                k a4 = a(i5);
                if (a4 != null) {
                    p.a aVar = new p.a();
                    aVar.f3950d = 0;
                    aVar.f3951e = 0;
                    a(a4, bundle2, aVar.a());
                    i3 = i4;
                } else {
                    throw new IllegalStateException("unknown destination during deep link: " + k.a(this.f3898a, i5));
                }
            }
            return true;
        } else {
            m mVar2 = this.f3899b;
            int i6 = 0;
            while (i6 < intArray.length) {
                int i7 = intArray[i6];
                if (i6 == 0) {
                    kVar = this.f3899b;
                } else {
                    kVar = mVar2.a(i7, true);
                }
                if (kVar != null) {
                    if (i6 != intArray.length - 1) {
                        while (true) {
                            mVar = (m) kVar;
                            if (!(mVar.a(mVar.f3930b, true) instanceof m)) {
                                break;
                            }
                            kVar = mVar.a(mVar.f3930b, true);
                        }
                        mVar2 = mVar;
                    } else {
                        Bundle a5 = kVar.a(bundle2);
                        p.a a6 = new p.a().a(this.f3899b.f3921e, true);
                        a6.f3950d = 0;
                        a6.f3951e = 0;
                        a(kVar, a5, a6.a());
                    }
                    i6++;
                } else {
                    throw new IllegalStateException("unknown destination during deep link: " + k.a(this.f3898a, i7));
                }
            }
            return true;
        }
    }

    private String a(int[] iArr) {
        k kVar;
        m mVar;
        m mVar2 = this.f3899b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i2 == 0) {
                kVar = this.f3899b;
            } else {
                kVar = mVar2.a(i3, true);
            }
            if (kVar == null) {
                return k.a(this.f3898a, i3);
            }
            if (i2 != iArr.length - 1) {
                while (true) {
                    mVar = (m) kVar;
                    if (!(mVar.a(mVar.f3930b, true) instanceof m)) {
                        break;
                    }
                    kVar = mVar.a(mVar.f3930b, true);
                }
                mVar2 = mVar;
            }
        }
        return null;
    }

    public final k e() {
        if (this.f3903f.isEmpty()) {
            return null;
        }
        return this.f3903f.getLast().f3896a;
    }

    private k a(int i2) {
        k kVar;
        m mVar = this.f3899b;
        if (mVar == null) {
            return null;
        }
        if (mVar.f3921e == i2) {
            return this.f3899b;
        }
        if (this.f3903f.isEmpty()) {
            kVar = this.f3899b;
        } else {
            kVar = this.f3903f.getLast().f3896a;
        }
        return (kVar instanceof m ? (m) kVar : kVar.f3920d).a(i2, true);
    }

    public final void a(l lVar) {
        k kVar;
        int i2;
        p pVar;
        String str;
        int a2 = lVar.a();
        Bundle b2 = lVar.b();
        if (this.f3903f.isEmpty()) {
            kVar = this.f3899b;
        } else {
            kVar = this.f3903f.getLast().f3896a;
        }
        if (kVar != null) {
            b a3 = kVar.a(a2);
            Bundle bundle = null;
            if (a3 != null) {
                pVar = a3.f3869b;
                i2 = a3.f3868a;
                Bundle bundle2 = a3.f3870c;
                if (bundle2 != null) {
                    bundle = new Bundle();
                    bundle.putAll(bundle2);
                }
            } else {
                i2 = a2;
                pVar = null;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putAll(b2);
            if (i2 == 0 && pVar != null && pVar.f3941b != -1) {
                b(pVar.f3941b, pVar.f3942c);
            } else if (i2 != 0) {
                k a4 = a(i2);
                if (a4 == null) {
                    String a5 = k.a(this.f3898a, i2);
                    StringBuilder sb = new StringBuilder("navigation destination ");
                    sb.append(a5);
                    if (a3 != null) {
                        str = " referenced from action " + k.a(this.f3898a, a2);
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(" is unknown to this NavController");
                    throw new IllegalArgumentException(sb.toString());
                }
                a(a4, bundle, pVar);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public final boolean b() {
        int i2 = 0;
        for (g gVar : this.f3903f) {
            if (!(gVar.f3896a instanceof m)) {
                i2++;
            }
        }
        if (i2 != 1) {
            return a();
        }
        k e2 = e();
        int i3 = e2.f3921e;
        for (m mVar = e2.f3920d; mVar != null; mVar = mVar.f3920d) {
            if (mVar.f3930b != i3) {
                j jVar = new j(this);
                jVar.f3916d = mVar.f3921e;
                if (jVar.f3915c != null) {
                    k kVar = null;
                    ArrayDeque arrayDeque = new ArrayDeque();
                    arrayDeque.add(jVar.f3915c);
                    while (!arrayDeque.isEmpty() && kVar == null) {
                        k kVar2 = (k) arrayDeque.poll();
                        if (kVar2.f3921e == jVar.f3916d) {
                            kVar = kVar2;
                        } else if (kVar2 instanceof m) {
                            Iterator<k> it2 = ((m) kVar2).iterator();
                            while (it2.hasNext()) {
                                arrayDeque.add(it2.next());
                            }
                        }
                    }
                    if (kVar != null) {
                        jVar.f3914b.putExtra("android-support-nav:controller:deepLinkIds", kVar.d());
                    } else {
                        String a2 = k.a(jVar.f3913a, jVar.f3916d);
                        throw new IllegalArgumentException("navigation destination " + a2 + " is unknown to this NavController");
                    }
                }
                jVar.a().a();
                Activity activity = this.f3906i;
                if (activity != null) {
                    activity.finish();
                }
                return true;
            }
            i3 = mVar.f3921e;
        }
        return false;
    }

    private void a(k kVar, Bundle bundle, p pVar) {
        boolean a2 = (pVar == null || pVar.f3941b == -1) ? false : a(pVar.f3941b, pVar.f3942c);
        s a3 = this.f3904g.a(kVar.f3919c);
        Bundle a4 = kVar.a(bundle);
        k a5 = a3.a(kVar, a4, pVar, (s.a) null);
        if (a5 != null) {
            ArrayDeque arrayDeque = new ArrayDeque();
            for (m mVar = a5.f3920d; mVar != null; mVar = mVar.f3920d) {
                arrayDeque.addFirst(new g(mVar, a4));
            }
            Iterator<g> it2 = this.f3903f.iterator();
            while (it2.hasNext() && !arrayDeque.isEmpty()) {
                if (it2.next().f3896a.equals(((g) arrayDeque.getFirst()).f3896a)) {
                    arrayDeque.removeFirst();
                }
            }
            this.f3903f.addAll(arrayDeque);
            this.f3903f.add(new g(a5, a4));
        }
        if (a2 || a5 != null) {
            c();
        }
    }
}

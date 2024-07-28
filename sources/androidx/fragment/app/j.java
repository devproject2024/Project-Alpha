package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import androidx.fragment.app.q;
import androidx.fragment.app.r;
import androidx.lifecycle.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class j {
    private static boolean q = false;
    private boolean A;
    private ArrayList<a> B;
    private ArrayList<Boolean> C;
    private ArrayList<Fragment> D;
    private ArrayList<f> E;
    private Runnable F = new Runnable() {
        public final void run() {
            j.this.a(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final p f3424a = new p();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<a> f3425b;

    /* renamed from: c  reason: collision with root package name */
    final h f3426c = new h(this);

    /* renamed from: d  reason: collision with root package name */
    OnBackPressedDispatcher f3427d;

    /* renamed from: e  reason: collision with root package name */
    final androidx.activity.b f3428e = new androidx.activity.b() {
        public final void b() {
            j jVar = j.this;
            jVar.a(true);
            if (jVar.f3428e.f984a) {
                jVar.a((String) null, 0);
            } else {
                jVar.f3427d.a();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    final AtomicInteger f3429f = new AtomicInteger();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f3430g;

    /* renamed from: h  reason: collision with root package name */
    ConcurrentHashMap<Fragment, HashSet<androidx.core.d.b>> f3431h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final i f3432i = new i(this);
    int j = -1;
    g<?> k;
    d l;
    Fragment m;
    public Fragment n;
    public boolean o;
    l p;
    private final ArrayList<d> r = new ArrayList<>();
    private boolean s;
    private ArrayList<Fragment> t;
    private final r.a u = new r.a() {
        public final void a(Fragment fragment, androidx.core.d.b bVar) {
            j jVar = j.this;
            if (jVar.f3431h.get(fragment) == null) {
                jVar.f3431h.put(fragment, new HashSet());
            }
            jVar.f3431h.get(fragment).add(bVar);
        }

        public final void b(Fragment fragment, androidx.core.d.b bVar) {
            if (!bVar.a()) {
                j jVar = j.this;
                HashSet hashSet = jVar.f3431h.get(fragment);
                if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
                    jVar.f3431h.remove(fragment);
                    if (fragment.mState < 3) {
                        jVar.f(fragment);
                        jVar.a(fragment, fragment.getStateAfterAnimating());
                    }
                }
            }
        }
    };
    private f v = null;
    private f w = new f() {
        public final Fragment c(ClassLoader classLoader, String str) {
            return Fragment.instantiate(j.this.k.f3416c, str, (Bundle) null);
        }
    };
    private boolean x;
    private boolean y;
    private boolean z;

    public interface a {
        String g();
    }

    public static abstract class b {
        public void a(j jVar, Fragment fragment, View view) {
        }
    }

    public interface c {
        void a();
    }

    interface d {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    static int e(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    static boolean a(int i2) {
        return q || Log.isLoggable("FragmentManager", i2);
    }

    private void a(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
        g<?> gVar = this.k;
        if (gVar != null) {
            try {
                gVar.a("  ", printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public final q a() {
        return new a(this);
    }

    public final boolean b() {
        boolean a2 = a(true);
        y();
        return a2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (f() <= 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (a(r3.m) == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r0.f984a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r3.f3428e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.j$d> r0 = r3.r
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.j$d> r1 = r3.r     // Catch:{ all -> 0x0028 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0028 }
            r2 = 1
            if (r1 != 0) goto L_0x0012
            androidx.activity.b r1 = r3.f3428e     // Catch:{ all -> 0x0028 }
            r1.f984a = r2     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            androidx.activity.b r0 = r3.f3428e
            int r1 = r3.f()
            if (r1 <= 0) goto L_0x0024
            androidx.fragment.app.Fragment r1 = r3.m
            boolean r1 = r3.a((androidx.fragment.app.Fragment) r1)
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r0.f984a = r2
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.c():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        j jVar = fragment.mFragmentManager;
        if (!fragment.equals(jVar.n) || !a(jVar.m)) {
            return false;
        }
        return true;
    }

    public final void d() {
        a((d) new e((String) null, -1, 0), false);
    }

    public final boolean e() {
        return a((String) null, 0);
    }

    public final void a(String str) {
        a((d) new e(str, -1, 1), false);
    }

    public final boolean b(String str) {
        return a(str, 0);
    }

    public final boolean a(String str, int i2) {
        a(false);
        d(true);
        Fragment fragment = this.n;
        if (fragment != null && str == null && fragment.getChildFragmentManager().a((String) null, 0)) {
            return true;
        }
        boolean a2 = a(this.B, this.C, str, -1, i2);
        if (a2) {
            this.s = true;
            try {
                b(this.B, this.C);
            } finally {
                x();
            }
        }
        c();
        A();
        this.f3424a.a();
        return a2;
    }

    public final int f() {
        ArrayList<a> arrayList = this.f3425b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final a b(int i2) {
        return this.f3425b.get(i2);
    }

    public final void a(c cVar) {
        if (this.f3430g == null) {
            this.f3430g = new ArrayList<>();
        }
        this.f3430g.add(cVar);
    }

    public final void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public final Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment e2 = e(string);
        if (e2 == null) {
            a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return e2;
    }

    static Fragment a(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public final List<Fragment> g() {
        return this.f3424a.d();
    }

    private l r(Fragment fragment) {
        l lVar = this.p;
        l lVar2 = lVar.f3450b.get(fragment.mWho);
        if (lVar2 != null) {
            return lVar2;
        }
        l lVar3 = new l(lVar.f3452d);
        lVar.f3450b.put(fragment.mWho, lVar3);
        return lVar3;
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment) {
        if (i()) {
            a(2);
        } else if (this.p.a(fragment) && a(2)) {
            new StringBuilder("Updating retained Fragments: Added ").append(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Fragment fragment) {
        if (i()) {
            a(2);
        } else if (this.p.c(fragment) && a(2)) {
            new StringBuilder("Updating retained Fragments: Removed ").append(fragment);
        }
    }

    public final Fragment.SavedState d(Fragment fragment) {
        Bundle k2;
        n c2 = this.f3424a.c(fragment.mWho);
        if (c2 == null || !c2.f3455a.equals(fragment)) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (c2.f3455a.mState < 0 || (k2 = c2.k()) == null) {
            return null;
        }
        return new Fragment.SavedState(k2);
    }

    public final boolean h() {
        return this.o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.m;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.m)));
            sb.append("}");
        } else {
            g<?> gVar = this.k;
            if (gVar != null) {
                sb.append(gVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.k)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3424a.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.t;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.t.get(i2).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f3425b;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f3425b.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3429f.get());
        synchronized (this.r) {
            int size3 = this.r.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.r.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.l);
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.m);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.j);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.y);
        printWriter.print(" mStopped=");
        printWriter.print(this.z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.o);
        if (this.x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.x);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.s) {
            this.A = true;
            return;
        }
        fragment.mDeferStart = false;
        a(fragment, this.j);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r2 != 3) goto L_0x01e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.p r0 = r10.f3424a
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.n r0 = r0.c((java.lang.String) r1)
            r1 = 1
            if (r0 != 0) goto L_0x0014
            androidx.fragment.app.n r0 = new androidx.fragment.app.n
            androidx.fragment.app.i r2 = r10.f3432i
            r0.<init>(r2, r11)
            r0.f3456b = r1
        L_0x0014:
            int r2 = r0.a()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r3 = 0
            r4 = 2
            r5 = 3
            if (r2 > r12) goto L_0x00f9
            int r2 = r11.mState
            if (r2 >= r12) goto L_0x0032
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.d.b>> r2 = r10.f3431h
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0032
            r10.s(r11)
        L_0x0032:
            int r2 = r11.mState
            r6 = -1
            if (r2 == r6) goto L_0x0041
            if (r2 == 0) goto L_0x00d6
            if (r2 == r1) goto L_0x00db
            if (r2 == r4) goto L_0x00ed
            if (r2 == r5) goto L_0x00f2
            goto L_0x01e9
        L_0x0041:
            if (r12 < 0) goto L_0x00d6
            boolean r2 = a((int) r5)
            if (r2 == 0) goto L_0x0053
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "moveto ATTACHED: "
            r2.<init>(r6)
            r2.append(r11)
        L_0x0053:
            androidx.fragment.app.Fragment r2 = r11.mTarget
            java.lang.String r6 = " that does not belong to this FragmentManager!"
            java.lang.String r7 = " declared target fragment "
            java.lang.String r8 = "Fragment "
            if (r2 == 0) goto L_0x009e
            androidx.fragment.app.Fragment r2 = r11.mTarget
            androidx.fragment.app.Fragment r9 = r11.mTarget
            java.lang.String r9 = r9.mWho
            androidx.fragment.app.Fragment r9 = r10.e((java.lang.String) r9)
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x0081
            androidx.fragment.app.Fragment r2 = r11.mTarget
            int r2 = r2.mState
            if (r2 > 0) goto L_0x0078
            androidx.fragment.app.Fragment r2 = r11.mTarget
            r10.a((androidx.fragment.app.Fragment) r2, (int) r1)
        L_0x0078:
            androidx.fragment.app.Fragment r2 = r11.mTarget
            java.lang.String r2 = r2.mWho
            r11.mTargetWho = r2
            r11.mTarget = r3
            goto L_0x009e
        L_0x0081:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            r0.append(r11)
            r0.append(r7)
            androidx.fragment.app.Fragment r11 = r11.mTarget
            r0.append(r11)
            r0.append(r6)
            java.lang.String r11 = r0.toString()
            r12.<init>(r11)
            throw r12
        L_0x009e:
            java.lang.String r2 = r11.mTargetWho
            if (r2 == 0) goto L_0x00cf
            java.lang.String r2 = r11.mTargetWho
            androidx.fragment.app.Fragment r2 = r10.e((java.lang.String) r2)
            if (r2 == 0) goto L_0x00b2
            int r3 = r2.mState
            if (r3 > 0) goto L_0x00cf
            r10.a((androidx.fragment.app.Fragment) r2, (int) r1)
            goto L_0x00cf
        L_0x00b2:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            r0.append(r11)
            r0.append(r7)
            java.lang.String r11 = r11.mTargetWho
            r0.append(r11)
            r0.append(r6)
            java.lang.String r11 = r0.toString()
            r12.<init>(r11)
            throw r12
        L_0x00cf:
            androidx.fragment.app.g<?> r2 = r10.k
            androidx.fragment.app.Fragment r3 = r10.m
            r0.a(r2, r10, r3)
        L_0x00d6:
            if (r12 <= 0) goto L_0x00db
            r0.c()
        L_0x00db:
            if (r12 < 0) goto L_0x00e0
            r0.b()
        L_0x00e0:
            if (r12 <= r1) goto L_0x00ed
            androidx.fragment.app.d r1 = r10.l
            r0.a((androidx.fragment.app.d) r1)
            r0.d()
            r0.e()
        L_0x00ed:
            if (r12 <= r4) goto L_0x00f2
            r0.f()
        L_0x00f2:
            if (r12 <= r5) goto L_0x01e9
            r0.g()
            goto L_0x01e9
        L_0x00f9:
            int r2 = r11.mState
            if (r2 <= r12) goto L_0x01e9
            int r2 = r11.mState
            if (r2 == 0) goto L_0x01e2
            r6 = 0
            if (r2 == r1) goto L_0x019e
            if (r2 == r4) goto L_0x0117
            if (r2 == r5) goto L_0x0112
            r7 = 4
            if (r2 == r7) goto L_0x010d
            goto L_0x01e9
        L_0x010d:
            if (r12 >= r7) goto L_0x0112
            r0.h()
        L_0x0112:
            if (r12 >= r5) goto L_0x0117
            r0.i()
        L_0x0117:
            if (r12 >= r4) goto L_0x019e
            boolean r2 = a((int) r5)
            if (r2 == 0) goto L_0x0129
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "movefrom ACTIVITY_CREATED: "
            r2.<init>(r4)
            r2.append(r11)
        L_0x0129:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x013c
            androidx.fragment.app.g<?> r2 = r10.k
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x013c
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x013c
            r0.l()
        L_0x013c:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x018f
            android.view.ViewGroup r2 = r11.mContainer
            if (r2 == 0) goto L_0x018f
            android.view.ViewGroup r2 = r11.mContainer
            android.view.View r4 = r11.mView
            r2.endViewTransition(r4)
            android.view.View r2 = r11.mView
            r2.clearAnimation()
            boolean r2 = r11.isRemovingParent()
            if (r2 != 0) goto L_0x018f
            int r2 = r10.j
            r4 = 0
            if (r2 < 0) goto L_0x0177
            boolean r2 = r10.o
            if (r2 != 0) goto L_0x0177
            android.view.View r2 = r11.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0177
            float r2 = r11.mPostponedAlpha
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0177
            androidx.fragment.app.g<?> r2 = r10.k
            android.content.Context r2 = r2.f3416c
            androidx.fragment.app.d r3 = r10.l
            androidx.fragment.app.c$a r3 = androidx.fragment.app.c.a(r2, r3, r11, r6)
        L_0x0177:
            r11.mPostponedAlpha = r4
            android.view.ViewGroup r2 = r11.mContainer
            android.view.View r4 = r11.mView
            if (r3 == 0) goto L_0x0187
            r11.setStateAfterAnimating(r12)
            androidx.fragment.app.r$a r7 = r10.u
            androidx.fragment.app.c.a(r11, r3, r7)
        L_0x0187:
            r2.removeView(r4)
            android.view.ViewGroup r3 = r11.mContainer
            if (r2 == r3) goto L_0x018f
            return
        L_0x018f:
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.d.b>> r2 = r10.f3431h
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x019b
            r10.f(r11)
            goto L_0x019e
        L_0x019b:
            r11.setStateAfterAnimating(r12)
        L_0x019e:
            if (r12 > 0) goto L_0x01e2
            boolean r2 = r11.mRemoving
            if (r2 == 0) goto L_0x01ab
            boolean r2 = r11.isInBackStack()
            if (r2 != 0) goto L_0x01ab
            r6 = 1
        L_0x01ab:
            if (r6 != 0) goto L_0x01cb
            androidx.fragment.app.l r2 = r10.p
            boolean r2 = r2.b(r11)
            if (r2 == 0) goto L_0x01b6
            goto L_0x01cb
        L_0x01b6:
            java.lang.String r2 = r11.mTargetWho
            if (r2 == 0) goto L_0x01ce
            java.lang.String r2 = r11.mTargetWho
            androidx.fragment.app.Fragment r2 = r10.e((java.lang.String) r2)
            if (r2 == 0) goto L_0x01ce
            boolean r3 = r2.getRetainInstance()
            if (r3 == 0) goto L_0x01ce
            r11.mTarget = r2
            goto L_0x01ce
        L_0x01cb:
            r10.a((androidx.fragment.app.n) r0)
        L_0x01ce:
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.d.b>> r2 = r10.f3431h
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x01db
            r11.setStateAfterAnimating(r12)
            r12 = 1
            goto L_0x01e2
        L_0x01db:
            androidx.fragment.app.g<?> r1 = r10.k
            androidx.fragment.app.l r2 = r10.p
            r0.a(r1, r2)
        L_0x01e2:
            if (r12 >= 0) goto L_0x01e9
            androidx.fragment.app.l r1 = r10.p
            r0.a((androidx.fragment.app.l) r1)
        L_0x01e9:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0211
            boolean r0 = a((int) r5)
            if (r0 == 0) goto L_0x020f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
        L_0x020f:
            r11.mState = r12
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.a(androidx.fragment.app.Fragment, int):void");
    }

    private void s(Fragment fragment) {
        HashSet hashSet = this.f3431h.get(fragment);
        if (hashSet != null) {
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((androidx.core.d.b) it2.next()).b();
            }
            hashSet.clear();
            f(fragment);
            this.f3431h.remove(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment, boolean z2) {
        ViewGroup v2 = v(fragment);
        if (v2 != null && (v2 instanceof FragmentContainerView)) {
            ((FragmentContainerView) v2).setDrawDisappearingViewsLast(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(Fragment fragment) {
        fragment.performDestroyView();
        this.f3432i.e(fragment);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public final void g(Fragment fragment) {
        a(fragment, this.j);
    }

    private void t(final Fragment fragment) {
        if (fragment.mView != null) {
            c.a a2 = c.a(this.k.f3416c, this.l, fragment, !fragment.mHidden);
            if (a2 == null || a2.f3406b == null) {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.f3405a);
                    a2.f3405a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                a2.f3406b.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a2.f3406b.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null && fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                a2.f3406b.start();
            }
        }
        if (fragment.mAdded && w(fragment)) {
            this.x = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        r0 = r0.mView;
        r1 = r4.mContainer;
        r0 = r1.indexOfChild(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(androidx.fragment.app.Fragment r4) {
        /*
            r3 = this;
            androidx.fragment.app.p r0 = r3.f3424a
            java.lang.String r1 = r4.mWho
            boolean r0 = r0.b((java.lang.String) r1)
            if (r0 != 0) goto L_0x002f
            r0 = 3
            boolean r0 = a((int) r0)
            if (r0 == 0) goto L_0x002e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Ignoring moving "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = " to state "
            r0.append(r4)
            int r4 = r3.j
            r0.append(r4)
            java.lang.String r4 = "since it is not added to "
            r0.append(r4)
            r0.append(r3)
        L_0x002e:
            return
        L_0x002f:
            r3.g(r4)
            android.view.View r0 = r4.mView
            if (r0 == 0) goto L_0x0096
            androidx.fragment.app.p r0 = r3.f3424a
            androidx.fragment.app.Fragment r0 = r0.c((androidx.fragment.app.Fragment) r4)
            if (r0 == 0) goto L_0x0056
            android.view.View r0 = r0.mView
            android.view.ViewGroup r1 = r4.mContainer
            int r0 = r1.indexOfChild(r0)
            android.view.View r2 = r4.mView
            int r2 = r1.indexOfChild(r2)
            if (r2 >= r0) goto L_0x0056
            r1.removeViewAt(r2)
            android.view.View r2 = r4.mView
            r1.addView(r2, r0)
        L_0x0056:
            boolean r0 = r4.mIsNewlyAdded
            if (r0 == 0) goto L_0x0096
            android.view.ViewGroup r0 = r4.mContainer
            if (r0 == 0) goto L_0x0096
            float r0 = r4.mPostponedAlpha
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            android.view.View r0 = r4.mView
            float r2 = r4.mPostponedAlpha
            r0.setAlpha(r2)
        L_0x006c:
            r4.mPostponedAlpha = r1
            r0 = 0
            r4.mIsNewlyAdded = r0
            androidx.fragment.app.g<?> r0 = r3.k
            android.content.Context r0 = r0.f3416c
            androidx.fragment.app.d r1 = r3.l
            r2 = 1
            androidx.fragment.app.c$a r0 = androidx.fragment.app.c.a(r0, r1, r4, r2)
            if (r0 == 0) goto L_0x0096
            android.view.animation.Animation r1 = r0.f3405a
            if (r1 == 0) goto L_0x008a
            android.view.View r1 = r4.mView
            android.view.animation.Animation r0 = r0.f3405a
            r1.startAnimation(r0)
            goto L_0x0096
        L_0x008a:
            android.animation.Animator r1 = r0.f3406b
            android.view.View r2 = r4.mView
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f3406b
            r0.start()
        L_0x0096:
            boolean r0 = r4.mHiddenChanged
            if (r0 == 0) goto L_0x009d
            r3.t(r4)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.h(androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z2) {
        g<?> gVar;
        if (this.k == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.j) {
            this.j = i2;
            for (Fragment h2 : this.f3424a.d()) {
                h(h2);
            }
            for (Fragment next : this.f3424a.e()) {
                if (next != null && !next.mIsNewlyAdded) {
                    h(next);
                }
            }
            v();
            if (this.x && (gVar = this.k) != null && this.j == 4) {
                gVar.d();
                this.x = false;
            }
        }
    }

    private void v() {
        for (Fragment next : this.f3424a.e()) {
            if (next != null) {
                e(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(Fragment fragment) {
        if (!this.f3424a.b(fragment.mWho)) {
            n nVar = new n(this.f3432i, fragment);
            nVar.a(this.k.f3416c.getClassLoader());
            this.f3424a.a(nVar);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    b(fragment);
                } else {
                    c(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            nVar.f3456b = this.j;
            if (a(2)) {
                new StringBuilder("Added fragment to active set ").append(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(Fragment fragment) {
        if (a(2)) {
            new StringBuilder("add: ").append(fragment);
        }
        i(fragment);
        if (!fragment.mDetached) {
            this.f3424a.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (w(fragment)) {
                this.x = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(Fragment fragment) {
        if (a(2)) {
            StringBuilder sb = new StringBuilder("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f3424a.b(fragment);
            if (w(fragment)) {
                this.x = true;
            }
            fragment.mRemoving = true;
            u(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public final void l(Fragment fragment) {
        if (a(2)) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            u(fragment);
        }
    }

    static void m(Fragment fragment) {
        if (a(2)) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    public final void n(Fragment fragment) {
        if (a(2)) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (a(2)) {
                    new StringBuilder("remove from detach: ").append(fragment);
                }
                this.f3424a.b(fragment);
                if (w(fragment)) {
                    this.x = true;
                }
                u(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void o(Fragment fragment) {
        if (a(2)) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f3424a.a(fragment);
                if (a(2)) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                if (w(fragment)) {
                    this.x = true;
                }
            }
        }
    }

    public final Fragment c(int i2) {
        return this.f3424a.b(i2);
    }

    public final Fragment c(String str) {
        return this.f3424a.a(str);
    }

    /* access modifiers changed from: package-private */
    public final Fragment d(String str) {
        return this.f3424a.d(str);
    }

    /* access modifiers changed from: package-private */
    public final Fragment e(String str) {
        return this.f3424a.e(str);
    }

    private void w() {
        if (i()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean i() {
        return this.y || this.z;
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar, boolean z2) {
        if (!z2) {
            if (this.k != null) {
                w();
            } else if (this.o) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.r) {
            if (this.k != null) {
                this.r.add(dVar);
                j();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        synchronized (this.r) {
            boolean z2 = false;
            boolean z3 = this.E != null && !this.E.isEmpty();
            if (this.r.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.k.f3417d.removeCallbacks(this.F);
                this.k.f3417d.post(this.F);
                c();
            }
        }
    }

    private void d(boolean z2) {
        if (this.s) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.k == null) {
            if (this.o) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.k.f3417d.getLooper()) {
            if (!z2) {
                w();
            }
            if (this.B == null) {
                this.B = new ArrayList<>();
                this.C = new ArrayList<>();
            }
            this.s = true;
            try {
                a((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.s = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(d dVar, boolean z2) {
        if (!z2 || (this.k != null && !this.o)) {
            d(z2);
            if (dVar.a(this.B, this.C)) {
                this.s = true;
                try {
                    b(this.B, this.C);
                } finally {
                    x();
                }
            }
            c();
            A();
            this.f3424a.a();
        }
    }

    private void x() {
        this.s = false;
        this.C.clear();
        this.B.clear();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final boolean a(boolean z2) {
        d(z2);
        boolean z3 = false;
        while (c(this.B, this.C)) {
            this.s = true;
            try {
                b(this.B, this.C);
                x();
                z3 = true;
            } catch (Throwable th) {
                x();
                throw th;
            }
        }
        c();
        A();
        this.f3424a.a();
        return z3;
    }

    private void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<f> arrayList3 = this.E;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            f fVar = this.E.get(i2);
            if (arrayList == null || fVar.f3445a || (indexOf2 = arrayList.indexOf(fVar.f3446b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((fVar.f3447c == 0) || (arrayList != null && fVar.f3446b.a(arrayList, 0, arrayList.size()))) {
                    this.E.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || fVar.f3445a || (indexOf = arrayList.indexOf(fVar.f3446b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        fVar.c();
                    } else {
                        fVar.d();
                    }
                }
            } else {
                this.E.remove(i2);
                i2--;
                size--;
                fVar.d();
            }
            i2++;
        }
    }

    private void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                a(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).s) {
                        if (i3 != i2) {
                            a(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).s) {
                                i3++;
                            }
                        }
                        a(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    a(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = arrayList3.get(i5).s;
        ArrayList<Fragment> arrayList5 = this.D;
        if (arrayList5 == null) {
            this.D = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.D.addAll(this.f3424a.d());
        Fragment fragment = this.n;
        boolean z3 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            a aVar = arrayList3.get(i7);
            if (!arrayList4.get(i7).booleanValue()) {
                fragment = aVar.a(this.D, fragment);
            } else {
                fragment = aVar.b(this.D, fragment);
            }
            z3 = z3 || aVar.j;
        }
        this.D.clear();
        if (!z2) {
            r.a(this, arrayList, arrayList2, i2, i3, false, this.u);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z2) {
            androidx.a.b bVar = new androidx.a.b();
            b((androidx.a.b<Fragment>) bVar);
            int a2 = a(arrayList, arrayList2, i2, i3, (androidx.a.b<Fragment>) bVar);
            a((androidx.a.b<Fragment>) bVar);
            i4 = a2;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z2) {
            r.a(this, arrayList, arrayList2, i2, i4, true, this.u);
            a(this.j, true);
        }
        while (i5 < i6) {
            a aVar2 = arrayList3.get(i5);
            if (arrayList4.get(i5).booleanValue() && aVar2.f3390c >= 0) {
                aVar2.f3390c = -1;
            }
            aVar2.a();
            i5++;
        }
        if (z3) {
            B();
        }
    }

    private static void a(androidx.a.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) bVar.f927a[i2];
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, androidx.a.b<Fragment> bVar) {
        boolean z2;
        boolean z3;
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            int i6 = 0;
            while (true) {
                z2 = true;
                if (i6 >= aVar.f3463d.size()) {
                    z3 = false;
                    break;
                } else if (a.a((q.a) aVar.f3463d.get(i6))) {
                    z3 = true;
                    break;
                } else {
                    i6++;
                }
            }
            if (!z3 || aVar.a(arrayList, i5 + 1, i3)) {
                z2 = false;
            }
            if (z2) {
                if (this.E == null) {
                    this.E = new ArrayList<>();
                }
                f fVar = new f(aVar, booleanValue);
                this.E.add(fVar);
                aVar.a((Fragment.c) fVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.a(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                b(bVar);
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.a(z4);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            r.a(this, arrayList, arrayList2, 0, 1, true, this.u);
        }
        if (z4) {
            a(this.j, true);
        }
        for (Fragment next : this.f3424a.e()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.b(next.mContainerId)) {
                if (next.mPostponedAlpha > 0.0f) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z4) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    private static void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.a(z2);
            } else {
                aVar.a(1);
                aVar.f();
            }
            i2++;
        }
    }

    private void u(Fragment fragment) {
        ViewGroup v2 = v(fragment);
        if (v2 != null) {
            if (v2.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                v2.setTag(R.id.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) v2.getTag(R.id.visible_removing_fragment_view_tag)).setNextAnim(fragment.getNextAnim());
        }
    }

    private ViewGroup v(Fragment fragment) {
        if (fragment.mContainerId > 0 && this.l.a()) {
            View a2 = this.l.a(fragment.mContainerId);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    private void b(androidx.a.b<Fragment> bVar) {
        int i2 = this.j;
        if (i2 > 0) {
            int min = Math.min(i2, 3);
            for (Fragment next : this.f3424a.d()) {
                if (next.mState < min) {
                    a(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        bVar.add(next);
                    }
                }
            }
        }
    }

    private void y() {
        if (this.E != null) {
            while (!this.E.isEmpty()) {
                this.E.remove(0).c();
            }
        }
    }

    private void z() {
        if (!this.f3431h.isEmpty()) {
            for (Fragment next : this.f3431h.keySet()) {
                s(next);
                a(next, next.getStateAfterAnimating());
            }
        }
    }

    private boolean c(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.r) {
            if (this.r.isEmpty()) {
                return false;
            }
            int size = this.r.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                z2 |= this.r.get(i2).a(arrayList, arrayList2);
            }
            this.r.clear();
            this.k.f3417d.removeCallbacks(this.F);
            return z2;
        }
    }

    private void A() {
        if (this.A) {
            this.A = false;
            v();
        }
    }

    private void B() {
        if (this.f3430g != null) {
            for (int i2 = 0; i2 < this.f3430g.size(); i2++) {
                this.f3430g.get(i2).a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = this.f3425b;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f3425b.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.f3425b.size() - 1;
                while (i4 >= 0) {
                    a aVar = this.f3425b.get(i4);
                    if ((str != null && str.equals(aVar.l)) || (i2 >= 0 && i2 == aVar.f3390c)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        a aVar2 = this.f3425b.get(i4);
                        if ((str == null || !str.equals(aVar2.l)) && (i2 < 0 || i2 != aVar2.f3390c)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.f3425b.size() - 1) {
                return false;
            }
            for (int size2 = this.f3425b.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.f3425b.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Parcelable k() {
        int size;
        y();
        z();
        a(true);
        this.y = true;
        ArrayList<FragmentState> b2 = this.f3424a.b();
        BackStackState[] backStackStateArr = null;
        if (b2.isEmpty()) {
            a(2);
            return null;
        }
        ArrayList<String> c2 = this.f3424a.c();
        ArrayList<a> arrayList = this.f3425b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f3425b.get(i2));
                if (a(2)) {
                    StringBuilder sb = new StringBuilder("saveAllState: adding back stack #");
                    sb.append(i2);
                    sb.append(": ");
                    sb.append(this.f3425b.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f3361a = b2;
        fragmentManagerState.f3362b = c2;
        fragmentManagerState.f3363c = backStackStateArr;
        fragmentManagerState.f3364d = this.f3429f.get();
        Fragment fragment = this.n;
        if (fragment != null) {
            fragmentManagerState.f3365e = fragment.mWho;
        }
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public final void a(Parcelable parcelable) {
        n nVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f3361a != null) {
                this.f3424a.f3459a.clear();
                Iterator<FragmentState> it2 = fragmentManagerState.f3361a.iterator();
                while (it2.hasNext()) {
                    FragmentState next = it2.next();
                    if (next != null) {
                        Fragment a2 = this.p.a(next.f3367b);
                        if (a2 != null) {
                            if (a(2)) {
                                new StringBuilder("restoreSaveState: re-attaching retained ").append(a2);
                            }
                            nVar = new n(this.f3432i, a2, next);
                        } else {
                            nVar = new n(this.f3432i, this.k.f3416c.getClassLoader(), u(), next);
                        }
                        Fragment fragment = nVar.f3455a;
                        fragment.mFragmentManager = this;
                        if (a(2)) {
                            StringBuilder sb = new StringBuilder("restoreSaveState: active (");
                            sb.append(fragment.mWho);
                            sb.append("): ");
                            sb.append(fragment);
                        }
                        nVar.a(this.k.f3416c.getClassLoader());
                        this.f3424a.a(nVar);
                        nVar.f3456b = this.j;
                    }
                }
                for (Fragment next2 : this.p.f3449a.values()) {
                    if (!this.f3424a.b(next2.mWho)) {
                        if (a(2)) {
                            StringBuilder sb2 = new StringBuilder("Discarding retained Fragment ");
                            sb2.append(next2);
                            sb2.append(" that was not found in the set of active Fragments ");
                            sb2.append(fragmentManagerState.f3361a);
                        }
                        a(next2, 1);
                        next2.mRemoving = true;
                        a(next2, -1);
                    }
                }
                this.f3424a.a((List<String>) fragmentManagerState.f3362b);
                if (fragmentManagerState.f3363c != null) {
                    this.f3425b = new ArrayList<>(fragmentManagerState.f3363c.length);
                    for (int i2 = 0; i2 < fragmentManagerState.f3363c.length; i2++) {
                        a a3 = fragmentManagerState.f3363c[i2].a(this);
                        if (a(2)) {
                            StringBuilder sb3 = new StringBuilder("restoreAllState: back stack #");
                            sb3.append(i2);
                            sb3.append(" (index ");
                            sb3.append(a3.f3390c);
                            sb3.append("): ");
                            sb3.append(a3);
                            PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f3425b.add(a3);
                    }
                } else {
                    this.f3425b = null;
                }
                this.f3429f.set(fragmentManagerState.f3364d);
                if (fragmentManagerState.f3365e != null) {
                    this.n = e(fragmentManagerState.f3365e);
                    q(this.n);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.activity.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.fragment.app.g<?> r3, androidx.fragment.app.d r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.g<?> r0 = r2.k
            if (r0 != 0) goto L_0x004d
            r2.k = r3
            r2.l = r4
            r2.m = r5
            androidx.fragment.app.Fragment r4 = r2.m
            if (r4 == 0) goto L_0x0011
            r2.c()
        L_0x0011:
            boolean r4 = r3 instanceof androidx.activity.c
            if (r4 == 0) goto L_0x0028
            r4 = r3
            androidx.activity.c r4 = (androidx.activity.c) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f3427d = r0
            if (r5 == 0) goto L_0x0021
            r4 = r5
        L_0x0021:
            androidx.activity.OnBackPressedDispatcher r0 = r2.f3427d
            androidx.activity.b r1 = r2.f3428e
            r0.a(r4, r1)
        L_0x0028:
            if (r5 == 0) goto L_0x0033
            androidx.fragment.app.j r3 = r5.mFragmentManager
            androidx.fragment.app.l r3 = r3.r(r5)
            r2.p = r3
            return
        L_0x0033:
            boolean r4 = r3 instanceof androidx.lifecycle.ao
            if (r4 == 0) goto L_0x0044
            androidx.lifecycle.ao r3 = (androidx.lifecycle.ao) r3
            androidx.lifecycle.an r3 = r3.getViewModelStore()
            androidx.fragment.app.l r3 = androidx.fragment.app.l.a((androidx.lifecycle.an) r3)
            r2.p = r3
            return
        L_0x0044:
            androidx.fragment.app.l r3 = new androidx.fragment.app.l
            r4 = 0
            r3.<init>(r4)
            r2.p = r3
            return
        L_0x004d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.a(androidx.fragment.app.g, androidx.fragment.app.d, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        if (this.k != null) {
            this.y = false;
            this.z = false;
            for (Fragment next : this.f3424a.d()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void m() {
        this.y = false;
        this.z = false;
        d(1);
    }

    /* access modifiers changed from: package-private */
    public final void n() {
        this.y = false;
        this.z = false;
        d(2);
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        this.y = false;
        this.z = false;
        d(3);
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        this.y = false;
        this.z = false;
        d(4);
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        this.z = true;
        d(2);
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.o = true;
        a(true);
        z();
        d(-1);
        this.k = null;
        this.l = null;
        this.m = null;
        if (this.f3427d != null) {
            this.f3428e.a();
            this.f3427d = null;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void d(int i2) {
        try {
            this.s = true;
            this.f3424a.a(i2);
            a(i2, false);
            this.s = false;
            a(true);
        } catch (Throwable th) {
            this.s = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z2) {
        for (Fragment next : this.f3424a.d()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(boolean z2) {
        for (Fragment next : this.f3424a.d()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Configuration configuration) {
        for (Fragment next : this.f3424a.d()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        for (Fragment next : this.f3424a.d()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.j <= 0) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment next : this.f3424a.d()) {
            if (next != null && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z2 = true;
            }
        }
        if (this.t != null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                Fragment fragment = this.t.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.t = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Menu menu) {
        boolean z2 = false;
        if (this.j <= 0) {
            return false;
        }
        for (Fragment next : this.f3424a.d()) {
            if (next != null && next.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(MenuItem menuItem) {
        if (this.j <= 0) {
            return false;
        }
        for (Fragment next : this.f3424a.d()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(MenuItem menuItem) {
        if (this.j <= 0) {
            return false;
        }
        for (Fragment next : this.f3424a.d()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void b(Menu menu) {
        if (this.j > 0) {
            for (Fragment next : this.f3424a.d()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void p(Fragment fragment) {
        if (fragment == null || (fragment.equals(e(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.n;
            this.n = fragment;
            q(fragment2);
            q(this.n);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public final void q(Fragment fragment) {
        if (fragment != null && fragment.equals(e(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public final Fragment t() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment, k.b bVar) {
        if (!fragment.equals(e(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    public final f u() {
        j jVar = this;
        while (true) {
            f fVar = jVar.v;
            if (fVar != null) {
                return fVar;
            }
            Fragment fragment = jVar.m;
            if (fragment == null) {
                return jVar.w;
            }
            jVar = fragment.mFragmentManager;
        }
    }

    private boolean C() {
        boolean z2 = false;
        for (Fragment next : this.f3424a.e()) {
            if (next != null) {
                z2 = w(next);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    private static boolean w(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.C();
    }

    class e implements d {

        /* renamed from: a  reason: collision with root package name */
        final String f3441a;

        /* renamed from: b  reason: collision with root package name */
        final int f3442b;

        /* renamed from: c  reason: collision with root package name */
        final int f3443c;

        e(String str, int i2, int i3) {
            this.f3441a = str;
            this.f3442b = i2;
            this.f3443c = i3;
        }

        public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            if (j.this.n != null && this.f3442b < 0 && this.f3441a == null && j.this.n.getChildFragmentManager().a((String) null, 0)) {
                return false;
            }
            return j.this.a(arrayList, arrayList2, this.f3441a, this.f3442b, this.f3443c);
        }
    }

    static class f implements Fragment.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f3445a;

        /* renamed from: b  reason: collision with root package name */
        final a f3446b;

        /* renamed from: c  reason: collision with root package name */
        int f3447c;

        f(a aVar, boolean z) {
            this.f3445a = z;
            this.f3446b = aVar;
        }

        public final void a() {
            this.f3447c--;
            if (this.f3447c == 0) {
                this.f3446b.f3388a.j();
            }
        }

        public final void b() {
            this.f3447c++;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            boolean z = this.f3447c > 0;
            for (Fragment next : this.f3446b.f3388a.f3424a.d()) {
                next.setOnStartEnterTransitionListener((Fragment.c) null);
                if (z && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            this.f3446b.f3388a.a(this.f3446b, this.f3445a, !z, true);
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.f3446b.f3388a.a(this.f3446b, this.f3445a, false, false);
        }
    }

    private void a(n nVar) {
        Fragment fragment = nVar.f3455a;
        if (this.f3424a.b(fragment.mWho)) {
            if (a(2)) {
                new StringBuilder("Removed fragment from active set ").append(fragment);
            }
            this.f3424a.b(nVar);
            c(fragment);
        }
    }
}

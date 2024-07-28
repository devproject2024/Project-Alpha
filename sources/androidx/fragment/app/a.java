package androidx.fragment.app;

import androidx.core.g.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends q implements j.a, j.d {

    /* renamed from: a  reason: collision with root package name */
    final j f3388a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3389b;

    /* renamed from: c  reason: collision with root package name */
    int f3390c;

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3390c >= 0) {
            sb.append(" #");
            sb.append(this.f3390c);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append("}");
        return sb.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3390c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3389b);
            if (this.f3468i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3468i));
            }
            if (!(this.f3464e == 0 && this.f3465f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3464e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3465f));
            }
            if (!(this.f3466g == 0 && this.f3467h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3466g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3467h));
            }
            if (!(this.m == 0 && this.n == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (!this.f3463d.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f3463d.size();
            for (int i2 = 0; i2 < size; i2++) {
                q.a aVar = (q.a) this.f3463d.get(i2);
                switch (aVar.f3469a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f3469a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f3470b);
                if (z) {
                    if (!(aVar.f3471c == 0 && aVar.f3472d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3471c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3472d));
                    }
                    if (aVar.f3473e != 0 || aVar.f3474f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3473e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3474f));
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(j jVar) {
        super(jVar.u(), jVar.k != null ? jVar.k.f3416c.getClassLoader() : null);
        this.f3390c = -1;
        this.f3388a = jVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Fragment fragment, String str, int i3) {
        super.a(i2, fragment, str, i3);
        fragment.mFragmentManager = this.f3388a;
    }

    public final q a(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3388a) {
            return super.a(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final q b(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3388a) {
            return super.b(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final q c(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3388a) {
            return super.c(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final q d(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3388a) {
            return super.d(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final q e(Fragment fragment) {
        if (fragment == null || fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3388a) {
            return super.e(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final q a(Fragment fragment, k.b bVar) {
        if (fragment.mFragmentManager != this.f3388a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3388a);
        } else if (bVar.isAtLeast(k.b.CREATED)) {
            return super.a(fragment, bVar);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + k.b.CREATED);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.j) {
            if (j.a(2)) {
                StringBuilder sb = new StringBuilder("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i2);
            }
            int size = this.f3463d.size();
            for (int i3 = 0; i3 < size; i3++) {
                q.a aVar = (q.a) this.f3463d.get(i3);
                if (aVar.f3470b != null) {
                    aVar.f3470b.mBackStackNesting += i2;
                    if (j.a(2)) {
                        StringBuilder sb2 = new StringBuilder("Bump nesting of ");
                        sb2.append(aVar.f3470b);
                        sb2.append(" to ");
                        sb2.append(aVar.f3470b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void a() {
        if (this.t != null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                ((Runnable) this.t.get(i2)).run();
            }
            this.t = null;
        }
    }

    public final int b() {
        return b(false);
    }

    public final int c() {
        return b(true);
    }

    public final void d() {
        k();
        this.f3388a.b((j.d) this, false);
    }

    public final void e() {
        k();
        this.f3388a.b((j.d) this, true);
    }

    private int b(boolean z) {
        if (!this.f3389b) {
            if (j.a(2)) {
                new StringBuilder("Commit: ").append(this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.f3389b = true;
            if (this.j) {
                this.f3390c = this.f3388a.f3429f.getAndIncrement();
            } else {
                this.f3390c = -1;
            }
            this.f3388a.a((j.d) this, z);
            return this.f3390c;
        }
        throw new IllegalStateException("commit already called");
    }

    public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.a(2)) {
            new StringBuilder("Run: ").append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.j) {
            return true;
        }
        j jVar = this.f3388a;
        if (jVar.f3425b == null) {
            jVar.f3425b = new ArrayList<>();
        }
        jVar.f3425b.add(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2) {
        int size = this.f3463d.size();
        for (int i3 = 0; i3 < size; i3++) {
            q.a aVar = (q.a) this.f3463d.get(i3);
            int i4 = aVar.f3470b != null ? aVar.f3470b.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f3463d.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            q.a aVar = (q.a) this.f3463d.get(i5);
            int i6 = aVar.f3470b != null ? aVar.f3470b.mContainerId : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar2 = arrayList.get(i7);
                    int size2 = aVar2.f3463d.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        q.a aVar3 = (q.a) aVar2.f3463d.get(i8);
                        if ((aVar3.f3470b != null ? aVar3.f3470b.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        int size = this.f3463d.size();
        for (int i2 = 0; i2 < size; i2++) {
            q.a aVar = (q.a) this.f3463d.get(i2);
            Fragment fragment = aVar.f3470b;
            if (fragment != null) {
                fragment.setNextTransition(this.f3468i);
            }
            switch (aVar.f3469a) {
                case 1:
                    fragment.setNextAnim(aVar.f3471c);
                    this.f3388a.a(fragment, false);
                    this.f3388a.j(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f3472d);
                    this.f3388a.k(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f3472d);
                    this.f3388a.l(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f3471c);
                    this.f3388a.a(fragment, false);
                    j.m(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f3472d);
                    this.f3388a.n(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f3471c);
                    this.f3388a.a(fragment, false);
                    this.f3388a.o(fragment);
                    break;
                case 8:
                    this.f3388a.p(fragment);
                    break;
                case 9:
                    this.f3388a.p((Fragment) null);
                    break;
                case 10:
                    this.f3388a.a(fragment, aVar.f3476h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3469a);
            }
            if (!(this.s || aVar.f3469a == 1 || fragment == null)) {
                this.f3388a.h(fragment);
            }
        }
        if (!this.s) {
            j jVar = this.f3388a;
            jVar.a(jVar.j, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        for (int size = this.f3463d.size() - 1; size >= 0; size--) {
            q.a aVar = (q.a) this.f3463d.get(size);
            Fragment fragment = aVar.f3470b;
            if (fragment != null) {
                fragment.setNextTransition(j.e(this.f3468i));
            }
            switch (aVar.f3469a) {
                case 1:
                    fragment.setNextAnim(aVar.f3474f);
                    this.f3388a.a(fragment, true);
                    this.f3388a.k(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f3473e);
                    this.f3388a.j(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f3473e);
                    j.m(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f3474f);
                    this.f3388a.a(fragment, true);
                    this.f3388a.l(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f3473e);
                    this.f3388a.o(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f3474f);
                    this.f3388a.a(fragment, true);
                    this.f3388a.n(fragment);
                    break;
                case 8:
                    this.f3388a.p((Fragment) null);
                    break;
                case 9:
                    this.f3388a.p(fragment);
                    break;
                case 10:
                    this.f3388a.a(fragment, aVar.f3475g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3469a);
            }
            if (!(this.s || aVar.f3469a == 3 || fragment == null)) {
                this.f3388a.h(fragment);
            }
        }
        if (!this.s && z) {
            j jVar = this.f3388a;
            jVar.a(jVar.j, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i2;
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i3 = 0;
        while (i2 < this.f3463d.size()) {
            q.a aVar = (q.a) this.f3463d.get(i2);
            int i4 = aVar.f3469a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Fragment fragment3 = aVar.f3470b;
                    int i5 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i6 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList2.get(size);
                        if (fragment5.mContainerId == i5) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f3463d.add(i6, new q.a(9, fragment5));
                                    i6++;
                                    fragment4 = null;
                                }
                                q.a aVar2 = new q.a(3, fragment5);
                                aVar2.f3471c = aVar.f3471c;
                                aVar2.f3473e = aVar.f3473e;
                                aVar2.f3472d = aVar.f3472d;
                                aVar2.f3474f = aVar.f3474f;
                                this.f3463d.add(i6, aVar2);
                                arrayList2.remove(fragment5);
                                i6++;
                            }
                        }
                    }
                    if (z) {
                        this.f3463d.remove(i6);
                        i2 = i6 - 1;
                    } else {
                        aVar.f3469a = 1;
                        arrayList2.add(fragment3);
                        i2 = i6;
                    }
                    fragment2 = fragment4;
                } else if (i4 == 3 || i4 == 6) {
                    arrayList2.remove(aVar.f3470b);
                    if (aVar.f3470b == fragment2) {
                        this.f3463d.add(i2, new q.a(9, aVar.f3470b));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i4 != 7) {
                    if (i4 == 8) {
                        this.f3463d.add(i2, new q.a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f3470b;
                    }
                }
                i3 = i2 + 1;
            }
            arrayList2.add(aVar.f3470b);
            i3 = i2 + 1;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    public final Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3463d.size() - 1; size >= 0; size--) {
            q.a aVar = (q.a) this.f3463d.get(size);
            int i2 = aVar.f3469a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f3470b;
                            break;
                        case 10:
                            aVar.f3476h = aVar.f3475g;
                            break;
                    }
                }
                arrayList.add(aVar.f3470b);
            }
            arrayList.remove(aVar.f3470b);
        }
        return fragment;
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment.c cVar) {
        for (int i2 = 0; i2 < this.f3463d.size(); i2++) {
            q.a aVar = (q.a) this.f3463d.get(i2);
            if (a(aVar)) {
                aVar.f3470b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    static boolean a(q.a aVar) {
        Fragment fragment = aVar.f3470b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public final String g() {
        return this.l;
    }

    public final boolean h() {
        return this.f3463d.isEmpty();
    }
}

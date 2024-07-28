package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, n> f3459a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Fragment> f3460b = new ArrayList<>();

    p() {
    }

    /* access modifiers changed from: package-private */
    public final void a(List<String> list) {
        this.f3460b.clear();
        if (list != null) {
            for (String next : list) {
                Fragment e2 = e(next);
                if (e2 != null) {
                    if (j.a(2)) {
                        StringBuilder sb = new StringBuilder("restoreSaveState: added (");
                        sb.append(next);
                        sb.append("): ");
                        sb.append(e2);
                    }
                    a(e2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(n nVar) {
        this.f3459a.put(nVar.f3455a.mWho, nVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        if (!this.f3460b.contains(fragment)) {
            synchronized (this.f3460b) {
                this.f3460b.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        Iterator<Fragment> it2 = this.f3460b.iterator();
        while (it2.hasNext()) {
            n nVar = this.f3459a.get(it2.next().mWho);
            if (nVar != null) {
                nVar.f3456b = i2;
            }
        }
        for (n next : this.f3459a.values()) {
            if (next != null) {
                next.f3456b = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment) {
        synchronized (this.f3460b) {
            this.f3460b.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f3459a.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<FragmentState> b() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f3459a.size());
        for (n next : this.f3459a.values()) {
            if (next != null) {
                Fragment fragment = next.f3455a;
                FragmentState j = next.j();
                arrayList.add(j);
                if (j.a(2)) {
                    StringBuilder sb = new StringBuilder("Saved state of ");
                    sb.append(fragment);
                    sb.append(": ");
                    sb.append(j.m);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<String> c() {
        synchronized (this.f3460b) {
            if (this.f3460b.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3460b.size());
            Iterator<Fragment> it2 = this.f3460b.iterator();
            while (it2.hasNext()) {
                Fragment next = it2.next();
                arrayList.add(next.mWho);
                if (j.a(2)) {
                    StringBuilder sb = new StringBuilder("saveAllState: adding fragment (");
                    sb.append(next.mWho);
                    sb.append("): ");
                    sb.append(next);
                }
            }
            return arrayList;
        }
    }

    public final List<Fragment> d() {
        ArrayList arrayList;
        if (this.f3460b.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3460b) {
            arrayList = new ArrayList(this.f3460b);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<Fragment> e() {
        ArrayList arrayList = new ArrayList();
        for (n next : this.f3459a.values()) {
            if (next != null) {
                arrayList.add(next.f3455a);
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final Fragment b(int i2) {
        for (int size = this.f3460b.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3460b.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (n next : this.f3459a.values()) {
            if (next != null) {
                Fragment fragment2 = next.f3455a;
                if (fragment2.mFragmentId == i2) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Fragment a(String str) {
        if (str != null) {
            for (int size = this.f3460b.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3460b.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (n next : this.f3459a.values()) {
            if (next != null) {
                Fragment fragment2 = next.f3455a;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str) {
        return this.f3459a.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public final n c(String str) {
        return this.f3459a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Fragment d(String str) {
        Fragment findFragmentByWho;
        for (n next : this.f3459a.values()) {
            if (next != null && (findFragmentByWho = next.f3455a.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Fragment e(String str) {
        n nVar = this.f3459a.get(str);
        if (nVar != null) {
            return nVar.f3455a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Fragment c(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f3460b.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f3460b.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3459a.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (n next : this.f3459a.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment fragment = next.f3455a;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3460b.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f3460b.get(i2).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(n nVar) {
        Fragment fragment = nVar.f3455a;
        for (n next : this.f3459a.values()) {
            if (next != null) {
                Fragment fragment2 = next.f3455a;
                if (fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        this.f3459a.put(fragment.mWho, (Object) null);
        if (fragment.mTargetWho != null) {
            fragment.mTarget = e(fragment.mTargetWho);
        }
    }
}

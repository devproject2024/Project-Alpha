package androidx.fragment.app;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import java.util.HashMap;
import java.util.Iterator;

final class l extends ai {

    /* renamed from: f  reason: collision with root package name */
    private static final al.b f3448f = new al.b() {
        public final <T extends ai> T create(Class<T> cls) {
            return new l(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Fragment> f3449a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    final HashMap<String, l> f3450b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final HashMap<String, an> f3451c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    final boolean f3452d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3453e = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3454g = false;

    static l a(an anVar) {
        return (l) new al(anVar, f3448f).a(l.class);
    }

    l(boolean z) {
        this.f3452d = z;
    }

    public final void onCleared() {
        if (j.a(3)) {
            new StringBuilder("onCleared called for ").append(this);
        }
        this.f3453e = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Fragment fragment) {
        if (this.f3449a.containsKey(fragment.mWho)) {
            return false;
        }
        this.f3449a.put(fragment.mWho, fragment);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Fragment a(String str) {
        return this.f3449a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean b(Fragment fragment) {
        if (!this.f3449a.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f3452d) {
            return this.f3453e;
        }
        if (!this.f3454g) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean c(Fragment fragment) {
        return this.f3449a.remove(fragment.mWho) != null;
    }

    /* access modifiers changed from: package-private */
    public final void d(Fragment fragment) {
        if (j.a(3)) {
            new StringBuilder("Clearing non-config state for ").append(fragment);
        }
        l lVar = this.f3450b.get(fragment.mWho);
        if (lVar != null) {
            lVar.onCleared();
            this.f3450b.remove(fragment.mWho);
        }
        an anVar = this.f3451c.get(fragment.mWho);
        if (anVar != null) {
            anVar.b();
            this.f3451c.remove(fragment.mWho);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            l lVar = (l) obj;
            return this.f3449a.equals(lVar.f3449a) && this.f3450b.equals(lVar.f3450b) && this.f3451c.equals(lVar.f3451c);
        }
    }

    public final int hashCode() {
        return (((this.f3449a.hashCode() * 31) + this.f3450b.hashCode()) * 31) + this.f3451c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it2 = this.f3449a.values().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it3 = this.f3450b.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it4 = this.f3451c.keySet().iterator();
        while (it4.hasNext()) {
            sb.append(it4.next());
            if (it4.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}

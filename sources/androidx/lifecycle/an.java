package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class an {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, ai> f3647a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, ai aiVar) {
        ai put = this.f3647a.put(str, aiVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* access modifiers changed from: package-private */
    public final ai a(String str) {
        return this.f3647a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Set<String> a() {
        return new HashSet(this.f3647a.keySet());
    }

    public final void b() {
        for (ai clear : this.f3647a.values()) {
            clear.clear();
        }
        this.f3647a.clear();
    }
}

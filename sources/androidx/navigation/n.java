package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.Iterator;

@s.b(a = "navigation")
public final class n extends s<m> {

    /* renamed from: b  reason: collision with root package name */
    private final t f3935b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayDeque<Integer> f3936c = new ArrayDeque<>();

    public final /* synthetic */ k a(k kVar, Bundle bundle, p pVar, s.a aVar) {
        m mVar = (m) kVar;
        int i2 = mVar.f3930b;
        if (i2 != 0) {
            k a2 = mVar.a(i2, false);
            if (a2 == null) {
                if (mVar.f3931i == null) {
                    mVar.f3931i = Integer.toString(mVar.f3930b);
                }
                String str = mVar.f3931i;
                throw new IllegalArgumentException("navigation destination " + str + " is not a direct child of this NavGraph");
            }
            if (pVar == null || !pVar.f3940a || !a(mVar)) {
                this.f3936c.add(Integer.valueOf(mVar.f3921e));
            }
            return this.f3935b.a(a2.f3919c).a(a2, a2.a(bundle), pVar, aVar);
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + mVar.c());
    }

    public n(t tVar) {
        this.f3935b = tVar;
    }

    private boolean a(m mVar) {
        if (this.f3936c.isEmpty()) {
            return false;
        }
        int intValue = this.f3936c.peekLast().intValue();
        while (mVar.f3921e != intValue) {
            k a2 = mVar.a(mVar.f3930b, true);
            if (!(a2 instanceof m)) {
                return false;
            }
            mVar = (m) a2;
        }
        return true;
    }

    public final boolean a() {
        return this.f3936c.pollLast() != null;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f3936c.size()];
        Iterator<Integer> it2 = this.f3936c.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr[i2] = it2.next().intValue();
            i2++;
        }
        bundle.putIntArray("androidx-nav-graph:navigator:backStackIds", iArr);
        return bundle;
    }

    public final void a(Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray("androidx-nav-graph:navigator:backStackIds")) != null) {
            this.f3936c.clear();
            for (int valueOf : intArray) {
                this.f3936c.add(Integer.valueOf(valueOf));
            }
        }
    }

    public final /* synthetic */ k b() {
        return new m(this);
    }
}

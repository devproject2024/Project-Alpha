package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.travelpass.R;
import net.one97.travelpass.a;

public final class h extends g {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30241e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30242f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f30243g;

    /* renamed from: h  reason: collision with root package name */
    private long f30244h;

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        f30241e = bVar;
        bVar.a(0, new String[]{"tp_empty_screen_view"}, new int[]{2}, new int[]{R.layout.tp_empty_screen_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30242f = sparseIntArray;
        sparseIntArray.put(R.id.empty_image_view, 1);
        f30242f.put(R.id.recyclerView, 3);
        f30242f.put(R.id.progressbar, 4);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30241e, f30242f));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[4], objArr[3]);
        this.f30244h = -1;
        this.f30243g = objArr[0];
        this.f30243g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30244h = 2;
        }
        this.f30238b.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f30238b.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f30244h     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.travelpass.b.y r0 = r6.f30238b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.b.h.hasPendingBindings():boolean");
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f30238b.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f30028a) {
            return false;
        }
        synchronized (this) {
            this.f30244h |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30244h = 0;
        }
        executeBindingsOn(this.f30238b);
    }
}

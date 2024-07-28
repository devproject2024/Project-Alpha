package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.travelpass.R;
import net.one97.travelpass.a;

public final class f extends e {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f30234g;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f30235h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f30236i;
    private long j;

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(7);
        f30234g = bVar;
        bVar.a(0, new String[]{"tp_empty_screen_view"}, new int[]{3}, new int[]{R.layout.tp_empty_screen_view});
        f30234g.a(1, new String[]{"vh_travel_button"}, new int[]{2}, new int[]{R.layout.vh_travel_button});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30235h = sparseIntArray;
        sparseIntArray.put(R.id.recyclerView, 4);
        f30235h.put(R.id.progress_container, 5);
        f30235h.put(R.id.progressbar, 6);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f30234g, f30235h));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[5], objArr[6], objArr[4], objArr[2]);
        this.j = -1;
        this.f30228a.setTag((Object) null);
        this.f30236i = objArr[0];
        this.f30236i.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
        }
        this.f30233f.invalidateAll();
        this.f30229b.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f30229b.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f30233f.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.j     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            net.one97.travelpass.b.bc r0 = r6.f30233f
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.travelpass.b.y r0 = r6.f30229b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.b.f.hasPendingBindings():boolean");
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f30233f.setLifecycleOwner(qVar);
        this.f30229b.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f30028a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f30028a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
        executeBindingsOn(this.f30233f);
        executeBindingsOn(this.f30229b);
    }
}

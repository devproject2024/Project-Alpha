package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.travelpass.R;
import net.one97.travelpass.a;

public final class b extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30146e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30147f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f30148g;

    /* renamed from: h  reason: collision with root package name */
    private long f30149h;

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        f30146e = bVar;
        bVar.a(0, new String[]{"vh_travel_button", "tp_empty_screen_view"}, new int[]{1, 2}, new int[]{R.layout.vh_travel_button, R.layout.tp_empty_screen_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30147f = sparseIntArray;
        sparseIntArray.put(R.id.recyclerView, 3);
        f30147f.put(R.id.progressbar, 4);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30146e, f30147f));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[4], objArr[3]);
        this.f30149h = -1;
        this.f30148g = objArr[0];
        this.f30148g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30149h = 4;
        }
        this.f30059b.invalidateAll();
        this.f30058a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f30058a.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f30059b.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f30149h     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            net.one97.travelpass.b.bc r0 = r6.f30059b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.travelpass.b.y r0 = r6.f30058a
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.b.b.hasPendingBindings():boolean");
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f30059b.setLifecycleOwner(qVar);
        this.f30058a.setLifecycleOwner(qVar);
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
            this.f30149h |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f30028a) {
            return false;
        }
        synchronized (this) {
            this.f30149h |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30149h = 0;
        }
        executeBindingsOn(this.f30059b);
        executeBindingsOn(this.f30058a);
    }
}

package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.a;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public final class z extends y {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f60399b;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f60400c = null;

    /* renamed from: d  reason: collision with root package name */
    private final CardView f60401d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f60402e;

    /* renamed from: f  reason: collision with root package name */
    private final u f60403f;

    /* renamed from: g  reason: collision with root package name */
    private long f60404g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(3);
        f60399b = bVar;
        bVar.a(1, new String[]{"utility_automatic_list_item_header"}, new int[]{2}, new int[]{R.layout.utility_automatic_list_item_header});
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f60399b, f60400c));
    }

    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f60404g = -1;
        this.f60401d = objArr[0];
        this.f60401d.setTag((Object) null);
        this.f60402e = objArr[1];
        this.f60402e.setTag((Object) null);
        this.f60403f = objArr[2];
        setContainedBinding(this.f60403f);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60404g = 2;
        }
        this.f60403f.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f60403f.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f60404g     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.recharge.b.u r0 = r6.f60403f
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.b.z.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60180a != i2) {
            return false;
        }
        this.f60398a = (CJRAutomaticSubscriptionItemModel) obj;
        synchronized (this) {
            this.f60404g |= 1;
        }
        notifyPropertyChanged(a.f60180a);
        super.requestRebind();
        return true;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f60403f.setLifecycleOwner(qVar);
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f60404g;
            this.f60404g = 0;
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f60398a;
        if ((j & 3) != 0) {
            this.f60403f.a(cJRAutomaticSubscriptionItemModel);
        }
        executeBindingsOn(this.f60403f);
    }
}

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

public final class x extends w {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f60392c;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f60393d;

    /* renamed from: e  reason: collision with root package name */
    private final CardView f60394e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f60395f;

    /* renamed from: g  reason: collision with root package name */
    private final u f60396g;

    /* renamed from: h  reason: collision with root package name */
    private long f60397h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(4);
        f60392c = bVar;
        bVar.a(1, new String[]{"utility_automatic_list_item_header"}, new int[]{2}, new int[]{R.layout.utility_automatic_list_item_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f60393d = sparseIntArray;
        sparseIntArray.put(R.id.txt_last_bill_paid, 3);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f60392c, f60393d));
    }

    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3]);
        this.f60397h = -1;
        this.f60394e = objArr[0];
        this.f60394e.setTag((Object) null);
        this.f60395f = objArr[1];
        this.f60395f.setTag((Object) null);
        this.f60396g = objArr[2];
        setContainedBinding(this.f60396g);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60397h = 2;
        }
        this.f60396g.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f60396g.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f60397h     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.recharge.b.u r0 = r6.f60396g
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.b.x.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f60180a != i2) {
            return false;
        }
        this.f60391b = (CJRAutomaticSubscriptionItemModel) obj;
        synchronized (this) {
            this.f60397h |= 1;
        }
        notifyPropertyChanged(a.f60180a);
        super.requestRebind();
        return true;
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f60396g.setLifecycleOwner(qVar);
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f60397h;
            this.f60397h = 0;
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f60391b;
        if ((j & 3) != 0) {
            this.f60396g.a(cJRAutomaticSubscriptionItemModel);
        }
        executeBindingsOn(this.f60396g);
    }
}

package com.paytmmall.artifact.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.a;

public final class b extends a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final CoordinatorLayout l;
    private final RelativeLayout m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.toolBarClp, 4);
        k.put(R.id.slid_up, 5);
        k.put(R.id.bottomCartLayout, 6);
        k.put(R.id.page_background, 7);
        k.put(R.id.progressBar, 8);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, j, k));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[1], objArr[7], objArr[8], objArr[3], objArr[5], objArr[4]);
        this.n = -1;
        this.f15394b.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.m = objArr[2];
        this.m.setTag((Object) null);
        this.f15397e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f15392b == i2) {
            this.f15401i = (com.paytmmall.artifact.clp.b.a) obj;
        } else if (a.f15391a != i2) {
            return false;
        } else {
            a((com.paytmmall.artifact.clp.a.a) obj);
        }
        return true;
    }

    public final void a(com.paytmmall.artifact.clp.a.a aVar) {
        this.f15400h = aVar;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(a.f15391a);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.n;
            this.n = 0;
        }
        com.paytmmall.artifact.clp.a.a aVar = this.f15400h;
        if ((j2 & 6) != 0) {
            this.f15397e.setAdapter(aVar);
        }
    }
}

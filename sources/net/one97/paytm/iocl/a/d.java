package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.b.a.a;

public final class d extends c implements a.C0194a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f14098g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f14099h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f14100i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14099h = sparseIntArray;
        sparseIntArray.put(R.id.tv_first_row_text, 3);
        f14099h.put(R.id.image, 4);
        f14099h.put(R.id.tv_second_row_text, 5);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f14098g, f14099h));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[1], objArr[3], objArr[5]);
        this.l = -1;
        this.f14092a.setTag((Object) null);
        this.f14094c.setTag((Object) null);
        this.f14100i = objArr[0];
        this.f14100i.setTag((Object) null);
        setRootTag(view);
        this.j = new a(this, 2);
        this.k = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.iocl.a.f14079c != i2) {
            return false;
        }
        a((net.one97.paytm.transport.iocl_v1.c.e) obj);
        return true;
    }

    public final void a(net.one97.paytm.transport.iocl_v1.c.e eVar) {
        this.f14097f = eVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.iocl.a.f14079c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        if ((j2 & 2) != 0) {
            this.f14092a.setOnClickListener(this.j);
            this.f14094c.setOnClickListener(this.k);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            if (this.f14097f != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.transport.iocl_v1.c.e.b(view);
            }
        } else if (i2 == 2) {
            if (this.f14097f != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.transport.iocl_v1.c.e.a(view);
            }
        }
    }
}

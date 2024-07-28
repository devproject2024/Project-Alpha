package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class fr extends fq {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.iv_close, 2);
        k.put(R.id.tv_msg_one, 3);
        k.put(R.id.tv_msg_two, 4);
        k.put(R.id.tv_bootom_action_two, 5);
        k.put(R.id.tv_or, 6);
        k.put(R.id.tv_bottom_action_one, 7);
    }

    public fr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, j, k));
    }

    private fr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[5], objArr[7], objArr[3], objArr[4], objArr[6]);
        this.m = -1;
        this.f29746a.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.q == i2) {
            this.f29753h = (SRPHeaderViewModel) obj;
        } else if (a.J != i2) {
            return false;
        } else {
            this.f29754i = (String) obj;
            synchronized (this) {
                this.m |= 2;
            }
            notifyPropertyChanged(a.J);
            super.requestRebind();
        }
        return true;
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.f29753h = sRPHeaderViewModel;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        String str = this.f29754i;
        if ((j2 & 6) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29746a, str, (com.paytm.utility.b.b.e) null, (Integer) null);
        }
    }
}

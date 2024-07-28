package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class db extends da implements b.a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29442d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29443e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29444f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f29445g;

    /* renamed from: h  reason: collision with root package name */
    private long f29446h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29443e = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 2);
    }

    public db(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29442d, f29443e));
    }

    private db(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29446h = -1;
        this.f29439a.setTag((Object) null);
        this.f29444f = objArr[0];
        this.f29444f.setTag((Object) null);
        setRootTag(view);
        this.f29445g = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29446h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29446h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29441c = reviewViewModel;
        synchronized (this) {
            this.f29446h |= 1;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29446h;
            this.f29446h = 0;
        }
        if ((j & 2) != 0) {
            this.f29439a.setOnClickListener(this.f29445g);
        }
    }

    public final void a(int i2) {
        ReviewViewModel reviewViewModel = this.f29441c;
        if (reviewViewModel != null) {
            reviewViewModel.onBackPressed();
        }
    }
}

package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;

public final class bj extends bi implements a.C0556a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final LinearLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.publisher_container, 4);
        l.put(R.id.feed_banner_recyclerview, 5);
    }

    public bj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, k, l));
    }

    private bj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[5], objArr[4], objArr[2], objArr[3]);
        this.p = -1;
        this.f33948a.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.f33951d.setTag((Object) null);
        this.f33952e.setTag((Object) null);
        setRootTag(view);
        this.n = new a(this, 1);
        this.o = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.p = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.j = (net.one97.paytm.feed.ui.feed.a) obj;
            synchronized (this) {
                this.p |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.D == i2) {
            this.f33954g = (String) obj;
            synchronized (this) {
                this.p |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.D);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.m == i2) {
            this.f33955h = (String) obj;
            synchronized (this) {
                this.p |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.m);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33779f == i2) {
            this.f33953f = (String) obj;
            synchronized (this) {
                this.p |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33779f);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33956i = (Integer) obj;
            synchronized (this) {
                this.p |= 16;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p;
            this.p = 0;
        }
        String str = this.f33954g;
        String str2 = this.f33955h;
        String str3 = this.f33953f;
        int i2 = 0;
        int i3 = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean z = str3 == null;
            if (i3 != 0) {
                j |= z ? 128 : 64;
            }
            if (z) {
                i2 = 8;
            }
        }
        if ((40 & j) != 0) {
            d.a(this.f33948a, (CharSequence) str3);
            this.f33948a.setVisibility(i2);
        }
        if ((32 & j) != 0) {
            this.f33951d.setOnClickListener(this.n);
            this.f33952e.setOnClickListener(this.o);
        }
        if ((34 & j) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33951d, str, (String) null, (String) null);
        }
        if ((j & 36) != 0) {
            d.a(this.f33952e, (CharSequence) str2);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.feed.ui.feed.a aVar = this.j;
            Integer num = this.f33956i;
            if (aVar != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.a.a(getRoot().getContext(), num.intValue());
            }
        } else if (i2 == 2) {
            net.one97.paytm.feed.ui.feed.a aVar2 = this.j;
            Integer num2 = this.f33956i;
            if (aVar2 != null) {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.ui.feed.a.a(getRoot().getContext(), num2.intValue());
            }
        }
    }
}

package net.one97.paytm.feed.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.ui.feed.livetv.category.c;
import net.one97.paytm.feed.utility.b;

public final class cv extends cu implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34102f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34103g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f34104h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f34105i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34103g = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        f34103g.put(R.id.title, 4);
        f34103g.put(R.id.channels_recyclerview_container, 5);
    }

    public cv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f34102f, f34103g));
    }

    private cv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[2], objArr[4], objArr[3]);
        this.k = -1;
        this.f34098b.setTag((Object) null);
        this.f34104h = objArr[0];
        this.f34104h.setTag((Object) null);
        this.f34105i = objArr[1];
        this.f34105i.setTag((Object) null);
        setRootTag(view);
        this.j = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.z != i2) {
            return false;
        }
        c cVar = (c) obj;
        updateRegistration(0, (h) cVar);
        this.f34101e = cVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.feed.a.z);
        super.requestRebind();
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 == net.one97.paytm.feed.a.f33774a) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.k) {
            synchronized (this) {
                this.k |= 2;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.u) {
            return false;
        } else {
            synchronized (this) {
                this.k |= 4;
            }
            return true;
        }
    }

    public final void executeBindings() {
        long j2;
        boolean z;
        String str;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        c cVar = this.f34101e;
        Drawable drawable = null;
        int i2 = 0;
        if ((15 & j2) != 0) {
            z = ((j2 & 13) == 0 || cVar == null) ? false : cVar.f35124c;
            if ((j2 & 11) != 0) {
                if (cVar != null) {
                    i2 = cVar.f35125d;
                }
                drawable = b.b(getRoot().getContext(), i2);
                str = b.a(getRoot().getContext(), i2);
                i2 = b.a(i2);
            } else {
                str = null;
            }
        } else {
            str = null;
            z = false;
        }
        if ((13 & j2) != 0) {
            net.one97.paytm.feed.utility.a.a((View) this.f34098b, z);
        }
        if ((j2 & 11) != 0) {
            d.a(this.f34105i, drawable);
            d.a(this.f34105i, (CharSequence) str);
            this.f34105i.setVisibility(i2);
        }
        if ((j2 & 8) != 0) {
            this.f34105i.setOnClickListener(this.j);
        }
    }

    public final void a(int i2, View view) {
        c cVar = this.f34101e;
        if (cVar != null) {
            cVar.a(getRoot().getContext(), this.f34098b);
        }
    }
}

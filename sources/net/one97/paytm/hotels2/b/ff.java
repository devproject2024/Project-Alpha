package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class ff extends fe {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29705i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.divider, 3);
    }

    public ff(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29705i, j));
    }

    private ff(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2]);
        this.l = -1;
        this.f29698b.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.f29699c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 32;
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
        if (a.w == i2) {
            this.f29700d = (AutoSearchDataItem) obj;
        } else if (a.C == i2) {
            a((Boolean) obj);
        } else if (a.f29092g == i2) {
            b((String) obj);
        } else if (a.aj == i2) {
            a((String) obj);
        } else if (a.J != i2) {
            return false;
        } else {
            a((Drawable) obj);
        }
        return true;
    }

    public final void a(AutoSearchDataItem autoSearchDataItem) {
        this.f29700d = autoSearchDataItem;
    }

    public final void a(Boolean bool) {
        this.f29701e = bool;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(a.C);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29704h = str;
        synchronized (this) {
            this.l |= 4;
        }
        notifyPropertyChanged(a.f29092g);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29703g = str;
        synchronized (this) {
            this.l |= 8;
        }
        notifyPropertyChanged(a.aj);
        super.requestRebind();
    }

    public final void a(Drawable drawable) {
        this.f29702f = drawable;
        synchronized (this) {
            this.l |= 16;
        }
        notifyPropertyChanged(a.J);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        Boolean bool = this.f29701e;
        String str = this.f29704h;
        String str2 = this.f29703g;
        Drawable drawable = this.f29702f;
        int i2 = 0;
        int i3 = ((j2 & 34) > 0 ? 1 : ((j2 & 34) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 128 : 64;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((40 & j2) != 0) {
            d.a(this.f29698b, (CharSequence) str2);
        }
        if ((34 & j2) != 0) {
            this.f29698b.setVisibility(i2);
        }
        if ((48 & j2) != 0) {
            d.b(this.f29699c, drawable);
        }
        if ((j2 & 36) != 0) {
            d.a(this.f29699c, (CharSequence) str);
        }
    }
}

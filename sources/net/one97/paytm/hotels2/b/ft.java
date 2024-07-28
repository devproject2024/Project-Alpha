package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class ft extends fs {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29762h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29763i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29763i = sparseIntArray;
        sparseIntArray.put(R.id.divider1, 3);
    }

    public ft(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29762h, f29763i));
    }

    private ft(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[2]);
        this.k = -1;
        this.f29756b.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f29757c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 16;
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
        if (a.f29087b == i2) {
            a((String) obj);
        } else if (a.C == i2) {
            a((Boolean) obj);
        } else if (a.aj == i2) {
            b((String) obj);
        } else if (a.J != i2) {
            return false;
        } else {
            a((Drawable) obj);
        }
        return true;
    }

    public final void a(String str) {
        this.f29758d = str;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(a.f29087b);
        super.requestRebind();
    }

    public final void a(Boolean bool) {
        this.f29759e = bool;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(a.C);
        super.requestRebind();
    }

    public final void b(String str) {
        this.f29761g = str;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(a.aj);
        super.requestRebind();
    }

    public final void a(Drawable drawable) {
        this.f29760f = drawable;
        synchronized (this) {
            this.k |= 8;
        }
        notifyPropertyChanged(a.J);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        String str = this.f29758d;
        Boolean bool = this.f29759e;
        String str2 = this.f29761g;
        Drawable drawable = this.f29760f;
        int i2 = 0;
        int i3 = ((j2 & 18) > 0 ? 1 : ((j2 & 18) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 64 : 32;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((20 & j2) != 0) {
            d.a(this.f29756b, (CharSequence) str2);
        }
        if ((j2 & 18) != 0) {
            this.f29756b.setVisibility(i2);
        }
        if ((24 & j2) != 0) {
            d.b(this.f29757c, drawable);
        }
        if ((j2 & 17) != 0) {
            d.a(this.f29757c, (CharSequence) str);
        }
    }
}

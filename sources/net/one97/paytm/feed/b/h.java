package net.one97.paytm.feed.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.ui.feed.livetv.channel.b;

public final class h extends g implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34168f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34169g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f34170h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f34171i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34169g = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        f34169g.put(R.id.title, 4);
        f34169g.put(R.id.channels_recyclerview, 5);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f34168f, f34169g));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[2], objArr[4], objArr[3]);
        this.k = -1;
        this.f34164b.setTag((Object) null);
        this.f34170h = objArr[0];
        this.f34170h.setTag((Object) null);
        this.f34171i = objArr[1];
        this.f34171i.setTag((Object) null);
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
        b bVar = (b) obj;
        updateRegistration(0, (androidx.databinding.h) bVar);
        this.f34167e = bVar;
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
        b bVar = this.f34167e;
        Drawable drawable = null;
        int i2 = 0;
        if ((15 & j2) != 0) {
            if ((j2 & 13) == 0 || bVar == null) {
                z = false;
            } else {
                z = bVar.f35134d;
            }
            if ((j2 & 11) != 0) {
                if (bVar != null) {
                    i2 = bVar.f35135e;
                }
                drawable = net.one97.paytm.feed.utility.b.b(getRoot().getContext(), i2);
                str = net.one97.paytm.feed.utility.b.a(getRoot().getContext(), i2);
                i2 = net.one97.paytm.feed.utility.b.a(i2);
            } else {
                str = null;
            }
        } else {
            str = null;
            z = false;
        }
        if ((13 & j2) != 0) {
            net.one97.paytm.feed.utility.a.a((View) this.f34164b, z);
        }
        if ((j2 & 11) != 0) {
            this.f34171i.setVisibility(i2);
            d.a(this.f34171i, drawable);
            d.a(this.f34171i, (CharSequence) str);
        }
        if ((j2 & 8) != 0) {
            this.f34171i.setOnClickListener(this.j);
        }
    }

    public final void a(int i2, View view) {
        b bVar = this.f34167e;
        if (bVar != null) {
            bVar.a(getRoot().getContext(), bVar.f35132b, this.f34164b);
        }
    }
}

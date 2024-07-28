package net.one97.paytm.feed.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.ui.feed.h.b.d;
import net.one97.paytm.feed.ui.feed.h.b.g;

public final class av extends au implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f33894f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f33895g = null;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f33896h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f33897i;
    private long j;

    public av(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f33894f, f33895g));
    }

    private av(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.j = -1;
        this.f33896h = objArr[0];
        this.f33896h.setTag((Object) null);
        this.f33889a.setTag((Object) null);
        this.f33890b.setTag((Object) null);
        setRootTag(view);
        this.f33897i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.E == i2) {
            this.f33893e = (g) obj;
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33892d = (d) obj;
            synchronized (this) {
                this.j |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33891c = (Brand) obj;
            synchronized (this) {
                this.j |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.feed.a.f33774a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        Brand brand = this.f33891c;
        String str2 = null;
        int i2 = ((12 & j2) > 0 ? 1 : ((12 & j2) == 0 ? 0 : -1));
        if (i2 == 0 || brand == null) {
            str = null;
        } else {
            str2 = brand.getName();
            str = brand.getLogoUrl();
        }
        if ((j2 & 8) != 0) {
            this.f33896h.setOnClickListener(this.f33897i);
        }
        if (i2 != 0) {
            net.one97.paytm.feed.utility.a.d(this.f33889a, str);
            androidx.databinding.a.d.a(this.f33890b, (CharSequence) str2);
        }
    }

    public final void a(int i2, View view) {
        d dVar = this.f33892d;
        Brand brand = this.f33891c;
        if (dVar != null) {
            k.c(view, "view");
            k.c(brand, "data");
            b bVar = b.f34268c;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            b.a(context, brand.getDeepLink());
            net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_channels_click", "");
        }
    }
}

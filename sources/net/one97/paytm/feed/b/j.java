package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.livetv.Channel;

public final class j extends i implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34177f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34178g = null;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f34179h;

    /* renamed from: i  reason: collision with root package name */
    private long f34180i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34177f, f34178g));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[1], objArr[2]);
        this.f34180i = -1;
        this.f34172a.setTag((Object) null);
        this.f34173b.setTag((Object) null);
        this.f34174c.setTag((Object) null);
        setRootTag(view);
        this.f34179h = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34180i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34180i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34176e = (net.one97.paytm.feed.ui.feed.livetv.channel.a) obj;
            synchronized (this) {
                this.f34180i |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34175d = (Channel) obj;
            synchronized (this) {
                this.f34180i |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.f34180i;
            this.f34180i = 0;
        }
        Channel channel = this.f34175d;
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i2 == 0 || channel == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str2 = channel.getChannelThumbnailUrl();
            str = channel.getProgramImageUrl();
            str3 = channel.getId();
        }
        if ((j & 4) != 0) {
            this.f34172a.setOnClickListener(this.f34179h);
        }
        if (i2 != 0) {
            net.one97.paytm.feed.utility.a.a((View) this.f34173b, str3);
            net.one97.paytm.feed.utility.a.a(this.f34173b, str, (String) null, (String) null);
            net.one97.paytm.feed.utility.a.b((ImageView) this.f34174c, str2);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.livetv.channel.a aVar = this.f34176e;
        Channel channel = this.f34175d;
        if (aVar != null) {
            net.one97.paytm.feed.ui.feed.livetv.channel.a.a(view, channel);
        }
    }
}

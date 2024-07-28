package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.livetv.Channel;

public final class an extends am implements a.C0556a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f33859f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f33860g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f33861h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f33862i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33860g = sparseIntArray;
        sparseIntArray.put(R.id.channel_image_container, 3);
    }

    public an(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f33859f, f33860g));
    }

    private an(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.j = -1;
        this.f33854a.setTag((Object) null);
        this.f33856c.setTag((Object) null);
        this.f33861h = objArr[0];
        this.f33861h.setTag((Object) null);
        setRootTag(view);
        this.f33862i = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
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
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33858e = (net.one97.paytm.feed.ui.feed.livetv.channel.a) obj;
            synchronized (this) {
                this.j |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33857d = (Channel) obj;
            synchronized (this) {
                this.j |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        Channel channel = this.f33857d;
        int i2 = ((6 & j2) > 0 ? 1 : ((6 & j2) == 0 ? 0 : -1));
        if (i2 == 0 || channel == null) {
            str2 = null;
            str = null;
        } else {
            str = channel.getChannelName();
            str2 = channel.getChannelThumbnailUrl();
        }
        if (i2 != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33854a, str2, (String) null, (String) null);
            d.a(this.f33856c, (CharSequence) str);
        }
        if ((j2 & 4) != 0) {
            this.f33861h.setOnClickListener(this.f33862i);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.livetv.channel.a aVar = this.f33858e;
        Channel channel = this.f33857d;
        if (aVar != null) {
            net.one97.paytm.feed.ui.feed.livetv.channel.a.a(view, channel);
        }
    }
}

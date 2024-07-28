package net.one97.paytm.feed.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategory;
import net.one97.paytm.feed.ui.feed.livetv.channel.ChannelAcitivity;
import net.one97.paytm.feed.utility.b;

public final class al extends ak implements a.C0556a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f33851g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f33852h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f33853i;
    private final View.OnClickListener j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33852h = sparseIntArray;
        sparseIntArray.put(R.id.tv_channel_category_recyclerview, 4);
    }

    public al(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f33851g, f33852h));
    }

    private al(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[3], objArr[1]);
        this.k = -1;
        this.f33845a.setTag((Object) null);
        this.f33853i = objArr[0];
        this.f33853i.setTag((Object) null);
        this.f33847c.setTag((Object) null);
        this.f33848d.setTag((Object) null);
        setRootTag(view);
        this.j = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 4;
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
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33850f = (net.one97.paytm.feed.ui.feed.livetv.a) obj;
            synchronized (this) {
                this.k |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33849e = (ChannelCategory) obj;
            synchronized (this) {
                this.k |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        int i2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        ChannelCategory channelCategory = this.f33849e;
        String str2 = null;
        int i3 = ((6 & j2) > 0 ? 1 : ((6 & j2) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (channelCategory != null) {
                i2 = channelCategory.getChannelCount();
                str2 = channelCategory.getCategoryName();
            } else {
                i2 = 0;
            }
            str = this.f33847c.getResources().getString(R.string.feed_channel_count, new Object[]{Integer.valueOf(i2)});
        } else {
            str = null;
        }
        if ((j2 & 4) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33845a, b.a());
            this.f33845a.setOnClickListener(this.j);
        }
        if (i3 != 0) {
            d.a(this.f33847c, (CharSequence) str);
            d.a(this.f33848d, (CharSequence) str2);
        }
    }

    public final void a(int i2, View view) {
        net.one97.paytm.feed.ui.feed.livetv.a aVar = this.f33850f;
        ChannelCategory channelCategory = this.f33849e;
        boolean z = true;
        if (aVar != null) {
            if (channelCategory == null) {
                z = false;
            }
            if (z) {
                String categoryName = channelCategory.getCategoryName();
                String categoryId = channelCategory.getCategoryId();
                k.c(view, "view");
                k.c(categoryName, "categoryname");
                k.c(categoryId, "categoryID");
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                ChannelAcitivity.a aVar2 = ChannelAcitivity.f35127d;
                Context context = view.getContext();
                k.a((Object) context, "view.context");
                k.c(context, "context");
                k.c(categoryName, "categoryname");
                k.c(categoryId, "categoryID");
                Intent intent = new Intent(context, ChannelAcitivity.class);
                intent.putExtra("name", categoryName);
                intent.putExtra("id", categoryId);
                context.startActivity(intent);
            }
        }
    }
}

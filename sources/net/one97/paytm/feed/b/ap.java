package net.one97.paytm.feed.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.ui.feed.livetv.category.LiveTvCategoryAcitivity;
import net.one97.paytm.feed.utility.b;

public final class ap extends ao implements a.C0556a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f33867e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f33868f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f33869g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f33870h;

    /* renamed from: i  reason: collision with root package name */
    private long f33871i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33868f = sparseIntArray;
        sparseIntArray.put(R.id.feed_tv_header, 2);
        f33868f.put(R.id.feed_tv_recyclerview, 3);
    }

    public ap(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f33867e, f33868f));
    }

    private ap(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f33871i = -1;
        this.f33865c.setTag((Object) null);
        this.f33869g = objArr[0];
        this.f33869g.setTag((Object) null);
        setRootTag(view);
        this.f33870h = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33871i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33871i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b != i2) {
            return false;
        }
        this.f33866d = (net.one97.paytm.feed.ui.feed.livetv.a) obj;
        synchronized (this) {
            this.f33871i |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f33871i;
            this.f33871i = 0;
        }
        if ((j & 2) != 0) {
            net.one97.paytm.feed.utility.a.a(this.f33865c, b.a());
            this.f33865c.setOnClickListener(this.f33870h);
        }
    }

    public final void a(int i2, View view) {
        if (this.f33866d != null) {
            k.c(view, "view");
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            LiveTvCategoryAcitivity.a aVar = LiveTvCategoryAcitivity.f35111d;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            k.c(context, "context");
            context.startActivity(new Intent(context, LiveTvCategoryAcitivity.class));
            net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_livetv_click", "");
        }
    }
}

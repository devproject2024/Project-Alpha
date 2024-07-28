package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class bf extends be {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f33936g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f33937h;

    /* renamed from: i  reason: collision with root package name */
    private long f33938i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33937h = sparseIntArray;
        sparseIntArray.put(R.id.feed_provider_header, 1);
        f33937h.put(R.id.feed_provider_icon, 2);
        f33937h.put(R.id.provider_name, 3);
        f33937h.put(R.id.provider_follower_count, 4);
        f33937h.put(R.id.provider_follow, 5);
    }

    public bf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f33936g, f33937h));
    }

    private bf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[0], objArr[5], objArr[4], objArr[3]);
        this.f33938i = -1;
        this.f33932c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33938i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33938i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f33938i = 0;
        }
    }
}

package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class bh extends bg {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q;
    private long r;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.appbar, 1);
        q.put(R.id.collapsing, 2);
        q.put(R.id.feed_provider_header, 3);
        q.put(R.id.feed_provider_icon, 4);
        q.put(R.id.provider_data, 5);
        q.put(R.id.provider_name, 6);
        q.put(R.id.provider_follower_count, 7);
        q.put(R.id.provider_follow, 8);
        q.put(R.id.recyclerview, 9);
        q.put(R.id.toolbar, 10);
        q.put(R.id.toolbar_title, 11);
        q.put(R.id.provider_follow_toolbar, 12);
        q.put(R.id.feed_loading_progress, 13);
        q.put(R.id.back, 14);
    }

    public bh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, p, q));
    }

    private bh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[14], objArr[2], objArr[13], objArr[3], objArr[4], objArr[5], objArr[8], objArr[12], objArr[7], objArr[6], objArr[9], objArr[0], objArr[10], objArr[11]);
        this.r = -1;
        this.m.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.r = 0;
        }
    }
}

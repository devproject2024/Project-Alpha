package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.R;

public class SingleEmiDetailsBindingImpl extends SingleEmiDetailsBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rb_emi, 1);
        sViewsWithIds.put(R.id.txt_months, 2);
        sViewsWithIds.put(R.id.txt_emi, 3);
        sViewsWithIds.put(R.id.txt_percentage, 4);
        sViewsWithIds.put(R.id.txt_total, 5);
    }

    public SingleEmiDetailsBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private SingleEmiDetailsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1], objArr[0], objArr[3], objArr[2], objArr[4], objArr[5]);
        this.mDirtyFlags = -1;
        this.toplayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}

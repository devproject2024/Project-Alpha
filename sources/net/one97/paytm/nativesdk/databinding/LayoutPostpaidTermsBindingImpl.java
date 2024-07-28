package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.R;

public class LayoutPostpaidTermsBindingImpl extends LayoutPostpaidTermsBinding {
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
        sparseIntArray.put(R.id.tv_upi_help_title, 1);
        sViewsWithIds.put(R.id.cross_icon, 2);
        sViewsWithIds.put(R.id.wv_termsNCondition, 3);
        sViewsWithIds.put(R.id.pb_progress, 4);
    }

    public LayoutPostpaidTermsBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private LayoutPostpaidTermsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[4], objArr[0], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.rlMainView.setTag((Object) null);
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

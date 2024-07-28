package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.R;

public class UpiHelpLayoutMainBindingImpl extends UpiHelpLayoutMainBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

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
        sViewsWithIds.put(R.id.tv_info, 3);
        sViewsWithIds.put(R.id.tv_seeHow, 4);
        sViewsWithIds.put(R.id.btnProceed, 5);
    }

    public UpiHelpLayoutMainBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private UpiHelpLayoutMainBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[5], objArr[2], objArr[3], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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

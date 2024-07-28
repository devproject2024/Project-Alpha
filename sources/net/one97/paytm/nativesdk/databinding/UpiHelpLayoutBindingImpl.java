package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.R;

public class UpiHelpLayoutBindingImpl extends UpiHelpLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_whatIsUpi, 1);
        sViewsWithIds.put(R.id.iv_upi, 2);
        sViewsWithIds.put(R.id.tv_seeHowUpiWorks, 3);
        sViewsWithIds.put(R.id.btnProceed2, 4);
        sViewsWithIds.put(R.id.rl_contentView, 5);
        sViewsWithIds.put(R.id.tv_upi_help_title, 6);
        sViewsWithIds.put(R.id.cross_icon, 7);
        sViewsWithIds.put(R.id.vp_upi_help, 8);
        sViewsWithIds.put(R.id.tab_layout, 9);
        sViewsWithIds.put(R.id.btnProceed, 10);
    }

    public UpiHelpLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private UpiHelpLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[10], objArr[4], objArr[7], objArr[2], objArr[1], objArr[5], objArr[9], objArr[3], objArr[6], objArr[8]);
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

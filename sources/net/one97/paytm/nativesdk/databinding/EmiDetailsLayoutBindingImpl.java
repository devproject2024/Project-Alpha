package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.R;

public class EmiDetailsLayoutBindingImpl extends EmiDetailsLayoutBinding {
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
        sparseIntArray.put(R.id.list_empty_layout_container, 2);
        sViewsWithIds.put(R.id.title, 3);
        sViewsWithIds.put(R.id.tnc, 4);
        sViewsWithIds.put(R.id.imgCross, 5);
        sViewsWithIds.put(R.id.rb_emi, 6);
        sViewsWithIds.put(R.id.dot_progress_bar, 7);
        sViewsWithIds.put(R.id.rv_emi, 8);
    }

    public EmiDetailsLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private EmiDetailsLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[7], objArr[5], objArr[2], objArr[1], objArr[6], objArr[8], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.minHeightLayout.setTag((Object) null);
        View view2 = view;
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

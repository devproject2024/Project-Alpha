package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.LoadingInstrumentSheetViewModel;

public class NativeInstrumentLoadingSheetBindingImpl extends NativeInstrumentLoadingSheetBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_loading, 1);
        sViewsWithIds.put(R.id.tv_please_wait, 2);
        sViewsWithIds.put(R.id.tv_fetch_payment_methods, 3);
        sViewsWithIds.put(R.id.dot_progress_bar, 4);
        sViewsWithIds.put(R.id.v_dark_blue_strip, 5);
        sViewsWithIds.put(R.id.v_light_blue_strip, 6);
    }

    public NativeInstrumentLoadingSheetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private NativeInstrumentLoadingSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[4], objArr[1], objArr[3], objArr[2], objArr[5], objArr[6]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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

    public boolean setVariable(int i2, Object obj) {
        if (BR.selectedInstrumentSheetViewModel != i2) {
            return false;
        }
        setSelectedInstrumentSheetViewModel((LoadingInstrumentSheetViewModel) obj);
        return true;
    }

    public void setSelectedInstrumentSheetViewModel(LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel) {
        this.mSelectedInstrumentSheetViewModel = loadingInstrumentSheetViewModel;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}

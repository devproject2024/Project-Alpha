package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.generated.callback.OnCheckedChangeListener;
import com.business.merchant_payments.homepagedialogs.HomeDialogsManager;

public class MpDialogDownloadBusinessAppBindingImpl extends MpDialogDownloadBusinessAppBinding implements OnCheckedChangeListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public final CompoundButton.OnCheckedChangeListener mCallback8;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 2);
        sViewsWithIds.put(R.id.img_reminder, 3);
        sViewsWithIds.put(R.id.tick_1, 4);
        sViewsWithIds.put(R.id.point_1, 5);
        sViewsWithIds.put(R.id.tick_2, 6);
        sViewsWithIds.put(R.id.point_2, 7);
        sViewsWithIds.put(R.id.tick_3, 8);
        sViewsWithIds.put(R.id.point_3, 9);
        sViewsWithIds.put(R.id.btn_download_app_now, 10);
        sViewsWithIds.put(R.id.btn_do_it_later, 11);
        sViewsWithIds.put(R.id.view_dont_ask_again, 12);
    }

    public MpDialogDownloadBusinessAppBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 13, sIncludes, sViewsWithIds));
    }

    public MpDialogDownloadBusinessAppBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[11], objArr[10], objArr[1], objArr[3], objArr[5], objArr[7], objArr[9], objArr[0], objArr[4], objArr[6], objArr[8], objArr[2], objArr[12]);
        this.mDirtyFlags = -1;
        this.checkDontAskAgain.setTag((Object) null);
        this.rootView.setTag((Object) null);
        setRootTag(view);
        this.mCallback8 = new OnCheckedChangeListener(this, 1);
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
        if (BR.parentViewModel != i2) {
            return false;
        }
        setParentViewModel((HomeDialogsManager) obj);
        return true;
    }

    public void setParentViewModel(HomeDialogsManager homeDialogsManager) {
        this.mParentViewModel = homeDialogsManager;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.parentViewModel);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            this.checkDontAskAgain.setOnCheckedChangeListener(this.mCallback8);
        }
    }

    public final void _internalCallbackOnCheckedChanged(int i2, CompoundButton compoundButton, boolean z) {
        HomeDialogsManager homeDialogsManager = this.mParentViewModel;
        if (homeDialogsManager != null) {
            homeDialogsManager.checkChangeListener(2, z);
        }
    }
}

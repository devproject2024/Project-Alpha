package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.viewmodel.OtpDialogViewModel;

public class PrOtpDialogViewBindingImpl extends PrOtpDialogViewBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public final View.OnClickListener mCallback5;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.backIV, 4);
        sViewsWithIds.put(R.id.tv_enter_otp, 5);
        sViewsWithIds.put(R.id.crossIv, 6);
        sViewsWithIds.put(R.id.tv_sent_to_text, 7);
        sViewsWithIds.put(R.id.container_id, 8);
        sViewsWithIds.put(R.id.margin_view, 9);
        sViewsWithIds.put(R.id.filler_view, 10);
    }

    public PrOtpDialogViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrOtpDialogViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[1], objArr[8], objArr[6], objArr[10], objArr[9], objArr[3], objArr[2], objArr[5], objArr[7]);
        this.mDirtyFlags = -1;
        this.btnResendOtp.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        this.proceedBtn.setTag((Object) null);
        this.progress.setTag((Object) null);
        setRootTag(view);
        this.mCallback5 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((OtpDialogViewModel) obj);
        return true;
    }

    public void setViewModel(OtpDialogViewModel otpDialogViewModel) {
        this.mViewModel = otpDialogViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeViewModelShowProgress((ObservableBoolean) obj, i3);
    }

    private boolean onChangeViewModelShowProgress(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        int i2;
        boolean z;
        boolean z2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OtpDialogViewModel otpDialogViewModel = this.mViewModel;
        ObservableBoolean observableBoolean = null;
        int i3 = 0;
        int i4 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (otpDialogViewModel != null) {
                observableBoolean = otpDialogViewModel.showProgress;
            }
            updateRegistration(0, (h) observableBoolean);
            if (observableBoolean != null) {
                z2 = observableBoolean.get();
            } else {
                z2 = false;
            }
            if (i4 != 0) {
                if (z2) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            i2 = z2 ? 4 : 0;
            if (!z2) {
                i3 = 4;
            }
            z = !z2;
        } else {
            z = false;
            i2 = 0;
        }
        if ((j & 7) != 0) {
            this.btnResendOtp.setEnabled(z);
            this.btnResendOtp.setVisibility(i2);
            this.proceedBtn.setEnabled(z);
            this.progress.setVisibility(i3);
        }
        if ((j & 4) != 0) {
            this.btnResendOtp.setOnClickListener(this.mCallback5);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        OtpDialogViewModel otpDialogViewModel = this.mViewModel;
        if (otpDialogViewModel != null) {
            otpDialogViewModel.onResendOtp();
        }
    }
}

package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.generated.callback.OnTextChanged;
import net.one97.paytm.nativesdk.login.viewmodel.LoginViewModel;

public class LoginFragmentLayoutBindingImpl extends LoginFragmentLayoutBinding implements OnTextChanged.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final d.c mCallback2;
    private long mDirtyFlags;
    private OnClickListenerImpl mLandingPageViewModelHandleLoginClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final FrameLayout mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.scrollView, 4);
        sViewsWithIds.put(R.id.rl_merchantInfo, 5);
        sViewsWithIds.put(R.id.iv_merchantLogo, 6);
        sViewsWithIds.put(R.id.iv_cross, 7);
        sViewsWithIds.put(R.id.tv_amtTobePaid, 8);
        sViewsWithIds.put(R.id.tv_amount, 9);
        sViewsWithIds.put(R.id.tv_decimalAmt, 10);
        sViewsWithIds.put(R.id.lyt_select_other_option, 11);
        sViewsWithIds.put(R.id.rl_paytmPayOption, 12);
        sViewsWithIds.put(R.id.rb_paytmPayOption, 13);
        sViewsWithIds.put(R.id.iv_paytmLogo, 14);
        sViewsWithIds.put(R.id.ll_login, 15);
        sViewsWithIds.put(R.id.tv_err_mobile_number, 16);
        sViewsWithIds.put(R.id.btn_login, 17);
        sViewsWithIds.put(R.id.lyt_paymethods, 18);
        sViewsWithIds.put(R.id.otp_fragment_container, 19);
        sViewsWithIds.put(R.id.pb_progress, 20);
    }

    public LoginFragmentLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, sIncludes, sViewsWithIds));
    }

    private LoginFragmentLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[17], objArr[1], objArr[7], objArr[6], objArr[14], objArr[15], objArr[18], objArr[11], objArr[2], objArr[19], objArr[20], objArr[13], objArr[5], objArr[12], objArr[4], objArr[9], objArr[8], objArr[10], objArr[16]);
        this.mDirtyFlags = -1;
        this.etMobileNumber.setTag((Object) null);
        this.lytSignInButton.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnTextChanged(this, 1);
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
        if (BR.landingPageViewModel != i2) {
            return false;
        }
        setLandingPageViewModel((LoginViewModel) obj);
        return true;
    }

    public void setLandingPageViewModel(LoginViewModel loginViewModel) {
        updateRegistration(0, (h) loginViewModel);
        this.mLandingPageViewModel = loginViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.landingPageViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeLandingPageViewModel((LoginViewModel) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeLandingPageViewModelProgressbarVisiblity((ObservableInt) obj, i3);
    }

    private boolean onChangeLandingPageViewModel(LoginViewModel loginViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLandingPageViewModelProgressbarVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        OnClickListenerImpl onClickListenerImpl;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LoginViewModel loginViewModel = this.mLandingPageViewModel;
        int i2 = 0;
        int i3 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if ((j & 5) == 0 || loginViewModel == null) {
                onClickListenerImpl = null;
            } else {
                OnClickListenerImpl onClickListenerImpl2 = this.mLandingPageViewModelHandleLoginClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl2 == null) {
                    onClickListenerImpl2 = new OnClickListenerImpl();
                    this.mLandingPageViewModelHandleLoginClickAndroidViewViewOnClickListener = onClickListenerImpl2;
                }
                onClickListenerImpl = onClickListenerImpl2.setValue(loginViewModel);
            }
            ObservableInt observableInt = loginViewModel != null ? loginViewModel.progressbarVisiblity : null;
            updateRegistration(1, (h) observableInt);
            if (observableInt != null) {
                i2 = observableInt.get();
            }
        } else {
            onClickListenerImpl = null;
        }
        if ((4 & j) != 0) {
            d.a(this.etMobileNumber, this.mCallback2, (d.a) null, (g) null);
        }
        if ((j & 5) != 0) {
            this.lytSignInButton.setOnClickListener(onClickListenerImpl);
        }
        if (i3 != 0) {
            this.mboundView3.setVisibility(i2);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private LoginViewModel value;

        public OnClickListenerImpl setValue(LoginViewModel loginViewModel) {
            this.value = loginViewModel;
            if (loginViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.handleLoginClick(view);
        }
    }

    public final void _internalCallbackOnTextChanged(int i2, CharSequence charSequence, int i3, int i4, int i5) {
        LoginViewModel loginViewModel = this.mLandingPageViewModel;
        if (loginViewModel != null) {
            loginViewModel.onTextChanged(getRoot().getContext(), charSequence);
        }
    }
}

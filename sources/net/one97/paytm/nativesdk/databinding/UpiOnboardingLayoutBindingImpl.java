package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingViewModel;

public class UpiOnboardingLayoutBindingImpl extends UpiOnboardingLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rb_bank_name, 3);
        sViewsWithIds.put(R.id.tv_newTxt, 4);
        sViewsWithIds.put(R.id.tv_promotion, 5);
        sViewsWithIds.put(R.id.txt_account, 6);
        sViewsWithIds.put(R.id.upi_image, 7);
        sViewsWithIds.put(R.id.tvOfferText, 8);
        sViewsWithIds.put(R.id.ltv_loading, 9);
    }

    public UpiOnboardingLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private UpiOnboardingLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[1], objArr[9], objArr[0], objArr[2], objArr[3], objArr[4], objArr[8], objArr[5], objArr[6], objArr[7]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.parentLayout.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (BR.model == i2) {
            setModel((UpiOnboardingViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setModel(UpiOnboardingViewModel upiOnboardingViewModel) {
        updateRegistration(0, (h) upiOnboardingViewModel);
        this.mModel = upiOnboardingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeModel((UpiOnboardingViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeModelProceedButtonVisibility((ObservableInt) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeModelPaySecurelyText((i) obj, i3);
    }

    private boolean onChangeModel(UpiOnboardingViewModel upiOnboardingViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelProceedButtonVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UpiOnboardingViewModel upiOnboardingViewModel = this.mModel;
        int i2 = 0;
        String str = null;
        if ((23 & j) != 0) {
            if ((j & 19) != 0) {
                ObservableInt observableInt = upiOnboardingViewModel != null ? upiOnboardingViewModel.proceedButtonVisibility : null;
                updateRegistration(1, (h) observableInt);
                if (observableInt != null) {
                    i2 = observableInt.get();
                }
            }
            if ((j & 21) != 0) {
                i<String> iVar = upiOnboardingViewModel != null ? upiOnboardingViewModel.paySecurelyText : null;
                updateRegistration(2, (h) iVar);
                if (iVar != null) {
                    str = iVar.get();
                }
            }
        }
        if ((j & 19) != 0) {
            this.btnProceed.setVisibility(i2);
        }
        if ((j & 21) != 0) {
            d.a(this.paysecurely, (CharSequence) str);
        }
    }
}

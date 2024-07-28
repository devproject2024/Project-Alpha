package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel;

public class PrProfileScreenHeaderBindingImpl extends PrProfileScreenHeaderBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.profile_pic, 2);
        sViewsWithIds.put(R.id.user_name, 3);
        sViewsWithIds.put(R.id.merchant_switch_view, 4);
    }

    public PrProfileScreenHeaderBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public PrProfileScreenHeaderBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[4], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.businessDisplayName.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        setRootTag(view);
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
        setViewModel((ProfileBusinessDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel) {
        this.mViewModel = profileBusinessDetailsViewModel;
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
        return onChangeViewModelDisplayName((i) obj, i3);
    }

    private boolean onChangeViewModelDisplayName(i<String> iVar, int i2) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel = this.mViewModel;
        String str = null;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            i<String> iVar = profileBusinessDetailsViewModel != null ? profileBusinessDetailsViewModel.displayName : null;
            updateRegistration(0, (h) iVar);
            if (iVar != null) {
                str = iVar.get();
            }
        }
        if (i2 != 0) {
            d.a(this.businessDisplayName, (CharSequence) str);
        }
    }
}

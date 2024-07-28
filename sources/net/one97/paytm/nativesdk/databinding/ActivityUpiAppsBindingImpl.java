package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel;

public class ActivityUpiAppsBindingImpl extends ActivityUpiAppsBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final FrameLayout mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.list_empty_layout_container, 3);
        sViewsWithIds.put(R.id.iv_back_arrow, 4);
        sViewsWithIds.put(R.id.tv_toolbar_title, 5);
        sViewsWithIds.put(R.id.imgSearch, 6);
        sViewsWithIds.put(R.id.searchView, 7);
        sViewsWithIds.put(R.id.img_edt_cross, 8);
    }

    public ActivityUpiAppsBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    private ActivityUpiAppsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[8], objArr[6], objArr[4], objArr[3], objArr[2], objArr[7], objArr[5]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.rvAppsList.setTag((Object) null);
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
        if (BR.allNetBankingViewModel != i2) {
            return false;
        }
        setAllNetBankingViewModel((AllNetBankingListViewModel) obj);
        return true;
    }

    public void setAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel) {
        updateRegistration(0, (h) allNetBankingListViewModel);
        this.mAllNetBankingViewModel = allNetBankingListViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.allNetBankingViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeAllNetBankingViewModel((AllNetBankingListViewModel) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeAllNetBankingViewModelNetbakingRecyclerVisiblity((ObservableInt) obj, i3);
    }

    private boolean onChangeAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAllNetBankingViewModelNetbakingRecyclerVisiblity(ObservableInt observableInt, int i2) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AllNetBankingListViewModel allNetBankingListViewModel = this.mAllNetBankingViewModel;
        int i2 = 0;
        ObservableInt observableInt = null;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (allNetBankingListViewModel != null) {
                observableInt = allNetBankingListViewModel.netbakingRecyclerVisiblity;
            }
            updateRegistration(1, (h) observableInt);
            if (observableInt != null) {
                i2 = observableInt.get();
            }
        }
        if (i3 != 0) {
            this.rvAppsList.setVisibility(i2);
        }
    }
}

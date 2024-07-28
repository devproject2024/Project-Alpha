package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.viewmodel.EmbedWebViewViewModel;

public class MpEmbedWebViewActivityBindingImpl extends MpEmbedWebViewActivityBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;
    public final ProgressBar mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.tv_title, 3);
        sViewsWithIds.put(R.id.webview, 4);
    }

    public MpEmbedWebViewActivityBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public MpEmbedWebViewActivityBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[2], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        ProgressBar progressBar = objArr[1];
        this.mboundView1 = progressBar;
        progressBar.setTag((Object) null);
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
        if (BR.embedWebViewViewModel != i2) {
            return false;
        }
        setEmbedWebViewViewModel((EmbedWebViewViewModel) obj);
        return true;
    }

    public void setEmbedWebViewViewModel(EmbedWebViewViewModel embedWebViewViewModel) {
        updateRegistration(0, (h) embedWebViewViewModel);
        this.mEmbedWebViewViewModel = embedWebViewViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.embedWebViewViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeEmbedWebViewViewModel((EmbedWebViewViewModel) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeEmbedWebViewViewModelProgressBarVisibility((i) obj, i3);
    }

    private boolean onChangeEmbedWebViewViewModel(EmbedWebViewViewModel embedWebViewViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeEmbedWebViewViewModelProgressBarVisibility(i<Integer> iVar, int i2) {
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
        int i2 = 0;
        EmbedWebViewViewModel embedWebViewViewModel = this.mEmbedWebViewViewModel;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            Integer num = null;
            i<Integer> iVar = embedWebViewViewModel != null ? embedWebViewViewModel.progressBarVisibility : null;
            updateRegistration(1, (h) iVar);
            if (iVar != null) {
                num = iVar.get();
            }
            i2 = ViewDataBinding.safeUnbox(num);
        }
        if (i3 != 0) {
            this.mboundView1.setVisibility(i2);
        }
    }
}

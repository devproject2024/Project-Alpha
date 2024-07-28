package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SmartGridDataModel;

public class SfGridPopupLayoutBindingImpl extends SfGridPopupLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_begin, 5);
        sViewsWithIds.put(R.id.guideline_end, 6);
        sViewsWithIds.put(R.id.guideline_top, 7);
        sViewsWithIds.put(R.id.tickerLayout, 8);
        sViewsWithIds.put(R.id.gridViewPager, 9);
        sViewsWithIds.put(R.id.progressLottie, 10);
    }

    public SfGridPopupLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private SfGridPopupLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[9], objArr[5], objArr[6], objArr[7], objArr[4], objArr[0], objArr[10], objArr[2], objArr[8], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        this.indicator.setTag((Object) null);
        this.popupLayout.setTag((Object) null);
        this.tickerIcon.setTag((Object) null);
        this.tickerText.setTag((Object) null);
        this.titleTV.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (BR.dataModel != i2) {
            return false;
        }
        setDataModel((SmartGridDataModel) obj);
        return true;
    }

    public void setDataModel(SmartGridDataModel smartGridDataModel) {
        updateRegistration(0, (h) smartGridDataModel);
        this.mDataModel = smartGridDataModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.dataModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeDataModel((SmartGridDataModel) obj, i3);
    }

    private boolean onChangeDataModel(SmartGridDataModel smartGridDataModel, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 == BR.title) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i2 != BR.pagerIndicatorVisibility) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SmartGridDataModel smartGridDataModel = this.mDataModel;
        int i2 = 0;
        String str2 = null;
        if ((15 & j) != 0) {
            str = ((j & 9) == 0 || smartGridDataModel == null) ? null : smartGridDataModel.getTickerText();
            if (!((j & 13) == 0 || smartGridDataModel == null)) {
                i2 = smartGridDataModel.getPagerIndicatorVisibility();
            }
            if (!((j & 11) == 0 || smartGridDataModel == null)) {
                str2 = smartGridDataModel.getTitle();
            }
        } else {
            str = null;
        }
        if ((13 & j) != 0) {
            this.indicator.setVisibility(i2);
        }
        if ((9 & j) != 0) {
            SmartGridDataModel.setImageWithDefault(this.tickerIcon, smartGridDataModel);
            d.a(this.tickerText, (CharSequence) str);
        }
        if ((j & 11) != 0) {
            d.a(this.titleTV, (CharSequence) str2);
        }
    }
}

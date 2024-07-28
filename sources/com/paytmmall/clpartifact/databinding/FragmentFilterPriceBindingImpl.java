package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;

public class FragmentFilterPriceBindingImpl extends FragmentFilterPriceBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.seekBar, 3);
    }

    public FragmentFilterPriceBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private FragmentFilterPriceBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.fromTxt.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.toTxt.setTag((Object) null);
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
        if (BR.initialTo == i2) {
            setInitialTo((String) obj);
        } else if (BR.initialFrom != i2) {
            return false;
        } else {
            setInitialFrom((String) obj);
        }
        return true;
    }

    public void setInitialTo(String str) {
        this.mInitialTo = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.initialTo);
        super.requestRebind();
    }

    public void setInitialFrom(String str) {
        this.mInitialFrom = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.initialFrom);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mInitialTo;
        String str2 = this.mInitialFrom;
        if ((6 & j) != 0) {
            d.a((TextView) this.fromTxt, (CharSequence) str2);
        }
        if ((j & 5) != 0) {
            d.a((TextView) this.toTxt, (CharSequence) str);
        }
    }
}

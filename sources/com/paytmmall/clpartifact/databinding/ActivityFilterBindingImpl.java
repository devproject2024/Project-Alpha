package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.FilterActivity;

public class ActivityFilterBindingImpl extends ActivityFilterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback89;
    private final View.OnClickListener mCallback90;
    private final View.OnClickListener mCallback91;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lyt_filter_header, 4);
        sViewsWithIds.put(R.id.lyt_filter_list, 5);
        sViewsWithIds.put(R.id.rv_filter, 6);
        sViewsWithIds.put(R.id.lyt_filter_detail, 7);
        sViewsWithIds.put(R.id.lyt_filter_close, 8);
        sViewsWithIds.put(R.id.progressBar, 9);
    }

    public ActivityFilterBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    private ActivityFilterBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[8], objArr[7], objArr[4], objArr[5], objArr[9], objArr[6]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        setRootTag(view);
        this.mCallback89 = new OnClickListener(this, 1);
        this.mCallback90 = new OnClickListener(this, 2);
        this.mCallback91 = new OnClickListener(this, 3);
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
        if (BR.handler != i2) {
            return false;
        }
        setHandler((FilterActivity) obj);
        return true;
    }

    public void setHandler(FilterActivity filterActivity) {
        this.mHandler = filterActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback89);
            this.mboundView2.setOnClickListener(this.mCallback90);
            this.mboundView3.setOnClickListener(this.mCallback91);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            FilterActivity filterActivity = this.mHandler;
            if (filterActivity != null) {
                z = true;
            }
            if (z) {
                filterActivity.handleClearAll();
            }
        } else if (i2 == 2) {
            FilterActivity filterActivity2 = this.mHandler;
            if (filterActivity2 != null) {
                z = true;
            }
            if (z) {
                filterActivity2.handleClose();
            }
        } else if (i2 == 3) {
            FilterActivity filterActivity3 = this.mHandler;
            if (filterActivity3 != null) {
                z = true;
            }
            if (z) {
                filterActivity3.handleApplyAll();
            }
        }
    }
}

package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.viewHolder.TreeWidgetViewHolder;

public class ItemTreeOneFixedBindingImpl extends ItemTreeOneFixedBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback32;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;
    private final TextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.arrow_fixed, 4);
    }

    public ItemTreeOneFixedBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemTreeOneFixedBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[0], objArr[3]);
        this.mDirtyFlags = -1;
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.treeFixed.setTag((Object) null);
        this.treeRecyclerview.setTag((Object) null);
        setRootTag(view);
        this.mCallback32 = new OnClickListener(this, 1);
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.handler == i2) {
            setHandler((TreeWidgetViewHolder) obj);
        } else if (BR.IS_COLLAPSED != i2) {
            return false;
        } else {
            setISCOLLAPSED((Boolean) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(0, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setHandler(TreeWidgetViewHolder treeWidgetViewHolder) {
        this.mHandler = treeWidgetViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setISCOLLAPSED(Boolean bool) {
        this.mISCOLLAPSED = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.IS_COLLAPSED);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        Boolean bool = this.mISCOLLAPSED;
        String str = null;
        if (!((j & 25) == 0 || view == null)) {
            str = view.getTitle();
        }
        int i2 = 0;
        int i3 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 64 : 32;
            }
            if (safeUnbox) {
                i2 = 8;
            }
        }
        if ((16 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback32);
        }
        if ((25 & j) != 0) {
            d.a(this.mboundView2, (CharSequence) str);
        }
        if ((j & 20) != 0) {
            this.treeRecyclerview.setVisibility(i2);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        TreeWidgetViewHolder treeWidgetViewHolder = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        if (treeWidgetViewHolder != null) {
            treeWidgetViewHolder.handleTreeClick(view2);
        }
    }
}

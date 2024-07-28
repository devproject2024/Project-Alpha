package com.paytmmall.clpartifact.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarousel4X;

public class ItemReco4xRvBindingImpl extends ItemReco4xRvBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback36;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.expandGroup4x, 2);
    }

    public ItemReco4xRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemReco4xRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[2], objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.mainLayout.setTag((Object) null);
        this.showMore.setTag((Object) null);
        setRootTag(view);
        this.mCallback36 = new OnClickListener(this, 1);
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
            setHandler((CLPCarousel4X) obj);
        } else if (BR.showMoreVisibility == i2) {
            setShowMoreVisibility((Boolean) obj);
        } else if (BR.isCollapsed != i2) {
            return false;
        } else {
            setIsCollapsed((Boolean) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        this.mView = view;
    }

    public void setHandler(CLPCarousel4X cLPCarousel4X) {
        this.mHandler = cLPCarousel4X;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setShowMoreVisibility(Boolean bool) {
        this.mShowMoreVisibility = bool;
    }

    public void setIsCollapsed(Boolean bool) {
        this.mIsCollapsed = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.isCollapsed);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
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
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        Boolean bool = this.mIsCollapsed;
        int i3 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 64 : 32;
            }
            if (safeUnbox) {
                resources = this.showMore.getResources();
                i2 = R.string.see_all;
            } else {
                resources = this.showMore.getResources();
                i2 = R.string.see_less;
            }
            str = resources.getString(i2);
        }
        if ((j & 24) != 0) {
            d.a((TextView) this.showMore, (CharSequence) str);
        }
        if ((j & 16) != 0) {
            this.showMore.setOnClickListener(this.mCallback36);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPCarousel4X cLPCarousel4X = this.mHandler;
        if (cLPCarousel4X != null) {
            cLPCarousel4X.handleMoreClick(view);
        }
    }
}

package com.paytmmall.clpartifact.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.SmartGroupGridAdapter;
import com.paytmmall.clpartifact.view.viewmodel.SmartGroupGrid4XNVH;

public class SmartGroupGrid4xnRvBindingImpl extends SmartGroupGrid4xnRvBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback64;
    private long mDirtyFlags;

    public SmartGroupGrid4xnRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private SmartGroupGrid4xnRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[2], objArr[0], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.expandGroup.setTag((Object) null);
        this.llParent.setTag((Object) null);
        this.quickMoney.setTag((Object) null);
        this.showMore.setTag((Object) null);
        setRootTag(view);
        this.mCallback64 = new OnClickListener(this, 1);
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
            setHandler((SmartGroupGrid4XNVH) obj);
        } else if (BR.groupAdapter != i2) {
            return false;
        } else {
            setGroupAdapter((SmartGroupGridAdapter) obj);
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

    public void setHandler(SmartGroupGrid4XNVH smartGroupGrid4XNVH) {
        this.mHandler = smartGroupGrid4XNVH;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setGroupAdapter(SmartGroupGridAdapter smartGroupGridAdapter) {
        this.mGroupAdapter = smartGroupGridAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.groupAdapter);
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
        boolean z;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        SmartGroupGridAdapter smartGroupGridAdapter = this.mGroupAdapter;
        int i2 = 0;
        String str3 = null;
        if ((j & 25) != 0) {
            int i3 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
            if (i3 != 0) {
                str = view != null ? view.getShow_more_label() : null;
                z = !TextUtils.isEmpty(str);
                if (i3 != 0) {
                    j |= z ? 64 : 32;
                }
            } else {
                str = null;
                z = false;
            }
            str2 = view != null ? view.getTitle() : null;
            boolean z2 = !TextUtils.isEmpty(str2);
            if ((j & 25) != 0) {
                j |= z2 ? 256 : 128;
            }
            if (!z2) {
                i2 = 8;
            }
        } else {
            str2 = null;
            str = null;
            z = false;
        }
        int i4 = ((17 & j) > 0 ? 1 : ((17 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (!z) {
                str = this.showMore.getResources().getString(R.string.show_more);
            }
            str3 = str;
        }
        if ((20 & j) != 0) {
            this.expandGroup.setAdapter(smartGroupGridAdapter);
        }
        if ((j & 25) != 0) {
            d.a(this.quickMoney, (CharSequence) str2);
            this.quickMoney.setVisibility(i2);
        }
        if (i4 != 0) {
            d.a(this.showMore, (CharSequence) str3);
        }
        if ((j & 16) != 0) {
            this.showMore.setOnClickListener(this.mCallback64);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        SmartGroupGrid4XNVH smartGroupGrid4XNVH = this.mHandler;
        if (smartGroupGrid4XNVH != null) {
            smartGroupGrid4XNVH.handleAllClick();
        }
    }
}

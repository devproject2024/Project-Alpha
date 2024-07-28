package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import com.paytmmall.clpartifact.view.adapter.CategoryFilterValuesAdapter;

public class ItemFilterCategoryBindingImpl extends ItemFilterCategoryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback76;
    private final View.OnClickListener mCallback77;
    private final View.OnClickListener mCallback78;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ItemFilterCategoryBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemFilterCategoryBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.categoryName.setTag((Object) null);
        this.itemCount.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.selectedImage.setTag((Object) null);
        setRootTag(view);
        this.mCallback77 = new OnClickListener(this, 2);
        this.mCallback78 = new OnClickListener(this, 3);
        this.mCallback76 = new OnClickListener(this, 1);
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
        if (BR.item == i2) {
            setItem((CJRFrontEndFilterItem) obj);
        } else if (BR.handler == i2) {
            setHandler((CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
        }
        return true;
    }

    public void setItem(CJRFrontEndFilterItem cJRFrontEndFilterItem) {
        this.mItem = cJRFrontEndFilterItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder categoryFilterValuesItemHolder) {
        this.mHandler = categoryFilterValuesItemHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
    }

    public void executeBindings() {
        long j;
        String str;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRFrontEndFilterItem cJRFrontEndFilterItem = this.mItem;
        String str2 = null;
        int i2 = 0;
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRFrontEndFilterItem != null) {
                str2 = cJRFrontEndFilterItem.getCount();
                z = cJRFrontEndFilterItem.isSelected();
                str = cJRFrontEndFilterItem.getName();
            } else {
                str = null;
                z = false;
            }
            if (i3 != 0) {
                j |= z ? 32 : 16;
            }
            if (z) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((8 & j) != 0) {
            this.categoryName.setOnClickListener(this.mCallback78);
            this.itemCount.setOnClickListener(this.mCallback77);
            this.selectedImage.setOnClickListener(this.mCallback76);
        }
        if ((j & 9) != 0) {
            d.a((TextView) this.categoryName, (CharSequence) str);
            d.a((TextView) this.itemCount, (CharSequence) str2);
            this.itemCount.setVisibility(i2);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder categoryFilterValuesItemHolder = this.mHandler;
            CJRFrontEndFilterItem cJRFrontEndFilterItem = this.mItem;
            if (categoryFilterValuesItemHolder != null) {
                z = true;
            }
            if (z) {
                categoryFilterValuesItemHolder.onFilterSelected(cJRFrontEndFilterItem, true);
            }
        } else if (i2 == 2) {
            CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder categoryFilterValuesItemHolder2 = this.mHandler;
            CJRFrontEndFilterItem cJRFrontEndFilterItem2 = this.mItem;
            if (categoryFilterValuesItemHolder2 == null) {
                z2 = false;
            }
            if (z2) {
                categoryFilterValuesItemHolder2.onFilterSelected(cJRFrontEndFilterItem2, false);
            }
        } else if (i2 == 3) {
            CategoryFilterValuesAdapter.CategoryFilterValuesItemHolder categoryFilterValuesItemHolder3 = this.mHandler;
            CJRFrontEndFilterItem cJRFrontEndFilterItem3 = this.mItem;
            if (categoryFilterValuesItemHolder3 == null) {
                z2 = false;
            }
            if (z2) {
                categoryFilterValuesItemHolder3.onFilterSelected(cJRFrontEndFilterItem3, false);
            }
        }
    }
}

package com.paytmmall.clpartifact.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.view.adapter.FilterValuesAdapter;

public class ItemFilterLinearRectBindingImpl extends ItemFilterLinearRectBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback103;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ImageView mboundView4;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.brand_label, 5);
        sViewsWithIds.put(R.id.brand_divider, 6);
        sViewsWithIds.put(R.id.colorImageView, 7);
    }

    public ItemFilterLinearRectBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemFilterLinearRectBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[6], objArr[5], objArr[7], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.filterName.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.numberCount.setTag((Object) null);
        setRootTag(view);
        this.mCallback103 = new OnClickListener(this, 1);
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
        if (BR.item == i2) {
            setItem((CJRFilterValue) obj);
        } else if (BR.handler == i2) {
            setHandler((FilterValuesAdapter.FilterValuesItemHolder) obj);
        } else if (BR.position == i2) {
            setPosition((Integer) obj);
        } else if (BR.isApplied != i2) {
            return false;
        } else {
            setIsApplied((Boolean) obj);
        }
        return true;
    }

    public void setItem(CJRFilterValue cJRFilterValue) {
        this.mItem = cJRFilterValue;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(FilterValuesAdapter.FilterValuesItemHolder filterValuesItemHolder) {
        this.mHandler = filterValuesItemHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public void setIsApplied(Boolean bool) {
        this.mIsApplied = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.isApplied);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        int i2;
        int i3;
        TextView textView;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRFilterValue cJRFilterValue = this.mItem;
        Boolean bool = this.mIsApplied;
        Drawable drawable = null;
        if ((j & 17) == 0 || cJRFilterValue == null) {
            str2 = null;
            str = null;
        } else {
            str = cJRFilterValue.getCount();
            str2 = cJRFilterValue.getName();
        }
        int i4 = 0;
        int i5 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if (i5 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i5 != 0) {
                if (safeUnbox) {
                    j3 = j | 64 | 256;
                    j2 = 1024;
                } else {
                    j3 = j | 32 | 128;
                    j2 = 512;
                }
                j = j3 | j2;
            }
            i4 = getColorFromResource(this.numberCount, safeUnbox ? R.color.clp_color_2222222 : R.color.filter_text_color);
            drawable = getDrawableFromResource(this.mboundView4, safeUnbox ? R.drawable.clp_ic_cancel : R.drawable.clp_ic_done);
            if (safeUnbox) {
                textView = this.filterName;
                i3 = R.color.clp_color_2222222;
            } else {
                textView = this.filterName;
                i3 = R.color.filter_text_color;
            }
            i2 = getColorFromResource(textView, i3);
        } else {
            i2 = 0;
        }
        if ((17 & j) != 0) {
            d.a(this.filterName, (CharSequence) str2);
            d.a(this.numberCount, (CharSequence) str);
        }
        if ((j & 24) != 0) {
            this.filterName.setTextColor(i2);
            this.mboundView4.setImageDrawable(drawable);
            this.numberCount.setTextColor(i4);
        }
        if ((j & 16) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback103);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        FilterValuesAdapter.FilterValuesItemHolder filterValuesItemHolder = this.mHandler;
        CJRFilterValue cJRFilterValue = this.mItem;
        Integer num = this.mPosition;
        if (filterValuesItemHolder != null) {
            filterValuesItemHolder.onFilterSelected(num.intValue(), cJRFilterValue);
        }
    }
}

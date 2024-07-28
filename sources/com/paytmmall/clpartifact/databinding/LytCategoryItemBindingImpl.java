package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class LytCategoryItemBindingImpl extends LytCategoryItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.grp_item, 5);
        sViewsWithIds.put(R.id.textView, 6);
    }

    public LytCategoryItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private LytCategoryItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[3], objArr[5], objArr[2], objArr[6], objArr[1]);
        this.mDirtyFlags = -1;
        this.categoryTitle.setTag((Object) null);
        this.groupImageView.setTag((Object) null);
        this.icRaises.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback10 = new OnClickListener(this, 1);
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
            setItem((Item) obj);
        } else if (BR.handler == i2) {
            setHandler((ICategoryClickListener) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
        }
        return true;
    }

    public void setItem(Item item) {
        updateRegistration(0, (h) item);
        this.mItem = item;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(ICategoryClickListener iCategoryClickListener) {
        this.mHandler = iCategoryClickListener;
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

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeItem((Item) obj, i3);
    }

    private boolean onChangeItem(Item item, int i2) {
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
        String str;
        String str2;
        String str3;
        Item.LayoutData layoutData;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        int i3 = 0;
        String str5 = null;
        int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (item != null) {
                str4 = item.getImageUrl();
                layoutData = item.getLayout();
                str3 = item.getName();
            } else {
                str3 = null;
                str4 = null;
                layoutData = null;
            }
            if (layoutData != null) {
                str5 = layoutData.mLabel;
            }
            boolean z = !TextUtils.isEmpty(str5);
            if (i4 != 0) {
                j |= z ? 32 : 16;
            }
            if (!z) {
                i3 = 4;
            }
            str2 = str4;
            i2 = i3;
            str = str5;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((9 & j) != 0) {
            this.categoryTitle.setText(str3);
            ClickableRVChildViewHolder.setImageUrl(this.groupImageView, str2, 0, false, false, 0, (Context) null);
            this.icRaises.setVisibility(i2);
            d.a(this.tvLabel, (CharSequence) str);
            this.tvLabel.setVisibility(i2);
        }
        if ((j & 8) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback10);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        ICategoryClickListener iCategoryClickListener = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        boolean z = true;
        if (iCategoryClickListener != null) {
            if (item == null) {
                z = false;
            }
            if (z) {
                iCategoryClickListener.onCategoryClick(item.getTitle(), num.intValue());
            }
        }
    }
}

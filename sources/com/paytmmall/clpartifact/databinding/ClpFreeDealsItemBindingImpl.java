package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.FreeDealsItemViewHolder;

public class ClpFreeDealsItemBindingImpl extends ClpFreeDealsItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback96;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.Free, 4);
    }

    public ClpFreeDealsItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ClpFreeDealsItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[4], objArr[1], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.imageView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.textView.setTag((Object) null);
        this.textView2.setTag((Object) null);
        setRootTag(view);
        this.mCallback96 = new OnClickListener(this, 1);
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
        if (BR.product == i2) {
            setProduct((CJRGridProduct) obj);
        } else if (BR.holder != i2) {
            return false;
        } else {
            setHolder((FreeDealsItemViewHolder) obj);
        }
        return true;
    }

    public void setProduct(CJRGridProduct cJRGridProduct) {
        this.mProduct = cJRGridProduct;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.product);
        super.requestRebind();
    }

    public void setHolder(FreeDealsItemViewHolder freeDealsItemViewHolder) {
        this.mHolder = freeDealsItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.holder);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        Context context;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRGridProduct cJRGridProduct = this.mProduct;
        FreeDealsItemViewHolder freeDealsItemViewHolder = this.mHolder;
        Context context2 = null;
        int i2 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if ((j & 5) == 0 || cJRGridProduct == null) {
                str3 = null;
                str2 = null;
            } else {
                str3 = cJRGridProduct.getName();
                str2 = cJRGridProduct.getBrand();
            }
            String imageUrl = cJRGridProduct != null ? cJRGridProduct.getImageUrl() : null;
            if (freeDealsItemViewHolder != null) {
                context2 = freeDealsItemViewHolder.getContext();
            }
            str = imageUrl;
            context = context2;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            context = null;
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.imageView, str, 0, false, false, 0, context);
        }
        if ((4 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback96);
        }
        if ((j & 5) != 0) {
            d.a(this.textView, (CharSequence) str2);
            d.a(this.textView2, (CharSequence) str3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CJRGridProduct cJRGridProduct = this.mProduct;
        FreeDealsItemViewHolder freeDealsItemViewHolder = this.mHolder;
        if (freeDealsItemViewHolder != null) {
            freeDealsItemViewHolder.handleGridDeepLink(cJRGridProduct, freeDealsItemViewHolder.getAdapterPosition());
        }
    }
}

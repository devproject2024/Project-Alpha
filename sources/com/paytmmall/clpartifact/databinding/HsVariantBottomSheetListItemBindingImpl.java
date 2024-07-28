package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.HSVariantBottomSheetRVAdapterViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class HsVariantBottomSheetListItemBindingImpl extends HsVariantBottomSheetListItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback24;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public HsVariantBottomSheetListItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private HsVariantBottomSheetListItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[5], objArr[6]);
        this.mDirtyFlags = -1;
        this.actualPrice.setTag((Object) null);
        this.discountPercent.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        setRootTag(view);
        this.mCallback24 = new OnClickListener(this, 1);
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
        if (BR.item == i2) {
            setItem((CJRGridProduct) obj);
        } else if (BR.holder != i2) {
            return false;
        } else {
            setHolder((HSVariantBottomSheetRVAdapterViewHolder) obj);
        }
        return true;
    }

    public void setItem(CJRGridProduct cJRGridProduct) {
        this.mItem = cJRGridProduct;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHolder(HSVariantBottomSheetRVAdapterViewHolder hSVariantBottomSheetRVAdapterViewHolder) {
        this.mHolder = hSVariantBottomSheetRVAdapterViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.holder);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRGridProduct cJRGridProduct = this.mItem;
        HSVariantBottomSheetRVAdapterViewHolder hSVariantBottomSheetRVAdapterViewHolder = this.mHolder;
        int i2 = 0;
        String str11 = null;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRGridProduct != null) {
                str10 = cJRGridProduct.getImageUrl();
                str9 = cJRGridProduct.getActualPrice();
                str8 = cJRGridProduct.getVariantValue();
                str7 = cJRGridProduct.getDiscountPercent();
                str6 = cJRGridProduct.getDiscountedPrice();
                z = cJRGridProduct.isDiscounted();
            } else {
                str10 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                z = false;
            }
            if (i3 != 0) {
                j |= z ? 16 : 8;
            }
            str3 = StringUtils.getRupeesFormat(str9);
            str2 = str7 + "%";
            String rupeesFormat = StringUtils.getRupeesFormat(str6);
            if (!z) {
                i2 = 8;
            }
            str5 = rupeesFormat;
            String str12 = str8;
            str = str10;
            str4 = str12;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i4 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (hSVariantBottomSheetRVAdapterViewHolder != null) {
                str11 = hSVariantBottomSheetRVAdapterViewHolder.getVariantLabel();
            }
            str11 = str11 + AppConstants.COLON;
        }
        if ((j & 5) != 0) {
            d.a(this.actualPrice, (CharSequence) str3);
            this.actualPrice.setVisibility(i2);
            d.a(this.discountPercent, (CharSequence) str2);
            this.discountPercent.setVisibility(i2);
            ClickableRVChildViewHolder.setImageUrl(this.mboundView1, str, 0, false, false, 0, (Context) null);
            d.a(this.mboundView3, (CharSequence) str4);
            d.a(this.mboundView4, (CharSequence) str5);
        }
        if ((j & 4) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback24);
        }
        if (i4 != 0) {
            d.a(this.mboundView2, (CharSequence) str11);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        HSVariantBottomSheetRVAdapterViewHolder hSVariantBottomSheetRVAdapterViewHolder = this.mHolder;
        if (hSVariantBottomSheetRVAdapterViewHolder != null) {
            hSVariantBottomSheetRVAdapterViewHolder.onProductClick();
        }
    }
}

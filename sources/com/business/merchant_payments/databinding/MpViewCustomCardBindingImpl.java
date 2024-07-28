package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.common.utility.DataBindingUtility;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;

public class MpViewCustomCardBindingImpl extends MpViewCustomCardBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public MpViewCustomCardBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    public MpViewCustomCardBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[5], objArr[0], objArr[2], objArr[1], objArr[4]);
        this.mDirtyFlags = -1;
        this.body.setTag((Object) null);
        this.cardCta.setTag((Object) null);
        this.cardRoot.setTag((Object) null);
        this.header.setTag((Object) null);
        this.icCard.setTag((Object) null);
        this.icCloseCard.setTag((Object) null);
        setRootTag(view);
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
        if (BR.model != i2) {
            return false;
        }
        setModel((CustomCardUIModel) obj);
        return true;
    }

    public void setModel(CustomCardUIModel customCardUIModel) {
        this.mModel = customCardUIModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String[] strArr;
        boolean z3;
        boolean z4;
        String str;
        String[] strArr2;
        boolean z5;
        String[] strArr3;
        boolean z6;
        int i2;
        String str2;
        int i3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CustomCardUIModel customCardUIModel = this.mModel;
        String str3 = null;
        int i5 = 0;
        int i6 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i6 == 0 || customCardUIModel == null) {
            str2 = null;
            strArr3 = null;
            strArr2 = null;
            str = null;
            strArr = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z6 = false;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        } else {
            i5 = customCardUIModel.getBodyColor();
            String[] headerParams = customCardUIModel.getHeaderParams();
            i3 = customCardUIModel.getHeaderColor();
            str2 = customCardUIModel.getHeaderText();
            i2 = customCardUIModel.getCtaColor();
            z6 = customCardUIModel.getShowSpanAtEnd();
            boolean closeable = customCardUIModel.getCloseable();
            z5 = customCardUIModel.isCtaVisible();
            strArr2 = customCardUIModel.getCtaParams();
            str = customCardUIModel.getCtaText();
            z4 = customCardUIModel.getToUnderlineCta();
            String bodyText = customCardUIModel.getBodyText();
            strArr = customCardUIModel.getBodyParams();
            boolean isIconVisible = customCardUIModel.isIconVisible();
            boolean arrowVisibleOnHeader = customCardUIModel.getArrowVisibleOnHeader();
            i4 = customCardUIModel.getIconId();
            z = closeable;
            z2 = isIconVisible;
            strArr3 = headerParams;
            str3 = bodyText;
            z3 = arrowVisibleOnHeader;
        }
        if (i6 != 0) {
            this.body.setTextColor(i5);
            DataBindingUtility.setTextWithParams(this.body, str3, strArr);
            DataBindingUtility.bindVisibility(this.cardCta, z5);
            DataBindingUtility.underlineText(this.cardCta, z4);
            this.cardCta.setTextColor(i2);
            DataBindingUtility.setTextWithParamsAndImage(this.cardCta, str, strArr2, z6, i4);
            this.header.setTextColor(i3);
            DataBindingUtility.setTextWithParamsAndImage(this.header, str2, strArr3, z3, i4);
            DataBindingUtility.bindVisibility(this.icCard, z2);
            DataBindingUtility.bindVisibility(this.icCloseCard, z);
        }
    }
}

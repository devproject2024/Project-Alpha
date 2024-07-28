package com.business.merchant_payments.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.b;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;

public class MpPaymentsSummaryLayoutBindingImpl extends MpPaymentsSummaryLayoutBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tp_header, 4);
        sViewsWithIds.put(R.id.rp_header, 5);
        sViewsWithIds.put(R.id.rp_icon, 6);
        sViewsWithIds.put(R.id.ta_header, 7);
        sViewsWithIds.put(R.id.divider, 8);
    }

    public MpPaymentsSummaryLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpPaymentsSummaryLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[8], objArr[2], objArr[5], objArr[6], objArr[7], objArr[3], objArr[1], objArr[4]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.rewardsPoints.setTag((Object) null);
        this.totalAmount.setTag((Object) null);
        this.totalPayments.setTag((Object) null);
        View view2 = view;
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
        setModel((PaymentsSummaryModel) obj);
        return true;
    }

    public void setModel(PaymentsSummaryModel paymentsSummaryModel) {
        this.mModel = paymentsSummaryModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        int i2;
        ConstraintLayout constraintLayout;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PaymentsSummaryModel paymentsSummaryModel = this.mModel;
        int i3 = 0;
        String str3 = null;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (paymentsSummaryModel != null) {
                i3 = paymentsSummaryModel.isNonMigrated();
                String rewardPoints = paymentsSummaryModel.getRewardPoints();
                str = paymentsSummaryModel.getTotalAmount();
                str2 = paymentsSummaryModel.getTotalPayments();
                str3 = rewardPoints;
            } else {
                str2 = null;
                str = null;
            }
            if (i4 != 0) {
                j |= i3 != 0 ? 8 : 4;
            }
            if (i3 != 0) {
                constraintLayout = this.mboundView0;
                i2 = R.color.color_ebf3fd;
            } else {
                constraintLayout = this.mboundView0;
                i2 = R.color.color_ffffff;
            }
            i3 = ViewDataBinding.getColorFromResource(constraintLayout, i2);
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 3) != 0) {
            androidx.databinding.a.e.a((View) this.mboundView0, (Drawable) b.a(i3));
            d.a(this.rewardsPoints, (CharSequence) str3);
            d.a(this.totalAmount, (CharSequence) str);
            d.a(this.totalPayments, (CharSequence) str2);
        }
    }
}

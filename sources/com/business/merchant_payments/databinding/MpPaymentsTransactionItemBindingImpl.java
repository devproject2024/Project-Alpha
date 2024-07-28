package com.business.merchant_payments.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.b;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DataBindingUtility;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;

public class MpPaymentsTransactionItemBindingImpl extends MpPaymentsTransactionItemBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;
    public final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public MpPaymentsTransactionItemBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpPaymentsTransactionItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[5], objArr[7], objArr[8], objArr[6], objArr[4], objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.amount.setTag((Object) null);
        this.cardMachineStatus.setTag((Object) null);
        this.divider.setTag((Object) null);
        this.icon.setTag((Object) null);
        this.ivInstantSettled.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        this.name.setTag((Object) null);
        this.time.setTag((Object) null);
        this.transactionRoot.setTag((Object) null);
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
        setModel((PaymentsTransactionModel) obj);
        return true;
    }

    public void setModel(PaymentsTransactionModel paymentsTransactionModel) {
        this.mModel = paymentsTransactionModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        long j2;
        boolean z;
        int i2;
        String str;
        int i3;
        String str2;
        int i4;
        int i5;
        String str3;
        int i6;
        String str4;
        boolean z2;
        boolean z3;
        int i7;
        int i8;
        TextView textView;
        boolean z4;
        String str5;
        String str6;
        boolean z5;
        String str7;
        OrderDetail orderDetail;
        String str8;
        boolean z6;
        int i9;
        View view;
        int i10;
        ConstraintLayout constraintLayout;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PaymentsTransactionModel paymentsTransactionModel = this.mModel;
        int i11 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i11 != 0) {
            if (paymentsTransactionModel != null) {
                z6 = paymentsTransactionModel.isDividerVisible();
                str8 = paymentsTransactionModel.getName();
                z = paymentsTransactionModel.isIncentive();
                orderDetail = paymentsTransactionModel.getOrderDetail();
                str7 = paymentsTransactionModel.getPayMethodUrl();
                z5 = paymentsTransactionModel.getBgEven();
                str6 = paymentsTransactionModel.getAmount();
                str5 = paymentsTransactionModel.getTime();
                z4 = paymentsTransactionModel.getCardErr();
            } else {
                z6 = false;
                str8 = null;
                z = false;
                orderDetail = null;
                str7 = null;
                z5 = false;
                str6 = null;
                str5 = null;
                z4 = false;
            }
            if (i11 != 0) {
                j |= z6 ? 128 : 64;
            }
            if ((j & 3) != 0) {
                if (z) {
                    j4 = j | 32;
                    j3 = 512;
                } else {
                    j4 = j | 16;
                    j3 = 256;
                }
                j = j4 | j3;
            }
            if ((j & 3) != 0) {
                j |= z5 ? 8192 : 4096;
            }
            if ((j & 3) != 0) {
                j |= z4 ? 8 : 4;
            }
            if (z6) {
                view = this.divider;
                i9 = R.color.color_ebf3fd;
            } else {
                view = this.divider;
                i9 = R.color.color_f5f9fe;
            }
            int colorFromResource = ViewDataBinding.getColorFromResource(view, i9);
            int i12 = z ? 2 : 1;
            if (z5) {
                constraintLayout = this.transactionRoot;
                i10 = R.color.color_ffffff;
            } else {
                constraintLayout = this.transactionRoot;
                i10 = R.color.color_f5f9fe;
            }
            int colorFromResource2 = ViewDataBinding.getColorFromResource(constraintLayout, i10);
            i3 = z4 ? 0 : 8;
            boolean equals = TextUtils.equals(orderDetail != null ? orderDetail.getTxnSettleType() : null, HomeRVAdapter.INSTANT_SETTLED_TXN);
            if ((j & 3) != 0) {
                j |= equals ? 2048 : 1024;
            }
            str2 = str8;
            if (equals) {
                i4 = i12;
                i2 = colorFromResource2;
                str3 = str7;
                str = str5;
                i5 = 0;
            } else {
                i4 = i12;
                i2 = colorFromResource2;
                str3 = str7;
                str = str5;
                i5 = 8;
            }
            i6 = colorFromResource;
            str4 = str6;
            j2 = 16;
        } else {
            j2 = 16;
            str4 = null;
            i6 = 0;
            str3 = null;
            i5 = 0;
            i4 = 0;
            str2 = null;
            i3 = 0;
            str = null;
            i2 = 0;
            z = false;
        }
        int i13 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
        if (i13 != 0) {
            if (paymentsTransactionModel != null) {
                z2 = paymentsTransactionModel.isRefund();
            } else {
                z2 = false;
            }
            if (i13 != 0) {
                j = z2 ? j | 131072 : j | 65536;
            }
        } else {
            z2 = false;
        }
        if ((j & 65536) == 0 || paymentsTransactionModel == null) {
            z3 = false;
        } else {
            z3 = paymentsTransactionModel.isChargeBack();
        }
        int i14 = ((j & 16) > 0 ? 1 : ((j & 16) == 0 ? 0 : -1));
        if (i14 != 0) {
            if (z2) {
                z3 = true;
            }
            if (i14 != 0) {
                j |= z3 ? 32768 : 16384;
            }
            if (z3) {
                textView = this.name;
                i8 = R.color.color_ff9d00;
            } else {
                textView = this.name;
                i8 = R.color.color_1d2f54;
            }
            i7 = ViewDataBinding.getColorFromResource(textView, i8);
        } else {
            i7 = 0;
        }
        int i15 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i15 == 0) {
            i7 = 0;
        } else if (z) {
            i7 = ViewDataBinding.getColorFromResource(this.name, R.color.color_21c17a);
        }
        if (i15 != 0) {
            d.a(this.amount, (CharSequence) str4);
            this.cardMachineStatus.setVisibility(i3);
            androidx.databinding.a.e.a(this.divider, (Drawable) b.a(i6));
            DataBindingUtility.loadPayMethodImage(this.icon, str3);
            this.ivInstantSettled.setVisibility(i5);
            this.name.setMaxLines(i4);
            d.a(this.name, (CharSequence) str2);
            this.name.setTextColor(i7);
            d.a(this.time, (CharSequence) str);
            androidx.databinding.a.e.a((View) this.transactionRoot, (Drawable) b.a(i2));
        }
    }
}

package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPVoucherRVViewHolder;

public class ClpVoucherItemBindingImpl extends ClpVoucherItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback37;
    private final View.OnClickListener mCallback38;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final View mboundView4;
    private final ImageView mboundView5;
    private final RelativeLayout mboundView7;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ClpVoucherItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    private ClpVoucherItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[6], objArr[3], objArr[2], objArr[8]);
        this.mDirtyFlags = -1;
        this.CashbackVal.setTag((Object) null);
        this.Price.setTag((Object) null);
        this.Storeled.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.mboundView7 = objArr[7];
        this.mboundView7.setTag((Object) null);
        this.viewMore.setTag((Object) null);
        setRootTag(view);
        this.mCallback37 = new OnClickListener(this, 1);
        this.mCallback38 = new OnClickListener(this, 2);
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
            setHolder((CLPVoucherRVViewHolder) obj);
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

    public void setHolder(CLPVoucherRVViewHolder cLPVoucherRVViewHolder) {
        this.mHolder = cLPVoucherRVViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.holder);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00c3 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00c3 }
            monitor-exit(r20)     // Catch:{ all -> 0x00c3 }
            com.paytmmall.clpartifact.modal.grid.CJRGridProduct r0 = r1.mProduct
            com.paytmmall.clpartifact.view.viewHolder.CLPVoucherRVViewHolder r6 = r1.mHolder
            r7 = 7
            long r9 = r2 & r7
            r11 = 6
            r13 = 5
            r15 = 0
            r16 = 0
            int r17 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0076
            long r9 = r2 & r13
            int r18 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x002e
            java.lang.String r9 = r0.getName()
            java.lang.String r10 = r0.getDiscountedPrice()
            goto L_0x0030
        L_0x002e:
            r9 = r15
            r10 = r9
        L_0x0030:
            java.lang.String r10 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r10)
            goto L_0x0037
        L_0x0035:
            r9 = r15
            r10 = r9
        L_0x0037:
            if (r6 == 0) goto L_0x0042
            java.lang.String r15 = r6.getCashback(r0)
            boolean r0 = r6.hasCashback(r0)
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            if (r17 == 0) goto L_0x004e
            if (r0 == 0) goto L_0x004a
            r17 = 16
            goto L_0x004c
        L_0x004a:
            r17 = 8
        L_0x004c:
            long r2 = r2 | r17
        L_0x004e:
            if (r0 == 0) goto L_0x0052
            r0 = 0
            goto L_0x0053
        L_0x0052:
            r0 = 4
        L_0x0053:
            long r17 = r2 & r11
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0079
            if (r6 == 0) goto L_0x0060
            boolean r6 = r6.isCollapsed()
            goto L_0x0061
        L_0x0060:
            r6 = 0
        L_0x0061:
            if (r19 == 0) goto L_0x006c
            if (r6 == 0) goto L_0x0068
            r17 = 64
            goto L_0x006a
        L_0x0068:
            r17 = 32
        L_0x006a:
            long r2 = r2 | r17
        L_0x006c:
            if (r6 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            r6 = 8
            r16 = 8
        L_0x0073:
            r6 = r16
            goto L_0x007a
        L_0x0076:
            r9 = r15
            r10 = r9
            r0 = 0
        L_0x0079:
            r6 = 0
        L_0x007a:
            long r7 = r7 & r2
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0093
            android.widget.TextView r7 = r1.CashbackVal
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r15)
            android.widget.TextView r7 = r1.CashbackVal
            r7.setVisibility(r0)
            android.view.View r7 = r1.mboundView4
            r7.setVisibility(r0)
            android.widget.ImageView r7 = r1.mboundView5
            r7.setVisibility(r0)
        L_0x0093:
            long r7 = r2 & r13
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a3
            android.widget.TextView r0 = r1.Price
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.TextView r0 = r1.Storeled
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x00a3:
            r7 = 4
            long r7 = r7 & r2
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b8
            android.widget.LinearLayout r0 = r1.mboundView1
            android.view.View$OnClickListener r7 = r1.mCallback37
            r0.setOnClickListener(r7)
            android.widget.TextView r0 = r1.viewMore
            android.view.View$OnClickListener r7 = r1.mCallback38
            r0.setOnClickListener(r7)
        L_0x00b8:
            long r2 = r2 & r11
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c2
            android.widget.RelativeLayout r0 = r1.mboundView7
            r0.setVisibility(r6)
        L_0x00c2:
            return
        L_0x00c3:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00c3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ClpVoucherItemBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CJRGridProduct cJRGridProduct = this.mProduct;
            CLPVoucherRVViewHolder cLPVoucherRVViewHolder = this.mHolder;
            if (cLPVoucherRVViewHolder != null) {
                z = true;
            }
            if (z) {
                cLPVoucherRVViewHolder.handleGridDeepLink(cJRGridProduct, cLPVoucherRVViewHolder.getAdapterPosition());
            }
        } else if (i2 == 2) {
            CLPVoucherRVViewHolder cLPVoucherRVViewHolder2 = this.mHolder;
            if (cLPVoucherRVViewHolder2 != null) {
                z = true;
            }
            if (z) {
                cLPVoucherRVViewHolder2.viewMore(view);
            }
        }
    }
}

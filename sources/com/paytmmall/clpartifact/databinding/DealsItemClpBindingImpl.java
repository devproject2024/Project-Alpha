package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.DealsItemViewHolder;

public class DealsItemClpBindingImpl extends DealsItemClpBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback12;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public DealsItemClpBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private DealsItemClpBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1], objArr[2], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.imageView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.mboundView7 = objArr[7];
        this.mboundView7.setTag((Object) null);
        this.textView.setTag((Object) null);
        this.textView2.setTag((Object) null);
        this.textView3.setTag((Object) null);
        setRootTag(view);
        this.mCallback12 = new OnClickListener(this, 1);
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
            setHolder((DealsItemViewHolder) obj);
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

    public void setHolder(DealsItemViewHolder dealsItemViewHolder) {
        this.mHolder = dealsItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.holder);
        super.requestRebind();
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r14v4, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00cc }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00cc }
            monitor-exit(r23)     // Catch:{ all -> 0x00cc }
            com.paytmmall.clpartifact.modal.grid.CJRGridProduct r0 = r1.mProduct
            com.paytmmall.clpartifact.view.viewHolder.DealsItemViewHolder r6 = r1.mHolder
            r7 = 7
            long r9 = r2 & r7
            r11 = 5
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0076
            long r9 = r2 & r11
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x002f
            java.lang.String r9 = r0.getName()
            java.lang.String r10 = r0.getActualPrice()
            java.lang.String r16 = r0.getBrand()
            goto L_0x0033
        L_0x002f:
            r9 = r14
            r10 = r9
            r16 = r10
        L_0x0033:
            java.lang.String r17 = com.paytmmall.clpartifact.common.StringUtils.getOfferV1Text((com.paytmmall.clpartifact.modal.grid.CJRGridProduct) r0)
            java.lang.String r18 = com.paytmmall.clpartifact.common.StringUtils.getOfferV1Subtext((com.paytmmall.clpartifact.modal.grid.CJRGridProduct) r0)
            boolean r19 = com.paytmmall.clpartifact.common.StringUtils.hasOfferV1(r0)
            if (r15 == 0) goto L_0x004a
            if (r19 == 0) goto L_0x0046
            r20 = 16
            goto L_0x0048
        L_0x0046:
            r20 = 8
        L_0x0048:
            long r2 = r2 | r20
        L_0x004a:
            java.lang.String r10 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r10)
            if (r19 == 0) goto L_0x0051
            goto L_0x005b
        L_0x0051:
            r13 = 4
            goto L_0x005b
        L_0x0053:
            r9 = r14
            r10 = r9
            r16 = r10
            r17 = r16
            r18 = r17
        L_0x005b:
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r0.getImageUrl()
            goto L_0x0063
        L_0x0062:
            r0 = r14
        L_0x0063:
            if (r6 == 0) goto L_0x0069
            android.content.Context r14 = r6.getContext()
        L_0x0069:
            r15 = r9
            r19 = r14
            r6 = r17
            r9 = r18
            r14 = r0
            r0 = r13
            r13 = r10
            r10 = r16
            goto L_0x007e
        L_0x0076:
            r6 = r14
            r9 = r6
            r10 = r9
            r13 = r10
            r15 = r13
            r19 = r15
            r0 = 0
        L_0x007e:
            long r7 = r7 & r2
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0095
            android.widget.ImageView r7 = r1.imageView
            r8 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r22 = r13
            r13 = r7
            r7 = r15
            r15 = r8
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r13, r14, r15, r16, r17, r18, r19)
            goto L_0x0098
        L_0x0095:
            r22 = r13
            r7 = r15
        L_0x0098:
            r13 = 4
            long r13 = r13 & r2
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00a6
            androidx.constraintlayout.widget.ConstraintLayout r8 = r1.mboundView0
            android.view.View$OnClickListener r13 = r1.mCallback12
            r8.setOnClickListener(r13)
        L_0x00a6:
            long r2 = r2 & r11
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00cb
            android.widget.LinearLayout r2 = r1.mboundView5
            r2.setVisibility(r0)
            android.widget.TextView r0 = r1.mboundView6
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.mboundView7
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.textView
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.TextView r0 = r1.textView2
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.textView3
            r10 = r22
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x00cb:
            return
        L_0x00cc:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x00cc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.DealsItemClpBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CJRGridProduct cJRGridProduct = this.mProduct;
        DealsItemViewHolder dealsItemViewHolder = this.mHolder;
        if (dealsItemViewHolder != null) {
            dealsItemViewHolder.handleGridDeepLink(cJRGridProduct, dealsItemViewHolder.getAdapterPosition());
        }
    }
}

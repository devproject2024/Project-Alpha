package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public class ItemPortrait3xnBindingImpl extends ItemPortrait3xnBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemPortrait3xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, sIncludes, sViewsWithIds));
    }

    private ItemPortrait3xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0]);
        this.mDirtyFlags = -1;
        this.one.setTag((Object) null);
        setRootTag(view);
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
            setHandler((CLPItemRVViewHolder) obj);
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

    public void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder) {
        this.mHandler = cLPItemRVViewHolder;
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

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x008f }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x008f }
            monitor-exit(r18)     // Catch:{ all -> 0x008f }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            java.lang.Integer r7 = r1.mPosition
            r8 = 15
            long r10 = r2 & r8
            r12 = 11
            r14 = 9
            r8 = 0
            r9 = 0
            int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0064
            long r10 = r2 & r14
            int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x002b
            java.lang.String r10 = r0.getImageUrl()
            goto L_0x002c
        L_0x002b:
            r10 = r9
        L_0x002c:
            if (r10 == 0) goto L_0x0030
            r10 = 1
            goto L_0x0031
        L_0x0030:
            r10 = 0
        L_0x0031:
            if (r16 == 0) goto L_0x003c
            if (r10 == 0) goto L_0x0038
            r16 = 32
            goto L_0x003a
        L_0x0038:
            r16 = 16
        L_0x003a:
            long r2 = r2 | r16
        L_0x003c:
            if (r10 == 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r10 = 8
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            long r16 = r2 & r12
            int r11 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0054
            if (r6 == 0) goto L_0x0054
            java.lang.String r11 = r6.getRequestId()
            android.content.Context r16 = r6.getContext()
            goto L_0x0057
        L_0x0054:
            r11 = r9
            r16 = r11
        L_0x0057:
            int r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            if (r6 == 0) goto L_0x0061
            com.paytm.ads.PaytmAdView$a r9 = r6.getAdClickListener(r0, r7)
        L_0x0061:
            r6 = r16
            goto L_0x0067
        L_0x0064:
            r6 = r9
            r11 = r6
            r10 = 0
        L_0x0067:
            long r14 = r14 & r2
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0071
            com.paytm.ads.PaytmAdView r7 = r1.one
            r7.setVisibility(r10)
        L_0x0071:
            r14 = 15
            long r14 = r14 & r2
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x007d
            com.paytm.ads.PaytmAdView r7 = r1.one
            r7.setOnClickListener(r9)
        L_0x007d:
            long r2 = r2 & r12
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x008e
            com.paytm.ads.PaytmAdView r2 = r1.one
            r3 = 21
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImagePostMeasure(r2, r0, r3, r8, r6)
            com.paytm.ads.PaytmAdView r2 = r1.one
            com.paytmmall.clpartifact.view.viewbindings.AddviewBindings.setAddView(r2, r0, r11)
        L_0x008e:
            return
        L_0x008f:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x008f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemPortrait3xnBindingImpl.executeBindings():void");
    }
}

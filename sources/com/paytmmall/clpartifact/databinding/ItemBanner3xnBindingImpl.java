package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public class ItemBanner3xnBindingImpl extends ItemBanner3xnBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemBanner3xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemBanner3xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1]);
        this.mDirtyFlags = -1;
        this.avatar.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0069 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0069 }
            monitor-exit(r21)     // Catch:{ all -> 0x0069 }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            java.lang.Integer r7 = r1.mPosition
            r8 = 15
            long r8 = r8 & r2
            r10 = 11
            r12 = 0
            int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0046
            long r8 = r2 & r10
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0027
            java.lang.String r8 = r0.getImageUrl()
            goto L_0x0028
        L_0x0027:
            r8 = r12
        L_0x0028:
            if (r6 == 0) goto L_0x0033
            java.lang.String r9 = r6.getRequestId()
            android.content.Context r14 = r6.getContext()
            goto L_0x0038
        L_0x0033:
            r9 = r12
            goto L_0x0037
        L_0x0035:
            r8 = r12
            r9 = r8
        L_0x0037:
            r14 = r9
        L_0x0038:
            int r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            if (r6 == 0) goto L_0x0042
            com.paytm.ads.PaytmAdView$a r12 = r6.getAdClickListener(r0, r7)
        L_0x0042:
            r15 = r8
            r20 = r14
            goto L_0x004a
        L_0x0046:
            r9 = r12
            r15 = r9
            r20 = r15
        L_0x004a:
            if (r13 == 0) goto L_0x0051
            com.paytm.ads.PaytmAdView r6 = r1.avatar
            r6.setOnClickListener(r12)
        L_0x0051:
            long r2 = r2 & r10
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0068
            com.paytm.ads.PaytmAdView r14 = r1.avatar
            r16 = 4
            r17 = 1
            r18 = 0
            r19 = 0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r14, r15, r16, r17, r18, r19, r20)
            com.paytm.ads.PaytmAdView r2 = r1.avatar
            com.paytmmall.clpartifact.view.viewbindings.AddviewBindings.setAddView(r2, r0, r9)
        L_0x0068:
            return
        L_0x0069:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x0069 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemBanner3xnBindingImpl.executeBindings():void");
    }
}

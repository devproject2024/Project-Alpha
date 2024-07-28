package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridFoodViewHolder;

public class ClpFoodItemBindingImpl extends ClpFoodItemBinding {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(10);
        sIncludes = bVar;
        bVar.a(1, new String[]{"layout_add_to_cart", "layout_edit_cart"}, new int[]{2, 3}, new int[]{R.layout.layout_add_to_cart, R.layout.layout_edit_cart});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.food_tag, 4);
        sViewsWithIds.put(R.id.item_name, 5);
        sViewsWithIds.put(R.id.item_description, 6);
        sViewsWithIds.put(R.id.offer_price, 7);
        sViewsWithIds.put(R.id.actual_price, 8);
        sViewsWithIds.put(R.id.discount_percent, 9);
    }

    public ClpFoodItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ClpFoodItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[8], objArr[1], objArr[2], objArr[9], objArr[3], objArr[4], objArr[6], objArr[5], objArr[7]);
        this.mDirtyFlags = -1;
        this.addToCartContainer.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.addToCartLayout.invalidateAll();
        this.editCartLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.editCartLayout.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.addToCartLayout.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            com.paytmmall.clpartifact.databinding.LayoutAddToCartBinding r0 = r6.addToCartLayout
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.paytmmall.clpartifact.databinding.LayoutEditCartBinding r0 = r6.editCartLayout
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ClpFoodItemBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.item == i2) {
            setItem((CJRGridProduct) obj);
        } else if (BR.holder != i2) {
            return false;
        } else {
            setHolder((CLPInfiniteGridFoodViewHolder) obj);
        }
        return true;
    }

    public void setItem(CJRGridProduct cJRGridProduct) {
        this.mItem = cJRGridProduct;
    }

    public void setHolder(CLPInfiniteGridFoodViewHolder cLPInfiniteGridFoodViewHolder) {
        this.mHolder = cLPInfiniteGridFoodViewHolder;
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.addToCartLayout.setLifecycleOwner(qVar);
        this.editCartLayout.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeAddToCartLayout((LayoutAddToCartBinding) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeEditCartLayout((LayoutEditCartBinding) obj, i3);
    }

    private boolean onChangeAddToCartLayout(LayoutAddToCartBinding layoutAddToCartBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeEditCartLayout(LayoutEditCartBinding layoutEditCartBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.addToCartLayout);
        executeBindingsOn(this.editCartLayout);
    }
}

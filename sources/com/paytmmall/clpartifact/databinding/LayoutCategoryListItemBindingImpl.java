package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;

public class LayoutCategoryListItemBindingImpl extends LayoutCategoryListItemBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.grid_container_1, 5);
        sViewsWithIds.put(R.id.first_item_image_container, 6);
    }

    public LayoutCategoryListItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private LayoutCategoryListItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[4], objArr[6], objArr[5], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.categoryIcon.setTag((Object) null);
        this.categoryTitle.setTag((Object) null);
        this.icRaises.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvLabel.setTag((Object) null);
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
        if (BR.imageUrl == i2) {
            setImageUrl((String) obj);
        } else if (BR.label == i2) {
            setLabel((String) obj);
        } else if (BR.name != i2) {
            return false;
        } else {
            setName((String) obj);
        }
        return true;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.imageUrl);
        super.requestRebind();
    }

    public void setLabel(String str) {
        this.mLabel = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.label);
        super.requestRebind();
    }

    public void setName(String str) {
        this.mName = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.name);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ad }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ad }
            monitor-exit(r22)     // Catch:{ all -> 0x00ad }
            java.lang.String r7 = r1.mImageUrl
            java.lang.String r0 = r1.mLabel
            java.lang.String r13 = r1.mName
            r8 = 9
            long r10 = r2 & r8
            r6 = 4
            r12 = 0
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x002c
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r14 == 0) goto L_0x0028
            if (r10 == 0) goto L_0x0025
            r14 = 128(0x80, double:6.32E-322)
            goto L_0x0027
        L_0x0025:
            r14 = 64
        L_0x0027:
            long r2 = r2 | r14
        L_0x0028:
            if (r10 == 0) goto L_0x002c
            r10 = 4
            goto L_0x002d
        L_0x002c:
            r10 = 0
        L_0x002d:
            r14 = 10
            long r16 = r2 & r14
            int r11 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0048
            boolean r16 = android.text.TextUtils.isEmpty(r0)
            if (r11 == 0) goto L_0x0044
            if (r16 == 0) goto L_0x0040
            r17 = 512(0x200, double:2.53E-321)
            goto L_0x0042
        L_0x0040:
            r17 = 256(0x100, double:1.265E-321)
        L_0x0042:
            long r2 = r2 | r17
        L_0x0044:
            if (r16 == 0) goto L_0x0048
            r11 = 4
            goto L_0x0049
        L_0x0048:
            r11 = 0
        L_0x0049:
            r16 = 12
            long r18 = r2 & r16
            int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0063
            boolean r18 = android.text.TextUtils.isEmpty(r13)
            if (r20 == 0) goto L_0x0060
            if (r18 == 0) goto L_0x005c
            r19 = 32
            goto L_0x005e
        L_0x005c:
            r19 = 16
        L_0x005e:
            long r2 = r2 | r19
        L_0x0060:
            if (r18 == 0) goto L_0x0063
            r12 = 4
        L_0x0063:
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0081
            android.widget.ImageView r6 = r1.categoryIcon
            r6.setVisibility(r10)
            android.widget.ImageView r6 = r1.categoryIcon
            r8 = 0
            r9 = 0
            r10 = 0
            r18 = 0
            r19 = 0
            r21 = r11
            r11 = r18
            r14 = r12
            r12 = r19
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0084
        L_0x0081:
            r21 = r11
            r14 = r12
        L_0x0084:
            long r6 = r2 & r16
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0094
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r6 = r1.categoryTitle
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r6 = r1.categoryTitle
            r6.setVisibility(r14)
        L_0x0094:
            r6 = 10
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ac
            android.widget.ImageView r2 = r1.icRaises
            r11 = r21
            r2.setVisibility(r11)
            android.widget.TextView r2 = r1.tvLabel
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.tvLabel
            r0.setVisibility(r11)
        L_0x00ac:
            return
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00ad }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.LayoutCategoryListItemBindingImpl.executeBindings():void");
    }
}

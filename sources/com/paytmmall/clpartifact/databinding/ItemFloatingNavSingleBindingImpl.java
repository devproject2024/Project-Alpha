package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH;

public class ItemFloatingNavSingleBindingImpl extends ItemFloatingNavSingleBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback58;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemFloatingNavSingleBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemFloatingNavSingleBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.dot.setTag((Object) null);
        this.groupImageView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback58 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
            setHandler((FabBaseVH) obj);
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

    public void setHandler(FabBaseVH fabBaseVH) {
        this.mHandler = fabBaseVH;
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
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 != BR.notificationActive) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ca }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ca }
            monitor-exit(r24)     // Catch:{ all -> 0x00ca }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.widgets.component.viewholder.FabBaseVH r6 = r1.mHandler
            r7 = 27
            long r7 = r7 & r2
            r9 = 17
            r11 = 25
            r13 = 19
            r15 = 0
            r16 = 0
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x007f
            long r7 = r2 & r13
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x002b
            if (r0 == 0) goto L_0x002b
            java.lang.String r7 = r0.getImageUrl()
            goto L_0x002c
        L_0x002b:
            r7 = r15
        L_0x002c:
            long r17 = r2 & r9
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0039
            java.lang.String r17 = r0.getTitle()
            goto L_0x003b
        L_0x0039:
            r17 = r15
        L_0x003b:
            boolean r18 = android.text.TextUtils.isEmpty(r17)
            r18 = r18 ^ 1
            if (r8 == 0) goto L_0x004c
            if (r18 == 0) goto L_0x0048
            r19 = 256(0x100, double:1.265E-321)
            goto L_0x004a
        L_0x0048:
            r19 = 128(0x80, double:6.32E-322)
        L_0x004a:
            long r2 = r2 | r19
        L_0x004c:
            if (r18 == 0) goto L_0x004f
            goto L_0x0054
        L_0x004f:
            r8 = 8
            goto L_0x0055
        L_0x0052:
            r17 = r15
        L_0x0054:
            r8 = 0
        L_0x0055:
            long r18 = r2 & r11
            int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0062
            boolean r0 = r0.isNotificationActive()
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            if (r20 == 0) goto L_0x006e
            if (r0 == 0) goto L_0x006a
            r18 = 64
            goto L_0x006c
        L_0x006a:
            r18 = 32
        L_0x006c:
            long r2 = r2 | r18
        L_0x006e:
            if (r0 == 0) goto L_0x0071
            goto L_0x0074
        L_0x0071:
            r0 = 4
            r16 = 4
        L_0x0074:
            r0 = r16
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            r23 = r17
            r17 = r7
            r7 = r23
            goto L_0x0084
        L_0x007f:
            r7 = r15
            r17 = r7
            r0 = 0
            r8 = 0
        L_0x0084:
            long r13 = r13 & r2
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x008f
            if (r6 == 0) goto L_0x008f
            android.content.Context r15 = r6.getContext()
        L_0x008f:
            r22 = r15
            long r11 = r11 & r2
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x009b
            android.view.View r6 = r1.dot
            r6.setVisibility(r0)
        L_0x009b:
            if (r16 == 0) goto L_0x00ac
            android.widget.ImageView r0 = r1.groupImageView
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r16 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r16, r17, r18, r19, r20, r21, r22)
        L_0x00ac:
            r11 = 16
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ba
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.mboundView0
            android.view.View$OnClickListener r6 = r1.mCallback58
            r0.setOnClickListener(r6)
        L_0x00ba:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c9
            android.widget.TextView r0 = r1.tvLabel
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.tvLabel
            r0.setVisibility(r8)
        L_0x00c9:
            return
        L_0x00ca:
            r0 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x00ca }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemFloatingNavSingleBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        FabBaseVH fabBaseVH = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (fabBaseVH != null) {
            fabBaseVH.handleDeepLink(view, item, num.intValue());
        }
    }
}

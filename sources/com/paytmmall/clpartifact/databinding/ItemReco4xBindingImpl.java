package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem4X;

public class ItemReco4xBindingImpl extends ItemReco4xBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback7;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mainLayoutReco, 6);
        sViewsWithIds.put(R.id.close_icon, 7);
    }

    public ItemReco4xBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemReco4xBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[5], objArr[7], objArr[1], objArr[6], objArr[2], objArr[0], objArr[4]);
        this.mDirtyFlags = -1;
        this.categoryTitle.setTag((Object) null);
        this.categorycta.setTag((Object) null);
        this.groupImageView.setTag((Object) null);
        this.recoLabel.setTag((Object) null);
        this.recoLayoutContainer.setTag((Object) null);
        this.subtitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback7 = new OnClickListener(this, 1);
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
            setHandler((CLPCarouselItem4X) obj);
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

    public void setHandler(CLPCarouselItem4X cLPCarouselItem4X) {
        this.mHandler = cLPCarouselItem4X;
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

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0111 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0111 }
            monitor-exit(r24)     // Catch:{ all -> 0x0111 }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem4X r6 = r1.mHandler
            r7 = 11
            long r9 = r2 & r7
            r11 = 9
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00c3
            if (r0 == 0) goto L_0x0021
            java.lang.String r9 = r0.getImageUrl()
            goto L_0x0022
        L_0x0021:
            r9 = r13
        L_0x0022:
            if (r6 == 0) goto L_0x0029
            android.content.Context r6 = r6.getContext()
            goto L_0x002a
        L_0x0029:
            r6 = r13
        L_0x002a:
            long r15 = r2 & r11
            int r10 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x0043
            java.lang.String r15 = r0.getItemSubtitle()
            java.lang.String r16 = r0.getTitle()
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r17 = r0.getCta()
            java.lang.String r0 = r0.getName()
            goto L_0x0049
        L_0x0043:
            r0 = r13
            r15 = r0
            r16 = r15
            r17 = r16
        L_0x0049:
            boolean r18 = android.text.TextUtils.isEmpty(r15)
            boolean r19 = android.text.TextUtils.isEmpty(r16)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r10 == 0) goto L_0x0060
            if (r18 == 0) goto L_0x005c
            r20 = 32
            goto L_0x005e
        L_0x005c:
            r20 = 16
        L_0x005e:
            long r2 = r2 | r20
        L_0x0060:
            long r20 = r2 & r11
            int r10 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x006f
            if (r19 == 0) goto L_0x006b
            r20 = 512(0x200, double:2.53E-321)
            goto L_0x006d
        L_0x006b:
            r20 = 256(0x100, double:1.265E-321)
        L_0x006d:
            long r2 = r2 | r20
        L_0x006f:
            long r20 = r2 & r11
            int r10 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x007e
            if (r0 == 0) goto L_0x007a
            r20 = 128(0x80, double:6.32E-322)
            goto L_0x007c
        L_0x007a:
            r20 = 64
        L_0x007c:
            long r2 = r2 | r20
        L_0x007e:
            if (r17 == 0) goto L_0x0084
            java.lang.String r13 = r17.getLabel()
        L_0x0084:
            r10 = 8
            if (r18 == 0) goto L_0x008b
            r17 = 8
            goto L_0x008d
        L_0x008b:
            r17 = 0
        L_0x008d:
            if (r19 == 0) goto L_0x0092
            r18 = 8
            goto L_0x0094
        L_0x0092:
            r18 = 0
        L_0x0094:
            if (r0 == 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r10 = 0
        L_0x0098:
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            long r19 = r2 & r11
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x00a7
            r19 = 2048(0x800, double:1.0118E-320)
            goto L_0x00a9
        L_0x00a7:
            r19 = 1024(0x400, double:5.06E-321)
        L_0x00a9:
            long r2 = r2 | r19
        L_0x00ab:
            if (r0 == 0) goto L_0x00af
            r0 = 4
            r14 = 4
        L_0x00af:
            r23 = r6
            r22 = r9
            r0 = r13
            r6 = r14
            r13 = r16
            r9 = r17
            r14 = r18
            goto L_0x00cc
        L_0x00bc:
            r23 = r6
            r22 = r9
            r0 = r13
            r15 = r0
            goto L_0x00c9
        L_0x00c3:
            r0 = r13
            r15 = r0
            r22 = r15
            r23 = r22
        L_0x00c9:
            r6 = 0
            r9 = 0
            r10 = 0
        L_0x00cc:
            long r11 = r11 & r2
            int r16 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00f4
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r11 = r1.categoryTitle
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r11 = r1.categoryTitle
            r11.setVisibility(r14)
            android.widget.TextView r11 = r1.categorycta
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.categorycta
            r0.setVisibility(r6)
            android.widget.TextView r0 = r1.recoLabel
            r0.setVisibility(r10)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.subtitle
            r0.setVisibility(r9)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.subtitle
            r0.setText(r15)
        L_0x00f4:
            r9 = 8
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0102
            android.widget.TextView r0 = r1.categorycta
            android.view.View$OnClickListener r6 = r1.mCallback7
            r0.setOnClickListener(r6)
        L_0x0102:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0110
            android.widget.ImageView r0 = r1.groupImageView
            r9 = r22
            r6 = r23
            com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings.setCircularImage(r0, r9, r6)
        L_0x0110:
            return
        L_0x0111:
            r0 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x0111 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemReco4xBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPCarouselItem4X cLPCarouselItem4X = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (cLPCarouselItem4X != null) {
            cLPCarouselItem4X.handleDeepLink(item, num.intValue());
        }
    }
}

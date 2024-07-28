package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;

public class ItemRowBindingImpl extends ItemRowBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final ImageView mboundView10;
    private final CLPRobotoTextView mboundView4;
    private final CLPRobotoTextView mboundView5;
    private final CLPRobotoTextView mboundView6;
    private final TextView mboundView8;
    private final LinearLayout mboundView9;

    public ItemRowBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemRowBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[11], objArr[3], objArr[2], objArr[7], objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.badgeTV.setTag((Object) null);
        this.caption.setTag((Object) null);
        this.itemAddTag.setTag((Object) null);
        this.mboundView10 = objArr[10];
        this.mboundView10.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.mboundView8 = objArr[8];
        this.mboundView8.setTag((Object) null);
        this.mboundView9 = objArr[9];
        this.mboundView9.setTag((Object) null);
        this.offerText.setTag((Object) null);
        this.parentLayout.setTag((Object) null);
        this.rowImage.setTag((Object) null);
        setRootTag(view);
        this.mCallback9 = new OnClickListener(this, 1);
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

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r35 = this;
            r1 = r35
            monitor-enter(r35)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01cd }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01cd }
            monitor-exit(r35)     // Catch:{ all -> 0x01cd }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            r7 = 11
            long r9 = r2 & r7
            r11 = 9
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x012c
            if (r0 == 0) goto L_0x0021
            java.lang.String r9 = r0.getImageUrl()
            goto L_0x0022
        L_0x0021:
            r9 = r13
        L_0x0022:
            if (r6 == 0) goto L_0x0049
            java.lang.String r10 = r6.getOfferSubText(r0)
            java.lang.String r16 = r6.getBadgeText(r0)
            boolean r17 = r6.hasOfferText(r0)
            boolean r18 = r6.hasSubOfferText(r0)
            boolean r19 = r6.hasBadge(r0)
            java.lang.String r20 = r6.getBadgeUrl(r0)
            int r21 = r6.getPromoTextColor(r0)
            android.content.Context r22 = r6.getContext()
            java.lang.String r6 = r6.getOfferText(r0)
            goto L_0x0059
        L_0x0049:
            r6 = r13
            r10 = r6
            r16 = r10
            r20 = r16
            r22 = r20
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
        L_0x0059:
            if (r15 == 0) goto L_0x0064
            if (r17 == 0) goto L_0x0060
            r23 = 32
            goto L_0x0062
        L_0x0060:
            r23 = 16
        L_0x0062:
            long r2 = r2 | r23
        L_0x0064:
            long r23 = r2 & r7
            int r15 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0073
            if (r18 == 0) goto L_0x006f
            r23 = 512(0x200, double:2.53E-321)
            goto L_0x0071
        L_0x006f:
            r23 = 256(0x100, double:1.265E-321)
        L_0x0071:
            long r2 = r2 | r23
        L_0x0073:
            long r23 = r2 & r7
            int r15 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0082
            if (r19 == 0) goto L_0x007e
            r23 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0080
        L_0x007e:
            r23 = 4096(0x1000, double:2.0237E-320)
        L_0x0080:
            long r2 = r2 | r23
        L_0x0082:
            r15 = 8
            if (r17 == 0) goto L_0x0089
            r17 = 0
            goto L_0x008b
        L_0x0089:
            r17 = 8
        L_0x008b:
            if (r18 == 0) goto L_0x0090
            r18 = 0
            goto L_0x0092
        L_0x0090:
            r18 = 8
        L_0x0092:
            if (r19 == 0) goto L_0x0097
            r19 = 0
            goto L_0x0099
        L_0x0097:
            r19 = 8
        L_0x0099:
            long r23 = r2 & r11
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x0113
            if (r0 == 0) goto L_0x00ba
            java.lang.String r13 = r0.getActualPrice()
            java.lang.String r23 = r0.getOfferPrice()
            boolean r24 = r0.isDiscounted()
            java.lang.String r26 = r0.getDiscount()
            java.lang.String r27 = r0.getName()
            boolean r0 = r0.getSponsored()
            goto L_0x00c3
        L_0x00ba:
            r23 = r13
            r26 = r23
            r27 = r26
            r0 = 0
            r24 = 0
        L_0x00c3:
            if (r25 == 0) goto L_0x00ce
            if (r24 == 0) goto L_0x00ca
            r28 = 128(0x80, double:6.32E-322)
            goto L_0x00cc
        L_0x00ca:
            r28 = 64
        L_0x00cc:
            long r2 = r2 | r28
        L_0x00ce:
            long r28 = r2 & r11
            int r25 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x00dd
            if (r0 == 0) goto L_0x00d9
            r28 = 2048(0x800, double:1.0118E-320)
            goto L_0x00db
        L_0x00d9:
            r28 = 1024(0x400, double:5.06E-321)
        L_0x00db:
            long r2 = r2 | r28
        L_0x00dd:
            java.lang.String r13 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r13)
            java.lang.String r23 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r23)
            if (r24 == 0) goto L_0x00ea
            r24 = 0
            goto L_0x00ec
        L_0x00ea:
            r24 = 8
        L_0x00ec:
            java.lang.String r25 = com.paytmmall.clpartifact.common.StringUtils.getOfferText(r26)
            if (r0 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r14 = 8
        L_0x00f5:
            r33 = r13
            r30 = r14
            r13 = r16
            r0 = r18
            r15 = r20
            r11 = r21
            r29 = r22
            r31 = r23
            r32 = r24
            r34 = r25
            r12 = r27
            r14 = r6
            r24 = r9
            r9 = r17
            r6 = r19
            goto L_0x0142
        L_0x0113:
            r14 = r6
            r24 = r9
            r12 = r13
            r31 = r12
            r33 = r31
            r34 = r33
            r13 = r16
            r9 = r17
            r0 = r18
            r6 = r19
            r15 = r20
            r11 = r21
            r29 = r22
            goto L_0x013e
        L_0x012c:
            r10 = r13
            r12 = r10
            r14 = r12
            r15 = r14
            r24 = r15
            r29 = r24
            r31 = r29
            r33 = r31
            r34 = r33
            r0 = 0
            r6 = 0
            r9 = 0
            r11 = 0
        L_0x013e:
            r30 = 0
            r32 = 0
        L_0x0142:
            long r7 = r7 & r2
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x018a
            android.widget.TextView r7 = r1.badgeTV
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r13)
            android.widget.ImageView r7 = r1.mboundView10
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r13 = r14
            r14 = r7
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r14, r15, r16, r17, r18, r19, r20)
            android.widget.TextView r7 = r1.mboundView8
            r7.setVisibility(r0)
            android.widget.TextView r0 = r1.mboundView8
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.LinearLayout r0 = r1.mboundView9
            r0.setVisibility(r6)
            android.widget.TextView r0 = r1.offerText
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.offerText
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.offerText
            r0.setTextColor(r11)
            android.widget.ImageView r0 = r1.rowImage
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r23 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r23, r24, r25, r26, r27, r28, r29)
        L_0x018a:
            r6 = 9
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.caption
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.widget.TextView r0 = r1.itemAddTag
            r14 = r30
            r0.setVisibility(r14)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView4
            r13 = r31
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView5
            r14 = r32
            r0.setVisibility(r14)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView5
            r13 = r33
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView6
            r0.setVisibility(r14)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.mboundView6
            r13 = r34
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x01be:
            r6 = 8
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01cc
            android.widget.ImageView r0 = r1.rowImage
            android.view.View$OnClickListener r2 = r1.mCallback9
            r0.setOnClickListener(r2)
        L_0x01cc:
            return
        L_0x01cd:
            r0 = move-exception
            monitor-exit(r35)     // Catch:{ all -> 0x01cd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRowBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (cLPItemRVViewHolder != null) {
            cLPItemRVViewHolder.handleDeepLink(item, num.intValue());
        }
    }
}

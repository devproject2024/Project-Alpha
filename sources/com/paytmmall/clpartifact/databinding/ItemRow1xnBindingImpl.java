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

public class ItemRow1xnBindingImpl extends ItemRow1xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback50;
    private final View.OnClickListener mCallback51;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView11;
    private final LinearLayout mboundView12;
    private final ImageView mboundView13;
    private final CLPRobotoTextView mboundView4;

    public ItemRow1xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemRow1xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[14], objArr[3], objArr[10], objArr[1], objArr[7], objArr[9], objArr[2], objArr[8], objArr[6], objArr[5]);
        this.mDirtyFlags = -1;
        this.badgeTV.setTag((Object) null);
        this.itemAddTag.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView11 = objArr[11];
        this.mboundView11.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView13 = objArr[13];
        this.mboundView13.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.offerText.setTag((Object) null);
        this.parentLayout.setTag((Object) null);
        this.row1xnCost.setTag((Object) null);
        this.row1xnDiscount.setTag((Object) null);
        this.row1xnImage.setTag((Object) null);
        this.row1xnOriginalCost.setTag((Object) null);
        this.row1xnText.setTag((Object) null);
        this.wishlistIcon.setTag((Object) null);
        setRootTag(view);
        this.mCallback50 = new OnClickListener(this, 1);
        this.mCallback51 = new OnClickListener(this, 2);
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
            setHandler((CLPItemRVViewHolder) obj);
        } else if (BR.isWishListed == i2) {
            setIsWishListed((Boolean) obj);
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

    public void setIsWishListed(Boolean bool) {
        this.mIsWishListed = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.isWishListed);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 8;
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

    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x024b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r39 = this;
            r1 = r39
            monitor-enter(r39)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0251 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0251 }
            monitor-exit(r39)     // Catch:{ all -> 0x0251 }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            java.lang.Boolean r7 = r1.mIsWishListed
            r8 = 19
            long r10 = r2 & r8
            r12 = 17
            int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0167
            if (r0 == 0) goto L_0x0021
            java.lang.String r10 = r0.getImageUrl()
            goto L_0x0022
        L_0x0021:
            r10 = 0
        L_0x0022:
            if (r6 == 0) goto L_0x0049
            java.lang.String r11 = r6.getOfferSubText(r0)
            java.lang.String r17 = r6.getBadgeText(r0)
            boolean r18 = r6.hasOfferText(r0)
            boolean r19 = r6.hasSubOfferText(r0)
            boolean r20 = r6.hasBadge(r0)
            java.lang.String r21 = r6.getBadgeUrl(r0)
            int r22 = r6.getPromoTextColor(r0)
            android.content.Context r23 = r6.getContext()
            java.lang.String r6 = r6.getOfferText(r0)
            goto L_0x0059
        L_0x0049:
            r6 = 0
            r11 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0059:
            if (r16 == 0) goto L_0x0064
            if (r18 == 0) goto L_0x0060
            r24 = 64
            goto L_0x0062
        L_0x0060:
            r24 = 32
        L_0x0062:
            long r2 = r2 | r24
        L_0x0064:
            long r24 = r2 & r8
            int r16 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0073
            if (r19 == 0) goto L_0x006f
            r24 = 1024(0x400, double:5.06E-321)
            goto L_0x0071
        L_0x006f:
            r24 = 512(0x200, double:2.53E-321)
        L_0x0071:
            long r2 = r2 | r24
        L_0x0073:
            long r24 = r2 & r8
            int r16 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0084
            if (r20 == 0) goto L_0x007f
            r24 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0082
        L_0x007f:
            r24 = 32768(0x8000, double:1.61895E-319)
        L_0x0082:
            long r2 = r2 | r24
        L_0x0084:
            r16 = 8
            if (r18 == 0) goto L_0x008b
            r18 = 0
            goto L_0x008d
        L_0x008b:
            r18 = 8
        L_0x008d:
            if (r19 == 0) goto L_0x0092
            r19 = 0
            goto L_0x0094
        L_0x0092:
            r19 = 8
        L_0x0094:
            if (r20 == 0) goto L_0x0099
            r20 = 0
            goto L_0x009b
        L_0x0099:
            r20 = 8
        L_0x009b:
            long r24 = r2 & r12
            int r26 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x014d
            if (r0 == 0) goto L_0x00ba
            java.lang.String r24 = r0.getMactualPrice()
            java.lang.String r14 = r0.mDiscount
            java.lang.String r27 = r0.getMofferPrice()
            java.lang.String r28 = r0.getmBrand()
            java.lang.String r29 = r0.getName()
            boolean r0 = r0.getSponsored()
            goto L_0x00c4
        L_0x00ba:
            r0 = 0
            r14 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
        L_0x00c4:
            if (r26 == 0) goto L_0x00cf
            if (r0 == 0) goto L_0x00cb
            r30 = 16384(0x4000, double:8.0948E-320)
            goto L_0x00cd
        L_0x00cb:
            r30 = 8192(0x2000, double:4.0474E-320)
        L_0x00cd:
            long r2 = r2 | r30
        L_0x00cf:
            java.lang.String r24 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r24)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r14)
            java.lang.String r8 = "%"
            r15.append(r8)
            java.lang.String r8 = r15.toString()
            java.lang.String r9 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r27)
            if (r0 == 0) goto L_0x00ec
            r15 = 0
            goto L_0x00ee
        L_0x00ec:
            r15 = 8
        L_0x00ee:
            if (r14 == 0) goto L_0x00f7
            java.lang.String r0 = "0"
            boolean r0 = r14.equals(r0)
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            long r32 = r2 & r12
            int r14 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0107
            if (r0 == 0) goto L_0x0103
            r32 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0105
        L_0x0103:
            r32 = 2048(0x800, double:1.0118E-320)
        L_0x0105:
            long r2 = r2 | r32
        L_0x0107:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r8)
            java.lang.String r8 = " "
            r14.append(r8)
            java.lang.String r8 = r14.toString()
            if (r0 == 0) goto L_0x011b
            goto L_0x011d
        L_0x011b:
            r16 = 0
        L_0x011d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = "Off"
            r0.append(r8)
            java.lang.String r14 = r0.toString()
            r37 = r6
            r36 = r9
            r0 = r14
            r34 = r15
            r6 = r17
            r8 = r18
            r9 = r19
            r35 = r20
            r17 = r21
            r12 = r22
            r26 = r23
            r14 = r24
            r13 = r28
            r38 = r29
            r15 = r10
            r10 = r16
            goto L_0x017f
        L_0x014d:
            r37 = r6
            r15 = r10
            r6 = r17
            r8 = r18
            r9 = r19
            r35 = r20
            r17 = r21
            r12 = r22
            r26 = r23
            r0 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r34 = 0
            r36 = 0
            goto L_0x017d
        L_0x0167:
            r0 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r26 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
        L_0x017d:
            r38 = 0
        L_0x017f:
            r27 = 20
            long r18 = r2 & r27
            int r16 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x01aa
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r16 == 0) goto L_0x0196
            if (r7 == 0) goto L_0x0192
            r18 = 256(0x100, double:1.265E-321)
            goto L_0x0194
        L_0x0192:
            r18 = 128(0x80, double:6.32E-322)
        L_0x0194:
            long r2 = r2 | r18
        L_0x0196:
            if (r7 == 0) goto L_0x01a1
            android.widget.ImageView r7 = r1.wishlistIcon
            int r4 = com.paytmmall.clpartifact.R.drawable.clp_wishlist_selected
            android.graphics.drawable.Drawable r4 = getDrawableFromResource(r7, r4)
            goto L_0x01ab
        L_0x01a1:
            android.widget.ImageView r4 = r1.wishlistIcon
            int r5 = com.paytmmall.clpartifact.R.drawable.clp_heart_button
            android.graphics.drawable.Drawable r4 = getDrawableFromResource(r4, r5)
            goto L_0x01ab
        L_0x01aa:
            r4 = 0
        L_0x01ab:
            r18 = 19
            long r18 = r2 & r18
            r20 = 0
            int r5 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r5 == 0) goto L_0x01fb
            android.widget.TextView r5 = r1.badgeTV
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r6)
            android.widget.TextView r5 = r1.mboundView11
            r5.setVisibility(r9)
            android.widget.TextView r5 = r1.mboundView11
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r11)
            android.widget.LinearLayout r5 = r1.mboundView12
            r6 = r35
            r5.setVisibility(r6)
            android.widget.ImageView r5 = r1.mboundView13
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r5
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r16, r17, r18, r19, r20, r21, r22)
            android.widget.TextView r5 = r1.offerText
            r5.setVisibility(r8)
            android.widget.TextView r5 = r1.offerText
            r6 = r37
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r6)
            android.widget.TextView r5 = r1.offerText
            r5.setTextColor(r12)
            android.widget.ImageView r5 = r1.row1xnImage
            r16 = 0
            r17 = 0
            r6 = r14
            r14 = r5
            r20 = r26
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r14, r15, r16, r17, r18, r19, r20)
            goto L_0x01fc
        L_0x01fb:
            r6 = r14
        L_0x01fc:
            r7 = 17
            long r7 = r7 & r2
            r11 = 0
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x022e
            android.widget.TextView r5 = r1.itemAddTag
            r15 = r34
            r5.setVisibility(r15)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r5 = r1.mboundView4
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r5 = r1.row1xnCost
            r9 = r36
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r9)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r5 = r1.row1xnDiscount
            r5.setVisibility(r10)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r5 = r1.row1xnDiscount
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r0)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.row1xnOriginalCost
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.row1xnText
            r5 = r38
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x022e:
            r5 = 16
            long r5 = r5 & r2
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0245
            android.widget.LinearLayout r0 = r1.parentLayout
            android.view.View$OnClickListener r5 = r1.mCallback50
            r0.setOnClickListener(r5)
            android.widget.ImageView r0 = r1.wishlistIcon
            android.view.View$OnClickListener r5 = r1.mCallback51
            r0.setOnClickListener(r5)
        L_0x0245:
            long r2 = r2 & r27
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0250
            android.widget.ImageView r0 = r1.wishlistIcon
            r0.setImageDrawable(r4)
        L_0x0250:
            return
        L_0x0251:
            r0 = move-exception
            monitor-exit(r39)     // Catch:{ all -> 0x0251 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRow1xnBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
            Item item = this.mItem;
            Integer num = this.mPosition;
            if (cLPItemRVViewHolder != null) {
                z = true;
            }
            if (z) {
                cLPItemRVViewHolder.handleDeepLink(item, num.intValue());
            }
        } else if (i2 == 2) {
            CLPItemRVViewHolder cLPItemRVViewHolder2 = this.mHandler;
            Item item2 = this.mItem;
            if (cLPItemRVViewHolder2 != null) {
                z = true;
            }
            if (z) {
                cLPItemRVViewHolder2.handleWishListClick(item2);
            }
        }
    }
}

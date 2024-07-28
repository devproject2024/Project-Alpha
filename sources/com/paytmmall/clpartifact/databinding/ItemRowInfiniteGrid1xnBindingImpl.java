package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.fragment.InfiniteFragment;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder;

public class ItemRowInfiniteGrid1xnBindingImpl extends ItemRowInfiniteGrid1xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback53;
    private final View.OnClickListener mCallback54;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView12;
    private final TextView mboundView5;
    private final LinearLayout mboundView8;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(22);
        sIncludes = bVar;
        bVar.a(9, new String[]{"layout_add_to_cart", "layout_edit_cart"}, new int[]{15, 16}, new int[]{R.layout.layout_add_to_cart, R.layout.layout_edit_cart});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.variantLayout, 14);
        sViewsWithIds.put(R.id.price_layout, 17);
        sViewsWithIds.put(R.id.offerPriceTV, 18);
        sViewsWithIds.put(R.id.badgeSeparator, 19);
        sViewsWithIds.put(R.id.badgeIV, 20);
        sViewsWithIds.put(R.id.badgeTV, 21);
    }

    public ItemRowInfiniteGrid1xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, sIncludes, sViewsWithIds));
    }

    private ItemRowInfiniteGrid1xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[3], objArr[6], objArr[15], objArr[20], objArr[19], objArr[21], objArr[9], objArr[7], objArr[16], objArr[2], objArr[13], objArr[18], objArr[17], objArr[1], objArr[4], objArr[11], objArr[10], objArr[14]);
        this.mDirtyFlags = -1;
        this.BrandNameTV.setTag((Object) null);
        this.actualPriceTV.setTag((Object) null);
        this.cartContainer.setTag((Object) null);
        this.discountPercentTV.setTag((Object) null);
        this.itemAddTag.setTag((Object) null);
        this.itemHeart.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.mboundView8 = objArr[8];
        this.mboundView8.setTag((Object) null);
        this.productImage.setTag((Object) null);
        this.productNameTV.setTag((Object) null);
        this.rating.setTag((Object) null);
        this.star.setTag((Object) null);
        setRootTag(view);
        this.mCallback54 = new OnClickListener(this, 2);
        this.mCallback53 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRowInfiniteGrid1xnBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.item == i2) {
            setItem((CJRGridProduct) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPInfiniteGridHolder) obj);
        } else if (BR.fragment == i2) {
            setFragment((InfiniteFragment) obj);
        } else if (BR.isWishListed == i2) {
            setIsWishListed((Boolean) obj);
        } else if (BR.position == i2) {
            setPosition((Integer) obj);
        } else if (BR.showWishListIcon != i2) {
            return false;
        } else {
            setShowWishListIcon((Boolean) obj);
        }
        return true;
    }

    public void setItem(CJRGridProduct cJRGridProduct) {
        this.mItem = cJRGridProduct;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(CLPInfiniteGridHolder cLPInfiniteGridHolder) {
        this.mHandler = cLPInfiniteGridHolder;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setFragment(InfiniteFragment infiniteFragment) {
        this.mFragment = infiniteFragment;
    }

    public void setIsWishListed(Boolean bool) {
        this.mIsWishListed = bool;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.isWishListed);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public void setShowWishListIcon(Boolean bool) {
        this.mShowWishListIcon = bool;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.showWishListIcon);
        super.requestRebind();
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

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x020d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r40 = this;
            r1 = r40
            monitor-enter(r40)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0233 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0233 }
            monitor-exit(r40)     // Catch:{ all -> 0x0233 }
            com.paytmmall.clpartifact.modal.grid.CJRGridProduct r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder r6 = r1.mHandler
            java.lang.Boolean r7 = r1.mIsWishListed
            java.lang.Boolean r8 = r1.mShowWishListIcon
            r9 = 268(0x10c, double:1.324E-321)
            long r11 = r2 & r9
            r14 = 260(0x104, double:1.285E-321)
            r16 = 0
            r17 = 0
            int r18 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x012b
            if (r0 == 0) goto L_0x0027
            java.lang.String r11 = r0.getImageUrl()
            goto L_0x0029
        L_0x0027:
            r11 = r17
        L_0x0029:
            if (r6 == 0) goto L_0x0030
            android.content.Context r6 = r6.getContext()
            goto L_0x0032
        L_0x0030:
            r6 = r17
        L_0x0032:
            long r18 = r2 & r14
            int r12 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x011c
            if (r0 == 0) goto L_0x005f
            java.lang.String r18 = r0.getActualPrice()
            boolean r19 = r0.isShowBrand()
            java.lang.String r13 = r0.mAvgRating
            java.lang.String r21 = r0.getBrand()
            java.lang.String r22 = r0.getDiscountPercent()
            java.lang.String r23 = r0.getDiscountedPrice()
            boolean r24 = r0.isDiscounted()
            java.lang.String r25 = r0.getName()
            java.lang.String r9 = r0.mTotalrating
            boolean r0 = r0.isSponsored()
            goto L_0x0071
        L_0x005f:
            r9 = r17
            r13 = r9
            r18 = r13
            r21 = r18
            r22 = r21
            r23 = r22
            r25 = r23
            r0 = 0
            r19 = 0
            r24 = 0
        L_0x0071:
            if (r12 == 0) goto L_0x007c
            if (r19 == 0) goto L_0x0078
            r26 = 1024(0x400, double:5.06E-321)
            goto L_0x007a
        L_0x0078:
            r26 = 512(0x200, double:2.53E-321)
        L_0x007a:
            long r2 = r2 | r26
        L_0x007c:
            long r26 = r2 & r14
            int r10 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x008b
            if (r24 == 0) goto L_0x0087
            r26 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0089
        L_0x0087:
            r26 = 2048(0x800, double:1.0118E-320)
        L_0x0089:
            long r2 = r2 | r26
        L_0x008b:
            long r26 = r2 & r14
            int r10 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x009c
            if (r0 == 0) goto L_0x0097
            r26 = 65536(0x10000, double:3.2379E-319)
            goto L_0x009a
        L_0x0097:
            r26 = 32768(0x8000, double:1.61895E-319)
        L_0x009a:
            long r2 = r2 | r26
        L_0x009c:
            java.lang.String r10 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r18)
            if (r19 == 0) goto L_0x00a4
            r12 = 0
            goto L_0x00a6
        L_0x00a4:
            r12 = 8
        L_0x00a6:
            java.lang.String r18 = java.lang.String.valueOf(r13)
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r19 = com.paytmmall.clpartifact.common.StringUtils.getOfferText(r22)
            java.lang.String r22 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r23)
            if (r24 == 0) goto L_0x00bb
            r23 = 0
            goto L_0x00bd
        L_0x00bb:
            r23 = 8
        L_0x00bd:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r4 = "("
            java.lang.String r4 = r4.concat(r9)
            if (r0 == 0) goto L_0x00cb
            r0 = 0
            goto L_0x00cd
        L_0x00cb:
            r0 = 8
        L_0x00cd:
            long r28 = r2 & r14
            r26 = 0
            int r5 = (r28 > r26 ? 1 : (r28 == r26 ? 0 : -1))
            if (r5 == 0) goto L_0x00e8
            if (r13 == 0) goto L_0x00df
            r28 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r28
            r28 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x00e6
        L_0x00df:
            r28 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2 | r28
            r28 = 2097152(0x200000, double:1.0361308E-317)
        L_0x00e6:
            long r2 = r2 | r28
        L_0x00e8:
            if (r13 == 0) goto L_0x00ed
            r5 = 8
            goto L_0x00ee
        L_0x00ed:
            r5 = 0
        L_0x00ee:
            if (r13 == 0) goto L_0x00f2
            r9 = 4
            goto L_0x00f3
        L_0x00f2:
            r9 = 0
        L_0x00f3:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            java.lang.String r4 = ")"
            r13.append(r4)
            java.lang.String r4 = r13.toString()
            r13 = r0
            r39 = r6
            r30 = r9
            r31 = r10
            r34 = r11
            r9 = r18
            r11 = r19
            r0 = r21
            r32 = r25
            r6 = r4
            r10 = r5
            r4 = r22
            r5 = r23
            goto L_0x013f
        L_0x011c:
            r39 = r6
            r34 = r11
            r0 = r17
            r4 = r0
            r6 = r4
            r9 = r6
            r11 = r9
            r31 = r11
            r32 = r31
            goto L_0x0139
        L_0x012b:
            r0 = r17
            r4 = r0
            r6 = r4
            r9 = r6
            r11 = r9
            r31 = r11
            r32 = r31
            r34 = r32
            r39 = r34
        L_0x0139:
            r5 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r30 = 0
        L_0x013f:
            r18 = 288(0x120, double:1.423E-321)
            long r21 = r2 & r18
            r23 = 0
            int r25 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r25 == 0) goto L_0x016b
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r25 == 0) goto L_0x015a
            if (r7 == 0) goto L_0x0155
            r21 = 262144(0x40000, double:1.295163E-318)
            goto L_0x0158
        L_0x0155:
            r21 = 131072(0x20000, double:6.47582E-319)
        L_0x0158:
            long r2 = r2 | r21
        L_0x015a:
            if (r7 == 0) goto L_0x0161
            android.widget.ImageView r7 = r1.itemHeart
            int r14 = com.paytmmall.clpartifact.R.drawable.clp_wishlist_selected
            goto L_0x0165
        L_0x0161:
            android.widget.ImageView r7 = r1.itemHeart
            int r14 = com.paytmmall.clpartifact.R.drawable.clp_heart_button
        L_0x0165:
            android.graphics.drawable.Drawable r7 = getDrawableFromResource(r7, r14)
            r17 = r7
        L_0x016b:
            r7 = r17
            r14 = 384(0x180, double:1.897E-321)
            long r23 = r2 & r14
            r26 = 0
            int r17 = (r23 > r26 ? 1 : (r23 == r26 ? 0 : -1))
            if (r17 == 0) goto L_0x0190
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r17 == 0) goto L_0x0188
            if (r8 == 0) goto L_0x0183
            r23 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x0186
        L_0x0183:
            r23 = 524288(0x80000, double:2.590327E-318)
        L_0x0186:
            long r2 = r2 | r23
        L_0x0188:
            if (r8 == 0) goto L_0x018b
            goto L_0x018d
        L_0x018b:
            r16 = 8
        L_0x018d:
            r8 = r16
            goto L_0x0191
        L_0x0190:
            r8 = 0
        L_0x0191:
            r16 = 260(0x104, double:1.285E-321)
            long r16 = r2 & r16
            r20 = 0
            int r22 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r22 == 0) goto L_0x01e5
            android.widget.TextView r14 = r1.BrandNameTV
            r14.setVisibility(r12)
            android.widget.TextView r12 = r1.BrandNameTV
            androidx.databinding.a.d.a((android.widget.TextView) r12, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.actualPriceTV
            r12 = r31
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.widget.TextView r0 = r1.discountPercentTV
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.discountPercentTV
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
            android.widget.TextView r0 = r1.itemAddTag
            r0.setVisibility(r13)
            android.widget.TextView r0 = r1.mboundView12
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.mboundView12
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.mboundView5
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.productNameTV
            r4 = r32
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.rating
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.rating
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.ImageView r0 = r1.star
            r9 = r30
            r0.setVisibility(r9)
            r4 = 384(0x180, double:1.897E-321)
            goto L_0x01e6
        L_0x01e5:
            r4 = r14
        L_0x01e6:
            long r4 = r4 & r2
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x01f2
            android.widget.ImageView r0 = r1.itemHeart
            r0.setVisibility(r8)
        L_0x01f2:
            r4 = 256(0x100, double:1.265E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0207
            android.widget.ImageView r0 = r1.itemHeart
            android.view.View$OnClickListener r4 = r1.mCallback54
            r0.setOnClickListener(r4)
            android.widget.LinearLayout r0 = r1.mboundView0
            android.view.View$OnClickListener r4 = r1.mCallback53
            r0.setOnClickListener(r4)
        L_0x0207:
            long r4 = r2 & r18
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0212
            android.widget.ImageView r0 = r1.itemHeart
            r0.setImageDrawable(r7)
        L_0x0212:
            r4 = 268(0x10c, double:1.324E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0228
            android.widget.ImageView r0 = r1.productImage
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r33 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r33, r34, r35, r36, r37, r38, r39)
        L_0x0228:
            com.paytmmall.clpartifact.databinding.LayoutAddToCartBinding r0 = r1.addToCartLayout
            executeBindingsOn(r0)
            com.paytmmall.clpartifact.databinding.LayoutEditCartBinding r0 = r1.editCartLayout
            executeBindingsOn(r0)
            return
        L_0x0233:
            r0 = move-exception
            monitor-exit(r40)     // Catch:{ all -> 0x0233 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRowInfiniteGrid1xnBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPInfiniteGridHolder cLPInfiniteGridHolder = this.mHandler;
            CJRGridProduct cJRGridProduct = this.mItem;
            Integer num = this.mPosition;
            if (cLPInfiniteGridHolder != null) {
                z = true;
            }
            if (z) {
                cLPInfiniteGridHolder.handleGridDeepLink(cJRGridProduct, num.intValue());
            }
        } else if (i2 == 2) {
            CLPInfiniteGridHolder cLPInfiniteGridHolder2 = this.mHandler;
            CJRGridProduct cJRGridProduct2 = this.mItem;
            if (cLPInfiniteGridHolder2 != null) {
                z = true;
            }
            if (z) {
                cLPInfiniteGridHolder2.handleWishListClick(cJRGridProduct2);
            }
        }
    }
}

package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder;

public class ItemRowInfiniteGridBindingImpl extends ItemRowInfiniteGridBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback61;
    private final View.OnClickListener mCallback62;
    private final View.OnClickListener mCallback63;
    private long mDirtyFlags;
    private final LinearLayout mboundView14;
    private final View mboundView17;
    private final LinearLayout mboundView18;
    private final ImageView mboundView19;
    private final CLPRobotoTextView mboundView20;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.product_1, 21);
        sViewsWithIds.put(R.id.ratingll, 22);
        sViewsWithIds.put(R.id.ratingImg, 23);
        sViewsWithIds.put(R.id.endView, 24);
    }

    public ItemRowInfiniteGridBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 25, sIncludes, sViewsWithIds));
    }

    private ItemRowInfiniteGridBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[15], objArr[24], objArr[4], objArr[5], objArr[3], objArr[1], objArr[6], objArr[7], objArr[0], objArr[21], objArr[13], objArr[12], objArr[10], objArr[9], objArr[8], objArr[11], objArr[23], objArr[16], objArr[22], objArr[2]);
        this.mDirtyFlags = -1;
        this.avgratingTxt.setTag((Object) null);
        this.itemAddTag.setTag((Object) null);
        this.itemBrandName.setTag((Object) null);
        this.itemHeart.setTag((Object) null);
        this.itemImage1.setTag((Object) null);
        this.itemName1.setTag((Object) null);
        this.llPrice.setTag((Object) null);
        this.llRoot.setTag((Object) null);
        this.mboundView14 = objArr[14];
        this.mboundView14.setTag((Object) null);
        this.mboundView17 = objArr[17];
        this.mboundView17.setTag((Object) null);
        this.mboundView18 = objArr[18];
        this.mboundView18.setTag((Object) null);
        this.mboundView19 = objArr[19];
        this.mboundView19.setTag((Object) null);
        this.mboundView20 = objArr[20];
        this.mboundView20.setTag((Object) null);
        this.product1CashbackSubtext.setTag((Object) null);
        this.product1CashbackText.setTag((Object) null);
        this.product1DiscountPercent.setTag((Object) null);
        this.product1OldPrice.setTag((Object) null);
        this.product1Price.setTag((Object) null);
        this.productName.setTag((Object) null);
        this.ratingTxt.setTag((Object) null);
        this.variantLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback62 = new OnClickListener(this, 2);
        this.mCallback63 = new OnClickListener(this, 3);
        this.mCallback61 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8192;
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
            setItem((CJRGridProduct) obj);
        } else if (BR.showRating == i2) {
            setShowRating((Boolean) obj);
        } else if (BR.badgeText == i2) {
            setBadgeText((String) obj);
        } else if (BR.offerTag == i2) {
            setOfferTag((Boolean) obj);
        } else if (BR.subCashback == i2) {
            setSubCashback((String) obj);
        } else if (BR.badgeImageUrl == i2) {
            setBadgeImageUrl((String) obj);
        } else if (BR.showSeparation == i2) {
            setShowSeparation(((Boolean) obj).booleanValue());
        } else if (BR.showPrice == i2) {
            setShowPrice(((Boolean) obj).booleanValue());
        } else if (BR.cashback == i2) {
            setCashback((String) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPInfiniteGridHolder) obj);
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
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setShowRating(Boolean bool) {
        this.mShowRating = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.showRating);
        super.requestRebind();
    }

    public void setBadgeText(String str) {
        this.mBadgeText = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.badgeText);
        super.requestRebind();
    }

    public void setOfferTag(Boolean bool) {
        this.mOfferTag = bool;
    }

    public void setSubCashback(String str) {
        this.mSubCashback = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.subCashback);
        super.requestRebind();
    }

    public void setBadgeImageUrl(String str) {
        this.mBadgeImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.badgeImageUrl);
        super.requestRebind();
    }

    public void setShowSeparation(boolean z) {
        this.mShowSeparation = z;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.showSeparation);
        super.requestRebind();
    }

    public void setShowPrice(boolean z) {
        this.mShowPrice = z;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.showPrice);
        super.requestRebind();
    }

    public void setCashback(String str) {
        this.mCashback = str;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.cashback);
        super.requestRebind();
    }

    public void setHandler(CLPInfiniteGridHolder cLPInfiniteGridHolder) {
        this.mHandler = cLPInfiniteGridHolder;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setIsWishListed(Boolean bool) {
        this.mIsWishListed = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(BR.isWishListed);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public void setShowWishListIcon(Boolean bool) {
        this.mShowWishListIcon = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.showWishListIcon);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0499  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0505  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0523  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x021a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r65 = this;
            r1 = r65
            monitor-enter(r65)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x054e }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x054e }
            monitor-exit(r65)     // Catch:{ all -> 0x054e }
            com.paytmmall.clpartifact.modal.grid.CJRGridProduct r0 = r1.mItem
            java.lang.Boolean r6 = r1.mShowRating
            java.lang.String r7 = r1.mBadgeText
            java.lang.String r8 = r1.mSubCashback
            java.lang.String r10 = r1.mBadgeImageUrl
            boolean r9 = r1.mShowSeparation
            boolean r11 = r1.mShowPrice
            java.lang.String r15 = r1.mCashback
            com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder r12 = r1.mHandler
            java.lang.Boolean r13 = r1.mIsWishListed
            java.lang.Boolean r14 = r1.mShowWishListIcon
            r16 = 8705(0x2201, double:4.301E-320)
            long r18 = r2 & r16
            r20 = 4
            r21 = 8193(0x2001, double:4.048E-320)
            r23 = 1
            r24 = 8
            r25 = 0
            r26 = 0
            int r27 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x01cb
            if (r0 == 0) goto L_0x003b
            java.lang.String r18 = r0.getImageUrl()
            goto L_0x003d
        L_0x003b:
            r18 = r25
        L_0x003d:
            if (r12 == 0) goto L_0x004c
            java.lang.String r19 = r12.getVariantLabel(r0)
            int r27 = r12.getVariantLabelVisibility(r0)
            android.content.Context r12 = r12.getContext()
            goto L_0x0052
        L_0x004c:
            r12 = r25
            r19 = r12
            r27 = 0
        L_0x0052:
            long r28 = r2 & r21
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x01a9
            if (r0 == 0) goto L_0x0083
            java.lang.String r28 = r0.getActualPrice()
            java.lang.String r29 = r0.getDiscountPercent()
            java.lang.String r31 = r0.getDiscountedPrice()
            java.lang.String r4 = r0.mTotalrating
            boolean r5 = r0.isShowBrand()
            r34 = r4
            java.lang.String r4 = r0.mAvgRating
            java.lang.String r35 = r0.getBrand()
            java.lang.String r36 = r0.getName()
            boolean r0 = r0.isSponsored()
            r64 = r29
            r29 = r4
            r4 = r64
            goto L_0x0093
        L_0x0083:
            r4 = r25
            r28 = r4
            r29 = r28
            r31 = r29
            r34 = r31
            r35 = r34
            r36 = r35
            r0 = 0
            r5 = 0
        L_0x0093:
            if (r30 == 0) goto L_0x00a2
            if (r5 == 0) goto L_0x009d
            r37 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x00a0
        L_0x009d:
            r37 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x00a0:
            long r2 = r2 | r37
        L_0x00a2:
            long r37 = r2 & r21
            r32 = 0
            int r30 = (r37 > r32 ? 1 : (r37 == r32 ? 0 : -1))
            if (r30 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x00b0
            r37 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x00b3
        L_0x00b0:
            r37 = 16777216(0x1000000, double:8.289046E-317)
        L_0x00b3:
            long r2 = r2 | r37
        L_0x00b5:
            java.lang.String r28 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r28)
            r30 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            r37 = r14
            java.lang.String r14 = "%"
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            java.lang.String r14 = com.paytmmall.clpartifact.common.StringUtils.getRupeesFormat(r31)
            r38 = r14
            if (r34 == 0) goto L_0x00d9
            r31 = 1
            goto L_0x00db
        L_0x00d9:
            r31 = 0
        L_0x00db:
            java.lang.String r14 = java.lang.String.valueOf(r34)
            r34 = r13
            java.lang.String r13 = "("
            java.lang.String r13 = r13.concat(r14)
            if (r5 == 0) goto L_0x00eb
            r5 = 0
            goto L_0x00ec
        L_0x00eb:
            r5 = 4
        L_0x00ec:
            if (r29 == 0) goto L_0x00f0
            r14 = 1
            goto L_0x00f1
        L_0x00f0:
            r14 = 0
        L_0x00f1:
            if (r0 == 0) goto L_0x00f5
            r0 = 0
            goto L_0x00f7
        L_0x00f5:
            r0 = 8
        L_0x00f7:
            long r39 = r2 & r21
            r32 = 0
            int r41 = (r39 > r32 ? 1 : (r39 == r32 ? 0 : -1))
            if (r41 == 0) goto L_0x010e
            if (r31 == 0) goto L_0x0107
            r39 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x010c
        L_0x0107:
            r39 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x010c:
            long r2 = r2 | r39
        L_0x010e:
            long r39 = r2 & r21
            int r41 = (r39 > r32 ? 1 : (r39 == r32 ? 0 : -1))
            if (r41 == 0) goto L_0x0123
            if (r14 == 0) goto L_0x011c
            r39 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x0121
        L_0x011c:
            r39 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x0121:
            long r2 = r2 | r39
        L_0x0123:
            r39 = r0
            if (r4 == 0) goto L_0x012e
            java.lang.String r0 = "0"
            boolean r0 = r4.equals(r0)
            goto L_0x012f
        L_0x012e:
            r0 = 0
        L_0x012f:
            long r40 = r2 & r21
            r32 = 0
            int r4 = (r40 > r32 ? 1 : (r40 == r32 ? 0 : -1))
            if (r4 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x013d
            r40 = 32768(0x8000, double:1.61895E-319)
            goto L_0x013f
        L_0x013d:
            r40 = 16384(0x4000, double:8.0948E-320)
        L_0x013f:
            long r2 = r2 | r40
        L_0x0141:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            java.lang.String r12 = " "
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            r40 = r2
            if (r31 == 0) goto L_0x0158
            r12 = 0
            goto L_0x0159
        L_0x0158:
            r12 = 4
        L_0x0159:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            if (r14 == 0) goto L_0x016e
            r3 = 0
            goto L_0x016f
        L_0x016e:
            r3 = 4
        L_0x016f:
            if (r0 == 0) goto L_0x0174
            r0 = 8
            goto L_0x0175
        L_0x0174:
            r0 = 0
        L_0x0175:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            java.lang.String r4 = "Off"
            r13.append(r4)
            java.lang.String r4 = r13.toString()
            r46 = r0
            r14 = r3
            r47 = r19
            r45 = r27
            r48 = r28
            r0 = r29
            r44 = r30
            r13 = r36
            r27 = r38
            r19 = r2
            r28 = r4
            r4 = r35
            r2 = r40
            r64 = r12
            r12 = r5
            r5 = r39
            r39 = r18
            r18 = r64
            goto L_0x01ea
        L_0x01a9:
            r30 = r12
            r34 = r13
            r37 = r14
            r39 = r18
            r47 = r19
            r0 = r25
            r4 = r0
            r13 = r4
            r19 = r13
            r28 = r19
            r48 = r28
            r45 = r27
            r44 = r30
            r5 = 0
            r12 = 0
            r14 = 0
            r18 = 0
            r46 = 0
            r27 = r48
            goto L_0x01ea
        L_0x01cb:
            r34 = r13
            r37 = r14
            r0 = r25
            r4 = r0
            r13 = r4
            r19 = r13
            r27 = r19
            r28 = r27
            r39 = r28
            r44 = r39
            r47 = r44
            r48 = r47
            r5 = 0
            r12 = 0
            r14 = 0
            r18 = 0
            r45 = 0
            r46 = 0
        L_0x01ea:
            r29 = 8194(0x2002, double:4.0484E-320)
            long r35 = r2 & r29
            r31 = 0
            int r38 = (r35 > r31 ? 1 : (r35 == r31 ? 0 : -1))
            if (r38 == 0) goto L_0x020f
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r38 == 0) goto L_0x0209
            if (r6 == 0) goto L_0x0202
            r35 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x0207
        L_0x0202:
            r35 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x0207:
            long r2 = r2 | r35
        L_0x0209:
            if (r6 == 0) goto L_0x020c
            goto L_0x020f
        L_0x020c:
            r6 = 8
            goto L_0x0210
        L_0x020f:
            r6 = 0
        L_0x0210:
            r35 = 8196(0x2004, double:4.0494E-320)
            long r40 = r2 & r35
            r31 = 0
            int r38 = (r40 > r31 ? 1 : (r40 == r31 ? 0 : -1))
            if (r38 == 0) goto L_0x0238
            if (r7 == 0) goto L_0x021f
            r31 = 1
            goto L_0x0221
        L_0x021f:
            r31 = 0
        L_0x0221:
            if (r38 == 0) goto L_0x022e
            if (r31 == 0) goto L_0x0229
            r40 = 131072(0x20000, double:6.47582E-319)
            goto L_0x022c
        L_0x0229:
            r40 = 65536(0x10000, double:3.2379E-319)
        L_0x022c:
            long r2 = r2 | r40
        L_0x022e:
            if (r31 == 0) goto L_0x0233
            r38 = 0
            goto L_0x0235
        L_0x0233:
            r38 = 8
        L_0x0235:
            r49 = r38
            goto L_0x023c
        L_0x0238:
            r31 = 0
            r49 = 0
        L_0x023c:
            r50 = 8208(0x2010, double:4.0553E-320)
            long r40 = r2 & r50
            r32 = 0
            int r38 = (r40 > r32 ? 1 : (r40 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x0292
            boolean r40 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x024f
            r41 = 1
            goto L_0x0251
        L_0x024f:
            r41 = 0
        L_0x0251:
            if (r38 == 0) goto L_0x025e
            if (r41 == 0) goto L_0x0259
            r42 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x025c
        L_0x0259:
            r42 = 1048576(0x100000, double:5.180654E-318)
        L_0x025c:
            long r2 = r2 | r42
        L_0x025e:
            r38 = r40 ^ 1
            if (r41 == 0) goto L_0x0265
            r40 = 0
            goto L_0x0267
        L_0x0265:
            r40 = 4
        L_0x0267:
            long r41 = r2 & r50
            r32 = 0
            int r43 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r43 == 0) goto L_0x027a
            if (r38 == 0) goto L_0x0275
            r41 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x0278
        L_0x0275:
            r41 = 4194304(0x400000, double:2.0722615E-317)
        L_0x0278:
            long r2 = r2 | r41
        L_0x027a:
            r41 = r2
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r2 = r1.product1CashbackText
            if (r38 == 0) goto L_0x0283
            int r3 = com.paytmmall.clpartifact.R.color.clp_red
            goto L_0x0285
        L_0x0283:
            int r3 = com.paytmmall.clpartifact.R.color.clp_green_teal
        L_0x0285:
            int r2 = getColorFromResource(r2, r3)
            r53 = r2
            r52 = r8
            r8 = r40
            r2 = r41
            goto L_0x0297
        L_0x0292:
            r52 = r8
            r8 = 0
            r53 = 0
        L_0x0297:
            r54 = 8228(0x2024, double:4.065E-320)
            long r40 = r2 & r54
            r56 = 8224(0x2020, double:4.063E-320)
            r32 = 0
            int r38 = (r40 > r32 ? 1 : (r40 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x02e0
            if (r10 == 0) goto L_0x02a8
            r40 = 1
            goto L_0x02aa
        L_0x02a8:
            r40 = 0
        L_0x02aa:
            if (r38 == 0) goto L_0x02b7
            if (r40 == 0) goto L_0x02b2
            r41 = 524288(0x80000, double:2.590327E-318)
            goto L_0x02b5
        L_0x02b2:
            r41 = 262144(0x40000, double:1.295163E-318)
        L_0x02b5:
            long r2 = r2 | r41
        L_0x02b7:
            long r41 = r2 & r56
            r32 = 0
            int r38 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x02ca
            if (r40 == 0) goto L_0x02c5
            r41 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x02c8
        L_0x02c5:
            r41 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x02c8:
            long r2 = r2 | r41
        L_0x02ca:
            long r41 = r2 & r56
            int r38 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x02dc
            if (r40 == 0) goto L_0x02d5
            r38 = 0
            goto L_0x02d7
        L_0x02d5:
            r38 = 8
        L_0x02d7:
            r58 = r8
            r8 = r38
            goto L_0x02e7
        L_0x02dc:
            r58 = r8
            r8 = 0
            goto L_0x02e7
        L_0x02e0:
            r32 = 0
            r58 = r8
            r8 = 0
            r40 = 0
        L_0x02e7:
            r59 = 8256(0x2040, double:4.079E-320)
            long r41 = r2 & r59
            int r38 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x0305
            if (r38 == 0) goto L_0x0300
            if (r9 == 0) goto L_0x02f9
            r41 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x02fe
        L_0x02f9:
            r41 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x02fe:
            long r2 = r2 | r41
        L_0x0300:
            if (r9 == 0) goto L_0x0305
            r9 = 8
            goto L_0x0306
        L_0x0305:
            r9 = 0
        L_0x0306:
            r61 = 8320(0x2080, double:4.1106E-320)
            long r41 = r2 & r61
            r32 = 0
            int r38 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x0327
            if (r38 == 0) goto L_0x0321
            if (r11 == 0) goto L_0x031a
            r41 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x031f
        L_0x031a:
            r41 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x031f:
            long r2 = r2 | r41
        L_0x0321:
            if (r11 == 0) goto L_0x0324
            goto L_0x0327
        L_0x0324:
            r11 = 8
            goto L_0x0328
        L_0x0327:
            r11 = 0
        L_0x0328:
            r41 = 8448(0x2100, double:4.174E-320)
            long r41 = r2 & r41
            r32 = 0
            int r38 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r38 == 0) goto L_0x034d
            if (r15 == 0) goto L_0x0337
            r41 = 1
            goto L_0x0339
        L_0x0337:
            r41 = 0
        L_0x0339:
            if (r38 == 0) goto L_0x0346
            if (r41 == 0) goto L_0x0341
            r42 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x0344
        L_0x0341:
            r42 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x0344:
            long r2 = r2 | r42
        L_0x0346:
            if (r41 == 0) goto L_0x034a
            r20 = 0
        L_0x034a:
            r63 = r20
            goto L_0x034f
        L_0x034d:
            r63 = 0
        L_0x034f:
            r41 = 9216(0x2400, double:4.5533E-320)
            long r41 = r2 & r41
            r32 = 0
            int r20 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r20 == 0) goto L_0x0386
            boolean r25 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r34)
            if (r20 == 0) goto L_0x036e
            if (r25 == 0) goto L_0x0367
            r41 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x036c
        L_0x0367:
            r41 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x036c:
            long r2 = r2 | r41
        L_0x036e:
            r41 = r2
            android.widget.ImageView r2 = r1.itemHeart
            if (r25 == 0) goto L_0x0377
            int r3 = com.paytmmall.clpartifact.R.drawable.clp_wishlist_selected
            goto L_0x0379
        L_0x0377:
            int r3 = com.paytmmall.clpartifact.R.drawable.clp_heart_button
        L_0x0379:
            android.graphics.drawable.Drawable r2 = getDrawableFromResource(r2, r3)
            r25 = r2
            r20 = r15
            r15 = r25
            r2 = r41
            goto L_0x038a
        L_0x0386:
            r20 = r15
            r15 = r25
        L_0x038a:
            r41 = 12288(0x3000, double:6.071E-320)
            long r41 = r2 & r41
            r32 = 0
            int r25 = (r41 > r32 ? 1 : (r41 == r32 ? 0 : -1))
            if (r25 == 0) goto L_0x03b7
            boolean r34 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r37)
            if (r25 == 0) goto L_0x03a9
            if (r34 == 0) goto L_0x03a2
            r37 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x03a7
        L_0x03a2:
            r37 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x03a7:
            long r2 = r2 | r37
        L_0x03a9:
            if (r34 == 0) goto L_0x03ae
            r25 = 0
            goto L_0x03b0
        L_0x03ae:
            r25 = 8
        L_0x03b0:
            r64 = r25
            r25 = r10
            r10 = r64
            goto L_0x03ba
        L_0x03b7:
            r25 = r10
            r10 = 0
        L_0x03ba:
            r37 = 524288(0x80000, double:2.590327E-318)
            long r37 = r2 & r37
            r32 = 0
            int r34 = (r37 > r32 ? 1 : (r37 == r32 ? 0 : -1))
            if (r34 == 0) goto L_0x03dc
            if (r7 == 0) goto L_0x03c8
            goto L_0x03ca
        L_0x03c8:
            r23 = 0
        L_0x03ca:
            long r37 = r2 & r35
            int r31 = (r37 > r32 ? 1 : (r37 == r32 ? 0 : -1))
            if (r31 == 0) goto L_0x03de
            if (r23 == 0) goto L_0x03d6
            r37 = 131072(0x20000, double:6.47582E-319)
            goto L_0x03d9
        L_0x03d6:
            r37 = 65536(0x10000, double:3.2379E-319)
        L_0x03d9:
            long r2 = r2 | r37
            goto L_0x03de
        L_0x03dc:
            r23 = r31
        L_0x03de:
            long r37 = r2 & r54
            r31 = 0
            int r34 = (r37 > r31 ? 1 : (r37 == r31 ? 0 : -1))
            if (r34 == 0) goto L_0x0406
            if (r40 == 0) goto L_0x03e9
            goto L_0x03eb
        L_0x03e9:
            r23 = 0
        L_0x03eb:
            if (r34 == 0) goto L_0x03fc
            if (r23 == 0) goto L_0x03f5
            r37 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            goto L_0x03fa
        L_0x03f5:
            r37 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
        L_0x03fa:
            long r2 = r2 | r37
        L_0x03fc:
            if (r23 == 0) goto L_0x03ff
            goto L_0x0401
        L_0x03ff:
            r26 = 8
        L_0x0401:
            r23 = r7
            r7 = r26
            goto L_0x0409
        L_0x0406:
            r23 = r7
            r7 = 0
        L_0x0409:
            long r21 = r2 & r21
            r31 = 0
            int r24 = (r21 > r31 ? 1 : (r21 == r31 ? 0 : -1))
            r21 = r8
            if (r24 == 0) goto L_0x045b
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r8 = r1.avgratingTxt
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r0)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.avgratingTxt
            r0.setVisibility(r14)
            android.widget.TextView r0 = r1.itemAddTag
            r0.setVisibility(r5)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.itemBrandName
            r0.setVisibility(r12)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.itemBrandName
            r0.setText(r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.itemName1
            r0.setText(r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.product1DiscountPercent
            r4 = r46
            r0.setVisibility(r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.product1DiscountPercent
            r4 = r28
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.product1OldPrice
            r4 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.product1Price
            r4 = r27
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.ratingTxt
            r4 = r19
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.ratingTxt
            r12 = r18
            r0.setVisibility(r12)
        L_0x045b:
            r4 = 12288(0x3000, double:6.071E-320)
            long r4 = r4 & r2
            r12 = 0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0469
            android.widget.ImageView r0 = r1.itemHeart
            r0.setVisibility(r10)
        L_0x0469:
            r4 = 8192(0x2000, double:4.0474E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0485
            android.widget.ImageView r0 = r1.itemHeart
            android.view.View$OnClickListener r4 = r1.mCallback63
            r0.setOnClickListener(r4)
            android.widget.LinearLayout r0 = r1.llRoot
            android.view.View$OnClickListener r4 = r1.mCallback61
            r0.setOnClickListener(r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.variantLabel
            android.view.View$OnClickListener r4 = r1.mCallback62
            r0.setOnClickListener(r4)
        L_0x0485:
            r4 = 9216(0x2400, double:4.5533E-320)
            long r4 = r4 & r2
            r12 = 0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0493
            android.widget.ImageView r0 = r1.itemHeart
            r0.setImageDrawable(r15)
        L_0x0493:
            long r4 = r2 & r16
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x04b6
            android.widget.ImageView r0 = r1.itemImage1
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r38 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r38, r39, r40, r41, r42, r43, r44)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.variantLabel
            r4 = r47
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.variantLabel
            r4 = r45
            r0.setVisibility(r4)
        L_0x04b6:
            long r4 = r2 & r61
            r12 = 0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x04c8
            android.widget.LinearLayout r0 = r1.llPrice
            r0.setVisibility(r11)
            android.widget.LinearLayout r0 = r1.productName
            r0.setVisibility(r11)
        L_0x04c8:
            long r4 = r2 & r29
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x04d3
            android.widget.LinearLayout r0 = r1.mboundView14
            r0.setVisibility(r6)
        L_0x04d3:
            long r4 = r2 & r59
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x04de
            android.view.View r0 = r1.mboundView17
            r0.setVisibility(r9)
        L_0x04de:
            long r4 = r2 & r54
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x04e9
            android.widget.LinearLayout r0 = r1.mboundView18
            r0.setVisibility(r7)
        L_0x04e9:
            long r4 = r2 & r56
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0505
            android.widget.ImageView r0 = r1.mboundView19
            r4 = r21
            r0.setVisibility(r4)
            android.widget.ImageView r9 = r1.mboundView19
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r10 = r25
            r0 = r20
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0507
        L_0x0505:
            r0 = r20
        L_0x0507:
            long r4 = r2 & r35
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x051d
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.mboundView20
            r5 = r49
            r4.setVisibility(r5)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.mboundView20
            r5 = r23
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
        L_0x051d:
            long r4 = r2 & r50
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0538
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.product1CashbackSubtext
            r5 = r58
            r4.setVisibility(r5)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.product1CashbackSubtext
            r5 = r52
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.product1CashbackText
            r5 = r53
            r4.setTextColor(r5)
        L_0x0538:
            r4 = 8448(0x2100, double:4.174E-320)
            long r2 = r2 & r4
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x054d
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r2 = r1.product1CashbackText
            r3 = r63
            r2.setVisibility(r3)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r2 = r1.product1CashbackText
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
        L_0x054d:
            return
        L_0x054e:
            r0 = move-exception
            monitor-exit(r65)     // Catch:{ all -> 0x054e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRowInfiniteGridBindingImpl.executeBindings():void");
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
                cLPInfiniteGridHolder2.handleVariantClick(cJRGridProduct2);
            }
        } else if (i2 == 3) {
            CLPInfiniteGridHolder cLPInfiniteGridHolder3 = this.mHandler;
            CJRGridProduct cJRGridProduct3 = this.mItem;
            if (cLPInfiniteGridHolder3 != null) {
                z = true;
            }
            if (z) {
                cLPInfiniteGridHolder3.handleWishListClick(cJRGridProduct3);
            }
        }
    }
}

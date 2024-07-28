package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.CJRStoreInfo;
import com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV;

public class ItemStoreBannerBindingImpl extends ItemStoreBannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback68;
    private final View.OnClickListener mCallback69;
    private final View.OnClickListener mCallback70;
    private final View.OnClickListener mCallback71;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.star, 9);
    }

    public ItemStoreBannerBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemStoreBannerBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[2], objArr[1], objArr[8], objArr[4], objArr[5], objArr[9], objArr[6], objArr[3], objArr[7]);
        this.mDirtyFlags = -1;
        this.BrandLogo.setTag((Object) null);
        this.backButton.setTag((Object) null);
        this.follow.setTag((Object) null);
        this.group.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.rating.setTag((Object) null);
        this.storeName.setTag((Object) null);
        this.txvName.setTag((Object) null);
        this.viewAllStores.setTag((Object) null);
        setRootTag(view);
        this.mCallback70 = new OnClickListener(this, 3);
        this.mCallback68 = new OnClickListener(this, 1);
        this.mCallback71 = new OnClickListener(this, 4);
        this.mCallback69 = new OnClickListener(this, 2);
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((CLPStoreBannerVHWithoutRV) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(0, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setHandler(CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV) {
        this.mHandler = cLPStoreBannerVHWithoutRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeViewGetStoreInfo((CJRStoreInfo) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewGetStoreInfo(CJRStoreInfo cJRStoreInfo, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i2 != BR.following) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r37 = this;
            r1 = r37
            monitor-enter(r37)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01dc }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01dc }
            monitor-exit(r37)     // Catch:{ all -> 0x01dc }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV r6 = r1.mHandler
            r7 = 31
            long r7 = r7 & r2
            r10 = 256(0x100, double:1.265E-321)
            r12 = 512(0x200, double:2.53E-321)
            r14 = 65536(0x10000, double:3.2379E-319)
            r16 = 23
            r18 = 19
            r20 = 17
            r22 = 27
            r9 = 1
            r24 = 0
            r25 = 0
            int r26 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r26 == 0) goto L_0x00b8
            if (r0 == 0) goto L_0x0030
            com.paytmmall.clpartifact.modal.clpCommon.CJRStoreInfo r7 = r0.getStoreInfo()
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r7)
            long r26 = r2 & r22
            int r8 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x005e
            if (r7 == 0) goto L_0x003f
            r8 = 1
            goto L_0x0040
        L_0x003f:
            r8 = 0
        L_0x0040:
            long r26 = r2 & r18
            int r28 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x004e
            if (r8 == 0) goto L_0x004a
            long r2 = r2 | r10
            goto L_0x004e
        L_0x004a:
            r26 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r26
        L_0x004e:
            long r26 = r2 & r22
            int r28 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x005f
            if (r8 == 0) goto L_0x0058
            long r2 = r2 | r14
            goto L_0x005f
        L_0x0058:
            r26 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r26
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            long r26 = r2 & r16
            int r28 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0088
            if (r7 == 0) goto L_0x006c
            java.lang.String r26 = r7.getLogoUrl()
            goto L_0x006e
        L_0x006c:
            r26 = r24
        L_0x006e:
            long r27 = r2 & r18
            int r29 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x008a
            boolean r27 = android.text.TextUtils.isEmpty(r26)
            if (r29 == 0) goto L_0x0083
            if (r27 == 0) goto L_0x007f
            r28 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0081
        L_0x007f:
            r28 = 2048(0x800, double:1.0118E-320)
        L_0x0081:
            long r2 = r2 | r28
        L_0x0083:
            if (r27 == 0) goto L_0x008a
            r27 = 8
            goto L_0x008c
        L_0x0088:
            r26 = r24
        L_0x008a:
            r27 = 0
        L_0x008c:
            long r28 = r2 & r20
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x0099
            com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview r28 = r0.getRatingReview()
            goto L_0x009b
        L_0x0099:
            r28 = r24
        L_0x009b:
            if (r28 != 0) goto L_0x00a0
            r29 = 1
            goto L_0x00a2
        L_0x00a0:
            r29 = 0
        L_0x00a2:
            if (r30 == 0) goto L_0x00ac
            if (r29 == 0) goto L_0x00ab
            r30 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r30
            goto L_0x00ac
        L_0x00ab:
            long r2 = r2 | r12
        L_0x00ac:
            r31 = r26
            r9 = r27
            goto L_0x00c2
        L_0x00b1:
            r28 = r24
            r31 = r26
            r9 = r27
            goto L_0x00c0
        L_0x00b8:
            r7 = r24
            r28 = r7
            r31 = r28
            r8 = 0
            r9 = 0
        L_0x00c0:
            r29 = 0
        L_0x00c2:
            long r32 = r2 & r16
            int r27 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x00cf
            if (r6 == 0) goto L_0x00cf
            android.content.Context r6 = r6.getContext()
            goto L_0x00d1
        L_0x00cf:
            r6 = r24
        L_0x00d1:
            long r14 = r14 & r2
            int r27 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r27 == 0) goto L_0x00dd
            if (r7 == 0) goto L_0x00dd
            boolean r14 = r7.isFollowing()
            goto L_0x00de
        L_0x00dd:
            r14 = 0
        L_0x00de:
            long r12 = r12 & r2
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00f0
            if (r28 == 0) goto L_0x00ea
            java.lang.Double r12 = r28.getAvgRating()
            goto L_0x00ec
        L_0x00ea:
            r12 = r24
        L_0x00ec:
            if (r12 != 0) goto L_0x00f2
            r13 = 1
            goto L_0x00f3
        L_0x00f0:
            r12 = r24
        L_0x00f2:
            r13 = 0
        L_0x00f3:
            long r10 = r10 & r2
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00ff
            if (r7 == 0) goto L_0x00ff
            java.lang.String r7 = r7.getName()
            goto L_0x0101
        L_0x00ff:
            r7 = r24
        L_0x0101:
            long r10 = r2 & r18
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x010e
            if (r8 == 0) goto L_0x010a
            goto L_0x010c
        L_0x010a:
            java.lang.String r7 = "StoreName"
        L_0x010c:
            r24 = r7
        L_0x010e:
            r7 = r24
            long r10 = r2 & r20
            r32 = 32
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0126
            if (r29 == 0) goto L_0x011b
            r13 = 1
        L_0x011b:
            if (r15 == 0) goto L_0x0127
            if (r13 == 0) goto L_0x0123
            r10 = 64
            long r2 = r2 | r10
            goto L_0x0127
        L_0x0123:
            long r2 = r2 | r32
            goto L_0x0127
        L_0x0126:
            r13 = 0
        L_0x0127:
            long r10 = r2 & r22
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0130
            if (r8 == 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r14 = 0
        L_0x0131:
            long r10 = r2 & r32
            int r8 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0149
            if (r28 == 0) goto L_0x013d
            java.lang.Double r12 = r28.getAvgRating()
        L_0x013d:
            double r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r12)
            r27 = 0
            int r8 = (r10 > r27 ? 1 : (r10 == r27 ? 0 : -1))
            if (r8 != 0) goto L_0x0149
            r8 = 1
            goto L_0x014a
        L_0x0149:
            r8 = 0
        L_0x014a:
            long r10 = r2 & r20
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0164
            if (r13 == 0) goto L_0x0153
            r8 = 1
        L_0x0153:
            if (r12 == 0) goto L_0x015d
            if (r8 == 0) goto L_0x015a
            r10 = 16384(0x4000, double:8.0948E-320)
            goto L_0x015c
        L_0x015a:
            r10 = 8192(0x2000, double:4.0474E-320)
        L_0x015c:
            long r2 = r2 | r10
        L_0x015d:
            if (r8 == 0) goto L_0x0161
            r25 = 8
        L_0x0161:
            r8 = r25
            goto L_0x0165
        L_0x0164:
            r8 = 0
        L_0x0165:
            long r10 = r2 & r18
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0175
            android.widget.ImageView r10 = r1.BrandLogo
            r10.setVisibility(r9)
            android.widget.TextView r9 = r1.txvName
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r7)
        L_0x0175:
            long r9 = r2 & r16
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            android.widget.ImageView r7 = r1.BrandLogo
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r30 = r7
            r36 = r6
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r30, r31, r32, r33, r34, r35, r36)
        L_0x018c:
            r9 = 16
            long r9 = r9 & r2
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x01af
            android.widget.ImageView r7 = r1.backButton
            android.view.View$OnClickListener r9 = r1.mCallback68
            r7.setOnClickListener(r9)
            android.widget.TextView r7 = r1.follow
            android.view.View$OnClickListener r9 = r1.mCallback71
            r7.setOnClickListener(r9)
            android.widget.TextView r7 = r1.storeName
            android.view.View$OnClickListener r9 = r1.mCallback69
            r7.setOnClickListener(r9)
            android.widget.TextView r7 = r1.viewAllStores
            android.view.View$OnClickListener r9 = r1.mCallback70
            r7.setOnClickListener(r9)
        L_0x01af:
            long r9 = r2 & r22
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x01ba
            android.widget.TextView r7 = r1.follow
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setFollowText(r7, r14)
        L_0x01ba:
            long r9 = r2 & r20
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x01cf
            androidx.constraintlayout.widget.Group r7 = r1.group
            r7.setVisibility(r8)
            android.widget.TextView r7 = r1.rating
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setRatingText(r7, r0)
            android.widget.TextView r7 = r1.storeName
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setText(r7, r0)
        L_0x01cf:
            r7 = 21
            long r2 = r2 & r7
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x01db
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.mboundView0
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setBGColor(r2, r0, r6)
        L_0x01db:
            return
        L_0x01dc:
            r0 = move-exception
            monitor-exit(r37)     // Catch:{ all -> 0x01dc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemStoreBannerBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV = this.mHandler;
            if (cLPStoreBannerVHWithoutRV != null) {
                z = true;
            }
            if (z) {
                cLPStoreBannerVHWithoutRV.handleBackPress();
            }
        } else if (i2 == 2) {
            CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV2 = this.mHandler;
            if (cLPStoreBannerVHWithoutRV2 != null) {
                z = true;
            }
            if (z) {
                cLPStoreBannerVHWithoutRV2.openReviewsTab(view);
            }
        } else if (i2 == 3) {
            CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV3 = this.mHandler;
            if (cLPStoreBannerVHWithoutRV3 != null) {
                z = true;
            }
            if (z) {
                cLPStoreBannerVHWithoutRV3.openAllStoresTab(view);
            }
        } else if (i2 == 4) {
            CLPStoreBannerVHWithoutRV cLPStoreBannerVHWithoutRV4 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
            if (cLPStoreBannerVHWithoutRV4 != null) {
                z = true;
            }
            if (z) {
                cLPStoreBannerVHWithoutRV4.onFollowClick(view, view2);
            }
        }
    }
}

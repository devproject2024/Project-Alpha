package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public class ItemFullWidthRootRvSmallTiBindingImpl extends ItemFullWidthRootRvSmallTiBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback88;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.flash_sale_container, 6);
        sViewsWithIds.put(R.id.timer_view, 7);
        sViewsWithIds.put(R.id.color_background, 8);
        sViewsWithIds.put(R.id.rvThinBanner, 9);
    }

    public ItemFullWidthRootRvSmallTiBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemFullWidthRootRvSmallTiBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[5], objArr[8], objArr[6], objArr[0], objArr[9], objArr[4], objArr[7], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.backgroundImage.setTag((Object) null);
        this.llParent.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.subTitle.setTag((Object) null);
        this.viewAll.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
        this.mCallback88 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        } else if (BR.layoutManager == i2) {
            setLayoutManager((RecyclerView.LayoutManager) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPItemVHWithRV) obj);
        } else if (BR.title == i2) {
            setTitle((Boolean) obj);
        } else if (BR.adapter != i2) {
            return false;
        } else {
            setAdapter((CLPItemRVAdapter) obj);
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

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public void setHandler(CLPItemVHWithRV cLPItemVHWithRV) {
        this.mHandler = cLPItemVHWithRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setTitle(Boolean bool) {
        this.mTitle = bool;
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0072 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r31 = this;
            r1 = r31
            monitor-enter(r31)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0108 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0108 }
            monitor-exit(r31)     // Catch:{ all -> 0x0108 }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV r6 = r1.mHandler
            r7 = 101(0x65, double:5.0E-322)
            long r7 = r7 & r2
            r9 = 65
            r11 = 97
            r14 = 69
            r16 = 0
            r17 = 0
            int r18 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0088
            long r7 = r2 & r11
            int r18 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x002c
            java.lang.String r7 = r0.getTitle()
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r18 == 0) goto L_0x003d
            if (r8 == 0) goto L_0x0039
            r18 = 256(0x100, double:1.265E-321)
            goto L_0x003b
        L_0x0039:
            r18 = 128(0x80, double:6.32E-322)
        L_0x003b:
            long r2 = r2 | r18
        L_0x003d:
            if (r8 == 0) goto L_0x0044
            r8 = 8
            goto L_0x0045
        L_0x0042:
            r7 = r16
        L_0x0044:
            r8 = 0
        L_0x0045:
            long r18 = r2 & r9
            int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0068
            if (r0 == 0) goto L_0x0052
            java.lang.String r18 = r0.getSubtitle()
            goto L_0x0054
        L_0x0052:
            r18 = r16
        L_0x0054:
            boolean r19 = android.text.TextUtils.isEmpty(r18)
            if (r20 == 0) goto L_0x0063
            if (r19 == 0) goto L_0x005f
            r20 = 1024(0x400, double:5.06E-321)
            goto L_0x0061
        L_0x005f:
            r20 = 512(0x200, double:2.53E-321)
        L_0x0061:
            long r2 = r2 | r20
        L_0x0063:
            if (r19 == 0) goto L_0x006a
            r19 = 8
            goto L_0x006c
        L_0x0068:
            r18 = r16
        L_0x006a:
            r19 = 0
        L_0x006c:
            long r20 = r2 & r14
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0080
            if (r0 == 0) goto L_0x0080
            java.lang.String r20 = r0.getImageUrl()
            r13 = r7
            r23 = r18
            r7 = r19
            r25 = r20
            goto L_0x0090
        L_0x0080:
            r13 = r7
            r25 = r16
            r23 = r18
            r7 = r19
            goto L_0x0090
        L_0x0088:
            r13 = r16
            r23 = r13
            r25 = r23
            r7 = 0
            r8 = 0
        L_0x0090:
            long r19 = r2 & r14
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00b7
            if (r6 == 0) goto L_0x00a1
            boolean r0 = r6.shouldShowBackgroundImage(r0)
            android.content.Context r16 = r6.getContext()
            goto L_0x00a2
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            if (r21 == 0) goto L_0x00ad
            if (r0 == 0) goto L_0x00a9
            r19 = 4096(0x1000, double:2.0237E-320)
            goto L_0x00ab
        L_0x00a9:
            r19 = 2048(0x800, double:1.0118E-320)
        L_0x00ab:
            long r2 = r2 | r19
        L_0x00ad:
            if (r0 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r17 = 8
        L_0x00b2:
            r30 = r16
            r0 = r17
            goto L_0x00ba
        L_0x00b7:
            r30 = r16
            r0 = 0
        L_0x00ba:
            long r14 = r14 & r2
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00d3
            android.widget.ImageView r6 = r1.backgroundImage
            r6.setVisibility(r0)
            android.widget.ImageView r0 = r1.backgroundImage
            r26 = 12
            r27 = 0
            r28 = 0
            r29 = 0
            r24 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r24, r25, r26, r27, r28, r29, r30)
        L_0x00d3:
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e7
            android.widget.LinearLayout r0 = r1.mboundView1
            r0.setVisibility(r8)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            r0.setVisibility(r8)
        L_0x00e7:
            long r8 = r2 & r9
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f9
            android.widget.TextView r0 = r1.subTitle
            r6 = r23
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.subTitle
            r0.setVisibility(r7)
        L_0x00f9:
            r6 = 64
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0107
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewAll
            android.view.View$OnClickListener r2 = r1.mCallback88
            r0.setOnClickListener(r2)
        L_0x0107:
            return
        L_0x0108:
            r0 = move-exception
            monitor-exit(r31)     // Catch:{ all -> 0x0108 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemFullWidthRootRvSmallTiBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        if (cLPItemVHWithRV != null) {
            cLPItemVHWithRV.handleViewAllClick(view2);
        }
    }
}

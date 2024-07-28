package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public class ItemCartRvBindingImpl extends ItemCartRvBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback66;
    private long mDirtyFlags;

    public ItemCartRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemCartRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0], objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.mainLayout.setTag((Object) null);
        this.rvThinBanner.setTag((Object) null);
        this.viewAll.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
        this.mCallback66 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.layoutManager);
        super.requestRebind();
    }

    public void setHandler(CLPItemVHWithRV cLPItemVHWithRV) {
        this.mHandler = cLPItemVHWithRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
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
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0102 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0102 }
            monitor-exit(r25)     // Catch:{ all -> 0x0102 }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r1.mLayoutManager
            com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter r7 = r1.mAdapter
            r8 = 49
            long r10 = r2 & r8
            r13 = 64
            r16 = 33
            r18 = 0
            r19 = 0
            int r20 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0088
            long r10 = r2 & r16
            int r20 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x0031
            java.lang.String r10 = r0.getUrlType()
            java.util.List r11 = r0.getItems()
            goto L_0x0034
        L_0x0031:
            r10 = r18
            r11 = r10
        L_0x0034:
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x003c
            r11 = 1
            goto L_0x003d
        L_0x003c:
            r11 = 0
        L_0x003d:
            if (r20 == 0) goto L_0x0048
            if (r10 == 0) goto L_0x0044
            r20 = 2048(0x800, double:1.0118E-320)
            goto L_0x0046
        L_0x0044:
            r20 = 1024(0x400, double:5.06E-321)
        L_0x0046:
            long r2 = r2 | r20
        L_0x0048:
            long r20 = r2 & r16
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0056
            if (r11 == 0) goto L_0x0055
            r20 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r20
            goto L_0x0056
        L_0x0055:
            long r2 = r2 | r13
        L_0x0056:
            if (r10 == 0) goto L_0x005b
            r10 = 8
            goto L_0x005f
        L_0x005b:
            r10 = 0
            goto L_0x005f
        L_0x005d:
            r10 = 0
            r11 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0066
            java.lang.String r20 = r0.getTitle()
            goto L_0x0068
        L_0x0066:
            r20 = r18
        L_0x0068:
            boolean r21 = android.text.TextUtils.isEmpty(r20)
            long r22 = r2 & r8
            int r24 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x007b
            if (r21 == 0) goto L_0x0077
            r22 = 512(0x200, double:2.53E-321)
            goto L_0x0079
        L_0x0077:
            r22 = 256(0x100, double:1.265E-321)
        L_0x0079:
            long r2 = r2 | r22
        L_0x007b:
            if (r21 == 0) goto L_0x0080
            r21 = 8
            goto L_0x0082
        L_0x0080:
            r21 = 0
        L_0x0082:
            r12 = r10
            r15 = r20
            r10 = r21
            goto L_0x008d
        L_0x0088:
            r15 = r18
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x008d:
            long r13 = r13 & r2
            int r22 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x00a0
            if (r0 == 0) goto L_0x0097
            java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item> r0 = r0.mItems
            goto L_0x0099
        L_0x0097:
            r0 = r18
        L_0x0099:
            if (r0 == 0) goto L_0x00a0
            boolean r0 = r0.isEmpty()
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            long r13 = r2 & r16
            int r18 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x00bb
            if (r11 == 0) goto L_0x00aa
            r0 = 1
        L_0x00aa:
            if (r18 == 0) goto L_0x00b4
            if (r0 == 0) goto L_0x00b1
            r13 = 8192(0x2000, double:4.0474E-320)
            goto L_0x00b3
        L_0x00b1:
            r13 = 4096(0x1000, double:2.0237E-320)
        L_0x00b3:
            long r2 = r2 | r13
        L_0x00b4:
            if (r0 == 0) goto L_0x00b8
            r19 = 8
        L_0x00b8:
            r0 = r19
            goto L_0x00bc
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            long r13 = r2 & r16
            int r11 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00cc
            android.widget.LinearLayout r11 = r1.mainLayout
            r11.setVisibility(r0)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewAll
            r0.setVisibility(r12)
        L_0x00cc:
            r11 = 40
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d8
            androidx.recyclerview.widget.RecyclerView r0 = r1.rvThinBanner
            r0.setAdapter(r7)
        L_0x00d8:
            r11 = 34
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e4
            androidx.recyclerview.widget.RecyclerView r0 = r1.rvThinBanner
            r0.setLayoutManager(r6)
        L_0x00e4:
            r6 = 32
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f2
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewAll
            android.view.View$OnClickListener r6 = r1.mCallback66
            r0.setOnClickListener(r6)
        L_0x00f2:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0101
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            r0.setVisibility(r10)
        L_0x0101:
            return
        L_0x0102:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0102 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemCartRvBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        if (cLPItemVHWithRV != null) {
            cLPItemVHWithRV.handleViewAllClick(view2);
        }
    }
}

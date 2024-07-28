package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public class ItemSmartIconButton2xnRootBindingImpl extends ItemSmartIconButton2xnRootBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback111;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rvThinBanner, 3);
    }

    public ItemSmartIconButton2xnRootBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemSmartIconButton2xnRootBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[0], objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.clParent.setTag((Object) null);
        this.viewAll.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
        this.mCallback111 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        } else if (BR.view == i2) {
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

    public void setItem(Item item) {
        this.mItem = item;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(1, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setTitle(Boolean bool) {
        this.mTitle = bool;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeItem((Item) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
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

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0098 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0098 }
            monitor-exit(r20)     // Catch:{ all -> 0x0098 }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            java.lang.Boolean r6 = r1.mTitle
            r7 = 194(0xc2, double:9.6E-322)
            long r9 = r2 & r7
            r11 = 8
            r12 = 130(0x82, double:6.4E-322)
            r14 = 0
            r15 = 0
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0046
            long r9 = r2 & r12
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x003e
            if (r0 == 0) goto L_0x0029
            java.lang.String r9 = r0.getUrlType()
            goto L_0x002a
        L_0x0029:
            r9 = r14
        L_0x002a:
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r16 == 0) goto L_0x0039
            if (r9 == 0) goto L_0x0035
            r16 = 512(0x200, double:2.53E-321)
            goto L_0x0037
        L_0x0035:
            r16 = 256(0x100, double:1.265E-321)
        L_0x0037:
            long r2 = r2 | r16
        L_0x0039:
            if (r9 == 0) goto L_0x003e
            r9 = 8
            goto L_0x003f
        L_0x003e:
            r9 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0047
            java.lang.String r14 = r0.getTitle()
            goto L_0x0047
        L_0x0046:
            r9 = 0
        L_0x0047:
            r16 = 144(0x90, double:7.1E-322)
            long r18 = r2 & r16
            int r10 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0063
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r10 == 0) goto L_0x005e
            if (r6 == 0) goto L_0x005a
            r18 = 2048(0x800, double:1.0118E-320)
            goto L_0x005c
        L_0x005a:
            r18 = 1024(0x400, double:5.06E-321)
        L_0x005c:
            long r2 = r2 | r18
        L_0x005e:
            if (r6 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r15 = 8
        L_0x0063:
            r10 = 128(0x80, double:6.32E-322)
            long r10 = r10 & r2
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0071
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r6 = r1.viewAll
            android.view.View$OnClickListener r10 = r1.mCallback111
            r6.setOnClickListener(r10)
        L_0x0071:
            long r10 = r2 & r12
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0081
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r6 = r1.viewAll
            r6.setVisibility(r9)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r6 = r1.viewName
            com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings.setTitleSize(r6, r0)
        L_0x0081:
            long r6 = r2 & r7
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x008c
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x008c:
            long r2 = r2 & r16
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0097
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.viewName
            r0.setVisibility(r15)
        L_0x0097:
            return
        L_0x0098:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x0098 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnRootBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        if (cLPItemVHWithRV != null) {
            cLPItemVHWithRV.handleViewAllClick(view2);
        }
    }
}

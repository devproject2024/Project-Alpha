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
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;
import java.util.List;

public class ItemCollageThreexnBindingImpl extends ItemCollageThreexnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback14;
    private final View.OnClickListener mCallback15;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;

    public ItemCollageThreexnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemCollageThreexnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        setRootTag(view);
        this.mCallback15 = new OnClickListener(this, 3);
        this.mCallback13 = new OnClickListener(this, 1);
        this.mCallback14 = new OnClickListener(this, 2);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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
            setHandler((CLPItemVHWithoutRV) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(2, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV) {
        this.mHandler = cLPItemVHWithoutRV;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeItemViewItemsGetInt2((Item) obj, i3);
            case 1:
                return onChangeViewItemsGetInt0((Item) obj, i3);
            case 2:
                return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
            case 3:
                return onChangeViewItemsGetInt2((Item) obj, i3);
            case 4:
                return onChangeViewItemsGetInt1((Item) obj, i3);
            case 5:
                return onChangeItemViewItemsGetInt1((Item) obj, i3);
            case 6:
                return onChangeItemViewItemsGetInt0((Item) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeItemViewItemsGetInt2(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
    }

    private boolean onChangeViewItemsGetInt2(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt1(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt1(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00f7 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00f7 }
            monitor-exit(r26)     // Catch:{ all -> 0x00f7 }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV r6 = r1.mHandler
            r7 = 1023(0x3ff, double:5.054E-321)
            long r7 = r7 & r2
            r9 = 653(0x28d, double:3.226E-321)
            r13 = 710(0x2c6, double:3.51E-321)
            r15 = 772(0x304, double:3.814E-321)
            r17 = 767(0x2ff, double:3.79E-321)
            r11 = 0
            int r21 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x009b
            long r7 = r2 & r15
            int r21 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x002b
            if (r0 == 0) goto L_0x002b
            java.lang.String r7 = r0.getTitle()
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            long r21 = r2 & r17
            int r8 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0099
            if (r0 == 0) goto L_0x0039
            java.util.List r0 = r0.getItems()
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            long r21 = r2 & r13
            r8 = 1
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x004c
            java.lang.Object r21 = r0.get(r11)
            com.paytmmall.clpartifact.modal.clpCommon.Item r21 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r21
            r12 = r21
            goto L_0x004d
        L_0x004c:
            r12 = 0
        L_0x004d:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r12 = 0
        L_0x0054:
            r13 = 6
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            goto L_0x005a
        L_0x0059:
            r12 = 0
        L_0x005a:
            long r13 = r2 & r9
            int r24 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x006a
            r13 = 2
            java.lang.Object r13 = r0.get(r13)
            com.paytmmall.clpartifact.modal.clpCommon.Item r13 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r13
            goto L_0x006b
        L_0x006a:
            r13 = 0
        L_0x006b:
            r14 = 3
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r13 = 0
        L_0x0073:
            r1.updateRegistration((int) r11, (androidx.databinding.h) r13)
            goto L_0x0078
        L_0x0077:
            r13 = 0
        L_0x0078:
            r19 = 692(0x2b4, double:3.42E-321)
            long r24 = r2 & r19
            int r14 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0097
            if (r0 == 0) goto L_0x0089
            java.lang.Object r0 = r0.get(r8)
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r0
            goto L_0x008a
        L_0x0089:
            r0 = 0
        L_0x008a:
            r8 = 4
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r0 = 0
        L_0x0092:
            r8 = 5
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            goto L_0x009f
        L_0x0097:
            r0 = 0
            goto L_0x009f
        L_0x0099:
            r0 = 0
            goto L_0x009d
        L_0x009b:
            r0 = 0
            r7 = 0
        L_0x009d:
            r12 = 0
            r13 = 0
        L_0x009f:
            long r17 = r2 & r17
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00ac
            if (r6 == 0) goto L_0x00ac
            android.content.Context r6 = r6.getContext()
            goto L_0x00ad
        L_0x00ac:
            r6 = 0
        L_0x00ad:
            long r14 = r2 & r15
            int r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00b8
            android.widget.TextView r8 = r1.mboundView1
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r7)
        L_0x00b8:
            r7 = 512(0x200, double:2.53E-321)
            long r7 = r7 & r2
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00d4
            android.widget.ImageView r7 = r1.mboundView2
            android.view.View$OnClickListener r8 = r1.mCallback13
            r7.setOnClickListener(r8)
            android.widget.ImageView r7 = r1.mboundView3
            android.view.View$OnClickListener r8 = r1.mCallback14
            r7.setOnClickListener(r8)
            android.widget.ImageView r7 = r1.mboundView4
            android.view.View$OnClickListener r8 = r1.mCallback15
            r7.setOnClickListener(r8)
        L_0x00d4:
            r7 = 710(0x2c6, double:3.51E-321)
            long r7 = r7 & r2
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00e0
            android.widget.ImageView r7 = r1.mboundView2
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImagePostMeasure(r7, r12, r11, r11, r6)
        L_0x00e0:
            r7 = 692(0x2b4, double:3.42E-321)
            long r7 = r7 & r2
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00ec
            android.widget.ImageView r7 = r1.mboundView3
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImagePostMeasure(r7, r0, r11, r11, r6)
        L_0x00ec:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f6
            android.widget.ImageView r0 = r1.mboundView4
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImagePostMeasure(r0, r13, r11, r11, r6)
        L_0x00f6:
            return
        L_0x00f7:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x00f7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemCollageThreexnBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
            if (cLPItemVHWithoutRV != null) {
                if (view2 != null) {
                    List<Item> items = view2.getItems();
                    if (items == null) {
                        z2 = false;
                    }
                    if (z2) {
                        cLPItemVHWithoutRV.handleDeepLink(items.get(0), 0);
                    }
                }
            }
        } else if (i2 == 2) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV2 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view3 = this.mView;
            if (cLPItemVHWithoutRV2 != null) {
                if (view3 != null) {
                    List<Item> items2 = view3.getItems();
                    if (items2 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV2.handleDeepLink(items2.get(1), 1);
                    }
                }
            }
        } else if (i2 == 3) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV3 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view4 = this.mView;
            if (cLPItemVHWithoutRV3 != null) {
                if (view4 != null) {
                    List<Item> items3 = view4.getItems();
                    if (items3 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV3.handleDeepLink(items3.get(2), 2);
                    }
                }
            }
        }
    }
}

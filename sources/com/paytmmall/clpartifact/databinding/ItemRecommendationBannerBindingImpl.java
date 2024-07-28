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
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;

public class ItemRecommendationBannerBindingImpl extends ItemRecommendationBannerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback81;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.grid_container_1, 5);
        sViewsWithIds.put(R.id.first_item_image_container, 6);
    }

    public ItemRecommendationBannerBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemRecommendationBannerBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[4], objArr[6], objArr[5], objArr[1], objArr[0], objArr[2]);
        this.mDirtyFlags = -1;
        this.categoryTitle.setTag((Object) null);
        this.categorycta.setTag((Object) null);
        this.groupImageView.setTag((Object) null);
        this.mainLayoutReco.setTag((Object) null);
        this.recoLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback81 = new OnClickListener(this, 1);
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
            setHandler((CLPRecoItemVH) obj);
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

    public void setHandler(CLPRecoItemVH cLPRecoItemVH) {
        this.mHandler = cLPRecoItemVH;
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

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00e2 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00e2 }
            monitor-exit(r23)     // Catch:{ all -> 0x00e2 }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH r6 = r1.mHandler
            r7 = 11
            long r9 = r2 & r7
            r11 = 9
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x009c
            if (r0 == 0) goto L_0x0021
            java.lang.String r9 = r0.getImageUrl()
            goto L_0x0022
        L_0x0021:
            r9 = r14
        L_0x0022:
            if (r6 == 0) goto L_0x0029
            android.content.Context r6 = r6.getContext()
            goto L_0x002a
        L_0x0029:
            r6 = r14
        L_0x002a:
            long r15 = r2 & r11
            int r10 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0097
            if (r0 == 0) goto L_0x003f
            java.lang.String r15 = r0.getItemSubtitle()
            java.lang.String r16 = r0.getTitle()
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r0 = r0.getCta()
            goto L_0x0043
        L_0x003f:
            r0 = r14
            r15 = r0
            r16 = r15
        L_0x0043:
            boolean r17 = android.text.TextUtils.isEmpty(r15)
            boolean r18 = android.text.TextUtils.isEmpty(r16)
            if (r10 == 0) goto L_0x0056
            if (r17 == 0) goto L_0x0052
            r19 = 32
            goto L_0x0054
        L_0x0052:
            r19 = 16
        L_0x0054:
            long r2 = r2 | r19
        L_0x0056:
            long r19 = r2 & r11
            int r10 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0065
            if (r18 == 0) goto L_0x0061
            r19 = 128(0x80, double:6.32E-322)
            goto L_0x0063
        L_0x0061:
            r19 = 64
        L_0x0063:
            long r2 = r2 | r19
        L_0x0065:
            if (r0 == 0) goto L_0x006b
            java.lang.String r14 = r0.getLabel()
        L_0x006b:
            r0 = 4
            if (r17 == 0) goto L_0x0070
            r10 = 4
            goto L_0x0071
        L_0x0070:
            r10 = 0
        L_0x0071:
            if (r18 == 0) goto L_0x0076
            r17 = 8
            goto L_0x0078
        L_0x0076:
            r17 = 0
        L_0x0078:
            boolean r18 = android.text.TextUtils.isEmpty(r14)
            long r19 = r2 & r11
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x008b
            if (r18 == 0) goto L_0x0087
            r19 = 512(0x200, double:2.53E-321)
            goto L_0x0089
        L_0x0087:
            r19 = 256(0x100, double:1.265E-321)
        L_0x0089:
            long r2 = r2 | r19
        L_0x008b:
            if (r18 == 0) goto L_0x008e
            r13 = 4
        L_0x008e:
            r22 = r6
            r6 = r13
            r0 = r14
            r14 = r16
            r13 = r17
            goto L_0x00a3
        L_0x0097:
            r22 = r6
            r0 = r14
            r15 = r0
            goto L_0x00a1
        L_0x009c:
            r0 = r14
            r9 = r0
            r15 = r9
            r22 = r15
        L_0x00a1:
            r6 = 0
            r10 = 0
        L_0x00a3:
            long r11 = r11 & r2
            int r16 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00c6
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r11 = r1.categoryTitle
            r11.setVisibility(r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r11 = r1.categoryTitle
            r11.setText(r14)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r11 = r1.categorycta
            androidx.databinding.a.d.a((android.widget.TextView) r11, (java.lang.CharSequence) r0)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.categorycta
            r0.setVisibility(r6)
            android.widget.TextView r0 = r1.recoLabel
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.recoLabel
            r0.setVisibility(r10)
        L_0x00c6:
            long r6 = r2 & r7
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d3
            android.widget.ImageView r0 = r1.groupImageView
            r6 = r22
            com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings.setCircularImage(r0, r9, r6)
        L_0x00d3:
            r6 = 8
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e1
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.mainLayoutReco
            android.view.View$OnClickListener r2 = r1.mCallback81
            r0.setOnClickListener(r2)
        L_0x00e1:
            return
        L_0x00e2:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x00e2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRecommendationBannerBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPRecoItemVH cLPRecoItemVH = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (cLPRecoItemVH != null) {
            cLPRecoItemVH.handleDeepLink(item, num.intValue());
        }
    }
}

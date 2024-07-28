package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;

public class ItemRecommendationBannerLargeImageBindingImpl extends ItemRecommendationBannerLargeImageBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback47;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemRecommendationBannerLargeImageBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemRecommendationBannerLargeImageBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[5], objArr[3], objArr[4], objArr[2]);
        this.mDirtyFlags = -1;
        this.bgImage.setTag((Object) null);
        this.cta.setTag((Object) null);
        this.image.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.subTitle.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        this.mCallback47 = new OnClickListener(this, 1);
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

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r31 = this;
            r1 = r31
            monitor-enter(r31)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ea }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ea }
            monitor-exit(r31)     // Catch:{ all -> 0x00ea }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH r6 = r1.mHandler
            r7 = 11
            long r9 = r2 & r7
            r11 = 9
            r13 = 0
            r14 = 0
            int r15 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0085
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
            if (r10 == 0) goto L_0x007d
            if (r0 == 0) goto L_0x0043
            java.lang.String r15 = r0.getItemSubtitle()
            java.lang.String r16 = r0.getSubTitleColor()
            java.lang.String r17 = r0.getTitle()
            com.paytmmall.clpartifact.modal.clpCommon.ItemCTA r0 = r0.getCta()
            goto L_0x0049
        L_0x0043:
            r0 = r14
            r15 = r0
            r16 = r15
            r17 = r16
        L_0x0049:
            boolean r18 = android.text.TextUtils.isEmpty(r15)
            if (r10 == 0) goto L_0x0060
            if (r18 == 0) goto L_0x0058
            r19 = 32
            long r2 = r2 | r19
            r19 = 128(0x80, double:6.32E-322)
            goto L_0x005e
        L_0x0058:
            r19 = 16
            long r2 = r2 | r19
            r19 = 64
        L_0x005e:
            long r2 = r2 | r19
        L_0x0060:
            if (r0 == 0) goto L_0x0066
            java.lang.String r14 = r0.getLabel()
        L_0x0066:
            if (r18 == 0) goto L_0x006c
            r0 = 8
            r13 = 8
        L_0x006c:
            if (r18 == 0) goto L_0x0070
            r0 = 2
            goto L_0x0071
        L_0x0070:
            r0 = 1
        L_0x0071:
            r22 = r6
            r6 = r0
            r0 = r16
            r30 = r17
            r17 = r9
            r9 = r30
            goto L_0x008d
        L_0x007d:
            r22 = r6
            r17 = r9
            r0 = r14
            r9 = r0
            r15 = r9
            goto L_0x008c
        L_0x0085:
            r0 = r14
            r9 = r0
            r15 = r9
            r17 = r15
            r22 = r17
        L_0x008c:
            r6 = 0
        L_0x008d:
            r18 = 8
            long r18 = r2 & r18
            int r10 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00af
            android.widget.ImageView r10 = r1.bgImage
            r24 = 0
            r25 = 17
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r23 = r10
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r23, r24, r25, r26, r27, r28, r29)
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.mboundView0
            android.view.View$OnClickListener r7 = r1.mCallback47
            r10.setOnClickListener(r7)
        L_0x00af:
            long r7 = r2 & r11
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00d3
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r7 = r1.cta
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r14)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r7 = r1.subTitle
            r7.setVisibility(r13)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r7 = r1.subTitle
            com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings.setTextColor(r7, r0)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.subTitle
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.title
            r0.setLines(r6)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.title
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x00d3:
            r6 = 11
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e9
            android.widget.ImageView r0 = r1.image
            r18 = 3
            r19 = 0
            r20 = 0
            r21 = 0
            r16 = r0
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r16, r17, r18, r19, r20, r21, r22)
        L_0x00e9:
            return
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r31)     // Catch:{ all -> 0x00ea }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRecommendationBannerLargeImageBindingImpl.executeBindings():void");
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

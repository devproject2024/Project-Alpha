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
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import java.util.List;

public class ItemSmartIconHeaderBindingImpl extends ItemSmartIconHeaderBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback100;
    private final View.OnClickListener mCallback101;
    private final View.OnClickListener mCallback102;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_33, 16);
        sViewsWithIds.put(R.id.guideline_66, 17);
    }

    public ItemSmartIconHeaderBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, sIncludes, sViewsWithIds));
    }

    private ItemSmartIconHeaderBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[4], objArr[9], objArr[14], objArr[5], objArr[10], objArr[15], objArr[16], objArr[17], objArr[1], objArr[6], objArr[11], objArr[3], objArr[8], objArr[13], objArr[2], objArr[7], objArr[12]);
        this.mDirtyFlags = -1;
        this.gridImage1.setTag((Object) null);
        this.gridImage2.setTag((Object) null);
        this.gridImage3.setTag((Object) null);
        this.gridText1.setTag((Object) null);
        this.gridText2.setTag((Object) null);
        this.gridText3.setTag((Object) null);
        this.icRaises1.setTag((Object) null);
        this.icRaises2.setTag((Object) null);
        this.icRaises3.setTag((Object) null);
        this.imageContainer1.setTag((Object) null);
        this.imageContainer2.setTag((Object) null);
        this.imageContainer3.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvLabel1.setTag((Object) null);
        this.tvLabel2.setTag((Object) null);
        this.tvLabel3.setTag((Object) null);
        setRootTag(view);
        this.mCallback100 = new OnClickListener(this, 1);
        this.mCallback101 = new OnClickListener(this, 2);
        this.mCallback102 = new OnClickListener(this, 3);
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
        if (BR.item == i2) {
            setItem((Item) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPItemRVViewHolder) obj);
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
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeItem((Item) obj, i3);
            case 1:
                return onChangeItemItemsGetInt2((Item) obj, i3);
            case 2:
                return onChangeItemItemsGetInt1((Item) obj, i3);
            case 3:
                return onChangeItemItemsSizeInt2ItemItemsGetInt2JavaLangObjectNull((Item) obj, i3);
            case 4:
                return onChangeItemItemsSizeInt1ItemItemsGetInt1JavaLangObjectNull((Item) obj, i3);
            case 5:
                return onChangeItemItemsSizeInt0ItemItemsGetInt0JavaLangObjectNull((Item) obj, i3);
            case 6:
                return onChangeItemItemsGetInt0((Item) obj, i3);
            default:
                return false;
        }
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

    private boolean onChangeItemItemsGetInt2(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemItemsGetInt1(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeItemItemsSizeInt2ItemItemsGetInt2JavaLangObjectNull(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeItemItemsSizeInt1ItemItemsGetInt1JavaLangObjectNull(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeItemItemsSizeInt0ItemItemsGetInt0JavaLangObjectNull(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeItemItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r59 = this;
            r1 = r59
            monitor-enter(r59)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0382 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0382 }
            monitor-exit(r59)     // Catch:{ all -> 0x0382 }
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = r1.mItem
            com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r6 = r1.mHandler
            r7 = 767(0x2ff, double:3.79E-321)
            long r7 = r7 & r2
            r9 = 517(0x205, double:2.554E-321)
            r15 = 134217728(0x8000000, double:6.63123685E-316)
            r17 = 705(0x2c1, double:3.483E-321)
            r19 = 533(0x215, double:2.633E-321)
            r21 = 523(0x20b, double:2.584E-321)
            r12 = 2
            r25 = 513(0x201, double:2.535E-321)
            r11 = 1
            r27 = 0
            r13 = 0
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x017f
            if (r0 == 0) goto L_0x002e
            java.util.List r0 = r0.getItems()
            goto L_0x0030
        L_0x002e:
            r0 = r27
        L_0x0030:
            if (r0 == 0) goto L_0x0037
            int r7 = r0.size()
            goto L_0x0038
        L_0x0037:
            r7 = 0
        L_0x0038:
            long r30 = r2 & r21
            r8 = 8
            int r14 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0095
            if (r7 <= r12) goto L_0x0044
            r14 = 1
            goto L_0x0045
        L_0x0044:
            r14 = 0
        L_0x0045:
            long r30 = r2 & r25
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0060
            if (r14 == 0) goto L_0x0056
            r30 = 131072(0x20000, double:6.47582E-319)
            long r2 = r2 | r30
            r30 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x005e
        L_0x0056:
            r30 = 65536(0x10000, double:3.2379E-319)
            long r2 = r2 | r30
            r30 = 1048576(0x100000, double:5.180654E-318)
        L_0x005e:
            long r2 = r2 | r30
        L_0x0060:
            long r30 = r2 & r21
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0071
            if (r14 == 0) goto L_0x006c
            r30 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x006f
        L_0x006c:
            r30 = 4194304(0x400000, double:2.0722615E-317)
        L_0x006f:
            long r2 = r2 | r30
        L_0x0071:
            r30 = 515(0x203, double:2.544E-321)
            long r30 = r2 & r30
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0082
            if (r14 == 0) goto L_0x007d
            long r2 = r2 | r15
            goto L_0x0082
        L_0x007d:
            r30 = 67108864(0x4000000, double:3.31561842E-316)
            long r2 = r2 | r30
        L_0x0082:
            long r30 = r2 & r25
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0096
            if (r14 == 0) goto L_0x008d
            r30 = 0
            goto L_0x008f
        L_0x008d:
            r30 = 8
        L_0x008f:
            if (r14 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            r31 = 4
            goto L_0x009a
        L_0x0095:
            r14 = 0
        L_0x0096:
            r30 = 0
        L_0x0098:
            r31 = 0
        L_0x009a:
            long r32 = r2 & r19
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00f9
            if (r7 <= r11) goto L_0x00a5
            r32 = 1
            goto L_0x00a7
        L_0x00a5:
            r32 = 0
        L_0x00a7:
            long r33 = r2 & r25
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00c2
            if (r32 == 0) goto L_0x00b9
            r33 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r33
            r33 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x00c0
        L_0x00b9:
            r33 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r33
            r33 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x00c0:
            long r2 = r2 | r33
        L_0x00c2:
            long r33 = r2 & r9
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00d5
            if (r32 == 0) goto L_0x00d0
            r28 = 33554432(0x2000000, double:1.6578092E-316)
            long r2 = r2 | r28
            goto L_0x00d5
        L_0x00d0:
            r33 = 16777216(0x1000000, double:8.289046E-317)
            long r2 = r2 | r33
        L_0x00d5:
            long r33 = r2 & r19
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00e6
            if (r32 == 0) goto L_0x00e1
            r33 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x00e4
        L_0x00e1:
            r33 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x00e4:
            long r2 = r2 | r33
        L_0x00e6:
            long r33 = r2 & r25
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00fb
            if (r32 == 0) goto L_0x00f1
            r33 = 0
            goto L_0x00f3
        L_0x00f1:
            r33 = 4
        L_0x00f3:
            if (r32 == 0) goto L_0x00f6
            goto L_0x00fd
        L_0x00f6:
            r34 = 8
            goto L_0x00ff
        L_0x00f9:
            r32 = 0
        L_0x00fb:
            r33 = 0
        L_0x00fd:
            r34 = 0
        L_0x00ff:
            r35 = 737(0x2e1, double:3.64E-321)
            long r35 = r2 & r35
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x0172
            if (r7 <= 0) goto L_0x010b
            r7 = 1
            goto L_0x010c
        L_0x010b:
            r7 = 0
        L_0x010c:
            long r35 = r2 & r25
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x0125
            if (r7 == 0) goto L_0x011c
            r35 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2 | r35
            r35 = 524288(0x80000, double:2.590327E-318)
            goto L_0x0123
        L_0x011c:
            r35 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r35
            r35 = 262144(0x40000, double:1.295163E-318)
        L_0x0123:
            long r2 = r2 | r35
        L_0x0125:
            long r35 = r2 & r17
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x0137
            if (r7 == 0) goto L_0x0133
            r23 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r23
            goto L_0x0137
        L_0x0133:
            r35 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r35
        L_0x0137:
            r35 = 609(0x261, double:3.01E-321)
            long r35 = r2 & r35
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x014e
            if (r7 == 0) goto L_0x0147
            r35 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x014c
        L_0x0147:
            r35 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x014c:
            long r2 = r2 | r35
        L_0x014e:
            long r35 = r2 & r25
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x0169
            if (r7 == 0) goto L_0x0157
            r8 = 0
        L_0x0157:
            if (r7 == 0) goto L_0x015c
            r35 = 0
            goto L_0x015e
        L_0x015c:
            r35 = 4
        L_0x015e:
            r39 = r30
            r42 = r31
            r41 = r33
            r38 = r34
            r40 = r35
            goto L_0x0190
        L_0x0169:
            r39 = r30
            r42 = r31
            r41 = r33
            r38 = r34
            goto L_0x017b
        L_0x0172:
            r39 = r30
            r42 = r31
            r41 = r33
            r38 = r34
            r7 = 0
        L_0x017b:
            r8 = 0
            r40 = 0
            goto L_0x0190
        L_0x017f:
            r0 = r27
            r7 = 0
            r8 = 0
            r14 = 0
            r32 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
        L_0x0190:
            long r17 = r2 & r17
            int r30 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x019f
            if (r6 == 0) goto L_0x019f
            android.content.Context r6 = r6.getContext()
            r49 = r6
            goto L_0x01a1
        L_0x019f:
            r49 = r27
        L_0x01a1:
            r17 = 142606336(0x8800000, double:7.04568915E-316)
            long r17 = r2 & r17
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01c7
            if (r0 == 0) goto L_0x01b3
            java.lang.Object r6 = r0.get(r12)
            com.paytmmall.clpartifact.modal.clpCommon.Item r6 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r6
            goto L_0x01b5
        L_0x01b3:
            r6 = r27
        L_0x01b5:
            r1.updateRegistration((int) r11, (androidx.databinding.h) r6)
            long r15 = r15 & r2
            int r17 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x01c4
            if (r6 == 0) goto L_0x01c4
            java.lang.String r15 = r6.getImageUrl()
            goto L_0x01ca
        L_0x01c4:
            r15 = r27
            goto L_0x01ca
        L_0x01c7:
            r6 = r27
            r15 = r6
        L_0x01ca:
            r16 = 570425344(0x22000000, double:2.81827566E-315)
            long r16 = r2 & r16
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x01f6
            if (r0 == 0) goto L_0x01de
            java.lang.Object r16 = r0.get(r11)
            com.paytmmall.clpartifact.modal.clpCommon.Item r16 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r16
            r11 = r16
            goto L_0x01e0
        L_0x01de:
            r11 = r27
        L_0x01e0:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            r17 = 33554432(0x2000000, double:1.6578092E-316)
            long r17 = r2 & r17
            int r28 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x01f3
            if (r11 == 0) goto L_0x01f3
            java.lang.String r17 = r11.getImageUrl()
            goto L_0x01fa
        L_0x01f3:
            r17 = r27
            goto L_0x01fa
        L_0x01f6:
            r11 = r27
            r17 = r11
        L_0x01fa:
            r28 = 8589967360(0x200008000, double:4.2440077715E-314)
            long r28 = r2 & r28
            int r18 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0229
            if (r0 == 0) goto L_0x0210
            java.lang.Object r18 = r0.get(r13)
            com.paytmmall.clpartifact.modal.clpCommon.Item r18 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r18
            r13 = r18
            goto L_0x0212
        L_0x0210:
            r13 = r27
        L_0x0212:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r13)
            r23 = 32768(0x8000, double:1.61895E-319)
            long r23 = r2 & r23
            int r12 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0226
            if (r13 == 0) goto L_0x0226
            java.lang.String r12 = r13.getImageUrl()
            goto L_0x022c
        L_0x0226:
            r12 = r27
            goto L_0x022c
        L_0x0229:
            r12 = r27
            r13 = r12
        L_0x022c:
            if (r30 == 0) goto L_0x0236
            if (r7 == 0) goto L_0x0231
            goto L_0x0233
        L_0x0231:
            java.lang.String r12 = ""
        L_0x0233:
            r44 = r12
            goto L_0x0238
        L_0x0236:
            r44 = r27
        L_0x0238:
            long r21 = r2 & r21
            int r12 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0248
            if (r14 == 0) goto L_0x0241
            goto L_0x0243
        L_0x0241:
            r6 = r27
        L_0x0243:
            r4 = 3
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            goto L_0x024a
        L_0x0248:
            r6 = r27
        L_0x024a:
            long r4 = r2 & r9
            r9 = 0
            int r23 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r23 == 0) goto L_0x025c
            if (r32 == 0) goto L_0x0255
            goto L_0x0259
        L_0x0255:
            java.lang.String r4 = ""
            r17 = r4
        L_0x0259:
            r51 = r17
            goto L_0x025e
        L_0x025c:
            r51 = r27
        L_0x025e:
            r4 = 515(0x203, double:2.544E-321)
            long r4 = r4 & r2
            int r17 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r17 == 0) goto L_0x026c
            if (r14 == 0) goto L_0x0268
            goto L_0x026e
        L_0x0268:
            java.lang.String r4 = ""
            r15 = r4
            goto L_0x026e
        L_0x026c:
            r15 = r27
        L_0x026e:
            long r4 = r2 & r19
            int r14 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x027e
            if (r32 == 0) goto L_0x0277
            goto L_0x0279
        L_0x0277:
            r11 = r27
        L_0x0279:
            r4 = 4
            r1.updateRegistration((int) r4, (androidx.databinding.h) r11)
            goto L_0x0280
        L_0x027e:
            r11 = r27
        L_0x0280:
            r4 = 609(0x261, double:3.01E-321)
            long r4 = r4 & r2
            int r19 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r19 == 0) goto L_0x0291
            if (r7 == 0) goto L_0x028a
            goto L_0x028c
        L_0x028a:
            r13 = r27
        L_0x028c:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            goto L_0x0293
        L_0x0291:
            r13 = r27
        L_0x0293:
            if (r30 == 0) goto L_0x02a4
            android.widget.ImageView r4 = r1.gridImage1
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r43 = r4
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r43, r44, r45, r46, r47, r48, r49)
        L_0x02a4:
            if (r23 == 0) goto L_0x02b7
            android.widget.ImageView r4 = r1.gridImage2
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r50 = r4
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r50, r51, r52, r53, r54, r55, r56)
        L_0x02b7:
            if (r17 == 0) goto L_0x02cc
            android.widget.ImageView r4 = r1.gridImage3
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r52 = r4
            r53 = r15
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r52, r53, r54, r55, r56, r57, r58)
        L_0x02cc:
            long r4 = r2 & r25
            r9 = 0
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0344
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.gridText1
            r4.setVisibility(r8)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.gridText2
            r5 = r38
            r4.setVisibility(r5)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.gridText3
            r7 = r39
            r4.setVisibility(r7)
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r4 = r1.gridText3
            r9 = 2
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.setTextnew(r4, r0, r9)
            android.widget.ImageView r4 = r1.icRaises1
            r9 = r40
            r4.setVisibility(r9)
            android.widget.ImageView r4 = r1.icRaises1
            r10 = 0
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r10)
            android.widget.ImageView r4 = r1.icRaises2
            r10 = r41
            r4.setVisibility(r10)
            android.widget.ImageView r4 = r1.icRaises2
            r15 = 1
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r15)
            android.widget.ImageView r4 = r1.icRaises3
            r4.setVisibility(r7)
            android.widget.ImageView r4 = r1.icRaises3
            r15 = 2
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r15)
            android.view.View r4 = r1.imageContainer1
            r4.setVisibility(r8)
            android.view.View r4 = r1.imageContainer2
            r4.setVisibility(r5)
            android.view.View r4 = r1.imageContainer3
            r4.setVisibility(r7)
            android.widget.TextView r4 = r1.tvLabel1
            r4.setVisibility(r9)
            android.widget.TextView r4 = r1.tvLabel1
            r5 = 0
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r5)
            android.widget.TextView r4 = r1.tvLabel2
            r4.setVisibility(r10)
            android.widget.TextView r4 = r1.tvLabel2
            r5 = 1
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r5)
            android.widget.TextView r4 = r1.tvLabel3
            r5 = r42
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.tvLabel3
            r5 = 2
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.labelVisibility(r4, r0, r5)
        L_0x0344:
            if (r19 == 0) goto L_0x0350
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.gridText1
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.setText(r0, r13)
            android.widget.TextView r0 = r1.tvLabel1
            com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH.setlableText(r0, r13)
        L_0x0350:
            if (r14 == 0) goto L_0x035c
            com.paytmmall.clpartifact.customViews.CLPRobotoTextView r0 = r1.gridText2
            com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader.setText(r0, r11)
            android.widget.TextView r0 = r1.tvLabel2
            com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH.setlableText(r0, r11)
        L_0x035c:
            r4 = 512(0x200, double:2.53E-321)
            long r2 = r2 & r4
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x037a
            android.view.View r0 = r1.imageContainer1
            android.view.View$OnClickListener r2 = r1.mCallback100
            r0.setOnClickListener(r2)
            android.view.View r0 = r1.imageContainer2
            android.view.View$OnClickListener r2 = r1.mCallback101
            r0.setOnClickListener(r2)
            android.view.View r0 = r1.imageContainer3
            android.view.View$OnClickListener r2 = r1.mCallback102
            r0.setOnClickListener(r2)
        L_0x037a:
            if (r12 == 0) goto L_0x0381
            android.widget.TextView r0 = r1.tvLabel3
            com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH.setlableText(r0, r6)
        L_0x0381:
            return
        L_0x0382:
            r0 = move-exception
            monitor-exit(r59)     // Catch:{ all -> 0x0382 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
            Item item = this.mItem;
            Integer num = this.mPosition;
            if (cLPItemRVViewHolder != null) {
                if (item != null) {
                    List<Item> items = item.getItems();
                    if (items == null) {
                        z2 = false;
                    }
                    if (z2) {
                        cLPItemRVViewHolder.handleDeepLink(items.get(0), (num.intValue() * 3) + 0);
                    }
                }
            }
        } else if (i2 == 2) {
            CLPItemRVViewHolder cLPItemRVViewHolder2 = this.mHandler;
            Item item2 = this.mItem;
            Integer num2 = this.mPosition;
            if (cLPItemRVViewHolder2 != null) {
                if (item2 != null) {
                    List<Item> items2 = item2.getItems();
                    if (items2 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemRVViewHolder2.handleDeepLink(items2.get(1), (num2.intValue() * 3) + 1);
                    }
                }
            }
        } else if (i2 == 3) {
            CLPItemRVViewHolder cLPItemRVViewHolder3 = this.mHandler;
            Item item3 = this.mItem;
            Integer num3 = this.mPosition;
            if (cLPItemRVViewHolder3 != null) {
                if (item3 != null) {
                    List<Item> items3 = item3.getItems();
                    if (items3 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemRVViewHolder3.handleDeepLink(items3.get(2), (num3.intValue() * 3) + 2);
                    }
                }
            }
        }
    }
}

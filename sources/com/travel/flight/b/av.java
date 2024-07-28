package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;

public final class av extends au implements a.C0456a {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(9);
        j = bVar;
        bVar.a(0, new String[]{"layout_srp_bottom_strip_oneway_v2"}, new int[]{7}, new int[]{R.layout.layout_srp_bottom_strip_oneway_v2});
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.pullToRefresh, 8);
    }

    public av(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, j, k));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private av(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[5], objArr[3], objArr[2], objArr[8], objArr[1], objArr[6], objArr[4]);
        this.o = -1;
        this.f23637b.setTag((Object) null);
        this.f23638c.setTag((Object) null);
        this.f23639d.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f23641f.setTag((Object) null);
        this.f23642g.setTag((Object) null);
        this.f23643h.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        this.n = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 32;
        }
        this.f23636a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f23636a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.o     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.flight.b.bm r0 = r6.f23636a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.av.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.p != i2) {
            return false;
        }
        a((SRPOneWayViewModel) obj);
        return true;
    }

    public final void a(SRPOneWayViewModel sRPOneWayViewModel) {
        this.f23644i = sRPOneWayViewModel;
        synchronized (this) {
            this.o |= 16;
        }
        notifyPropertyChanged(com.travel.flight.a.p);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f23636a.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 == 2) {
            return c(i3);
        }
        if (i2 != 3) {
            return false;
        }
        return d(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: java.util.ArrayList<com.travel.model.CalendarDatePriceInfo>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: java.util.ArrayList<com.travel.model.CalendarDatePriceInfo>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: java.util.ArrayList<com.travel.model.CalendarDatePriceInfo>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: java.util.ArrayList<com.travel.model.CalendarDatePriceInfo>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v15, resolved type: com.travel.model.CalendarPriceModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v17, resolved type: java.util.ArrayList<com.travel.model.CalendarDatePriceInfo>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r34 = this;
            r1 = r34
            monitor-enter(r34)
            long r2 = r1.o     // Catch:{ all -> 0x0271 }
            r4 = 0
            r1.o = r4     // Catch:{ all -> 0x0271 }
            monitor-exit(r34)     // Catch:{ all -> 0x0271 }
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r0 = r1.f23644i
            r6 = 59
            long r6 = r6 & r2
            r10 = 49
            r12 = 56
            r15 = 524288(0x80000, double:2.590327E-318)
            r17 = 50
            r14 = 1
            r19 = 0
            r8 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x011e
            long r6 = r2 & r12
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0064
            if (r0 == 0) goto L_0x002d
            androidx.lifecycle.y r6 = r0.getOnwardFlightList()
            goto L_0x002f
        L_0x002d:
            r6 = r19
        L_0x002f:
            r7 = 3
            r1.updateLiveDataRegistration(r7, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.getValue()
            com.travel.flight.flightSRPV2.c.a r6 = (com.travel.flight.flightSRPV2.c.a) r6
            goto L_0x003e
        L_0x003c:
            r6 = r19
        L_0x003e:
            if (r6 == 0) goto L_0x0045
            int r7 = r6.size()
            goto L_0x0046
        L_0x0045:
            r7 = 0
        L_0x0046:
            if (r7 <= 0) goto L_0x004a
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            if (r9 == 0) goto L_0x005e
            if (r7 == 0) goto L_0x0056
            r22 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r22
            r22 = 8192(0x2000, double:4.0474E-320)
            goto L_0x005c
        L_0x0056:
            r22 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r22
            r22 = 4096(0x1000, double:2.0237E-320)
        L_0x005c:
            long r2 = r2 | r22
        L_0x005e:
            if (r7 == 0) goto L_0x0061
            goto L_0x0067
        L_0x0061:
            r9 = 8
            goto L_0x0068
        L_0x0064:
            r6 = r19
            r7 = 0
        L_0x0067:
            r9 = 0
        L_0x0068:
            r22 = 51
            long r22 = r2 & r22
            int r24 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r24 == 0) goto L_0x010e
            if (r0 == 0) goto L_0x0077
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r22 = r0.getParentViewModel()
            goto L_0x0079
        L_0x0077:
            r22 = r19
        L_0x0079:
            long r23 = r2 & r10
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x009f
            if (r22 == 0) goto L_0x0088
            androidx.lifecycle.y r23 = r22.getSearchInput()
            r10 = r23
            goto L_0x008a
        L_0x0088:
            r10 = r19
        L_0x008a:
            r1.updateLiveDataRegistration(r8, r10)
            if (r10 == 0) goto L_0x0096
            java.lang.Object r10 = r10.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r10 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r10
            goto L_0x0098
        L_0x0096:
            r10 = r19
        L_0x0098:
            if (r10 == 0) goto L_0x009f
            java.lang.String r10 = r10.getDate()
            goto L_0x00a1
        L_0x009f:
            r10 = r19
        L_0x00a1:
            long r25 = r2 & r17
            int r11 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0102
            if (r22 == 0) goto L_0x00b6
            boolean r25 = r22.isSortFilterEnable()
            androidx.lifecycle.y r26 = r22.getCalendarPriceInfo()
            r8 = r26
            r26 = r25
            goto L_0x00ba
        L_0x00b6:
            r8 = r19
            r26 = 0
        L_0x00ba:
            r1.updateLiveDataRegistration(r14, r8)
            if (r11 == 0) goto L_0x00c8
            if (r26 == 0) goto L_0x00c3
            long r2 = r2 | r15
            goto L_0x00c8
        L_0x00c3:
            r20 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r20
        L_0x00c8:
            if (r8 == 0) goto L_0x00d1
            java.lang.Object r11 = r8.getValue()
            com.travel.model.CalendarPriceModel r11 = (com.travel.model.CalendarPriceModel) r11
            goto L_0x00d3
        L_0x00d1:
            r11 = r19
        L_0x00d3:
            if (r11 == 0) goto L_0x00d9
            java.util.ArrayList r19 = r11.getOnwardDatePriceInfo()
        L_0x00d9:
            if (r19 == 0) goto L_0x00e0
            int r27 = r19.size()
            goto L_0x00e2
        L_0x00e0:
            r27 = 0
        L_0x00e2:
            if (r27 <= 0) goto L_0x00e7
            r28 = 1
            goto L_0x00e9
        L_0x00e7:
            r28 = 0
        L_0x00e9:
            long r29 = r2 & r17
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x00f8
            if (r28 == 0) goto L_0x00f4
            r29 = 128(0x80, double:6.32E-322)
            goto L_0x00f6
        L_0x00f4:
            r29 = 64
        L_0x00f6:
            long r2 = r2 | r29
        L_0x00f8:
            r33 = r9
            r9 = r6
            r6 = r19
            r19 = r11
            r11 = r33
            goto L_0x012d
        L_0x0102:
            r11 = r9
            r8 = r19
            r26 = 0
            r27 = 0
            r28 = 0
            r9 = r6
            r6 = r8
            goto L_0x012d
        L_0x010e:
            r11 = r9
            r8 = r19
            r10 = r8
            r22 = r10
            r26 = 0
            r27 = 0
            r28 = 0
            r9 = r6
            r6 = r22
            goto L_0x012d
        L_0x011e:
            r6 = r19
            r8 = r6
            r9 = r8
            r10 = r9
            r22 = r10
            r7 = 0
            r11 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x012d:
            r29 = 640(0x280, double:3.16E-321)
            long r29 = r2 & r29
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x013b
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r22 = r0.getParentViewModel()
        L_0x013b:
            if (r22 == 0) goto L_0x0141
            boolean r26 = r22.isSortFilterEnable()
        L_0x0141:
            long r29 = r2 & r17
            int r31 = (r29 > r4 ? 1 : (r29 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0150
            if (r26 == 0) goto L_0x014b
            long r2 = r2 | r15
            goto L_0x0150
        L_0x014b:
            r20 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r20
        L_0x0150:
            long r20 = r2 & r17
            int r29 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x0172
            if (r28 == 0) goto L_0x015b
            r20 = r26
            goto L_0x015d
        L_0x015b:
            r20 = 0
        L_0x015d:
            if (r29 == 0) goto L_0x0168
            if (r20 == 0) goto L_0x0164
            r28 = 2048(0x800, double:1.0118E-320)
            goto L_0x0166
        L_0x0164:
            r28 = 1024(0x400, double:5.06E-321)
        L_0x0166:
            long r2 = r2 | r28
        L_0x0168:
            if (r20 == 0) goto L_0x016d
            r20 = 0
            goto L_0x016f
        L_0x016d:
            r20 = 8
        L_0x016f:
            r32 = r20
            goto L_0x0174
        L_0x0172:
            r32 = 0
        L_0x0174:
            long r20 = r2 & r12
            int r28 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0192
            if (r7 == 0) goto L_0x017f
            r7 = r26
            goto L_0x0180
        L_0x017f:
            r7 = 0
        L_0x0180:
            if (r28 == 0) goto L_0x018c
            if (r7 == 0) goto L_0x0188
            r20 = 32768(0x8000, double:1.61895E-319)
            goto L_0x018a
        L_0x0188:
            r20 = 16384(0x4000, double:8.0948E-320)
        L_0x018a:
            long r2 = r2 | r20
        L_0x018c:
            if (r7 == 0) goto L_0x018f
            goto L_0x0192
        L_0x018f:
            r7 = 8
            goto L_0x0193
        L_0x0192:
            r7 = 0
        L_0x0193:
            long r20 = r2 & r15
            r28 = 1048576(0x100000, double:5.180654E-318)
            int r30 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x01c9
            if (r0 == 0) goto L_0x01a2
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r22 = r0.getParentViewModel()
        L_0x01a2:
            if (r22 == 0) goto L_0x01a8
            androidx.lifecycle.y r8 = r22.getCalendarPriceInfo()
        L_0x01a8:
            r1.updateLiveDataRegistration(r14, r8)
            if (r8 == 0) goto L_0x01b5
            java.lang.Object r8 = r8.getValue()
            r19 = r8
            com.travel.model.CalendarPriceModel r19 = (com.travel.model.CalendarPriceModel) r19
        L_0x01b5:
            if (r19 != 0) goto L_0x01b9
            r8 = 1
            goto L_0x01ba
        L_0x01b9:
            r8 = 0
        L_0x01ba:
            if (r30 == 0) goto L_0x01c6
            if (r8 == 0) goto L_0x01c4
            r20 = 2097152(0x200000, double:1.0361308E-317)
            long r2 = r2 | r20
            goto L_0x01c6
        L_0x01c4:
            long r2 = r2 | r28
        L_0x01c6:
            r14 = r22
            goto L_0x01cc
        L_0x01c9:
            r14 = r22
            r8 = 0
        L_0x01cc:
            long r21 = r2 & r28
            int r28 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x01e3
            if (r19 == 0) goto L_0x01d8
            java.util.ArrayList r6 = r19.getOnwardDatePriceInfo()
        L_0x01d8:
            if (r6 == 0) goto L_0x01de
            int r27 = r6.size()
        L_0x01de:
            if (r27 != 0) goto L_0x01e3
            r19 = 1
            goto L_0x01e5
        L_0x01e3:
            r19 = 0
        L_0x01e5:
            long r15 = r15 & r2
            int r21 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x01f1
            if (r8 == 0) goto L_0x01ee
            r8 = 1
            goto L_0x01f2
        L_0x01ee:
            r8 = r19
            goto L_0x01f2
        L_0x01f1:
            r8 = 0
        L_0x01f2:
            long r15 = r2 & r17
            int r19 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x020e
            if (r26 == 0) goto L_0x01fb
            goto L_0x01fc
        L_0x01fb:
            r8 = 0
        L_0x01fc:
            if (r19 == 0) goto L_0x0208
            if (r8 == 0) goto L_0x0204
            r15 = 131072(0x20000, double:6.47582E-319)
            goto L_0x0207
        L_0x0204:
            r15 = 65536(0x10000, double:3.2379E-319)
        L_0x0207:
            long r2 = r2 | r15
        L_0x0208:
            if (r8 == 0) goto L_0x020b
            goto L_0x020e
        L_0x020b:
            r8 = 8
            goto L_0x020f
        L_0x020e:
            r8 = 0
        L_0x020f:
            long r12 = r12 & r2
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0227
            com.travel.flight.b.bm r12 = r1.f23636a
            android.view.View r12 = r12.getRoot()
            r12.setVisibility(r7)
            androidx.recyclerview.widget.RecyclerView r7 = r1.f23642g
            r7.setVisibility(r11)
            androidx.recyclerview.widget.RecyclerView r7 = r1.f23642g
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r7, (com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel) r0, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r9)
        L_0x0227:
            r11 = 48
            long r11 = r11 & r2
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0233
            com.travel.flight.b.bm r7 = r1.f23636a
            r7.a(r0)
        L_0x0233:
            r11 = 32
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0248
            android.widget.ImageView r0 = r1.f23637b
            android.view.View$OnClickListener r7 = r1.n
            r0.setOnClickListener(r7)
            android.widget.ImageView r0 = r1.f23638c
            android.view.View$OnClickListener r7 = r1.m
            r0.setOnClickListener(r7)
        L_0x0248:
            long r11 = r2 & r17
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x025f
            android.widget.LinearLayout r0 = r1.f23639d
            r0.setVisibility(r8)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23641f
            r7 = r32
            r0.setVisibility(r7)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f23641f
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r0, (java.util.List<com.travel.model.CalendarDatePriceInfo>) r6, (com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel) r14)
        L_0x025f:
            r6 = 49
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x026b
            com.paytm.utility.RoboTextView r0 = r1.f23643h
            com.travel.flight.flightSRPV2.c.c.c((android.widget.TextView) r0, (java.lang.String) r10)
        L_0x026b:
            com.travel.flight.b.bm r0 = r1.f23636a
            executeBindingsOn(r0)
            return
        L_0x0271:
            r0 = move-exception
            monitor-exit(r34)     // Catch:{ all -> 0x0271 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.av.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            SRPOneWayViewModel sRPOneWayViewModel = this.f23644i;
            if (sRPOneWayViewModel == null) {
                z2 = false;
            }
            if (z2) {
                sRPOneWayViewModel.fetchDataForNextOrPreviousDay(getRoot().getContext(), false);
            }
        } else if (i2 == 2) {
            SRPOneWayViewModel sRPOneWayViewModel2 = this.f23644i;
            if (sRPOneWayViewModel2 != null) {
                z = true;
            }
            if (z) {
                sRPOneWayViewModel2.fetchDataForNextOrPreviousDay(getRoot().getContext(), true);
            }
        }
    }
}

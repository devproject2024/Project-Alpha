package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;

public final class ap extends ao implements a.C0456a {
    private static final ViewDataBinding.b w = null;
    private static final SparseIntArray x;
    private final ImageView A;
    private final View.OnClickListener B;
    private long C;
    private final ConstraintLayout y;
    private final ImageView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.ll_top_left, 10);
        x.put(R.id.ll_top_right, 11);
        x.put(R.id.top_view_separator, 12);
        x.put(R.id.view_separator_bottom, 13);
        x.put(R.id.view_top_shadow, 14);
        x.put(R.id.flight_price_lyt, 15);
        x.put(R.id.rupees_text, 16);
        x.put(R.id.releative_special_price, 17);
        x.put(R.id.rupees_text_special_price, 18);
        x.put(R.id.bottom_special_price, 19);
        x.put(R.id.fare_for_one_adult_text, 20);
    }

    public ap(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, w, x));
    }

    private ap(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[19], objArr[20], objArr[15], objArr[8], objArr[5], objArr[6], objArr[10], objArr[11], objArr[7], objArr[2], objArr[9], objArr[17], objArr[4], objArr[16], objArr[18], objArr[12], objArr[13], objArr[14]);
        this.C = -1;
        this.f23612d.setTag((Object) null);
        this.f23613e.setTag((Object) null);
        this.f23614f.setTag((Object) null);
        this.f23617i.setTag((Object) null);
        this.y = objArr[0];
        this.y.setTag((Object) null);
        this.z = objArr[1];
        this.z.setTag((Object) null);
        this.A = objArr[3];
        this.A.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.m.setTag((Object) null);
        setRootTag(view);
        this.B = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.C = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.C != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.G == i2) {
            a((IRTSplitViewModel) obj);
        } else if (com.travel.flight.a.k == i2) {
            a((String) obj);
        } else if (com.travel.flight.a.N == i2) {
            b((String) obj);
        } else if (com.travel.flight.a.s != i2) {
            return false;
        } else {
            a((SRPSharedViewModel) obj);
        }
        return true;
    }

    public final void a(IRTSplitViewModel iRTSplitViewModel) {
        this.t = iRTSplitViewModel;
        synchronized (this) {
            this.C |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.G);
        super.requestRebind();
    }

    public final void a(String str) {
        this.u = str;
        synchronized (this) {
            this.C |= 8;
        }
        notifyPropertyChanged(com.travel.flight.a.k);
        super.requestRebind();
    }

    public final void b(String str) {
        this.v = str;
        synchronized (this) {
            this.C |= 16;
        }
        notifyPropertyChanged(com.travel.flight.a.N);
        super.requestRebind();
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.s = sRPSharedViewModel;
        synchronized (this) {
            this.C |= 32;
        }
        notifyPropertyChanged(com.travel.flight.a.s);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.C |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.C |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.C     // Catch:{ all -> 0x00d4 }
            r4 = 0
            r1.C = r4     // Catch:{ all -> 0x00d4 }
            monitor-exit(r20)     // Catch:{ all -> 0x00d4 }
            com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel r0 = r1.t
            java.lang.String r6 = r1.u
            java.lang.String r7 = r1.v
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r1.s
            r9 = 103(0x67, double:5.1E-322)
            long r9 = r9 & r2
            r11 = 1
            r12 = 70
            r14 = 0
            r15 = 0
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x004e
            long r9 = r2 & r12
            int r16 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x004e
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.y r9 = r0.getShowPriceLayout()
            goto L_0x002c
        L_0x002b:
            r9 = r15
        L_0x002c:
            r1.updateLiveDataRegistration(r11, r9)
            if (r9 == 0) goto L_0x0038
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0039
        L_0x0038:
            r9 = r15
        L_0x0039:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            if (r16 == 0) goto L_0x0048
            if (r9 == 0) goto L_0x0044
            r16 = 256(0x100, double:1.265E-321)
            goto L_0x0046
        L_0x0044:
            r16 = 128(0x80, double:6.32E-322)
        L_0x0046:
            long r2 = r2 | r16
        L_0x0048:
            if (r9 == 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r9 = 8
            goto L_0x004f
        L_0x004e:
            r9 = 0
        L_0x004f:
            r16 = 101(0x65, double:5.0E-322)
            long r16 = r2 & r16
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x007c
            if (r8 == 0) goto L_0x005e
            androidx.lifecycle.y r8 = r8.getIrtSplitViewFlightItem()
            goto L_0x005f
        L_0x005e:
            r8 = r15
        L_0x005f:
            r1.updateLiveDataRegistration(r14, r8)
            if (r8 == 0) goto L_0x006b
            java.lang.Object r8 = r8.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r8 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r8
            goto L_0x006c
        L_0x006b:
            r8 = r15
        L_0x006c:
            if (r8 == 0) goto L_0x007a
            java.util.ArrayList r15 = r8.getmIntReturnFlightList()
            java.util.ArrayList r16 = r8.getmIntOnwardFlightList()
            r12 = r15
            r15 = r16
            goto L_0x007e
        L_0x007a:
            r12 = r15
            goto L_0x007e
        L_0x007c:
            r8 = r15
            r12 = r8
        L_0x007e:
            r18 = 97
            long r18 = r2 & r18
            int r13 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0095
            com.paytm.utility.RoboTextView r13 = r1.f23612d
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setFlightFare(r13, r8)
            com.paytm.utility.RoboTextView r13 = r1.j
            com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.setOnwardFlightCountText(r13, r8)
            com.paytm.utility.RoboTextView r13 = r1.m
            com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.setReturnFlightCountText(r13, r8)
        L_0x0095:
            if (r10 == 0) goto L_0x00a1
            androidx.recyclerview.widget.RecyclerView r8 = r1.f23613e
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r8, (com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel) r0, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r15, (boolean) r11)
            androidx.recyclerview.widget.RecyclerView r8 = r1.f23614f
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r8, (com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel) r0, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r12, (boolean) r14)
        L_0x00a1:
            r10 = 70
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00ad
            android.widget.LinearLayout r0 = r1.f23617i
            r0.setVisibility(r9)
        L_0x00ad:
            r8 = 72
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b9
            android.widget.ImageView r0 = r1.z
            com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.setFlightImage(r0, r6)
        L_0x00b9:
            r8 = 80
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c5
            android.widget.ImageView r0 = r1.A
            com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.setFlightImage(r0, r7)
        L_0x00c5:
            r6 = 64
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d3
            android.widget.LinearLayout r0 = r1.k
            android.view.View$OnClickListener r2 = r1.B
            r0.setOnClickListener(r2)
        L_0x00d3:
            return
        L_0x00d4:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00d4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.ap.executeBindings():void");
    }

    public final void a(int i2, View view) {
        IRTSplitViewModel iRTSplitViewModel = this.t;
        SRPSharedViewModel sRPSharedViewModel = this.s;
        boolean z2 = true;
        if (iRTSplitViewModel != null) {
            if (sRPSharedViewModel != null) {
                y<CJRIntlFlightList> irtSplitViewFlightItem = sRPSharedViewModel.getIrtSplitViewFlightItem();
                if (irtSplitViewFlightItem == null) {
                    z2 = false;
                }
                if (z2) {
                    iRTSplitViewModel.proceedToBook(irtSplitViewFlightItem.getValue());
                }
            }
        }
    }
}

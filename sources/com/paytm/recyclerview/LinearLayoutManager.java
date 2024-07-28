package com.paytm.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.e;
import androidx.core.h.u;
import com.paytm.recyclerview.RecyclerView;
import java.util.List;

public final class LinearLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: a  reason: collision with root package name */
    int f15179a;

    /* renamed from: b  reason: collision with root package name */
    e f15180b;

    /* renamed from: c  reason: collision with root package name */
    boolean f15181c;

    /* renamed from: d  reason: collision with root package name */
    int f15182d;

    /* renamed from: e  reason: collision with root package name */
    int f15183e;

    /* renamed from: f  reason: collision with root package name */
    SavedState f15184f;

    /* renamed from: g  reason: collision with root package name */
    final a f15185g;
    private c p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;

    public final RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams();
    }

    public final void a(RecyclerView recyclerView, RecyclerView.j jVar) {
        super.a(recyclerView, jVar);
        if (this.u) {
            b(jVar);
            jVar.a();
        }
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        int i2;
        super.a(accessibilityEvent);
        if (h() > 0) {
            e a2 = androidx.core.h.a.b.a(accessibilityEvent);
            View a3 = a(0, h(), false);
            int i3 = -1;
            if (a3 == null) {
                i2 = -1;
            } else {
                i2 = a(a3);
            }
            a2.f3058a.setFromIndex(i2);
            View a4 = a(h() - 1, -1, false);
            if (a4 != null) {
                i3 = a(a4);
            }
            a2.f3058a.setToIndex(i3);
        }
    }

    public final Parcelable b() {
        SavedState savedState = this.f15184f;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (h() > 0) {
            p();
            boolean z = this.q ^ this.f15181c;
            savedState2.f15188c = z;
            if (z) {
                View s2 = s();
                savedState2.f15187b = this.f15180b.c() - this.f15180b.b(s2);
                savedState2.f15186a = a(s2);
            } else {
                View r2 = r();
                savedState2.f15186a = a(r2);
                savedState2.f15187b = this.f15180b.a(r2) - this.f15180b.b();
            }
        } else {
            savedState2.f15186a = -1;
        }
        return savedState2;
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f15184f = (SavedState) parcelable;
            g();
        }
    }

    public final boolean c() {
        return this.f15179a == 0;
    }

    public final boolean d() {
        return this.f15179a == 1;
    }

    private void n() {
        boolean z = true;
        if (this.f15179a == 1 || !o()) {
            z = this.r;
        } else if (this.r) {
            z = false;
        }
        this.f15181c = z;
    }

    public final View a(int i2) {
        int h2 = h();
        if (h2 == 0) {
            return null;
        }
        int a2 = i2 - a(e(0));
        if (a2 >= 0 && a2 < h2) {
            View e2 = e(a2);
            if (a(e2) == i2) {
                return e2;
            }
        }
        return super.a(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.recyclerview.RecyclerView.j r18, com.paytm.recyclerview.RecyclerView.n r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.paytm.recyclerview.LinearLayoutManager$SavedState r3 = r0.f15184f
            r4 = -1
            if (r3 != 0) goto L_0x000f
            int r3 = r0.f15182d
            if (r3 == r4) goto L_0x0019
        L_0x000f:
            int r3 = r19.a()
            if (r3 != 0) goto L_0x0019
            r17.b((com.paytm.recyclerview.RecyclerView.j) r18)
            return
        L_0x0019:
            com.paytm.recyclerview.LinearLayoutManager$SavedState r3 = r0.f15184f
            if (r3 == 0) goto L_0x0029
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0029
            com.paytm.recyclerview.LinearLayoutManager$SavedState r3 = r0.f15184f
            int r3 = r3.f15186a
            r0.f15182d = r3
        L_0x0029:
            r17.p()
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r5 = 0
            r3.f15197a = r5
            r17.n()
            com.paytm.recyclerview.LinearLayoutManager$a r3 = r0.f15185g
            r3.f15189a = r4
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.f15190b = r6
            r3.f15191c = r5
            boolean r7 = r0.f15181c
            boolean r8 = r0.s
            r7 = r7 ^ r8
            r3.f15191c = r7
            boolean r7 = r2.f15272g
            r8 = 1
            if (r7 != 0) goto L_0x0144
            int r7 = r0.f15182d
            if (r7 != r4) goto L_0x0050
            goto L_0x0144
        L_0x0050:
            if (r7 < 0) goto L_0x0140
            int r9 = r19.a()
            if (r7 < r9) goto L_0x005a
            goto L_0x0140
        L_0x005a:
            int r7 = r0.f15182d
            r3.f15189a = r7
            com.paytm.recyclerview.LinearLayoutManager$SavedState r7 = r0.f15184f
            if (r7 == 0) goto L_0x0090
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x0090
            com.paytm.recyclerview.LinearLayoutManager$SavedState r7 = r0.f15184f
            boolean r7 = r7.f15188c
            r3.f15191c = r7
            boolean r7 = r3.f15191c
            if (r7 == 0) goto L_0x0081
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.c()
            com.paytm.recyclerview.LinearLayoutManager$SavedState r9 = r0.f15184f
            int r9 = r9.f15187b
            int r7 = r7 - r9
            r3.f15190b = r7
            goto L_0x013e
        L_0x0081:
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.b()
            com.paytm.recyclerview.LinearLayoutManager$SavedState r9 = r0.f15184f
            int r9 = r9.f15187b
            int r7 = r7 + r9
            r3.f15190b = r7
            goto L_0x013e
        L_0x0090:
            int r7 = r0.f15183e
            if (r7 != r6) goto L_0x0121
            int r7 = r0.f15182d
            android.view.View r7 = r0.a((int) r7)
            if (r7 == 0) goto L_0x00ff
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r9 = r9.c(r7)
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.e()
            if (r9 <= r10) goto L_0x00af
            r3.a()
            goto L_0x013e
        L_0x00af:
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r9 = r9.a((android.view.View) r7)
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.b()
            int r9 = r9 - r10
            if (r9 >= 0) goto L_0x00ca
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.b()
            r3.f15190b = r7
            r3.f15191c = r5
            goto L_0x013e
        L_0x00ca:
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r9 = r9.c()
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.b((android.view.View) r7)
            int r9 = r9 - r10
            if (r9 >= 0) goto L_0x00e4
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.c()
            r3.f15190b = r7
            r3.f15191c = r8
            goto L_0x013e
        L_0x00e4:
            boolean r9 = r3.f15191c
            if (r9 == 0) goto L_0x00f6
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r7 = r9.b((android.view.View) r7)
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r9 = r9.a()
            int r7 = r7 + r9
            goto L_0x00fc
        L_0x00f6:
            com.paytm.recyclerview.e r9 = r0.f15180b
            int r7 = r9.a((android.view.View) r7)
        L_0x00fc:
            r3.f15190b = r7
            goto L_0x013e
        L_0x00ff:
            int r7 = r17.h()
            if (r7 <= 0) goto L_0x011d
            android.view.View r7 = r0.e((int) r5)
            int r7 = a((android.view.View) r7)
            int r9 = r0.f15182d
            if (r9 >= r7) goto L_0x0113
            r7 = 1
            goto L_0x0114
        L_0x0113:
            r7 = 0
        L_0x0114:
            boolean r9 = r0.f15181c
            if (r7 != r9) goto L_0x011a
            r7 = 1
            goto L_0x011b
        L_0x011a:
            r7 = 0
        L_0x011b:
            r3.f15191c = r7
        L_0x011d:
            r3.a()
            goto L_0x013e
        L_0x0121:
            boolean r7 = r0.f15181c
            r3.f15191c = r7
            if (r7 == 0) goto L_0x0133
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.c()
            int r9 = r0.f15183e
            int r7 = r7 - r9
            r3.f15190b = r7
            goto L_0x013e
        L_0x0133:
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.b()
            int r9 = r0.f15183e
            int r7 = r7 + r9
            r3.f15190b = r7
        L_0x013e:
            r7 = 1
            goto L_0x0145
        L_0x0140:
            r0.f15182d = r4
            r0.f15183e = r6
        L_0x0144:
            r7 = 0
        L_0x0145:
            if (r7 != 0) goto L_0x02ad
            int r7 = r17.h()
            if (r7 == 0) goto L_0x029a
            com.paytm.recyclerview.RecyclerView r7 = r0.f15224i
            if (r7 != 0) goto L_0x0153
        L_0x0151:
            r7 = 0
            goto L_0x0164
        L_0x0153:
            com.paytm.recyclerview.RecyclerView r7 = r0.f15224i
            android.view.View r7 = r7.getFocusedChild()
            if (r7 == 0) goto L_0x0151
            com.paytm.recyclerview.b r10 = r0.f15223h
            boolean r10 = r10.d((android.view.View) r7)
            if (r10 == 0) goto L_0x0164
            goto L_0x0151
        L_0x0164:
            if (r7 == 0) goto L_0x0241
            android.view.ViewGroup$LayoutParams r10 = r7.getLayoutParams()
            com.paytm.recyclerview.RecyclerView$LayoutParams r10 = (com.paytm.recyclerview.RecyclerView.LayoutParams) r10
            com.paytm.recyclerview.RecyclerView$q r11 = r10.f15225a
            boolean r11 = r11.n()
            if (r11 != 0) goto L_0x018a
            com.paytm.recyclerview.RecyclerView$q r11 = r10.f15225a
            int r11 = r11.d()
            if (r11 < 0) goto L_0x018a
            com.paytm.recyclerview.RecyclerView$q r10 = r10.f15225a
            int r10 = r10.d()
            int r11 = r19.a()
            if (r10 >= r11) goto L_0x018a
            r10 = 1
            goto L_0x018b
        L_0x018a:
            r10 = 0
        L_0x018b:
            if (r10 == 0) goto L_0x0241
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r10 = r10.a()
            if (r10 < 0) goto L_0x019c
            r3.a(r7)
            goto L_0x0298
        L_0x019c:
            int r11 = a((android.view.View) r7)
            r3.f15189a = r11
            boolean r11 = r3.f15191c
            if (r11 == 0) goto L_0x01f5
            com.paytm.recyclerview.LinearLayoutManager r11 = r3.f15192d
            com.paytm.recyclerview.e r11 = r11.f15180b
            int r11 = r11.c()
            int r11 = r11 - r10
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r10 = r10.b((android.view.View) r7)
            int r11 = r11 - r10
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r10 = r10.c()
            int r10 = r10 - r11
            r3.f15190b = r10
            if (r11 <= 0) goto L_0x0298
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r10 = r10.c(r7)
            int r12 = r3.f15190b
            int r12 = r12 - r10
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r10 = r10.b()
            com.paytm.recyclerview.LinearLayoutManager r13 = r3.f15192d
            com.paytm.recyclerview.e r13 = r13.f15180b
            int r7 = r13.a((android.view.View) r7)
            int r7 = r7 - r10
            int r7 = java.lang.Math.min(r7, r5)
            int r10 = r10 + r7
            int r12 = r12 - r10
            if (r12 >= 0) goto L_0x0298
            int r7 = r3.f15190b
            int r10 = -r12
            int r10 = java.lang.Math.min(r11, r10)
            int r7 = r7 + r10
            r3.f15190b = r7
            goto L_0x0298
        L_0x01f5:
            com.paytm.recyclerview.LinearLayoutManager r11 = r3.f15192d
            com.paytm.recyclerview.e r11 = r11.f15180b
            int r11 = r11.a((android.view.View) r7)
            com.paytm.recyclerview.LinearLayoutManager r12 = r3.f15192d
            com.paytm.recyclerview.e r12 = r12.f15180b
            int r12 = r12.b()
            int r12 = r11 - r12
            r3.f15190b = r11
            if (r12 <= 0) goto L_0x0298
            com.paytm.recyclerview.LinearLayoutManager r13 = r3.f15192d
            com.paytm.recyclerview.e r13 = r13.f15180b
            int r13 = r13.c(r7)
            int r11 = r11 + r13
            com.paytm.recyclerview.LinearLayoutManager r13 = r3.f15192d
            com.paytm.recyclerview.e r13 = r13.f15180b
            int r13 = r13.c()
            int r13 = r13 - r10
            com.paytm.recyclerview.LinearLayoutManager r10 = r3.f15192d
            com.paytm.recyclerview.e r10 = r10.f15180b
            int r7 = r10.b((android.view.View) r7)
            int r13 = r13 - r7
            com.paytm.recyclerview.LinearLayoutManager r7 = r3.f15192d
            com.paytm.recyclerview.e r7 = r7.f15180b
            int r7 = r7.c()
            int r10 = java.lang.Math.min(r5, r13)
            int r7 = r7 - r10
            int r7 = r7 - r11
            if (r7 >= 0) goto L_0x0298
            int r10 = r3.f15190b
            int r7 = -r7
            int r7 = java.lang.Math.min(r12, r7)
            int r10 = r10 - r7
            r3.f15190b = r10
            goto L_0x0298
        L_0x0241:
            boolean r7 = r0.q
            boolean r10 = r0.s
            if (r7 != r10) goto L_0x029a
            boolean r7 = r3.f15191c
            if (r7 == 0) goto L_0x0250
            android.view.View r7 = r0.k(r2)
            goto L_0x0254
        L_0x0250:
            android.view.View r7 = r0.l(r2)
        L_0x0254:
            if (r7 == 0) goto L_0x029a
            r3.a(r7)
            boolean r10 = r2.f15272g
            if (r10 != 0) goto L_0x0298
            boolean r10 = r17.f()
            if (r10 == 0) goto L_0x0298
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.a((android.view.View) r7)
            com.paytm.recyclerview.e r11 = r0.f15180b
            int r11 = r11.c()
            if (r10 >= r11) goto L_0x0282
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r7 = r10.b((android.view.View) r7)
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.b()
            if (r7 >= r10) goto L_0x0280
            goto L_0x0282
        L_0x0280:
            r7 = 0
            goto L_0x0283
        L_0x0282:
            r7 = 1
        L_0x0283:
            if (r7 == 0) goto L_0x0298
            boolean r7 = r3.f15191c
            if (r7 == 0) goto L_0x0290
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.c()
            goto L_0x0296
        L_0x0290:
            com.paytm.recyclerview.e r7 = r0.f15180b
            int r7 = r7.b()
        L_0x0296:
            r3.f15190b = r7
        L_0x0298:
            r7 = 1
            goto L_0x029b
        L_0x029a:
            r7 = 0
        L_0x029b:
            if (r7 != 0) goto L_0x02ad
            r3.a()
            boolean r7 = r0.s
            if (r7 == 0) goto L_0x02aa
            int r7 = r19.a()
            int r7 = r7 - r8
            goto L_0x02ab
        L_0x02aa:
            r7 = 0
        L_0x02ab:
            r3.f15189a = r7
        L_0x02ad:
            int r3 = r0.g(r2)
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            int r7 = r7.j
            if (r7 < 0) goto L_0x02ba
            r7 = r3
            r3 = 0
            goto L_0x02bb
        L_0x02ba:
            r7 = 0
        L_0x02bb:
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.b()
            int r3 = r3 + r10
            com.paytm.recyclerview.e r10 = r0.f15180b
            int r10 = r10.f()
            int r7 = r7 + r10
            boolean r10 = r2.f15272g
            if (r10 == 0) goto L_0x0304
            int r10 = r0.f15182d
            if (r10 == r4) goto L_0x0304
            int r11 = r0.f15183e
            if (r11 == r6) goto L_0x0304
            android.view.View r10 = r0.a((int) r10)
            if (r10 == 0) goto L_0x0304
            boolean r11 = r0.f15181c
            if (r11 == 0) goto L_0x02ef
            com.paytm.recyclerview.e r11 = r0.f15180b
            int r11 = r11.c()
            com.paytm.recyclerview.e r12 = r0.f15180b
            int r10 = r12.b((android.view.View) r10)
            int r11 = r11 - r10
            int r10 = r0.f15183e
            goto L_0x02fe
        L_0x02ef:
            com.paytm.recyclerview.e r11 = r0.f15180b
            int r10 = r11.a((android.view.View) r10)
            com.paytm.recyclerview.e r11 = r0.f15180b
            int r11 = r11.b()
            int r10 = r10 - r11
            int r11 = r0.f15183e
        L_0x02fe:
            int r11 = r11 - r10
            if (r11 <= 0) goto L_0x0303
            int r3 = r3 + r11
            goto L_0x0304
        L_0x0303:
            int r7 = r7 - r11
        L_0x0304:
            int r10 = r17.h()
            int r10 = r10 - r8
        L_0x0309:
            if (r10 < 0) goto L_0x0346
            android.view.View r11 = r0.e((int) r10)
            com.paytm.recyclerview.RecyclerView$q r12 = com.paytm.recyclerview.RecyclerView.b((android.view.View) r11)
            boolean r13 = r12.c()
            if (r13 != 0) goto L_0x0343
            boolean r13 = r12.k()
            if (r13 == 0) goto L_0x0336
            boolean r13 = r12.n()
            if (r13 != 0) goto L_0x0336
            com.paytm.recyclerview.RecyclerView r13 = r0.f15224i
            com.paytm.recyclerview.RecyclerView$a r13 = r13.y
            boolean r13 = r13.f15231b
            if (r13 != 0) goto L_0x0336
            r0.c((int) r10)
            r1.a((com.paytm.recyclerview.RecyclerView.q) r12)
            goto L_0x0343
        L_0x0336:
            r0.d((int) r10)
            r1.c((android.view.View) r11)
            com.paytm.recyclerview.RecyclerView r11 = r0.f15224i
            com.paytm.recyclerview.i r11 = r11.f15210e
            r11.d(r12)
        L_0x0343:
            int r10 = r10 + -1
            goto L_0x0309
        L_0x0346:
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            boolean r11 = r17.q()
            r10.l = r11
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            boolean r11 = r2.f15272g
            r10.f15205i = r11
            com.paytm.recyclerview.LinearLayoutManager$a r10 = r0.f15185g
            boolean r10 = r10.f15191c
            if (r10 == 0) goto L_0x03ad
            com.paytm.recyclerview.LinearLayoutManager$a r10 = r0.f15185g
            r0.b((com.paytm.recyclerview.LinearLayoutManager.a) r10)
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            r10.f15204h = r3
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r10, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            int r3 = r3.f15198b
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            int r10 = r10.f15200d
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            if (r11 <= 0) goto L_0x0379
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            int r7 = r7 + r11
        L_0x0379:
            com.paytm.recyclerview.LinearLayoutManager$a r11 = r0.f15185g
            r0.a((com.paytm.recyclerview.LinearLayoutManager.a) r11)
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            r11.f15204h = r7
            int r7 = r11.f15200d
            com.paytm.recyclerview.LinearLayoutManager$c r12 = r0.p
            int r12 = r12.f15201e
            int r7 = r7 + r12
            r11.f15200d = r7
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r7, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            int r7 = r7.f15198b
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            if (r11 <= 0) goto L_0x03ff
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            r0.e(r10, r3)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r3.f15204h = r11
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r3, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            int r3 = r3.f15198b
            goto L_0x03ff
        L_0x03ad:
            com.paytm.recyclerview.LinearLayoutManager$a r10 = r0.f15185g
            r0.a((com.paytm.recyclerview.LinearLayoutManager.a) r10)
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            r10.f15204h = r7
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r10, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            int r7 = r7.f15198b
            com.paytm.recyclerview.LinearLayoutManager$c r10 = r0.p
            int r10 = r10.f15200d
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            if (r11 <= 0) goto L_0x03cc
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            int r3 = r3 + r11
        L_0x03cc:
            com.paytm.recyclerview.LinearLayoutManager$a r11 = r0.f15185g
            r0.b((com.paytm.recyclerview.LinearLayoutManager.a) r11)
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            r11.f15204h = r3
            int r3 = r11.f15200d
            com.paytm.recyclerview.LinearLayoutManager$c r12 = r0.p
            int r12 = r12.f15201e
            int r3 = r3 + r12
            r11.f15200d = r3
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r3, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            int r3 = r3.f15198b
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            if (r11 <= 0) goto L_0x03ff
            com.paytm.recyclerview.LinearLayoutManager$c r11 = r0.p
            int r11 = r11.f15199c
            r0.d(r10, r7)
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            r7.f15204h = r11
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r7, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            com.paytm.recyclerview.LinearLayoutManager$c r7 = r0.p
            int r7 = r7.f15198b
        L_0x03ff:
            int r10 = r17.h()
            if (r10 <= 0) goto L_0x0423
            boolean r10 = r0.f15181c
            boolean r11 = r0.s
            r10 = r10 ^ r11
            if (r10 == 0) goto L_0x0417
            int r10 = r0.a((int) r7, (com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r8)
            int r3 = r3 + r10
            int r7 = r7 + r10
            int r10 = r0.b(r3, r1, r2, r5)
            goto L_0x0421
        L_0x0417:
            int r10 = r0.b(r3, r1, r2, r8)
            int r3 = r3 + r10
            int r7 = r7 + r10
            int r10 = r0.a((int) r7, (com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
        L_0x0421:
            int r3 = r3 + r10
            int r7 = r7 + r10
        L_0x0423:
            boolean r10 = r2.f15274i
            if (r10 == 0) goto L_0x04c7
            int r10 = r17.h()
            if (r10 == 0) goto L_0x04c7
            boolean r10 = r2.f15272g
            if (r10 != 0) goto L_0x04c7
            boolean r10 = r17.f()
            if (r10 != 0) goto L_0x0439
            goto L_0x04c7
        L_0x0439:
            java.util.List<com.paytm.recyclerview.RecyclerView$q> r10 = r1.f15246d
            int r11 = r10.size()
            android.view.View r12 = r0.e((int) r5)
            int r12 = a((android.view.View) r12)
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x044a:
            if (r13 >= r11) goto L_0x0485
            java.lang.Object r16 = r10.get(r13)
            r8 = r16
            com.paytm.recyclerview.RecyclerView$q r8 = (com.paytm.recyclerview.RecyclerView.q) r8
            boolean r16 = r8.n()
            if (r16 != 0) goto L_0x047f
            int r6 = r8.d()
            if (r6 >= r12) goto L_0x0462
            r6 = 1
            goto L_0x0463
        L_0x0462:
            r6 = 0
        L_0x0463:
            boolean r9 = r0.f15181c
            if (r6 == r9) goto L_0x0469
            r6 = -1
            goto L_0x046a
        L_0x0469:
            r6 = 1
        L_0x046a:
            if (r6 != r4) goto L_0x0476
            com.paytm.recyclerview.e r6 = r0.f15180b
            android.view.View r8 = r8.f15282a
            int r6 = r6.c(r8)
            int r14 = r14 + r6
            goto L_0x047f
        L_0x0476:
            com.paytm.recyclerview.e r6 = r0.f15180b
            android.view.View r8 = r8.f15282a
            int r6 = r6.c(r8)
            int r15 = r15 + r6
        L_0x047f:
            int r13 = r13 + 1
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 1
            goto L_0x044a
        L_0x0485:
            com.paytm.recyclerview.LinearLayoutManager$c r6 = r0.p
            r6.k = r10
            if (r14 <= 0) goto L_0x04a5
            android.view.View r6 = r17.r()
            int r6 = a((android.view.View) r6)
            r0.e(r6, r3)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r3.f15204h = r14
            r3.f15199c = r5
            r6 = 0
            r3.a((android.view.View) r6)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r3, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
        L_0x04a5:
            if (r15 <= 0) goto L_0x04c2
            android.view.View r3 = r17.s()
            int r3 = a((android.view.View) r3)
            r0.d(r3, r7)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r3.f15204h = r15
            r3.f15199c = r5
            r6 = 0
            r3.a((android.view.View) r6)
            com.paytm.recyclerview.LinearLayoutManager$c r3 = r0.p
            r0.a((com.paytm.recyclerview.RecyclerView.j) r1, (com.paytm.recyclerview.LinearLayoutManager.c) r3, (com.paytm.recyclerview.RecyclerView.n) r2, (boolean) r5)
            goto L_0x04c3
        L_0x04c2:
            r6 = 0
        L_0x04c3:
            com.paytm.recyclerview.LinearLayoutManager$c r1 = r0.p
            r1.k = r6
        L_0x04c7:
            boolean r1 = r2.f15272g
            if (r1 != 0) goto L_0x04d9
            r0.f15182d = r4
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0.f15183e = r1
            com.paytm.recyclerview.e r1 = r0.f15180b
            int r2 = r1.e()
            r1.f15352b = r2
        L_0x04d9:
            boolean r1 = r0.s
            r0.q = r1
            r1 = 0
            r0.f15184f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.LinearLayoutManager.a(com.paytm.recyclerview.RecyclerView$j, com.paytm.recyclerview.RecyclerView$n):void");
    }

    private int a(int i2, RecyclerView.j jVar, RecyclerView.n nVar, boolean z) {
        int c2;
        int c3 = this.f15180b.c() - i2;
        if (c3 <= 0) {
            return 0;
        }
        int i3 = -d(-c3, jVar, nVar);
        int i4 = i2 + i3;
        if (!z || (c2 = this.f15180b.c() - i4) <= 0) {
            return i3;
        }
        this.f15180b.a(c2);
        return c2 + i3;
    }

    private int b(int i2, RecyclerView.j jVar, RecyclerView.n nVar, boolean z) {
        int b2;
        int b3 = i2 - this.f15180b.b();
        if (b3 <= 0) {
            return 0;
        }
        int i3 = -d(b3, jVar, nVar);
        int i4 = i2 + i3;
        if (!z || (b2 = i4 - this.f15180b.b()) <= 0) {
            return i3;
        }
        this.f15180b.a(-b2);
        return i3 - b2;
    }

    private void a(a aVar) {
        d(aVar.f15189a, aVar.f15190b);
    }

    private void d(int i2, int i3) {
        this.p.f15199c = this.f15180b.c() - i3;
        this.p.f15201e = this.f15181c ? -1 : 1;
        c cVar = this.p;
        cVar.f15200d = i2;
        cVar.f15202f = 1;
        cVar.f15198b = i3;
        cVar.f15203g = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        e(aVar.f15189a, aVar.f15190b);
    }

    private void e(int i2, int i3) {
        this.p.f15199c = i3 - this.f15180b.b();
        c cVar = this.p;
        cVar.f15200d = i2;
        cVar.f15201e = this.f15181c ? 1 : -1;
        c cVar2 = this.p;
        cVar2.f15202f = -1;
        cVar2.f15198b = i3;
        cVar2.f15203g = Integer.MIN_VALUE;
    }

    private void p() {
        if (this.p == null) {
            this.p = new c();
        }
        if (this.f15180b == null) {
            this.f15180b = e.a(this, this.f15179a);
        }
    }

    public final void b(int i2) {
        this.f15182d = i2;
        this.f15183e = Integer.MIN_VALUE;
        SavedState savedState = this.f15184f;
        if (savedState != null) {
            savedState.f15186a = -1;
        }
        g();
    }

    public final int a(int i2, RecyclerView.j jVar, RecyclerView.n nVar) {
        if (this.f15179a == 1) {
            return 0;
        }
        return d(i2, jVar, nVar);
    }

    public final int b(int i2, RecyclerView.j jVar, RecyclerView.n nVar) {
        if (this.f15179a == 0) {
            return 0;
        }
        return d(i2, jVar, nVar);
    }

    public final int a(RecyclerView.n nVar) {
        return h(nVar);
    }

    public final int b(RecyclerView.n nVar) {
        return h(nVar);
    }

    public final int c(RecyclerView.n nVar) {
        return i(nVar);
    }

    public final int d(RecyclerView.n nVar) {
        return i(nVar);
    }

    public final int e(RecyclerView.n nVar) {
        return j(nVar);
    }

    public final int f(RecyclerView.n nVar) {
        return j(nVar);
    }

    private int h(RecyclerView.n nVar) {
        if (h() == 0) {
            return 0;
        }
        p();
        return g.a(nVar, this.f15180b, a(!this.t), b(!this.t), this, this.t, this.f15181c);
    }

    private int i(RecyclerView.n nVar) {
        if (h() == 0) {
            return 0;
        }
        p();
        return g.a(nVar, this.f15180b, a(!this.t), b(!this.t), this, this.t);
    }

    private int j(RecyclerView.n nVar) {
        if (h() == 0) {
            return 0;
        }
        p();
        return g.b(nVar, this.f15180b, a(!this.t), b(!this.t), this, this.t);
    }

    private void a(int i2, int i3, boolean z, RecyclerView.n nVar) {
        int i4;
        this.p.l = q();
        this.p.f15204h = g(nVar);
        c cVar = this.p;
        cVar.f15202f = i2;
        int i5 = -1;
        if (i2 == 1) {
            cVar.f15204h += this.f15180b.f();
            View s2 = s();
            c cVar2 = this.p;
            if (!this.f15181c) {
                i5 = 1;
            }
            cVar2.f15201e = i5;
            this.p.f15200d = a(s2) + this.p.f15201e;
            this.p.f15198b = this.f15180b.b(s2);
            i4 = this.f15180b.b(s2) - this.f15180b.c();
        } else {
            View r2 = r();
            this.p.f15204h += this.f15180b.b();
            c cVar3 = this.p;
            if (this.f15181c) {
                i5 = 1;
            }
            cVar3.f15201e = i5;
            this.p.f15200d = a(r2) + this.p.f15201e;
            this.p.f15198b = this.f15180b.a(r2);
            i4 = (-this.f15180b.a(r2)) + this.f15180b.b();
        }
        c cVar4 = this.p;
        cVar4.f15199c = i3;
        if (z) {
            cVar4.f15199c -= i4;
        }
        this.p.f15203g = i4;
    }

    private boolean q() {
        return this.f15180b.g() == 0 && this.f15180b.d() == 0;
    }

    private int d(int i2, RecyclerView.j jVar, RecyclerView.n nVar) {
        if (h() == 0 || i2 == 0) {
            return 0;
        }
        this.p.f15197a = true;
        p();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, nVar);
        int a2 = this.p.f15203g + a(jVar, this.p, nVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.f15180b.a(-i2);
        this.p.j = i2;
        return i2;
    }

    private void a(RecyclerView.j jVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    a(i4, jVar);
                }
                return;
            }
            while (i2 > i3) {
                a(i2, jVar);
                i2--;
            }
        }
    }

    private void a(RecyclerView.j jVar, c cVar) {
        if (cVar.f15197a && !cVar.l) {
            if (cVar.f15202f == -1) {
                int i2 = cVar.f15203g;
                int h2 = h();
                if (i2 >= 0) {
                    int d2 = this.f15180b.d() - i2;
                    if (this.f15181c) {
                        for (int i3 = 0; i3 < h2; i3++) {
                            if (this.f15180b.a(e(i3)) < d2) {
                                a(jVar, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = h2 - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        if (this.f15180b.a(e(i5)) < d2) {
                            a(jVar, i4, i5);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            int i6 = cVar.f15203g;
            if (i6 >= 0) {
                int h3 = h();
                if (this.f15181c) {
                    int i7 = h3 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        if (this.f15180b.b(e(i8)) > i6) {
                            a(jVar, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < h3; i9++) {
                    if (this.f15180b.b(e(i9)) > i6) {
                        a(jVar, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    private int a(RecyclerView.j jVar, c cVar, RecyclerView.n nVar, boolean z) {
        int i2 = cVar.f15199c;
        if (cVar.f15203g != Integer.MIN_VALUE) {
            if (cVar.f15199c < 0) {
                cVar.f15203g += cVar.f15199c;
            }
            a(jVar, cVar);
        }
        int i3 = cVar.f15199c + cVar.f15204h;
        b bVar = new b();
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(nVar)) {
                break;
            }
            bVar.a();
            a(jVar, cVar, bVar);
            if (bVar.f15194b) {
                break;
            }
            cVar.f15198b += bVar.f15193a * cVar.f15202f;
            if (!bVar.f15195c || this.p.k != null || !nVar.f15272g) {
                cVar.f15199c -= bVar.f15193a;
                i3 -= bVar.f15193a;
            }
            if (cVar.f15203g != Integer.MIN_VALUE) {
                cVar.f15203g += bVar.f15193a;
                if (cVar.f15199c < 0) {
                    cVar.f15203g += cVar.f15199c;
                }
                a(jVar, cVar);
            }
            if (z && bVar.f15196d) {
                break;
            }
        }
        return i2 - cVar.f15199c;
    }

    private void a(RecyclerView.j jVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(jVar);
        if (a2 == null) {
            bVar.f15194b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.f15181c == (cVar.f15202f == -1)) {
                b(a2, -1);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.f15181c == (cVar.f15202f == -1)) {
                a(a2, -1);
            } else {
                a(a2, 0);
            }
        }
        b(a2);
        bVar.f15193a = this.f15180b.c(a2);
        if (this.f15179a == 1) {
            if (o()) {
                i6 = this.n - k();
                i4 = i6 - this.f15180b.d(a2);
            } else {
                i4 = i();
                i6 = this.f15180b.d(a2) + i4;
            }
            if (cVar.f15202f == -1) {
                i3 = cVar.f15198b;
                int i7 = i6;
                i5 = cVar.f15198b - bVar.f15193a;
                i2 = i7;
            } else {
                int i8 = cVar.f15198b;
                i3 = cVar.f15198b + bVar.f15193a;
                i2 = i6;
                i5 = i8;
            }
        } else {
            i5 = j();
            int d2 = this.f15180b.d(a2) + i5;
            if (cVar.f15202f == -1) {
                int i9 = cVar.f15198b;
                int i10 = d2;
                i4 = cVar.f15198b - bVar.f15193a;
                i2 = i9;
                i3 = i10;
            } else {
                int i11 = cVar.f15198b;
                i2 = cVar.f15198b + bVar.f15193a;
                int i12 = i11;
                i3 = d2;
                i4 = i12;
            }
        }
        a(a2, i4 + layoutParams.leftMargin, i5 + layoutParams.topMargin, i2 - layoutParams.rightMargin, i3 - layoutParams.bottomMargin);
        if (layoutParams.f15225a.n() || layoutParams.f15225a.t()) {
            bVar.f15195c = true;
        }
        bVar.f15196d = a2.isFocusable();
    }

    private View r() {
        return e(this.f15181c ? h() - 1 : 0);
    }

    private View s() {
        return e(this.f15181c ? 0 : h() - 1);
    }

    private View a(boolean z) {
        if (this.f15181c) {
            return a(h() - 1, -1, z);
        }
        return a(0, h(), z);
    }

    private View b(boolean z) {
        if (this.f15181c) {
            return a(0, h(), z);
        }
        return a(h() - 1, -1, z);
    }

    private View k(RecyclerView.n nVar) {
        if (this.f15181c) {
            return m(nVar);
        }
        return n(nVar);
    }

    private View l(RecyclerView.n nVar) {
        if (this.f15181c) {
            return n(nVar);
        }
        return m(nVar);
    }

    private View m(RecyclerView.n nVar) {
        return b(0, h(), nVar.a());
    }

    private View n(RecyclerView.n nVar) {
        return b(h() - 1, -1, nVar.a());
    }

    private View b(int i2, int i3, int i4) {
        p();
        int b2 = this.f15180b.b();
        int c2 = this.f15180b.c();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View e2 = e(i2);
            int a2 = a(e2);
            if (a2 >= 0 && a2 < i4) {
                if (((RecyclerView.LayoutParams) e2.getLayoutParams()).f15225a.n()) {
                    if (view2 == null) {
                        view2 = e2;
                    }
                } else if (this.f15180b.a(e2) < c2 && this.f15180b.b(e2) >= b2) {
                    return e2;
                } else {
                    if (view == null) {
                        view = e2;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private View a(int i2, int i3, boolean z) {
        p();
        int b2 = this.f15180b.b();
        int c2 = this.f15180b.c();
        int i4 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View e2 = e(i2);
            int a2 = this.f15180b.a(e2);
            int b3 = this.f15180b.b(e2);
            if (a2 < c2 && b3 > b2) {
                if (!z) {
                    return e2;
                }
                if (a2 >= b2 && b3 <= c2) {
                    return e2;
                }
                if (view == null) {
                    view = e2;
                }
            }
            i2 += i4;
        }
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r7.f15179a == 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if (r7.f15179a == 0) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View c(int r8, com.paytm.recyclerview.RecyclerView.j r9, com.paytm.recyclerview.RecyclerView.n r10) {
        /*
            r7 = this;
            r7.n()
            int r0 = r7.h()
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            r0 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            if (r8 == r3) goto L_0x003d
            r4 = 2
            if (r8 == r4) goto L_0x003b
            r4 = 17
            if (r8 == r4) goto L_0x0036
            r4 = 33
            if (r8 == r4) goto L_0x0031
            r4 = 66
            if (r8 == r4) goto L_0x002c
            r4 = 130(0x82, float:1.82E-43)
            if (r8 == r4) goto L_0x0027
        L_0x0024:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x003e
        L_0x0027:
            int r8 = r7.f15179a
            if (r8 != r3) goto L_0x0024
            goto L_0x003b
        L_0x002c:
            int r8 = r7.f15179a
            if (r8 != 0) goto L_0x0024
            goto L_0x003b
        L_0x0031:
            int r8 = r7.f15179a
            if (r8 != r3) goto L_0x0024
            goto L_0x003d
        L_0x0036:
            int r8 = r7.f15179a
            if (r8 != 0) goto L_0x0024
            goto L_0x003d
        L_0x003b:
            r8 = 1
            goto L_0x003e
        L_0x003d:
            r8 = -1
        L_0x003e:
            if (r8 != r2) goto L_0x0041
            return r1
        L_0x0041:
            r7.p()
            if (r8 != r0) goto L_0x004b
            android.view.View r4 = r7.l(r10)
            goto L_0x004f
        L_0x004b:
            android.view.View r4 = r7.k(r10)
        L_0x004f:
            if (r4 != 0) goto L_0x0052
            return r1
        L_0x0052:
            r7.p()
            r5 = 1051372203(0x3eaaaaab, float:0.33333334)
            com.paytm.recyclerview.e r6 = r7.f15180b
            int r6 = r6.e()
            float r6 = (float) r6
            float r6 = r6 * r5
            int r5 = (int) r6
            r6 = 0
            r7.a((int) r8, (int) r5, (boolean) r6, (com.paytm.recyclerview.RecyclerView.n) r10)
            com.paytm.recyclerview.LinearLayoutManager$c r5 = r7.p
            r5.f15203g = r2
            r5.f15197a = r6
            r7.a((com.paytm.recyclerview.RecyclerView.j) r9, (com.paytm.recyclerview.LinearLayoutManager.c) r5, (com.paytm.recyclerview.RecyclerView.n) r10, (boolean) r3)
            if (r8 != r0) goto L_0x0076
            android.view.View r8 = r7.r()
            goto L_0x007a
        L_0x0076:
            android.view.View r8 = r7.s()
        L_0x007a:
            if (r8 == r4) goto L_0x0084
            boolean r9 = r8.isFocusable()
            if (r9 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            return r8
        L_0x0084:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.LinearLayoutManager.c(int, com.paytm.recyclerview.RecyclerView$j, com.paytm.recyclerview.RecyclerView$n):android.view.View");
    }

    public final boolean f() {
        return this.f15184f == null && this.q == this.s;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f15197a = true;

        /* renamed from: b  reason: collision with root package name */
        int f15198b;

        /* renamed from: c  reason: collision with root package name */
        int f15199c;

        /* renamed from: d  reason: collision with root package name */
        int f15200d;

        /* renamed from: e  reason: collision with root package name */
        int f15201e;

        /* renamed from: f  reason: collision with root package name */
        int f15202f;

        /* renamed from: g  reason: collision with root package name */
        int f15203g;

        /* renamed from: h  reason: collision with root package name */
        int f15204h = 0;

        /* renamed from: i  reason: collision with root package name */
        boolean f15205i = false;
        int j;
        List<RecyclerView.q> k = null;
        boolean l;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(RecyclerView.n nVar) {
            int i2 = this.f15200d;
            return i2 >= 0 && i2 < nVar.a();
        }

        /* access modifiers changed from: package-private */
        public final View a(RecyclerView.j jVar) {
            if (this.k != null) {
                return a();
            }
            View a2 = jVar.a(this.f15200d);
            this.f15200d += this.f15201e;
            return a2;
        }

        private View a() {
            int size = this.k.size();
            int i2 = 0;
            while (i2 < size) {
                View view = this.k.get(i2).f15282a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.f15225a.n() || this.f15200d != layoutParams.f15225a.d()) {
                    i2++;
                } else {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public final void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f15200d = -1;
            } else {
                this.f15200d = ((RecyclerView.LayoutParams) b2.getLayoutParams()).f15225a.d();
            }
        }

        private View b(View view) {
            int d2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).f15282a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.f15225a.n() && (d2 = (layoutParams.f15225a.d() - this.f15200d) * this.f15201e) >= 0 && d2 < i2) {
                    view2 = view3;
                    if (d2 == 0) {
                        break;
                    }
                    i2 = d2;
                }
            }
            return view2;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f15186a;

        /* renamed from: b  reason: collision with root package name */
        int f15187b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15188c;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f15186a = parcel.readInt();
            this.f15187b = parcel.readInt();
            this.f15188c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f15186a = savedState.f15186a;
            this.f15187b = savedState.f15187b;
            this.f15188c = savedState.f15188c;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f15186a >= 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f15186a);
            parcel.writeInt(this.f15187b);
            parcel.writeInt(this.f15188c ? 1 : 0);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f15189a;

        /* renamed from: b  reason: collision with root package name */
        int f15190b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15191c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f15192d;

        /* access modifiers changed from: package-private */
        public final void a() {
            int i2;
            if (this.f15191c) {
                i2 = this.f15192d.f15180b.c();
            } else {
                i2 = this.f15192d.f15180b.b();
            }
            this.f15190b = i2;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f15189a + ", mCoordinate=" + this.f15190b + ", mLayoutFromEnd=" + this.f15191c + '}';
        }

        public final void a(View view) {
            if (this.f15191c) {
                this.f15190b = this.f15192d.f15180b.b(view) + this.f15192d.f15180b.a();
            } else {
                this.f15190b = this.f15192d.f15180b.a(view);
            }
            this.f15189a = LinearLayoutManager.a(view);
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f15193a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15194b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15195c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15196d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f15193a = 0;
            this.f15194b = false;
            this.f15195c = false;
            this.f15196d = false;
        }
    }

    private int g(RecyclerView.n nVar) {
        if (nVar.f15266a != -1) {
            return this.f15180b.e();
        }
        return 0;
    }

    private boolean o() {
        return u.j(this.f15224i) == 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        boolean z;
        if (!(this.m == 1073741824 || this.l == 1073741824)) {
            int h2 = h();
            int i2 = 0;
            while (true) {
                if (i2 >= h2) {
                    z = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = e(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}

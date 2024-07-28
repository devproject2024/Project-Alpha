package androidx.fragment.app;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.a.f;
import androidx.core.app.o;
import androidx.core.h.u;
import androidx.fragment.app.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3477a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final t f3478b = (Build.VERSION.SDK_INT >= 21 ? new s() : null);

    /* renamed from: c  reason: collision with root package name */
    private static final t f3479c = b();

    interface a {
        void a(Fragment fragment, androidx.core.d.b bVar);

        void b(Fragment fragment, androidx.core.d.b bVar);
    }

    private static t b() {
        try {
            return (t) Class.forName("androidx.transition.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        r9 = r10.f3511a;
        r14 = r10.f3514d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x022c, code lost:
        r3 = r10.f3511a;
        r4 = r10.f3514d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01aa A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(androidx.fragment.app.j r42, java.util.ArrayList<androidx.fragment.app.a> r43, java.util.ArrayList<java.lang.Boolean> r44, int r45, int r46, boolean r47, androidx.fragment.app.r.a r48) {
        /*
            r0 = r42
            r1 = r43
            r2 = r44
            r3 = r46
            r4 = r47
            r5 = r48
            int r6 = r0.j
            if (r6 > 0) goto L_0x0011
            return
        L_0x0011:
            android.util.SparseArray r6 = new android.util.SparseArray
            r6.<init>()
            r7 = r45
        L_0x0018:
            if (r7 >= r3) goto L_0x0036
            java.lang.Object r8 = r1.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r2.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0030
            b((androidx.fragment.app.a) r8, (android.util.SparseArray<androidx.fragment.app.r.b>) r6, (boolean) r4)
            goto L_0x0033
        L_0x0030:
            a((androidx.fragment.app.a) r8, (android.util.SparseArray<androidx.fragment.app.r.b>) r6, (boolean) r4)
        L_0x0033:
            int r7 = r7 + 1
            goto L_0x0018
        L_0x0036:
            int r7 = r6.size()
            if (r7 == 0) goto L_0x03bb
            android.view.View r7 = new android.view.View
            androidx.fragment.app.g<?> r8 = r0.k
            android.content.Context r8 = r8.f3416c
            r7.<init>(r8)
            int r15 = r6.size()
            r13 = 0
        L_0x004a:
            if (r13 >= r15) goto L_0x03bb
            int r8 = r6.keyAt(r13)
            r12 = r45
            androidx.a.a r11 = a((int) r8, (java.util.ArrayList<androidx.fragment.app.a>) r1, (java.util.ArrayList<java.lang.Boolean>) r2, (int) r12, (int) r3)
            java.lang.Object r9 = r6.valueAt(r13)
            r10 = r9
            androidx.fragment.app.r$b r10 = (androidx.fragment.app.r.b) r10
            r21 = 0
            if (r4 == 0) goto L_0x020c
            androidx.fragment.app.d r9 = r0.l
            boolean r9 = r9.a()
            if (r9 == 0) goto L_0x0072
            androidx.fragment.app.d r9 = r0.l
            android.view.View r8 = r9.a(r8)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            goto L_0x0074
        L_0x0072:
            r8 = r21
        L_0x0074:
            if (r8 == 0) goto L_0x0202
            androidx.fragment.app.Fragment r9 = r10.f3511a
            androidx.fragment.app.Fragment r14 = r10.f3514d
            androidx.fragment.app.t r1 = a((androidx.fragment.app.Fragment) r14, (androidx.fragment.app.Fragment) r9)
            if (r1 == 0) goto L_0x0202
            boolean r2 = r10.f3512b
            boolean r3 = r10.f3515e
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r37 = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.Object r12 = a((androidx.fragment.app.t) r1, (androidx.fragment.app.Fragment) r9, (boolean) r2)
            java.lang.Object r3 = b((androidx.fragment.app.t) r1, (androidx.fragment.app.Fragment) r14, (boolean) r3)
            r38 = r13
            androidx.fragment.app.Fragment r13 = r10.f3511a
            r39 = r15
            androidx.fragment.app.Fragment r15 = r10.f3514d
            if (r13 == 0) goto L_0x00aa
            android.view.View r0 = r13.requireView()
            r5 = 0
            r0.setVisibility(r5)
        L_0x00aa:
            if (r13 == 0) goto L_0x014f
            if (r15 != 0) goto L_0x00b0
            goto L_0x014f
        L_0x00b0:
            boolean r0 = r10.f3512b
            boolean r5 = r11.isEmpty()
            if (r5 == 0) goto L_0x00bd
            r16 = r2
            r5 = r21
            goto L_0x00c3
        L_0x00bd:
            java.lang.Object r5 = a((androidx.fragment.app.t) r1, (androidx.fragment.app.Fragment) r13, (androidx.fragment.app.Fragment) r15, (boolean) r0)
            r16 = r2
        L_0x00c3:
            androidx.a.a r2 = b(r1, r11, r5, r10)
            r17 = r9
            androidx.a.a r9 = a((androidx.fragment.app.t) r1, (androidx.a.a<java.lang.String, java.lang.String>) r11, (java.lang.Object) r5, (androidx.fragment.app.r.b) r10)
            boolean r18 = r11.isEmpty()
            if (r18 == 0) goto L_0x00e0
            if (r2 == 0) goto L_0x00d8
            r2.clear()
        L_0x00d8:
            if (r9 == 0) goto L_0x00dd
            r9.clear()
        L_0x00dd:
            r5 = r21
            goto L_0x00f2
        L_0x00e0:
            r18 = r5
            java.util.Set r5 = r11.keySet()
            a((java.util.ArrayList<android.view.View>) r6, (androidx.a.a<java.lang.String, android.view.View>) r2, (java.util.Collection<java.lang.String>) r5)
            java.util.Collection r5 = r11.values()
            a((java.util.ArrayList<android.view.View>) r4, (androidx.a.a<java.lang.String, android.view.View>) r9, (java.util.Collection<java.lang.String>) r5)
            r5 = r18
        L_0x00f2:
            if (r12 != 0) goto L_0x00fd
            if (r3 != 0) goto L_0x00fd
            if (r5 != 0) goto L_0x00fd
            r41 = r4
        L_0x00fa:
            r40 = r11
            goto L_0x0156
        L_0x00fd:
            a((androidx.fragment.app.Fragment) r13, (androidx.fragment.app.Fragment) r15, (boolean) r0, (androidx.a.a<java.lang.String, android.view.View>) r2)
            if (r5 == 0) goto L_0x0132
            r4.add(r7)
            r1.a((java.lang.Object) r5, (android.view.View) r7, (java.util.ArrayList<android.view.View>) r6)
            r40 = r11
            boolean r11 = r10.f3515e
            r41 = r4
            androidx.fragment.app.a r4 = r10.f3516f
            r22 = r1
            r23 = r5
            r24 = r3
            r25 = r2
            r26 = r11
            r27 = r4
            a((androidx.fragment.app.t) r22, (java.lang.Object) r23, (java.lang.Object) r24, (androidx.a.a<java.lang.String, android.view.View>) r25, (boolean) r26, (androidx.fragment.app.a) r27)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r21 = a((androidx.a.a<java.lang.String, android.view.View>) r9, (androidx.fragment.app.r.b) r10, (java.lang.Object) r12, (boolean) r0)
            if (r21 == 0) goto L_0x012d
            r1.a((java.lang.Object) r12, (android.graphics.Rect) r2)
        L_0x012d:
            r36 = r2
            r34 = r21
            goto L_0x013a
        L_0x0132:
            r41 = r4
            r40 = r11
            r34 = r21
            r36 = r34
        L_0x013a:
            androidx.fragment.app.r$5 r2 = new androidx.fragment.app.r$5
            r29 = r2
            r30 = r13
            r31 = r15
            r32 = r0
            r33 = r9
            r35 = r1
            r29.<init>(r30, r31, r32, r33, r34, r35, r36)
            androidx.core.h.r.a(r8, r2)
            goto L_0x0158
        L_0x014f:
            r16 = r2
            r41 = r4
            r17 = r9
            goto L_0x00fa
        L_0x0156:
            r5 = r21
        L_0x0158:
            if (r12 != 0) goto L_0x0163
            if (r5 != 0) goto L_0x0163
            if (r3 == 0) goto L_0x015f
            goto L_0x0163
        L_0x015f:
            r15 = r48
            goto L_0x01ff
        L_0x0163:
            java.util.ArrayList r0 = a((androidx.fragment.app.t) r1, (java.lang.Object) r3, (androidx.fragment.app.Fragment) r14, (java.util.ArrayList<android.view.View>) r6, (android.view.View) r7)
            r2 = r17
            r4 = r41
            java.util.ArrayList r9 = a((androidx.fragment.app.t) r1, (java.lang.Object) r12, (androidx.fragment.app.Fragment) r2, (java.util.ArrayList<android.view.View>) r4, (android.view.View) r7)
            r10 = 4
            a((java.util.ArrayList<android.view.View>) r9, (int) r10)
            r22 = r1
            r23 = r12
            r24 = r3
            r25 = r5
            r26 = r2
            r27 = r16
            java.lang.Object r2 = a((androidx.fragment.app.t) r22, (java.lang.Object) r23, (java.lang.Object) r24, (java.lang.Object) r25, (androidx.fragment.app.Fragment) r26, (boolean) r27)
            if (r14 == 0) goto L_0x01a6
            if (r0 == 0) goto L_0x01a6
            int r10 = r0.size()
            if (r10 > 0) goto L_0x0193
            int r10 = r6.size()
            if (r10 <= 0) goto L_0x01a6
        L_0x0193:
            androidx.core.d.b r10 = new androidx.core.d.b
            r10.<init>()
            r15 = r48
            r15.a(r14, r10)
            androidx.fragment.app.r$1 r11 = new androidx.fragment.app.r$1
            r11.<init>(r15, r14, r10)
            r1.a((java.lang.Object) r2, (java.lang.Runnable) r11)
            goto L_0x01a8
        L_0x01a6:
            r15 = r48
        L_0x01a8:
            if (r2 == 0) goto L_0x01ff
            if (r14 == 0) goto L_0x01cf
            if (r3 == 0) goto L_0x01cf
            boolean r10 = r14.mAdded
            if (r10 == 0) goto L_0x01cf
            boolean r10 = r14.mHidden
            if (r10 == 0) goto L_0x01cf
            boolean r10 = r14.mHiddenChanged
            if (r10 == 0) goto L_0x01cf
            r10 = 1
            r14.setHideReplaced(r10)
            android.view.View r10 = r14.getView()
            r1.b((java.lang.Object) r3, (android.view.View) r10, (java.util.ArrayList<android.view.View>) r0)
            android.view.ViewGroup r10 = r14.mContainer
            androidx.fragment.app.r$2 r11 = new androidx.fragment.app.r$2
            r11.<init>(r0)
            androidx.core.h.r.a(r10, r11)
        L_0x01cf:
            java.util.ArrayList r20 = androidx.fragment.app.t.a((java.util.ArrayList<android.view.View>) r4)
            r29 = r1
            r30 = r2
            r31 = r12
            r32 = r9
            r33 = r3
            r34 = r0
            r35 = r5
            r36 = r4
            r29.a(r30, r31, r32, r33, r34, r35, r36)
            r1.a((android.view.ViewGroup) r8, (java.lang.Object) r2)
            r16 = r1
            r17 = r8
            r18 = r6
            r19 = r4
            r21 = r40
            r16.a(r17, r18, r19, r20, r21)
            r0 = 0
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r1.a((java.lang.Object) r5, (java.util.ArrayList<android.view.View>) r6, (java.util.ArrayList<android.view.View>) r4)
            goto L_0x03a1
        L_0x01ff:
            r0 = 0
            goto L_0x03a1
        L_0x0202:
            r37 = r6
            r38 = r13
            r39 = r15
            r0 = 0
            r15 = r5
            goto L_0x03a1
        L_0x020c:
            r1 = r0
            r37 = r6
            r40 = r11
            r38 = r13
            r39 = r15
            r0 = 0
            r15 = r5
            androidx.fragment.app.d r2 = r1.l
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0228
            androidx.fragment.app.d r2 = r1.l
            android.view.View r2 = r2.a(r8)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            goto L_0x022a
        L_0x0228:
            r2 = r21
        L_0x022a:
            if (r2 == 0) goto L_0x03a1
            androidx.fragment.app.Fragment r3 = r10.f3511a
            androidx.fragment.app.Fragment r4 = r10.f3514d
            androidx.fragment.app.t r5 = a((androidx.fragment.app.Fragment) r4, (androidx.fragment.app.Fragment) r3)
            if (r5 == 0) goto L_0x03a1
            boolean r6 = r10.f3512b
            boolean r8 = r10.f3515e
            java.lang.Object r6 = a((androidx.fragment.app.t) r5, (androidx.fragment.app.Fragment) r3, (boolean) r6)
            java.lang.Object r14 = b((androidx.fragment.app.t) r5, (androidx.fragment.app.Fragment) r4, (boolean) r8)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            androidx.fragment.app.Fragment r11 = r10.f3511a
            androidx.fragment.app.Fragment r9 = r10.f3514d
            if (r11 == 0) goto L_0x0305
            if (r9 != 0) goto L_0x0256
            goto L_0x0305
        L_0x0256:
            boolean r8 = r10.f3512b
            boolean r16 = r40.isEmpty()
            if (r16 == 0) goto L_0x0265
            r16 = r12
            r1 = r21
            r0 = r40
            goto L_0x026f
        L_0x0265:
            java.lang.Object r16 = a((androidx.fragment.app.t) r5, (androidx.fragment.app.Fragment) r11, (androidx.fragment.app.Fragment) r9, (boolean) r8)
            r1 = r16
            r0 = r40
            r16 = r12
        L_0x026f:
            androidx.a.a r12 = b(r5, r0, r1, r10)
            boolean r17 = r0.isEmpty()
            if (r17 == 0) goto L_0x027c
            r1 = r21
            goto L_0x0287
        L_0x027c:
            r17 = r1
            java.util.Collection r1 = r12.values()
            r13.addAll(r1)
            r1 = r17
        L_0x0287:
            if (r6 != 0) goto L_0x02a0
            if (r14 != 0) goto L_0x02a0
            if (r1 != 0) goto L_0x02a0
            r40 = r0
            r22 = r10
            r26 = r13
            r0 = r14
            r23 = r16
            r17 = r21
            r25 = r38
            r28 = r39
            r27 = 0
            goto L_0x0314
        L_0x02a0:
            a((androidx.fragment.app.Fragment) r11, (androidx.fragment.app.Fragment) r9, (boolean) r8, (androidx.a.a<java.lang.String, android.view.View>) r12)
            if (r1 == 0) goto L_0x02ce
            r17 = r8
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r5.a((java.lang.Object) r1, (android.view.View) r7, (java.util.ArrayList<android.view.View>) r13)
            r18 = r9
            boolean r9 = r10.f3515e
            r19 = r11
            androidx.fragment.app.a r11 = r10.f3516f
            r22 = r5
            r23 = r1
            r24 = r14
            r25 = r12
            r26 = r9
            r27 = r11
            a((androidx.fragment.app.t) r22, (java.lang.Object) r23, (java.lang.Object) r24, (androidx.a.a<java.lang.String, android.view.View>) r25, (boolean) r26, (androidx.fragment.app.a) r27)
            if (r6 == 0) goto L_0x02cb
            r5.a((java.lang.Object) r6, (android.graphics.Rect) r8)
        L_0x02cb:
            r20 = r8
            goto L_0x02d6
        L_0x02ce:
            r17 = r8
            r18 = r9
            r19 = r11
            r20 = r21
        L_0x02d6:
            androidx.fragment.app.r$6 r12 = new androidx.fragment.app.r$6
            r8 = r12
            r9 = r5
            r11 = r10
            r10 = r0
            r22 = r11
            r11 = r1
            r24 = r1
            r1 = r12
            r23 = r16
            r12 = r22
            r26 = r13
            r25 = r38
            r13 = r23
            r40 = r0
            r0 = r14
            r27 = 0
            r14 = r7
            r28 = r39
            r15 = r19
            r16 = r18
            r18 = r26
            r19 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.core.h.r.a(r2, r1)
            r17 = r24
            goto L_0x0314
        L_0x0305:
            r22 = r10
            r23 = r12
            r26 = r13
            r0 = r14
            r25 = r38
            r28 = r39
            r27 = 0
            r17 = r21
        L_0x0314:
            if (r6 != 0) goto L_0x031a
            if (r17 != 0) goto L_0x031a
            if (r0 == 0) goto L_0x03a7
        L_0x031a:
            r1 = r26
            java.util.ArrayList r19 = a((androidx.fragment.app.t) r5, (java.lang.Object) r0, (androidx.fragment.app.Fragment) r4, (java.util.ArrayList<android.view.View>) r1, (android.view.View) r7)
            if (r19 == 0) goto L_0x0328
            boolean r8 = r19.isEmpty()
            if (r8 == 0) goto L_0x032a
        L_0x0328:
            r0 = r21
        L_0x032a:
            r5.b(r6, r7)
            r9 = r22
            boolean r8 = r9.f3512b
            r11 = r5
            r12 = r6
            r13 = r0
            r14 = r17
            r15 = r3
            r16 = r8
            java.lang.Object r10 = a((androidx.fragment.app.t) r11, (java.lang.Object) r12, (java.lang.Object) r13, (java.lang.Object) r14, (androidx.fragment.app.Fragment) r15, (boolean) r16)
            if (r4 == 0) goto L_0x0360
            if (r19 == 0) goto L_0x0360
            int r8 = r19.size()
            if (r8 > 0) goto L_0x034d
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0360
        L_0x034d:
            androidx.core.d.b r1 = new androidx.core.d.b
            r1.<init>()
            r9 = r48
            r9.a(r4, r1)
            androidx.fragment.app.r$3 r8 = new androidx.fragment.app.r$3
            r8.<init>(r9, r4, r1)
            r5.a((java.lang.Object) r10, (java.lang.Runnable) r8)
            goto L_0x0362
        L_0x0360:
            r9 = r48
        L_0x0362:
            if (r10 == 0) goto L_0x03a7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11 = r5
            r12 = r10
            r13 = r6
            r14 = r1
            r15 = r0
            r16 = r19
            r18 = r23
            r11.a(r12, r13, r14, r15, r16, r17, r18)
            androidx.fragment.app.r$4 r4 = new androidx.fragment.app.r$4
            r8 = r4
            r9 = r6
            r6 = r10
            r10 = r5
            r11 = r7
            r12 = r3
            r13 = r23
            r15 = r19
            r16 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            androidx.core.h.r.a(r2, r4)
            androidx.fragment.app.t$2 r0 = new androidx.fragment.app.t$2
            r3 = r23
            r1 = r40
            r0.<init>(r3, r1)
            androidx.core.h.r.a(r2, r0)
            r5.a((android.view.ViewGroup) r2, (java.lang.Object) r6)
            androidx.fragment.app.t$3 r0 = new androidx.fragment.app.t$3
            r0.<init>(r3, r1)
            androidx.core.h.r.a(r2, r0)
            goto L_0x03a7
        L_0x03a1:
            r25 = r38
            r28 = r39
            r27 = 0
        L_0x03a7:
            int r13 = r25 + 1
            r0 = r42
            r1 = r43
            r2 = r44
            r3 = r46
            r4 = r47
            r5 = r48
            r15 = r28
            r6 = r37
            goto L_0x004a
        L_0x03bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.a(androidx.fragment.app.j, java.util.ArrayList, java.util.ArrayList, int, int, boolean, androidx.fragment.app.r$a):void");
    }

    private static androidx.a.a<String, String> a(int i2, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        androidx.a.a<String, String> aVar = new androidx.a.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a aVar2 = arrayList.get(i5);
            if (aVar2.b(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                if (aVar2.q != null) {
                    int size = aVar2.q.size();
                    if (booleanValue) {
                        ArrayList arrayList5 = aVar2.q;
                        arrayList3 = aVar2.r;
                        arrayList4 = arrayList5;
                    } else {
                        arrayList3 = aVar2.q;
                        arrayList4 = aVar2.r;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = (String) arrayList3.get(i6);
                        String str2 = (String) arrayList4.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static t a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        t tVar = f3478b;
        if (tVar != null && a(tVar, (List<Object>) arrayList)) {
            return f3478b;
        }
        t tVar2 = f3479c;
        if (tVar2 != null && a(tVar2, (List<Object>) arrayList)) {
            return f3479c;
        }
        if (f3478b == null && f3479c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(t tVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!tVar.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(t tVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return tVar.c(tVar.b(obj));
    }

    private static Object a(t tVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return tVar.b(obj);
    }

    private static Object b(t tVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return tVar.b(obj);
    }

    private static void a(ArrayList<View> arrayList, androidx.a.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(u.x(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static androidx.a.a<String, View> b(t tVar, androidx.a.a<String, String> aVar, Object obj, b bVar) {
        o oVar;
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.f3514d;
        androidx.a.a<String, View> aVar2 = new androidx.a.a<>();
        tVar.a((Map<String, View>) aVar2, fragment.requireView());
        a aVar3 = bVar.f3516f;
        if (bVar.f3515e) {
            oVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.r;
        } else {
            oVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.q;
        }
        if (arrayList != null) {
            f.a(aVar2, (Collection<?>) arrayList);
        }
        if (oVar != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(u.x(view))) {
                    aVar.put(u.x(view), aVar.remove(str));
                }
            }
        } else {
            f.a(aVar, (Collection<?>) aVar2.keySet());
        }
        return aVar2;
    }

    static androidx.a.a<String, View> a(t tVar, androidx.a.a<String, String> aVar, Object obj, b bVar) {
        o oVar;
        ArrayList arrayList;
        String a2;
        Fragment fragment = bVar.f3511a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.a.a<String, View> aVar2 = new androidx.a.a<>();
        tVar.a((Map<String, View>) aVar2, view);
        a aVar3 = bVar.f3513c;
        if (bVar.f3512b) {
            oVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.q;
        } else {
            oVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.r;
        }
        if (arrayList != null) {
            f.a(aVar2, (Collection<?>) arrayList);
            f.a(aVar2, (Collection<?>) aVar.values());
        }
        if (oVar != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = aVar2.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(u.x(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, u.x(view2));
                }
            }
        } else {
            for (int size2 = aVar.size() - 1; size2 >= 0; size2--) {
                if (!aVar2.containsKey(aVar.c(size2))) {
                    aVar.d(size2);
                }
            }
        }
        return aVar2;
    }

    private static String a(androidx.a.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.c(i2))) {
                return aVar.b(i2);
            }
        }
        return null;
    }

    static View a(androidx.a.a<String, View> aVar, b bVar, Object obj, boolean z) {
        String str;
        a aVar2 = bVar.f3513c;
        if (obj == null || aVar == null || aVar2.q == null || aVar2.q.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) aVar2.q.get(0);
        } else {
            str = (String) aVar2.r.get(0);
        }
        return aVar.get(str);
    }

    private static void a(t tVar, Object obj, Object obj2, androidx.a.a<String, View> aVar, boolean z, a aVar2) {
        String str;
        if (aVar2.q != null && !aVar2.q.isEmpty()) {
            if (z) {
                str = (String) aVar2.r.get(0);
            } else {
                str = (String) aVar2.q.get(0);
            }
            View view = aVar.get(str);
            tVar.a(obj, view);
            if (obj2 != null) {
                tVar.a(obj2, view);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, androidx.a.a<String, View> aVar) {
        o oVar;
        int i2;
        if (z) {
            oVar = fragment2.getEnterTransitionCallback();
        } else {
            oVar = fragment.getEnterTransitionCallback();
        }
        if (oVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar == null) {
                i2 = 0;
            } else {
                i2 = aVar.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList2.add(aVar.b(i3));
                arrayList.add(aVar.c(i3));
            }
        }
    }

    static ArrayList<View> a(t tVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            tVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        tVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    private static Object a(t tVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return tVar.a(obj2, obj, obj3);
        }
        return tVar.b(obj2, obj, obj3);
    }

    private static void a(a aVar, SparseArray<b> sparseArray, boolean z) {
        int size = aVar.f3463d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(aVar, (q.a) aVar.f3463d.get(i2), sparseArray, false, z);
        }
    }

    private static void b(a aVar, SparseArray<b> sparseArray, boolean z) {
        if (aVar.f3388a.l.a()) {
            for (int size = aVar.f3463d.size() - 1; size >= 0; size--) {
                a(aVar, (q.a) aVar.f3463d.get(size), sparseArray, true, z);
            }
        }
    }

    static boolean a() {
        return (f3478b == null && f3479c == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008c, code lost:
        if (r0.mHidden == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00db A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.a r8, androidx.fragment.app.q.a r9, android.util.SparseArray<androidx.fragment.app.r.b> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f3470b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f3477a
            int r9 = r9.f3469a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f3469a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x0081
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x0081
            r9 = 0
        L_0x0029:
            r4 = 0
            r5 = 0
            goto L_0x0094
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0090
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0090
            goto L_0x008e
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x0091
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0072
        L_0x004d:
            goto L_0x0070
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x004d
        L_0x0057:
            if (r12 == 0) goto L_0x0074
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0072
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0072
            android.view.View r9 = r0.mView
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0072
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0072
        L_0x0070:
            r9 = 1
            goto L_0x007d
        L_0x0072:
            r9 = 0
            goto L_0x007d
        L_0x0074:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x0070
        L_0x007d:
            r5 = r9
            r9 = 0
            r4 = 1
            goto L_0x0094
        L_0x0081:
            if (r12 == 0) goto L_0x0086
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x0091
        L_0x0086:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0090
        L_0x008e:
            r9 = 1
            goto L_0x0091
        L_0x0090:
            r9 = 0
        L_0x0091:
            r2 = r9
            r9 = 1
            goto L_0x0029
        L_0x0094:
            java.lang.Object r6 = r10.get(r1)
            androidx.fragment.app.r$b r6 = (androidx.fragment.app.r.b) r6
            if (r2 == 0) goto L_0x00a6
            androidx.fragment.app.r$b r6 = a((androidx.fragment.app.r.b) r6, (android.util.SparseArray<androidx.fragment.app.r.b>) r10, (int) r1)
            r6.f3511a = r0
            r6.f3512b = r11
            r6.f3513c = r8
        L_0x00a6:
            r2 = 0
            if (r12 != 0) goto L_0x00c7
            if (r9 == 0) goto L_0x00c7
            if (r6 == 0) goto L_0x00b3
            androidx.fragment.app.Fragment r9 = r6.f3514d
            if (r9 != r0) goto L_0x00b3
            r6.f3514d = r2
        L_0x00b3:
            androidx.fragment.app.j r9 = r8.f3388a
            int r7 = r0.mState
            if (r7 > 0) goto L_0x00c7
            int r7 = r9.j
            if (r7 <= 0) goto L_0x00c7
            boolean r7 = r8.s
            if (r7 != 0) goto L_0x00c7
            r9.i(r0)
            r9.a((androidx.fragment.app.Fragment) r0, (int) r3)
        L_0x00c7:
            if (r5 == 0) goto L_0x00d9
            if (r6 == 0) goto L_0x00cf
            androidx.fragment.app.Fragment r9 = r6.f3514d
            if (r9 != 0) goto L_0x00d9
        L_0x00cf:
            androidx.fragment.app.r$b r6 = a((androidx.fragment.app.r.b) r6, (android.util.SparseArray<androidx.fragment.app.r.b>) r10, (int) r1)
            r6.f3514d = r0
            r6.f3515e = r11
            r6.f3516f = r8
        L_0x00d9:
            if (r12 != 0) goto L_0x00e5
            if (r4 == 0) goto L_0x00e5
            if (r6 == 0) goto L_0x00e5
            androidx.fragment.app.Fragment r8 = r6.f3511a
            if (r8 != r0) goto L_0x00e5
            r6.f3511a = r2
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.a(androidx.fragment.app.a, androidx.fragment.app.q$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static b a(b bVar, SparseArray<b> sparseArray, int i2) {
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        sparseArray.put(i2, bVar2);
        return bVar2;
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f3511a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3512b;

        /* renamed from: c  reason: collision with root package name */
        public a f3513c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f3514d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3515e;

        /* renamed from: f  reason: collision with root package name */
        public a f3516f;

        b() {
        }
    }
}

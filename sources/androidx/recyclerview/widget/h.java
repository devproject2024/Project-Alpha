package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<f> f4253a = new Comparator<f>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            f fVar = (f) obj;
            f fVar2 = (f) obj2;
            int i2 = fVar.f4268a - fVar2.f4268a;
            return i2 == 0 ? fVar.f4269b - fVar2.f4269b : i2;
        }
    };

    public static abstract class a {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static abstract class c<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);
    }

    public static b a(a aVar) {
        return b(aVar);
    }

    public static b b(a aVar) {
        int oldListSize = aVar.getOldListSize();
        int newListSize = aVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(oldListSize, newListSize));
        int abs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar = (e) arrayList2.remove(arrayList2.size() - 1);
            f a2 = a(aVar, eVar.f4264a, eVar.f4265b, eVar.f4266c, eVar.f4267d, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.f4270c > 0) {
                    arrayList.add(a2);
                }
                a2.f4268a += eVar.f4264a;
                a2.f4269b += eVar.f4266c;
                e eVar2 = arrayList3.isEmpty() ? new e() : (e) arrayList3.remove(arrayList3.size() - 1);
                eVar2.f4264a = eVar.f4264a;
                eVar2.f4266c = eVar.f4266c;
                if (a2.f4272e) {
                    eVar2.f4265b = a2.f4268a;
                    eVar2.f4267d = a2.f4269b;
                } else if (a2.f4271d) {
                    eVar2.f4265b = a2.f4268a - 1;
                    eVar2.f4267d = a2.f4269b;
                } else {
                    eVar2.f4265b = a2.f4268a;
                    eVar2.f4267d = a2.f4269b - 1;
                }
                arrayList2.add(eVar2);
                if (!a2.f4272e) {
                    eVar.f4264a = a2.f4268a + a2.f4270c;
                    eVar.f4266c = a2.f4269b + a2.f4270c;
                } else if (a2.f4271d) {
                    eVar.f4264a = a2.f4268a + a2.f4270c + 1;
                    eVar.f4266c = a2.f4269b + a2.f4270c;
                } else {
                    eVar.f4264a = a2.f4268a + a2.f4270c;
                    eVar.f4266c = a2.f4269b + a2.f4270c + 1;
                }
                arrayList2.add(eVar);
            } else {
                arrayList3.add(eVar);
            }
        }
        Collections.sort(arrayList, f4253a);
        return new b(aVar, arrayList, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1[r13 - 1] < r1[r13 + r7]) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        if (r2[r13 - 1] < r2[r13 + 1]) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[LOOP:1: B:10:0x0033->B:33:0x009c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.recyclerview.widget.h.f a(androidx.recyclerview.widget.h.a r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            r0 = r19
            r1 = r24
            r2 = r25
            int r3 = r21 - r20
            int r4 = r23 - r22
            if (r3 <= 0) goto L_0x0133
            if (r4 > 0) goto L_0x0010
            goto L_0x0133
        L_0x0010:
            int r5 = r3 - r4
            int r6 = r3 + r4
            r7 = 1
            int r6 = r6 + r7
            int r6 = r6 / 2
            int r8 = r26 - r6
            int r8 = r8 - r7
            int r9 = r26 + r6
            int r9 = r9 + r7
            r10 = 0
            java.util.Arrays.fill(r1, r8, r9, r10)
            int r8 = r8 + r5
            int r9 = r9 + r5
            java.util.Arrays.fill(r2, r8, r9, r3)
            int r8 = r5 % 2
            if (r8 == 0) goto L_0x002d
            r8 = 1
            goto L_0x002e
        L_0x002d:
            r8 = 0
        L_0x002e:
            r9 = 0
        L_0x002f:
            if (r9 > r6) goto L_0x012b
            int r11 = -r9
            r12 = r11
        L_0x0033:
            if (r12 > r9) goto L_0x00a2
            if (r12 == r11) goto L_0x004d
            if (r12 == r9) goto L_0x0045
            int r13 = r26 + r12
            int r14 = r13 + -1
            r14 = r1[r14]
            int r13 = r13 + r7
            r13 = r1[r13]
            if (r14 >= r13) goto L_0x0045
            goto L_0x004d
        L_0x0045:
            int r13 = r26 + r12
            int r13 = r13 - r7
            r13 = r1[r13]
            int r13 = r13 + r7
            r14 = 1
            goto L_0x0053
        L_0x004d:
            int r13 = r26 + r12
            int r13 = r13 + r7
            r13 = r1[r13]
            r14 = 0
        L_0x0053:
            int r15 = r13 - r12
        L_0x0055:
            if (r13 >= r3) goto L_0x006a
            if (r15 >= r4) goto L_0x006a
            int r10 = r20 + r13
            int r7 = r22 + r15
            boolean r7 = r0.areItemsTheSame(r10, r7)
            if (r7 == 0) goto L_0x006a
            int r13 = r13 + 1
            int r15 = r15 + 1
            r7 = 1
            r10 = 0
            goto L_0x0055
        L_0x006a:
            int r7 = r26 + r12
            r1[r7] = r13
            if (r8 == 0) goto L_0x009c
            int r10 = r5 - r9
            r13 = 1
            int r10 = r10 + r13
            if (r12 < r10) goto L_0x009c
            int r10 = r5 + r9
            int r10 = r10 - r13
            if (r12 > r10) goto L_0x009c
            r10 = r1[r7]
            r13 = r2[r7]
            if (r10 < r13) goto L_0x009c
            androidx.recyclerview.widget.h$f r0 = new androidx.recyclerview.widget.h$f
            r0.<init>()
            r3 = r2[r7]
            r0.f4268a = r3
            int r3 = r0.f4268a
            int r3 = r3 - r12
            r0.f4269b = r3
            r1 = r1[r7]
            r2 = r2[r7]
            int r1 = r1 - r2
            r0.f4270c = r1
            r0.f4271d = r14
            r7 = 0
            r0.f4272e = r7
            return r0
        L_0x009c:
            r7 = 0
            int r12 = r12 + 2
            r7 = 1
            r10 = 0
            goto L_0x0033
        L_0x00a2:
            r7 = 0
            r10 = r11
        L_0x00a4:
            if (r10 > r9) goto L_0x0120
            int r12 = r10 + r5
            int r13 = r9 + r5
            if (r12 == r13) goto L_0x00c6
            int r13 = r11 + r5
            if (r12 == r13) goto L_0x00bd
            int r13 = r26 + r12
            int r14 = r13 + -1
            r14 = r2[r14]
            r15 = 1
            int r13 = r13 + r15
            r13 = r2[r13]
            if (r14 >= r13) goto L_0x00be
            goto L_0x00c7
        L_0x00bd:
            r15 = 1
        L_0x00be:
            int r13 = r26 + r12
            int r13 = r13 + r15
            r13 = r2[r13]
            int r13 = r13 - r15
            r14 = 1
            goto L_0x00cd
        L_0x00c6:
            r15 = 1
        L_0x00c7:
            int r13 = r26 + r12
            int r13 = r13 - r15
            r13 = r2[r13]
            r14 = 0
        L_0x00cd:
            int r16 = r13 - r12
        L_0x00cf:
            if (r13 <= 0) goto L_0x00ec
            if (r16 <= 0) goto L_0x00ec
            int r17 = r20 + r13
            int r7 = r17 + -1
            int r17 = r22 + r16
            r18 = r3
            int r3 = r17 + -1
            boolean r3 = r0.areItemsTheSame(r7, r3)
            if (r3 == 0) goto L_0x00ee
            int r13 = r13 + -1
            int r16 = r16 + -1
            r3 = r18
            r7 = 0
            r15 = 1
            goto L_0x00cf
        L_0x00ec:
            r18 = r3
        L_0x00ee:
            int r3 = r26 + r12
            r2[r3] = r13
            if (r8 != 0) goto L_0x0119
            if (r12 < r11) goto L_0x0119
            if (r12 > r9) goto L_0x0119
            r7 = r1[r3]
            r13 = r2[r3]
            if (r7 < r13) goto L_0x0119
            androidx.recyclerview.widget.h$f r0 = new androidx.recyclerview.widget.h$f
            r0.<init>()
            r4 = r2[r3]
            r0.f4268a = r4
            int r4 = r0.f4268a
            int r4 = r4 - r12
            r0.f4269b = r4
            r1 = r1[r3]
            r2 = r2[r3]
            int r1 = r1 - r2
            r0.f4270c = r1
            r0.f4271d = r14
            r3 = 1
            r0.f4272e = r3
            return r0
        L_0x0119:
            r3 = 1
            int r10 = r10 + 2
            r3 = r18
            r7 = 0
            goto L_0x00a4
        L_0x0120:
            r18 = r3
            r3 = 1
            int r9 = r9 + 1
            r3 = r18
            r7 = 1
            r10 = 0
            goto L_0x002f
        L_0x012b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation."
            r0.<init>(r1)
            throw r0
        L_0x0133:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h.a(androidx.recyclerview.widget.h$a, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.h$f");
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        int f4268a;

        /* renamed from: b  reason: collision with root package name */
        int f4269b;

        /* renamed from: c  reason: collision with root package name */
        int f4270c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4271d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4272e;

        f() {
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        int f4264a;

        /* renamed from: b  reason: collision with root package name */
        int f4265b;

        /* renamed from: c  reason: collision with root package name */
        int f4266c;

        /* renamed from: d  reason: collision with root package name */
        int f4267d;

        public e() {
        }

        public e(int i2, int i3) {
            this.f4264a = 0;
            this.f4265b = i2;
            this.f4266c = 0;
            this.f4267d = i3;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<f> f4254a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f4255b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f4256c;

        /* renamed from: d  reason: collision with root package name */
        private final a f4257d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4258e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4259f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f4260g = true;

        b(a aVar, List<f> list, int[] iArr, int[] iArr2) {
            this.f4254a = list;
            this.f4255b = iArr;
            this.f4256c = iArr2;
            Arrays.fill(this.f4255b, 0);
            Arrays.fill(this.f4256c, 0);
            this.f4257d = aVar;
            this.f4258e = aVar.getOldListSize();
            this.f4259f = aVar.getNewListSize();
            f fVar = this.f4254a.isEmpty() ? null : this.f4254a.get(0);
            if (!(fVar != null && fVar.f4268a == 0 && fVar.f4269b == 0)) {
                f fVar2 = new f();
                fVar2.f4268a = 0;
                fVar2.f4269b = 0;
                fVar2.f4271d = false;
                fVar2.f4270c = 0;
                fVar2.f4272e = false;
                this.f4254a.add(0, fVar2);
            }
            a();
        }

        private void a() {
            int i2 = this.f4258e;
            int i3 = this.f4259f;
            for (int size = this.f4254a.size() - 1; size >= 0; size--) {
                f fVar = this.f4254a.get(size);
                int i4 = fVar.f4268a + fVar.f4270c;
                int i5 = fVar.f4269b + fVar.f4270c;
                if (this.f4260g) {
                    while (i2 > i4) {
                        if (this.f4255b[i2 - 1] == 0) {
                            a(i2, i3, size, false);
                        }
                        i2--;
                    }
                    while (i3 > i5) {
                        if (this.f4256c[i3 - 1] == 0) {
                            a(i2, i3, size, true);
                        }
                        i3--;
                    }
                }
                for (int i6 = 0; i6 < fVar.f4270c; i6++) {
                    int i7 = fVar.f4268a + i6;
                    int i8 = fVar.f4269b + i6;
                    int i9 = this.f4257d.areContentsTheSame(i7, i8) ? 1 : 2;
                    this.f4255b[i7] = (i8 << 5) | i9;
                    this.f4256c[i8] = (i7 << 5) | i9;
                }
                i2 = fVar.f4268a;
                i3 = fVar.f4269b;
            }
        }

        private boolean a(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i6 = i2 - 1;
                i5 = i6;
            }
            while (i4 >= 0) {
                f fVar = this.f4254a.get(i4);
                int i7 = fVar.f4268a + fVar.f4270c;
                int i8 = fVar.f4269b + fVar.f4270c;
                int i9 = 8;
                if (z) {
                    for (int i10 = i6 - 1; i10 >= i7; i10--) {
                        if (this.f4257d.areItemsTheSame(i10, i5)) {
                            if (!this.f4257d.areContentsTheSame(i10, i5)) {
                                i9 = 4;
                            }
                            this.f4256c[i5] = (i10 << 5) | 16;
                            this.f4255b[i10] = (i5 << 5) | i9;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i11 = i3 - 1; i11 >= i8; i11--) {
                        if (this.f4257d.areItemsTheSame(i5, i11)) {
                            if (!this.f4257d.areContentsTheSame(i5, i11)) {
                                i9 = 4;
                            }
                            int i12 = i2 - 1;
                            this.f4255b[i12] = (i11 << 5) | 16;
                            this.f4256c[i11] = (i12 << 5) | i9;
                            return true;
                        }
                    }
                    continue;
                }
                i6 = fVar.f4268a;
                i3 = fVar.f4269b;
                i4--;
            }
            return false;
        }

        public final void a(RecyclerView.a aVar) {
            a((s) new b(aVar));
        }

        public final void a(s sVar) {
            e eVar;
            if (sVar instanceof e) {
                eVar = (e) sVar;
            } else {
                eVar = new e(sVar);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.f4258e;
            int i3 = this.f4259f;
            for (int size = this.f4254a.size() - 1; size >= 0; size--) {
                f fVar = this.f4254a.get(size);
                int i4 = fVar.f4270c;
                int i5 = fVar.f4268a + i4;
                int i6 = fVar.f4269b + i4;
                if (i5 < i2) {
                    b(arrayList, eVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    a(arrayList, eVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    if ((this.f4255b[fVar.f4268a + i7] & 31) == 2) {
                        eVar.a(fVar.f4268a + i7, 1, this.f4257d.getChangePayload(fVar.f4268a + i7, fVar.f4269b + i7));
                    }
                }
                i2 = fVar.f4268a;
                i3 = fVar.f4269b;
            }
            eVar.a();
        }

        private static d a(List<d> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = list.get(size);
                if (dVar.f4261a == i2 && dVar.f4263c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f4262b += z ? 1 : -1;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<d> list, s sVar, int i2, int i3, int i4) {
            if (!this.f4260g) {
                sVar.a(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f4256c[i6] & 31;
                if (i7 == 0) {
                    sVar.a(i2, 1);
                    for (d dVar : list) {
                        dVar.f4262b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f4256c[i6] >> 5;
                    sVar.c(a(list, i8, true).f4262b, i2);
                    if (i7 == 4) {
                        sVar.a(i2, 1, this.f4257d.getChangePayload(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString((long) i7));
                }
            }
        }

        private void b(List<d> list, s sVar, int i2, int i3, int i4) {
            if (!this.f4260g) {
                sVar.b(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f4255b[i6] & 31;
                if (i7 == 0) {
                    sVar.b(i2 + i5, 1);
                    for (d dVar : list) {
                        dVar.f4262b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f4255b[i6] >> 5;
                    d a2 = a(list, i8, false);
                    sVar.c(i2 + i5, a2.f4262b - 1);
                    if (i7 == 4) {
                        sVar.a(a2.f4262b - 1, 1, this.f4257d.getChangePayload(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2 + i5, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString((long) i7));
                }
            }
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        int f4261a;

        /* renamed from: b  reason: collision with root package name */
        int f4262b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4263c;

        public d(int i2, int i3, boolean z) {
            this.f4261a = i2;
            this.f4262b = i3;
            this.f4263c = z;
        }
    }
}

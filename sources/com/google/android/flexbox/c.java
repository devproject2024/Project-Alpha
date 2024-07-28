package com.google.android.flexbox;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class c {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f8022c = (!c.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    int[] f8023a;

    /* renamed from: b  reason: collision with root package name */
    long[] f8024b;

    /* renamed from: d  reason: collision with root package name */
    private final a f8025d;

    /* renamed from: e  reason: collision with root package name */
    private boolean[] f8026e;

    /* renamed from: f  reason: collision with root package name */
    private long[] f8027f;

    static int a(long j) {
        return (int) j;
    }

    static int b(long j) {
        return (int) (j >> 32);
    }

    private static long b(int i2, int i3) {
        return (((long) i2) & 4294967295L) | (((long) i3) << 32);
    }

    c(a aVar) {
        this.f8025d = aVar;
    }

    /* access modifiers changed from: package-private */
    public final int[] a(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f8025d.getFlexItemCount();
        List<b> e2 = e(flexItemCount);
        b bVar = new b((byte) 0);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            bVar.f8031b = 1;
        } else {
            bVar.f8031b = ((FlexItem) layoutParams).c();
        }
        if (i2 == -1 || i2 == flexItemCount) {
            bVar.f8030a = flexItemCount;
        } else if (i2 < this.f8025d.getFlexItemCount()) {
            bVar.f8030a = i2;
            while (i2 < flexItemCount) {
                e2.get(i2).f8030a++;
                i2++;
            }
        } else {
            bVar.f8030a = flexItemCount;
        }
        e2.add(bVar);
        return a(flexItemCount + 1, e2, sparseIntArray);
    }

    /* access modifiers changed from: package-private */
    public final int[] a(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f8025d.getFlexItemCount();
        return a(flexItemCount, e(flexItemCount), sparseIntArray);
    }

    private List<b> e(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            b bVar = new b((byte) 0);
            bVar.f8031b = ((FlexItem) this.f8025d.a(i3).getLayoutParams()).c();
            bVar.f8030a = i3;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f8025d.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View a2 = this.f8025d.a(i2);
            if (a2 != null && ((FlexItem) a2.getLayoutParams()).c() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    private static int[] a(int i2, List<b> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (b next : list) {
            iArr[i3] = next.f8030a;
            sparseIntArray.append(next.f8030a, next.f8031b);
            i3++;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        a(aVar, i2, i3, i4, i5, -1, list);
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        a(aVar, i2, i3, i4, 0, i5, list);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3) {
        a(aVar, i3, i2, Integer.MAX_VALUE, 0, -1, (List<b>) null);
    }

    /* access modifiers changed from: package-private */
    public final void c(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        a(aVar, i3, i2, i4, i5, -1, list);
    }

    /* access modifiers changed from: package-private */
    public final void d(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        a(aVar, i3, i2, i4, 0, i5, list);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3, int i4, int i5, int i6, List<b> list) {
        int i7;
        int i8;
        a aVar2;
        int i9;
        int i10;
        List<b> list2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View view;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        b bVar;
        a aVar3 = aVar;
        int i21 = i2;
        int i22 = i3;
        int i23 = i6;
        boolean a2 = this.f8025d.a();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        aVar3.f8028a = arrayList;
        boolean z = i23 == -1;
        int a3 = a(a2);
        int b2 = b(a2);
        int c2 = c(a2);
        int d2 = d(a2);
        b bVar2 = new b();
        int i24 = i5;
        bVar2.o = i24;
        int i25 = b2 + a3;
        bVar2.f8017e = i25;
        int flexItemCount = this.f8025d.getFlexItemCount();
        boolean z2 = z;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = Integer.MIN_VALUE;
        while (true) {
            if (i7 >= flexItemCount) {
                i8 = i27;
                aVar2 = aVar;
                break;
            }
            View b3 = this.f8025d.b(i7);
            if (b3 == null) {
                if (a(i7, flexItemCount, bVar2)) {
                    a(arrayList, bVar2, i7, i26);
                }
            } else if (b3.getVisibility() == 8) {
                bVar2.f8021i++;
                bVar2.f8020h++;
                if (a(i7, flexItemCount, bVar2)) {
                    a(arrayList, bVar2, i7, i26);
                }
            } else {
                FlexItem flexItem = (FlexItem) b3.getLayoutParams();
                int i30 = flexItemCount;
                if (flexItem.f() == 4) {
                    bVar2.n.add(Integer.valueOf(i7));
                }
                int a4 = a(flexItem, a2);
                if (flexItem.l() != -1.0f && mode == 1073741824) {
                    a4 = Math.round(((float) size) * flexItem.l());
                }
                if (a2) {
                    int a5 = this.f8025d.a(i21, i25 + c(flexItem, true) + d(flexItem, true), a4);
                    i10 = size;
                    i9 = mode;
                    int b4 = this.f8025d.b(i22, c2 + d2 + e(flexItem, true) + f(flexItem, true) + i26, b(flexItem, true));
                    b3.measure(a5, b4);
                    a(i7, a5, b4, b3);
                    i15 = a5;
                } else {
                    i10 = size;
                    i9 = mode;
                    int a6 = this.f8025d.a(i22, c2 + d2 + e(flexItem, false) + f(flexItem, false) + i26, b(flexItem, false));
                    int b5 = this.f8025d.b(i21, c(flexItem, false) + i25 + d(flexItem, false), a4);
                    b3.measure(a6, b5);
                    a(i7, a6, b5, b3);
                    i15 = b5;
                }
                this.f8025d.a(i7, b3);
                a(b3, i7);
                i27 = View.combineMeasuredStates(i27, b3.getMeasuredState());
                int i31 = i26;
                int i32 = i30;
                b bVar3 = bVar2;
                int i33 = i25;
                int i34 = i7;
                View view2 = b3;
                list2 = arrayList;
                int i35 = i34;
                int i36 = i15;
                if (a(b3, i9, i10, bVar2.f8017e, d(flexItem, a2) + a(b3, a2) + c(flexItem, a2), flexItem, i34, i28, arrayList.size())) {
                    if (bVar3.a() > 0) {
                        if (i35 > 0) {
                            i20 = i35 - 1;
                            bVar = bVar3;
                        } else {
                            bVar = bVar3;
                            i20 = 0;
                        }
                        a(list2, bVar, i20, i31);
                        i19 = bVar.f8019g + i31;
                    } else {
                        i19 = i31;
                    }
                    if (!a2) {
                        i13 = i3;
                        view = view2;
                        i7 = i35;
                        int i37 = i36;
                        if (flexItem.k_() == -1) {
                            a aVar4 = this.f8025d;
                            view.measure(aVar4.a(i13, aVar4.getPaddingLeft() + this.f8025d.getPaddingRight() + flexItem.m() + flexItem.o() + i19, flexItem.k_()), i37);
                            a(view, i7);
                        }
                    } else if (flexItem.b() == -1) {
                        a aVar5 = this.f8025d;
                        i13 = i3;
                        i7 = i35;
                        view = view2;
                        view.measure(i36, aVar5.b(i13, aVar5.getPaddingTop() + this.f8025d.getPaddingBottom() + flexItem.n() + flexItem.p() + i19, flexItem.b()));
                        a(view, i7);
                    } else {
                        i13 = i3;
                        view = view2;
                        i7 = i35;
                    }
                    bVar2 = new b();
                    bVar2.f8020h = 1;
                    i12 = i33;
                    bVar2.f8017e = i12;
                    bVar2.o = i7;
                    i31 = i19;
                    i17 = Integer.MIN_VALUE;
                    i16 = 0;
                } else {
                    i13 = i3;
                    view = view2;
                    i7 = i35;
                    bVar2 = bVar3;
                    i12 = i33;
                    bVar2.f8020h++;
                    i16 = i28 + 1;
                    i17 = i29;
                }
                int[] iArr = this.f8023a;
                if (iArr != null) {
                    iArr[i7] = list2.size();
                }
                bVar2.f8017e += a(view, a2) + c(flexItem, a2) + d(flexItem, a2);
                bVar2.j += flexItem.d();
                bVar2.k += flexItem.e();
                this.f8025d.a(view, i7, i16, bVar2);
                int max = Math.max(i17, b(view, a2) + e(flexItem, a2) + f(flexItem, a2) + this.f8025d.a(view));
                bVar2.f8019g = Math.max(bVar2.f8019g, max);
                if (a2) {
                    if (this.f8025d.getFlexWrap() != 2) {
                        bVar2.l = Math.max(bVar2.l, view.getBaseline() + flexItem.n());
                    } else {
                        bVar2.l = Math.max(bVar2.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.p());
                    }
                }
                i14 = i30;
                if (a(i7, i14, bVar2)) {
                    a(list2, bVar2, i7, i31);
                    i31 += bVar2.f8019g;
                }
                i11 = i6;
                if (i11 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i11 && i7 >= i11 && !z2) {
                        i18 = -bVar2.f8019g;
                        z2 = true;
                        if (i18 <= i4 && z2) {
                            aVar2 = aVar;
                            i8 = i27;
                            break;
                        }
                        i29 = max;
                        i28 = i16;
                        i26 = i18;
                        i24 = i7 + 1;
                        a aVar6 = aVar;
                        i21 = i2;
                        flexItemCount = i14;
                        i22 = i13;
                        i25 = i12;
                        arrayList = list2;
                        mode = i9;
                        i23 = i11;
                        size = i10;
                    }
                }
                i18 = i31;
                if (i18 <= i4) {
                }
                i29 = max;
                i28 = i16;
                i26 = i18;
                i24 = i7 + 1;
                a aVar62 = aVar;
                i21 = i2;
                flexItemCount = i14;
                i22 = i13;
                i25 = i12;
                arrayList = list2;
                mode = i9;
                i23 = i11;
                size = i10;
            }
            int i38 = i4;
            i10 = size;
            i9 = mode;
            i13 = i22;
            i11 = i23;
            list2 = arrayList;
            i12 = i25;
            i14 = flexItemCount;
            i24 = i7 + 1;
            a aVar622 = aVar;
            i21 = i2;
            flexItemCount = i14;
            i22 = i13;
            i25 = i12;
            arrayList = list2;
            mode = i9;
            i23 = i11;
            size = i10;
        }
        aVar2.f8029b = i8;
    }

    private int a(boolean z) {
        if (z) {
            return this.f8025d.getPaddingStart();
        }
        return this.f8025d.getPaddingTop();
    }

    private int b(boolean z) {
        if (z) {
            return this.f8025d.getPaddingEnd();
        }
        return this.f8025d.getPaddingBottom();
    }

    private int c(boolean z) {
        if (z) {
            return this.f8025d.getPaddingTop();
        }
        return this.f8025d.getPaddingStart();
    }

    private int d(boolean z) {
        if (z) {
            return this.f8025d.getPaddingBottom();
        }
        return this.f8025d.getPaddingEnd();
    }

    private static int a(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private static int b(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private static int a(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.k_();
        }
        return flexItem.b();
    }

    private static int b(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.b();
        }
        return flexItem.k_();
    }

    private static int c(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.m();
        }
        return flexItem.n();
    }

    private static int d(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.o();
        }
        return flexItem.p();
    }

    private static int e(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.n();
        }
        return flexItem.m();
    }

    private static int f(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.p();
        }
        return flexItem.o();
    }

    private boolean a(View view, int i2, int i3, int i4, int i5, FlexItem flexItem, int i6, int i7, int i8) {
        if (this.f8025d.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.k()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.f8025d.getMaxLine();
        if (maxLine != -1 && maxLine <= i8 + 1) {
            return false;
        }
        int a2 = this.f8025d.a(view, i6, i7);
        if (a2 > 0) {
            i5 += a2;
        }
        if (i3 < i4 + i5) {
            return true;
        }
        return false;
    }

    private static boolean a(int i2, int i3, b bVar) {
        return i2 == i3 - 1 && bVar.a() != 0;
    }

    private void a(List<b> list, b bVar, int i2, int i3) {
        bVar.m = i3;
        this.f8025d.a(bVar);
        bVar.p = i2;
        list.add(bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.g()
            r4 = 1
            if (r1 >= r3) goto L_0x001b
            int r1 = r0.g()
        L_0x0019:
            r3 = 1
            goto L_0x0027
        L_0x001b:
            int r3 = r0.i()
            if (r1 <= r3) goto L_0x0026
            int r1 = r0.i()
            goto L_0x0019
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r5 = r0.h()
            if (r2 >= r5) goto L_0x0032
            int r2 = r0.h()
            goto L_0x003e
        L_0x0032:
            int r5 = r0.j()
            if (r2 <= r5) goto L_0x003d
            int r2 = r0.j()
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            if (r4 == 0) goto L_0x0055
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.a((int) r8, (int) r1, (int) r0, (android.view.View) r7)
            com.google.android.flexbox.a r0 = r6.f8025d
            r0.a(r8, r7)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.c.a(android.view.View, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3) {
        a(i2, i3, 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        f(this.f8025d.getFlexItemCount());
        if (i4 < this.f8025d.getFlexItemCount()) {
            int flexDirection = this.f8025d.getFlexDirection();
            int flexDirection2 = this.f8025d.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                if (mode != 1073741824) {
                    size = this.f8025d.getLargestMainSize();
                }
                i7 = this.f8025d.getPaddingLeft();
                i5 = this.f8025d.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = View.MeasureSpec.getMode(i3);
                i6 = View.MeasureSpec.getSize(i3);
                if (mode2 != 1073741824) {
                    i6 = this.f8025d.getLargestMainSize();
                }
                i7 = this.f8025d.getPaddingTop();
                i5 = this.f8025d.getPaddingBottom();
            } else {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int i8 = i7 + i5;
            int i9 = 0;
            int[] iArr = this.f8023a;
            if (iArr != null) {
                i9 = iArr[i4];
            }
            List<b> flexLinesInternal = this.f8025d.getFlexLinesInternal();
            int size2 = flexLinesInternal.size();
            for (int i10 = i9; i10 < size2; i10++) {
                b bVar = flexLinesInternal.get(i10);
                if (bVar.f8017e < i6) {
                    a(i2, i3, bVar, i6, i8, false);
                } else {
                    b(i2, i3, bVar, i6, i8, false);
                }
            }
        }
    }

    private void f(int i2) {
        boolean[] zArr = this.f8026e;
        if (zArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f8026e = new boolean[i2];
        } else if (zArr.length < i2) {
            int length = zArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f8026e = new boolean[i2];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void a(int i2, int i3, b bVar, int i4, int i5, boolean z) {
        float f2;
        int i6;
        int i7;
        int i8;
        double d2;
        double d3;
        b bVar2 = bVar;
        int i9 = i4;
        int i10 = 1;
        boolean z2 = z;
        while (bVar2.j > 0.0f && i9 >= bVar2.f8017e) {
            int i11 = bVar2.f8017e;
            float f3 = ((float) (i9 - bVar2.f8017e)) / bVar2.j;
            bVar2.f8017e = i5 + bVar2.f8018f;
            if (!z2) {
                bVar2.f8019g = Integer.MIN_VALUE;
            }
            int i12 = 0;
            boolean z3 = false;
            float f4 = 0.0f;
            int i13 = 0;
            while (i12 < bVar2.f8020h) {
                int i14 = bVar2.o + i12;
                View b2 = this.f8025d.b(i14);
                if (b2 == null || b2.getVisibility() == 8) {
                    int i15 = i3;
                    f2 = f3;
                    int i16 = i2;
                } else {
                    FlexItem flexItem = (FlexItem) b2.getLayoutParams();
                    int flexDirection = this.f8025d.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == i10) {
                        f2 = f3;
                        int i17 = i2;
                        int measuredWidth = b2.getMeasuredWidth();
                        long[] jArr = this.f8027f;
                        if (jArr != null) {
                            measuredWidth = (int) jArr[i14];
                        }
                        int measuredHeight = b2.getMeasuredHeight();
                        long[] jArr2 = this.f8027f;
                        if (jArr2 != null) {
                            measuredHeight = (int) (jArr2[i14] >> 32);
                        }
                        if (this.f8026e[i14] || flexItem.d() <= 0.0f) {
                            int i18 = i3;
                            i8 = measuredWidth;
                            i7 = measuredHeight;
                        } else {
                            float d4 = ((float) measuredWidth) + (flexItem.d() * f2);
                            if (i12 == bVar2.f8020h - 1) {
                                d4 += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(d4);
                            if (round > flexItem.i()) {
                                round = flexItem.i();
                                this.f8026e[i14] = true;
                                bVar2.j -= flexItem.d();
                                z3 = true;
                            } else {
                                f4 += d4 - ((float) round);
                                double d5 = (double) f4;
                                if (d5 > 1.0d) {
                                    round++;
                                    d2 = d5 - 1.0d;
                                } else if (d5 < -1.0d) {
                                    round--;
                                    d2 = d5 + 1.0d;
                                }
                                f4 = (float) d2;
                            }
                            int b3 = b(i3, flexItem, bVar2.m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            b2.measure(makeMeasureSpec, b3);
                            i8 = b2.getMeasuredWidth();
                            i7 = b2.getMeasuredHeight();
                            a(i14, makeMeasureSpec, b3, b2);
                            this.f8025d.a(i14, b2);
                        }
                        i6 = Math.max(i13, i7 + flexItem.n() + flexItem.p() + this.f8025d.a(b2));
                        bVar2.f8017e += i8 + flexItem.m() + flexItem.o();
                    } else {
                        int measuredHeight2 = b2.getMeasuredHeight();
                        long[] jArr3 = this.f8027f;
                        if (jArr3 != null) {
                            measuredHeight2 = (int) (jArr3[i14] >> 32);
                        }
                        int measuredWidth2 = b2.getMeasuredWidth();
                        long[] jArr4 = this.f8027f;
                        f2 = f3;
                        if (jArr4 != null) {
                            measuredWidth2 = (int) jArr4[i14];
                        }
                        if (this.f8026e[i14] || flexItem.d() <= 0.0f) {
                            int i19 = i2;
                        } else {
                            float d6 = ((float) measuredHeight2) + (f2 * flexItem.d());
                            if (i12 == bVar2.f8020h - 1) {
                                d6 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(d6);
                            if (round2 > flexItem.j()) {
                                round2 = flexItem.j();
                                this.f8026e[i14] = true;
                                bVar2.j -= flexItem.d();
                                z3 = true;
                            } else {
                                f4 += d6 - ((float) round2);
                                double d7 = (double) f4;
                                if (d7 > 1.0d) {
                                    round2++;
                                    d3 = d7 - 1.0d;
                                } else if (d7 < -1.0d) {
                                    round2--;
                                    d3 = d7 + 1.0d;
                                }
                                f4 = (float) d3;
                            }
                            int a2 = a(i2, flexItem, bVar2.m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            b2.measure(a2, makeMeasureSpec2);
                            measuredWidth2 = b2.getMeasuredWidth();
                            measuredHeight2 = b2.getMeasuredHeight();
                            a(i14, a2, makeMeasureSpec2, b2);
                            this.f8025d.a(i14, b2);
                        }
                        i6 = Math.max(i13, measuredWidth2 + flexItem.m() + flexItem.o() + this.f8025d.a(b2));
                        bVar2.f8017e += measuredHeight2 + flexItem.n() + flexItem.p();
                        int i20 = i3;
                    }
                    bVar2.f8019g = Math.max(bVar2.f8019g, i6);
                    i13 = i6;
                }
                i12++;
                f3 = f2;
                i10 = 1;
            }
            int i21 = i2;
            int i22 = i3;
            if (z3 && i11 != bVar2.f8017e) {
                i10 = 1;
                z2 = true;
            } else {
                return;
            }
        }
    }

    private void b(int i2, int i3, b bVar, int i4, int i5, boolean z) {
        boolean z2;
        int i6;
        int i7;
        int i8;
        boolean z3;
        b bVar2 = bVar;
        int i9 = i4;
        int i10 = 1;
        boolean z4 = z;
        while (true) {
            int i11 = bVar2.f8017e;
            if (bVar2.k > 0.0f && i9 <= bVar2.f8017e) {
                float f2 = ((float) (bVar2.f8017e - i9)) / bVar2.k;
                bVar2.f8017e = i5 + bVar2.f8018f;
                if (!z4) {
                    bVar2.f8019g = Integer.MIN_VALUE;
                }
                int i12 = 0;
                boolean z5 = false;
                float f3 = 0.0f;
                int i13 = 0;
                while (i12 < bVar2.f8020h) {
                    int i14 = bVar2.o + i12;
                    View b2 = this.f8025d.b(i14);
                    if (b2 == null || b2.getVisibility() == 8) {
                        int i15 = i3;
                        z2 = z5;
                    } else {
                        FlexItem flexItem = (FlexItem) b2.getLayoutParams();
                        int flexDirection = this.f8025d.getFlexDirection();
                        if (flexDirection == 0 || flexDirection == i10) {
                            boolean z6 = z5;
                            int measuredWidth = b2.getMeasuredWidth();
                            long[] jArr = this.f8027f;
                            if (jArr != null) {
                                measuredWidth = (int) jArr[i14];
                            }
                            int measuredHeight = b2.getMeasuredHeight();
                            long[] jArr2 = this.f8027f;
                            if (jArr2 != null) {
                                measuredHeight = (int) (jArr2[i14] >> 32);
                            }
                            if (this.f8026e[i14] || flexItem.e() <= 0.0f) {
                                int i16 = i3;
                                i8 = measuredWidth;
                                i7 = measuredHeight;
                            } else {
                                float e2 = ((float) measuredWidth) - (flexItem.e() * f2);
                                if (i12 == bVar2.f8020h - 1) {
                                    e2 += f3;
                                    f3 = 0.0f;
                                }
                                int round = Math.round(e2);
                                if (round < flexItem.g()) {
                                    round = flexItem.g();
                                    this.f8026e[i14] = true;
                                    bVar2.k -= flexItem.e();
                                    z6 = true;
                                } else {
                                    f3 += e2 - ((float) round);
                                    double d2 = (double) f3;
                                    if (d2 > 1.0d) {
                                        round++;
                                        f3 -= 1.0f;
                                    } else if (d2 < -1.0d) {
                                        round--;
                                        f3 += 1.0f;
                                    }
                                }
                                int b3 = b(i3, flexItem, bVar2.m);
                                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                                b2.measure(makeMeasureSpec, b3);
                                i8 = b2.getMeasuredWidth();
                                i7 = b2.getMeasuredHeight();
                                a(i14, makeMeasureSpec, b3, b2);
                                this.f8025d.a(i14, b2);
                            }
                            i6 = Math.max(i13, i7 + flexItem.n() + flexItem.p() + this.f8025d.a(b2));
                            bVar2.f8017e += i8 + flexItem.m() + flexItem.o();
                        } else {
                            int measuredHeight2 = b2.getMeasuredHeight();
                            long[] jArr3 = this.f8027f;
                            if (jArr3 != null) {
                                measuredHeight2 = (int) (jArr3[i14] >> 32);
                            }
                            int measuredWidth2 = b2.getMeasuredWidth();
                            long[] jArr4 = this.f8027f;
                            z2 = z5;
                            if (jArr4 != null) {
                                measuredWidth2 = (int) jArr4[i14];
                            }
                            if (!this.f8026e[i14] && flexItem.e() > 0.0f) {
                                float e3 = ((float) measuredHeight2) - (flexItem.e() * f2);
                                if (i12 == bVar2.f8020h - 1) {
                                    e3 += f3;
                                    f3 = 0.0f;
                                }
                                int round2 = Math.round(e3);
                                if (round2 < flexItem.h()) {
                                    round2 = flexItem.h();
                                    this.f8026e[i14] = true;
                                    bVar2.k -= flexItem.e();
                                    z3 = true;
                                } else {
                                    f3 += e3 - ((float) round2);
                                    double d3 = (double) f3;
                                    if (d3 > 1.0d) {
                                        round2++;
                                        f3 -= 1.0f;
                                    } else if (d3 < -1.0d) {
                                        round2--;
                                        f3 += 1.0f;
                                    }
                                    z3 = z2;
                                }
                                int a2 = a(i2, flexItem, bVar2.m);
                                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                                b2.measure(a2, makeMeasureSpec2);
                                measuredWidth2 = b2.getMeasuredWidth();
                                int measuredHeight3 = b2.getMeasuredHeight();
                                a(i14, a2, makeMeasureSpec2, b2);
                                this.f8025d.a(i14, b2);
                                z2 = z3;
                                measuredHeight2 = measuredHeight3;
                            }
                            i6 = Math.max(i13, measuredWidth2 + flexItem.m() + flexItem.o() + this.f8025d.a(b2));
                            bVar2.f8017e += measuredHeight2 + flexItem.n() + flexItem.p();
                            int i17 = i3;
                        }
                        bVar2.f8019g = Math.max(bVar2.f8019g, i6);
                        i13 = i6;
                    }
                    i12++;
                    z5 = z2;
                    i10 = 1;
                }
                int i18 = i3;
                if (z5 && i11 != bVar2.f8017e) {
                    i10 = 1;
                    z4 = true;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private int a(int i2, FlexItem flexItem, int i3) {
        a aVar = this.f8025d;
        int a2 = aVar.a(i2, aVar.getPaddingLeft() + this.f8025d.getPaddingRight() + flexItem.m() + flexItem.o() + i3, flexItem.k_());
        int size = View.MeasureSpec.getSize(a2);
        if (size > flexItem.i()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.i(), View.MeasureSpec.getMode(a2));
        }
        return size < flexItem.g() ? View.MeasureSpec.makeMeasureSpec(flexItem.g(), View.MeasureSpec.getMode(a2)) : a2;
    }

    private int b(int i2, FlexItem flexItem, int i3) {
        a aVar = this.f8025d;
        int b2 = aVar.b(i2, aVar.getPaddingTop() + this.f8025d.getPaddingBottom() + flexItem.n() + flexItem.p() + i3, flexItem.b());
        int size = View.MeasureSpec.getSize(b2);
        if (size > flexItem.j()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.j(), View.MeasureSpec.getMode(b2));
        }
        return size < flexItem.h() ? View.MeasureSpec.makeMeasureSpec(flexItem.h(), View.MeasureSpec.getMode(b2)) : b2;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, int i3, int i4) {
        int i5;
        int i6;
        int flexDirection = this.f8025d.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            i6 = View.MeasureSpec.getMode(i3);
            i5 = View.MeasureSpec.getSize(i3);
        } else if (flexDirection == 2 || flexDirection == 3) {
            int mode = View.MeasureSpec.getMode(i2);
            i5 = View.MeasureSpec.getSize(i2);
            i6 = mode;
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<b> flexLinesInternal = this.f8025d.getFlexLinesInternal();
        if (i6 == 1073741824) {
            int sumOfCrossSize = this.f8025d.getSumOfCrossSize() + i4;
            int i7 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f8019g = i5 - i4;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f8025d.getAlignContent();
                if (alignContent == 1) {
                    int i8 = i5 - sumOfCrossSize;
                    b bVar = new b();
                    bVar.f8019g = i8;
                    flexLinesInternal.add(0, bVar);
                } else if (alignContent == 2) {
                    this.f8025d.setFlexLines(a(flexLinesInternal, i5, sumOfCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && sumOfCrossSize < i5) {
                            float size = ((float) (i5 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                            int size2 = flexLinesInternal.size();
                            float f2 = 0.0f;
                            while (i7 < size2) {
                                b bVar2 = flexLinesInternal.get(i7);
                                float f3 = ((float) bVar2.f8019g) + size;
                                if (i7 == flexLinesInternal.size() - 1) {
                                    f3 += f2;
                                    f2 = 0.0f;
                                }
                                int round = Math.round(f3);
                                f2 += f3 - ((float) round);
                                if (f2 > 1.0f) {
                                    round++;
                                    f2 -= 1.0f;
                                } else if (f2 < -1.0f) {
                                    round--;
                                    f2 += 1.0f;
                                }
                                bVar2.f8019g = round;
                                i7++;
                            }
                        }
                    } else if (sumOfCrossSize >= i5) {
                        this.f8025d.setFlexLines(a(flexLinesInternal, i5, sumOfCrossSize));
                    } else {
                        int size3 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList = new ArrayList();
                        b bVar3 = new b();
                        bVar3.f8019g = size3;
                        for (b add : flexLinesInternal) {
                            arrayList.add(bVar3);
                            arrayList.add(add);
                            arrayList.add(bVar3);
                        }
                        this.f8025d.setFlexLines(arrayList);
                    }
                } else if (sumOfCrossSize < i5) {
                    float size4 = ((float) (i5 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size5 = flexLinesInternal.size();
                    float f4 = 0.0f;
                    while (i7 < size5) {
                        arrayList2.add(flexLinesInternal.get(i7));
                        if (i7 != flexLinesInternal.size() - 1) {
                            b bVar4 = new b();
                            if (i7 == flexLinesInternal.size() - 2) {
                                bVar4.f8019g = Math.round(f4 + size4);
                                f4 = 0.0f;
                            } else {
                                bVar4.f8019g = Math.round(size4);
                            }
                            f4 += size4 - ((float) bVar4.f8019g);
                            if (f4 > 1.0f) {
                                bVar4.f8019g++;
                                f4 -= 1.0f;
                            } else if (f4 < -1.0f) {
                                bVar4.f8019g--;
                                f4 += 1.0f;
                            }
                            arrayList2.add(bVar4);
                        }
                        i7++;
                    }
                    this.f8025d.setFlexLines(arrayList2);
                }
            }
        }
    }

    private static List<b> a(List<b> list, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.f8019g = (i2 - i3) / 2;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a(0);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        View b2;
        int i3 = i2;
        if (i3 < this.f8025d.getFlexItemCount()) {
            int flexDirection = this.f8025d.getFlexDirection();
            if (this.f8025d.getAlignItems() == 4) {
                int[] iArr = this.f8023a;
                List<b> flexLinesInternal = this.f8025d.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i4 = iArr != null ? iArr[i3] : 0; i4 < size; i4++) {
                    b bVar = flexLinesInternal.get(i4);
                    int i5 = bVar.f8020h;
                    for (int i6 = 0; i6 < i5; i6++) {
                        int i7 = bVar.o + i6;
                        if (!(i6 >= this.f8025d.getFlexItemCount() || (b2 = this.f8025d.b(i7)) == null || b2.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) b2.getLayoutParams();
                            if (flexItem.f() == -1 || flexItem.f() == 4) {
                                if (flexDirection == 0 || flexDirection == 1) {
                                    a(b2, bVar.f8019g, i7);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    b(b2, bVar.f8019g, i7);
                                } else {
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                }
                            }
                        }
                    }
                }
                return;
            }
            for (b next : this.f8025d.getFlexLinesInternal()) {
                Iterator<Integer> it2 = next.n.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Integer next2 = it2.next();
                        View b3 = this.f8025d.b(next2.intValue());
                        if (flexDirection == 0 || flexDirection == 1) {
                            a(b3, next.f8019g, next2.intValue());
                        } else if (flexDirection == 2 || flexDirection == 3) {
                            b(b3, next.f8019g, next2.intValue());
                        } else {
                            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        }
                    }
                }
            }
        }
    }

    private void a(View view, int i2, int i3) {
        int i4;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.n()) - flexItem.p()) - this.f8025d.a(view), flexItem.h()), flexItem.j());
        long[] jArr = this.f8027f;
        if (jArr != null) {
            i4 = (int) jArr[i3];
        } else {
            i4 = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i3, makeMeasureSpec, makeMeasureSpec2, view);
        this.f8025d.a(i3, view);
    }

    private void b(View view, int i2, int i3) {
        int i4;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.m()) - flexItem.o()) - this.f8025d.a(view), flexItem.g()), flexItem.i());
        long[] jArr = this.f8027f;
        if (jArr != null) {
            i4 = (int) (jArr[i3] >> 32);
        } else {
            i4 = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i3, makeMeasureSpec2, makeMeasureSpec, view);
        this.f8025d.a(i3, view);
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, b bVar, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f8025d.getAlignItems();
        if (flexItem.f() != -1) {
            alignItems = flexItem.f();
        }
        int i6 = bVar.f8019g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int measuredHeight = (((i6 - view.getMeasuredHeight()) + flexItem.n()) - flexItem.p()) / 2;
                    if (this.f8025d.getFlexWrap() != 2) {
                        int i7 = i3 + measuredHeight;
                        view.layout(i2, i7, i4, view.getMeasuredHeight() + i7);
                        return;
                    }
                    int i8 = i3 - measuredHeight;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.f8025d.getFlexWrap() != 2) {
                    int max = Math.max(bVar.l - view.getBaseline(), flexItem.n());
                    view.layout(i2, i3 + max, i4, i5 + max);
                    return;
                } else {
                    int max2 = Math.max((bVar.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.p());
                    view.layout(i2, i3 - max2, i4, i5 - max2);
                    return;
                }
            } else if (this.f8025d.getFlexWrap() != 2) {
                int i9 = i3 + i6;
                view.layout(i2, (i9 - view.getMeasuredHeight()) - flexItem.p(), i4, i9 - flexItem.p());
                return;
            } else {
                view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + flexItem.n(), i4, (i5 - i6) + view.getMeasuredHeight() + flexItem.n());
                return;
            }
        }
        if (this.f8025d.getFlexWrap() != 2) {
            view.layout(i2, i3 + flexItem.n(), i4, i5 + flexItem.n());
        } else {
            view.layout(i2, i3 - flexItem.p(), i4, i5 - flexItem.p());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, b bVar, boolean z, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f8025d.getAlignItems();
        if (flexItem.f() != -1) {
            alignItems = flexItem.f();
        }
        int i6 = bVar.f8019g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i6 - view.getMeasuredWidth()) + h.a(marginLayoutParams)) - h.b(marginLayoutParams)) / 2;
                    if (!z) {
                        view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                        return;
                    } else {
                        view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z) {
                view.layout(((i2 + i6) - view.getMeasuredWidth()) - flexItem.o(), i3, ((i4 + i6) - view.getMeasuredWidth()) - flexItem.o(), i5);
                return;
            } else {
                view.layout((i2 - i6) + view.getMeasuredWidth() + flexItem.m(), i3, (i4 - i6) + view.getMeasuredWidth() + flexItem.m(), i5);
                return;
            }
        }
        if (!z) {
            view.layout(i2 + flexItem.m(), i3, i4 + flexItem.m(), i5);
        } else {
            view.layout(i2 - flexItem.o(), i3, i4 - flexItem.o(), i5);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        long[] jArr = this.f8027f;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f8027f = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f8027f = Arrays.copyOf(this.f8027f, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        long[] jArr = this.f8024b;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f8024b = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f8024b = Arrays.copyOf(this.f8024b, i2);
        }
    }

    private void a(int i2, int i3, int i4, View view) {
        long[] jArr = this.f8024b;
        if (jArr != null) {
            jArr[i2] = b(i3, i4);
        }
        long[] jArr2 = this.f8027f;
        if (jArr2 != null) {
            jArr2[i2] = b(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(int i2) {
        int[] iArr = this.f8023a;
        if (iArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f8023a = new int[i2];
        } else if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f8023a = Arrays.copyOf(this.f8023a, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(List<b> list, int i2) {
        if (!f8022c && this.f8023a == null) {
            throw new AssertionError();
        } else if (f8022c || this.f8024b != null) {
            int i3 = this.f8023a[i2];
            if (i3 == -1) {
                i3 = 0;
            }
            for (int size = list.size() - 1; size >= i3; size--) {
                list.remove(size);
            }
            int[] iArr = this.f8023a;
            int length = iArr.length - 1;
            if (i2 > length) {
                Arrays.fill(iArr, -1);
            } else {
                Arrays.fill(iArr, i2, length, -1);
            }
            long[] jArr = this.f8024b;
            int length2 = jArr.length - 1;
            if (i2 > length2) {
                Arrays.fill(jArr, 0);
            } else {
                Arrays.fill(jArr, i2, length2, 0);
            }
        } else {
            throw new AssertionError();
        }
    }

    static class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        int f8030a;

        /* renamed from: b  reason: collision with root package name */
        int f8031b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int i2 = this.f8031b;
            int i3 = bVar.f8031b;
            if (i2 != i3) {
                return i2 - i3;
            }
            return this.f8030a - bVar.f8030a;
        }

        public final String toString() {
            return "Order{order=" + this.f8031b + ", index=" + this.f8030a + '}';
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        List<b> f8028a;

        /* renamed from: b  reason: collision with root package name */
        int f8029b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f8028a = null;
            this.f8029b = 0;
        }
    }
}

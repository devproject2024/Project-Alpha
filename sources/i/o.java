package i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class o extends AbstractList<f> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final f[] f46311a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f46312b;

    private o(f[] fVarArr, int[] iArr) {
        this.f46311a = fVarArr;
        this.f46312b = iArr;
    }

    public static o a(f... fVarArr) {
        if (fVarArr.length == 0) {
            return new o(new f[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, fVarArr[i3]), Integer.valueOf(i3));
        }
        if (((f) arrayList.get(0)).size() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                f fVar = (f) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    f fVar2 = (f) arrayList.get(i6);
                    if (!fVar2.startsWith(fVar)) {
                        continue;
                        break;
                    } else if (fVar2.size() == fVar.size()) {
                        throw new IllegalArgumentException("duplicate option: ".concat(String.valueOf(fVar2)));
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            c cVar = new c();
            a(0, cVar, 0, arrayList, 0, arrayList.size(), arrayList2);
            int[] iArr = new int[a(cVar)];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr[i7] = cVar.i();
            }
            if (cVar.d()) {
                return new o((f[]) fVarArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    private static void a(long j, c cVar, int i2, List<f> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        int i7;
        c cVar2;
        c cVar3 = cVar;
        int i8 = i2;
        List<f> list3 = list;
        int i9 = i3;
        int i10 = i4;
        List<Integer> list4 = list2;
        if (i9 < i10) {
            int i11 = i9;
            while (i11 < i10) {
                if (list3.get(i11).size() >= i8) {
                    i11++;
                } else {
                    throw new AssertionError();
                }
            }
            f fVar = list.get(i3);
            f fVar2 = list3.get(i10 - 1);
            int i12 = -1;
            if (i8 == fVar.size()) {
                i12 = list4.get(i9).intValue();
                i9++;
                fVar = list3.get(i9);
            }
            int i13 = i9;
            if (fVar.getByte(i8) != fVar2.getByte(i8)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i10; i15++) {
                    if (list3.get(i15 - 1).getByte(i8) != list3.get(i15).getByte(i8)) {
                        i14++;
                    }
                }
                long a2 = j + ((long) a(cVar)) + 2 + ((long) (i14 * 2));
                cVar3.h(i14);
                cVar3.h(i12);
                for (int i16 = i13; i16 < i10; i16++) {
                    byte b2 = list3.get(i16).getByte(i8);
                    if (i16 == i13 || b2 != list3.get(i16 - 1).getByte(i8)) {
                        cVar3.h((int) b2 & 255);
                    }
                }
                c cVar4 = new c();
                int i17 = i13;
                while (i17 < i10) {
                    byte b3 = list3.get(i17).getByte(i8);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i10) {
                            i6 = i10;
                            break;
                        } else if (b3 != list3.get(i19).getByte(i8)) {
                            i6 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i6 && i8 + 1 == list3.get(i17).size()) {
                        cVar3.h(list4.get(i17).intValue());
                        i7 = i6;
                        cVar2 = cVar4;
                    } else {
                        cVar3.h((int) ((((long) a(cVar4)) + a2) * -1));
                        i7 = i6;
                        cVar2 = cVar4;
                        a(a2, cVar4, i8 + 1, list, i17, i6, list2);
                    }
                    cVar4 = cVar2;
                    i17 = i7;
                }
                c cVar5 = cVar4;
                cVar3.write(cVar5, cVar5.f46277b);
                return;
            }
            int min = Math.min(fVar.size(), fVar2.size());
            int i20 = i8;
            int i21 = 0;
            while (i20 < min && fVar.getByte(i20) == fVar2.getByte(i20)) {
                i21++;
                i20++;
            }
            long a3 = 1 + j + ((long) a(cVar)) + 2 + ((long) i21);
            cVar3.h(-i21);
            cVar3.h(i12);
            int i22 = i8;
            while (true) {
                i5 = i8 + i21;
                if (i22 >= i5) {
                    break;
                }
                cVar3.h((int) fVar.getByte(i22) & 255);
                i22++;
            }
            if (i13 + 1 != i10) {
                c cVar6 = new c();
                cVar3.h((int) ((((long) a(cVar6)) + a3) * -1));
                a(a3, cVar6, i5, list, i13, i4, list2);
                cVar3.write(cVar6, cVar6.f46277b);
            } else if (i5 == list3.get(i13).size()) {
                cVar3.h(list4.get(i13).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public final int size() {
        return this.f46311a.length;
    }

    private static int a(c cVar) {
        return (int) (cVar.f46277b / 4);
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return this.f46311a[i2];
    }
}

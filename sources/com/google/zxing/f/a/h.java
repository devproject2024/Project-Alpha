package com.google.zxing.f.a;

import com.google.zxing.t;

final class h extends g {

    /* renamed from: c  reason: collision with root package name */
    final boolean f40454c;

    h(c cVar, boolean z) {
        super(cVar);
        this.f40454c = z;
    }

    /* access modifiers changed from: package-private */
    public final int[] a() {
        t tVar;
        t tVar2;
        int i2;
        a b2 = b();
        if (b2 == null) {
            return null;
        }
        c cVar = this.f40452a;
        if (this.f40454c) {
            tVar = cVar.f40431b;
        } else {
            tVar = cVar.f40433d;
        }
        if (this.f40454c) {
            tVar2 = cVar.f40432c;
        } else {
            tVar2 = cVar.f40434e;
        }
        int b3 = b((int) tVar2.f40585b);
        d[] dVarArr = this.f40453b;
        int i3 = -1;
        int i4 = 0;
        int i5 = 1;
        for (int b4 = b((int) tVar.f40585b); b4 < b3; b4++) {
            if (dVarArr[b4] != null) {
                d dVar = dVarArr[b4];
                dVar.b();
                int i6 = dVar.f40443e - i3;
                if (i6 == 0) {
                    i4++;
                } else {
                    if (i6 == 1) {
                        i5 = Math.max(i5, i4);
                        i3 = dVar.f40443e;
                    } else if (dVar.f40443e >= b2.f40419e) {
                        dVarArr[b4] = null;
                    } else {
                        i3 = dVar.f40443e;
                    }
                    i4 = 1;
                }
            }
        }
        int[] iArr = new int[b2.f40419e];
        for (d dVar2 : this.f40453b) {
            if (dVar2 != null && (i2 = dVar2.f40443e) < iArr.length) {
                iArr[i2] = iArr[i2] + 1;
            }
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int i3 = dVar.f40442d % 30;
                int i4 = dVar.f40443e;
                if (i4 > aVar.f40419e) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f40454c) {
                        i4 += 2;
                    }
                    int i5 = i4 % 3;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 == 2 && i3 + 1 != aVar.f40415a) {
                                dVarArr[i2] = null;
                            }
                        } else if (i3 / 3 != aVar.f40416b || i3 % 3 != aVar.f40418d) {
                            dVarArr[i2] = null;
                        }
                    } else if ((i3 * 3) + 1 != aVar.f40417c) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }

    public final String toString() {
        return "IsLeft: " + this.f40454c + 10 + super.toString();
    }

    /* access modifiers changed from: package-private */
    public final a b() {
        d[] dVarArr = this.f40453b;
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArr) {
            if (dVar != null) {
                dVar.b();
                int i2 = dVar.f40442d % 30;
                int i3 = dVar.f40443e;
                if (!this.f40454c) {
                    i3 += 2;
                }
                int i4 = i3 % 3;
                if (i4 == 0) {
                    bVar2.a((i2 * 3) + 1);
                } else if (i4 == 1) {
                    bVar4.a(i2 / 3);
                    bVar3.a(i2 % 3);
                } else if (i4 == 2) {
                    bVar.a(i2 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(dVarArr, aVar);
        return aVar;
    }
}

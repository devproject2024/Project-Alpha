package com.google.zxing.g.a;

public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final f[] FOR_BITS = null;
    private final int bits;

    static {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        FOR_BITS = new f[]{fVar2, fVar, fVar4, fVar3};
    }

    private f(int i2) {
        this.bits = i2;
    }

    public final int getBits() {
        return this.bits;
    }

    public static f forBits(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = FOR_BITS;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }
}

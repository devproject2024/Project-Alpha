package com.bumptech.glide.load.b.a;

public final class i implements a<int[]> {
    public final String a() {
        return "IntegerArrayPool";
    }

    public final int b() {
        return 4;
    }

    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return ((int[]) obj).length;
    }

    public final /* bridge */ /* synthetic */ Object a(int i2) {
        return new int[i2];
    }
}

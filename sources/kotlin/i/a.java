package kotlin.i;

import java.util.Random;

public abstract class a extends c {
    public abstract Random a();

    public final int a(int i2) {
        return ((-i2) >> 31) & (a().nextInt() >>> (32 - i2));
    }

    public final int b() {
        return a().nextInt();
    }

    public final int b(int i2) {
        return a().nextInt(i2);
    }
}

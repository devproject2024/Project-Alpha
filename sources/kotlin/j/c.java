package kotlin.j;

import java.util.NoSuchElementException;
import kotlin.a.ac;

public final class c extends ac {

    /* renamed from: a  reason: collision with root package name */
    private final int f47942a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f47943b;

    /* renamed from: c  reason: collision with root package name */
    private int f47944c;

    /* renamed from: d  reason: collision with root package name */
    private final int f47945d;

    public c(int i2, int i3, int i4) {
        this.f47945d = i4;
        this.f47942a = i3;
        boolean z = true;
        if (this.f47945d <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f47943b = z;
        this.f47944c = !this.f47943b ? this.f47942a : i2;
    }

    public final boolean hasNext() {
        return this.f47943b;
    }

    public final int a() {
        int i2 = this.f47944c;
        if (i2 != this.f47942a) {
            this.f47944c = this.f47945d + i2;
        } else if (this.f47943b) {
            this.f47943b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }
}

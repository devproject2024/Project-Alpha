package androidx.core.g;

import java.io.Writer;

@Deprecated
public final class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f2962a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f2963b = new StringBuilder(128);

    public b(String str) {
        this.f2962a = str;
    }

    public final void close() {
        a();
    }

    public final void flush() {
        a();
    }

    public final void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                a();
            } else {
                this.f2963b.append(c2);
            }
        }
    }

    private void a() {
        if (this.f2963b.length() > 0) {
            StringBuilder sb = this.f2963b;
            sb.delete(0, sb.length());
        }
    }
}

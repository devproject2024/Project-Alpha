package androidx.sqlite.db;

import java.io.Closeable;

public interface d extends Closeable {
    void a(int i2);

    void a(int i2, double d2);

    void a(int i2, long j);

    void a(int i2, String str);

    void a(int i2, byte[] bArr);
}

package i;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface d extends u, WritableByteChannel {
    long a(v vVar) throws IOException;

    c a();

    d b(String str) throws IOException;

    d b(String str, int i2, int i3) throws IOException;

    d c() throws IOException;

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i2, int i3) throws IOException;

    d d(f fVar) throws IOException;

    void flush() throws IOException;

    d g(int i2) throws IOException;

    d h(int i2) throws IOException;

    d i(int i2) throws IOException;

    d j(int i2) throws IOException;

    d m(long j) throws IOException;

    d n(long j) throws IOException;

    d x() throws IOException;
}

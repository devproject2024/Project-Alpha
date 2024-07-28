package i;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e extends v, ReadableByteChannel {
    int a(o oVar) throws IOException;

    long a(u uVar) throws IOException;

    @Deprecated
    c a();

    String a(long j, Charset charset) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j) throws IOException;

    void a(c cVar, long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    long b(f fVar) throws IOException;

    c b();

    boolean b(long j) throws IOException;

    long c(f fVar) throws IOException;

    f d(long j) throws IOException;

    boolean d() throws IOException;

    InputStream e();

    String f(long j) throws IOException;

    byte g() throws IOException;

    short h() throws IOException;

    byte[] h(long j) throws IOException;

    int i() throws IOException;

    void i(long j) throws IOException;

    long j() throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    long n() throws IOException;

    long o() throws IOException;

    String r() throws IOException;

    byte[] s() throws IOException;

    long u() throws IOException;
}

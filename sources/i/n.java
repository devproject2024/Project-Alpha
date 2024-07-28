package i;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f46305a = Logger.getLogger(n.class.getName());

    private n() {
    }

    public static e a(v vVar) {
        return new q(vVar);
    }

    public static d a(u uVar) {
        return new p(uVar);
    }

    private static u a(OutputStream outputStream) {
        return a(outputStream, new w());
    }

    private static u a(final OutputStream outputStream, final w wVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (wVar != null) {
            return new u() {
                public final void write(c cVar, long j) throws IOException {
                    x.a(cVar.f46277b, 0, j);
                    while (j > 0) {
                        w.this.throwIfReached();
                        r rVar = cVar.f46276a;
                        int min = (int) Math.min(j, (long) (rVar.f46322c - rVar.f46321b));
                        outputStream.write(rVar.f46320a, rVar.f46321b, min);
                        rVar.f46321b += min;
                        long j2 = (long) min;
                        j -= j2;
                        cVar.f46277b -= j2;
                        if (rVar.f46321b == rVar.f46322c) {
                            cVar.f46276a = rVar.c();
                            s.a(rVar);
                        }
                    }
                }

                public final void flush() throws IOException {
                    outputStream.flush();
                }

                public final void close() throws IOException {
                    outputStream.close();
                }

                public final w timeout() {
                    return w.this;
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static u a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            a c2 = c(socket);
            return c2.sink(a(socket.getOutputStream(), (w) c2));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static v a(InputStream inputStream) {
        return a(inputStream, new w());
    }

    private static v a(final InputStream inputStream, final w wVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (wVar != null) {
            return new v() {
                public final long read(c cVar, long j) throws IOException {
                    int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i2 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                    } else if (i2 == 0) {
                        return 0;
                    } else {
                        try {
                            w.this.throwIfReached();
                            r f2 = cVar.f(1);
                            int read = inputStream.read(f2.f46320a, f2.f46322c, (int) Math.min(j, (long) (8192 - f2.f46322c)));
                            if (read == -1) {
                                return -1;
                            }
                            f2.f46322c += read;
                            long j2 = (long) read;
                            cVar.f46277b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (n.a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                public final void close() throws IOException {
                    inputStream.close();
                }

                public final w timeout() {
                    return w.this;
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static v a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static u b(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static u c(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static u a() {
        return new u() {
            public final void close() throws IOException {
            }

            public final void flush() throws IOException {
            }

            public final void write(c cVar, long j) throws IOException {
                cVar.i(j);
            }

            public final w timeout() {
                return w.NONE;
            }
        };
    }

    public static v b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            a c2 = c(socket);
            return c2.source(a(socket.getInputStream(), (w) c2));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static a c(final Socket socket) {
        return new a() {
            /* access modifiers changed from: protected */
            public final IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            public final void timedOut() {
                try {
                    socket.close();
                } catch (Exception e2) {
                    Logger logger = n.f46305a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + socket, e2);
                } catch (AssertionError e3) {
                    if (n.a(e3)) {
                        Logger logger2 = n.f46305a;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + socket, e3);
                        return;
                    }
                    throw e3;
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}

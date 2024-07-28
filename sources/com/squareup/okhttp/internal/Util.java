package com.squareup.okhttp.internal;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.okhttp.HttpUrl;
import i.c;
import i.f;
import i.v;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset UTF_8 = Charset.forName(AppConstants.UTF_8);

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!isAndroidGetsocknameError(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeAll(Closeable closeable, Closeable closeable2) throws IOException {
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw th;
            } else {
                throw new AssertionError(th);
            }
        }
    }

    public static boolean discard(v vVar, int i2, TimeUnit timeUnit) {
        try {
            return skipAll(vVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean skipAll(v vVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = vVar.timeout().hasDeadline() ? vVar.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        vVar.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            c cVar = new c();
            while (vVar.read(cVar, 2048) != -1) {
                cVar.t();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                vVar.timeout().clearDeadline();
                return true;
            }
            vVar.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                vVar.timeout().clearDeadline();
                return false;
            }
            vVar.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                vVar.timeout().clearDeadline();
            } else {
                vVar.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static String md5Hex(String str) {
        try {
            return f.of(MessageDigest.getInstance("MD5").digest(str.getBytes(AppConstants.UTF_8))).hex();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String shaBase64(String str) {
        try {
            return f.of(MessageDigest.getInstance("SHA-1").digest(str.getBytes(AppConstants.UTF_8))).base64();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f sha1(f fVar) {
        try {
            return f.of(MessageDigest.getInstance("SHA-1").digest(fVar.toByteArray()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static <T> T[] intersect(Class<T> cls, T[] tArr, T[] tArr2) {
        List intersect = intersect(tArr, tArr2);
        return intersect.toArray((Object[]) Array.newInstance(cls, intersect.size()));
    }

    private static <T> List<T> intersect(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                T t2 = tArr2[i2];
                if (t.equals(t2)) {
                    arrayList.add(t2);
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public static String hostHeader(HttpUrl httpUrl) {
        if (httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            return httpUrl.host();
        }
        return httpUrl.host() + AppConstants.COLON + httpUrl.port();
    }

    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt <= 31 || codePointAt >= 127) {
                c cVar = new c();
                cVar.b(str, 0, i2);
                while (i2 < length) {
                    int codePointAt2 = str.codePointAt(i2);
                    cVar.a((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i2 += Character.charCount(codePointAt2);
                }
                return cVar.q();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}

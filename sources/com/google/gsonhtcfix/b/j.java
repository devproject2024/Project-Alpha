package com.google.gsonhtcfix.b;

import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.l;
import java.io.IOException;
import java.io.Writer;

public final class j {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.gsonhtcfix.m((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.gsonhtcfix.v((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.gsonhtcfix.n.f39822a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.gsonhtcfix.v((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.gsonhtcfix.v((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' com.google.gsonhtcfix.d.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.gsonhtcfix.l a(com.google.gsonhtcfix.d.a r2) throws com.google.gsonhtcfix.p {
        /*
            r2.f()     // Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.gsonhtcfix.y<com.google.gsonhtcfix.l> r1 = com.google.gsonhtcfix.b.a.l.P     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.a((com.google.gsonhtcfix.d.a) r2)     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.gsonhtcfix.l r2 = (com.google.gsonhtcfix.l) r2     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.gsonhtcfix.v r0 = new com.google.gsonhtcfix.v
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.gsonhtcfix.m r0 = new com.google.gsonhtcfix.m
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.gsonhtcfix.v r0 = new com.google.gsonhtcfix.v
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.gsonhtcfix.n r2 = com.google.gsonhtcfix.n.f39822a
            return r2
        L_0x002b:
            com.google.gsonhtcfix.v r0 = new com.google.gsonhtcfix.v
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.b.j.a(com.google.gsonhtcfix.d.a):com.google.gsonhtcfix.l");
    }

    public static void a(l lVar, c cVar) throws IOException {
        com.google.gsonhtcfix.b.a.l.P.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable, (byte) 0);
    }

    static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f39770a;

        /* renamed from: b  reason: collision with root package name */
        private final C0669a f39771b;

        public final void close() {
        }

        public final void flush() {
        }

        /* synthetic */ a(Appendable appendable, byte b2) {
            this(appendable);
        }

        private a(Appendable appendable) {
            this.f39771b = new C0669a();
            this.f39770a = appendable;
        }

        public final void write(char[] cArr, int i2, int i3) throws IOException {
            C0669a aVar = this.f39771b;
            aVar.f39772a = cArr;
            this.f39770a.append(aVar, i2, i3 + i2);
        }

        public final void write(int i2) throws IOException {
            this.f39770a.append((char) i2);
        }

        /* renamed from: com.google.gsonhtcfix.b.j$a$a  reason: collision with other inner class name */
        static class C0669a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f39772a;

            C0669a() {
            }

            public final int length() {
                return this.f39772a.length;
            }

            public final char charAt(int i2) {
                return this.f39772a[i2];
            }

            public final CharSequence subSequence(int i2, int i3) {
                return new String(this.f39772a, i2, i3 - i2);
            }
        }
    }
}

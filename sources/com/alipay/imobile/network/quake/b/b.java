package com.alipay.imobile.network.quake.b;

import com.alipay.imobile.network.quake.b.a;
import com.alipay.imobile.network.quake.c;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f14724a;

    /* renamed from: b  reason: collision with root package name */
    private long f14725b;

    /* renamed from: c  reason: collision with root package name */
    private final File f14726c;

    /* renamed from: d  reason: collision with root package name */
    private int f14727d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14728e;

    /* renamed from: com.alipay.imobile.network.quake.b.b$b  reason: collision with other inner class name */
    static class C0202b extends FilterInputStream {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f14736a;

        private C0202b(InputStream inputStream) {
            super(inputStream);
            this.f14736a = 0;
        }

        /* synthetic */ C0202b(InputStream inputStream, byte b2) {
            this(inputStream);
        }

        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f14736a++;
            }
            return read;
        }

        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.f14736a += read;
            }
            return read;
        }
    }

    private b(File file) {
        this.f14724a = new LinkedHashMap(16, 0.75f, true);
        this.f14725b = 0;
        this.f14728e = false;
        this.f14726c = file;
        this.f14727d = 5242880;
    }

    public b(File file, byte b2) {
        this(file);
    }

    public static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | e(inputStream) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    public static void a(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    public static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(AppConstants.UTF_8);
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, a aVar) {
        if (!this.f14724a.containsKey(str)) {
            this.f14725b += aVar.f14729a;
        } else {
            this.f14725b += aVar.f14729a - this.f14724a.get(str).f14729a;
        }
        this.f14724a.put(str, aVar);
    }

    private static byte[] a(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == i2) {
            return bArr;
        }
        throw new IOException("Expected " + i2 + " bytes, read " + i3 + " bytes");
    }

    public static long b(InputStream inputStream) throws IOException {
        return (((long) e(inputStream)) & 255) | 0 | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((255 & ((long) e(inputStream))) << 56);
    }

    public static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), AppConstants.UTF_8);
    }

    private static String c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private File d(String str) {
        return new File(this.f14726c, c(str));
    }

    public static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i2 = 0; i2 < a2; i2++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public final boolean a() {
        return this.f14728e;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:31|30|33|34|(0)(0)|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r4 = com.alipay.imobile.network.quake.c.f14737a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x007d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0086 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076 A[SYNTHETIC, Splitter:B:36:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A[SYNTHETIC, Splitter:B:42:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.f14726c     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0090 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0029
            java.io.File r0 = r9.f14726c     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "Unable to create cache dir %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0090 }
            java.io.File r3 = r9.f14726c     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0090 }
            r2[r1] = r3     // Catch:{ all -> 0x0090 }
            com.alipay.iap.android.common.b.c.a(r0, r2)     // Catch:{ all -> 0x0090 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0090 }
        L_0x0027:
            monitor-exit(r9)
            return
        L_0x0029:
            java.io.File r0 = r9.f14726c     // Catch:{ all -> 0x0090 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0033
            monitor-exit(r9)
            return
        L_0x0033:
            int r3 = r0.length     // Catch:{ all -> 0x0090 }
        L_0x0034:
            if (r1 >= r3) goto L_0x008c
            r4 = r0[r1]     // Catch:{ all -> 0x0090 }
            r5 = 0
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0063 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0063 }
            r7.<init>(r4)     // Catch:{ IOException -> 0x0063 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0063 }
            com.alipay.imobile.network.quake.b.b$a r5 = com.alipay.imobile.network.quake.b.b.a.a((java.io.InputStream) r6)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            long r7 = r4.length()     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r5.f14729a = r7     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            java.lang.String r7 = r5.f14730b     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r9.a((java.lang.String) r7, (com.alipay.imobile.network.quake.b.b.a) r5)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r6.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x007d
        L_0x0056:
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0090 }
        L_0x0058:
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x0090 }
            goto L_0x007d
        L_0x005c:
            r0 = move-exception
            r5 = r6
            goto L_0x0080
        L_0x005f:
            r5 = r6
            goto L_0x0063
        L_0x0061:
            r0 = move-exception
            goto L_0x0080
        L_0x0063:
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = "disk cache can not read file="
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0061 }
            r6.concat(r7)     // Catch:{ all -> 0x0061 }
            com.alipay.iap.android.common.b.c.d()     // Catch:{ all -> 0x0061 }
            r4.delete()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x007d
            r5.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007d
        L_0x007a:
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0090 }
            goto L_0x0058
        L_0x007d:
            int r1 = r1 + 1
            goto L_0x0034
        L_0x0080:
            if (r5 == 0) goto L_0x008b
            r5.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008b
        L_0x0086:
            java.lang.String r1 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0090 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x0090 }
        L_0x008b:
            throw r0     // Catch:{ all -> 0x0090 }
        L_0x008c:
            r9.f14728e = r2     // Catch:{ all -> 0x0090 }
            monitor-exit(r9)
            return
        L_0x0090:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.b.b.b():void");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f14729a;

        /* renamed from: b  reason: collision with root package name */
        public String f14730b;

        /* renamed from: c  reason: collision with root package name */
        public String f14731c;

        /* renamed from: d  reason: collision with root package name */
        public long f14732d;

        /* renamed from: e  reason: collision with root package name */
        public long f14733e;

        /* renamed from: f  reason: collision with root package name */
        public long f14734f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f14735g;

        private a() {
        }

        public a(String str, a.C0201a aVar) {
            this.f14730b = str;
            this.f14729a = (long) aVar.f14718a.length;
            this.f14731c = aVar.f14719b;
            this.f14732d = aVar.f14720c;
            this.f14733e = aVar.f14721d;
            this.f14734f = aVar.f14722e;
            this.f14735g = aVar.f14723f;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (b.a(inputStream) == 538247942) {
                aVar.f14730b = b.c(inputStream);
                aVar.f14731c = b.c(inputStream);
                if ("".equals(aVar.f14731c)) {
                    aVar.f14731c = null;
                }
                aVar.f14732d = b.b(inputStream);
                aVar.f14733e = b.b(inputStream);
                aVar.f14734f = b.b(inputStream);
                aVar.f14735g = b.d(inputStream);
                return aVar;
            }
            throw new IOException();
        }

        public final boolean a(OutputStream outputStream) {
            try {
                b.a(outputStream, 538247942);
                b.a(outputStream, this.f14730b);
                b.a(outputStream, this.f14731c == null ? "" : this.f14731c);
                b.a(outputStream, this.f14732d);
                b.a(outputStream, this.f14733e);
                b.a(outputStream, this.f14734f);
                Map<String, String> map = this.f14735g;
                if (map != null) {
                    b.a(outputStream, map.size());
                    for (Map.Entry next : map.entrySet()) {
                        b.a(outputStream, (String) next.getKey());
                        b.a(outputStream, (String) next.getValue());
                    }
                } else {
                    b.a(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                String str = c.f14737a;
                e2.getMessage();
                com.alipay.iap.android.common.b.c.j();
                return false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:34|35|36|37) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:45|46|47|48) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:53|54|55|56) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:17|18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0093 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A[SYNTHETIC, Splitter:B:45:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c7 A[SYNTHETIC, Splitter:B:53:0x00c7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0062=Splitter:B:21:0x0062, B:36:0x0093=Splitter:B:36:0x0093, B:55:0x00cb=Splitter:B:55:0x00cb, B:47:0x00bd=Splitter:B:47:0x00bd} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0072=Splitter:B:31:0x0072, B:42:0x009c=Splitter:B:42:0x009c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.alipay.imobile.network.quake.b.a.C0201a a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00d1 }
            r1 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String r12 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00d1 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x00d1 }
            monitor-exit(r11)
            return r1
        L_0x000f:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.b.b$a> r0 = r11.f14724a     // Catch:{ all -> 0x00d1 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x00d1 }
            com.alipay.imobile.network.quake.b.b$a r0 = (com.alipay.imobile.network.quake.b.b.a) r0     // Catch:{ all -> 0x00d1 }
            if (r0 != 0) goto L_0x001b
            monitor-exit(r11)
            return r1
        L_0x001b:
            java.io.File r2 = r11.d((java.lang.String) r12)     // Catch:{ all -> 0x00d1 }
            r3 = 1
            r4 = 2
            r5 = 0
            com.alipay.imobile.network.quake.b.b$b r6 = new com.alipay.imobile.network.quake.b.b$b     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            r8.<init>(r2)     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            r7.<init>(r8)     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            r6.<init>(r7, r5)     // Catch:{ IOException -> 0x009a, NegativeArraySizeException -> 0x0070, all -> 0x006d }
            com.alipay.imobile.network.quake.b.b.a.a((java.io.InputStream) r6)     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r7 = r2.length()     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            int r9 = r6.f14736a     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r9 = (long) r9     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r7 = r7 - r9
            int r8 = (int) r7     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            byte[] r7 = a((java.io.InputStream) r6, (int) r8)     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            com.alipay.imobile.network.quake.b.a$a r8 = new com.alipay.imobile.network.quake.b.a$a     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.<init>()     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14718a = r7     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            java.lang.String r7 = r0.f14731c     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14719b = r7     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r9 = r0.f14732d     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14720c = r9     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r9 = r0.f14733e     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14721d = r9     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            long r9 = r0.f14734f     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14722e = r9     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.f14735g     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r8.f14723f = r0     // Catch:{ IOException -> 0x006b, NegativeArraySizeException -> 0x0069 }
            r6.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0067
        L_0x0062:
            java.lang.String r12 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00d1 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x00d1 }
        L_0x0067:
            monitor-exit(r11)
            return r8
        L_0x0069:
            r0 = move-exception
            goto L_0x0072
        L_0x006b:
            r0 = move-exception
            goto L_0x009c
        L_0x006d:
            r12 = move-exception
            r6 = r1
            goto L_0x00c5
        L_0x0070:
            r0 = move-exception
            r6 = r1
        L_0x0072:
            java.lang.String r7 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00c4 }
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00c4 }
            r4[r5] = r2     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c4 }
            r4[r3] = r0     // Catch:{ all -> 0x00c4 }
            com.alipay.iap.android.common.b.c.a(r7, r4)     // Catch:{ all -> 0x00c4 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x00c4 }
            r11.b((java.lang.String) r12)     // Catch:{ all -> 0x00c4 }
            if (r6 == 0) goto L_0x0098
            r6.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0098
        L_0x0093:
            java.lang.String r12 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00d1 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x00d1 }
        L_0x0098:
            monitor-exit(r11)
            return r1
        L_0x009a:
            r0 = move-exception
            r6 = r1
        L_0x009c:
            java.lang.String r7 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00c4 }
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00c4 }
            r4[r5] = r2     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c4 }
            r4[r3] = r0     // Catch:{ all -> 0x00c4 }
            com.alipay.iap.android.common.b.c.a(r7, r4)     // Catch:{ all -> 0x00c4 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x00c4 }
            r11.b((java.lang.String) r12)     // Catch:{ all -> 0x00c4 }
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r12 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00d1 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x00d1 }
        L_0x00c2:
            monitor-exit(r11)
            return r1
        L_0x00c4:
            r12 = move-exception
        L_0x00c5:
            if (r6 == 0) goto L_0x00d0
            r6.close()     // Catch:{ IOException -> 0x00cb }
            goto L_0x00d0
        L_0x00cb:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00d1 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x00d1 }
        L_0x00d0:
            throw r12     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.b.b.a(java.lang.String):com.alipay.imobile.network.quake.b.a$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:39|40|41|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:54|55|56|57) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:64|65|66|67) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0118, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r0 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0164, code lost:
        r0 = com.alipay.imobile.network.quake.c.f14737a;
        new java.lang.StringBuilder("Could not clean up file ").append(r4.getAbsolutePath());
        com.alipay.iap.android.common.b.c.e();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0112 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x013a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0159 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x017f */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0155 A[SYNTHETIC, Splitter:B:54:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017b A[SYNTHETIC, Splitter:B:64:0x017b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0112=Splitter:B:39:0x0112, B:56:0x0159=Splitter:B:56:0x0159, B:66:0x017f=Splitter:B:66:0x017f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r19, com.alipay.imobile.network.quake.b.a.C0201a r20) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            monitor-enter(r18)
            boolean r3 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x0185 }
            if (r3 == 0) goto L_0x0014
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x0185 }
            monitor-exit(r18)
            return
        L_0x0014:
            byte[] r3 = r2.f14718a     // Catch:{ all -> 0x0185 }
            int r3 = r3.length     // Catch:{ all -> 0x0185 }
            boolean r4 = com.alipay.iap.android.common.b.c.a()     // Catch:{ all -> 0x0185 }
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0185 }
            java.lang.String r5 = "Pruning currentSize="
            r4.<init>(r5)     // Catch:{ all -> 0x0185 }
            long r5 = r1.f14725b     // Catch:{ all -> 0x0185 }
            r4.append(r5)     // Catch:{ all -> 0x0185 }
            java.lang.String r5 = ", need="
            r4.append(r5)     // Catch:{ all -> 0x0185 }
            r4.append(r3)     // Catch:{ all -> 0x0185 }
            java.lang.String r5 = ", maxSize="
            r4.append(r5)     // Catch:{ all -> 0x0185 }
            int r5 = r1.f14727d     // Catch:{ all -> 0x0185 }
            r4.append(r5)     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ all -> 0x0185 }
        L_0x0040:
            long r4 = r1.f14725b     // Catch:{ all -> 0x0185 }
            long r6 = (long) r3     // Catch:{ all -> 0x0185 }
            long r4 = r4 + r6
            int r3 = r1.f14727d     // Catch:{ all -> 0x0185 }
            long r8 = (long) r3     // Catch:{ all -> 0x0185 }
            r10 = 2
            int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r13 < 0) goto L_0x00eb
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ all -> 0x0185 }
            long r4 = r1.f14725b     // Catch:{ all -> 0x0185 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0185 }
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.b.b$a> r13 = r1.f14724a     // Catch:{ all -> 0x0185 }
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x0185 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0185 }
            r14 = 0
        L_0x0062:
            boolean r15 = r13.hasNext()     // Catch:{ all -> 0x0185 }
            if (r15 == 0) goto L_0x00bf
            java.lang.Object r15 = r13.next()     // Catch:{ all -> 0x0185 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ all -> 0x0185 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ all -> 0x0185 }
            com.alipay.imobile.network.quake.b.b$a r15 = (com.alipay.imobile.network.quake.b.b.a) r15     // Catch:{ all -> 0x0185 }
            java.lang.String r3 = r15.f14730b     // Catch:{ all -> 0x0185 }
            java.io.File r3 = r1.d((java.lang.String) r3)     // Catch:{ all -> 0x0185 }
            boolean r3 = r3.delete()     // Catch:{ all -> 0x0185 }
            if (r3 == 0) goto L_0x008a
            long r11 = r1.f14725b     // Catch:{ all -> 0x0185 }
            r16 = r4
            long r3 = r15.f14729a     // Catch:{ all -> 0x0185 }
            long r11 = r11 - r3
            r1.f14725b = r11     // Catch:{ all -> 0x0185 }
            goto L_0x00a6
        L_0x008a:
            r16 = r4
            java.lang.String r3 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            java.lang.String r4 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x0185 }
            java.lang.String r3 = r15.f14730b     // Catch:{ all -> 0x0185 }
            r12 = 0
            r11[r12] = r3     // Catch:{ all -> 0x0185 }
            java.lang.String r3 = r15.f14730b     // Catch:{ all -> 0x0185 }
            java.lang.String r3 = c((java.lang.String) r3)     // Catch:{ all -> 0x0185 }
            r5 = 1
            r11[r5] = r3     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.a(r4, r11)     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x0185 }
        L_0x00a6:
            r13.remove()     // Catch:{ all -> 0x0185 }
            int r14 = r14 + 1
            long r4 = r1.f14725b     // Catch:{ all -> 0x0185 }
            long r4 = r4 + r6
            float r4 = (float) r4     // Catch:{ all -> 0x0185 }
            int r5 = r1.f14727d     // Catch:{ all -> 0x0185 }
            float r5 = (float) r5     // Catch:{ all -> 0x0185 }
            r11 = 1063675494(0x3f666666, float:0.9)
            float r5 = r5 * r11
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x00bc
            goto L_0x00c1
        L_0x00bc:
            r4 = r16
            goto L_0x0062
        L_0x00bf:
            r16 = r4
        L_0x00c1:
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            java.lang.String r4 = "pruned %d files, %d bytes, %d ms"
            r5 = 3
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0185 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0185 }
            r7 = 0
            r6[r7] = r5     // Catch:{ all -> 0x0185 }
            long r11 = r1.f14725b     // Catch:{ all -> 0x0185 }
            long r11 = r11 - r16
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0185 }
            r3 = 1
            r6[r3] = r5     // Catch:{ all -> 0x0185 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0185 }
            long r11 = r11 - r8
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0185 }
            r6[r10] = r5     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.a(r4, r6)     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ all -> 0x0185 }
        L_0x00eb:
            java.io.File r4 = r18.d((java.lang.String) r19)     // Catch:{ all -> 0x0185 }
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x013a }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x013a }
            r7.<init>(r4)     // Catch:{ IOException -> 0x013a }
            r6.<init>(r7)     // Catch:{ IOException -> 0x013a }
            com.alipay.imobile.network.quake.b.b$a r5 = new com.alipay.imobile.network.quake.b.b$a     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r5.<init>(r0, r2)     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            boolean r7 = r5.a((java.io.OutputStream) r6)     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            if (r7 == 0) goto L_0x0119
            byte[] r7 = r2.f14718a     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r6.write(r7)     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r1.a((java.lang.String) r0, (com.alipay.imobile.network.quake.b.b.a) r5)     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r6.close()     // Catch:{ IOException -> 0x0112 }
            monitor-exit(r18)
            return
        L_0x0112:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0185 }
            monitor-exit(r18)
            return
        L_0x0119:
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            java.lang.String r5 = "Failed to write header for %s"
            r3 = 1
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            java.lang.String r8 = r4.getAbsolutePath()     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r9 = 0
            r7[r9] = r8     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            com.alipay.iap.android.common.b.c.a(r5, r7)     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            r5.<init>()     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
            throw r5     // Catch:{ IOException -> 0x0135, all -> 0x0133 }
        L_0x0133:
            r0 = move-exception
            goto L_0x0179
        L_0x0135:
            r5 = r6
            goto L_0x013a
        L_0x0137:
            r0 = move-exception
            r6 = r5
            goto L_0x0179
        L_0x013a:
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0137 }
            java.lang.String r6 = "Failed to put key=%s, entry=%s for %s "
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0137 }
            r8 = 0
            r7[r8] = r0     // Catch:{ all -> 0x0137 }
            r0 = 1
            r7[r0] = r2     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ all -> 0x0137 }
            r7[r10] = r0     // Catch:{ all -> 0x0137 }
            com.alipay.iap.android.common.b.c.a(r6, r7)     // Catch:{ all -> 0x0137 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x0137 }
            if (r5 == 0) goto L_0x015e
            r5.close()     // Catch:{ IOException -> 0x0159 }
            goto L_0x015e
        L_0x0159:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0185 }
        L_0x015e:
            boolean r0 = r4.delete()     // Catch:{ all -> 0x0185 }
            if (r0 != 0) goto L_0x0177
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = "Could not clean up file "
            r0.<init>(r2)     // Catch:{ all -> 0x0185 }
            java.lang.String r2 = r4.getAbsolutePath()     // Catch:{ all -> 0x0185 }
            r0.append(r2)     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x0185 }
        L_0x0177:
            monitor-exit(r18)
            return
        L_0x0179:
            if (r6 == 0) goto L_0x0184
            r6.close()     // Catch:{ IOException -> 0x017f }
            goto L_0x0184
        L_0x017f:
            java.lang.String r2 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0185 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0185 }
        L_0x0184:
            throw r0     // Catch:{ all -> 0x0185 }
        L_0x0185:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.b.b.a(java.lang.String, com.alipay.imobile.network.quake.b.a$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r7 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0047 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x0047 }
            monitor-exit(r6)
            return
        L_0x000e:
            java.io.File r0 = r6.d((java.lang.String) r7)     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.delete()     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.b.b$a> r1 = r6.f14724a     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0047 }
            com.alipay.imobile.network.quake.b.b$a r1 = (com.alipay.imobile.network.quake.b.b.a) r1     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x002c
            long r2 = r6.f14725b     // Catch:{ all -> 0x0047 }
            long r4 = r1.f14729a     // Catch:{ all -> 0x0047 }
            long r2 = r2 - r4
            r6.f14725b = r2     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.b.b$a> r1 = r6.f14724a     // Catch:{ all -> 0x0047 }
            r1.remove(r7)     // Catch:{ all -> 0x0047 }
        L_0x002c:
            if (r0 != 0) goto L_0x0045
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = "Could not delete cache entry for key=%s, filename=%s"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0047 }
            r2 = 0
            r1[r2] = r7     // Catch:{ all -> 0x0047 }
            r2 = 1
            java.lang.String r7 = c((java.lang.String) r7)     // Catch:{ all -> 0x0047 }
            r1[r2] = r7     // Catch:{ all -> 0x0047 }
            com.alipay.iap.android.common.b.c.a(r0, r1)     // Catch:{ all -> 0x0047 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r6)
            return
        L_0x0047:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.b.b.b(java.lang.String):void");
    }
}

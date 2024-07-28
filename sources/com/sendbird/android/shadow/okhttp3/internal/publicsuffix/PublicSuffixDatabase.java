package com.sendbird.android.shadow.okhttp3.internal.publicsuffix;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.GzipSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Source;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {
    private static final String[] EMPTY_RULE = new String[0];
    private static final byte EXCEPTION_MARKER = 33;
    private static final String[] PREVAILING_RULE = {"*"};
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int i2;
        int i3;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] findMatchingRule = findMatchingRule(split);
            if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
                return null;
            }
            if (findMatchingRule[0].charAt(0) == '!') {
                i3 = split.length;
                i2 = findMatchingRule.length;
            } else {
                i3 = split.length;
                i2 = findMatchingRule.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i4 = i3 - i2; i4 < split2.length; i4++) {
                sb.append(split2[i4]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] findMatchingRule(java.lang.String[] r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.listRead
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.listRead
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0016
            r7.readTheListUninterruptibly()
            goto L_0x0023
        L_0x0016:
            java.util.concurrent.CountDownLatch r0 = r7.readCompleteLatch     // Catch:{ InterruptedException -> 0x001c }
            r0.await()     // Catch:{ InterruptedException -> 0x001c }
            goto L_0x0023
        L_0x001c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0023:
            monitor-enter(r7)
            byte[] r0 = r7.publicSuffixListBytes     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00b7
            monitor-exit(r7)     // Catch:{ all -> 0x00bf }
            int r0 = r8.length
            byte[][] r0 = new byte[r0][]
            r3 = 0
        L_0x002d:
            int r4 = r8.length
            if (r3 >= r4) goto L_0x003d
            r4 = r8[r3]
            java.nio.charset.Charset r5 = com.sendbird.android.shadow.okhttp3.internal.Util.UTF_8
            byte[] r4 = r4.getBytes(r5)
            r0[r3] = r4
            int r3 = r3 + 1
            goto L_0x002d
        L_0x003d:
            r8 = 0
        L_0x003e:
            int r3 = r0.length
            r4 = 0
            if (r8 >= r3) goto L_0x004e
            byte[] r3 = r7.publicSuffixListBytes
            java.lang.String r3 = binarySearchBytes(r3, r0, r8)
            if (r3 == 0) goto L_0x004b
            goto L_0x004f
        L_0x004b:
            int r8 = r8 + 1
            goto L_0x003e
        L_0x004e:
            r3 = r4
        L_0x004f:
            int r8 = r0.length
            if (r8 <= r2) goto L_0x006d
            java.lang.Object r8 = r0.clone()
            byte[][] r8 = (byte[][]) r8
            r5 = 0
        L_0x0059:
            int r6 = r8.length
            int r6 = r6 - r2
            if (r5 >= r6) goto L_0x006d
            byte[] r6 = WILDCARD_LABEL
            r8[r5] = r6
            byte[] r6 = r7.publicSuffixListBytes
            java.lang.String r6 = binarySearchBytes(r6, r8, r5)
            if (r6 == 0) goto L_0x006a
            goto L_0x006e
        L_0x006a:
            int r5 = r5 + 1
            goto L_0x0059
        L_0x006d:
            r6 = r4
        L_0x006e:
            if (r6 == 0) goto L_0x0080
        L_0x0070:
            int r8 = r0.length
            int r8 = r8 - r2
            if (r1 >= r8) goto L_0x0080
            byte[] r8 = r7.publicSuffixExceptionListBytes
            java.lang.String r8 = binarySearchBytes(r8, r0, r1)
            if (r8 == 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            int r1 = r1 + 1
            goto L_0x0070
        L_0x0080:
            r8 = r4
        L_0x0081:
            if (r8 == 0) goto L_0x0094
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r0 = "!"
            java.lang.String r8 = r0.concat(r8)
            java.lang.String r0 = "\\."
            java.lang.String[] r8 = r8.split(r0)
            return r8
        L_0x0094:
            if (r3 != 0) goto L_0x009b
            if (r6 != 0) goto L_0x009b
            java.lang.String[] r8 = PREVAILING_RULE
            return r8
        L_0x009b:
            if (r3 == 0) goto L_0x00a4
            java.lang.String r8 = "\\."
            java.lang.String[] r8 = r3.split(r8)
            goto L_0x00a6
        L_0x00a4:
            java.lang.String[] r8 = EMPTY_RULE
        L_0x00a6:
            if (r6 == 0) goto L_0x00af
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r6.split(r0)
            goto L_0x00b1
        L_0x00af:
            java.lang.String[] r0 = EMPTY_RULE
        L_0x00b1:
            int r1 = r8.length
            int r2 = r0.length
            if (r1 <= r2) goto L_0x00b6
            return r8
        L_0x00b6:
            return r0
        L_0x00b7:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            r8.<init>(r0)     // Catch:{ all -> 0x00bf }
            throw r8     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00bf }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.lang.String[]):java.lang.String[]");
    }

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        byte b2;
        int i4;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr3[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i3 = i7 + i8;
                if (bArr3[i3] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i3 - i7;
            int i10 = i2;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    b2 = 46;
                } else {
                    b2 = bArr4[i10][i11] & 255;
                }
                i4 = b2 - (bArr3[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 != i9) {
                    if (bArr4[i10].length == i11) {
                        if (i10 == bArr4.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr4[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, Util.UTF_8);
                        }
                    }
                }
                i5 = i3 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0025, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002a
        L_0x0010:
            r1 = move-exception
            com.sendbird.android.shadow.okhttp3.internal.platform.Platform r2 = com.sendbird.android.shadow.okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x000e }
            r3 = 5
            java.lang.String r4 = "Failed to read public suffix list"
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0024
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0024:
            return
        L_0x0025:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002a:
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0033:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            BufferedSource buffer = Okio.buffer((Source) new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] bArr = new byte[buffer.readInt()];
                buffer.readFully(bArr);
                byte[] bArr2 = new byte[buffer.readInt()];
                buffer.readFully(bArr2);
                synchronized (this) {
                    this.publicSuffixListBytes = bArr;
                    this.publicSuffixExceptionListBytes = bArr2;
                }
                this.readCompleteLatch.countDown();
            } finally {
                Util.closeQuietly((Closeable) buffer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}

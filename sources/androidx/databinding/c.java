package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class c<C, T, A> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private List<C> f3266a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private long f3267b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long[] f3268c;

    /* renamed from: d  reason: collision with root package name */
    private int f3269d;

    /* renamed from: e  reason: collision with root package name */
    private final a<C, T, A> f3270e;

    public static abstract class a<C, T, A> {
        public abstract void a(C c2, T t, int i2);
    }

    public c(a<C, T, A> aVar) {
        this.f3270e = aVar;
    }

    public final synchronized void a(T t, int i2) {
        this.f3269d++;
        int size = this.f3266a.size();
        int length = this.f3268c == null ? -1 : this.f3268c.length - 1;
        a(t, i2, (Object) null, length);
        a(t, i2, (length + 2) * 64, size, 0);
        this.f3269d--;
        if (this.f3269d == 0) {
            if (this.f3268c != null) {
                for (int length2 = this.f3268c.length - 1; length2 >= 0; length2--) {
                    long j = this.f3268c[length2];
                    if (j != 0) {
                        a((length2 + 1) * 64, j);
                        this.f3268c[length2] = 0;
                    }
                }
            }
            if (this.f3267b != 0) {
                a(0, this.f3267b);
                this.f3267b = 0;
            }
        }
    }

    private void b(T t, int i2) {
        a(t, i2, 0, Math.min(64, this.f3266a.size()), this.f3267b);
    }

    private void a(T t, int i2, A a2, int i3) {
        if (i3 < 0) {
            b(t, i2);
            return;
        }
        long j = this.f3268c[i3];
        int i4 = (i3 + 1) * 64;
        int min = Math.min(this.f3266a.size(), i4 + 64);
        a(t, i2, a2, i3 - 1);
        a(t, i2, i4, min, j);
    }

    private void a(T t, int i2, int i3, int i4, long j) {
        long j2 = 1;
        while (i3 < i4) {
            if ((j & j2) == 0) {
                this.f3270e.a(this.f3266a.get(i3), t, i2);
            }
            j2 <<= 1;
            i3++;
        }
    }

    public final synchronized void a(C c2) {
        if (c2 != null) {
            int lastIndexOf = this.f3266a.lastIndexOf(c2);
            if (lastIndexOf < 0 || a(lastIndexOf)) {
                this.f3266a.add(c2);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    private boolean a(int i2) {
        int i3;
        if (i2 < 64) {
            return ((1 << i2) & this.f3267b) != 0;
        }
        long[] jArr = this.f3268c;
        if (jArr == null || (i3 = (i2 / 64) - 1) >= jArr.length) {
            return false;
        }
        return ((1 << (i2 % 64)) & jArr[i3]) != 0;
    }

    private void a(int i2, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i3 = (i2 + 64) - 1; i3 >= i2; i3--) {
            if ((j & j2) != 0) {
                this.f3266a.remove(i3);
            }
            j2 >>>= 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(C r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f3269d     // Catch:{ all -> 0x005a }
            if (r0 != 0) goto L_0x000c
            java.util.List<C> r0 = r8.f3266a     // Catch:{ all -> 0x005a }
            r0.remove(r9)     // Catch:{ all -> 0x005a }
            monitor-exit(r8)
            return
        L_0x000c:
            java.util.List<C> r0 = r8.f3266a     // Catch:{ all -> 0x005a }
            int r9 = r0.lastIndexOf(r9)     // Catch:{ all -> 0x005a }
            if (r9 < 0) goto L_0x0058
            r0 = 1
            r2 = 64
            if (r9 >= r2) goto L_0x0022
            long r0 = r0 << r9
            long r2 = r8.f3267b     // Catch:{ all -> 0x005a }
            long r0 = r0 | r2
            r8.f3267b = r0     // Catch:{ all -> 0x005a }
            monitor-exit(r8)
            return
        L_0x0022:
            int r3 = r9 / 64
            int r3 = r3 + -1
            long[] r4 = r8.f3268c     // Catch:{ all -> 0x005a }
            if (r4 != 0) goto L_0x0036
            java.util.List<C> r4 = r8.f3266a     // Catch:{ all -> 0x005a }
            int r4 = r4.size()     // Catch:{ all -> 0x005a }
            int r4 = r4 / r2
            long[] r4 = new long[r4]     // Catch:{ all -> 0x005a }
            r8.f3268c = r4     // Catch:{ all -> 0x005a }
            goto L_0x004f
        L_0x0036:
            long[] r4 = r8.f3268c     // Catch:{ all -> 0x005a }
            int r4 = r4.length     // Catch:{ all -> 0x005a }
            if (r4 > r3) goto L_0x004f
            java.util.List<C> r4 = r8.f3266a     // Catch:{ all -> 0x005a }
            int r4 = r4.size()     // Catch:{ all -> 0x005a }
            int r4 = r4 / r2
            long[] r4 = new long[r4]     // Catch:{ all -> 0x005a }
            long[] r5 = r8.f3268c     // Catch:{ all -> 0x005a }
            long[] r6 = r8.f3268c     // Catch:{ all -> 0x005a }
            int r6 = r6.length     // Catch:{ all -> 0x005a }
            r7 = 0
            java.lang.System.arraycopy(r5, r7, r4, r7, r6)     // Catch:{ all -> 0x005a }
            r8.f3268c = r4     // Catch:{ all -> 0x005a }
        L_0x004f:
            int r9 = r9 % r2
            long r0 = r0 << r9
            long[] r9 = r8.f3268c     // Catch:{ all -> 0x005a }
            r4 = r9[r3]     // Catch:{ all -> 0x005a }
            long r0 = r0 | r4
            r9[r3] = r0     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r8)
            return
        L_0x005a:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.c.b(java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e2;
        try {
            cVar = (c) super.clone();
            try {
                cVar.f3267b = 0;
                cVar.f3268c = null;
                cVar.f3269d = 0;
                cVar.f3266a = new ArrayList();
                int size = this.f3266a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!a(i2)) {
                        cVar.f3266a.add(this.f3266a.get(i2));
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e4) {
            CloneNotSupportedException cloneNotSupportedException = e4;
            cVar = null;
            e2 = cloneNotSupportedException;
            e2.printStackTrace();
            return cVar;
        }
        return cVar;
    }
}

package com.alipay.imobile.network.quake.h.b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    protected static final Comparator<byte[]> f14881a = new Comparator<byte[]>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((byte[]) obj).length - ((byte[]) obj2).length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private List<byte[]> f14882b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private List<byte[]> f14883c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    private int f14884d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f14885e = 4096;

    private synchronized void a() {
        while (this.f14884d > this.f14885e) {
            byte[] remove = this.f14882b.remove(0);
            this.f14883c.remove(remove);
            this.f14884d -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f14885e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f14882b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f14883c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f14881a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f14883c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f14884d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f14884d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.h.b.a.a(byte[]):void");
    }

    public final synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.f14883c.size(); i3++) {
            byte[] bArr = this.f14883c.get(i3);
            if (bArr.length >= i2) {
                this.f14884d -= bArr.length;
                this.f14883c.remove(i3);
                this.f14882b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}

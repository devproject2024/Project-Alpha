package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.b;

final class br {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37082a = new b("ExtractorTaskFinder");

    /* renamed from: b  reason: collision with root package name */
    private final bo f37083b;

    /* renamed from: c  reason: collision with root package name */
    private final ad f37084c;

    /* renamed from: d  reason: collision with root package name */
    private final am f37085d;

    br(bo boVar, ad adVar, am amVar) {
        this.f37083b = boVar;
        this.f37084c = adVar;
        this.f37085d = amVar;
    }

    private final boolean a(bl blVar, bm bmVar) {
        ad adVar = this.f37084c;
        bk bkVar = blVar.f37064c;
        String str = bkVar.f37057a;
        return adVar.e(str, blVar.f37063b, bkVar.f37058b, bmVar.f37065a).exists();
    }

    private static boolean a(bm bmVar) {
        int i2 = bmVar.f37070f;
        return i2 == 1 || i2 == 2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        f37082a.a("Found final move task for session %s with pack %s.", java.lang.Integer.valueOf(r5.f37062a), r5.f37064c.f37057a);
        r12 = r5.f37062a;
        r9 = r5.f37064c;
        r11 = new com.google.android.play.core.assetpacks.cc(r12, r9.f37057a, r5.f37063b, r9.f37058b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0322, code lost:
        f37082a.a("Found extraction task for patch for session %s, pack %s, slice %s.", java.lang.Integer.valueOf(r7.f37062a), r7.f37064c.f37057a, r11.f37065a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r2 = r1.f37084c;
        r4 = r7.f37064c;
        r0 = new java.io.FileInputStream(r2.e(r4.f37057a, r7.f37063b, r4.f37058b, r11.f37065a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r4 = r7.f37062a;
        r5 = r7.f37064c;
        r20 = new com.google.android.play.core.assetpacks.au(r4, r5.f37057a, r7.f37063b, r5.f37058b, r11.f37065a, 0, 0, 1, r5.f37060d, r5.f37059c, r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0316 A[Catch:{ FileNotFoundException -> 0x038e, IOException -> 0x0090, all -> 0x04b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.bq a() {
        /*
            r34 = this;
            r1 = r34
            java.lang.String r2 = "previousChunk"
            com.google.android.play.core.assetpacks.bo r0 = r1.f37083b     // Catch:{ all -> 0x04b0 }
            java.util.concurrent.locks.ReentrantLock r0 = r0.f37076f     // Catch:{ all -> 0x04b0 }
            r0.lock()     // Catch:{ all -> 0x04b0 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x04b0 }
            r3.<init>()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bo r0 = r1.f37083b     // Catch:{ all -> 0x04b0 }
            java.util.Map<java.lang.Integer, com.google.android.play.core.assetpacks.bl> r0 = r0.f37075e     // Catch:{ all -> 0x04b0 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x04b0 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x001c:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bl r4 = (com.google.android.play.core.assetpacks.bl) r4     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r4.f37064c     // Catch:{ all -> 0x04b0 }
            int r5 = r5.f37059c     // Catch:{ all -> 0x04b0 }
            boolean r5 = com.google.android.play.core.assetpacks.by.b(r5)     // Catch:{ all -> 0x04b0 }
            if (r5 == 0) goto L_0x001c
            r3.add(r4)     // Catch:{ all -> 0x04b0 }
            goto L_0x001c
        L_0x0036:
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x04b0 }
            if (r0 != 0) goto L_0x04a7
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x0040:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x04b0 }
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x00af
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bl r5 = (com.google.android.play.core.assetpacks.bl) r5     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r9 = r1.f37084c     // Catch:{ IOException -> 0x0090 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ IOException -> 0x0090 }
            java.lang.String r11 = r10.f37057a     // Catch:{ IOException -> 0x0090 }
            int r12 = r5.f37063b     // Catch:{ IOException -> 0x0090 }
            long r13 = r10.f37058b     // Catch:{ IOException -> 0x0090 }
            int r9 = r9.e(r11, r12, r13)     // Catch:{ IOException -> 0x0090 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ IOException -> 0x0090 }
            java.util.List<com.google.android.play.core.assetpacks.bm> r10 = r10.f37061e     // Catch:{ IOException -> 0x0090 }
            int r10 = r10.size()     // Catch:{ IOException -> 0x0090 }
            if (r9 != r10) goto L_0x0040
            com.google.android.play.core.b.b r0 = f37082a     // Catch:{ all -> 0x04b0 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x04b0 }
            int r10 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04b0 }
            r9[r8] = r10     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r10.f37057a     // Catch:{ all -> 0x04b0 }
            r9[r7] = r10     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = "Found final move task for session %s with pack %s."
            r0.a(r10, r9)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.cc r0 = new com.google.android.play.core.assetpacks.cc     // Catch:{ all -> 0x04b0 }
            int r12 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r9 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r13 = r9.f37057a     // Catch:{ all -> 0x04b0 }
            int r14 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r9 = r9.f37058b     // Catch:{ all -> 0x04b0 }
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04b0 }
            goto L_0x00b0
        L_0x0090:
            r0 = move-exception
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x04b0 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x04b0 }
            int r4 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x04b0 }
            r3[r8] = r4     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r4 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r4 = r4.f37057a     // Catch:{ all -> 0x04b0 }
            r3[r7] = r4     // Catch:{ all -> 0x04b0 }
            java.lang.String r4 = "Failed to check number of completed merges for session %s, pack %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x04b0 }
            int r4 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x04b0 }
            throw r2     // Catch:{ all -> 0x04b0 }
        L_0x00af:
            r0 = 0
        L_0x00b0:
            if (r0 != 0) goto L_0x049f
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x00b6:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x04b0 }
            r9 = 3
            if (r5 == 0) goto L_0x013a
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bl r5 = (com.google.android.play.core.assetpacks.bl) r5     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            int r10 = r10.f37059c     // Catch:{ all -> 0x04b0 }
            boolean r10 = com.google.android.play.core.assetpacks.by.b(r10)     // Catch:{ all -> 0x04b0 }
            if (r10 == 0) goto L_0x00b6
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.util.List<com.google.android.play.core.assetpacks.bm> r10 = r10.f37061e     // Catch:{ all -> 0x04b0 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x00d5:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r11 == 0) goto L_0x00b6
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bm r11 = (com.google.android.play.core.assetpacks.bm) r11     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r12 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r13 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r14 = r13.f37057a     // Catch:{ all -> 0x04b0 }
            int r15 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r6 = r13.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r13 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r17 = r13
            r13 = r14
            r14 = r15
            r15 = r6
            java.io.File r6 = r12.b(r13, r14, r15, r17)     // Catch:{ all -> 0x04b0 }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x04b0 }
            if (r6 == 0) goto L_0x0137
            com.google.android.play.core.b.b r0 = f37082a     // Catch:{ all -> 0x04b0 }
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ all -> 0x04b0 }
            int r7 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x04b0 }
            r6[r8] = r7     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r7 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = r7.f37057a     // Catch:{ all -> 0x04b0 }
            r10 = 1
            r6[r10] = r7     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r10 = 2
            r6[r10] = r7     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = "Found merge task for session %s with pack %s and slice %s."
            r0.a(r7, r6)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bz r0 = new com.google.android.play.core.assetpacks.bz     // Catch:{ all -> 0x04b0 }
            int r6 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r7 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r7.f37057a     // Catch:{ all -> 0x04b0 }
            int r5 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r12 = r7.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r20 = r0
            r21 = r6
            r22 = r10
            r23 = r5
            r24 = r12
            r26 = r7
            r20.<init>(r21, r22, r23, r24, r26)     // Catch:{ all -> 0x04b0 }
            goto L_0x013b
        L_0x0137:
            r6 = 2
            r7 = 1
            goto L_0x00d5
        L_0x013a:
            r0 = 0
        L_0x013b:
            if (r0 != 0) goto L_0x0497
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x0141:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r5 == 0) goto L_0x01dd
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bl r5 = (com.google.android.play.core.assetpacks.bl) r5     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r6 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            int r6 = r6.f37059c     // Catch:{ all -> 0x04b0 }
            boolean r6 = com.google.android.play.core.assetpacks.by.b(r6)     // Catch:{ all -> 0x04b0 }
            if (r6 == 0) goto L_0x0141
            com.google.android.play.core.assetpacks.bk r6 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.util.List<com.google.android.play.core.assetpacks.bm> r6 = r6.f37061e     // Catch:{ all -> 0x04b0 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x015f:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r7 == 0) goto L_0x0141
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bm r7 = (com.google.android.play.core.assetpacks.bm) r7     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.cm r17 = new com.google.android.play.core.assetpacks.cm     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r11 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r12 = r10.f37057a     // Catch:{ all -> 0x04b0 }
            int r13 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r14 = r10.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r7.f37065a     // Catch:{ all -> 0x04b0 }
            r16 = r10
            r10 = r17
            r10.<init>(r11, r12, r13, r14, r16)     // Catch:{ all -> 0x04b0 }
            boolean r10 = r17.c()     // Catch:{ all -> 0x04b0 }
            if (r10 == 0) goto L_0x015f
            com.google.android.play.core.assetpacks.ad r11 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r12 = r10.f37057a     // Catch:{ all -> 0x04b0 }
            int r13 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r14 = r10.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r7.f37065a     // Catch:{ all -> 0x04b0 }
            r16 = r10
            java.io.File r10 = r11.a(r12, r13, r14, r16)     // Catch:{ all -> 0x04b0 }
            boolean r10 = r10.exists()     // Catch:{ all -> 0x04b0 }
            if (r10 == 0) goto L_0x015f
            com.google.android.play.core.b.b r0 = f37082a     // Catch:{ all -> 0x04b0 }
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ all -> 0x04b0 }
            int r10 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04b0 }
            r6[r8] = r10     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r10.f37057a     // Catch:{ all -> 0x04b0 }
            r11 = 1
            r6[r11] = r10     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r7.f37065a     // Catch:{ all -> 0x04b0 }
            r11 = 2
            r6[r11] = r10     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = "Found verify task for session %s with pack %s and slice %s."
            r0.a(r10, r6)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.cp r0 = new com.google.android.play.core.assetpacks.cp     // Catch:{ all -> 0x04b0 }
            int r6 = r5.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r10 = r5.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r11 = r10.f37057a     // Catch:{ all -> 0x04b0 }
            int r5 = r5.f37063b     // Catch:{ all -> 0x04b0 }
            long r12 = r10.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r7.f37065a     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = r7.f37066b     // Catch:{ all -> 0x04b0 }
            r20 = r0
            r21 = r6
            r22 = r11
            r23 = r5
            r24 = r12
            r26 = r10
            r27 = r7
            r20.<init>(r21, r22, r23, r24, r26, r27)     // Catch:{ all -> 0x04b0 }
            goto L_0x01de
        L_0x01dd:
            r0 = 0
        L_0x01de:
            if (r0 != 0) goto L_0x048f
            java.util.Iterator r5 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x01e4:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x04b0 }
            r6 = 4
            if (r0 == 0) goto L_0x03bb
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x04b0 }
            r7 = r0
            com.google.android.play.core.assetpacks.bl r7 = (com.google.android.play.core.assetpacks.bl) r7     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r0 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            int r0 = r0.f37059c     // Catch:{ all -> 0x04b0 }
            boolean r0 = com.google.android.play.core.assetpacks.by.b(r0)     // Catch:{ all -> 0x04b0 }
            if (r0 == 0) goto L_0x01e4
            com.google.android.play.core.assetpacks.bk r0 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.util.List<com.google.android.play.core.assetpacks.bm> r0 = r0.f37061e     // Catch:{ all -> 0x04b0 }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x0204:
            boolean r0 = r10.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r0 == 0) goto L_0x01e4
            java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x04b0 }
            r11 = r0
            com.google.android.play.core.assetpacks.bm r11 = (com.google.android.play.core.assetpacks.bm) r11     // Catch:{ all -> 0x04b0 }
            boolean r0 = a(r11)     // Catch:{ all -> 0x04b0 }
            if (r0 != 0) goto L_0x031a
            com.google.android.play.core.assetpacks.cm r0 = new com.google.android.play.core.assetpacks.cm     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r12 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r13 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r14 = r13.f37057a     // Catch:{ all -> 0x04b0 }
            int r15 = r7.f37063b     // Catch:{ all -> 0x04b0 }
            r17 = r5
            long r4 = r13.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r13 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r20 = r0
            r21 = r12
            r22 = r14
            r23 = r15
            r24 = r4
            r26 = r13
            r20.<init>(r21, r22, r23, r24, r26)     // Catch:{ all -> 0x04b0 }
            r4 = -1
            com.google.android.play.core.assetpacks.ad r5 = r0.f37148a     // Catch:{ IOException -> 0x028b }
            java.lang.String r12 = r0.f37149b     // Catch:{ IOException -> 0x028b }
            int r13 = r0.f37150c     // Catch:{ IOException -> 0x028b }
            long r14 = r0.f37151d     // Catch:{ IOException -> 0x028b }
            java.lang.String r0 = r0.f37152e     // Catch:{ IOException -> 0x028b }
            r20 = r5
            r21 = r12
            r22 = r13
            r23 = r14
            r25 = r0
            java.io.File r0 = r20.c(r21, r22, r23, r25)     // Catch:{ IOException -> 0x028b }
            boolean r5 = r0.exists()     // Catch:{ IOException -> 0x028b }
            if (r5 == 0) goto L_0x0298
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x028b }
            r5.<init>(r0)     // Catch:{ IOException -> 0x028b }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x028b }
            r0.<init>()     // Catch:{ IOException -> 0x028b }
            r0.load(r5)     // Catch:{ IOException -> 0x028b }
            java.lang.String r5 = "fileStatus"
            java.lang.String r12 = "-1"
            java.lang.String r5 = r0.getProperty(r5, r12)     // Catch:{ IOException -> 0x028b }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x028b }
            if (r5 == r6) goto L_0x0289
            java.lang.String r5 = r0.getProperty(r2)     // Catch:{ IOException -> 0x028b }
            if (r5 == 0) goto L_0x0281
            java.lang.String r0 = r0.getProperty(r2)     // Catch:{ IOException -> 0x028b }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ IOException -> 0x028b }
            r5 = 1
            int r0 = r0 + r5
            goto L_0x0299
        L_0x0281:
            com.google.android.play.core.assetpacks.ax r0 = new com.google.android.play.core.assetpacks.ax     // Catch:{ IOException -> 0x028b }
            java.lang.String r5 = "Slice checkpoint file corrupt."
            r0.<init>(r5)     // Catch:{ IOException -> 0x028b }
            throw r0     // Catch:{ IOException -> 0x028b }
        L_0x0289:
            r0 = -1
            goto L_0x0299
        L_0x028b:
            r0 = move-exception
            com.google.android.play.core.b.b r5 = f37082a     // Catch:{ all -> 0x04b0 }
            r12 = 1
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x04b0 }
            r13[r8] = r0     // Catch:{ all -> 0x04b0 }
            java.lang.String r0 = "Slice checkpoint corrupt, restarting extraction. %s"
            r5.b(r0, r13)     // Catch:{ all -> 0x04b0 }
        L_0x0298:
            r0 = 0
        L_0x0299:
            if (r0 == r4) goto L_0x0316
            java.util.List<com.google.android.play.core.assetpacks.bj> r4 = r11.f37068d     // Catch:{ all -> 0x04b0 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bj r4 = (com.google.android.play.core.assetpacks.bj) r4     // Catch:{ all -> 0x04b0 }
            boolean r4 = r4.f37056a     // Catch:{ all -> 0x04b0 }
            if (r4 == 0) goto L_0x0316
            com.google.android.play.core.b.b r2 = f37082a     // Catch:{ all -> 0x04b0 }
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x04b0 }
            int r5 = r11.f37069e     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04b0 }
            r4[r8] = r5     // Catch:{ all -> 0x04b0 }
            int r5 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04b0 }
            r10 = 1
            r4[r10] = r5     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            r10 = 2
            r4[r10] = r5     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r4[r9] = r5     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x04b0 }
            r4[r6] = r5     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = "Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s."
            r2.a(r5, r4)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.am r2 = r1.f37085d     // Catch:{ all -> 0x04b0 }
            int r4 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            java.io.InputStream r33 = r2.a(r4, r5, r10, r0)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.au r2 = new com.google.android.play.core.assetpacks.au     // Catch:{ all -> 0x04b0 }
            int r4 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r10 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            int r12 = r7.f37063b     // Catch:{ all -> 0x04b0 }
            long r13 = r5.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            int r15 = r11.f37069e     // Catch:{ all -> 0x04b0 }
            java.util.List<com.google.android.play.core.assetpacks.bj> r11 = r11.f37068d     // Catch:{ all -> 0x04b0 }
            int r29 = r11.size()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r7 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            long r8 = r7.f37060d     // Catch:{ all -> 0x04b0 }
            int r7 = r7.f37059c     // Catch:{ all -> 0x04b0 }
            r20 = r2
            r21 = r4
            r22 = r10
            r23 = r12
            r24 = r13
            r26 = r5
            r27 = r15
            r28 = r0
            r30 = r8
            r32 = r7
            r20.<init>(r21, r22, r23, r24, r26, r27, r28, r29, r30, r32, r33)     // Catch:{ all -> 0x04b0 }
            goto L_0x03bc
        L_0x0316:
            r5 = r17
            goto L_0x0204
        L_0x031a:
            r17 = r5
            boolean r0 = r1.a(r7, r11)     // Catch:{ all -> 0x04b0 }
            if (r0 == 0) goto L_0x03b5
            com.google.android.play.core.b.b r0 = f37082a     // Catch:{ all -> 0x04b0 }
            r2 = 3
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x04b0 }
            int r2 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x04b0 }
            r5 = 0
            r4[r5] = r2     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r2 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r2 = r2.f37057a     // Catch:{ all -> 0x04b0 }
            r5 = 1
            r4[r5] = r2     // Catch:{ all -> 0x04b0 }
            java.lang.String r2 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r5 = 2
            r4[r5] = r2     // Catch:{ all -> 0x04b0 }
            java.lang.String r2 = "Found extraction task for patch for session %s, pack %s, slice %s."
            r0.a(r2, r4)     // Catch:{ all -> 0x04b0 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x038e }
            com.google.android.play.core.assetpacks.ad r2 = r1.f37084c     // Catch:{ FileNotFoundException -> 0x038e }
            com.google.android.play.core.assetpacks.bk r4 = r7.f37064c     // Catch:{ FileNotFoundException -> 0x038e }
            java.lang.String r5 = r4.f37057a     // Catch:{ FileNotFoundException -> 0x038e }
            int r8 = r7.f37063b     // Catch:{ FileNotFoundException -> 0x038e }
            long r9 = r4.f37058b     // Catch:{ FileNotFoundException -> 0x038e }
            java.lang.String r4 = r11.f37065a     // Catch:{ FileNotFoundException -> 0x038e }
            r20 = r2
            r21 = r5
            r22 = r8
            r23 = r9
            r25 = r4
            java.io.File r2 = r20.e(r21, r22, r23, r25)     // Catch:{ FileNotFoundException -> 0x038e }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x038e }
            com.google.android.play.core.assetpacks.au r2 = new com.google.android.play.core.assetpacks.au     // Catch:{ all -> 0x04b0 }
            int r4 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r8 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            int r7 = r7.f37063b     // Catch:{ all -> 0x04b0 }
            long r9 = r5.f37058b     // Catch:{ all -> 0x04b0 }
            java.lang.String r11 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            long r12 = r5.f37060d     // Catch:{ all -> 0x04b0 }
            r27 = 0
            r28 = 0
            r29 = 1
            int r5 = r5.f37059c     // Catch:{ all -> 0x04b0 }
            r20 = r2
            r21 = r4
            r22 = r8
            r23 = r7
            r24 = r9
            r26 = r11
            r30 = r12
            r32 = r5
            r33 = r0
            r20.<init>(r21, r22, r23, r24, r26, r27, r28, r29, r30, r32, r33)     // Catch:{ all -> 0x04b0 }
            goto L_0x03bc
        L_0x038e:
            r0 = move-exception
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x04b0 }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x04b0 }
            int r4 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x04b0 }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r4 = r7.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r4 = r4.f37057a     // Catch:{ all -> 0x04b0 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x04b0 }
            java.lang.String r4 = r11.f37065a     // Catch:{ all -> 0x04b0 }
            r5 = 2
            r3[r5] = r4     // Catch:{ all -> 0x04b0 }
            java.lang.String r4 = "Error finding patch, session %s packName %s sliceId %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x04b0 }
            int r4 = r7.f37062a     // Catch:{ all -> 0x04b0 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x04b0 }
            throw r2     // Catch:{ all -> 0x04b0 }
        L_0x03b5:
            r5 = r17
            r8 = 0
            r9 = 3
            goto L_0x0204
        L_0x03bb:
            r2 = 0
        L_0x03bc:
            if (r2 != 0) goto L_0x0487
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x03c2:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r2 == 0) goto L_0x0473
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bl r2 = (com.google.android.play.core.assetpacks.bl) r2     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r3 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            int r3 = r3.f37059c     // Catch:{ all -> 0x04b0 }
            boolean r3 = com.google.android.play.core.assetpacks.by.b(r3)     // Catch:{ all -> 0x04b0 }
            if (r3 == 0) goto L_0x03c2
            com.google.android.play.core.assetpacks.bk r3 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            java.util.List<com.google.android.play.core.assetpacks.bm> r3 = r3.f37061e     // Catch:{ all -> 0x04b0 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x04b0 }
        L_0x03e0:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x04b0 }
            if (r4 == 0) goto L_0x03c2
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bm r4 = (com.google.android.play.core.assetpacks.bm) r4     // Catch:{ all -> 0x04b0 }
            boolean r5 = a(r4)     // Catch:{ all -> 0x04b0 }
            if (r5 == 0) goto L_0x03e0
            java.util.List<com.google.android.play.core.assetpacks.bj> r5 = r4.f37068d     // Catch:{ all -> 0x04b0 }
            r7 = 0
            java.lang.Object r5 = r5.get(r7)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bj r5 = (com.google.android.play.core.assetpacks.bj) r5     // Catch:{ all -> 0x04b0 }
            boolean r5 = r5.f37056a     // Catch:{ all -> 0x04b0 }
            if (r5 == 0) goto L_0x03e0
            boolean r5 = r1.a(r2, r4)     // Catch:{ all -> 0x04b0 }
            if (r5 != 0) goto L_0x03e0
            com.google.android.play.core.b.b r0 = f37082a     // Catch:{ all -> 0x04b0 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x04b0 }
            int r5 = r4.f37070f     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04b0 }
            r6 = 0
            r3[r6] = r5     // Catch:{ all -> 0x04b0 }
            int r5 = r2.f37062a     // Catch:{ all -> 0x04b0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04b0 }
            r7 = 1
            r3[r7] = r5     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            r8 = 2
            r3[r8] = r5     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r4.f37065a     // Catch:{ all -> 0x04b0 }
            r9 = 3
            r3[r9] = r5     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = "Found patch slice task using patch format %s for session %s, pack %s, slice %s."
            r0.a(r5, r3)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.am r0 = r1.f37085d     // Catch:{ all -> 0x04b0 }
            int r3 = r2.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            java.lang.String r6 = r4.f37065a     // Catch:{ all -> 0x04b0 }
            r10 = 0
            java.io.InputStream r30 = r0.a(r3, r5, r6, r10)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ci r0 = new com.google.android.play.core.assetpacks.ci     // Catch:{ all -> 0x04b0 }
            int r3 = r2.f37062a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r5 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r5 = r5.f37057a     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r6 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            int r20 = r6.b((java.lang.String) r5)     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.ad r6 = r1.f37084c     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r7 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            java.lang.String r7 = r7.f37057a     // Catch:{ all -> 0x04b0 }
            long r21 = r6.c((java.lang.String) r7)     // Catch:{ all -> 0x04b0 }
            int r6 = r2.f37063b     // Catch:{ all -> 0x04b0 }
            com.google.android.play.core.assetpacks.bk r2 = r2.f37064c     // Catch:{ all -> 0x04b0 }
            long r7 = r2.f37058b     // Catch:{ all -> 0x04b0 }
            int r2 = r4.f37070f     // Catch:{ all -> 0x04b0 }
            java.lang.String r9 = r4.f37065a     // Catch:{ all -> 0x04b0 }
            long r10 = r4.f37067c     // Catch:{ all -> 0x04b0 }
            r17 = r0
            r18 = r3
            r19 = r5
            r23 = r6
            r24 = r7
            r26 = r2
            r27 = r9
            r28 = r10
            r17.<init>(r18, r19, r20, r21, r23, r24, r26, r27, r28, r30)     // Catch:{ all -> 0x04b0 }
            goto L_0x0474
        L_0x0473:
            r0 = 0
        L_0x0474:
            if (r0 != 0) goto L_0x047f
            com.google.android.play.core.assetpacks.bo r0 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r0 = r0.f37076f
            r0.unlock()
            r2 = 0
            return r2
        L_0x047f:
            com.google.android.play.core.assetpacks.bo r2 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f37076f
            r2.unlock()
            return r0
        L_0x0487:
            com.google.android.play.core.assetpacks.bo r0 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r0 = r0.f37076f
            r0.unlock()
            return r2
        L_0x048f:
            com.google.android.play.core.assetpacks.bo r2 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f37076f
            r2.unlock()
            return r0
        L_0x0497:
            com.google.android.play.core.assetpacks.bo r2 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f37076f
            r2.unlock()
            return r0
        L_0x049f:
            com.google.android.play.core.assetpacks.bo r2 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f37076f
            r2.unlock()
            return r0
        L_0x04a7:
            com.google.android.play.core.assetpacks.bo r0 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r0 = r0.f37076f
            r0.unlock()
            r2 = 0
            return r2
        L_0x04b0:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bo r2 = r1.f37083b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f37076f
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.br.a():com.google.android.play.core.assetpacks.bq");
    }
}

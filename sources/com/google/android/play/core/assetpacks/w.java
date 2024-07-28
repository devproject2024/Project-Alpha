package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f37251a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f37252b;

    w(x xVar, Bundle bundle) {
        this.f37251a = xVar;
        this.f37252b = bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v52, resolved type: java.io.InputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(20:31|(1:(1:(3:35|36|(1:38)(3:281|40|41))(3:280|42|43))(2:46|(18:48|84|(7:86|87|(8:88|(2:90|91)|93|94|(4:98|(4:100|(4:102|103|104|105)|296|106)(1:107)|109|(1:294)(2:111|(2:295|113)(1:114)))|108|109|(0)(0))|115|(1:117)|118|(2:120|(3:122|(1:124)|125)(2:126|(1:128)(17:129|(2:131|(1:133)(3:291|134|135))(1:136)|137|143|144|145|146|(2:148|149)|155|156|157|158|159|160|(1:162)|163|293))))(1:141)|142|143|144|145|146|(0)|155|156|157|158|159|160|(0)|163|293)(3:285|49|50)))(4:51|52|53|(2:55|(5:56|(1:59)|58|60|(1:63)(1:64)))(3:289|74|75))|39|84|(0)(0)|142|143|144|145|146|(0)|155|156|157|158|159|160|(0)|163|293) */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r19 = r4.length();
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01c7, code lost:
        if (r12 == r13) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01c9, code lost:
        com.google.android.play.core.assetpacks.av.f37011a.a("Chunk has ended while resuming the previous chunks file content.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d9, code lost:
        r8 = r14;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01e1, code lost:
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r15.a(r3.getCanonicalPath(), r19, r1, r9.f37006e);
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e6, code lost:
        r8 = r14;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0254, code lost:
        if (r12.a().endsWith("/") == false) goto L_0x0256;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:158:0x0491 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02bb A[Catch:{ all -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0408 A[SYNTHETIC, Splitter:B:148:0x0408] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04b3 A[Catch:{ IOException -> 0x0435, Exception -> 0x052d }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x02c6 A[EDGE_INSN: B:294:0x02c6->B:115:0x02c6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0237 A[SYNTHETIC, Splitter:B:86:0x0237] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r31 = this;
            r1 = r31
            com.google.android.play.core.assetpacks.x r2 = r1.f37251a
            android.os.Bundle r3 = r1.f37252b
            com.google.android.play.core.assetpacks.bo r4 = r2.f37253a
            com.google.android.play.core.assetpacks.bd r5 = new com.google.android.play.core.assetpacks.bd
            r5.<init>(r4, r3)
            java.lang.Object r3 = r4.a(r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0828
            com.google.android.play.core.assetpacks.ay r2 = r2.f37254b
            com.google.android.play.core.b.b r3 = com.google.android.play.core.assetpacks.ay.f37022a
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "Run extractor loop"
            r3.a(r6, r5)
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.f37030i
            r5 = 1
            boolean r3 = r3.compareAndSet(r4, r5)
            if (r3 == 0) goto L_0x081e
        L_0x002e:
            com.google.android.play.core.assetpacks.br r6 = r2.f37029h     // Catch:{ ax -> 0x0035 }
            com.google.android.play.core.assetpacks.bq r6 = r6.a()     // Catch:{ ax -> 0x0035 }
            goto L_0x005d
        L_0x0035:
            r0 = move-exception
            r6 = r0
            com.google.android.play.core.b.b r7 = com.google.android.play.core.assetpacks.ay.f37022a
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r9 = r6.getMessage()
            r8[r4] = r9
            java.lang.String r9 = "Error while getting next extraction task: %s"
            r7.b(r9, r8)
            int r7 = r6.f37021a
            if (r7 < 0) goto L_0x005c
            com.google.android.play.core.b.bh<com.google.android.play.core.assetpacks.dk> r7 = r2.f37028g
            java.lang.Object r7 = r7.a()
            com.google.android.play.core.assetpacks.dk r7 = (com.google.android.play.core.assetpacks.dk) r7
            int r8 = r6.f37021a
            r7.a((int) r8)
            int r7 = r6.f37021a
            r2.a(r7, r6)
        L_0x005c:
            r6 = 0
        L_0x005d:
            if (r6 == 0) goto L_0x0816
            boolean r7 = r6 instanceof com.google.android.play.core.assetpacks.au
            r8 = 2
            if (r7 == 0) goto L_0x0537
            com.google.android.play.core.assetpacks.av r7 = r2.f37023b     // Catch:{ Exception -> 0x0533 }
            r9 = r6
            com.google.android.play.core.assetpacks.au r9 = (com.google.android.play.core.assetpacks.au) r9     // Catch:{ Exception -> 0x0533 }
            com.google.android.play.core.assetpacks.cm r14 = new com.google.android.play.core.assetpacks.cm     // Catch:{ Exception -> 0x0533 }
            com.google.android.play.core.assetpacks.ad r11 = r7.f37013c     // Catch:{ Exception -> 0x0533 }
            java.lang.String r12 = r9.k     // Catch:{ Exception -> 0x0533 }
            int r13 = r9.f37002a     // Catch:{ Exception -> 0x0533 }
            long r3 = r9.f37003b     // Catch:{ Exception -> 0x0533 }
            java.lang.String r15 = r9.f37004c     // Catch:{ Exception -> 0x0533 }
            r10 = r14
            r17 = r14
            r16 = r15
            r14 = r3
            r10.<init>(r11, r12, r13, r14, r16)     // Catch:{ Exception -> 0x0533 }
            com.google.android.play.core.assetpacks.ad r3 = r7.f37013c     // Catch:{ Exception -> 0x0533 }
            java.lang.String r4 = r9.k     // Catch:{ Exception -> 0x0533 }
            int r10 = r9.f37002a     // Catch:{ Exception -> 0x0533 }
            long r11 = r9.f37003b     // Catch:{ Exception -> 0x0533 }
            java.lang.String r13 = r9.f37004c     // Catch:{ Exception -> 0x0533 }
            r18 = r3
            r19 = r4
            r20 = r10
            r21 = r11
            r23 = r13
            java.io.File r3 = r18.f(r19, r20, r21, r23)     // Catch:{ Exception -> 0x0533 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0533 }
            if (r4 != 0) goto L_0x009f
            r3.mkdirs()     // Catch:{ Exception -> 0x0533 }
        L_0x009f:
            r4 = 3
            java.io.InputStream r10 = r9.f37010i     // Catch:{ IOException -> 0x04eb }
            int r11 = r9.f37005d     // Catch:{ IOException -> 0x04eb }
            if (r11 == r5) goto L_0x00a8
            r14 = r10
            goto L_0x00b1
        L_0x00a8:
            java.util.zip.GZIPInputStream r11 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x04eb }
            byte[] r12 = r7.f37012b     // Catch:{ IOException -> 0x04eb }
            int r12 = r12.length     // Catch:{ IOException -> 0x04eb }
            r11.<init>(r10, r12)     // Catch:{ IOException -> 0x04eb }
            r14 = r11
        L_0x00b1:
            int r10 = r9.f37006e     // Catch:{ all -> 0x04da }
            if (r10 <= 0) goto L_0x022a
            com.google.android.play.core.assetpacks.cl r10 = r17.a()     // Catch:{ all -> 0x0223 }
            int r11 = r10.e()     // Catch:{ all -> 0x0223 }
            int r12 = r9.f37006e     // Catch:{ all -> 0x0223 }
            int r13 = r12 + -1
            if (r11 != r13) goto L_0x01f8
            int r11 = r10.a()     // Catch:{ all -> 0x0223 }
            if (r11 == r5) goto L_0x015c
            if (r11 == r8) goto L_0x0118
            if (r11 != r4) goto L_0x00f6
            com.google.android.play.core.b.b r11 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x0111 }
            java.lang.String r12 = "Resuming central directory from last chunk."
            r13 = 0
            java.lang.Object[] r15 = new java.lang.Object[r13]     // Catch:{ all -> 0x0111 }
            r11.a(r12, r15)     // Catch:{ all -> 0x0111 }
            long r10 = r10.c()     // Catch:{ all -> 0x0111 }
            r15 = r17
            r15.a((java.io.InputStream) r14, (long) r10)     // Catch:{ all -> 0x0111 }
            boolean r10 = r9.a()     // Catch:{ all -> 0x0111 }
            if (r10 == 0) goto L_0x00ec
            r5 = r2
            r8 = r14
            r4 = r15
        L_0x00e9:
            r1 = 0
            goto L_0x022f
        L_0x00ec:
            com.google.android.play.core.assetpacks.ax r7 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x0111 }
            java.lang.String r10 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r11 = r9.j     // Catch:{ all -> 0x0111 }
            r7.<init>((java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x0111 }
            throw r7     // Catch:{ all -> 0x0111 }
        L_0x00f6:
            com.google.android.play.core.assetpacks.ax r7 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x0111 }
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x0111 }
            int r10 = r10.a()     // Catch:{ all -> 0x0111 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0111 }
            r12 = 0
            r11[r12] = r10     // Catch:{ all -> 0x0111 }
            java.lang.String r10 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ all -> 0x0111 }
            int r11 = r9.j     // Catch:{ all -> 0x0111 }
            r7.<init>((java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x0111 }
            throw r7     // Catch:{ all -> 0x0111 }
        L_0x0111:
            r0 = move-exception
            r1 = r0
            r19 = r2
            r8 = r14
            goto L_0x04df
        L_0x0118:
            r15 = r17
            com.google.android.play.core.b.b r10 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = "Resuming zip entry from last chunk during local file header."
            r12 = 0
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x0111 }
            r10.a(r11, r13)     // Catch:{ all -> 0x0111 }
            com.google.android.play.core.assetpacks.ad r10 = r7.f37013c     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = r9.k     // Catch:{ all -> 0x0111 }
            int r12 = r9.f37002a     // Catch:{ all -> 0x0111 }
            long r3 = r9.f37003b     // Catch:{ all -> 0x0111 }
            java.lang.String r13 = r9.f37004c     // Catch:{ all -> 0x0111 }
            r17 = r10
            r18 = r11
            r19 = r12
            r20 = r3
            r22 = r13
            java.io.File r3 = r17.d(r18, r19, r20, r22)     // Catch:{ all -> 0x0111 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0111 }
            if (r4 == 0) goto L_0x0152
            java.io.SequenceInputStream r4 = new java.io.SequenceInputStream     // Catch:{ all -> 0x0111 }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ all -> 0x0111 }
            r10.<init>(r3)     // Catch:{ all -> 0x0111 }
            r4.<init>(r10, r14)     // Catch:{ all -> 0x0111 }
            r5 = r2
            r1 = r4
            r8 = r14
            r4 = r15
            goto L_0x022f
        L_0x0152:
            com.google.android.play.core.assetpacks.ax r3 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "Checkpoint extension file not found."
            int r7 = r9.j     // Catch:{ all -> 0x0111 }
            r3.<init>((java.lang.String) r4, (int) r7)     // Catch:{ all -> 0x0111 }
            throw r3     // Catch:{ all -> 0x0111 }
        L_0x015c:
            r15 = r17
            com.google.android.play.core.b.b r3 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x0223 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ all -> 0x0223 }
            java.lang.String r11 = r10.b()     // Catch:{ all -> 0x0223 }
            r12 = 0
            r4[r12] = r11     // Catch:{ all -> 0x0223 }
            java.lang.String r11 = "Resuming zip entry from last chunk during file %s."
            r3.a(r11, r4)     // Catch:{ all -> 0x0223 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0223 }
            java.lang.String r4 = r10.b()     // Catch:{ all -> 0x0223 }
            r3.<init>(r4)     // Catch:{ all -> 0x0223 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0223 }
            if (r4 == 0) goto L_0x01ec
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0223 }
            java.lang.String r11 = "rw"
            r4.<init>(r3, r11)     // Catch:{ all -> 0x0223 }
            long r11 = r10.c()     // Catch:{ all -> 0x0223 }
            r4.seek(r11)     // Catch:{ all -> 0x0223 }
            long r10 = r10.d()     // Catch:{ all -> 0x0223 }
        L_0x018f:
            byte[] r12 = r7.f37012b     // Catch:{ all -> 0x0223 }
            int r12 = r12.length     // Catch:{ all -> 0x0223 }
            long r12 = (long) r12     // Catch:{ all -> 0x0223 }
            long r12 = java.lang.Math.min(r10, r12)     // Catch:{ all -> 0x0223 }
            int r13 = (int) r12     // Catch:{ all -> 0x0223 }
            byte[] r12 = r7.f37012b     // Catch:{ all -> 0x0223 }
            r5 = 0
            int r12 = r14.read(r12, r5, r13)     // Catch:{ all -> 0x0223 }
            int r12 = java.lang.Math.max(r12, r5)     // Catch:{ all -> 0x0223 }
            if (r12 > 0) goto L_0x01a7
        L_0x01a5:
            r5 = r2
            goto L_0x01ad
        L_0x01a7:
            byte[] r8 = r7.f37012b     // Catch:{ all -> 0x0223 }
            r4.write(r8, r5, r12)     // Catch:{ all -> 0x0223 }
            goto L_0x01a5
        L_0x01ad:
            long r1 = (long) r12
            long r1 = r10 - r1
            r10 = 0
            int r8 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r8 > 0) goto L_0x01b7
            goto L_0x01c0
        L_0x01b7:
            if (r12 <= 0) goto L_0x01c0
            r8 = 2
            r10 = r1
            r2 = r5
            r5 = 1
            r1 = r31
            goto L_0x018f
        L_0x01c0:
            long r19 = r4.length()     // Catch:{ all -> 0x01e9 }
            r4.close()     // Catch:{ all -> 0x01e9 }
            if (r12 == r13) goto L_0x01e6
            com.google.android.play.core.b.b r4 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x01e9 }
            java.lang.String r8 = "Chunk has ended while resuming the previous chunks file content."
            r10 = 0
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x01e9 }
            r4.a(r8, r11)     // Catch:{ all -> 0x01e9 }
            java.lang.String r11 = r3.getCanonicalPath()     // Catch:{ all -> 0x01e9 }
            int r3 = r9.f37006e     // Catch:{ all -> 0x01e9 }
            r10 = r15
            r12 = r19
            r8 = r14
            r4 = r15
            r14 = r1
            r16 = r3
            r10.a(r11, r12, r14, r16)     // Catch:{ all -> 0x021d }
            goto L_0x00e9
        L_0x01e6:
            r8 = r14
            r4 = r15
            goto L_0x022e
        L_0x01e9:
            r0 = move-exception
            r8 = r14
            goto L_0x021e
        L_0x01ec:
            r5 = r2
            r8 = r14
            com.google.android.play.core.assetpacks.ax r1 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x021d }
            java.lang.String r2 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r3 = r9.j     // Catch:{ all -> 0x021d }
            r1.<init>((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x021d }
            throw r1     // Catch:{ all -> 0x021d }
        L_0x01f8:
            r5 = r2
            r8 = r14
            com.google.android.play.core.assetpacks.ax r1 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x021d }
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x021d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x021d }
            r4 = 0
            r3[r4] = r2     // Catch:{ all -> 0x021d }
            int r2 = r10.e()     // Catch:{ all -> 0x021d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x021d }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x021d }
            java.lang.String r2 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x021d }
            int r3 = r9.j     // Catch:{ all -> 0x021d }
            r1.<init>((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x021d }
            throw r1     // Catch:{ all -> 0x021d }
        L_0x021d:
            r0 = move-exception
        L_0x021e:
            r1 = r0
            r19 = r5
            goto L_0x04df
        L_0x0223:
            r0 = move-exception
            r8 = r14
            r1 = r0
            r19 = r2
            goto L_0x04df
        L_0x022a:
            r5 = r2
            r8 = r14
            r4 = r17
        L_0x022e:
            r1 = r8
        L_0x022f:
            java.lang.String r2 = "metadataFileCounter"
            java.lang.String r3 = "previousChunk"
            java.lang.String r14 = "fileStatus"
            if (r1 == 0) goto L_0x03fc
            com.google.android.play.core.assetpacks.ao r10 = new com.google.android.play.core.assetpacks.ao     // Catch:{ all -> 0x03f7 }
            r10.<init>(r1)     // Catch:{ all -> 0x03f7 }
            java.io.File r11 = r7.a(r9)     // Catch:{ all -> 0x03f7 }
        L_0x0240:
            com.google.android.play.core.assetpacks.cs r12 = r10.a()     // Catch:{ all -> 0x03f7 }
            java.lang.String r13 = r12.a()     // Catch:{ all -> 0x03f7 }
            if (r13 == 0) goto L_0x0256
            java.lang.String r13 = r12.a()     // Catch:{ all -> 0x021d }
            java.lang.String r15 = "/"
            boolean r13 = r13.endsWith(r15)     // Catch:{ all -> 0x021d }
            if (r13 != 0) goto L_0x02b3
        L_0x0256:
            boolean r13 = r12.d()     // Catch:{ all -> 0x03f7 }
            if (r13 != 0) goto L_0x02b3
            boolean r13 = r10.f36988c     // Catch:{ all -> 0x03f7 }
            if (r13 != 0) goto L_0x02b3
            int r13 = r12.c()     // Catch:{ all -> 0x03f7 }
            if (r13 != 0) goto L_0x02a7
            byte[] r13 = r12.e()     // Catch:{ all -> 0x03f7 }
            r4.a(r13)     // Catch:{ all -> 0x03f7 }
            java.io.File r13 = new java.io.File     // Catch:{ all -> 0x03f7 }
            java.lang.String r15 = r12.a()     // Catch:{ all -> 0x03f7 }
            r13.<init>(r11, r15)     // Catch:{ all -> 0x03f7 }
            java.io.File r15 = r13.getParentFile()     // Catch:{ all -> 0x03f7 }
            r15.mkdirs()     // Catch:{ all -> 0x03f7 }
            java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ all -> 0x03f7 }
            r15.<init>(r13)     // Catch:{ all -> 0x03f7 }
            byte[] r13 = r7.f37012b     // Catch:{ all -> 0x03f7 }
            int r13 = r10.read(r13)     // Catch:{ all -> 0x03f7 }
        L_0x0288:
            if (r13 <= 0) goto L_0x029f
            r16 = r11
            byte[] r11 = r7.f37012b     // Catch:{ all -> 0x03f7 }
            r19 = r5
            r5 = 0
            r15.write(r11, r5, r13)     // Catch:{ all -> 0x03f4 }
            byte[] r5 = r7.f37012b     // Catch:{ all -> 0x03f4 }
            int r13 = r10.read(r5)     // Catch:{ all -> 0x03f4 }
            r11 = r16
            r5 = r19
            goto L_0x0288
        L_0x029f:
            r19 = r5
            r16 = r11
            r15.close()     // Catch:{ all -> 0x03f4 }
            goto L_0x02b7
        L_0x02a7:
            r19 = r5
            r16 = r11
            byte[] r5 = r12.e()     // Catch:{ all -> 0x03f4 }
            r4.a((byte[]) r5, (java.io.InputStream) r10)     // Catch:{ all -> 0x03f4 }
            goto L_0x02b7
        L_0x02b3:
            r19 = r5
            r16 = r11
        L_0x02b7:
            boolean r5 = r10.f36987b     // Catch:{ all -> 0x03f4 }
            if (r5 != 0) goto L_0x02c6
            boolean r5 = r10.f36988c     // Catch:{ all -> 0x03f4 }
            if (r5 == 0) goto L_0x02c0
            goto L_0x02c6
        L_0x02c0:
            r11 = r16
            r5 = r19
            goto L_0x0240
        L_0x02c6:
            boolean r5 = r10.f36988c     // Catch:{ all -> 0x03f4 }
            if (r5 == 0) goto L_0x02db
            com.google.android.play.core.b.b r5 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = "Writing central directory metadata."
            r13 = 0
            java.lang.Object[] r15 = new java.lang.Object[r13]     // Catch:{ all -> 0x03f4 }
            r5.a(r11, r15)     // Catch:{ all -> 0x03f4 }
            byte[] r5 = r12.e()     // Catch:{ all -> 0x03f4 }
            r4.a((byte[]) r5, (java.io.InputStream) r1)     // Catch:{ all -> 0x03f4 }
        L_0x02db:
            boolean r1 = r9.a()     // Catch:{ all -> 0x03f4 }
            if (r1 != 0) goto L_0x03fe
            boolean r1 = r12.d()     // Catch:{ all -> 0x03f4 }
            if (r1 == 0) goto L_0x034f
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x03f4 }
            java.lang.String r5 = "Writing slice checkpoint for partial local file header."
            r10 = 0
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x03f4 }
            r1.a(r5, r11)     // Catch:{ all -> 0x03f4 }
            byte[] r1 = r12.e()     // Catch:{ all -> 0x03f4 }
            int r5 = r9.f37006e     // Catch:{ all -> 0x03f4 }
            java.util.Properties r10 = new java.util.Properties     // Catch:{ all -> 0x03f4 }
            r10.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = "2"
            r10.put(r14, r11)     // Catch:{ all -> 0x03f4 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x03f4 }
            r10.put(r3, r5)     // Catch:{ all -> 0x03f4 }
            int r5 = r4.f37153f     // Catch:{ all -> 0x03f4 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x03f4 }
            r10.put(r2, r5)     // Catch:{ all -> 0x03f4 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x03f4 }
            java.io.File r11 = r4.d()     // Catch:{ all -> 0x03f4 }
            r5.<init>(r11)     // Catch:{ all -> 0x03f4 }
            r11 = 0
            r10.store(r5, r11)     // Catch:{ all -> 0x03f4 }
            r5.close()     // Catch:{ all -> 0x03f4 }
            com.google.android.play.core.assetpacks.ad r5 = r4.f37148a     // Catch:{ all -> 0x03f4 }
            java.lang.String r10 = r4.f37149b     // Catch:{ all -> 0x03f4 }
            int r11 = r4.f37150c     // Catch:{ all -> 0x03f4 }
            long r12 = r4.f37151d     // Catch:{ all -> 0x03f4 }
            java.lang.String r15 = r4.f37152e     // Catch:{ all -> 0x03f4 }
            r25 = r5
            r26 = r10
            r27 = r11
            r28 = r12
            r30 = r15
            java.io.File r5 = r25.d(r26, r27, r28, r30)     // Catch:{ all -> 0x03f4 }
            boolean r10 = r5.exists()     // Catch:{ all -> 0x03f4 }
            if (r10 == 0) goto L_0x0342
            r5.delete()     // Catch:{ all -> 0x03f4 }
        L_0x0342:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x03f4 }
            r10.<init>(r5)     // Catch:{ all -> 0x03f4 }
            r10.write(r1)     // Catch:{ all -> 0x03f4 }
            r10.close()     // Catch:{ all -> 0x03f4 }
            goto L_0x03fe
        L_0x034f:
            boolean r1 = r10.f36988c     // Catch:{ all -> 0x03f4 }
            if (r1 == 0) goto L_0x039b
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x03f4 }
            java.lang.String r5 = "Writing slice checkpoint for central directory."
            r10 = 0
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x03f4 }
            r1.a(r5, r11)     // Catch:{ all -> 0x03f4 }
            int r1 = r9.f37006e     // Catch:{ all -> 0x03f4 }
            java.util.Properties r5 = new java.util.Properties     // Catch:{ all -> 0x03f4 }
            r5.<init>()     // Catch:{ all -> 0x03f4 }
            java.lang.String r10 = "3"
            r5.put(r14, r10)     // Catch:{ all -> 0x03f4 }
            java.lang.String r10 = "fileOffset"
            java.io.File r11 = r4.b()     // Catch:{ all -> 0x03f4 }
            long r11 = r11.length()     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x03f4 }
            r5.put(r10, r11)     // Catch:{ all -> 0x03f4 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x03f4 }
            r5.put(r3, r1)     // Catch:{ all -> 0x03f4 }
            int r1 = r4.f37153f     // Catch:{ all -> 0x03f4 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x03f4 }
            r5.put(r2, r1)     // Catch:{ all -> 0x03f4 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x03f4 }
            java.io.File r10 = r4.d()     // Catch:{ all -> 0x03f4 }
            r1.<init>(r10)     // Catch:{ all -> 0x03f4 }
            r10 = 0
            r5.store(r1, r10)     // Catch:{ all -> 0x03f4 }
            r1.close()     // Catch:{ all -> 0x03f4 }
            goto L_0x03fe
        L_0x039b:
            int r1 = r12.c()     // Catch:{ all -> 0x03f4 }
            if (r1 != 0) goto L_0x03d1
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x03f4 }
            java.lang.String r5 = "Writing slice checkpoint for partial file."
            r11 = 0
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ all -> 0x03f4 }
            r1.a(r5, r13)     // Catch:{ all -> 0x03f4 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x03f4 }
            java.io.File r5 = r7.a(r9)     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = r12.a()     // Catch:{ all -> 0x03f4 }
            r1.<init>(r5, r11)     // Catch:{ all -> 0x03f4 }
            long r11 = r12.b()     // Catch:{ all -> 0x03f4 }
            r5 = r14
            long r13 = r10.f36986a     // Catch:{ all -> 0x03f4 }
            long r11 = r11 - r13
            long r13 = r1.length()     // Catch:{ all -> 0x03f4 }
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x03c9
            goto L_0x03e4
        L_0x03c9:
            com.google.android.play.core.assetpacks.ax r1 = new com.google.android.play.core.assetpacks.ax     // Catch:{ all -> 0x03f4 }
            java.lang.String r2 = "Partial file is of unexpected size."
            r1.<init>(r2)     // Catch:{ all -> 0x03f4 }
            throw r1     // Catch:{ all -> 0x03f4 }
        L_0x03d1:
            r5 = r14
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ all -> 0x03f4 }
            java.lang.String r11 = "Writing slice checkpoint for partial unextractable file."
            r12 = 0
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x03f4 }
            r1.a(r11, r13)     // Catch:{ all -> 0x03f4 }
            java.io.File r1 = r4.b()     // Catch:{ all -> 0x03f4 }
            long r11 = r1.length()     // Catch:{ all -> 0x03f4 }
        L_0x03e4:
            r12 = r11
            java.lang.String r11 = r1.getCanonicalPath()     // Catch:{ all -> 0x03f4 }
            long r14 = r10.f36986a     // Catch:{ all -> 0x03f4 }
            int r1 = r9.f37006e     // Catch:{ all -> 0x03f4 }
            r10 = r4
            r16 = r1
            r10.a(r11, r12, r14, r16)     // Catch:{ all -> 0x03f4 }
            goto L_0x03ff
        L_0x03f4:
            r0 = move-exception
            goto L_0x04de
        L_0x03f7:
            r0 = move-exception
            r19 = r5
            goto L_0x04de
        L_0x03fc:
            r19 = r5
        L_0x03fe:
            r5 = r14
        L_0x03ff:
            r8.close()     // Catch:{ IOException -> 0x04e9 }
            boolean r1 = r9.a()     // Catch:{ Exception -> 0x052d }
            if (r1 == 0) goto L_0x0452
            int r1 = r9.f37006e     // Catch:{ IOException -> 0x0435 }
            java.util.Properties r8 = new java.util.Properties     // Catch:{ IOException -> 0x0435 }
            r8.<init>()     // Catch:{ IOException -> 0x0435 }
            java.lang.String r10 = "4"
            r8.put(r5, r10)     // Catch:{ IOException -> 0x0435 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0435 }
            r8.put(r3, r1)     // Catch:{ IOException -> 0x0435 }
            int r1 = r4.f37153f     // Catch:{ IOException -> 0x0435 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0435 }
            r8.put(r2, r1)     // Catch:{ IOException -> 0x0435 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0435 }
            java.io.File r2 = r4.d()     // Catch:{ IOException -> 0x0435 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0435 }
            r2 = 0
            r8.store(r1, r2)     // Catch:{ IOException -> 0x0435 }
            r1.close()     // Catch:{ IOException -> 0x0435 }
            goto L_0x0452
        L_0x0435:
            r0 = move-exception
            r1 = r0
            com.google.android.play.core.b.b r2 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ Exception -> 0x052d }
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ Exception -> 0x052d }
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = "Writing extraction finished checkpoint failed with %s."
            r2.b(r3, r4)     // Catch:{ Exception -> 0x052d }
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = "Writing extraction finished checkpoint failed."
            int r4 = r9.j     // Catch:{ Exception -> 0x052d }
            r2.<init>(r3, r1, r4)     // Catch:{ Exception -> 0x052d }
            throw r2     // Catch:{ Exception -> 0x052d }
        L_0x0452:
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ Exception -> 0x052d }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x052d }
            int r3 = r9.f37006e     // Catch:{ Exception -> 0x052d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x052d }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = r9.f37004c     // Catch:{ Exception -> 0x052d }
            r4 = 1
            r2[r4] = r3     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = r9.k     // Catch:{ Exception -> 0x052d }
            r4 = 2
            r2[r4] = r3     // Catch:{ Exception -> 0x052d }
            int r3 = r9.j     // Catch:{ Exception -> 0x052d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x052d }
            r4 = 3
            r2[r4] = r3     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r1.d(r3, r2)     // Catch:{ Exception -> 0x052d }
            com.google.android.play.core.b.bh<com.google.android.play.core.assetpacks.dk> r1 = r7.f37014d     // Catch:{ Exception -> 0x052d }
            java.lang.Object r1 = r1.a()     // Catch:{ Exception -> 0x052d }
            com.google.android.play.core.assetpacks.dk r1 = (com.google.android.play.core.assetpacks.dk) r1     // Catch:{ Exception -> 0x052d }
            int r2 = r9.j     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = r9.k     // Catch:{ Exception -> 0x052d }
            java.lang.String r4 = r9.f37004c     // Catch:{ Exception -> 0x052d }
            int r5 = r9.f37006e     // Catch:{ Exception -> 0x052d }
            r1.a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x052d }
            java.io.InputStream r1 = r9.f37010i     // Catch:{ IOException -> 0x0491 }
            r1.close()     // Catch:{ IOException -> 0x0491 }
            goto L_0x04ae
        L_0x0491:
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ Exception -> 0x052d }
            r2 = 3
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x052d }
            int r2 = r9.f37006e     // Catch:{ Exception -> 0x052d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x052d }
            r4 = 0
            r3[r4] = r2     // Catch:{ Exception -> 0x052d }
            java.lang.String r2 = r9.f37004c     // Catch:{ Exception -> 0x052d }
            r4 = 1
            r3[r4] = r2     // Catch:{ Exception -> 0x052d }
            java.lang.String r2 = r9.k     // Catch:{ Exception -> 0x052d }
            r4 = 2
            r3[r4] = r2     // Catch:{ Exception -> 0x052d }
            java.lang.String r2 = "Could not close file for chunk %s of slice %s of pack %s."
            r1.e(r2, r3)     // Catch:{ Exception -> 0x052d }
        L_0x04ae:
            int r1 = r9.f37009h     // Catch:{ Exception -> 0x052d }
            r2 = 3
            if (r1 != r2) goto L_0x04d6
            com.google.android.play.core.b.bh<com.google.android.play.core.assetpacks.x> r1 = r7.f37015e     // Catch:{ Exception -> 0x052d }
            java.lang.Object r1 = r1.a()     // Catch:{ Exception -> 0x052d }
            com.google.android.play.core.assetpacks.x r1 = (com.google.android.play.core.assetpacks.x) r1     // Catch:{ Exception -> 0x052d }
            java.lang.String r2 = r9.k     // Catch:{ Exception -> 0x052d }
            long r3 = r9.f37008g     // Catch:{ Exception -> 0x052d }
            r21 = 3
            r22 = 0
            com.google.android.play.core.assetpacks.ba r5 = r7.f37016f     // Catch:{ Exception -> 0x052d }
            double r27 = r5.a(r2, r9)     // Catch:{ Exception -> 0x052d }
            r20 = r2
            r23 = r3
            r25 = r3
            com.google.android.play.core.assetpacks.c r2 = com.google.android.play.core.assetpacks.c.a(r20, r21, r22, r23, r25, r27)     // Catch:{ Exception -> 0x052d }
            r1.a(r2)     // Catch:{ Exception -> 0x052d }
        L_0x04d6:
            r2 = r19
            goto L_0x0810
        L_0x04da:
            r0 = move-exception
            r19 = r2
            r8 = r14
        L_0x04de:
            r1 = r0
        L_0x04df:
            r8.close()     // Catch:{ all -> 0x04e3 }
            goto L_0x04e8
        L_0x04e3:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.b.bg.a(r1, r2)     // Catch:{ IOException -> 0x04e9 }
        L_0x04e8:
            throw r1     // Catch:{ IOException -> 0x04e9 }
        L_0x04e9:
            r0 = move-exception
            goto L_0x04ee
        L_0x04eb:
            r0 = move-exception
            r19 = r2
        L_0x04ee:
            r1 = r0
            com.google.android.play.core.b.b r2 = com.google.android.play.core.assetpacks.av.f37011a     // Catch:{ Exception -> 0x052d }
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ Exception -> 0x052d }
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x052d }
            java.lang.String r3 = "IOException during extraction %s."
            r2.b(r3, r4)     // Catch:{ Exception -> 0x052d }
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x052d }
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x052d }
            int r4 = r9.f37006e     // Catch:{ Exception -> 0x052d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x052d }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x052d }
            java.lang.String r4 = r9.f37004c     // Catch:{ Exception -> 0x052d }
            r5 = 1
            r3[r5] = r4     // Catch:{ Exception -> 0x052d }
            java.lang.String r4 = r9.k     // Catch:{ Exception -> 0x052d }
            r5 = 2
            r3[r5] = r4     // Catch:{ Exception -> 0x052d }
            int r4 = r9.j     // Catch:{ Exception -> 0x052d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x052d }
            r5 = 3
            r3[r5] = r4     // Catch:{ Exception -> 0x052d }
            java.lang.String r4 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ Exception -> 0x052d }
            int r4 = r9.j     // Catch:{ Exception -> 0x052d }
            r2.<init>(r3, r1, r4)     // Catch:{ Exception -> 0x052d }
            throw r2     // Catch:{ Exception -> 0x052d }
        L_0x052d:
            r0 = move-exception
            r2 = r0
            r1 = r19
            goto L_0x07ec
        L_0x0533:
            r0 = move-exception
            r1 = r2
            goto L_0x07eb
        L_0x0537:
            r19 = r2
            boolean r1 = r6 instanceof com.google.android.play.core.assetpacks.cp     // Catch:{ Exception -> 0x07e8 }
            if (r1 == 0) goto L_0x0643
            r1 = r19
            com.google.android.play.core.assetpacks.cq r2 = r1.f37024c     // Catch:{ Exception -> 0x07e6 }
            r3 = r6
            com.google.android.play.core.assetpacks.cp r3 = (com.google.android.play.core.assetpacks.cp) r3     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r7 = r2.f37162b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r9 = r3.f37157a     // Catch:{ Exception -> 0x07e6 }
            long r10 = r3.f37158b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r12 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            java.io.File r4 = r7.a(r8, r9, r10, r12)     // Catch:{ Exception -> 0x07e6 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r5 == 0) goto L_0x062d
            com.google.android.play.core.assetpacks.ad r7 = r2.f37162b     // Catch:{ IOException -> 0x0615 }
            java.lang.String r8 = r3.k     // Catch:{ IOException -> 0x0615 }
            int r9 = r3.f37157a     // Catch:{ IOException -> 0x0615 }
            long r10 = r3.f37158b     // Catch:{ IOException -> 0x0615 }
            java.lang.String r12 = r3.f37159c     // Catch:{ IOException -> 0x0615 }
            java.io.File r5 = r7.f(r8, r9, r10, r12)     // Catch:{ IOException -> 0x0615 }
            boolean r7 = r5.exists()     // Catch:{ IOException -> 0x0615 }
            if (r7 == 0) goto L_0x05ff
            java.util.List r5 = com.google.android.play.core.assetpacks.co.a(r4, r5)     // Catch:{ IOException -> 0x0615 }
            java.lang.String r5 = com.google.android.play.core.assetpacks.by.a((java.util.List<java.io.File>) r5)     // Catch:{ NoSuchAlgorithmException -> 0x05f3, IOException -> 0x05db }
            java.lang.String r7 = r3.f37160d     // Catch:{ Exception -> 0x07e6 }
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x07e6 }
            if (r5 == 0) goto L_0x05c5
            com.google.android.play.core.b.b r5 = com.google.android.play.core.assetpacks.cq.f37161a     // Catch:{ Exception -> 0x07e6 }
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r9 = 0
            r7[r9] = r8     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = r3.k     // Catch:{ Exception -> 0x07e6 }
            r9 = 1
            r7[r9] = r8     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = "Verification of slice %s of pack %s successful."
            r5.d(r8, r7)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r9 = r2.f37162b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r10 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r11 = r3.f37157a     // Catch:{ Exception -> 0x07e6 }
            long r12 = r3.f37158b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r14 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            java.io.File r2 = r9.b(r10, r11, r12, r14)     // Catch:{ Exception -> 0x07e6 }
            boolean r5 = r2.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r5 != 0) goto L_0x05a7
            r2.mkdirs()     // Catch:{ Exception -> 0x07e6 }
        L_0x05a7:
            boolean r2 = r4.renameTo(r2)     // Catch:{ Exception -> 0x07e6 }
            if (r2 == 0) goto L_0x05af
            goto L_0x080f
        L_0x05af:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r7 = 0
            r5[r7] = r4     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Failed to move slice %s after verification."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x05c5:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r7 = 0
            r5[r7] = r4     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Verification failed for slice %s."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x05db:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.assetpacks.ax r4 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r8 = 0
            r7[r8] = r5     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = "Could not digest file during verification for slice %s."
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r4.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x07e6 }
            throw r4     // Catch:{ Exception -> 0x07e6 }
        L_0x05f3:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.assetpacks.ax r4 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = "SHA256 algorithm not supported."
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r4.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x07e6 }
            throw r4     // Catch:{ Exception -> 0x07e6 }
        L_0x05ff:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ IOException -> 0x0615 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0615 }
            java.lang.String r4 = r3.f37159c     // Catch:{ IOException -> 0x0615 }
            r7 = 0
            r5[r7] = r4     // Catch:{ IOException -> 0x0615 }
            java.lang.String r4 = "Cannot find metadata files for slice %s."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x0615 }
            int r5 = r3.j     // Catch:{ IOException -> 0x0615 }
            r2.<init>((java.lang.String) r4, (int) r5)     // Catch:{ IOException -> 0x0615 }
            throw r2     // Catch:{ IOException -> 0x0615 }
        L_0x0615:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.assetpacks.ax r4 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r8 = 0
            r7[r8] = r5     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = "Could not reconstruct slice archive during verification for slice %s."
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r4.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x07e6 }
            throw r4     // Catch:{ Exception -> 0x07e6 }
        L_0x062d:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = r3.f37159c     // Catch:{ Exception -> 0x07e6 }
            r7 = 0
            r5[r7] = r4     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Cannot find unverified files for slice %s."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x0643:
            r1 = r19
            boolean r2 = r6 instanceof com.google.android.play.core.assetpacks.bz     // Catch:{ Exception -> 0x07e6 }
            if (r2 == 0) goto L_0x06ed
            com.google.android.play.core.assetpacks.ca r2 = r1.f37025d     // Catch:{ Exception -> 0x07e6 }
            r3 = r6
            com.google.android.play.core.assetpacks.bz r3 = (com.google.android.play.core.assetpacks.bz) r3     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r7 = r2.f37115b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r9 = r3.f37111a     // Catch:{ Exception -> 0x07e6 }
            long r10 = r3.f37112b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r12 = r3.f37113c     // Catch:{ Exception -> 0x07e6 }
            java.io.File r4 = r7.b(r8, r9, r10, r12)     // Catch:{ Exception -> 0x07e6 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r5 == 0) goto L_0x06d7
            com.google.android.play.core.assetpacks.ad r5 = r2.f37115b     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r7 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r8 = r3.f37111a     // Catch:{ Exception -> 0x07e6 }
            long r9 = r3.f37112b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r5 = r5.c(r7, r8, r9)     // Catch:{ Exception -> 0x07e6 }
            boolean r7 = r5.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r7 != 0) goto L_0x0677
            r5.mkdirs()     // Catch:{ Exception -> 0x07e6 }
        L_0x0677:
            com.google.android.play.core.assetpacks.ca.a(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r4 = r2.f37115b     // Catch:{ IOException -> 0x06ba }
            java.lang.String r5 = r3.k     // Catch:{ IOException -> 0x06ba }
            int r7 = r3.f37111a     // Catch:{ IOException -> 0x06ba }
            long r8 = r3.f37112b     // Catch:{ IOException -> 0x06ba }
            int r4 = r4.e(r5, r7, r8)     // Catch:{ IOException -> 0x06ba }
            com.google.android.play.core.assetpacks.ad r2 = r2.f37115b     // Catch:{ IOException -> 0x06ba }
            java.lang.String r5 = r3.k     // Catch:{ IOException -> 0x06ba }
            int r7 = r3.f37111a     // Catch:{ IOException -> 0x06ba }
            long r8 = r3.f37112b     // Catch:{ IOException -> 0x06ba }
            r10 = 1
            int r4 = r4 + r10
            java.io.File r2 = r2.d(r5, r7, r8)     // Catch:{ IOException -> 0x06ba }
            java.util.Properties r5 = new java.util.Properties     // Catch:{ IOException -> 0x06ba }
            r5.<init>()     // Catch:{ IOException -> 0x06ba }
            java.lang.String r7 = "numberOfMerges"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x06ba }
            r5.put(r7, r4)     // Catch:{ IOException -> 0x06ba }
            java.io.File r4 = r2.getParentFile()     // Catch:{ IOException -> 0x06ba }
            r4.mkdirs()     // Catch:{ IOException -> 0x06ba }
            r2.createNewFile()     // Catch:{ IOException -> 0x06ba }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x06ba }
            r4.<init>(r2)     // Catch:{ IOException -> 0x06ba }
            r2 = 0
            r5.store(r4, r2)     // Catch:{ IOException -> 0x06ba }
            r4.close()     // Catch:{ IOException -> 0x06ba }
            goto L_0x080f
        L_0x06ba:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.b.b r4 = com.google.android.play.core.assetpacks.ca.f37114a     // Catch:{ Exception -> 0x07e6 }
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = r2.getMessage()     // Catch:{ Exception -> 0x07e6 }
            r8 = 0
            r7[r8] = r5     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = "Writing merge checkpoint failed with %s."
            r4.b(r5, r7)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ax r4 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = "Writing merge checkpoint failed."
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r4.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x07e6 }
            throw r4     // Catch:{ Exception -> 0x07e6 }
        L_0x06d7:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = r3.f37113c     // Catch:{ Exception -> 0x07e6 }
            r7 = 0
            r5[r7] = r4     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Cannot find verified files for slice %s."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x06ed:
            boolean r2 = r6 instanceof com.google.android.play.core.assetpacks.cc     // Catch:{ Exception -> 0x07e6 }
            if (r2 == 0) goto L_0x07c3
            com.google.android.play.core.assetpacks.ce r2 = r1.f37026e     // Catch:{ Exception -> 0x07e6 }
            r3 = r6
            com.google.android.play.core.assetpacks.cc r3 = (com.google.android.play.core.assetpacks.cc) r3     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r4 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r7 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r8 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r4 = r4.c(r5, r7, r8)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r5 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r7 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r8 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r9 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r5 = r5.f(r7, r8, r9)     // Catch:{ Exception -> 0x07e6 }
            boolean r7 = r4.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r7 == 0) goto L_0x07ad
            boolean r7 = r5.exists()     // Catch:{ Exception -> 0x07e6 }
            if (r7 == 0) goto L_0x07ad
            com.google.android.play.core.assetpacks.ad r7 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r8 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r9 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r10 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r7 = r7.a(r8, r9, r10)     // Catch:{ Exception -> 0x07e6 }
            r7.mkdirs()     // Catch:{ Exception -> 0x07e6 }
            boolean r4 = r4.renameTo(r7)     // Catch:{ Exception -> 0x07e6 }
            if (r4 == 0) goto L_0x07a3
            com.google.android.play.core.assetpacks.ad r4 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r7 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r8 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r9 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x07e6 }
            java.io.File r4 = r4.a(r7, r8, r9)     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r7 = "merge.tmp"
            r11.<init>(r4, r7)     // Catch:{ Exception -> 0x07e6 }
            r11.delete()     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r4 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r7 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r8 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r9 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            java.io.File r4 = r4.b(r7, r8, r9)     // Catch:{ Exception -> 0x07e6 }
            r4.mkdirs()     // Catch:{ Exception -> 0x07e6 }
            boolean r4 = r5.renameTo(r4)     // Catch:{ Exception -> 0x07e6 }
            if (r4 == 0) goto L_0x0799
            com.google.android.play.core.b.bh<java.util.concurrent.Executor> r4 = r2.f37123d     // Catch:{ Exception -> 0x07e6 }
            java.lang.Object r4 = r4.a()     // Catch:{ Exception -> 0x07e6 }
            java.util.concurrent.Executor r4 = (java.util.concurrent.Executor) r4     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ad r5 = r2.f37120a     // Catch:{ Exception -> 0x07e6 }
            r5.getClass()     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.cd r7 = new com.google.android.play.core.assetpacks.cd     // Catch:{ Exception -> 0x07e6 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x07e6 }
            r4.execute(r7)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.bo r4 = r2.f37122c     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r10 = r3.k     // Catch:{ Exception -> 0x07e6 }
            int r11 = r3.f37117a     // Catch:{ Exception -> 0x07e6 }
            long r12 = r3.f37118b     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.bf r5 = new com.google.android.play.core.assetpacks.bf     // Catch:{ Exception -> 0x07e6 }
            r8 = r5
            r9 = r4
            r8.<init>(r9, r10, r11, r12)     // Catch:{ Exception -> 0x07e6 }
            r4.a(r5)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.ba r4 = r2.f37124e     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r5 = r3.k     // Catch:{ Exception -> 0x07e6 }
            r4.a(r5)     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.b.bh<com.google.android.play.core.assetpacks.dk> r2 = r2.f37121b     // Catch:{ Exception -> 0x07e6 }
            java.lang.Object r2 = r2.a()     // Catch:{ Exception -> 0x07e6 }
            com.google.android.play.core.assetpacks.dk r2 = (com.google.android.play.core.assetpacks.dk) r2     // Catch:{ Exception -> 0x07e6 }
            int r4 = r3.j     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r3 = r3.k     // Catch:{ Exception -> 0x07e6 }
            r2.a(r4, r3)     // Catch:{ Exception -> 0x07e6 }
            goto L_0x080f
        L_0x0799:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Cannot move metadata files to final location."
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x07a3:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Cannot move merged pack files to final location."
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x07ad:
            com.google.android.play.core.assetpacks.ax r2 = new com.google.android.play.core.assetpacks.ax     // Catch:{ Exception -> 0x07e6 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = r3.k     // Catch:{ Exception -> 0x07e6 }
            r7 = 0
            r5[r7] = r4     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r4 = "Cannot find pack files to move for pack %s."
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x07e6 }
            int r3 = r3.j     // Catch:{ Exception -> 0x07e6 }
            r2.<init>((java.lang.String) r4, (int) r3)     // Catch:{ Exception -> 0x07e6 }
            throw r2     // Catch:{ Exception -> 0x07e6 }
        L_0x07c3:
            boolean r2 = r6 instanceof com.google.android.play.core.assetpacks.ci     // Catch:{ Exception -> 0x07e6 }
            if (r2 != 0) goto L_0x07dd
            com.google.android.play.core.b.b r2 = com.google.android.play.core.assetpacks.ay.f37022a     // Catch:{ Exception -> 0x07e6 }
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x07e6 }
            java.lang.Class r3 = r6.getClass()     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x07e6 }
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x07e6 }
            java.lang.String r3 = "Unknown task type: %s"
            r2.b(r3, r4)     // Catch:{ Exception -> 0x07e6 }
            goto L_0x080f
        L_0x07dd:
            com.google.android.play.core.assetpacks.cj r2 = r1.f37027f     // Catch:{ Exception -> 0x07e6 }
            r3 = r6
            com.google.android.play.core.assetpacks.ci r3 = (com.google.android.play.core.assetpacks.ci) r3     // Catch:{ Exception -> 0x07e6 }
            r2.a(r3)     // Catch:{ Exception -> 0x07e6 }
            goto L_0x080f
        L_0x07e6:
            r0 = move-exception
            goto L_0x07eb
        L_0x07e8:
            r0 = move-exception
            r1 = r19
        L_0x07eb:
            r2 = r0
        L_0x07ec:
            com.google.android.play.core.b.b r3 = com.google.android.play.core.assetpacks.ay.f37022a
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r7 = r2.getMessage()
            r8 = 0
            r5[r8] = r7
            java.lang.String r7 = "Error during extraction task: %s"
            r3.b(r7, r5)
            com.google.android.play.core.b.bh<com.google.android.play.core.assetpacks.dk> r3 = r1.f37028g
            java.lang.Object r3 = r3.a()
            com.google.android.play.core.assetpacks.dk r3 = (com.google.android.play.core.assetpacks.dk) r3
            int r5 = r6.j
            r3.a((int) r5)
            int r3 = r6.j
            r1.a(r3, r2)
        L_0x080f:
            r2 = r1
        L_0x0810:
            r4 = 0
            r5 = 1
            r1 = r31
            goto L_0x002e
        L_0x0816:
            r1 = r2
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.f37030i
            r2 = 0
            r1.set(r2)
            return
        L_0x081e:
            r2 = 0
            com.google.android.play.core.b.b r1 = com.google.android.play.core.assetpacks.ay.f37022a
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "runLoop already looping; return"
            r1.e(r3, r2)
        L_0x0828:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.w.run():void");
    }
}

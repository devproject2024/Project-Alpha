package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.d.c;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.video.a.b;
import java.util.ArrayList;

public class h implements ae {

    /* renamed from: a  reason: collision with root package name */
    protected int f32595a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f32596b;

    /* renamed from: c  reason: collision with root package name */
    private e<i> f32597c;

    /* renamed from: d  reason: collision with root package name */
    private long f32598d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32599e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32600f;

    /* renamed from: g  reason: collision with root package name */
    private c f32601g = c.f31338a;

    public h(Context context) {
        this.f32596b = context;
    }

    public final ab[] a(Handler handler, com.google.android.exoplayer2.video.h hVar, com.google.android.exoplayer2.b.h hVar2, k kVar, d dVar, e<i> eVar) {
        e<i> eVar2 = eVar == null ? this.f32597c : eVar;
        ArrayList arrayList = new ArrayList();
        e<i> eVar3 = eVar2;
        a(this.f32596b, this.f32595a, this.f32601g, eVar3, this.f32599e, this.f32600f, handler, hVar, this.f32598d, (ArrayList<ab>) arrayList);
        a(this.f32596b, this.f32595a, this.f32601g, eVar3, this.f32599e, this.f32600f, new g[0], handler, hVar2, (ArrayList<ab>) arrayList);
        arrayList.add(new l(kVar, handler.getLooper()));
        arrayList.add(new com.google.android.exoplayer2.metadata.e(dVar, handler.getLooper()));
        arrayList.add(new b());
        return (ab[]) arrayList.toArray(new ab[0]);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, int i2, c cVar, e<i> eVar, boolean z, boolean z2, Handler handler, com.google.android.exoplayer2.video.h hVar, long j, ArrayList<ab> arrayList) {
        int i3 = i2;
        ArrayList<ab> arrayList2 = arrayList;
        arrayList2.add(new com.google.android.exoplayer2.video.d(context, cVar, j, eVar, z, z2, handler, hVar));
        if (i3 != 0) {
            int size = arrayList.size();
            if (i3 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (ab) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Long.TYPE, Handler.class, com.google.android.exoplayer2.video.h.class, Integer.TYPE}).newInstance(new Object[]{Long.valueOf(j), handler, hVar, 50}));
                com.google.android.exoplayer2.g.l.b();
            } catch (ClassNotFoundException unused) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating VP9 extension", e2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b A[ExcHandler: Exception (r0v5 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r14, int r15, com.google.android.exoplayer2.d.c r16, com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> r17, boolean r18, boolean r19, com.google.android.exoplayer2.b.g[] r20, android.os.Handler r21, com.google.android.exoplayer2.b.h r22, java.util.ArrayList<com.google.android.exoplayer2.ab> r23) {
        /*
            r13 = this;
            r0 = r15
            r1 = r20
            r11 = r23
            com.google.android.exoplayer2.b.r r12 = new com.google.android.exoplayer2.b.r
            com.google.android.exoplayer2.b.o r10 = new com.google.android.exoplayer2.b.o
            com.google.android.exoplayer2.b.d r2 = com.google.android.exoplayer2.b.d.a(r14)
            r10.<init>((com.google.android.exoplayer2.b.d) r2, (com.google.android.exoplayer2.b.g[]) r1)
            r2 = r12
            r3 = r14
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r21
            r9 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r11.add(r12)
            if (r0 != 0) goto L_0x0027
            return
        L_0x0027:
            int r2 = r23.size()
            r3 = 2
            if (r0 != r3) goto L_0x0030
            int r2 = r2 + -1
        L_0x0030:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Class<com.google.android.exoplayer2.b.h> r8 = com.google.android.exoplayer2.b.h.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Class<com.google.android.exoplayer2.b.g[]> r8 = com.google.android.exoplayer2.b.g[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            r7[r0] = r21     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            r7[r5] = r22     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            r7[r3] = r1     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            com.google.android.exoplayer2.ab r6 = (com.google.android.exoplayer2.ab) r6     // Catch:{ ClassNotFoundException -> 0x006b, Exception -> 0x0062 }
            int r7 = r2 + 1
            r11.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0062 }
            com.google.android.exoplayer2.g.l.b()     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0062 }
            goto L_0x006c
        L_0x0062:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x006b:
            r7 = r2
        L_0x006c:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Class<com.google.android.exoplayer2.b.h> r8 = com.google.android.exoplayer2.b.h.class
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Class<com.google.android.exoplayer2.b.g[]> r8 = com.google.android.exoplayer2.b.g[].class
            r6[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            r6[r0] = r21     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            r6[r5] = r22     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            r6[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            com.google.android.exoplayer2.ab r2 = (com.google.android.exoplayer2.ab) r2     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x009b }
            int r6 = r7 + 1
            r11.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009b }
            com.google.android.exoplayer2.g.l.b()     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009b }
            goto L_0x00a5
        L_0x009b:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00a4:
            r6 = r7
        L_0x00a5:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Class<com.google.android.exoplayer2.b.h> r8 = com.google.android.exoplayer2.b.h.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Class<com.google.android.exoplayer2.b.g[]> r8 = com.google.android.exoplayer2.b.g[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            r4[r0] = r21     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            r4[r5] = r22     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            r4[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            com.google.android.exoplayer2.ab r0 = (com.google.android.exoplayer2.ab) r0     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            r11.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            com.google.android.exoplayer2.g.l.b()     // Catch:{ ClassNotFoundException -> 0x00db, Exception -> 0x00d2 }
            return
        L_0x00d2:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.a(android.content.Context, int, com.google.android.exoplayer2.d.c, com.google.android.exoplayer2.drm.e, boolean, boolean, com.google.android.exoplayer2.b.g[], android.os.Handler, com.google.android.exoplayer2.b.h, java.util.ArrayList):void");
    }
}

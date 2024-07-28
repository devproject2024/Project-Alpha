package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.hls.a.d;
import com.google.android.exoplayer2.source.hls.a.i;
import com.google.android.exoplayer2.source.hls.k;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class i implements i.b, k.a, n {

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.exoplayer2.source.hls.a.i f33172a;

    /* renamed from: b  reason: collision with root package name */
    final p.a f33173b;

    /* renamed from: c  reason: collision with root package name */
    n.a f33174c;

    /* renamed from: d  reason: collision with root package name */
    k[] f33175d = new k[0];

    /* renamed from: e  reason: collision with root package name */
    private final f f33176e;

    /* renamed from: f  reason: collision with root package name */
    private final e f33177f;

    /* renamed from: g  reason: collision with root package name */
    private final ad f33178g;

    /* renamed from: h  reason: collision with root package name */
    private final w f33179h;

    /* renamed from: i  reason: collision with root package name */
    private final b f33180i;
    private final IdentityHashMap<u, Integer> j = new IdentityHashMap<>();
    private final m k = new m();
    private final g l;
    private final boolean m;
    private final boolean n;
    private int o;
    private TrackGroupArray p;
    private k[] q = new k[0];
    private int[][] r = new int[0][];
    private v s;
    private boolean t;

    public final long a(long j2, af afVar) {
        return j2;
    }

    public i(f fVar, com.google.android.exoplayer2.source.hls.a.i iVar, e eVar, ad adVar, w wVar, p.a aVar, b bVar, g gVar, boolean z, boolean z2) {
        this.f33176e = fVar;
        this.f33172a = iVar;
        this.f33177f = eVar;
        this.f33178g = adVar;
        this.f33179h = wVar;
        this.f33173b = aVar;
        this.f33180i = bVar;
        this.l = gVar;
        this.m = z;
        this.n = z2;
        this.s = gVar.a(new v[0]);
        aVar.a();
    }

    public final void a(n.a aVar, long j2) {
        HashMap hashMap;
        this.f33174c = aVar;
        this.f33172a.a((i.b) this);
        d dVar = (d) a.a(this.f33172a.b());
        if (this.n) {
            List<DrmInitData> list = dVar.k;
            ArrayList arrayList = new ArrayList(list);
            HashMap hashMap2 = new HashMap();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData = list.get(i2);
                String str = drmInitData.f31354b;
                i2++;
                DrmInitData drmInitData2 = drmInitData;
                int i3 = i2;
                while (i3 < arrayList.size()) {
                    DrmInitData drmInitData3 = (DrmInitData) arrayList.get(i3);
                    if (TextUtils.equals(drmInitData3.f31354b, str)) {
                        a.b(drmInitData2.f31354b == null || drmInitData3.f31354b == null || TextUtils.equals(drmInitData2.f31354b, drmInitData3.f31354b));
                        DrmInitData drmInitData4 = new DrmInitData(drmInitData2.f31354b != null ? drmInitData2.f31354b : drmInitData3.f31354b, (DrmInitData.SchemeData[]) ae.a((T[]) drmInitData2.f31353a, (T[]) drmInitData3.f31353a));
                        arrayList.remove(i3);
                        drmInitData2 = drmInitData4;
                    } else {
                        i3++;
                    }
                }
                hashMap2.put(str, drmInitData2);
            }
            hashMap = hashMap2;
        } else {
            hashMap = Collections.emptyMap();
        }
        boolean z = !dVar.f33096c.isEmpty();
        List<d.a> list2 = dVar.f33098e;
        List<d.a> list3 = dVar.f33099f;
        this.o = 0;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (z) {
            a(dVar, j2, (List<k>) arrayList2, (List<int[]>) arrayList3, (Map<String, DrmInitData>) hashMap);
        }
        a(j2, list2, (List<k>) arrayList2, (List<int[]>) arrayList3, (Map<String, DrmInitData>) hashMap);
        int i4 = 0;
        while (i4 < list3.size()) {
            d.a aVar2 = list3.get(i4);
            int i5 = i4;
            k a2 = a(3, new Uri[]{aVar2.f33103a}, new Format[]{aVar2.f33104b}, (Format) null, Collections.emptyList(), hashMap, j2);
            arrayList3.add(new int[]{i5});
            arrayList2.add(a2);
            a2.a(new TrackGroupArray(new TrackGroup(aVar2.f33104b)), TrackGroupArray.f32783a);
            i4 = i5 + 1;
        }
        this.f33175d = (k[]) arrayList2.toArray(new k[0]);
        this.r = (int[][]) arrayList3.toArray(new int[0][]);
        k[] kVarArr = this.f33175d;
        this.o = kVarArr.length;
        kVarArr[0].a(true);
        for (k b2 : this.f33175d) {
            b2.b();
        }
        this.q = this.f33175d;
    }

    public final void i_() throws IOException {
        for (k kVar : this.f33175d) {
            kVar.f33185b.a();
        }
    }

    public final TrackGroupArray b() {
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0275, code lost:
        if (r7 != r10[0]) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        if (r3 != r7.v) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.google.android.exoplayer2.trackselection.f[] r29, boolean[] r30, com.google.android.exoplayer2.source.u[] r31, boolean[] r32, long r33) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r31
            r3 = r33
            int r5 = r1.length
            int[] r5 = new int[r5]
            int r6 = r1.length
            int[] r6 = new int[r6]
            r8 = 0
        L_0x000f:
            int r9 = r1.length
            r10 = -1
            if (r8 >= r9) goto L_0x004e
            r9 = r2[r8]
            if (r9 != 0) goto L_0x0019
            r9 = -1
            goto L_0x0027
        L_0x0019:
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.u, java.lang.Integer> r9 = r0.j
            r11 = r2[r8]
            java.lang.Object r9 = r9.get(r11)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
        L_0x0027:
            r5[r8] = r9
            r6[r8] = r10
            r9 = r1[r8]
            if (r9 == 0) goto L_0x004b
            r9 = r1[r8]
            com.google.android.exoplayer2.source.TrackGroup r9 = r9.e()
            r11 = 0
        L_0x0036:
            com.google.android.exoplayer2.source.hls.k[] r12 = r0.f33175d
            int r13 = r12.length
            if (r11 >= r13) goto L_0x004b
            r12 = r12[r11]
            com.google.android.exoplayer2.source.TrackGroupArray r12 = r12.r
            int r12 = r12.a(r9)
            if (r12 == r10) goto L_0x0048
            r6[r8] = r11
            goto L_0x004b
        L_0x0048:
            int r11 = r11 + 1
            goto L_0x0036
        L_0x004b:
            int r8 = r8 + 1
            goto L_0x000f
        L_0x004e:
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.u, java.lang.Integer> r8 = r0.j
            r8.clear()
            int r8 = r1.length
            com.google.android.exoplayer2.source.u[] r8 = new com.google.android.exoplayer2.source.u[r8]
            int r9 = r1.length
            com.google.android.exoplayer2.source.u[] r9 = new com.google.android.exoplayer2.source.u[r9]
            int r11 = r1.length
            com.google.android.exoplayer2.trackselection.f[] r11 = new com.google.android.exoplayer2.trackselection.f[r11]
            com.google.android.exoplayer2.source.hls.k[] r12 = r0.f33175d
            int r12 = r12.length
            com.google.android.exoplayer2.source.hls.k[] r12 = new com.google.android.exoplayer2.source.hls.k[r12]
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0064:
            com.google.android.exoplayer2.source.hls.k[] r7 = r0.f33175d
            int r7 = r7.length
            if (r13 >= r7) goto L_0x029f
            r7 = 0
        L_0x006a:
            int r10 = r1.length
            r16 = r12
            if (r7 >= r10) goto L_0x0088
            r10 = r5[r7]
            if (r10 != r13) goto L_0x0076
            r10 = r2[r7]
            goto L_0x0077
        L_0x0076:
            r10 = 0
        L_0x0077:
            r9[r7] = r10
            r10 = r6[r7]
            if (r10 != r13) goto L_0x0080
            r12 = r1[r7]
            goto L_0x0081
        L_0x0080:
            r12 = 0
        L_0x0081:
            r11[r7] = r12
            int r7 = r7 + 1
            r12 = r16
            goto L_0x006a
        L_0x0088:
            com.google.android.exoplayer2.source.hls.k[] r7 = r0.f33175d
            r7 = r7[r13]
            boolean r10 = r7.m
            com.google.android.exoplayer2.g.a.b(r10)
            int r10 = r7.n
            r12 = 0
        L_0x0094:
            int r2 = r11.length
            r17 = r14
            r14 = 1
            if (r12 >= r2) goto L_0x00dc
            r2 = r9[r12]
            if (r2 == 0) goto L_0x00d1
            r2 = r11[r12]
            if (r2 == 0) goto L_0x00a6
            boolean r2 = r30[r12]
            if (r2 != 0) goto L_0x00d1
        L_0x00a6:
            int r2 = r7.n
            int r2 = r2 - r14
            r7.n = r2
            r2 = r9[r12]
            com.google.android.exoplayer2.source.hls.j r2 = (com.google.android.exoplayer2.source.hls.j) r2
            int r14 = r2.f33183c
            r18 = r5
            r5 = -1
            if (r14 == r5) goto L_0x00cd
            com.google.android.exoplayer2.source.hls.k r14 = r2.f33182b
            int r5 = r2.f33181a
            int[] r0 = r14.s
            r0 = r0[r5]
            boolean[] r5 = r14.u
            boolean r5 = r5[r0]
            com.google.android.exoplayer2.g.a.b(r5)
            boolean[] r5 = r14.u
            r14 = 0
            r5[r0] = r14
            r0 = -1
            r2.f33183c = r0
        L_0x00cd:
            r0 = 0
            r9[r12] = r0
            goto L_0x00d3
        L_0x00d1:
            r18 = r5
        L_0x00d3:
            int r12 = r12 + 1
            r0 = r28
            r14 = r17
            r5 = r18
            goto L_0x0094
        L_0x00dc:
            r18 = r5
            if (r15 != 0) goto L_0x00f3
            boolean r0 = r7.x
            if (r0 == 0) goto L_0x00e9
            if (r10 != 0) goto L_0x00e7
            goto L_0x00f3
        L_0x00e7:
            r0 = r15
            goto L_0x00f1
        L_0x00e9:
            r0 = r15
            long r14 = r7.v
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00f1
            goto L_0x00f4
        L_0x00f1:
            r5 = 0
            goto L_0x00f5
        L_0x00f3:
            r0 = r15
        L_0x00f4:
            r5 = 1
        L_0x00f5:
            com.google.android.exoplayer2.source.hls.d r10 = r7.f33185b
            com.google.android.exoplayer2.trackselection.f r10 = r10.f33153h
            r14 = r5
            r12 = r10
            r5 = 0
        L_0x00fc:
            int r15 = r11.length
            if (r5 >= r15) goto L_0x0163
            r15 = r11[r5]
            if (r15 == 0) goto L_0x015b
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r7.r
            r26 = r0
            com.google.android.exoplayer2.source.TrackGroup r0 = r15.e()
            int r0 = r2.a(r0)
            int r2 = r7.t
            if (r0 != r2) goto L_0x0118
            com.google.android.exoplayer2.source.hls.d r2 = r7.f33185b
            r2.f33153h = r15
            r12 = r15
        L_0x0118:
            r2 = r9[r5]
            if (r2 != 0) goto L_0x015d
            int r2 = r7.n
            r15 = 1
            int r2 = r2 + r15
            r7.n = r2
            com.google.android.exoplayer2.source.hls.j r2 = new com.google.android.exoplayer2.source.hls.j
            r2.<init>(r7, r0)
            r9[r5] = r2
            r32[r5] = r15
            int[] r15 = r7.s
            if (r15 == 0) goto L_0x0136
            r15 = r9[r5]
            com.google.android.exoplayer2.source.hls.j r15 = (com.google.android.exoplayer2.source.hls.j) r15
            r15.c()
        L_0x0136:
            boolean r15 = r7.l
            if (r15 == 0) goto L_0x015d
            if (r14 != 0) goto L_0x015d
            com.google.android.exoplayer2.source.t[] r14 = r7.j
            int[] r15 = r7.s
            r0 = r15[r0]
            r0 = r14[r0]
            r0.b()
            r2 = 1
            int r14 = r0.a((long) r3, (boolean) r2)
            r15 = -1
            if (r14 != r15) goto L_0x0159
            com.google.android.exoplayer2.source.s r0 = r0.f33388a
            int r0 = r0.b()
            if (r0 == 0) goto L_0x0159
            r14 = 1
            goto L_0x015e
        L_0x0159:
            r14 = 0
            goto L_0x015e
        L_0x015b:
            r26 = r0
        L_0x015d:
            r15 = -1
        L_0x015e:
            int r5 = r5 + 1
            r0 = r26
            goto L_0x00fc
        L_0x0163:
            r26 = r0
            r15 = -1
            int r0 = r7.n
            if (r0 != 0) goto L_0x019f
            com.google.android.exoplayer2.source.hls.d r0 = r7.f33185b
            r5 = 0
            r0.f33151f = r5
            r7.p = r5
            r0 = 1
            r7.w = r0
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.h> r0 = r7.f33188e
            r0.clear()
            com.google.android.exoplayer2.f.x r0 = r7.f33186c
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0199
            boolean r0 = r7.l
            if (r0 == 0) goto L_0x0193
            com.google.android.exoplayer2.source.t[] r0 = r7.j
            int r5 = r0.length
            r10 = 0
        L_0x0189:
            if (r10 >= r5) goto L_0x0193
            r12 = r0[r10]
            r12.c()
            int r10 = r10 + 1
            goto L_0x0189
        L_0x0193:
            com.google.android.exoplayer2.f.x r0 = r7.f33186c
            r0.d()
            goto L_0x019c
        L_0x0199:
            r7.c()
        L_0x019c:
            r0 = r11
            goto L_0x020a
        L_0x019f:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.h> r0 = r7.f33188e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x01f4
            boolean r0 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r12, (java.lang.Object) r10)
            if (r0 != 0) goto L_0x01f4
            boolean r0 = r7.x
            if (r0 != 0) goto L_0x01ea
            r19 = 0
            int r0 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x01bc
            r0 = r11
            long r10 = -r3
            r20 = r10
            goto L_0x01bf
        L_0x01bc:
            r0 = r11
            r20 = r19
        L_0x01bf:
            com.google.android.exoplayer2.source.hls.h r5 = r7.f()
            com.google.android.exoplayer2.source.hls.d r10 = r7.f33185b
            com.google.android.exoplayer2.source.b.m[] r25 = r10.a((com.google.android.exoplayer2.source.hls.h) r5, (long) r3)
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.exoplayer2.source.hls.h> r10 = r7.f33189f
            r19 = r12
            r24 = r10
            r19.a(r20, r22, r24, r25)
            com.google.android.exoplayer2.source.hls.d r10 = r7.f33185b
            com.google.android.exoplayer2.source.TrackGroup r10 = r10.f33147b
            com.google.android.exoplayer2.Format r5 = r5.f32816g
            int r5 = r10.a(r5)
            int r10 = r12.h()
            if (r10 == r5) goto L_0x01e8
            goto L_0x01eb
        L_0x01e8:
            r5 = 0
            goto L_0x01ec
        L_0x01ea:
            r0 = r11
        L_0x01eb:
            r5 = 1
        L_0x01ec:
            if (r5 == 0) goto L_0x01f5
            r2 = 1
            r7.w = r2
            r5 = 1
            r14 = 1
            goto L_0x01f7
        L_0x01f4:
            r0 = r11
        L_0x01f5:
            r5 = r26
        L_0x01f7:
            if (r14 == 0) goto L_0x020a
            r7.a((long) r3, (boolean) r5)
            r5 = 0
        L_0x01fd:
            int r10 = r9.length
            if (r5 >= r10) goto L_0x020a
            r10 = r9[r5]
            if (r10 == 0) goto L_0x0207
            r2 = 1
            r32[r5] = r2
        L_0x0207:
            int r5 = r5 + 1
            goto L_0x01fd
        L_0x020a:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.j> r5 = r7.f33191h
            r5.clear()
            int r5 = r9.length
            r10 = 0
        L_0x0211:
            if (r10 >= r5) goto L_0x0221
            r11 = r9[r10]
            if (r11 == 0) goto L_0x021e
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.j> r12 = r7.f33191h
            com.google.android.exoplayer2.source.hls.j r11 = (com.google.android.exoplayer2.source.hls.j) r11
            r12.add(r11)
        L_0x021e:
            int r10 = r10 + 1
            goto L_0x0211
        L_0x0221:
            r2 = 1
            r7.x = r2
            r5 = 0
            r10 = 0
        L_0x0226:
            int r11 = r1.length
            if (r5 >= r11) goto L_0x025d
            r11 = r6[r5]
            if (r11 != r13) goto L_0x024a
            r10 = r9[r5]
            if (r10 == 0) goto L_0x0233
            r10 = 1
            goto L_0x0234
        L_0x0233:
            r10 = 0
        L_0x0234:
            com.google.android.exoplayer2.g.a.b(r10)
            r10 = r9[r5]
            r8[r5] = r10
            r11 = r28
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.u, java.lang.Integer> r10 = r11.j
            r12 = r9[r5]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r10.put(r12, r2)
            r10 = 1
            goto L_0x025a
        L_0x024a:
            r11 = r28
            r2 = r18[r5]
            if (r2 != r13) goto L_0x025a
            r2 = r9[r5]
            if (r2 != 0) goto L_0x0256
            r2 = 1
            goto L_0x0257
        L_0x0256:
            r2 = 0
        L_0x0257:
            com.google.android.exoplayer2.g.a.b(r2)
        L_0x025a:
            int r5 = r5 + 1
            goto L_0x0226
        L_0x025d:
            r11 = r28
            if (r10 == 0) goto L_0x028a
            r16[r17] = r7
            int r2 = r17 + 1
            if (r17 != 0) goto L_0x0284
            r5 = 1
            r7.a((boolean) r5)
            if (r14 != 0) goto L_0x0278
            com.google.android.exoplayer2.source.hls.k[] r10 = r11.q
            int r12 = r10.length
            if (r12 == 0) goto L_0x0278
            r12 = 0
            r10 = r10[r12]
            if (r7 == r10) goto L_0x0288
            goto L_0x0279
        L_0x0278:
            r12 = 0
        L_0x0279:
            com.google.android.exoplayer2.source.hls.m r7 = r11.k
            android.util.SparseArray<com.google.android.exoplayer2.g.ab> r7 = r7.f33193a
            r7.clear()
            r14 = r2
            r26 = 1
            goto L_0x028d
        L_0x0284:
            r12 = 0
            r7.a((boolean) r12)
        L_0x0288:
            r14 = r2
            goto L_0x028d
        L_0x028a:
            r12 = 0
            r14 = r17
        L_0x028d:
            int r13 = r13 + 1
            r2 = r31
            r12 = r16
            r5 = r18
            r15 = r26
            r10 = -1
            r27 = r11
            r11 = r0
            r0 = r27
            goto L_0x0064
        L_0x029f:
            r11 = r0
            r16 = r12
            r17 = r14
            r12 = 0
            int r0 = r8.length
            r1 = r31
            java.lang.System.arraycopy(r8, r12, r1, r12, r0)
            r0 = r16
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r14)
            com.google.android.exoplayer2.source.hls.k[] r0 = (com.google.android.exoplayer2.source.hls.k[]) r0
            r11.q = r0
            com.google.android.exoplayer2.source.g r0 = r11.l
            com.google.android.exoplayer2.source.hls.k[] r1 = r11.q
            com.google.android.exoplayer2.source.v r0 = r0.a(r1)
            r11.s = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.i.a(com.google.android.exoplayer2.trackselection.f[], boolean[], com.google.android.exoplayer2.source.u[], boolean[], long):long");
    }

    public final void a(long j2, boolean z) {
        for (k kVar : this.q) {
            if (kVar.l && !kVar.h()) {
                int length = kVar.j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    kVar.j[i2].a(j2, z, kVar.u[i2]);
                }
            }
        }
    }

    public final void a(long j2) {
        this.s.a(j2);
    }

    public final boolean c(long j2) {
        if (this.p != null) {
            return this.s.c(j2);
        }
        for (k b2 : this.f33175d) {
            b2.b();
        }
        return false;
    }

    public final long e() {
        return this.s.e();
    }

    public final long c() {
        if (this.t) {
            return -9223372036854775807L;
        }
        this.f33173b.c();
        this.t = true;
        return -9223372036854775807L;
    }

    public final long d() {
        return this.s.d();
    }

    public final long b(long j2) {
        k[] kVarArr = this.q;
        if (kVarArr.length > 0) {
            boolean a2 = kVarArr[0].a(j2, false);
            int i2 = 1;
            while (true) {
                k[] kVarArr2 = this.q;
                if (i2 >= kVarArr2.length) {
                    break;
                }
                kVarArr2[i2].a(j2, a2);
                i2++;
            }
            if (a2) {
                this.k.f33193a.clear();
            }
        }
        return j2;
    }

    public final void f() {
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 <= 0) {
            int i3 = 0;
            for (k kVar : this.f33175d) {
                i3 += kVar.r.f32784b;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            k[] kVarArr = this.f33175d;
            int length = kVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                k kVar2 = kVarArr[i4];
                int i6 = kVar2.r.f32784b;
                int i7 = i5;
                int i8 = 0;
                while (i8 < i6) {
                    trackGroupArr[i7] = kVar2.r.f32785c[i8];
                    i8++;
                    i7++;
                }
                i4++;
                i5 = i7;
            }
            this.p = new TrackGroupArray(trackGroupArr);
            this.f33174c.a(this);
        }
    }

    public final void a(Uri uri) {
        this.f33172a.c(uri);
    }

    public final void g() {
        this.f33174c.a(this);
    }

    public final boolean a(Uri uri, long j2) {
        boolean z;
        int c2;
        boolean z2 = true;
        for (k kVar : this.f33175d) {
            d dVar = kVar.f33185b;
            int i2 = 0;
            while (true) {
                if (i2 >= dVar.f33146a.length) {
                    i2 = -1;
                    break;
                } else if (dVar.f33146a[i2].equals(uri)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!(i2 == -1 || (c2 = dVar.f33153h.c(i2)) == -1)) {
                dVar.f33154i |= uri.equals(dVar.f33152g);
                if (j2 != -9223372036854775807L && !dVar.f33153h.a(c2, j2)) {
                    z = false;
                    z2 &= z;
                }
            }
            z = true;
            z2 &= z;
        }
        this.f33174c.a(this);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.source.hls.a.d r27, long r28, java.util.List<com.google.android.exoplayer2.source.hls.k> r30, java.util.List<int[]> r31, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r32) {
        /*
            r26 = this;
            r0 = r27
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$b> r1 = r0.f33096c
            int r1 = r1.size()
            int[] r1 = new int[r1]
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000e:
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$b> r6 = r0.f33096c
            int r6 = r6.size()
            r7 = 2
            r8 = 1
            if (r3 >= r6) goto L_0x0047
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$b> r6 = r0.f33096c
            java.lang.Object r6 = r6.get(r3)
            com.google.android.exoplayer2.source.hls.a.d$b r6 = (com.google.android.exoplayer2.source.hls.a.d.b) r6
            com.google.android.exoplayer2.Format r6 = r6.f33108b
            int r9 = r6.o
            if (r9 > 0) goto L_0x0040
            java.lang.String r9 = r6.f31066f
            java.lang.String r9 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r9, (int) r7)
            if (r9 == 0) goto L_0x002f
            goto L_0x0040
        L_0x002f:
            java.lang.String r6 = r6.f31066f
            java.lang.String r6 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r6, (int) r8)
            if (r6 == 0) goto L_0x003c
            r1[r3] = r8
            int r5 = r5 + 1
            goto L_0x0044
        L_0x003c:
            r6 = -1
            r1[r3] = r6
            goto L_0x0044
        L_0x0040:
            r1[r3] = r7
            int r4 = r4 + 1
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0047:
            int r3 = r1.length
            if (r4 <= 0) goto L_0x004c
            r3 = 1
            goto L_0x0055
        L_0x004c:
            if (r5 >= r3) goto L_0x0053
            int r4 = r3 - r5
            r3 = 0
            r5 = 1
            goto L_0x0056
        L_0x0053:
            r4 = r3
            r3 = 0
        L_0x0055:
            r5 = 0
        L_0x0056:
            android.net.Uri[] r11 = new android.net.Uri[r4]
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r4]
            int[] r15 = new int[r4]
            r9 = 0
            r10 = 0
        L_0x005e:
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$b> r12 = r0.f33096c
            int r12 = r12.size()
            if (r9 >= r12) goto L_0x008a
            if (r3 == 0) goto L_0x006c
            r12 = r1[r9]
            if (r12 != r7) goto L_0x0087
        L_0x006c:
            if (r5 == 0) goto L_0x0072
            r12 = r1[r9]
            if (r12 == r8) goto L_0x0087
        L_0x0072:
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$b> r12 = r0.f33096c
            java.lang.Object r12 = r12.get(r9)
            com.google.android.exoplayer2.source.hls.a.d$b r12 = (com.google.android.exoplayer2.source.hls.a.d.b) r12
            android.net.Uri r13 = r12.f33107a
            r11[r10] = r13
            com.google.android.exoplayer2.Format r12 = r12.f33108b
            r6[r10] = r12
            int r12 = r10 + 1
            r15[r10] = r9
            r10 = r12
        L_0x0087:
            int r9 = r9 + 1
            goto L_0x005e
        L_0x008a:
            r1 = r6[r2]
            java.lang.String r1 = r1.f31066f
            r10 = 0
            com.google.android.exoplayer2.Format r13 = r0.f33101h
            java.util.List<com.google.android.exoplayer2.Format> r14 = r0.f33102i
            r9 = r26
            r12 = r6
            r3 = r15
            r15 = r32
            r16 = r28
            com.google.android.exoplayer2.source.hls.k r5 = r9.a(r10, r11, r12, r13, r14, r15, r16)
            r9 = r30
            r9.add(r5)
            r9 = r31
            r9.add(r3)
            r3 = r26
            boolean r9 = r3.m
            if (r9 == 0) goto L_0x01c7
            if (r1 == 0) goto L_0x01c7
            java.lang.String r9 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r1, (int) r7)
            if (r9 == 0) goto L_0x00b9
            r9 = 1
            goto L_0x00ba
        L_0x00b9:
            r9 = 0
        L_0x00ba:
            java.lang.String r10 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r1, (int) r8)
            if (r10 == 0) goto L_0x00c2
            r10 = 1
            goto L_0x00c3
        L_0x00c2:
            r10 = 0
        L_0x00c3:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            if (r9 == 0) goto L_0x0164
            com.google.android.exoplayer2.Format[] r1 = new com.google.android.exoplayer2.Format[r4]
            r4 = 0
        L_0x00cd:
            int r9 = r1.length
            if (r4 >= r9) goto L_0x0112
            r9 = r6[r4]
            java.lang.String r12 = r9.f31066f
            java.lang.String r17 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r12, (int) r7)
            java.lang.String r16 = com.google.android.exoplayer2.g.o.f(r17)
            java.lang.String r13 = r9.f31061a
            java.lang.String r14 = r9.f31062b
            java.lang.String r15 = r9.f31068h
            com.google.android.exoplayer2.metadata.Metadata r12 = r9.f31067g
            int r7 = r9.f31065e
            int r2 = r9.n
            int r8 = r9.o
            float r3 = r9.p
            r23 = 0
            r28 = r5
            int r5 = r9.f31063c
            int r9 = r9.f31064d
            r18 = r12
            r19 = r7
            r20 = r2
            r21 = r8
            r22 = r3
            r24 = r5
            r25 = r9
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (com.google.android.exoplayer2.metadata.Metadata) r18, (int) r19, (int) r20, (int) r21, (float) r22, (java.util.List<byte[]>) r23, (int) r24, (int) r25)
            r1[r4] = r2
            int r4 = r4 + 1
            r2 = 0
            r8 = 1
            r3 = r26
            r5 = r28
            r7 = 2
            goto L_0x00cd
        L_0x0112:
            r28 = r5
            com.google.android.exoplayer2.source.TrackGroup r2 = new com.google.android.exoplayer2.source.TrackGroup
            r2.<init>((com.google.android.exoplayer2.Format[]) r1)
            r11.add(r2)
            if (r10 == 0) goto L_0x0140
            com.google.android.exoplayer2.Format r1 = r0.f33101h
            if (r1 != 0) goto L_0x012a
            java.util.List<com.google.android.exoplayer2.source.hls.a.d$a> r1 = r0.f33098e
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0140
        L_0x012a:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            r2 = 1
            com.google.android.exoplayer2.Format[] r3 = new com.google.android.exoplayer2.Format[r2]
            r2 = 0
            r4 = r6[r2]
            com.google.android.exoplayer2.Format r5 = r0.f33101h
            com.google.android.exoplayer2.Format r4 = a(r4, r5, r2)
            r3[r2] = r4
            r1.<init>((com.google.android.exoplayer2.Format[]) r3)
            r11.add(r1)
        L_0x0140:
            java.util.List<com.google.android.exoplayer2.Format> r0 = r0.f33102i
            if (r0 == 0) goto L_0x0162
            r1 = 0
        L_0x0145:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0162
            com.google.android.exoplayer2.source.TrackGroup r2 = new com.google.android.exoplayer2.source.TrackGroup
            r3 = 1
            com.google.android.exoplayer2.Format[] r4 = new com.google.android.exoplayer2.Format[r3]
            java.lang.Object r3 = r0.get(r1)
            com.google.android.exoplayer2.Format r3 = (com.google.android.exoplayer2.Format) r3
            r5 = 0
            r4[r5] = r3
            r2.<init>((com.google.android.exoplayer2.Format[]) r4)
            r11.add(r2)
            int r1 = r1 + 1
            goto L_0x0145
        L_0x0162:
            r5 = 1
            goto L_0x0185
        L_0x0164:
            r28 = r5
            if (r10 == 0) goto L_0x01b7
            com.google.android.exoplayer2.Format[] r1 = new com.google.android.exoplayer2.Format[r4]
            r2 = 0
        L_0x016b:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x017c
            r3 = r6[r2]
            com.google.android.exoplayer2.Format r4 = r0.f33101h
            r5 = 1
            com.google.android.exoplayer2.Format r3 = a(r3, r4, r5)
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x016b
        L_0x017c:
            r5 = 1
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            r0.<init>((com.google.android.exoplayer2.Format[]) r1)
            r11.add(r0)
        L_0x0185:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r1 = new com.google.android.exoplayer2.Format[r5]
            java.lang.String r2 = "ID3"
            java.lang.String r3 = "application/id3"
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r2, (java.lang.String) r3)
            r3 = 0
            r1[r3] = r2
            r0.<init>((com.google.android.exoplayer2.Format[]) r1)
            r11.add(r0)
            com.google.android.exoplayer2.source.TrackGroupArray r1 = new com.google.android.exoplayer2.source.TrackGroupArray
            com.google.android.exoplayer2.source.TrackGroup[] r2 = new com.google.android.exoplayer2.source.TrackGroup[r3]
            java.lang.Object[] r2 = r11.toArray(r2)
            com.google.android.exoplayer2.source.TrackGroup[] r2 = (com.google.android.exoplayer2.source.TrackGroup[]) r2
            r1.<init>((com.google.android.exoplayer2.source.TrackGroup[]) r2)
            com.google.android.exoplayer2.source.TrackGroupArray r2 = new com.google.android.exoplayer2.source.TrackGroupArray
            r4 = 1
            com.google.android.exoplayer2.source.TrackGroup[] r4 = new com.google.android.exoplayer2.source.TrackGroup[r4]
            r4[r3] = r0
            r2.<init>((com.google.android.exoplayer2.source.TrackGroup[]) r4)
            r0 = r28
            r0.a((com.google.android.exoplayer2.source.TrackGroupArray) r1, (com.google.android.exoplayer2.source.TrackGroupArray) r2)
            goto L_0x01c7
        L_0x01b7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Unexpected codecs attribute: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.i.a(com.google.android.exoplayer2.source.hls.a.d, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void a(long j2, List<d.a> list, List<k> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<d.a> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list4.get(i2).f33106d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (ae.a((Object) str, (Object) list4.get(i3).f33106d)) {
                        d.a aVar = list4.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(aVar.f33103a);
                        arrayList2.add(aVar.f33104b);
                        z &= aVar.f33104b.f31066f != null;
                    }
                }
                k a2 = a(1, (Uri[]) arrayList.toArray(new Uri[0]), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j2);
                list3.add(ae.a((List<Integer>) arrayList3));
                list2.add(a2);
                if (this.m && z) {
                    a2.a(new TrackGroupArray(new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))), TrackGroupArray.f32783a);
                }
            } else {
                List<k> list5 = list2;
                List<int[]> list6 = list3;
            }
        }
    }

    private k a(int i2, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j2) {
        return new k(i2, this, new d(this.f33176e, this.f33172a, uriArr, formatArr, this.f33177f, this.f33178g, this.k, list), map, this.f33180i, j2, format, this.f33179h, this.f33173b);
    }

    private static Format a(Format format, Format format2, boolean z) {
        String str;
        int i2;
        int i3;
        int i4;
        Metadata metadata;
        String str2;
        String str3;
        Format format3 = format;
        Format format4 = format2;
        if (format4 != null) {
            String str4 = format4.f31066f;
            Metadata metadata2 = format4.f31067g;
            int i5 = format4.v;
            int i6 = format4.f31063c;
            int i7 = format4.f31064d;
            String str5 = format4.A;
            str3 = format4.f31062b;
            str2 = str4;
            metadata = metadata2;
            i4 = i5;
            i3 = i6;
            i2 = i7;
            str = str5;
        } else {
            String a2 = ae.a(format3.f31066f, 1);
            Metadata metadata3 = format3.f31067g;
            if (z) {
                int i8 = format3.v;
                str2 = a2;
                i4 = i8;
                i3 = format3.f31063c;
                metadata = metadata3;
                i2 = format3.f31064d;
                str = format3.A;
                str3 = format3.f31062b;
            } else {
                str2 = a2;
                str3 = null;
                str = null;
                metadata = metadata3;
                i4 = -1;
                i3 = 0;
                i2 = 0;
            }
        }
        return Format.a(format3.f31061a, str3, format3.f31068h, o.f(str2), str2, metadata, z ? format3.f31065e : -1, i4, -1, (List<byte[]>) null, i3, i2, str);
    }

    public final /* bridge */ /* synthetic */ void a(v vVar) {
        this.f33174c.a(this);
    }
}

package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b.g;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.a.d;
import com.google.android.exoplayer2.source.dash.a.e;
import com.google.android.exoplayer2.source.dash.a.f;
import com.google.android.exoplayer2.source.dash.a.i;
import com.google.android.exoplayer2.source.dash.h;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c implements g.b<a>, n, v.a<g<a>> {

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f32977f = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: a  reason: collision with root package name */
    final int f32978a;

    /* renamed from: b  reason: collision with root package name */
    final h f32979b;

    /* renamed from: c  reason: collision with root package name */
    final p.a f32980c;

    /* renamed from: d  reason: collision with root package name */
    n.a f32981d;

    /* renamed from: e  reason: collision with root package name */
    g<a>[] f32982e = new g[0];

    /* renamed from: g  reason: collision with root package name */
    private final a.C0547a f32983g;

    /* renamed from: h  reason: collision with root package name */
    private final ad f32984h;

    /* renamed from: i  reason: collision with root package name */
    private final w f32985i;
    private final long j;
    private final y k;
    private final b l;
    private final TrackGroupArray m;
    private final a[] n;
    private final com.google.android.exoplayer2.source.g o;
    private final IdentityHashMap<g<a>, h.c> p = new IdentityHashMap<>();
    private g[] q = new g[0];
    private v r;
    private com.google.android.exoplayer2.source.dash.a.b s;
    private int t;
    private List<e> u;
    private boolean v;

    public c(int i2, com.google.android.exoplayer2.source.dash.a.b bVar, int i3, a.C0547a aVar, ad adVar, w wVar, p.a aVar2, long j2, y yVar, b bVar2, com.google.android.exoplayer2.source.g gVar, h.b bVar3) {
        b bVar4 = bVar2;
        com.google.android.exoplayer2.source.g gVar2 = gVar;
        this.f32978a = i2;
        this.s = bVar;
        this.t = i3;
        this.f32983g = aVar;
        this.f32984h = adVar;
        this.f32985i = wVar;
        this.f32980c = aVar2;
        this.j = j2;
        this.k = yVar;
        this.l = bVar4;
        this.o = gVar2;
        this.f32979b = new h(bVar, bVar3, bVar4);
        this.r = gVar2.a(this.f32982e);
        f a2 = bVar.a(i3);
        this.u = a2.f32936d;
        List<com.google.android.exoplayer2.source.dash.a.a> list = a2.f32935c;
        List<e> list2 = this.u;
        int[][] a3 = a(list);
        int length = a3.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int a4 = a(length, list, a3, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[a4];
        a[] aVarArr = new a[a4];
        a(list2, trackGroupArr, aVarArr, a(list, a3, length, zArr, formatArr, trackGroupArr, aVarArr));
        Pair create = Pair.create(new TrackGroupArray(trackGroupArr), aVarArr);
        this.m = (TrackGroupArray) create.first;
        this.n = (a[]) create.second;
        aVar2.a();
    }

    public final void a(com.google.android.exoplayer2.source.dash.a.b bVar, int i2) {
        this.s = bVar;
        this.t = i2;
        h hVar = this.f32979b;
        hVar.f33027h = false;
        hVar.f33025f = -9223372036854775807L;
        hVar.f33024e = bVar;
        Iterator<Map.Entry<Long, Long>> it2 = hVar.f33023d.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() < hVar.f33024e.f32912h) {
                it2.remove();
            }
        }
        g<a>[] gVarArr = this.f32982e;
        if (gVarArr != null) {
            for (g<a> gVar : gVarArr) {
                ((a) gVar.f32841e).a(bVar, i2);
            }
            this.f32981d.a(this);
        }
        this.u = bVar.a(i2).f32936d;
        for (g gVar2 : this.q) {
            Iterator<e> it3 = this.u.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                e next = it3.next();
                if (next.a().equals(gVar2.f33012a.a())) {
                    boolean z = true;
                    int a2 = bVar.a() - 1;
                    if (!bVar.f32908d || i2 != a2) {
                        z = false;
                    }
                    gVar2.a(next, z);
                }
            }
        }
    }

    public final synchronized void a(g<a> gVar) {
        h.c remove = this.p.remove(gVar);
        if (remove != null) {
            remove.f33031a.a(false);
        }
    }

    public final void a(n.a aVar, long j2) {
        this.f32981d = aVar;
        aVar.a(this);
    }

    public final void i_() throws IOException {
        this.k.a();
    }

    public final TrackGroupArray b() {
        return this.m;
    }

    public final void a(long j2, boolean z) {
        for (g<a> a2 : this.f32982e) {
            a2.a(j2, z);
        }
    }

    public final void a(long j2) {
        this.r.a(j2);
    }

    public final boolean c(long j2) {
        return this.r.c(j2);
    }

    public final long e() {
        return this.r.e();
    }

    public final long c() {
        if (this.v) {
            return -9223372036854775807L;
        }
        this.f32980c.c();
        this.v = true;
        return -9223372036854775807L;
    }

    public final long d() {
        return this.r.d();
    }

    public final long b(long j2) {
        for (g<a> b2 : this.f32982e) {
            b2.b(j2);
        }
        for (g b3 : this.q) {
            b3.b(j2);
        }
        return j2;
    }

    public final long a(long j2, af afVar) {
        for (g<a> gVar : this.f32982e) {
            if (gVar.f32837a == 2) {
                return gVar.a(j2, afVar);
            }
        }
        return j2;
    }

    private int a(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.n[i3].f32990e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.n[i6].f32988c == 0) {
                return i5;
            }
        }
        return -1;
    }

    private static int[][] a(List<com.google.android.exoplayer2.source.dash.a.a> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).f32900a, i2);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (!zArr[i4]) {
                zArr[i4] = true;
                d b2 = b(list.get(i4).f32904e);
                if (b2 == null) {
                    iArr[i3] = new int[]{i4};
                    i3++;
                } else {
                    String[] a2 = ae.a(b2.f32926b, AppConstants.COMMA);
                    int[] iArr2 = new int[(a2.length + 1)];
                    iArr2[0] = i4;
                    int i5 = 1;
                    for (String parseInt : a2) {
                        int i6 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                        if (i6 != -1) {
                            zArr[i6] = true;
                            iArr2[i5] = i6;
                            i5++;
                        }
                    }
                    if (i5 < iArr2.length) {
                        iArr2 = Arrays.copyOf(iArr2, i5);
                    }
                    iArr[i3] = iArr2;
                    i3++;
                }
            }
        }
        return i3 < size ? (int[][]) Arrays.copyOf(iArr, i3) : iArr;
    }

    private static int a(int i2, List<com.google.android.exoplayer2.source.dash.a.a> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        boolean z;
        Format[] formatArr2;
        List<com.google.android.exoplayer2.source.dash.a.a> list2 = list;
        int i3 = 0;
        int i4 = i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int[] iArr2 = iArr[i5];
            int length = iArr2.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    z = false;
                    break;
                }
                List<i> list3 = list2.get(iArr2[i6]).f32902c;
                for (int i7 = 0; i7 < list3.size(); i7++) {
                    if (!list3.get(i7).f32950e.isEmpty()) {
                        z = true;
                        break;
                    }
                }
                i6++;
            }
            if (z) {
                zArr[i5] = true;
                i3++;
            }
            int[] iArr3 = iArr[i5];
            int length2 = iArr3.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length2) {
                    formatArr2 = new Format[0];
                    break;
                }
                int i9 = iArr3[i8];
                com.google.android.exoplayer2.source.dash.a.a aVar = list2.get(i9);
                List<d> list4 = list2.get(i9).f32903d;
                int i10 = 0;
                while (i10 < list4.size()) {
                    d dVar = list4.get(i10);
                    if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f32925a)) {
                        String str = dVar.f32926b;
                        if (str != null) {
                            String[] a2 = ae.a(str, ";");
                            Format[] formatArr3 = new Format[a2.length];
                            int i11 = 0;
                            while (true) {
                                if (i11 >= a2.length) {
                                    formatArr2 = formatArr3;
                                    break;
                                }
                                Matcher matcher = f32977f.matcher(a2[i11]);
                                if (!matcher.matches()) {
                                    formatArr2 = new Format[]{a(aVar.f32900a, (String) null, -1)};
                                    break;
                                }
                                formatArr3[i11] = a(aVar.f32900a, matcher.group(2), Integer.parseInt(matcher.group(1)));
                                i11++;
                            }
                        } else {
                            formatArr2 = new Format[]{a(aVar.f32900a, (String) null, -1)};
                        }
                    } else {
                        i10++;
                    }
                }
                i8++;
            }
            formatArr[i5] = formatArr2;
            if (formatArr[i5].length != 0) {
                i3++;
            }
        }
        return i3;
    }

    private static int a(List<com.google.android.exoplayer2.source.dash.a.a> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, a[] aVarArr) {
        int i3;
        int i4;
        int i5;
        List<com.google.android.exoplayer2.source.dash.a.a> list2 = list;
        char c2 = 0;
        int i6 = i2;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int[] iArr2 = iArr[i7];
            ArrayList arrayList = new ArrayList();
            for (int i9 : iArr2) {
                arrayList.addAll(list2.get(i9).f32902c);
            }
            Format[] formatArr2 = new Format[arrayList.size()];
            for (int i10 = 0; i10 < formatArr2.length; i10++) {
                formatArr2[i10] = ((i) arrayList.get(i10)).f32947b;
            }
            com.google.android.exoplayer2.source.dash.a.a aVar = list2.get(iArr2[c2]);
            int i11 = i8 + 1;
            if (zArr[i7]) {
                i3 = i11;
                i11++;
            } else {
                i3 = -1;
            }
            if (formatArr[i7].length != 0) {
                i5 = i11;
                i4 = i11 + 1;
            } else {
                i4 = i11;
                i5 = -1;
            }
            trackGroupArr[i8] = new TrackGroup(formatArr2);
            int i12 = i5;
            int i13 = i3;
            aVarArr[i8] = new a(aVar.f32901b, 0, iArr2, i8, i3, i5, -1);
            if (i13 != -1) {
                trackGroupArr[i13] = new TrackGroup(Format.a(aVar.f32900a + ":emsg", "application/x-emsg"));
                aVarArr[i13] = new a(4, 1, iArr2, i8, -1, -1, -1);
            }
            int i14 = i12;
            if (i14 != -1) {
                trackGroupArr[i14] = new TrackGroup(formatArr[i7]);
                aVarArr[i14] = new a(3, 1, iArr2, i8, -1, -1, -1);
            }
            i7++;
            i8 = i4;
            c2 = 0;
        }
        return i8;
    }

    private static void a(List<e> list, TrackGroup[] trackGroupArr, a[] aVarArr, int i2) {
        int i3 = i2;
        int i4 = 0;
        while (i4 < list.size()) {
            trackGroupArr[i3] = new TrackGroup(Format.a(list.get(i4).a(), "application/x-emsg"));
            aVarArr[i3] = new a(4, 2, new int[0], -1, -1, -1, i4);
            i4++;
            i3++;
        }
    }

    private g<a> a(a aVar, com.google.android.exoplayer2.trackselection.f fVar, long j2) {
        TrackGroup trackGroup;
        int i2;
        TrackGroup trackGroup2;
        int i3;
        h.c cVar;
        a aVar2 = aVar;
        boolean z = aVar2.f32991f != -1;
        if (z) {
            trackGroup = this.m.f32785c[aVar2.f32991f];
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        boolean z2 = aVar2.f32992g != -1;
        if (z2) {
            trackGroup2 = this.m.f32785c[aVar2.f32992g];
            i2 += trackGroup2.f32780a;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i2];
        int[] iArr = new int[i2];
        if (z) {
            formatArr[0] = trackGroup.f32781b[0];
            iArr[0] = 4;
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i4 = 0; i4 < trackGroup2.f32780a; i4++) {
                formatArr[i3] = trackGroup2.f32781b[i4];
                iArr[i3] = 3;
                arrayList.add(formatArr[i3]);
                i3++;
            }
        }
        if (!this.s.f32908d || !z) {
            cVar = null;
        } else {
            h hVar = this.f32979b;
            cVar = new h.c(new t(hVar.f33020a));
        }
        h.c cVar2 = cVar;
        g gVar = new g(aVar2.f32987b, iArr, formatArr, this.f32983g.a(this.k, this.s, this.t, aVar2.f32986a, fVar, aVar2.f32987b, this.j, z, arrayList, cVar, this.f32984h), this, this.l, j2, this.f32985i, this.f32980c);
        synchronized (this) {
            this.p.put(gVar, cVar2);
        }
        return gVar;
    }

    private static d b(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar.f32925a)) {
                return dVar;
            }
        }
        return null;
    }

    private static Format a(int i2, String str, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(":cea608");
        sb.append(i3 != -1 ? AppConstants.COLON.concat(String.valueOf(i3)) : "");
        return Format.a(sb.toString(), "application/cea-608", 0, str, i3, (DrmInitData) null, Long.MAX_VALUE, (List<byte[]>) null);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f32986a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32987b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32988c;

        /* renamed from: d  reason: collision with root package name */
        public final int f32989d;

        /* renamed from: e  reason: collision with root package name */
        public final int f32990e;

        /* renamed from: f  reason: collision with root package name */
        public final int f32991f;

        /* renamed from: g  reason: collision with root package name */
        public final int f32992g;

        a(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
            this.f32987b = i2;
            this.f32986a = iArr;
            this.f32988c = i3;
            this.f32990e = i4;
            this.f32991f = i5;
            this.f32992g = i6;
            this.f32989d = i7;
        }
    }

    public final long a(com.google.android.exoplayer2.trackselection.f[] fVarArr, boolean[] zArr, u[] uVarArr, boolean[] zArr2, long j2) {
        u uVar;
        boolean z;
        int[] iArr = new int[fVarArr.length];
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (fVarArr[i2] != null) {
                iArr[i2] = this.m.a(fVarArr[i2].e());
            } else {
                iArr[i2] = -1;
            }
        }
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (fVarArr[i3] == null || !zArr[i3]) {
                if (uVarArr[i3] instanceof g) {
                    uVarArr[i3].a(this);
                } else if (uVarArr[i3] instanceof g.a) {
                    uVarArr[i3].c();
                }
                uVarArr[i3] = null;
            }
        }
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if ((uVarArr[i4] instanceof com.google.android.exoplayer2.source.i) || (uVarArr[i4] instanceof g.a)) {
                int a2 = a(i4, iArr);
                if (a2 == -1) {
                    z = uVarArr[i4] instanceof com.google.android.exoplayer2.source.i;
                } else {
                    z = (uVarArr[i4] instanceof g.a) && uVarArr[i4].f32846a == uVarArr[a2];
                }
                if (!z) {
                    if (uVarArr[i4] instanceof g.a) {
                        uVarArr[i4].c();
                    }
                    uVarArr[i4] = null;
                }
            }
        }
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            com.google.android.exoplayer2.trackselection.f fVar = fVarArr[i5];
            if (fVar != null) {
                if (uVarArr[i5] == null) {
                    zArr2[i5] = true;
                    a aVar = this.n[iArr[i5]];
                    if (aVar.f32988c == 0) {
                        uVarArr[i5] = a(aVar, fVar, j2);
                    } else if (aVar.f32988c == 2) {
                        uVarArr[i5] = new g(this.u.get(aVar.f32989d), fVar.e().f32781b[0], this.s.f32908d);
                    }
                } else if (uVarArr[i5] instanceof g) {
                    ((a) uVarArr[i5].f32841e).a(fVar);
                }
            }
        }
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            if (uVarArr[i6] == null && fVarArr[i6] != null) {
                a aVar2 = this.n[iArr[i6]];
                if (aVar2.f32988c != 1) {
                    continue;
                } else {
                    int a3 = a(i6, iArr);
                    if (a3 == -1) {
                        uVar = new com.google.android.exoplayer2.source.i();
                    } else {
                        g gVar = uVarArr[a3];
                        int i7 = aVar2.f32987b;
                        int i8 = 0;
                        while (i8 < gVar.f32843g.length) {
                            if (gVar.f32838b[i8] == i7) {
                                com.google.android.exoplayer2.g.a.b(!gVar.f32840d[i8]);
                                gVar.f32840d[i8] = true;
                                gVar.f32843g[i8].b();
                                gVar.f32843g[i8].a(j2, true);
                                uVar = new g.a(gVar, gVar.f32843g[i8], i8);
                            } else {
                                i8++;
                            }
                        }
                        throw new IllegalStateException();
                    }
                    uVarArr[i6] = uVar;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (g gVar2 : uVarArr) {
            if (gVar2 instanceof g) {
                arrayList.add(gVar2);
            } else if (gVar2 instanceof g) {
                arrayList2.add((g) gVar2);
            }
        }
        this.f32982e = new g[arrayList.size()];
        arrayList.toArray(this.f32982e);
        this.q = new g[arrayList2.size()];
        arrayList2.toArray(this.q);
        this.r = this.o.a(this.f32982e);
        return j2;
    }

    public final /* bridge */ /* synthetic */ void a(v vVar) {
        this.f32981d.a(this);
    }
}

package com.google.android.exoplayer2.source.smoothstreaming.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class a implements com.google.android.exoplayer2.offline.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final int f33330a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33331b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33332c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33333d;

    /* renamed from: e  reason: collision with root package name */
    public final C0551a f33334e;

    /* renamed from: f  reason: collision with root package name */
    public final b[] f33335f;

    /* renamed from: g  reason: collision with root package name */
    public final long f33336g;

    /* renamed from: h  reason: collision with root package name */
    public final long f33337h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a.a$a  reason: collision with other inner class name */
    public static class C0551a {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f33338a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f33339b;

        /* renamed from: c  reason: collision with root package name */
        public final k[] f33340c;

        public C0551a(UUID uuid, byte[] bArr, k[] kVarArr) {
            this.f33338a = uuid;
            this.f33339b = bArr;
            this.f33340c = kVarArr;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f33341a;

        /* renamed from: b  reason: collision with root package name */
        public final String f33342b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33343c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33344d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33345e;

        /* renamed from: f  reason: collision with root package name */
        public final int f33346f;

        /* renamed from: g  reason: collision with root package name */
        public final int f33347g;

        /* renamed from: h  reason: collision with root package name */
        public final int f33348h;

        /* renamed from: i  reason: collision with root package name */
        public final String f33349i;
        public final Format[] j;
        public final int k;
        public final String l;
        public final String m;
        public final List<Long> n;
        public final long[] o;
        private final long p;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, formatArr, list, ae.a(list, j2), ae.b(j3, 1000000, j2));
            String str6 = str;
        }

        private b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j3) {
            this.l = str;
            this.m = str2;
            this.f33341a = i2;
            this.f33342b = str3;
            this.f33343c = j2;
            this.f33344d = str4;
            this.f33345e = i3;
            this.f33346f = i4;
            this.f33347g = i5;
            this.f33348h = i6;
            this.f33349i = str5;
            this.j = formatArr;
            this.n = list;
            this.o = jArr;
            this.p = j3;
            this.k = list.size();
        }

        public final b a(Format[] formatArr) {
            String str = this.l;
            return new b(str, this.m, this.f33341a, this.f33342b, this.f33343c, this.f33344d, this.f33345e, this.f33346f, this.f33347g, this.f33348h, this.f33349i, formatArr, this.n, this.o, this.p);
        }

        public final int a(long j2) {
            return ae.a(this.o, j2, true);
        }

        public final long a(int i2) {
            if (i2 == this.k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i2 + 1] - jArr[i2];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(int i2, int i3, long j, long j2, long j3, int i4, boolean z, C0551a aVar, b[] bVarArr) {
        this(i2, i3, j2 == 0 ? -9223372036854775807L : ae.b(j2, 1000000, j), j3 != 0 ? ae.b(j3, 1000000, j) : -9223372036854775807L, i4, z, aVar, bVarArr);
    }

    private a(int i2, int i3, long j, long j2, int i4, boolean z, C0551a aVar, b[] bVarArr) {
        this.f33330a = i2;
        this.f33331b = i3;
        this.f33336g = j;
        this.f33337h = j2;
        this.f33332c = i4;
        this.f33333d = z;
        this.f33334e = aVar;
        this.f33335f = bVarArr;
    }

    public final /* synthetic */ Object a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i2);
            b bVar2 = this.f33335f[streamKey.f32766b];
            if (!(bVar2 == bVar || bVar == null)) {
                arrayList2.add(bVar.a((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.j[streamKey.f32767c]);
            i2++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.a((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new a(this.f33330a, this.f33331b, this.f33336g, this.f33337h, this.f33332c, this.f33333d, this.f33334e, (b[]) arrayList2.toArray(new b[0]));
    }
}

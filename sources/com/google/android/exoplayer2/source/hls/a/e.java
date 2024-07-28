package com.google.android.exoplayer2.source.hls.a;

import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

public final class e extends f {

    /* renamed from: a  reason: collision with root package name */
    public final int f33113a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33114b;

    /* renamed from: c  reason: collision with root package name */
    public final long f33115c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33116d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33117e;

    /* renamed from: f  reason: collision with root package name */
    public final long f33118f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33119g;

    /* renamed from: h  reason: collision with root package name */
    public final long f33120h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f33121i;
    public final boolean j;
    public final DrmInitData k;
    public final List<a> l;
    public final long m;

    public final /* bridge */ /* synthetic */ Object a(List list) {
        return this;
    }

    public static final class a implements Comparable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final String f33122a;

        /* renamed from: b  reason: collision with root package name */
        public final a f33123b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33124c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33125d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33126e;

        /* renamed from: f  reason: collision with root package name */
        public final long f33127f;

        /* renamed from: g  reason: collision with root package name */
        public final DrmInitData f33128g;

        /* renamed from: h  reason: collision with root package name */
        public final String f33129h;

        /* renamed from: i  reason: collision with root package name */
        public final String f33130i;
        public final long j;
        public final long k;
        public final boolean l;

        public final /* synthetic */ int compareTo(Object obj) {
            Long l2 = (Long) obj;
            if (this.f33127f > l2.longValue()) {
                return 1;
            }
            return this.f33127f < l2.longValue() ? -1 : 0;
        }

        public a(String str, long j2, long j3, String str2, String str3) {
            this(str, (a) null, "", 0, -1, -9223372036854775807L, (DrmInitData) null, str2, str3, j2, j3, false);
        }

        public a(String str, a aVar, String str2, long j2, int i2, long j3, DrmInitData drmInitData, String str3, String str4, long j4, long j5, boolean z) {
            this.f33122a = str;
            this.f33123b = aVar;
            this.f33125d = str2;
            this.f33124c = j2;
            this.f33126e = i2;
            this.f33127f = j3;
            this.f33128g = drmInitData;
            this.f33129h = str3;
            this.f33130i = str4;
            this.j = j4;
            this.k = j5;
            this.l = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(int i2, String str, List<String> list, long j2, long j3, boolean z, int i3, long j4, int i4, long j5, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, List<a> list2) {
        super(str, list, z2);
        String str2 = str;
        List<String> list3 = list;
        this.f33113a = i2;
        this.f33115c = j3;
        this.f33116d = z;
        this.f33117e = i3;
        this.f33118f = j4;
        this.f33119g = i4;
        this.f33120h = j5;
        this.f33121i = z3;
        this.j = z4;
        this.k = drmInitData;
        this.l = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar = list2.get(list2.size() - 1);
            this.m = aVar.f33127f + aVar.f33124c;
        } else {
            this.m = 0;
        }
        this.f33114b = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.m + j2;
    }

    public final long a() {
        return this.f33115c + this.m;
    }
}

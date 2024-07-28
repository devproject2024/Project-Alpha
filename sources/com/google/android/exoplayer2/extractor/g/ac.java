package com.google.android.exoplayer2.extractor.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.Collections;
import java.util.List;

public interface ac {

    public interface c {
        SparseArray<ac> a();

        ac a(int i2, b bVar);
    }

    void a();

    void a(ab abVar, i iVar, d dVar);

    void a(r rVar, int i2) throws v;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f31918a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31919b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f31920c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f31921d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.f31918a = i2;
            this.f31919b = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f31920c = list2;
            this.f31921d = bArr;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f31915a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31916b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f31917c;

        public a(String str, int i2, byte[] bArr) {
            this.f31915a = str;
            this.f31916b = i2;
            this.f31917c = bArr;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f31922a;

        /* renamed from: b  reason: collision with root package name */
        private final int f31923b;

        /* renamed from: c  reason: collision with root package name */
        private final int f31924c;

        /* renamed from: d  reason: collision with root package name */
        private int f31925d;

        /* renamed from: e  reason: collision with root package name */
        private String f31926e;

        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        public d(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f31922a = str;
            this.f31923b = i3;
            this.f31924c = i4;
            this.f31925d = Integer.MIN_VALUE;
        }

        public final void a() {
            int i2 = this.f31925d;
            this.f31925d = i2 == Integer.MIN_VALUE ? this.f31923b : i2 + this.f31924c;
            this.f31926e = this.f31922a + this.f31925d;
        }

        public final int b() {
            d();
            return this.f31925d;
        }

        public final String c() {
            d();
            return this.f31926e;
        }

        private void d() {
            if (this.f31925d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}

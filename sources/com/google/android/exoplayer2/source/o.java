package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import java.io.IOException;

public interface o {

    public interface b {
        void onSourceInfoRefreshed(o oVar, ah ahVar, Object obj);
    }

    n a(a aVar, com.google.android.exoplayer2.f.b bVar, long j);

    void a(Handler handler, p pVar);

    void a(n nVar);

    void a(b bVar);

    void a(b bVar, ad adVar);

    void a(p pVar);

    void b() throws IOException;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f33224a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33225b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33226c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33227d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33228e;

        public a(Object obj) {
            this(obj, (byte) 0);
        }

        private a(Object obj, byte b2) {
            this(obj, -1, -1, -1, -1);
        }

        public a(Object obj, long j, int i2) {
            this(obj, -1, -1, j, i2);
        }

        public a(Object obj, int i2, int i3, long j) {
            this(obj, i2, i3, j, -1);
        }

        a(Object obj, int i2, int i3, long j, int i4) {
            this.f33224a = obj;
            this.f33225b = i2;
            this.f33226c = i3;
            this.f33227d = j;
            this.f33228e = i4;
        }

        public final boolean a() {
            return this.f33225b != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f33224a.equals(aVar.f33224a) && this.f33225b == aVar.f33225b && this.f33226c == aVar.f33226c && this.f33227d == aVar.f33227d && this.f33228e == aVar.f33228e;
            }
        }

        public final int hashCode() {
            return ((((((((this.f33224a.hashCode() + 527) * 31) + this.f33225b) * 31) + this.f33226c) * 31) + ((int) this.f33227d)) * 31) + this.f33228e;
        }
    }
}

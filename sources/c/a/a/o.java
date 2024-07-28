package c.a.a;

import i.c;
import i.d;
import i.h;
import i.n;
import i.u;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

final class o extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    protected RequestBody f5605a;

    /* renamed from: b  reason: collision with root package name */
    protected n f5606b;

    /* renamed from: c  reason: collision with root package name */
    protected a f5607c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f5608d;

    public o(RequestBody requestBody, n nVar) {
        this.f5605a = requestBody;
        this.f5606b = nVar;
    }

    public final MediaType contentType() {
        return this.f5605a.contentType();
    }

    public final long contentLength() {
        try {
            return this.f5605a.contentLength();
        } catch (IOException unused) {
            return -1;
        }
    }

    public final void writeTo(d dVar) throws IOException {
        this.f5608d = System.currentTimeMillis();
        this.f5607c = new a(dVar);
        d a2 = n.a((u) this.f5607c);
        this.f5605a.writeTo(a2);
        a2.flush();
    }

    protected final class a extends h {

        /* renamed from: a  reason: collision with root package name */
        long f5609a = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f5611c = 0;

        public a(u uVar) {
            super(uVar);
        }

        public final void write(c cVar, long j) throws IOException {
            super.write(cVar, j);
            if (this.f5609a == 0) {
                this.f5609a = o.this.contentLength();
            }
            this.f5611c += j;
            if (o.this.f5606b != null) {
                long currentTimeMillis = (System.currentTimeMillis() - o.this.f5608d) / 1000;
                if (currentTimeMillis == 0) {
                    currentTimeMillis++;
                }
                long j2 = this.f5611c;
                long j3 = j2 / currentTimeMillis;
                long j4 = this.f5609a;
                o.this.f5606b.a((int) ((100 * j2) / j4), j3, j2 == j4);
            }
        }
    }
}

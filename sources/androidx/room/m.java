package androidx.room;

import androidx.sqlite.db.d;
import androidx.sqlite.db.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class m implements d, e {

    /* renamed from: i  reason: collision with root package name */
    static final TreeMap<Integer, m> f4471i = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile String f4472a;

    /* renamed from: b  reason: collision with root package name */
    final long[] f4473b;

    /* renamed from: c  reason: collision with root package name */
    final double[] f4474c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f4475d;

    /* renamed from: e  reason: collision with root package name */
    final byte[][] f4476e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f4477f;

    /* renamed from: g  reason: collision with root package name */
    final int f4478g;

    /* renamed from: h  reason: collision with root package name */
    int f4479h;

    public final void close() {
    }

    public static m a(String str, int i2) {
        synchronized (f4471i) {
            Map.Entry<Integer, m> ceilingEntry = f4471i.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                f4471i.remove(ceilingEntry.getKey());
                m value = ceilingEntry.getValue();
                value.b(str, i2);
                return value;
            }
            m mVar = new m(i2);
            mVar.b(str, i2);
            return mVar;
        }
    }

    private m(int i2) {
        this.f4478g = i2;
        int i3 = i2 + 1;
        this.f4477f = new int[i3];
        this.f4473b = new long[i3];
        this.f4474c = new double[i3];
        this.f4475d = new String[i3];
        this.f4476e = new byte[i3][];
    }

    private void b(String str, int i2) {
        this.f4472a = str;
        this.f4479h = i2;
    }

    public final void a() {
        synchronized (f4471i) {
            f4471i.put(Integer.valueOf(this.f4478g), this);
            if (f4471i.size() > 15) {
                int size = f4471i.size() - 10;
                Iterator<Integer> it2 = f4471i.descendingKeySet().iterator();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it2.next();
                    it2.remove();
                    size = i2;
                }
            }
        }
    }

    public final String b() {
        return this.f4472a;
    }

    public final void a(d dVar) {
        for (int i2 = 1; i2 <= this.f4479h; i2++) {
            int i3 = this.f4477f[i2];
            if (i3 == 1) {
                dVar.a(i2);
            } else if (i3 == 2) {
                dVar.a(i2, this.f4473b[i2]);
            } else if (i3 == 3) {
                dVar.a(i2, this.f4474c[i2]);
            } else if (i3 == 4) {
                dVar.a(i2, this.f4475d[i2]);
            } else if (i3 == 5) {
                dVar.a(i2, this.f4476e[i2]);
            }
        }
    }

    public final void a(int i2) {
        this.f4477f[i2] = 1;
    }

    public final void a(int i2, long j) {
        this.f4477f[i2] = 2;
        this.f4473b[i2] = j;
    }

    public final void a(int i2, double d2) {
        this.f4477f[i2] = 3;
        this.f4474c[i2] = d2;
    }

    public final void a(int i2, String str) {
        this.f4477f[i2] = 4;
        this.f4475d[i2] = str;
    }

    public final void a(int i2, byte[] bArr) {
        this.f4477f[i2] = 5;
        this.f4476e[i2] = bArr;
    }
}

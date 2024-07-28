package com.google.android.exoplayer2.extractor.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g implements ac.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f31971a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f31972b;

    public g() {
        this(0);
    }

    public g(int i2) {
        this(i2, Collections.singletonList(Format.a("application/cea-608")));
    }

    public g(int i2, List<Format> list) {
        this.f31971a = i2;
        this.f31972b = list;
    }

    public final SparseArray<ac> a() {
        return new SparseArray<>();
    }

    public final ac a(int i2, ac.b bVar) {
        if (i2 == 2) {
            return new r(new k(new ae(b(bVar))));
        }
        if (i2 == 3 || i2 == 4) {
            return new r(new p(bVar.f31919b));
        }
        if (i2 != 15) {
            if (i2 != 17) {
                if (i2 == 21) {
                    return new r(new n());
                }
                if (i2 != 27) {
                    if (i2 == 36) {
                        return new r(new m(a(bVar)));
                    }
                    if (i2 == 89) {
                        return new r(new i(bVar.f31920c));
                    }
                    if (i2 != 138) {
                        if (i2 == 172) {
                            return new r(new d(bVar.f31919b));
                        }
                        if (i2 != 129) {
                            if (i2 != 130) {
                                if (i2 != 134) {
                                    if (i2 != 135) {
                                        return null;
                                    }
                                } else if (a(16)) {
                                    return null;
                                } else {
                                    return new w(new y());
                                }
                            } else if (!a(64)) {
                                return null;
                            }
                        }
                        return new r(new b(bVar.f31919b));
                    }
                    return new r(new h(bVar.f31919b));
                } else if (a(4)) {
                    return null;
                } else {
                    return new r(new l(a(bVar), a(1), a(8)));
                }
            } else if (a(2)) {
                return null;
            } else {
                return new r(new o(bVar.f31919b));
            }
        } else if (a(2)) {
            return null;
        } else {
            return new r(new f(false, bVar.f31919b));
        }
    }

    private x a(ac.b bVar) {
        return new x(b(bVar));
    }

    private List<Format> b(ac.b bVar) {
        int i2;
        String str;
        List list;
        if (a(32)) {
            return this.f31972b;
        }
        r rVar = new r(bVar.f31921d);
        List<Format> list2 = this.f31972b;
        while (rVar.b() > 0) {
            int c2 = rVar.c();
            int c3 = rVar.f32567b + rVar.c();
            if (c2 == 134) {
                list2 = new ArrayList<>();
                int c4 = rVar.c() & 31;
                for (int i3 = 0; i3 < c4; i3++) {
                    String e2 = rVar.e(3);
                    int c5 = rVar.c();
                    boolean z = (c5 & 128) != 0;
                    if (z) {
                        i2 = c5 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte c6 = (byte) rVar.c();
                    rVar.d(1);
                    if (z) {
                        list = Collections.singletonList(new byte[]{(byte) ((c6 & 64) != 0 ? 1 : 0)});
                    } else {
                        list = null;
                    }
                    list2.add(Format.a((String) null, str, 0, e2, i2, (DrmInitData) null, Long.MAX_VALUE, (List<byte[]>) list));
                }
            }
            rVar.c(c3);
        }
        return list2;
    }

    private boolean a(int i2) {
        return (i2 & this.f31971a) != 0;
    }
}

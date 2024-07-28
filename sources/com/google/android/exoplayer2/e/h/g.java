package com.google.android.exoplayer2.e.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.h.e;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.ArrayList;
import java.util.List;

public final class g extends c {

    /* renamed from: c  reason: collision with root package name */
    private final f f31633c = new f();

    /* renamed from: d  reason: collision with root package name */
    private final r f31634d = new r();

    /* renamed from: e  reason: collision with root package name */
    private final e.a f31635e = new e.a();

    /* renamed from: f  reason: collision with root package name */
    private final a f31636f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final List<d> f31637g = new ArrayList();

    public final /* bridge */ /* synthetic */ com.google.android.exoplayer2.e.e a(byte[] bArr, int i2, boolean z) throws com.google.android.exoplayer2.e.g {
        return a(bArr, i2);
    }

    public g() {
        super("WebvttDecoder");
    }

    private i a(byte[] bArr, int i2) throws com.google.android.exoplayer2.e.g {
        this.f31634d.a(bArr, i2);
        this.f31635e.a();
        this.f31637g.clear();
        try {
            h.a(this.f31634d);
            do {
            } while (!TextUtils.isEmpty(this.f31634d.r()));
            ArrayList arrayList = new ArrayList();
            while (true) {
                int a2 = a(this.f31634d);
                if (a2 == 0) {
                    return new i(arrayList);
                }
                if (a2 == 1) {
                    b(this.f31634d);
                } else if (a2 == 2) {
                    if (arrayList.isEmpty()) {
                        this.f31634d.r();
                        this.f31637g.addAll(this.f31636f.a(this.f31634d));
                    } else {
                        throw new com.google.android.exoplayer2.e.g("A style block was found after the first cue.");
                    }
                } else if (a2 == 3 && this.f31633c.a(this.f31634d, this.f31635e, this.f31637g)) {
                    arrayList.add(this.f31635e.b());
                    this.f31635e.a();
                }
            }
        } catch (v e2) {
            throw new com.google.android.exoplayer2.e.g((Exception) e2);
        }
    }

    private static void b(r rVar) {
        do {
        } while (!TextUtils.isEmpty(rVar.r()));
    }

    private static int a(r rVar) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = rVar.f32567b;
            String r = rVar.r();
            if (r == null) {
                i2 = 0;
            } else if ("STYLE".equals(r)) {
                i2 = 2;
            } else {
                i2 = r.startsWith("NOTE") ? 1 : 3;
            }
        }
        rVar.c(i3);
        return i2;
    }
}

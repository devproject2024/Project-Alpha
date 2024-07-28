package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final e f31813a = new e();

    /* renamed from: b  reason: collision with root package name */
    final r f31814b = new r(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    int f31815c = -1;

    /* renamed from: d  reason: collision with root package name */
    boolean f31816d;

    /* renamed from: e  reason: collision with root package name */
    private int f31817e;

    d() {
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        int i2;
        a.b(hVar != null);
        if (this.f31816d) {
            this.f31816d = false;
            this.f31814b.a();
        }
        while (!this.f31816d) {
            if (this.f31815c < 0) {
                if (!this.f31813a.a(hVar, true)) {
                    return false;
                }
                int i3 = this.f31813a.f31825h;
                if ((this.f31813a.f31819b & 1) == 1 && this.f31814b.f32568c == 0) {
                    i3 += a(0);
                    i2 = this.f31817e + 0;
                } else {
                    i2 = 0;
                }
                hVar.b(i3);
                this.f31815c = i2;
            }
            int a2 = a(this.f31815c);
            int i4 = this.f31815c + this.f31817e;
            if (a2 > 0) {
                if (this.f31814b.f32566a.length < this.f31814b.f32568c + a2) {
                    r rVar = this.f31814b;
                    rVar.f32566a = Arrays.copyOf(rVar.f32566a, this.f31814b.f32568c + a2);
                }
                hVar.b(this.f31814b.f32566a, this.f31814b.f32568c, a2);
                r rVar2 = this.f31814b;
                rVar2.b(rVar2.f32568c + a2);
                this.f31816d = this.f31813a.j[i4 + -1] != 255;
            }
            if (i4 == this.f31813a.f31824g) {
                i4 = -1;
            }
            this.f31815c = i4;
        }
        return true;
    }

    private int a(int i2) {
        int i3 = 0;
        this.f31817e = 0;
        while (this.f31817e + i2 < this.f31813a.f31824g) {
            int[] iArr = this.f31813a.j;
            int i4 = this.f31817e;
            this.f31817e = i4 + 1;
            int i5 = iArr[i4 + i2];
            i3 += i5;
            if (i5 != 255) {
                break;
            }
        }
        return i3;
    }
}

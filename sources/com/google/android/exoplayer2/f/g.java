package com.google.android.exoplayer2.f;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.net.URLDecoder;

public final class g extends e {

    /* renamed from: a  reason: collision with root package name */
    private l f32385a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f32386b;

    /* renamed from: c  reason: collision with root package name */
    private int f32387c;

    /* renamed from: d  reason: collision with root package name */
    private int f32388d;

    public g() {
        super(false);
    }

    public final long a(l lVar) throws IOException {
        d();
        this.f32385a = lVar;
        this.f32388d = (int) lVar.f32400f;
        Uri uri = lVar.f32395a;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String[] a2 = ae.a(uri.getSchemeSpecificPart(), AppConstants.COMMA);
            if (a2.length == 2) {
                String str = a2[1];
                if (a2[0].contains(";base64")) {
                    try {
                        this.f32386b = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e2) {
                        throw new v("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e2);
                    }
                } else {
                    this.f32386b = ae.c(URLDecoder.decode(str, "US-ASCII"));
                }
                this.f32387c = lVar.f32401g != -1 ? ((int) lVar.f32401g) + this.f32388d : this.f32386b.length;
                int i2 = this.f32387c;
                if (i2 > this.f32386b.length || this.f32388d > i2) {
                    this.f32386b = null;
                    throw new j(0);
                }
                b(lVar);
                return ((long) this.f32387c) - ((long) this.f32388d);
            }
            throw new v("Unexpected URI format: ".concat(String.valueOf(uri)));
        }
        throw new v("Unsupported scheme: ".concat(String.valueOf(scheme)));
    }

    public final int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f32387c - this.f32388d;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(ae.a(this.f32386b), this.f32388d, bArr, i2, min);
        this.f32388d += min;
        a(min);
        return min;
    }

    public final Uri a() {
        l lVar = this.f32385a;
        if (lVar != null) {
            return lVar.f32395a;
        }
        return null;
    }

    public final void c() {
        if (this.f32386b != null) {
            this.f32386b = null;
            e();
        }
        this.f32385a = null;
    }
}

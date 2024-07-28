package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.e.h;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31827a = ae.h("Opus");

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f31828d = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: e  reason: collision with root package name */
    private boolean f31829e;

    g() {
    }

    public static boolean a(r rVar) {
        int b2 = rVar.b();
        byte[] bArr = f31828d;
        if (b2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        rVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, f31828d);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.f31829e = false;
        }
    }

    /* access modifiers changed from: protected */
    public final long b(r rVar) {
        byte[] bArr = rVar.f32566a;
        byte b2 = bArr[0] & 255;
        byte b3 = b2 & 3;
        byte b4 = 2;
        if (b3 == 0) {
            b4 = 1;
        } else if (!(b3 == 1 || b3 == 2)) {
            b4 = bArr[1] & 63;
        }
        int i2 = b2 >> 3;
        int i3 = i2 & 3;
        return b(((long) b4) * ((long) (i2 >= 16 ? 2500 << i3 : i2 >= 12 ? AppConstants.START_OTP_FLOW << (i3 & 1) : i3 == 3 ? 60000 : AppConstants.START_OTP_FLOW << i3)));
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar, long j, h.a aVar) {
        boolean z = true;
        if (!this.f31829e) {
            byte[] copyOf = Arrays.copyOf(rVar.f32566a, rVar.f32568c);
            byte b2 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            a(arrayList, 3840);
            aVar.f31839a = Format.a((String) null, "audio/opus", -1, -1, (int) b2, 48000, (List<byte[]>) arrayList, (DrmInitData) null, (String) null);
            this.f31829e = true;
            return true;
        }
        if (rVar.i() != f31827a) {
            z = false;
        }
        rVar.c(0);
        return z;
    }

    private static void a(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i2) * 1000000000) / 48000).array());
    }
}

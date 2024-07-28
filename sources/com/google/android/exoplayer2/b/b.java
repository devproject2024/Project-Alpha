package com.google.android.exoplayer2.b;

import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.nio.ByteBuffer;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f31159a = {2002, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, SDKConstants.ERROR_CODE_480, 400, 400, EmiUtil.EMI_PLAN_REQUEST_CODE};

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f31160a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31161b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31162c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31163d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31164e;

        /* synthetic */ a(int i2, int i3, int i4, int i5, byte b2) {
            this(i2, i3, i4, i5);
        }

        private a(int i2, int i3, int i4, int i5) {
            this.f31160a = i2;
            this.f31162c = 2;
            this.f31161b = i3;
            this.f31163d = i4;
            this.f31164e = i5;
        }
    }

    public static Format a(r rVar, String str, String str2, DrmInitData drmInitData) {
        rVar.d(1);
        return Format.a(str, "audio/ac4", -1, -1, 2, ((rVar.c() & 32) >> 5) == 1 ? 48000 : 44100, (List<byte[]>) null, drmInitData, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0090, code lost:
        if (r10 != 11) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (r10 != 11) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        if (r10 != 8) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.b.b.a a(com.google.android.exoplayer2.g.q r10) {
        /*
            r0 = 16
            int r1 = r10.c(r0)
            int r0 = r10.c(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r10.c(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = 4
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r6 = r0
            r0 = 2
            int r1 = r10.c(r0)
            r3 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003c
            r5 = 0
        L_0x002c:
            int r7 = r10.c(r0)
            int r5 = r5 + r7
            boolean r7 = r10.e()
            if (r7 == 0) goto L_0x003b
            int r5 = r5 + 1
            int r5 = r5 << r0
            goto L_0x002c
        L_0x003b:
            int r1 = r1 + r5
        L_0x003c:
            r5 = 10
            int r5 = r10.c(r5)
            boolean r7 = r10.e()
            if (r7 == 0) goto L_0x0051
            int r7 = r10.c(r4)
            if (r7 <= 0) goto L_0x0051
            r10.b(r0)
        L_0x0051:
            boolean r7 = r10.e()
            r8 = 48000(0xbb80, float:6.7262E-41)
            r9 = 44100(0xac44, float:6.1797E-41)
            if (r7 == 0) goto L_0x0061
            r7 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0064
        L_0x0061:
            r7 = 44100(0xac44, float:6.1797E-41)
        L_0x0064:
            int r10 = r10.c(r2)
            if (r7 != r9) goto L_0x0073
            r9 = 13
            if (r10 != r9) goto L_0x0073
            int[] r0 = f31159a
            r10 = r0[r10]
            goto L_0x00a3
        L_0x0073:
            if (r7 != r8) goto L_0x00a2
            int[] r8 = f31159a
            int r9 = r8.length
            if (r10 >= r9) goto L_0x00a2
            r3 = r8[r10]
            int r5 = r5 % 5
            r8 = 8
            r9 = 1
            if (r5 == r9) goto L_0x0098
            r9 = 11
            if (r5 == r0) goto L_0x0093
            if (r5 == r4) goto L_0x0098
            if (r5 == r2) goto L_0x008c
            goto L_0x009d
        L_0x008c:
            if (r10 == r4) goto L_0x009f
            if (r10 == r8) goto L_0x009f
            if (r10 != r9) goto L_0x009d
            goto L_0x009f
        L_0x0093:
            if (r10 == r8) goto L_0x009f
            if (r10 != r9) goto L_0x009d
            goto L_0x009f
        L_0x0098:
            if (r10 == r4) goto L_0x009f
            if (r10 != r8) goto L_0x009d
            goto L_0x009f
        L_0x009d:
            r10 = r3
            goto L_0x00a3
        L_0x009f:
            int r3 = r3 + 1
            goto L_0x009d
        L_0x00a2:
            r10 = 0
        L_0x00a3:
            com.google.android.exoplayer2.b.b$a r0 = new com.google.android.exoplayer2.b.b$a
            r8 = 0
            r3 = r0
            r4 = r1
            r5 = r7
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.b.a(com.google.android.exoplayer2.g.q):com.google.android.exoplayer2.b.b$a");
    }

    public static int a(byte[] bArr, int i2) {
        int i3 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b2 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (b2 == 65535) {
            b2 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i3 = 4;
        }
        if (i2 == 44097) {
            i3 += 2;
        }
        return b2 + i3;
    }

    public static int a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return a(new q(bArr)).f31164e;
    }

    public static void a(int i2, r rVar) {
        rVar.a(7);
        rVar.f32566a[0] = -84;
        rVar.f32566a[1] = 64;
        rVar.f32566a[2] = -1;
        rVar.f32566a[3] = -1;
        rVar.f32566a[4] = (byte) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        rVar.f32566a[5] = (byte) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        rVar.f32566a[6] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
    }
}
